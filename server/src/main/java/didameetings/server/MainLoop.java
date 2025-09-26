package didameetings.server;

import java.util.concurrent.ConcurrentHashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import didameetings.DidaMeetingsMain;
import didameetings.DidaMeetingsPaxos;
import didameetings.DidaMeetingsPaxosServiceGrpc;

import didameetings.util.GenericResponseCollector;
import didameetings.util.CollectorStreamObserver;
import didameetings.util.PhaseOneBogusProcessor;
import didameetings.util.PhaseTwoResponseProcessor;

import didameetings.configs.ConfigurationScheduler;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MainLoop implements Runnable {
    DidaMeetingsServerState server_state;

    private boolean has_work;
    private int next_log_entry;
    private List<Integer> all_participants;
    private int n_participants;
    private String[] targets;
    private ManagedChannel[] channels;
    private DidaMeetingsPaxosServiceGrpc.DidaMeetingsPaxosServiceStub[] async_stubs;

    private boolean phaseOneDone = false;

    private boolean ballot_aborted;
    private int phase_one_readballot;
    private int phase_two_value;
    
    // MultiPaxos: estrutura para armazenar valores descobertos na Fase 1
    private final ConcurrentHashMap<Integer, Integer> discovered_instance_values;
    private final ConcurrentHashMap<Integer, Integer> discovered_instance_ballots;

    //Guarda os valores decididos: instance_number → command_id -> ou seja o que é decidido no final da phase 1
    private final ConcurrentHashMap<Integer, Integer> decided_instances;

    public MainLoop(DidaMeetingsServerState state) {
        this.server_state = state;
        this.has_work = false;
        this.next_log_entry = 0;
        this.discovered_instance_values = new ConcurrentHashMap<>();
        this.discovered_instance_ballots = new ConcurrentHashMap<>();
        this.decided_instances = new ConcurrentHashMap<>();
    }

    public void run() {
        while (true) {
            if (this.server_state.scheduler.leader(this.server_state.getCurrentBallot()) == this.server_state.my_id) {
                if (phaseOneDone == false) {
                    System.out.println("I am the leader for ballot " + this.server_state.getCurrentBallot());
                    this.doMultiPaxosPhaseOne();
                    phaseOneDone = true;
                }

                this.next_log_entry++;
                this.processEntry(this.next_log_entry);
            } else {
                try {
                    Thread.sleep(100); // evita busy loop
                } catch (InterruptedException e) {}
                phaseOneDone = false; // reset para quando voltar a ser líder
                // Limpar descobertas quando perde liderança
                discovered_instance_values.clear();
                discovered_instance_ballots.clear();
            }
        }
    }

    public synchronized void wakeup() {
        this.has_work = true;
        notify();
    }

    /**
     * MultiPaxos Fase 1 - Descobrir valores de todas as instâncias dos acceptors ----->ANTIGA
     */
    /*
    public synchronized void doMultiPaxosPhaseOne() {
        int ballot = this.server_state.getCurrentBallot();
        int completed_ballot = this.server_state.getCompletedBallot();


        List<Integer> acceptors = this.server_state.scheduler.acceptors(ballot);
        int quorum = this.server_state.scheduler.quorum(ballot);
        int n_acceptors = acceptors.size();
		System.out.println("1111\n");
        if ((ballot > -1) && (this.server_state.scheduler.leader(ballot) == this.server_state.my_id)) {
            System.out.println("MultiPaxos Phase 1: Discovering all instance values from acceptors");

            ballot_aborted = false;

            // Usar o PhaseOneBogusProcessor existente
            PhaseOneBogusProcessor phase_one_processor = 
                new PhaseOneBogusProcessor(this.server_state.scheduler, completed_ballot, ballot, quorum);

            ArrayList<DidaMeetingsPaxos.PhaseOneReply> phase_one_responses = new ArrayList<>();
            GenericResponseCollector<DidaMeetingsPaxos.PhaseOneReply> phase_one_collector = 
                new GenericResponseCollector<>(phase_one_responses, n_acceptors, phase_one_processor);

            // Enviar pedidos de descoberta para todos os acceptors
            for (int i = 0; i < n_acceptors; i++) {
                // Pedido sem instância específica = descoberta MultiPaxos
                DidaMeetingsPaxos.PhaseOneRequest.Builder phase_one_request_builder = 
                    DidaMeetingsPaxos.PhaseOneRequest.newBuilder();
                phase_one_request_builder.setRequestballot(ballot);
                // NÃO definir setInstance() - isso indica pedido de descoberta

                DidaMeetingsPaxos.PhaseOneRequest phase_one_request = phase_one_request_builder.build();
                System.out.println("Sending MultiPaxos discovery to acceptor " + acceptors.get(i) + 
                                 ": " + phase_one_request);

                CollectorStreamObserver<DidaMeetingsPaxos.PhaseOneReply> phase_one_observer = 
                    new CollectorStreamObserver<>(phase_one_collector);
                this.server_state.async_stubs[acceptors.get(i)].phaseone(phase_one_request, phase_one_observer);
            }

            // Aguardar respostas
            phase_one_collector.waitUntilDone();

            if (phase_one_processor.getAccepted() == false) {
                ballot_aborted = true;
                int maxballot = phase_one_processor.getMaxballot();
                if (maxballot > this.server_state.getCurrentBallot()) {
                    this.server_state.setCurrentBallot(maxballot);
                }
                System.out.println("MultiPaxos Phase 1 rejected. MaxBallot: " + maxballot);
            } else {
                // Armazenar valores descobertos usando o processor existente
                storeDiscoveredValues(phase_one_processor);
                System.out.println("MultiPaxos Phase 1 completed successfully. Discovered " + 
                                 discovered_instance_values.size() + " instances with values");
            }
        }
    }

    */






    /**
     * Descobrir o log length máximo entre os acceptors no quorum ----->NOVO
     */
    public synchronized void doMultiPaxosPhaseOne() {
        int ballot = this.server_state.getCurrentBallot();
        int completed_ballot = this.server_state.getCompletedBallot();

        List<Integer> acceptors = this.server_state.scheduler.acceptors(ballot);
        int quorum = this.server_state.scheduler.quorum(ballot);
        int n_acceptors = acceptors.size();

        if ((ballot > -1) && (this.server_state.scheduler.leader(ballot) == this.server_state.my_id)) {
            System.out.println("MultiPaxos Phase 1: Discovering all instance values from acceptors");

            // PASSO 1: Descobrir instância máxima
            int max_instance = discoverMaxInstance(acceptors, ballot, n_acceptors);
            if (ballot_aborted) {
                return; // Se descoberta falhou, sair
            }

            if (max_instance < 0) {
                System.out.println("No instances found - MultiPaxos Phase 1 complete");
                return;
            }
            
            System.out.println("Max instance discovered: " + max_instance);

            // PASSO 2: Fazer Phase 1 com contador para cada instância
            int instance_counter = 0; // CONTADOR PARA RASTREAR INSTÂNCIAS
            
            // PASSO 2: Fazer Phase 1 para cada instância de 0 até max_instance
            for (int instance = 0; instance <= max_instance; instance++) {
                System.out.println("Running Phase 1 for instance " + instance);
                
                ballot_aborted = false;
                
                // Usar o PhaseOneBogusProcessor existente
                PhaseOneBogusProcessor phase_one_processor = 
                    new PhaseOneBogusProcessor(this.server_state.scheduler, completed_ballot, ballot, quorum);

                ArrayList<DidaMeetingsPaxos.PhaseOneReply> phase_one_responses = new ArrayList<>();
                GenericResponseCollector<DidaMeetingsPaxos.PhaseOneReply> phase_one_collector = 
                    new GenericResponseCollector<>(phase_one_responses, n_acceptors, phase_one_processor);

                // Enviar pedidos para esta instância específica
                for (int i = 0; i < n_acceptors; i++) {
                    DidaMeetingsPaxos.PhaseOneRequest.Builder phase_one_request_builder = 
                        DidaMeetingsPaxos.PhaseOneRequest.newBuilder();
                    phase_one_request_builder.setRequestballot(ballot);
                    phase_one_request_builder.setInstance(instance); // DEFINIR A INSTÂNCIA ESPECÍFICA

                    DidaMeetingsPaxos.PhaseOneRequest phase_one_request = phase_one_request_builder.build();
                    System.out.println("Sending Phase 1 to acceptor " + acceptors.get(i) + 
                                    " for instance " + instance + ": " + phase_one_request);

                    CollectorStreamObserver<DidaMeetingsPaxos.PhaseOneReply> phase_one_observer = 
                        new CollectorStreamObserver<>(phase_one_collector);
                    this.server_state.async_stubs[acceptors.get(i)].phaseone(phase_one_request, phase_one_observer);
                }

                // Aguardar respostas para esta instância
                phase_one_collector.waitUntilDone();
                
                if (phase_one_processor.getAccepted() == false) {
                    ballot_aborted = true;
                    int maxballot = phase_one_processor.getMaxballot();
                    if (maxballot > this.server_state.getCurrentBallot()) {
                        this.server_state.setCurrentBallot(maxballot);
                    }
                    System.out.println("Phase 1 for instance " + instance + " rejected. MaxBallot: " + maxballot);
                    break; // Sair do loop se rejeitado
                } else {
                    // Armazenar valores descobertos para esta instância
                    //storeDiscoveredValuesForInstance(instance, phase_one_processor); //----->ANTIGA
                    storeDecidedValueForInstance(instance_counter, phase_one_processor);
                    instance_counter++; // Incrementar contador de instâncias
                    System.out.println("Phase 1 for instance " + instance + " completed successfully");
                }
            }

            System.out.println("MultiPaxos Phase 1 completed. Discovered " + 
                            discovered_instance_values.size() + " instances with values");
        }
    }



    /**
     * Verificar se instância já foi decidida ------>NOVO
     */
    private boolean isInstanceDecided(int instance) {
        return decided_instances.containsKey(instance);
    }

    /**
     * Obter comando decidido para instância (se existir) ------>NOVO
     */
    private Integer getDecidedCommand(int instance) {
        return decided_instances.get(instance);
    }


    /**
     * Armazenar valor decidido: instance_number → command_id ------>NOVO
     */
    private void storeDecidedValueForInstance(int instance_number, PhaseOneBogusProcessor processor) {
        if (processor.getValballot() > 0) { // Se há valor decidido
            int command_id = processor.getValue();
            
            // ARMAZENAR: instância → comando decidido
            decided_instances.put(instance_number, command_id);
            
            System.out.println("✓ Instance " + instance_number + " DECIDED with command " + command_id);
        } else {
            System.out.println("○ Instance " + instance_number + " not decided yet");
        }
    }

    /**
 * FUNÇÃO AUXILIAR: Descobrir instância máxima dos acceptors
 */
    private int discoverMaxInstance(List<Integer> acceptors, int ballot, int n_acceptors) {
        System.out.println("Discovering max instance from acceptors...");
        
        ArrayList<DidaMeetingsPaxos.PhaseOneReply> discovery_responses = new ArrayList<>();
        GenericResponseCollector<DidaMeetingsPaxos.PhaseOneReply> discovery_collector = 
            new GenericResponseCollector<>(discovery_responses, n_acceptors);

        // Enviar pedido especial com instance = -1 para descobrir máximo
        for (int i = 0; i < n_acceptors; i++) {
            DidaMeetingsPaxos.PhaseOneRequest.Builder discovery_request_builder = 
                DidaMeetingsPaxos.PhaseOneRequest.newBuilder();
            discovery_request_builder.setRequestballot(ballot);
            discovery_request_builder.setInstance(-1); // -1 = descobrir máximo

            CollectorStreamObserver<DidaMeetingsPaxos.PhaseOneReply> discovery_observer = 
                new CollectorStreamObserver<>(discovery_collector);
            this.server_state.async_stubs[acceptors.get(i)].phaseone(discovery_request_builder.build(), discovery_observer);
        }

        discovery_collector.waitUntilDone();

        // Encontrar a instância máxima
        int max_instance = -1;
        for (DidaMeetingsPaxos.PhaseOneReply response : discovery_responses) {
            if (!response.getAccepted()) {
                ballot_aborted = true;
                this.server_state.setCurrentBallot(Math.max(this.server_state.getCurrentBallot(), response.getMaxballot()));
                System.out.println("Discovery rejected by acceptor " + response.getServerid());
                return -1;
            }
            
            int acceptor_max = response.getValue(); // Instância máxima no campo value
            if (acceptor_max > max_instance) {
                max_instance = acceptor_max;
            }
            System.out.println("Acceptor " + response.getServerid() + " max instance: " + acceptor_max);
        }
        
        return Math.max(max_instance, 0); // Pelo menos instância 0
    }

    /**
     * FUNÇÃO AUXILIAR: Armazenar valores descobertos para uma instância específica ------>nao esta a ser usada
     */
    private void storeDiscoveredValuesForInstance(int instance, PhaseOneBogusProcessor processor) {
        if (processor.getValballot() > 0) {
            int value = processor.getValue();
            int ballot = processor.getValballot();
            
            discovered_instance_values.put(instance, value);
            discovered_instance_ballots.put(instance, ballot);
            
            System.out.println("Stored discovered value for instance " + instance + 
                            ": value=" + value + ", ballot=" + ballot);
        }
    }

    

    /**
     * Armazenar valores descobertos nas estruturas de dados
     */
    private void storeDiscoveredValues(PhaseOneBogusProcessor processor) {
        if (processor.getValballot() > 0) {
            // Por simplicidade, assumir que descobrimos valor para instância 0
            // (pode ser expandido para múltiplas instâncias conforme necessário)
            int instance = 0;
            int value = processor.getValue();
            int ballot = processor.getValballot();
            
            discovered_instance_values.put(instance, value);
            discovered_instance_ballots.put(instance, ballot);
            
            System.out.println("Stored discovered value: instance=" + instance + 
                             ", value=" + value + ", ballot=" + ballot);
        }
        
        System.out.println("Total discovered instances stored: " + discovered_instance_values.size());
    }

    /**
     * Obter valor para uma instância (descoberto na Fase 1 ou novo)
     */
    private int getValueForInstance(int instance, int default_value) {
        Integer discovered_value = discovered_instance_values.get(instance);
        if (discovered_value != null) {
            System.out.println("Using discovered value " + discovered_value + 
                             " for instance " + instance);
            return discovered_value;
        } else {
            System.out.println("Using new value " + default_value + 
                             " for instance " + instance);
            return default_value;
        }
    }

    public synchronized void processEntry(int entry_number) {
        PaxosInstance next_entry = this.server_state.paxos_log.testAndSetEntry(entry_number);

        while (next_entry.decided == false) {
            RequestRecord request_record = this.server_state.req_history.getFirstPending();
            int ballot = this.server_state.getCurrentBallot();
            int completed_ballot = this.server_state.getCompletedBallot();

            List<Integer> acceptors = this.server_state.scheduler.acceptors(ballot);
            int quorum = this.server_state.scheduler.quorum(ballot);
            int n_acceptors = acceptors.size();

            if ((ballot > -1) && (request_record != null) && 
                (this.server_state.scheduler.leader(ballot) == this.server_state.my_id)) {

                System.out.println("I am the leader for request with id " + request_record.getId());
                ballot_aborted = false;
                phase_one_readballot = -1;
                
                // MultiPaxos: usar valor descoberto se existir, senão usar ID do request
                phase_two_value = getValueForInstance(entry_number, request_record.getId());

                // Paxos Phase Two (SEM Fase 1 - já foi feita)
                System.out.println("Going to run paxos phase 2");

                // send phase2
                DidaMeetingsPaxos.PhaseTwoRequest.Builder phase_two_request = 
                    DidaMeetingsPaxos.PhaseTwoRequest.newBuilder();
                phase_two_request.setInstance(entry_number);
                phase_two_request.setRequestballot(ballot);
                phase_two_request.setValue(phase_two_value);

                PhaseTwoResponseProcessor phase_two_processor = new PhaseTwoResponseProcessor(quorum);

                System.out.println("Calling peers with phase_two_request = " + 
                                 phase_two_request.build());
                ArrayList<DidaMeetingsPaxos.PhaseTwoReply> phase_two_responses = new ArrayList<>();
                GenericResponseCollector<DidaMeetingsPaxos.PhaseTwoReply> phase_two_collector = 
                    new GenericResponseCollector<>(phase_two_responses, n_acceptors, phase_two_processor);
                
                for (int i = 0; i < n_acceptors; i++) {
                    CollectorStreamObserver<DidaMeetingsPaxos.PhaseTwoReply> phase_two_observer = 
                        new CollectorStreamObserver<>(phase_two_collector);
                    this.server_state.async_stubs[acceptors.get(i)].phasetwo(
                        phase_two_request.build(), phase_two_observer);
                }

                System.out.println("Waiting for responses...");
                phase_two_collector.waitUntilDone();
                if (phase_two_processor.getAccepted() == false) {
                    ballot_aborted = true;
                    this.server_state.setCurrentBallot(phase_two_processor.getMaxballot());
                }
                System.out.println("Paxos phase 2 ended with ballot_aborted = " + ballot_aborted);

                // After phase2
                if (ballot_aborted == false) {
                    this.server_state.setCompletedBallot(ballot);
                    next_entry.command_id = phase_two_value;
                    next_entry.decided = true;
                }
            }
            
            if (next_entry.decided == false) {
                System.out.println("Entry not decided: waiting");
                this.has_work = false;
                while (this.has_work == false) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        System.out.println("Log entry with number " + entry_number + 
                         " has been decided with command id = " + next_entry.command_id);
        RequestRecord request_record = this.server_state.req_history.getIfPending(next_entry.command_id);
        
        // if I receive the paxos decision before the request
        while (request_record == null) {
            System.out.println("Record not available!");
            try {
                wait();
            } catch (InterruptedException e) {
            }
            request_record = this.server_state.req_history.getIfPending(next_entry.command_id);
        }

        // exec request in entry
        DidaMeetingsCommand command = request_record.getRequest();
        boolean result = false;

        DidaMeetingsAction action = command.getAction();

        switch (action) {
            case OPEN:
                System.out.println("It is an open request with id = " + command.getMeetingId() + 
                                 " and max = " + this.server_state.max_participants);
                result = this.server_state.meeting_manager.open(command.getMeetingId(), 
                                                               this.server_state.max_participants);
                break;
            case ADD:
                result = this.server_state.meeting_manager.addAndClose(command.getMeetingId(), 
                                                                      command.getParticipantId());
                break;
            case TOPIC:
                result = this.server_state.meeting_manager.setTopic(command.getMeetingId(), 
                                                                   command.getParticipantId(), 
                                                                   command.getTopicId());
                break;
            case CLOSE:
                result = this.server_state.meeting_manager.close(command.getMeetingId());
                break;
            case DUMP:
                this.server_state.meeting_manager.dump();
                result = true;
                break;
            default:
                result = false;
                System.err.println("*** Unknown command ****");
                break;
        }

        // sending response
        System.out.println("Setting response for command with id = " + next_entry.command_id + 
                         " with result = " + result);
        request_record.setResponse(result);
        this.server_state.req_history.moveToProcessed(request_record.getId());
    }

    // Classes auxiliares - REMOVIDAS, usando ConcurrentHashMap diretamente
}
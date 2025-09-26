package didameetings.server;

import java.util.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import didameetings.core.*;
import didameetings.configs.*;
import didameetings.configs.ConfigurationScheduler;

import didameetings.DidaMeetingsMain;
import didameetings.DidaMeetingsPaxos;
import didameetings.DidaMeetingsPaxosServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class DidaMeetingsServerState {
    int                         max_participants;
    MeetingManager              meeting_manager;
    ConfigurationScheduler      scheduler;
    int                         base_port;
    int                         my_id;
    RequestHistory              req_history;
    PaxosLog                    paxos_log;

    List<Integer>               all_participants;
    int                         n_participants;
    String[]                    targets;
    ManagedChannel[]            channels;
    DidaMeetingsPaxosServiceGrpc.DidaMeetingsPaxosServiceStub[] async_stubs;

    private int                 current_ballot;
    private int                 completed_ballot;
    private int                 debug_mode;
 
    MainLoop                    main_loop;
    Thread                      main_loop_worker;

	private volatile boolean isFrozen = false;
	private volatile boolean isSlowMode = false;
	private int slowDelay = 0;
	private final ConcurrentHashMap<Integer, Integer> decided_instance_learners; //Para guradar id de requests de instancias ja decididas/finalizadas

	private final Object lock = new Object();

	
    
    public DidaMeetingsServerState(int port, int myself, char schedule, int max) {
	this.max_participants = max;
	this.meeting_manager  = new MeetingManager();
	this.scheduler        = new ConfigurationScheduler (schedule);
	this.base_port        = port;
	this.my_id            = myself;
	this.debug_mode       = 0;
	this.current_ballot   = 0;
	this.completed_ballot = -1;
	this.req_history      = new RequestHistory();
	this.paxos_log        = new PaxosLog();
	this.main_loop        = new MainLoop(this);
	this.decided_instance_learners = new ConcurrentHashMap<>();

	// init comms
	this.all_participants = this.scheduler.allparticipants ();
	this.n_participants = all_participants.size();
	
	this.targets = new String[this.n_participants];
	for (int i = 0; i < this.n_participants; i++) {
	    int target_port = this.base_port + all_participants.get(i);
	    this.targets[i] = new String();
	    this.targets[i] = "localhost:" + target_port;
	    System.out.printf("targets[%d] = %s%n", i, targets[i]);
	}
	
	this.channels = new ManagedChannel[this.n_participants];
	for (int i = 0; i < this.n_participants; i++) 
	    this.channels[i] = ManagedChannelBuilder.forTarget(this.targets[i]).usePlaintext().build();
	
	this.async_stubs = new DidaMeetingsPaxosServiceGrpc.DidaMeetingsPaxosServiceStub[this.n_participants];
	for (int i = 0; i < this.n_participants; i++) 
	    this.async_stubs[i] = DidaMeetingsPaxosServiceGrpc.newStub(this.channels[i]);	

	// start worker
	this.main_loop_worker = new Thread (main_loop);
	this.main_loop_worker.start();
    }

    public synchronized int getCurrentBallot () {
	return this.current_ballot;
    }
    
    public synchronized void setCurrentBallot (int ballot) {
	if (ballot > this.current_ballot)
	    this.current_ballot = ballot;
    }

    public synchronized int getCompletedBallot () {
	return this.completed_ballot;
    }

    public int findMaxDecidedBallot () {
	int ballot = -1;
	int length = this.paxos_log.length();

	for (int i=0; i< length; i++) {
	    PaxosInstance entry = this.paxos_log.getEntry(i);
	    if (entry == null)
		return ballot;
	    if (!entry.decided)
		return ballot;
	    else if (entry.accept_ballot > ballot)
		ballot = entry.accept_ballot;

	}
	return ballot;
    }
    
    public synchronized void updateCompletedBallot (int ballot) {
	// WARNING: THIS ONLY WORKS FOR CONFIGURATIONS WHERE THERE IS NO NEED FOR STATE-TRANSFER!!!!!
	// NEEDS TO BE UPDATE FOR THE PROJECT


	ballot = this.findMaxDecidedBallot ();
	if (ballot > this.completed_ballot)
	    this.completed_ballot = ballot;
	this.notifyAll();
    }

    
    public synchronized void setCompletedBallot (int ballot) {
	if (ballot > this.completed_ballot)
	    this.completed_ballot = ballot;
	this.notifyAll();
    }

    
    public synchronized int waitForCompletedBallot(int ballot) {
        while (this.completed_ballot < ballot) {
            try {
		wait ();
	    }
	    catch (InterruptedException e) {
	    }
	}
	return this.completed_ballot;
    }




	//Metodos para lidar com lista de requests decided 
	public synchronized void recordDecision(int instance, int command_id) {
		decided_instance_learners.put(instance, command_id);
		System.out.println("✓ DECISION RECORDED: Instance " + instance + " → Command " + command_id);
	}

	public synchronized boolean isCommandAlreadyDecided(int command_id) {
		return decided_instance_learners.containsValue(command_id);
	}

	public synchronized Integer getDecidedCommand(int instance) {
		return decided_instance_learners.get(instance);
	}

	// ★ NOVO: Procurar instância onde um request_id foi decidido ★
	public synchronized Integer findInstanceByRequestId(int request_id) {
		for (Map.Entry<Integer, Integer> entry : decided_instance_learners.entrySet()) {
			if (entry.getValue() == request_id) {
				return entry.getKey(); // Retorna a instância onde foi decidido
			}
		}
		return null; // Request não foi encontrado
	}

	//Verificar se um request_id específico já foi decidido e em que instância ★
	public synchronized String getRequestDecisionInfo(int request_id) {
		Integer instance = findInstanceByRequestId(request_id);
		if (instance != null) {
			return "Request " + request_id + " was decided in instance " + instance;
		} else {
			return "Request " + request_id + " not decided yet";
		}
	}






    public synchronized int getDebugMode () {
	return this.debug_mode;
    }

    public synchronized void setDebugMode (int mode) {
	this.debug_mode = mode;
    }

	public void setFrozen(boolean state) {
		isFrozen = state;

		if (!state) {
			synchronized (lock) {
				lock.notifyAll(); //acorda as threads
			}
		}
	}

	public void waitIfFrozen() {
		synchronized (lock) {
			while (isFrozen) {  // espera até o freeze acabar
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setSlowMode(boolean state, int delay) {
		synchronized (lock) {
			isSlowMode = state;
			slowDelay = delay;
			if (!state) {
				lock.notifyAll(); // acorda threads se slow mode acabar
			}
		}
		System.out.println("Slow mode set to " + state + " with delay " + delay);
	}
	

	public void waitIfSlowMode() {
		synchronized (lock) {
			if (isSlowMode) {
				try {
					// espera slowDelay ms, mas pode ser interrompido com notify()
					lock.wait(slowDelay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isSlowMode = false;
			}
		}
	}

}

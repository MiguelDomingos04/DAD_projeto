package didameetings.server;

import java.util.Hashtable;


public class PaxosLog {
    private Hashtable<Integer, PaxosInstance>  log;
    private int max_instance; // NOVO: manter registo da maior instância
     
    public PaxosLog() {
	this.log = new Hashtable<Integer, PaxosInstance>();
    this.max_instance = -1; // NOVO: inicializar com -1 (nenhuma instância)
    }

    public synchronized int length() {
        return this.log.size();
    }
    
    public synchronized PaxosInstance getEntry(int position) {
        return this.log.get(position);
    }

    // NOVO: método para obter a maior instância
    public synchronized int getMaxInstance() {
        return this.max_instance;
    }
   
   
    public synchronized PaxosInstance testAndSetEntry(int position) {
	PaxosInstance entry = this.log.get(position);

	if (entry == null){
	    entry = new PaxosInstance(position);
	    this.log.put (position, entry);
	}

    // NOVO: SEMPRE atualizar a instância máxima (mesmo se entry já existia)
    if (position > this.max_instance) {
        this.max_instance = position;
    }

	return entry;
    }

    
    public synchronized PaxosInstance testAndSetEntry(int position, int ballot) {
	PaxosInstance entry = this.log.get(position);

	if (entry == null){
	    entry = new PaxosInstance(position, ballot);
	    this.log.put (position, entry);
	}

    // NOVO: SEMPRE atualizar a instância máxima (mesmo se entry já existia)
    if (position > this.max_instance) {
        this.max_instance = position;
    }

	return entry;
    }
}

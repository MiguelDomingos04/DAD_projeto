package didameetings.util;

import java.util.ArrayList;
import java.util.Hashtable;

import didameetings.DidaMeetingsPaxos;
import didameetings.DidaMeetingsPaxosServiceGrpc;

import didameetings.configs.ConfigurationScheduler;

public class PhaseOneBogusProcessor extends GenericResponseProcessor<DidaMeetingsPaxos.PhaseOneReply>  {
    private ConfigurationScheduler   scheduler;
    private boolean                  accepted;
    private int                      value;
    private int                      valballot;
    private int                      maxballot;
    private int                      low_ballot;
    private int                      high_ballot;
    private int                     quorum;
   
    
    public PhaseOneBogusProcessor (ConfigurationScheduler s, int l, int h, int quorum) {
	// System.out.println("Phase 1 processor constructor with low_ballot =" + l + " high_ballot = " + h);
	this.accepted    = true;
	this.value       = -1;
	this.valballot   = -1;
	this.maxballot   = -1;
	this.low_ballot  = l;
	this.high_ballot = h;
	this.scheduler   = s;
    this.quorum = quorum;
    }

    public boolean getAccepted() {
	return this.accepted;
    }
    
    public int getValue() {
	return this.value;
    }
    
    public int getValballot() {
	return this.valballot;
    }
    
    public int getMaxballot() {
	return this.maxballot;
    }
    

    public synchronized boolean onNext(ArrayList<DidaMeetingsPaxos.PhaseOneReply> all_responses, DidaMeetingsPaxos.PhaseOneReply last_response){
    
    // Update state based on the last received response
    if (last_response.getMaxballot() > this.maxballot) {
        this.maxballot = last_response.getMaxballot();
    }

    if (last_response.getValballot() > this.valballot) {
        this.valballot = last_response.getValballot();
        this.value = last_response.getValue();
    }

    // Check if the latest response was a rejection
    if (last_response.getAccepted() == false) {
        this.accepted = false;
        // If a rejection is received, the phase fails. Return true to stop.
        return true;
    }

    // Count promises
    int promises = 0;
    for (DidaMeetingsPaxos.PhaseOneReply response : all_responses) {
        if (response.getAccepted()) {
            promises++;
        }
    }

    // Check if a quorum of promises has been reached
    if (promises >= this.quorum) {
        this.accepted = true;
        // A quorum has been met, so the phase can proceed. Return true to stop.
        return true;
    }

    // If no quorum is met yet, continue waiting for more responses
    return false;
}
}
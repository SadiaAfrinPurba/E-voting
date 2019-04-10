/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author afrin
 */
public class Election {
    private int electionID;
    private String electionName;
    private String electionStart;
    private String electionEnd;

    public int getElectionID() {
        return electionID;
    }

    public void setElectionID(int electionID) {
        this.electionID = electionID;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getElectionStart() {
        return electionStart;
    }

    public void setElectionStart(String electionStart) {
        this.electionStart = electionStart;
    }

    public String getElectionEnd() {
        return electionEnd;
    }

    public void setElectionEnd(String electionEnd) {
        this.electionEnd = electionEnd;
    }

    @Override
    public String toString() {
        return "Election{" + "electionID=" + electionID + '}';
    }
    
           
}

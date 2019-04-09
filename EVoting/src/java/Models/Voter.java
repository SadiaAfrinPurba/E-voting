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
public class Voter {
    private int voterId;
    private int voterNID;
    private String voterName;
    private String voterSecurityQues;
    private String voterSecurityAns;
    
    public Voter(){
        
    }
    public Voter(int voterNID){
        this.voterNID = voterNID;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getVoterNID() {
        return voterNID;
    }

    public void setVoterNID(int voterNID) {
        this.voterNID = voterNID;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterSecurityQues() {
        return voterSecurityQues;
    }

    public void setVoterSecurityQues(String voterSecurityQues) {
        this.voterSecurityQues = voterSecurityQues;
    }

    public String getVoterSecurityAns() {
        return voterSecurityAns;
    }

    public void setVoterSecurityAns(String voterSecurityAns) {
        this.voterSecurityAns = voterSecurityAns;
    }
    
    
}

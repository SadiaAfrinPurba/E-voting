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
public class Candidate {
    private int candidateID;
    private String candidateName;
    private String candidateEducation;
    private String candidateHometown;
    private String candidateExp;
    private String candidateAgenda;
    private String electioName;
    private String base64Image;

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateEducation() {
        return candidateEducation;
    }

    public void setCandidateEducation(String candidateEducation) {
        this.candidateEducation = candidateEducation;
    }

    public String getCandidateHometown() {
        return candidateHometown;
    }

    public void setCandidateHometown(String candidateHometown) {
        this.candidateHometown = candidateHometown;
    }

    public String getCandidateExp() {
        return candidateExp;
    }

    public void setCandidateExp(String candidateExp) {
        this.candidateExp = candidateExp;
    }

    public String getCandidateAgenda() {
        return candidateAgenda;
    }

    public void setCandidateAgenda(String candidateAgenda) {
        this.candidateAgenda = candidateAgenda;
    }

    public String getElectioName() {
        return electioName;
    }

    public void setElectioName(String electioName) {
        this.electioName = electioName;
    }

    @Override
    public String toString() {
        return "Candidate{" + "candidateID=" + candidateID + '}';
    }
    
      
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afrin
 */
@Entity
@Table(name = "Candidate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
    , @NamedQuery(name = "Candidate.findByCandidateId", query = "SELECT c FROM Candidate c WHERE c.candidateId = :candidateId")
    , @NamedQuery(name = "Candidate.findByCandidateName", query = "SELECT c FROM Candidate c WHERE c.candidateName = :candidateName")
    , @NamedQuery(name = "Candidate.findByCandidateEducation", query = "SELECT c FROM Candidate c WHERE c.candidateEducation = :candidateEducation")
    , @NamedQuery(name = "Candidate.findByCandidateHometown", query = "SELECT c FROM Candidate c WHERE c.candidateHometown = :candidateHometown")
    , @NamedQuery(name = "Candidate.findByCandidateExperience", query = "SELECT c FROM Candidate c WHERE c.candidateExperience = :candidateExperience")
    , @NamedQuery(name = "Candidate.findByCandidateAgenda", query = "SELECT c FROM Candidate c WHERE c.candidateAgenda = :candidateAgenda")
    , @NamedQuery(name = "Candidate.findByCandidateElectionName", query = "SELECT c FROM Candidate c WHERE c.candidateElectionName = :candidateElectionName")})
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "candidate_id")
    private Short candidateId;
    @Column(name = "candidate_name")
    private String candidateName;
    @Column(name = "candidate_education")
    private String candidateEducation;
    @Basic(optional = false)
    @Lob
    @Column(name = "candidate_picture")
    private byte[] candidatePicture;
    @Column(name = "candidate_hometown")
    private String candidateHometown;
    @Column(name = "candidate_experience")
    private String candidateExperience;
    @Column(name = "candidate_agenda")
    private String candidateAgenda;
    @Column(name = "candidate_election_name")
    private String candidateElectionName;

    public Candidate() {
    }

    public Candidate(Short candidateId) {
        this.candidateId = candidateId;
    }

    public Candidate(Short candidateId, byte[] candidatePicture) {
        this.candidateId = candidateId;
        this.candidatePicture = candidatePicture;
    }

    public Short getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Short candidateId) {
        this.candidateId = candidateId;
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

    public byte[] getCandidatePicture() {
        return candidatePicture;
    }

    public void setCandidatePicture(byte[] candidatePicture) {
        this.candidatePicture = candidatePicture;
    }

    public String getCandidateHometown() {
        return candidateHometown;
    }

    public void setCandidateHometown(String candidateHometown) {
        this.candidateHometown = candidateHometown;
    }

    public String getCandidateExperience() {
        return candidateExperience;
    }

    public void setCandidateExperience(String candidateExperience) {
        this.candidateExperience = candidateExperience;
    }

    public String getCandidateAgenda() {
        return candidateAgenda;
    }

    public void setCandidateAgenda(String candidateAgenda) {
        this.candidateAgenda = candidateAgenda;
    }

    public String getCandidateElectionName() {
        return candidateElectionName;
    }

    public void setCandidateElectionName(String candidateElectionName) {
        this.candidateElectionName = candidateElectionName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidateId != null ? candidateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.candidateId == null && other.candidateId != null) || (this.candidateId != null && !this.candidateId.equals(other.candidateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Candidate[ candidateId=" + candidateId + " ]";
    }
    
}

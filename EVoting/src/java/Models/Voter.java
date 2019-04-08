/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afrin
 */
@Entity
@Table(name = "Voter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voter.findAll", query = "SELECT v FROM Voter v")
    , @NamedQuery(name = "Voter.findByVoterId", query = "SELECT v FROM Voter v WHERE v.voterPK.voterId = :voterId")
    , @NamedQuery(name = "Voter.findByVoterNid", query = "SELECT v FROM Voter v WHERE v.voterPK.voterNid = :voterNid")
    , @NamedQuery(name = "Voter.findByVoterName", query = "SELECT v FROM Voter v WHERE v.voterPK.voterName = :voterName")
    , @NamedQuery(name = "Voter.findByVotersQuestion", query = "SELECT v FROM Voter v WHERE v.votersQuestion = :votersQuestion")
    , @NamedQuery(name = "Voter.findByVotersAnswer", query = "SELECT v FROM Voter v WHERE v.votersAnswer = :votersAnswer")})
public class Voter implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VoterPK voterPK;
    @Column(name = "voter_sQuestion")
    private String votersQuestion;
    @Column(name = "voter_sAnswer")
    private String votersAnswer;

    public Voter() {
    }

    public Voter(VoterPK voterPK) {
        this.voterPK = voterPK;
    }

    public Voter(short voterId, int voterNid, String voterName) {
        this.voterPK = new VoterPK(voterId, voterNid, voterName);
    }

    public VoterPK getVoterPK() {
        return voterPK;
    }

    public void setVoterPK(VoterPK voterPK) {
        this.voterPK = voterPK;
    }

    public String getVotersQuestion() {
        return votersQuestion;
    }

    public void setVotersQuestion(String votersQuestion) {
        this.votersQuestion = votersQuestion;
    }

    public String getVotersAnswer() {
        return votersAnswer;
    }

    public void setVotersAnswer(String votersAnswer) {
        this.votersAnswer = votersAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voterPK != null ? voterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voter)) {
            return false;
        }
        Voter other = (Voter) object;
        if ((this.voterPK == null && other.voterPK != null) || (this.voterPK != null && !this.voterPK.equals(other.voterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Voter[ voterPK=" + voterPK + " ]";
    }
    
}

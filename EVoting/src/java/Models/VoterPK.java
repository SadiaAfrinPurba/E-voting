/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author afrin
 */
@Embeddable
public class VoterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "voter_id")
    private short voterId;
    @Basic(optional = false)
    @Column(name = "voter_nid")
    private int voterNid;
    @Basic(optional = false)
    @Column(name = "voter_name")
    private String voterName;

    public VoterPK() {
    }

    public VoterPK(short voterId, int voterNid, String voterName) {
        this.voterId = voterId;
        this.voterNid = voterNid;
        this.voterName = voterName;
    }

    public short getVoterId() {
        return voterId;
    }

    public void setVoterId(short voterId) {
        this.voterId = voterId;
    }

    public int getVoterNid() {
        return voterNid;
    }

    public void setVoterNid(int voterNid) {
        this.voterNid = voterNid;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) voterId;
        hash += (int) voterNid;
        hash += (voterName != null ? voterName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoterPK)) {
            return false;
        }
        VoterPK other = (VoterPK) object;
        if (this.voterId != other.voterId) {
            return false;
        }
        if (this.voterNid != other.voterNid) {
            return false;
        }
        if ((this.voterName == null && other.voterName != null) || (this.voterName != null && !this.voterName.equals(other.voterName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.VoterPK[ voterId=" + voterId + ", voterNid=" + voterNid + ", voterName=" + voterName + " ]";
    }
    
}

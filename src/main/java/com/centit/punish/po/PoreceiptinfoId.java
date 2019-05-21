package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PoreceiptinfoId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long poreceiptstate;

    private String punishobjectid;

    // Constructors
    /** default constructor */
    public PoreceiptinfoId() {
    }

    /** full constructor */
    public PoreceiptinfoId(Long poreceiptstate, String punishobjectid) {

        this.poreceiptstate = poreceiptstate;
        this.punishobjectid = punishobjectid;
    }

    public Long getPoreceiptstate() {
        return this.poreceiptstate;
    }

    public void setPoreceiptstate(Long poreceiptstate) {
        this.poreceiptstate = poreceiptstate;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PoreceiptinfoId))
            return false;

        PoreceiptinfoId castOther = (PoreceiptinfoId) other;
        boolean ret = true;

        ret = ret
                && (this.getPoreceiptstate() == castOther.getPoreceiptstate() || (this
                        .getPoreceiptstate() != null
                        && castOther.getPoreceiptstate() != null && this
                        .getPoreceiptstate().equals(
                                castOther.getPoreceiptstate())));

        ret = ret
                && (this.getPunishobjectid() == castOther.getPunishobjectid() || (this
                        .getPunishobjectid() != null
                        && castOther.getPunishobjectid() != null && this
                        .getPunishobjectid().equals(
                                castOther.getPunishobjectid())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (this.getPoreceiptstate() == null ? 0 : this
                        .getPoreceiptstate().hashCode());

        result = 37
                * result
                + (this.getPunishobjectid() == null ? 0 : this
                        .getPunishobjectid().hashCode());

        return result;
    }
}

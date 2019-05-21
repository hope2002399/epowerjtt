package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PoindividualId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String individualid;

    // Constructors
    /** default constructor */
    public PoindividualId() {
    }

    /** full constructor */
    public PoindividualId(String punishobjectid, String individualid) {

        this.punishobjectid = punishobjectid;
        this.individualid = individualid;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public String getIndividualid() {
        return this.individualid;
    }

    public void setIndividualid(String individualid) {
        this.individualid = individualid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PoindividualId))
            return false;

        PoindividualId castOther = (PoindividualId) other;
        boolean ret = true;

        ret = ret
                && (this.getPunishobjectid() == castOther.getPunishobjectid() || (this
                        .getPunishobjectid() != null
                        && castOther.getPunishobjectid() != null && this
                        .getPunishobjectid().equals(
                                castOther.getPunishobjectid())));

        ret = ret
                && (this.getIndividualid() == castOther.getIndividualid() || (this
                        .getIndividualid() != null
                        && castOther.getIndividualid() != null && this
                        .getIndividualid().equals(castOther.getIndividualid())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (this.getPunishobjectid() == null ? 0 : this
                        .getPunishobjectid().hashCode());

        result = 37
                * result
                + (this.getIndividualid() == null ? 0 : this.getIndividualid()
                        .hashCode());

        return result;
    }
}

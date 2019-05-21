package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PoundertakebasicId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String usercode;

    // Constructors
    /** default constructor */
    public PoundertakebasicId() {
    }

    /** full constructor */
    public PoundertakebasicId(String punishobjectid, String usercode) {

        this.punishobjectid = punishobjectid;
        this.usercode = usercode;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public String getUsercode() {
        return this.usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PoundertakebasicId))
            return false;

        PoundertakebasicId castOther = (PoundertakebasicId) other;
        boolean ret = true;

        ret = ret
                && (this.getPunishobjectid() == castOther.getPunishobjectid() || (this
                        .getPunishobjectid() != null
                        && castOther.getPunishobjectid() != null && this
                        .getPunishobjectid().equals(
                                castOther.getPunishobjectid())));

        ret = ret
                && (this.getUsercode() == castOther.getUsercode() || (this
                        .getUsercode() != null
                        && castOther.getUsercode() != null && this
                        .getUsercode().equals(castOther.getUsercode())));

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
                + (this.getUsercode() == null ? 0 : this.getUsercode()
                        .hashCode());

        return result;
    }
}

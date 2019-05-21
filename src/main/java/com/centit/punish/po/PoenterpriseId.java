package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PoenterpriseId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String enterpriseid;

    // Constructors
    /** default constructor */
    public PoenterpriseId() {
    }

    /** full constructor */
    public PoenterpriseId(String punishobjectid, String enterpriseid) {

        this.punishobjectid = punishobjectid;
        this.enterpriseid = enterpriseid;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public String getEnterpriseid() {
        return this.enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PoenterpriseId))
            return false;

        PoenterpriseId castOther = (PoenterpriseId) other;
        boolean ret = true;

        ret = ret
                && (this.getPunishobjectid() == castOther.getPunishobjectid() || (this
                        .getPunishobjectid() != null
                        && castOther.getPunishobjectid() != null && this
                        .getPunishobjectid().equals(
                                castOther.getPunishobjectid())));

        ret = ret
                && (this.getEnterpriseid() == castOther.getEnterpriseid() || (this
                        .getEnterpriseid() != null
                        && castOther.getEnterpriseid() != null && this
                        .getEnterpriseid().equals(castOther.getEnterpriseid())));

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
                + (this.getEnterpriseid() == null ? 0 : this.getEnterpriseid()
                        .hashCode());

        return result;
    }
}

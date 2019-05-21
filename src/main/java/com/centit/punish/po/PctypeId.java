package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PctypeId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishclassid;

    private String punishtypeid;

    // Constructors
    /** default constructor */
    public PctypeId() {
    }

    /** full constructor */
    public PctypeId(String punishclassid, String punishtypeid) {

        this.punishclassid = punishclassid;
        this.punishtypeid = punishtypeid;
    }

    public String getPunishclassid() {
        return this.punishclassid;
    }

    public void setPunishclassid(String punishclassid) {
        this.punishclassid = punishclassid;
    }

    public String getPunishtypeid() {
        return this.punishtypeid;
    }

    public void setPunishtypeid(String punishtypeid) {
        this.punishtypeid = punishtypeid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PctypeId))
            return false;

        PctypeId castOther = (PctypeId) other;
        boolean ret = true;

        ret = ret
                && (this.getPunishclassid() == castOther.getPunishclassid() || (this
                        .getPunishclassid() != null
                        && castOther.getPunishclassid() != null && this
                        .getPunishclassid()
                        .equals(castOther.getPunishclassid())));

        ret = ret
                && (this.getPunishtypeid() == castOther.getPunishtypeid() || (this
                        .getPunishtypeid() != null
                        && castOther.getPunishtypeid() != null && this
                        .getPunishtypeid().equals(castOther.getPunishtypeid())));

        return ret;
    }

    public int hashCode() {
        int result = 17;

        result = 37
                * result
                + (this.getPunishclassid() == null ? 0 : this
                        .getPunishclassid().hashCode());

        result = 37
                * result
                + (this.getPunishtypeid() == null ? 0 : this.getPunishtypeid()
                        .hashCode());

        return result;
    }
}

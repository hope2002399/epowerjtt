package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PopunishbasicId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String punishtypeid;

    private String item_id;

    // Constructors
    /** default constructor */
    public PopunishbasicId() {
    }

    /** full constructor */
    public PopunishbasicId(String punishobjectid, String punishtypeid,
            String item_id) {

        this.punishobjectid = punishobjectid;
        this.punishtypeid = punishtypeid;
        this.item_id = item_id;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public String getPunishtypeid() {
        return this.punishtypeid;
    }

    public void setPunishtypeid(String punishtypeid) {
        this.punishtypeid = punishtypeid;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PopunishbasicId))
            return false;

        PopunishbasicId castOther = (PopunishbasicId) other;
        boolean ret = true;

        ret = ret
                && (this.getPunishobjectid() == castOther.getPunishobjectid() || (this
                        .getPunishobjectid() != null
                        && castOther.getPunishobjectid() != null && this
                        .getPunishobjectid().equals(
                                castOther.getPunishobjectid())));

        ret = ret
                && (this.getPunishtypeid() == castOther.getPunishtypeid() || (this
                        .getPunishtypeid() != null
                        && castOther.getPunishtypeid() != null && this
                        .getPunishtypeid().equals(castOther.getPunishtypeid())));

        ret = ret
                && (this.getItem_id() == castOther.getItem_id() || (this
                        .getItem_id() != null && castOther.getItem_id() != null && this
                        .getItem_id().equals(castOther.getItem_id())));

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
                + (this.getPunishtypeid() == null ? 0 : this.getPunishtypeid()
                        .hashCode());

        result = 37
                * result
                + (this.getItem_id() == null ? 0 : this.getItem_id().hashCode());

        return result;
    }
}

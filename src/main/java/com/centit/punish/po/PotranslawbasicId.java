package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PotranslawbasicId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String item_id;

    private String punishobjectid;

    // Constructors
    /** default constructor */
    public PotranslawbasicId() {
    }

    /** full constructor */
    public PotranslawbasicId(String item_id, String punishobjectid) {

        this.item_id = item_id;
        this.punishobjectid = punishobjectid;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
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
        if (!(other instanceof PotranslawbasicId))
            return false;

        PotranslawbasicId castOther = (PotranslawbasicId) other;
        boolean ret = true;

        ret = ret
                && (this.getItem_id() == castOther.getItem_id() || (this
                        .getItem_id() != null && castOther.getItem_id() != null && this
                        .getItem_id().equals(castOther.getItem_id())));

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
                + (this.getItem_id() == null ? 0 : this.getItem_id().hashCode());

        result = 37
                * result
                + (this.getPunishobjectid() == null ? 0 : this
                        .getPunishobjectid().hashCode());

        return result;
    }
}

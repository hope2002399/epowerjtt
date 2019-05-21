package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PodiscussbasicId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private Long podiscusstype;

    // Constructors
    /** default constructor */
    public PodiscussbasicId() {
    }

    /** full constructor */
    public PodiscussbasicId(String punishobjectid, Long podiscusstype) {

        this.punishobjectid = punishobjectid;
        this.podiscusstype = podiscusstype;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public Long getPodiscusstype() {
        return this.podiscusstype;
    }

    public void setPodiscusstype(Long podiscusstype) {
        this.podiscusstype = podiscusstype;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof PodiscussbasicId))
            return false;

        PodiscussbasicId castOther = (PodiscussbasicId) other;
        boolean ret = true;

        ret = ret
                && (this.getPunishobjectid() == castOther.getPunishobjectid() || (this
                        .getPunishobjectid() != null
                        && castOther.getPunishobjectid() != null && this
                        .getPunishobjectid().equals(
                                castOther.getPunishobjectid())));

        ret = ret
                && (this.getPodiscusstype() == castOther.getPodiscusstype() || (this
                        .getPodiscusstype() != null
                        && castOther.getPodiscusstype() != null && this
                        .getPodiscusstype()
                        .equals(castOther.getPodiscusstype())));

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
                + (this.getPodiscusstype() == null ? 0 : this
                        .getPodiscusstype().hashCode());

        return result;
    }
}

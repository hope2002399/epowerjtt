package com.centit.punish.po;

/**
 * FAddressBook entity.
 * 
 * @author codefan@hotmail.com
 */

public class PoapprovepersonId implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long operatorid;

    private String stepworkid;

    private Long tachestepid;

    private String punishobjectid;

    // Constructors
    /** default constructor */
    public PoapprovepersonId() {
    }

    /** full constructor */
    public PoapprovepersonId(Long operatorid, String stepworkid,
            Long tachestepid, String punishobjectid) {

        this.operatorid = operatorid;
        this.stepworkid = stepworkid;
        this.tachestepid = tachestepid;
        this.punishobjectid = punishobjectid;
    }

    public Long getOperatorid() {
        return this.operatorid;
    }

    public void setOperatorid(Long operatorid) {
        this.operatorid = operatorid;
    }

    public String getStepworkid() {
        return this.stepworkid;
    }

    public void setStepworkid(String stepworkid) {
        this.stepworkid = stepworkid;
    }

    public Long getTachestepid() {
        return this.tachestepid;
    }

    public void setTachestepid(Long tachestepid) {
        this.tachestepid = tachestepid;
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
        if (!(other instanceof PoapprovepersonId))
            return false;

        PoapprovepersonId castOther = (PoapprovepersonId) other;
        boolean ret = true;

        ret = ret
                && (this.getOperatorid() == castOther.getOperatorid() || (this
                        .getOperatorid() != null
                        && castOther.getOperatorid() != null && this
                        .getOperatorid().equals(castOther.getOperatorid())));

        ret = ret
                && (this.getStepworkid() == castOther.getStepworkid() || (this
                        .getStepworkid() != null
                        && castOther.getStepworkid() != null && this
                        .getStepworkid().equals(castOther.getStepworkid())));

        ret = ret
                && (this.getTachestepid() == castOther.getTachestepid() || (this
                        .getTachestepid() != null
                        && castOther.getTachestepid() != null && this
                        .getTachestepid().equals(castOther.getTachestepid())));

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
                + (this.getOperatorid() == null ? 0 : this.getOperatorid()
                        .hashCode());

        result = 37
                * result
                + (this.getStepworkid() == null ? 0 : this.getStepworkid()
                        .hashCode());

        result = 37
                * result
                + (this.getTachestepid() == null ? 0 : this.getTachestepid()
                        .hashCode());

        result = 37
                * result
                + (this.getPunishobjectid() == null ? 0 : this
                        .getPunishobjectid().hashCode());

        return result;
    }
}

package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poapproveperson implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PoapprovepersonId cid;

    private Long depid;
    private String isappoint;

    // Constructors
    /** default constructor */
    public Poapproveperson() {
    }

    /** minimal constructor */
    public Poapproveperson(PoapprovepersonId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public Poapproveperson(PoapprovepersonId id

    , Long depid, String isappoint) {
        this.cid = id;

        this.depid = depid;
        this.isappoint = isappoint;
    }

    public PoapprovepersonId getCid() {
        return this.cid;
    }

    public void setCid(PoapprovepersonId id) {
        this.cid = id;
    }

    public Long getOperatorid() {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        return this.cid.getOperatorid();
    }

    public void setOperatorid(Long operatorid) {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        this.cid.setOperatorid(operatorid);
    }

    public String getStepworkid() {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        return this.cid.getStepworkid();
    }

    public void setStepworkid(String stepworkid) {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        this.cid.setStepworkid(stepworkid);
    }

    public Long getTachestepid() {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        return this.cid.getTachestepid();
    }

    public void setTachestepid(Long tachestepid) {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        this.cid.setTachestepid(tachestepid);
    }

    public String getPunishobjectid() {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        return this.cid.getPunishobjectid();
    }

    public void setPunishobjectid(String punishobjectid) {
        if (this.cid == null)
            this.cid = new PoapprovepersonId();
        this.cid.setPunishobjectid(punishobjectid);
    }

    // Property accessors

    public Long getDepid() {
        return this.depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getIsappoint() {
        return this.isappoint;
    }

    public void setIsappoint(String isappoint) {
        this.isappoint = isappoint;
    }

    public void copy(Poapproveperson other) {

        this.setOperatorid(other.getOperatorid());
        this.setStepworkid(other.getStepworkid());
        this.setTachestepid(other.getTachestepid());
        this.setPunishobjectid(other.getPunishobjectid());

        this.depid = other.getDepid();
        this.isappoint = other.getIsappoint();

    }

    public void copyNotNullProperty(Poapproveperson other) {

        if (other.getOperatorid() != null)
            this.setOperatorid(other.getOperatorid());
        if (other.getStepworkid() != null)
            this.setStepworkid(other.getStepworkid());
        if (other.getTachestepid() != null)
            this.setTachestepid(other.getTachestepid());
        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getDepid() != null)
            this.depid = other.getDepid();
        if (other.getIsappoint() != null)
            this.isappoint = other.getIsappoint();

    }

    public void clearProperties() {

        this.depid = null;
        this.isappoint = null;

    }
}

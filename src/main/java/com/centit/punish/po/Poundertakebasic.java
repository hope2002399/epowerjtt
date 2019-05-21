package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poundertakebasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PoundertakebasicId cid;

    private Long depid;
    private Long sectionid;

    // Constructors
    /** default constructor */
    public Poundertakebasic() {
    }

    /** minimal constructor */
    public Poundertakebasic(PoundertakebasicId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public Poundertakebasic(PoundertakebasicId id

    , Long depid, Long sectionid) {
        this.cid = id;

        this.depid = depid;
        this.sectionid = sectionid;
    }

    public PoundertakebasicId getCid() {
        return this.cid;
    }

    public void setCid(PoundertakebasicId id) {
        this.cid = id;
    }

    public String getPunishobjectid() {
        if (this.cid == null)
            this.cid = new PoundertakebasicId();
        return this.cid.getPunishobjectid();
    }

    public void setPunishobjectid(String punishobjectid) {
        if (this.cid == null)
            this.cid = new PoundertakebasicId();
        this.cid.setPunishobjectid(punishobjectid);
    }

    public String getUsercode() {
        if (this.cid == null)
            this.cid = new PoundertakebasicId();
        return this.cid.getUsercode();
    }

    public void setUsercode(String usercode) {
        if (this.cid == null)
            this.cid = new PoundertakebasicId();
        this.cid.setUsercode(usercode);
    }

    // Property accessors

    public Long getDepid() {
        return this.depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public Long getSectionid() {
        return this.sectionid;
    }

    public void setSectionid(Long sectionid) {
        this.sectionid = sectionid;
    }

    public void copy(Poundertakebasic other) {

        this.setPunishobjectid(other.getPunishobjectid());
        this.setUsercode(other.getUsercode());

        this.depid = other.getDepid();
        this.sectionid = other.getSectionid();

    }

    public void copyNotNullProperty(Poundertakebasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());
        if (other.getUsercode() != null)
            this.setUsercode(other.getUsercode());

        if (other.getDepid() != null)
            this.depid = other.getDepid();
        if (other.getSectionid() != null)
            this.sectionid = other.getSectionid();

    }

    public void clearProperties() {

        this.depid = null;
        this.sectionid = null;

    }
}

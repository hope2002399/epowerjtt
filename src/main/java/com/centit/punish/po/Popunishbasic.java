package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Popunishbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PopunishbasicId cid;

    private String punishvalue;

    // Constructors
    /** default constructor */
    public Popunishbasic() {
    }

    /** minimal constructor */
    public Popunishbasic(PopunishbasicId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public Popunishbasic(PopunishbasicId id

    , String punishvalue) {
        this.cid = id;

        this.punishvalue = punishvalue;
    }

    public PopunishbasicId getCid() {
        return this.cid;
    }

    public void setCid(PopunishbasicId id) {
        this.cid = id;
    }

    public String getPunishobjectid() {
        if (this.cid == null)
            this.cid = new PopunishbasicId();
        return this.cid.getPunishobjectid();
    }

    public void setPunishobjectid(String punishobjectid) {
        if (this.cid == null)
            this.cid = new PopunishbasicId();
        this.cid.setPunishobjectid(punishobjectid);
    }

    public String getPunishtypeid() {
        if (this.cid == null)
            this.cid = new PopunishbasicId();
        return this.cid.getPunishtypeid();
    }

    public void setPunishtypeid(String punishtypeid) {
        if (this.cid == null)
            this.cid = new PopunishbasicId();
        this.cid.setPunishtypeid(punishtypeid);
    }

    public String getItem_id() {
        if (this.cid == null)
            this.cid = new PopunishbasicId();
        return this.cid.getItem_id();
    }

    public void setItem_id(String item_id) {
        if (this.cid == null)
            this.cid = new PopunishbasicId();
        this.cid.setItem_id(item_id);
    }

    // Property accessors

    public String getPunishvalue() {
        return this.punishvalue;
    }

    public void setPunishvalue(String punishvalue) {
        this.punishvalue = punishvalue;
    }

    public void copy(Popunishbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());
        this.setPunishtypeid(other.getPunishtypeid());
        this.setItem_id(other.getItem_id());

        this.punishvalue = other.getPunishvalue();

    }

    public void copyNotNullProperty(Popunishbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());
        if (other.getPunishtypeid() != null)
            this.setPunishtypeid(other.getPunishtypeid());
        if (other.getItem_id() != null)
            this.setItem_id(other.getItem_id());

        if (other.getPunishvalue() != null)
            this.punishvalue = other.getPunishvalue();

    }

    public void clearProperties() {

        this.punishvalue = null;

    }
}

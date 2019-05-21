package com.centit.punish.po;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poprintdef implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PoprintdefId cid;

    private String ioprintcode;

    // Constructors
    /** default constructor */
    public Poprintdef() {
    }

    /** full constructor */
    public Poprintdef(PoprintdefId id

    , String ioprintcode) {
        this.cid = id;

        this.ioprintcode = ioprintcode;
    }

    public PoprintdefId getCid() {
        return this.cid;
    }

    public void setCid(PoprintdefId id) {
        this.cid = id;
    }

    public Long getDepid() {
        if (this.cid == null)
            this.cid = new PoprintdefId();
        return this.cid.getDepid();
    }

    public void setDepid(Long depid) {
        if (this.cid == null)
            this.cid = new PoprintdefId();
        this.cid.setDepid(depid);
    }

    public String getPrinttype() {
        if (this.cid == null)
            this.cid = new PoprintdefId();
        return this.cid.getPrinttype();
    }

    public void setPrinttype(String printtype) {
        if (this.cid == null)
            this.cid = new PoprintdefId();
        this.cid.setPrinttype(printtype);
    }

    // Property accessors

    public String getIoprintcode() {
        return this.ioprintcode;
    }

    public void setIoprintcode(String ioprintcode) {
        this.ioprintcode = ioprintcode;
    }

    public void copy(Poprintdef other) {

        this.setDepid(other.getDepid());
        this.setPrinttype(other.getPrinttype());

        this.ioprintcode = other.getIoprintcode();

    }

    public void copyNotNullProperty(Poprintdef other) {

        if (other.getDepid() != null)
            this.setDepid(other.getDepid());
        if (other.getPrinttype() != null)
            this.setPrinttype(other.getPrinttype());

        if (other.getIoprintcode() != null)
            this.ioprintcode = other.getIoprintcode();

    }

    public void clearProperties() {

        this.ioprintcode = null;

    }
}

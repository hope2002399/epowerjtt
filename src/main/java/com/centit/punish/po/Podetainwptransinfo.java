package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Podetainwptransinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PodetainwptransinfoId cid;

    private String transperson;
    private String receiveperson;
    private Date receivedate;
    private String translocation;
    private String remark;
    private Long opttype;
    private String optperson;

    // Constructors
    /** default constructor */
    public Podetainwptransinfo() {
    }

    /** minimal constructor */
    public Podetainwptransinfo(PodetainwptransinfoId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public Podetainwptransinfo(PodetainwptransinfoId id

    , String transperson, String receiveperson, Date receivedate,
            String translocation, String remark, Long opttype, String optperson) {
        this.cid = id;

        this.transperson = transperson;
        this.receiveperson = receiveperson;
        this.receivedate = receivedate;
        this.translocation = translocation;
        this.remark = remark;
        this.opttype = opttype;
        this.optperson = optperson;
    }

    public PodetainwptransinfoId getCid() {
        return this.cid;
    }

    public void setCid(PodetainwptransinfoId id) {
        this.cid = id;
    }

    public String getWpid() {
        if (this.cid == null)
            this.cid = new PodetainwptransinfoId();
        return this.cid.getWpid();
    }

    public void setWpid(String wpid) {
        if (this.cid == null)
            this.cid = new PodetainwptransinfoId();
        this.cid.setWpid(wpid);
    }

    public Date getOptdate() {
        if (this.cid == null)
            this.cid = new PodetainwptransinfoId();
        return this.cid.getOptdate();
    }

    public void setOptdate(Date optdate) {
        if (this.cid == null)
            this.cid = new PodetainwptransinfoId();
        this.cid.setOptdate(optdate);
    }

    // Property accessors

    public String getTransperson() {
        return this.transperson;
    }

    public void setTransperson(String transperson) {
        this.transperson = transperson;
    }

    public String getReceiveperson() {
        return this.receiveperson;
    }

    public void setReceiveperson(String receiveperson) {
        this.receiveperson = receiveperson;
    }

    public Date getReceivedate() {
        return this.receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public String getTranslocation() {
        return this.translocation;
    }

    public void setTranslocation(String translocation) {
        this.translocation = translocation;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOpttype() {
        return this.opttype;
    }

    public void setOpttype(Long opttype) {
        this.opttype = opttype;
    }

    public String getOptperson() {
        return this.optperson;
    }

    public void setOptperson(String optperson) {
        this.optperson = optperson;
    }

    public void copy(Podetainwptransinfo other) {

        this.setWpid(other.getWpid());
        this.setOptdate(other.getOptdate());

        this.transperson = other.getTransperson();
        this.receiveperson = other.getReceiveperson();
        this.receivedate = other.getReceivedate();
        this.translocation = other.getTranslocation();
        this.remark = other.getRemark();
        this.opttype = other.getOpttype();
        this.optperson = other.getOptperson();

    }

    public void copyNotNullProperty(Podetainwptransinfo other) {

        if (other.getWpid() != null)
            this.setWpid(other.getWpid());
        if (other.getOptdate() != null)
            this.setOptdate(other.getOptdate());

        if (other.getTransperson() != null)
            this.transperson = other.getTransperson();
        if (other.getReceiveperson() != null)
            this.receiveperson = other.getReceiveperson();
        if (other.getReceivedate() != null)
            this.receivedate = other.getReceivedate();
        if (other.getTranslocation() != null)
            this.translocation = other.getTranslocation();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        if (other.getOpttype() != null)
            this.opttype = other.getOpttype();
        if (other.getOptperson() != null)
            this.optperson = other.getOptperson();

    }

    public void clearProperties() {

        this.transperson = null;
        this.receiveperson = null;
        this.receivedate = null;
        this.translocation = null;
        this.remark = null;
        this.opttype = null;
        this.optperson = null;

    }
}

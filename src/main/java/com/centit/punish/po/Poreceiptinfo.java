package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poreceiptinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PoreceiptinfoId cid;

    private String operatorname;
    private String signinedname;
    private Date signineddate;
    private String poreceiptname;
    private byte[] poreceiptdoc;
    private String receiptmodel;
    private String enregisterid;
    private Date enregisterdate;

    // Constructors
    /** default constructor */
    public Poreceiptinfo() {
    }

    /** minimal constructor */
    public Poreceiptinfo(PoreceiptinfoId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public Poreceiptinfo(PoreceiptinfoId id, String operatorname,
            String signinedname, Date signineddate, String poreceiptname,
            byte[] poreceiptdoc, String receiptmodel, String enregisterid,
            Date enregisterdate) {
        this.cid = id;
        this.operatorname = operatorname;
        this.signinedname = signinedname;
        this.signineddate = signineddate;
        this.poreceiptname = poreceiptname;
        this.poreceiptdoc = poreceiptdoc;
        this.receiptmodel = receiptmodel;
        this.enregisterid = enregisterid;
        this.enregisterdate = enregisterdate;
    }

    public PoreceiptinfoId getCid() {
        return this.cid;
    }

    public void setCid(PoreceiptinfoId id) {
        this.cid = id;
    }

    public Long getPoreceiptstate() {
        if (this.cid == null)
            this.cid = new PoreceiptinfoId();
        return this.cid.getPoreceiptstate();
    }

    public void setPoreceiptstate(Long poreceiptstate) {
        if (this.cid == null)
            this.cid = new PoreceiptinfoId();
        this.cid.setPoreceiptstate(poreceiptstate);
    }

    public String getPunishobjectid() {
        if (this.cid == null)
            this.cid = new PoreceiptinfoId();
        return this.cid.getPunishobjectid();
    }

    public void setPunishobjectid(String punishobjectid) {
        if (this.cid == null)
            this.cid = new PoreceiptinfoId();
        this.cid.setPunishobjectid(punishobjectid);
    }

    // Property accessors

    public String getOperatorname() {
        return this.operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname;
    }

    public String getSigninedname() {
        return this.signinedname;
    }

    public void setSigninedname(String signinedname) {
        this.signinedname = signinedname;
    }

    public Date getSignineddate() {
        return this.signineddate;
    }

    public void setSignineddate(Date signineddate) {
        this.signineddate = signineddate;
    }

    public String getPoreceiptname() {
        return this.poreceiptname;
    }

    public void setPoreceiptname(String poreceiptname) {
        this.poreceiptname = poreceiptname;
    }

    public byte[] getPoreceiptdoc() {
        return this.poreceiptdoc;
    }

    public void setPoreceiptdoc(byte[] poreceiptdoc) {
        this.poreceiptdoc = poreceiptdoc;
    }

    public String getReceiptmodel() {
        return this.receiptmodel;
    }

    public void setReceiptmodel(String receiptmodel) {
        this.receiptmodel = receiptmodel;
    }

    public String getEnregisterid() {
        return enregisterid;
    }

    public void setEnregisterid(String enregisterid) {
        this.enregisterid = enregisterid;
    }

    public Date getEnregisterdate() {
        return this.enregisterdate;
    }

    public void setEnregisterdate(Date enregisterdate) {
        this.enregisterdate = enregisterdate;
    }

    public void copy(Poreceiptinfo other) {

        this.setPoreceiptstate(other.getPoreceiptstate());
        this.setPunishobjectid(other.getPunishobjectid());

        this.operatorname = other.getOperatorname();
        this.signinedname = other.getSigninedname();
        this.signineddate = other.getSignineddate();
        this.poreceiptname = other.getPoreceiptname();
        this.poreceiptdoc = other.getPoreceiptdoc();
        this.receiptmodel = other.getReceiptmodel();
        this.enregisterid = other.getEnregisterid();
        this.enregisterdate = other.getEnregisterdate();

    }

    public void copyNotNullProperty(Poreceiptinfo other) {

        if (other.getPoreceiptstate() != null)
            this.setPoreceiptstate(other.getPoreceiptstate());
        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getOperatorname() != null)
            this.operatorname = other.getOperatorname();
        if (other.getSigninedname() != null)
            this.signinedname = other.getSigninedname();
        if (other.getSignineddate() != null)
            this.signineddate = other.getSignineddate();
        if (other.getPoreceiptname() != null)
            this.poreceiptname = other.getPoreceiptname();
        if (other.getPoreceiptdoc() != null)
            this.poreceiptdoc = other.getPoreceiptdoc();
        if (other.getReceiptmodel() != null)
            this.receiptmodel = other.getReceiptmodel();
        if (other.getEnregisterid() != null)
            this.enregisterid = other.getEnregisterid();
        if (other.getEnregisterdate() != null)
            this.enregisterdate = other.getEnregisterdate();

    }

    public void clearProperties() {

        this.operatorname = null;
        this.signinedname = null;
        this.signineddate = null;
        this.poreceiptname = null;
        this.poreceiptdoc = null;
        this.receiptmodel = null;
        this.enregisterid = null;
        this.enregisterdate = null;

    }
}

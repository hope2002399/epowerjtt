package com.centit.powerruntime.po;

import java.util.Date;

public class OptExpressMessage implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String expressid;
    private String emsordno;
    private String govtbname;
    private String posttype;
    private String nettype;
    private String busstype;
    private String sendname;
    private String sendprov;
    private String sendcity;
    private String sendCountry;
    private String sendstrect;
    private String sendphone;
    private String sendcall;
    private String rcvname;
    private String rcvprov;
    private String rcvcity;
    private String rcvcountry;
    private String rcvstrect;
    private String rcvphone;
    private String rcvcall;
    private String rcvpostcode;
    private String item;
    private String chkcode;
    private String issend;
    private String showmore;
    private Date expresstime;
    private String state;
    private String djid;
    private String isnetApply;
    private String mailnum;
    private String bjnumber;

    private String signature;

    // Constructors
    /** default constructor */
    public OptExpressMessage() {
    }

    /** minimal constructor */
    public OptExpressMessage(String expressid) {

        this.expressid = expressid;

    }

    /** full constructor */
    public OptExpressMessage(String expressid, Date expresstime,
            String sendprov, String sendcity, String sendCountry,
            String sendstrect, String sendphone, String sendcall,
            String emsordno, String govtbname, String posttype, String nettype,
            String busstype, String sendname, String rcvname, String item,
            String chkcode, String issend, String showmore, String rcvprov,
            String rcvcity, String rcvcountry, String rcvstrect,
            String rcvphone, String rcvcall, String rcvpostcode, String state,
            String djid, String mailnum) {
        this.expressid = expressid;
        this.emsordno = emsordno;
        this.govtbname = govtbname;
        this.posttype = posttype;
        this.nettype = nettype;
        this.busstype = busstype;
        this.sendname = sendname;
        this.sendprov = sendprov;
        this.sendcity = sendcity;
        this.sendCountry = sendCountry;
        this.sendstrect = sendstrect;
        this.sendphone = sendphone;
        this.sendcall = sendcall;
        this.rcvname = rcvname;
        this.rcvprov = rcvprov;
        this.rcvcity = rcvcity;
        this.rcvcountry = rcvcountry;
        this.rcvstrect = rcvstrect;
        this.rcvphone = rcvphone;
        this.rcvcall = rcvcall;
        this.rcvpostcode = rcvpostcode;
        this.item = item;
        this.chkcode = chkcode;
        this.issend = issend;
        this.showmore = showmore;
        this.expresstime = expresstime;
        this.state = state;
        this.djid = djid;
        this.mailnum = mailnum;
    }

    public String getExpressid() {
        return this.expressid;
    }

    public void setExpressid(String expressid) {
        this.expressid = expressid;
    }

    // Property accessors

    public String getEmsordno() {
        return this.emsordno;
    }

    public void setEmsordno(String emsordno) {
        this.emsordno = emsordno;
    }

    public String getGovtbname() {
        return this.govtbname;
    }

    public void setGovtbname(String govtbname) {
        this.govtbname = govtbname;
    }

    public String getPosttype() {
        return this.posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public String getNettype() {
        return this.nettype;
    }

    public void setNettype(String nettype) {
        this.nettype = nettype;
    }

    public String getBusstype() {
        return this.busstype;
    }

    public void setBusstype(String busstype) {
        this.busstype = busstype;
    }

    public String getSendname() {
        return this.sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public String getSendprov() {
        return sendprov;
    }

    public void setSendprov(String sendprov) {
        this.sendprov = sendprov;
    }

    public String getSendcity() {
        return sendcity;
    }

    public void setSendcity(String sendcity) {
        this.sendcity = sendcity;
    }

    public String getSendCountry() {
        return sendCountry;
    }

    public void setSendCountry(String sendCountry) {
        this.sendCountry = sendCountry;
    }

    public String getSendstrect() {
        return sendstrect;
    }

    public void setSendstrect(String sendstrect) {
        this.sendstrect = sendstrect;
    }

    public String getSendphone() {
        return sendphone;
    }

    public void setSendphone(String sendphone) {
        this.sendphone = sendphone;
    }

    public String getSendcall() {
        return sendcall;
    }

    public void setSendcall(String sendcall) {
        this.sendcall = sendcall;
    }

    public String getRcvname() {
        return this.rcvname;
    }

    public void setRcvname(String rcvname) {
        this.rcvname = rcvname;
    }

    public String getRcvprov() {
        return rcvprov;
    }

    public void setRcvprov(String rcvprov) {
        this.rcvprov = rcvprov;
    }

    public String getRcvcity() {
        return rcvcity;
    }

    public void setRcvcity(String rcvcity) {
        this.rcvcity = rcvcity;
    }

    public String getRcvcountry() {
        return rcvcountry;
    }

    public void setRcvcountry(String rcvcountry) {
        this.rcvcountry = rcvcountry;
    }

    public String getRcvstrect() {
        return rcvstrect;
    }

    public void setRcvstrect(String rcvstrect) {
        this.rcvstrect = rcvstrect;
    }

    public String getRcvphone() {
        return rcvphone;
    }

    public void setRcvphone(String rcvphone) {
        this.rcvphone = rcvphone;
    }

    public String getRcvcall() {
        return rcvcall;
    }

    public void setRcvcall(String rcvcall) {
        this.rcvcall = rcvcall;
    }

    public String getRcvpostcode() {
        return rcvpostcode;
    }

    public void setRcvpostcode(String rcvpostcode) {
        this.rcvpostcode = rcvpostcode;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getChkcode() {
        return this.chkcode;
    }

    public void setChkcode(String chkcode) {
        this.chkcode = chkcode;
    }

    public String getIssend() {
        return this.issend;
    }

    public void setIssend(String issend) {
        this.issend = issend;
    }

    public String getBjnumber() {
        return bjnumber;
    }

    public void setBjnumber(String bjnumber) {
        this.bjnumber = bjnumber;
    }

    public String getShowmore() {
        return showmore;
    }

    public void setShowmore(String showmore) {
        this.showmore = showmore;
    }

    public Date getExpresstime() {
        return expresstime;
    }

    public void setExpresstime(Date expresstime) {
        this.expresstime = expresstime;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDjid() {
        return djid;
    }

    public void setDjid(String djid) {
        this.djid = djid;
    }

    public String getMailnum() {
        return mailnum;
    }

    public void setMailnum(String mailnum) {
        this.mailnum = mailnum;
    }

    public void copy(OptExpressMessage other) {
        this.setExpressid(other.getExpressid());
        this.emsordno = other.getEmsordno();
        this.govtbname = other.getGovtbname();
        this.posttype = other.getPosttype();
        this.nettype = other.getNettype();
        this.busstype = other.getBusstype();
        this.sendname = other.getSendname();
        this.sendprov = other.getSendprov();
        this.sendcity = other.getSendcity();
        this.sendCountry = other.getSendCountry();
        this.sendstrect = other.getSendstrect();
        this.sendphone = other.getSendphone();
        this.sendcall = other.getSendcall();
        this.rcvname = other.getRcvname();
        this.rcvprov = other.getRcvprov();
        this.rcvcity = other.getRcvcity();
        this.rcvcountry = other.getRcvcountry();
        this.rcvstrect = other.getRcvstrect();
        this.rcvphone = other.getRcvphone();
        this.rcvcall = other.getRcvcall();
        this.rcvpostcode = other.getRcvpostcode();
        this.item = other.getItem();
        this.chkcode = other.getChkcode();
        this.issend = other.getIssend();
        this.showmore = other.getShowmore();
        this.expresstime = other.getExpresstime();
        this.state = other.getState();
        this.djid = other.getDjid();
        this.mailnum = other.getMailnum();
    }

    public void copyNotNullProperty(OptExpressMessage other) {
        if (other.getExpressid() != null)
            this.setExpressid(other.getExpressid());
        if (other.getEmsordno() != null)
            this.emsordno = other.getEmsordno();
        if (other.getGovtbname() != null)
            this.govtbname = other.getGovtbname();
        if (other.getPosttype() != null)
            this.posttype = other.getPosttype();
        if (other.getNettype() != null)
            this.nettype = other.getNettype();
        if (other.getBusstype() != null)
            this.busstype = other.getBusstype();
        if (other.getSendname() != null)
            this.sendname = other.getSendname();
        if (other.getSendprov() != null)
            this.sendprov = other.getSendprov();
        if (other.getSendcity() != null)
            this.sendcity = other.getSendcity();
        if (other.getSendCountry() != null)
            this.sendCountry = other.getSendCountry();
        if (other.getSendstrect() != null)
            this.sendstrect = other.getSendstrect();
        if (other.getSendphone() != null)
            this.sendphone = other.getSendphone();
        if (other.getSendcall() != null)
            this.sendcall = other.getSendcall();
        if (other.getRcvname() != null)
            this.rcvname = other.getRcvname();
        if (other.getRcvprov() != null)
            this.rcvprov = other.getRcvprov();
        if (other.getRcvcity() != null)
            this.rcvcity = other.getRcvcity();
        if (other.getRcvcountry() != null)
            this.rcvcountry = other.getRcvcountry();
        if (other.getRcvstrect() != null)
            this.rcvstrect = other.getRcvstrect();
        if (other.getRcvphone() != null)
            this.rcvphone = other.getRcvphone();
        if (other.getRcvcall() != null)
            this.rcvcall = other.getRcvcall();
        if (other.getRcvpostcode() != null)
            this.rcvpostcode = other.getRcvpostcode();
        if (other.getItem() != null)
            this.item = other.getItem();
        if (other.getChkcode() != null)
            this.chkcode = other.getChkcode();
        if (other.getIssend() != null)
            this.issend = other.getIssend();
        if (other.getShowmore() != null)
            this.showmore = other.getShowmore();
        if (other.getExpresstime() != null)
            this.expresstime = other.getExpresstime();
        if (other.getState() != null)
            this.state = other.getState();
        if (other.getDjid() != null)
            this.djid = other.getDjid();
        if (other.getMailnum() != null)
            this.mailnum = other.getMailnum();
    }

    public String getIsnetApply() {
        return isnetApply;
    }

    public void setIsnetApply(String isnetApply) {
        this.isnetApply = isnetApply;
    }

    public void clearProperties() {
        this.emsordno = null;
        this.govtbname = null;
        this.posttype = null;
        this.nettype = null;
        this.busstype = null;
        this.sendname = null;
        this.sendprov = null;
        this.sendcity = null;
        this.sendCountry = null;
        this.sendstrect = null;
        this.sendphone = null;
        this.sendcall = null;
        this.rcvname = null;
        this.rcvprov = null;
        this.rcvcity = null;
        this.rcvcountry = null;
        this.rcvstrect = null;
        this.rcvphone = null;
        this.rcvcall = null;
        this.rcvpostcode = null;
        this.item = null;
        this.chkcode = null;
        this.issend = null;
        this.showmore = null;
        this.expresstime = null;
        this.state = null;
        this.djid = null;
        this.mailnum = null;
    }
}

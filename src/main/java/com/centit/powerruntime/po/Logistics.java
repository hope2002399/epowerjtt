package com.centit.powerruntime.po;

import java.util.Date;

public class Logistics {
    private String emsordno;
    private String mailnum;
    private String status;
    private String stsinfo;
    private String stsdesc;
    private Date ststime;
    public String getEmsordno() {
        return emsordno;
    }
    public void setEmsordno(String emsordno) {
        this.emsordno = emsordno;
    }
    public String getMailnum() {
        return mailnum;
    }
    public void setMailnum(String mailnum) {
        this.mailnum = mailnum;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStsinfo() {
        return stsinfo;
    }
    public void setStsinfo(String stsinfo) {
        this.stsinfo = stsinfo;
    }
    public String getStsdesc() {
        return stsdesc;
    }
    public void setStsdesc(String stsdesc) {
        this.stsdesc = stsdesc;
    }
    public Date getStstime() {
        return ststime;
    }
    public void setStstime(Date ststime) {
        this.ststime = ststime;
    }
    
    
    
}

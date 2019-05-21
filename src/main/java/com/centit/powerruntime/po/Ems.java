package com.centit.powerruntime.po;

public class Ems implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String emsId;
    private String emsordno;
    private String orgcode;
    private String internalno;
    private String rcvname;
    private String rcvstrect;
    private String rcvphone;
    private String emscontent;
    private String emsresultcode;
    private String emsresultmsg;

    public Ems() {
        this.emsId = String.valueOf(System.currentTimeMillis());
    }

    public Ems(String emsordno, String orgcode, String internalno) {
        this.emsId = String.valueOf(System.currentTimeMillis());
        this.emsordno = emsordno;
        this.orgcode = orgcode;
        this.internalno = internalno;
    }

    public Ems(String emsordno, String orgcode, String internalno,
            String rcvname, String rcvstrect, String rcvphone, String emscontent) {
        this.emsId = String.valueOf(System.currentTimeMillis());
        this.rcvname = rcvname;
        this.rcvstrect = rcvstrect;
        this.rcvphone = rcvphone;
        this.emsordno = emsordno;
        this.orgcode = orgcode;
        this.internalno = internalno;
        this.emscontent = emscontent;
    }

    public String getEmsId() {
        return emsId;
    }

    public void setEmsId(String emsId) {
        this.emsId = emsId;
    }

    public String getEmsordno() {
        return emsordno;
    }

    public void setEmsordno(String emsordno) {
        this.emsordno = emsordno;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getInternalno() {
        return internalno;
    }

    public void setInternalno(String internalno) {
        this.internalno = internalno;
    }

    public String getEmscontent() {
        return emscontent;
    }

    public void setEmscontent(String emscontent) {
        this.emscontent = emscontent;
    }

    public String getEmsresultcode() {
        return emsresultcode;
    }

    public void setEmsresultcode(String emsresultcode) {
        this.emsresultcode = emsresultcode;
    }

    public String getEmsresultmsg() {
        return emsresultmsg;
    }

    public void setEmsresultmsg(String emsresultmsg) {
        this.emsresultmsg = emsresultmsg;
    }

    public String getRcvname() {
        return rcvname;
    }

    public void setRcvname(String rcvname) {
        this.rcvname = rcvname;
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

}

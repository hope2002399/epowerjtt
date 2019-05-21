package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poexcucebasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private Date poexcucedate;
    private String poexcuceadress;
    private String undertakername;
    private String undertakecertno;
    private String undertakername2;
    private String undertakecertno2;
    private String registercertno;
    private String registerid;
    private String deputyname;
    private Date excucedate;

    // Constructors
    /** default constructor */
    public Poexcucebasic() {
    }

    /** minimal constructor */
    public Poexcucebasic(String punishobjectid, Date poexcucedate,
            Date excucedate) {

        this.punishobjectid = punishobjectid;

        this.poexcucedate = poexcucedate;
        this.excucedate = excucedate;
    }

    /** full constructor */
    public Poexcucebasic(String punishobjectid, Date poexcucedate,
            String poexcuceadress, String undertakername,
            String undertakecertno, String registercertno, String registerid,
            String deputyname, Date excucedate) {

        this.punishobjectid = punishobjectid;

        this.poexcucedate = poexcucedate;
        this.poexcuceadress = poexcuceadress;
        this.undertakername = undertakername;
        this.undertakecertno = undertakecertno;
        this.registercertno = registercertno;
        this.registerid = registerid;
        this.deputyname = deputyname;
        this.excucedate = excucedate;
    }

    public Poexcucebasic(String punishobjectid, Date poexcucedate,
            String poexcuceadress, String undertakername,
            String undertakecertno, String undertakername2,
            String undertakecertno2, String registercertno, String registerid,
            String deputyname, Date excucedate) {
        super();
        this.punishobjectid = punishobjectid;
        this.poexcucedate = poexcucedate;
        this.poexcuceadress = poexcuceadress;
        this.undertakername = undertakername;
        this.undertakecertno = undertakecertno;
        this.undertakername2 = undertakername2;
        this.undertakecertno2 = undertakecertno2;
        this.registercertno = registercertno;
        this.registerid = registerid;
        this.deputyname = deputyname;
        this.excucedate = excucedate;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public Date getPoexcucedate() {
        return this.poexcucedate;
    }

    public void setPoexcucedate(Date poexcucedate) {
        this.poexcucedate = poexcucedate;
    }

    public String getPoexcuceadress() {
        return this.poexcuceadress;
    }

    public void setPoexcuceadress(String poexcuceadress) {
        this.poexcuceadress = poexcuceadress;
    }

    public String getUndertakername() {
        return this.undertakername;
    }

    public void setUndertakername(String undertakername) {
        this.undertakername = undertakername;
    }

    public String getUndertakecertno() {
        return this.undertakecertno;
    }

    public void setUndertakecertno(String undertakecertno) {
        this.undertakecertno = undertakecertno;
    }

    public String getRegistercertno() {
        return this.registercertno;
    }

    public void setRegistercertno(String registercertno) {
        this.registercertno = registercertno;
    }

    public String getRegisterid() {
        return this.registerid;
    }

    public void setRegisterid(String registerid) {
        this.registerid = registerid;
    }

    public String getDeputyname() {
        return this.deputyname;
    }

    public void setDeputyname(String deputyname) {
        this.deputyname = deputyname;
    }

    public Date getExcucedate() {
        return this.excucedate;
    }

    public void setExcucedate(Date excucedate) {
        this.excucedate = excucedate;
    }

    public String getUndertakername2() {
        return undertakername2;
    }

    public void setUndertakername2(String undertakername2) {
        this.undertakername2 = undertakername2;
    }

    public String getUndertakecertno2() {
        return undertakecertno2;
    }

    public void setUndertakecertno2(String undertakecertno2) {
        this.undertakecertno2 = undertakecertno2;
    }

    public void copy(Poexcucebasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.poexcucedate = other.getPoexcucedate();
        this.poexcuceadress = other.getPoexcuceadress();
        this.undertakername = other.getUndertakername();
        this.undertakecertno = other.getUndertakecertno();
        this.undertakername2 = other.getUndertakername2();
        this.undertakecertno2 = other.getUndertakecertno2();
        this.registercertno = other.getRegistercertno();
        this.registerid = other.getRegisterid();
        this.deputyname = other.getDeputyname();
        this.excucedate = other.getExcucedate();

    }

    public void copyNotNullProperty(Poexcucebasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPoexcucedate() != null)
            this.poexcucedate = other.getPoexcucedate();
        if (other.getPoexcuceadress() != null)
            this.poexcuceadress = other.getPoexcuceadress();
        if (other.getUndertakername() != null)
            this.undertakername = other.getUndertakername();
        if (other.getUndertakecertno() != null)
            this.undertakecertno = other.getUndertakecertno();
        if (other.getUndertakername2() != null)
            this.undertakername2 = other.getUndertakername2();
        if (other.getUndertakecertno2() != null)
            this.undertakecertno2 = other.getUndertakecertno2();
        if (other.getRegistercertno() != null)
            this.registercertno = other.getRegistercertno();
        if (other.getRegisterid() != null)
            this.registerid = other.getRegisterid();
        if (other.getDeputyname() != null)
            this.deputyname = other.getDeputyname();
        if (other.getExcucedate() != null)
            this.excucedate = other.getExcucedate();

    }

    public void clearProperties() {

        this.poexcucedate = null;
        this.poexcuceadress = null;
        this.undertakername = null;
        this.undertakecertno = null;
        this.undertakername2 = null;
        this.undertakecertno2 = null;
        this.registercertno = null;
        this.registerid = null;
        this.deputyname = null;
        this.excucedate = null;

    }
}

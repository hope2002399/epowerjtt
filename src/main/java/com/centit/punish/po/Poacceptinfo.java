package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poacceptinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String jbrSl;
    private String ksrSl;
    private String fzrSl;
    private String jbroptionSl;
    private String ksoptionSl;
    private String fzroptionSl;
    private Date jbroptionSltime;
    private Date ksoptionSltime;
    private Date fzroptionSltime;

    // Constructors
    /** default constructor */
    public Poacceptinfo() {
    }

    /** minimal constructor */
    public Poacceptinfo(String punishobjectid) {

        this.punishobjectid = punishobjectid;

    }

    /** full constructor */
    public Poacceptinfo(String punishobjectid, String jbrSl, String ksrSl,
            String fzrSl, String jbroptionSl, String ksoptionSl,
            String fzroptionSl, Date jbroptionSltime, Date ksoptionSltime,
            Date fzroptionSltime) {

        this.punishobjectid = punishobjectid;

        this.jbrSl = jbrSl;
        this.ksrSl = ksrSl;
        this.fzrSl = fzrSl;
        this.jbroptionSl = jbroptionSl;
        this.ksoptionSl = ksoptionSl;
        this.fzroptionSl = fzroptionSl;
        this.jbroptionSltime = jbroptionSltime;
        this.ksoptionSltime = ksoptionSltime;
        this.fzroptionSltime = fzroptionSltime;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getJbrSl() {
        return this.jbrSl;
    }

    public void setJbrSl(String jbrSl) {
        this.jbrSl = jbrSl;
    }

    public String getKsrSl() {
        return this.ksrSl;
    }

    public void setKsrSl(String ksrSl) {
        this.ksrSl = ksrSl;
    }

    public String getFzrSl() {
        return this.fzrSl;
    }

    public void setFzrSl(String fzrSl) {
        this.fzrSl = fzrSl;
    }

    public String getJbroptionSl() {
        return this.jbroptionSl;
    }

    public void setJbroptionSl(String jbroptionSl) {
        this.jbroptionSl = jbroptionSl;
    }

    public String getKsoptionSl() {
        return this.ksoptionSl;
    }

    public void setKsoptionSl(String ksoptionSl) {
        this.ksoptionSl = ksoptionSl;
    }

    public String getFzroptionSl() {
        return this.fzroptionSl;
    }

    public void setFzroptionSl(String fzroptionSl) {
        this.fzroptionSl = fzroptionSl;
    }

    public Date getJbroptionSltime() {
        return this.jbroptionSltime;
    }

    public void setJbroptionSltime(Date jbroptionSltime) {
        this.jbroptionSltime = jbroptionSltime;
    }

    public Date getKsoptionSltime() {
        return this.ksoptionSltime;
    }

    public void setKsoptionSltime(Date ksoptionSltime) {
        this.ksoptionSltime = ksoptionSltime;
    }

    public Date getFzroptionSltime() {
        return this.fzroptionSltime;
    }

    public void setFzroptionSltime(Date fzroptionSltime) {
        this.fzroptionSltime = fzroptionSltime;
    }

    public void copy(Poacceptinfo other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.jbrSl = other.getJbrSl();
        this.ksrSl = other.getKsrSl();
        this.fzrSl = other.getFzrSl();
        this.jbroptionSl = other.getJbroptionSl();
        this.ksoptionSl = other.getKsoptionSl();
        this.fzroptionSl = other.getFzroptionSl();
        this.jbroptionSltime = other.getJbroptionSltime();
        this.ksoptionSltime = other.getKsoptionSltime();
        this.fzroptionSltime = other.getFzroptionSltime();

    }

    public void copyNotNullProperty(Poacceptinfo other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getJbrSl() != null)
            this.jbrSl = other.getJbrSl();
        if (other.getKsrSl() != null)
            this.ksrSl = other.getKsrSl();
        if (other.getFzrSl() != null)
            this.fzrSl = other.getFzrSl();
        if (other.getJbroptionSl() != null)
            this.jbroptionSl = other.getJbroptionSl();
        if (other.getKsoptionSl() != null)
            this.ksoptionSl = other.getKsoptionSl();
        if (other.getFzroptionSl() != null)
            this.fzroptionSl = other.getFzroptionSl();
        if (other.getJbroptionSltime() != null)
            this.jbroptionSltime = other.getJbroptionSltime();
        if (other.getKsoptionSltime() != null)
            this.ksoptionSltime = other.getKsoptionSltime();
        if (other.getFzroptionSltime() != null)
            this.fzroptionSltime = other.getFzroptionSltime();

    }

    public void clearProperties() {

        this.jbrSl = null;
        this.ksrSl = null;
        this.fzrSl = null;
        this.jbroptionSl = null;
        this.ksoptionSl = null;
        this.fzroptionSl = null;
        this.jbroptionSltime = null;
        this.ksoptionSltime = null;
        this.fzroptionSltime = null;

    }
}

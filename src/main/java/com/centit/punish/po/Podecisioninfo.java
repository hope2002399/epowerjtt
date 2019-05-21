package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Podecisioninfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String jbrCfjd;
    private String ksrCfjd;
    private String fzrCfjd;
    private String jbroptionCfjd;
    private String ksoptionCfjd;
    private String fzroptionCfjd;
    private Date jbroptionCfjdtime;
    private Date ksoptionCfjdtime;
    private Date fzroptionCfjdtime;

    // Constructors
    /** default constructor */
    public Podecisioninfo() {
    }

    /** minimal constructor */
    public Podecisioninfo(String punishobjectid) {

        this.punishobjectid = punishobjectid;

    }

    /** full constructor */
    public Podecisioninfo(String punishobjectid, String jbrCfjd,
            String ksrCfjd, String fzrCfjd, String jbroptionCfjd,
            String ksoptionCfjd, String fzroptionCfjd, Date jbroptionCfjdtime,
            Date ksoptionCfjdtime, Date fzroptionCfjdtime) {

        this.punishobjectid = punishobjectid;

        this.jbrCfjd = jbrCfjd;
        this.ksrCfjd = ksrCfjd;
        this.fzrCfjd = fzrCfjd;
        this.jbroptionCfjd = jbroptionCfjd;
        this.ksoptionCfjd = ksoptionCfjd;
        this.fzroptionCfjd = fzroptionCfjd;
        this.jbroptionCfjdtime = jbroptionCfjdtime;
        this.ksoptionCfjdtime = ksoptionCfjdtime;
        this.fzroptionCfjdtime = fzroptionCfjdtime;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getJbrCfjd() {
        return this.jbrCfjd;
    }

    public void setJbrCfjd(String jbrCfjd) {
        this.jbrCfjd = jbrCfjd;
    }

    public String getKsrCfjd() {
        return this.ksrCfjd;
    }

    public void setKsrCfjd(String ksrCfjd) {
        this.ksrCfjd = ksrCfjd;
    }

    public String getFzrCfjd() {
        return this.fzrCfjd;
    }

    public void setFzrCfjd(String fzrCfjd) {
        this.fzrCfjd = fzrCfjd;
    }

    public String getJbroptionCfjd() {
        return this.jbroptionCfjd;
    }

    public void setJbroptionCfjd(String jbroptionCfjd) {
        this.jbroptionCfjd = jbroptionCfjd;
    }

    public String getKsoptionCfjd() {
        return this.ksoptionCfjd;
    }

    public void setKsoptionCfjd(String ksoptionCfjd) {
        this.ksoptionCfjd = ksoptionCfjd;
    }

    public String getFzroptionCfjd() {
        return this.fzroptionCfjd;
    }

    public void setFzroptionCfjd(String fzroptionCfjd) {
        this.fzroptionCfjd = fzroptionCfjd;
    }

    public Date getJbroptionCfjdtime() {
        return this.jbroptionCfjdtime;
    }

    public void setJbroptionCfjdtime(Date jbroptionCfjdtime) {
        this.jbroptionCfjdtime = jbroptionCfjdtime;
    }

    public Date getKsoptionCfjdtime() {
        return this.ksoptionCfjdtime;
    }

    public void setKsoptionCfjdtime(Date ksoptionCfjdtime) {
        this.ksoptionCfjdtime = ksoptionCfjdtime;
    }

    public Date getFzroptionCfjdtime() {
        return this.fzroptionCfjdtime;
    }

    public void setFzroptionCfjdtime(Date fzroptionCfjdtime) {
        this.fzroptionCfjdtime = fzroptionCfjdtime;
    }

    public void copy(Podecisioninfo other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.jbrCfjd = other.getJbrCfjd();
        this.ksrCfjd = other.getKsrCfjd();
        this.fzrCfjd = other.getFzrCfjd();
        this.jbroptionCfjd = other.getJbroptionCfjd();
        this.ksoptionCfjd = other.getKsoptionCfjd();
        this.fzroptionCfjd = other.getFzroptionCfjd();
        this.jbroptionCfjdtime = other.getJbroptionCfjdtime();
        this.ksoptionCfjdtime = other.getKsoptionCfjdtime();
        this.fzroptionCfjdtime = other.getFzroptionCfjdtime();

    }

    public void copyNotNullProperty(Podecisioninfo other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getJbrCfjd() != null)
            this.jbrCfjd = other.getJbrCfjd();
        if (other.getKsrCfjd() != null)
            this.ksrCfjd = other.getKsrCfjd();
        if (other.getFzrCfjd() != null)
            this.fzrCfjd = other.getFzrCfjd();
        if (other.getJbroptionCfjd() != null)
            this.jbroptionCfjd = other.getJbroptionCfjd();
        if (other.getKsoptionCfjd() != null)
            this.ksoptionCfjd = other.getKsoptionCfjd();
        if (other.getFzroptionCfjd() != null)
            this.fzroptionCfjd = other.getFzroptionCfjd();
        if (other.getJbroptionCfjdtime() != null)
            this.jbroptionCfjdtime = other.getJbroptionCfjdtime();
        if (other.getKsoptionCfjdtime() != null)
            this.ksoptionCfjdtime = other.getKsoptionCfjdtime();
        if (other.getFzroptionCfjdtime() != null)
            this.fzroptionCfjdtime = other.getFzroptionCfjdtime();

    }

    public void clearProperties() {

        this.jbrCfjd = null;
        this.ksrCfjd = null;
        this.fzrCfjd = null;
        this.jbroptionCfjd = null;
        this.ksoptionCfjd = null;
        this.fzroptionCfjd = null;
        this.jbroptionCfjdtime = null;
        this.ksoptionCfjdtime = null;
        this.fzroptionCfjdtime = null;

    }
}

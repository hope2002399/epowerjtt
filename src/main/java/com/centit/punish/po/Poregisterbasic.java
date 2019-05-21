package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poregisterbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String poregisterindagate; // 调查情况
    private String poregisterbasis;
    private String ispass; // 立案

    private String jbr_la;
    private String ks_la;
    private String fzr_la;
    private String jbrOption_la;
    private String ksOption_la;
    private String fzrOption_la;
    private Date jbrOption_latime;
    private Date ksOption_latime;
    private Date fzrOption_latime;

    private Long ifregister;
    private String punishObjectBrief;// 案由

    // Constructors
    /** default constructor */
    public Poregisterbasic() {
    }

    /** minimal constructor */
    public Poregisterbasic(String punishobjectid, Long poregisterstep) {

        this.punishobjectid = punishobjectid;

    }

    public Poregisterbasic(String punishobjectid, String poregisterindagate,
            String poregisterbasis, String ispass, String jbr_la, String ks_la,
            String fzr_la, String jbrOption_la, String ksOption_la,
            String fzrOption_la, Date jbrOption_latime, Date ksOption_latime,
            Date fzrOption_latime, Long ifregister) {
        super();
        this.punishobjectid = punishobjectid;
        this.poregisterindagate = poregisterindagate;
        this.poregisterbasis = poregisterbasis;
        this.ispass = ispass;
        this.jbr_la = jbr_la;
        this.ks_la = ks_la;
        this.fzr_la = fzr_la;
        this.jbrOption_la = jbrOption_la;
        this.ksOption_la = ksOption_la;
        this.fzrOption_la = fzrOption_la;
        this.jbrOption_latime = jbrOption_latime;
        this.ksOption_latime = ksOption_latime;
        this.fzrOption_latime = fzrOption_latime;
        this.ifregister = ifregister;
    }

    public String getJbr_la() {
        return jbr_la;
    }

    public void setJbr_la(String jbr_la) {
        this.jbr_la = jbr_la;
    }

    public String getKs_la() {
        return ks_la;
    }

    public void setKs_la(String ks_la) {
        this.ks_la = ks_la;
    }

    public String getFzr_la() {
        return fzr_la;
    }

    public void setFzr_la(String fzr_la) {
        this.fzr_la = fzr_la;
    }

    public String getJbrOption_la() {
        return jbrOption_la;
    }

    public void setJbrOption_la(String jbrOption_la) {
        this.jbrOption_la = jbrOption_la;
    }

    public String getKsOption_la() {
        return ksOption_la;
    }

    public void setKsOption_la(String ksOption_la) {
        this.ksOption_la = ksOption_la;
    }

    public String getFzrOption_la() {
        return fzrOption_la;
    }

    public void setFzrOption_la(String fzrOption_la) {
        this.fzrOption_la = fzrOption_la;
    }

    public Date getJbrOption_latime() {
        return jbrOption_latime;
    }

    public void setJbrOption_latime(Date jbrOption_latime) {
        this.jbrOption_latime = jbrOption_latime;
    }

    public Date getKsOption_latime() {
        return ksOption_latime;
    }

    public void setKsOption_latime(Date ksOption_latime) {
        this.ksOption_latime = ksOption_latime;
    }

    public Date getFzrOption_latime() {
        return fzrOption_latime;
    }

    public void setFzrOption_latime(Date fzrOption_latime) {
        this.fzrOption_latime = fzrOption_latime;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** full constructor */
    public Poregisterbasic(String punishobjectid, String poregisterindagate,
            String poregisterbasis, String ispass, Long ifregister) {

        this.punishobjectid = punishobjectid;

        this.poregisterindagate = poregisterindagate;
        this.poregisterbasis = poregisterbasis;
        this.ispass = ispass;
        this.ifregister = ifregister;

    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

    public String getPoregisterindagate() {
        return this.poregisterindagate;
    }

    public void setPoregisterindagate(String poregisterindagate) {
        this.poregisterindagate = poregisterindagate;
    }

    public String getPoregisterbasis() {
        return this.poregisterbasis;
    }

    public void setPoregisterbasis(String poregisterbasis) {
        this.poregisterbasis = poregisterbasis;
    }

    public String getIspass() {
        return this.ispass;
    }

    public void setIspass(String ispass) {
        this.ispass = ispass;
    }

    public Long getIfregister() {
        return this.ifregister;
    }

    public void setIfregister(Long ifregister) {
        this.ifregister = ifregister;
    }

    public void copy(Poregisterbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.poregisterindagate = other.getPoregisterindagate();
        this.poregisterbasis = other.getPoregisterbasis();
        this.ispass = other.getIspass();
        this.ifregister = other.getIfregister();
        this.punishObjectBrief = other.getPunishObjectBrief();

    }

    public void copyNotNullProperty(Poregisterbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getPoregisterindagate() != null)
            this.poregisterindagate = other.getPoregisterindagate();
        if (other.getPoregisterbasis() != null)
            this.poregisterbasis = other.getPoregisterbasis();
        if (other.getIspass() != null)
            this.ispass = other.getIspass();
        if (other.getIfregister() != null)
            this.ifregister = other.getIfregister();

    }

    public void clearProperties() {

        this.poregisterindagate = null;
        this.poregisterbasis = null;
        this.ispass = null;
        this.ifregister = null;
    }

    public String getPunishObjectBrief() {
        return punishObjectBrief;
    }

    public void setPunishObjectBrief(String punishObjectBrief) {
        this.punishObjectBrief = punishObjectBrief;
    }

}

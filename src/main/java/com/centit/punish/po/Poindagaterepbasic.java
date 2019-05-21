package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Poindagaterepbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String confirmtruth;
    private String unconfirmtruth;
    private String poindagatereppassage;
    private String disobeyitem;
    private String poindagaterepresult;
    private Long isdiscuss;
    private byte[] poindagaterepreportdoc;
    private String poindagaterepreportdocname;
    private String poindagaterepstate;
    private Long poindagaterepstep;

    private String jbr_dczj;
    private String ks_dczj;
    private String fzr_dczj;
    private String jbrOption_dczj;
    private String ksOption_dczj;
    private String fzrOption_dczj;
    private Date jbrOptiontime_dczj;
    private Date ksOptiontime_dczj;
    private Date fzrOptiontime_dczj;

    private String poindagaterepcontent;
    private String version;

    public String getPoindagaterepcontent() {
        return poindagaterepcontent;
    }

    public void setPoindagaterepcontent(String poindagaterepcontent) {
        this.poindagaterepcontent = poindagaterepcontent;
    }

    // Constructors
    /** default constructor */
    public Poindagaterepbasic() {
    }

    /** minimal constructor */
    public Poindagaterepbasic(String punishobjectid, Long poindagaterepstep) {

        this.punishobjectid = punishobjectid;

        this.poindagaterepstep = poindagaterepstep;
    }

    /** full constructor */
    public Poindagaterepbasic(String punishobjectid, String confirmtruth,
            String unconfirmtruth, String poindagatereppassage,
            String disobeyitem, String poindagaterepresult, Long isdiscuss,
            byte[] poindagaterepreportdoc, String poindagaterepreportdocname,
            String poindagaterepstate, Long poindagaterepstep) {

        this.punishobjectid = punishobjectid;

        this.confirmtruth = confirmtruth;
        this.unconfirmtruth = unconfirmtruth;
        this.poindagatereppassage = poindagatereppassage;
        this.disobeyitem = disobeyitem;
        this.poindagaterepresult = poindagaterepresult;
        this.isdiscuss = isdiscuss;
        this.poindagaterepreportdoc = poindagaterepreportdoc;
        this.poindagaterepreportdocname = poindagaterepreportdocname;
        this.poindagaterepstate = poindagaterepstate;
        this.poindagaterepstep = poindagaterepstep;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public Poindagaterepbasic(String punishobjectid, String confirmtruth,
            String unconfirmtruth, String poindagatereppassage,
            String disobeyitem, String poindagaterepresult, Long isdiscuss,
            byte[] poindagaterepreportdoc, String poindagaterepreportdocname,
            String poindagaterepstate, Long poindagaterepstep, String jbr_dczj,
            String ks_dczj, String fzr_dczj, String jbrOption_dczj,
            String ksOption_dczj, String fzrOption_dczj,
            Date jbrOptiontime_dczj, Date ksOptiontime_dczj,
            Date fzrOptiontime_dczj) {
        super();
        this.punishobjectid = punishobjectid;
        this.confirmtruth = confirmtruth;
        this.unconfirmtruth = unconfirmtruth;
        this.poindagatereppassage = poindagatereppassage;
        this.disobeyitem = disobeyitem;
        this.poindagaterepresult = poindagaterepresult;
        this.isdiscuss = isdiscuss;
        this.poindagaterepreportdoc = poindagaterepreportdoc;
        this.poindagaterepreportdocname = poindagaterepreportdocname;
        this.poindagaterepstate = poindagaterepstate;
        this.poindagaterepstep = poindagaterepstep;
        this.jbr_dczj = jbr_dczj;
        this.ks_dczj = ks_dczj;
        this.fzr_dczj = fzr_dczj;
        this.jbrOption_dczj = jbrOption_dczj;
        this.ksOption_dczj = ksOption_dczj;
        this.fzrOption_dczj = fzrOption_dczj;
        this.jbrOptiontime_dczj = jbrOptiontime_dczj;
        this.ksOptiontime_dczj = ksOptiontime_dczj;
        this.fzrOptiontime_dczj = fzrOptiontime_dczj;
    }

    // Property accessors

    public String getJbr_dczj() {
        return jbr_dczj;
    }

    public void setJbr_dczj(String jbr_dczj) {
        this.jbr_dczj = jbr_dczj;
    }

    public String getKs_dczj() {
        return ks_dczj;
    }

    public void setKs_dczj(String ks_dczj) {
        this.ks_dczj = ks_dczj;
    }

    public String getFzr_dczj() {
        return fzr_dczj;
    }

    public void setFzr_dczj(String fzr_dczj) {
        this.fzr_dczj = fzr_dczj;
    }

    public String getJbrOption_dczj() {
        return jbrOption_dczj;
    }

    public void setJbrOption_dczj(String jbrOption_dczj) {
        this.jbrOption_dczj = jbrOption_dczj;
    }

    public String getKsOption_dczj() {
        return ksOption_dczj;
    }

    public void setKsOption_dczj(String ksOption_dczj) {
        this.ksOption_dczj = ksOption_dczj;
    }

    public String getFzrOption_dczj() {
        return fzrOption_dczj;
    }

    public void setFzrOption_dczj(String fzrOption_dczj) {
        this.fzrOption_dczj = fzrOption_dczj;
    }

    public Date getJbrOptiontime_dczj() {
        return jbrOptiontime_dczj;
    }

    public void setJbrOptiontime_dczj(Date jbrOptiontime_dczj) {
        this.jbrOptiontime_dczj = jbrOptiontime_dczj;
    }

    public Date getKsOptiontime_dczj() {
        return ksOptiontime_dczj;
    }

    public void setKsOptiontime_dczj(Date ksOptiontime_dczj) {
        this.ksOptiontime_dczj = ksOptiontime_dczj;
    }

    public Date getFzrOptiontime_dczj() {
        return fzrOptiontime_dczj;
    }

    public void setFzrOptiontime_dczj(Date fzrOptiontime_dczj) {
        this.fzrOptiontime_dczj = fzrOptiontime_dczj;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getConfirmtruth() {
        return this.confirmtruth;
    }

    public void setConfirmtruth(String confirmtruth) {
        this.confirmtruth = confirmtruth;
    }

    public String getUnconfirmtruth() {
        return this.unconfirmtruth;
    }

    public void setUnconfirmtruth(String unconfirmtruth) {
        this.unconfirmtruth = unconfirmtruth;
    }

    public String getPoindagatereppassage() {
        return this.poindagatereppassage;
    }

    public void setPoindagatereppassage(String poindagatereppassage) {
        this.poindagatereppassage = poindagatereppassage;
    }

    public String getDisobeyitem() {
        return this.disobeyitem;
    }

    public void setDisobeyitem(String disobeyitem) {
        this.disobeyitem = disobeyitem;
    }

    public String getPoindagaterepresult() {
        return this.poindagaterepresult;
    }

    public void setPoindagaterepresult(String poindagaterepresult) {
        this.poindagaterepresult = poindagaterepresult;
    }

    public Long getIsdiscuss() {
        return this.isdiscuss;
    }

    public void setIsdiscuss(Long isdiscuss) {
        this.isdiscuss = isdiscuss;
    }

    public byte[] getPoindagaterepreportdoc() {
        return this.poindagaterepreportdoc;
    }

    public void setPoindagaterepreportdoc(byte[] poindagaterepreportdoc) {
        this.poindagaterepreportdoc = poindagaterepreportdoc;
    }

    public String getPoindagaterepreportdocname() {
        return this.poindagaterepreportdocname;
    }

    public void setPoindagaterepreportdocname(String poindagaterepreportdocname) {
        this.poindagaterepreportdocname = poindagaterepreportdocname;
    }

    public String getPoindagaterepstate() {
        return this.poindagaterepstate;
    }

    public void setPoindagaterepstate(String poindagaterepstate) {
        this.poindagaterepstate = poindagaterepstate;
    }

    public Long getPoindagaterepstep() {
        return this.poindagaterepstep;
    }

    public void setPoindagaterepstep(Long poindagaterepstep) {
        this.poindagaterepstep = poindagaterepstep;
    }

    public void copy(Poindagaterepbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.confirmtruth = other.getConfirmtruth();
        this.unconfirmtruth = other.getUnconfirmtruth();
        this.poindagatereppassage = other.getPoindagatereppassage();
        this.disobeyitem = other.getDisobeyitem();
        this.poindagaterepresult = other.getPoindagaterepresult();
        this.isdiscuss = other.getIsdiscuss();
        this.poindagaterepreportdoc = other.getPoindagaterepreportdoc();
        this.poindagaterepreportdocname = other.getPoindagaterepreportdocname();
        this.poindagaterepstate = other.getPoindagaterepstate();
        this.poindagaterepstep = other.getPoindagaterepstep();

    }

    public void copyNotNullProperty(Poindagaterepbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getConfirmtruth() != null)
            this.confirmtruth = other.getConfirmtruth();
        if (other.getUnconfirmtruth() != null)
            this.unconfirmtruth = other.getUnconfirmtruth();
        if (other.getPoindagatereppassage() != null)
            this.poindagatereppassage = other.getPoindagatereppassage();
        if (other.getDisobeyitem() != null)
            this.disobeyitem = other.getDisobeyitem();
        if (other.getPoindagaterepresult() != null)
            this.poindagaterepresult = other.getPoindagaterepresult();
        if (other.getIsdiscuss() != null)
            this.isdiscuss = other.getIsdiscuss();
        if (other.getPoindagaterepreportdoc() != null)
            this.poindagaterepreportdoc = other.getPoindagaterepreportdoc();
        if (other.getPoindagaterepreportdocname() != null)
            this.poindagaterepreportdocname = other
                    .getPoindagaterepreportdocname();
        if (other.getPoindagaterepstate() != null)
            this.poindagaterepstate = other.getPoindagaterepstate();
        if (other.getPoindagaterepstep() != null)
            this.poindagaterepstep = other.getPoindagaterepstep();

    }

    public void clearProperties() {

        this.confirmtruth = null;
        this.unconfirmtruth = null;
        this.poindagatereppassage = null;
        this.disobeyitem = null;
        this.poindagaterepresult = null;
        this.isdiscuss = null;
        this.poindagaterepreportdoc = null;
        this.poindagaterepreportdocname = null;
        this.poindagaterepstate = null;
        this.poindagaterepstep = null;

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

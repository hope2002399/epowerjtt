package com.centit.punish.po;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Podiscussbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PodiscussbasicId cid;

    private Date podiscussbegintime;
    private Date podiscussendtime;
    private String podiscussemcee;
    private String podiscussnoter;
    private String podiscussattendname;
    private String podiscussattendeename;
    private String podiscussaffixname;
    private byte[] podiscussrecored;
    private String disobeyitem;
    private String confirmtruth;
    private String podiscussadress;
    private String podiscussresult;
    private Date enregisterdate;
    private Long podiscussstep;
    private String enregisterid;
    private String version;

    // Constructors
    /** default constructor */
    public Podiscussbasic() {
    }

    /** minimal constructor */
    public Podiscussbasic(PodiscussbasicId id

    , Long podiscussstep) {
        this.cid = id;

        this.podiscussstep = podiscussstep;
    }

    /** full constructor */
    public Podiscussbasic(PodiscussbasicId id

    , Date podiscussbegintime, Date podiscussendtime, String podiscussemcee,
            String podiscussnoter, String podiscussattendname,
            String podiscussattendeename, String podiscussaffixname,
            byte[] podiscussrecored, String disobeyitem, String confirmtruth,
            String podiscussadress, String podiscussresult,
            Date enregisterdate, Long podiscussstep) {
        this.cid = id;

        this.podiscussbegintime = podiscussbegintime;
        this.podiscussendtime = podiscussendtime;
        this.podiscussemcee = podiscussemcee;
        this.podiscussnoter = podiscussnoter;
        this.podiscussattendname = podiscussattendname;
        this.podiscussattendeename = podiscussattendeename;
        this.podiscussaffixname = podiscussaffixname;
        this.podiscussrecored = podiscussrecored;
        this.disobeyitem = disobeyitem;
        this.confirmtruth = confirmtruth;
        this.podiscussadress = podiscussadress;
        this.podiscussresult = podiscussresult;
        this.enregisterdate = enregisterdate;
        this.podiscussstep = podiscussstep;
    }

    public Podiscussbasic(PodiscussbasicId cid, Date podiscussbegintime,
            Date podiscussendtime, String podiscussemcee,
            String podiscussnoter, String podiscussattendname,
            String podiscussattendeename, String podiscussaffixname,
            String disobeyitem, String confirmtruth, String podiscussadress,
            String podiscussresult, Date enregisterdate, Long podiscussstep,
            String enregisterid) {
        super();
        this.cid = cid;
        this.podiscussbegintime = podiscussbegintime;
        this.podiscussendtime = podiscussendtime;
        this.podiscussemcee = podiscussemcee;
        this.podiscussnoter = podiscussnoter;
        this.podiscussattendname = podiscussattendname;
        this.podiscussattendeename = podiscussattendeename;
        this.podiscussaffixname = podiscussaffixname;
        this.disobeyitem = disobeyitem;
        this.confirmtruth = confirmtruth;
        this.podiscussadress = podiscussadress;
        this.podiscussresult = podiscussresult;
        this.enregisterdate = enregisterdate;
        this.podiscussstep = podiscussstep;
        this.enregisterid = enregisterid;
    }

    public Podiscussbasic(PodiscussbasicId cid, Date podiscussbegintime,
            Date podiscussendtime, String podiscussemcee,
            String podiscussnoter, String podiscussattendname,
            String podiscussattendeename, String podiscussaffixname,
            byte[] podiscussrecored, String disobeyitem, String confirmtruth,
            String podiscussadress, String podiscussresult,
            Date enregisterdate, Long podiscussstep, String enregisterid) {
        super();
        this.cid = cid;
        this.podiscussbegintime = podiscussbegintime;
        this.podiscussendtime = podiscussendtime;
        this.podiscussemcee = podiscussemcee;
        this.podiscussnoter = podiscussnoter;
        this.podiscussattendname = podiscussattendname;
        this.podiscussattendeename = podiscussattendeename;
        this.podiscussaffixname = podiscussaffixname;
        this.podiscussrecored = podiscussrecored;
        this.disobeyitem = disobeyitem;
        this.confirmtruth = confirmtruth;
        this.podiscussadress = podiscussadress;
        this.podiscussresult = podiscussresult;
        this.enregisterdate = enregisterdate;
        this.podiscussstep = podiscussstep;
        this.enregisterid = enregisterid;
    }

    public PodiscussbasicId getCid() {
        return this.cid;
    }

    public void setCid(PodiscussbasicId id) {
        this.cid = id;
    }

    public String getPunishobjectid() {
        if (this.cid == null)
            this.cid = new PodiscussbasicId();
        return this.cid.getPunishobjectid();
    }

    public void setPunishobjectid(String punishobjectid) {
        if (this.cid == null)
            this.cid = new PodiscussbasicId();
        this.cid.setPunishobjectid(punishobjectid);
    }

    public Long getPodiscusstype() {
        if (this.cid == null)
            this.cid = new PodiscussbasicId();
        return this.cid.getPodiscusstype();
    }

    public void setPodiscusstype(Long podiscusstype) {
        if (this.cid == null)
            this.cid = new PodiscussbasicId();
        this.cid.setPodiscusstype(podiscusstype);
    }

    // Property accessors

    public Date getPodiscussbegintime() {
        if (this.podiscussbegintime == null) {
            this.podiscussbegintime = new Date(System.currentTimeMillis());
        }
        return this.podiscussbegintime;
    }

    public void setPodiscussbegintime(Date podiscussbegintime) {
        this.podiscussbegintime = podiscussbegintime;
    }

    public Date getPodiscussendtime() {
        if (this.podiscussbegintime == null) {
            this.podiscussbegintime = new Date(System.currentTimeMillis());
        }
        return this.podiscussendtime;
    }

    public void setPodiscussendtime(Date podiscussendtime) {
        this.podiscussendtime = podiscussendtime;
    }

    public String getPodiscussemcee() {
        return this.podiscussemcee;
    }

    public void setPodiscussemcee(String podiscussemcee) {
        this.podiscussemcee = podiscussemcee;
    }

    public String getPodiscussnoter() {
        return this.podiscussnoter;
    }

    public void setPodiscussnoter(String podiscussnoter) {
        this.podiscussnoter = podiscussnoter;
    }

    public String getPodiscussattendname() {
        return this.podiscussattendname;
    }

    public void setPodiscussattendname(String podiscussattendname) {
        this.podiscussattendname = podiscussattendname;
    }

    public String getPodiscussattendeename() {
        return this.podiscussattendeename;
    }

    public void setPodiscussattendeename(String podiscussattendeename) {
        this.podiscussattendeename = podiscussattendeename;
    }

    public String getPodiscussaffixname() {
        return this.podiscussaffixname;
    }

    public void setPodiscussaffixname(String podiscussaffixname) {
        this.podiscussaffixname = podiscussaffixname;
    }

    public byte[] getPodiscussrecored() {
        return this.podiscussrecored;
    }

    public void setPodiscussrecored(byte[] podiscussrecored) {
        this.podiscussrecored = podiscussrecored;
    }

    public String getDisobeyitem() {
        return this.disobeyitem;
    }

    public void setDisobeyitem(String disobeyitem) {
        this.disobeyitem = disobeyitem;
    }

    public String getConfirmtruth() {
        return this.confirmtruth;
    }

    public void setConfirmtruth(String confirmtruth) {
        this.confirmtruth = confirmtruth;
    }

    public String getPodiscussadress() {
        return this.podiscussadress;
    }

    public void setPodiscussadress(String podiscussadress) {
        this.podiscussadress = podiscussadress;
    }

    public String getPodiscussresult() {
        return this.podiscussresult;
    }

    public void setPodiscussresult(String podiscussresult) {
        this.podiscussresult = podiscussresult;
    }

    public Date getEnregisterdate() {
        return this.enregisterdate;
    }

    public String getEnregisterid() {
        return enregisterid;
    }

    public void setEnregisterid(String enregisterid) {
        this.enregisterid = enregisterid;
    }

    public void setEnregisterdate(Date enregisterdate) {
        this.enregisterdate = enregisterdate;
    }

    public Long getPodiscussstep() {
        return this.podiscussstep;
    }

    public void setPodiscussstep(Long podiscussstep) {
        this.podiscussstep = podiscussstep;
    }

    public void copy(Podiscussbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());
        this.setPodiscusstype(other.getPodiscusstype());

        this.podiscussbegintime = other.getPodiscussbegintime();
        this.podiscussendtime = other.getPodiscussendtime();
        this.podiscussemcee = other.getPodiscussemcee();
        this.podiscussnoter = other.getPodiscussnoter();
        this.podiscussattendname = other.getPodiscussattendname();
        this.podiscussattendeename = other.getPodiscussattendeename();
        this.podiscussaffixname = other.getPodiscussaffixname();
        this.podiscussrecored = other.getPodiscussrecored();
        this.disobeyitem = other.getDisobeyitem();
        this.confirmtruth = other.getConfirmtruth();
        this.podiscussadress = other.getPodiscussadress();
        this.podiscussresult = other.getPodiscussresult();
        this.enregisterdate = other.getEnregisterdate();
        this.podiscussstep = other.getPodiscussstep();

    }

    public void copyNotNullProperty(Podiscussbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());
        if (other.getPodiscusstype() != null)
            this.setPodiscusstype(other.getPodiscusstype());

        if (other.getPodiscussbegintime() != null)
            this.podiscussbegintime = other.getPodiscussbegintime();
        if (other.getPodiscussendtime() != null)
            this.podiscussendtime = other.getPodiscussendtime();
        if (other.getPodiscussemcee() != null)
            this.podiscussemcee = other.getPodiscussemcee();
        if (other.getPodiscussnoter() != null)
            this.podiscussnoter = other.getPodiscussnoter();
        if (other.getPodiscussattendname() != null)
            this.podiscussattendname = other.getPodiscussattendname();
        if (other.getPodiscussattendeename() != null)
            this.podiscussattendeename = other.getPodiscussattendeename();
        if (other.getPodiscussaffixname() != null)
            this.podiscussaffixname = other.getPodiscussaffixname();
        if (other.getPodiscussrecored() != null)
            this.podiscussrecored = other.getPodiscussrecored();
        if (other.getDisobeyitem() != null)
            this.disobeyitem = other.getDisobeyitem();
        if (other.getConfirmtruth() != null)
            this.confirmtruth = other.getConfirmtruth();
        if (other.getPodiscussadress() != null)
            this.podiscussadress = other.getPodiscussadress();
        if (other.getPodiscussresult() != null)
            this.podiscussresult = other.getPodiscussresult();
        if (other.getEnregisterdate() != null)
            this.enregisterdate = other.getEnregisterdate();
        if (other.getPodiscussstep() != null)
            this.podiscussstep = other.getPodiscussstep();

    }

    public void clearProperties() {

        this.podiscussbegintime = null;
        this.podiscussendtime = null;
        this.podiscussemcee = null;
        this.podiscussnoter = null;
        this.podiscussattendname = null;
        this.podiscussattendeename = null;
        this.podiscussaffixname = null;
        this.podiscussrecored = null;
        this.disobeyitem = null;
        this.confirmtruth = null;
        this.podiscussadress = null;
        this.podiscussresult = null;
        this.enregisterdate = null;
        this.podiscussstep = null;

    }

    public String getVersion() {
        if (StringUtils.isNotBlank(version)) {
            version = "0";
        }
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

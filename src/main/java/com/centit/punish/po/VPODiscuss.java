package com.centit.punish.po;

import java.util.Date;

/**
 * TODO Class description should be added
 * 
 * @author hx
 * 
 */
public class VPODiscuss implements java.io.Serializable {
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
    private String isSurpass;// 处罚决定是否超过自由裁量标准：0:没有超越；1:超越
    private Long punish_heavy;

    public VPODiscuss() {
        super();
    }

    public VPODiscuss(PodiscussbasicId cid) {
        super();
        this.cid = cid;
    }

    public VPODiscuss(PodiscussbasicId cid, Date podiscussbegintime,
            Date podiscussendtime, String podiscussemcee,
            String podiscussnoter, String podiscussattendname,
            String podiscussattendeename, String podiscussaffixname,
            byte[] podiscussrecored, String disobeyitem, String confirmtruth,
            String podiscussadress, String podiscussresult,
            Date enregisterdate, String isSurpass) {
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
        this.isSurpass = isSurpass;
    }

    public PodiscussbasicId getCid() {
        return cid;
    }

    public void setCid(PodiscussbasicId cid) {
        this.cid = cid;
    }

    public Date getPodiscussbegintime() {
        return podiscussbegintime;
    }

    public void setPodiscussbegintime(Date podiscussbegintime) {
        this.podiscussbegintime = podiscussbegintime;
    }

    public Date getPodiscussendtime() {
        return podiscussendtime;
    }

    public void setPodiscussendtime(Date podiscussendtime) {
        this.podiscussendtime = podiscussendtime;
    }

    public String getPodiscussemcee() {
        return podiscussemcee;
    }

    public void setPodiscussemcee(String podiscussemcee) {
        this.podiscussemcee = podiscussemcee;
    }

    public String getPodiscussnoter() {
        return podiscussnoter;
    }

    public void setPodiscussnoter(String podiscussnoter) {
        this.podiscussnoter = podiscussnoter;
    }

    public String getPodiscussattendname() {
        return podiscussattendname;
    }

    public void setPodiscussattendname(String podiscussattendname) {
        this.podiscussattendname = podiscussattendname;
    }

    public String getPodiscussattendeename() {
        return podiscussattendeename;
    }

    public void setPodiscussattendeename(String podiscussattendeename) {
        this.podiscussattendeename = podiscussattendeename;
    }

    public String getPodiscussaffixname() {
        return podiscussaffixname;
    }

    public void setPodiscussaffixname(String podiscussaffixname) {
        this.podiscussaffixname = podiscussaffixname;
    }

    public byte[] getPodiscussrecored() {
        return podiscussrecored;
    }

    public void setPodiscussrecored(byte[] podiscussrecored) {
        this.podiscussrecored = podiscussrecored;
    }

    public String getDisobeyitem() {
        return disobeyitem;
    }

    public void setDisobeyitem(String disobeyitem) {
        this.disobeyitem = disobeyitem;
    }

    public String getConfirmtruth() {
        return confirmtruth;
    }

    public void setConfirmtruth(String confirmtruth) {
        this.confirmtruth = confirmtruth;
    }

    public String getPodiscussadress() {
        return podiscussadress;
    }

    public void setPodiscussadress(String podiscussadress) {
        this.podiscussadress = podiscussadress;
    }

    public String getPodiscussresult() {
        return podiscussresult;
    }

    public void setPodiscussresult(String podiscussresult) {
        this.podiscussresult = podiscussresult;
    }

    public Date getEnregisterdate() {
        return enregisterdate;
    }

    public void setEnregisterdate(Date enregisterdate) {
        this.enregisterdate = enregisterdate;
    }

    public String getIsSurpass() {
        return isSurpass;
    }

    public void setIsSurpass(String isSurpass) {
        this.isSurpass = isSurpass;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Long getPunish_heavy() {
        return punish_heavy;
    }

    public void setPunish_heavy(Long punish_heavy) {
        this.punish_heavy = punish_heavy;
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

    public VPODiscuss(PodiscussbasicId cid, Date podiscussbegintime,
            Date podiscussendtime, String podiscussemcee,
            String podiscussnoter, String podiscussattendname,
            String podiscussattendeename, String podiscussaffixname,
            byte[] podiscussrecored, String disobeyitem, String confirmtruth,
            String podiscussadress, String podiscussresult,
            Date enregisterdate, String isSurpass, Long punish_heavy) {
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
        this.isSurpass = isSurpass;
        this.punish_heavy = punish_heavy;
    }

    public void copy(VPODiscuss other) {

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
        this.isSurpass = other.getIsSurpass();
        this.punish_heavy = other.getPunish_heavy();
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
        this.isSurpass = null;
        this.punish_heavy = null;

    }

    public void copyNotNullProperty(VPODiscuss other) {

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
        if (other.getIsSurpass() != null)
            this.isSurpass = other.getIsSurpass();
        if (other.getPunish_heavy() != null)
            this.punish_heavy = other.getPunish_heavy();

    }
}

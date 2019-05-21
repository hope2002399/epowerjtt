package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Pofinishbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishobjectid;

    private String disobeyitem;
    private String confirmtruth;
    private String podiscussresult;
    private Double punishamout;
    private String otherpunish;
    private String finishType;
    private Integer punishamoutpeople;
    private Long punishseizure;
    private Double punishseizurevalue;
    private Long punishshoutont;
    private Integer punishdetentionpeople;
    private Long punishdetention;
    private Long isfinish;
    private String punishaffixname;
    private byte[] punishaffixdoc;
    private String punishaffixcode;
    private Long pofinishstep;

    private String jbrja;
    private String ksja;
    private String fzrja;
    private String jbroptionja;
    private String ksoptionja;
    private String fzroptionja;
    private Date jbroptionjatime;
    private Date ksoptionjatime;
    private Date fzroptionjatime;

    // Constructors
    /** default constructor */
    public Pofinishbasic() {
    }

    /** minimal constructor */
    public Pofinishbasic(String punishobjectid, Long pofinishstep) {

        this.punishobjectid = punishobjectid;

        this.pofinishstep = pofinishstep;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** full constructor */
    public Pofinishbasic(String punishobjectid, String disobeyitem,
            String confirmtruth, String podiscussresult, Double punishamout,
            String otherpunish, Integer punishamoutpeople, Long punishseizure,
            Double punishseizurevalue, Long punishshoutont,
            Integer punishdetentionpeople, Long punishdetention, Long isfinish,
            String punishaffixname, byte[] punishaffixdoc,
            String punishaffixcode, Long pofinishstep) {

        this.punishobjectid = punishobjectid;

        this.disobeyitem = disobeyitem;
        this.confirmtruth = confirmtruth;
        this.podiscussresult = podiscussresult;
        this.punishamout = punishamout;
        this.otherpunish = otherpunish;
        this.punishamoutpeople = punishamoutpeople;
        this.punishseizure = punishseizure;
        this.punishseizurevalue = punishseizurevalue;
        this.punishshoutont = punishshoutont;
        this.punishdetentionpeople = punishdetentionpeople;
        this.punishdetention = punishdetention;
        this.isfinish = isfinish;
        this.punishaffixname = punishaffixname;
        this.punishaffixdoc = punishaffixdoc;
        this.punishaffixcode = punishaffixcode;
        this.pofinishstep = pofinishstep;
    }

    public Pofinishbasic(String punishobjectid, String disobeyitem,
            String confirmtruth, String podiscussresult, Double punishamout,
            String otherpunish, Integer punishamoutpeople, Long punishseizure,
            Double punishseizurevalue, Long punishshoutont,
            Integer punishdetentionpeople, Long punishdetention, Long isfinish,
            String punishaffixname, byte[] punishaffixdoc,
            String punishaffixcode, Long pofinishstep, String jbrja,
            String ksja, String fzrja, String jbroptionja, String ksoptionja,
            String fzroptionja, Date jbroptionjatime, Date ksoptionjatime,
            Date fzroptionjatime) {
        super();
        this.punishobjectid = punishobjectid;
        this.disobeyitem = disobeyitem;
        this.confirmtruth = confirmtruth;
        this.podiscussresult = podiscussresult;
        this.punishamout = punishamout;
        this.otherpunish = otherpunish;
        this.punishamoutpeople = punishamoutpeople;
        this.punishseizure = punishseizure;
        this.punishseizurevalue = punishseizurevalue;
        this.punishshoutont = punishshoutont;
        this.punishdetentionpeople = punishdetentionpeople;
        this.punishdetention = punishdetention;
        this.isfinish = isfinish;
        this.punishaffixname = punishaffixname;
        this.punishaffixdoc = punishaffixdoc;
        this.punishaffixcode = punishaffixcode;
        this.pofinishstep = pofinishstep;
        this.jbrja = jbrja;
        this.ksja = ksja;
        this.fzrja = fzrja;
        this.jbroptionja = jbroptionja;
        this.ksoptionja = ksoptionja;
        this.fzroptionja = fzroptionja;
        this.jbroptionjatime = jbroptionjatime;
        this.ksoptionjatime = ksoptionjatime;
        this.fzroptionjatime = fzroptionjatime;
    }

    public Pofinishbasic(String punishobjectid, String disobeyitem,
            String confirmtruth, String podiscussresult, Double punishamout,
            String otherpunish, String finishType, Integer punishamoutpeople,
            Long punishseizure, Double punishseizurevalue, Long punishshoutont,
            Integer punishdetentionpeople, Long punishdetention, Long isfinish,
            String punishaffixname, byte[] punishaffixdoc,
            String punishaffixcode, Long pofinishstep, String jbrja,
            String ksja, String fzrja, String jbroptionja, String ksoptionja,
            String fzroptionja, Date jbroptionjatime, Date ksoptionjatime,
            Date fzroptionjatime) {
        super();
        this.punishobjectid = punishobjectid;
        this.disobeyitem = disobeyitem;
        this.confirmtruth = confirmtruth;
        this.podiscussresult = podiscussresult;
        this.punishamout = punishamout;
        this.otherpunish = otherpunish;
        this.finishType = finishType;
        this.punishamoutpeople = punishamoutpeople;
        this.punishseizure = punishseizure;
        this.punishseizurevalue = punishseizurevalue;
        this.punishshoutont = punishshoutont;
        this.punishdetentionpeople = punishdetentionpeople;
        this.punishdetention = punishdetention;
        this.isfinish = isfinish;
        this.punishaffixname = punishaffixname;
        this.punishaffixdoc = punishaffixdoc;
        this.punishaffixcode = punishaffixcode;
        this.pofinishstep = pofinishstep;
        this.jbrja = jbrja;
        this.ksja = ksja;
        this.fzrja = fzrja;
        this.jbroptionja = jbroptionja;
        this.ksoptionja = ksoptionja;
        this.fzroptionja = fzroptionja;
        this.jbroptionjatime = jbroptionjatime;
        this.ksoptionjatime = ksoptionjatime;
        this.fzroptionjatime = fzroptionjatime;
    }

    public String getJbrja() {
        return jbrja;
    }

    public void setJbrja(String jbrja) {
        this.jbrja = jbrja;
    }

    public String getKsja() {
        return ksja;
    }

    public void setKsja(String ksja) {
        this.ksja = ksja;
    }

    public String getFzrja() {
        return fzrja;
    }

    public void setFzrja(String fzrja) {
        this.fzrja = fzrja;
    }

    public String getJbroptionja() {
        return jbroptionja;
    }

    public void setJbroptionja(String jbroptionja) {
        this.jbroptionja = jbroptionja;
    }

    public String getKsoptionja() {
        return ksoptionja;
    }

    public void setKsoptionja(String ksoptionja) {
        this.ksoptionja = ksoptionja;
    }

    public String getFzroptionja() {
        return fzroptionja;
    }

    public void setFzroptionja(String fzroptionja) {
        this.fzroptionja = fzroptionja;
    }

    public Date getJbroptionjatime() {
        return jbroptionjatime;
    }

    public void setJbroptionjatime(Date jbroptionjatime) {
        this.jbroptionjatime = jbroptionjatime;
    }

    public Date getKsoptionjatime() {
        return ksoptionjatime;
    }

    public void setKsoptionjatime(Date ksoptionjatime) {
        this.ksoptionjatime = ksoptionjatime;
    }

    public Date getFzroptionjatime() {
        return fzroptionjatime;
    }

    public void setFzroptionjatime(Date fzroptionjatime) {
        this.fzroptionjatime = fzroptionjatime;
    }

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    // Property accessors

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

    public String getPodiscussresult() {
        return this.podiscussresult;
    }

    public void setPodiscussresult(String podiscussresult) {
        this.podiscussresult = podiscussresult;
    }

    public Double getPunishamout() {
        if (punishamout == null) {
            this.punishamout = -1.00;
        }
        return this.punishamout;
    }

    public void setPunishamout(Double punishamout) {
        this.punishamout = punishamout;
    }

    public String getOtherpunish() {
        return this.otherpunish;
    }

    public void setOtherpunish(String otherpunish) {
        this.otherpunish = otherpunish;
    }

    public Integer getPunishamoutpeople() {
        if (punishamoutpeople == null) {
            this.punishamoutpeople = -1;
        }
        return this.punishamoutpeople;
    }

    public void setPunishamoutpeople(Integer punishamoutpeople) {
        this.punishamoutpeople = punishamoutpeople;
    }

    public Long getPunishseizure() {
        if (punishseizure == null) {
            this.punishseizure = (long) -1;
        }
        return this.punishseizure;
    }

    public void setPunishseizure(Long punishseizure) {
        this.punishseizure = punishseizure;
    }

    public Double getPunishseizurevalue() {
        if (punishseizurevalue == null) {
            this.punishseizurevalue = -1.00;
        }
        return this.punishseizurevalue;
    }

    public void setPunishseizurevalue(Double punishseizurevalue) {
        this.punishseizurevalue = punishseizurevalue;
    }

    public Long getPunishshoutont() {
        if (punishshoutont == null) {
            this.punishshoutont = (long) -1;
        }
        return this.punishshoutont;
    }

    public void setPunishshoutont(Long punishshoutont) {
        this.punishshoutont = punishshoutont;
    }

    public Integer getPunishdetentionpeople() {
        if (punishdetentionpeople == null) {
            this.punishdetentionpeople = -1;
        }
        return this.punishdetentionpeople;
    }

    public void setPunishdetentionpeople(Integer punishdetentionpeople) {
        this.punishdetentionpeople = punishdetentionpeople;
    }

    public Long getPunishdetention() {
        if (punishdetention == null) {
            this.punishdetention = (long) -1;
        }
        return this.punishdetention;
    }

    public void setPunishdetention(Long punishdetention) {
        this.punishdetention = punishdetention;
    }

    public Long getIsfinish() {
        if (isfinish == null) {
            this.isfinish = (long) 0;
        }
        return this.isfinish;
    }

    public void setIsfinish(Long isfinish) {
        this.isfinish = isfinish;
    }

    public String getPunishaffixname() {
        return this.punishaffixname;
    }

    public void setPunishaffixname(String punishaffixname) {
        this.punishaffixname = punishaffixname;
    }

    public byte[] getPunishaffixdoc() {
        return this.punishaffixdoc;
    }

    public void setPunishaffixdoc(byte[] punishaffixdoc) {
        this.punishaffixdoc = punishaffixdoc;
    }

    public String getPunishaffixcode() {
        return this.punishaffixcode;
    }

    public void setPunishaffixcode(String punishaffixcode) {
        this.punishaffixcode = punishaffixcode;
    }

    public Long getPofinishstep() {
        return this.pofinishstep;
    }

    public void setPofinishstep(Long pofinishstep) {
        this.pofinishstep = pofinishstep;
    }

    public String getFinishType() {
        return finishType;
    }

    public void setFinishType(String finishType) {
        this.finishType = finishType;
    }

    public void copy(Pofinishbasic other) {

        this.setPunishobjectid(other.getPunishobjectid());

        this.disobeyitem = other.getDisobeyitem();
        this.confirmtruth = other.getConfirmtruth();
        this.podiscussresult = other.getPodiscussresult();
        this.punishamout = other.getPunishamout();
        this.otherpunish = other.getOtherpunish();
        this.punishamoutpeople = other.getPunishamoutpeople();
        this.punishseizure = other.getPunishseizure();
        this.punishseizurevalue = other.getPunishseizurevalue();
        this.punishshoutont = other.getPunishshoutont();
        this.punishdetentionpeople = other.getPunishdetentionpeople();
        this.punishdetention = other.getPunishdetention();
        this.isfinish = other.getIsfinish();
        this.punishaffixname = other.getPunishaffixname();
        this.punishaffixdoc = other.getPunishaffixdoc();
        this.punishaffixcode = other.getPunishaffixcode();
        this.pofinishstep = other.getPofinishstep();
        this.finishType = other.getFinishType();
        this.jbrja = other.getJbrja();
        this.jbroptionja = other.getJbroptionja();
        this.jbroptionjatime = other.getJbroptionjatime();
        this.ksja = other.getKsja();
        this.ksoptionja = other.getKsoptionja();
        this.ksoptionjatime = other.getKsoptionjatime();
        this.fzrja = other.getFzrja();
        this.fzroptionja = other.getFzroptionja();
        this.fzroptionjatime = other.getFzroptionjatime();
    }

    public void copyNotNullProperty(Pofinishbasic other) {

        if (other.getPunishobjectid() != null)
            this.setPunishobjectid(other.getPunishobjectid());

        if (other.getDisobeyitem() != null)
            this.disobeyitem = other.getDisobeyitem();
        if (other.getConfirmtruth() != null)
            this.confirmtruth = other.getConfirmtruth();
        if (other.getPodiscussresult() != null)
            this.podiscussresult = other.getPodiscussresult();
        if (other.getPunishamout() > 0)
            this.punishamout = other.getPunishamout();
        if (other.getOtherpunish() != null)
            this.otherpunish = other.getOtherpunish();
        if (other.getPunishamoutpeople() > 0)
            this.punishamoutpeople = other.getPunishamoutpeople();
        if (other.getPunishseizure() > 0)
            this.punishseizure = other.getPunishseizure();
        if (other.getPunishseizurevalue() > 0)
            this.punishseizurevalue = other.getPunishseizurevalue();
        if (other.getPunishshoutont() > 0)
            this.punishshoutont = other.getPunishshoutont();
        if (other.getPunishdetentionpeople() > 0)
            this.punishdetentionpeople = other.getPunishdetentionpeople();
        if (other.getPunishdetention() > 0)
            this.punishdetention = other.getPunishdetention();
        if (other.getIsfinish() != null)
            this.isfinish = other.getIsfinish();
        if (other.getPunishaffixname() != null)
            this.punishaffixname = other.getPunishaffixname();
        if (other.getPunishaffixdoc() != null)
            this.punishaffixdoc = other.getPunishaffixdoc();
        if (other.getPunishaffixcode() != null)
            this.punishaffixcode = other.getPunishaffixcode();
        if (other.getPofinishstep() != null)
            this.pofinishstep = other.getPofinishstep();
        if (other.getFinishType() != null)
            this.finishType = other.getFinishType();

        if (other.getJbrja() != null)
            this.jbrja = other.getJbrja();
        if (other.getJbroptionja() != null)
            this.jbroptionja = other.getJbroptionja();
        if (other.getJbroptionjatime() != null)
            this.jbroptionjatime = other.getJbroptionjatime();
        if (other.getKsja() != null)
            this.ksja = other.getKsja();
        if (other.getKsoptionja() != null)
            this.ksoptionja = other.getKsoptionja();
        if (other.getKsoptionjatime() != null)
            this.ksoptionjatime = other.getKsoptionjatime();
        if (other.getFzrja() != null)
            this.fzrja = other.getFzrja();
        if (other.getFzroptionja() != null)
            this.fzroptionja = other.getFzroptionja();
        if (other.getFzroptionjatime() != null)
            this.fzroptionjatime = other.getFzroptionjatime();
    }

    public void clearProperties() {

        this.disobeyitem = null;
        this.confirmtruth = null;
        this.podiscussresult = null;
        this.punishamout = null;
        this.otherpunish = null;
        this.punishamoutpeople = null;
        this.punishseizure = null;
        this.punishseizurevalue = null;
        this.punishshoutont = null;
        this.punishdetentionpeople = null;
        this.punishdetention = null;
        this.isfinish = null;
        this.punishaffixname = null;
        this.punishaffixdoc = null;
        this.punishaffixcode = null;
        this.pofinishstep = null;
        this.finishType = null;
        this.jbrja = null;
        this.jbroptionja = null;
        this.jbroptionjatime = null;
        this.ksja = null;
        this.ksoptionja = null;
        this.ksoptionjatime = null;
        this.fzrja = null;
        this.fzroptionja = null;
        this.fzroptionjatime = null;
    }
}

package com.centit.punish.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Pomovebackbasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long sortno;

    private String punishobjectid;
    private Long stepworkid;
    private String beginapprovecode;
    private String endapprovecode;
    private Date movebackdate;
    private Long operatorid;
    private String movebackcontent;

    // Constructors
    /** default constructor */
    public Pomovebackbasic() {
    }

    /** minimal constructor */
    public Pomovebackbasic(Long sortno) {

        this.sortno = sortno;

    }

    /** full constructor */
    public Pomovebackbasic(Long sortno, String punishobjectid, Long stepworkid,
            String beginapprovecode, String endapprovecode, Date movebackdate,
            Long operatorid, String movebackcontent) {

        this.sortno = sortno;

        this.punishobjectid = punishobjectid;
        this.stepworkid = stepworkid;
        this.beginapprovecode = beginapprovecode;
        this.endapprovecode = endapprovecode;
        this.movebackdate = movebackdate;
        this.operatorid = operatorid;
        this.movebackcontent = movebackcontent;
    }

    public Long getSortno() {
        return this.sortno;
    }

    public void setSortno(Long sortno) {
        this.sortno = sortno;
    }

    // Property accessors

    public String getPunishobjectid() {
        return this.punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public Long getStepworkid() {
        return this.stepworkid;
    }

    public void setStepworkid(Long stepworkid) {
        this.stepworkid = stepworkid;
    }

    public String getBeginapprovecode() {
        return this.beginapprovecode;
    }

    public void setBeginapprovecode(String beginapprovecode) {
        this.beginapprovecode = beginapprovecode;
    }

    public String getEndapprovecode() {
        return this.endapprovecode;
    }

    public void setEndapprovecode(String endapprovecode) {
        this.endapprovecode = endapprovecode;
    }

    public Date getMovebackdate() {
        return this.movebackdate;
    }

    public void setMovebackdate(Date movebackdate) {
        this.movebackdate = movebackdate;
    }

    public Long getOperatorid() {
        return this.operatorid;
    }

    public void setOperatorid(Long operatorid) {
        this.operatorid = operatorid;
    }

    public String getMovebackcontent() {
        return this.movebackcontent;
    }

    public void setMovebackcontent(String movebackcontent) {
        this.movebackcontent = movebackcontent;
    }

    public void copy(Pomovebackbasic other) {

        this.setSortno(other.getSortno());

        this.punishobjectid = other.getPunishobjectid();
        this.stepworkid = other.getStepworkid();
        this.beginapprovecode = other.getBeginapprovecode();
        this.endapprovecode = other.getEndapprovecode();
        this.movebackdate = other.getMovebackdate();
        this.operatorid = other.getOperatorid();
        this.movebackcontent = other.getMovebackcontent();

    }

    public void copyNotNullProperty(Pomovebackbasic other) {

        if (other.getSortno() != null)
            this.setSortno(other.getSortno());

        if (other.getPunishobjectid() != null)
            this.punishobjectid = other.getPunishobjectid();
        if (other.getStepworkid() != null)
            this.stepworkid = other.getStepworkid();
        if (other.getBeginapprovecode() != null)
            this.beginapprovecode = other.getBeginapprovecode();
        if (other.getEndapprovecode() != null)
            this.endapprovecode = other.getEndapprovecode();
        if (other.getMovebackdate() != null)
            this.movebackdate = other.getMovebackdate();
        if (other.getOperatorid() != null)
            this.operatorid = other.getOperatorid();
        if (other.getMovebackcontent() != null)
            this.movebackcontent = other.getMovebackcontent();

    }

    public void clearProperties() {

        this.punishobjectid = null;
        this.stepworkid = null;
        this.beginapprovecode = null;
        this.endapprovecode = null;
        this.movebackdate = null;
        this.operatorid = null;
        this.movebackcontent = null;

    }
}

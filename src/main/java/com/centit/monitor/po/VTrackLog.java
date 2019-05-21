package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VTrackLog implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String trackno;
    private String no;
    private String powertype;
    private String internalNoAj;
    private String internalNoBj;
    private String orgIdBj;
    private String orgIdAj;
    private String itemIdAj;
    private String itemIdBj;
    private String punishTarget;
    private String isRiskAj;
    private String isRiskBj;
    private String tracktype;
    private Date tracktime;
    private String trackoperator;
    private String trackreason;
    private Date untracktime;
    private String untrackoperator;
    private String untrackreason;
    private String topunitcode;
    private String transactAffairName;
    private String itemtype;

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getTransactAffairName() {
        return transactAffairName;
    }

    public void setTransactAffairName(String transactAffairName) {
        this.transactAffairName = transactAffairName;
    }

    // Constructors
    /** default constructor */
    public VTrackLog() {
    }

    /** minimal constructor */
    public VTrackLog(String trackno, String no, String powertype,
            String internalNoAj, String internalNoBj, String orgIdAj,
            String orgIdBj, String itemIdAj, String itemIdBj,
            String punishTarget, String isRiskAj, String isRiskBj,
            Date tracktime, String trackoperator, String trackreason,
            Date untracktime, String untrackoperator, String untrackreason,
            String tracktype, String topunitcode) {
        this.trackno = trackno;
        this.no = no;
        this.powertype = powertype;

        this.internalNoAj = internalNoAj;
        this.internalNoBj = internalNoBj;
        this.orgIdAj = orgIdAj;
        this.orgIdBj = orgIdBj;
        this.itemIdAj = itemIdAj;
        this.itemIdBj = itemIdBj;
        this.punishTarget = punishTarget;
        this.isRiskAj = isRiskAj;
        this.isRiskBj = isRiskBj;
        this.tracktype = tracktype;
        this.tracktime = tracktime;
        this.trackoperator = trackoperator;
        this.trackreason = trackreason;
        this.untracktime = untracktime;
        this.untrackoperator = untrackoperator;
        this.untrackreason = untrackreason;
        this.topunitcode = topunitcode;
    }

    public String getTopunitcode() {
        return topunitcode;
    }

    public void setTopunitcode(String topunitcode) {
        this.topunitcode = topunitcode;
    }

    public String getIsRiskAj() {
        return isRiskAj;
    }

    public void setIsRiskAj(String isRiskAj) {
        this.isRiskAj = isRiskAj;
    }

    public String getIsRiskBj() {
        return isRiskBj;
    }

    public void setIsRiskBj(String isRiskBj) {
        this.isRiskBj = isRiskBj;
    }

    public String getTrackno() {
        return this.trackno;
    }

    public void setTrackno(String trackno) {
        this.trackno = trackno;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPowertype() {
        return this.powertype;
    }

    public void setPowertype(String powertype) {
        this.powertype = powertype;
    }

    public Date getTracktime() {
        return this.tracktime;
    }

    public void setTracktime(Date tracktime) {
        this.tracktime = tracktime;
    }

    public String getInternalNoAj() {
        return internalNoAj;
    }

    public void setInternalNoAj(String internalNoAj) {
        this.internalNoAj = internalNoAj;
    }

    public String getInternalNoBj() {
        return internalNoBj;
    }

    public void setInternalNoBj(String internalNoBj) {
        this.internalNoBj = internalNoBj;
    }

    public String getOrgIdBj() {
        return orgIdBj;
    }

    public void setOrgIdBj(String orgIdBj) {
        this.orgIdBj = orgIdBj;
    }

    public String getOrgIdAj() {
        return orgIdAj;
    }

    public void setOrgIdAj(String orgIdAj) {
        this.orgIdAj = orgIdAj;
    }

    public String getItemIdAj() {
        return itemIdAj;
    }

    public void setItemIdAj(String itemIdAj) {
        this.itemIdAj = itemIdAj;
    }

    public String getItemIdBj() {
        return itemIdBj;
    }

    public void setItemIdBj(String itemIdBj) {
        this.itemIdBj = itemIdBj;
    }

    public String getPunishTarget() {
        return punishTarget;
    }

    public void setPunishTarget(String punishTarget) {
        this.punishTarget = punishTarget;
    }

    public String getTracktype() {
        return tracktype;
    }

    public void setTracktype(String tracktype) {
        this.tracktype = tracktype;
    }

    public String getTrackoperator() {
        return trackoperator;
    }

    public void setTrackoperator(String trackoperator) {
        this.trackoperator = trackoperator;
    }

    public String getTrackreason() {
        return trackreason;
    }

    public void setTrackreason(String trackreason) {
        this.trackreason = trackreason;
    }

    public Date getUntracktime() {
        return untracktime;
    }

    public void setUntracktime(Date untracktime) {
        this.untracktime = untracktime;
    }

    public String getUntrackoperator() {
        return untrackoperator;
    }

    public void setUntrackoperator(String untrackoperator) {
        this.untrackoperator = untrackoperator;
    }

    public String getUntrackreason() {
        return untrackreason;
    }

    public void setUntrackreason(String untrackreason) {
        this.untrackreason = untrackreason;
    }

    public void copy(VTrackLog other) {
        this.setTrackno(other.getTrackno());
        this.no = other.getNo();
        this.powertype = other.getPowertype();
        this.internalNoAj = other.getInternalNoAj();
        this.internalNoBj = other.getInternalNoBj();
        this.orgIdAj = other.getOrgIdAj();
        this.orgIdBj = other.getOrgIdBj();
        this.itemIdAj = other.getItemIdAj();
        this.itemIdBj = other.getItemIdBj();
        this.punishTarget = other.getPunishTarget();
        this.isRiskAj = other.getIsRiskAj();
        this.isRiskBj = other.getIsRiskBj();
        this.tracktype = other.getTracktype();
        this.tracktime = other.getTracktime();
        this.trackoperator = other.getTrackoperator();
        this.trackreason = other.getTrackreason();
        this.untracktime = other.getUntracktime();
        this.untrackoperator = other.getUntrackoperator();
        this.untrackreason = other.getUntrackreason();
        this.topunitcode = other.getTopunitcode();
    }

    public void copyNotNullProperty(VTrackLog other) {

        if (other.getTrackno() != null)
            this.setTrackno(other.getTrackno());
        if (other.getNo() != null)
            this.no = other.getNo();
        if (other.getPowertype() != null)
            this.powertype = other.getPowertype();

        if (other.getItemIdAj() != null)
            this.itemIdAj = other.getItemIdAj();
        if (other.getItemIdBj() != null)
            this.itemIdBj = other.getItemIdBj();
        if (other.getPunishTarget() != null)
            this.punishTarget = other.getPunishTarget();
        if (other.getInternalNoAj() != null)
            this.internalNoAj = other.getInternalNoAj();
        if (other.getInternalNoBj() != null)
            this.internalNoBj = other.getInternalNoBj();
        if (other.getOrgIdAj() != null)
            this.orgIdAj = other.getOrgIdAj();
        if (other.getOrgIdBj() != null)
            this.orgIdBj = other.getOrgIdBj();
        if (other.getIsRiskBj() != null)
            this.isRiskBj = other.getIsRiskBj();
        if (other.getIsRiskAj() != null)
            this.isRiskAj = other.getIsRiskAj();
        if (other.getTracktype() != null)
            this.tracktype = other.getTracktype();
        if (other.getTracktime() != null)
            this.tracktime = other.getTracktime();
        if (other.getTrackoperator() != null)
            this.trackoperator = other.getTrackoperator();
        if (other.getTrackreason() != null)
            this.trackreason = other.getTrackreason();
        if (other.getUntracktime() != null)
            this.untracktime = other.getUntracktime();
        if (other.getUntrackoperator() != null)
            this.untrackoperator = other.getUntrackoperator();
        if (other.getUntrackreason() != null)
            this.untrackreason = other.getUntrackreason();
        if (other.getTopunitcode() != null) {
            this.topunitcode = other.getTopunitcode();
        }
    }

    public void clearProperties() {
        this.no = null;
        this.powertype = null;

        this.internalNoAj = null;
        this.internalNoBj = null;
        this.orgIdAj = null;
        this.orgIdBj = null;
        this.itemIdAj = null;
        this.itemIdBj = null;
        this.punishTarget = null;
        this.isRiskAj = null;
        this.isRiskBj = null;
        this.tracktype = null;
        this.tracktime = null;
        this.trackoperator = null;
        this.trackreason = null;
        this.untracktime = null;
        this.untrackoperator = null;
        this.untrackreason = null;
        this.topunitcode = null;
    }
}

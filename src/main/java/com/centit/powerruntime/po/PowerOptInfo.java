package com.centit.powerruntime.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class PowerOptInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private PowerOptInfoId cid;

    private Long riskid;
    private String setoperator;
    private Date setime;
    private String applyItemType;
    private String group_id;
    private RiskInfo riskInfo;
    private String recordid;

    // Constructors
    /** default constructor */
    public PowerOptInfo() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /** minimal constructor */
    public PowerOptInfo(PowerOptInfoId id

    ) {
        this.cid = id;

    }

    public PowerOptInfo(PowerOptInfoId cid, Long riskid, String setoperator,
            Date setime, String applyItemType, String group_id, String recordid) {
        super();
        this.cid = cid;
        this.riskid = riskid;
        this.setoperator = setoperator;
        this.setime = setime;
        this.applyItemType = applyItemType;
        this.group_id = group_id;
        this.recordid = recordid;
    }

    public PowerOptInfo(PowerOptInfoId cid, Long riskid, String setoperator,
            Date setime, String applyItemType, String group_id,
            RiskInfo riskInfo, String recordid) {
        super();
        this.cid = cid;
        this.riskid = riskid;
        this.setoperator = setoperator;
        this.setime = setime;
        this.applyItemType = applyItemType;
        this.group_id = group_id;
        this.riskInfo = riskInfo;
        this.recordid = recordid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public RiskInfo getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(RiskInfo riskInfo) {
        this.riskInfo = riskInfo;
    }

    public PowerOptInfo(PowerOptInfoId cid, Long riskid, String setoperator,
            Date setime, String applyItemType) {
        super();
        this.cid = cid;
        this.riskid = riskid;
        this.setoperator = setoperator;
        this.setime = setime;
        this.applyItemType = applyItemType;
    }

    public String getApplyItemType() {
        return applyItemType;
    }

    public void setApplyItemType(String applyItemType) {
        this.applyItemType = applyItemType;
    }

    public PowerOptInfo(PowerOptInfoId cid, Long riskid, String setoperator,
            Date setime, String applyItemType, String group_id) {
        super();
        this.cid = cid;
        this.riskid = riskid;
        this.setoperator = setoperator;
        this.setime = setime;
        this.applyItemType = applyItemType;
        this.group_id = group_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    /** full constructor */
    public PowerOptInfo(PowerOptInfoId id

    , Long riskid, String setoperator, Date setime) {
        this.cid = id;

        this.riskid = riskid;
        this.setoperator = setoperator;
        this.setime = setime;
    }

    public PowerOptInfoId getCid() {
        return this.cid;
    }

    public void setCid(PowerOptInfoId id) {
        this.cid = id;
    }

    public String getItemId() {
        if (this.cid == null)
            this.cid = new PowerOptInfoId();
        return this.cid.getItemId();
    }

    public void setItemId(String itemId) {
        if (this.cid == null)
            this.cid = new PowerOptInfoId();
        this.cid.setItemId(itemId);
    }

    public String getWfcode() {
        if (this.cid == null)
            this.cid = new PowerOptInfoId();
        return this.cid.getWfcode();
    }

    public void setWfcode(String wfcode) {
        if (this.cid == null)
            this.cid = new PowerOptInfoId();
        this.cid.setWfcode(wfcode);
    }

    // Property accessors

    public Long getRiskid() {
        return this.riskid;
    }

    public void setRiskid(Long riskid) {
        this.riskid = riskid;
    }

    public String getSetoperator() {
        return this.setoperator;
    }

    public void setSetoperator(String setoperator) {
        this.setoperator = setoperator;
    }

    public Date getSetime() {
        return this.setime;
    }

    public void setSetime(Date setime) {
        this.setime = setime;
    }

    public void copy(PowerOptInfo other) {

        this.setItemId(other.getItemId());
        this.setWfcode(other.getWfcode());

        this.riskid = other.getRiskid();
        this.setoperator = other.getSetoperator();
        this.setime = other.getSetime();
        this.applyItemType = other.getApplyItemType();
        this.group_id = other.getGroup_id();
        this.recordid = other.getRecordid();

    }

    public void copyNotNullProperty(PowerOptInfo other) {

        if (other.getItemId() != null)
            this.setItemId(other.getItemId());
        if (other.getWfcode() != null)
            this.setWfcode(other.getWfcode());

        if (other.getRiskid() != null)
            this.riskid = other.getRiskid();
        if (other.getSetoperator() != null)
            this.setoperator = other.getSetoperator();
        if (other.getSetime() != null)
            this.setime = other.getSetime();
        if (other.getApplyItemType() != null)
            this.applyItemType = other.getApplyItemType();
        if (other.getGroup_id() != null)
            this.group_id = other.getGroup_id();
        if (other.getRecordid() != null)
            this.recordid = other.getRecordid();
    }

    public void clearProperties() {

        this.riskid = null;
        this.setoperator = null;
        this.setime = null;
        this.applyItemType = null;
        this.group_id = null;
        this.recordid = null;
    }
}

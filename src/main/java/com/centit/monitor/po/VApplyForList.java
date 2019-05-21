package com.centit.monitor.po;

import java.util.Date;

public class VApplyForList implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String no;

    private String orgId;
    private String internalNo;
    private String itemId;
    private String department;
    private String applicantName;
    private Long isrisk;
    private Date applyDate;
    private Date finishTime;
    private String applicantType;
    private String isTrack;
    private String monitorStyle;
    private String transactAffairName;
    private String unitcode;
    private String status;

    public String getTransactAffairName() {
        return transactAffairName;
    }

    public void setTransactAffairName(String transactAffairName) {
        this.transactAffairName = transactAffairName;
    }

    public String getMonitorStyle() {
        return monitorStyle;
    }

    public void setMonitorStyle(String monitorStyle) {
        this.monitorStyle = monitorStyle;
    }

    public VApplyForList(String no, String orgId, String internalNo,
            String itemId, String department, String applicantName,
            Long isrisk, Date applyDate, Date finishTime, String itemType,
            String topunitcode, String applicantType, String isTrack) {
        super();
        this.no = no;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.applicantName = applicantName;
        this.isrisk = isrisk;
        this.applyDate = applyDate;
        this.finishTime = finishTime;
        this.itemType = itemType;
        this.topunitcode = topunitcode;
        this.applicantType = applicantType;
        this.isTrack = isTrack;
    }

    public VApplyForList(String no, String orgId, String internalNo,
            String itemId, String department, String applicantName,
            Long isrisk, Date applyDate, Date finishTime, String applicantType,
            String isTrack, String monitorStyle, String transactAffairName,
            String itemType, String topunitcode) {
        super();
        this.no = no;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.applicantName = applicantName;
        this.isrisk = isrisk;
        this.applyDate = applyDate;
        this.finishTime = finishTime;
        this.applicantType = applicantType;
        this.isTrack = isTrack;
        this.monitorStyle = monitorStyle;
        this.transactAffairName = transactAffairName;
        this.itemType = itemType;
        this.topunitcode = topunitcode;
    }

    public String getIsTrack() {
        return isTrack;
    }

    public void setIsTrack(String isTrack) {
        this.isTrack = isTrack;
    }

    public VApplyForList() {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Long getIsrisk() {
        return isrisk;
    }

    public void setIsrisk(Long isrisk) {
        this.isrisk = isrisk;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTopunitcode() {
        return topunitcode;
    }

    public void setTopunitcode(String topunitcode) {
        this.topunitcode = topunitcode;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    private String itemType;
    private String topunitcode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void copy(VApplyForList other) {
        this.setNo(other.getNo());
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.applicantName = other.getApplicantName();
        this.applyDate = other.getApplyDate();
        this.department = other.getDepartment();
        this.isrisk = other.getIsrisk();
        this.topunitcode = other.getTopunitcode();
        this.finishTime = other.getFinishTime();
        this.applicantType = other.getApplicantType();
        this.isTrack = other.getIsTrack();
        this.status = other.getStatus();
    }

    public void copyNotNullProperty(VApplyForList other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getApplicantName() != null)
            this.applicantName = other.getApplicantName();
        if (other.getApplyDate() != null)
            this.applyDate = other.getApplyDate();
        if (other.getDepartment() != null)
            this.department = other.getDepartment();
        if (other.getIsrisk() != null)
            this.isrisk = other.getIsrisk();
        if (other.getTopunitcode() != null)
            this.topunitcode = other.getTopunitcode();

        if (other.getFinishTime() != null)
            this.finishTime = other.getFinishTime();
        if (other.getApplicantType() != null)
            this.applicantType = other.getApplicantType();
        if (other.getIsTrack() != null)
            this.isTrack = other.getIsTrack();
        if (other.getStatus() != null) {
            this.status = other.getStatus();
        }
    }

    public void clearProperties() {
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.applicantName = null;
        this.applyDate = null;
        this.department = null;
        this.isrisk = null;
        this.topunitcode = null;
        this.finishTime = null;
        this.applicantType = null;
        this.isTrack = null;
        this.status = null;
    }
}

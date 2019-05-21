package com.centit.monitor.po;

import java.util.Date;

public class VApply implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String no;
    private Long changNo;
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
    private String version;
    private String acceptNo;
    private String incomeDocNo;
    private String dispatchDocNo;
    private String monitorStyle;
    private String transactAffairName;
    private String maxstatus;
    private String status;
    private String unitcode;

    public String getMaxstatus() {
        return maxstatus;
    }

    public void setMaxstatus(String maxstatus) {
        this.maxstatus = maxstatus;
    }

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

    public String getAcceptNo() {
        return acceptNo;
    }

    public void setAcceptNo(String acceptNo) {
        this.acceptNo = acceptNo;
    }

    public String getIncomeDocNo() {
        return incomeDocNo;
    }

    public void setIncomeDocNo(String incomeDocNo) {
        this.incomeDocNo = incomeDocNo;
    }

    public String getDispatchDocNo() {
        return dispatchDocNo;
    }

    public void setDispatchDocNo(String dispatchDocNo) {
        this.dispatchDocNo = dispatchDocNo;
    }

    public VApply(String no, Long changNo, String orgId, String internalNo,
            String itemId, String department, String applicantName,
            Long isrisk, Date applyDate, Date finishTime, String itemType,
            String topunitcode, String applicantType, String isTrack,
            String version) {
        super();
        this.no = no;
        this.changNo = changNo;
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
        this.version = version;
    }

    public VApply(String no, Long changNo, String orgId, String internalNo,
            String itemId, String department, String applicantName,
            Long isrisk, Date applyDate, Date finishTime, String applicantType,
            String isTrack, String version, String acceptNo,
            String incomeDocNo, String dispatchDocNo, String monitorStyle,
            String transactAffairName, String itemType, String topunitcode) {
        super();
        this.no = no;
        this.changNo = changNo;
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
        this.version = version;
        this.acceptNo = acceptNo;
        this.incomeDocNo = incomeDocNo;
        this.dispatchDocNo = dispatchDocNo;
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

    public VApply() {

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getChangNo() {
        return changNo;
    }

    public void setChangNo(Long changNo) {
        this.changNo = changNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    private String itemType;
    private String topunitcode;

    public void copy(VApply other) {

        this.setNo(other.getNo());

        this.changNo = other.getChangNo();
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
        this.version = other.getVersion();
    }

    public void copyNotNullProperty(VApply other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getChangNo() != null)
            this.changNo = other.getChangNo();
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
        if (other.getVersion() != null) {
            this.version = other.getVersion();
        }
    }

    public void clearProperties() {

        this.changNo = null;
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
        this.version = null;
    }
}

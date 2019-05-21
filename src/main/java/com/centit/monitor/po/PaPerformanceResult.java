package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class PaPerformanceResult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long checkNo;

    private String checkType;
    private String userCode;
    private String orgId;
    private String countYear;
    private String countMonth;
    private Date createDate;
    private Double allNum;
    private Double zsScore;
    private String auditDesc;
    private String auditor;
    private Date auditDate;
    private String auditResult;
    private Double recordNum;

    private Double calculateNum;

    // Constructors
    /** default constructor */
    public PaPerformanceResult() {
    }

    /** minimal constructor */
    public PaPerformanceResult(Long checkNo, String checkType,
            String countYear, String countMonth) {

        this.checkNo = checkNo;

        this.checkType = checkType;
        this.countYear = countYear;
        this.countMonth = countMonth;
    }

    /** full constructor */
    public PaPerformanceResult(Long checkNo, String checkType, String userCode,
            String orgId, String countYear, String countMonth, Date createDate,
            Double allNum, Double zsScore, String auditDesc, String auditor,
            Date auditDate, String auditResult, Double recordNum,
            Double calculateNum) {

        this.checkNo = checkNo;

        this.checkType = checkType;
        this.userCode = userCode;
        this.orgId = orgId;
        this.countYear = countYear;
        this.countMonth = countMonth;
        this.createDate = createDate;
        this.allNum = allNum;
        this.zsScore = zsScore;
        this.auditDesc = auditDesc;
        this.auditor = auditor;
        this.auditDate = auditDate;
        this.auditResult = auditResult;
        this.recordNum = recordNum;
        this.calculateNum = calculateNum;
    }

    public Long getCheckNo() {
        return this.checkNo;
    }

    public void setCheckNo(Long checkNo) {
        this.checkNo = checkNo;
    }

    // Property accessors

    public String getCheckType() {
        return this.checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getAllNum() {
        return this.allNum;
    }

    public void setAllNum(Double allNum) {
        this.allNum = allNum;
    }

    public Double getZsScore() {
        return this.zsScore;
    }

    public void setZsScore(Double zsScore) {
        this.zsScore = zsScore;
    }

    public String getAuditDesc() {
        return this.auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditor() {
        return this.auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getAuditDate() {
        return this.auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditResult() {
        return this.auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public Double getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Double recordNum) {
        this.recordNum = recordNum;
    }

    public Double getCalculateNum() {
        return calculateNum;
    }

    public void setCalculateNum(Double calculateNum) {
        this.calculateNum = calculateNum;
    }

    public String getCountYear() {
        return countYear;
    }

    public void setCountYear(String countYear) {
        this.countYear = countYear;
    }

    public String getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(String countMonth) {
        this.countMonth = countMonth;
    }

    public void copy(PaPerformanceResult other) {

        this.setCheckNo(other.getCheckNo());

        this.checkType = other.getCheckType();
        this.userCode = other.getUserCode();
        this.orgId = other.getOrgId();
        this.countYear = other.getCountYear();
        this.countMonth = other.getCountMonth();
        this.createDate = other.getCreateDate();
        this.allNum = other.getAllNum();
        this.zsScore = other.getZsScore();
        this.auditDesc = other.getAuditDesc();
        this.auditor = other.getAuditor();
        this.auditDate = other.getAuditDate();
        this.auditResult = other.getAuditResult();

    }

    public void copyNotNullProperty(PaPerformanceResult other) {

        if (other.getCheckNo() != null)
            this.setCheckNo(other.getCheckNo());

        if (other.getCheckType() != null)
            this.checkType = other.getCheckType();
        if (other.getUserCode() != null)
            this.userCode = other.getUserCode();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getCountYear() != null)
            this.countYear = other.getCountYear();
        if (other.getCountMonth() != null)
            this.countMonth = other.getCountMonth();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getAllNum() != null)
            this.allNum = other.getAllNum();
        if (other.getZsScore() != null)
            this.zsScore = other.getZsScore();
        if (other.getAuditDesc() != null)
            this.auditDesc = other.getAuditDesc();
        if (other.getAuditor() != null)
            this.auditor = other.getAuditor();
        if (other.getAuditDate() != null)
            this.auditDate = other.getAuditDate();
        if (other.getAuditResult() != null)
            this.auditResult = other.getAuditResult();

    }

    public void clearProperties() {

        this.checkType = null;
        this.userCode = null;
        this.orgId = null;
        this.countYear = null;
        this.countMonth = null;
        this.createDate = null;
        this.allNum = null;
        this.zsScore = null;
        this.auditDesc = null;
        this.auditor = null;
        this.auditDate = null;
        this.auditResult = null;
        this.auditDate = null;
        this.auditResult = null;

    }
}

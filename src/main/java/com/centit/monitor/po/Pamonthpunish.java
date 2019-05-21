package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Pamonthpunish implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String punishNo;

    public String getPunishNo() {
        return punishNo;
    }

    public void setPunishNo(String punishNo) {
        this.punishNo = punishNo;
    }

    private String punishType;

    public String getPunishType() {
        return punishType;
    }

    public void setPunishType(String punishType) {
        this.punishType = punishType;
    }

    private String userCode;
    private String orgId;
    private String countYear;
    private String countMonth;
    private Double punishUnit;
    private Double punishCount;
    private Double punishSum;
    private String punishResion;
    private String auditResult;
    private String auditDesc;
    private String auditor;
    private Date auditDate;
    private String recorder;
    private Date recordDate;

    // Constructors
    /** default constructor */
    public Pamonthpunish() {
    }

    /** minimal constructor */
    public Pamonthpunish(String punishNo, String punishType, String countYear,
            String countMonth) {

        this.punishNo = punishNo;

        this.punishType = punishType;
        this.countYear = countYear;
        this.countMonth = countMonth;
    }

    /** full constructor */
    public Pamonthpunish(String punishNo, String punishType, String userCode,
            String orgId, String countYear, String countMonth,
            Double punishUnit, Double punishCount, Double punishSum,
            String punishResion, String auditResult, String auditDesc,
            String auditor, Date auditDate, String recorder, Date recordDate) {

        this.punishNo = punishNo;

        this.punishType = punishType;
        this.userCode = userCode;
        this.orgId = orgId;
        this.countYear = countYear;
        this.countMonth = countMonth;
        this.punishUnit = punishUnit;
        this.punishCount = punishCount;
        this.punishSum = punishSum;
        this.punishResion = punishResion;
        this.auditResult = auditResult;
        this.auditDesc = auditDesc;
        this.auditor = auditor;
        this.auditDate = auditDate;
        this.recorder = recorder;
        this.recordDate = recordDate;
    }

    // Property accessors

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

    public Double getPunishUnit() {
        return this.punishUnit;
    }

    public void setPunishUnit(Double punishUnit) {
        this.punishUnit = punishUnit;
    }

    public Double getPunishCount() {
        return this.punishCount;
    }

    public void setPunishCount(Double punishCount) {
        this.punishCount = punishCount;
    }

    public Double getPunishSum() {
        return this.punishSum;
    }

    public void setPunishSum(Double punishSum) {
        this.punishSum = punishSum;
    }

    public String getPunishResion() {
        return this.punishResion;
    }

    public void setPunishResion(String punishResion) {
        this.punishResion = punishResion;
    }

    public String getAuditResult() {
        return this.auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
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

    public String getRecorder() {
        return this.recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public Date getRecordDate() {
        return this.recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public void copy(Pamonthpunish other) {

        this.setPunishNo(other.getPunishNo());

        this.punishType = other.getPunishType();
        this.userCode = other.getUserCode();
        this.orgId = other.getOrgId();
        this.countYear = other.getCountYear();
        this.countMonth = other.getCountMonth();
        this.punishUnit = other.getPunishUnit();
        this.punishCount = other.getPunishCount();
        this.punishSum = other.getPunishSum();
        this.punishResion = other.getPunishResion();
        this.auditResult = other.getAuditResult();
        this.auditDesc = other.getAuditDesc();
        this.auditor = other.getAuditor();
        this.auditDate = other.getAuditDate();
        this.recorder = other.getRecorder();
        this.recordDate = other.getRecordDate();

    }

    public void copyNotNullProperty(Pamonthpunish other) {

        if (other.getPunishNo() != null)
            this.setPunishNo(other.getPunishNo());

        if (other.getPunishType() != null)
            this.punishType = other.getPunishType();
        if (other.getUserCode() != null)
            this.userCode = other.getUserCode();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getCountYear() != null)
            this.countYear = other.getCountYear();
        if (other.getCountMonth() != null)
            this.countMonth = other.getCountMonth();
        if (other.getPunishUnit() != null)
            this.punishUnit = other.getPunishUnit();
        if (other.getPunishCount() != null)
            this.punishCount = other.getPunishCount();
        if (other.getPunishSum() != null)
            this.punishSum = other.getPunishSum();
        if (other.getPunishResion() != null)
            this.punishResion = other.getPunishResion();
        if (other.getAuditResult() != null)
            this.auditResult = other.getAuditResult();
        if (other.getAuditDesc() != null)
            this.auditDesc = other.getAuditDesc();
        if (other.getAuditor() != null)
            this.auditor = other.getAuditor();
        if (other.getAuditDate() != null)
            this.auditDate = other.getAuditDate();
        if (other.getRecorder() != null)
            this.recorder = other.getRecorder();
        if (other.getRecordDate() != null)
            this.recordDate = other.getRecordDate();

    }

    public void clearProperties() {

        this.punishType = null;
        this.userCode = null;
        this.orgId = null;
        this.countYear = null;
        this.countMonth = null;
        this.punishUnit = null;
        this.punishCount = null;
        this.punishSum = null;
        this.punishResion = null;
        this.auditResult = null;
        this.auditDesc = null;
        this.auditor = null;
        this.auditDate = null;
        this.recorder = null;
        this.recordDate = null;

    }
}

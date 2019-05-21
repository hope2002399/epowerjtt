package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Supervisorypersonnel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private String userId;
    private String updateType;
    private String userName;
    private String deptcode;
    private Date birth;
    private String sex;
    private String politicalLandscape;
    private String education;
    private String tel;
    private String position;
    private String organization;
    private Date changeDate;
    private String recoder;
    private Date recodDate;
    private String auditor;
    private Date auditDate;
    private String datesource;
    private Date updateDate;
    private Date readDate;
    private String syncSign;
    private String errorDesc;
    private String state;
    private String sysId;
    private String auditReason;

    // Constructors
    /** default constructor */
    public Supervisorypersonnel() {
    }

    /** minimal constructor */
    public Supervisorypersonnel(String no, String userId, String updateType,
            String userName, String deptcode, Date birth, String sex,
            String politicalLandscape, String education, String tel,
            String position, String organization, String datesource,
            Date updateDate) {

        this.no = no;

        this.userId = userId;
        this.updateType = updateType;
        this.userName = userName;
        this.deptcode = deptcode;
        this.birth = birth;
        this.sex = sex;
        this.politicalLandscape = politicalLandscape;
        this.education = education;
        this.tel = tel;
        this.position = position;
        this.organization = organization;
        this.datesource = datesource;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public Supervisorypersonnel(String no, String userId, String updateType,
            String userName, String deptcode, Date birth, String sex,
            String politicalLandscape, String education, String tel,
            String position, String organization, Date changeDate,
            String recoder, Date recodDate, String auditor, Date auditDate,
            String datesource, Date updateDate, Date readDate, String syncSign,
            String errorDesc, String state, String sysId, String auditReason) {

        this.no = no;

        this.userId = userId;
        this.updateType = updateType;
        this.userName = userName;
        this.deptcode = deptcode;
        this.birth = birth;
        this.sex = sex;
        this.politicalLandscape = politicalLandscape;
        this.education = education;
        this.tel = tel;
        this.position = position;
        this.organization = organization;
        this.changeDate = changeDate;
        this.recoder = recoder;
        this.recodDate = recodDate;
        this.auditor = auditor;
        this.auditDate = auditDate;
        this.datesource = datesource;
        this.updateDate = updateDate;
        this.readDate = readDate;
        this.syncSign = syncSign;
        this.errorDesc = errorDesc;
        this.state = state;
        this.auditReason = auditReason;
        this.sysId = sysId;
    }

    public String getNo() {
        return this.no;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // Property accessors

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptcode() {
        return this.deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public Date getBirth() {
        return this.birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPoliticalLandscape() {
        return this.politicalLandscape;
    }

    public void setPoliticalLandscape(String politicalLandscape) {
        this.politicalLandscape = politicalLandscape;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getChangeDate() {
        return this.changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getRecoder() {
        return this.recoder;
    }

    public void setRecoder(String recoder) {
        this.recoder = recoder;
    }

    public Date getRecodDate() {
        return this.recodDate;
    }

    public void setRecodDate(Date recodDate) {
        this.recodDate = recodDate;
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

    public String getDatesource() {
        return this.datesource;
    }

    public void setDatesource(String datesource) {
        this.datesource = datesource;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getReadDate() {
        return this.readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public String getSyncSign() {
        return this.syncSign;
    }

    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void copy(Supervisorypersonnel other) {

        this.setNo(other.getNo());

        this.userId = other.getUserId();
        this.updateType = other.getUpdateType();
        this.userName = other.getUserName();
        this.deptcode = other.getDeptcode();
        this.birth = other.getBirth();
        this.sex = other.getSex();
        this.politicalLandscape = other.getPoliticalLandscape();
        this.education = other.getEducation();
        this.tel = other.getTel();
        this.position = other.getPosition();
        this.organization = other.getOrganization();
        this.changeDate = other.getChangeDate();
        this.recoder = other.getRecoder();
        this.recodDate = other.getRecodDate();
        this.auditor = other.getAuditor();
        this.auditDate = other.getAuditDate();
        this.datesource = other.getDatesource();
        this.updateDate = other.getUpdateDate();
        this.readDate = other.getReadDate();
        this.syncSign = other.getSyncSign();
        this.errorDesc = other.getErrorDesc();
        this.state = other.getState();
        this.sysId = other.getSysId();
        this.auditReason = other.getAuditReason();
    }

    public void copyNotNullProperty(Supervisorypersonnel other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getUserId() != null)
            this.userId = other.getUserId();
        if (other.getUpdateType() != null)
            this.updateType = other.getUpdateType();
        if (other.getUserName() != null)
            this.userName = other.getUserName();
        if (other.getDeptcode() != null)
            this.deptcode = other.getDeptcode();
        if (other.getBirth() != null)
            this.birth = other.getBirth();
        if (other.getSex() != null)
            this.sex = other.getSex();
        if (other.getPoliticalLandscape() != null)
            this.politicalLandscape = other.getPoliticalLandscape();
        if (other.getEducation() != null)
            this.education = other.getEducation();
        if (other.getTel() != null)
            this.tel = other.getTel();
        if (other.getPosition() != null)
            this.position = other.getPosition();
        if (other.getOrganization() != null)
            this.organization = other.getOrganization();
        if (other.getChangeDate() != null)
            this.changeDate = other.getChangeDate();
        if (other.getRecoder() != null)
            this.recoder = other.getRecoder();
        if (other.getRecodDate() != null)
            this.recodDate = other.getRecodDate();
        if (other.getAuditor() != null)
            this.auditor = other.getAuditor();
        if (other.getAuditDate() != null)
            this.auditDate = other.getAuditDate();
        if (other.getDatesource() != null)
            this.datesource = other.getDatesource();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getReadDate() != null)
            this.readDate = other.getReadDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getErrorDesc() != null)
            this.errorDesc = other.getErrorDesc();
        if (other.getState() != null)
            this.state = other.getState();
        if (other.getAuditReason() != null)
            this.auditReason = other.getAuditReason();
        if (other.getSysId() != null)
            this.sysId = other.getSysId();

    }

    public void clearProperties() {

        this.userId = null;
        this.updateType = null;
        this.userName = null;
        this.deptcode = null;
        this.birth = null;
        this.sex = null;
        this.politicalLandscape = null;
        this.education = null;
        this.tel = null;
        this.position = null;
        this.organization = null;
        this.changeDate = null;
        this.recoder = null;
        this.recodDate = null;
        this.auditor = null;
        this.auditDate = null;
        this.datesource = null;
        this.updateDate = null;
        this.readDate = null;
        this.syncSign = null;
        this.errorDesc = null;
        this.state = null;
        this.sysId = null;
        this.auditReason = null;
    }
}

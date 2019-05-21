package com.centit.powerbase.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Lawmen implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String lawmenId;

    private String userId;
    private String updateType;
    private String deptcode;
    private String userName;
    private String nation;
    private Date birth;
    private String sex;
    private String politicalLandscape;
    private String education;
    private String tel;
    private String position;
    private String organization;
    private String state;
    private String usercode;
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

    // Constructors
    private String giveCertOrgan;
    private String legalRange;
    private String legalArea;

    // 年检新增 by lq
    private Date validity;
    private Date annualDate;
    private Date separationDate;
    private String separationReason;

    /** default constructor */
    public Lawmen() {
    }

    /** minimal constructor */
    public Lawmen(String lawmenId, String userId, String updateType,
            String deptcode, String userName, Date birth, String sex,
            String politicalLandscape, String education, String tel,
            String position, String organization, String datesource,
            Date updateDate, String giveCertOrgan, String legalRange,
            String legalArea, Date validity, Date annualDate,
            Date separationDate, String separationReason) {

        this.lawmenId = lawmenId;

        this.userId = userId;
        this.updateType = updateType;
        this.deptcode = deptcode;
        this.userName = userName;
        this.birth = birth;
        this.sex = sex;
        this.politicalLandscape = politicalLandscape;
        this.education = education;
        this.tel = tel;
        this.position = position;
        this.organization = organization;
        this.datesource = datesource;
        this.updateDate = updateDate;
        this.giveCertOrgan = giveCertOrgan;
        this.legalArea = legalArea;
        this.legalRange = legalRange;

        this.validity = validity;
        this.annualDate = annualDate;
        this.separationDate = separationDate;
        this.separationReason = separationReason;
    }

    public String getSeparationReason() {
        return separationReason;
    }

    public void setSeparationReason(String separationReason) {
        this.separationReason = separationReason;
    }

    /** full constructor */
    public Lawmen(String lawmenId, String userId, String updateType,
            String deptcode, String userName, String nation, Date birth,
            String sex, String politicalLandscape, String education,
            String tel, String position, String organization, String state,
            String usercode, Date changeDate, String recoder, Date recodDate,
            String auditor, Date auditDate, String datesource, Date updateDate,
            Date readDate, String syncSign, String errorDesc,
            String giveCertOrgan, String legalRange, String legalArea,
            Date validity, Date annualDate, Date separationDate,
            String separationReason) {

        this.lawmenId = lawmenId;

        this.userId = userId;
        this.updateType = updateType;
        this.deptcode = deptcode;
        this.userName = userName;
        this.nation = nation;
        this.birth = birth;
        this.sex = sex;
        this.politicalLandscape = politicalLandscape;
        this.education = education;
        this.tel = tel;
        this.position = position;
        this.organization = organization;
        this.state = state;
        this.usercode = usercode;
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
        this.giveCertOrgan = giveCertOrgan;
        this.legalArea = legalArea;
        this.legalRange = legalRange;

        this.validity = validity;
        this.annualDate = annualDate;
        this.separationDate = separationDate;
        this.separationReason = separationReason;
    }

    public String getLawmenId() {
        return this.lawmenId;
    }

    public void setLawmenId(String lawmenId) {
        this.lawmenId = lawmenId;
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

    public String getGiveCertOrgan() {
        return giveCertOrgan;
    }

    public void setGiveCertOrgan(String giveCertOrgan) {
        this.giveCertOrgan = giveCertOrgan;
    }

    public String getLegalRange() {
        return legalRange;
    }

    public void setLegalRange(String legalRange) {
        this.legalRange = legalRange;
    }

    public String getLegalArea() {
        return legalArea;
    }

    public void setLegalArea(String legalArea) {
        this.legalArea = legalArea;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getDeptcode() {
        return this.deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsercode() {
        return this.usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
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

    public void copy(Lawmen other) {

        this.setLawmenId(other.getLawmenId());

        this.userId = other.getUserId();
        this.updateType = other.getUpdateType();
        this.deptcode = other.getDeptcode();
        this.userName = other.getUserName();
        this.nation = other.getNation();
        this.birth = other.getBirth();
        this.sex = other.getSex();
        this.politicalLandscape = other.getPoliticalLandscape();
        this.education = other.getEducation();
        this.tel = other.getTel();
        this.position = other.getPosition();
        this.organization = other.getOrganization();
        this.state = other.getState();
        this.usercode = other.getUsercode();
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
        this.legalArea = other.getLegalArea();
        this.legalRange = other.getLegalRange();
        this.giveCertOrgan = other.getGiveCertOrgan();

        this.validity = other.getValidity();
        this.annualDate = other.getAnnualDate();
        this.separationDate = other.getSeparationDate();
        this.separationReason = other.getSeparationReason();
    }

    public void copyNotNullProperty(Lawmen other) {

        if (other.getLawmenId() != null)
            this.setLawmenId(other.getLawmenId());

        if (other.getUserId() != null)
            this.userId = other.getUserId();
        if (other.getUpdateType() != null)
            this.updateType = other.getUpdateType();
        if (other.getDeptcode() != null)
            this.deptcode = other.getDeptcode();
        if (other.getUserName() != null)
            this.userName = other.getUserName();
        if (other.getNation() != null)
            this.nation = other.getNation();
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
        if (other.getState() != null)
            this.state = other.getState();
        if (other.getUsercode() != null)
            this.usercode = other.getUsercode();
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

        if (other.getGiveCertOrgan() != null)
            this.giveCertOrgan = other.getGiveCertOrgan();
        if (other.getLegalArea() != null)
            this.legalArea = other.getLegalArea();
        if (other.getLegalRange() != null)
            this.legalRange = other.getLegalRange();

        if (other.getValidity() != null)
            this.validity = other.getValidity();
        if (other.getAnnualDate() != null)
            this.annualDate = other.getAnnualDate();
        if (other.getSeparationDate() != null)
            this.separationDate = other.getSeparationDate();
        if (other.getSeparationReason() != null)
            this.separationReason = other.getSeparationReason();
    }

    public void clearProperties() {

        this.userId = null;
        this.updateType = null;
        this.deptcode = null;
        this.userName = null;
        this.nation = null;
        this.birth = null;
        this.sex = null;
        this.politicalLandscape = null;
        this.education = null;
        this.tel = null;
        this.position = null;
        this.organization = null;
        this.state = null;
        this.usercode = null;
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
        this.legalArea = null;
        this.legalRange = null;
        this.giveCertOrgan = null;

        this.validity = null;
        this.annualDate = null;
        this.separationDate = null;
        this.separationReason = null;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Date getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(Date annualDate) {
        this.annualDate = annualDate;
    }

    public Date getSeparationDate() {
        return separationDate;
    }

    public void setSeparationDate(Date separationDate) {
        this.separationDate = separationDate;
    }
}

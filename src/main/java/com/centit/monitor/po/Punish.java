package com.centit.monitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Punish implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private String parentName;
    private String itemParName;
    private Long changNo;
    private String orgId;
    private String internalNo;
    private String itemId;
    private String department;
    private String ajAddr;
    private Date ajOccurDate;
    private String source;
    private String fact;
    private String targetType;
    private String punishTarget;
    private String targetCode;
    private String targetPaperType;
    private String targetPaperNumber;
    private String targetPhone;
    private String targetMobile;
    private String targetAddress;
    private String targetZipCode;
    private String targetEmail;
    private String reporter;
    private Date reporterDate;
    private String reporterPaperType;
    private String reporterAperCode;
    private String reporterPhone;
    private String reporterMobile;
    private String reporterAddress;
    private String reporterZipcode;
    private String reporterEmail;
    private String content;
    private String form;
    private Long promise;
    private String promiseType;
    private Long isrisk;
    private String risktype;
    private String riskdescription;
    private String riskresult;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;
    private String isTrack;
    private List docList = new ArrayList();
    private String bmcj;

    public String getBmcj() {
        return bmcj;
    }

    public void setBmcj(String bmcj) {
        this.bmcj = bmcj;
    }
    
    @Transient
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Transient
    public String getItemParName() {
        return itemParName;
    }

    public void setItemParName(String itemParName) {
        this.itemParName = itemParName;
    }

    public List getDocList() {
        return docList;
    }

    public void setDocList(List docList) {
        this.docList = docList;
    }

    // Constructors
    /** default constructor */
    public Punish() {
    }

    /** minimal constructor */
    public Punish(String no, Long changNo, String orgId, String internalNo,
            String itemId, String department, String ajAddr, Date ajOccurDate,
            String targetType, String punishTarget, Long promise,
            String promiseType, Date createDate, Date updateDate, String isTrack) {

        this.no = no;

        this.changNo = changNo;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.ajAddr = ajAddr;
        this.ajOccurDate = ajOccurDate;
        this.targetType = targetType;
        this.punishTarget = punishTarget;
        this.promise = promise;
        this.promiseType = promiseType;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isTrack = isTrack;
    }

    /** full constructor */
    public Punish(String no, Long changNo, String orgId, String internalNo,
            String itemId, String department, String ajAddr, Date ajOccurDate,
            String source, String fact, String targetType, String punishTarget,
            String targetCode, String targetPaperType,
            String targetPaperNumber, String targetPhone, String targetMobile,
            String targetAddress, String targetZipCode, String targetEmail,
            String reporter, Date reporterDate, String reporterPaperType,
            String reporterAperCode, String reporterPhone,
            String reporterMobile, String reporterAddress,
            String reporterZipcode, String reporterEmail, String content,
            String form, Long promise, String promiseType, Long isrisk,
            String risktype, String riskdescription, String riskresult,
            Date createDate, Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {

        this.no = no;

        this.changNo = changNo;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.ajAddr = ajAddr;
        this.ajOccurDate = ajOccurDate;
        this.source = source;
        this.fact = fact;
        this.targetType = targetType;
        this.punishTarget = punishTarget;
        this.targetCode = targetCode;
        this.targetPaperType = targetPaperType;
        this.targetPaperNumber = targetPaperNumber;
        this.targetPhone = targetPhone;
        this.targetMobile = targetMobile;
        this.targetAddress = targetAddress;
        this.targetZipCode = targetZipCode;
        this.targetEmail = targetEmail;
        this.reporter = reporter;
        this.reporterDate = reporterDate;
        this.reporterPaperType = reporterPaperType;
        this.reporterAperCode = reporterAperCode;
        this.reporterPhone = reporterPhone;
        this.reporterMobile = reporterMobile;
        this.reporterAddress = reporterAddress;
        this.reporterZipcode = reporterZipcode;
        this.reporterEmail = reporterEmail;
        this.content = content;
        this.form = form;
        this.promise = promise;
        this.promiseType = promiseType;
        this.isrisk = isrisk;
        this.risktype = risktype;
        this.riskdescription = riskdescription;
        this.riskresult = riskresult;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
        this.isTrack = isTrack;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // Property accessors

    public Long getChangNo() {
        return this.changNo;
    }

    public void setChangNo(Long changNo) {
        this.changNo = changNo;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getInternalNo() {
        return this.internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getIsTrack() {
        return isTrack;
    }

    public void setIsTrack(String isTrack) {
        this.isTrack = isTrack;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAjAddr() {
        return this.ajAddr;
    }

    public void setAjAddr(String ajAddr) {
        this.ajAddr = ajAddr;
    }

    public Date getAjOccurDate() {
        return this.ajOccurDate;
    }

    public void setAjOccurDate(Date ajOccurDate) {
        this.ajOccurDate = ajOccurDate;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFact() {
        return this.fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getPunishTarget() {
        return this.punishTarget;
    }

    public void setPunishTarget(String punishTarget) {
        this.punishTarget = punishTarget;
    }

    public String getTargetCode() {
        return this.targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public String getTargetPaperType() {
        return this.targetPaperType;
    }

    public void setTargetPaperType(String targetPaperType) {
        this.targetPaperType = targetPaperType;
    }

    public String getTargetPaperNumber() {
        return this.targetPaperNumber;
    }

    public void setTargetPaperNumber(String targetPaperNumber) {
        this.targetPaperNumber = targetPaperNumber;
    }

    public String getTargetPhone() {
        return this.targetPhone;
    }

    public void setTargetPhone(String targetPhone) {
        this.targetPhone = targetPhone;
    }

    public String getTargetMobile() {
        return this.targetMobile;
    }

    public void setTargetMobile(String targetMobile) {
        this.targetMobile = targetMobile;
    }

    public String getTargetAddress() {
        return this.targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getTargetZipCode() {
        return this.targetZipCode;
    }

    public void setTargetZipCode(String targetZipCode) {
        this.targetZipCode = targetZipCode;
    }

    public String getTargetEmail() {
        return this.targetEmail;
    }

    public void setTargetEmail(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    public String getReporter() {
        return this.reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Date getReporterDate() {
        return this.reporterDate;
    }

    public void setReporterDate(Date reporterDate) {
        this.reporterDate = reporterDate;
    }

    public String getReporterPaperType() {
        return this.reporterPaperType;
    }

    public void setReporterPaperType(String reporterPaperType) {
        this.reporterPaperType = reporterPaperType;
    }

    public String getReporterAperCode() {
        return this.reporterAperCode;
    }

    public void setReporterAperCode(String reporterAperCode) {
        this.reporterAperCode = reporterAperCode;
    }

    public String getReporterPhone() {
        return this.reporterPhone;
    }

    public void setReporterPhone(String reporterPhone) {
        this.reporterPhone = reporterPhone;
    }

    public String getReporterMobile() {
        return this.reporterMobile;
    }

    public void setReporterMobile(String reporterMobile) {
        this.reporterMobile = reporterMobile;
    }

    public String getReporterAddress() {
        return this.reporterAddress;
    }

    public void setReporterAddress(String reporterAddress) {
        this.reporterAddress = reporterAddress;
    }

    public String getReporterZipcode() {
        return this.reporterZipcode;
    }

    public void setReporterZipcode(String reporterZipcode) {
        this.reporterZipcode = reporterZipcode;
    }

    public String getReporterEmail() {
        return this.reporterEmail;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Long getPromise() {
        return this.promise;
    }

    public void setPromise(Long promise) {
        this.promise = promise;
    }

    public String getPromiseType() {
        return this.promiseType;
    }

    public void setPromiseType(String promiseType) {
        this.promiseType = promiseType;
    }

    public Long getIsrisk() {
        return this.isrisk;
    }

    public void setIsrisk(Long isrisk) {
        this.isrisk = isrisk;
    }

    public String getRisktype() {
        return this.risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype;
    }

    public String getRiskdescription() {
        return this.riskdescription;
    }

    public void setRiskdescription(String riskdescription) {
        this.riskdescription = riskdescription;
    }

    public String getRiskresult() {
        return this.riskresult;
    }

    public void setRiskresult(String riskresult) {
        this.riskresult = riskresult;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getSyncDate() {
        return this.syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public String getSyncSign() {
        return this.syncSign;
    }

    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    public String getSyncErrorDesc() {
        return this.syncErrorDesc;
    }

    public void setSyncErrorDesc(String syncErrorDesc) {
        this.syncErrorDesc = syncErrorDesc;
    }

    public void copy(Punish other) {

        this.setNo(other.getNo());

        this.changNo = other.getChangNo();
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.department = other.getDepartment();
        this.ajAddr = other.getAjAddr();
        this.ajOccurDate = other.getAjOccurDate();
        this.source = other.getSource();
        this.fact = other.getFact();
        this.targetType = other.getTargetType();
        this.punishTarget = other.getPunishTarget();
        this.targetCode = other.getTargetCode();
        this.targetPaperType = other.getTargetPaperType();
        this.targetPaperNumber = other.getTargetPaperNumber();
        this.targetPhone = other.getTargetPhone();
        this.targetMobile = other.getTargetMobile();
        this.targetAddress = other.getTargetAddress();
        this.targetZipCode = other.getTargetZipCode();
        this.targetEmail = other.getTargetEmail();
        this.reporter = other.getReporter();
        this.reporterDate = other.getReporterDate();
        this.reporterPaperType = other.getReporterPaperType();
        this.reporterAperCode = other.getReporterAperCode();
        this.reporterPhone = other.getReporterPhone();
        this.reporterMobile = other.getReporterMobile();
        this.reporterAddress = other.getReporterAddress();
        this.reporterZipcode = other.getReporterZipcode();
        this.reporterEmail = other.getReporterEmail();
        this.content = other.getContent();
        this.form = other.getForm();
        this.promise = other.getPromise();
        this.promiseType = other.getPromiseType();
        this.isrisk = other.getIsrisk();
        this.risktype = other.getRisktype();
        this.riskdescription = other.getRiskdescription();
        this.riskresult = other.getRiskresult();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();
        this.isTrack = other.getIsTrack();
        this.bmcj = other.getBmcj();
    }

    public void copyNotNullProperty(Punish other) {

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
        if (other.getDepartment() != null)
            this.department = other.getDepartment();
        if (other.getAjAddr() != null)
            this.ajAddr = other.getAjAddr();
        if (other.getAjOccurDate() != null)
            this.ajOccurDate = other.getAjOccurDate();
        if (other.getSource() != null)
            this.source = other.getSource();
        if (other.getFact() != null)
            this.fact = other.getFact();
        if (other.getTargetType() != null)
            this.targetType = other.getTargetType();
        if (other.getPunishTarget() != null)
            this.punishTarget = other.getPunishTarget();
        if (other.getTargetCode() != null)
            this.targetCode = other.getTargetCode();
        if (other.getTargetPaperType() != null)
            this.targetPaperType = other.getTargetPaperType();
        if (other.getTargetPaperNumber() != null)
            this.targetPaperNumber = other.getTargetPaperNumber();
        if (other.getTargetPhone() != null)
            this.targetPhone = other.getTargetPhone();
        if (other.getTargetMobile() != null)
            this.targetMobile = other.getTargetMobile();
        if (other.getTargetAddress() != null)
            this.targetAddress = other.getTargetAddress();
        if (other.getTargetZipCode() != null)
            this.targetZipCode = other.getTargetZipCode();
        if (other.getTargetEmail() != null)
            this.targetEmail = other.getTargetEmail();
        if (other.getReporter() != null)
            this.reporter = other.getReporter();
        if (other.getReporterDate() != null)
            this.reporterDate = other.getReporterDate();
        if (other.getReporterPaperType() != null)
            this.reporterPaperType = other.getReporterPaperType();
        if (other.getReporterAperCode() != null)
            this.reporterAperCode = other.getReporterAperCode();
        if (other.getReporterPhone() != null)
            this.reporterPhone = other.getReporterPhone();
        if (other.getReporterMobile() != null)
            this.reporterMobile = other.getReporterMobile();
        if (other.getReporterAddress() != null)
            this.reporterAddress = other.getReporterAddress();
        if (other.getReporterZipcode() != null)
            this.reporterZipcode = other.getReporterZipcode();
        if (other.getReporterEmail() != null)
            this.reporterEmail = other.getReporterEmail();
        if (other.getContent() != null)
            this.content = other.getContent();
        if (other.getForm() != null)
            this.form = other.getForm();
        if (other.getPromise() != null)
            this.promise = other.getPromise();
        if (other.getPromiseType() != null)
            this.promiseType = other.getPromiseType();
        if (other.getIsrisk() != null)
            this.isrisk = other.getIsrisk();
        if (other.getRisktype() != null)
            this.risktype = other.getRisktype();
        if (other.getRiskdescription() != null)
            this.riskdescription = other.getRiskdescription();
        if (other.getRiskresult() != null)
            this.riskresult = other.getRiskresult();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getSyncDate() != null)
            this.syncDate = other.getSyncDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getSyncErrorDesc() != null)
            this.syncErrorDesc = other.getSyncErrorDesc();
        if (other.getIsTrack() != null)
            this.isTrack = other.getIsTrack();
        if (other.getBmcj() != null)
            this.bmcj = other.getBmcj();

    }

    public void clearProperties() {

        this.changNo = null;
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.department = null;
        this.ajAddr = null;
        this.ajOccurDate = null;
        this.source = null;
        this.fact = null;
        this.targetType = null;
        this.punishTarget = null;
        this.targetCode = null;
        this.targetPaperType = null;
        this.targetPaperNumber = null;
        this.targetPhone = null;
        this.targetMobile = null;
        this.targetAddress = null;
        this.targetZipCode = null;
        this.targetEmail = null;
        this.reporter = null;
        this.reporterDate = null;
        this.reporterPaperType = null;
        this.reporterAperCode = null;
        this.reporterPhone = null;
        this.reporterMobile = null;
        this.reporterAddress = null;
        this.reporterZipcode = null;
        this.reporterEmail = null;
        this.content = null;
        this.form = null;
        this.promise = null;
        this.promiseType = null;
        this.isrisk = null;
        this.risktype = null;
        this.riskdescription = null;
        this.riskresult = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;
        this.isTrack = null;
        this.bmcj = null;
    }
}

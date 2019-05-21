package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class ApplyLog implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private ApplyLogId cid;

    private String orgId;
    private String internalNo;
    private String itemId;
    private String itemType;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    private String department;
    private String transactAffairName;
    private String content;
    private String applyWay;
    private String form;
    private String stuff;
    private String applicantCode;
    private String applicantType;
    private String applicantName;
    private String applicantPaperType;
    private String applicantPaperCode;
    private String applicantPhone;
    private String applicantMobile;
    private String applicantAddress;
    private String applicantZipcode;
    private String applicantEmail;
    private String linkman;
    private String linkmanName;
    private String linkmanPaperType;
    private String linkmanPaperCode;
    private String linkmanPhone;
    private String linkmanMobile;
    private String linkmanAddress;
    private String linkmanZipcode;
    private String linkmanEmail;
    private Long promise;
    private String promiseType;
    private Long isrisk;
    private String risktype;
    private String riskdescription;
    private String riskresult;
    private Date applyDate;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;

    // Constructors
    /** default constructor */
    public ApplyLog() {
    }

    /** minimal constructor */
    public ApplyLog(ApplyLogId id

    , String orgId, String internalNo, String itemId, String department,
            String transactAffairName, String content, String applyWay,
            String form, String applicantType, String applicantName,
            Long promise, String promiseType, Date applyDate, Date createDate,
            Date updateDate) {
        this.cid = id;

        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.transactAffairName = transactAffairName;
        this.content = content;
        this.applyWay = applyWay;
        this.form = form;
        this.applicantType = applicantType;
        this.applicantName = applicantName;
        this.promise = promise;
        this.promiseType = promiseType;
        this.applyDate = applyDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public ApplyLog(ApplyLogId id

    , String orgId, String internalNo, String itemId, String department,
            String transactAffairName, String content, String applyWay,
            String form, String stuff, String applicantCode,
            String applicantType, String applicantName,
            String applicantPaperType, String applicantPaperCode,
            String applicantPhone, String applicantMobile,
            String applicantAddress, String applicantZipcode,
            String applicantEmail, String linkman, String linkmanName,
            String linkmanPaperType, String linkmanPaperCode,
            String linkmanPhone, String linkmanMobile, String linkmanAddress,
            String linkmanZipcode, String linkmanEmail, Long promise,
            String promiseType, Long isrisk, String risktype,
            String riskdescription, String riskresult, Date applyDate,
            Date createDate, Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {
        this.cid = id;

        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.transactAffairName = transactAffairName;
        this.content = content;
        this.applyWay = applyWay;
        this.form = form;
        this.stuff = stuff;
        this.applicantCode = applicantCode;
        this.applicantType = applicantType;
        this.applicantName = applicantName;
        this.applicantPaperType = applicantPaperType;
        this.applicantPaperCode = applicantPaperCode;
        this.applicantPhone = applicantPhone;
        this.applicantMobile = applicantMobile;
        this.applicantAddress = applicantAddress;
        this.applicantZipcode = applicantZipcode;
        this.applicantEmail = applicantEmail;
        this.linkman = linkman;
        this.linkmanName = linkmanName;
        this.linkmanPaperType = linkmanPaperType;
        this.linkmanPaperCode = linkmanPaperCode;
        this.linkmanPhone = linkmanPhone;
        this.linkmanMobile = linkmanMobile;
        this.linkmanAddress = linkmanAddress;
        this.linkmanZipcode = linkmanZipcode;
        this.linkmanEmail = linkmanEmail;
        this.promise = promise;
        this.promiseType = promiseType;
        this.isrisk = isrisk;
        this.risktype = risktype;
        this.riskdescription = riskdescription;
        this.riskresult = riskresult;
        this.applyDate = applyDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public ApplyLogId getCid() {
        return this.cid;
    }

    public void setCid(ApplyLogId id) {
        this.cid = id;
    }

    public String getNo() {
        if (this.cid == null)
            this.cid = new ApplyLogId();
        return this.cid.getNo();
    }

    public void setNo(String no) {
        if (this.cid == null)
            this.cid = new ApplyLogId();
        this.cid.setNo(no);
    }

    public Long getChangNo() {
        if (this.cid == null)
            this.cid = new ApplyLogId();
        return this.cid.getChangNo();
    }

    public void setChangNo(Long changNo) {
        if (this.cid == null)
            this.cid = new ApplyLogId();
        this.cid.setChangNo(changNo);
    }

    // Property accessors

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

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTransactAffairName() {
        return this.transactAffairName;
    }

    public void setTransactAffairName(String transactAffairName) {
        this.transactAffairName = transactAffairName;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApplyWay() {
        return this.applyWay;
    }

    public void setApplyWay(String applyWay) {
        this.applyWay = applyWay;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getStuff() {
        return this.stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public String getApplicantCode() {
        return this.applicantCode;
    }

    public void setApplicantCode(String applicantCode) {
        this.applicantCode = applicantCode;
    }

    public String getApplicantType() {
        return this.applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getApplicantName() {
        return this.applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantPaperType() {
        return this.applicantPaperType;
    }

    public void setApplicantPaperType(String applicantPaperType) {
        this.applicantPaperType = applicantPaperType;
    }

    public String getApplicantPaperCode() {
        return this.applicantPaperCode;
    }

    public void setApplicantPaperCode(String applicantPaperCode) {
        this.applicantPaperCode = applicantPaperCode;
    }

    public String getApplicantPhone() {
        return this.applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicantMobile() {
        return this.applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getApplicantAddress() {
        return this.applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantZipcode() {
        return this.applicantZipcode;
    }

    public void setApplicantZipcode(String applicantZipcode) {
        this.applicantZipcode = applicantZipcode;
    }

    public String getApplicantEmail() {
        return this.applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getLinkman() {
        return this.linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanName() {
        return this.linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanPaperType() {
        return this.linkmanPaperType;
    }

    public void setLinkmanPaperType(String linkmanPaperType) {
        this.linkmanPaperType = linkmanPaperType;
    }

    public String getLinkmanPaperCode() {
        return this.linkmanPaperCode;
    }

    public void setLinkmanPaperCode(String linkmanPaperCode) {
        this.linkmanPaperCode = linkmanPaperCode;
    }

    public String getLinkmanPhone() {
        return this.linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getLinkmanMobile() {
        return this.linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    public String getLinkmanAddress() {
        return this.linkmanAddress;
    }

    public void setLinkmanAddress(String linkmanAddress) {
        this.linkmanAddress = linkmanAddress;
    }

    public String getLinkmanZipcode() {
        return this.linkmanZipcode;
    }

    public void setLinkmanZipcode(String linkmanZipcode) {
        this.linkmanZipcode = linkmanZipcode;
    }

    public String getLinkmanEmail() {
        return this.linkmanEmail;
    }

    public void setLinkmanEmail(String linkmanEmail) {
        this.linkmanEmail = linkmanEmail;
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

    public Date getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public void copy(ApplyLog other) {

        this.setNo(other.getNo());
        this.setChangNo(other.getChangNo());

        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.department = other.getDepartment();
        this.transactAffairName = other.getTransactAffairName();
        this.content = other.getContent();
        this.applyWay = other.getApplyWay();
        this.form = other.getForm();
        this.stuff = other.getStuff();
        this.applicantCode = other.getApplicantCode();
        this.applicantType = other.getApplicantType();
        this.applicantName = other.getApplicantName();
        this.applicantPaperType = other.getApplicantPaperType();
        this.applicantPaperCode = other.getApplicantPaperCode();
        this.applicantPhone = other.getApplicantPhone();
        this.applicantMobile = other.getApplicantMobile();
        this.applicantAddress = other.getApplicantAddress();
        this.applicantZipcode = other.getApplicantZipcode();
        this.applicantEmail = other.getApplicantEmail();
        this.linkman = other.getLinkman();
        this.linkmanName = other.getLinkmanName();
        this.linkmanPaperType = other.getLinkmanPaperType();
        this.linkmanPaperCode = other.getLinkmanPaperCode();
        this.linkmanPhone = other.getLinkmanPhone();
        this.linkmanMobile = other.getLinkmanMobile();
        this.linkmanAddress = other.getLinkmanAddress();
        this.linkmanZipcode = other.getLinkmanZipcode();
        this.linkmanEmail = other.getLinkmanEmail();
        this.promise = other.getPromise();
        this.promiseType = other.getPromiseType();
        this.isrisk = other.getIsrisk();
        this.risktype = other.getRisktype();
        this.riskdescription = other.getRiskdescription();
        this.riskresult = other.getRiskresult();
        this.applyDate = other.getApplyDate();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();

    }

    public void copyNotNullProperty(ApplyLog other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());
        if (other.getChangNo() != null)
            this.setChangNo(other.getChangNo());

        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getDepartment() != null)
            this.department = other.getDepartment();
        if (other.getTransactAffairName() != null)
            this.transactAffairName = other.getTransactAffairName();
        if (other.getContent() != null)
            this.content = other.getContent();
        if (other.getApplyWay() != null)
            this.applyWay = other.getApplyWay();
        if (other.getForm() != null)
            this.form = other.getForm();
        if (other.getStuff() != null)
            this.stuff = other.getStuff();
        if (other.getApplicantCode() != null)
            this.applicantCode = other.getApplicantCode();
        if (other.getApplicantType() != null)
            this.applicantType = other.getApplicantType();
        if (other.getApplicantName() != null)
            this.applicantName = other.getApplicantName();
        if (other.getApplicantPaperType() != null)
            this.applicantPaperType = other.getApplicantPaperType();
        if (other.getApplicantPaperCode() != null)
            this.applicantPaperCode = other.getApplicantPaperCode();
        if (other.getApplicantPhone() != null)
            this.applicantPhone = other.getApplicantPhone();
        if (other.getApplicantMobile() != null)
            this.applicantMobile = other.getApplicantMobile();
        if (other.getApplicantAddress() != null)
            this.applicantAddress = other.getApplicantAddress();
        if (other.getApplicantZipcode() != null)
            this.applicantZipcode = other.getApplicantZipcode();
        if (other.getApplicantEmail() != null)
            this.applicantEmail = other.getApplicantEmail();
        if (other.getLinkman() != null)
            this.linkman = other.getLinkman();
        if (other.getLinkmanName() != null)
            this.linkmanName = other.getLinkmanName();
        if (other.getLinkmanPaperType() != null)
            this.linkmanPaperType = other.getLinkmanPaperType();
        if (other.getLinkmanPaperCode() != null)
            this.linkmanPaperCode = other.getLinkmanPaperCode();
        if (other.getLinkmanPhone() != null)
            this.linkmanPhone = other.getLinkmanPhone();
        if (other.getLinkmanMobile() != null)
            this.linkmanMobile = other.getLinkmanMobile();
        if (other.getLinkmanAddress() != null)
            this.linkmanAddress = other.getLinkmanAddress();
        if (other.getLinkmanZipcode() != null)
            this.linkmanZipcode = other.getLinkmanZipcode();
        if (other.getLinkmanEmail() != null)
            this.linkmanEmail = other.getLinkmanEmail();
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
        if (other.getApplyDate() != null)
            this.applyDate = other.getApplyDate();
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

    }

    public void clearProperties() {

        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.department = null;
        this.transactAffairName = null;
        this.content = null;
        this.applyWay = null;
        this.form = null;
        this.stuff = null;
        this.applicantCode = null;
        this.applicantType = null;
        this.applicantName = null;
        this.applicantPaperType = null;
        this.applicantPaperCode = null;
        this.applicantPhone = null;
        this.applicantMobile = null;
        this.applicantAddress = null;
        this.applicantZipcode = null;
        this.applicantEmail = null;
        this.linkman = null;
        this.linkmanName = null;
        this.linkmanPaperType = null;
        this.linkmanPaperCode = null;
        this.linkmanPhone = null;
        this.linkmanMobile = null;
        this.linkmanAddress = null;
        this.linkmanZipcode = null;
        this.linkmanEmail = null;
        this.promise = null;
        this.promiseType = null;
        this.isrisk = null;
        this.risktype = null;
        this.riskdescription = null;
        this.riskresult = null;
        this.applyDate = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;

    }
}

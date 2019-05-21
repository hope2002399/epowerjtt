package com.centit.dispatchdoc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.centit.powerruntime.po.OptBaseInfo;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class IncomeDoc implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String djId;

    private String internalNo;
    private String itemId;
    private String acceptNo;
    private String incomeDocNo;
    private String incomeDocTitle;
    private String incomeDeptName;
    private String incomeDocFileName;
    private byte[] incomeDocFile;
    private String syncErrorDesc;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String flowCode;

    private String applicantPeopleName;
    private String applicantName;
    private String applicantPhone;
    private String applicantMobile;
    private String applicantEmail;
    private String linkmanName;
    private List<IncomeDoc> docList = new ArrayList<IncomeDoc>();

    private OptBaseInfo optBaseInfo;

    // Constructors
    /** default constructor */
    public IncomeDoc() {
    }

    /** minimal constructor */
    public IncomeDoc(String djId, String internalNo, String itemId,
            Date createDate, Date updateDate) {

        this.djId = djId;

        this.internalNo = internalNo;
        this.itemId = itemId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public IncomeDoc(String djId, String internalNo, String itemId,
            String acceptNo, String incomeDocNo, String incomeDocTitle,
            String incomeDeptName, String incomeDocFileName,
            byte[] incomeDocFile, String syncErrorDesc, Date createDate,
            Date updateDate, Date syncDate, String syncSign) {

        this.djId = djId;

        this.internalNo = internalNo;
        this.itemId = itemId;
        this.acceptNo = acceptNo;
        this.incomeDocNo = incomeDocNo;
        this.incomeDocTitle = incomeDocTitle;
        this.incomeDeptName = incomeDeptName;
        this.incomeDocFileName = incomeDocFileName;
        this.incomeDocFile = incomeDocFile;
        this.syncErrorDesc = syncErrorDesc;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
    }

    public String getDjId() {
        return this.djId;
    }

    public void setDjId(String djId) {
        this.djId = djId;
    }

    // Property accessors

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

    public String getAcceptNo() {
        return this.acceptNo;
    }

    public void setAcceptNo(String acceptNo) {
        this.acceptNo = acceptNo;
    }

    public String getIncomeDocNo() {
        return this.incomeDocNo;
    }

    public void setIncomeDocNo(String incomeDocNo) {
        this.incomeDocNo = incomeDocNo;
    }

    public String getIncomeDocTitle() {
        return this.incomeDocTitle;
    }

    public void setIncomeDocTitle(String incomeDocTitle) {
        this.incomeDocTitle = incomeDocTitle;
    }

    public String getIncomeDeptName() {
        return this.incomeDeptName;
    }

    public void setIncomeDeptName(String incomeDeptName) {
        this.incomeDeptName = incomeDeptName;
    }

    public String getIncomeDocFileName() {
        return this.incomeDocFileName;
    }

    public void setIncomeDocFileName(String incomeDocFileName) {
        this.incomeDocFileName = incomeDocFileName;
    }

    public byte[] getIncomeDocFile() {
        return this.incomeDocFile;
    }

    public void setIncomeDocFile(byte[] incomeDocFile) {
        this.incomeDocFile = incomeDocFile;
    }

    public String getSyncErrorDesc() {
        return this.syncErrorDesc;
    }

    public void setSyncErrorDesc(String syncErrorDesc) {
        this.syncErrorDesc = syncErrorDesc;
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

    public void copy(IncomeDoc other) {

        this.setDjId(other.getDjId());

        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.acceptNo = other.getAcceptNo();
        this.incomeDocNo = other.getIncomeDocNo();
        this.incomeDocTitle = other.getIncomeDocTitle();
        this.incomeDeptName = other.getIncomeDeptName();
        this.incomeDocFileName = other.getIncomeDocFileName();
        this.incomeDocFile = other.getIncomeDocFile();
        this.syncErrorDesc = other.getSyncErrorDesc();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.flowCode = other.getFlowCode();
        this.incomeDocFileName = other.getIncomeDocFileName();
    }

    public void copyNotNullProperty(IncomeDoc other) {

        if (other.getDjId() != null)
            this.setDjId(other.getDjId());

        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getAcceptNo() != null)
            this.acceptNo = other.getAcceptNo();
        if (other.getIncomeDocNo() != null)
            this.incomeDocNo = other.getIncomeDocNo();
        if (other.getIncomeDocTitle() != null)
            this.incomeDocTitle = other.getIncomeDocTitle();
        if (other.getIncomeDeptName() != null)
            this.incomeDeptName = other.getIncomeDeptName();
        if (other.getIncomeDocFileName() != null)
            this.incomeDocFileName = other.getIncomeDocFileName();
        if (other.getIncomeDocFile() != null)
            this.incomeDocFile = other.getIncomeDocFile();
        if (other.getSyncErrorDesc() != null)
            this.syncErrorDesc = other.getSyncErrorDesc();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getSyncDate() != null)
            this.syncDate = other.getSyncDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getFlowCode() != null)
            this.flowCode = other.getFlowCode();
        if (other.getIncomeDocFileName() != null)
            this.incomeDocFileName = other.getIncomeDocFileName();

    }

    public void clearProperties() {

        this.internalNo = null;
        this.itemId = null;
        this.acceptNo = null;
        this.incomeDocNo = null;
        this.incomeDocTitle = null;
        this.incomeDeptName = null;
        this.incomeDocFileName = null;
        this.incomeDocFile = null;
        this.syncErrorDesc = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.flowCode = null;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public OptBaseInfo getOptBaseInfo() {
        return optBaseInfo;
    }

    public void setOptBaseInfo(OptBaseInfo optBaseInfo) {
        this.optBaseInfo = optBaseInfo;
    }

    public String getApplicantPeopleName() {
        return applicantPeopleName;
    }

    public void setApplicantPeopleName(String applicantPeopleName) {
        this.applicantPeopleName = applicantPeopleName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public List<IncomeDoc> getDocList() {
        return docList;
    }

    public void setDocList(List<IncomeDoc> docList) {
        this.docList = docList;
    }
}

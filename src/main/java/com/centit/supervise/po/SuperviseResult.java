package com.centit.supervise.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class SuperviseResult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private String superviseNo;
    // private String monitorNo;
    private Date endDate;
    private String backOperatorId;
    private String backOperatorName;
    private Date receiptDate;
    private String superviseBack;
    private String confirm;
    private Long isExternal;
    private String superviseResult;
    private String endoperatorid;
    private String endOpinion;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;

    // Constructors
    /** default constructor */
    public SuperviseResult() {
    }

    /** minimal constructor */
    public SuperviseResult(String no, Date endDate, String confirm,
            Date updateDate) {

        this.no = no;
        this.endDate = endDate;
        this.confirm = confirm;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public SuperviseResult(String no, String superviseNo, Date endDate,
            String backOperatorId, String backOperatorName, Date receiptDate,
            String superviseBack, String confirm, Long isExternal,
            String superviseResult, String endoperatorid, String endOpinion,
            Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {

        this.no = no;

        this.superviseNo = superviseNo;
        this.endDate = endDate;
        this.backOperatorId = backOperatorId;
        this.backOperatorName = backOperatorName;
        this.receiptDate = receiptDate;
        this.superviseBack = superviseBack;
        this.confirm = confirm;
        this.isExternal = isExternal;
        this.superviseResult = superviseResult;
        this.endoperatorid = endoperatorid;
        this.endOpinion = endOpinion;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // Property accessors

    public String getSuperviseNo() {
        return this.superviseNo;
    }

    public void setSuperviseNo(String superviseNo) {
        this.superviseNo = superviseNo;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBackOperatorId() {
        return this.backOperatorId;
    }

    public void setBackOperatorId(String backOperatorId) {
        this.backOperatorId = backOperatorId;
    }

    public String getBackOperatorName() {
        return this.backOperatorName;
    }

    public void setBackOperatorName(String backOperatorName) {
        this.backOperatorName = backOperatorName;
    }

    public Date getReceiptDate() {
        return this.receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getSuperviseBack() {
        return this.superviseBack;
    }

    public void setSuperviseBack(String superviseBack) {
        this.superviseBack = superviseBack;
    }

    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public Long getIsExternal() {
        return this.isExternal;
    }

    public void setIsExternal(Long isExternal) {
        this.isExternal = isExternal;
    }

    public String getSuperviseResult() {
        return this.superviseResult;
    }

    public void setSuperviseResult(String superviseResult) {
        this.superviseResult = superviseResult;
    }

    public String getEndoperatorid() {
        return this.endoperatorid;
    }

    public void setEndoperatorid(String endoperatorid) {
        this.endoperatorid = endoperatorid;
    }

    public String getEndOpinion() {
        return this.endOpinion;
    }

    public void setEndOpinion(String endOpinion) {
        this.endOpinion = endOpinion;
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

    public void copy(SuperviseResult other) {

        this.setNo(other.getNo());

        this.superviseNo = other.getSuperviseNo();
        this.endDate = other.getEndDate();
        this.backOperatorId = other.getBackOperatorId();
        this.backOperatorName = other.getBackOperatorName();
        this.receiptDate = other.getReceiptDate();
        this.superviseBack = other.getSuperviseBack();
        this.confirm = other.getConfirm();
        this.isExternal = other.getIsExternal();
        this.superviseResult = other.getSuperviseResult();
        this.endoperatorid = other.getEndoperatorid();
        this.endOpinion = other.getEndOpinion();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();

    }

    public void copyNotNullProperty(SuperviseResult other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getSuperviseNo() != null)
            this.superviseNo = other.getSuperviseNo();
        if (other.getEndDate() != null)
            this.endDate = other.getEndDate();
        if (other.getBackOperatorId() != null)
            this.backOperatorId = other.getBackOperatorId();
        if (other.getBackOperatorName() != null)
            this.backOperatorName = other.getBackOperatorName();
        if (other.getReceiptDate() != null)
            this.receiptDate = other.getReceiptDate();
        if (other.getSuperviseBack() != null)
            this.superviseBack = other.getSuperviseBack();
        if (other.getConfirm() != null)
            this.confirm = other.getConfirm();
        if (other.getIsExternal() != null)
            this.isExternal = other.getIsExternal();
        if (other.getSuperviseResult() != null)
            this.superviseResult = other.getSuperviseResult();
        if (other.getEndoperatorid() != null)
            this.endoperatorid = other.getEndoperatorid();
        if (other.getEndOpinion() != null)
            this.endOpinion = other.getEndOpinion();
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

        this.superviseNo = null;
        this.endDate = null;
        this.backOperatorId = null;
        this.backOperatorName = null;
        this.receiptDate = null;
        this.superviseBack = null;
        this.confirm = null;
        this.isExternal = null;
        this.superviseResult = null;
        this.endoperatorid = null;
        this.endOpinion = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;

    }
}

package com.centit.complaint.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class ComplaintsResult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private String complaintid;
    private String type;
    private String detail;
    private String operatorId;
    private String operatorName;
    private Date resultDate;
    private String opinion;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;
    private String cobackResult;
    private String cobackRemark;
    private Date cobackDate;
    private String cobackoperatorId;

    public Date getCobackDate() {
        return cobackDate;
    }

    public void setCobackDate(Date cobackDate) {
        this.cobackDate = cobackDate;
    }

    public String getCobackoperatorId() {
        return cobackoperatorId;
    }

    public void setCobackoperatorId(String cobackoperatorId) {
        this.cobackoperatorId = cobackoperatorId;
    }

    public String getCobackResult() {
        return cobackResult;
    }

    public void setCobackResult(String cobackResult) {
        this.cobackResult = cobackResult;
    }

    public String getCobackRemark() {
        return cobackRemark;
    }

    public void setCobackRemark(String cobackRemark) {
        this.cobackRemark = cobackRemark;
    }

    // Constructors
    /** default constructor */
    public ComplaintsResult() {
    }

    /** minimal constructor */
    public ComplaintsResult(String no, String type, Date resultDate,
            String opinion, Date updateDate) {

        this.no = no;

        this.type = type;
        this.resultDate = resultDate;
        this.opinion = opinion;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public ComplaintsResult(String no, String complaintid, String type,
            String detail, String operatorId, String operatorName,
            Date resultDate, String opinion, Date updateDate, Date syncDate,
            String syncSign, String syncErrorDesc) {

        this.no = no;

        this.complaintid = complaintid;
        this.type = type;
        this.detail = detail;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.resultDate = resultDate;
        this.opinion = opinion;
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

    public String getComplaintid() {
        return this.complaintid;
    }

    public void setComplaintid(String complaintid) {
        this.complaintid = complaintid;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getResultDate() {
        return this.resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
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

    public void copy(ComplaintsResult other) {

        this.setNo(other.getNo());

        this.complaintid = other.getComplaintid();
        this.type = other.getType();
        this.detail = other.getDetail();
        this.operatorId = other.getOperatorId();
        this.operatorName = other.getOperatorName();
        this.resultDate = other.getResultDate();
        this.opinion = other.getOpinion();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();

    }

    public void copyNotNullProperty(ComplaintsResult other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getComplaintid() != null)
            this.complaintid = other.getComplaintid();
        if (other.getType() != null)
            this.type = other.getType();
        if (other.getDetail() != null)
            this.detail = other.getDetail();
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getOperatorName() != null)
            this.operatorName = other.getOperatorName();
        if (other.getResultDate() != null)
            this.resultDate = other.getResultDate();
        if (other.getOpinion() != null)
            this.opinion = other.getOpinion();
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

        this.complaintid = null;
        this.type = null;
        this.detail = null;
        this.operatorId = null;
        this.operatorName = null;
        this.resultDate = null;
        this.opinion = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;

    }
}

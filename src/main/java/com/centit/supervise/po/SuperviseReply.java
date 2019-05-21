package com.centit.supervise.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class SuperviseReply implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String processNo;
    private Long nodeInstId;
    private String superviseNo;
    private String processCode;
    private String processName;
    private Date processDate;
    private String operatorId;
    private String operatorName;
    private String operatorResult;
    private String operatorOpinion;
    private String attachment;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;

    // Constructors
    /** default constructor */
    public SuperviseReply() {
    }

    /** minimal constructor */
    public SuperviseReply(Long nodeInstId, Date processDate,
            String operatorOpinion, Date updateDate) {

        this.nodeInstId = nodeInstId;

        this.processDate = processDate;
        this.operatorOpinion = operatorOpinion;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public SuperviseReply(Long nodeInstId, String superviseNo,
            String processCode, String processName, Date processDate,
            String operatorId, String operatorName, String operatorResult,
            String operatorOpinion, String attachment, Date updateDate,
            Date syncDate, String syncSign, String syncErrorDesc) {

        this.nodeInstId = nodeInstId;

        this.superviseNo = superviseNo;
        this.processCode = processCode;
        this.processName = processName;
        this.processDate = processDate;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorResult = operatorResult;
        this.operatorOpinion = operatorOpinion;
        this.attachment = attachment;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public Long getNodeInstId() {
        return this.nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public SuperviseReply(String processNo, Long nodeInstId,
            String superviseNo, String processCode, String processName,
            Date processDate, String operatorId, String operatorName,
            String operatorResult, String operatorOpinion, String attachment,
            Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {
        super();
        this.processNo = processNo;
        this.nodeInstId = nodeInstId;
        this.superviseNo = superviseNo;
        this.processCode = processCode;
        this.processName = processName;
        this.processDate = processDate;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorResult = operatorResult;
        this.operatorOpinion = operatorOpinion;
        this.attachment = attachment;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    // Property accessors

    public SuperviseReply(String processNo, Long nodeInstId,
            String superviseNo, String processCode, String processName,
            Date processDate, String operatorId, String operatorName,
            String operatorResult, String operatorOpinion) {
        super();
        this.processNo = processNo;
        this.nodeInstId = nodeInstId;
        this.superviseNo = superviseNo;
        this.processCode = processCode;
        this.processName = processName;
        this.processDate = processDate;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.operatorResult = operatorResult;
        this.operatorOpinion = operatorOpinion;
    }

    public String getSuperviseNo() {
        return this.superviseNo;
    }

    public void setSuperviseNo(String superviseNo) {
        this.superviseNo = superviseNo;
    }

    public String getProcessCode() {
        return this.processCode;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getProcessDate() {
        return this.processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
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

    public String getOperatorResult() {
        return this.operatorResult;
    }

    public void setOperatorResult(String operatorResult) {
        this.operatorResult = operatorResult;
    }

    public String getOperatorOpinion() {
        return this.operatorOpinion;
    }

    public void setOperatorOpinion(String operatorOpinion) {
        this.operatorOpinion = operatorOpinion;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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

    public void copy(SuperviseReply other) {
        this.setProcessNo(other.getProcessNo());
        this.nodeInstId = other.getNodeInstId();
        this.superviseNo = other.getSuperviseNo();
        this.processCode = other.getProcessCode();
        this.processName = other.getProcessName();
        this.processDate = other.getProcessDate();
        this.operatorId = other.getOperatorId();
        this.operatorName = other.getOperatorName();
        this.operatorResult = other.getOperatorResult();
        this.operatorOpinion = other.getOperatorOpinion();
        this.attachment = other.getAttachment();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();

    }

    public void copyNotNullProperty(SuperviseReply other) {

        if (other.getProcessNo() != null)
            this.setProcessNo(other.getProcessNo());
        if (other.getNodeInstId() != null)
            this.nodeInstId = other.getNodeInstId();
        if (other.getSuperviseNo() != null)
            this.superviseNo = other.getSuperviseNo();
        if (other.getProcessCode() != null)
            this.processCode = other.getProcessCode();
        if (other.getProcessName() != null)
            this.processName = other.getProcessName();
        if (other.getProcessDate() != null)
            this.processDate = other.getProcessDate();
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getOperatorName() != null)
            this.operatorName = other.getOperatorName();
        if (other.getOperatorResult() != null)
            this.operatorResult = other.getOperatorResult();
        if (other.getOperatorOpinion() != null)
            this.operatorOpinion = other.getOperatorOpinion();
        if (other.getAttachment() != null)
            this.attachment = other.getAttachment();
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
        this.nodeInstId = null;
        this.superviseNo = null;
        this.processCode = null;
        this.processName = null;
        this.processDate = null;
        this.operatorId = null;
        this.operatorName = null;
        this.operatorResult = null;
        this.operatorOpinion = null;
        this.attachment = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;

    }
}

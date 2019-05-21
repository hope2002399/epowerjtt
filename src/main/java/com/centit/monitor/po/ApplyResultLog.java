package com.centit.monitor.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class ApplyResultLog implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private ApplyResultLogId cid;

    private String orgId;
    private String internalNo;
    private String itemId;
    private String status;
    private String note;
    private String attachment;
    private Date finishTime;
    private Double receivable;
    private Double paid;
    private String reliefReasons;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;

    // Constructors
    /** default constructor */
    public ApplyResultLog() {
    }

    /** minimal constructor */
    public ApplyResultLog(ApplyResultLogId id

    , String orgId, String internalNo, String itemId, String status,
            String note, String attachment, Date finishTime, Date createDate,
            Date updateDate) {
        this.cid = id;

        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.status = status;
        this.note = note;
        this.attachment = attachment;
        this.finishTime = finishTime;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public ApplyResultLog(ApplyResultLogId id

    , String orgId, String internalNo, String itemId, String status,
            String note, String attachment, Date finishTime, Double receivable,
            Double paid, String reliefReasons, Date createDate,
            Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {
        this.cid = id;

        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.status = status;
        this.note = note;
        this.attachment = attachment;
        this.finishTime = finishTime;
        this.receivable = receivable;
        this.paid = paid;
        this.reliefReasons = reliefReasons;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public ApplyResultLogId getCid() {
        return this.cid;
    }

    public void setCid(ApplyResultLogId id) {
        this.cid = id;
    }

    public String getNo() {
        if (this.cid == null)
            this.cid = new ApplyResultLogId();
        return this.cid.getNo();
    }

    public void setNo(String no) {
        if (this.cid == null)
            this.cid = new ApplyResultLogId();
        this.cid.setNo(no);
    }

    public Long getChangNo() {
        if (this.cid == null)
            this.cid = new ApplyResultLogId();
        return this.cid.getChangNo();
    }

    public void setChangNo(Long changNo) {
        if (this.cid == null)
            this.cid = new ApplyResultLogId();
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Double getReceivable() {
        return this.receivable;
    }

    public void setReceivable(Double receivable) {
        this.receivable = receivable;
    }

    public Double getPaid() {
        return this.paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public String getReliefReasons() {
        return this.reliefReasons;
    }

    public void setReliefReasons(String reliefReasons) {
        this.reliefReasons = reliefReasons;
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

    public void copy(ApplyResultLog other) {

        this.setNo(other.getNo());
        this.setChangNo(other.getChangNo());

        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.status = other.getStatus();
        this.note = other.getNote();
        this.attachment = other.getAttachment();
        this.finishTime = other.getFinishTime();
        this.receivable = other.getReceivable();
        this.paid = other.getPaid();
        this.reliefReasons = other.getReliefReasons();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();

    }

    public void copyNotNullProperty(ApplyResultLog other) {

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
        if (other.getStatus() != null)
            this.status = other.getStatus();
        if (other.getNote() != null)
            this.note = other.getNote();
        if (other.getAttachment() != null)
            this.attachment = other.getAttachment();
        if (other.getFinishTime() != null)
            this.finishTime = other.getFinishTime();
        if (other.getReceivable() != null)
            this.receivable = other.getReceivable();
        if (other.getPaid() != null)
            this.paid = other.getPaid();
        if (other.getReliefReasons() != null)
            this.reliefReasons = other.getReliefReasons();
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
        this.status = null;
        this.note = null;
        this.attachment = null;
        this.finishTime = null;
        this.receivable = null;
        this.paid = null;
        this.reliefReasons = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;

    }
}

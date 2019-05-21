package com.centit.monitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class ApplyResult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String no;
    private Long changNo;
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
    @SuppressWarnings("rawtypes")
    private List docList = new ArrayList();

    @SuppressWarnings("rawtypes")
    public List getDocList() {
        return docList;
    }

    @SuppressWarnings("rawtypes")
    public void setDocList(List docList) {
        this.docList = docList;
    }

    // Constructors
    /** default constructor */
    public ApplyResult() {
    }

    /** minimal constructor */
    public ApplyResult(String no, Long changNo, String orgId,
            String internalNo, String itemId, String status, String note,
            String attachment, Date finishTime, Date createDate, Date updateDate) {

        this.no = no;

        this.changNo = changNo;
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
    public ApplyResult(String no, Long changNo, String orgId,
            String internalNo, String itemId, String status, String note,
            String attachment, Date finishTime, Double receivable, Double paid,
            String reliefReasons, Date createDate, Date updateDate,
            Date syncDate, String syncSign, String syncErrorDesc) {

        this.no = no;

        this.changNo = changNo;
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

    public String getStatus() {
        return this.status;
    }

    public String getStatusText() {
        String result = "";
        switch (Integer.parseInt(this.status)) {
        case 1:
            result = "不予受理";
            break;
        case 2:
            result = "许可";
            break;
        case 3:
            result = "不许可";
            break;
        default:
            break;
        }

        return result;
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

    public void copy(ApplyResult other) {

        this.setNo(other.getNo());

        this.changNo = other.getChangNo();
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

    public void copyNotNullProperty(ApplyResult other) {

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

        this.changNo = null;
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

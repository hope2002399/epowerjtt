package com.centit.powerbase.po;

import java.util.Date;

public class RecordApplyBasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String recordCode; //
    private String no; // NO VARCHAR2(50),
    private String operatorId; // OPERATORID VARCHAR2(8),
    private Date bookDate; // 登记时间
    private String recodeStyle;// RECODESTYLE VARCHAR2(10),
    private String recodeSource;// RECODESOURCE VARCHAR2(2),
    private Date finishDate;//
    private String remark;// 备案意见
    private String dealStep;// DEALSTEP VARCHAR2(4),
    private String finishStatus;// FINISHSTATUS CHAR(1) default 0

    /*
     * default constructor
     */
    public RecordApplyBasic() {
    }

    /*
     * all fields constructor
     */
    public RecordApplyBasic(String recordCode, String no, String operatorId,
            Date bookDate, String recodeStyle, String recodeSource,
            Date finishDate, String remark, String dealStep,
            String finishStatus, Date begTime, Date endTime) {
        this.recordCode = recordCode;
        this.no = no;
        this.operatorId = operatorId;
        this.bookDate = bookDate;
        this.recodeStyle = recodeStyle;
        this.recodeSource = recodeSource;
        this.finishDate = finishDate;
        this.remark = remark;
        this.dealStep = dealStep;
        this.finishStatus = finishStatus;
    }

    public void copy(RecordApplyBasic other) {
        this.recordCode = other.recordCode;
        this.no = other.no;
        this.operatorId = other.operatorId;
        this.bookDate = other.bookDate;
        this.recodeStyle = other.recodeStyle;
        this.recodeSource = other.recodeSource;
        this.finishDate = other.finishDate;
        this.remark = other.remark;
        this.dealStep = other.dealStep;
        this.finishStatus = other.finishStatus;
    }

    public void copyNotNullProperty(RecordApplyBasic other) {
        if (other.recordCode != null)
            this.recordCode = other.recordCode;
        if (other.no != null)
            this.no = other.no;
        if (other.operatorId != null)
            this.operatorId = other.operatorId;
        if (other.bookDate != null)
            this.bookDate = other.bookDate;
        if (other.recodeStyle != null)
            this.recodeStyle = other.recodeStyle;
        if (other.recodeSource != null)
            this.recodeSource = other.recodeSource;
        if (other.finishDate != null)
            this.finishDate = other.finishDate;
        if (other.remark != null)
            this.remark = other.remark;
        if (other.dealStep != null)
            this.dealStep = other.dealStep;
        if (other.finishStatus != null)
            this.finishStatus = other.finishStatus;
    }

    public void clearProperties() {
        this.recordCode = null;
        this.no = null;
        this.operatorId = null;
        this.bookDate = null;
        this.recodeStyle = null;
        this.recodeSource = null;
        this.finishDate = null;
        this.remark = null;
        this.dealStep = null;
        this.finishStatus = null;

    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorid) {
        this.operatorId = operatorid;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getRecodeStyle() {
        return recodeStyle;
    }

    public void setRecodeStyle(String recodeStyle) {
        this.recodeStyle = recodeStyle;
    }

    public String getRecodeSource() {
        return recodeSource;
    }

    public void setRecodeSource(String recodeSource) {
        this.recodeSource = recodeSource;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDealStep() {
        return dealStep;
    }

    public void setDealStep(String dealStep) {
        this.dealStep = dealStep;
    }

    public String getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(String finishStatus) {
        this.finishStatus = finishStatus;
    }

}

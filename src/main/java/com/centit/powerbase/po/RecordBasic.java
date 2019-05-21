package com.centit.powerbase.po;

import java.util.Date;

public class RecordBasic {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
    private String recordCode;
    private String no;
    private String operatorId;
    private Date bookDate;
    private String recodeStyle;
    private byte[] applyFile;
    private String remark;
    private String dealStep;
    private String fileName;
    private String recodeSource;

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

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
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

    public byte[] getApplyFile() {
        return applyFile;
    }

    public void setApplyFile(byte[] applyFile) {
        this.applyFile = applyFile;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRecodeSource() {
        return recodeSource;
    }

    public void setRecodeSource(String recodeSource) {
        this.recodeSource = recodeSource;
    }

    public RecordBasic() {

    }

    public RecordBasic(String recordCode, String no, String operatorId,
            Date bookDate, String recodeStyle, byte[] applyFile, String remark,
            String dealStep, String fileName, String recodeSource) {
        super();
        this.recordCode = recordCode;
        this.no = no;
        this.operatorId = operatorId;
        this.bookDate = bookDate;
        this.recodeStyle = recodeStyle;
        this.applyFile = applyFile;
        this.remark = remark;
        this.dealStep = dealStep;
        this.fileName = fileName;
        this.recodeSource = recodeSource;
    }

    public void copy(RecordBasic other) {

        this.setRecordCode(other.getRecordCode());
        this.no = other.no;
        this.operatorId = other.operatorId;
        this.bookDate = other.bookDate;
        this.recodeStyle = other.recodeStyle;
        this.applyFile = other.applyFile;
        this.remark = other.remark;
        this.dealStep = other.dealStep;
        this.fileName = other.fileName;
        this.recodeSource = other.recodeSource;
    }

    public void copyNotNullProperty(RecordBasic other) {

        if (other.getRecordCode() != null)
            this.setRecordCode(other.getRecordCode());
        if (other.getNo() != null)
            this.no = other.getNo();
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getBookDate() != null)
            this.bookDate = other.getBookDate();
        if (other.getRecodeStyle() != null)
            this.recodeStyle = other.getRecodeStyle();
        if (other.getApplyFile() != null)
            this.applyFile = other.getApplyFile();
        if (other.getRemark() != null)
            this.remark = other.getRemark();
        if (other.getDealStep() != null)
            this.dealStep = other.dealStep;
        if (other.getFileName() != null)
            this.fileName = other.getFileName();
        if (other.getRecodeSource() != null)
            this.recodeSource = other.getRecodeSource();

    }

    public void clearProperties() {
        this.recordCode = null;
        this.no = null;
        this.operatorId = null;
        this.bookDate = null;
        this.recodeStyle = null;
        this.applyFile = null;
        this.remark = null;
        this.dealStep = null;
        this.fileName = null;
        this.recodeSource = null;

    }

}

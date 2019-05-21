package com.centit.powerbase.po;

import java.util.Date;

public class RecordFileStuff implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String attachNo;
    private String recordCode;
    private String processNo;
    private String attachmnetName;
    private String fileName;
    private byte[] context;
    private String fileType;
    private String memo;
    private String operatorID;
    private Date uploadDate;

    public void clearProperties() {
        this.attachNo = null;
        this.recordCode = null;
        this.processNo = null;
        this.attachmnetName = null;
        this.fileName = null;
        this.context = null;
        this.fileType = null;
        this.memo = null;
        this.operatorID = null;
        this.uploadDate = null;
    }

    public String getAttachNo() {
        return attachNo;
    }

    public void setAttachNo(String attachNo) {
        this.attachNo = attachNo;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getProcessNo() {
        return processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getAttachmnetName() {
        return attachmnetName;
    }

    public void setAttachmnetName(String attachmnetName) {
        this.attachmnetName = attachmnetName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContext() {
        return context;
    }

    public void setContext(byte[] context) {
        this.context = context;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

}

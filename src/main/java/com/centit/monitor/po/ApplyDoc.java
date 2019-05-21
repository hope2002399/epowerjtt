package com.centit.monitor.po;

import java.io.IOException;
import java.util.Date;

import sun.misc.BASE64Decoder;

import com.centit.sys.util.InFlowInfo;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class ApplyDoc implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private Date updateDate;
    private Date readDate;
    private String syncSign;
    private String errorDesc;
    private String itemId;
    private String internalNo;
    private String processNo;
    private String docNo;
    private String docType;
    private String docSort;
    private String docName;
    private String documentName;
    private String doccontent_Base64;
    private byte[] docFile;

    // Constructors
    /** default constructor */
    public ApplyDoc() {
    }

    public ApplyDoc(InFlowInfo inflowinfo, boolean isContent) {
        if (null != inflowinfo) {
            this.docName = inflowinfo.getFile_name();
            this.documentName = inflowinfo.getDocument_name();
            this.docNo = inflowinfo.getDocument_id();
            this.doccontent_Base64 = inflowinfo.getFile_content();
            if (isContent) {
                this.docFile = base642content(inflowinfo.getFile_content()
                        .substring(6, this.doccontent_Base64.length() - 1));
            }
        }
    }

    /** minimal constructor */
    public ApplyDoc(String no, Date updateDate, String itemId,
            String internalNo, String docNo, String docType, String docSort,
            String docName, String documentName) {
        this.no = no;
        this.updateDate = updateDate;
        this.itemId = itemId;
        this.internalNo = internalNo;
        this.docNo = docNo;
        this.docType = docType;
        this.docSort = docSort;
        this.docName = docName;
        this.documentName = documentName;
    }

    /** full constructor */
    public ApplyDoc(String no, Date updateDate, Date readDate, String syncSign,
            String errorDesc, String itemId, String internalNo,
            String processNo, String docNo, String docType, String docSort,
            String docName, String documentName, byte[] docFile) {

        this.no = no;

        this.updateDate = updateDate;
        this.readDate = readDate;
        this.syncSign = syncSign;
        this.errorDesc = errorDesc;
        this.itemId = itemId;
        this.internalNo = internalNo;
        this.processNo = processNo;
        this.docNo = docNo;
        this.docType = docType;
        this.docSort = docSort;
        this.docName = docName;
        this.documentName = documentName;
        this.docFile = docFile;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    // Property accessors

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getReadDate() {
        return this.readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public String getSyncSign() {
        return this.syncSign;
    }

    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getInternalNo() {
        return this.internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getProcessNo() {
        return this.processNo;
    }

    public void setProcessNo(String processNo) {
        this.processNo = processNo;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocSort() {
        return this.docSort;
    }

    public void setDocSort(String docSort) {
        this.docSort = docSort;
    }

    public String getDocName() {
        return this.docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public byte[] getDocFile() {
        return this.docFile;
    }

    public void setDocFile(byte[] docFile) {
        this.docFile = docFile;
    }

    public String getDoccontent_Base64() {
        return doccontent_Base64;
    }

    public void setDoccontent_Base64(String doccontent_Base64) {
        this.doccontent_Base64 = doccontent_Base64;
    }

    public void copy(ApplyDoc other) {
        this.setNo(other.getNo());
        this.updateDate = other.getUpdateDate();
        this.readDate = other.getReadDate();
        this.syncSign = other.getSyncSign();
        this.errorDesc = other.getErrorDesc();
        this.itemId = other.getItemId();
        this.internalNo = other.getInternalNo();
        this.processNo = other.getProcessNo();
        this.docNo = other.getDocNo();
        this.docType = other.getDocType();
        this.docSort = other.getDocSort();
        this.docName = other.getDocName();
        this.documentName = other.getDocumentName();
        this.docFile = other.getDocFile();

    }

    public void copyNotNullProperty(ApplyDoc other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getReadDate() != null)
            this.readDate = other.getReadDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getErrorDesc() != null)
            this.errorDesc = other.getErrorDesc();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getProcessNo() != null)
            this.processNo = other.getProcessNo();
        if (other.getDocNo() != null)
            this.docNo = other.getDocNo();
        if (other.getDocType() != null)
            this.docType = other.getDocType();
        if (other.getDocSort() != null)
            this.docSort = other.getDocSort();
        if (other.getDocName() != null)
            this.docName = other.getDocName();
        if (other.getDocumentName() != null)
            this.documentName = other.getDocumentName();
        if (other.getDocFile() != null)
            this.docFile = other.getDocFile();

    }

    public void clearProperties() {
        this.updateDate = null;
        this.readDate = null;
        this.syncSign = null;
        this.errorDesc = null;
        this.itemId = null;
        this.internalNo = null;
        this.processNo = null;
        this.docNo = null;
        this.docType = null;
        this.docSort = null;
        this.docName = null;
        this.documentName = null;
        this.docFile = null;
    }

    public byte[] base642content(String base64) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(base64);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
            // TODO Auto-generated catch block
        }
    }
}

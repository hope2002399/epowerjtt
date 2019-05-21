package com.centit.supervise.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class SupInfoBasicDlfx implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String superviseCode;
    private String no;
    private String complaintId;
    private String superviseType;
    private String superviseOption;
    private String superviseBack;
    private String superviseResult;
    private String operatorId;
    private Date superDate;
    private Date receiptDate;
    private Date endDate;
    private Long isExternal;
    private String isSuperviseUpload;
    private String isReceiptUpload;
    private String isEndUpload;
    private String dealStep;
    private String backOperatorName;
    private String endOperatorId;
    private Date promise;
    private String receiveOperatorList;
    private String isCheck;
    private String superviseSource;
    private String warnsortNo;
    private String orgId;
    private String superviseUploadNo;
    private String supervisionType;
    private String supervisionYear;
    private String supervisionMonth;

    public SupInfoBasicDlfx() {
    }

    public SupInfoBasicDlfx(String superviseCode, Date promise) {
        this.superviseCode = superviseCode;
        this.promise = promise;
    }

    public SupInfoBasicDlfx(String superviseCode, String no,
            String complaintId, String superviseType, String superviseOption,
            String superviseBack, String superviseResult, String operatorId,
            Date superDate, Date receiptDate, Date endDate, Long isExternal,
            String isSuperviseUpload, String isReceiptUpload,
            String isEndUpload, String dealStep, String backOperatorName,
            String endOperatorId, Date promise, String receiveOperatorList,
            String isCheck, String superviseSource, String warnsortNo,
            String orgId, String superviseUploadNo, String supervisionType,
            String supervisionYear, String supervisionMonth) {
        this.superviseCode = superviseCode;
        this.no = no;
        this.complaintId = complaintId;
        this.superviseType = superviseType;
        this.superviseOption = superviseOption;
        this.superviseBack = superviseBack;
        this.superviseResult = superviseResult;
        this.operatorId = operatorId;
        this.superDate = superDate;
        this.receiptDate = receiptDate;
        this.endDate = endDate;
        this.isExternal = isExternal;
        this.isSuperviseUpload = isSuperviseUpload;
        this.isReceiptUpload = isReceiptUpload;
        this.isEndUpload = isEndUpload;
        this.dealStep = dealStep;
        this.backOperatorName = backOperatorName;
        this.endOperatorId = endOperatorId;
        this.promise = promise;
        this.receiveOperatorList = receiveOperatorList;
        this.isCheck = isCheck;
        this.superviseSource = superviseSource;
        this.warnsortNo = warnsortNo;
        this.orgId = orgId;
        this.superviseUploadNo = superviseUploadNo;
        this.supervisionType = supervisionType;
        this.supervisionYear = supervisionYear;
        this.supervisionMonth = supervisionMonth;
    }

    public String getSuperviseCode() {
        return superviseCode;
    }

    public void setSuperviseCode(String superviseCode) {
        this.superviseCode = superviseCode;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getSuperviseType() {
        return superviseType;
    }

    public void setSuperviseType(String superviseType) {
        this.superviseType = superviseType;
    }

    public String getSuperviseOption() {
        return superviseOption;
    }

    public void setSuperviseOption(String superviseOption) {
        this.superviseOption = superviseOption;
    }

    public String getSuperviseBack() {
        return superviseBack;
    }

    public void setSuperviseBack(String superviseBack) {
        this.superviseBack = superviseBack;
    }

    public String getSuperviseResult() {
        return superviseResult;
    }

    public void setSuperviseResult(String superviseResult) {
        this.superviseResult = superviseResult;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getSuperDate() {
        return superDate;
    }

    public void setSuperDate(Date superDate) {
        this.superDate = superDate;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Long isExternal) {
        this.isExternal = isExternal;
    }

    public String getIsSuperviseUpload() {
        return isSuperviseUpload;
    }

    public void setIsSuperviseUpload(String isSuperviseUpload) {
        this.isSuperviseUpload = isSuperviseUpload;
    }

    public String getIsReceiptUpload() {
        return isReceiptUpload;
    }

    public void setIsReceiptUpload(String isReceiptUpload) {
        this.isReceiptUpload = isReceiptUpload;
    }

    public String getIsEndUpload() {
        return isEndUpload;
    }

    public void setIsEndUpload(String isEndUpload) {
        this.isEndUpload = isEndUpload;
    }

    public String getDealStep() {
        return dealStep;
    }

    public void setDealStep(String dealStep) {
        this.dealStep = dealStep;
    }

    public String getBackOperatorName() {
        return backOperatorName;
    }

    public void setBackOperatorName(String backOperatorName) {
        this.backOperatorName = backOperatorName;
    }

    public String getEndOperatorId() {
        return endOperatorId;
    }

    public void setEndOperatorId(String endOperatorId) {
        this.endOperatorId = endOperatorId;
    }

    public Date getPromise() {
        return promise;
    }

    public void setPromise(Date promise) {
        this.promise = promise;
    }

    public String getReceiveOperatorList() {
        return receiveOperatorList;
    }

    public void setReceiveOperatorList(String receiveOperatorList) {
        this.receiveOperatorList = receiveOperatorList;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public String getSuperviseSource() {
        return superviseSource;
    }

    public void setSuperviseSource(String superviseSource) {
        this.superviseSource = superviseSource;
    }

    public String getWarnsortNo() {
        return warnsortNo;
    }

    public void setWarnsortNo(String warnsortNo) {
        this.warnsortNo = warnsortNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSuperviseUploadNo() {
        return superviseUploadNo;
    }

    public void setSuperviseUploadNo(String superviseUploadNo) {
        this.superviseUploadNo = superviseUploadNo;
    }

    public String getSupervisionType() {
        return supervisionType;
    }

    public void setSupervisionType(String supervisionType) {
        this.supervisionType = supervisionType;
    }

    public String getSupervisionYear() {
        return supervisionYear;
    }

    public void setSupervisionYear(String supervisionYear) {
        this.supervisionYear = supervisionYear;
    }

    public String getSupervisionMonth() {
        return supervisionMonth;
    }

    public void setSupervisionMonth(String supervisionMonth) {
        this.supervisionMonth = supervisionMonth;
    }

    public void copy(SupInfoBasicDlfx other) {
        this.backOperatorName = other.getBackOperatorName();
        this.complaintId = other.getComplaintId();
        this.dealStep = other.getDealStep();
        this.endDate = other.getEndDate();
        this.endOperatorId = other.getEndOperatorId();
        this.isCheck = other.getIsCheck();
        this.isEndUpload = other.getIsEndUpload();
        this.isExternal = other.getIsExternal();
        this.isReceiptUpload = other.getIsReceiptUpload();
        this.isSuperviseUpload = other.getIsSuperviseUpload();
        this.no = other.getNo();
        this.operatorId = other.getOperatorId();
        this.orgId = other.getOrgId();
        this.promise = other.getPromise();
        this.receiptDate = other.getReceiptDate();
        this.receiveOperatorList = other.getReceiveOperatorList();
        this.superDate = other.getSuperDate();
        this.superviseBack = other.getSuperviseBack();
        this.superviseCode = other.getSuperviseCode();
        this.superviseOption = other.getSuperviseOption();
        this.superviseResult = other.getSuperviseOption();
        this.superviseSource = other.getSuperviseSource();
        this.superviseType = other.getSuperviseType();
        this.superviseUploadNo = other.getSuperviseUploadNo();
        this.supervisionMonth = other.getSupervisionMonth();
        this.supervisionType = other.getSupervisionType();
        this.supervisionYear = other.getSupervisionYear();
        this.warnsortNo = other.getWarnsortNo();
    }

    public void copyNotNullProperty(SupInfoBasicDlfx other) {
        if (other.getBackOperatorName() != null) {
            this.setBackOperatorName(other.getBackOperatorName());
        }
        if (other.getComplaintId() != null) {
            this.setComplaintId(other.getComplaintId());
        }
        if (other.getDealStep() != null) {
            this.setDealStep(other.getDealStep());
        }
        if (other.getEndDate() != null) {
            this.setEndDate(other.getEndDate());
        }
        if (other.getEndOperatorId() != null) {
            this.setEndOperatorId(other.getEndOperatorId());
        }
        if (other.getIsCheck() != null) {
            this.setIsCheck(other.getIsCheck());
        }
        if (other.getIsEndUpload() != null) {
            this.setIsEndUpload(other.getIsEndUpload());
        }
        if (other.getIsExternal() != null) {
            this.setIsExternal(other.getIsExternal());
        }
        if (other.getIsReceiptUpload() != null) {
            this.setIsReceiptUpload(other.getIsReceiptUpload());
        }
        if (other.getIsSuperviseUpload() != null) {
            this.setIsSuperviseUpload(other.getIsSuperviseUpload());
        }
        if (other.getNo() != null) {
            this.setNo(other.getNo());
        }
        if (other.getOperatorId() != null) {
            this.setOperatorId(other.getOperatorId());
        }
        if (other.getOrgId() != null) {
            this.setOrgId(other.getOrgId());
        }
        if (other.getPromise() != null) {
            this.setPromise(other.getPromise());
        }
        if (other.getReceiptDate() != null) {
            this.setReceiptDate(other.getReceiptDate());
        }
        if (other.getReceiveOperatorList() != null) {
            this.setReceiveOperatorList(other.getReceiveOperatorList());
        }
        if (other.getSuperDate() != null) {
            this.setSuperDate(other.getSuperDate());
        }
        if (other.getSuperviseBack() != null) {
            this.setSuperviseBack(other.getSuperviseBack());
        }
        if (other.getSuperviseCode() != null) {
            this.setSuperviseCode(other.getSuperviseCode());
        }
        if (other.getSuperviseOption() != null) {
            this.setSuperviseOption(other.getSuperviseOption());
        }
        if (other.getSuperviseResult() != null) {
            this.setSuperviseResult(other.getSuperviseResult());
        }
        if (other.getSuperviseSource() != null) {
            this.setSuperviseSource(other.getSuperviseSource());
        }
        if (other.getSuperviseType() != null) {
            this.setSuperviseType(other.getSuperviseType());
        }
        if (other.getSuperviseType() != null) {
            this.setSuperviseType(other.getSuperviseType());
        }
        if (other.getSuperviseUploadNo() != null) {
            this.setSuperviseUploadNo(other.getSuperviseUploadNo());
        }
        if (other.getSupervisionMonth() != null) {
            this.setSupervisionMonth(other.getSupervisionMonth());
        }
        if (other.getSupervisionType() != null) {
            this.setSupervisionType(other.getSupervisionType());
        }
        if (other.getSupervisionYear() != null) {
            this.setSupervisionYear(other.getSupervisionYear());
        }
        if (other.getWarnsortNo() != null) {
            this.setWarnsortNo(other.getWarnsortNo());
        }
    }

    public void clearProperties() {
        this.backOperatorName = null;
        this.complaintId = null;
        this.dealStep = null;
        this.endDate = null;
        this.endOperatorId = null;
        this.isCheck = null;
        this.isEndUpload = null;
        this.isExternal = null;
        this.isReceiptUpload = null;
        this.no = null;
        this.operatorId = null;
        this.orgId = null;
        this.promise = null;
        this.receiptDate = null;
        this.receiveOperatorList = null;
        this.superDate = null;
        this.superviseBack = null;
        this.superviseOption = null;
        this.superviseCode = null;
        this.superviseResult = null;
        this.superviseType = null;
        this.superviseSource = null;
        this.supervisionMonth = null;
        this.supervisionType = null;
        this.supervisionYear = null;
        this.warnsortNo = null;
    }
}

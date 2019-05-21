package com.centit.powerbase.po;

import java.util.Date;

public class Vapplyrecordbasic {
    private String internalNo;
    private String orgId;
    private String department;
    private String transactAffairName;
    private Date bookDate;
    private Date applyDate;
    private String itemId;
    private String itemName;
    private String itemType;
    private String applicant;
    private String applicantType;
    private String content;
    private String remark;
    private String no;

    public Vapplyrecordbasic() {
    }

    public Vapplyrecordbasic(String internalNo, String orgId,
            String department, String transactAffairName, Date bookDate,
            String itemId, String itemName, String itemType, String applicant,
            String applicantType, String content, String remark,
            Date applyDate, String no) {
        this.internalNo = internalNo;
        this.orgId = orgId;
        this.department = department;
        this.transactAffairName = transactAffairName;
        this.bookDate = bookDate;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.applicant = applicant;
        this.applicantType = applicantType;
        this.content = content;
        this.remark = remark;
        this.applyDate = applyDate;
        this.no = no;
    }

    public void copy(Vapplyrecordbasic other) {

        this.internalNo = other.internalNo;
        this.orgId = other.orgId;
        this.department = other.department;
        this.transactAffairName = other.transactAffairName;
        this.bookDate = other.bookDate;
        this.itemId = other.itemId;
        this.itemName = other.itemName;
        this.itemType = other.itemType;
        this.applicant = other.applicant;
        this.applicantType = other.applicantType;
        this.content = other.content;
        this.remark = other.remark;
        this.applyDate = other.applyDate;
        this.no = other.no;
    }

    public void copyNotNullProperty(Vapplyrecordbasic other) {
        if (other.internalNo != null)
            this.internalNo = other.internalNo;
        if (other.orgId != null)
            this.orgId = other.orgId;
        if (other.department != null)
            this.department = other.department;
        if (other.transactAffairName != null)
            this.transactAffairName = other.transactAffairName;
        if (other.bookDate != null)
            this.bookDate = other.bookDate;
        if (other.itemId != null)
            this.itemId = other.itemId;
        if (other.itemName != null)
            this.itemName = other.itemName;
        if (other.itemType != null)
            this.itemType = other.itemType;
        if (other.applicant != null)
            this.applicant = other.applicant;
        if (other.applicantType != null)
            this.applicantType = other.applicantType;
        if (other.content != null)
            this.content = other.content;
        if (other.remark != null)
            this.remark = other.remark;
        if (other.applyDate != null)
            this.applyDate = other.applyDate;
        if (other.no != null)
            this.no = other.no;
    }

    public void clearProperties() {
        this.internalNo = null;
        this.orgId = null;
        this.department = null;
        this.transactAffairName = null;
        this.bookDate = null;
        this.itemId = null;
        this.itemName = null;
        this.itemType = null;
        this.applicant = null;
        this.applicantType = null;
        this.content = null;
        this.remark = null;
        this.applyDate = null;
        this.no = null;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTransactAffairName() {
        return transactAffairName;
    }

    public void setTransactAffairName(String transactAffairName) {
        this.transactAffairName = transactAffairName;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}

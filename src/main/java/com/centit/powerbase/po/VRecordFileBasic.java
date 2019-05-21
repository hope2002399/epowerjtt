package com.centit.powerbase.po;

import java.util.Date;

public class VRecordFileBasic implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String recordCode;
    private String operatorID;
    private Date bookDate;
    private String constituteDepName;
    private String fileName;
    private String ownerDepID;
    private String depFileNo;
    private String allFIleNo;
    private Date punishDate;
    private Date applyDate;
    private String remark;
    private Date finishDate;
    private String finishStatus;
    private String dealStep;
    private Integer sortNo;
    private String discussname;
    private String constituteId;
    private Date beginDate;
    private Date endDate;
    private String depNo;

    public String getDepNo() {
        return depNo;
    }

    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    public VRecordFileBasic() {

    }

    public VRecordFileBasic(String so) {

    }

    public void copy(VRecordFileBasic other) {
        this.recordCode = other.recordCode;
        this.operatorID = other.operatorID;
        this.bookDate = other.bookDate;
        this.constituteDepName = other.constituteDepName;
        this.fileName = other.fileName;
        this.ownerDepID = other.ownerDepID;
        this.depFileNo = other.depFileNo;
        this.allFIleNo = other.allFIleNo;
        this.punishDate = other.punishDate;
        this.applyDate = other.applyDate;
        this.remark = other.remark;
        this.finishDate = other.finishDate;
        this.finishStatus = other.finishStatus;
        this.dealStep = other.dealStep;
        this.sortNo = other.sortNo;
        this.discussname = other.discussname;
        this.constituteId = other.constituteId;
    }

    public void clearProperties() {
        this.recordCode = null;
        this.operatorID = null;
        this.bookDate = null;
        this.constituteDepName = null;
        this.fileName = null;
        this.ownerDepID = null;
        this.depFileNo = null;
        this.allFIleNo = null;
        this.punishDate = null;
        this.applyDate = null;
        this.remark = null;
        this.finishDate = null;
        this.finishStatus = null;
        this.dealStep = null;
        this.sortNo = null;
        this.discussname = null;
        this.constituteId = null;
    }

    public String getDiscussname() {
        return discussname;
    }

    public void setDiscussname(String discussname) {
        this.discussname = discussname;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getConstituteDepName() {
        return constituteDepName;
    }

    public void setConstituteDepName(String constituteDepName) {
        this.constituteDepName = constituteDepName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOwnerDepID() {
        return ownerDepID;
    }

    public void setOwnerDepID(String ownerDepID) {
        this.ownerDepID = ownerDepID;
    }

    public String getDepFileNo() {
        return depFileNo;
    }

    public void setDepFileNo(String depFileNo) {
        this.depFileNo = depFileNo;
    }

    public String getAllFIleNo() {
        return allFIleNo;
    }

    public void setAllFIleNo(String allFIleNo) {
        this.allFIleNo = allFIleNo;
    }

    public Date getPunishDate() {
        return punishDate;
    }

    public void setPunishDate(Date punishDate) {
        this.punishDate = punishDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(String finishStatus) {
        this.finishStatus = finishStatus;
    }

    public String getDealStep() {
        return dealStep;
    }

    public void setDealStep(String dealStep) {
        this.dealStep = dealStep;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getConstituteId() {
        return constituteId;
    }

    public void setConstituteId(String constituteId) {
        this.constituteId = constituteId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

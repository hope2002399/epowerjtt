package com.centit.monitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class ApplyProcess implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String no;

    private Long noOrd;
    private String orgId;
    private String internalNo;
    private String itemId;
    private String tacheId;
    private String tacheName;
    private String tacheInteNo;
    private String tachePrevIntNo;
    private String department;
    private String userStaffCode;
    private String userName;
    private String status;
    private Long promise;
    private String promiseType;
    private String promiseStartSign;
    private Long isrisk;
    private String risktype;
    private String riskdescription;
    private String riskresult;
    private String note;
    private String attachment;
    private Date beginDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    private Date processDate;
    private String nodeId;
    private Long nodeAttribute;
    private Date createDate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;
    private String isDoc;
    @SuppressWarnings("rawtypes")
    private List docList = new ArrayList();
    private Outway outway;
    private List<Outway> outwaylist;

    public List<Outway> getOutwaylist() {
        return outwaylist;
    }

    private String title;
    private String standardProTime;
    private String standardProType;
    private String acceptName;
    private String processID;
    private String riskInfo;
    private String isRisk;
    private String riskResult;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStandardProTime() {
        return standardProTime;
    }

    public void setStandardProTime(String standardProTime) {
        this.standardProTime = standardProTime;
    }

    public String getStandardProType() {
        return standardProType;
    }

    public void setStandardProType(String standardProType) {
        this.standardProType = standardProType;
    }

    public String getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public String getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(String riskInfo) {
        this.riskInfo = riskInfo;
    }

    public String getIsRisk() {
        return isRisk;
    }

    public void setIsRisk(String isRisk) {
        this.isRisk = isRisk;
    }

    public String getRiskResult() {
        return riskResult;
    }

    public void setRiskResult(String riskResult) {
        this.riskResult = riskResult;
    }

    public void setOutwaylist(List<Outway> outwaylist) {
        this.outwaylist = outwaylist;
    }

    public Outway getOutway() {
        return outway;
    }

    public void setOutway(Outway outway) {
        this.outway = outway;
    }

    @SuppressWarnings("rawtypes")
    public List getDocList() {
        return docList;
    }

    @SuppressWarnings("rawtypes")
    public void setDocList(List docList) {
        this.docList = docList;
    }

    public String getIsDoc() {
        return isDoc;
    }

    public void setIsDoc(String isDoc) {
        this.isDoc = isDoc;
    }

    // Constructors
    /** default constructor */
    public ApplyProcess() {
    }

    /** minimal constructor */
    public ApplyProcess(String no, Long noOrd, String orgId, String internalNo,
            String itemId, String department, String userStaffCode,
            String userName, String status, Long promise, String note,
            Date processDate, String nodeId, Long nodeAttribute,
            Date createDate, Date updateDate) {

        this.no = no;

        this.noOrd = noOrd;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.department = department;
        this.userStaffCode = userStaffCode;
        this.userName = userName;
        this.status = status;
        this.promise = promise;
        this.note = note;
        this.processDate = processDate;
        this.nodeId = nodeId;
        this.nodeAttribute = nodeAttribute;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /** full constructor */
    public ApplyProcess(String no, Long noOrd, String orgId, String internalNo,
            String itemId, String tacheId, String tacheName,
            String tacheInteNo, String tachePrevIntNo, String department,
            String userStaffCode, String userName, String status, Long promise,
            String promiseType, String promiseStartSign, Long isrisk,
            String risktype, String riskdescription, String riskresult,
            String note, String attachment, Date processDate, String nodeId,
            Long nodeAttribute, Date createDate, Date updateDate,
            Date syncDate, String syncSign, String syncErrorDesc) {

        this.no = no;

        this.noOrd = noOrd;
        this.orgId = orgId;
        this.internalNo = internalNo;
        this.itemId = itemId;
        this.tacheId = tacheId;
        this.tacheName = tacheName;
        this.tacheInteNo = tacheInteNo;
        this.tachePrevIntNo = tachePrevIntNo;
        this.department = department;
        this.userStaffCode = userStaffCode;
        this.userName = userName;
        this.status = status;
        this.promise = promise;
        this.promiseType = promiseType;
        this.promiseStartSign = promiseStartSign;
        this.isrisk = isrisk;
        this.risktype = risktype;
        this.riskdescription = riskdescription;
        this.riskresult = riskresult;
        this.note = note;
        this.attachment = attachment;
        this.processDate = processDate;
        this.nodeId = nodeId;
        this.nodeAttribute = nodeAttribute;
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

    public Long getNoOrd() {
        return this.noOrd;
    }

    public void setNoOrd(Long noOrd) {
        this.noOrd = noOrd;
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

    public String getTacheId() {
        return this.tacheId;
    }

    public void setTacheId(String tacheId) {
        this.tacheId = tacheId;
    }

    public String getTacheName() {
        return this.tacheName;
    }

    public void setTacheName(String tacheName) {
        this.tacheName = tacheName;
    }

    public String getTacheInteNo() {
        return this.tacheInteNo;
    }

    public void setTacheInteNo(String tacheInteNo) {
        this.tacheInteNo = tacheInteNo;
    }

    public String getTachePrevIntNo() {
        return this.tachePrevIntNo;
    }

    public void setTachePrevIntNo(String tachePrevIntNo) {
        this.tachePrevIntNo = tachePrevIntNo;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserStaffCode() {
        return this.userStaffCode;
    }

    public void setUserStaffCode(String userStaffCode) {
        this.userStaffCode = userStaffCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPromise() {
        return this.promise;
    }

    public void setPromise(Long promise) {
        this.promise = promise;
    }

    public String getPromiseType() {
        return this.promiseType;
    }

    public void setPromiseType(String promiseType) {
        this.promiseType = promiseType;
    }

    public String getPromiseStartSign() {
        return this.promiseStartSign;
    }

    public void setPromiseStartSign(String promiseStartSign) {
        this.promiseStartSign = promiseStartSign;
    }

    public Long getIsrisk() {
        return this.isrisk;
    }

    public void setIsrisk(Long isrisk) {
        this.isrisk = isrisk;
    }

    public String getRisktype() {
        return this.risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype;
    }

    public String getRiskdescription() {
        return this.riskdescription;
    }

    public void setRiskdescription(String riskdescription) {
        this.riskdescription = riskdescription;
    }

    public String getRiskresult() {
        return this.riskresult;
    }

    public void setRiskresult(String riskresult) {
        this.riskresult = riskresult;
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

    public Date getProcessDate() {
        return this.processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Long getNodeAttribute() {
        return this.nodeAttribute;
    }

    public void setNodeAttribute(Long nodeAttribute) {
        this.nodeAttribute = nodeAttribute;
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

    public void copy(ApplyProcess other) {

        this.setNo(other.getNo());

        this.noOrd = other.getNoOrd();
        this.orgId = other.getOrgId();
        this.internalNo = other.getInternalNo();
        this.itemId = other.getItemId();
        this.tacheId = other.getTacheId();
        this.tacheName = other.getTacheName();
        this.tacheInteNo = other.getTacheInteNo();
        this.tachePrevIntNo = other.getTachePrevIntNo();
        this.department = other.getDepartment();
        this.userStaffCode = other.getUserStaffCode();
        this.userName = other.getUserName();
        this.status = other.getStatus();
        this.promise = other.getPromise();
        this.promiseType = other.getPromiseType();
        this.promiseStartSign = other.getPromiseStartSign();
        this.isrisk = other.getIsrisk();
        this.risktype = other.getRisktype();
        this.riskdescription = other.getRiskdescription();
        this.riskresult = other.getRiskresult();
        this.note = other.getNote();
        this.attachment = other.getAttachment();
        this.processDate = other.getProcessDate();
        this.nodeId = other.getNodeId();
        this.nodeAttribute = other.getNodeAttribute();
        this.createDate = other.getCreateDate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();

    }

    public void copyNotNullProperty(ApplyProcess other) {

        if (other.getNo() != null)
            this.setNo(other.getNo());

        if (other.getNoOrd() != null)
            this.noOrd = other.getNoOrd();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getTacheId() != null)
            this.tacheId = other.getTacheId();
        if (other.getTacheName() != null)
            this.tacheName = other.getTacheName();
        if (other.getTacheInteNo() != null)
            this.tacheInteNo = other.getTacheInteNo();
        if (other.getTachePrevIntNo() != null)
            this.tachePrevIntNo = other.getTachePrevIntNo();
        if (other.getDepartment() != null)
            this.department = other.getDepartment();
        if (other.getUserStaffCode() != null)
            this.userStaffCode = other.getUserStaffCode();
        if (other.getUserName() != null)
            this.userName = other.getUserName();
        if (other.getStatus() != null)
            this.status = other.getStatus();
        if (other.getPromise() != null)
            this.promise = other.getPromise();
        if (other.getPromiseType() != null)
            this.promiseType = other.getPromiseType();
        if (other.getPromiseStartSign() != null)
            this.promiseStartSign = other.getPromiseStartSign();
        if (other.getIsrisk() != null)
            this.isrisk = other.getIsrisk();
        if (other.getRisktype() != null)
            this.risktype = other.getRisktype();
        if (other.getRiskdescription() != null)
            this.riskdescription = other.getRiskdescription();
        if (other.getRiskresult() != null)
            this.riskresult = other.getRiskresult();
        if (other.getNote() != null)
            this.note = other.getNote();
        if (other.getAttachment() != null)
            this.attachment = other.getAttachment();
        if (other.getProcessDate() != null)
            this.processDate = other.getProcessDate();
        if (other.getNodeId() != null)
            this.nodeId = other.getNodeId();
        if (other.getNodeAttribute() != null)
            this.nodeAttribute = other.getNodeAttribute();
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

        this.noOrd = null;
        this.orgId = null;
        this.internalNo = null;
        this.itemId = null;
        this.tacheId = null;
        this.tacheName = null;
        this.tacheInteNo = null;
        this.tachePrevIntNo = null;
        this.department = null;
        this.userStaffCode = null;
        this.userName = null;
        this.status = null;
        this.promise = null;
        this.promiseType = null;
        this.promiseStartSign = null;
        this.isrisk = null;
        this.risktype = null;
        this.riskdescription = null;
        this.riskresult = null;
        this.note = null;
        this.attachment = null;
        this.processDate = null;
        this.nodeId = null;
        this.nodeAttribute = null;
        this.createDate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;

    }
}

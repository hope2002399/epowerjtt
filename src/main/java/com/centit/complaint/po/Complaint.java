package com.centit.complaint.po;

import java.util.Date;

import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Punish;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class Complaint implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String complaintid;

    private Long flowInstId;
    private String complaintsType;
    private String complaintsSource;

    /**
     * 办件类型 1：许可 2：处罚
     */
    private String bjType;
    private String bjNo;
    private String itemId;
    private String internalNo;
    private String processType;

    private String graentOrgId;
    private String graentOpinion;

    private String wereComplaintsOrgId;
    private String wereComplaintsName;
    private String wereComplaintsPersonName;

    private String complaintman;
    private String complaintphone;
    private Date complaintdate;
    private String address;
    private String complaintreason;
    private String complaintremark;
    private Long disposetype;

    private Date complaintmandate;
    private Long complaintmanresult;
    private String complaintmanremark;

    private String tsly;
    private String orgId;
    private Date processDate;

    private String optId;
    private String createUser;
    private Date createDate;
    private String biztype;
    private Date promise_Date;
    private String dateSrc;

    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;

    //
    private String complaintresult;
    private Apply apply;
    private Punish punish;
    private ComplaintsResult complaintsResult;

    // Constructors
    /** default constructor */
    public Complaint() {
    }

    public Complaint(String complaintid, Long flowInstId,
            String complaintsType, String complaintsSource, String bjType,
            String bjNo, String itemId, String internalNo, String processType,
            String graentOrgId, String graentOpinion,
            String wereComplaintsOrgId, String wereComplaintsName,
            String wereComplaintsPersonName, String complaintman,
            String complaintphone, Date complaintdate, String address,
            String complaintreason, String complaintremark, Long disposetype,
            Date complaintmandate, Long complaintmanresult,
            String complaintmanremark, String tsly, String orgId,
            Date processDate, String optId, String createUser, Date createDate,
            String biztype, Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {
        super();
        this.complaintid = complaintid;
        this.flowInstId = flowInstId;
        this.complaintsType = complaintsType;
        this.complaintsSource = complaintsSource;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.itemId = itemId;
        this.internalNo = internalNo;
        this.processType = processType;
        this.graentOrgId = graentOrgId;
        this.graentOpinion = graentOpinion;
        this.wereComplaintsOrgId = wereComplaintsOrgId;
        this.wereComplaintsName = wereComplaintsName;
        this.wereComplaintsPersonName = wereComplaintsPersonName;
        this.complaintman = complaintman;
        this.complaintphone = complaintphone;
        this.complaintdate = complaintdate;
        this.address = address;
        this.complaintreason = complaintreason;
        this.complaintremark = complaintremark;
        this.disposetype = disposetype;
        this.complaintmandate = complaintmandate;
        this.complaintmanresult = complaintmanresult;
        this.complaintmanremark = complaintmanremark;
        this.tsly = tsly;
        this.orgId = orgId;
        this.processDate = processDate;
        this.optId = optId;
        this.createUser = createUser;
        this.createDate = createDate;
        this.biztype = biztype;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public String getTsly() {
        return tsly;
    }

    public void setTsly(String tsly) {
        this.tsly = tsly;
    }

    public String getComplaintid() {
        return this.complaintid;
    }

    public void setComplaintid(String complaintid) {
        this.complaintid = complaintid;
    }

    // Property accessors

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getBjType() {
        return this.bjType;
    }

    public void setBjType(String bjType) {
        this.bjType = bjType;
    }

    public String getBjNo() {
        return this.bjNo;
    }

    public void setBjNo(String bjNo) {
        this.bjNo = bjNo;
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

    public String getComplaintsType() {
        return this.complaintsType;
    }

    public void setComplaintsType(String complaintsType) {
        this.complaintsType = complaintsType;
    }

    public String getComplaintsSource() {
        return this.complaintsSource;
    }

    public void setComplaintsSource(String complaintsSource) {
        this.complaintsSource = complaintsSource;
    }

    public String getComplaintman() {
        return this.complaintman;
    }

    public void setComplaintman(String complaintman) {
        this.complaintman = complaintman;
    }

    public String getComplaintphone() {
        return this.complaintphone;
    }

    public void setComplaintphone(String complaintphone) {
        this.complaintphone = complaintphone;
    }

    public Date getComplaintdate() {
        return this.complaintdate;
    }

    public void setComplaintdate(Date complaintdate) {
        this.complaintdate = complaintdate;
    }

    public String getComplaintreason() {
        return this.complaintreason;
    }

    public void setComplaintreason(String complaintreason) {
        this.complaintreason = complaintreason;
    }

    public String getComplaintremark() {
        return this.complaintremark;
    }

    public void setComplaintremark(String complaintremark) {
        this.complaintremark = complaintremark;
    }

    public Long getDisposetype() {
        return this.disposetype;
    }

    public void setDisposetype(Long disposetype) {
        this.disposetype = disposetype;
    }

    public Date getComplaintmandate() {
        return this.complaintmandate;
    }

    public void setComplaintmandate(Date complaintmandate) {
        this.complaintmandate = complaintmandate;
    }

    public Long getComplaintmanresult() {
        return this.complaintmanresult;
    }

    public void setComplaintmanresult(Long complaintmanresult) {
        this.complaintmanresult = complaintmanresult;
    }

    public String getComplaintmanremark() {
        return this.complaintmanremark;
    }

    public void setComplaintmanremark(String complaintmanremark) {
        this.complaintmanremark = complaintmanremark;
    }

    public String getWereComplaintsOrgId() {
        return this.wereComplaintsOrgId;
    }

    public void setWereComplaintsOrgId(String wereComplaintsOrgId) {
        this.wereComplaintsOrgId = wereComplaintsOrgId;
    }

    public String getWereComplaintsName() {
        return this.wereComplaintsName;
    }

    public void setWereComplaintsName(String wereComplaintsName) {
        this.wereComplaintsName = wereComplaintsName;
    }

    public String getWereComplaintsPersonName() {
        return this.wereComplaintsPersonName;
    }

    public void setWereComplaintsPersonName(String wereComplaintsPersonName) {
        this.wereComplaintsPersonName = wereComplaintsPersonName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getProcessDate() {
        return this.processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getProcessType() {
        return this.processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getGraentOrgId() {
        return this.graentOrgId;
    }

    public void setGraentOrgId(String graentOrgId) {
        this.graentOrgId = graentOrgId;
    }

    public String getGraentOpinion() {
        return this.graentOpinion;
    }

    public void setGraentOpinion(String graentOpinion) {
        this.graentOpinion = graentOpinion;
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

    public void copy(Complaint other) {

        this.setComplaintid(other.getComplaintid());

        this.flowInstId = other.getFlowInstId();
        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.itemId = other.getItemId();
        this.internalNo = other.getInternalNo();
        this.complaintsType = other.getComplaintsType();
        this.complaintsSource = other.getComplaintsSource();
        this.complaintman = other.getComplaintman();
        this.complaintphone = other.getComplaintphone();
        this.complaintdate = other.getComplaintdate();
        this.complaintreason = other.getComplaintreason();
        this.complaintremark = other.getComplaintremark();
        this.disposetype = other.getDisposetype();
        this.complaintmandate = other.getComplaintmandate();
        this.complaintmanresult = other.getComplaintmanresult();
        this.complaintmanremark = other.getComplaintmanremark();
        this.wereComplaintsOrgId = other.getWereComplaintsOrgId();
        this.wereComplaintsName = other.getWereComplaintsName();
        this.wereComplaintsPersonName = other.getWereComplaintsPersonName();
        this.address = other.getAddress();
        this.orgId = other.getOrgId();
        this.processDate = other.getProcessDate();
        this.processType = other.getProcessType();
        this.graentOrgId = other.getGraentOrgId();
        this.graentOpinion = other.getGraentOpinion();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();
        this.optId = other.getOptId();
        this.createUser = other.getCreateUser();
        this.createDate = other.getCreateDate();
        this.biztype = other.getBiztype();
        this.tsly = other.getTsly();
        this.promise_Date = other.getPromise_Date();
        this.dateSrc = other.getDateSrc();
    }

    public void copyNotNullProperty(Complaint other) {

        if (other.getComplaintid() != null)
            this.setComplaintid(other.getComplaintid());

        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getBjType() != null)
            this.bjType = other.getBjType();
        if (other.getBjNo() != null)
            this.bjNo = other.getBjNo();
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getComplaintsType() != null)
            this.complaintsType = other.getComplaintsType();
        if (other.getComplaintsSource() != null)
            this.complaintsSource = other.getComplaintsSource();
        if (other.getComplaintman() != null)
            this.complaintman = other.getComplaintman();
        if (other.getComplaintphone() != null)
            this.complaintphone = other.getComplaintphone();
        if (other.getComplaintdate() != null)
            this.complaintdate = other.getComplaintdate();
        if (other.getComplaintreason() != null)
            this.complaintreason = other.getComplaintreason();
        if (other.getComplaintremark() != null)
            this.complaintremark = other.getComplaintremark();
        if (other.getDisposetype() != null)
            this.disposetype = other.getDisposetype();

        if (other.getComplaintmandate() != null)
            this.complaintmandate = other.getComplaintmandate();
        if (other.getComplaintmanresult() != null)
            this.complaintmanresult = other.getComplaintmanresult();
        if (other.getComplaintmanremark() != null)
            this.complaintmanremark = other.getComplaintmanremark();

        if (other.getWereComplaintsOrgId() != null)
            this.wereComplaintsOrgId = other.getWereComplaintsOrgId();
        if (other.getWereComplaintsName() != null)
            this.wereComplaintsName = other.getWereComplaintsName();
        if (other.getWereComplaintsPersonName() != null)
            this.wereComplaintsPersonName = other.getWereComplaintsPersonName();

        if (other.getAddress() != null)
            this.address = other.getAddress();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getProcessDate() != null)
            this.processDate = other.getProcessDate();
        if (other.getProcessType() != null)
            this.processType = other.getProcessType();
        if (other.getGraentOrgId() != null)
            this.graentOrgId = other.getGraentOrgId();
        if (other.getGraentOpinion() != null)
            this.graentOpinion = other.getGraentOpinion();
        if (other.getUpdateDate() != null)
            this.updateDate = other.getUpdateDate();
        if (other.getSyncDate() != null)
            this.syncDate = other.getSyncDate();
        if (other.getSyncSign() != null)
            this.syncSign = other.getSyncSign();
        if (other.getSyncErrorDesc() != null)
            this.syncErrorDesc = other.getSyncErrorDesc();
        if (other.getOptId() != null)
            this.optId = other.getOptId();
        if (other.getCreateUser() != null)
            this.createUser = other.getCreateUser();
        if (other.getCreateDate() != null)
            this.createDate = other.getCreateDate();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();
        if (other.getTsly() != null)
            this.tsly = other.getTsly();
        if (other.getPromise_Date() != null)
            this.promise_Date = other.getPromise_Date();
        if (other.getDateSrc() != null)
            this.dateSrc = other.getDateSrc();
    }

    public void clearProperties() {

        this.flowInstId = null;
        this.bjType = null;
        this.bjNo = null;
        this.itemId = null;
        this.internalNo = null;
        this.complaintsType = null;
        this.complaintsSource = null;
        this.complaintman = null;
        this.complaintphone = null;
        this.complaintdate = null;
        this.complaintreason = null;
        this.complaintremark = null;
        this.disposetype = null;
        this.complaintmandate = null;
        this.complaintmanresult = null;
        this.complaintmanremark = null;
        this.wereComplaintsOrgId = null;
        this.wereComplaintsName = null;
        this.wereComplaintsPersonName = null;
        this.address = null;
        this.orgId = null;
        this.processDate = null;
        this.processType = null;
        this.graentOrgId = null;
        this.graentOpinion = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;
        this.optId = null;
        this.createUser = null;
        this.createDate = null;
        this.biztype = null;
        this.tsly = null;
        this.promise_Date = null;
        this.dateSrc = null;
    }

    public Complaint(String complaintid, Long flowInstId,
            String complaintsType, String complaintsSource, String bjType,
            String bjNo, String itemId, String internalNo, String processType,
            String graentOrgId, String graentOpinion,
            String wereComplaintsOrgId, String wereComplaintsName,
            String wereComplaintsPersonName, String complaintman,
            String complaintphone, Date complaintdate, String address,
            String complaintreason, String complaintremark, Long disposetype,
            Date complaintmandate, Long complaintmanresult,
            String complaintmanremark, String tsly, String orgId,
            Date processDate, String optId, String createUser, Date createDate,
            String biztype, Date promise_Date, String dateSrc, Date updateDate,
            Date syncDate, String syncSign, String syncErrorDesc) {
        super();
        this.complaintid = complaintid;
        this.flowInstId = flowInstId;
        this.complaintsType = complaintsType;
        this.complaintsSource = complaintsSource;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.itemId = itemId;
        this.internalNo = internalNo;
        this.processType = processType;
        this.graentOrgId = graentOrgId;
        this.graentOpinion = graentOpinion;
        this.wereComplaintsOrgId = wereComplaintsOrgId;
        this.wereComplaintsName = wereComplaintsName;
        this.wereComplaintsPersonName = wereComplaintsPersonName;
        this.complaintman = complaintman;
        this.complaintphone = complaintphone;
        this.complaintdate = complaintdate;
        this.address = address;
        this.complaintreason = complaintreason;
        this.complaintremark = complaintremark;
        this.disposetype = disposetype;
        this.complaintmandate = complaintmandate;
        this.complaintmanresult = complaintmanresult;
        this.complaintmanremark = complaintmanremark;
        this.tsly = tsly;
        this.orgId = orgId;
        this.processDate = processDate;
        this.optId = optId;
        this.createUser = createUser;
        this.createDate = createDate;
        this.biztype = biztype;
        this.promise_Date = promise_Date;
        this.dateSrc = dateSrc;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Apply getApply() {
        return apply;
    }

    public void setApply(Apply apply) {
        this.apply = apply;
    }

    public Punish getPunish() {
        return punish;
    }

    public void setPunish(Punish punish) {
        this.punish = punish;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public ComplaintsResult getComplaintsResult() {
        return complaintsResult;
    }

    public String getComplaintresult() {
        return complaintresult;
    }

    public void setComplaintresult(String complaintresult) {
        this.complaintresult = complaintresult;
    }

    public Date getPromise_Date() {
        return promise_Date;
    }

    public void setPromise_Date(Date promise_Date) {
        this.promise_Date = promise_Date;
    }

    public String getDateSrc() {
        return dateSrc;
    }

    public void setDateSrc(String dateSrc) {
        this.dateSrc = dateSrc;
    }

    public void setComplaintsResult(ComplaintsResult complaintsResult) {
        this.complaintsResult = complaintsResult;
    }
}

package com.centit.supervise.po;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.centit.complaint.po.Complaint;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Outway;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VPunish;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class SuperviseBasic implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String superviseNo;

    private Long flowInstId;
    private String bjType;
    private String bjNo;
    private String complaintid;
    private String outwayid;
    private String orgId;
    private String operatorName;
    private String operatorId;
    private Date superviseDate;
    private String monitorOrgId;
    private String monitorOrgName;
    private String monitorOperatorId;
    private String monitorOperatorName;
    private String superviseOption;
    private byte[] attachment;
    private Date promisedate;
    private Date updateDate;
    private Date syncDate;
    private String syncSign;
    private String syncErrorDesc;
    private String optId;
    private String createUser;
    private Date createDate;
    private String monitorSource;

    public String getMonitorSource() {
        return monitorSource;
    }

    public void setMonitorSource(String monitorSource) {
        this.monitorSource = monitorSource;
    }

    /**
     * F未提交，T办理中，C办结
     */
    private String bizType;
    private String superviseDetail;
    private String isOrg;

    private VApply vapply;
    private VPunish vpunish;
    private Apply apply;
    private Punish punish;
    private Complaint complaint;
    private SuperviseResult superviseResult;
    private Outway outway;

    // Constructors
    /** default constructor */
    public SuperviseBasic() {
    }

    /** minimal constructor */
    public SuperviseBasic(String superviseNo) {

        this.superviseNo = superviseNo;

    }

    /** full constructor */
    public SuperviseBasic(String superviseNo, Long flowInstId, String bjType,
            String bjNo, String complaintid, String outwayid, String orgId,
            String operatorName, String operatorId, Date superviseDate,
            String monitorOrgId, String monitorOrgName,
            String monitorOperatorId, String monitorOperatorName,
            String superviseOption, byte[] attachment, Date promiseDate,
            Date updateDate, Date syncDate, String syncSign,
            String syncErrorDesc) {

        this.superviseNo = superviseNo;

        this.flowInstId = flowInstId;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.complaintid = complaintid;
        this.outwayid = outwayid;
        this.orgId = orgId;
        this.operatorName = operatorName;
        this.operatorId = operatorId;
        this.superviseDate = superviseDate;
        this.monitorOrgId = monitorOrgId;
        this.monitorOrgName = monitorOrgName;
        this.monitorOperatorId = monitorOperatorId;
        this.monitorOperatorName = monitorOperatorName;
        this.superviseOption = superviseOption;
        this.attachment = attachment;
        this.promisedate = promiseDate;
        this.updateDate = updateDate;
        this.syncDate = syncDate;
        this.syncSign = syncSign;
        this.syncErrorDesc = syncErrorDesc;
    }

    public String getSuperviseNo() {
        return this.superviseNo;
    }

    public void setSuperviseNo(String superviseNo) {
        this.superviseNo = superviseNo;
    }

    // Property accessors

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getBjType() {
        if (StringUtils.isBlank(this.bjType)) {
            this.bjType = "1";
        }
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

    public Outway getOutway() {
        return outway;
    }

    public void setOutway(Outway outway) {
        this.outway = outway;
    }

    public String getComplaintid() {
        return this.complaintid;
    }

    public void setComplaintid(String complaintid) {
        this.complaintid = complaintid;
    }

    public String getOutwayid() {
        return this.outwayid;
    }

    public void setOutwayid(String outwayid) {
        this.outwayid = outwayid;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getSuperviseDate() {
        return this.superviseDate;
    }

    public void setSuperviseDate(Date superviseDate) {
        this.superviseDate = superviseDate;
    }

    public String getMonitorOrgId() {
        return this.monitorOrgId;
    }

    public void setMonitorOrgId(String monitorOrgId) {
        this.monitorOrgId = monitorOrgId;
    }

    public String getMonitorOrgName() {
        return this.monitorOrgName;
    }

    public void setMonitorOrgName(String monitorOrgName) {
        this.monitorOrgName = monitorOrgName;
    }

    public String getMonitorOperatorId() {
        return this.monitorOperatorId;
    }

    public void setMonitorOperatorId(String monitorOperatorId) {
        this.monitorOperatorId = monitorOperatorId;
    }

    public String getMonitorOperatorName() {
        return this.monitorOperatorName;
    }

    public void setMonitorOperatorName(String monitorOperatorName) {
        this.monitorOperatorName = monitorOperatorName;
    }

    public String getSuperviseOption() {
        return this.superviseOption;
    }

    public void setSuperviseOption(String superviseOption) {
        this.superviseOption = superviseOption;
    }

    public byte[] getAttachment() {
        return this.attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
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

    public void copy(SuperviseBasic other) {

        this.setSuperviseNo(other.getSuperviseNo());

        this.flowInstId = other.getFlowInstId();
        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.complaintid = other.getComplaintid();
        this.outwayid = other.getOutwayid();
        this.orgId = other.getOrgId();
        this.operatorName = other.getOperatorName();
        this.operatorId = other.getOperatorId();
        this.superviseDate = other.getSuperviseDate();
        this.monitorOrgId = other.getMonitorOrgId();
        this.monitorOrgName = other.getMonitorOrgName();
        this.monitorOperatorId = other.getMonitorOperatorId();
        this.monitorOperatorName = other.getMonitorOperatorName();
        this.superviseOption = other.getSuperviseOption();
        this.attachment = other.getAttachment();
        this.promisedate = other.getPromisedate();
        this.updateDate = other.getUpdateDate();
        this.syncDate = other.getSyncDate();
        this.syncSign = other.getSyncSign();
        this.syncErrorDesc = other.getSyncErrorDesc();
        this.optId = other.getOptId();
        this.createUser = other.getCreateUser();
        this.createDate = other.getCreateDate();
        this.bizType = other.getBizType();
        this.isOrg = other.getIsOrg();
        this.superviseDetail = other.getSuperviseDetail();
        this.monitorSource = other.getMonitorSource();
    }

    public Date getPromisedate() {
        return promisedate;
    }

    public void setPromisedate(Date promisedate) {
        this.promisedate = promisedate;
    }

    public void copyNotNullProperty(SuperviseBasic other) {

        if (other.getSuperviseNo() != null)
            this.setSuperviseNo(other.getSuperviseNo());

        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getBjType() != null)
            this.bjType = other.getBjType();
        if (other.getBjNo() != null)
            this.bjNo = other.getBjNo();
        if (other.getComplaintid() != null)
            this.complaintid = other.getComplaintid();
        if (other.getOutwayid() != null)
            this.outwayid = other.getOutwayid();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getOperatorName() != null)
            this.operatorName = other.getOperatorName();
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getSuperviseDate() != null)
            this.superviseDate = other.getSuperviseDate();
        if (other.getMonitorOrgId() != null)
            this.monitorOrgId = other.getMonitorOrgId();
        if (other.getMonitorOrgName() != null)
            this.monitorOrgName = other.getMonitorOrgName();
        if (other.getMonitorOperatorId() != null)
            this.monitorOperatorId = other.getMonitorOperatorId();
        if (other.getMonitorOperatorName() != null)
            this.monitorOperatorName = other.getMonitorOperatorName();
        if (other.getSuperviseOption() != null)
            this.superviseOption = other.getSuperviseOption();
        if (other.getAttachment() != null)
            this.attachment = other.getAttachment();
        if (other.getPromisedate() != null)
            this.promisedate = other.getPromisedate();
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
        if (other.getBizType() != null)
            this.bizType = other.getBizType();
        if (other.getIsOrg() != null)
            this.isOrg = other.getIsOrg();
        if (other.getSuperviseDetail() != null)
            this.superviseDetail = other.getSuperviseDetail();
        if (other.getMonitorSource() != null)
            this.monitorSource = other.getMonitorSource();

    }

    public void clearProperties() {

        this.flowInstId = null;
        this.bjType = null;
        this.bjNo = null;
        this.complaintid = null;
        this.outwayid = null;
        this.orgId = null;
        this.operatorName = null;
        this.operatorId = null;
        this.superviseDate = null;
        this.monitorOrgId = null;
        this.monitorOrgName = null;
        this.monitorOperatorId = null;
        this.monitorOperatorName = null;
        this.superviseOption = null;
        this.attachment = null;
        this.promisedate = null;
        this.updateDate = null;
        this.syncDate = null;
        this.syncSign = null;
        this.syncErrorDesc = null;
        this.optId = null;
        this.createUser = null;
        this.createDate = null;
        this.bizType = null;
        this.isOrg = null;
        this.superviseDetail = null;
        this.monitorSource = null;
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

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public VApply getVapply() {
        return vapply;
    }

    public void setVapply(VApply vapply) {
        this.vapply = vapply;
    }

    public VPunish getVpunish() {
        return vpunish;
    }

    public void setVpunish(VPunish vpunish) {
        this.vpunish = vpunish;
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

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getSuperviseDetail() {
        return superviseDetail;
    }

    public void setSuperviseDetail(String superviseDetail) {
        this.superviseDetail = superviseDetail;
    }

    public String getIsOrg() {
        if (StringUtils.isBlank(isOrg)) {
            isOrg = "F";
        }
        return isOrg;
    }

    public void setIsOrg(String isOrg) {
        this.isOrg = isOrg;
    }

    public SuperviseResult getSuperviseResult() {
        return superviseResult;
    }

    public void setSuperviseResult(SuperviseResult superviseResult) {
        this.superviseResult = superviseResult;
    }

}

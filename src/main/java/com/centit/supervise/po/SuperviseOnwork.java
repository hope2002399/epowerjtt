package com.centit.supervise.po;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class SuperviseOnwork implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String superviseNo;

    private String bjname;
    private String bjType;
    private String bjNo;
    private String complaintid;
    private Long outwayid;
    private String orgId;
    private String operatorId;
    private Date superviseDate;
    private String monitorOrgId;
    private String monitorOperatorId;
    private String superviseOption;
    private Date promiseDate;
    private String internalNo;
    private String processno;
    private String processName;
    private Date processDate;
    private String processOperatorId;
    private String operatorResult;
    private String operatorOpinion;
    private String biztype;
    private String isExternal;
    private String monitorSource;
    private String unitcode;

    public String getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(String isExternal) {
        this.isExternal = isExternal;
    }

    private String superviseResult;
    private String endOpinion;

    // Constructors
    /** default constructor */
    public SuperviseOnwork() {
    }

    /** minimal constructor */
    public SuperviseOnwork(String superviseNo) {

        this.superviseNo = superviseNo;

    }

    /** full constructor */
    public SuperviseOnwork(String superviseNo, String bjname, String bjType,
            String bjNo, String complaintid, Long outwayid, String orgId,
            String operatorId, Date superviseDate, String monitorOrgId,
            String monitorOperatorId, String superviseOption, Date promiseDate,
            String internalNo, String processno, String processName,
            Date processDate, String processOperatorId, String operatorResult,
            String operatorOpinion, String biztype, String unitcode) {

        this.superviseNo = superviseNo;

        this.bjname = bjname;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.complaintid = complaintid;
        this.outwayid = outwayid;
        this.orgId = orgId;
        this.operatorId = operatorId;
        this.superviseDate = superviseDate;
        this.monitorOrgId = monitorOrgId;
        this.monitorOperatorId = monitorOperatorId;
        this.superviseOption = superviseOption;
        this.promiseDate = promiseDate;
        this.internalNo = internalNo;
        this.processno = processno;
        this.processName = processName;
        this.processDate = processDate;
        this.processOperatorId = processOperatorId;
        this.operatorResult = operatorResult;
        this.operatorOpinion = operatorOpinion;
        this.biztype = biztype;
        this.unitcode = unitcode;
    }

    public String getSuperviseNo() {
        return this.superviseNo;
    }

    public void setSuperviseNo(String superviseNo) {
        this.superviseNo = superviseNo;
    }

    // Property accessors

    public String getBjname() {
        return this.bjname;
    }

    public void setBjname(String bjname) {
        this.bjname = bjname;
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

    public String getComplaintid() {
        return this.complaintid;
    }

    public void setComplaintid(String complaintid) {
        this.complaintid = complaintid;
    }

    public Long getOutwayid() {
        return this.outwayid;
    }

    public void setOutwayid(Long outwayid) {
        this.outwayid = outwayid;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getMonitorOperatorId() {
        return this.monitorOperatorId;
    }

    public void setMonitorOperatorId(String monitorOperatorId) {
        this.monitorOperatorId = monitorOperatorId;
    }

    public String getSuperviseOption() {
        return this.superviseOption;
    }

    public void setSuperviseOption(String superviseOption) {
        this.superviseOption = superviseOption;
    }

    public Date getPromiseDate() {
        return this.promiseDate;
    }

    public void setPromiseDate(Date promiseDate) {
        this.promiseDate = promiseDate;
    }

    public String getInternalNo() {
        return this.internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getProcessno() {
        return this.processno;
    }

    public void setProcessno(String processno) {
        this.processno = processno;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getProcessDate() {
        return this.processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getProcessOperatorId() {
        return this.processOperatorId;
    }

    public void setProcessOperatorId(String processOperatorId) {
        this.processOperatorId = processOperatorId;
    }

    public String getOperatorResult() {
        return this.operatorResult;
    }

    public void setOperatorResult(String operatorResult) {
        this.operatorResult = operatorResult;
    }

    public String getOperatorOpinion() {
        return this.operatorOpinion;
    }

    public void setOperatorOpinion(String operatorOpinion) {
        this.operatorOpinion = operatorOpinion;
    }

    public String getBiztype() {
        return this.biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public void copy(SuperviseOnwork other) {

        this.setSuperviseNo(other.getSuperviseNo());

        this.bjname = other.getBjname();
        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.complaintid = other.getComplaintid();
        this.outwayid = other.getOutwayid();
        this.orgId = other.getOrgId();
        this.operatorId = other.getOperatorId();
        this.superviseDate = other.getSuperviseDate();
        this.monitorOrgId = other.getMonitorOrgId();
        this.monitorOperatorId = other.getMonitorOperatorId();
        this.superviseOption = other.getSuperviseOption();
        this.promiseDate = other.getPromiseDate();
        this.internalNo = other.getInternalNo();
        this.processno = other.getProcessno();
        this.processName = other.getProcessName();
        this.processDate = other.getProcessDate();
        this.processOperatorId = other.getProcessOperatorId();
        this.operatorResult = other.getOperatorResult();
        this.operatorOpinion = other.getOperatorOpinion();
        this.biztype = other.getBiztype();
        this.unitcode = other.getUnitcode();

    }

    public void copyNotNullProperty(SuperviseOnwork other) {

        if (other.getSuperviseNo() != null)
            this.setSuperviseNo(other.getSuperviseNo());

        if (other.getBjname() != null)
            this.bjname = other.getBjname();
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
        if (other.getOperatorId() != null)
            this.operatorId = other.getOperatorId();
        if (other.getSuperviseDate() != null)
            this.superviseDate = other.getSuperviseDate();
        if (other.getMonitorOrgId() != null)
            this.monitorOrgId = other.getMonitorOrgId();
        if (other.getMonitorOperatorId() != null)
            this.monitorOperatorId = other.getMonitorOperatorId();
        if (other.getSuperviseOption() != null)
            this.superviseOption = other.getSuperviseOption();
        if (other.getPromiseDate() != null)
            this.promiseDate = other.getPromiseDate();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getProcessno() != null)
            this.processno = other.getProcessno();
        if (other.getProcessName() != null)
            this.processName = other.getProcessName();
        if (other.getProcessDate() != null)
            this.processDate = other.getProcessDate();
        if (other.getProcessOperatorId() != null)
            this.processOperatorId = other.getProcessOperatorId();
        if (other.getOperatorResult() != null)
            this.operatorResult = other.getOperatorResult();
        if (other.getOperatorOpinion() != null)
            this.operatorOpinion = other.getOperatorOpinion();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();
        if (other.getUnitcode() != null) {
            this.unitcode = other.getUnitcode();
        }

    }

    public void clearProperties() {

        this.bjname = null;
        this.bjType = null;
        this.bjNo = null;
        this.complaintid = null;
        this.outwayid = null;
        this.orgId = null;
        this.operatorId = null;
        this.superviseDate = null;
        this.monitorOrgId = null;
        this.monitorOperatorId = null;
        this.superviseOption = null;
        this.promiseDate = null;
        this.internalNo = null;
        this.processno = null;
        this.processName = null;
        this.processDate = null;
        this.processOperatorId = null;
        this.operatorResult = null;
        this.operatorOpinion = null;
        this.biztype = null;

    }

    public String getSuperviseResult() {
        return superviseResult;
    }

    public void setSuperviseResult(String superviseResult) {
        this.superviseResult = superviseResult;
    }

    public String getEndOpinion() {
        return endOpinion;
    }

    public void setEndOpinion(String endOpinion) {
        this.endOpinion = endOpinion;
    }

    public String getMonitorSource() {
        return monitorSource;
    }

    public void setMonitorSource(String monitorSource) {
        this.monitorSource = monitorSource;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

}

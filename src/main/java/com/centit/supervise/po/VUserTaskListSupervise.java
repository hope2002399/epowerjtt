package com.centit.supervise.po;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import com.centit.core.structs2.OptDesc;
import com.centit.core.structs2.Struts2UrlParser;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VUserTaskListSupervise implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Long taskId;

    private Long nodeInstId;
    private String unitCode;
    private String userCode;
    private String roleType;
    private String roleCode;
    private String optId;
    private String flowOptName;
    private String flowOptTag;
    private String authDesc;
    private String nodeName;
    private String nodeType;
    private String nodeOptType;
    private String optName;
    private String methodName;
    private String optUrl;
    private String optMethod;
    private String optDesc;
    private String optCode;
    private String optParam;
    private String inststate;
    private Date nodeCreateTime;
    private Long expireOptSign;
    private String expireOpt;
    private String grantor;
    private Long timeLimit;
    private String lastUpdateUser;
    private Date lastUpdateTime;
    private String flowPhase;

    private String superviseNo;
    private String bjType;
    private String bjNo;
    private String complaintId;
    private Long flowInstId;
    private String outWayId;
    private String orgId;
    private String operatorName;
    private String operatorID;
    private Date superviseDate;
    private String monitorOrgId;
    private String monitorOrgName;
    private String monitorOperatorId;
    private String monitorOperatorName;
    private String superviseOption;
    private Date promiseDate;
    private String internalNo;
    private String bjname;
    private String monitorSource;

    public String getMonitorSource() {
        return monitorSource;
    }

    public void setMonitorSource(String monitorSource) {
        this.monitorSource = monitorSource;
    }

    // Constructors
    /** default constructor */
    public VUserTaskListSupervise() {
    }

    /** minimal constructor */
    public VUserTaskListSupervise(Long taskId) {

        this.taskId = taskId;

    }

    /** full constructor */
    public VUserTaskListSupervise(Long taskId, Long nodeInstId,
            String unitCode, String userCode, String roleType, String roleCode,
            String optId, String flowOptName, String flowOptTag,
            String authDesc, String nodeName, String nodeType,
            String nodeOptType, String optName, String methodName,
            String optUrl, String optMethod, String optDesc, String optCode,
            String optParam, String inststate, Date nodeCreateTime,
            Long expireOptSign, String expireOpt, String grantor,
            Long timeLimit, String lastUpdateUser, Date lastUpdateTime,
            String flowPhase, String bjType, String bjNo, String complaintId,
            Long flowInstId, String outWayId, String orgId,
            String operatorName, String operatorID, Date superviseDate,
            String monitorOrgId, String monitorOrgName,
            String monitorOperatorId, String monitorOperatorName,
            String superviseOption, Date promiseDate, String monitorSource) {

        this.taskId = taskId;

        this.nodeInstId = nodeInstId;
        this.unitCode = unitCode;
        this.userCode = userCode;
        this.roleType = roleType;
        this.roleCode = roleCode;
        this.optId = optId;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.authDesc = authDesc;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.nodeOptType = nodeOptType;
        this.optName = optName;
        this.methodName = methodName;
        this.optUrl = optUrl;
        this.optMethod = optMethod;
        this.optDesc = optDesc;
        this.optCode = optCode;
        this.optParam = optParam;
        this.inststate = inststate;
        this.nodeCreateTime = nodeCreateTime;
        this.expireOptSign = expireOptSign;
        this.expireOpt = expireOpt;
        this.grantor = grantor;
        this.timeLimit = timeLimit;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateTime = lastUpdateTime;
        this.flowPhase = flowPhase;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.complaintId = complaintId;
        this.flowInstId = flowInstId;
        this.outWayId = outWayId;
        this.orgId = orgId;
        this.operatorName = operatorName;
        this.operatorID = operatorID;
        this.superviseDate = superviseDate;
        this.monitorOrgId = monitorOrgId;
        this.monitorOrgName = monitorOrgName;
        this.monitorOperatorId = monitorOperatorId;
        this.monitorOperatorName = monitorOperatorName;
        this.superviseOption = superviseOption;
        this.promiseDate = promiseDate;
        this.monitorSource = monitorSource;
    }

    public VUserTaskListSupervise(Long taskId, Long nodeInstId,
            String unitCode, String userCode, String roleType, String roleCode,
            String optId, String flowOptName, String flowOptTag,
            String authDesc, String nodeName, String nodeType,
            String nodeOptType, String optName, String methodName,
            String optUrl, String optMethod, String optDesc, String optCode,
            String optParam, String inststate, Date nodeCreateTime,
            Long expireOptSign, String expireOpt, String grantor,
            Long timeLimit, String lastUpdateUser, Date lastUpdateTime,
            String flowPhase, String superviseNo, String bjType, String bjNo,
            String complaintId, Long flowInstId, String outWayId, String orgId,
            String operatorName, String operatorID, Date superviseDate,
            String monitorOrgId, String monitorOrgName,
            String monitorOperatorId, String monitorOperatorName,
            String superviseOption, Date promiseDate) {
        super();
        this.taskId = taskId;
        this.nodeInstId = nodeInstId;
        this.unitCode = unitCode;
        this.userCode = userCode;
        this.roleType = roleType;
        this.roleCode = roleCode;
        this.optId = optId;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.authDesc = authDesc;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.nodeOptType = nodeOptType;
        this.optName = optName;
        this.methodName = methodName;
        this.optUrl = optUrl;
        this.optMethod = optMethod;
        this.optDesc = optDesc;
        this.optCode = optCode;
        this.optParam = optParam;
        this.inststate = inststate;
        this.nodeCreateTime = nodeCreateTime;
        this.expireOptSign = expireOptSign;
        this.expireOpt = expireOpt;
        this.grantor = grantor;
        this.timeLimit = timeLimit;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateTime = lastUpdateTime;
        this.flowPhase = flowPhase;
        this.superviseNo = superviseNo;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.complaintId = complaintId;
        this.flowInstId = flowInstId;
        this.outWayId = outWayId;
        this.orgId = orgId;
        this.operatorName = operatorName;
        this.operatorID = operatorID;
        this.superviseDate = superviseDate;
        this.monitorOrgId = monitorOrgId;
        this.monitorOrgName = monitorOrgName;
        this.monitorOperatorId = monitorOperatorId;
        this.monitorOperatorName = monitorOperatorName;
        this.superviseOption = superviseOption;
        this.promiseDate = promiseDate;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    // Property accessors

    public Long getNodeInstId() {
        return this.nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public String getSuperviseNo() {
        return superviseNo;
    }

    public void setSuperviseNo(String superviseNo) {
        this.superviseNo = superviseNo;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getOptId() {
        return this.optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getFlowOptName() {
        return this.flowOptName;
    }

    public void setFlowOptName(String flowOptName) {
        this.flowOptName = flowOptName;
    }

    public String getFlowOptTag() {
        return this.flowOptTag;
    }

    public void setFlowOptTag(String flowOptTag) {
        this.flowOptTag = flowOptTag;
    }

    public String getAuthDesc() {
        return this.authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return this.nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeOptType() {
        return this.nodeOptType;
    }

    public void setNodeOptType(String nodeOptType) {
        this.nodeOptType = nodeOptType;
    }

    public String getOptName() {
        return this.optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getOptUrl() {
        return this.optUrl;
    }

    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl;
    }

    public String getOptMethod() {
        return this.optMethod;
    }

    public void setOptMethod(String optMethod) {
        this.optMethod = optMethod;
    }

    public String getOptDesc() {
        return this.optDesc;
    }

    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }

    public String getOptCode() {
        return this.optCode;
    }

    public void setOptCode(String optCode) {
        this.optCode = optCode;
    }

    public String getOptParam() {
        return this.optParam;
    }

    public void setOptParam(String optParam) {
        this.optParam = optParam;
    }

    public String getInststate() {
        return this.inststate;
    }

    public void setInststate(String inststate) {
        this.inststate = inststate;
    }

    public Date getNodeCreateTime() {
        return this.nodeCreateTime;
    }

    public void setNodeCreateTime(Date nodeCreateTime) {
        this.nodeCreateTime = nodeCreateTime;
    }

    public Long getExpireOptSign() {
        return this.expireOptSign;
    }

    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    public String getExpireOpt() {
        return this.expireOpt;
    }

    public void setExpireOpt(String expireOpt) {
        this.expireOpt = expireOpt;
    }

    public String getGrantor() {
        return this.grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public Long getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getLastUpdateUser() {
        return this.lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getFlowPhase() {
        return this.flowPhase;
    }

    public void setFlowPhase(String flowPhase) {
        this.flowPhase = flowPhase;
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

    public String getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getOutWayId() {
        return this.outWayId;
    }

    public void setOutWayId(String outWayId) {
        this.outWayId = outWayId;
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

    public String getOperatorID() {
        return this.operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
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

    public Date getPromiseDate() {
        return this.promiseDate;
    }

    public void setPromiseDate(Date promiseDate) {
        this.promiseDate = promiseDate;
    }

    public void copy(VUserTaskListSupervise other) {

        this.setTaskId(other.getTaskId());

        this.nodeInstId = other.getNodeInstId();
        this.unitCode = other.getUnitCode();
        this.userCode = other.getUserCode();
        this.roleType = other.getRoleType();
        this.roleCode = other.getRoleCode();
        this.optId = other.getOptId();
        this.flowOptName = other.getFlowOptName();
        this.flowOptTag = other.getFlowOptTag();
        this.authDesc = other.getAuthDesc();
        this.nodeName = other.getNodeName();
        this.nodeType = other.getNodeType();
        this.nodeOptType = other.getNodeOptType();
        this.optName = other.getOptName();
        this.methodName = other.getMethodName();
        this.optUrl = other.getOptUrl();
        this.optMethod = other.getOptMethod();
        this.optDesc = other.getOptDesc();
        this.optCode = other.getOptCode();
        this.optParam = other.getOptParam();
        this.inststate = other.getInststate();
        this.nodeCreateTime = other.getNodeCreateTime();
        this.expireOptSign = other.getExpireOptSign();
        this.expireOpt = other.getExpireOpt();
        this.grantor = other.getGrantor();
        this.timeLimit = other.getTimeLimit();
        this.lastUpdateUser = other.getLastUpdateUser();
        this.lastUpdateTime = other.getLastUpdateTime();
        this.flowPhase = other.getFlowPhase();
        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.complaintId = other.getComplaintId();
        this.flowInstId = other.getFlowInstId();
        this.outWayId = other.getOutWayId();
        this.orgId = other.getOrgId();
        this.operatorName = other.getOperatorName();
        this.operatorID = other.getOperatorID();
        this.superviseDate = other.getSuperviseDate();
        this.monitorOrgId = other.getMonitorOrgId();
        this.monitorOrgName = other.getMonitorOrgName();
        this.monitorOperatorId = other.getMonitorOperatorId();
        this.monitorOperatorName = other.getMonitorOperatorName();
        this.superviseOption = other.getSuperviseOption();
        this.promiseDate = other.getPromiseDate();
        this.superviseNo = other.getSuperviseNo();
        this.internalNo = other.getInternalNo();
        this.bjname = other.getBjname();

    }

    public void copyNotNullProperty(VUserTaskListSupervise other) {

        if (other.getTaskId() != null)
            this.setTaskId(other.getTaskId());

        if (other.getNodeInstId() != null)
            this.nodeInstId = other.getNodeInstId();
        if (other.getUnitCode() != null)
            this.unitCode = other.getUnitCode();
        if (other.getUserCode() != null)
            this.userCode = other.getUserCode();
        if (other.getRoleType() != null)
            this.roleType = other.getRoleType();
        if (other.getRoleCode() != null)
            this.roleCode = other.getRoleCode();
        if (other.getOptId() != null)
            this.optId = other.getOptId();
        if (other.getFlowOptName() != null)
            this.flowOptName = other.getFlowOptName();
        if (other.getFlowOptTag() != null)
            this.flowOptTag = other.getFlowOptTag();
        if (other.getAuthDesc() != null)
            this.authDesc = other.getAuthDesc();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getNodeType() != null)
            this.nodeType = other.getNodeType();
        if (other.getNodeOptType() != null)
            this.nodeOptType = other.getNodeOptType();
        if (other.getOptName() != null)
            this.optName = other.getOptName();
        if (other.getMethodName() != null)
            this.methodName = other.getMethodName();
        if (other.getOptUrl() != null)
            this.optUrl = other.getOptUrl();
        if (other.getOptMethod() != null)
            this.optMethod = other.getOptMethod();
        if (other.getOptDesc() != null)
            this.optDesc = other.getOptDesc();
        if (other.getOptCode() != null)
            this.optCode = other.getOptCode();
        if (other.getOptParam() != null)
            this.optParam = other.getOptParam();
        if (other.getInststate() != null)
            this.inststate = other.getInststate();
        if (other.getNodeCreateTime() != null)
            this.nodeCreateTime = other.getNodeCreateTime();
        if (other.getExpireOptSign() != null)
            this.expireOptSign = other.getExpireOptSign();
        if (other.getExpireOpt() != null)
            this.expireOpt = other.getExpireOpt();
        if (other.getGrantor() != null)
            this.grantor = other.getGrantor();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getLastUpdateUser() != null)
            this.lastUpdateUser = other.getLastUpdateUser();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
        if (other.getFlowPhase() != null)
            this.flowPhase = other.getFlowPhase();
        if (other.getBjType() != null)
            this.bjType = other.getBjType();
        if (other.getBjNo() != null)
            this.bjNo = other.getBjNo();
        if (other.getComplaintId() != null)
            this.complaintId = other.getComplaintId();
        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getOutWayId() != null)
            this.outWayId = other.getOutWayId();
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getOperatorName() != null)
            this.operatorName = other.getOperatorName();
        if (other.getOperatorID() != null)
            this.operatorID = other.getOperatorID();
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
        if (other.getPromiseDate() != null)
            this.promiseDate = other.getPromiseDate();
        if (other.getSuperviseNo() != null)
            this.superviseNo = other.getSuperviseNo();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getBjname() != null)
            this.bjname = other.getBjname();
    }

    public void clearProperties() {

        this.nodeInstId = null;
        this.unitCode = null;
        this.userCode = null;
        this.roleType = null;
        this.roleCode = null;
        this.optId = null;
        this.flowOptName = null;
        this.flowOptTag = null;
        this.authDesc = null;
        this.nodeName = null;
        this.nodeType = null;
        this.nodeOptType = null;
        this.optName = null;
        this.methodName = null;
        this.optUrl = null;
        this.optMethod = null;
        this.optDesc = null;
        this.optCode = null;
        this.optParam = null;
        this.inststate = null;
        this.nodeCreateTime = null;
        this.expireOptSign = null;
        this.expireOpt = null;
        this.grantor = null;
        this.timeLimit = null;
        this.lastUpdateUser = null;
        this.lastUpdateTime = null;
        this.flowPhase = null;
        this.bjType = null;
        this.bjNo = null;
        this.complaintId = null;
        this.flowInstId = null;
        this.outWayId = null;
        this.orgId = null;
        this.operatorName = null;
        this.operatorID = null;
        this.superviseDate = null;
        this.monitorOrgId = null;
        this.monitorOrgName = null;
        this.monitorOperatorId = null;
        this.monitorOperatorName = null;
        this.superviseOption = null;
        this.promiseDate = null;
        this.superviseNo = null;
        this.internalNo = null;
        this.bjname = null;

    }

    public String getNodeOptUrl() {
        if (optUrl == null) {
            return null;
        }

        OptDesc optDesc = Struts2UrlParser.parseUrl(optUrl);
        optDesc.setMethod(optMethod);
        String url = optDesc.getOptUrl() + "?nodeInstId=" + getNodeInstId()
                + "&flowInstId=" + flowInstId + "&flowPhase=" + flowPhase;
        // System.out.println(url);
        if (grantor != null && !"".equals(grantor)) {// &&
                                                     // !grantor.equals(userCode)){
            url = url + "&isGrantor=yes&grantor=" + grantor;
        }
        if (optParam != null && !"".equals(optParam))
            url = url + "&" + optParam;

        try {
            url = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "/sampleflow/flowUserTask!todoWork.do?nodeInstId="
                + getNodeInstId() + "&flowInstId=" + flowInstId
                + "&nodeOptUrl=" + url;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo;
    }

    public String getBjname() {
        return bjname;
    }

    public void setBjname(String bjname) {
        this.bjname = bjname;
    }

    public VUserTaskListSupervise(Long taskId, Long nodeInstId,
            String unitCode, String userCode, String roleType, String roleCode,
            String optId, String flowOptName, String flowOptTag,
            String authDesc, String nodeName, String nodeType,
            String nodeOptType, String optName, String methodName,
            String optUrl, String optMethod, String optDesc, String optCode,
            String optParam, String inststate, Date nodeCreateTime,
            Long expireOptSign, String expireOpt, String grantor,
            Long timeLimit, String lastUpdateUser, Date lastUpdateTime,
            String flowPhase, String superviseNo, String bjType, String bjNo,
            String complaintId, Long flowInstId, String outWayId, String orgId,
            String operatorName, String operatorID, Date superviseDate,
            String monitorOrgId, String monitorOrgName,
            String monitorOperatorId, String monitorOperatorName,
            String superviseOption, Date promiseDate, String internalNo,
            String bjname) {
        super();
        this.taskId = taskId;
        this.nodeInstId = nodeInstId;
        this.unitCode = unitCode;
        this.userCode = userCode;
        this.roleType = roleType;
        this.roleCode = roleCode;
        this.optId = optId;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.authDesc = authDesc;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.nodeOptType = nodeOptType;
        this.optName = optName;
        this.methodName = methodName;
        this.optUrl = optUrl;
        this.optMethod = optMethod;
        this.optDesc = optDesc;
        this.optCode = optCode;
        this.optParam = optParam;
        this.inststate = inststate;
        this.nodeCreateTime = nodeCreateTime;
        this.expireOptSign = expireOptSign;
        this.expireOpt = expireOpt;
        this.grantor = grantor;
        this.timeLimit = timeLimit;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateTime = lastUpdateTime;
        this.flowPhase = flowPhase;
        this.superviseNo = superviseNo;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.complaintId = complaintId;
        this.flowInstId = flowInstId;
        this.outWayId = outWayId;
        this.orgId = orgId;
        this.operatorName = operatorName;
        this.operatorID = operatorID;
        this.superviseDate = superviseDate;
        this.monitorOrgId = monitorOrgId;
        this.monitorOrgName = monitorOrgName;
        this.monitorOperatorId = monitorOperatorId;
        this.monitorOperatorName = monitorOperatorName;
        this.superviseOption = superviseOption;
        this.promiseDate = promiseDate;
        this.internalNo = internalNo;
        this.bjname = bjname;
    }

}

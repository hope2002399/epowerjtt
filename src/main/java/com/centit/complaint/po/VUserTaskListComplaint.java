package com.centit.complaint.po;

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

public class VUserTaskListComplaint implements java.io.Serializable {
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
    private String grantOrgId;
    private Long timeLimit;
    private String lastUpdateUser;
    private Date lastUpdateTime;
    private String flowPhase;
    private String bjType;
    private String bjNo;
    private String itemId;
    private String internalNo;
    private String complaintsType;
    private String complaintsSource;
    private String complaintMan;
    private String complaintPhone;
    private Date complaintDate;
    private String complaintReason;
    private String complaintRemark;
    private String complaintId;
    private Long flowInstId;

    // Constructors
    /** default constructor */
    public VUserTaskListComplaint() {
    }

    /** minimal constructor */
    public VUserTaskListComplaint(Long taskId) {

        this.taskId = taskId;

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

    public String getComplaintMan() {
        return this.complaintMan;
    }

    public void setComplaintMan(String complaintMan) {
        this.complaintMan = complaintMan;
    }

    public String getComplaintPhone() {
        return this.complaintPhone;
    }

    public void setComplaintPhone(String complaintPhone) {
        this.complaintPhone = complaintPhone;
    }

    public Date getComplaintDate() {
        return this.complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintReason() {
        return this.complaintReason;
    }

    public void setComplaintReason(String complaintReason) {
        this.complaintReason = complaintReason;
    }

    public String getComplaintRemark() {
        return this.complaintRemark;
    }

    public void setComplaintRemark(String complaintRemark) {
        this.complaintRemark = complaintRemark;
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

    public void copy(VUserTaskListComplaint other) {

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
        this.itemId = other.getItemId();
        this.internalNo = other.getInternalNo();
        this.complaintsType = other.getComplaintsType();
        this.complaintsSource = other.getComplaintsSource();
        this.complaintMan = other.getComplaintMan();
        this.complaintPhone = other.getComplaintPhone();
        this.complaintDate = other.getComplaintDate();
        this.complaintReason = other.getComplaintReason();
        this.complaintRemark = other.getComplaintRemark();
        this.complaintId = other.getComplaintId();
        this.flowInstId = other.getFlowInstId();
        this.grantOrgId = other.getGrantOrgId();

    }

    public void copyNotNullProperty(VUserTaskListComplaint other) {

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
        if (other.getItemId() != null)
            this.itemId = other.getItemId();
        if (other.getInternalNo() != null)
            this.internalNo = other.getInternalNo();
        if (other.getComplaintsType() != null)
            this.complaintsType = other.getComplaintsType();
        if (other.getComplaintsSource() != null)
            this.complaintsSource = other.getComplaintsSource();
        if (other.getComplaintMan() != null)
            this.complaintMan = other.getComplaintMan();
        if (other.getComplaintPhone() != null)
            this.complaintPhone = other.getComplaintPhone();
        if (other.getComplaintDate() != null)
            this.complaintDate = other.getComplaintDate();
        if (other.getComplaintReason() != null)
            this.complaintReason = other.getComplaintReason();
        if (other.getComplaintRemark() != null)
            this.complaintRemark = other.getComplaintRemark();
        if (other.getComplaintId() != null)
            this.complaintId = other.getComplaintId();
        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getGrantOrgId() != null)
            this.grantOrgId = other.getGrantOrgId();

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
        this.itemId = null;
        this.internalNo = null;
        this.complaintsType = null;
        this.complaintsSource = null;
        this.complaintMan = null;
        this.complaintPhone = null;
        this.complaintDate = null;
        this.complaintReason = null;
        this.complaintRemark = null;
        this.complaintId = null;
        this.flowInstId = null;
        this.grantOrgId = null;

    }

    public String getGrantOrgId() {
        return grantOrgId;
    }

    public void setGrantOrgId(String grantOrgId) {
        this.grantOrgId = grantOrgId;
    }

}

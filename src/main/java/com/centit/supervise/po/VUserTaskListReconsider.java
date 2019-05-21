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

public class VUserTaskListReconsider implements java.io.Serializable {
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
    private Long timeLimit;
    private String lastUpdateUser;
    private Date lastUpdateTime;
    private String flowPhase;
    private String reconsiderid;
    private Date reconsiderdate;
    private String reconsiderapply;
    private String applyphone;
    private Date applydate;
    private String applyreason;
    private String applyremark;
    private String reconsiderdep;
    private String bookoperator;
    private Date bookdate;
    private Long flowInstId;
    private String bjType;
    private String bjNo;
    private String itemId;
    private String internalNo;
    private String orgId;
    private String biztype;

    // Constructors
    /** default constructor */
    public VUserTaskListReconsider() {
    }

    /** minimal constructor */
    public VUserTaskListReconsider(Long taskId, String orgId) {

        this.taskId = taskId;

        this.orgId = orgId;
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

    public String getReconsiderid() {
        return this.reconsiderid;
    }

    public void setReconsiderid(String reconsiderid) {
        this.reconsiderid = reconsiderid;
    }

    public Date getReconsiderdate() {
        return this.reconsiderdate;
    }

    public void setReconsiderdate(Date reconsiderdate) {
        this.reconsiderdate = reconsiderdate;
    }

    public String getReconsiderapply() {
        return this.reconsiderapply;
    }

    public void setReconsiderapply(String reconsiderapply) {
        this.reconsiderapply = reconsiderapply;
    }

    public String getApplyphone() {
        return this.applyphone;
    }

    public void setApplyphone(String applyphone) {
        this.applyphone = applyphone;
    }

    public Date getApplydate() {
        return this.applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getApplyreason() {
        return this.applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getApplyremark() {
        return this.applyremark;
    }

    public void setApplyremark(String applyremark) {
        this.applyremark = applyremark;
    }

    public String getReconsiderdep() {
        return this.reconsiderdep;
    }

    public void setReconsiderdep(String reconsiderdep) {
        this.reconsiderdep = reconsiderdep;
    }

    public String getBookoperator() {
        return this.bookoperator;
    }

    public void setBookoperator(String bookoperator) {
        this.bookoperator = bookoperator;
    }

    public Date getBookdate() {
        return this.bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

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

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBiztype() {
        return this.biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype;
    }

    public VUserTaskListReconsider(Long taskId, Long nodeInstId,
            String unitCode, String userCode, String roleType, String roleCode,
            String optId, String flowOptName, String flowOptTag,
            String authDesc, String nodeName, String nodeType,
            String nodeOptType, String optName, String methodName,
            String optUrl, String optMethod, String optDesc, String optCode,
            String optParam, String inststate, Date nodeCreateTime,
            Long expireOptSign, String expireOpt, Long timeLimit,
            String lastUpdateUser, Date lastUpdateTime, String flowPhase,
            String reconsiderid, Date reconsiderdate, String reconsiderapply,
            String applyphone, Date applydate, String applyreason,
            String applyremark, String reconsiderdep, String bookoperator,
            Date bookdate, Long flowInstId, String bjType, String bjNo,
            String itemId, String internalNo, String orgId, String biztype) {
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
        this.timeLimit = timeLimit;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateTime = lastUpdateTime;
        this.flowPhase = flowPhase;
        this.reconsiderid = reconsiderid;
        this.reconsiderdate = reconsiderdate;
        this.reconsiderapply = reconsiderapply;
        this.applyphone = applyphone;
        this.applydate = applydate;
        this.applyreason = applyreason;
        this.applyremark = applyremark;
        this.reconsiderdep = reconsiderdep;
        this.bookoperator = bookoperator;
        this.bookdate = bookdate;
        this.flowInstId = flowInstId;
        this.bjType = bjType;
        this.bjNo = bjNo;
        this.itemId = itemId;
        this.internalNo = internalNo;
        this.orgId = orgId;
        this.biztype = biztype;
    }

    public void copy(VUserTaskListReconsider other) {

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
        this.timeLimit = other.getTimeLimit();
        this.lastUpdateUser = other.getLastUpdateUser();
        this.lastUpdateTime = other.getLastUpdateTime();
        this.flowPhase = other.getFlowPhase();
        this.reconsiderid = other.getReconsiderid();
        this.reconsiderdate = other.getReconsiderdate();
        this.reconsiderapply = other.getReconsiderapply();
        this.applyphone = other.getApplyphone();
        this.applydate = other.getApplydate();
        this.applyreason = other.getApplyreason();
        this.applyremark = other.getApplyremark();
        this.reconsiderdep = other.getReconsiderdep();
        this.bookoperator = other.getBookoperator();
        this.bookdate = other.getBookdate();
        this.flowInstId = other.getFlowInstId();
        this.bjType = other.getBjType();
        this.bjNo = other.getBjNo();
        this.itemId = other.getItemId();
        this.internalNo = other.getInternalNo();
        this.orgId = other.getOrgId();
        this.biztype = other.getBiztype();

    }

    public void copyNotNullProperty(VUserTaskListReconsider other) {

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
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getLastUpdateUser() != null)
            this.lastUpdateUser = other.getLastUpdateUser();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
        if (other.getFlowPhase() != null)
            this.flowPhase = other.getFlowPhase();
        if (other.getReconsiderid() != null)
            this.reconsiderid = other.getReconsiderid();
        if (other.getReconsiderdate() != null)
            this.reconsiderdate = other.getReconsiderdate();
        if (other.getReconsiderapply() != null)
            this.reconsiderapply = other.getReconsiderapply();
        if (other.getApplyphone() != null)
            this.applyphone = other.getApplyphone();
        if (other.getApplydate() != null)
            this.applydate = other.getApplydate();
        if (other.getApplyreason() != null)
            this.applyreason = other.getApplyreason();
        if (other.getApplyremark() != null)
            this.applyremark = other.getApplyremark();
        if (other.getReconsiderdep() != null)
            this.reconsiderdep = other.getReconsiderdep();
        if (other.getBookoperator() != null)
            this.bookoperator = other.getBookoperator();
        if (other.getBookdate() != null)
            this.bookdate = other.getBookdate();
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
        if (other.getOrgId() != null)
            this.orgId = other.getOrgId();
        if (other.getBiztype() != null)
            this.biztype = other.getBiztype();

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
        this.timeLimit = null;
        this.lastUpdateUser = null;
        this.lastUpdateTime = null;
        this.flowPhase = null;
        this.reconsiderid = null;
        this.reconsiderdate = null;
        this.reconsiderapply = null;
        this.applyphone = null;
        this.applydate = null;
        this.applyreason = null;
        this.applyremark = null;
        this.reconsiderdep = null;
        this.bookoperator = null;
        this.bookdate = null;
        this.flowInstId = null;
        this.bjType = null;
        this.bjNo = null;
        this.itemId = null;
        this.internalNo = null;
        this.orgId = null;
        this.biztype = null;

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
}

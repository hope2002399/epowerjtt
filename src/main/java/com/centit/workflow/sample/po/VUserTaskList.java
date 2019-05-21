package com.centit.workflow.sample.po;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import com.centit.core.structs2.OptDesc;
import com.centit.core.structs2.Struts2UrlParser;
import com.centit.core.utils.WorkTimeSpan;
import com.centit.workflow.UserTask;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VUserTaskList implements java.io.Serializable, UserTask {
    private static final long serialVersionUID = 1L;
    private VUserTaskListId cid;

    private Long flowInstId;
    private String authDesc;
    private String flowOptName;
    private String flowOptTag;
    private String nodeName;
    private String nodeType;
    private String nodeOptType;
    private String optName;
    private String methodName;
    private String optId;
    private String optParam;
    private String optUrl;
    private String optMethod;
    private String optDesc;
    private String optCode;
    private Date createTime;
    private String expireOpt;
    private Date lastUpdateTime;
    private String lastUpdateUser;
    private Long promiseTime;
    private Long timeLimit;
    private String grantor;
    private String roleType;
    private String roleCode;

    private String inststate;
    private Date nodeCreateTime;
    private Date nodeExpireTime;
    private Long expireOptSign;
    private Date nodeLastUpdateTime;
    private Date flowExpireTime;
    private Long flowTimeLimit;

    // 流程节点阶段
    private String flowPhase;

    // Constructors
    /** default constructor */
    public VUserTaskList() {
    }

    /** minimal constructor */
    public VUserTaskList(VUserTaskListId id

    ) {
        this.cid = id;

    }

    /** full constructor */
    public VUserTaskList(VUserTaskListId id

    , Long flowInstId, String authDesc, String flowOptName, String flowOptTag,
            String nodeName, String nodeType, String nodeOptType,
            String optName, String methodName, String optParam, String optUrl,
            String optMethod, String optDesc, String optCode, Date createTime,
            Long promiseTime, String expireOpt, String grantor,
            String flowPhase, String roleType, String roleCode) {
        this.cid = id;

        this.flowInstId = flowInstId;
        this.authDesc = authDesc;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.nodeOptType = nodeOptType;
        this.optName = optName;
        this.methodName = methodName;
        this.optParam = optParam;
        this.optUrl = optUrl;
        this.optMethod = optMethod;
        this.optDesc = optDesc;
        this.optCode = optCode;
        this.createTime = createTime;
        this.promiseTime = promiseTime;
        this.expireOpt = expireOpt;
        this.grantor = grantor;
        this.flowPhase = flowPhase;
        this.roleType = roleType;
        this.roleCode = roleCode;
    }

    @Override
    public String getNodeOptUrl() {
        if (optUrl == null) {
            return null;
        }

        OptDesc optDesc = Struts2UrlParser.parseUrl(optUrl);
        optDesc.setMethod(optMethod);
        String url = optDesc.getOptUrl() + "?nodeInstId=" + cid.getNodeInstId()
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
                + cid.getNodeInstId() + "&flowInstId=" + flowInstId
                + "&nodeOptUrl=" + url;
    }

    public VUserTaskListId getCid() {
        return this.cid;
    }

    public void setCid(VUserTaskListId id) {
        this.cid = id;
    }

    public Long getNodeInstId() {
        if (this.cid == null)
            this.cid = new VUserTaskListId();
        return this.cid.getNodeInstId();
    }

    public void setNodeInstId(Long nodeInstId) {
        if (this.cid == null)
            this.cid = new VUserTaskListId();
        this.cid.setNodeInstId(nodeInstId);
    }

    public String getUnitCode() {
        if (this.cid == null)
            this.cid = new VUserTaskListId();
        return this.cid.getUnitCode();
    }

    public void setUnitCode(String unitCode) {
        if (this.cid == null)
            this.cid = new VUserTaskListId();
        this.cid.setUnitCode(unitCode);
    }

    public String getUserCode() {
        if (this.cid == null)
            this.cid = new VUserTaskListId();
        return this.cid.getUserCode();
    }

    public void setUserCode(String userCode) {
        if (this.cid == null)
            this.cid = new VUserTaskListId();
        this.cid.setUserCode(userCode);
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

    // Property accessors
    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public String getAuthDesc() {
        return this.authDesc;
    }

    public void setAuthDesc(String authDesc) {
        this.authDesc = authDesc;
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

    public String getOptParam() {
        return this.optParam;
    }

    public void setOptParam(String optParam) {
        this.optParam = optParam;
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

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPromiseTimeStr() {
        if (promiseTime == null)
            return "";
        WorkTimeSpan wts = new WorkTimeSpan();
        wts.fromNumber(promiseTime);
        return wts.getTimeSpanDesc();
    }

    public Long getPromiseTime() {
        return promiseTime;
    }

    public void setPromiseTime(Long promiseTime) {
        this.promiseTime = promiseTime;
    }

    public String getTimeLimitStr() {
        if (timeLimit == null)
            return "";
        WorkTimeSpan wts = new WorkTimeSpan();
        wts.fromNumber(timeLimit);
        return wts.getTimeSpanDesc();
    }

    /**
     * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
     * 
     * @return
     */
    public String getExpireOpt() {
        return this.expireOpt;
    }

    /**
     * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
     * 
     * @param expireopt
     */
    public void setExpireOpt(String expireopt) {
        this.expireOpt = expireopt;
    }

    public void copy(VUserTaskList other) {

        this.setNodeInstId(other.getNodeInstId());
        this.setUnitCode(other.getUnitCode());
        this.setUserCode(other.getUserCode());
        this.setRoleType(other.getRoleType());
        this.setRoleCode(other.getRoleCode());

        this.flowInstId = other.getFlowInstId();
        this.authDesc = other.getAuthDesc();
        this.flowOptName = other.getFlowOptName();
        this.flowOptTag = other.getFlowOptTag();
        this.nodeName = other.getNodeName();
        this.nodeType = other.getNodeType();
        this.nodeOptType = other.getNodeOptType();
        this.optName = other.getOptName();
        this.methodName = other.getMethodName();
        this.optParam = other.getOptParam();
        this.optUrl = other.getOptUrl();
        this.optMethod = other.getOptMethod();
        this.optDesc = other.getOptDesc();
        this.optCode = other.getOptCode();
        this.createTime = other.getCreateTime();
        this.promiseTime = other.getPromiseTime();
        this.lastUpdateTime = other.getLastUpdateTime();
        this.expireOpt = other.getExpireOpt();
        this.grantor = other.getGrantor();
        this.flowPhase = other.getFlowPhase();
        this.optId = other.getOptId();
        this.roleType = other.getRoleType();
        this.roleCode = other.getRoleCode();
    }

    public void copyNotNullProperty(VUserTaskList other) {

        if (other.getNodeInstId() != null)
            this.setNodeInstId(other.getNodeInstId());
        if (other.getUnitCode() != null)
            this.setUnitCode(other.getUnitCode());
        if (other.getUserCode() != null)
            this.setUserCode(other.getUserCode());
        if (other.getRoleType() != null)
            this.setRoleType(other.getRoleType());
        if (other.getRoleCode() != null)
            this.setRoleCode(other.getRoleCode());

        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getAuthDesc() != null)
            this.authDesc = other.getAuthDesc();
        if (other.getFlowOptName() != null)
            this.flowOptName = other.getFlowOptName();
        if (other.getFlowOptTag() != null)
            this.flowOptTag = other.getFlowOptTag();
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
        if (other.getOptParam() != null)
            this.optParam = other.getOptParam();
        if (other.getOptUrl() != null)
            this.optUrl = other.getOptUrl();
        if (other.getOptMethod() != null)
            this.optMethod = other.getOptMethod();
        if (other.getOptDesc() != null)
            this.optDesc = other.getOptDesc();
        if (other.getOptCode() != null)
            this.optCode = other.getOptCode();
        if (other.getCreateTime() != null)
            this.createTime = other.getCreateTime();
        if (other.getPromiseTime() != null)
            this.promiseTime = other.getPromiseTime();
        if (other.getExpireOpt() != null)
            this.expireOpt = other.getExpireOpt();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
        if (other.getGrantor() != null) {
            this.grantor = other.getGrantor();
        }
        if (other.getFlowPhase() != null)
            this.flowPhase = other.getFlowPhase();
        if (other.getOptId() != null)
            this.optId = other.getOptId();
        if (other.getRoleType() != null) {
            this.roleType = other.getRoleType();
        }
        if (other.getRoleCode() != null) {
            this.roleCode = other.getRoleCode();
        }
    }

    public void clearProperties() {

        this.flowInstId = null;
        this.authDesc = null;
        this.flowOptName = null;
        this.flowOptTag = null;
        this.nodeName = null;
        this.nodeType = null;
        this.nodeOptType = null;
        this.optName = null;
        this.methodName = null;
        this.optParam = null;
        this.optUrl = null;
        this.optMethod = null;
        this.optDesc = null;
        this.optCode = null;
        this.createTime = null;
        this.promiseTime = null;
        this.expireOpt = null;
        this.grantor = null;
        this.flowPhase = null;
        this.optId = null;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public String getFlowPhase() {
        return flowPhase;
    }

    public void setFlowPhase(String flowPhase) {
        this.flowPhase = flowPhase;
    }

    public String getOptId() {
        return optId;
    }

    public void setOptId(String optId) {
        this.optId = optId;
    }

    public String getInststate() {
        return inststate;
    }

    public void setInststate(String inststate) {
        this.inststate = inststate;
    }

    public Date getNodeCreateTime() {
        return nodeCreateTime;
    }

    public void setNodeCreateTime(Date nodeCreateTime) {
        this.nodeCreateTime = nodeCreateTime;
    }

    public Date getNodeExpireTime() {
        return nodeExpireTime;
    }

    public void setNodeExpireTime(Date nodeExpireTime) {
        this.nodeExpireTime = nodeExpireTime;
    }

    public Long getExpireOptSign() {
        return expireOptSign;
    }

    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    public Date getNodeLastUpdateTime() {
        return nodeLastUpdateTime;
    }

    public void setNodeLastUpdateTime(Date nodeLastUpdateTime) {
        this.nodeLastUpdateTime = nodeLastUpdateTime;
    }

    public Date getFlowExpireTime() {
        return flowExpireTime;
    }

    public void setFlowExpireTime(Date flowExpireTime) {
        this.flowExpireTime = flowExpireTime;
    }

    public Long getFlowTimeLimit() {
        return flowTimeLimit;
    }

    public void setFlowTimeLimit(Long flowTimeLimit) {
        this.flowTimeLimit = flowTimeLimit;
    }
}

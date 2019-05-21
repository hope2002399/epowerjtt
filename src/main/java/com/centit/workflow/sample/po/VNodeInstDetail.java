package com.centit.workflow.sample.po;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.core.structs2.OptDesc;
import com.centit.core.structs2.Struts2UrlParser;
import com.centit.core.utils.WorkTimeSpan;
import com.centit.workflow.NodeInstance;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class VNodeInstDetail implements java.io.Serializable, NodeInstance {
    private static final long serialVersionUID = 1L;

    private Long nodeInstId;

    private Long flowInstId;
    private Long nodeId;
    private Date createTime;
    private Long prevNodeInstId;
    private Long promiseTime;
    private Long timeLimit;
    private String nodeState;
    private Long subFlowInstId;
    private String unitCode;
    private Long transId;
    private String taskAssigned;
    private Long expireOptSign;
    private String runToken;
    private String lastUpdateUser;
    private Date lastUpdateTime;
    private String isTimer;
    private String flowOptName;
    private String flowOptTag;
    private String nodeName;
    private String roleType;
    private String roleCode;
    private String optName;
    private String methodName;
    private String optParam;
    private String optUrl;
    private String optMethod;
    private Set<WfActionLog> wfActionLogs = null;// new
                                                 // ArrayList<WfActionLog>();
    private Set<WfActionTask> wfActionTasks = null;// new
                                                   // ArrayList<WfActionTask>();

    // 非持久化属性
    private String isRecycle;// yes:可以回收；no：不可以回收

    // Constructors
    /** default constructor */
    public VNodeInstDetail() {
    }

    /** minimal constructor */
    public VNodeInstDetail(Long nodeInstId) {

        this.nodeInstId = nodeInstId;

    }

    /** full constructor */
    public VNodeInstDetail(Long nodeInstId, Long flowInstId, Long nodeId,
            Date createTime, Long prevNodeInstId, Long promiseTime,
            Long timeLimit, String nodeState, Long subFlowInstId,
            String unitCode, Long transId, String taskAssigned,
            Long expireOptSign, String runToken, String lastUpdateUser,
            Date lastUpdateTime, String isTimer, String flowOptName,
            String flowOptTag, String nodeName, String roleType,
            String roleCode, String optName, String methodName, String optUrl,
            String optMethod) {

        this.nodeInstId = nodeInstId;

        this.flowInstId = flowInstId;
        this.nodeId = nodeId;
        this.createTime = createTime;
        this.prevNodeInstId = prevNodeInstId;
        this.timeLimit = timeLimit;
        this.nodeState = nodeState;
        this.subFlowInstId = subFlowInstId;
        this.unitCode = unitCode;
        this.transId = transId;
        this.taskAssigned = taskAssigned;
        this.expireOptSign = expireOptSign;
        this.runToken = runToken;
        this.lastUpdateUser = lastUpdateUser;
        this.lastUpdateTime = lastUpdateTime;
        this.isTimer = isTimer;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.nodeName = nodeName;
        this.roleType = roleType;
        this.roleCode = roleCode;
        this.optName = optName;
        this.methodName = methodName;
        this.optUrl = optUrl;
        this.optMethod = optMethod;
    }

    public Long getNodeInstId() {
        return this.nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    // Property accessors

    public Long getFlowInstId() {
        return this.flowInstId;
    }

    public void setFlowInstId(Long flowInstId) {
        this.flowInstId = flowInstId;
    }

    public Long getNodeId() {
        return this.nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getPrevNodeInstId() {
        return this.prevNodeInstId;
    }

    public void setPrevNodeInstId(Long prevNodeInstId) {
        this.prevNodeInstId = prevNodeInstId;
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

    public Long getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getNodeState() {
        return this.nodeState;
    }

    public void setNodeState(String nodeState) {
        this.nodeState = nodeState;
    }

    public Long getSubFlowInstId() {
        return this.subFlowInstId;
    }

    public void setSubFlowInstId(Long subFlowInstId) {
        this.subFlowInstId = subFlowInstId;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Long getTransId() {
        return this.transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public String getTaskAssigned() {
        return this.taskAssigned;
    }

    public void setTaskAssigned(String taskAssigned) {
        this.taskAssigned = taskAssigned;
    }

    public Long getExpireOptSign() {
        return this.expireOptSign;
    }

    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    public String getRunToken() {
        return this.runToken;
    }

    public void setRunToken(String runToken) {
        this.runToken = runToken;
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

    /**
     * 不计时N、计时T(有期限)、暂停P 忽略(无期限) F
     */
    public String getIsTimer() {
        return this.isTimer;
    }

    /**
     * 不计时N、计时T(有期限)、暂停P 忽略(无期限) F
     * 
     * @param isTimer
     */
    public void setIsTimer(String isTimer) {
        this.isTimer = isTimer;
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

    public Set<WfActionLog> getWfActionLogs() {
        if (this.wfActionLogs == null)
            this.wfActionLogs = new HashSet<WfActionLog>();
        return this.wfActionLogs;
    }

    public void setWfActionLogs(Set<WfActionLog> wfActionLogs) {
        this.wfActionLogs = wfActionLogs;
    }

    public void addWfActionLog(WfActionLog wfActionLog) {
        if (this.wfActionLogs == null)
            this.wfActionLogs = new HashSet<WfActionLog>();
        this.wfActionLogs.add(wfActionLog);
    }

    public void removeWfActionLog(WfActionLog wfActionLog) {
        if (this.wfActionLogs == null)
            return;
        this.wfActionLogs.remove(wfActionLog);
    }

    public WfActionLog newWfActionLog() {
        WfActionLog res = new WfActionLog();

        res.setNodeInstId(this.getNodeInstId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceWfActionLogs(List<WfActionLog> wfActionLogs) {
        List<WfActionLog> newObjs = new ArrayList<WfActionLog>();
        for (WfActionLog p : wfActionLogs) {
            if (p == null)
                continue;
            WfActionLog newdt = newWfActionLog();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<WfActionLog> oldObjs = new HashSet<WfActionLog>();
        oldObjs.addAll(getWfActionLogs());

        for (Iterator<WfActionLog> it = oldObjs.iterator(); it.hasNext();) {
            WfActionLog odt = it.next();
            found = false;
            for (WfActionLog newdt : newObjs) {
                if (odt.getActionId().equals(newdt.getActionId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeWfActionLog(odt);
        }
        oldObjs.clear();
        // insert or update
        for (WfActionLog newdt : newObjs) {
            found = false;
            for (Iterator<WfActionLog> it = getWfActionLogs().iterator(); it
                    .hasNext();) {
                WfActionLog odt = it.next();
                if (odt.getActionId().equals(newdt.getActionId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addWfActionLog(newdt);
        }
    }

    public Set<WfActionTask> getWfActionTasks() {
        if (this.wfActionTasks == null)
            this.wfActionTasks = new HashSet<WfActionTask>();
        return this.wfActionTasks;
    }

    public void setWfActionTasks(Set<WfActionTask> wfActionTasks) {
        this.wfActionTasks = wfActionTasks;
    }

    public void addWfActionTask(WfActionTask wfActionTask) {
        if (this.wfActionTasks == null)
            this.wfActionTasks = new HashSet<WfActionTask>();
        this.wfActionTasks.add(wfActionTask);
    }

    public void removeWfActionTask(WfActionTask wfActionTask) {
        if (this.wfActionTasks == null)
            return;
        this.wfActionTasks.remove(wfActionTask);
    }

    public WfActionTask newWfActionTask() {
        WfActionTask res = new WfActionTask();

        res.setNodeInstId(this.getNodeInstId());

        return res;
    }

    /**
     * 替换子类对象数组，这个函数主要是考虑hibernate中的对象的状态，以避免对象状态不一致的问题
     * 
     */
    public void replaceWfActionTasks(List<WfActionTask> wfActionTasks) {
        List<WfActionTask> newObjs = new ArrayList<WfActionTask>();
        for (WfActionTask p : wfActionTasks) {
            if (p == null)
                continue;
            WfActionTask newdt = newWfActionTask();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<WfActionTask> oldObjs = new HashSet<WfActionTask>();
        oldObjs.addAll(getWfActionTasks());

        for (Iterator<WfActionTask> it = oldObjs.iterator(); it.hasNext();) {
            WfActionTask odt = it.next();
            found = false;
            for (WfActionTask newdt : newObjs) {
                if (odt.getTaskId().equals(newdt.getTaskId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeWfActionTask(odt);
        }
        oldObjs.clear();
        // insert or update
        for (WfActionTask newdt : newObjs) {
            found = false;
            for (Iterator<WfActionTask> it = getWfActionTasks().iterator(); it
                    .hasNext();) {
                WfActionTask odt = it.next();
                if (odt.getTaskId().equals(newdt.getTaskId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addWfActionTask(newdt);
        }
    }

    public void copy(VNodeInstDetail other) {

        this.setNodeInstId(other.getNodeInstId());

        this.flowInstId = other.getFlowInstId();
        this.nodeId = other.getNodeId();
        this.createTime = other.getCreateTime();
        this.prevNodeInstId = other.getPrevNodeInstId();
        this.timeLimit = other.getTimeLimit();
        this.nodeState = other.getNodeState();
        this.subFlowInstId = other.getSubFlowInstId();
        this.unitCode = other.getUnitCode();
        this.transId = other.getTransId();
        this.taskAssigned = other.getTaskAssigned();
        this.expireOptSign = other.getExpireOptSign();
        this.runToken = other.getRunToken();
        this.lastUpdateUser = other.getLastUpdateUser();
        this.lastUpdateTime = other.getLastUpdateTime();
        this.isTimer = other.getIsTimer();
        this.flowOptName = other.getFlowOptName();
        this.flowOptTag = other.getFlowOptTag();
        this.nodeName = other.getNodeName();
        this.roleType = other.getRoleType();
        this.roleCode = other.getRoleCode();
        this.optName = other.getOptName();
        this.methodName = other.getMethodName();
        this.optUrl = other.getOptUrl();
        this.optMethod = other.getOptMethod();

        this.wfActionLogs = other.getWfActionLogs();
        this.wfActionTasks = other.getWfActionTasks();
    }

    public void copyNotNullProperty(VNodeInstDetail other) {

        if (other.getNodeInstId() != null)
            this.setNodeInstId(other.getNodeInstId());

        if (other.getFlowInstId() != null)
            this.flowInstId = other.getFlowInstId();
        if (other.getNodeId() != null)
            this.nodeId = other.getNodeId();
        if (other.getCreateTime() != null)
            this.createTime = other.getCreateTime();
        if (other.getPrevNodeInstId() != null)
            this.prevNodeInstId = other.getPrevNodeInstId();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getNodeState() != null)
            this.nodeState = other.getNodeState();
        if (other.getSubFlowInstId() != null)
            this.subFlowInstId = other.getSubFlowInstId();
        if (other.getUnitCode() != null)
            this.unitCode = other.getUnitCode();
        if (other.getTransId() != null)
            this.transId = other.getTransId();
        if (other.getTaskAssigned() != null)
            this.taskAssigned = other.getTaskAssigned();
        if (other.getExpireOptSign() != null)
            this.expireOptSign = other.getExpireOptSign();
        if (other.getRunToken() != null)
            this.runToken = other.getRunToken();
        if (other.getLastUpdateUser() != null)
            this.lastUpdateUser = other.getLastUpdateUser();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
        if (other.getIsTimer() != null)
            this.isTimer = other.getIsTimer();
        if (other.getFlowOptName() != null)
            this.flowOptName = other.getFlowOptName();
        if (other.getFlowOptTag() != null)
            this.flowOptTag = other.getFlowOptTag();
        if (other.getNodeName() != null)
            this.nodeName = other.getNodeName();
        if (other.getRoleType() != null)
            this.roleType = other.getRoleType();
        if (other.getRoleCode() != null)
            this.roleCode = other.getRoleCode();
        if (other.getOptName() != null)
            this.optName = other.getOptName();
        if (other.getMethodName() != null)
            this.methodName = other.getMethodName();
        if (other.getOptUrl() != null)
            this.optUrl = other.getOptUrl();
        if (other.getOptMethod() != null)
            this.optMethod = other.getOptMethod();

        this.wfActionLogs = other.getWfActionLogs();
        this.wfActionTasks = other.getWfActionTasks();
    }

    public void clearProperties() {

        this.flowInstId = null;
        this.nodeId = null;
        this.createTime = null;
        this.prevNodeInstId = null;
        this.timeLimit = null;
        this.nodeState = null;
        this.subFlowInstId = null;
        this.unitCode = null;
        this.transId = null;
        this.taskAssigned = null;
        this.expireOptSign = null;
        this.runToken = null;
        this.lastUpdateUser = null;
        this.lastUpdateTime = null;
        this.isTimer = null;
        this.flowOptName = null;
        this.flowOptTag = null;
        this.nodeName = null;
        this.roleType = null;
        this.roleCode = null;
        this.optName = null;
        this.methodName = null;
        this.optUrl = null;
        this.optMethod = null;

        this.wfActionLogs = new HashSet<WfActionLog>();
        this.wfActionTasks = new HashSet<WfActionTask>();
    }

    public String getIsRecycle() {
        return isRecycle;
    }

    public void setIsRecycle(String isRecycle) {
        this.isRecycle = isRecycle;
    }

    public boolean isTaskAssign() {

        return "T".equals(taskAssigned);
    }

    public String getNodeOptUrl() {
        if (optUrl == null) {
            return null;
        }

        OptDesc optDesc = Struts2UrlParser.parseUrl(optUrl);
        optDesc.setMethod(optMethod);
        String url = optDesc.getOptUrl() + "?nodeInstId=" + nodeInstId
                + "&flowInstId=" + flowInstId;
        if (optParam != null && !"".equals(optParam))
            url = url + "&optParam=" + optParam;
        try {
            url = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getOptParam() {
        return optParam;
    }

    public void setOptParam(String optParam) {
        this.optParam = optParam;
    }

    @Override
    public List<String> getTrainsUsers() {
        
        return null;
    }
}

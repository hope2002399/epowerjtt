package com.centit.workflow.sample.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.core.utils.WorkTimeSpan;
import com.centit.workflow.NodeInstance;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfNodeInstance implements java.io.Serializable, NodeInstance {
    private static final long serialVersionUID = 1L;

    private Long nodeinstid;

    private Long wfinstid;
    private Long nodeid;
    private Date createtime;
    private Date lastUpdateTime;
    private Long prevnodeinstid;
    private Long promiseTime;
    private Long timeLimit;
    /**
     * N 正常/ R 运行(保留)/ C 完成/ S 挂起 / X 超时挂起eXpire / D 强制提交 /B 已回退 /E 因为流程完成而结束 /
     * F 被强制结束 / W 等待子流程返回 / I 无效
     */
    private String nodeState;
    private Long subwfinstid;
    private String unitcode;
    private Long transid;
    private String taskassigned;
    private Long expireOptSign;
    private String runToken;
    private String lastUpdateUser;
    private String isTimer;// 不计时N、计时Y、暂停P
    private Set<WfActionLog> wfActionLogs = null;// new
                                                 // ArrayList<WfActionLog>();
    private Set<WfActionTask> wfActionTasks = null;// new
                                                   // ArrayList<WfActionTask>();

    // 非持久化属性
    private String nodeName;
    private String flowOptName;
    private String flowOptTag;
    private String roleType;
    private String roleCode;
    private String isRecycle;// yes:可以回收；no：不可以回收
    private List<String> trainsUsers;

    // Constructors
    /** default constructor */
    public WfNodeInstance() {
        this.expireOptSign = 0L;
        this.timeLimit = null;
        this.taskassigned = "F";
    }

    /** minimal constructor */
    public WfNodeInstance(Long nodeinstid) {
        this.timeLimit = null;
        this.expireOptSign = 0L;
        this.nodeinstid = nodeinstid;
        this.taskassigned = "F";
    }

    /** full constructor */
    public WfNodeInstance(Long nodeinstid, Long wfinstid, Long nodeid,
            Date createtime, Date starttime, Long prevnodeinstid,
            Long promiseTime, Long timeLimit, String nodestate,
            Long subwfinstid, String unitcode, Long transid,
            String taskassigned, Long expireOptSign, String runToken,
            String lastUpdateUser, String isTimer) {

        this.nodeinstid = nodeinstid;

        this.wfinstid = wfinstid;
        this.nodeid = nodeid;
        this.createtime = createtime;
        this.lastUpdateTime = starttime;
        this.prevnodeinstid = prevnodeinstid;
        this.promiseTime = promiseTime;
        this.timeLimit = timeLimit;
        this.nodeState = nodestate;
        this.subwfinstid = subwfinstid;
        this.unitcode = unitcode;
        this.transid = transid;
        this.taskassigned = taskassigned;
        this.expireOptSign = expireOptSign;
        this.setRunToken(runToken);
        this.lastUpdateUser = lastUpdateUser;
        this.isTimer = isTimer;
    }

    public Long getNodeInstId() {
        return this.nodeinstid;
    }

    public void setNodeInstId(Long nodeinstid) {
        this.nodeinstid = nodeinstid;
    }

    // Property accessors

    public Long getFlowInstId() {
        return this.wfinstid;
    }

    public void setFlowInstId(Long wfinstid) {
        this.wfinstid = wfinstid;
    }

    public Long getNodeId() {
        return this.nodeid;
    }

    public void setNodeId(Long nodeid) {
        this.nodeid = nodeid;
    }

    public Date getCreateTime() {
        return this.createtime;
    }

    public void setCreateTime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date starttime) {
        this.lastUpdateTime = starttime;
    }

    public Long getPrevNodeInstId() {
        return this.prevnodeinstid;
    }

    public void setPrevNodeInstId(Long prevnodeinstid) {
        this.prevnodeinstid = prevnodeinstid;
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
        return timeLimit;
    }

    public void setTimeLimit(Long timeLimit) {
        this.timeLimit = timeLimit;
    }

    /**
     * N 正常/ R 运行(保留)/ C 完成/ S 挂起 / X 超时挂起eXpire / D 强制提交 /B 已回退 /E 因为流程完成而结束 /
     * F 被强制结束 / W 等待子流程返回 / I 无效
     */
    public String getNodeState() {
        return this.nodeState;
    }

    /**
     * N 正常/ R 运行(保留)/ C 完成/ S 挂起 / X 超时挂起eXpire / D 强制提交 /B 已回退 /E 因为流程完成而结束 /
     * F 被强制结束 / W 等待子流程返回 / I 无效
     */
    public void setNodeState(String nodestate) {
        this.nodeState = nodestate;
    }

    public Long getSubFlowInstId() {
        return this.subwfinstid;
    }

    public void setSubFlowInstId(Long subwfinstid) {
        this.subwfinstid = subwfinstid;
    }

    public String getUnitCode() {
        return this.unitcode;
    }

    public void setUnitCode(String unitcode) {
        this.unitcode = unitcode;
    }

    public Long getTransId() {
        return this.transid;
    }

    public void setTransId(Long transid) {
        this.transid = transid;
    }

    public boolean isTaskAssign() {

        return "T".equals(taskassigned);
    }

    /**
     * T 已分配 F 未分配
     * 
     * @return
     */
    public String getTaskAssigned() {
        return this.taskassigned;
    }

    public void setTaskAssigned(String taskassigned) {
        this.taskassigned = taskassigned;
    }

    /**
     * expireOptSign == 0未处理 1 已通知 ,2..6 已通知2..5次（暂时不启动重复通知）6:不处理 7：已挂起 8 已终止 9
     * 已完成
     * 
     * @return
     */
    public Long getExpireOptSign() {
        return expireOptSign;
    }

    /**
     * expireOptSign == 0未处理 1 已通知 ,2..6 已通知2..5次（暂时不启动重复通知）6:不处理 7：已挂起 8 已终止 9
     * 已完成
     */
    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    public String getRunToken() {
        return runToken;
    }

    public void setRunToken(String runToken) {
        this.runToken = runToken;
    }

    public Set<WfActionLog> getWfActionLogs() {
        if (this.wfActionLogs == null)
            this.wfActionLogs = new HashSet<WfActionLog>();
        return this.wfActionLogs;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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
        // insert
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
        // insert
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

    public void copy(WfNodeInstance other) {

        this.setNodeInstId(other.getNodeInstId());

        this.wfinstid = other.getFlowInstId();
        this.nodeid = other.getNodeId();
        this.createtime = other.getCreateTime();
        this.lastUpdateTime = other.getLastUpdateTime();
        this.prevnodeinstid = other.getPrevNodeInstId();
        this.nodeState = other.getNodeState();
        this.subwfinstid = other.getSubFlowInstId();
        this.unitcode = other.getUnitCode();
        this.transid = other.getTransId();
        this.taskassigned = other.getTaskAssigned();
        this.expireOptSign = other.getExpireOptSign();
        this.timeLimit = other.getTimeLimit();
        this.runToken = other.getRunToken();
        this.lastUpdateUser = other.getLastUpdateUser();
        this.isTimer = other.getIsTimer();

    }

    public void copyNotNullProperty(WfNodeInstance other) {

        if (other.getNodeInstId() != null)
            this.setNodeInstId(other.getNodeInstId());

        if (other.getFlowInstId() != null)
            this.wfinstid = other.getFlowInstId();
        if (other.getNodeId() != null)
            this.nodeid = other.getNodeId();
        if (other.getCreateTime() != null)
            this.createtime = other.getCreateTime();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
        if (other.getPrevNodeInstId() != null)
            this.prevnodeinstid = other.getPrevNodeInstId();
        if (other.getNodeState() != null)
            this.nodeState = other.getNodeState();
        if (other.getSubFlowInstId() != null)
            this.subwfinstid = other.getSubFlowInstId();
        if (other.getUnitCode() != null)
            this.unitcode = other.getUnitCode();
        if (other.getTransId() != null)
            this.transid = other.getTransId();
        if (other.getTaskAssigned() != null)
            this.taskassigned = other.getTaskAssigned();
        if (other.getExpireOptSign() != null)
            this.expireOptSign = other.getExpireOptSign();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getRunToken() != null)
            this.runToken = other.getRunToken();
        if (other.getLastUpdateUser() != null)
            this.lastUpdateUser = other.getLastUpdateUser();
        if (other.getIsTimer() != null)
            this.isTimer = other.getIsTimer();
    }

    public void clearProperties() {
        // this.wfinstid= null;
        this.nodeid = null;
        this.createtime = null;
        this.lastUpdateTime = null;
        this.prevnodeinstid = null;
        this.nodeState = null;
        this.subwfinstid = null;
        this.unitcode = null;
        this.transid = null;
        this.taskassigned = "F";
        this.expireOptSign = 0L;
        this.timeLimit = null;
        this.runToken = null;
        this.isTimer = null;
    }

    public String getFlowOptName() {
        return flowOptName;
    }

    public void setFlowOptName(String flowOptName) {
        this.flowOptName = flowOptName;
    }

    public String getFlowOptTag() {
        return flowOptTag;
    }

    public void setFlowOptTag(String flowOptTag) {
        this.flowOptTag = flowOptTag;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 不计时N、计时T 、暂停 P
     */
    public String getIsTimer() {
        return isTimer;
    }

    /**
     * 不计时N、计时T 、暂停 P
     */
    public void setIsTimer(String isTimer) {
        this.isTimer = isTimer;
    }

    public String getIsRecycle() {
        return isRecycle;
    }

    public void setIsRecycle(String isRecycle) {
        this.isRecycle = isRecycle;
    }

    @Override
    public String getNodeOptUrl() {

        return null;
    }

    public List<String> getTrainsUsers() {
        return trainsUsers;
    }

    public void setTrainsUsers(List<String> trainsUsers) {
        this.trainsUsers = trainsUsers;
    }

}

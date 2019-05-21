package com.centit.workflow.sample.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.centit.core.utils.WorkTimeSpan;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.StageInstance;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public class WfFlowInstance implements java.io.Serializable, FlowInstance {
    private static final long serialVersionUID = 1L;

    private Long wfinstid;
    private Long version;
    private String wfcode;
    private String flowOptName;
    private String flowOptTag;
    private Date createtime;
    private Long promiseTime;
    private Long timeLimit;
    /**
     * 流程状态 N 正常/ R 运行(保留)/ C 完成/ S 挂起/ F 强行结束 / X 超时挂起expire /I 失效
     */
    private String inststate;
    private String issubinst;
    private Long preinstid;
    private Long prenodeinstid;
    private String unitcode;
    private String usercode;
    private Long expireOptSign;
    private Date lastUpdateTime;
    private String lastUpdateUser;
    private String isTimer; // 不计时N、计时T(有期限)、暂停P 忽略(无期限) F
    private Set<WfNodeInstance> wfNodeInstances = null;// new
                                                       // ArrayList<WfNodeInstance>();
    private List<WfNodeInstance> activeNodeList;
    private Set<WfStageInstance> wfStageInstances = null;// new
                                                         // ArrayList<WfNodeInstance>();
    private String optName;
    private String flowName;

    private String curStep;

    // Constructors
    /** default constructor */
    public WfFlowInstance() {
        this.expireOptSign = 0L;
        this.timeLimit = null;
    }

    /** minimal constructor */
    public WfFlowInstance(Long wfinstid, Date createtime) {
        this.timeLimit = null;
        this.wfinstid = wfinstid;

        this.createtime = createtime;
        this.expireOptSign = 0L;
    }

    /** full constructor */
    public WfFlowInstance(Long wfinstid, Long version, String wfcode,
            String flowOptName, String flowOptTag, Date createtime,
            Long promiseTime, Long timeLimit, String inststate,
            String issubinst, Long preinstid, Long prenodeinstid,
            String unitcode, String usercode, Long expireOptSign,
            Date lastUpdateTime, String lastUpdateUser, String isTimer) {

        this.wfinstid = wfinstid;

        this.version = version;
        this.wfcode = wfcode;
        this.flowOptName = flowOptName;
        this.flowOptTag = flowOptTag;
        this.createtime = createtime;
        this.promiseTime = promiseTime;
        this.timeLimit = timeLimit;
        this.inststate = inststate;
        this.issubinst = issubinst;
        this.preinstid = preinstid;
        this.prenodeinstid = prenodeinstid;
        this.unitcode = unitcode;
        this.usercode = usercode;
        this.expireOptSign = expireOptSign;
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateUser = lastUpdateUser;
        this.isTimer = isTimer;
    }

    public Long getFlowInstId() {
        return this.wfinstid;
    }

    public void setFlowInstId(Long wfinstid) {
        this.wfinstid = wfinstid;
    }

    // Property accessors

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFlowCode() {
        return this.wfcode;
    }

    public void setFlowCode(String wfcode) {
        this.wfcode = wfcode;
    }

    public String getFlowOptName() {
        return flowOptName;
    }

    public void setFlowOptName(String flowOptName) {
        this.flowOptName = flowOptName;
    }

    public Date getCreateTime() {
        return this.createtime;
    }

    public void setCreateTime(Date createtime) {
        this.createtime = createtime;
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
     * 流程状态 N 正常/ R 运行(保留)/ C 完成/ S 挂起/ F 强行结束 / X 超时挂起expire /I 失效
     */
    public String getInstState() {
        return this.inststate;
    }

    /**
     * @param inststate
     *            流程状态 N 正常/ R 运行(保留)/ C 完成/ S 挂起/ F 强行结束 / X 超时挂起expire /I 失效
     */
    public void setInstState(String inststate) {
        this.inststate = inststate;
    }

    @Override
    public boolean isSubFlow() {

        return "Y".equals(issubinst);
    }

    /**
     * Y 子流程/ N 非子流程
     */
    public String getIsSubInst() {
        return this.issubinst;
    }

    /**
     * 
     * @param issubinst
     *            Y 子流程/ N 非子流程
     */
    public void setIsSubInst(String issubinst) {
        this.issubinst = issubinst;
    }

    public Long getPreInstId() {
        return this.preinstid;
    }

    public void setPreInstId(Long preinstid) {
        this.preinstid = preinstid;
    }

    public Long getPreNodeInstId() {
        return this.prenodeinstid;
    }

    public void setPreNodeInstId(Long prenodeinstid) {
        this.prenodeinstid = prenodeinstid;
    }

    public String getUnitCode() {
        return this.unitcode;
    }

    public void setUnitCode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getUserCode() {
        return this.usercode;
    }

    public void setUserCode(String usercode) {
        this.usercode = usercode;
    }

    public void getOptName(String on) {

        optName = on;
    }

    @Override
    public String getOptName() {

        return optName;
    }

    public String getFlowOptTag() {
        return flowOptTag;
    }

    public void setFlowOptTag(String flowOptTag) {
        this.flowOptTag = flowOptTag;
    }

    /**
     * expireOptSign == 0未处理 1 已通知 ,2..5 已通知2..5次（暂时不启动重复通知） 6:不处理 7：已挂起 8 已终止 9
     * 已完成
     * 
     * @return
     */
    public Long getExpireOptSign() {
        return expireOptSign;
    }

    /**
     * expireOptSign == 0未处理 1 已通知 ,2..5 已通知2..5次（暂时不启动重复通知）6:不处理 7：已挂起 8 已终止 9
     * 已完成
     * 
     * @param expireOptSign
     */
    public void setExpireOptSign(Long expireOptSign) {
        this.expireOptSign = expireOptSign;
    }

    @Override
    public Set<NodeInstance> getActiveNodeInstances() {
        Set<NodeInstance> nodeInstSet = new HashSet<NodeInstance>();
        if (this.wfNodeInstances == null)
            return nodeInstSet;
        for (WfNodeInstance nodeInst : wfNodeInstances)
            if ("N".equals(nodeInst.getNodeState())
                    || "R".equals(nodeInst.getNodeState())
                    || "W".equals(nodeInst.getNodeState()))
                nodeInstSet.add(nodeInst);
        return nodeInstSet;
    }

    @Override
    public List<NodeInstance> getNodeInstances() {
        return new ArrayList<NodeInstance>(wfNodeInstances);
    }

    public Set<WfNodeInstance> getWfNodeInstances() {
        if (this.wfNodeInstances == null)
            this.wfNodeInstances = new HashSet<WfNodeInstance>();
        return this.wfNodeInstances;
    }

    public void setWfNodeInstances(Set<WfNodeInstance> wfNodeInstances) {
        this.wfNodeInstances = wfNodeInstances;
    }

    public void addWfNodeInstance(WfNodeInstance wfNodeInstance) {
        if (this.wfNodeInstances == null)
            this.wfNodeInstances = new HashSet<WfNodeInstance>();
        this.wfNodeInstances.add(wfNodeInstance);
    }

    public void removeWfNodeInstance(WfNodeInstance wfNodeInstance) {
        if (this.wfNodeInstances == null)
            return;
        this.wfNodeInstances.remove(wfNodeInstance);
    }

    public WfNodeInstance newWfNodeInstance() {
        WfNodeInstance res = new WfNodeInstance();

        res.setFlowInstId(this.getFlowInstId());

        return res;
    }

    public WfNodeInstance getNodeInstanceById(long nodeInstId) {
        if (this.wfNodeInstances == null)
            return null;

        for (WfNodeInstance nodeInst : wfNodeInstances)
            if (nodeInst.getNodeInstId().equals(nodeInstId))
                return nodeInst;

        return null;
    }

    public Set<WfStageInstance> getWfStageInstances() {
        if (this.wfStageInstances == null)
            this.wfStageInstances = new HashSet<WfStageInstance>();
        return this.wfStageInstances;
    }

    @Override
    public List<StageInstance> getStageInstanceList() {
        List<StageInstance> stageList = new ArrayList<StageInstance>();
        stageList.addAll(getWfStageInstances());
        return stageList;
    }

    @Override
    public List<StageInstance> getExpiredStageInstanceList() {
        List<StageInstance> stageList = new ArrayList<StageInstance>();
        for (WfStageInstance stage : getWfStageInstances()) {
            if (stage.getTimeLimit() < 0)
                stageList.add(stage);
        }
        return stageList;
    }

    public void setWfStageInstances(Set<WfStageInstance> wfStageInstances) {
        this.wfStageInstances = wfStageInstances;
    }

    public void addWfStageInstance(WfStageInstance wfStageInstance) {
        if (this.wfStageInstances == null)
            this.wfStageInstances = new HashSet<WfStageInstance>();
        this.wfStageInstances.add(wfStageInstance);
    }

    public void removeWfStageInstance(WfStageInstance wfStageInstance) {
        if (this.wfStageInstances == null)
            return;
        this.wfStageInstances.remove(wfStageInstance);
    }

    public WfStageInstance newWfStageInstance() {

        WfStageInstance res = new WfStageInstance();
        res.setFlowInstId(this.getFlowInstId());
        res.setExpireOptSign(0L);
        return res;
    }

    public WfStageInstance getStageInstanceByCode(long stageCode) {
        if (this.wfStageInstances == null)
            return null;

        for (WfStageInstance stageInst : this.wfStageInstances)
            if (stageInst.getStageCode().equals(stageCode))
                return stageInst;
        return null;
    }

    @Override
    public WfNodeInstance getFirstNodeInstance() {
        if (this.wfNodeInstances == null)
            return null;
        WfNodeInstance firstNode = null;
        for (WfNodeInstance nodeInst : wfNodeInstances)
            if (firstNode == null
                    || firstNode.getNodeInstId() > nodeInst.getNodeInstId())
                firstNode = nodeInst;

        return firstNode;
    }

    @Override
    public List<NodeInstance> getSameLevelNodeInstances(long nodeInstId) {
        WfNodeInstance nodeInst = this.getNodeInstanceById(nodeInstId);
        if (nodeInst == null)
            return null;
        List<NodeInstance> nodes = new ArrayList<NodeInstance>();
        String thisToken = nodeInst.getRunToken();
        while (true) {
            if (thisToken == null || thisToken.equals(nodeInst.getRunToken()))
                nodes.add(nodeInst);
            nodeInst = getNodeInstanceById(nodeInst.getPrevNodeInstId());
            if (nodeInst == null)
                break;
        }
        return nodes;
    }

    @Override
    public List<NodeInstance> getRunTraceNodeInstances(long nodeInstId) {
        WfNodeInstance nodeInst = this.getNodeInstanceById(nodeInstId);
        if (nodeInst == null)
            return null;
        List<NodeInstance> nodes = new ArrayList<NodeInstance>();
        // String thisToken = nodeInst.getRunToken();
        while (true) {
            // if(thisToken==null || thisToken.equals(nodeInst.getRunToken()))
            nodes.add(nodeInst);
            nodeInst = getNodeInstanceById(nodeInst.getPrevNodeInstId());
            if (nodeInst == null)
                break;
        }
        return nodes;
    }

    public String getNearestNodeUnitCode(WfNodeInstance nodeInst) {
        WfNodeInstance curNode = nodeInst;
        String thisToken = curNode.getRunToken();

        while (curNode != null) {
            if (curNode.getUnitCode() != null
                    && !"".equals(curNode.getUnitCode())) {
                String prevToken = curNode.getRunToken();
                if (thisToken == null || prevToken == null
                        || thisToken.equals(prevToken)
                        || thisToken.startsWith(prevToken + '.'))
                    return curNode.getUnitCode();
            } else if (curNode.getPrevNodeInstId() == null)
                return null;

            curNode = this.getNodeInstanceById(curNode.getPrevNodeInstId());
        }
        return null;
    }

    public List<NodeInstance> findSameNodeInsts(NodeInstance nodeInst) {
        List<NodeInstance> sameNodes = new ArrayList<NodeInstance>();
        if (this.wfNodeInstances == null)
            return sameNodes;
        Long nodeId = nodeInst.getNodeId();
        Long thisNodeInstId = nodeInst.getNodeInstId();
        String runToken = null;
        if (nodeInst != null)
            runToken = nodeInst.getRunToken();
        for (WfNodeInstance ni : wfNodeInstances)
            if (ni.getNodeId().equals(nodeId)
                    && !ni.getNodeInstId().equals(thisNodeInstId)
                    && (runToken == null || ni.getRunToken() == null
                            || runToken.equals(ni.getRunToken())
                            || runToken.startsWith(ni.getRunToken() + ".") || ni
                            .getRunToken().startsWith(runToken + ".")))
                sameNodes.add(nodeInst);

        return sameNodes;
    }

    /**
     * 查找在同一条运行路径上的相同节点
     */
    public WfNodeInstance findLastSameNodeInst(Long nodeId,
            NodeInstance nodeInst, Long thisNodeInstId) {
        if (this.wfNodeInstances == null)
            return null;

        WfNodeInstance sameInst = null;
        String runToken = null;
        if (nodeInst != null)
            runToken = nodeInst.getRunToken();
        for (WfNodeInstance ni : wfNodeInstances)
            if (ni.getNodeId().equals(nodeId)
                    && !ni.getNodeInstId().equals(thisNodeInstId)
                    && (runToken == null || ni.getRunToken() == null
                            || runToken.equals(ni.getRunToken())
                            || runToken.startsWith(ni.getRunToken() + ".") || ni
                            .getRunToken().startsWith(runToken + "."))) {

                if (sameInst == null
                        || ni.getNodeInstId() > sameInst.getNodeInstId())
                    sameInst = ni;
            }
        return sameInst;
    }

    public Set<WfNodeInstance> findSubNodeInstByToken(String token) {
        Set<WfNodeInstance> sameNodes = new HashSet<WfNodeInstance>();
        if (this.wfNodeInstances == null)
            return sameNodes;
        for (WfNodeInstance nodeInst : wfNodeInstances) {
            String thisToken = nodeInst.getRunToken();
            if (thisToken != null && thisToken.startsWith(token + '.'))
                sameNodes.add(nodeInst);
        }
        return sameNodes;
    }

    public WfNodeInstance getPrevNodeInst(long thisNodeInstId) {
        WfNodeInstance nodeInst = getNodeInstanceById(thisNodeInstId);
        if (nodeInst == null)
            return null;
        String thisToken = nodeInst.getRunToken();
        while (true) {
            WfNodeInstance prevNodeInst = getNodeInstanceById(nodeInst
                    .getPrevNodeInstId());
            if (prevNodeInst == null)
                return null;

            String prevToken = prevNodeInst.getRunToken();
            if ((thisToken == null || prevToken == null)
                    || thisToken.equals(prevToken)
                    || thisToken.startsWith(prevToken + '.'))

                return prevNodeInst;

            nodeInst = prevNodeInst;
        }
    }

    public void replaceWfNodeInstances(List<WfNodeInstance> wfNodeInstances) {
        List<WfNodeInstance> newObjs = new ArrayList<WfNodeInstance>();
        for (WfNodeInstance p : wfNodeInstances) {
            if (p == null)
                continue;
            WfNodeInstance newdt = newWfNodeInstance();
            newdt.copyNotNullProperty(p);
            newObjs.add(newdt);
        }
        // delete
        boolean found = false;
        Set<WfNodeInstance> oldObjs = new HashSet<WfNodeInstance>();
        oldObjs.addAll(getWfNodeInstances());

        for (Iterator<WfNodeInstance> it = oldObjs.iterator(); it.hasNext();) {
            WfNodeInstance odt = it.next();
            found = false;
            for (WfNodeInstance newdt : newObjs) {
                if (odt.getNodeInstId().equals(newdt.getNodeInstId())) {
                    found = true;
                    break;
                }
            }
            if (!found)
                removeWfNodeInstance(odt);
        }
        oldObjs.clear();
        // insert
        for (WfNodeInstance newdt : newObjs) {
            found = false;
            for (Iterator<WfNodeInstance> it = getWfNodeInstances().iterator(); it
                    .hasNext();) {
                WfNodeInstance odt = it.next();
                if (odt.getNodeInstId().equals(newdt.getNodeInstId())) {
                    odt.copy(newdt);
                    found = true;
                    break;
                }
            }
            if (!found)
                addWfNodeInstance(newdt);
        }
    }

    public void copy(WfFlowInstance other) {

        this.setFlowInstId(other.getFlowInstId());

        this.version = other.getVersion();
        this.wfcode = other.getFlowCode();
        this.flowOptName = other.getFlowOptName();
        this.flowOptTag = other.getFlowOptTag();
        this.createtime = other.getCreateTime();
        this.inststate = other.getInstState();
        this.issubinst = other.getIsSubInst();
        this.preinstid = other.getPreInstId();
        this.prenodeinstid = other.getPreNodeInstId();
        this.unitcode = other.getUnitCode();
        this.usercode = other.getUserCode();
        this.expireOptSign = other.getExpireOptSign();
        this.promiseTime = other.getPromiseTime();
        this.timeLimit = other.getTimeLimit();
        this.wfNodeInstances = other.getWfNodeInstances();
        this.wfStageInstances = other.getWfStageInstances();
        this.lastUpdateTime = other.getLastUpdateTime();
        this.lastUpdateUser = other.getLastUpdateUser();
        this.isTimer = other.getIsTimer();
    }

    public void copyNotNullProperty(WfFlowInstance other) {

        if (other.getFlowInstId() != null)
            this.setFlowInstId(other.getFlowInstId());

        if (other.getVersion() != null)
            this.version = other.getVersion();
        if (other.getFlowCode() != null)
            this.wfcode = other.getFlowCode();
        if (other.getFlowOptName() != null)
            this.flowOptName = other.getFlowOptName();
        if (other.getFlowOptTag() != null)
            this.flowOptTag = other.getFlowOptTag();

        if (other.getCreateTime() != null)
            this.createtime = other.getCreateTime();
        if (other.getInstState() != null)
            this.inststate = other.getInstState();
        if (other.getIsSubInst() != null)
            this.issubinst = other.getIsSubInst();
        if (other.getPreInstId() != null)
            this.preinstid = other.getPreInstId();
        if (other.getPreNodeInstId() != null)
            this.prenodeinstid = other.getPreNodeInstId();
        if (other.getUnitCode() != null)
            this.unitcode = other.getUnitCode();
        if (other.getUserCode() != null)
            this.usercode = other.getUserCode();
        if (other.getExpireOptSign() != null)
            this.expireOptSign = other.getExpireOptSign();
        if (other.getPromiseTime() != null)
            this.promiseTime = other.getPromiseTime();
        if (other.getTimeLimit() != null)
            this.timeLimit = other.getTimeLimit();
        if (other.getLastUpdateTime() != null)
            this.lastUpdateTime = other.getLastUpdateTime();
        if (other.getLastUpdateUser() != null)
            this.lastUpdateUser = other.getLastUpdateUser();
        if (other.getIsTimer() != null)
            this.isTimer = other.getIsTimer();
        // this.wfNodeInstances = other.getWfNodeInstances();
        // this.wfStageInstances = other.getWfStageInstances();

    }

    public void clearProperties() {
        // this.wfinstid= null;
        this.version = null;
        this.wfcode = null;
        this.flowOptName = null;
        this.flowOptTag = null;
        this.createtime = null;
        this.inststate = null;
        this.issubinst = null;
        this.preinstid = null;
        this.prenodeinstid = null;
        this.unitcode = null;
        this.usercode = null;
        this.expireOptSign = 0L;
        this.timeLimit = null;
        this.promiseTime = null;
        this.wfNodeInstances = null;
        this.wfStageInstances = null;
        this.lastUpdateTime = null;
        this.lastUpdateUser = null;
        this.isTimer = null;
    }

    @Override
    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
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

    /**
     * 不计时N、计时T(有期限)、暂停P
     */
    public String getIsTimer() {
        return isTimer;
    }

    /**
     * 不计时N、计时T(有期限)、暂停P
     * 
     * @param isTimer
     */
    public void setIsTimer(String isTimer) {
        this.isTimer = isTimer;
    }

    public List<NodeInstance> getActiveNodeList() {
        return new ArrayList<NodeInstance>(activeNodeList);
    }

    public void setActiveNodeList(List<WfNodeInstance> activeNodeList) {
        this.activeNodeList = activeNodeList;
    }

    public String getCurStep() {
        return curStep;
    }

    public void setCurStep(String curStep) {
        this.curStep = curStep;
    }

}

package com.centit.workflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.centit.core.utils.PageDesc;
import com.centit.core.utils.WorkTimeSpan;
import com.centit.support.utils.DatetimeOpt;
import com.centit.workflow.ActionLog;
import com.centit.workflow.ActionTask;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.FlowManager;
import com.centit.workflow.ManageActionLog;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.UserTask;
import com.centit.workflow.sample.dao.VNodeInstDetailDao;
import com.centit.workflow.sample.dao.VUserTasksDao;
import com.centit.workflow.sample.dao.WfActionLogDao;
import com.centit.workflow.sample.dao.WfActionTaskDao;
import com.centit.workflow.sample.dao.WfFlowDefineDao;
import com.centit.workflow.sample.dao.WfFlowInstanceDao;
import com.centit.workflow.sample.dao.WfManageActionDao;
import com.centit.workflow.sample.dao.WfNodeDao;
import com.centit.workflow.sample.dao.WfNodeInstanceDao;
import com.centit.workflow.sample.dao.WfTaskMoveDao;
import com.centit.workflow.sample.dao.WfTeamDao;
import com.centit.workflow.sample.dao.WfTransitionDao;
import com.centit.workflow.sample.po.VNodeInstDetail;
import com.centit.workflow.sample.po.VUserTaskList;
import com.centit.workflow.sample.po.WfActionLog;
import com.centit.workflow.sample.po.WfActionTask;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowDefineId;
import com.centit.workflow.sample.po.WfFlowInstance;
import com.centit.workflow.sample.po.WfManageAction;
import com.centit.workflow.sample.po.WfNode;
import com.centit.workflow.sample.po.WfNodeInstance;
import com.centit.workflow.sample.po.WfTaskMove;
import com.centit.workflow.sample.po.WfTeam;
import com.centit.workflow.sample.po.WfTransition;

/**
 * 
 * 流程管理业务实现类
 * 
 * @author ljy
 * @version $Rev$ <br>
 *          $Id$
 */
public class SampleFlowManager implements FlowManager, Serializable {
    private static final long serialVersionUID = 1L;
    WfFlowInstanceDao flowInstanceDao;
    WfNodeInstanceDao nodeInstanceDao;
    WfNodeDao flowNodeDao;
    WfTransitionDao flowTransitionDao;
    WfManageActionDao manageActionDao;
    WfActionTaskDao actionTaskDao;
    WfActionLogDao actionLogDao;
    WfFlowDefineDao flowDefDao;
    VNodeInstDetailDao vNodeInstDetailDao;
    private WfTeamDao flowTeamDao;
    private WfTaskMoveDao flowTaskMoveDao;
    private VUserTasksDao vUserTasksDao;

    public String viewFlowInstance(long flowInstId) {
        WfFlowInstance wfInst = flowInstanceDao.getObjectById(flowInstId);
        WfFlowDefine wfDef = flowDefDao.getObjectById(new WfFlowDefineId(wfInst
                .getVersion(), wfInst.getFlowCode()));

        Document viewDoc = DocumentHelper.createDocument();
        Element baseEle = viewDoc.addElement("TopFlow");
        Element procsEle = baseEle.addElement("Procs");
        Element stepsEle = baseEle.addElement("Steps");

        Set<WfNodeInstance> nodeInstSet = wfInst.getWfNodeInstances();
        Set<WfNode> nodeSet = wfDef.getWfNodes();
        Set<WfTransition> transSet = wfDef.getWfTransitions();
        Iterator<WfNode> nodesIter = nodeSet.iterator();
        Iterator<WfTransition> transIter = transSet.iterator();

        long benginNodeId = -1;
        // Map<Long,String> compNodeMap = new HashMap<Long,String>();
        // 节点迭代
        while (nodesIter.hasNext()) {
            WfNode wfNodes = nodesIter.next();
            Element procEle = procsEle.addElement("Proc");
            procEle.addAttribute("id", wfNodes.getNodeId().toString());
            Iterator<WfNodeInstance> nodeInstIter = nodeInstSet.iterator();

            if (wfNodes.getNodeType().equals("A")) {
                procEle.addAttribute("inststate", "complete");
                benginNodeId = wfNodes.getNodeId();
                continue;
            }
            String inststate = "ready";
            int instCount = 0;
            // 根据节点实例状态刷新流程的节点状态
            while (nodeInstIter.hasNext()) {
                WfNodeInstance wfInstNodes = nodeInstIter.next();
                // 实例状态为C，更新流程当前节点为complete；
                // 实例状态为N，更新流程当前节点为waiting；
                // 实例状态为R，更新流程当前节点为waiting；
                if (wfInstNodes.getNodeId().equals(wfNodes.getNodeId())) {
                    String thisNodeState = "ready";

                    if (wfInstNodes.getNodeState().equals("C")) {
                        thisNodeState = "complete";
                        if (instCount == 0)
                            inststate = "complete";
                    } else if (wfInstNodes.getNodeState().equals("R")) {
                        thisNodeState = "dissociation";
                        if (!"waiting".equals(inststate))
                            inststate = "dissociation";
                    } else if (wfInstNodes.getNodeState().equals("N")) {
                        thisNodeState = "waiting";
                        inststate = "waiting";
                    } else {
                        thisNodeState = "closed";
                        if (instCount == 0)
                            inststate = "closed";
                    }
                    instCount++;
                    procEle.addElement("inst")
                            .addAttribute("instid",
                                    wfInstNodes.getNodeInstId().toString())
                            .addAttribute("state", thisNodeState);
                }
            }
            procEle.addAttribute("inststate", inststate);
            procEle.addAttribute("instcount", String.valueOf(instCount));
        }

        // 流转条件迭代
        while (transIter.hasNext()) {
            WfTransition wfTrans = transIter.next();
            Element stepEle = stepsEle.addElement("Step");
            stepEle.addAttribute("id", wfTrans.getTransid().toString());
            Iterator<WfNodeInstance> nodeInstIter = nodeInstSet.iterator();

            if (wfTrans.getStartnodeid().equals(benginNodeId)) {
                stepEle.addAttribute("inststate", "1");
                continue;
            }

            // 根据节点实例状态刷新流程的节点状态
            while (nodeInstIter.hasNext()) {
                WfNodeInstance wfInstNodes = nodeInstIter.next();

                // 不为空的实例，设置状态为1,默认为-1
                if (wfInstNodes.getTransId() != null
                        && wfInstNodes.getNodeId().equals(
                                wfTrans.getEndnodeid())
                        && wfInstNodes.getTransId()
                                .equals(wfTrans.getTransid())
                // && compNodeMap.containsKey(wfTrans.getStartnodeid())

                ) {
                    stepEle.addAttribute("inststate", "1");
                    break;
                }

                stepEle.addAttribute("inststate", "-1");
            }
        }

        return viewDoc.asXML();
    }

    /**
     * 例举一个用户可以操作的所有工作节点 1，根据Task表中查询 2，根据岗位、行政、流程角色查询
     */
    @Override
    public List<UserTask> listUserTasks(String userCode) {

        List<VUserTaskList> taskList = actionTaskDao.getTasksByUser(userCode);
        List<UserTask> tempList = new ArrayList<UserTask>(taskList);
        return tempList;
    }

    public List<VUserTaskList> listUserTasks(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vUserTasksDao.listObjects(filterMap, pageDesc);
    }

    /**
     * 根据节点ID查询能够操作该节点的所有人员，如果为空，则需要分配工作任务单
     */
    @Override
    public List<UserTask> listNodeTasks(long nodeInstId) {
        List<VUserTaskList> taskList = actionTaskDao
                .getTasksByNodeInstId(nodeInstId);
        if (taskList == null)
            return null;
        List<UserTask> tempList = new ArrayList<UserTask>();
        tempList.addAll(taskList);
        return tempList;
    }

    @Override
    public List<UserTask> listFlowTasks(long flowInstId) {

        List<VUserTaskList> taskList = actionTaskDao
                .getTasksByFlowid(flowInstId);
        if (taskList == null)
            return null;
        List<UserTask> tempList = new ArrayList<UserTask>(taskList);
        return tempList;
    }

    public ActionTask getActionTask(long taskId) {
        return actionTaskDao.getObjectById(taskId);
    }

    /**
     * 更新流程实例状态，同时需更新所有节点实例状态
     * 
     * @param instid
     *            实例编号
     * @param state
     *            N 正常/ R 运行(保留)/ C 完成/ S 挂起 /E 因为流程结束而结束 / F 因为流程强行结束二结束 / W
     *            等待子流程返回
     * @param userCode
     *            操作用户
     */
    private int updateInstanceState(long instid, String state, String userCode,
            String admindesc) {

        WfFlowInstance wfFlowInst = flowInstanceDao.getObjectById(instid);
        if (wfFlowInst == null)
            return 0;
        // wfFlowInst.setInststate(state);
        Date updateTime = DatetimeOpt.currentUtilDate();
        wfFlowInst.setLastUpdateTime(updateTime);
        wfFlowInst.setLastUpdateUser(userCode);
        // 系统自动检测超时，更新流程实例状态为超时
        if ("X".equals(state) && "N".equals(wfFlowInst.getInstState())) {
            wfFlowInst.setInstState(state);
            flowInstanceDao.saveObject(wfFlowInst);
            return 1;
        }
        String actionType = "U";
        // 只能结束未完成的流程
        if ("F".equals(state) && !"C".equals(wfFlowInst.getInstState())
                && !"F".equals(wfFlowInst.getInstState()))
            actionType = "F";
        // 只能挂起正常的流程
        else if ("S".equals(state) && "N".equals(wfFlowInst.getInstState()))
            actionType = "S";
        // 是流程失效
        else if ("I".equals(state) && "N".equals(wfFlowInst.getInstState()))
            actionType = "I";
        // 只能唤醒挂起、失效、超时 的流程
        else if ("N".equals(state)
                && ("S".equals(wfFlowInst.getInstState())
                        || "X".equals(wfFlowInst.getInstState()) || "I"
                            .equals(wfFlowInst.getInstState()))) {
            actionType = "W";
        }
        // 不正确的操作
        if ("U".equals(actionType))
            return -1;

        // 更新流程实例状态
        wfFlowInst.setInstState(state);
        if ("N".equals(state)) {
            for (WfNodeInstance nodeInst : wfFlowInst.getWfNodeInstances()) {
                if ("S".equals(nodeInst.getNodeState())) {
                    nodeInst.setNodeState("N");
                    nodeInst.setLastUpdateTime(updateTime);
                    nodeInst.setLastUpdateUser(userCode);
                }
            }
        }
        flowInstanceDao.saveObject(wfFlowInst);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(instid,
                userCode, actionType);
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc(admindesc);
        manageActionDao.saveObject(managerAct);

        return 1;
    }

    private long updateNodeInstState(long nodeInstId, String state,
            String mangerUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null) {
            return 0;
        }

        // 设置最后更新时间和更新人
        nodeInst.setLastUpdateUser(mangerUserCode);
        nodeInst.setLastUpdateTime(new Date(System.currentTimeMillis()));

        // 超时挂起
        if ("X".equals(state) && "N".equals(nodeInst.getNodeState())) {
            nodeInst.setNodeState(state);
            nodeInstanceDao.saveObject(nodeInst);
            return 1;
        }

        String actionType = "U";
        // 只能结束未完成的节点
        if ("F".equals(state) && !"C".equals(nodeInst.getNodeState())
                && !"F".equals(nodeInst.getNodeState()))
            actionType = "F";
        // 只能挂起正常的节点
        else if ("S".equals(state) && "N".equals(nodeInst.getNodeState()))
            actionType = "S";
        else if ("I".equals(state) && "N".equals(nodeInst.getNodeState()))
            actionType = "I";
        // 只能唤醒挂起、超时挂起、失效的节点
        else if ("N".equals(state)
                && ("S".equals(nodeInst.getNodeState())
                        || "X".equals(nodeInst.getNodeState()) || "I"
                            .equals(nodeInst.getNodeState())))
            actionType = "W";
        // 不正确的操作
        if ("U".equals(actionType))
            return -1;
        nodeInst.setNodeState(state);
        nodeInstanceDao.saveObject(nodeInst);

        WfActionLog wfactlog = SampleFlowUtils.createActionLog(state,
                mangerUserCode, nodeInstId);
        wfactlog.setActionId(actionLogDao.getNextActionId());
        actionLogDao.saveObject(wfactlog);
        return 1;
    }

    public long expireNodeInstance(long nodeInstId) {
        return updateNodeInstState(nodeInstId, "X", null);
    }

    public long suspendNodeInstance(long nodeInstId, String mangerUserCode) {
        return updateNodeInstState(nodeInstId, "S", mangerUserCode);
    }

    public long activizeNodeInstance(long nodeInstId, String mangerUserCode) {
        return updateNodeInstState(nodeInstId, "N", mangerUserCode);
    }

    /**
     * X 唤醒一个超时流程的一个节点
     */
    public long activizeExpireNodeInstance(long nodeInstId, String timeLimit,
            String mangerUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null) {
            return 0;
        }
        // 超时挂起
        if (!"X".equals(nodeInst.getNodeState())
                && !"N".equals(nodeInst.getNodeState())) {
            return -1;
        }

        nodeInst.setNodeState("N");
        nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber());
        nodeInst.setExpireOptSign(0L);
        // 设置最后更新时间和更新人
        nodeInst.setLastUpdateUser(mangerUserCode);
        nodeInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
        nodeInstanceDao.saveObject(nodeInst);

        WfActionLog wfactlog = SampleFlowUtils.createActionLog("X",
                mangerUserCode, nodeInstId);
        wfactlog.setActionId(actionLogDao.getNextActionId());
        actionLogDao.saveObject(wfactlog);
        return 1;
    }

    public FlowInstance getFlowInstance(long flowInstId) {
        return flowInstanceDao.getObjectById(flowInstId);
    }

    @Override
    public List<FlowInstance> listUserAttachFlowInstance(String userCode,
            String flowPhase, Map<String, Object> filterMap, PageDesc pageDesc) {
        List<WfFlowInstance> instList = flowInstanceDao
                .listUserAttachFlowInstance(userCode, flowPhase, filterMap,
                        pageDesc);

        for (WfFlowInstance flowInst : instList) {
            StringBuffer curStep = new StringBuffer(1);
            List<WfNodeInstance> activeNodeList = new ArrayList<WfNodeInstance>();
            for (WfNodeInstance nodeInst : flowInst.getWfNodeInstances()) {

                if ("N".equals(nodeInst.getNodeState())
                        || "R".equals(nodeInst.getNodeState())
                        || "W".equals(nodeInst.getNodeState())) {
                    WfNode node = flowNodeDao.getObjectById(nodeInst
                            .getNodeId());
                    nodeInst.setNodeName(node.getNodeName());
                    activeNodeList.add(nodeInst);
                    curStep.append(node.getNodeName());
                    curStep.append(',');
                }
            }
            if (curStep.length() > 1) {
                flowInst.setCurStep(curStep.deleteCharAt(curStep.length() - 1)
                        .toString());
            }
            flowInst.setActiveNodeList(activeNodeList);
        }

        return new ArrayList<FlowInstance>(this.convertor(instList));
    }

    /**
     * 转换流程名称等
     * 
     * @param instList
     * @return
     */
    private List<WfFlowInstance> convertor(List<WfFlowInstance> instList) {
        // TODO 刘建洋这个为什么不用一个视图，后面可以更新这个效率太低。
        if (instList == null)
            return null;
        for (WfFlowInstance flowInst : instList) {
            WfFlowDefine flowDef = flowDefDao.getFlowDefineByID(
                    flowInst.getFlowCode(), flowInst.getVersion());
            if (flowDef != null)
                flowInst.setFlowName(flowDef.getFlowName());
        }
        return instList;
    }

    @Override
    public List<FlowInstance> listFlowInstance(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        List<WfFlowInstance> instList = flowInstanceDao.listObjects(filterMap,
                pageDesc);
        return new ArrayList<FlowInstance>(this.convertor(instList));
    }

    @Override
    public List<ManageActionLog> listManageActionLog(long flowInstId) {
        return new ArrayList<ManageActionLog>(
                manageActionDao.getFlowManageLogs(flowInstId));
    }

    /**
     * 强行结束一个流程，同时将其所有的活动节点也强行结束
     */
    @Override
    public int stopInstance(long flowInstId, String mangerUserCode,
            String admindesc) {
        return updateInstanceState(flowInstId, "F", mangerUserCode, admindesc);
    }

    @Override
    public int expireInstance(long flowInstId) {
        return updateInstanceState(flowInstId, "X", null, "");
    }

    /**
     * 挂起一个流程，同时将其所有的活动节点也挂起
     */
    @Override
    public int suspendInstance(long flowInstId, String mangerUserCode,
            String admindesc) {
        return updateInstanceState(flowInstId, "S", mangerUserCode, admindesc);
    }

    /**
     * 激活一个 挂起的或者无效的流程
     */
    @Override
    public int activizeInstance(long flowInstId, String mangerUserCode,
            String admindesc) {
        return updateInstanceState(flowInstId, "N", mangerUserCode, admindesc);
    }

    /**
     * 唤醒一个超时流程的一个节点
     */
    public long activizeExpireInstance(long flowInstId, String timeLimit,
            String mangerUserCode, String admindesc) {
        WfFlowInstance wfFlowInst = flowInstanceDao.getObjectById(flowInstId);
        if (wfFlowInst == null)
            return 0;
        if (!"X".equals(wfFlowInst.getInstState())
                && !"N".equals(wfFlowInst.getInstState()))
            return -1;

        // 更新流程实例状态
        wfFlowInst.setInstState("N");
        wfFlowInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
        wfFlowInst.setLastUpdateUser(mangerUserCode);
        wfFlowInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber());
        wfFlowInst.setExpireOptSign(0L);
        flowInstanceDao.saveObject(wfFlowInst);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flowInstId, mangerUserCode, "X");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc(admindesc);
        manageActionDao.saveObject(managerAct);

        return 1;
    }

    /**
     * 使流程失效
     */
    @Override
    public int invalidInstance(long flowInstId, String mangerUserCode,
            String admindesc) {
        return updateInstanceState(flowInstId, "I", mangerUserCode, admindesc);
    }

    /**
     * 将流程回滚到上一个节点，如果是汇聚节点则不能回滚（暂不支持），如果是并行分支节点需要管理员配合挂起落空的节点
     * 暂时忽略流程的状态，但是要判断节点的状态，只有正在运行的节点（状态为N）才可以回退
     * 
     * @return >0：新节点的ID,-1 找不到节点，-2找不到流程 -3 找不到上一个节点 -4 上一个流程为子流程 不允许回退 -5
     *         本节点为汇聚节点不允许回退
     */
    @Override
    public long rollbackOpt(long nodeInstId, String mangerUserCode) {
        // 添加令牌算法
        WfNodeInstance thisNodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (thisNodeInst == null)
            return -1;
        // 当前节点状态必需为正常
        if (!"N".equals(thisNodeInst.getNodeState()))
            return -6;

        WfFlowInstance flowInst = flowInstanceDao.getObjectById(thisNodeInst
                .getFlowInstId());
        if (flowInst == null)
            return -2;

        /*
         * WfNode nodedef = flowNodeDao.getObjectById( thisnode.getNodeId());
         * if("E".equals(nodedef.getNodetype())){ //本节点为汇聚节点不允许回退 return -5; }
         */
        // 查找上一个流经节点
        WfNodeInstance prevNodeInst = flowInst.getPrevNodeInst(nodeInstId);
        // 不能回退到 自动执行，哑元，和子流程节点
        WfNode nodedef = flowNodeDao.getObjectById(prevNodeInst.getNodeId());
        while (prevNodeInst != null) {
            if ("D".equals(nodedef.getOptType())
                    || "E".equals(nodedef.getOptType())
                    || "S".equals(nodedef.getOptType())) {
                prevNodeInst = flowInst.getPrevNodeInst(prevNodeInst
                        .getNodeInstId());
                nodedef = flowNodeDao.getObjectById(prevNodeInst.getNodeId());
            } else
                break;
        }
        if (prevNodeInst == null)
            return -3;

        Date updateTime = DatetimeOpt.currentUtilDate();
        String prevToken = prevNodeInst.getRunToken();
        String thisToken = thisNodeInst.getRunToken();

        // 如果发现令牌不一致，则要重新设定令牌，并将相关的分支节点设置为无效
        if (prevToken != null && !prevToken.equals(thisToken)) {
            for (WfNodeInstance ni : flowInst.findSubNodeInstByToken(prevToken)) {
                if ("N".equals(ni.getNodeState())
                        || "R".equals(ni.getNodeState())
                        || "W".equals(ni.getNodeState())) {
                    if ("W".equals(ni.getNodeState())) { // 结束子流程
                        WfFlowInstance subFlowInst = flowInstanceDao
                                .getObjectById(ni.getSubFlowInstId());
                        if (subFlowInst != null) {
                            SampleFlowUtils.endInstance(subFlowInst, "F",
                                    mangerUserCode, flowInstanceDao);
                            subFlowInst.setLastUpdateUser(mangerUserCode);
                            flowInstanceDao.saveObject(subFlowInst);
                        }
                    }
                    ni.setNodeState("B");// 节点设置为无效
                    // 设置最后更新时间和更新人
                    ni.setLastUpdateUser(mangerUserCode);
                    ni.setLastUpdateTime(updateTime);
                }
            }
        }

        thisNodeInst.setNodeState("B");
        // 设置最后更新时间和更新人
        thisNodeInst.setLastUpdateUser(mangerUserCode);
        thisNodeInst.setLastUpdateTime(updateTime);

        long lastNodeInstId = nodeInstanceDao.getNextNodeInstId();
        WfNodeInstance nextNodeInst = flowInst.newWfNodeInstance();
        nextNodeInst.copyNotNullProperty(prevNodeInst);
        nextNodeInst.setNodeInstId(lastNodeInstId);
        nextNodeInst.setCreateTime(updateTime);
        nextNodeInst.setTimeLimit(null);
        nextNodeInst.setNodeState("N");
        nextNodeInst.setTaskAssigned("F");
        nextNodeInst.setLastUpdateUser(mangerUserCode);
        nextNodeInst.setLastUpdateTime(updateTime);

        for (WfActionTask task : prevNodeInst.getWfActionTasks()) {
            if ("T".equals(task.getIsvalid())) {
                WfActionTask newtask = SampleFlowUtils.createActionTask(
                        task.getUserCode(), nextNodeInst, nodedef);
                newtask.setTaskId(actionTaskDao.getNextTaskId());
                // 要判断 过期时间的问题
                nextNodeInst.addWfActionTask(newtask);
                nextNodeInst.setTimeLimit(null);
                nextNodeInst.setTaskAssigned("T");
            }

        }

        flowInst.addWfNodeInstance(nextNodeInst);
        nodeInstanceDao.saveObject(thisNodeInst);
        flowInstanceDao.saveObject(flowInst);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flowInst.getFlowInstId(), mangerUserCode, "B");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("node:" + nodeInstId);
        manageActionDao.saveObject(managerAct);

        return lastNodeInstId;
    }

    /**
     * 如果后续节点是 自动运行 和哑元 节点，节点被操作的判断将会误判
     */
    public boolean nodeCanBeReclaim(long nodeInstId) {
        WfNodeInstance thisnode = nodeInstanceDao.getObjectById(nodeInstId);
        if (thisnode == null)
            return false;
        WfFlowInstance flow = flowInstanceDao.getObjectById(thisnode
                .getFlowInstId());
        if (flow == null)
            return false;
        // 流程状态被更改也算被操作了
        if (!"N".equals(flow.getInstState()))
            return false;
        int nns = 0;
        for (WfNodeInstance nextNode : flow.getWfNodeInstances()) {
            if (thisnode.getNodeInstId().equals(nextNode.getPrevNodeInstId())) {
                nns++;
                if (!"N".equals(nextNode.getNodeState())) // ||
                                                          // nextNode.getWfActionLogs().size()>0)
                    return false;
            }
        }
        return nns > 0;
    }

    /**
     * 从这个节点重新运行该流程，包括已经结束的流程
     */
    public long resetFlowToThisNode(long nodeInstId, String mangerUserCode) {

        WfNodeInstance thisnode = nodeInstanceDao.getObjectById(nodeInstId);
        if (thisnode == null)
            return -1;
        // 当前节点状态必需不能为正常，如果是正常则没有必要重置
        if ("N".equals(thisnode.getNodeState()))
            return -6;

        WfFlowInstance flow = flowInstanceDao.getObjectById(thisnode
                .getFlowInstId());
        if (flow == null)
            return -2;
        WfNode nodedef = flowNodeDao.getObjectById(thisnode.getNodeId());
        if ("A".equals(nodedef.getNodeType())
                || "F".equals(nodedef.getNodeType())) {
            // 不能设定到开始或者结束节点
            return -5;
        }

        for (WfNodeInstance nodeInst : flow.getWfNodeInstances()) {
            if (("N".equals(nodeInst.getNodeState())
                    || "R".equals(nodeInst.getNodeState()) || "W"
                        .equals(nodeInst.getNodeState()))
                    && (nodeInst.getNodeId().equals(thisnode.getNodeId()))) {
                // 已经有一个正在运行的相同节点实例，不能重置到该节点
                return -6;
            }
        }

        flow.setInstState("N");
        flow.setLastUpdateTime(new Date(System.currentTimeMillis()));
        flow.setLastUpdateUser(mangerUserCode);
        // 将所有的下层正常节点都设置为 B 已回退
        String thisToken = thisnode.getRunToken();
        Date updateTime = DatetimeOpt.currentUtilDate();
        for (WfNodeInstance nodeInst : flow.getWfNodeInstances()) {
            String currToken = nodeInst.getRunToken();
            if (("N".equals(nodeInst.getNodeState())
                    || "R".equals(nodeInst.getNodeState()) || "W"
                        .equals(nodeInst.getNodeState()))
                    && currToken != null
                    && thisToken != null
                    && (currToken.equals(thisToken)
                            || currToken.startsWith(thisToken + '.') || thisToken
                                .startsWith(currToken + '.'))) {

                if ("W".equals(nodeInst.getNodeState())) { // 结束子流程
                    WfFlowInstance subFlowInst = flowInstanceDao
                            .getObjectById(nodeInst.getSubFlowInstId());
                    if (subFlowInst != null) {
                        SampleFlowUtils.endInstance(subFlowInst, "F",
                                mangerUserCode, flowInstanceDao);
                        subFlowInst.setLastUpdateUser(mangerUserCode);
                        flowInstanceDao.saveObject(subFlowInst);
                    }
                }
                nodeInst.setNodeState("B");
                // 设置最后更新时间和更新人
                nodeInst.setLastUpdateUser(mangerUserCode);
                nodeInst.setLastUpdateTime(updateTime);
                WfActionLog wfactlog = SampleFlowUtils.createActionLog("E",
                        mangerUserCode, nodeInstId);
                wfactlog.setActionId(actionLogDao.getNextActionId());
                nodeInst.addWfActionLog(wfactlog);
            }
        }
        // 创建新节点
        long lastNodeInstId = nodeInstanceDao.getNextNodeInstId();
        WfNodeInstance nextNodeInst = flow.newWfNodeInstance();
        nextNodeInst.copyNotNullProperty(thisnode);
        nextNodeInst.setNodeInstId(lastNodeInstId);
        nextNodeInst.setNodeState("N");
        nextNodeInst.setTaskAssigned("F");
        nextNodeInst.setLastUpdateUser(mangerUserCode);
        nextNodeInst.setLastUpdateTime(updateTime);

        for (WfActionTask task : thisnode.getWfActionTasks()) {
            if ("T".equals(task.getIsvalid())) {
                WfActionTask newtask = SampleFlowUtils.createActionTask(
                        task.getUserCode(), nextNodeInst, nodedef);
                newtask.setTaskId(actionTaskDao.getNextTaskId());
                // 要判断 过期时间的问题
                nextNodeInst.addWfActionTask(newtask);
            }
        }

        flow.addWfNodeInstance(nextNodeInst);
        flowInstanceDao.saveObject(flow);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flow.getFlowInstId(), mangerUserCode, "R");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("node:" + nodeInstId);
        manageActionDao.saveObject(managerAct);

        return lastNodeInstId;
    }

    public long createNodeInst(long nodeId, long flowInstId, String unitCode,
            String mangerUserCode) {
        WfFlowInstance flow = flowInstanceDao.getObjectById(flowInstId);
        if (flow == null)
            return -2;

        long newInstId = nodeInstanceDao.getNextNodeInstId();

        WfNodeInstance newNodeInst = flow.newWfNodeInstance();
        newNodeInst.setNodeInstId(newInstId);
        newNodeInst.setNodeId(nodeId);
        newNodeInst.setCreateTime(new Date(System.currentTimeMillis()));
        newNodeInst.setNodeState("N"); // 设置为有游离状态
        newNodeInst.setRunToken("T"); // 添加令牌算法 这个节点不参与令牌管理，给一个游离的令牌 R
        newNodeInst.setTaskAssigned("F");

        if (StringUtils.isNotBlank(unitCode)) {
            newNodeInst.setUnitCode(unitCode);
        }

        flow.addWfNodeInstance(newNodeInst);
        flow.setLastUpdateTime(new Date(System.currentTimeMillis()));
        flow.setLastUpdateUser(mangerUserCode);

        flowInstanceDao.saveObject(flow);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flow.getFlowInstId(), mangerUserCode, "N");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("创建节点实例： " + newInstId);
        manageActionDao.saveObject(managerAct);

        return newInstId;
    }

    public long createDissociateNodeInst(long nodeInstId, String mangerUserCode) {
        WfNodeInstance thisnode = nodeInstanceDao.getObjectById(nodeInstId);
        if (thisnode == null)
            return -1;
        // 当前节点状态必需不能为正常，如果是正常则没有必要重置
        if ("N".equals(thisnode.getNodeState()))
            return -6;

        WfFlowInstance flow = flowInstanceDao.getObjectById(thisnode
                .getFlowInstId());
        if (flow == null)
            return -2;
        WfNode nodedef = flowNodeDao.getObjectById(thisnode.getNodeId());
        if ("A".equals(nodedef.getNodeType())
                || "F".equals(nodedef.getNodeType())) {
            // 不能设定到开始或者结束节点
            return -5;
        }
        for (WfNodeInstance nodeInst : flow.getWfNodeInstances()) {
            if (("N".equals(nodeInst.getNodeState())
                    || "R".equals(nodeInst.getNodeState()) || "W"
                        .equals(nodeInst.getNodeState()))
                    && (nodeInst.getNodeId().equals(thisnode.getNodeId()))) {
                // 已经有一个正在运行的相同节点实例，不能重置到该节点
                return -6;
            }
        }

        flow.setInstState("N");
        flow.setLastUpdateTime(new Date(System.currentTimeMillis()));
        flow.setLastUpdateUser(mangerUserCode);
        long lastNodeInstId = nodeInstanceDao.getNextNodeInstId();
        WfNodeInstance nextNodeInst = flow.newWfNodeInstance();
        nextNodeInst.copyNotNullProperty(thisnode);
        // 游离的节点不能回退
        // nextNodeInst.setPrevNodeInstId(0l);
        nextNodeInst.setNodeInstId(lastNodeInstId);
        nextNodeInst.setCreateTime(new Date(System.currentTimeMillis()));
        nextNodeInst.setNodeState("R"); // 设置为有游离状态
        nextNodeInst.setRunToken(thisnode.getRunToken() + ".R"); // 添加令牌算法
                                                                 // 这个节点不参与令牌管理，给一个游离的令牌
                                                                 // R
        nextNodeInst.setTaskAssigned("F");

        flow.addWfNodeInstance(nextNodeInst);
        flowInstanceDao.saveObject(flow);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flow.getFlowInstId(), mangerUserCode, "Q");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("nodeInstId:" + nodeInstId);
        manageActionDao.saveObject(managerAct);

        return lastNodeInstId;
    }

    public int stopDissociateNodeInst(long flowInstId, String mangerUserCode) {
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(flowInstId);
        if (flowInst == null)
            return -2;
        int stop = 0;
        for (WfNodeInstance nodeInst : flowInst.getWfNodeInstances())
            if ("R".equals(nodeInst.getNodeState())) {
                nodeInst.setNodeState("I");
                nodeInst.setLastUpdateUser(mangerUserCode);
                nodeInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
                stop++;
            }
        if (stop > 0) {
            flowInstanceDao.saveObject(flowInst);
            WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                    flowInst.getFlowInstId(), mangerUserCode, "i");
            managerAct.setActionId(manageActionDao.getNextManageId());
            managerAct.setAdminDesc("flowInstId:" + flowInstId);
            manageActionDao.saveObject(managerAct);
        }
        return stop;
    }

    @Override
    public long forceDissociateRuning(long nodeInstId, String mangerUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null || (!"N".equals(nodeInst.getNodeState())))
            return -1;
        WfFlowInstance flowinst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());
        if (flowinst == null)
            return -2;
        int otherRunNode = 0;
        for (WfNodeInstance tNode : flowinst.getWfNodeInstances()) {
            if (!tNode.getNodeInstId().equals(nodeInstId)
                    && "N".equals(tNode.getNodeState()))
                otherRunNode++;
        }
        if (otherRunNode == 0)
            return -3;

        nodeInst.setNodeState("R");
        // 设置最后更新时间和更新人
        nodeInst.setLastUpdateUser(mangerUserCode);
        nodeInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
        nodeInstanceDao.saveObject(nodeInst);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                nodeInst.getFlowInstId(), mangerUserCode, "q");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("node:" + nodeInstId);
        manageActionDao.saveObject(managerAct);
        return nodeInstId;
    }

    /**
     * 目前只能提交直接向下流转的节点，暂不支持分支节点，也不支持下一个节点是汇聚类型的流转,机构自动继承上个节点的机构 强行流转无法自动运行
     * 机构和权限表达式，所以新的节点可能没有人能够对其进行操作，必需要配合任务管理来指定到具体的人
     */
    @Override
    public long forceCommit(long nodeInstId, String mangerUserCode) {

        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null)
            return -1;
        List<WfTransition> transList = flowTransitionDao.getNodeTrans(nodeInst
                .getNodeId());
        if (transList == null || transList.size() != 1)
            return -2;
        WfTransition trans = transList.get(0);
        long nextCode = transList.get(0).getEndnodeid();
        WfNode nextNode = flowNodeDao.getObjectById(nextCode);
        if (nextNode == null)
            return -3;
        if ("F".equals(nextNode.getNodeType()))
            return -4;
        if ("E".equals(nextNode.getNodeType()))
            return -5;
        Date commitTime = DatetimeOpt.currentUtilDate();
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());

        nodeInst.setNodeState("D");
        // 设置最后更新时间和更新人
        nodeInst.setLastUpdateUser(mangerUserCode);
        nodeInst.setLastUpdateTime(commitTime);

        long nextNodeInstId = nodeInstanceDao.getNextNodeInstId();
        WfNodeInstance nextNodeInst = SampleFlowUtils.createNodeInst(
                nodeInst.getUnitCode(), mangerUserCode, flowInst, nextNode,
                trans);

        nextNodeInst.setNodeInstId(nextNodeInstId);
        nextNodeInst.setPrevNodeInstId(nodeInst.getNodeId());
        nextNodeInst.setRunToken(nodeInst.getRunToken());// 添加令牌算法
        nextNodeInst.setTransId(trans.getTransid());
        nodeInstanceDao.saveObject(nodeInst);
        nodeInstanceDao.saveObject(nextNodeInst);

        flowInst.setLastUpdateUser(mangerUserCode);
        flowInst.setLastUpdateTime(commitTime);
        flowInstanceDao.saveObject(flowInst);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                nodeInst.getFlowInstId(), mangerUserCode, "C");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("node:" + nodeInstId);
        manageActionDao.saveObject(managerAct);
        return nextNodeInstId;
    }

    /**
     * 获取用户所有的操作记录
     * 
     * @param userCode
     * @param pageDesc
     *            和分页机制结合
     * @param lastTime
     *            if null return all
     * @return
     */
    @Override
    public List<ActionLog> listUserActionLogs(String userCode,
            PageDesc pageDesc, Date lastTime) {
        List<WfActionLog> actionLogs = actionLogDao.listUserActionLogs(
                userCode, pageDesc, lastTime);
        return new ArrayList<ActionLog>(actionLogs);
    }

    /**
     * 在任务列表中指定工作人员，这样就屏蔽了按照角色自动查找符合权限的人员
     */
    @Override
    public long assignTask(long nodeInstId, String userCode,
            String mangerUserCode, Date expiretime, String authDesc) {
        WfNodeInstance node = nodeInstanceDao.getObjectById(nodeInstId);
        if (node == null)
            return -1;

        Set<WfActionTask> taskList = node.getWfActionTasks();
        for (WfActionTask task : taskList) {
            if ("T".equals(task.getIsvalid())
                    && userCode.equals(task.getUserCode()))
                return -2;
        }

        WfActionTask task = SampleFlowUtils.createActionTask(nodeInstId,
                userCode);
        task.setTaskId(actionTaskDao.getNextTaskId());
        task.setExpireTime(expiretime);
        task.setAuthDesc(authDesc);
        node.addWfActionTask(task);
        node.setTaskAssigned("T");

        nodeInstanceDao.saveObject(node);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                node.getFlowInstId(), userCode, "A");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc(authDesc);
        manageActionDao.saveObject(managerAct);
        return 0;
    }

    /**
     * 收回任务分配
     */
    @Override
    public int disableTask(long nodeInstId, String userCode,
            String mangerUserCode) {

        WfNodeInstance node = nodeInstanceDao.getObjectById(nodeInstId);
        if (node == null)
            return -1;
        WfActionTask assignedTask = null;
        Set<WfActionTask> taskList = node.getWfActionTasks();
        int atc = 0;
        for (WfActionTask task : taskList) {
            if ("T".equals(task.getIsvalid())
                    && "A".equals(task.getTaskState()))// 只能禁用未完成的任务
            {
                if (userCode.equals(task.getUserCode()))
                    assignedTask = task;
                else
                    atc++;
            }
        }

        if (assignedTask == null)
            return -3;
        assignedTask.setIsvalid("F");
        node.setTaskAssigned(atc > 0 ? "T" : "F");
        nodeInstanceDao.saveObject(node);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                node.getFlowInstId(), mangerUserCode, "P");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("node:" + nodeInstId + " user:" + userCode);
        manageActionDao.saveObject(managerAct);
        return 0;
    }

    /**
     * 删除任务节点
     */
    @Override
    public int deleteTask(long nodeInstId, String userCode,
            String mangerUserCode) {
        WfNodeInstance node = nodeInstanceDao.getObjectById(nodeInstId);
        if (node == null)
            return -1;
        WfActionTask assignedTask = null;
        Set<WfActionTask> taskList = node.getWfActionTasks();
        int atc = 0;
        for (WfActionTask task : taskList) {
            if ("T".equals(task.getIsvalid())
                    && "A".equals(task.getTaskState()))// 只能禁用未完成的任务
            {
                if (userCode.equals(task.getUserCode()))
                    assignedTask = task;
                else
                    atc++;
            }
        }

        if (assignedTask == null)
            return -3;

        node.removeWfActionTask(assignedTask);
        node.setTaskAssigned(atc > 0 ? "T" : "F");
        nodeInstanceDao.saveObject(node);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                node.getFlowInstId(), mangerUserCode, "D");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("node:" + nodeInstId + " user:" + userCode);
        manageActionDao.saveObject(managerAct);
        return 0;
    }

    /**
     * 取消节点任务
     */
    public int disableTask(long taskInstId, String mangerUserCode) {
        WfActionTask assignedTask = actionTaskDao.getObjectById(taskInstId);
        if (assignedTask == null)
            return -1;
        WfNodeInstance node = nodeInstanceDao.getObjectById(assignedTask
                .getNodeInstId());
        if (node == null)
            return -2;
        if ("C".equals(assignedTask.getTaskState()))// 只能禁用没有完成的任务
            return -3;

        Set<WfActionTask> taskList = node.getWfActionTasks();
        int atc = 0;
        for (WfActionTask task : taskList) {
            if (task.getTaskId().equals(taskInstId))// 只能禁用未完成的任务
                assignedTask = task;
            else if ("T".equals(task.getIsvalid())
                    && "A".equals(task.getTaskState()))
                atc++;
        }

        assignedTask.setIsvalid("F");
        node.setTaskAssigned(atc > 0 ? "T" : "F");
        nodeInstanceDao.saveObject(node);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                node.getFlowInstId(), mangerUserCode, "P");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("task:" + taskInstId);
        manageActionDao.saveObject(managerAct);
        return 0;
    }

    /**
     * 删除节点任务
     */
    public int deleteTask(long taskInstId, String mangerUserCode) {
        WfActionTask assignedTask = actionTaskDao.getObjectById(taskInstId);
        if (assignedTask == null)
            return -1;
        WfNodeInstance node = nodeInstanceDao.getObjectById(assignedTask
                .getNodeInstId());
        if (node == null)
            return -2;
        if ("C".equals(assignedTask.getTaskState()))// 只能禁用没有完成的任务
            return -3;

        Set<WfActionTask> taskList = node.getWfActionTasks();
        int atc = 0;
        for (WfActionTask task : taskList) {
            if (task.getTaskId().equals(taskInstId))// 只能禁用未完成的任务
                assignedTask = task;
            else if ("T".equals(task.getIsvalid())
                    && "A".equals(task.getTaskState()))
                atc++;
        }

        node.removeWfActionTask(assignedTask);
        node.setTaskAssigned(atc > 0 ? "T" : "F");
        nodeInstanceDao.saveObject(node);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                node.getFlowInstId(), mangerUserCode, "D");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("task:" + taskInstId);
        manageActionDao.saveObject(managerAct);
        return 0;
    }

    /**
     * 设置任务期限
     */
    public int assignTaskExpireTime(long taskInstId, Date expiretime,
            String mangerUserCode) {
        WfActionTask task = actionTaskDao.getObjectById(taskInstId);
        if (task == null)
            return -1;
        WfNodeInstance node = nodeInstanceDao.getObjectById(task
                .getNodeInstId());
        if (node == null)
            return -2;
        if ("C".equals(task.getTaskState()))// 只能设置没有完成的任务的期限
            return -3;
        task.setExpireTime(expiretime);
        actionTaskDao.saveObject(task);
        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                node.getFlowInstId(), mangerUserCode, "E");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("task:" + taskInstId);
        manageActionDao.saveObject(managerAct);
        return 0;
    }

    @Override
    public String getTaskGrantor(long nodeInstId, String userCode) {
        return actionTaskDao.getTaskGrantor(nodeInstId, userCode);
    }

    @Override
    public List<NodeInstance> listNodesWithoutOpt() {
        List<WfNodeInstance> tempList = nodeInstanceDao.listNodesWithoutOpt();
        if (tempList != null) {
            for (int i = 0; i < tempList.size();) {
                WfNodeInstance nodeInst = (WfNodeInstance) tempList.get(i);
                try {
                    WfFlowInstance flowInst = flowInstanceDao
                            .getObjectById(nodeInst.getFlowInstId());
                    nodeInst.setFlowOptName(flowInst.getFlowOptName());
                    nodeInst.setFlowOptTag(flowInst.getFlowOptTag());

                    WfNode wfNode = flowNodeDao.getObjectById(nodeInst
                            .getNodeId());
                    nodeInst.setRoleCode(wfNode.getRoleCode());
                    nodeInst.setRoleType(wfNode.getRoleType());
                    nodeInst.setNodeName(wfNode.getNodeName());
                    i++;
                } catch (Exception e) {
                    System.out.println(nodeInst.getFlowInstId());
                    tempList.remove(i);
                    continue;
                }

            }

            return new ArrayList<NodeInstance>(tempList);
        }
        return new ArrayList<NodeInstance>();

    }

    public boolean canAccess(long nodeInstId, String userCode) {
        if (userCode == null)
            return false;
        VUserTaskList taskList = actionTaskDao.getUserTaskByNodeInstId(
                nodeInstId, userCode);
        return taskList != null;
    }

    public String getNodeOptUrl(long nodeInstId, String userCode) {
        if (userCode != null) {
            VUserTaskList task = actionTaskDao.getUserTaskByNodeInstId(
                    nodeInstId, userCode);
            if (task == null)
                return null;
            else {
                return task.getNodeOptUrl();
            }
        } else {
            List<VUserTaskList> taskList = actionTaskDao
                    .getTasksByNodeInstId(nodeInstId);
            if (taskList == null || taskList.size() == 0)
                return null;
            else {
                VUserTaskList task = taskList.get(0);
                return task.getNodeOptUrl();
            }
        }
    }

    public String getNodeOptUrl(long nodeInstId) {
        return getNodeOptUrl(nodeInstId, null);
    }

    public void saveNodeInstUnit(long nodeInstId, String unitCode,
            String mangerUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        nodeInst.setUnitCode(unitCode);
        nodeInstanceDao.saveObject(nodeInst);

        WfActionLog wfActionLog = SampleFlowUtils.createActionLog("O",
                mangerUserCode, nodeInstId);
        wfActionLog.setActionId(actionLogDao.getNextActionId());
        actionLogDao.saveObject(wfActionLog);
    }

    public void saveFlowInstUnit(long flowInstId, String unitCode,
            String mangerUserCode) {
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(flowInstId);
        flowInst.setUnitCode(unitCode);
        flowInstanceDao.saveObject(flowInst);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flowInstId, mangerUserCode, "O");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("修改流程实例机构，修改人：" + mangerUserCode);
        manageActionDao.saveObject(managerAct);

    }

    public List<NodeInstance> listFlowInstNodes(long wfinstid) {
        List<WfNodeInstance> nodeInstList = new ArrayList<WfNodeInstance>();
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(wfinstid);
        Set<WfNodeInstance> nodeInstsSet = flowInst.getWfNodeInstances();
        for (WfNodeInstance nodeInst : nodeInstsSet) {
            WfNode node = flowNodeDao.getObjectById(nodeInst.getNodeId());
            // 不显示 自动执行的节点 codefan@sina.com 2012-7-8
            if ("D".equals(node.getOptType()) || "E".equals(node.getOptType()))
                continue;

            nodeInst.setNodeName(node.getNodeName());
            if (nodeInst.getNodeState().equals("N")) {
                List<VUserTaskList> taskList = actionTaskDao
                        .getTasksByNodeInstId(nodeInst.getNodeInstId());
                List<String> trainsUsers = new ArrayList<String>();
                for (VUserTaskList userTask : taskList) {
                    trainsUsers.add(userTask.getUserCode());
                }
                nodeInst.setTrainsUsers(trainsUsers);
            }
            nodeInstList.add(nodeInst);
        }
        return new ArrayList<NodeInstance>(nodeInstList);
    }

    public List<ActionTask> listNodeActionTasks(long nodeinstid) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeinstid);
        return new ArrayList<ActionTask>(nodeInst.getWfActionTasks());
    }

    public int deleteNodeActionTasks(long nodeinstid, String mangerUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeinstid);
        int nTasks = nodeInst.getWfActionTasks().size();

        if (nTasks > 0) {
            nodeInst.getWfActionTasks().clear();
            nodeInstanceDao.saveObject(nodeInst);

            WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                    nodeInst.getFlowInstId(), mangerUserCode, "D");
            managerAct.setActionId(manageActionDao.getNextManageId());
            managerAct.setAdminDesc("delete all task:"
                    + nodeInst.getNodeInstId());
            manageActionDao.saveObject(managerAct);
        }

        return nTasks;
    }

    public List<ActionLog> listNodeActionLogs(long nodeinstid) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeinstid);
        return new ArrayList<ActionLog>(nodeInst.getWfActionLogs());
    }

    @Override
    public List<NodeInstance> listLastUpdateNodeInst(String userCode,
            String nodeState) {
        List<WfNodeInstance> tempList = nodeInstanceDao.listLastUpdateNodeInst(
                userCode, nodeState);
        return new ArrayList<NodeInstance>(tempList);
    }

    @Override
    public List<FlowInstance> listLastUpdateFlowInst(String userCode,
            String flowState) {
        List<WfFlowInstance> tempList = flowInstanceDao.listLastUpdateFlowInst(
                userCode, flowState);
        return new ArrayList<FlowInstance>(tempList);
    }

    /**
     * isTimer T 计时、 F 不计时 H仅环节计时 、暂停P
     */
    public int suspendNodeInstTimer(long nodeInstId, String mangerUserCode) {
        nodeInstanceDao.updateNodeTimerState(nodeInstId, "P", mangerUserCode);

        WfActionLog wfActionLog = SampleFlowUtils.createActionLog("P",
                mangerUserCode, nodeInstId);
        wfActionLog.setActionId(actionLogDao.getNextActionId());
        actionLogDao.saveObject(wfActionLog);
        return 1;
    }

    /**
     * isTimer 不计时F 、计时T(有期限)、暂停P H 仅环节计时 唤醒时要根据 wf_node 的计时类别进行修改 T 计时、有期限 F
     * 不计时 H仅环节计时
     */
    public int activizeNodeInstTimer(long nodeInstId, String mangerUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null)
            return 0;
        WfNode node = flowNodeDao.getObjectById(nodeInst.getNodeId());
        nodeInstanceDao.updateNodeTimerState(nodeInstId,
                node.getIsAccountTime() /* T */, mangerUserCode);
        WfActionLog wfActionLog = SampleFlowUtils.createActionLog("T",
                mangerUserCode, nodeInstId);
        wfActionLog.setActionId(actionLogDao.getNextActionId());
        actionLogDao.saveObject(wfActionLog);
        return 1;
    }

    /**
     * isTimer 不计时 F、计时T(有期限)、暂停P 忽略(无期限) F
     */
    public int suspendFlowInstTimer(long flowInstId, String mangerUserCode) {
        flowInstanceDao.updateFlowTimerState(flowInstId, "P", mangerUserCode);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flowInstId, mangerUserCode, "P");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct
                .setAdminDesc("suspend flow timer !flowInstId: " + flowInstId);
        manageActionDao.saveObject(managerAct);
        return 1;
    }

    /**
     * isTimer 不计时N、计时T(有期限)、暂停P 忽略(无期限) F
     */
    public int activizeFlowInstTimer(long flowInstId, String mangerUserCode) {
        flowInstanceDao.updateFlowTimerState(flowInstId, "T", mangerUserCode);

        WfManageAction managerAct = SampleFlowUtils.createManagerAction(
                flowInstId, mangerUserCode, "T");
        managerAct.setActionId(manageActionDao.getNextManageId());
        managerAct.setAdminDesc("activize flow timer !flowInstId: "
                + flowInstId);
        manageActionDao.saveObject(managerAct);
        return 1;
    }

    @Override
    public List<NodeInstance> listPauseTimerNodeInst(String userCode) {
        List<WfNodeInstance> tempList = nodeInstanceDao.listNodeInstByTimer(
                userCode, "P");
        return new ArrayList<NodeInstance>(tempList);
    }

    @Override
    public List<FlowInstance> listPauseTimerFlowInst(String userCode) {
        List<WfFlowInstance> tempList = flowInstanceDao.listFlowInstByTimer(
                userCode, "P");
        return new ArrayList<FlowInstance>(tempList);
    }

    @Override
    public List<ActionLog> listGrantorActionLog(String userCode,
            PageDesc pageDesc) {
        List<WfActionLog> tempList = actionLogDao.listGrantorActionLog(
                userCode, pageDesc);
        return new ArrayList<ActionLog>(tempList);
    }

    @Override
    public List<ActionLog> listGrantdedActionLog(String userCode,
            PageDesc pageDesc) {
        List<WfActionLog> tempList = actionLogDao.listGrantedActionLog(
                userCode, pageDesc);
        return new ArrayList<ActionLog>(tempList);
    }

    public List<NodeInstance> listUserSuspendNodeInst(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        List<VNodeInstDetail> tempList = vNodeInstDetailDao.listObjects(
                filterMap, pageDesc);
        if (tempList != null) {
            return new ArrayList<NodeInstance>(tempList);
        }
        return new ArrayList<NodeInstance>();
    }

    public List<NodeInstance> listUserCompleteTasks(
            Map<String, Object> filterMap, PageDesc pageDesc, String userCode) {
        List<WfNodeInstance> tempList = nodeInstanceDao.listObjects(filterMap,
                pageDesc);
        List<NodeInstance> temp = new ArrayList<NodeInstance>();
        if (tempList != null) {

            for (WfNodeInstance nodeInst : tempList) {
                WfFlowInstance flowInst = flowInstanceDao
                        .getObjectById(nodeInst.getFlowInstId());
                if (flowInst == null) {
                    continue;
                }
                nodeInst.setFlowOptName(flowInst.getFlowOptName());
                nodeInst.setFlowOptTag(flowInst.getFlowOptTag());

                WfNode wfNode = flowNodeDao.getObjectById(nodeInst.getNodeId());
                if (wfNode == null) {
                    continue;
                }
                nodeInst.setRoleCode(wfNode.getRoleCode());
                nodeInst.setRoleType(wfNode.getRoleType());
                nodeInst.setNodeName(wfNode.getNodeName());

                // 判断节点任务是否提供回收：a.下一步办理人为当前操作人员的;b.下一节点已经被处理过的
                if (nodeCanBeReclaim(nodeInst.getNodeInstId())
                        && !canAccess(nodeInst.getNodeInstId(), userCode)) {
                    nodeInst.setIsRecycle("yes");
                    temp.add(nodeInst);
                } else {
                    nodeInst.setIsRecycle("no");
                }
            }

            return temp;
        }
        return new ArrayList<NodeInstance>();
    }

    public void saveMoveTask(WfTaskMove taskMove) {
        if (StringUtils.isNotBlank(taskMove.getOlduser())
                && StringUtils.isNotBlank(taskMove.getNewuser())) {
            List<WfTeam> oldTeamList = flowTeamDao.listTeamsByFlow(taskMove
                    .getOlduser());
            for (WfTeam team : oldTeamList) {
                WfTeam newUserTeam = new WfTeam();
                newUserTeam.setFlowInstId(team.getFlowInstId());
                newUserTeam.setUserCode(taskMove.getNewuser());
                newUserTeam.setRoleCode(team.getRoleCode());
                newUserTeam.setAuthTime(new Date(System.currentTimeMillis()));
                newUserTeam.setAuthDesc("任务迁移：" + taskMove.getOlduser()
                        + " to " + taskMove.getNewuser());
                flowTeamDao.saveObject(newUserTeam);
                flowTeamDao.deleteObjectById(team.getCid());
            }

            List<WfActionTask> taskList = actionTaskDao
                    .listActionTaskByNode(taskMove.getOlduser());
            for (WfActionTask task : taskList) {
                task.setUserCode(taskMove.getNewuser());
                actionTaskDao.saveObject(task);
            }

            flowTaskMoveDao.saveTaskMove(taskMove);
        }
    }

    public VNodeInstDetail getVNodeInstDetailbyNode(Long nodeinstid) {
        return vNodeInstDetailDao.getDetailbyNodeinstid(nodeinstid);
    }

    public List<WfTaskMove> listMoveTask(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return flowTaskMoveDao.listObjects(filterMap, pageDesc);
    }

    public void setFlowInstanceDao(WfFlowInstanceDao flowInstanceDao) {
        this.flowInstanceDao = flowInstanceDao;
    }

    public void setNodeInstanceDao(WfNodeInstanceDao nodeInstanceDao) {
        this.nodeInstanceDao = nodeInstanceDao;
    }

    public void setFlowNodeDao(WfNodeDao flowNodeDao) {
        this.flowNodeDao = flowNodeDao;
    }

    public void setFlowTransitionDao(WfTransitionDao flowTransitionDao) {
        this.flowTransitionDao = flowTransitionDao;
    }

    public void setManageActionDao(WfManageActionDao manageActionDao) {
        this.manageActionDao = manageActionDao;
    }

    public void setActionTaskDao(WfActionTaskDao actionTaskDao) {
        this.actionTaskDao = actionTaskDao;
    }

    public void setActionLogDao(WfActionLogDao actionLogDao) {
        this.actionLogDao = actionLogDao;
    }

    public void setFlowDefDao(WfFlowDefineDao flowDefDao) {
        this.flowDefDao = flowDefDao;
    }

    public VNodeInstDetailDao getvNodeInstDetailDao() {
        return vNodeInstDetailDao;
    }

    public void setvNodeInstDetailDao(VNodeInstDetailDao vNodeInstDetailDao) {
        this.vNodeInstDetailDao = vNodeInstDetailDao;
    }

    public void setFlowTeamDao(WfTeamDao flowTeamDao) {
        this.flowTeamDao = flowTeamDao;
    }

    public WfTaskMoveDao getFlowTaskMoveDao() {
        return flowTaskMoveDao;
    }

    public void setFlowTaskMoveDao(WfTaskMoveDao flowTaskMoveDao) {
        this.flowTaskMoveDao = flowTaskMoveDao;
    }

    public VUserTasksDao getvUserTasksDao() {
        return vUserTasksDao;
    }

    public void setvUserTasksDao(VUserTasksDao vUserTasksDao) {
        this.vUserTasksDao = vUserTasksDao;
    }
}

package com.centit.workflow.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.support.compiler.Formula;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringRegularOpt;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUnitFilterEngine;
import com.centit.sys.service.SysUserFilterEngine;
import com.centit.sys.service.SysVariableTranslate;
import com.centit.workflow.FlowDescribe;
import com.centit.workflow.FlowEngine;
import com.centit.workflow.FlowNodeInfo;
import com.centit.workflow.FlowVariable;
import com.centit.workflow.WorkflowException;
import com.centit.workflow.sample.dao.WfActionLogDao;
import com.centit.workflow.sample.dao.WfActionTaskDao;
import com.centit.workflow.sample.dao.WfFlowDefineDao;
import com.centit.workflow.sample.dao.WfFlowInstanceDao;
import com.centit.workflow.sample.dao.WfFlowVariableDao;
import com.centit.workflow.sample.dao.WfInstAttentionDao;
import com.centit.workflow.sample.dao.WfNodeDao;
import com.centit.workflow.sample.dao.WfNodeInstanceDao;
import com.centit.workflow.sample.dao.WfOrganizeDao;
import com.centit.workflow.sample.dao.WfTeamDao;
import com.centit.workflow.sample.dao.WfTransitionDao;
import com.centit.workflow.sample.po.WfActionLog;
import com.centit.workflow.sample.po.WfActionTask;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowDefineId;
import com.centit.workflow.sample.po.WfFlowInstance;
import com.centit.workflow.sample.po.WfFlowVariable;
import com.centit.workflow.sample.po.WfFlowVariableId;
import com.centit.workflow.sample.po.WfInstAttention;
import com.centit.workflow.sample.po.WfInstAttentionId;
import com.centit.workflow.sample.po.WfNode;
import com.centit.workflow.sample.po.WfNodeInstance;
import com.centit.workflow.sample.po.WfOrganize;
import com.centit.workflow.sample.po.WfOrganizeId;
import com.centit.workflow.sample.po.WfTeam;
import com.centit.workflow.sample.po.WfTeamId;
import com.centit.workflow.sample.po.WfTransition;

public class SampleFlowEngine implements FlowEngine, Serializable {

    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(SampleFlowEngine.class);
    private WfFlowInstanceDao flowInstanceDao;
    private WfNodeInstanceDao nodeInstanceDao;
    private WfNodeDao flowNodeDao;
    private WfTransitionDao flowTransitionDao;
    private WfActionTaskDao actionTaskDao;
    private WfActionLogDao actionLogDao;
    private WfFlowDefineDao flowDefDao;
    private WfTeamDao flowTeamDao;
    private WfOrganizeDao flowOrganizeDao;
    private WfFlowVariableDao flowVariableDao;
    private WfInstAttentionDao attentionDao;

    public void setFlowAttentionDao(WfInstAttentionDao flowAttentionDao) {
        attentionDao = flowAttentionDao;
    }

    public SampleFlowEngine() {
    }

    /**
     * 创建一个新的流程 同时创建第一个节点，并在活动日志中记录创建活动 判断创建权限可以在应用系统中做，如果在流程引擎中做就用开始节点的权限代替
     */

    @Override
    public WfFlowInstance createInstance(String flowCode, String flowOptName,
            String flowOptTag, String userCode, String unitCode) {
        return createInstInside(flowCode, flowOptName, flowOptTag, userCode,
                unitCode, 0, 0, false);
    }

    public WfFlowInstance createInstance(String flowCode, String flowOptName,
            String flowOptTag, long version, String userCode, String unitCode) {
        return createInstInside(flowCode, flowOptName, flowOptTag, version,
                userCode, unitCode, 0, 0, null, false);
    }

    public WfFlowInstance createInstanceLockFirstNode(String flowCode,
            String flowOptName, String flowOptTag, String userCode,
            String unitCode) {
        return createInstInside(flowCode, flowOptName, flowOptTag, userCode,
                unitCode, 0, 0, true);
    }

    @Override
    public void updateFlowInstOptInfo(long flowInstId, String flowOptName,
            String flowOptTag) {
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(flowInstId);
        if (flowInst == null)
            return;
        flowInst.setFlowOptName(flowOptName);
        flowInst.setFlowOptTag(flowOptTag);
        flowInstanceDao.saveObject(flowInst);
    }

    @Override
    public void updateFlowInstUnit(long flowInstId, String unitCode) {
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(flowInstId);
        if (flowInst == null)
            return;
        flowInst.setUnitCode(unitCode);
        flowInstanceDao.saveObject(flowInst);
    }

    @Override
    public void updateFlowInstParentNode(long flowInstId,
            long parentFlowInstId, long parentNodeInstId) {
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(flowInstId);
        if (flowInst == null)
            return;
        flowInst.setPreInstId(parentFlowInstId);
        flowInst.setPreNodeInstId(parentNodeInstId);
        flowInstanceDao.saveObject(flowInst);
    }

    public WfFlowInstance createInstanceLockFirstNode(String flowCode,
            String flowOptName, String flowOptTag, long version,
            String userCode, String unitCode) {
        return createInstInside(flowCode, flowOptName, flowOptTag, version,
                userCode, unitCode, 0, 0, null, true);
    }

    /**
     * 创建流程实例或子流程实例
     * 
     * @param flowCode
     *            流程编码
     * @param nodeInstId
     *            节点实例编号 ,节点编号不为0表示为子流程
     * @param userCode
     *            用户编码
     * @param unitCode
     *            机构编码
     * @return
     */
    private WfFlowInstance createInstInside(String flowCode,
            String flowOptName, String flowOptTag, long version,
            String userCode, String unitCode, long nodeInstId, long flowInstid,
            SysVariableTranslate varTrans, boolean lockFirstOpt) {

        Date createTime = new Date(System.currentTimeMillis());

        // 获取流程信息
        WfFlowDefine wf = flowDefDao.getFlowDefineByID(flowCode, version);

        // 获取流程实例编号
        Long flowInstId = flowInstanceDao.getNextFlowInstId();// update by ljy
        WfFlowInstance flowInst = SampleFlowUtils.createFlowInst(unitCode,
                userCode, wf, flowInstId);
        // flowInst.setFlowInstId(flowInstanceDao.getNextFlowInstId());
        flowInst.setCreateTime(createTime);

        // 节点实例编号不为空，为子流程，创建子流程时要给父节点的状态设置为 W：等待子流程返回
        if (nodeInstId != 0) {
            flowInst.setPreNodeInstId(nodeInstId);
            flowInst.setPreInstId(flowInstid);
            flowInst.setIsSubInst("Y");
        }
        flowInst.setFlowOptName(flowOptName);
        flowInst.setFlowOptTag(flowOptTag);
        // 生成首节点实例编号
        WfNode node = wf.getFirstNode();
        if (node == null)
            return null;

        WfNodeInstance nodeInst = SampleFlowUtils.createNodeInst(unitCode,
                userCode, flowInst, node, null);
        // 添加令牌算法 首节点的令牌为初始值 系统默认值
        // nodeInst.setRunToken("T");
        // 同步创建时间
        nodeInst.setNodeInstId(nodeInstanceDao.getNextNodeInstId());
        nodeInst.setCreateTime(createTime);

        // 创建节点操作日志 W:创建首节点
        WfActionLog wfactlog = SampleFlowUtils.createActionLog("W", userCode,
                nodeInst, node);
        wfactlog.setActionId(actionLogDao.getNextActionId());
        wfactlog.setActionTime(createTime);
        nodeInst.addWfActionLog(wfactlog);

        SysVariableTranslate flowVarTrans = new SampleFlowVariableTranslate(
                varTrans, null, nodeInst, flowInst);

        // 计算节点机构
        String nextNodeUnit = SysUnitFilterEngine.calcSingleUnitByExp(
                node.getUnitExp(),
                (String) null,
                unitCode == null ? CodeRepositoryUtil.getUserInfoByCode(
                        userCode).getPrimaryUnit() : unitCode, flowInst
                        .getNearestNodeUnitCode(nodeInst), flowInst
                        .getUnitCode(), flowVarTrans);
        nodeInst.setUnitCode(nextNodeUnit);
        // 如果锁定首节点只能有本人操作，则要在任务表中添加一条记录
        if (lockFirstOpt) {
            WfActionTask wfactTask = SampleFlowUtils.createActionTask(userCode,
                    nodeInst, node);
            wfactTask.setTaskId(actionTaskDao.getNextTaskId());
            wfactTask.setAssignTime(createTime);
            nodeInst.setTaskAssigned("T");
            nodeInst.addWfActionTask(wfactTask);
        } else {
            if ("en".equals(node.getRoleType())) {
                // 如果节点的角色类别为 权限引擎则要调用权限引擎来分配角色
                // 根据权限表达式创建任务列表
                Set<String> optUsers = SysUserFilterEngine.calcOptsByRoleExp(
                        node.getPowerExp(), (String) null,
                        unitCode == null ? CodeRepositoryUtil
                                .getUserInfoByCode(userCode).getPrimaryUnit()
                                : unitCode, flowInst
                                .getNearestNodeUnitCode(nodeInst),
                        nextNodeUnit, flowInst.getUnitCode(), flowInst
                                .getUserCode(), userCode, flowVarTrans);

                if (optUsers == null || optUsers.size() == 0)
                    log.error("权限引擎没有识别出符合表达式的操作人员！");
                else {
                    // if(optUsers != null && optUsers.size()>0){
                    nodeInst.setTaskAssigned("T");
                    for (String uc : optUsers) {
                        WfActionTask wfactTask = SampleFlowUtils
                                .createActionTask(uc, nodeInst, node);
                        wfactTask.setTaskId(actionTaskDao.getNextTaskId());
                        wfactTask.setAssignTime(createTime);
                        nodeInst.addWfActionTask(wfactTask);
                    }
                }
            }
        }
        flowInst.addWfNodeInstance(nodeInst);
        // 用AbstractTransactionalDataSourceSpringContextTests测试必需分别保存
        nodeInstanceDao.saveObject(nodeInst);
        flowInstanceDao.saveObject(flowInst);
        return flowInst;
    }

    private WfFlowInstance createInstInside(String flowCode,
            String flowOptName, String flowOptTag, String userCode,
            String unitCode, long nodeInstId, long flowInstid,
            boolean lockFirstOpt) {
        long version = flowDefDao.getLastVersion(flowCode);
        return createInstInside(flowCode, flowOptName, flowOptTag, version,
                userCode, unitCode, nodeInstId, flowInstid, null, lockFirstOpt);
    }

    public WfFlowInstance getFlowInstById(long flowInstId) {
        return flowInstanceDao.getObjectById(flowInstId);
    }

    public WfNodeInstance getNodeInstById(long nodeInstId) {
        return nodeInstanceDao.getObjectById(nodeInstId);
    }

    public FlowDescribe getFlowDefObject(String flowCode, long version) {
        try {
            return flowDefDao.getObjectById(new WfFlowDefineId(version,
                    flowCode));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取指定版本流程定义对象
     */
    public FlowDescribe getFlowDefObject(String flowCode) {
        long version = flowDefDao.getLastVersion(flowCode);
        return getFlowDefObject(flowCode, version);
    }

    /**
     * 根据节点ID获得节点定义
     * 
     * @param nodeId
     * @return
     */
    public FlowNodeInfo getNodeInfoById(long nodeId) {
        return flowNodeDao.getObjectById(nodeId);
    }

    private void endFlowInstance(WfFlowInstance flowInst, WfNode endNode,
            WfTransition trans, long preNodeInstId, String userCode,
            String unitCode) {
        SampleFlowUtils.endInstance(flowInst, "C", userCode, flowInstanceDao);

        WfNodeInstance endNodeInst = SampleFlowUtils.createNodeInst(unitCode,
                userCode, flowInst, endNode, trans);
        endNodeInst.setNodeInstId(nodeInstanceDao.getNextNodeInstId());
        endNodeInst.setNodeState("C");
        Date updateTime = DatetimeOpt.currentUtilDate();
        endNodeInst.setLastUpdateTime(updateTime);
        endNodeInst.setLastUpdateUser(userCode);
        endNodeInst.setPrevNodeInstId(preNodeInstId);
        endNodeInst.setTransId(trans.getTransid());

        flowInst.addWfNodeInstance(endNodeInst);
    }

    private Set<WfTransition> calcNextNodes(WfNode currNode,
            SysVariableTranslate varTrans) {
        List<WfTransition> transList = flowTransitionDao.getNodeTrans(currNode
                .getNodeId());
        Set<WfTransition> nextNodes = new HashSet<WfTransition>();
        if (transList == null)
            return nextNodes;
        if ("C".equals(currNode.getNodeType()) && transList.size() == 1) {
            nextNodes.add(transList.get(0));
            return nextNodes;
        }
        for (WfTransition trans : transList) {
            Formula fCalcCond = new Formula();
            fCalcCond.setVariableTranslate(varTrans);
            if (StringRegularOpt.isTrue(fCalcCond.calculate(trans
                    .getTranscondition()))) {
                // 保存目标节点实例
                nextNodes.add(trans);
                // D:分支节点 只能有一个出口
                if ("D".equals(currNode.getNodeType()))
                    break;
            }
        }
        return nextNodes;
    }

    private WfNodeInstance createNodeInside(WfNode nextNode,
            WfFlowInstance flowInst, WfNodeInstance nodeInst,
            WfTransition trans, String userCode, String unitCode,
            SysVariableTranslate varTrans, String nodeInstUnitCode,
            Map<Long, Set<String>> nodeOptUsers, ServletContext application) {
        Set<String> optUsers = null;
        long nextCode = nextNode.getNodeId();
        // 如果用户指定的节点对应的操作人员为空 则不创建这个节点
        //
        if (nodeOptUsers != null && nodeOptUsers.containsKey(nextCode)) {
            optUsers = nodeOptUsers.get(nextCode);
            // if(optUsers==null || optUsers.size()==0)
            // return null;
        }
        long lastNodeInstId = nodeInstanceDao.getNextNodeInstId();
        // 获取上一个相同节点实例机构
        String oldNodeInstUnitCode = null;
        WfNodeInstance oldNodeInst = flowInst.findLastSameNodeInst(nextCode,
                nodeInst, lastNodeInstId);
        if (oldNodeInst != null)
            oldNodeInstUnitCode = oldNodeInst.getUnitCode();
        // 调用机构引擎来计算 unitCode
        String nextNodeUnit = nodeInstUnitCode; // 如果指定机构 就不需要再进行计算了
        if (nextNodeUnit == null)
            nextNodeUnit = SysUnitFilterEngine.calcSingleUnitByExp(
                    nextNode.getUnitExp(),
                    oldNodeInstUnitCode,
                    unitCode == null ? CodeRepositoryUtil.getUserInfoByCode(
                            userCode).getPrimaryUnit() : unitCode,
                    flowInst.getNearestNodeUnitCode(nodeInst),
                    flowInst.getUnitCode(), varTrans);

        WfNodeInstance nextNodeInst = SampleFlowUtils.createNodeInst(
                nextNodeUnit, userCode, flowInst, nextNode, trans);

        nextNodeInst.setNodeInstId(lastNodeInstId);
        nextNodeInst.setPrevNodeInstId(nodeInst.getNodeInstId());
        nextNodeInst.setTransId(trans.getTransid());

        // 如果是 孤独的叶子节点，请将节点状态设置为 R 。这个令牌在流转中 已经没有意义，在提交时判断一下没有后续节点不报错就好了
        // if("T".equals( nextNode.getIsLeafNode() ))
        // nextNodeInst.setNodeState("R");

        // nextOptNodes.put(lastNodeInstId, nextNode);

        // 判断是否为子流程 A:一般 B:抢先机制 C:多人操作 S:子流程
        if ("S".equals(nextNode.getOptType())) {
            // 如果是子流程 启动流程
            nextNodeInst.setNodeState("W");
            // 子流程的机构 要和 节点的机构一致
            WfFlowInstance tempFlow = createInstInside(
                    nextNode.getSubFlowCode(), flowInst.getFlowOptName() + "--"
                            + nextNode.getNodeName(), flowInst.getFlowOptTag(),
                    userCode, nextNodeUnit, lastNodeInstId,
                    nodeInst.getFlowInstId(), false);
            nextNodeInst.setSubFlowInstId(tempFlow.getFlowInstId());
            // 子流程的时间限制和父流程节点的一致
            if (nextNodeInst.getTimeLimit() != null) {
                flowInst.setTimeLimit(nextNodeInst.getTimeLimit());
                flowInstanceDao.saveObject(flowInst);
            }
        } else {
            if (optUsers == null && "en".equals(nextNode.getRoleType())) {
                // 如果节点的角色类别为 权限引擎则要调用权限引擎来分配角色
                // 根据权限表达式创建任务列表
                optUsers = SysUserFilterEngine.calcOptsByRoleExp(nextNode
                        .getPowerExp(), oldNodeInstUnitCode,
                        unitCode == null ? CodeRepositoryUtil
                                .getUserInfoByCode(userCode).getPrimaryUnit()
                                : unitCode, flowInst
                                .getNearestNodeUnitCode(nodeInst),
                        nextNodeUnit, flowInst.getUnitCode(), flowInst
                                .getUserCode(), userCode, varTrans);
                if (optUsers == null || optUsers.size() == 0) {
                    log.error("权限引擎没有识别出符合表达式的操作人员！");
                }
            } else if (optUsers == null && "C".equals(nextNode.getOptType())) {
                // 多人任务,将符合条件的人添加到 工作任务列表中
                log.info("流程实例ID：" + nodeInst.getFlowInstId() + " 角色类别 ："
                        + nextNode.getRoleType() + " 角色代码 ："
                        + nextNode.getRoleCode());
                if ("bj".equals(nextNode.getRoleType())) {
                    optUsers = new HashSet<String>();
                    List<WfTeam> users = flowTeamDao.listFlowWorkTeamByRole(
                            nodeInst.getFlowInstId(), nextNode.getRoleCode());
                    for (WfTeam u : users)
                        optUsers.add(u.getUserCode());
                } else {
                    optUsers = SysUserFilterEngine.getUsersByRoleAndUnit(
                            nextNode.getRoleType(), nextNode.getRoleCode(),
                            nextNodeUnit);
                }
            }

            if (optUsers != null && optUsers.size() > 0) {
                Date createTime = new Date(System.currentTimeMillis());
                nextNodeInst.setTaskAssigned("T");
                for (String uc : optUsers) {
                    WfActionTask wfactTask = SampleFlowUtils.createActionTask(
                            uc, nextNodeInst, nextNode);
                    wfactTask.setTaskId(actionTaskDao.getNextTaskId());
                    wfactTask.setAssignTime(createTime);
                    nextNodeInst.addWfActionTask(wfactTask);
                }
            }
        }
        /**
         * 调用节点创建后事件
         */
        SampleFlowUtils.runAfterCreate(flowInst, nextNodeInst, nextNode,
                userCode, application);
        return nextNodeInst;
    }

    /*
     * 提交一个流程节点 根据条件选择路劲并创建下一个节点 如果是分支节点可能创建多个节点 如果是汇聚节点可能不创建节点
     * 如果下一个节点是介绍节点则介绍整个流程 记录提交日志，节点创建情况
     */
    private Set<Long> submitOptInside(long nodeInstId, String userCode,
            String grantorCode, String unitCode, boolean colseBranch,
            SysVariableTranslate varTrans, Map<Long, Set<String>> nodeUnits,
            Map<Long, Set<String>> nodeOptUsers, ServletContext application)
            throws WorkflowException {
        // 2012-04-16 重构提交事件，添加一个多实例节点类型，这个节点类型会根据不同的机构创建不同的节点
        // 根据上级节点实例编号获取节点所在父流程实例信息
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null) {
            log.error("找不到节点实例：" + nodeInstId);
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.NodeInstNotFound,
                    "找不到节点实例：" + nodeInstId);
        }
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());
        if (flowInst == null) {
            log.error("找不到流程实例：" + nodeInst.getFlowInstId());
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.FlowInstNotFound,
                    "找不到流程实例：" + nodeInst.getFlowInstId());
        }

        if ("P".equals(nodeInst.getIsTimer())) {
            log.error("流程节点处于暂停计时 状态：" + flowInst.getInstState() + "节点："
                    + nodeInstId);
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.PauseTimerNode,
                    "流程节点处于暂停计时 状态：" + flowInst.getInstState() + "节点："
                            + nodeInstId);
        }

        // 校验节点状态 流程和节点状态都要为正常
        if (!"N".equals(flowInst.getInstState())
                || (!"N".equals(nodeInst.getNodeState())
                        && !"W".equals(nodeInst.getNodeState()) // 等待子流程返回
                && !"R".equals(nodeInst.getNodeState()) // 游离节点
                )) {
            log.error("流程节点状态不正确，流程：" + nodeInst.getFlowInstId() + " 状态："
                    + flowInst.getInstState() + "节点：" + nodeInstId + " 状态："
                    + nodeInst.getNodeState());
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.IncorrectNodeState,
                    "流程节点状态不正确，流程：" + nodeInst.getFlowInstId() + " 状态："
                            + flowInst.getInstState() + "节点：" + nodeInstId
                            + " 状态：" + nodeInst.getNodeState());
        }
        String sGrantor = userCode;
        WfNode currNode = flowNodeDao.getObjectById(nodeInst.getNodeId());
        if (grantorCode == null || grantorCode.equals(userCode)) {
            sGrantor = actionTaskDao.getTaskGrantor(nodeInstId, userCode);
            // 哑元、自动执行以及子流程 不判断
            if (sGrantor == null && !"E".equals(currNode.getOptType())
                    && !"D".equals(currNode.getOptType())
                    && !"S".equals(currNode.getOptType())) {
                log.error("用户没有权限操作该节点：" + userCode + " -- " + nodeInstId);
                throw new WorkflowException(
                        WorkflowException.FlowExceptionType.WithoutPermission,
                        "用户没有权限操作该节点：" + userCode + " -- " + nodeInstId);
            }
        } else {
            sGrantor = grantorCode;
            if (!"E".equals(currNode.getOptType())
                    && !"D".equals(currNode.getOptType())
                    && !"S".equals(currNode.getOptType())
                    && !actionTaskDao.hasOptPower(nodeInstId, userCode,
                            grantorCode)) {
                log.error("用户没有权限操作该节点：" + userCode + " -- " + nodeInstId);
                throw new WorkflowException(
                        WorkflowException.FlowExceptionType.WithoutPermission,
                        "用户没有权限操作该节点：" + userCode + " -- " + nodeInstId);
            }
        }
        Date updateTime = DatetimeOpt.currentUtilDate();
        nodeInst.setLastUpdateTime(updateTime);
        nodeInst.setLastUpdateUser(userCode);

        // 创建节点提交日志 S:提交节点
        WfActionLog wfactlog = SampleFlowUtils.createActionLog("S", userCode,
                nodeInst, currNode);
        wfactlog.setActionId(actionLogDao.getNextActionId());
        wfactlog.setActionTime(updateTime);
        if (sGrantor != null && !sGrantor.equals(userCode)) {
            wfactlog.setGrantor(sGrantor);
        }
        nodeInst.addWfActionLog(wfactlog);

        // 多人操作节点 等待所有人都提交才可以提交
        if ("C".equals(currNode.getOptType())) {
            // 判断是否是多人操作，如果是多人操作，最后一个人提交才正在提交
            // 前面人提交只更改任务列表中的任务完成状态，多人操作一定要配合 流程活动任务单 工作
            // 这个任务可以是业务填写也可以是权限引擎填写
            int havnotSubmit = 0;
            for (WfActionTask task : nodeInst.getWfActionTasks()) {
                if ("T".equals(task.getIsvalid())
                        && "A".equals(task.getTaskState())
                        // 这个可能存在一个问题就是最后一个人没有提交，但是已经过期了，这个需要处理，需要在设置任务列表时注意
                        && (task.getExpireTime() == null || task
                                .getExpireTime().after(
                                        new Date(System.currentTimeMillis())))) {
                    if (/* userCode */sGrantor.equals(task.getUserCode())) {
                        // 任务的完成时间在任务的活动日志中
                        task.setTaskState("C");
                    } else
                        havnotSubmit++;
                }
            }

            if (havnotSubmit > 0) {
                nodeInstanceDao.saveObject(nodeInst);
                // flowInstanceDao.saveObject(flowInst);
                return null;
            }
        }
        /**
         * 节点提交前事件
         */
        SampleFlowUtils.runBeforeSubmit(flowInst, nodeInst, currNode, userCode,
                application);

        // 提交游离状态的节点， 孤独的叶子节点 将不会向后流转
        if ("R".equals(nodeInst.getNodeState())
                || "T".equals(currNode.getIsLeafNode())) {
            // log.info("游离节点:" + nodeInstId);
            // 将节点的状态设置为已完成
            nodeInst.setNodeState("C");
            nodeInstanceDao.saveObject(nodeInst);
            return null;
        }

        SampleFlowVariableTranslate flowVarTrans = new SampleFlowVariableTranslate(
                varTrans, flowVariableDao.listFlowVariables(flowInst
                        .getFlowInstId()), nodeInst, flowInst);

        flowVarTrans.setFlowOrganizes(this.viewFlowOrganize(flowInst
                .getFlowInstId()));

        // 获取下一批流转节点
        Set<WfTransition> nextNodes = calcNextNodes(currNode, flowVarTrans);
        if (nextNodes.size() == 0) {
            log.error("流程：" + nodeInst.getFlowInstId() + "节点：" + nodeInstId
                    + " " + currNode.getNodeName() + " 没有找到符合流转条件的后续节点。");
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.NotFoundNextNode, "流程："
                            + nodeInst.getFlowInstId() + "节点：" + nodeInstId
                            + " " + currNode.getNodeName()
                            + " 没有找到符合流转条件的后续节点。");
        }
        // 将节点的状态设置为已完成
        nodeInst.setNodeState("C");

        // 获取当前令牌
        String nodeType = currNode.getNodeType();
        if ( /* "C".equals(nodeType) && */nextNodes.size() > 1)
            nodeType = "H";

        String runToken = nodeInst.getRunToken();
        int nOutInd = 1;
        Map<Long, WfNode> nextOptNodes = new HashMap<Long, WfNode>();
        for (WfTransition trans : nextNodes) {
            long nextCode = trans.getEndnodeid();
            WfNode nextNode = flowNodeDao.getObjectById(nextCode);
            String nextNodeToken = runToken;
            if ("H".equals(nodeType)) {
                nextNodeToken = runToken + "." + nOutInd;
                nOutInd++;
            }
            if ("F".equals(nextNode.getNodeType())) {
                // 如果是最后一个节点，则要结束整个流程 调用 endInstance
                this.endFlowInstance(flowInst, nextNode, trans,
                        nodeInst.getNodeInstId(), userCode, unitCode);

                if ("Y".equals(flowInst.getIsSubInst())) {
                    // 如果该流程为子流程 则需要提交父节点 ，这边可能有多层循环嵌套
                    submitOpt(flowInst.getPreNodeInstId(), userCode, unitCode,
                            varTrans, application);
                }
                break;
            } else if ("G".equals(nextNode.getNodeType())) {
                // 获得用户指定的机构
                Set<String> nextNodeUnits = null;
                if (nodeUnits != null)
                    nextNodeUnits = nodeUnits.get(nextNode.getNodeId());
                if (nextNodeUnits == null)
                    nextNodeUnits = SysUnitFilterEngine.calcUnitsByExp(nextNode
                            .getUnitExp(), unitCode, CodeRepositoryUtil
                            .getUserInfoByCode(userCode).getPrimaryUnit(),
                            flowInst.getNearestNodeUnitCode(nodeInst), flowInst
                                    .getUnitCode(), flowVarTrans);
                int nc = 1;
                if (nextNodeUnits == null || nextNodeUnits.size() == 0) { // 至少创建一个实例
                    WfNodeInstance nextNodeInst = createNodeInside(nextNode,
                            flowInst, nodeInst, trans, userCode, unitCode,
                            flowVarTrans, null, null, application);
                    nextNodeInst.setRunToken(nextNodeToken + "." + nc);
                    nodeInstanceDao.saveObject(nextNodeInst);// 这个不保存
                                                             // 测试用例包不起来，正常运行好像没有问题
                    flowInst.addWfNodeInstance(nextNodeInst);
                    nextOptNodes.put(nextNodeInst.getNodeInstId(), nextNode);

                } else
                    for (String uc : nextNodeUnits) {
                        WfNodeInstance nextNodeInst = createNodeInside(
                                nextNode, flowInst, nodeInst, trans, userCode,
                                unitCode, flowVarTrans, uc, null, application);
                        // log.info("unitCode pramater:" +uc +" value：  "+
                        // nextNodeInst.getUnitCode());
                        nextNodeInst.setRunToken(nextNodeToken + "." + nc);
                        nc++;
                        nodeInstanceDao.saveObject(nextNodeInst);// 这个不保存
                                                                 // 测试用例包不起来，正常运行好像没有问题
                        flowInst.addWfNodeInstance(nextNodeInst);
                        nextOptNodes
                                .put(nextNodeInst.getNodeInstId(), nextNode);
                    }
            } else {
                // 判断是否为汇聚节点 ,汇聚节点需要等所有相关节点都提交了才可以提交
                if ("E".equals(nextNode.getNodeType())) {
                    int havnotCompleteNode = 0;
                    // 判断 其他并行节点是否完成
                    for (WfNodeInstance tNode : flowInst
                            .findSubNodeInstByToken(SampleFlowUtils
                                    .calcSuperToken(runToken))) {
                        if (!tNode.getNodeInstId().equals(nodeInstId)
                                && ("N".equals(tNode.getNodeState())
                                        || "W".equals(tNode.getNodeState()) || "S"
                                            .equals(tNode.getNodeState())
                                // || "R".equals( tNode.getNodestate()) R
                                // 为游离状态，并行时不考虑
                                ))
                            havnotCompleteNode++;
                    }
                    // 汇聚节点，还有节点没有提交
                    if (havnotCompleteNode > 0)
                        break;
                }
                /*
                 * 获得用户指定的机构
                 */
                Set<String> nextNodeUnits = null;
                if (nodeUnits != null)
                    nextNodeUnits = nodeUnits.get(nextNode.getNodeId());
                String nodeInstUnitCode = null;
                if (nextNodeUnits != null && nextNodeUnits.size() > 1)
                    nodeInstUnitCode = nextNodeUnits.iterator().next();

                WfNodeInstance nextNodeInst = createNodeInside(nextNode,
                        flowInst, nodeInst, trans, userCode, unitCode,
                        flowVarTrans, nodeInstUnitCode, nodeOptUsers,
                        application);
                if ("E".equals(nextNode.getNodeType()))
                    nextNodeInst.setRunToken(SampleFlowUtils
                            .calcSuperToken(nextNodeToken));
                else
                    nextNodeInst.setRunToken(nextNodeToken);
                nextOptNodes.put(nextNodeInst.getNodeInstId(), nextNode);
                nodeInstanceDao.saveObject(nextNodeInst);// 这个不保存
                                                         // 测试用例包不起来，正常运行好像没有问题
                flowInst.addWfNodeInstance(nextNodeInst);
            }
        }

        // 令牌算法 判断令牌冲突
        for (Map.Entry<Long, WfNode> nextOpt : nextOptNodes.entrySet()) {
            WfNodeInstance thisNodeInst = flowInst.getNodeInstanceById(nextOpt
                    .getKey());

            String thisToken = thisNodeInst.getRunToken();
            // 查找在同一条运行路径上的相同节点
            WfNodeInstance sameInst = flowInst.findLastSameNodeInst(
                    thisNodeInst.getNodeId(), thisNodeInst,
                    thisNodeInst.getNodeInstId());
            if (sameInst != null) {

                String sameToken = sameInst.getRunToken();
                // 如果发现令牌不一致，则要重新设定令牌，并将相关的分支节点设置为无效
                if (sameToken != null && !sameToken.equals(thisToken)) {
                    thisNodeInst.setRunToken(sameToken);
                    // 将相关的分支节点设置为无效
                    if (colseBranch) {
                        for (WfNodeInstance ni : flowInst
                                .findSubNodeInstByToken(sameToken)) {
                            if ("N".equals(ni.getNodeState())
                                    || "R".equals(ni.getNodeState())
                                    || "W".equals(ni.getNodeState())) {
                                if ("W".equals(ni.getNodeState())) { // 结束子流程
                                    WfFlowInstance subFlowInst = flowInstanceDao
                                            .getObjectById(ni
                                                    .getSubFlowInstId());
                                    if (subFlowInst != null) {
                                        SampleFlowUtils.endInstance(
                                                subFlowInst, "F", userCode,
                                                flowInstanceDao);
                                        subFlowInst.setLastUpdateUser(userCode);
                                        flowInstanceDao.saveObject(subFlowInst);
                                    }
                                }
                                ni.setNodeState("I");// 节点设置为无效
                                ni.setLastUpdateTime(updateTime);
                                ni.setLastUpdateUser(userCode);
                            }
                        }
                    }
                }
            }
        }

        flowInst.setLastUpdateTime(updateTime);
        flowInst.setLastUpdateUser(userCode);

        flowInstanceDao.saveObject(flowInst);

        Set<Long> nextNodeInsts = new HashSet<Long>();
        // 检查自动执行节点 并执行相关操作
        for (Map.Entry<Long, WfNode> nextOpt : nextOptNodes.entrySet()) {
            nextNodeInsts.add(nextOpt.getKey());
            WfNode autoNode = nextOpt.getValue();
            // 自动执行
            if ("D".equals(autoNode.getOptType())) {
                boolean needSubmit = SampleFlowUtils.runAutoOperator(flowInst,
                        flowInst.getNodeInstanceById(nextOpt.getKey()),
                        autoNode, userCode, application);
                if (needSubmit)
                    this.submitOpt(nextOpt.getKey(), userCode, unitCode,
                            varTrans, application);

            } else if ("E".equals(autoNode.getOptType())) { // 哑元节点 自动提交
                try {
                    this.submitOpt(nextOpt.getKey(), userCode, unitCode,
                            colseBranch, varTrans, application);
                } catch (WorkflowException e) {
                    log.error("自动提交哑元节点 " + nextOpt.getKey() + "后提交出错 。"
                            + e.getMessage());
                    throw e;
                }
            }
        }
        return nextNodeInsts;
    }

    public void disableOtherBranchNodes(long nodeInstId, String optUserCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null || !"N".equals(nodeInst.getNodeState())) {
            log.error("找不到节点实例：" + nodeInstId + "，或者实例不是正常状态的节点。");
            return;
        }
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());
        if (flowInst == null) {
            log.error("找不到流程实例：" + nodeInst.getFlowInstId());
            return;
        }
        Date updateTime = DatetimeOpt.currentUtilDate();
        // 一个分支只有一个活动节点
        for (WfNodeInstance ni : flowInst.getWfNodeInstances())
            if (ni.getNodeInstId() != nodeInstId
                    && ("N".equals(ni.getNodeState())
                            || "R".equals(ni.getNodeState()) || "W".equals(ni
                            .getNodeState()))) {
                if ("W".equals(ni.getNodeState())) { // 结束子流程
                    WfFlowInstance subFlowInst = flowInstanceDao
                            .getObjectById(ni.getSubFlowInstId());
                    if (subFlowInst != null) {
                        SampleFlowUtils.endInstance(subFlowInst, "F",
                                optUserCode, flowInstanceDao);
                        subFlowInst.setLastUpdateUser(optUserCode);
                        flowInstanceDao.saveObject(subFlowInst);
                    }
                }
                ni.setNodeState("I");// 节点设置为无效
                ni.setLastUpdateUser(optUserCode);
                ni.setLastUpdateTime(updateTime);
            }
        flowInst.setLastUpdateUser(optUserCode);
        flowInst.setLastUpdateTime(updateTime);
        flowInstanceDao.saveObject(flowInst);
    }

    @Override
    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans,
            ServletContext application) throws WorkflowException {
        return submitOptInside(nodeInstId, userCode, userCode, unitCode, true,
                varTrans, null, null, application);
    }

    @Override
    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String unitCode, boolean colseBranch,
            SysVariableTranslate varTrans, ServletContext application)
            throws WorkflowException {
        return submitOptInside(nodeInstId, userCode, userCode, unitCode,
                colseBranch, varTrans, null, null, application);
    }

    @Override
    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String grantorCode, String unitCode, boolean colseBranch,
            SysVariableTranslate varTrans, ServletContext application)
            throws WorkflowException {
        return submitOptInside(nodeInstId, userCode, grantorCode, unitCode,
                colseBranch, varTrans, null, null, application);
    }

    @Override
    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String grantorCode, String unitCode, SysVariableTranslate varTrans,
            ServletContext application) throws WorkflowException {
        return submitOptInside(nodeInstId, userCode, grantorCode, unitCode,
                true, varTrans, null, null, application);
    }

    public Set<Long> submitOptWithAssignUsers(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans,
            Map<Long, Set<String>> nodeOptUsers, ServletContext application)
            throws WorkflowException {
        return submitOptInside(nodeInstId, userCode, userCode, unitCode, true,
                varTrans, null, nodeOptUsers, application);
    }

    /**
     * 返回下一步节点的节点实例ID
     * 
     * @param nodeInstId
     *            当前节点实例编号
     * @param userCode
     *            操作用户编号
     * @param unitCode
     *            将下一步的节点指定一个所属机构，还要配合机构表达式使用，机构表达式要为 A
     * @param varTrans
     *            变量转换器
     * @param nodeOptUsers
     *            预设的节点操作用户
     * @return 节点实例编号列表
     */
    public Set<Long> submitOptWithAssignUnits(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans,
            Map<Long, Set<String>> nodeUnits, ServletContext application)
            throws WorkflowException {
        return submitOptInside(nodeInstId, userCode, userCode, unitCode, true,
                varTrans, nodeUnits, null, application);
    }

    @Override
    public void updateNodeInstUnit(long nodeInstId, String unitCode) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null)
            return;
        nodeInst.setUnitCode(unitCode);
        nodeInstanceDao.saveObject(nodeInst);
    }

    @Override
    public Set<FlowNodeInfo> viewNextNode(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans) {
        // 根据上级节点实例编号获取节点所在父流程实例信息
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null) {
            log.error("找不到节点实例：" + nodeInstId);
            return null;
        }
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());
        if (flowInst == null) {
            log.error("找不到流程实例：" + nodeInst.getFlowInstId());
            return null;
        }
        // 校验节点状态 流程和节点状态都要为正常
        if (!"N".equals(flowInst.getInstState())
                || (!"N".equals(nodeInst.getNodeState())
                        && !"W".equals(nodeInst.getNodeState()) && !"R"
                            .equals(nodeInst.getNodeState()))) {
            log.error("流程节点状态不正确，流程：" + nodeInst.getFlowInstId() + " 状态："
                    + flowInst.getInstState() + "节点：" + nodeInstId + " 状态："
                    + nodeInst.getNodeState());
            return null;
        }
        // 提交游离状态的节点。
        if ("R".equals(nodeInst.getNodeState())) {
            return null;
        }

        WfNode currNode = flowNodeDao.getObjectById(nodeInst.getNodeId());
        // 等待所有人都提交才可以提交
        if ("C".equals(currNode.getOptType())) {
            // 判断是否是多人操作，如果是多人操作，最后一个人提交才正在提交
            // 前面人提交只更改任务列表中的任务完成状态，多人操作一定要配合 流程活动任务单 工作
            // 这个任务可以是业务填写也可以是权限引擎填写
            int havnotSubmit = 0;
            for (WfActionTask task : nodeInst.getWfActionTasks()) {
                if ("T".equals(task.getIsvalid())
                        && "A".equals(task.getTaskState())
                        // 这个可能存在一个问题就是最后一个人没有提交，但是已经过期了，这个需要处理，需要在设置任务列表时注意
                        && (task.getExpireTime() == null || task
                                .getExpireTime().after(
                                        new Date(System.currentTimeMillis())))) {
                    if (!userCode.equals(task.getUserCode()))
                        havnotSubmit++;
                }
            }

            if (havnotSubmit > 0) {
                return null;
            }
        }

        // 获取下一批流转节点
        List<WfTransition> transList = flowTransitionDao.getNodeTrans(nodeInst
                .getNodeId());
        Set<FlowNodeInfo> nextNodes = new HashSet<FlowNodeInfo>();

        SysVariableTranslate flowVarTrans = new SampleFlowVariableTranslate(
                varTrans, flowVariableDao.listFlowVariables(flowInst
                        .getFlowInstId()), nodeInst, flowInst);

        for (WfTransition trans : transList) {
            // 生成目标节点实例编号
            Formula fCalcCond = new Formula();
            fCalcCond.setVariableTranslate(flowVarTrans);
            if (StringRegularOpt.isTrue(fCalcCond.calculate(trans
                    .getTranscondition()))) {
                // 保存目标节点实例
                long nextCode = trans.getEndnodeid();
                // 判断是否为 结束节点 A:开始 B:首节点 C:一般 D:分支 E:汇聚 F结束
                WfNode nextNode = flowNodeDao.getObjectById(nextCode);

                if (!"F".equals(nextNode.getNodeType())) {
                    // 判断是否为汇聚节点 ,汇聚节点需要等所有相关节点都提交了才可以提交
                    if ("E".equals(nextNode.getNodeType())) {
                        int havnotCompleteNode = 0;
                        for (WfNodeInstance tNode : flowInst
                                .getWfNodeInstances()) {
                            if (!tNode.getNodeInstId().equals(nodeInstId)
                                    && ("N".equals(tNode.getNodeState())
                                            || "W".equals(tNode.getNodeState()) || "S"
                                                .equals(tNode.getNodeState())
                                    // || "R".equals( tNode.getNodestate()) R
                                    // 为游离状态，并行时不考虑
                                    ))
                                havnotCompleteNode++;
                        }
                        // 汇聚节点，还有节点没有提交
                        if (havnotCompleteNode > 0)
                            break;
                    }

                    // 判断是否为子流程 A:一般 B:抢先机制 C:多人操作 S:子流程
                    nextNodes.add(nextNode);
                }
            }
        }
        return nextNodes;
    }

    @Override
    public Set<String> viewNextNodeOperator(long nextNodeId,
            long curNodeInstId, String userCode, String unitCode,
            SysVariableTranslate varTrans) {

        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(curNodeInstId);
        if (nodeInst == null) {
            log.error("找不到节点实例：" + curNodeInstId);
            return null;
        }
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());
        if (flowInst == null) {
            log.error("找不到流程实例：" + nodeInst.getFlowInstId());
            return null;
        }
        Set<String> optUsers = null;
        // 判断是否为 结束节点 A:开始 B:首节点 C:一般 D:分支 E:汇聚 F结束
        WfNode nextNode = flowNodeDao.getObjectById(nextNodeId);
        // 获取上一个相同节点实例机构
        String oldNodeInstUnitCode = null;
        WfNodeInstance oldNodeInst = flowInst.findLastSameNodeInst(nextNodeId,
                nodeInst, -1l);
        if (oldNodeInst != null)
            oldNodeInstUnitCode = oldNodeInst.getUnitCode();

        // 调用机构引擎来计算 unitCode
        String nextNodeUnit = SysUnitFilterEngine.calcSingleUnitByExp(
                nextNode.getUnitExp(),
                oldNodeInstUnitCode,
                unitCode == null ? CodeRepositoryUtil.getUserInfoByCode(
                        userCode).getPrimaryUnit() : unitCode, flowInst
                        .getNearestNodeUnitCode(nodeInst), flowInst
                        .getUnitCode(), null);

        SysVariableTranslate flowVarTrans = new SampleFlowVariableTranslate(
                varTrans, flowVariableDao.listFlowVariables(flowInst
                        .getFlowInstId()), nodeInst, flowInst);

        // 判断是否为子流程 A:一般 B:抢先机制 C:多人操作 S:子流程
        if (!"S".equals(nextNode.getOptType())) {
            if ("en".equals(nextNode.getRoleType())) {
                // 如果节点的角色类别为 权限引擎则要调用权限引擎来分配角色
                // 根据权限表达式创建任务列表
                optUsers = SysUserFilterEngine.calcOptsByRoleExp(nextNode
                        .getPowerExp(), oldNodeInstUnitCode,
                        unitCode == null ? CodeRepositoryUtil
                                .getUserInfoByCode(userCode).getPrimaryUnit()
                                : unitCode, flowInst
                                .getNearestNodeUnitCode(nodeInst),
                        nextNodeUnit, flowInst.getUnitCode(), flowInst
                                .getUserCode(), userCode, flowVarTrans);
            } else
                optUsers = SysUserFilterEngine.calcOptsByRoleExp(
                        "D(N)" + nextNode.getRoleType() + "('"
                                + nextNode.getRoleCode() + "')",
                        oldNodeInstUnitCode,
                        unitCode == null ? CodeRepositoryUtil
                                .getUserInfoByCode(userCode).getPrimaryUnit()
                                : unitCode, flowInst
                                .getNearestNodeUnitCode(nodeInst),
                        nextNodeUnit, flowInst.getUnitCode(), flowInst
                                .getUserCode(), userCode, flowVarTrans);
        }

        return optUsers;
    }

    @Override
    public String getTaskGrantor(long nodeInstId, String userCode) {
        return actionTaskDao.getTaskGrantor(nodeInstId, userCode);
    }

    @Override
    public void recordActionLog(long nodeInstId, String userCode,
            String actionType) {

        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null)
            return;

        String sGrantor = actionTaskDao.getTaskGrantor(nodeInstId, userCode);
        if (sGrantor == null) {
            log.error("用户没有权限操作该节点：" + userCode + " -- " + nodeInstId);
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.WithoutPermission,
                    "用户没有权限操作该节点：" + userCode + " -- " + nodeInstId);
        }

        if ("C".equals(actionType))
            nodeInst.setLastUpdateTime(new Date(System.currentTimeMillis()));
        WfActionLog wfActionLog = SampleFlowUtils.createActionLog(actionType,
                userCode, nodeInstId);
        wfActionLog.setActionId(actionLogDao.getNextActionId());
        if (!sGrantor.equals(userCode))
            wfActionLog.setGrantor(sGrantor);

        nodeInst.addWfActionLog(wfActionLog);
        nodeInstanceDao.saveObject(nodeInst);
    }

    public WfNodeInstance createNodeInst(long flowInstId, long curNodeInstId,
            long nodeId, String userCode, String unitCode, String nodeType) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(curNodeInstId);
        if (nodeInst == null) {
            log.error("找不到节点实例：" + curNodeInstId);
            return null;
        }
        WfFlowInstance flowInst = flowInstanceDao.getObjectById(nodeInst
                .getFlowInstId());
        if (flowInst == null) {
            log.error("找不到流程实例：" + nodeInst.getFlowInstId());
            return null;
        }
        WfNode nextNode = flowNodeDao.getObjectById(nodeId);
        // 获取上一个相同节点实例机构
        String oldNodeInstUnitCode = null;
        WfNodeInstance oldNodeInst = flowInst.findLastSameNodeInst(nodeId,
                nodeInst, -1l);
        if (oldNodeInst != null)
            oldNodeInstUnitCode = oldNodeInst.getUnitCode();
        String nextNodeUnit = SysUnitFilterEngine.calcSingleUnitByExp(
                nextNode.getUnitExp(),
                oldNodeInstUnitCode,
                unitCode == null ? CodeRepositoryUtil.getUserInfoByCode(
                        userCode).getPrimaryUnit() : unitCode, flowInst
                        .getNearestNodeUnitCode(nodeInst), flowInst
                        .getUnitCode(), null);
        long lastNodeInstId = nodeInstanceDao.getNextNodeInstId();

        WfNodeInstance nextNodeInst = SampleFlowUtils.createNodeInst(
                nextNodeUnit, userCode, flowInst, nextNode, null);

        nextNodeInst.setNodeInstId(lastNodeInstId);
        nextNodeInst.setPrevNodeInstId(curNodeInstId);
        nextNodeInst.setRunToken(nodeInst.getRunToken() + ".R");
        // nextNodeInst.setTransId(trans.getTransid());
        // 如果是 孤独的叶子节点，请讲节点状态设置为 R
        if ("T".equals(nextNode.getIsLeafNode()) || "R".equals(nodeType))
            nextNodeInst.setNodeState("R");
        nodeInstanceDao.saveObject(nextNodeInst);
        return nextNodeInst;
    }

    public void assignFlowWorkTeam(long flowInstId, String roleCode,
            String userCode) {
        Date assignDate = new Date(System.currentTimeMillis());
        flowTeamDao.saveObject(new WfTeam(flowInstId, userCode, roleCode,
                assignDate));
    }

    @Override
    public void assignFlowWorkTeam(long flowInstId, String roleCode,
            Set<String> userCodeSet) {
        Date assignDate = new Date(System.currentTimeMillis());
        if (userCodeSet != null)
            for (String usercode : userCodeSet)
                if (usercode != null && !"".equals(usercode))
                    flowTeamDao.saveObject(new WfTeam(flowInstId, usercode,
                            roleCode, assignDate));

    }

    public void deleteFlowWorkTeam(long flowInstId, String roleCode,
            String userCode) {
        flowTeamDao.deleteObjectById(new WfTeamId(flowInstId, userCode,
                roleCode));
    }

    @Override
    public void deleteFlowWorkTeam(long flowInstId, String roleCode) {
        flowTeamDao.deleteFlowWorkTeam(flowInstId, roleCode);
    }

    @Override
    public Map<String, Set<String>> viewFlowWorkTeam(long flowInstId) {
        List<WfTeam> users = flowTeamDao.listFlowWorkTeam(flowInstId);
        Map<String, Set<String>> team = new HashMap<String, Set<String>>();
        for (WfTeam user : users) {
            Set<String> us = team.get(user.getRoleCode());
            if (us == null)
                us = new HashSet<String>();
            us.add(user.getUserCode());
            team.put(user.getRoleCode(), us);
        }
        return team;
    }

    @Override
    public Set<String> viewFlowWorkTeam(long flowInstId, String roleCode) {
        List<WfTeam> users = flowTeamDao.listFlowWorkTeamByRole(flowInstId,
                roleCode);
        Set<String> us = new HashSet<String>();
        for (WfTeam user : users) {
            us.add(user.getUserCode());
        }
        return us;
    }

    @Override
    public void assignFlowOrganize(long flowInstId, String roleCode,
            String unitCode) {
        Date assignDate = new Date(System.currentTimeMillis());
        flowOrganizeDao.saveObject(new WfOrganize(flowInstId, unitCode,
                roleCode, assignDate));

    }

    @Override
    public void assignFlowOrganize(long flowInstId, String roleCode,
            Set<String> unitCodeSet) {
        Date assignDate = new Date(System.currentTimeMillis());
        if (unitCodeSet != null)
            for (String unitCode : unitCodeSet)
                if (unitCode != null && !"".equals(unitCode))
                    flowOrganizeDao.saveObject(new WfOrganize(flowInstId,
                            unitCode, roleCode, assignDate));
    }

    @Override
    public void deleteFlowOrganize(long flowInstId, String roleCode,
            String unitCode) {
        flowOrganizeDao.deleteObjectById(new WfOrganizeId(flowInstId, unitCode,
                roleCode));

    }

    @Override
    public void deleteFlowOrganize(long flowInstId, String roleCode) {
        flowOrganizeDao.deleteFlowOrganize(flowInstId, roleCode);
    }

    @Override
    public Map<String, Set<String>> viewFlowOrganize(long flowInstId) {
        List<WfOrganize> units = flowOrganizeDao.listFlowOrganize(flowInstId);
        Map<String, Set<String>> orgs = new HashMap<String, Set<String>>();
        for (WfOrganize unit : units) {
            Set<String> us = orgs.get(unit.getRoleCode());
            if (us == null)
                us = new HashSet<String>();
            us.add(unit.getUnitCode());
            orgs.put(unit.getRoleCode(), us);
        }
        return orgs;
    }

    @Override
    public Set<String> viewFlowOrganize(long flowInstId, String roleCode) {
        List<WfOrganize> units = flowOrganizeDao.listFlowOrganizeByRole(
                flowInstId, roleCode);
        Set<String> orgs = new HashSet<String>();
        for (WfOrganize unit : units) {
            orgs.add(unit.getUnitCode());
        }
        return orgs;
    }

    @Override
    public void saveFlowVariable(long flowInstId, String sVar, String sValue) {
        if (sValue == null) {
            flowVariableDao.deleteObjectById(new WfFlowVariableId(flowInstId,
                    "A", sVar));
        } else {
            WfFlowVariable varO = new WfFlowVariable(flowInstId, "A", sVar,
                    sValue, "S");
            flowVariableDao.saveObject(varO);
        }
    }

    @Override
    public void saveFlowNodeVariable(long nodeInstId, String sVar, String sValue) {

        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null) {
            log.error("找不到节点实例：" + nodeInstId);
            return;
        }

        if (sValue == null) {
            flowVariableDao.deleteObjectById(new WfFlowVariableId(nodeInst
                    .getFlowInstId(), nodeInst.getRunToken() == null ? "A"
                    : nodeInst.getRunToken(), sVar));
            return;
        }

        WfFlowVariable varO = new WfFlowVariable(nodeInst.getFlowInstId(),
                nodeInst.getRunToken() == null ? "A" : nodeInst.getRunToken(),
                sVar, sValue, "S");
        flowVariableDao.saveObject(varO);
    }

    @Override
    public void saveFlowVariable(long flowInstId, String sVar,
            Set<String> sValues) {
        if (sValues == null) {
            flowVariableDao.deleteObjectById(new WfFlowVariableId(flowInstId,
                    "A", sVar));
        } else {
            WfFlowVariable varO = new WfFlowVariable(flowInstId, "A", sVar,
                    WfFlowVariable.stringsetToString(sValues), "E");
            flowVariableDao.saveObject(varO);
        }
    }

    @Override
    public void saveFlowNodeVariable(long nodeInstId, String sVar,
            Set<String> sValues) {
        WfNodeInstance nodeInst = nodeInstanceDao.getObjectById(nodeInstId);
        if (nodeInst == null) {
            log.error("找不到节点实例：" + nodeInstId);
            return;
        }
        if (sValues == null) {
            flowVariableDao.deleteObjectById(new WfFlowVariableId(nodeInst
                    .getFlowInstId(), nodeInst.getRunToken() == null ? "A"
                    : nodeInst.getRunToken(), sVar));
            return;
        }
        WfFlowVariable varO = new WfFlowVariable(nodeInst.getFlowInstId(),
                nodeInst.getRunToken() == null ? "A" : nodeInst.getRunToken(),
                sVar, WfFlowVariable.stringsetToString(sValues), "E");
        flowVariableDao.saveObject(varO);
    }

    @Override
    public List<FlowVariable> listFlowVariables(long flowInstId) {
        List<WfFlowVariable> lv = flowVariableDao.listFlowVariables(flowInstId);
        if (lv == null)
            return null;
        return new ArrayList<FlowVariable>(lv);
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

    public void setActionTaskDao(WfActionTaskDao actionTaskDao) {
        this.actionTaskDao = actionTaskDao;
    }

    public void setActionLogDao(WfActionLogDao actionLogDao) {
        this.actionLogDao = actionLogDao;
    }

    public void setFlowDefDao(WfFlowDefineDao flowDefDao) {
        this.flowDefDao = flowDefDao;
    }

    public void setFlowTeamDao(WfTeamDao flowTeamDao) {
        this.flowTeamDao = flowTeamDao;
    }

    public void setFlowOrganizeDao(WfOrganizeDao flowOrganizeDao) {
        this.flowOrganizeDao = flowOrganizeDao;
    }

    public void setFlowVariableDao(WfFlowVariableDao flowVariableDao) {
        this.flowVariableDao = flowVariableDao;
    }

    @Override
    public void setFlowAttention(long flowInstId, String attUser, String optUser) {
        WfInstAttention attObj = new WfInstAttention(attUser, flowInstId,
                DatetimeOpt.currentUtilDate(), optUser);
        attentionDao.saveObject(attObj);
    }

    @Override
    public void deleteFlowAttention(long flowInstId, String attUser) {
        attentionDao
                .deleteObjectById(new WfInstAttentionId(attUser, flowInstId));
    }

    @Override
    public void deleteFlowAttention(long flowInstId) {
        attentionDao.deleteFlowAttention(flowInstId);
    }

    @Override
    public List<String> viewFlowAttention(long flowInstId) {
        List<WfInstAttention> attentions = attentionDao
                .listAttentionByFlowInstId(flowInstId);
        List<String> users = new ArrayList<String>();
        for (WfInstAttention att : attentions)
            users.add(att.getUserCode());
        return users;
    }

    public List<FlowVariable> viewFlowVariablesByVarname(long flowInstId,
            String varname) {
        List<WfFlowVariable> lv = flowVariableDao.viewFlowVariablesByVarname(
                flowInstId, varname);
        if (lv == null)
            return null;
        return new ArrayList<FlowVariable>(lv);
    }

}

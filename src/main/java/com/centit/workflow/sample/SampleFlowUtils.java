package com.centit.workflow.sample;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.centit.core.utils.WorkTimeSpan;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.workflow.FlowInstance;
import com.centit.workflow.NodeEventSupport;
import com.centit.workflow.NodeInstance;
import com.centit.workflow.WorkflowException;
import com.centit.workflow.sample.dao.WfFlowInstanceDao;
import com.centit.workflow.sample.po.WfActionLog;
import com.centit.workflow.sample.po.WfActionTask;
import com.centit.workflow.sample.po.WfFlowDefine;
import com.centit.workflow.sample.po.WfFlowInstance;
import com.centit.workflow.sample.po.WfFlowStage;
import com.centit.workflow.sample.po.WfManageAction;
import com.centit.workflow.sample.po.WfNode;
import com.centit.workflow.sample.po.WfNodeInstance;
import com.centit.workflow.sample.po.WfStageInstance;
import com.centit.workflow.sample.po.WfTransition;

public class SampleFlowUtils {
    private static final Log log = LogFactory.getLog(SampleFlowUtils.class);

    /**
     * 创建流程实例
     */
    public static WfFlowInstance createFlowInst(String unitcode,
            String usercode, WfFlowDefine wf, Long flowInstId) {
        WfFlowInstance flowInst = new WfFlowInstance();
        flowInst.setFlowInstId(flowInstId);
        flowInst.setFlowCode(wf.getFlowCode());
        flowInst.setVersion(wf.getVersion());
        flowInst.setUnitCode(unitcode);
        flowInst.setUserCode(usercode);
        flowInst.setPreNodeInstId(0l);
        flowInst.setPreInstId(0l);
        flowInst.setIsSubInst("N");
        flowInst.setInstState("N");
        flowInst.setCreateTime(new Date(System.currentTimeMillis()));
        String timeLimit = wf.getTimeLimit();
        flowInst.setIsTimer("F");
        // 创建 环节实例
        for (WfFlowStage wfStage : wf.getWfFlowStages()) {
            WfStageInstance stageInst = flowInst.newWfStageInstance();
            stageInst.setFlowInstId(flowInstId);
            stageInst.setStageCode(wfStage.getStageCode());
            stageInst.setStageId(wfStage.getStageId());
            stageInst.setPromiseTime(new WorkTimeSpan(timeLimit).toNumber());
            stageInst.setTimeLimit(stageInst.getPromiseTime());
            flowInst.addWfStageInstance(stageInst);
        }

        if (!StringBaseOpt.isNvl(timeLimit)) {
            // 不计时N、计时T(有期限)、暂停P 忽略(无期限) F
            flowInst.setIsTimer("T");
            flowInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber());
        } else
            flowInst.setTimeLimit(null);

        flowInst.setPromiseTime(flowInst.getTimeLimit());
        // flowInst.setExpireTime(new
        // Date(System.currentTimeMillis()+1000*60*60*24));
        return flowInst;
    }

    /**
     * 创建节点实例 同时生产创建节点日志 节点状体 N 正常/ R 运行/ C 完成/ S 挂起/ F 强行结束/ W 等待子流程返回
     */

    public static WfNodeInstance createNodeInst(String unitcode,
            String usercode, WfFlowInstance flowInst, WfNode node,
            WfTransition trans) {
        WfNodeInstance nodeInst = new WfNodeInstance();
        nodeInst.setFlowInstId(flowInst.getFlowInstId());
        Date updateTime = DatetimeOpt.currentUtilDate();
        nodeInst.setNodeId(node.getNodeId());
        nodeInst.setUnitCode(unitcode);
        nodeInst.setNodeState("N");
        // nodeInst.setIsTimer(isTimer);
        nodeInst.setTaskAssigned("F");
        // 给一个默认的令牌 T
        nodeInst.setRunToken("T");
        // nodeInst.setLastUpdateUser(usercode);
        nodeInst.setCreateTime(updateTime);
        // 计算节点的期限
        nodeInst.setIsTimer(node.getIsAccountTime());
        nodeInst.setTimeLimit(0L);
        // 计算节点的期限
        // I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限 cycle、H
        // 继承上一个节点剩余时间 hierarchical。
        if (trans == null || "I".equals(trans.getLimitType())) {
            String timeLimit = node.getTimeLimit();
            if ("C".equals(node.getLimitType())) {
                WfNodeInstance sameInst = flowInst.findLastSameNodeInst(
                        nodeInst.getNodeId(), nodeInst,
                        nodeInst.getNodeInstId());
                if (sameInst != null)
                    nodeInst.setTimeLimit(sameInst.getTimeLimit());
                else {
                    nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit)
                            .toNumber());
                }
            } else if ("F".equals(node.getLimitType())) {
                nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber());
            } else if ("H".equals(node.getLimitType())) { // 继承上个节点的剩余时间
                nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber()
                        + nodeInst.getTimeLimit());
            }
        } else {
            String timeLimit = trans.getTimeLimit();
            if ("C".equals(trans.getLimitType())) {
                WfNodeInstance sameInst = flowInst.findLastSameNodeInst(
                        nodeInst.getNodeId(), nodeInst,
                        nodeInst.getNodeInstId());
                if (sameInst != null)
                    nodeInst.setTimeLimit(sameInst.getTimeLimit());
                else {
                    nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit)
                            .toNumber());
                }
            } else if ("F".equals(trans.getLimitType())) {
                nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber());
            } else if ("H".equals(trans.getLimitType())) { // 继承上个节点的剩余时间
                nodeInst.setTimeLimit(new WorkTimeSpan(timeLimit).toNumber()
                        + nodeInst.getTimeLimit());
            }
        }

        nodeInst.setPromiseTime(nodeInst.getTimeLimit());

        // nodeInst.setLastUpdateTime(updateTime);
        return nodeInst;
    }

    /**
     * 创建任务实例
     */
    public static WfActionTask createActionTask(Long nodeInstId, String usercode) {
        WfActionTask task = new WfActionTask();
        task.setNodeInstId(nodeInstId);
        task.setIsvalid("T");
        task.setAssignTime(new Date(System.currentTimeMillis()));
        task.setUserCode(usercode);
        task.setTaskState("A");
        return task;
    }

    /**
     * 创建任务实例
     */
    public static WfActionTask createActionTask(String usercode,
            WfNodeInstance nodeInst, WfNode node) {
        WfActionTask actionTask = createActionTask(nodeInst.getNodeInstId(),
                usercode);
        actionTask.setRoleType(node.getRoleType());
        actionTask.setRoleCode(node.getRoleCode());
        // actionTask.setExpireTime(new
        // Date(System.currentTimeMillis()+1000*60*60*480));
        return actionTask;
    }

    /**
     * 创建日志实例 创建流程同时创建首节点 W 创建节点 C 更改数据 U 提交节点 S 挂起节点 A 唤醒节点 R 终止节点 E X
     * 唤醒一个超时流程的一个节点
     */
    public static WfActionLog createActionLog(String actType, String usercode,
            long nodeInstId) {
        WfActionLog actionLog = new WfActionLog();

        actionLog.setNodeInstId(nodeInstId);
        actionLog.setActionTime(new Date(System.currentTimeMillis()));
        actionLog.setActionType(actType);
        actionLog.setUserCode(usercode);
        return actionLog;
    }

    /**
     * 创建日志实例 创建流程同时创建首节点 W 创建节点 C 更改数据 U 提交节点 S 挂起节点 A 唤醒节点 R 终止节点 E X
     * 唤醒一个超时流程的一个节点
     */
    public static WfActionLog createActionLog(String actType, String usercode,
            long nodeInstId, WfNode node) {
        WfActionLog actionLog = createActionLog(actType, usercode, nodeInstId);

        actionLog.setRoleType(node.getRoleType());
        actionLog.setRoleCode(node.getRoleCode());

        return actionLog;
    }

    /**
     * 创建日志实例 创建流程同时创建首节点 W 创建节点 C 更改数据 U 提交节点 S 挂起节点 A 唤醒节点 R 终止节点 E X
     * 唤醒一个超时流程的一个节点
     */
    public static WfActionLog createActionLog(String actType, String usercode,
            WfNodeInstance nodeInst, WfNode node) {
        return createActionLog(actType, usercode, nodeInst.getNodeInstId(),
                node);
    }

    /**
     * 
     * @param flowInst
     *            流程实例
     * @param endType
     *            C 完成 F强制结束
     */
    public static void endInstance(WfFlowInstance flowInst, String endType,
            String userCode, WfFlowInstanceDao flowInstanceDao) {
        flowInst.setInstState(endType);
        Date updateTime = DatetimeOpt.currentUtilDate();
        flowInst.setLastUpdateTime(updateTime);
        flowInst.setLastUpdateUser(userCode);
        for (WfNodeInstance ni : flowInst.getWfNodeInstances()) {
            if ("N".equals(ni.getNodeState()) || "R".equals(ni.getNodeState())
                    || "W".equals(ni.getNodeState())) {
                if ("W".equals(ni.getNodeState())) { // 结束子流程
                    WfFlowInstance subFlowInst = flowInstanceDao
                            .getObjectById(ni.getSubFlowInstId());
                    if (subFlowInst != null) {
                        endInstance(subFlowInst, endType, userCode,
                                flowInstanceDao);
                        flowInstanceDao.saveObject(subFlowInst);
                    }
                }
                if ("F".equals(endType))
                    ni.setNodeState("F");// 因为流程被强制结束而被强制结束
                else
                    ni.setNodeState("E");// 因为流程完成而结束
                ni.setLastUpdateTime(updateTime);
                ni.setLastUpdateUser(userCode);
            }
        }
    }

    /**
     * 在保存之前，必需设置 actionid，这个主键 hibernate目前不会自动分配
     * 
     * @param flowInstId
     * @param managerCode
     * @param actionType
     *            S 挂起/ F 强行结束/ B 强行回退 / C 强行提交 / W 唤醒 / A分配任务 / D 删除任务 / P 禁用任务
     *            /R 重置节点 /E 设置任务期限 / Q 创建一个游离节点 / I 使失效 /X 超时唤醒 /i 是游离节点失效 / q
     *            是一个正常的节点并未游离状态 /N 创建（任意）指定节点
     * @return
     */
    public static WfManageAction createManagerAction(long flowInstId,
            String managerCode, String actionType) {
        WfManageAction action = new WfManageAction();
        action.setFlowInstId(flowInstId);
        action.setUserCode(managerCode);
        action.setActionType(actionType);
        action.setActionTime(new Date(System.currentTimeMillis()));

        return action;
    }

    /**
     * 计算一个令牌token的上层token
     * 
     * @param token
     * @return
     */
    public static String calcSuperToken(String token) {
        if (token == null)
            return null;
        int nPos = token.lastIndexOf('.');
        if (nPos < 0)
            return null;
        return token.substring(0, nPos);
    }

    public static void runAfterCreate(FlowInstance flowInst,
            NodeInstance nodeInst, WfNode nodeInfo, String optUserCode,
            ServletContext application) {
        if (nodeInfo.getOptBean() == null || "".equals(nodeInfo.getOptBean()))
            return;

        if (application == null)
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeWithoutApplcationContent,
                    "自动运行节点 " + nodeInst.getNodeInstId()
                            + "出错，传递的参数application为空");
        try {
            WebApplicationContext wac = WebApplicationContextUtils
                    .getWebApplicationContext(application);// 获取spring的context
            NodeEventSupport autoRun = (NodeEventSupport) wac.getBean(nodeInfo
                    .getOptBean());
            autoRun.runAfterCreate(flowInst, nodeInst, nodeInfo.getOptParam(),
                    optUserCode);
        } catch (BeansException e) {
            log.error("自动运行节点 " + nodeInst.getNodeInstId() + "出错，可能是bean:"
                    + nodeInfo.getOptBean() + " 找不到 。" + e.getMessage());
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeBeanNotFound,
                    "自动运行节点 " + nodeInst.getNodeInstId() + "出错，可能是bean:"
                            + nodeInfo.getOptBean() + " 找不到 。" + e.getMessage());
        }

    }

    public static void runBeforeSubmit(FlowInstance flowInst,
            NodeInstance nodeInst, WfNode nodeInfo, String optUserCode,
            ServletContext application) {
        if (nodeInfo.getOptBean() == null || "".equals(nodeInfo.getOptBean()))
            return;

        if (application == null)
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeWithoutApplcationContent,
                    "自动运行节点 " + nodeInst.getNodeInstId()
                            + "出错，传递的参数application为空");
        try {
            WebApplicationContext wac = WebApplicationContextUtils
                    .getWebApplicationContext(application);// 获取spring的context
            NodeEventSupport autoRun = (NodeEventSupport) wac.getBean(nodeInfo
                    .getOptBean());
            autoRun.runBeforeSubmit(flowInst, nodeInst, nodeInfo.getOptParam(),
                    optUserCode);
        } catch (BeansException e) {
            log.error("自动运行节点 " + nodeInst.getNodeInstId() + "出错，可能是bean:"
                    + nodeInfo.getOptBean() + " 找不到 。" + e.getMessage());
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeBeanNotFound,
                    "自动运行节点 " + nodeInst.getNodeInstId() + "出错，可能是bean:"
                            + nodeInfo.getOptBean() + " 找不到 。" + e.getMessage());
        }

    }

    /**
     * 
     * @param flowInstId
     * @param nodeInstId
     * @param nodeInfo
     * @param optUserCode
     * @param application
     * @return
     */
    public static boolean runAutoOperator(FlowInstance flowInst,
            NodeInstance nodeInst, WfNode nodeInfo, String optUserCode,
            ServletContext application) {
        boolean needSubmit = true;
        if (nodeInfo.getOptBean() == null || "".equals(nodeInfo.getOptBean()))
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeBeanNotFound,
                    "自动运行节点 " + nodeInst.getNodeInstId()
                            + "出错，流程设置时没有设置节点的自动运行bean属性。");
        if (application == null)
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeWithoutApplcationContent,
                    "自动运行节点 " + nodeInst.getNodeInstId()
                            + "出错，传递的参数application为空");
        try {
            WebApplicationContext wac = WebApplicationContextUtils
                    .getWebApplicationContext(application);// 获取spring的context
            NodeEventSupport autoRun = (NodeEventSupport) wac.getBean(nodeInfo
                    .getOptBean());
            needSubmit = autoRun.runAutoOperator(flowInst, nodeInst,
                    nodeInfo.getOptParam(), optUserCode);
        } catch (BeansException e) {
            log.error("自动运行节点 " + nodeInst.getNodeInstId() + "出错，可能是bean:"
                    + nodeInfo.getOptBean() + " 找不到 。" + e.getMessage());
            throw new WorkflowException(
                    WorkflowException.FlowExceptionType.AutoRunNodeBeanNotFound,
                    "自动运行节点 " + nodeInst.getNodeInstId() + "出错，可能是bean:"
                            + nodeInfo.getOptBean() + " 找不到 。" + e.getMessage());
        }
        return needSubmit;
    }

}

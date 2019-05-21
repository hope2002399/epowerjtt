package com.centit.workflow;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.centit.core.utils.PageDesc;
import com.centit.workflow.sample.po.VNodeInstDetail;
import com.centit.workflow.sample.po.VUserTaskList;
import com.centit.workflow.sample.po.WfTaskMove;

/**
 * 流程管理业务接口类 <流程终止，暂停，唤醒，回退等操作>
 * 
 * @author codefan
 * @version $Rev$ <br>
 *          $Id$
 */
public interface FlowManager {

    /**
     * 查看工作流程实例状态或进度
     * 
     * @param wfinstid
     * @return XML 描述的流程流转状态图
     */
    public String viewFlowInstance(long flowInstId);

    /**
     * 终止一个流程
     */
    public int stopInstance(long flowInstId, String mangerUserCode,
            String admindesc);

    /**
     * 流程超时挂起
     */
    public int expireInstance(long flowInstId);

    /**
     * 暂停一个流程
     */
    public int suspendInstance(long flowInstId, String mangerUserCode,
            String admindesc);

    /**
     * 使流程失效
     */
    public int invalidInstance(long flowInstId, String mangerUserCode,
            String admindesc);

    /**
     * 激活一个 挂起的或者无效的流程
     */
    public int activizeInstance(long flowInstId, String mangerUserCode,
            String admindesc);

    /**
     * 唤醒一个超时流程的一个节点
     */
    public long activizeExpireInstance(long flowInstId, String timeLimit,
            String mangerUserCode, String admindesc);

    /**
     * 回退操作-回退到上一个节点
     */
    public long rollbackOpt(long nodeInstId, String mangerUserCode);

    /**
     * 检查后续的节点是否被操作过，包括更新和提交 只有后续节点没有处理的才可以收回。true表示已经处理过，false表示没有处理过，
     * 
     * @param nodeInstId
     * @return
     */
    public boolean nodeCanBeReclaim(long nodeInstId);

    /**
     * 从这个节点重新运行该流程，包括已经结束的流程
     */
    public long resetFlowToThisNode(long nodeInstId, String mangerUserCode);

    /**
     * 强制一个并行分支的节点为游离状态，在提交其他并行分支前调用
     */
    public long forceDissociateRuning(long nodeInstId, String mangerUserCode);

    /**
     * 已游离状态创建一个节点副本
     */
    public long createDissociateNodeInst(long nodeInstId, String mangerUserCode);

    /**
     * 结束一个流程下的所有 游离节点
     * 
     * @param flowInstId
     * @param mangerUserCode
     * @return
     */
    public int stopDissociateNodeInst(long flowInstId, String mangerUserCode);

    /**
     * 节点超时挂起
     */
    public long expireNodeInstance(long nodeInstId);

    /**
     * 暂停流程的一个节点
     */
    public long suspendNodeInstance(long nodeInstId, String mangerUserCode);

    /**
     * 使流程的 挂起和失效的节点 正常运行
     */
    public long activizeNodeInstance(long nodeInstId, String mangerUserCode);

    /**
     * 唤醒一个超时流程的一个节点
     */
    public long activizeExpireNodeInstance(long nodeInstId, String timeLimit,
            String mangerUserCode);

    /**
     * 强制流转到下一结点，这个好像不好搞，主要是无法获得业务数据，只能提交没有分支的节点
     */
    public long forceCommit(long nodeInstId, String mangerUserCode);

    /**
     * 分配节点任务
     */
    public long assignTask(long nodeInstId, String userCode,
            String mangerUserCode, Date expiretime, String authDesc);

    /**
     * 取消节点任务
     */
    public int disableTask(long nodeInstId, String userCode,
            String mangerUserCode);

    /**
     * 删除节点任务
     */
    public int deleteTask(long nodeInstId, String userCode,
            String mangerUserCode);

    /**
     * 取消节点任务
     */
    public int disableTask(long taskInstId, String mangerUserCode);

    /**
     * 删除节点任务
     */
    public int deleteTask(long taskInstId, String mangerUserCode);

    /**
     * 设置任务期限
     */
    public int assignTaskExpireTime(long taskInstId, Date expiretime,
            String mangerUserCode);

    /**
     * 查找所有没有操作用户的节点
     * 
     * @return List<NodeInstance>
     */
    public List<NodeInstance> listNodesWithoutOpt();

    /**
     * 获取流程实例下的节点实例列表
     * 
     * @param wfinstid
     *            流程实例编号
     * @return List<NodeInstance>
     */
    public List<NodeInstance> listFlowInstNodes(long wfinstid);

    /**
     * 根据节点ID查询能够操作该节点的所有人员，如果为空，则需要分配工作任务单
     */
    public List<UserTask> listNodeTasks(long nodeInstId);

    /**
     * 获取节点实例的任务列表
     * 
     * @param nodeinstid
     * @return List<WfActionTask>
     */
    public List<ActionTask> listNodeActionTasks(long nodeinstid);

    /**
     * 删除节点实例的任务列表
     * 
     * @param nodeinstid
     * @param mangerUserCode
     *            管理人员代码
     * @return 删除的任务数量
     */
    public int deleteNodeActionTasks(long nodeinstid, String mangerUserCode);

    /**
     * 获取节点实例的操作日志列表
     * 
     * @param nodeinstid
     * @return List<WfActionLog>
     */
    public List<ActionLog> listNodeActionLogs(long nodeinstid);

    /**
     * 列举用户待办事项
     */
    public List<UserTask> listUserTasks(String userCode);

    /**
     * 用户待办列表分页查询
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<VUserTaskList> listUserTasks(Map<String, Object> filterMap,
            PageDesc pageDesc);

    /**
     * 列举用户已办事项
     */
    public List<NodeInstance> listUserCompleteTasks(
            Map<String, Object> filterMap, PageDesc pageDesc, String userCode);

    /**
     * 列举用户挂起的节点实例
     */
    public List<NodeInstance> listUserSuspendNodeInst(
            Map<String, Object> filterMap, PageDesc pageDesc);

    /**
     * 列举流程中所有可操作的节点
     * 
     * @param flowInstId
     * @return
     */
    public List<UserTask> listFlowTasks(long flowInstId);

    /**
     * 根据任务ID获得任务信息
     * 
     * @param taskId
     * @return
     */
    public ActionTask getActionTask(long taskId);

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
    public List<ActionLog> listUserActionLogs(String userCode,
            PageDesc pageDesc, Date lastTime);

    /**
     * 根据 示例ID获得实例
     * 
     * @param flowInstId
     * @return
     */
    public FlowInstance getFlowInstance(long flowInstId);

    /*
     * 获取系统中所有的流程实例，并按照时间倒序排序
     * 
     * @param pageDesc 和分页机制结合
     * 
     * @param includedCompleted 是否包含已经执行完成的 流程
     * 
     * @param filterByFlowCode null 不过滤，否则按照流程代码过滤
     * 
     * @param filterByUnitCode null 不过滤，否则 查找指定机构创建的流程
     * 
     * @param filterByUserCode null 不过滤，否则 查找指定用户创建的流程
     * 
     * @param lastTime if null return all
     * 
     * @return
     * 
     * public List<FlowInstance> listFlowInstance(PageDesc pageDesc ,boolean
     * includedCompleted, String filterByFlowCode ,String
     * filterByUnitCode,String filterByUserCode , Date lastTime );
     */
    /**
     * 获取用户参与 流程实例 按照时间倒序排列
     * 
     * @param userCode
     *            用户代码
     * @param pageDesc
     *            分页描述
     * @return
     */
    public List<FlowInstance> listUserAttachFlowInstance(String userCode,
            String flowPhase, Map<String, Object> filterMap, PageDesc pageDesc);

    /**
     * 获取系统中所有的流程实例
     * 
     * @param filterMap
     *            过滤条件
     * @param pageDesc
     *            分页描述
     * @return
     */
    public List<FlowInstance> listFlowInstance(Map<String, Object> filterMap,
            PageDesc pageDesc);

    /**
     * 查询流程实例操作日志
     * 
     * @param flowInstId
     * @return
     */
    public List<ManageActionLog> listManageActionLog(long flowInstId);

    /**
     * 判断一个用户是否可以处理指定的节点,可以喝submitOpt结合使用， 判断当前操作人员是否可以访问提交后的下一个节点。
     *
     * @param nodeInstId
     *            节点实例代码
     * @param userCode
     *            用户代码
     * @return
     */
    public boolean canAccess(long nodeInstId, String userCode);

    public String getTaskGrantor(long nodeInstId, String userCode);

    /**
     * 获取用户操作节点的Url，if ! canAccess rteurn null
     *
     * @param nodeInstId
     *            节点实例代码
     * @param userCode
     *            用户代码
     * @return
     */
    public String getNodeOptUrl(long nodeInstId, String userCode);

    /**
     * 获取用户操作节点的Url
     *
     * @param nodeInstId
     *            节点实例代码
     * @return
     */
    public String getNodeOptUrl(long nodeInstId);

    /**
     * 修改孤儿节点的所属机构
     * 
     * @param nodeInstId
     *            实例编号
     * @param unitCode
     *            机构编号
     */
    public void saveNodeInstUnit(long nodeInstId, String unitCode,
            String mangerUserCode);

    /**
     * 修改流程实例的所属机构
     * 
     * @param flowInstId
     *            实例编号
     * @param unitCode
     *            机构编号
     */
    public void saveFlowInstUnit(long flowInstId, String unitCode,
            String mangerUserCode);

    /**
     * 查询最后更改的节点
     * 
     * @param userCode
     * @param nodeState
     * @return
     */
    public List<NodeInstance> listLastUpdateNodeInst(String userCode,
            String nodeState);

    /**
     * 查询最后更改的流程
     * 
     * @param userCode
     * @param flowState
     * @return
     */
    public List<FlowInstance> listLastUpdateFlowInst(String userCode,
            String flowState);

    /**
     * 暂停节点定时
     * 
     * @param nodeInstId
     * @param mangerUserCode
     */
    public int suspendNodeInstTimer(long nodeInstId, String mangerUserCode);

    /**
     * 暂停流程定时
     * 
     * @param nodeInstId
     * @param mangerUserCode
     */
    public int suspendFlowInstTimer(long flowInstId, String mangerUserCode);

    /**
     * 唤醒节点定时
     * 
     * @param nodeInstId
     * @param mangerUserCode
     */
    public int activizeNodeInstTimer(long nodeInstId, String mangerUserCode);

    /**
     * 唤醒流程定时
     * 
     * @param nodeInstId
     * @param mangerUserCode
     */
    public int activizeFlowInstTimer(long flowInstId, String mangerUserCode);

    /**
     * 查询某人暂定计时的节点
     * 
     * @param userCode
     * @param isTimer
     * @return
     */
    public List<NodeInstance> listPauseTimerNodeInst(String userCode);

    /**
     * 查询某人暂定计时的流程
     * 
     * @param userCode
     * @param isTimer
     * @return
     */
    public List<FlowInstance> listPauseTimerFlowInst(String userCode);

    /**
     * 查询委托别人做的工作记录
     * 
     * @param userCode
     * @return
     */
    public List<ActionLog> listGrantorActionLog(String userCode,
            PageDesc pageDesc);

    /**
     * 查询受委托的工作记录
     * 
     * @param userCode
     * @return
     */
    public List<ActionLog> listGrantdedActionLog(String userCode,
            PageDesc pageDesc);

    /**
     * 迁移任务
     * 
     * @param taskMove
     */
    public void saveMoveTask(WfTaskMove taskMove);

    /**
     * 查询迁移任务记录
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<WfTaskMove> listMoveTask(Map<String, Object> filterMap,
            PageDesc pageDesc);

    /**
     * 创建某流程的任意节点
     * 
     * @param nodeId
     * @param flowInstId
     * @param unitCode
     * @param mangerUserCode
     * @return
     */
    public long createNodeInst(long nodeId, long flowInstId, String unitCode,
            String mangerUserCode);

    public VNodeInstDetail getVNodeInstDetailbyNode(Long nodeinstid);
}

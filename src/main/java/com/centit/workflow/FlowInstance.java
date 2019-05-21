package com.centit.workflow;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface FlowInstance {

    /**
     * 流程实例ID
     * 
     * @return
     */
    public Long getFlowInstId();

    /**
     * 获得流程编码
     * 
     * @return
     */
    public String getFlowCode();

    /**
     * 获得流程业务名称，这个值由创建流程时传给流程引擎
     * 
     * @return
     */
    public String getFlowOptName();

    /**
     * 获得流程业务标记，这个值由创建流程时传给流程引擎
     * 
     * @return
     */
    public String getFlowOptTag();

    /**
     * 获得流程名称
     * 
     * @return
     */
    public String getFlowName();

    /**
     * 获取当前步骤
     * 
     * @return
     */
    public String getCurStep();

    /**
     * 获得流程版本
     * 
     * @return
     */
    public Long getVersion();

    /**
     * 实例的创建时间
     * 
     * @return
     */
    public Date getCreateTime();

    /**
     * 实例承诺完成时间，期限
     * 
     * @return
     */
    public String getPromiseTimeStr();

    /**
     * 实例承诺完成时间，期限
     * 
     * @return
     */
    public Long getPromiseTime();

    /**
     * 实例预计完成时间，期限
     * 
     * @return
     */
    public Long getTimeLimit();

    /**
     * 实例预计完成时间，期限
     * 
     * @return
     */
    public String getTimeLimitStr();

    /**
     * 流程状态 N 正常/ R 运行(保留)/ C 完成/ S 挂起 / X 超时挂起expire / F 强行结束 /I 失效
     */
    public String getInstState();

    /**
     * 是否为子流程
     * 
     * @return
     */
    public boolean isSubFlow();

    /**
     * 父流程的实例编号
     * 
     * @return
     */
    public Long getPreInstId();

    /**
     * 对应父流程的节点编号
     * 
     * @return
     */
    public Long getPreNodeInstId();

    /**
     * 流程实例所属机构（可以为空）
     * 
     * @return
     */
    public String getUnitCode();

    /**
     * 流程实例创建人
     * 
     * @return
     */
    public String getUserCode();

    /**
     * 对应的业务名称
     * 
     * @return
     */
    public String getOptName();

    /**
     * 最后更新用户
     * 
     * @return
     */
    public String getLastUpdateUser();

    /**
     * 最后更新时间
     * 
     * @return
     */
    public Date getLastUpdateTime();

    /**
     * 获得所有流程节点
     * 
     * @return
     */
    public List<NodeInstance> getNodeInstances();

    /**
     * 获得所有当前活动流程节点
     * 
     * @return
     */
    public Set<NodeInstance> getActiveNodeInstances();

    /**
     * 不计时N、计时Y、暂停P
     * 
     * @return
     */
    public String getIsTimer();

    /**
     * 获得所有当前活动流程节点列表
     * 
     * @return
     */
    public List<NodeInstance> getActiveNodeList();

    /**
     * 获得流程的首节点
     * 
     * @return
     */
    public NodeInstance getFirstNodeInstance();

    /**
     * 根据流程节点Id获得节点实例
     * 
     * @param nodeInstId
     * @return
     */
    public NodeInstance getNodeInstanceById(long nodeInstId);

    /**
     * 获取节点的前一个可以回退的节点
     * 
     * @param thisNodeInstId
     * @return
     */
    public NodeInstance getPrevNodeInst(long thisNodeInstId);

    /**
     * 获得流程运行同一路径上，及流经过的子路径上的节点，
     * 
     * @param nodeInst
     * @return
     */
    public List<NodeInstance> getSameLevelNodeInstances(long nodeInstId);

    /**
     * 获得从首节点到本节点的所有节点
     * 
     * @param nodeInst
     * @return
     */
    public List<NodeInstance> getRunTraceNodeInstances(long nodeInstId);

    /**
     * 查找所有相同的节点的节点实例，如果本节点的机构不为空，还判断机构
     * 
     * @param nodeId
     *            原则和 nodeInstId 对应的节点的节点Id一致，但是thisNodeInstId 可以为空
     * @param nodeInst
     *            同一路径上的一个节点
     * @Param thisNodeInstId 排除的节点实例id，比如当前节点实例ID，也可以为0 即忽略 unitCode 机构代码，可以为空
     *        //用不着机构ID 应该根据令牌寻找同一条运行路径上的
     * @return
     */
    public List<NodeInstance> findSameNodeInsts(NodeInstance nodeInst);

    /**
     * 查找拥有相同的节点的最新节点实例，如果本节点的机构不为空，还判断机构
     * 
     * @param nodeId
     *            unitCode 机构代码，可以为空 //用不着机构ID 应该根据令牌寻找同一条运行路径上的
     * @Param thisNodeInstId 排除的节点实例id，比如当前节点实例ID，也可以为0 即忽略
     * @return
     */
    public NodeInstance findLastSameNodeInst(Long nodeId,
            NodeInstance nodeInst, Long thisNodeInstId);

    /**
     * 获得所有计时环节信息
     * 
     * @return
     */
    public List<StageInstance> getStageInstanceList();

    /**
     * 获得所有超时时环节信息
     * 
     * @return
     */
    public List<StageInstance> getExpiredStageInstanceList();

}

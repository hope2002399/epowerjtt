package com.centit.workflow;

import java.util.Date;

/**
 * create by scaffold
 * 
 * @author codefan@hotmail.com
 */

public interface UserTask {
    /**
     * 节点实例编号
     * 
     * @return
     */
    public Long getNodeInstId();

    /**
     * 流程实例编号
     * 
     * @return
     */
    public Long getFlowInstId();

    /**
     * 执行人
     * 
     * @return
     */
    public String getUserCode();

    /**
     * 执行人充当的角色类别
     * 
     * @return
     */
    public String getRoleType();

    /**
     * 执行人充当的角色代码
     * 
     * @return
     */
    public String getRoleCode();

    /**
     * 执行人获得这个权限的说明
     * 
     * @return
     */
    public String getAuthDesc();

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
     * 任务对应的节点名称
     * 
     * @return
     */
    public String getNodeName();

    /**
     * 任务对应的操作名
     * 
     * @return
     */
    public String getOptName();

    /**
     * 任务对应的操作方法名
     * 
     * @return
     */
    public String getOptMethod();

    /**
     * 任务对应的操作方法名称
     * 
     * @return
     */
    public String getMethodName();

    /**
     * 任务对应的操作url包括参数部分
     * 
     * @return
     */
    public String getNodeOptUrl();

    /**
     * 任务节点操作类别
     * 
     * @return A:一般 B:抢先机制 C:多人操作 S:子流程
     */
    public String getNodeOptType();

    /**
     * 任务节点类别
     * 
     * @return A:开始 B:首节点 C:一般 D:分支 E:汇聚 F结束
     */
    public String getNodeType();

    /**
     * 任务的操作说明
     * 
     * @return
     */
    public String getOptDesc();

    /**
     * 业务编码
     * 
     * @return
     */
    public String getOptCode();

    /**
     * 节点创建时间
     * 
     * @return
     */
    public Date getCreateTime();

    /**
     * 节点实例承诺完成时间，期限
     * 
     * @return
     */
    public String getPromiseTimeStr();

    /**
     * 节点实例承诺完成时间，期限
     * 
     * @return
     */
    public Long getPromiseTime();

    /**
     * 节点运行剩余时间，期限
     * 
     * @return
     */
    public Long getTimeLimit();

    /**
     * 节点运行剩余时间，期限
     * 
     * @return
     */
    public String getTimeLimitStr();

    /**
     * N：通知， O:不处理 ，X：挂起，E：终止（流程）， C：完成（强制提交,提交失败就挂起）
     * 
     * @return
     */
    public String getExpireOpt();

    /**
     * 流程节点阶段
     * 
     * @return
     */
    public String getFlowPhase();
}

package com.centit.workflow;

import java.util.Date;

public interface ActionLog {
    /**
     * 获取活动ID
     * 
     * @return
     */
    public Long getActionId();

    /**
     * 获取活动对应的节点id
     * 
     * @return
     */
    public Long getNodeInstId();

    /**
     * 获取活动 类别 创建流程同时创建首节点 W 创建节点 C 更改数据 U 提交节点 S 挂起节点 A 唤醒节点 R 终止节点 E
     */
    public String getActionType();

    /**
     * 获取活动 执行时间
     * 
     * @return
     */
    public Date getActionTime();

    /**
     * 获取活动参与人
     * 
     * @return
     */
    public String getUserCode();

    /**
     * 参与人角色类别
     * 
     * @return
     */
    public String getRoleType();

    /**
     * 参与人角色代码
     * 
     * @return
     */
    public String getRoleCode();

    /**
     * 任务委托人
     * 
     * @return
     */
    public String getGrantor();

}

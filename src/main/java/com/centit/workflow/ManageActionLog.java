package com.centit.workflow;

import java.util.Date;

public interface ManageActionLog {

    /**
     * 管理活动编号
     * 
     * @return
     */
    public Long getActionId();

    /**
     * 流程示例ID
     * 
     * @return
     */
    public Long getFlowInstId();

    /**
     * S 挂起/ F 强行结束/ B 强行回退 / C 强行提交 / W 唤醒 / A分配任务 / D 删除任务 / P 禁用任务 /R 重置节点 /E
     * 设置任务期限 /U unknown 未知
     * 
     * @return
     */
    public String getActionType();

    /**
     * 执行时间
     * 
     * @return
     */
    public Date getActionTime();

    /**
     * 执行人
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
     * 管理活动描述
     * 
     * @return
     */
    public String getAdminDesc();

}

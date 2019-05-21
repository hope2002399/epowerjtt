package com.centit.workflow;

import java.util.Date;

public interface ActionTask {

    /**
     * 任务ID
     * 
     * @return
     */
    public Long getTaskId();

    /**
     * 获取活动对应的节点id
     * 
     * @return
     */
    public Long getNodeInstId();

    /**
     * 任务分配时间
     * 
     * @return
     */
    public Date getAssignTime();

    /**
     * 任务过期时间
     * 
     * @return
     */
    public Date getExpireTime();

    /**
     * 任务分配的对象，责任人
     * 
     * @return
     */
    public String getUserCode();

    /**
     * 充当的角色类别，这个暂未使用
     * 
     * @return
     */
    public String getRoleType();

    /**
     * 充当的角色代码，这个暂未使用
     * 
     * @return
     */
    public String getRoleCode();

    /**
     * @return A:已分配 C：已完成（提交）
     */
    public String getTaskState();

    /**
     * 这个任务是否有效，需要和 expireTime配合使用
     * 
     * @return
     */
    public boolean isValid();

    /**
     * 分配任务时的备注
     * 
     * @return
     */
    public String getAuthDesc();

}

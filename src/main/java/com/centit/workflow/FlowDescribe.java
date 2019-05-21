package com.centit.workflow;

import java.util.Date;
import java.util.Set;

public interface FlowDescribe {
    /**
     * 获得流程编码
     * 
     * @return
     */
    public String getFlowCode();

    /**
     * 获得流程版本
     * 
     * @return
     */
    public Long getVersion();

    /**
     * 暂未使用
     * 
     * @return
     */
    public String getFlowClass();

    /**
     * 获得流程名称
     * 
     * @return
     */
    public String getFlowName();

    /**
     * A 草稿 B 正常 C 过期 D 禁用
     * 
     * @return wfstate
     */
    public String getFlowState();

    /**
     * 获得流程备注
     * 
     * @return
     */
    public String getFlowDesc();

    /**
     * 获取 流程的xml描述
     * 
     * @return
     */
    public String getFlowXmlDesc();

    /**
     * 获取流程 发布日期
     * 
     * @return
     */
    public Date getPublishDate();

    /**
     * 获取流程自动发布日期
     * 
     * @return
     */
    public Date getAtPublishDate();

    /**
     * 获取流程对应的业务ID
     * 
     * @return
     */
    public String getOptId();

    /**
     * 获取流程限制时间
     * 
     * @return
     */
    public String getTimeLimit();

    /**
     * 获取流程超期后处理方式
     * 
     * @return N：通知， O:不处理 ，X：挂起，E：终止（流程）
     */
    public String getExpireOpt();

    /**
     * 获取流程首节点
     * 
     * @return
     */
    public FlowNodeInfo getFirstNode();

    /**
     * 获取流程定义节点
     * 
     * @return
     */
    public Set<FlowNodeInfo> getFlowNodes();

    /**
     * 获取流程定义阶段
     * 
     * @return
     */
    public Set<FlowStage> getFlowStages();

}

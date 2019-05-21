package com.centit.workflow;

import java.util.List;
import java.util.Map;

import com.centit.workflow.sample.po.WfFlowDefine;

/**
 * 流程定义接口
 */
public interface FlowDefine {
    /**
     * 保存流程定义，内容为JS画的流程描述XML文件
     */
    boolean saveDraftFlowDef(FlowDescribe wfDef);

    /**
     * 获取保存的流程定义文件
     */
    public String getDraftFlowDef(String flowCode);

    /**
     * 发布流程，返回当前流程版本号
     */
    long publishFlowDef(String flowCode) throws Exception;

    /**
     * 获取指定版本流程定义描述文件
     */
    public String getFlowDef(String flowCode, long version);

    /**
     * 获取最新版本的流程定义描述文件
     */
    public String getFlowDef(String flowCode);

    /**
     * 禁用某个流程
     */
    void disableFlow(String flowCode);

    /**
     * 启用某个流程
     */
    void enableFlow(String flowCode);

    /**
     * 启用某个流程的其他字段
     */
    void saveFlow(WfFlowDefine wfDef);

    /**
     * 获取指定版本流程定义对象
     */
    public WfFlowDefine getFlowDefObject(String flowCode, long version);

    /**
     * 获取指定版本流程定义对象
     */
    public FlowDescribe getFlowDefObject(String flowCode);

    /**
     * 获取全部流程
     */
    public List<FlowDescribe> getAllFlows();

    /**
     * 获取全部最新版本流程
     */
    public List<FlowDescribe> listLastVersionFlow(Map<String, Object> filterMap);

    /**
     * 获取某个流程全部版本
     */
    public List<FlowDescribe> getFlowsByCode(String wfCode);

    /**
     * 获取新建流程的主键（流程代码）
     */
    public String getNextPrimarykey();

    public long getNextStageId();

    /**
     * 根据已知的流程业务，查询对应的定义流程
     * 
     * @param optId
     * @return
     */
    public List<FlowDescribe> getFlowsByOptId(String optId);

}

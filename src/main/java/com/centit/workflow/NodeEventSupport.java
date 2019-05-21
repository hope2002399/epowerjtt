package com.centit.workflow;

/**
 * 
 * TODO 节点事件接口
 * 
 * @author codefan
 * @create 2013-7-10
 * @version
 */
public interface NodeEventSupport {
    /**
     * 在节点创建后的调用的的事件
     * 
     * @param flowInstId
     *            流程实例
     * @param nodeInstId
     *            节点实例
     * @param optParam
     *            用户自定义操作参数
     * @param optUserCode
     *            当前操作用户
     */
    void runAfterCreate(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode);

    /**
     * 在节点提交前的调用的的事件
     * 
     * @param flowInstId
     *            流程实例
     * @param nodeInstId
     *            节点实例
     * @param optParam
     *            用户自定义操作参数
     * @param optUserCode
     *            当前操作用户
     */

    void runBeforeSubmit(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode);

    /**
     * 自动运行节点所指向的spring bean需要实现这个接口
     * 
     * @param flowInstId
     *            流程实例
     * @param nodeInstId
     *            节点实例
     * @param optParam
     *            用户自定义操作参数
     * @param optUserCode
     *            当前操作用户
     * @return true 需要运行后需要调用自动提交，false 则不需要，一般在函数内部已经调用submitNode
     */
    boolean runAutoOperator(FlowInstance flowInst, NodeInstance nodeInst,
            String optParam, String optUserCode);
}

package com.centit.workflow;

public class WorkflowException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public static enum FlowExceptionType {
        NodeInstNotFound, // 找不到节点实例
        FlowInstNotFound, // 找不到流程实例
        IncorrectNodeState, // 流程节点状态不正确
        PauseTimerNode, // 暂停计时节点不能提交
        WithoutPermission, // 没有权限
        NotFoundNextNode, // 找不到符合流转条件的后续节点
        AutoRunNodeWithoutApplcationContent, // 自动运行节点出错，传递的参数application为空
        AutoRunNodeBeanNotFound; // 自动运行节点 出错，可能是设置bean找不到
    };

    private FlowExceptionType exceptionType;

    public WorkflowException(FlowExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public FlowExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(FlowExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

}

package com.centit.workflow;

public interface FlowNodeInfo {
    String getIsLeafNode();

    String getNodeDesc();

    /**
     * 节点ID
     * 
     * @return
     */
    Long getNodeId();

    /**
     * 节点名
     * 
     * @return
     */
    String getNodeName();

    /**
     * 节点类型
     * 
     * @return
     */
    String getNodeType();

    String getOptBean();

    /**
     * 操作代码
     * 
     * @return
     */
    String getOptCode();

    String getOptParam();

    String getOptType();

    String getPowerExp();

    String getRoleCode();

    String getRoleType();

    String getSubFlowCode();

    /**
     * 期限类别 I ： 未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限
     * cycle、H 继承上一个节点剩余时间 hierarchical。
     * 
     * @return
     */
    public String getLimitType();

    String getTimeLimit();

    String getUnitExp();

    Long getVersion();

    String getFlowCode();

    String getExpireOpt();
}

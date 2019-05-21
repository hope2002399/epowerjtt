/**
 * 
 */
package com.centit.workflow;

public interface AttachFlow {
    /**
     * 流程实例编号
     * 
     * @return
     */
    public long getFlowInstId();

    /**
     * 用户编码
     * 
     * @return
     */
    public String getUserCode();
}

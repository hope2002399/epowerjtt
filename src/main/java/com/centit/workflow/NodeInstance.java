package com.centit.workflow;

import java.util.Date;
import java.util.List;

public interface NodeInstance {
    /**
     * 节点实例编号
     * 
     * @return
     */
    public Long getNodeInstId();

    /**
     * 所属流程实例编号
     * 
     * @return
     */
    public Long getFlowInstId();

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
     * 对应的节点编号
     * 
     * @return
     */
    public Long getNodeId();

    /**
     * 对应的节点名称
     * 
     * @return
     */
    public String getNodeName();

    /**
     * 节点创建时间
     * 
     * @return
     */
    public Date getCreateTime();

    /**
     * 节点最后更改时间，不包括提交时间
     * 
     * @return
     */
    public Date getLastUpdateTime();

    /**
     * 最后更新用户
     * 
     * @return
     */
    public String getLastUpdateUser();

    /**
     * 上一个节点实例
     * 
     * @return
     */
    public Long getPrevNodeInstId();

    /**
     * 不计时N、计时Y
     */
    public String getIsTimer();

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
     * expireOptSign == 0未处理 1 已通知 ,2..6 已通知2..5次（暂时不启动重复通知）6:不处理 7：已挂起 8 已终止 9
     * 已完成
     * 
     * @return
     */
    public Long getExpireOptSign();

    /**
     * N 正常/ R 游离状态 / C 完成/ S 挂起 / X 超时挂起eXpire / D 强制提交 /B 已回退 /E 因为流程完成而结束 / F
     * 被强制结束 / W 等待子流程返回 / I 无效
     */
    public String getNodeState();

    /**
     * 节点子流程实例编号
     * 
     * @return
     */
    public Long getSubFlowInstId();

    /**
     * 节点所属机构（如果有）
     * 
     * @return
     */
    public String getUnitCode();

    /**
     * 流入该节点时应用的流转路径
     * 
     * @return
     */
    public Long getTransId();

    /**
     * 节点是否认为的指定具体的执行人员
     * 
     * @return
     */
    public boolean isTaskAssign();

    /**
     * 获得节点的运行令牌
     * 
     * @return
     */
    public String getRunToken();

    /**
     * 角色类型
     * 
     * @return
     */
    public String getRoleType();

    /**
     * 角色代码
     * 
     * @return
     */
    public String getRoleCode();

    /**
     * 节点任务，回收状态,(yes可回收，no,不可回收)
     * 
     * @return
     */
    public String getIsRecycle();

    /**
     * 挂起事项办理链接
     * 
     * @return
     */
    public String getNodeOptUrl();

    /**
     * N节点当前办理人
     * 
     * @return
     */
    public List<String> getTrainsUsers();

}

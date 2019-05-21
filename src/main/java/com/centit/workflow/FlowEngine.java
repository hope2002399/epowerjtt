package com.centit.workflow;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import com.centit.sys.service.SysVariableTranslate;

/**
 * 流程运行接口
 */
public interface FlowEngine {
    /**
     * 创建流程实例 返回流程实例
     * 
     * @param flowCode
     *            流程编码
     * @param flowOptName
     *            这个名称用户 查找流程信息
     * @param flowOptTag
     *            这个标记用户 查找流程信息，比如办件代码，有业务系统自己解释
     * @param userCode
     *            创建用户
     * @param unitCode
     *            将流程指定一个所属机构
     * @return
     */
    public FlowInstance createInstance(String flowCode, String flowOptName,
            String flowOptTag, String userCode, String unitCode);

    /**
     * 创建流程实例 返回流程实例
     * 
     * @param flowCode
     *            流程编码
     * @param flowOptName
     *            这个名称用户 查找流程信息
     * @param flowOptTag
     *            这个标记用户 查找流程信息，比如办件代码，有业务系统自己解释
     * @param userCode
     *            创建用户
     * @param unitCode
     *            将流程指定一个所属机构
     * @return
     */
    public FlowInstance createInstance(String flowCode, String flowOptName,
            String flowOptTag, long version, String userCode, String unitCode);

    /**
     * 创建流程实例并锁定首节点，首节点只能有创建人操作 返回流程实例
     * 
     * @param flowCode
     *            流程编码
     * @param flowOptName
     *            这个名称用户 查找流程信息
     * @param flowOptTag
     *            这个标记用户 查找流程信息，比如办件代码，有业务系统自己解释
     * @param userCode
     *            创建用户
     * @param unitCode
     *            将流程指定一个所属机构
     * @return
     */
    public FlowInstance createInstanceLockFirstNode(String flowCode,
            String flowOptName, String flowOptTag, String userCode,
            String unitCode);

    /**
     * 创建流程实例并锁定首节点，首节点只能有创建人操作 返回流程实例
     * 
     * @param flowCode
     *            流程编码
     * @param flowOptName
     *            这个名称用户 查找流程信息
     * @param flowOptTag
     *            这个标记用户 查找流程信息，比如办件代码，有业务系统自己解释
     * @param userCode
     *            创建用户
     * @param unitCode
     *            将流程指定一个所属机构
     * @return
     */
    public FlowInstance createInstanceLockFirstNode(String flowCode,
            String flowOptName, String flowOptTag, long version,
            String userCode, String unitCode);

    /**
     * 更改流程业务信息
     * 
     * @param flowInstId
     *            流程实例ID
     * @param flowOptName
     *            这个名称用户 查找流程信息
     * @param flowOptTag
     *            这个标记用户 查找流程信息，比如办件代码，有业务系统自己解释
     */
    public void updateFlowInstOptInfo(long flowInstId, String flowOptName,
            String flowOptTag);

    /**
     * 更改流程所属机构
     * 
     * @param flowInstId
     *            流程实例ID
     * @param unitCode
     *            机构代码
     */
    public void updateFlowInstUnit(long flowInstId, String unitCode);

    /**
     * 更改流程的父节点，一般只对子流程有用，当然用户也可以手动设定父流程节点
     * 
     * @param flowInstId
     *            子流程实例id
     * @param parentFlowInstId
     *            父流程实例id
     * @param parentNodeInstId
     *            父流程节点实例id
     */
    public void updateFlowInstParentNode(long flowInstId,
            long parentFlowInstId, long parentNodeInstId);

    /*
     * 创建子流程实例 返回流程实例号 子流程由内部创建不需要提供接口 public long createInstance(String
     * flowCode,long nodeInstId,String userCode,String unitCode);
     */
    /**
     * 关闭本节点分支以外的其他分支的所有节点
     * 
     * @param nodeInstId
     *            当前活动节点
     */
    public void disableOtherBranchNodes(long nodeInstId, String optUserCode);

    /**
     * 返回下一步节点的节点实例ID
     * 
     * @param nodeInstId
     *            当前节点实例编号
     * @param userCode
     *            操作用户编号 对应用户表达式 O operator
     * @param unitCode
     *            用户机构，如果为空系统会自动负责为 操作用户的主机构，机构表达式要为 U
     * @param varTrans
     *            变量转换器
     * @return 节点实例编号列表
     */
    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans,
            ServletContext application) throws WorkflowException;

    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String unitCode, boolean colseBranch,
            SysVariableTranslate varTrans, ServletContext application)
            throws WorkflowException;

    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String grantorCode, String unitCode, SysVariableTranslate varTrans,
            ServletContext application) throws WorkflowException;

    public Set<Long> submitOpt(long nodeInstId, String userCode,
            String grantorCode, String unitCode, boolean colseBranch,
            SysVariableTranslate varTrans, ServletContext application)
            throws WorkflowException;

    /**
     * 返回下一步节点的节点实例ID
     * 
     * @param nodeInstId
     *            当前节点实例编号
     * @param userCode
     *            操作用户编号 对应用户表达式 O operator
     * @param unitCode
     *            用户机构，如果为空系统会自动负责为 操作用户的主机构，机构表达式要为 U
     * @param varTrans
     *            变量转换器
     * @param nodeOptUsers
     *            预设的节点操作用户
     * @return 节点实例编号列表
     */
    public Set<Long> submitOptWithAssignUsers(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans,
            Map<Long, Set<String>> nodeOptUsers, ServletContext application)
            throws WorkflowException;

    /**
     * 返回下一步节点的节点实例ID
     * 
     * @param nodeInstId
     *            当前节点实例编号
     * @param userCode
     *            操作用户编号 对应用户表达式 O operator
     * @param unitCode
     *            用户机构，如果为空系统会自动负责为 操作用户的主机构，机构表达式要为 U
     * @param varTrans
     *            变量转换器
     * @param nodeUnits
     *            预设的节点机构
     * @return 节点实例编号列表
     */
    public Set<Long> submitOptWithAssignUnits(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans,
            Map<Long, Set<String>> nodeUnits, ServletContext application)
            throws WorkflowException;

    /**
     * 更改节点所属机构
     * 
     * @param nodeInstId
     *            节点实例ID
     * @param unitCode
     *            机构代码
     */
    public void updateNodeInstUnit(long nodeInstId, String unitCode);

    /**
     * 提交节点工作 是否成功 预判下一步节点的节点编号
     * 
     * @param nodeInstId
     *            当前节点实例编号
     * @param userCode
     *            操作用户编号 对应用户表达式 O operator
     * @param unitCode
     *            用户机构，如果为空系统会自动负责为 操作用户的主机构，机构表达式要为 U
     * @param varTrans
     *            变量转换器
     * @return 节点信息列表
     */
    public Set<FlowNodeInfo> viewNextNode(long nodeInstId, String userCode,
            String unitCode, SysVariableTranslate varTrans);

    /**
     * 查看下一节点可以操作的人员类表
     * 
     * @param nextNodeId
     *            下一个节点编号
     * @param curNodeInstId
     *            当前节点实例编号
     * @param userCode
     *            操作用户编号 对应用户表达式 O operator
     * @param unitCode
     *            用户机构，如果为空系统会自动负责为 操作用户的主机构，机构表达式要为 U
     * @param varTrans
     *            变量转换器
     * @return
     */
    public Set<String> viewNextNodeOperator(long nextNodeId,
            long curNodeInstId, String userCode, String unitCode,
            SysVariableTranslate varTrans);

    /**
     * 获取任务授权人，如果是用户自己的任务，范围自己，否则返回授权人
     * 
     * @param nodeInstId
     * @param userCode
     * @return
     */
    public String getTaskGrantor(long nodeInstId, String userCode);

    /**
     * 流程节点操作日志
     * 
     * @param nodeInstId
     *            节点实例编号
     * @param userCode
     *            用户编码
     * @param actionType
     *            操作类型: W 创建流程同时创建首节点 C 创建节点 U 更改数据 S 提交节点 A 挂起节点 R 唤醒节点 E 终止节点
     *            X 唤醒超时节点
     */
    public void recordActionLog(long nodeInstId, String userCode,
            String actionType);

    /*
     * 结束流程 这个也是一个内部函数不需要 提供接口， 系统在 Manager接口中提供管理接口 public void
     * endInstance(long flowId, String userCode);
     */

    /**
     * 根据流程编号获得流程实例
     * 
     * @param flowinstid
     * @return
     */
    public FlowInstance getFlowInstById(long flowInstId);

    /**
     * 根据节点实例号 获得节点实例
     * 
     * @param nodeInstId
     * @return
     */
    public NodeInstance getNodeInstById(long nodeInstId);

    /**
     * 获取指定版本流程定义对象
     */
    public FlowDescribe getFlowDefObject(String flowCode, long version);

    /**
     * 获取最新版本流程定义对象
     */
    public FlowDescribe getFlowDefObject(String flowCode);

    /**
     * 根据节点ID获得节点定义
     * 
     * @param nodeId
     * @return
     */
    public FlowNodeInfo getNodeInfoById(long nodeId);

    /**
     * 用户手动创建一个节点实例
     * 
     * @param flowInstId
     *            流程实例号
     * @param curNodeInstId
     *            当前节点实例号
     * @param nodeId
     *            节点号
     * @param userCode
     *            指定用户
     * @param unitCode
     *            指定机构
     * @param nodeType
     *            节点类型 R游离节 N正常节点
     * @return 节点实例
     */
    public NodeInstance createNodeInst(long flowInstId, long curNodeInstId,
            long nodeId, String userCode, String unitCode, String nodeType);

    /**
     * 分配工作小组 --办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            办件角色 不能为空
     * @param userCode
     *            用户代码，添加
     * @return
     */
    public void assignFlowWorkTeam(long flowInstId, String roleCode,
            String userCode);

    /**
     * 分配工作小组 --办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            办件角色 不能为空
     * @param userCodeSet
     *            用户代码列表，添加
     * @return
     */
    public void assignFlowWorkTeam(long flowInstId, String roleCode,
            Set<String> userCodeSet);

    /**
     * 删除工作小组--办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            办件角色 不能为空
     * @param userCode
     *            用户代码，添加
     */
    public void deleteFlowWorkTeam(long flowInstId, String roleCode,
            String userCode);

    /**
     * 删除工作小组--办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            办件角色 不能为空
     */
    public void deleteFlowWorkTeam(long flowInstId, String roleCode);

    /**
     * 查看工作小组
     * 
     * @param flowInstId
     * @return Map<roleCode,Set<userCode>>
     */
    public Map<String, Set<String>> viewFlowWorkTeam(long flowInstId);

    /**
     * 查看工作小组中某个角色的成员
     * 
     * @param flowInstId
     *            工作流实例号
     * @param roleCode
     *            办件角色代码
     * @return Set<userCode>
     */
    public Set<String> viewFlowWorkTeam(long flowInstId, String roleCode);

    /**
     * 分配流程组织机构
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            机构角色 不能为空
     * @param unitCode
     *            机构代码，添加
     * @return
     */
    public void assignFlowOrganize(long flowInstId, String roleCode,
            String unitCode);

    /**
     * 分配工作小组 --办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            机构角色 不能为空
     * @param unitCodeSet
     *            机构代码列表，添加
     * @return
     */
    public void assignFlowOrganize(long flowInstId, String roleCode,
            Set<String> unitCodeSet);

    /**
     * 删除工作小组--办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            机构角色 不能为空
     * @param unitCode
     *            机构代码，添加
     */
    public void deleteFlowOrganize(long flowInstId, String roleCode,
            String unitCode);

    /**
     * 删除工作小组--办件角色
     * 
     * @param flowInstId
     *            流程实例号 不能为空
     * @param roleCode
     *            机构角色 不能为空
     */
    public void deleteFlowOrganize(long flowInstId, String roleCode);

    /**
     * 查看工作小组
     * 
     * @param flowInstId
     * @return Map<roleCode,Set<unitCode>>
     */
    public Map<String, Set<String>> viewFlowOrganize(long flowInstId);

    /**
     * 查看工作小组中某个角色的成员
     * 
     * @param flowInstId
     *            工作流实例号
     * @param roleCode
     *            机构角色代码
     * @return Set<unitCode>
     */
    public Set<String> viewFlowOrganize(long flowInstId, String roleCode);

    /**
     * 设置流程全局变量
     * 
     * @param flowId
     * @param sVar
     * @param sValue
     */
    public void saveFlowVariable(long flowInstId, String sVar, String sValue);

    /**
     * 设置流程节点上下文变量
     * 
     * @param nodeInstId
     * @param sVar
     * @param sValue
     */
    public void saveFlowNodeVariable(long nodeInstId, String sVar, String sValue);

    /**
     * 设置流程全局变量
     * 
     * @param flowId
     * @param sVar
     * @param sValues
     *            Set<String> 中的值不能有 分号 ;
     */
    public void saveFlowVariable(long flowInstId, String sVar,
            Set<String> sValues);

    /**
     * 设置流程节点上下文变量
     * 
     * @param nodeInstId
     * @param sVar
     * @param sValues
     *            Set<String> 中的值不能有 分号 ;
     */
    public void saveFlowNodeVariable(long nodeInstId, String sVar,
            Set<String> sValues);

    /**
     * 查询流程变量
     * 
     * @param flowInstId
     * @return
     */
    public List<FlowVariable> listFlowVariables(long flowInstId);

    // 流程关注设置与清空
    /**
     * 设置流程关注人员
     * 
     * @param flowInstId
     *            流程实例id
     * @param attUser
     *            关注人员
     * @param optUser
     *            设置人员
     */
    public void setFlowAttention(long flowInstId, String attUser, String optUser);

    /**
     * 删除流程关注人员
     * 
     * @param flowInstId
     * @param attUser
     *            关注人员
     */
    public void deleteFlowAttention(long flowInstId, String attUser);

    /**
     * 删除流程所有关注人员
     * 
     * @param flowInstId
     */
    public void deleteFlowAttention(long flowInstId);

    /**
     * 获取流程关注人员
     * 
     * @param flowInstId
     * @return
     */
    public List<String> viewFlowAttention(long flowInstId);

    /**
     * 查询某个流程变量
     * 
     * @param flowInstId
     * @return
     */
    public List<FlowVariable> viewFlowVariablesByVarname(long flowInstId,
            String varname);
}

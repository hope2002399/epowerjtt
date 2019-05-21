package com.centit.workflow;

import java.util.List;
import java.util.Map;

/**
 * 模型基础数据接口
 */
public interface FlowModelData {
    /**
     * 例举所有节点操作类别
     */
    public Map<String, String> listAllOptType();

    /**
     * 例举所有节点类别
     */
    public Map<String, String> listAllNoteType();

    /**
     * 列举所有可用变量
     */
    public Map<String, String> listAllVariable(String optid);

    /**
     * 根据业务类型列举所有业务代码
     */
    public Map<String, String> listAllOptCode(String wfcode);

    /**
     * 列举所有角色
     */
    public Map<String, Map<String, String>> listAllRole();

    /**
     * 根据工号显示用户名
     */
    public String getUserNameByCode(String userCode);

    /**
     * 根据机构代码显示机构名
     */
    public String getUnitNameByCode(String unitCode);

    /**
     * 根据角色代码显示角色名
     */
    public String getRoleNameByCode(String roleCode);

    /**
     * 根据角色返回符合条件的所有用户代码
     */
    public List<String> getRightUsers(String unitCode, String roleCode,
            int instID);

    /**
     * 列举所有的子流程
     */
    public Map<String, String> listSubWf();

    /**
     * 获取流程阶段信息
     * 
     * @param flowCode
     *            流程代码
     * @return
     */
    public Map<String, String> listFlowStages(String flowCode);

}

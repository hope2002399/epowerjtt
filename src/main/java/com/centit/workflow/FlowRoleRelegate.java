package com.centit.workflow;

import java.util.List;
import java.util.Map;

import com.centit.core.utils.PageDesc;
import com.centit.workflow.sample.po.WfRoleRelegate;

public interface FlowRoleRelegate {
    /**
     * 保存委托
     * 
     * @param roleRelegate
     */
    public void saveRoleRelegate(WfRoleRelegate roleRelegate);

    /**
     * 查询委托信息
     * 
     * @param userCode
     */
    public List<WfRoleRelegate> listRoleRelegate(Map<String, Object> filterMap,
            PageDesc pageDesc);

    /**
     * 删除某个委托信息
     * 
     * @param relegateno
     */
    public void deleteRoleRelegate(Long relegateno);

    /**
     * 根据ID获取对象
     * 
     * @param relegateno
     * @return
     */
    public WfRoleRelegate getObjectById(Long relegateno);

    /**
     * 获取对象
     * 
     * @param relegateno
     * @return
     */
    public WfRoleRelegate getObject(WfRoleRelegate roleRelegate);
}

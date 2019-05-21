package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.LawExecutor;

/**
 * 
 * 执法人员管理Manager
 * 
 * @author JF
 * @create 2013-10-23
 * @version
 */
public interface LawExecutorManager extends BaseEntityManager<LawExecutor> {
    /**
     * 登记操作获取主键 获取规则为：按部门排序第几位
     * 
     * @param deptid
     *            部门编号
     * @return
     */
    public String createStaffno(String deptid);

    /**
     * 根据当前登录人机构分页查询执法人员审核列表
     * 
     * @param unitcode
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<LawExecutor> pageCheckList(String unitcode,
            Map<String, Object> filterMap, PageDesc pageDesc);

    public boolean IsPasscodeExist(String passcode);
}

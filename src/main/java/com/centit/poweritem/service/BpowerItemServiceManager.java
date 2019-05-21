package com.centit.poweritem.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.poweritem.po.BpowerItemService;
import com.centit.poweritem.po.VpowerItemServiceChange;
import com.centit.poweritem.po.Vpoweritemservicewithoutlob;

public interface BpowerItemServiceManager extends
        BaseEntityManager<BpowerItemService> {
    // 查询权力事项
    public List<Vpoweritemservicewithoutlob> listSupPowerWithoutLob(
            Map<String, Object> filterMap, PageDesc pageDesc);

    // 根据业务需要，查询所属部门的关联的权力事项:风险点、流程、分组材料、行使部门、申请事项等
    // public List<VOrgSupPower> listOrgSuppower(Map<String, Object>
    // filterMap,PageDesc pageDesc);

    // 根据权力编码和部门获取流程接口
    public String getFlowCodeByOrgItem(String itemId, String Org_id);

    // 根据权力编号和名称，权利状态查询列表,当有多个版本时，显示最新版本
    public List<BpowerItemService> getPicListByState(
            Map<String, Object> filterMap, PageDesc pageDesc, String qlState,
            String ItemType);

    // 查询权力事项列表，当有多个版本时，显示最新版本
    public List<Vpoweritemservicewithoutlob> listSupPowerOnlyList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public BpowerItemService getObjectById(String itemId, Long version);

    // 获取具体权力事项详细信息，显示最新版本
    public BpowerItemService getSuppowerLastVersion(String itemId, Date date);

    public BpowerItemService getSuppowerQlfb(String itemId);

    // 根据编号查询版本号列表
    @SuppressWarnings("rawtypes")
    public List getVersionList(String itemId);

    // 根据权力编号，查询所有的版本号和状态变更情况
    public List<BpowerItemService> getlistSuppowerOld(String item_id,
            Long version);

    public void saveSuppower(BpowerItemService suppower1,
            BpowerItemService suppower2);

    // 查看权力变更list信息
    public List<Vpoweritemservicewithoutlob> listSuppowerWithoutLob(
            String hsql, Map<String, Object> filterMap, PageDesc pageDesc);

    // 保存权力事项（权力管理）
    public void saveSuppower(BpowerItemService suppower);

    public void updateSuppower(BpowerItemService suppower);

    @SuppressWarnings("rawtypes")
    public List xmlDISCRETIONList(String dis_detail, String update_type,
            String item_id);

    @SuppressWarnings("rawtypes")
    public List xmlStandardList(String dis_standard, String update_type,
            String item_id);

    @SuppressWarnings("rawtypes")
    public List getzycvie(String Linagesize);

    @SuppressWarnings("rawtypes")
    public List getseqtype(String Linagesize);

    @SuppressWarnings("rawtypes")
    public List getseqlowlimitunit(String Linagesize);

    @SuppressWarnings("rawtypes")
    public List genxmlStandardList(String dis_standard, String update_type,
            String item_id);

    public List<BpowerItemService> getlistSuppower(String item_type);

    /**
     * 页面下拉框选择权利编号及名称
     * 
     * 注意！这里的编号被截取了，只保留后面这样：JT-CF-XXXX 这样的ID
     * 
     * @param item_type
     * @return
     */
    public List<BpowerItemService> listSuppower4Select(String item_type);

    public List<Vpoweritemservicewithoutlob> listPowerWithoutLob(
            Map<String, Object> filterMap, PageDesc pageDesc);

    /**
     * 根据权力编码和部门获取权力信息,其中带着版本
     * 
     * @param item_id
     * @param orgid
     * @return
     */
    // public VOrgSupPower getSupPowerInfo(String item_id,String orgid);

    // public VOrgSupPower getSuppowerInfo(String item_id);

    public boolean isPowerExist(String itemId);

    // 地区统计分析
    @SuppressWarnings("rawtypes")
    public List getxzlist(String begintime, String endtime);

    @SuppressWarnings("rawtypes")
    public List<BpowerItemService> getSuppowernum(String item_type);

    @SuppressWarnings("rawtypes")
    public List getdeplist(String string);

    public void QlfbAll(List<BpowerItemService> suppowerList);

    public VpowerItemServiceChange getVpowerItemServiceChangeInfo(
            String itemId, Long version);
}

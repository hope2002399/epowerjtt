package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyInfoNet;
import com.centit.powerruntime.po.OptApplyReturn;
import com.centit.powerruntime.po.VOptApplyInfoNet;

public interface OptApplyNetManager extends BaseEntityManager<OptApplyInfoNet> {
    // public String generateNextDjId(String item_type);

    /**
     * 查询保存但未提交的许可业务数据
     * 
     * @param filterMap
     *            查询条件
     * @param pageDesc
     *            排序方式
     * @return
     */
    public List<VOptApplyInfoNet> listOptApplyInfoNet(
            Map<String, Object> filterMap, PageDesc pageDesc);

    /**
     * 获取申请者JSON数据
     * 
     * @return
     */
    // public String getJSONProposerNames();

    /**
     * 根据登记编号获取办件信息JSON数据
     * 
     * @param djId
     * @return
     */
    // public String getApplyInfoJsonByDjId(String djId);

    public JSONObject getJSONDocumentNames(String net_id);

    public void insertOptApplyReturn(OptApplyReturn appret);

    public List<Object[]> getSendMessageInfo();

    public List<Object[]> listOptApplyInfoNetUnprocessed(Map<String, Object> filterMap);

}

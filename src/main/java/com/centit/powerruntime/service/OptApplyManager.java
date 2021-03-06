package com.centit.powerruntime.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.VOptApplyInfo;

public interface OptApplyManager extends BaseEntityManager<OptApplyInfo> {
    public String generateNextDjId();

    /**
     * 查询保存但未提交的许可业务数据
     * 
     * @param filterMap
     *            查询条件
     * @param pageDesc
     *            排序方式
     * @return
     */
    public List<VOptApplyInfo> listOptApplyInfo(Map<String, Object> filterMap,
            PageDesc pageDesc);

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

    public String getJSONDocumentNames(String dj_id, String username);

    public List<OptProcInfo> getOptProcInfos(String djId);

}

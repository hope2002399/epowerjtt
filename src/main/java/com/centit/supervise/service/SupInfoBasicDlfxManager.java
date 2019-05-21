package com.centit.supervise.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.SupDlfxOutway;
import com.centit.supervise.po.SupInfoBasicDlfx;

public interface SupInfoBasicDlfxManager extends
        BaseEntityManager<SupInfoBasicDlfx> {
    public String getNextkey();

    // 获取预报警信息
    public List<SupDlfxOutway> getSupDlfxOutWayManager(
            Map<String, Object> filterMap, PageDesc pageDesc);

    // 获取督办信息
    public List<SupInfoBasicDlfx> getSupInfoBasicDlfxList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public void UpdateSupInfoBasicDlfxJl(SupInfoBasicDlfx info);

    public void UpdateSupInfoBasicDlfxFk(SupInfoBasicDlfx info);
}

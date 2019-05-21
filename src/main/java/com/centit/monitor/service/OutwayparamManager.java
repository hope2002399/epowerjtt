package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Outwayparam;

public interface OutwayparamManager extends BaseEntityManager<Outwayparam> {
    // 获取outwayparamlist
    public List<Outwayparam> getOutWayParamList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    // 调用对应的存储过程
    public boolean callCheck_warning(String procedureName, String countYear,
            String countMonth);
}

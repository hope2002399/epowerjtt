package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PowerRisk;

public interface PowerRiskManager extends BaseEntityManager<PowerRisk> {

    public List<PowerRisk> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc);

}

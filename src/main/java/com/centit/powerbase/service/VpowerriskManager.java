package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Vpowerrisk;

public interface VpowerriskManager extends BaseEntityManager<Vpowerrisk> {

    public List<Vpowerrisk> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<Vpowerrisk> view();

}

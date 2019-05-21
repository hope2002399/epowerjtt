package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.VPowerQldy;

public interface VPowerQldyManager extends BaseEntityManager<VPowerQldy> {

    public List<VPowerQldy> getListVPowerQldy(Map<String, Object> filterMap,
            PageDesc pageDesc);

}

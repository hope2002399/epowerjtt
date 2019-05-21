package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.PowerRiskDao;
import com.centit.powerbase.po.PowerRisk;
import com.centit.powerbase.service.PowerRiskManager;

public class PowerRiskManagerImpl extends BaseEntityManagerImpl<PowerRisk>
        implements PowerRiskManager {

    private static final long serialVersionUID = 1L;

    private PowerRiskDao powerRiskDao;

    public void setPowerRiskDao(PowerRiskDao baseDao) {
        powerRiskDao = baseDao;
        this.setBaseDao(this.powerRiskDao);
    }

    @Override
    public List<PowerRisk> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return powerRiskDao.getListPowerRisk(filterMap, pageDesc);
    }

}

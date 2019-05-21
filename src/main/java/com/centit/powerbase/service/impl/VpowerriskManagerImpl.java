package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.VpowerriskDao;
import com.centit.powerbase.po.Vpowerrisk;
import com.centit.powerbase.service.VpowerriskManager;

public class VpowerriskManagerImpl extends BaseEntityManagerImpl<Vpowerrisk>
        implements VpowerriskManager {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private VpowerriskDao vpowerriskDao;

    public void setVpowerriskDao(VpowerriskDao baseDao) {
        vpowerriskDao = baseDao;
        this.setBaseDao(this.vpowerriskDao);
    }

    @Override
    public List<Vpowerrisk> getListPowerRisk(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vpowerriskDao.getListPowerRisk(filterMap, pageDesc);
    }

    @Override
    public List<Vpowerrisk> view() {
        return vpowerriskDao.view();
    }

}

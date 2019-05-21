package com.centit.powerbase.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.VPowerQldyDao;
import com.centit.powerbase.po.VPowerQldy;
import com.centit.powerbase.service.VPowerQldyManager;

public class VPowerQldyManagerImpl extends BaseEntityManagerImpl<VPowerQldy>
        implements VPowerQldyManager {

    private static final long serialVersionUID = 1L;

    private VPowerQldyDao vPowerQldyDao;

    public VPowerQldyDao getvPowerQldyDao() {
        return vPowerQldyDao;
    }

    public void setvPowerQldyDao(VPowerQldyDao vPowerQldyDao) {
        this.vPowerQldyDao = vPowerQldyDao;
    }

    @Override
    public List<VPowerQldy> getListVPowerQldy(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vPowerQldyDao.getListPowerRisk(filterMap, pageDesc);
    }

    @Override
    public VPowerQldy getObjectById(Serializable id) {
        
        return vPowerQldyDao.getObjectById(id);
    }

}

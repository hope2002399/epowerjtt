package com.centit.powerbase.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.PowerQldyDao;
import com.centit.powerbase.po.PowerQldy;
import com.centit.powerbase.service.PowerQldyManager;

public class PowerQldyManagerImpl extends BaseEntityManagerImpl<PowerQldy>
        implements PowerQldyManager {

    private static final long serialVersionUID = 1L;

    private PowerQldyDao powerQldyDao;

    public PowerQldyDao getPowerQldyDao() {
        return powerQldyDao;
    }

    public void setPowerQldyDao(PowerQldyDao powerQldyDao) {
        this.powerQldyDao = powerQldyDao;
    }

    @Override
    public PowerQldy getPowerQldyByBPowerItemId(String bPowerItemId) {
        
        return powerQldyDao.getPowerQldyByBPowerItemId(bPowerItemId);
    }

    @Override
    public void saveObject(PowerQldy o) {
        
        powerQldyDao.saveObject(o);
    }

}

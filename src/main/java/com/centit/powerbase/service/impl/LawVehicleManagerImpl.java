package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.LawVehicleDao;
import com.centit.powerbase.po.LawVehicle;
import com.centit.powerbase.service.LawVehicleManager;

public class LawVehicleManagerImpl extends BaseEntityManagerImpl<LawVehicle>
        implements LawVehicleManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawVehicleManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private LawVehicleDao lawVehicleDao;

    public void setLawVehicleDao(LawVehicleDao baseDao) {
        this.lawVehicleDao = baseDao;
        setBaseDao(this.lawVehicleDao);
    }

    @Override
    public String generateNextVehicleId() {
        
        return lawVehicleDao.generateNextVehicleId();
    }

    @Override
    public List<LawVehicle> lawVehicleList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return lawVehicleDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public LawVehicle getUpdateNo(String vehicleId) {
        
        return lawVehicleDao.getObjectById(vehicleId);
    }

    @Override
    public boolean checkplateNumber(String plateNumber) {
        
        return lawVehicleDao.IsplateNumberExist(plateNumber);
    }

}

package com.centit.powerruntime.service.impl;

import java.util.List;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.OptStuffInfoNetDao;
import com.centit.powerruntime.po.OptStuffInfoNet;
import com.centit.powerruntime.service.OptStuffInfoNetManager;

public class OptStuffInfoNetManagerImpl extends
        BaseEntityManagerImpl<OptStuffInfoNet> implements
        OptStuffInfoNetManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private OptStuffInfoNetDao optStuffInfoNetDao;

    public void setOptStuffInfoNetDao(OptStuffInfoNetDao optStuffInfoNetDao) {
        this.optStuffInfoNetDao = optStuffInfoNetDao;
        setBaseDao(optStuffInfoNetDao);
    }

    @Override
    public OptStuffInfoNet getObjectById_SortId(String netId, String sortId) {
        
        return optStuffInfoNetDao.getObjectById_SortId(netId, sortId);
    }

    public OptStuffInfoNet getStuffInfoByArchiveType(String netId,
            String archiveType) {

        return optStuffInfoNetDao.getStuffInfoByArchiveType(netId, archiveType);
    }

    public List<OptStuffInfoNet> getZwfjStuffInfo(String netId) {

        return optStuffInfoNetDao.listZwclStuffs(netId);
    }

    @Override
    public void deleteOSIN(String netId, String sortId) {
        
        optStuffInfoNetDao.deleteObjectById(netId, sortId);
    }

}

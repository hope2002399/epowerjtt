package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.OptStuffInfoDao;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.service.OptStuffInfoManager;

public class OptStuffInfoManagerImpl extends
        BaseEntityManagerImpl<OptStuffInfo> implements OptStuffInfoManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private OptStuffInfoDao optStuffInfoDao;

    public void setOptStuffInfoDao(OptStuffInfoDao optStuffInfoDao) {
        this.optStuffInfoDao = optStuffInfoDao;
        setBaseDao(optStuffInfoDao);
    }

    public OptStuffInfo getStuffInfoByArchiveType(String djId,
            String archiveType) {

        return optStuffInfoDao.getStuffInfoByArchiveType(djId, archiveType);
    }
    

    public OptStuffInfo getStuffInfoByDjIdName(String djId,
            String fileName) {

        return optStuffInfoDao.getStuffInfoBydjIdName(djId, fileName);
    }

}

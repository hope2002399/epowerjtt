package com.centit.EIdPhoto.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.EIdPhoto.dao.TZzZmInfoDao;
import com.centit.EIdPhoto.po.TZzZmInfo;
import com.centit.EIdPhoto.po.TZzZmdyInfo;
import com.centit.EIdPhoto.service.TZzZmInfoManager;
import com.centit.core.utils.PageDesc;

public class TZzZmInfoManagerImpl implements TZzZmInfoManager {

    private TZzZmInfoDao tZzZmInfoDao;
    
    
    
    public TZzZmInfoDao gettZzZmInfoDao() {
        return tZzZmInfoDao;
    }



    public void settZzZmInfoDao(TZzZmInfoDao tZzZmInfoDao) {
        this.tZzZmInfoDao = tZzZmInfoDao;
    }



    @Override
    public void insertZmInfo(TZzZmInfo tZzZmInfo) {
        tZzZmInfoDao.insertTZzZmInfo(tZzZmInfo);
    }
    
    @Override
    public List<TZzZmInfo> findTZzZmdyInfo(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return tZzZmInfoDao.listObjects(filterMap, pageDesc);
    }

}

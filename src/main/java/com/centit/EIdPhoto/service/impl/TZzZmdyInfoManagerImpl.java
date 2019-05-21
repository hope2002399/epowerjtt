package com.centit.EIdPhoto.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.EIdPhoto.dao.TZzMetadataInfoDao;
import com.centit.EIdPhoto.dao.TZzZmdyInfoDao;
import com.centit.EIdPhoto.po.TZzMetadataInfo;
import com.centit.EIdPhoto.po.TZzZmdyInfo;
import com.centit.EIdPhoto.service.TZzZmdyInfoManager;
import com.centit.core.utils.PageDesc;

public class TZzZmdyInfoManagerImpl implements TZzZmdyInfoManager {

    

    private TZzZmdyInfoDao tZzZmdyInfoDao;
    
    private TZzMetadataInfoDao tZzMetadataInfoDao;
    
    public TZzMetadataInfoDao gettZzMetadataInfoDao() {
        return tZzMetadataInfoDao;
    }



    public void settZzMetadataInfoDao(TZzMetadataInfoDao tZzMetadataInfoDao) {
        this.tZzMetadataInfoDao = tZzMetadataInfoDao;
    }



    public TZzZmdyInfoDao gettZzZmdyInfoDao() {
        return tZzZmdyInfoDao;
    }



    public void settZzZmdyInfoDao(TZzZmdyInfoDao tZzZmdyInfoDao) {
        this.tZzZmdyInfoDao = tZzZmdyInfoDao;
    }



    @Override
    public List<TZzZmdyInfo> findTZzZmdyInfo(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return tZzZmdyInfoDao.listObjects(filterMap, pageDesc);
    }
    
    @Override
    public List<TZzMetadataInfo> findTZzMetadataInfo(String mouldId){
        return tZzMetadataInfoDao.listObjects(mouldId);
    }

}

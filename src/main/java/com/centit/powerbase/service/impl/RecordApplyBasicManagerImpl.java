package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.RecordApplyBasicDao;
import com.centit.powerbase.po.RecordApplyBasic;
import com.centit.powerbase.service.RecordApplyBasicManager;

public class RecordApplyBasicManagerImpl extends
        BaseEntityManagerImpl<RecordApplyBasic> implements
        RecordApplyBasicManager {
    private static final long serialVersionUID = 1L;
    private RecordApplyBasicDao recordApplyBasicDao;

    public void setRecordApplyBasicDao(RecordApplyBasicDao baseDao) {
        this.recordApplyBasicDao = baseDao;
        this.setBaseDao(this.recordApplyBasicDao);
    }

    @Override
    public List<RecordApplyBasic> getListRecord(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return recordApplyBasicDao.getListRecord(filterMap, pageDesc);
    }

    @Override
    public String getRecordCode() {
        return recordApplyBasicDao.getRecordCode();
    }

    @Override
    public void saveRecordApplyBasic(RecordApplyBasic info) {
        
        super.saveObject(info);
    }

}

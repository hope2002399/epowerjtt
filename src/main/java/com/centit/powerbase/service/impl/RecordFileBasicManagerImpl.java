package com.centit.powerbase.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.RecordFileBasicDao;
import com.centit.powerbase.po.RecordFileBasic;
import com.centit.powerbase.service.RecordFileBasicManager;

public class RecordFileBasicManagerImpl extends
        BaseEntityManagerImpl<RecordFileBasic> implements
        RecordFileBasicManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private RecordFileBasicDao recordFileBasicDao;

    public void setRecordFileBasicDao(RecordFileBasicDao baseDao) {
        this.recordFileBasicDao = baseDao;
        setBaseDao(this.recordFileBasicDao);
    }

    @Override
    public RecordFileBasic getRecordById(String recordCode) {
        
        return recordFileBasicDao.getRecordById(recordCode);
    }

    @Override
    public String getDepNamesByDepIds(String depIds) {
        
        return recordFileBasicDao.getDepNamesByDepIds(depIds);
    }

    @Override
    public void saveRecord(RecordFileBasic record) {
        
        recordFileBasicDao.saveObject(record);
    }

    @Override
    public String getRecordCode() {
        
        return recordFileBasicDao.getRecordCode();
    }

}

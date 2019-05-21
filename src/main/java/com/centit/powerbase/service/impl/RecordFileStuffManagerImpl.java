package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.RecordFileStuffDao;
import com.centit.powerbase.po.RecordFileStuff;
import com.centit.powerbase.service.RecordFileStuffManager;

public class RecordFileStuffManagerImpl extends
        BaseEntityManagerImpl<RecordFileStuff> implements
        RecordFileStuffManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private RecordFileStuffDao recordFileStuffDao;

    @Override
    public List<RecordFileStuff> getRecordFileStuffByRecord(String recordCode) {
        
        return recordFileStuffDao.getRecordFileStuffByRecord(recordCode);
    }

    public void setRecordFileStuffDao(RecordFileStuffDao recordFileStuffDAO) {
        this.recordFileStuffDao = recordFileStuffDAO;
        setBaseDao(this.recordFileStuffDao);
    }

    @Override
    public RecordFileStuff getStuffByNo(String attachNo) {
        

        return recordFileStuffDao.getStuffByNo(attachNo);
    }

    @Override
    public void saveStuff(RecordFileStuff stuff) {
        
        recordFileStuffDao.saveObject(stuff);
    }

    @Override
    public String getAttachNo() {
        
        return recordFileStuffDao.getAttachNo();
    }

    @Override
    public List<RecordFileStuff> getFileStuff(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return recordFileStuffDao.getFileStuff(filterMap, pageDesc);
    }

}

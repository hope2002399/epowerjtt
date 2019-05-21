package com.centit.powerbase.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.RecordFileDepDao;
import com.centit.powerbase.po.RecordFileDep;
import com.centit.powerbase.service.RecordFileDepManager;

public class RecordFileDepManagerImpl extends
        BaseEntityManagerImpl<RecordFileDep> implements RecordFileDepManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private RecordFileDepDao recordFileDepDao;

    public void setRecordFileDepDao(RecordFileDepDao recordFileDepDao) {
        this.recordFileDepDao = recordFileDepDao;
        setBaseDao(this.recordFileDepDao);
    }

    @Override
    public void delDepByRecordCode(String recordCode) {
        
        recordFileDepDao.deleteByRecordCode(recordCode);
    }

    @Override
    public String getNo() {
        
        return recordFileDepDao.getNo();
    }

    @Override
    public void saveDeps(String recordCode, String constituteId) {
        
        
        String depIDs = constituteId;
        String[] depArray = depIDs.split(",");
        RecordFileDep fileDep = null;
        for (int i = 0; i < depArray.length; i++) {
            fileDep = new RecordFileDep();
            fileDep.setNo(getNo());
            fileDep.setRecordCode(recordCode);
            fileDep.setConstituteDepID(depArray[i]);
            saveObject(fileDep);
        }

    }

}

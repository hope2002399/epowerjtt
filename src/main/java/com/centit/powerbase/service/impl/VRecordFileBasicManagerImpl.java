package com.centit.powerbase.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.VRecordFileBasicDao;
import com.centit.powerbase.po.VRecordFileBasic;
import com.centit.powerbase.service.VRecordFileBasicManager;

public class VRecordFileBasicManagerImpl extends
        BaseEntityManagerImpl<VRecordFileBasic> implements
        VRecordFileBasicManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private VRecordFileBasicDao vRecordFileBasicDao;

    public void setVRecordFileBasicDao(VRecordFileBasicDao baseDao) {
        this.vRecordFileBasicDao = baseDao;
        setBaseDao(this.vRecordFileBasicDao);
    }
}

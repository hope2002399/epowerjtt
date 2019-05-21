package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.RecordBasicDao;
import com.centit.powerbase.po.RecordBasic;
import com.centit.powerbase.service.RecordBasicManager;

@SuppressWarnings("serial")
public class RecordBasicManagerImpl extends BaseEntityManagerImpl<RecordBasic>
        implements RecordBasicManager {
    private RecordBasicDao recordBasicDao;

    public void setRecordBasicDao(RecordBasicDao recordBasicDao) {
        this.recordBasicDao = recordBasicDao;
        setBaseDao(this.recordBasicDao);
    }

    @Override
    public List<RecordBasic> recordBasicList(Map<String, Object> filterMap,
            PageDesc pageDesc) {

        return recordBasicDao.recordBasicList(filterMap, pageDesc);
    }

    @Override
    public String getRecordCode() {
        return recordBasicDao.getRecordCode();
    }

}

package com.centit.powerbase.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerbase.po.RecordFileBasic;

public interface RecordFileBasicManager extends
        BaseEntityManager<RecordFileBasic> {
    public RecordFileBasic getRecordById(String recordCode);

    public String getDepNamesByDepIds(String depIds);

    public void saveRecord(RecordFileBasic record);

    public String getRecordCode();
}

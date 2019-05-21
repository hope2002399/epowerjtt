package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordFileStuff;

public interface RecordFileStuffManager extends
        BaseEntityManager<RecordFileStuff> {
    public List<RecordFileStuff> getRecordFileStuffByRecord(String recordCode);

    public RecordFileStuff getStuffByNo(String attachNo);

    public void saveStuff(RecordFileStuff stuff);

    public String getAttachNo();

    public List<RecordFileStuff> getFileStuff(Map<String, Object> filterMap,
            PageDesc pageDesc);
}

package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordBasic;

public interface RecordBasicManager extends BaseEntityManager<RecordBasic> {
    public List<RecordBasic> recordBasicList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public String getRecordCode();
}

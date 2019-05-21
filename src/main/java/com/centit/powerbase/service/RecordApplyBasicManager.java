package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordApplyBasic;

public interface RecordApplyBasicManager extends
        BaseEntityManager<RecordApplyBasic> {

    public List<RecordApplyBasic> getListRecord(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public String getRecordCode();

    public void saveRecordApplyBasic(RecordApplyBasic info);
}

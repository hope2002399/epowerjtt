package com.centit.powerbase.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerbase.po.RecordFileDep;

public interface RecordFileDepManager extends BaseEntityManager<RecordFileDep> {
    public void delDepByRecordCode(String recordCode);

    public String getNo();

    public void saveDeps(String recordCode, String constituteId);
}

package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PunishRecord;

public interface PunishrecordManager extends BaseEntityManager<PunishRecord> {
    public List<PunishRecord> getPunishRecord(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public void updatePunishRecord(Map<String, Object> filterMap);

    public boolean initPunishRecords(String org_id);
}

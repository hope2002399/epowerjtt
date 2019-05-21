package com.centit.powerbase.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.PunishBasic;
import com.centit.powerbase.po.PunishRecord;

public interface PunishBasicManager extends BaseEntityManager<PunishBasic> {
    public List<PunishBasic> PunishBasicTemp(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public PunishRecord getPunishRecordByOrgid(String org_id);
}

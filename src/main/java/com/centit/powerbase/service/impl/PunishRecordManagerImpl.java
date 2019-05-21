package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.PunishRecordDao;
import com.centit.powerbase.po.PunishRecord;
import com.centit.powerbase.service.PunishrecordManager;

@SuppressWarnings("serial")
public class PunishRecordManagerImpl extends
        BaseEntityManagerImpl<PunishRecord> implements PunishrecordManager {
    private PunishRecordDao punishRecordDao;

    public void setPunishRecordDao(PunishRecordDao punishRecordDao) {
        this.punishRecordDao = punishRecordDao;
        setBaseDao(this.punishRecordDao);
    }

    @Override
    public List<PunishRecord> getPunishRecord(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return punishRecordDao.getPunishRecord(filterMap, pageDesc);
    }

    @Override
    public void updatePunishRecord(Map<String, Object> filterMap) {
        punishRecordDao.updatePunishRecord(filterMap);

    }

    @Override
    public boolean initPunishRecords(String org_id) {
        
        Object[] paramObjs = new Object[1];
        if (StringUtils.isNotBlank(org_id)) {
            paramObjs[0] = org_id;
        } else {
            paramObjs[0] = null;
        }
        return punishRecordDao.callProcedure("initPunishRecords", paramObjs);

    }

}

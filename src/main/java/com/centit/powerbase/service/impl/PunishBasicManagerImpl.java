package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.PunishBasicDao;
import com.centit.powerbase.po.PunishBasic;
import com.centit.powerbase.po.PunishRecord;
import com.centit.powerbase.service.PunishBasicManager;

public class PunishBasicManagerImpl extends BaseEntityManagerImpl<PunishBasic>
        implements PunishBasicManager {
    private static final long serialVersionUID = 1L;
    private PunishBasicDao punishBasicDao;

    public void setPunishBasicDao(PunishBasicDao punishBasicDao) {
        this.punishBasicDao = punishBasicDao;
        setBaseDao(this.punishBasicDao);
    }

    @Override
    public List<PunishBasic> PunishBasicTemp(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return punishBasicDao.getPunishBasic(filterMap, pageDesc);
    }

    @Override
    public PunishRecord getPunishRecordByOrgid(String org_id) {
        
        PunishRecord record = getRecordByid(org_id);
        if (null == record) {
            return getRecordByid("JS");
        }
        return record;
    }

    @SuppressWarnings("unchecked")
    private PunishRecord getRecordByid(String org_id) {
        List<PunishRecord> list = (List<PunishRecord>) punishBasicDao
                .findObjectsByHql("from PunishRecord where org_id='" + org_id
                        + "'");
        if (list.size() > 0) {
            return (PunishRecord) list.get(0);
        }
        return null;
    }
}

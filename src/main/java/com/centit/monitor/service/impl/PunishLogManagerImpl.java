package com.centit.monitor.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.PunishLogDao;
import com.centit.monitor.po.PunishLog;
import com.centit.monitor.service.PunishLogManager;

public class PunishLogManagerImpl extends BaseEntityManagerImpl<PunishLog>
        implements PunishLogManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishLogManager.class);
    private PunishLogDao punishLogDao;

    public void setPunishLogDao(PunishLogDao baseDao) {
        this.punishLogDao = baseDao;
        setBaseDao(this.punishLogDao);
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String orgId) {
        return punishLogDao.getVersionList(internalNo, orgId);
    }

    public PunishLog getPunishLog(String internalNo, String orgId, Long chang_no) {
        return punishLogDao.getPunishLog(internalNo, orgId, chang_no);
    }
}

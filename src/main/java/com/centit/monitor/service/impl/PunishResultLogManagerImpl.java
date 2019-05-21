package com.centit.monitor.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.PunishResultLogDao;
import com.centit.monitor.po.PunishResultLog;
import com.centit.monitor.service.PunishResultLogManager;

public class PunishResultLogManagerImpl extends
        BaseEntityManagerImpl<PunishResultLog> implements
        PunishResultLogManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PunishResultLogManager.class);
    private PunishResultLogDao punishResultLogDao;

    public void setPunishResultLogDao(PunishResultLogDao baseDao) {
        this.punishResultLogDao = baseDao;
        setBaseDao(this.punishResultLogDao);
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String orgId) {
        return punishResultLogDao.getVersionList(internalNo, orgId);
    }

    public PunishResultLog getPunishResultLog(String internalNo, String orgId,
            Long chang_no) {
        return punishResultLogDao.getPunishResultLog(internalNo, orgId,
                chang_no);
    }
}

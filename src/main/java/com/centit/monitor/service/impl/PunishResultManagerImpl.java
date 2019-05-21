package com.centit.monitor.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.monitor.dao.PunishResultDao;
import com.centit.monitor.po.PunishResult;
import com.centit.monitor.service.PunishResultManager;

public class PunishResultManagerImpl extends
        BaseEntityManagerImpl<PunishResult> implements PunishResultManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishResultManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private PunishResultDao punishResultDao;

    public void setPunishResultDao(PunishResultDao baseDao) {
        this.punishResultDao = baseDao;
        setBaseDao(this.punishResultDao);
    }

    @Override
    public PunishResult getPunishResult(String internalNo, String orgId) {
        
        return punishResultDao.getPunishResult(internalNo, orgId);
    }

}

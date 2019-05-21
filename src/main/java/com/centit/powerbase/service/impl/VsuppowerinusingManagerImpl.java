package com.centit.powerbase.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.VsuppowerinusingDao;
import com.centit.powerbase.po.Vsuppowerinusing;
import com.centit.powerbase.service.VsuppowerinusingManager;

public class VsuppowerinusingManagerImpl extends
        BaseEntityManagerImpl<Vsuppowerinusing> implements
        VsuppowerinusingManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VsuppowerinusingManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private VsuppowerinusingDao vsuppowerinusingDao;

    public void setVsuppowerinusingDao(VsuppowerinusingDao baseDao) {
        this.vsuppowerinusingDao = baseDao;
        setBaseDao(this.vsuppowerinusingDao);
    }

    @Override
    public Vsuppowerinusing findB_PowerByItemId(String itemId) {
        
        return vsuppowerinusingDao.findB_PowerByItemId(itemId);
    }

}

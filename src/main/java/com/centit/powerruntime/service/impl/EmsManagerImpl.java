package com.centit.powerruntime.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.EmsDao;
import com.centit.powerruntime.po.Ems;
import com.centit.powerruntime.service.EmsManager;

public class EmsManagerImpl extends BaseEntityManagerImpl<Ems> implements
        EmsManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptApplyManagerImpl.class);
    private EmsDao emsDao;

    public void setEmsDao(EmsDao baseDao) {
        this.emsDao = baseDao;
        setBaseDao(this.emsDao);
    }

}

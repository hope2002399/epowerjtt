package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoregisterbasicDao;
import com.centit.punish.po.Poregisterbasic;
import com.centit.punish.service.PoregisterbasicManager;

public class PoregisterbasicManagerImpl extends
        BaseEntityManagerImpl<Poregisterbasic> implements
        PoregisterbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PoregisterbasicManager.class);

    private PoregisterbasicDao poregisterbasicDao;

    public void setPoregisterbasicDao(PoregisterbasicDao baseDao) {
        this.poregisterbasicDao = baseDao;
        setBaseDao(this.poregisterbasicDao);
    }

}

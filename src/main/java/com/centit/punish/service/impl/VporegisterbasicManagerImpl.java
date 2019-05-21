package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.VporegisterbasicDao;
import com.centit.punish.po.Vporegisterbasic;
import com.centit.punish.service.VporegisterbasicManager;

public class VporegisterbasicManagerImpl extends
        BaseEntityManagerImpl<Vporegisterbasic> implements
        VporegisterbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VporegisterbasicManager.class);

    private VporegisterbasicDao vporegisterbasicDao;

    public void setVporegisterbasicDao(VporegisterbasicDao baseDao) {
        this.vporegisterbasicDao = baseDao;
        setBaseDao(this.vporegisterbasicDao);
    }

}

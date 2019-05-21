package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PounwitnessbasicDao;
import com.centit.punish.po.Pounwitnessbasic;
import com.centit.punish.service.PounwitnessbasicManager;

public class PounwitnessbasicManagerImpl extends
        BaseEntityManagerImpl<Pounwitnessbasic> implements
        PounwitnessbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PounwitnessbasicManager.class);

    private PounwitnessbasicDao pounwitnessbasicDao;

    public void setPounwitnessbasicDao(PounwitnessbasicDao baseDao) {
        this.pounwitnessbasicDao = baseDao;
        setBaseDao(this.pounwitnessbasicDao);
    }

}

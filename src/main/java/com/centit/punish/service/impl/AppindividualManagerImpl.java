package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.AppindividualDao;
import com.centit.punish.po.Appindividual;
import com.centit.punish.service.AppindividualManager;

public class AppindividualManagerImpl extends
        BaseEntityManagerImpl<Appindividual> implements AppindividualManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(AppindividualManager.class);

    private AppindividualDao appindividualDao;

    public void setAppindividualDao(AppindividualDao baseDao) {
        this.appindividualDao = baseDao;
        setBaseDao(this.appindividualDao);
    }

}

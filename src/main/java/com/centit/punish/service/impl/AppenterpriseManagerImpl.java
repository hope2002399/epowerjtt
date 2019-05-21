package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.AppenterpriseDao;
import com.centit.punish.po.Appenterprise;
import com.centit.punish.service.AppenterpriseManager;

public class AppenterpriseManagerImpl extends
        BaseEntityManagerImpl<Appenterprise> implements AppenterpriseManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(AppenterpriseManager.class);

    private AppenterpriseDao appenterpriseDao;

    public void setAppenterpriseDao(AppenterpriseDao baseDao) {
        this.appenterpriseDao = baseDao;
        setBaseDao(this.appenterpriseDao);
    }

}

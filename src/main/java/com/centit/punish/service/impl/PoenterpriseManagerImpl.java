package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoenterpriseDao;
import com.centit.punish.po.Poenterprise;
import com.centit.punish.service.PoenterpriseManager;

public class PoenterpriseManagerImpl extends
        BaseEntityManagerImpl<Poenterprise> implements PoenterpriseManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoenterpriseManager.class);

    private PoenterpriseDao poenterpriseDao;

    public void setPoenterpriseDao(PoenterpriseDao baseDao) {
        this.poenterpriseDao = baseDao;
        setBaseDao(this.poenterpriseDao);
    }

    public String generateNextEnterpriseId() {
        return poenterpriseDao.genNextEnterpriseId();
    }

    public Poenterprise getPoenterprise(String punishobjectid) {
        return poenterpriseDao.getPoenterprise(punishobjectid);
    }

}

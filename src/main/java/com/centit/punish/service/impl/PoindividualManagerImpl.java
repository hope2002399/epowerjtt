package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoindividualDao;
import com.centit.punish.po.Poindividual;
import com.centit.punish.service.PoindividualManager;

public class PoindividualManagerImpl extends
        BaseEntityManagerImpl<Poindividual> implements PoindividualManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoindividualManager.class);

    private PoindividualDao poindividualDao;

    public void setPoindividualDao(PoindividualDao baseDao) {
        this.poindividualDao = baseDao;
        setBaseDao(this.poindividualDao);
    }

    public String generateNextIndividualId() {
        return poindividualDao.genNextIndividualId();
    }

    public Poindividual getPoindividual(String punishobjectid) {
        return poindividualDao.getPoindividual(punishobjectid);
    }
}

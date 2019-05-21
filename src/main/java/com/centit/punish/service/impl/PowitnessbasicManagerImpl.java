package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PowitnessbasicDao;
import com.centit.punish.po.Powitnessbasic;
import com.centit.punish.service.PowitnessbasicManager;

public class PowitnessbasicManagerImpl extends
        BaseEntityManagerImpl<Powitnessbasic> implements PowitnessbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PowitnessbasicManager.class);

    private PowitnessbasicDao powitnessbasicDao;

    public void setPowitnessbasicDao(PowitnessbasicDao baseDao) {
        this.powitnessbasicDao = baseDao;
        setBaseDao(this.powitnessbasicDao);
    }

}

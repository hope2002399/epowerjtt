package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PomovebackbasicDao;
import com.centit.punish.po.Pomovebackbasic;
import com.centit.punish.service.PomovebackbasicManager;

public class PomovebackbasicManagerImpl extends
        BaseEntityManagerImpl<Pomovebackbasic> implements
        PomovebackbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PomovebackbasicManager.class);

    private PomovebackbasicDao pomovebackbasicDao;

    public void setPomovebackbasicDao(PomovebackbasicDao baseDao) {
        this.pomovebackbasicDao = baseDao;
        setBaseDao(this.pomovebackbasicDao);
    }

}

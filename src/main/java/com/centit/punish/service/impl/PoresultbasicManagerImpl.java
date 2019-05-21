package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoresultbasicDao;
import com.centit.punish.po.Poresultbasic;
import com.centit.punish.service.PoresultbasicManager;

public class PoresultbasicManagerImpl extends
        BaseEntityManagerImpl<Poresultbasic> implements PoresultbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoresultbasicManager.class);

    private PoresultbasicDao poresultbasicDao;

    public void setPoresultbasicDao(PoresultbasicDao baseDao) {
        this.poresultbasicDao = baseDao;
        setBaseDao(this.poresultbasicDao);
    }

}

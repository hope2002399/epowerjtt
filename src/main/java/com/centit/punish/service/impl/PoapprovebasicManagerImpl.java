package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoapprovebasicDao;
import com.centit.punish.po.Poapprovebasic;
import com.centit.punish.service.PoapprovebasicManager;

public class PoapprovebasicManagerImpl extends
        BaseEntityManagerImpl<Poapprovebasic> implements PoapprovebasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PoapprovebasicManager.class);

    private PoapprovebasicDao poapprovebasicDao;

    public void setPoapprovebasicDao(PoapprovebasicDao baseDao) {
        this.poapprovebasicDao = baseDao;
        setBaseDao(this.poapprovebasicDao);
    }

}

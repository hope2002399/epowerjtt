package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoundertakebasicDao;
import com.centit.punish.po.Poundertakebasic;
import com.centit.punish.service.PoundertakebasicManager;

public class PoundertakebasicManagerImpl extends
        BaseEntityManagerImpl<Poundertakebasic> implements
        PoundertakebasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PoundertakebasicManager.class);

    private PoundertakebasicDao poundertakebasicDao;

    public void setPoundertakebasicDao(PoundertakebasicDao baseDao) {
        this.poundertakebasicDao = baseDao;
        setBaseDao(this.poundertakebasicDao);
    }

}

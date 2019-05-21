package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoacceptinfoDao;
import com.centit.punish.po.Poacceptinfo;
import com.centit.punish.service.PoacceptinfoManager;

public class PoacceptinfoManagerImpl extends
        BaseEntityManagerImpl<Poacceptinfo> implements PoacceptinfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoacceptinfoManager.class);

    private PoacceptinfoDao poacceptinfoDao;

    public void setPoacceptinfoDao(PoacceptinfoDao baseDao) {
        this.poacceptinfoDao = baseDao;
        setBaseDao(this.poacceptinfoDao);
    }

}

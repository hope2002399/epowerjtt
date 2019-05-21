package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoreceiptinfoDao;
import com.centit.punish.po.Poreceiptinfo;
import com.centit.punish.service.PoreceiptinfoManager;

public class PoreceiptinfoManagerImpl extends
        BaseEntityManagerImpl<Poreceiptinfo> implements PoreceiptinfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoreceiptinfoManager.class);

    private PoreceiptinfoDao poreceiptinfoDao;

    public void setPoreceiptinfoDao(PoreceiptinfoDao baseDao) {
        this.poreceiptinfoDao = baseDao;
        setBaseDao(this.poreceiptinfoDao);
    }

}

package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PodetainwptransinfoDao;
import com.centit.punish.po.Podetainwptransinfo;
import com.centit.punish.service.PodetainwptransinfoManager;

public class PodetainwptransinfoManagerImpl extends
        BaseEntityManagerImpl<Podetainwptransinfo> implements
        PodetainwptransinfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PodetainwptransinfoManager.class);

    private PodetainwptransinfoDao podetainwptransinfoDao;

    public void setPodetainwptransinfoDao(PodetainwptransinfoDao baseDao) {
        this.podetainwptransinfoDao = baseDao;
        setBaseDao(this.podetainwptransinfoDao);
    }

}

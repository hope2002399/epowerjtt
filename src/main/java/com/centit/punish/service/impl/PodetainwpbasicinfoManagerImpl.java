package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PodetainwpbasicinfoDao;
import com.centit.punish.po.Podetainwpbasicinfo;
import com.centit.punish.service.PodetainwpbasicinfoManager;

public class PodetainwpbasicinfoManagerImpl extends
        BaseEntityManagerImpl<Podetainwpbasicinfo> implements
        PodetainwpbasicinfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PodetainwpbasicinfoManager.class);

    private PodetainwpbasicinfoDao podetainwpbasicinfoDao;

    public void setPodetainwpbasicinfoDao(PodetainwpbasicinfoDao baseDao) {
        this.podetainwpbasicinfoDao = baseDao;
        setBaseDao(this.podetainwpbasicinfoDao);
    }

    public String genNextWpId() {
        return this.podetainwpbasicinfoDao.genNextWpId();
    }
}

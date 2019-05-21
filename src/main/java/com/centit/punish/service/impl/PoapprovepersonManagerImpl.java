package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoapprovepersonDao;
import com.centit.punish.po.Poapproveperson;
import com.centit.punish.service.PoapprovepersonManager;

public class PoapprovepersonManagerImpl extends
        BaseEntityManagerImpl<Poapproveperson> implements
        PoapprovepersonManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PoapprovepersonManager.class);

    private PoapprovepersonDao poapprovepersonDao;

    public void setPoapprovepersonDao(PoapprovepersonDao baseDao) {
        this.poapprovepersonDao = baseDao;
        setBaseDao(this.poapprovepersonDao);
    }

}

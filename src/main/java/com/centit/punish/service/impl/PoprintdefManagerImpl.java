package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoprintdefDao;
import com.centit.punish.po.Poprintdef;
import com.centit.punish.service.PoprintdefManager;

public class PoprintdefManagerImpl extends BaseEntityManagerImpl<Poprintdef>
        implements PoprintdefManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoprintdefManager.class);

    private PoprintdefDao poprintdefDao;

    public void setPoprintdefDao(PoprintdefDao baseDao) {
        this.poprintdefDao = baseDao;
        setBaseDao(this.poprintdefDao);
    }

}

package com.centit.powerbase.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerbase.dao.LawmenannualDao;
import com.centit.powerbase.po.Lawmenannual;
import com.centit.powerbase.service.LawmenannualManager;

public class LawmenannualManagerImpl extends
        BaseEntityManagerImpl<Lawmenannual> implements LawmenannualManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawmenannualManager.class);

    private LawmenannualDao lawmenannualDao;

    public void setLawmenannualDao(LawmenannualDao baseDao) {
        this.lawmenannualDao = baseDao;
        setBaseDao(this.lawmenannualDao);
    }

}

package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PoexcucebasicDao;
import com.centit.punish.po.Poexcucebasic;
import com.centit.punish.service.PoexcucebasicManager;

public class PoexcucebasicManagerImpl extends
        BaseEntityManagerImpl<Poexcucebasic> implements PoexcucebasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoexcucebasicManager.class);

    private PoexcucebasicDao poexcucebasicDao;

    public void setPoexcucebasicDao(PoexcucebasicDao baseDao) {
        this.poexcucebasicDao = baseDao;
        setBaseDao(this.poexcucebasicDao);
    }

}

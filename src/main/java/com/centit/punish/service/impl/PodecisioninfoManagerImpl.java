package com.centit.punish.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PodecisioninfoDao;
import com.centit.punish.po.Podecisioninfo;
import com.centit.punish.service.PodecisioninfoManager;

public class PodecisioninfoManagerImpl extends
        BaseEntityManagerImpl<Podecisioninfo> implements PodecisioninfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PodecisioninfoManager.class);

    private PodecisioninfoDao podecisioninfoDao;

    public void setPodecisioninfoDao(PodecisioninfoDao baseDao) {
        this.podecisioninfoDao = baseDao;
        setBaseDao(this.podecisioninfoDao);
    }

}

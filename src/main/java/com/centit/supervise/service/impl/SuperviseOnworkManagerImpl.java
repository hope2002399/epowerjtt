package com.centit.supervise.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.supervise.dao.SuperviseOnworkDao;
import com.centit.supervise.po.SuperviseOnwork;
import com.centit.supervise.service.SuperviseOnworkManager;

public class SuperviseOnworkManagerImpl extends
        BaseEntityManagerImpl<SuperviseOnwork> implements
        SuperviseOnworkManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(SuperviseOnworkManager.class);

    private SuperviseOnworkDao superviseOnworkDao;

    public void setSuperviseOnworkDao(SuperviseOnworkDao baseDao) {
        this.superviseOnworkDao = baseDao;
        setBaseDao(this.superviseOnworkDao);
    }

}

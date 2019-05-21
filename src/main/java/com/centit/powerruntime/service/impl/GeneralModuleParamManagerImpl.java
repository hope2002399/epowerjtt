package com.centit.powerruntime.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.GeneralModuleParamDao;
import com.centit.powerruntime.po.GeneralModuleParam;
import com.centit.powerruntime.service.GeneralModuleParamManager;

public class GeneralModuleParamManagerImpl extends
        BaseEntityManagerImpl<GeneralModuleParam> implements
        GeneralModuleParamManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(GeneralModuleParamManager.class);

    private GeneralModuleParamDao generalModuleParamDao;

    public void setGeneralModuleParamDao(GeneralModuleParamDao baseDao) {
        this.generalModuleParamDao = baseDao;
        setBaseDao(this.generalModuleParamDao);
    }

}

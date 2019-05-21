package com.centit.dispatchdoc.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.dispatchdoc.dao.VIncomeDocListDao;
import com.centit.dispatchdoc.po.VIncomeDocList;
import com.centit.dispatchdoc.service.VIncomeDocListManager;

public class VIncomeDocListManagerImpl extends
        BaseEntityManagerImpl<VIncomeDocList> implements VIncomeDocListManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VIncomeDocListManager.class);

    private VIncomeDocListDao VIncomeDocListDao;

    public void setVIncomeDocListDao(VIncomeDocListDao baseDao) {
        this.VIncomeDocListDao = baseDao;
        setBaseDao(this.VIncomeDocListDao);
    }

    public List<VIncomeDocList> getDocRelativeList(String dispatchNo) {
        return VIncomeDocListDao.getDocRelativeList(dispatchNo);
    }

}

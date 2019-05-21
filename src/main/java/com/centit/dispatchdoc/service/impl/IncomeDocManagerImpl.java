package com.centit.dispatchdoc.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.dispatchdoc.dao.IncomeDocDao;
import com.centit.dispatchdoc.po.IncomeDoc;
import com.centit.dispatchdoc.service.IncomeDocManager;

public class IncomeDocManagerImpl extends BaseEntityManagerImpl<IncomeDoc>
        implements IncomeDocManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(IncomeDocManager.class);

    private IncomeDocDao incomeDocDao;

    public void setIncomeDocDao(IncomeDocDao baseDao) {
        this.incomeDocDao = baseDao;
        setBaseDao(this.incomeDocDao);
    }

    public String getNextkey() {
        return "SW" + incomeDocDao.getNextKeyBySequence("S_INCOME_DOC", 14);
    }

    public IncomeDoc getIncomeDoc(String internalNo, String itemId) {
        return incomeDocDao.getIncomeDoc(internalNo, itemId);
    }

    public String getJSONDocumentNames(String djId) {

        return "";
    }
}

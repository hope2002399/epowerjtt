package com.centit.dispatchdoc.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.dispatchdoc.po.IncomeDoc;

public interface IncomeDocManager extends BaseEntityManager<IncomeDoc> {
    /**
     * 登记编号
     * 
     * @return
     */
    public String getNextkey();

    public IncomeDoc getIncomeDoc(String internalNo, String itemId);

    public String getJSONDocumentNames(String djId);
}

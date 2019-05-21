package com.centit.dispatchdoc.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.dispatchdoc.po.VIncomeDocList;

public interface VIncomeDocListManager extends
        BaseEntityManager<VIncomeDocList> {
    public List<VIncomeDocList> getDocRelativeList(String dispatchNo);

}

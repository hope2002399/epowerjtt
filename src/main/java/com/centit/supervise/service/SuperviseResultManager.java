package com.centit.supervise.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.supervise.po.SuperviseResult;

public interface SuperviseResultManager extends
        BaseEntityManager<SuperviseResult> {

    public SuperviseResult getSuperviseResultBySuperviseNo(String superviseNo);

    public String getNextKeyId();

}

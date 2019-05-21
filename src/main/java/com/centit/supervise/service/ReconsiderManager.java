package com.centit.supervise.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.supervise.po.Reconsider;

public interface ReconsiderManager extends BaseEntityManager<Reconsider> {

    public Reconsider getReconsiderByFlowId(Long flowInstId);

    public String getNextkey();

}

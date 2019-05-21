package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptDobasicMessage;

public interface OptDobasicMessageManager extends
        BaseEntityManager<OptDobasicMessage> {

    public String getDobasicMessageId();

}

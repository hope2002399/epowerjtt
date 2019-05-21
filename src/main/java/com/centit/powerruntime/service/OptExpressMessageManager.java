package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptExpressMessage;

public interface OptExpressMessageManager extends
        BaseEntityManager<OptExpressMessage> {

    public String getExpressMessageId();

    public OptExpressMessage getExpressMessageInfoBydjId(String djId);

    public void sendExpreeMessage(String expressid);

}

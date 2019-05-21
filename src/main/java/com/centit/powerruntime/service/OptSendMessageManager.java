package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptSendMessage;

public interface OptSendMessageManager extends
        BaseEntityManager<OptSendMessage> {
    public String getSendMessageId();
}

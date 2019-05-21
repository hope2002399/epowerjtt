package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptPickupMessage;

public interface OptPickupMessageManager extends BaseEntityManager<OptPickupMessage> 
{

    public String getPickupMessageId();

}

package com.centit.powerruntime.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerruntime.po.OptRelevancyResult;

public interface OptRelevancyResultManager extends BaseEntityManager<OptRelevancyResult> 
{

    public void saveResult(OptRelevancyResult relevancyResult);

    public void updateResult(OptRelevancyResult relevancyResult);
    
}

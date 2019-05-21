package com.centit.indicator.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.indicator.po.PmIndicator;

public interface PmIndicatorManager extends BaseEntityManager<PmIndicator> {
	public String indicatorList();
}

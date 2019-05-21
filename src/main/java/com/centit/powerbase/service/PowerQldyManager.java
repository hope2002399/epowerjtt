package com.centit.powerbase.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerbase.po.PowerQldy;

public interface PowerQldyManager extends BaseEntityManager<PowerQldy> {

    public PowerQldy getPowerQldyByBPowerItemId(String bPowerItemId);

}

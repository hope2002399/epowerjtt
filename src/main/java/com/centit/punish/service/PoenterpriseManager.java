package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Poenterprise;

public interface PoenterpriseManager extends BaseEntityManager<Poenterprise> {
    public String generateNextEnterpriseId();

    public Poenterprise getPoenterprise(String punishobjectid);
}

package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Podetainwpbasicinfo;

public interface PodetainwpbasicinfoManager extends
        BaseEntityManager<Podetainwpbasicinfo> {
    public String genNextWpId();
}

package com.centit.monitor.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.PunishResult;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public interface PunishResultManager extends BaseEntityManager<PunishResult> {

    public PunishResult getPunishResult(String internalNo, String orgId);
}

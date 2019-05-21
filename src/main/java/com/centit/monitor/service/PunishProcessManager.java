package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.PunishProcess;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public interface PunishProcessManager extends BaseEntityManager<PunishProcess> {
    public List<PunishProcess> listObjects(String internalNo, String orgId);

    public List<PunishProcess> listPunishProcessEx(String internalNo,
            String orgId, String xmlInFlowInfo);
}

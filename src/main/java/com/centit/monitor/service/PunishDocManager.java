package com.centit.monitor.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.monitor.po.PunishDoc;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public interface PunishDocManager extends BaseEntityManager<PunishDoc> {
    public List<PunishDoc> listObjects(String internalNo, String orgId);

    public List<PunishDoc> getProcessPunishDoc(String colname,
            String internalNo, String orgId, String noord, boolean b);
}

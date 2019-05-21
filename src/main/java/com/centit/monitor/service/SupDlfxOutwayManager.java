package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.SupDlfxOutway;

/**
 * 
 * TODO Class description should be added
 * 
 * @author zjh
 * @create 2013-12-17
 * @version
 */
public interface SupDlfxOutwayManager extends BaseEntityManager<SupDlfxOutway> {
    // 获取预报警信息
    public List<SupDlfxOutway> getSupDlfxOutWayManager(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public void UpdateSupDlfxOutwayInfo(SupDlfxOutway info);
}

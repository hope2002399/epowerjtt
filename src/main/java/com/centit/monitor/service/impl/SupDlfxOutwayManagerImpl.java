package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.SupDlfxOutwayDao;
import com.centit.monitor.po.SupDlfxOutway;
import com.centit.monitor.service.SupDlfxOutwayManager;

/**
 * 
 * TODO Class description should be added
 * 
 * @author zjh
 * @create 2013-12-17
 * @version
 */
public class SupDlfxOutwayManagerImpl extends
        BaseEntityManagerImpl<SupDlfxOutway> implements SupDlfxOutwayManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SupDlfxOutwayManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();
    private SupDlfxOutwayDao supDlfxOutwayDao;

    public void setSupDlfxOutwayDao(SupDlfxOutwayDao baseDao) {
        this.supDlfxOutwayDao = baseDao;
        setBaseDao(this.supDlfxOutwayDao);
    }

    // 获取预报警信息
    public List<SupDlfxOutway> getSupDlfxOutWayManager(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return supDlfxOutwayDao.getSupDlfxOutWayManager(filterMap, pageDesc);
    }

    // 获取预报警信息
    public void UpdateSupDlfxOutwayInfo(SupDlfxOutway info) {
        supDlfxOutwayDao.UpdateSupDlfxOutwayInfo(info);
    }
}

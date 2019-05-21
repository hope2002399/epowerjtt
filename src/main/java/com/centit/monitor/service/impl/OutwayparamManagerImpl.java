package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.OutwayparamDao;
import com.centit.monitor.po.Outwayparam;
import com.centit.monitor.service.OutwayparamManager;

public class OutwayparamManagerImpl extends BaseEntityManagerImpl<Outwayparam>
        implements OutwayparamManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OutwayparamManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private OutwayparamDao outwayparamDao;

    public void setOutwayparamDao(OutwayparamDao baseDao) {
        this.outwayparamDao = baseDao;
        setBaseDao(this.outwayparamDao);
    }

    // 获取outwayparamlist
    public List<Outwayparam> getOutWayParamList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return outwayparamDao.listObjects(filterMap, pageDesc);
    }

    // 调用对应的存储过程
    public boolean callCheck_warning(String procedureName, String countYear,
            String countMonth) {
        return outwayparamDao.callCheck_warning(procedureName, countYear,
                countMonth);
    }
}

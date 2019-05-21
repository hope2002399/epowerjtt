package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.LawsuitDao;
import com.centit.powerbase.po.Lawsuit;
import com.centit.powerbase.service.LawsuitManager;

public class LawsuitManagerImpl extends BaseEntityManagerImpl<Lawsuit>
        implements LawsuitManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawsuitManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private LawsuitDao lawsuitDao;

    public void setLawsuitDao(LawsuitDao baseDao) {
        this.lawsuitDao = baseDao;
        setBaseDao(this.lawsuitDao);
    }

    @Override
    public List<Lawsuit> Lawsuitlist(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return lawsuitDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public Lawsuit getUpdateNo(String lawsuitno) {
        
        return lawsuitDao.getObjectById(lawsuitno);
    }

}

package com.centit.powerbase.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.LawenforecaseDao;
import com.centit.powerbase.po.Lawenforecase;
import com.centit.powerbase.service.LawenforecaseManager;

public class LawenforecaseManagerImpl extends
        BaseEntityManagerImpl<Lawenforecase> implements LawenforecaseManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawenforecaseManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private LawenforecaseDao lawenforecaseDao;

    public void setLawenforecaseDao(LawenforecaseDao baseDao) {
        this.lawenforecaseDao = baseDao;
        setBaseDao(this.lawenforecaseDao);
    }

    @Override
    public List<Lawenforecase> LawenforecaseList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        
        return lawenforecaseDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public Lawenforecase getUpdateNo(String caseno) {
        
        return lawenforecaseDao.getObjectById(caseno);
    }

    @Override
    public void lawenforecaseSave(Lawenforecase phobject) {
        
        lawenforecaseDao.saveObject(phobject);
    }

    @Override
    public boolean CheckCasenoExist(String caseno) {
        
        return lawenforecaseDao.IsCasenoExist(caseno);
    }

}

package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.PamonthpunishDao;
import com.centit.monitor.po.Pamonthpunish;
import com.centit.monitor.service.PamonthpunishManager;

public class PamonthpunishManagerImpl extends
        BaseEntityManagerImpl<Pamonthpunish> implements PamonthpunishManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PamonthpunishManager.class);

    // private static final SysOptLog sysOptLog =
    // SysOptLogFactoryImpl.getSysOptLog();

    private PamonthpunishDao pamonthpunishDao;

    public void setPamonthpunishDao(PamonthpunishDao baseDao) {
        this.pamonthpunishDao = baseDao;
        setBaseDao(this.pamonthpunishDao);
    }

    @Override
    public List<Pamonthpunish> getPamonthpunishList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        
        return pamonthpunishDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public String generateNextPunishNo() {
        
        return pamonthpunishDao.genNextPunishNo();
    }

    @Override
    public String getauditResultbydata(String year, String month, String orgId) {
        
        return pamonthpunishDao.getauditResultbydata(year, month, orgId);
    }

    @Override
    public Pamonthpunish getUpdateNo(String punishNo) {
        
        return pamonthpunishDao.getObjectById(punishNo);
    }

    public void pamonthpunishSave(Pamonthpunish phobject) {
        
        pamonthpunishDao.saveObject(phobject);
    }

    @Override
    public Pamonthpunish getPamonthpunishinfo(String countYear,
            String countMonth, String orgId) {
        
        return pamonthpunishDao.getPamonthpunishinfo(countYear, countMonth,
                orgId);
    }

}

package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.PunishDao;
import com.centit.monitor.dao.VPunishDao;
import com.centit.monitor.dao.VPunishForListDao;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.po.VPunishForList;
import com.centit.monitor.service.PunishManager;

public class PunishManagerImpl extends BaseEntityManagerImpl<Punish> implements
        PunishManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishManager.class);
    private PunishDao punishDao;
    private VPunishDao vPunishDao;
    private VPunishForListDao vPunishForListDao;

    public void setvPunishDao(VPunishDao vPunishDao) {
        this.vPunishDao = vPunishDao;
    }

    public void setPunishDao(PunishDao baseDao) {
        this.punishDao = baseDao;
        setBaseDao(this.punishDao);
    }

    public void setVPunishForListDao(VPunishForListDao baseDao) {
        this.vPunishForListDao = baseDao;
        setBaseDao(this.punishDao);
    }

    public List<VPunish> listVPunish(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vPunishDao.listObjects(filterMap, pageDesc);
    }

    public List<VPunish> listVPunishResult(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vPunishDao.listResultObjects(filterMap, pageDesc);
    }

    public List<VPunish> getPunishList(Map<String, Object> filterMap) {
        return vPunishDao.getPunishList(filterMap);
    }

    public List<VPunish> getPunishList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vPunishDao.getPunishList(filterMap, pageDesc);
    }

    public VPunish getPunish(String no) {
        return vPunishDao.getPunish(no);
    }

    public Punish getPunishInfo(String no) {
        return punishDao.getPunishInfo(no);
    }

    public void punishSave(Punish info) {
        this.saveObject(info);
    }

    public Punish getPunishInfo(String internalNo, String orgId) {
        
        return punishDao.getPunish(internalNo, orgId);
    }
    
    public List getApplyReg(String internalNo){
        return punishDao.getApplyReg(internalNo);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public List getPunishlistsize(String begintime, String endtime) {

        return punishDao.getPunishlistsize(begintime, endtime);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getpunishalllist(String begintime, String endtime) {

        return punishDao.getpunishalllist(begintime, endtime);
    }

    @Override
    public List<VPunishForList> listVPunishForList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return vPunishForListDao.listVPunishForList(filterMap, pageDesc);
    }

    @Override
    public List<VPunishForList> listResultObjectsForList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return vPunishForListDao.listResultObjectsForList(filterMap, pageDesc);
    }

    @Override
    public VPunish getPunish(String internalNo, String orgId) {
        
        return vPunishDao.getPunish(internalNo, orgId);
    }
}

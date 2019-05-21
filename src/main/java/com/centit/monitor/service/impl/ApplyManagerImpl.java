package com.centit.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.dao.ApplyDao;
import com.centit.monitor.dao.VApplyDao;
import com.centit.monitor.dao.VApplyForListDao;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VApplyForList;
import com.centit.monitor.service.ApplyManager;

public class ApplyManagerImpl extends BaseEntityManagerImpl<Apply> implements
        ApplyManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyManager.class);
    private ApplyDao applyDao;
    private VApplyDao vApplyDao;

    private VApplyForListDao vApplyForListDao;

    public void setVApplyDao(VApplyDao vApplyDao) {
        this.vApplyDao = vApplyDao;
    }

    public void setApplyDao(ApplyDao baseDao) {
        this.applyDao = baseDao;
        setBaseDao(this.applyDao);
    }

    public void setVApplyForListDao(VApplyForListDao vApplyForListDao) {
        this.vApplyForListDao = vApplyForListDao;
    }

    public List<VApply> listVApply(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vApplyDao.listObjects(filterMap, pageDesc);
    }

    public List<VApply> listVApplyResult(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vApplyDao.listResultObjects(filterMap, pageDesc);
    }

    public Apply getApplyInfo(String internalNo, String itemId) {
        return applyDao.getApply(internalNo, itemId);
    }
    
    public List getApplyReg(String internalNo){
        return applyDao.getApplyReg(internalNo);
    }

    public Apply getApplyNew(String internalNo, String orgId) {
        return applyDao.getApplyNew(internalNo, orgId);
    }

    public List<VApply> getApplyList(Map<String, Object> filterMap) {
        return vApplyDao.getApplyList(filterMap);
    }

    public List<VApply> getApplyList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vApplyDao.getApplyList(filterMap, pageDesc);
    }

    public VApply getApply(String no) {
        return vApplyDao.getApply(no);
    }

    public Apply getApplyInfo(String no) {
        return applyDao.getApplyInfo(no);
    }

    public void applySave(Apply info) {
        this.saveObject(info);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getApplylistsize(String begintime, String endtime) {
        return applyDao.getApplylistsize(begintime, endtime);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getapplyalllist(String begintime, String endtime) {
        return applyDao.getapplyalllist(begintime, endtime);
    }

    @Override
    public List<VApplyForList> listVApplyForList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        return vApplyForListDao.listVApplyForList(filterMap, pageDesc);
    }

    @Override
    public VApply getApply(String internalNo, String itemId) {
        
        return vApplyDao.getApply(internalNo, itemId);
    }

}

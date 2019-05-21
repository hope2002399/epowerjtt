package com.centit.powerruntime.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.dao.OptIdeaInfoDao;
import com.centit.powerruntime.dao.OptProcAttentionDao;
import com.centit.powerruntime.dao.VProcAttentionDao;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcAttention;
import com.centit.powerruntime.po.VProcAttention;
import com.centit.powerruntime.service.OptProcAttentionManager;

public class OptProcAttentionManagerImpl extends
        BaseEntityManagerImpl<OptProcAttention> implements
        OptProcAttentionManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(OptProcAttentionManager.class);

    private OptProcAttentionDao optProcAttentionDao;
    private VProcAttentionDao vProcAttentionDao;

    private OptIdeaInfoDao optIdeaInfoDao;

    public void setOptProcAttentionDao(OptProcAttentionDao baseDao) {
        this.optProcAttentionDao = baseDao;
        setBaseDao(this.optProcAttentionDao);
    }

    public List<VProcAttention> listProcAttention(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return vProcAttentionDao.listObjects(filterMap, pageDesc);
    }

    public void setvProcAttentionDao(VProcAttentionDao vProcAttentionDao) {
        this.vProcAttentionDao = vProcAttentionDao;
    }

    @Override
    public void saveAtt(OptProcAttention optProcAttention) {
        optProcAttentionDao.saveObject(optProcAttention);

    }

    @Override
    public List<OptProcAttention> getAttentionsByDjId(String djId) {
        return optProcAttentionDao.getAttentionsByDjId(djId);
    }

    public void saveOptIdeaInfo(OptIdeaInfo ideaInfo) {
        ideaInfo.setProcid(optIdeaInfoDao.getNextIdeaPK());
        ideaInfo.setTransdate(new Date(System.currentTimeMillis()));
        optIdeaInfoDao.saveObject(ideaInfo);
    }

    public void setOptIdeaInfoDao(OptIdeaInfoDao optIdeaInfoDao) {
        this.optIdeaInfoDao = optIdeaInfoDao;
    }
}

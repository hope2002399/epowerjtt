package com.centit.powerruntime.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.HQLUtils;
import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.dao.OptIdeaInfoDao;
import com.centit.powerruntime.dao.OptProcAttentionDao;
import com.centit.powerruntime.dao.OptProcInfoDao;
import com.centit.powerruntime.dao.OptStuffInfoDao;
import com.centit.powerruntime.dao.VOptStuffInfoDao;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcAttention;
import com.centit.powerruntime.po.OptProcAttentionId;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.VOptStuffInfo;
import com.centit.powerruntime.service.OptProcInfoManager;

public class OptProcInfoManagerImpl extends BaseEntityManagerImpl<OptProcInfo>
        implements OptProcInfoManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptProcInfoManager.class);

    private OptProcInfoDao optProcInfoDao;

    public void setOptProcInfoDao(OptProcInfoDao baseDao) {
        this.optProcInfoDao = baseDao;
        setBaseDao(this.optProcInfoDao);
    }

    private OptStuffInfoDao optStuffInfoDao;
    private VOptStuffInfoDao vOptStuffInfoDao;

    public void setOptStuffInfoDao(OptStuffInfoDao baseDao) {
        this.optStuffInfoDao = baseDao;
    }

    private OptIdeaInfoDao optIdeaInfoDao;

    public void setOptIdeaInfoDao(OptIdeaInfoDao baseDao) {
        this.optIdeaInfoDao = baseDao;
    }

    private OptProcAttentionDao optProcAttentionDao;

    public void setOptProcAttentionDao(OptProcAttentionDao baseDao) {
        this.optProcAttentionDao = baseDao;
    }

    @Override
    public List<OptProcInfo> listProcessByDjId(String djId) {
        return optProcInfoDao.listObjects(
                "From OptProcInfo where djId = ? order by nodeInstId", djId);
    }

    @Override
    public List<OptStuffInfo> listStuffsByDjId(String djId) {
        return optStuffInfoDao.listObjects(
                "From OptStuffInfo where djId = ? order by uploadtime", djId);
    }

    public List<VOptStuffInfo> getStuffsByDjId(String djId) {
        return vOptStuffInfoDao.getStuffsByDjId(djId);
    }

    public List<OptStuffInfo> listStuffsByNode(Long nodeInstId) {
        return optStuffInfoDao.listObjects(
                "From OptStuffInfo where nodeInstId = ? order by uploadtime",
                nodeInstId);
    }

    public List<OptStuffInfo> listStuffsByType(String djId, String fileType) {
        return optStuffInfoDao
                .listObjects(
                        "From OptStuffInfo where djId = ? and filetype = ? order by uploadtime",
                        new Object[] { djId, fileType });
    }

    @Override
    public OptStuffInfo getStuffById(String id) {
        return optStuffInfoDao.getObjectById(id);
    }

    @Override
    public void saveStuffInfo(OptStuffInfo o) {
        optStuffInfoDao.saveObject(o);
    }

    @Override
    public void deleteStuffInfo(OptStuffInfo o) {
        optStuffInfoDao.deleteObject(o);
    }

    @Override
    public void deleteOptStuffInfoById(String id) {
        optStuffInfoDao.deleteObjectById(id);
    }

    public void isInuse(String djid) {
        optStuffInfoDao.isInuse(djid);
    }

    @Override
    public OptProcInfo getObjectByNodeInstId(long nodeInstId) {
        return optProcInfoDao.getObjectByNodeInstId(nodeInstId);
    }

    public List<OptIdeaInfo> listIdeaLogsByDjId(String djid) {
        return optIdeaInfoDao.listObjects(
                "From OptIdeaInfo where djId = ? order by procid ", djid);
    }

    @Override
    public void saveIdeaInfo(OptIdeaInfo o) {
        optIdeaInfoDao.saveObject(o);
    }

    public void saveIdeaInfo(OptIdeaInfo optIdeaInfo, OptProcInfo procInfo) {
        if (optIdeaInfo != null) {
            optIdeaInfo.setProcid(optIdeaInfoDao.getNextIdeaPK());
            if (procInfo != null) {
                optIdeaInfo.setDjId(procInfo.getDjId());
                optIdeaInfo.setNodeInstId(procInfo.getNodeInstId());
                optIdeaInfo.setNodeinststate(procInfo.getNodeinststate());
                optIdeaInfo.setNodename(procInfo.getNodename());
                optIdeaInfo.setTransdate(procInfo.getTransdate());
                optIdeaInfo.setTranscontent(procInfo.getTranscontent());
                optIdeaInfo.setUnitcode(procInfo.getUnitcode());
                optIdeaInfo.setUsercode(procInfo.getUsercode());
                optIdeaInfo.setIdeacode(procInfo.getIdeacode());
                optIdeaInfo.setTransidea(procInfo.getTransidea());
            }

            optIdeaInfoDao.saveObject(optIdeaInfo);
        }
    }

    @Override
    public void deleteIdeaInfo(OptIdeaInfo o) {
        optIdeaInfoDao.deleteObjectById(o);
    }

    @Override
    public void deleteIdeaInfoById(String id) {
        optIdeaInfoDao.deleteObjectById(id);
    }

    @Override
    public List<OptProcAttention> listProcAttentionsByDjId(String djid) {
        return optProcAttentionDao.listObjects(
                "From OptProcAttention where cid.djId = ? order by attsettime",
                djid);
    }

    @Override
    public void saveProcAttention(OptProcAttention o) {
        optProcAttentionDao.saveObject(o);
    }

    @Override
    public void deleteProcAttention(OptProcAttention o) {
        optProcAttentionDao.deleteObject(o);

    }

    @Override
    public void deleteProcAttentionById(String djid, String usercode) {
        optProcAttentionDao.deleteObjectById(new OptProcAttentionId(djid,
                usercode));
    }

    @Override
    public void deleteProcAttentionByDjId(String djid) {
        optProcAttentionDao.doExecuteHql(
                "delete From OptProcAttention where cid.djId = ?", djid);
    }

    @Override
    public void deleteStuffByiszhi(String sortId) {
        optStuffInfoDao.deleteStuffByiszhi(sortId);
    }

    @Override
    public void saveAtt(OptProcAttention optProcAttention) {
        optProcAttentionDao.saveObject(optProcAttention);
    }

    @Override
    public List<OptIdeaInfo> listIdeaLogsByDjIdAndFlowPhase(String djid,
            String flowPhase) {
        return optIdeaInfoDao.listObjects(
                "From OptIdeaInfo where djId = ? and flowPhase like "
                        + HQLUtils.buildHqlStringForSQL(flowPhase + "%")
                        + " order by procid desc", djid);
    }

    @Override
    public OptIdeaInfo getOptIdeaInfoByNodeInstId(long nodeInstId) {
        return optIdeaInfoDao.getObjectByNodeInstId(nodeInstId);
    }

    public List<OptStuffInfo> getStuffInfoList(OptProcInfo opi) {
        String djid = opi.getDjId();
        String nodeinstid = opi.getNodeInstId().toString();
        List<OptStuffInfo> retlist = this.optStuffInfoDao
                .getStuffInfoListByNodeinstid(djid, nodeinstid);
        return retlist;
    }

    @Override
    public List<OptStuffInfo> listStuffsByArchiveType(String djId,
            String archiveType) {
        return optStuffInfoDao
                .listObjects(
                        "From OptStuffInfo where djId = ? and archivetype = ? order by uploadtime",
                        new Object[] { djId, archiveType });
    }

    @Override
    public OptStuffInfo getStuffByIDs(String djId, String sortId) {
        
        List<OptStuffInfo> list = optStuffInfoDao
                .listObjects(
                        "From OptStuffInfo where djId = ? and sortId = ? order by uploadtime",
                        new Object[] { djId, sortId });
        if (list.size() > 0) {
            return (OptStuffInfo) list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<OptStuffInfo> getStuffInfoListBySortID(String djId,
            String sortId) {
        
        return optStuffInfoDao
                .listObjects(
                        "From OptStuffInfo where djId = ? and sortId = ? order by uploadtime",
                        new Object[] { djId, sortId });
    }

    public VOptStuffInfoDao getvOptStuffInfoDao() {
        return vOptStuffInfoDao;
    }

    public void setvOptStuffInfoDao(VOptStuffInfoDao vOptStuffInfoDao) {
        this.vOptStuffInfoDao = vOptStuffInfoDao;
    }
}

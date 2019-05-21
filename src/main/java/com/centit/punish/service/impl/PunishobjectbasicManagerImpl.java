package com.centit.punish.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.punish.dao.PunishobjectbasicDao;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PunishobjectbasicManager;

public class PunishobjectbasicManagerImpl extends
        BaseEntityManagerImpl<Punishobjectbasic> implements
        PunishobjectbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PunishobjectbasicManager.class);

    private PunishobjectbasicDao punishobjectbasicDao;

    public void setPunishobjectbasicDao(PunishobjectbasicDao baseDao) {
        this.punishobjectbasicDao = baseDao;
        setBaseDao(this.punishobjectbasicDao);
    }

    public Punishobjectbasic getPunishBaseByFlowId(Long flowinstid) {
        return punishobjectbasicDao.getPunishBaseByFlowId(flowinstid);
    }

    public String generateNextPunishObjectId() {
        return punishobjectbasicDao.genNextPunishObjectId();
    }

    /**
     * 更新处罚项目种类数量
     */
    public void updatepunishNum(String punishObjectID, String state) {
        punishobjectbasicDao.updatepunishNum(punishObjectID, state);
    }

    public void updateIsisSurpass(String punishObjectID, String isSurpass) {
        Punishobjectbasic saveobject = punishobjectbasicDao
                .getObjectById(punishObjectID);
        saveobject.setIssurpass(Long.parseLong(isSurpass));
        punishobjectbasicDao.saveObject(saveobject);
    }

    public String getNextAjbh() {
        String sKey = "00000000000"
                + punishobjectbasicDao.getNextValueOfSequence("ANJIANBIANHAO");
        return sKey.substring(sKey.length() - 10);
    }

    @Override
    public int getNumOfsameModel(String codeModel, String year) {
        return punishobjectbasicDao.getNumOfsameModel(codeModel, year);
    }

    @Override
    public List<Punishobjectbasic> listPunishObjectBasics(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        
        return punishobjectbasicDao.listPunishObjectBasics(filterMap, pageDesc);
    }

    public Punishobjectbasic getPunishobjectid(String punishobjectid) {
        return punishobjectbasicDao.getPunishobjectid(punishobjectid);
    }

}

package com.centit.punish.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PctypeDao;
import com.centit.punish.po.Pctype;
import com.centit.punish.service.PctypeManager;

public class PctypeManagerImpl extends BaseEntityManagerImpl<Pctype> implements
        PctypeManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PctypeManager.class);

    private PctypeDao pctypeDao;

    public void setPctypeDao(PctypeDao baseDao) {
        this.pctypeDao = baseDao;
        setBaseDao(this.pctypeDao);
    }

    public Pctype getObjectByClassId(String punishclassid) {

        return pctypeDao.getObjectByClassId(punishclassid);
    }

    public Pctype getObjectByItemsId(String punishclassid, String punishtypeid) {
        return pctypeDao.getObjectByItemsId(punishclassid, punishtypeid);
    }

    public List<Pctype> listPcType(String punishclassid) {
        return pctypeDao.listPcType(punishclassid);
    }

    @SuppressWarnings("rawtypes")
    public List<Map> listPunishType(String punishclassid, String degreeno) {
        return pctypeDao.listPunishType(punishclassid, degreeno);
    }

    public List<Pctype> listPcTypeInUse(String punishclassid) {
        return pctypeDao.listPcTypeInUse(punishclassid);
    }
}

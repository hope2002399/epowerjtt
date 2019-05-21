package com.centit.punish.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.punish.dao.PunishrecordparamDao;
import com.centit.punish.po.Punishrecordparam;
import com.centit.punish.service.PunishrecordparamManager;

public class PunishrecordparamManagerImpl extends
        BaseEntityManagerImpl<Punishrecordparam> implements
        PunishrecordparamManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PunishrecordparamManager.class);

    private PunishrecordparamDao punishrecordparamDao;

    public void setPunishrecordparamDao(PunishrecordparamDao baseDao) {
        this.punishrecordparamDao = baseDao;
        setBaseDao(this.punishrecordparamDao);
    }

    // 处罚备案参数管理列表
    public List<Punishrecordparam> punishrecordparamList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return punishrecordparamDao.getpunishrecordparamList(filterMap,
                pageDesc);
        // listObjects(filterMap, pageDesc);
    }

    // 保存 处罚备案参数
    public void punishrecordparamSave(Punishrecordparam info) {
        punishrecordparamDao.saveObject(info);
    }

}

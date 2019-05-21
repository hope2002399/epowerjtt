package com.centit.punish.service.impl;

import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.punish.dao.PofinishbasicDao;
import com.centit.punish.dao.PunishobjectbasicDao;
import com.centit.punish.po.Pofinishbasic;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.service.PofinishbasicManager;

public class PofinishbasicManagerImpl extends
        BaseEntityManagerImpl<Pofinishbasic> implements PofinishbasicManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PofinishbasicManager.class);

    private PofinishbasicDao pofinishbasicDao;
    private PunishobjectbasicDao punishobjectbasicDao;

    public void setPofinishbasicDao(PofinishbasicDao baseDao) {
        this.pofinishbasicDao = baseDao;
        setBaseDao(this.pofinishbasicDao);
    }

    public void setPunishobjectbasicDao(
            PunishobjectbasicDao punishobjectbasicDao) {
        this.punishobjectbasicDao = punishobjectbasicDao;
    }

    @Override
    public String getPunishReultByExtraCode(String punishobjectid,
            String punishType) {
        DecimalFormat dt = null;
        if ("3".equals(punishType)) {
            dt = new DecimalFormat("#0.00#");
        } else {
            dt = new DecimalFormat("#0.#");
        }
        Punishobjectbasic bean = punishobjectbasicDao
                .getObjectById(punishobjectid);

        return dt.format(pofinishbasicDao.getPunishReultByExtraCode(bean,
                punishobjectid, punishType));
    }

}

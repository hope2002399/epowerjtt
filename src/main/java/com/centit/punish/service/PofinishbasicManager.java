package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Pofinishbasic;

public interface PofinishbasicManager extends BaseEntityManager<Pofinishbasic> {
    /**
     * 根据处罚业务流水号、处罚类别，获取对应的处罚值
     * 
     * @param punishobjectid
     * @param punishType
     * @return
     */
    public String getPunishReultByExtraCode(String punishobjectid,
            String punishType);

}

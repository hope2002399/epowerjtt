package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Popunishbasic;

public interface PopunishbasicManager extends BaseEntityManager<Popunishbasic> {
    /**
     * 根据处罚流水号，获取案件处罚信息
     * 
     * @param punishobjectid
     * @return
     */
    public Popunishbasic getObjectByPunishobjectid(String punishobjectid);

}

package com.centit.punish.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Potranslawbasic;

public interface PotranslawbasicManager extends
        BaseEntityManager<Potranslawbasic> {
    /**
     * 获取处罚种类编码
     * 
     * @param punishobjectid
     * @return
     */
    public String getAllpunishClassID(String punishobjectid);

    public List<Potranslawbasic> getPotranslawbasicsbyId(String punishobjectid);

    public void updatePunishObjectIsSurpass(String punishObjectID);

    public void updatePOTransLawBasic(String punishObjectID, String item_id,
            String degreeNo);

    /**
     * 
     * @param item_id
     * @param version
     * @param degreeNo
     * @param freeUmpire
     * @return
     */
    public String isSurpassFreeUmpire(String item_id, Long version,
            String degreeNo, String[] freeUmpire);

    public void insertpunishBasicInfo(String punishObjectID, String item_id,
            String[] freeUmpire, String degreeNo, String isSurpass,
            String disobeyItem, String stepWorkID, String poDiscussType);

    /**
     * 删除处罚类型项目
     * 
     * @param punishObjectID
     * @param item_id
     */
    public void deletePunishClass(String punishObjectID, String item_id);

    public void initPunishInfo(String punishObjectID, String item_id);

    public String getPunishAmout(String punishobjectid, String item_id);

    public String getOtherPunish(String punishobjectid, String item_id);

    public void updatePunishBasic(String punishObjectID, String item_id,
            String[] freeUmpire, String degreeNo);

    public Potranslawbasic getItem_idBypunishobjectid(String punishobjectid);
}

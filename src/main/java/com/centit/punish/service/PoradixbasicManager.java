package com.centit.punish.service;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Poradixbasic;

public interface PoradixbasicManager extends BaseEntityManager<Poradixbasic> {
    public String generateNextPoRadixId();

    /**
     * 
     * @param punishObjectID
     * @param item_id
     */
    public void initRadixBasic(String punishObjectID, String item_id);

    public String getDatavalueFromFdic(String catalogcode, String datacode);

    /**
     * 根据处罚流水号删除基数信息
     * 
     * @param punishobjectid
     */
    public boolean deleteObjectBypunishObjectID(String punishobjectid);

    public String getDataCodeFromFdic(String catalogcode, String extracode);

    public Poradixbasic getRadixBasic(String punishobjectid,
            String punishtypeid, String item_id);

    /**
     * 根据处罚流水号获取对应基数信息
     * 
     * @param punishobjectid
     * @return
     */
    public Poradixbasic getRadixBasicByPunishobjectid(String punishobjectid);

}

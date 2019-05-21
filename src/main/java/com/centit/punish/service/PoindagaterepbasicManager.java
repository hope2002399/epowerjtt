package com.centit.punish.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.Potranslawbasic;

public interface PoindagaterepbasicManager extends
        BaseEntityManager<Poindagaterepbasic> {
    public List<Pcdef> getPcdefChooseList(String punishobjectid,
            String s_punishclasscode, String s_punishclassname,
            String primaryunit);

    /**
     * 获取处罚意见
     * 
     * @param punishobjectid
     * @param item_id
     * @return
     */
    public String getPunishOpinion(String punishobjectid, String item_id);

    public List<Pcfreeumpiretype> getFreeUmpireList(String punishobjectid,
            String item_id, Long version, Long degreeno);

    public List<Potranslawbasic> getPunishListByID(String punishobjectid);

    /**
     * 2个或2个以上的处罚项目时，做出的最终处罚意见
     * 
     * @param punishobjectid
     * @param item_id
     * @return
     */
    public String getIndagateRepResult(String punishobjectid, String item_id);

    public String getDisobeyItem(String punishobjectid, String otherdisobeyitem);

    /**
     * 获取自由裁量参考标准
     * 
     * @param item_id
     * @param version
     * @param degreeno
     * @return
     */
    public List<Pcfreeumpiretype> getFreeUmpireBZList(String item_id,
            Long version, String degreeno);

}

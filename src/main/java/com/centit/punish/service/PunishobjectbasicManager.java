package com.centit.punish.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.Punishobjectbasic;

public interface PunishobjectbasicManager extends
        BaseEntityManager<Punishobjectbasic> {
    /**
     * 根据流程实例编号获取案件信息
     * 
     * @param flowinstid
     * @return
     */
    public Punishobjectbasic getPunishBaseByFlowId(Long flowinstid);

    /** 生成PunishObjectBasic(案件信息)表下一个Punishobjectid值 lkm2012-12-06 **/
    public String generateNextPunishObjectId();

    /**
     * 更新处罚项目种类数量
     * 
     * @param punishObjectID
     * @param state
     */
    public void updatepunishNum(String punishObjectID, String state);

    public void updateIsisSurpass(String punishObjectID, String isSurpass);

    public String getNextAjbh();

    public int getNumOfsameModel(String codeModel, String year);

    /**
     * 查询处罚查看
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<Punishobjectbasic> listPunishObjectBasics(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public Punishobjectbasic getPunishobjectid(String punishobjectid);

}

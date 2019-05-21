package com.centit.punish.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.Pcdef;

public interface PcdefManager extends BaseEntityManager<Pcdef> {

    public String generateNextPunishClassID();

    public Pcdef getObjectByItemId(String punishclasscode);

    public List<Pcdef> listPcdef(Map<String, Object> filterMap,
            PageDesc pageDesc);

    // 根据处罚项目类别编号s获得处罚项目类别
    public String getPunishclassname(String punishClassIDs);

    public String getpunishItemType(String punishObjectID, String punishClassID);

    public List<Pcdef> listPcdefUsingOrg(String unitcode, String anyou);
}

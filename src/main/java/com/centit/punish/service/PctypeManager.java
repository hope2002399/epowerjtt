package com.centit.punish.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.punish.po.Pctype;

public interface PctypeManager extends BaseEntityManager<Pctype> {
    public Pctype getObjectByClassId(String punishclassid);

    public Pctype getObjectByItemsId(String punishclassid, String punishtypeid);

    public List<Pctype> listPcType(String punishclassid);

    @SuppressWarnings("rawtypes")
    public List<Map> listPunishType(String punishclassid, String degreeno);

    public List<Pctype> listPcTypeInUse(String punishclassid);
}

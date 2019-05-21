package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Pamonthpunish;

public interface PamonthpunishManager extends BaseEntityManager<Pamonthpunish> {

    public List<Pamonthpunish> getPamonthpunishList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public String generateNextPunishNo();

    public String getauditResultbydata(String year, String month, String orgId);

    public Pamonthpunish getUpdateNo(String punishNo);

    public void pamonthpunishSave(Pamonthpunish phobject);

    public Pamonthpunish getPamonthpunishinfo(String countYear,
            String countMonth, String orgId);

}

package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.po.VPunishForList;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-5-30
 * @version
 */
public interface PunishManager extends BaseEntityManager<Punish> {
    public List<VPunish> listVPunish(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<VPunish> listVPunishResult(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<VPunish> getPunishList(Map<String, Object> filterMap);

    public List<VPunish> getPunishList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public VPunish getPunish(String no);

    public VPunish getPunish(String internalNo, String orgId);

    public Punish getPunishInfo(String no);

    public Punish getPunishInfo(String internalNo, String orgId);

    public List getApplyReg(String internalNo);

    public void punishSave(Punish info);

    @SuppressWarnings("rawtypes")
    public List getPunishlistsize(String begintime, String endtime);

    @SuppressWarnings("rawtypes")
    public List getpunishalllist(String begintime, String endtime);

    public List<VPunishForList> listVPunishForList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    public List<VPunishForList> listResultObjectsForList(
            Map<String, Object> filterMap, PageDesc pageDesc);
}

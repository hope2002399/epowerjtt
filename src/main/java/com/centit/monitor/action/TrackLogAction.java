package com.centit.monitor.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.TrackLog;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VPunish;
import com.centit.monitor.po.VTrackLog;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.PunishManager;
import com.centit.monitor.service.TrackLogManager;
import com.centit.powerbase.po.Suppower;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;

public class TrackLogAction extends BaseEntityExtremeAction<TrackLog> {
    private static final long serialVersionUID = 1L;
    // manager
    private TrackLogManager trackLogMag;
    private ApplyManager applyManager;
    private PunishManager punishManager;
    private SysUserManager sysUserManager;
    private SysUnitManager sysUnitManager;
    // 变量
    private String flag = "1";// 默认为办件（1），案件（2）
    private String switch_time = "1";// 默认跟踪时间（1），取消时间（2）
    private List<FUnitinfo> unitList;
    private List<Suppower> itemList;
    private List<VPunish> punishList;
    private List<VApply> applyList;
    private List<VTrackLog> trackLogList;
    private VPunish punishInfo = new VPunish();
    private VApply applyInfo = new VApply();
    private TrackLog trackInfo = new TrackLog();
    private String bjNos;
    private String[] bjNoList;
    private String unitsJson;
    private String parentunit;
    private String fromsup;
    private String trackurl;

    public String getTrackurl() {
        return trackurl;
    }

    public void setTrackurl(String trackurl) {
        this.trackurl = trackurl;
    }

    public String getFromsup() {
        return fromsup;
    }

    public void setFromsup(String fromsup) {
        this.fromsup = fromsup;
    }

    public void setTrackLogManager(TrackLogManager basemgr) {
        trackLogMag = basemgr;
        this.setBaseEntityManager(trackLogMag);
    }

    /**
     * 保存单个跟踪办件
     * 
     * @return
     */
    public String trackLogSave() {
        TrackLog info = new TrackLog();
        Punish punish = new Punish();
        Apply apply = new Apply();
        FUserDetail user = ((FUserDetail) getLoginUser());
        info.setNo(object.getNo());
        info.setTrackoperator(user.getUsercode());
        info.setTracktime(DatetimeOpt.currentUtilDate());
        info.setTrackreason(object.getTrackreason());
        info.setTracktype(object.getTracktype());
        if ("1".equals(flag)) {
            info.setPowertype("1");
            info.setTrackno(trackLogMag.genNextChangeId());
            trackLogMag.trackLogSave(info);
            apply = applyManager.getApplyInfo(info.getNo());
            apply.setIsTrack("1");
            applyManager.applySave(apply);
        } else {
            info.setPowertype("2");
            info.setTrackno(trackLogMag.genNextChangeId());
            trackLogMag.trackLogSave(info);
            punish = punishManager.getPunishInfo(info.getNo());
            punish.setIsTrack("1");
            punishManager.punishSave(punish);
        }
        if ("1".equals(fromsup)) {
            if ("1".equals(flag)) {
                trackurl = "../monitor/apply!view.do?internalNo="
                        + apply.getInternalNo() + "&itemId="
                        + apply.getItemId() + "&orgId=" + apply.getOrgId();
            } else {
                trackurl = "../monitor/punish!view.do?internalNo="
                        + punish.getInternalNo() + "&itemId="
                        + punish.getItemId() + "&orgId=" + punish.getOrgId();
            }
            return "trackfromsup";
        } else {
            return this.trackLogSetList();
        }

    }

    /**
     * 保存N个跟踪办件
     * 
     * @return
     */
    public String trackLogSaves() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        if (!bjNos.isEmpty()) {
            bjNoList = bjNos.split(",");
        }
        if (null != bjNoList || bjNoList.length > 0) {
            for (int i = 0; i < bjNoList.length; i++) {
                TrackLog info = new TrackLog();
                Punish punish = new Punish();
                Apply apply = new Apply();
                String no = bjNoList[i];
                info.setNo(no);
                if ("1".equals(flag)) {
                    info.setPowertype("1");
                    apply = applyManager.getApplyInfo(info.getNo());
                    apply.setIsTrack("1");
                    applyManager.applySave(apply);
                } else {
                    info.setPowertype("2");
                    punish = punishManager.getPunishInfo(info.getNo());
                    punish.setIsTrack("1");
                    punishManager.punishSave(punish);
                }
                info.setTrackoperator(user.getUsercode());
                info.setTracktype(object.getTracktype());
                info.setTracktime(DatetimeOpt.currentUtilDate());
                info.setTrackreason(object.getTrackreason());
                info.setTrackno(trackLogMag.genNextChangeId());
                trackLogMag.trackLogSave(info);
            }
        }
        return this.trackLogSetList();
    }

    /**
     * 保存取消跟踪办件
     * 
     * @return
     */
    public String trackLogCancelSave() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        filterMap.put("trackno", object.getTrackno());
        TrackLog info = new TrackLog();
        Punish punish = new Punish();
        Apply apply = new Apply();
        FUserDetail user = ((FUserDetail) getLoginUser());
        info = trackLogMag.getTrackLog(filterMap);
        info.setUntrackoperator(user.getUsercode());
        info.setUntracktime(DatetimeOpt.currentUtilDate());
        info.setUntrackreason(object.getUntrackreason());
        if ("1".equals(flag)) {
            trackLogMag.trackLogSave(info);
            apply = applyManager.getApplyInfo(info.getNo());
            apply.setIsTrack(null);// 将重新设置为空
            applyManager.applySave(apply);
        } else {
            trackLogMag.trackLogSave(info);
            punish = punishManager.getPunishInfo(info.getNo());
            punish.setIsTrack(null);
            punishManager.punishSave(punish);
        }
        return this.trackLogList();
    }

    /**
     * 取消N个跟踪保存办件
     * 
     * @return
     */
    public String trackLogCancelSaves() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        if (!bjNos.isEmpty()) {
            bjNoList = bjNos.split(",");
        }
        if (null != bjNoList || bjNoList.length > 0) {
            for (int i = 0; i < bjNoList.length; i++) {
                TrackLog info = new TrackLog();
                Punish punish = new Punish();
                Apply apply = new Apply();
                String no = bjNoList[i];
                filterMap.put("no", no);
                filterMap.put("NP_untracktime", true);
                info = trackLogMag.getTrackLog(filterMap);
                if ("1".equals(flag)) {
                    apply = applyManager.getApplyInfo(info.getNo());
                    apply.setIsTrack(null);
                    applyManager.applySave(apply);
                } else {
                    punish = punishManager.getPunishInfo(info.getNo());
                    punish.setIsTrack(null);
                    punishManager.punishSave(punish);
                }
                info.setUntrackoperator(user.getUsercode());
                info.setUntracktime(DatetimeOpt.currentUtilDate());
                info.setUntrackreason(object.getUntrackreason());
                trackLogMag.trackLogSave(info);
            }
        }
        return this.trackLogList();
    }

    /**
     * 单个跟踪办件跳转页面
     * 
     * @return
     */
    public String trackLogTrack() {
        if ("1".equals(flag)) {// 办件
            applyInfo = applyManager.getApply(object.getNo());
        } else {// 案件
            punishInfo = punishManager.getPunish(object.getNo());
        }
        return "trackLogTrack";
    }

    /**
     * 单个办件取消跳转页面
     * 
     * @return
     */
    public String trackLogCancel() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        if ("1".equals(flag)) {// 办件
            applyInfo = applyManager.getApply(object.getNo());
        } else {// 案件
            punishInfo = punishManager.getPunish(object.getNo());
        }
        filterMap.put("trackno", object.getTrackno());
        trackInfo = trackLogMag.getTrackLog(filterMap);
        return "trackLogCancel";
    }

    /**
     * 多个跟踪办件跳转页面
     * 
     * @return
     */
    public String trackLogTracks() {
        this.setBjNos(this.bjNos);
        return "trackLogTracks";
    }

    /**
     * 多个取消办件跳转页面
     * 
     * @return
     */
    public String trackLogCancels() {
        this.setBjNos(this.bjNos);
        return "trackLogCancels";
    }

    /**
     * 查询办件、案件list
     * 
     * @return
     */
    public String trackLogSetList() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String unitCode = (String) filterMap.get("orgcode");
        if (!StringBaseOpt.isNvl(unitCode)) {
            String s_orgId = sysUnitManager.getObjectById(unitCode).getDepno();
            filterMap.put("orgId", s_orgId);
        }
        String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
        if ("true".equals(s_queryUnderUnit) && !StringUtils.isBlank(unitCode)) {
            filterMap.put("topunitcode", unitCode);
            filterMap.put("orgId", null);
        }
        if (!StringUtils.isBlank((String) filterMap.get("internalNo"))) {
            filterMap.put("internalNo", (String) filterMap.get("internalNo"));
        }
        if ("1".equals(flag)) {
            filterMap.put("NP_istrack", true);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            applyList = applyManager.getApplyList(filterMap, pageDesc);
            if (applyList != null) {
                totalRows = pageDesc.getTotalRows();
            }
        } else if ("2".equals(flag)) {
            filterMap.put("NP_istrack", true);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            punishList = punishManager.getPunishList(filterMap, pageDesc);
            if (punishList != null) {
                totalRows = pageDesc.getTotalRows();
            }
        }
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return "trackLogSetList";
    }

    /**
     * 查询办件、案件list
     * 
     * @return
     */
    public String trackLogList() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        String unitCode = (String) filterMap.get("orgcode");
        if ("1".equals(flag)) {
            filterMap.put("powertype", "1");
            if (!StringUtils.isBlank(unitCode)) {
                String s_orgId = sysUnitManager.getObjectById(unitCode)
                        .getDepno();
                filterMap.put("orgIdBj", s_orgId);
            }
            if (!StringUtils.isBlank((String) filterMap.get("internalNo"))) {
                filterMap.put("internalNoBj",
                        (String) filterMap.get("internalNo"));
            }
            String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
            if (!StringBaseOpt.isNvl(unitCode)
                    && "true".equals(s_queryUnderUnit)) {
                filterMap.put("topunitcode", unitCode);
                filterMap.put("orgIdBj", null);
            }
        } else if ("2".equals(flag)) {
            filterMap.put("powertype", "2");
            if (!StringUtils.isBlank(unitCode)) {
                String s_orgId = sysUnitManager.getObjectById(unitCode)
                        .getDepno();
                filterMap.put("orgIdAj", s_orgId);
            }
            if (!StringUtils.isBlank((String) filterMap.get("internalNo"))) {
                filterMap.put("internalNoAj",
                        (String) filterMap.get("internalNo"));
            }
            String s_queryUnderUnit = (String) filterMap.get("queryUnderUnit");
            if ("true".equals(s_queryUnderUnit)
                    && !StringUtils.isBlank(unitCode)) {
                filterMap.put("topunitcode", unitCode);
                filterMap.put("orgIdAj", null);
            }
        }
        filterMap.put("NP_untrackoperator", true);
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        trackLogList = trackLogMag.getTrackLogList(filterMap);
        if (trackLogList != null) {
            totalRows = trackLogList.size();
        }
        return "trackLogList";
    }

    /**
     * 跟踪查询办件、案件list
     * 
     * @return
     */
    public String trackLogViewList() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> remap = request.getParameterMap();
        Map<String, Object> filterMap = convertSearchColumn(remap);
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(user.getUsercode());
        String sParentUnit = dept.getUnitcode();
        filterMap.put("topunitcode", sParentUnit);
        unitList = sysUnitManager.getAllSubUnits(sParentUnit);
        if ("1".equals(flag)) {
            filterMap.put("powertype", "1");
        } else if ("2".equals(flag)) {
            filterMap.put("powertype", "2");
        }
        trackLogList = trackLogMag.getTrackLogList(filterMap);
        if (trackLogList != null) {
            totalRows = trackLogList.size();
        }
        return "trackLogViewList";
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public List<Suppower> getItemList() {
        return itemList;
    }

    public void setItemList(List<Suppower> itemList) {
        this.itemList = itemList;
    }

    public List<VPunish> getPunishList() {
        return punishList;
    }

    public void setPunishList(List<VPunish> punishList) {
        this.punishList = punishList;
    }

    public List<VApply> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<VApply> applyList) {
        this.applyList = applyList;
    }

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    public VPunish getPunishInfo() {
        return punishInfo;
    }

    public void setPunishInfo(VPunish punishInfo) {
        this.punishInfo = punishInfo;
    }

    public VApply getApplyInfo() {
        return applyInfo;
    }

    public void setApplyInfo(VApply applyInfo) {
        this.applyInfo = applyInfo;
    }

    public String getBjNos() {
        return bjNos;
    }

    public void setBjNos(String bjNos) {
        this.bjNos = bjNos;
    }

    public String[] getBjNoList() {
        return bjNoList;
    }

    public void setBjNoList(String[] bjNoList) {
        this.bjNoList = bjNoList;
    }

    public List<VTrackLog> getTrackLogList() {
        return trackLogList;
    }

    public void setTrackLogList(List<VTrackLog> trackLogList) {
        this.trackLogList = trackLogList;
    }

    public TrackLog getTrackInfo() {
        return trackInfo;
    }

    public void setTrackInfo(TrackLog trackInfo) {
        this.trackInfo = trackInfo;
    }

    public String getSwitch_time() {
        return switch_time;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

    public void setSwitch_time(String switch_time) {
        this.switch_time = switch_time;
    }

}

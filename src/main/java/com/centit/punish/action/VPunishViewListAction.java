package com.centit.punish.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.VPunishViewList;
import com.centit.punish.service.VPunishViewListManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;

public class VPunishViewListAction extends
        PunishCommonBizAction<VPunishViewList> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(VPunishViewListAction.class);
    private static final long serialVersionUID = 1L;
    private VPunishViewListManager VPunishViewListMag;

    private String unitsJson;
    private String parentunit;

    @Override
    public String list() {
        FUserDetail fuser = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserManager.getUserPrimaryUnit(fuser.getUsercode());
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        if (StringUtils.isBlank((String) filterMap.get("managedepid"))) {
            filterMap.put("managedepid", dept.getUnitcode());
        }
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        objList = VPunishViewListMag
                .listPunishObjectBasics(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        unitsJson = sysUnitManager.getAllSubUnitsJSON(dept.getUnitcode());
        parentunit = sysUnitManager.getObjectById(dept.getUnitcode())
                .getParentunit();
        return LIST;
    }

    /************************************ getter、setter ******************************************/

    public String getUnitsJson() {
        return unitsJson;
    }

    public String getParentunit() {
        return parentunit;
    }

    public void setParentunit(String parentunit) {
        this.parentunit = parentunit;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    public void setVPunishViewListManager(VPunishViewListManager basemgr) {
        VPunishViewListMag = basemgr;
        this.setBaseEntityManager(VPunishViewListMag);
    }

}

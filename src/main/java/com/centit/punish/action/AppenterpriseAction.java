package com.centit.punish.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Appenterprise;
import com.centit.punish.service.AppenterpriseManager;

public class AppenterpriseAction extends BaseEntityExtremeAction<Appenterprise> {
    private static final long serialVersionUID = 1L;
    private AppenterpriseManager appenterpriseMag;

    public void setAppenterpriseManager(AppenterpriseManager basemgr) {
        appenterpriseMag = basemgr;
        this.setBaseEntityManager(appenterpriseMag);
    }

}

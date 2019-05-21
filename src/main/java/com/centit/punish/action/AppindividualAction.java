package com.centit.punish.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Appindividual;
import com.centit.punish.service.AppindividualManager;

public class AppindividualAction extends BaseEntityExtremeAction<Appindividual> {
    private static final long serialVersionUID = 1L;
    private AppindividualManager appindividualMag;

    public void setAppindividualManager(AppindividualManager basemgr) {
        appindividualMag = basemgr;
        this.setBaseEntityManager(appindividualMag);
    }

}

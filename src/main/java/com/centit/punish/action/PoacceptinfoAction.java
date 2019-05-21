package com.centit.punish.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poacceptinfo;
import com.centit.punish.service.PoacceptinfoManager;

public class PoacceptinfoAction extends BaseEntityExtremeAction<Poacceptinfo> {
    private static final long serialVersionUID = 1L;
    private PoacceptinfoManager poacceptinfoMag;

    public void setPoacceptinfoManager(PoacceptinfoManager basemgr) {
        poacceptinfoMag = basemgr;
        this.setBaseEntityManager(poacceptinfoMag);
    }

}

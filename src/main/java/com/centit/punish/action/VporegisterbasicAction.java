package com.centit.punish.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Vporegisterbasic;
import com.centit.punish.service.VporegisterbasicManager;

public class VporegisterbasicAction extends
        BaseEntityExtremeAction<Vporegisterbasic> {
    private static final long serialVersionUID = 1L;
    private VporegisterbasicManager vporegisterbasicMag;

    public void setVporegisterbasicManager(VporegisterbasicManager basemgr) {
        vporegisterbasicMag = basemgr;
        this.setBaseEntityManager(vporegisterbasicMag);
    }

}

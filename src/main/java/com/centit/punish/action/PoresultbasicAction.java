package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poresultbasic;
import com.centit.punish.service.PoresultbasicManager;

public class PoresultbasicAction extends BaseEntityExtremeAction<Poresultbasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PoresultbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PoresultbasicManager poresultbasicMag;

    public void setPoresultbasicManager(PoresultbasicManager basemgr) {
        poresultbasicMag = basemgr;
        this.setBaseEntityManager(poresultbasicMag);
    }

}

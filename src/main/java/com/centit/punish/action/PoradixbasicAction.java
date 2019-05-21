package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.service.PoradixbasicManager;

public class PoradixbasicAction extends BaseEntityExtremeAction<Poradixbasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PoradixbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PoradixbasicManager poradixbasicMag;

    public void setPoradixbasicManager(PoradixbasicManager basemgr) {
        poradixbasicMag = basemgr;
        this.setBaseEntityManager(poradixbasicMag);
    }

}

package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Pomovebackbasic;
import com.centit.punish.service.PomovebackbasicManager;

public class PomovebackbasicAction extends
        BaseEntityExtremeAction<Pomovebackbasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PomovebackbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PomovebackbasicManager pomovebackbasicMag;

    public void setPomovebackbasicManager(PomovebackbasicManager basemgr) {
        pomovebackbasicMag = basemgr;
        this.setBaseEntityManager(pomovebackbasicMag);
    }

}

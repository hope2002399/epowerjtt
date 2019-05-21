package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.service.PotranslawbasicManager;

public class PotranslawbasicAction extends
        BaseEntityExtremeAction<Potranslawbasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PotranslawbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PotranslawbasicManager potranslawbasicMag;

    public void setPotranslawbasicManager(PotranslawbasicManager basemgr) {
        potranslawbasicMag = basemgr;
        this.setBaseEntityManager(potranslawbasicMag);
    }

}

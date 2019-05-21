package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poapprovebasic;
import com.centit.punish.service.PoapprovebasicManager;

public class PoapprovebasicAction extends
        BaseEntityExtremeAction<Poapprovebasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PoapprovebasicAction.class);
    private static final long serialVersionUID = 1L;
    private PoapprovebasicManager poapprovebasicMag;

    public void setPoapprovebasicManager(PoapprovebasicManager basemgr) {
        poapprovebasicMag = basemgr;
        this.setBaseEntityManager(poapprovebasicMag);
    }

}

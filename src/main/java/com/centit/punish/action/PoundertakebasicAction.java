package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poundertakebasic;
import com.centit.punish.service.PoundertakebasicManager;

public class PoundertakebasicAction extends
        BaseEntityExtremeAction<Poundertakebasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PoundertakebasicAction.class);
    private static final long serialVersionUID = 1L;
    private PoundertakebasicManager poundertakebasicMag;

    public void setPoundertakebasicManager(PoundertakebasicManager basemgr) {
        poundertakebasicMag = basemgr;
        this.setBaseEntityManager(poundertakebasicMag);
    }

}

package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poprintdef;
import com.centit.punish.service.PoprintdefManager;

public class PoprintdefAction extends BaseEntityExtremeAction<Poprintdef> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PoprintdefAction.class);
    private static final long serialVersionUID = 1L;
    private PoprintdefManager poprintdefMag;

    public void setPoprintdefManager(PoprintdefManager basemgr) {
        poprintdefMag = basemgr;
        this.setBaseEntityManager(poprintdefMag);
    }

}

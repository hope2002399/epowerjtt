package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Popunishbasic;
import com.centit.punish.service.PopunishbasicManager;

public class PopunishbasicAction extends BaseEntityExtremeAction<Popunishbasic> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PopunishbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PopunishbasicManager popunishbasicMag;

    public void setPopunishbasicManager(PopunishbasicManager basemgr) {
        popunishbasicMag = basemgr;
        this.setBaseEntityManager(popunishbasicMag);
    }

}

package com.centit.punish.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.OptNewlyIdea;
import com.centit.punish.service.OptNewlyIdeaManager;

public class OptNewlyIdeaAction extends BaseEntityExtremeAction<OptNewlyIdea> {
    private static final long serialVersionUID = 1L;
    private OptNewlyIdeaManager optNewlyIdeaMag;

    public void setOptNewlyIdeaManager(OptNewlyIdeaManager basemgr) {
        optNewlyIdeaMag = basemgr;
        this.setBaseEntityManager(optNewlyIdeaMag);
    }

}

package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poapproveperson;
import com.centit.punish.service.PoapprovepersonManager;

public class PoapprovepersonAction extends
        BaseEntityExtremeAction<Poapproveperson> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory
            .getLog(PoapprovepersonAction.class);
    private static final long serialVersionUID = 1L;
    private PoapprovepersonManager poapprovepersonMag;

    public void setPoapprovepersonManager(PoapprovepersonManager basemgr) {
        poapprovepersonMag = basemgr;
        this.setBaseEntityManager(poapprovepersonMag);
    }

}

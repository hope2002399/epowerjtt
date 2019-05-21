package com.centit.punish.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Poenterprise;
import com.centit.punish.service.PoenterpriseManager;

public class PoenterpriseAction extends BaseEntityExtremeAction<Poenterprise> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PoenterpriseAction.class);
    private static final long serialVersionUID = 1L;
    private PoenterpriseManager poenterpriseMag;

    public void setPoenterpriseManager(PoenterpriseManager basemgr) {
        poenterpriseMag = basemgr;
        this.setBaseEntityManager(poenterpriseMag);
    }

}

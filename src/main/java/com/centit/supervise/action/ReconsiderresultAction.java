package com.centit.supervise.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.supervise.po.Reconsiderresult;
import com.centit.supervise.service.ReconsiderresultManager;

public class ReconsiderresultAction extends
        BaseEntityExtremeAction<Reconsiderresult> {
    private static final long serialVersionUID = 1L;
    private ReconsiderresultManager reconsiderresultMag;

    public void setReconsiderresultManager(ReconsiderresultManager basemgr) {
        reconsiderresultMag = basemgr;
        this.setBaseEntityManager(reconsiderresultMag);
    }

}

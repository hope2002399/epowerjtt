package com.centit.supervise.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.supervise.po.SuperviseResult;
import com.centit.supervise.service.SuperviseResultManager;

public class SuperviseResultAction extends
        BaseEntityExtremeAction<SuperviseResult> {
    private static final long serialVersionUID = 1L;
    private SuperviseResultManager superviseResultMag;

    public void setSuperviseResultManager(SuperviseResultManager basemgr) {
        superviseResultMag = basemgr;
        this.setBaseEntityManager(superviseResultMag);
    }

    public String viewResult() {
        object = superviseResultMag.getSuperviseResultBySuperviseNo(object
                .getSuperviseNo());
        return VIEW;
    }

    public String edit() {

        return EDIT;
    }
}

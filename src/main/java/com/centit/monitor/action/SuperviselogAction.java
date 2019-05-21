package com.centit.monitor.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.Superviselog;
import com.centit.monitor.service.SuperviselogManager;
import com.opensymphony.xwork2.ActionContext;

public class SuperviselogAction extends BaseEntityExtremeAction<Superviselog> {
    private static final long serialVersionUID = 1L;
    private SuperviselogManager superviselogMag;

    public void setSuperviselogManager(SuperviselogManager basemgr) {
        superviselogMag = basemgr;
        this.setBaseEntityManager(superviselogMag);
    }

    @Override
    public String list() {
        ActionContext.getContext().put("optIds", superviselogMag.getOptList());

        return super.list();
    }

}

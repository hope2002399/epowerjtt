package com.centit.punish.action;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.punish.po.Podecisioninfo;
import com.centit.punish.service.PodecisioninfoManager;

public class PodecisioninfoAction extends
        BaseEntityExtremeAction<Podecisioninfo> {
    private static final long serialVersionUID = 1L;
    private PodecisioninfoManager podecisioninfoMag;

    public void setPodecisioninfoManager(PodecisioninfoManager basemgr) {
        podecisioninfoMag = basemgr;
        this.setBaseEntityManager(podecisioninfoMag);
    }

}

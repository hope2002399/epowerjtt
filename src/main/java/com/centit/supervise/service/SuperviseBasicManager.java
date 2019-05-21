package com.centit.supervise.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.supervise.po.SuperviseBasic;
import com.centit.supervise.po.VSuperviseBasic;

public interface SuperviseBasicManager extends
        BaseEntityManager<SuperviseBasic> {

    public SuperviseBasic getSuperviseBasicByFlowId(Long flowInstId);

    public String getNextkey();

    public List<VSuperviseBasic> listVSuperviseBasic(
            Map<String, Object> filtermap, PageDesc pagedesch);

    @SuppressWarnings("rawtypes")
    public List getdblist(String begintime, String endtime);

    public String getDbbmForCjdbByDepno(String depno);
}

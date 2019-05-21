package com.centit.monitor.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.VApply;
import com.centit.monitor.po.VApplyForList;

public interface ApplyManager extends BaseEntityManager<Apply> {
    public List<VApply> listVApply(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public List<VApply> listVApplyResult(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public Apply getApplyNew(String internalNo, String ordId);

    public List<VApply> getApplyList(Map<String, Object> filterMap);

    public List<VApply> getApplyList(Map<String, Object> filterMap,
            PageDesc pageDesc);

    public VApply getApply(String no);

    public VApply getApply(String internalNo, String itemId);

    public Apply getApplyInfo(String no);

    public Apply getApplyInfo(String internalNo, String itemId);

    public void applySave(Apply info);
    
    public List getApplyReg(String internalNo);

    @SuppressWarnings("rawtypes")
    public List getApplylistsize(String begintime, String endtime);

    @SuppressWarnings("rawtypes")
    public List getapplyalllist(String begintime, String endtime);

    public List<VApplyForList> listVApplyForList(Map<String, Object> filterMap,
            PageDesc pageDesc);
}

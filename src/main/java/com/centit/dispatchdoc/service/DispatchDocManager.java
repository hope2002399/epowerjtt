package com.centit.dispatchdoc.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.DispatchDoc;
import com.centit.dispatchdoc.po.VDispatchDocList;

public interface DispatchDocManager extends BaseEntityManager<DispatchDoc> {
    /**
     * 获取主键
     * 
     * @return
     */
    public String getNextkey();

    public DispatchDoc getDispatchDoc(String internalNo, String itemId);

    /**
     * 查询视图v_dispatchdoc(未提交发文/已办结发文)
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<VDispatchDocList> getVDispatchDocList(
            Map<String, Object> filterMap, PageDesc pageDesc);

    /**
     * 查询收发文关系表，列出关联的收文
     * 
     * @param dispatchNo
     *            发文号
     * @return
     */
    public List<VDispatchDocList> getDocRelativeList(String dispatchNo);

    /**
     * 查询收发文关系表，列出收文
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<VDispatchDocList> getIncomeDocList(
            Map<String, Object> filterMap, PageDesc pageDesc);
}

package com.centit.dispatchdoc.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.dao.DispatchDocDao;
import com.centit.dispatchdoc.dao.DocRelativeDao;
import com.centit.dispatchdoc.dao.VDispatchDocListDao;
import com.centit.dispatchdoc.po.DispatchDoc;
import com.centit.dispatchdoc.po.VDispatchDocList;
import com.centit.dispatchdoc.service.DispatchDocManager;

public class DispatchDocManagerImpl extends BaseEntityManagerImpl<DispatchDoc>
        implements DispatchDocManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(DispatchDocManager.class);

    private DispatchDocDao dispatchDocDao;
    private DocRelativeDao docRelativeDao;
    private VDispatchDocListDao vDispatchDocListDao;

    public String getNextkey() {
        return "FW" + dispatchDocDao.getNextKeyBySequence("S_DISPATCH_DOC", 14);
    }

    public DispatchDoc getDispatchDoc(String internalNo, String itemId) {
        return dispatchDocDao.getDispatchDoc(internalNo, itemId);
    }

    /**
     * 查询视图v_dispatchdoc(未提交发文/已办结发文)
     * 
     * @return
     */
    public List<VDispatchDocList> getVDispatchDocList(
            Map<String, Object> filterMap, PageDesc pageDesc) {

        return vDispatchDocListDao.listObjects(filterMap, pageDesc);

    }

    /**
     * 查询收发文关系表，列出关联的收文
     * 
     * @param dispatchNo
     *            发文号
     * @return
     */
    public List<VDispatchDocList> getDocRelativeList(String dispatchNo) {

        return vDispatchDocListDao.getDocRelativeList(dispatchNo);
    }

    /**
     * 查询收发文关系表，列出收文
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<VDispatchDocList> getIncomeDocList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return vDispatchDocListDao.getIncomeDocList(filterMap, pageDesc);
    }

    public VDispatchDocListDao getvDispatchDocListDao() {
        return vDispatchDocListDao;
    }

    public void setvDispatchDocListDao(VDispatchDocListDao vDispatchDocListDao) {
        this.vDispatchDocListDao = vDispatchDocListDao;
    }

    public DocRelativeDao getDocRelativeDao() {
        return docRelativeDao;
    }

    public void setDocRelativeDao(DocRelativeDao docRelativeDao) {
        this.docRelativeDao = docRelativeDao;
    }

    public void setDispatchDocDao(DispatchDocDao baseDao) {
        this.dispatchDocDao = baseDao;
        setBaseDao(this.dispatchDocDao);
    }
}

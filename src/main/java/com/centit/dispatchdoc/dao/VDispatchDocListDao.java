package com.centit.dispatchdoc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.dispatchdoc.po.VDispatchDocList;

public class VDispatchDocListDao extends BaseDaoImpl<VDispatchDocList> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VDispatchDocListDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("djId", CodeBook.EQUAL_HQL_ID);

            filterField.put("createDate", CodeBook.EQUAL_HQL_ID);
            filterField.put("flowInstId", CodeBook.EQUAL_HQL_ID);
            filterField.put("transaffairname", CodeBook.EQUAL_HQL_ID);
            filterField.put("biztype", CodeBook.EQUAL_HQL_ID);
            filterField.put("createuser", CodeBook.EQUAL_HQL_ID);

            filterField.put("headunitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgname", CodeBook.EQUAL_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " createDate desc ");

        }
        return filterField;
    }

    /**
     * 查询收发文关系表，列出关联的收文
     * 
     * @return
     */
    public List<VDispatchDocList> getDocRelativeList(String dispatchNo) {
        return super
                .listObjects(" from VDispatchDocList where djId in (select incomeNo from DocRelative where dispatchNo='"
                        + dispatchNo + "')");

    }

    /**
     * 查询收发文关系表，列出收文
     * 
     * @return
     */
    public List<VDispatchDocList> getIncomeDocList(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return super
                .listObjects(
                        " from VDispatchDocList where biztype<>'F' and djId in (select djId from IncomeDoc)",
                        filterMap, pageDesc);
    }
}

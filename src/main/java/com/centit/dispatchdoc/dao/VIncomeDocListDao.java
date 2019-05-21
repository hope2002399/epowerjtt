package com.centit.dispatchdoc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.dispatchdoc.po.VIncomeDocList;

public class VIncomeDocListDao extends BaseDaoImpl<VIncomeDocList> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VIncomeDocListDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("djId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("acceptNo", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDocNo", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDocTitle", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDeptName", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDocFileName", CodeBook.LIKE_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("flowCode", CodeBook.LIKE_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("transaffairname", CodeBook.LIKE_HQL_ID);

            filterField.put("bizstate", CodeBook.LIKE_HQL_ID);

            filterField.put("biztype", CodeBook.LIKE_HQL_ID);

            filterField.put("orgcode", CodeBook.LIKE_HQL_ID);

            filterField.put("orgname", CodeBook.LIKE_HQL_ID);

            filterField.put("content", CodeBook.LIKE_HQL_ID);

            filterField.put("powerid", CodeBook.LIKE_HQL_ID);

            filterField.put("powername", CodeBook.LIKE_HQL_ID);

            filterField.put("createuser", CodeBook.LIKE_HQL_ID);

            filterField.put("createdate", CodeBook.LIKE_HQL_ID);

            filterField.put("transAffairNo", CodeBook.LIKE_HQL_ID);

            filterField.put("transAffairQueryKey", CodeBook.LIKE_HQL_ID);

            filterField.put("instState", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeState", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public List<VIncomeDocList> getDocRelativeList(String dispatchNo) {
        return super
                .listObjects(" from VIncomeDocList where djId in (select cid.incomeNo from DocRelative where cid.dispatchNo='"
                        + dispatchNo + "')");
    }
}

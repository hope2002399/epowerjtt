package com.centit.dispatchdoc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.dispatchdoc.po.IncomeDoc;

public class IncomeDocDao extends BaseDaoImpl<IncomeDoc> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(IncomeDocDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("acceptNo", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDocNo", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDocTitle", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDeptName", CodeBook.LIKE_HQL_ID);

            filterField.put("incomeDocFileName", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public IncomeDoc getIncomeDoc(String internalNo, String itemId) {
        String shql = " from IncomeDoc where internalNo=? and itemId=? ";
        Object[] objects = new Object[] { internalNo, itemId };
        List<IncomeDoc> incomeDocs = this.listObjects(shql, objects);
        if (incomeDocs != null && incomeDocs.size() >= 1) {
            return incomeDocs.get(0);
        } else {
            return null;
        }
    }
}

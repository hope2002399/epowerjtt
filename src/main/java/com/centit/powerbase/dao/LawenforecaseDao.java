package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerbase.po.Lawenforecase;

public class LawenforecaseDao extends BaseDaoImpl<Lawenforecase> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(LawenforecaseDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("caseno", CodeBook.EQUAL_HQL_ID);

            filterField.put("casetitle", CodeBook.LIKE_HQL_ID);

            filterField.put("bookoperator", CodeBook.LIKE_HQL_ID);

            filterField.put("bookdate", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("docName", CodeBook.LIKE_HQL_ID);

            filterField.put("fileName", CodeBook.LIKE_HQL_ID);

            filterField.put("casedoc", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public boolean IsCasenoExist(String caseno) {
        if (caseno != null) {
            List<Lawenforecase> procs = this
                    .listObjects("From Lawenforecase where caseno =  "
                            + HQLUtils.buildHqlStringForSQL(caseno));
            if (procs != null && procs.size() >= 1)
                return true;
        }
        return false;

    }
}

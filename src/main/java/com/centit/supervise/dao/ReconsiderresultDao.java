package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.Reconsiderresult;

public class ReconsiderresultDao extends BaseDaoImpl<Reconsiderresult> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ReconsiderresultDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("reconsiderId", CodeBook.EQUAL_HQL_ID);

            filterField.put("reconsiderenddate", CodeBook.LIKE_HQL_ID);

            filterField.put("reconsiderresult", CodeBook.LIKE_HQL_ID);

            filterField.put("reconsiderremark", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("finishType", CodeBook.EQUAL_HQL_ID);

        }
        return filterField;
    }
}

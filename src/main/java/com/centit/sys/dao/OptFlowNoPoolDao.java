package com.centit.sys.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.support.utils.DatetimeOpt;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.OptFlowNoPool;

public class OptFlowNoPoolDao extends BaseDaoImpl<OptFlowNoPool> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptFlowNoPoolDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("ownerCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("codeDate", CodeBook.EQUAL_HQL_ID);

            filterField.put("codeCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("curNo", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public long fetchFirstLsh(String ownerCode, String codeCode,
            Date codeBaseDate) {
        return this
                .getSingleIntBySql("select min(CurNo) as MinNo from F_OptFlowNoPool"
                        + " where OwnerCode = "
                        + StringBaseOpt.quotedString(ownerCode)
                        + " and CodeCode = "
                        + StringBaseOpt.quotedString(ownerCode)
                        + " and CodeDate = to_date("
                        + StringBaseOpt.quotedString(DatetimeOpt
                                .convertDatetimeToString(codeBaseDate))
                        + ",'YYYY-MM-DD HH:MI:SS')");
    }
}

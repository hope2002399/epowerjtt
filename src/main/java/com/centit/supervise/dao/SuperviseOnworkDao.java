package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.SuperviseOnwork;

public class SuperviseOnworkDao extends BaseDaoImpl<SuperviseOnwork> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuperviseOnworkDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("superviseNo", CodeBook.LIKE_HQL_ID);

            filterField.put("bjname", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("outwayid", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("begTime",
                    " superviseDate >= to_date(?, 'yyyy-mm-dd') ");
            filterField.put("endTime",
                    " superviseDate <= to_date(?, 'yyyy-mm-dd') ");
            filterField.put("monitorOrgId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseOption", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("processno", CodeBook.LIKE_HQL_ID);

            filterField.put("processName", CodeBook.LIKE_HQL_ID);

            filterField.put("processDate", CodeBook.LIKE_HQL_ID);

            filterField.put("processOperatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorResult", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorOpinion", CodeBook.LIKE_HQL_ID);

            filterField.put("biztype", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "superviseNo desc");

            filterField.put("NP_monitorSource", "monitorSource is null");
        }
        return filterField;
    }
}

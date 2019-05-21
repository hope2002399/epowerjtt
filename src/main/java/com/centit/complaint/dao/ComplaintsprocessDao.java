package com.centit.complaint.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.po.ComplaintsProcess;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;

public class ComplaintsprocessDao extends BaseDaoImpl<ComplaintsProcess> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ComplaintsprocessDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("nodeinstid", CodeBook.EQUAL_HQL_ID);

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("processCode", CodeBook.LIKE_HQL_ID);

            filterField.put("processName", CodeBook.LIKE_HQL_ID);

            filterField.put("processDate", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorResult", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorOpinion", CodeBook.LIKE_HQL_ID);

            filterField.put("attachment", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "processDate desc");

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<ComplaintsProcess> getObjListByComplaintId(String complaintId) {

        return getHibernateTemplate()
                .find("FROM ComplaintsProcess  where complaintId= ? order by processDate desc ",
                        complaintId);
    }
}

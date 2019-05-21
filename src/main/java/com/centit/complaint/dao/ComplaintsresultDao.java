package com.centit.complaint.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.po.ComplaintsResult;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;

public class ComplaintsresultDao extends BaseDaoImpl<ComplaintsResult> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ComplaintsresultDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("type", CodeBook.LIKE_HQL_ID);

            filterField.put("detail", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("resultDate", CodeBook.LIKE_HQL_ID);

            filterField.put("opinion", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public ComplaintsResult getObjectByComplaintsId(String complaintId) {
        List<ComplaintsResult> optComplaintList = this.listObjects(
                "from ComplaintsResult where complaintid = ?", complaintId);
        if (optComplaintList == null || optComplaintList.size() == 0) {
            return null;
        }
        return optComplaintList.get(0);
    }

    @SuppressWarnings("unchecked")
    public Integer getNextComplantNo(String depno) {
        Integer retint = 0;
        String sql = "select nvl(max(substr(no,11,20)),0) as no,'scar' from m_complaintsresult where no like '"
                + depno + "%'";
        List<Object[]> l = findObjectsBySql(sql);
        Object[] O = (Object[]) l.get(0);
        String datavalue = (String) O[0];
        retint = Integer.parseInt(datavalue);
        return retint;
    }
}

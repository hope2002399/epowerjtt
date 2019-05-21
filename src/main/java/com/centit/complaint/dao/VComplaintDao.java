package com.centit.complaint.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.po.VComplaint;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;

public class VComplaintDao extends BaseDaoImpl<VComplaint> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ComplaintDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("flowinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintsType", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintsSource", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintman", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintphone", CodeBook.LIKE_HQL_ID);

            filterField.put("endTime",
                    "complaintdate <= to_date(?,'yyyy-mm-dd')");
            filterField.put("begTime",
                    "complaintdate >= to_date(?,'yyyy-mm-dd')");

            filterField.put("complaintreason", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintremark", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintmandate", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintmanresult", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintmanremark", CodeBook.LIKE_HQL_ID);

            filterField.put("wereComplaintsOrgId", CodeBook.LIKE_HQL_ID);

            filterField.put("wereComplaintsName", CodeBook.LIKE_HQL_ID);

            filterField.put("wereComplaintsPersonName", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintsPersonName", CodeBook.LIKE_HQL_ID);

            filterField.put("address", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);

            filterField.put("processDate", CodeBook.LIKE_HQL_ID);

            filterField.put("processType", CodeBook.LIKE_HQL_ID);

            filterField.put("graentOrgId", CodeBook.LIKE_HQL_ID);

            filterField.put("graentOpinion", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("biztype", CodeBook.EQUAL_HQL_ID);

            filterField.put("tsly", CodeBook.EQUAL_HQL_ID);

            filterField.put("state", CodeBook.LIKE_HQL_ID);

            filterField.put("type", CodeBook.EQUAL_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "complaintid desc");

        }
        return filterField;
    }

}

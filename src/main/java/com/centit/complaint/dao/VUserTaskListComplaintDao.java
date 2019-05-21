package com.centit.complaint.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.complaint.po.VUserTaskListComplaint;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;

public class VUserTaskListComplaintDao extends
        BaseDaoImpl<VUserTaskListComplaint> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VUserTaskListComplaintDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("taskId", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("unitCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("userCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleType", CodeBook.LIKE_HQL_ID);

            filterField.put("roleCode", CodeBook.LIKE_HQL_ID);

            filterField.put("optId", CodeBook.LIKE_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("flowOptName", CodeBook.LIKE_HQL_ID);

            filterField.put("flowOptTag", CodeBook.LIKE_HQL_ID);

            filterField.put("authDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeType", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeOptType", CodeBook.LIKE_HQL_ID);

            filterField.put("optName", CodeBook.LIKE_HQL_ID);

            filterField.put("methodName", CodeBook.LIKE_HQL_ID);

            filterField.put("optUrl", CodeBook.LIKE_HQL_ID);

            filterField.put("optMethod", CodeBook.LIKE_HQL_ID);

            filterField.put("optDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("optCode", CodeBook.LIKE_HQL_ID);

            filterField.put("optParam", CodeBook.LIKE_HQL_ID);

            filterField.put("inststate", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "nodeCreateTime desc");

            filterField.put("expireOptSign", CodeBook.LIKE_HQL_ID);

            filterField.put("expireOpt", CodeBook.LIKE_HQL_ID);

            filterField.put("grantor", CodeBook.LIKE_HQL_ID);

            filterField.put("timeLimit", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateUser", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateTime", CodeBook.LIKE_HQL_ID);

            filterField.put("flowPhase", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("processNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintsType", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintsSource", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintMan", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintPhone", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintDate", CodeBook.LIKE_HQL_ID);

            filterField.put("fileName", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintReason", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintRemark", CodeBook.LIKE_HQL_ID);

            filterField.put("grantOrgId", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }
}

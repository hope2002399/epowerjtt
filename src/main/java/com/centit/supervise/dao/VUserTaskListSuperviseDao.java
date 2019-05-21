package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.VUserTaskListSupervise;

public class VUserTaskListSuperviseDao extends
        BaseDaoImpl<VUserTaskListSupervise> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VUserTaskListSuperviseDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("taskId", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("unitCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("userCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleType", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("optId", CodeBook.EQUAL_HQL_ID);

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

            filterField.put("nodeCreateTime", CodeBook.LIKE_HQL_ID);

            filterField.put("expireOptSign", CodeBook.LIKE_HQL_ID);

            filterField.put("expireOpt", CodeBook.LIKE_HQL_ID);

            filterField.put("grantor", CodeBook.LIKE_HQL_ID);

            filterField.put("timeLimit", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateUser", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateTime", CodeBook.LIKE_HQL_ID);

            filterField.put("flowPhase", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseNo", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintId", CodeBook.LIKE_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("outWayId", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorID", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOrgId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOrgName", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintDate", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("bjname", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseOption", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorSource", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "nodeCreateTime desc");

            filterField.put("NP_monitorSource", "monitorSource is null");
        }
        return filterField;
    }
}

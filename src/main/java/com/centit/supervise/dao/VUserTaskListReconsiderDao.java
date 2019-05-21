package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.VUserTaskListReconsider;

public class VUserTaskListReconsiderDao extends
        BaseDaoImpl<VUserTaskListReconsider> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(VUserTaskListReconsiderDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("taskId", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("unitCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("userCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleType", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("optId", CodeBook.EQUAL_HQL_ID);

            filterField.put("flowOptName", CodeBook.LIKE_HQL_ID);

            filterField.put("flowOptTag", CodeBook.LIKE_HQL_ID);

            filterField.put("authDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeType", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeOptType", CodeBook.EQUAL_HQL_ID);

            filterField.put("optName", CodeBook.LIKE_HQL_ID);

            filterField.put("methodName", CodeBook.LIKE_HQL_ID);

            filterField.put("optUrl", CodeBook.LIKE_HQL_ID);

            filterField.put("optMethod", CodeBook.LIKE_HQL_ID);

            filterField.put("optDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("optCode", CodeBook.LIKE_HQL_ID);

            filterField.put("optParam", CodeBook.LIKE_HQL_ID);

            filterField.put("inststate", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeCreateTime", CodeBook.LIKE_HQL_ID);

            filterField.put("expireOptSign", CodeBook.LIKE_HQL_ID);

            filterField.put("expireOpt", CodeBook.LIKE_HQL_ID);

            filterField.put("timeLimit", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateUser", CodeBook.LIKE_HQL_ID);

            filterField.put("lastUpdateTime", CodeBook.LIKE_HQL_ID);

            filterField.put("flowPhase", CodeBook.LIKE_HQL_ID);

            filterField.put("reconsiderid", CodeBook.LIKE_HQL_ID);

            filterField.put("reconsiderdate", CodeBook.LIKE_HQL_ID);

            filterField.put("reconsiderapply", CodeBook.LIKE_HQL_ID);

            filterField.put("applyphone", CodeBook.LIKE_HQL_ID);

            filterField.put("applydate", CodeBook.LIKE_HQL_ID);

            filterField.put("applyreason", CodeBook.LIKE_HQL_ID);

            filterField.put("applyremark", CodeBook.LIKE_HQL_ID);

            filterField.put("reconsiderdep", CodeBook.LIKE_HQL_ID);

            filterField.put("bookoperator", CodeBook.LIKE_HQL_ID);

            filterField.put("bookdate", CodeBook.LIKE_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("biztype", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "nodeCreateTime desc");
        }
        return filterField;
    }
}

package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.SuperviseBasic;

public class SuperviseBasicDao extends BaseDaoImpl<SuperviseBasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuperviseBasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("superviseNo", CodeBook.LIKE_HQL_ID);

            filterField.put("flowinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("outwayid", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOrgId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOrgName", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseOption", CodeBook.LIKE_HQL_ID);

            filterField.put("attachment", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("bizType", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "superviseNo desc");

            filterField.put("begsupervisedate",
                    "superviseDate >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endsupervisedate",
                    "superviseDate <= to_date(?,'yyyy-mm-dd')");

        }
        return filterField;
    }

    public SuperviseBasic getSuperviseBasicByFlowId(Long flowInstId) {
        List<SuperviseBasic> optComplaintList = this.listObjects(
                "from SuperviseBasic where flowInstId = ?", flowInstId);
        if (optComplaintList == null || optComplaintList.size() == 0) {
            return null;
        }
        return optComplaintList.get(0);
    }
}

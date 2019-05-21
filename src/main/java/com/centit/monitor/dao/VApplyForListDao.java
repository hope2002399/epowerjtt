package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.VApplyForList;

public class VApplyForListDao extends BaseDaoImpl<VApplyForList> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VApplyForList.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);
            filterField.put("version", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);

            filterField.put("department", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantName", CodeBook.LIKE_HQL_ID);
            filterField.put("applicantType", CodeBook.LIKE_HQL_ID);

            filterField.put("item_type", CodeBook.EQUAL_HQL_ID);
            filterField.put("status", CodeBook.EQUAL_HQL_ID);

            filterField.put("isrisk", CodeBook.EQUAL_HQL_ID);
            filterField.put("NP_result", "finishTime is not null");
            filterField.put("NP_process", "finishTime is null");
            filterField.put("topunitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("begTime",
                    "applyDate >= to_date(?,'yyyy-mm-dd HH24:mi:ss')");

            filterField.put("endTime",
                    "applyDate <= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put("begFinishTime",
                    "finishTime >= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            filterField.put("endFinishTime",
                    "finishTime <= to_date(?,'yyyy-mm-dd HH24:mi:ss')");
            // filterField.put("type", " finish_time is ? ");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " applyDate desc");
            filterField.put("NP_istrack", "isTrack is null");

            filterField.put("unitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("transactAffairName", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    public List<VApplyForList> listVApplyForList(Map<String, Object> filterMap,
            PageDesc pageDesc) {

        String shql = " from VApplyForList where 1=1 ";

        return this.listObjects(shql, filterMap, pageDesc);
    }
}

package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.VApply;

public class VApplyDao extends BaseDaoImpl<VApply> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VApply.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("changNo", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);
            filterField.put("version", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);

            filterField.put("department", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantName", CodeBook.LIKE_HQL_ID);
            filterField.put("applicantType", CodeBook.LIKE_HQL_ID);

            filterField.put("acceptNo", CodeBook.LIKE_HQL_ID);
            filterField.put("incomeDocNo", CodeBook.LIKE_HQL_ID);
            filterField.put("dispatchDocNo", CodeBook.LIKE_HQL_ID);

            filterField.put("item_type", CodeBook.EQUAL_HQL_ID);

            filterField.put("isrisk", CodeBook.EQUAL_HQL_ID);
            filterField.put("NP_result", "finishTime is not null");
            filterField.put("NP_process", "finishTime is null");
            filterField.put("maxstatus", CodeBook.EQUAL_HQL_ID);
            filterField.put("topunitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("begTime", "applyDate >= to_date(?,'yyyy-mm-dd')");

            filterField
                    .put("endTime", "applyDate <= to_date(?,'yyyy-mm-dd')+1");
            filterField.put("begFinishTime",
                    "finishTime >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endFinishTime",
                    "finishTime <= to_date(?,'yyyy-mm-dd')+1");
            // filterField.put("type", " finish_time is ? ");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " applyDate desc");
            filterField.put("NP_istrack", "isTrack is null");

            filterField.put("status", CodeBook.EQUAL_HQL_ID);
            filterField.put("unitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("transactAffairName", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    // public List<VApply> listObjects(Map<String, Object> filterMap, PageDesc
    // pageDesc) {
    // String shql = " From VApply   " +
    // " where finishTime is null ";
    // List<VApply> l =super.listObjects(shql, filterMap, pageDesc);
    // return l;
    // }

    public List<VApply> listResultObjects(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " From VApply   " + " where finishTime is not null ";
        List<VApply> l = super.listObjects(shql, filterMap, pageDesc);
        return l;
    }

    public List<VApply> getApplyList(Map<String, Object> filterMap) {
        String shql = " From VApply where 1=1 ";
        List<VApply> l = super.listObjects(shql, filterMap);
        return l;

    }

    public List<VApply> getApplyList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " From VApply where 1=1 ";
        List<VApply> l = super.listObjects(shql, filterMap, pageDesc);
        return l;

    }

    public VApply getApply(String no) {
        String shql = " From VApply where 1=1 and no=?";
        List<VApply> l = super.listObjects(shql, no);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public VApply getApply(String internalNo, String itemId) {
        
        String shql = " From VApply where 1=1 and internalNo=? and itemId=?";
        Object[] objects = new Object[] { internalNo, itemId };
        List<VApply> l = super.listObjects(shql, objects);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }
}

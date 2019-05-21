package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.VTrackLog;

public class VTrackLogDao extends BaseDaoImpl<VTrackLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VTrackLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("trackno", CodeBook.EQUAL_HQL_ID);
            filterField.put("no", CodeBook.LIKE_HQL_ID);
            filterField.put("powertype", CodeBook.LIKE_HQL_ID);
            filterField.put("internalNoBj", CodeBook.LIKE_HQL_ID);
            filterField.put("internalNoAj", CodeBook.LIKE_HQL_ID);
            filterField.put("orgIdBj", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgIdAj", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemIdAj", CodeBook.LIKE_HQL_ID);
            filterField.put("itemIdBj", CodeBook.LIKE_HQL_ID);
            filterField.put("punishTarget", CodeBook.LIKE_HQL_ID);
            filterField.put("tracktype", CodeBook.LIKE_HQL_ID);
            filterField.put("trackoperator", CodeBook.LIKE_HQL_ID);
            filterField.put("tracktime", CodeBook.LIKE_HQL_ID);
            filterField.put("trackreason", CodeBook.LIKE_HQL_ID);
            filterField.put("untrackoperator", CodeBook.LIKE_HQL_ID);
            filterField.put("untracktime", CodeBook.LIKE_HQL_ID);
            filterField.put("untrackreason", CodeBook.LIKE_HQL_ID);
            filterField.put("begTrackTime",
                    "tracktime>=to_date(?,'yyyy-mm-dd')");
            filterField.put("endTrackTime",
                    "tracktime<=to_date(?,'yyyy-mm-dd')");
            filterField.put("begUnTrackTime",
                    "untracktime>=to_date(?,'yyyy-mm-dd')");
            filterField.put("endUnTrackTime",
                    "untracktime<=to_date(?,'yyyy-mm-dd')");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " untracktime desc");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " tracktime desc");
            filterField.put("isRiskAj", CodeBook.EQUAL_HQL_ID);
            filterField.put("isRiskBj", CodeBook.EQUAL_HQL_ID);
            filterField.put("topunitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemtype", CodeBook.EQUAL_HQL_ID);
            filterField.put("NP_untrackoperator", "untrackoperator is null");
        }
        return filterField;
    }

    public List<VTrackLog> getTrackLogList(Map<String, Object> filterMap) {
        List<VTrackLog> l = super.listObjects(filterMap);
        return l;
    }
}

package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.TrackLog;

public class TrackLogDao extends BaseDaoImpl<TrackLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(TrackLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("trackno", CodeBook.EQUAL_HQL_ID);

            filterField.put("no", CodeBook.LIKE_HQL_ID);

            filterField.put("powertype", CodeBook.LIKE_HQL_ID);

            filterField.put("tracktype", CodeBook.LIKE_HQL_ID);

            filterField.put("trackoperator", CodeBook.LIKE_HQL_ID);

            filterField.put("tracktime", CodeBook.LIKE_HQL_ID);

            filterField.put("trackreason", CodeBook.LIKE_HQL_ID);

            filterField.put("untrackoperator", CodeBook.LIKE_HQL_ID);

            filterField.put("untracktime", CodeBook.LIKE_HQL_ID);

            filterField.put("untrackreason", CodeBook.LIKE_HQL_ID);
            filterField.put("begTime", "tracktime>=to_date(?,'yyyy-mm-dd')");
            filterField.put("endTime", "tracktime<=to_date(?,'yyyy-mm-dd')");
            filterField.put("NP_untracktime", " untracktime is null");
            // 排序
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " tracktime desc");

        }
        return filterField;
    }

    // 获取下一个编码
    public String genNextChangeId() {
        String no = getNextKeyBySequence("S_TRACKLOGNO", 10);
        return no;
    }

    public List<TrackLog> getTrackLogList(Map<String, Object> filterMap) {
        List<TrackLog> l = super.listObjects(filterMap);
        return l;
    }

    public TrackLog getTrackLog(Map<String, Object> filterMap) {
        List<TrackLog> l = super.listObjects(filterMap);
        if (l != null) {
            return l.get(0);
        } else {
            return null;
        }

    }
}

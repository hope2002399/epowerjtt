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
import com.centit.monitor.po.VPunish;

public class VPunishDao extends BaseDaoImpl<VPunish> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VApply.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("changNo", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);
            filterField.put("itemId", CodeBook.EQUAL_HQL_ID);
            filterField.put("itemId2", "item_id like '%'||?");
            filterField.put("version", CodeBook.EQUAL_HQL_ID);

            filterField.put("department", CodeBook.LIKE_HQL_ID);

            filterField.put("punishTarget", CodeBook.LIKE_HQL_ID);
            filterField.put("item_type", CodeBook.EQUAL_HQL_ID);

            filterField.put("isrisk", CodeBook.EQUAL_HQL_ID);
            filterField.put("source", CodeBook.LIKE_HQL_ID);

            filterField.put("fact", CodeBook.LIKE_HQL_ID);

            filterField.put("targetType", CodeBook.LIKE_HQL_ID);
            filterField.put("isTrack", CodeBook.LIKE_HQL_ID);
            filterField.put("topunitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("NP_result", "finishDate is not null");
            filterField.put("NP_process", "finishDate is null");
            filterField.put("begTime", "createDate >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endTime",
                    "createDate <= to_date(?,'yyyy-mm-dd')+1");
            filterField.put("begFinishTime",
                    "finishDate >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endFinishTime",
                    "finishDate <= to_date(?,'yyyy-mm-dd')+1");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " createDate desc");
            filterField.put("NP_istrack", "isTrack is null");

            filterField.put("unitcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("punishDeside", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }

    public List<VPunish> listResultObjects(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " From VPunish   " + " where finishDate is not null ";
        List<VPunish> l = super.listObjects(shql, filterMap, pageDesc);
        return l;
    }

    public List<VPunish> getPunishList(Map<String, Object> filterMap) {
        String shql = " From VPunish where 1=1";
        List<VPunish> l = super.listObjects(shql, filterMap);
        return l;

    }

    public List<VPunish> getPunishList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " From VPunish where 1=1";
        List<VPunish> l = super.listObjects(shql, filterMap, pageDesc);
        return l;

    }

    public VPunish getPunish(String no) {
        String shql = " From VPunish where 1=1 and no=?";
        List<VPunish> l = super.listObjects(shql, no);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }

    public VPunish getPunish(String internalNo, String orgId) {
        
        String shql = " From VPunish where 1=1 and and internalNo=? and orgId=?";
        Object[] objects = new Object[] { internalNo, orgId };
        List<VPunish> l = super.listObjects(shql, objects);
        if (l != null && l.size() > 0) {
            return l.get(0);
        } else {
            return null;
        }
    }
}

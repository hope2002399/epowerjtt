package com.centit.monitor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.ApplyResultLog;

public class ApplyResultLogDao extends BaseDaoImpl<ApplyResultLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyResultLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.EQUAL_HQL_ID);
            filterField.put("changNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgId", CodeBook.LIKE_HQL_ID);
            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);
            filterField.put("status", CodeBook.LIKE_HQL_ID);
            filterField.put("note", CodeBook.LIKE_HQL_ID);
            filterField.put("attachment", CodeBook.LIKE_HQL_ID);
            filterField.put("finishTime", CodeBook.LIKE_HQL_ID);
            filterField.put("receivable", CodeBook.LIKE_HQL_ID);
            filterField.put("paid", CodeBook.LIKE_HQL_ID);
            filterField.put("reliefReasons", CodeBook.LIKE_HQL_ID);
            filterField.put("createDate", CodeBook.LIKE_HQL_ID);
            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);
            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);
            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);
            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String itemId) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append(" select chang_no from M_ApplyResultLog where 1=1 ");
        if (StringUtils.isNotBlank(internalNo)) {
            sql.append(" and internal_No = '" + internalNo + "' ");
        }
        if (StringUtils.isNotBlank(itemId)) {
            sql.append(" and item_id = '" + itemId + "' ");
        }
        sql.append(" order by chang_no desc ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;

    }

    public ApplyResultLog getApplyResultLog(String internalNo, String itemId,
            Long chang_no) {
        String shql = " from ApplyResultLog where internalNo=? and itemId=? and cid.changNo=? ";
        Object[] objects = new Object[] { internalNo, itemId, chang_no };
        List<ApplyResultLog> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }
}

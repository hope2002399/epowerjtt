package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.ApplyResult;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-4
 * @version
 */
public class ApplyResultDao extends BaseDaoImpl<ApplyResult> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyResultDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("changNo", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

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

            filterField.put("limitdate",
                    "finishTime >= to_date(?,'yyyy-mm-dd')");
            filterField.put("begfinishtime",
                    "finishTime >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endfinishtime",
                    "finishTime <= to_date(?,'yyyy-mm-dd')");
        }
        return filterField;
    }

    /**
     *
     * @param internalNo
     * @param itemId
     * @return
     */
    public ApplyResult getApplyResult(String internalNo, String itemId) {
        String shql = " from ApplyResult where internalNo=? and itemId=? ";
        Object[] objects = new Object[] { internalNo, itemId };
        List<ApplyResult> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }
}

package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.ApplyProcess;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class ApplyProcessDao extends BaseDaoImpl<ApplyProcess> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyProcessDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("noOrd", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("tacheId", CodeBook.LIKE_HQL_ID);

            filterField.put("tacheName", CodeBook.LIKE_HQL_ID);

            filterField.put("tacheInteNo", CodeBook.LIKE_HQL_ID);

            filterField.put("tachePrevIntNo", CodeBook.LIKE_HQL_ID);

            filterField.put("department", CodeBook.LIKE_HQL_ID);

            filterField.put("userStaffCode", CodeBook.LIKE_HQL_ID);

            filterField.put("userName", CodeBook.LIKE_HQL_ID);

            filterField.put("status", CodeBook.LIKE_HQL_ID);

            filterField.put("promise", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseType", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseStartSign", CodeBook.LIKE_HQL_ID);

            filterField.put("isrisk", CodeBook.LIKE_HQL_ID);

            filterField.put("risktype", CodeBook.LIKE_HQL_ID);

            filterField.put("riskdescription", CodeBook.LIKE_HQL_ID);

            filterField.put("riskresult", CodeBook.LIKE_HQL_ID);

            filterField.put("note", CodeBook.LIKE_HQL_ID);

            filterField.put("attachment", CodeBook.LIKE_HQL_ID);

            filterField.put("processDate", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeId", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeAttribute", CodeBook.LIKE_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, "noOrd");
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " noOrd ");

        }
        return filterField;
    }

    public List<ApplyProcess> listObjects(String internalNo, String itemId) {
        String shql = " from ApplyProcess where internalNo=? and itemId=?  order by noOrd ";
        Object[] objects = new Object[] { internalNo, itemId };
        List<ApplyProcess> list = this.listObjects(shql, objects);
        return list;
    }
}

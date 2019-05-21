package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.Reconsider;

public class ReconsiderDao extends BaseDaoImpl<Reconsider> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ReconsiderDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("reconsiderid", CodeBook.EQUAL_HQL_ID);

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

            filterField.put("optId", CodeBook.LIKE_HQL_ID);

            filterField.put("biztype", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "bookdate desc");

        }
        return filterField;
    }

    public Reconsider getReconsiderByFlowId(Long flowInstId) {
        List<Reconsider> optReconsiderList = this.listObjects(
                "from Reconsider where flowInstId = ?", flowInstId);
        if (optReconsiderList == null || optReconsiderList.size() == 0) {
            return null;
        }
        return optReconsiderList.get(0);
    }
}

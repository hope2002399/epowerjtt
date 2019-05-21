package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.SuperviseResult;

public class SuperviseResultDao extends BaseDaoImpl<SuperviseResult> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuperviseResultDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("superviseNo", CodeBook.LIKE_HQL_ID);

            // filterField.put("monitorNo", CodeBook.LIKE_HQL_ID);

            filterField.put("endDate", CodeBook.LIKE_HQL_ID);

            filterField.put("backOperatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("backOperatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("receiptDate", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseBack", CodeBook.LIKE_HQL_ID);

            filterField.put("confirm", CodeBook.LIKE_HQL_ID);

            filterField.put("isExternal", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseResult", CodeBook.LIKE_HQL_ID);

            filterField.put("endoperatorid", CodeBook.LIKE_HQL_ID);

            filterField.put("endOpinion", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public SuperviseResult getSuperviseResultBySuperviseNo(String superviseNo) {
        List<SuperviseResult> SuperviseResultList = this.listObjects(
                "from SuperviseResult where superviseNo = ?", superviseNo);
        if (SuperviseResultList == null || SuperviseResultList.size() == 0) {
            return null;
        }
        return SuperviseResultList.get(0);
    }
}

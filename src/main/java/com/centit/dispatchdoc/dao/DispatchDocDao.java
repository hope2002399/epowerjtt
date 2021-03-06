package com.centit.dispatchdoc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.dispatchdoc.po.DispatchDoc;

public class DispatchDocDao extends BaseDaoImpl<DispatchDoc> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(DispatchDocDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("djId", CodeBook.EQUAL_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocNo", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocTitle", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchFileType", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocType", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchCanOpen", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchOpenType", CodeBook.LIKE_HQL_ID);

            filterField.put("notOpenReason", CodeBook.LIKE_HQL_ID);

            filterField.put("isUnionDispatch", CodeBook.LIKE_HQL_ID);

            filterField.put("unionOthers", CodeBook.LIKE_HQL_ID);

            filterField.put("isCountersign", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocSummary", CodeBook.LIKE_HQL_ID);

            filterField.put("draftDate", CodeBook.LIKE_HQL_ID);

            filterField.put("optUnitName", CodeBook.LIKE_HQL_ID);

            filterField.put("draftUserName", CodeBook.LIKE_HQL_ID);

            filterField.put("secretsDegree", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchCopies", CodeBook.LIKE_HQL_ID);

            filterField.put("mainNotifyUnit", CodeBook.LIKE_HQL_ID);

            filterField.put("otherUnits", CodeBook.LIKE_HQL_ID);

            filterField.put("retentionPeriod", CodeBook.LIKE_HQL_ID);

            filterField.put("checkUserName", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocFileName", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocFile", CodeBook.LIKE_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("dispatchDocRed", CodeBook.LIKE_HQL_ID);

            filterField.put("printDate", CodeBook.LIKE_HQL_ID);

            filterField.put("criticalLevel", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public DispatchDoc getDispatchDoc(String internalNo, String itemId) {
        String shql = " from DispatchDoc where internalNo=? and itemId=? ";
        Object[] objects = new Object[] { internalNo, itemId };
        List<DispatchDoc> dispatchDocs = this.listObjects(shql, objects);
        if (dispatchDocs != null && dispatchDocs.size() >= 1) {
            return dispatchDocs.get(0);
        } else {
            return null;
        }
    }

}

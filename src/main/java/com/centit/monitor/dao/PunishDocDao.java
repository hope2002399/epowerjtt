package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.PunishDoc;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class PunishDocDao extends BaseDaoImpl<PunishDoc> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishDocDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("readDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("errorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("processNo", CodeBook.LIKE_HQL_ID);

            filterField.put("docNo", CodeBook.LIKE_HQL_ID);

            filterField.put("docType", CodeBook.LIKE_HQL_ID);

            filterField.put("docSort", CodeBook.LIKE_HQL_ID);

            filterField.put("docName", CodeBook.LIKE_HQL_ID);

            filterField.put("documentName", CodeBook.LIKE_HQL_ID);

            filterField.put("docFile", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    /**
     * 
     * @param internalNo
     * @param orgId
     * @return
     */
    public List<PunishDoc> listObjects(String internalNo, String orgId) {
        String shql = " from PunishDoc where internalNo=? and orgId=? ";
        Object[] objects = new Object[] { internalNo, orgId };
        List<PunishDoc> list = this.listObjects(shql, objects);
        return list;
    }

    /**
     * 
     * @param internalNo
     * @param orgId
     * @param noOrd
     * @param docType
     * @return
     */
    public boolean isDoc(String internalNo, String orgId, String noOrd,
            String docType) {
        boolean bl = false;
        String shql = " from PunishDoc where internalNo=? and orgId=? and processNo=? and docType =? ";
        Object[] objects = new Object[] { internalNo, orgId, noOrd, docType };
        List<PunishDoc> list = this.listObjects(shql, objects);
        if (list.size() > 0) {
            bl = true;
        }
        return bl;
    }
}

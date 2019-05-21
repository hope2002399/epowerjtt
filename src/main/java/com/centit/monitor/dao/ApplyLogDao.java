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
import com.centit.monitor.po.ApplyLog;

public class ApplyLogDao extends BaseDaoImpl<ApplyLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("changNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("department", CodeBook.LIKE_HQL_ID);

            filterField.put("transactAffairName", CodeBook.LIKE_HQL_ID);

            filterField.put("content", CodeBook.LIKE_HQL_ID);

            filterField.put("applyWay", CodeBook.LIKE_HQL_ID);

            filterField.put("form", CodeBook.LIKE_HQL_ID);

            filterField.put("stuff", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantCode", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantType", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantName", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantPaperType", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantPaperCode", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantPhone", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantMobile", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantAddress", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantZipcode", CodeBook.LIKE_HQL_ID);

            filterField.put("applicantEmail", CodeBook.LIKE_HQL_ID);

            filterField.put("linkman", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanName", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanPaperType", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanPaperCode", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanPhone", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanMobile", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanAddress", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanZipcode", CodeBook.LIKE_HQL_ID);

            filterField.put("linkmanEmail", CodeBook.LIKE_HQL_ID);

            filterField.put("promise", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseType", CodeBook.LIKE_HQL_ID);

            filterField.put("isrisk", CodeBook.LIKE_HQL_ID);

            filterField.put("risktype", CodeBook.LIKE_HQL_ID);

            filterField.put("riskdescription", CodeBook.LIKE_HQL_ID);

            filterField.put("riskresult", CodeBook.LIKE_HQL_ID);

            filterField.put("applyDate", CodeBook.LIKE_HQL_ID);

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
        sql.append(" select chang_no from M_ApplyLog where 1=1 ");
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

    public ApplyLog getApplyLog(String internalNo, String itemId, Long chang_no) {
        String shql = " from ApplyLog where internalNo=? and itemId=? and cid.changNo=? ";
        Object[] objects = new Object[] { internalNo, itemId, chang_no };
        List<ApplyLog> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }
}

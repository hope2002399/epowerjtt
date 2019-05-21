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
import com.centit.monitor.po.PunishLog;

public class PunishLogDao extends BaseDaoImpl<PunishLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.EQUAL_HQL_ID);
            filterField.put("changNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgId", CodeBook.LIKE_HQL_ID);
            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);
            filterField.put("itemId", CodeBook.LIKE_HQL_ID);
            filterField.put("department", CodeBook.LIKE_HQL_ID);
            filterField.put("ajAddr", CodeBook.LIKE_HQL_ID);
            filterField.put("ajOccurDate", CodeBook.LIKE_HQL_ID);
            filterField.put("source", CodeBook.LIKE_HQL_ID);
            filterField.put("fact", CodeBook.LIKE_HQL_ID);
            filterField.put("targetType", CodeBook.LIKE_HQL_ID);
            filterField.put("punishTarget", CodeBook.LIKE_HQL_ID);
            filterField.put("targetCode", CodeBook.LIKE_HQL_ID);
            filterField.put("targetPaperType", CodeBook.LIKE_HQL_ID);
            filterField.put("targetPaperNumber", CodeBook.LIKE_HQL_ID);
            filterField.put("targetPhone", CodeBook.LIKE_HQL_ID);
            filterField.put("targetMobile", CodeBook.LIKE_HQL_ID);
            filterField.put("targetAddress", CodeBook.LIKE_HQL_ID);
            filterField.put("targetZipCode", CodeBook.LIKE_HQL_ID);
            filterField.put("targetEmail", CodeBook.LIKE_HQL_ID);
            filterField.put("reporter", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterDate", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterPaperType", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterAperCode", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterPhone", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterMobile", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterAddress", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterZipcode", CodeBook.LIKE_HQL_ID);
            filterField.put("reporterEmail", CodeBook.LIKE_HQL_ID);
            filterField.put("content", CodeBook.LIKE_HQL_ID);
            filterField.put("form", CodeBook.LIKE_HQL_ID);
            filterField.put("promise", CodeBook.LIKE_HQL_ID);
            filterField.put("promiseType", CodeBook.LIKE_HQL_ID);
            filterField.put("isrisk", CodeBook.LIKE_HQL_ID);
            filterField.put("risktype", CodeBook.LIKE_HQL_ID);
            filterField.put("riskdescription", CodeBook.LIKE_HQL_ID);
            filterField.put("riskresult", CodeBook.LIKE_HQL_ID);
            filterField.put("createDate", CodeBook.LIKE_HQL_ID);
            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);
            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);
            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);
            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("rawtypes")
    public List getVersionList(String internalNo, String orgId) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append(" select chang_no from M_PunishLog where 1=1 ");
        if (StringUtils.isNotBlank(internalNo)) {
            sql.append(" and internal_No = '" + internalNo + "' ");
        }
        if (StringUtils.isNotBlank(orgId)) {
            sql.append(" and org_id = '" + orgId + "' ");
        }
        sql.append(" order by chang_no desc ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;

    }

    public PunishLog getPunishLog(String internalNo, String orgId, Long chang_no) {
        String shql = " from PunishLog where internalNo=? and orgId=? and cid.changNo=? ";
        Object[] objects = new Object[] { internalNo, orgId, chang_no };
        List<PunishLog> punishs = this.listObjects(shql, objects);
        if (punishs != null && punishs.size() >= 1) {
            return punishs.get(0);
        } else {
            return null;
        }
    }
}

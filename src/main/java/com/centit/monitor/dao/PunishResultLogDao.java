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
import com.centit.monitor.po.PunishResultLog;

public class PunishResultLogDao extends BaseDaoImpl<PunishResultLog> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishResultLogDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.EQUAL_HQL_ID);
            filterField.put("changNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgId", CodeBook.LIKE_HQL_ID);
            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);
            filterField.put("itemId", CodeBook.LIKE_HQL_ID);
            filterField.put("program", CodeBook.LIKE_HQL_ID);
            filterField.put("punishSort", CodeBook.LIKE_HQL_ID);
            filterField.put("accordance", CodeBook.LIKE_HQL_ID);
            filterField.put("standard", CodeBook.LIKE_HQL_ID);
            filterField.put("punishDeside", CodeBook.LIKE_HQL_ID);
            filterField.put("punishClass", CodeBook.LIKE_HQL_ID);
            filterField.put("punishResult", CodeBook.LIKE_HQL_ID);
            filterField.put("punishResultFine", CodeBook.LIKE_HQL_ID);
            filterField.put("punishResultFinePeople", CodeBook.LIKE_HQL_ID);
            filterField.put("punishResultExpropriation", CodeBook.LIKE_HQL_ID);
            filterField.put("punishResultBusiness", CodeBook.LIKE_HQL_ID);
            filterField.put("punishResultPeople", CodeBook.LIKE_HQL_ID);
            filterField.put("attachment", CodeBook.LIKE_HQL_ID);
            filterField.put("finishDate", CodeBook.LIKE_HQL_ID);
            filterField.put("resultStandard", CodeBook.LIKE_HQL_ID);
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
        sql.append(" select chang_no from M_PunishResultLog where 1=1 ");
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

    public PunishResultLog getPunishResultLog(String internalNo, String orgId,
            Long chang_no) {
        String shql = " from PunishResultLog where internalNo=? and orgId=? and cid.changNo=? ";
        Object[] objects = new Object[] { internalNo, orgId, chang_no };
        List<PunishResultLog> punishs = this.listObjects(shql, objects);
        if (punishs != null && punishs.size() >= 1) {
            return punishs.get(0);
        } else {
            return null;
        }
    }
}

package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.Pamonthpunish;

public class PamonthpunishDao extends BaseDaoImpl<Pamonthpunish> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PamonthpunishDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("statType", CodeBook.LIKE_HQL_ID);

            filterField.put("userCode", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("countYear", CodeBook.LIKE_HQL_ID);

            filterField.put("countMonth", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishUnit", CodeBook.LIKE_HQL_ID);

            filterField.put("punishCount", CodeBook.LIKE_HQL_ID);

            filterField.put("punishSum", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResion", CodeBook.LIKE_HQL_ID);

            filterField.put("auditResult", CodeBook.LIKE_HQL_ID);

            filterField.put("auditDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("auditor", CodeBook.LIKE_HQL_ID);

            filterField.put("auditDate", CodeBook.LIKE_HQL_ID);

            filterField.put("recorder", CodeBook.LIKE_HQL_ID);

            filterField.put("recordDate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String genNextPunishNo() {
        String sKey = getNextValueOfSequence("s_PUNISHNO");

        return sKey;

    }

    public String getauditResultbydata(String year, String month, String orgId) {
        String auditResult = "";
        String hql = "from Pamonthpunish where year = ? and month=? and orgId=? ";
        @SuppressWarnings("unchecked")
        List<Pamonthpunish> sqclList = (List<Pamonthpunish>) this
                .findObjectsByHql(hql, new String[] { year, month, orgId });
        if (sqclList != null) {
            Pamonthpunish ph = sqclList.get(0);
            auditResult = ph.getAuditResult();

        }
        return auditResult;
    }

    public Pamonthpunish getPamonthpunishinfo(String countYear,
            String countMonth, String orgId) {
        String hql = "from Pamonthpunish where countYear = ? and countMonth=? and orgId=?";
        Object[] objects = new Object[] { countYear, countMonth, orgId };
        List<Pamonthpunish> Applys = this.listObjects(hql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }

}

package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfRoleRelegate;

public class WfRoleRelegateDao extends BaseDaoImpl<WfRoleRelegate> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfRoleRelegateDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("relegateno", CodeBook.EQUAL_HQL_ID);

            filterField.put("grantor", CodeBook.LIKE_HQL_ID);

            filterField.put("grantee", CodeBook.LIKE_HQL_ID);

            filterField.put("isvalid", CodeBook.LIKE_HQL_ID);

            filterField.put("relegatetime",
                    "relegatetime like to_date(?,'yyyy-mm-dd')");

            filterField.put("expiretime",
                    "expiretime like to_date(?,'yyyy-mm-dd')");

            filterField.put("unitcode", CodeBook.LIKE_HQL_ID);

            filterField.put("roletype", CodeBook.LIKE_HQL_ID);

            filterField.put("rolecode", CodeBook.LIKE_HQL_ID);

            filterField.put("grantdesc", CodeBook.LIKE_HQL_ID);

            filterField.put("recorder", CodeBook.LIKE_HQL_ID);

            filterField.put("recorddate", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "recorddate desc");
        }
        return filterField;
    }

    public long getNextReleGateId() {
        String sNo = getNextValueOfSequence("S_RELEGATENO");
        return Long.valueOf(sNo);
    }

    @Override
    public void saveObject(WfRoleRelegate roleRelegate) {
        if (roleRelegate.getRelegateno() == null
                || roleRelegate.getRelegateno() == 0) {
            roleRelegate.setRelegateno(getNextReleGateId());
        }
        super.saveObject(roleRelegate);
    }
}

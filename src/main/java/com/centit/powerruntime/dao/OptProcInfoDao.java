package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerruntime.po.OptProcInfo;

public class OptProcInfoDao extends BaseDaoImpl<OptProcInfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptProcInfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("nodeinstid", CodeBook.EQUAL_HQL_ID);

            filterField.put("djId", CodeBook.LIKE_HQL_ID);

            filterField.put("nodename", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeinststate", CodeBook.LIKE_HQL_ID);

            filterField.put("transcontent", CodeBook.LIKE_HQL_ID);

            filterField.put("ideacode", CodeBook.LIKE_HQL_ID);

            filterField.put("transidea", CodeBook.LIKE_HQL_ID);

            filterField.put("transdate", CodeBook.LIKE_HQL_ID);

            filterField.put("usercode", CodeBook.LIKE_HQL_ID);

            filterField.put("unitcode", CodeBook.LIKE_HQL_ID);

            filterField.put("istrans", CodeBook.LIKE_HQL_ID);

            filterField.put("optcode", CodeBook.LIKE_HQL_ID);

            filterField.put("isrisk", CodeBook.LIKE_HQL_ID);

            filterField.put("risktype", CodeBook.LIKE_HQL_ID);

            filterField.put("riskdesc", CodeBook.LIKE_HQL_ID);

            filterField.put("riskresult", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public OptProcInfo getObjectByNodeInstId(long nodeInstId) {
        @SuppressWarnings("unchecked")
        List<OptProcInfo> procs = (List<OptProcInfo>) getHibernateTemplate()
                .find("From OptProcInfo where nodeinstid=?", nodeInstId);
        if (procs == null || procs.size() < 1)
            return null;
        return procs.get(0);
    }

}

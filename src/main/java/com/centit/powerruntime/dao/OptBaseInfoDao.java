package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerruntime.po.OptBaseInfo;

public class OptBaseInfoDao extends BaseDaoImpl<OptBaseInfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptBaseInfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("djId", CodeBook.EQUAL_HQL_ID);
            filterField.put("flowinstid", CodeBook.LIKE_HQL_ID);
            filterField.put("transaffairname", CodeBook.LIKE_HQL_ID);
            filterField.put("bizstate", CodeBook.LIKE_HQL_ID);
            filterField.put("biztype", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgcode", CodeBook.LIKE_HQL_ID);
            filterField.put("orgname", CodeBook.LIKE_HQL_ID);
            filterField.put("headunitcode", CodeBook.LIKE_HQL_ID);
            filterField.put("headusercode", CodeBook.LIKE_HQL_ID);
            filterField.put("content", CodeBook.LIKE_HQL_ID);
            filterField.put("powerid", CodeBook.LIKE_HQL_ID);
            filterField.put("powername", CodeBook.LIKE_HQL_ID);
            filterField.put("solvestatus", CodeBook.LIKE_HQL_ID);
            filterField.put("solvetime", CodeBook.LIKE_HQL_ID);
            filterField.put("solvenote", CodeBook.LIKE_HQL_ID);
            filterField.put("createuser", CodeBook.LIKE_HQL_ID);
            filterField.put("createdate", CodeBook.LIKE_HQL_ID);
            filterField.put("acceptArchiveNo", CodeBook.LIKE_HQL_ID);
            filterField.put("sendArchiveNo", CodeBook.LIKE_HQL_ID);
            filterField.put("caseNo", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public OptBaseInfo getOptBaseByFlowId(Long flowinstid) {
        List<OptBaseInfo> optBaseList = this.listObjects(
                "from OptBaseInfo where flowInstId = ?", flowinstid);
        if (optBaseList == null || optBaseList.size() == 0) {
            return null;
        }
        return optBaseList.get(0);
    }

    @SuppressWarnings("unchecked")
    public int getNumOfsameModel(String codeModel, String year) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select dj_id,caseno from opt_base_info where to_char(createdate, 'yyyy')="
                + HQLUtils.buildHqlStringForSQL(year)
                + " and caseNo like "
                + HQLUtils.buildHqlStringForSQL("%" + codeModel + "%"));
        List<Object[]> l = findObjectsBySql(sb.toString());
        return l.size();
    }

    public void updateBizType(String djId, String rolecode) {
        String HQL = null;
        if ("XKSL".equals(rolecode)) {
            HQL = "update OptBaseInfo set biztype='T' where djId=?";
        }
        if ("XKFHSD".equals(rolecode)) {
            HQL = "update OptBaseInfo set biztype='C' where djId=?";
        }
        this.doExecuteHql(HQL, djId);
    }
}

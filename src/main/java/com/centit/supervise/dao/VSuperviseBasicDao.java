package com.centit.supervise.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.VSuperviseBasic;

public class VSuperviseBasicDao extends BaseDaoImpl<VSuperviseBasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VSuperviseBasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("superviseNo", CodeBook.LIKE_HQL_ID);
            filterField.put("optId", CodeBook.LIKE_HQL_ID);
            filterField.put("flowinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("bjType", CodeBook.LIKE_HQL_ID);

            filterField.put("bjNo", CodeBook.LIKE_HQL_ID);

            filterField.put("complaintid", CodeBook.LIKE_HQL_ID);

            filterField.put("outwayid", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", " orgId = ?");

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOrgId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOrgName", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("monitorOperatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("superviseOption", CodeBook.LIKE_HQL_ID);

            filterField.put("attachment", CodeBook.LIKE_HQL_ID);

            filterField.put("promiseDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("bizType", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "superviseNo desc");

            filterField.put("monitorSource", CodeBook.LIKE_HQL_ID);

            filterField.put("NP_monitorSource", "monitorSource is null");

            filterField.put("begsupervisedate",
                    "superviseDate >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endsupervisedate",
                    "superviseDate <= to_date(?,'yyyy-mm-dd')");
            filterField.put("state", CodeBook.EQUAL_HQL_ID);
            filterField.put("isexternal", CodeBook.LIKE_HQL_ID);

            filterField.put("NP_state", " state like \'%no_receipt%\' ");
            filterField
                    .put("NP_state1",
                            "( state like \'%receipt_intime%\' or state like \'%overtime_receipt%\' or state like \'%no_result%\'  )");
            filterField.put("NP_isExternal", " isexternal is null ");

        }
        return filterField;
    }

    @SuppressWarnings("rawtypes")
    public List getdblist(String begintime, String endtime) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();

        sql.append("select nvl(xkdbnum,0) xkdbnum , nvl(zsdbnum,0)zsdbnum, nvl(cfdbnum,0)cfdbnum, nvl(qzdbnum,0)qzdbnum, nvl(qtdbnum,0)qtdbnum from( "
                + "SELECT  sum(case when  b_power.item_type='XK' then 1 else 0 end ) xkdbnum,"
                + " sum(case when  b_power.item_type='ZS' then 1 else 0 end ) zsdbnum,"
                + " sum(case when  b_power.item_type='CF' then 1 else 0 end ) cfdbnum,"
                + " sum(case when  b_power.item_type='QZ' then 1 else 0 end ) qzdbnum,"
                + " sum(case when  b_power.item_type not in('XK','ZS','CF','QZ') then 1 else 0 end ) qtdbnum "
                + " FROM  m_supervisebasic "
                + " left join m_apply on m_supervisebasic.bj_no=m_apply.no "
                + " left join m_punish on m_supervisebasic.bj_no=m_punish.no "
                + " left join b_power on b_power.item_id=m_apply.item_id||m_punish.item_id "
                + "  where  1=1  and m_supervisebasic.supervise_date>=to_date('"
                + begintime
                + "','yyyy-mm-dd') and m_supervisebasic.supervise_date>=to_date('"
                + endtime + " 23:59:59','yyyy-mm-dd HH24:mi:ss')) ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;

    }

    public String getDbbmForCjdbByDepno(String depno) {
        String sql = "select f_getdbbm('" + depno + "') from dual";
        return (String) getSession().createSQLQuery(sql).uniqueResult();
    }

}

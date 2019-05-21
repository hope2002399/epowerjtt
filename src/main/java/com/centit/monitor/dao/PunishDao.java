package com.centit.monitor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.Punish;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class PunishDao extends BaseDaoImpl<Punish> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.LIKE_HQL_ID);
            filterField.put("changNo", CodeBook.LIKE_HQL_ID);
            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);
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
            filterField.put("isTrack", CodeBook.LIKE_HQL_ID);
            filterField.put("bmcj", CodeBook.LIKE_HQL_ID);

            filterField.put("begTime", "createDate >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endTime",
                    "createDate <= to_date(?,'yyyy-mm-dd')+1");
        }
        return filterField;
    }

    public Punish getPunishInfo(String no) {
        String shql = " from Punish where no=? ";
        Object[] objects = new Object[] { no };
        List<Punish> Punishs = this.listObjects(shql, objects);
        if (Punishs != null && Punishs.size() >= 1) {
            return Punishs.get(0);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param internalNo
     * @param orgId
     * @return
     */
    public Punish getPunish(String internalNo, String orgId) {
        String shql = " from Punish where internalNo=? and orgId=? ";
        Object[] objects = new Object[] { internalNo, orgId };
        List<Punish> punishs = this.listObjects(shql, objects);
        if (punishs != null && punishs.size() >= 1) {
            return punishs.get(0);
        } else {
            return null;
        }
    }
    
    /**
     * 
     * @param internalNo
     * @return
     */
    public List getApplyReg(String internalNo) {
        String sql = "select ma.internal_no,yw.dept_yw_reg_no,ma.item_id,yw.yw_name,ql.ql_name,"
                + " (select ql_name from dept_ql_inf inf where inf.iddept_ql_inf = ql.dept_ql_parent_id) parent_name "
                + " from m_apply ma left join b_power_item_contrast con on ma.item_id = con.item_id "
                + " left join dept_yw_inf yw on yw.dept_yw_reg_no = "
                + " (case when length(ma.item_id) = 34 then ma.item_id when length(ma.outitemid) = 34 then ma.outitemid else con.serviceid end)"
                + " left join dept_ql_inf ql on ql.iddept_ql_inf = yw.dept_ql_id where ma.internal_no = '" + internalNo + "'";
        
        SQLQuery sqlQuery = getSession().createSQLQuery(sql);
        List versionList = new ArrayList();
        versionList = sqlQuery.list();
        return versionList;
    }

    public List getPunishlistsize(String begintime, String endtime) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select count(no) as punish from m_punish where create_Date >= to_date('"
                + begintime
                + "','yyyy-mm-dd') and create_Date <= to_date('"
                + endtime + " 23:59:59','yyyy-mm-dd HH24:mi:ss')");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;
    }

    @SuppressWarnings("rawtypes")
    public List getpunishalllist(String begintime, String endtime) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select sum( nvl(stat.num,0)) CFNUM,"
                + " sum(case when departmentattribute.dep_level='01' then stat.num else 0 end) as CFPJNUM,"
                + " sum(case when departmentattribute.dep_level='02' then stat.num else 0 end) as CFSJNUM,"
                + " sum(case when departmentattribute.dep_level='03' then stat.num else 0 end) as CFQXNUM,"
                + " sum( nvl(stat.allbereNum,0)) cfReNum"
                + " from departmentattribute left join("
                + " select a.org_id,count(a.no) as num,"
                + " sum(case when b.finish_date is not null then 1 else 0 end) allbereNum"
                + " from m_punish a"
                + " left join m_punishresult b on a.internal_no=b.internal_no"
                + " where 1=1 and a.punish_time >= to_date('" + begintime
                + "','yyyy-mm-dd') and a.punish_time <= to_date('" + endtime
                + " 23:59:59','yyyy-mm-dd HH24:mi:ss')" + " group by a.org_id) stat"
                + "  on departmentattribute.dep_no=stat.org_id");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;
    }
}

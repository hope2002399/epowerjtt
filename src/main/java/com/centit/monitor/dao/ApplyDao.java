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
import com.centit.monitor.po.Apply;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class ApplyDao extends BaseDaoImpl<Apply> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("no", CodeBook.LIKE_HQL_ID);
            filterField.put("changNo", CodeBook.LIKE_HQL_ID);
            filterField.put("orgId", CodeBook.EQUAL_HQL_ID);
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
            filterField.put("isTrack", CodeBook.LIKE_HQL_ID);
            filterField.put("bmcj", CodeBook.LIKE_HQL_ID);
            filterField.put("begTime", "applyDate >= to_date(?,'yyyy-mm-dd')");
            filterField
                    .put("endTime", "applyDate <= to_date(?,'yyyy-mm-dd')+1");
        }
        return filterField;
    }

    /**
     * 
     * @param internalNo
     * @param itemId
     * @return
     */
    public Apply getApply(String internalNo, String itemId) {
        String shql = " from Apply where internalNo=? and itemId=? ";
        Object[] objects = new Object[] { internalNo, itemId };
        List<Apply> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
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

    public Apply getApplyNew(String internalNo, String orgId) {
        String shql = " from Apply where internalNo=? and orgId=? ";
        Object[] objects = new Object[] { internalNo, orgId };
        List<Apply> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }

    public Apply getApplyInfo(String no) {
        String shql = " from Apply where no=? ";
        Object[] objects = new Object[] { no };
        List<Apply> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public List getApplylistsize(String begintime, String endtime) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select count(no) as no from m_apply where apply_Date >= to_date('"
                + begintime
                + "','yyyy-mm-dd') and apply_Date <= to_date('"
                + endtime + " 23:59::59','yyyy-mm-dd HH24:mi:ss')");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;
    }

    @SuppressWarnings("rawtypes")
    public List getapplyalllist(String begintime, String endtime) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select sum(case when  item_type='XK' then stat.num else 0 end) as XKNUM,"
                + " sum(case when departmentattribute.dep_level='01' and item_type='XK' then stat.num else 0 end) as XKPJNUM,"
                + " sum(case when departmentattribute.dep_level='02' and item_type='XK' then stat.num else 0 end) as XKSJNUM,"
                + " sum(case when departmentattribute.dep_level='03'  and item_type='XK' then stat.num else 0 end) as xkqxnum,"
                + " sum(case when  item_type='ZS' then stat.num else 0 end) as ZSNUM,"
                + "  sum(case when departmentattribute.dep_level='01' and item_type='ZS' then stat.num else 0 end) as zspjnum,"
                + " sum(case when departmentattribute.dep_level='02' and item_type='ZS' then stat.num else 0 end) as zssjnum,"
                + " sum(case when departmentattribute.dep_level='03'  and item_type='ZS' then stat.num else 0 end) as zsqxnum,"
                + " sum(case when  item_type='QZ' then stat.num else 0 end) as QZNUM,"
                + " sum(case when departmentattribute.dep_level='01' and item_type='QZ' then stat.num else 0 end) as qzpjnum,"
                + " sum(case when departmentattribute.dep_level='02' and item_type='QZ' then stat.num else 0 end) as qzsjnum,"
                + " sum(case when departmentattribute.dep_level='03'  and item_type='QZ' then stat.num else 0 end) as qzqxnum,"
                + " sum(case when  item_type not in('XK','ZS','QZ') then stat.num else 0 end) as QTNUM,"
                + " sum(case when departmentattribute.dep_level='01' and item_type not in('XK','ZS','QZ') then stat.num else 0 end) as qtpjnum,"
                + " sum(case when departmentattribute.dep_level='02' and item_type not in('XK','ZS','QZ') then stat.num else 0 end) as qtsjnum,"
                + " sum(case when departmentattribute.dep_level='03' and item_type not in('XK','ZS','QZ') then stat.num else 0 end) as qtqxnum,"
                + "  sum(case when   item_type='XK' then stat.allReNum else 0 end) as xkReNum,"
                + " sum(case when   item_type='ZS' then stat.allReNum else 0 end) as zsReNum,"
                + "  sum(case when item_type='QZ' then stat.allReNum else 0 end) as qzReNum,"
                + "  sum(case when item_type not in('XK','ZS','QZ')  then stat.allReNum else 0 end) as qtReNum"
                + " from departmentattribute left join ("
                + " select suppower.item_type,supapply.org_id,count(supapply.no) as num,"
                + "  sum(case when supapplyresult.finish_time is not null then 1 else 0 end) allReNum"
                + "  from m_apply supapply"
                + " left join m_applyresult supapplyresult on supapply.internal_no=supapplyresult.internal_no"
                + " left join b_power suppower on supapply.item_id=suppower.item_id"
                + " where suppower.item_type is not null and supapply.apply_Date >= to_date('"
                + begintime
                + "','yyyy-mm-dd') and supapply.apply_Date <= to_date('"
                + endtime
                + " 23:59:59','yyyy-mm-dd HH24:mi:ss')"
                + " group by supapply.org_id,suppower.item_type) stat on  departmentattribute.dep_no=stat.org_id");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;
    }
}

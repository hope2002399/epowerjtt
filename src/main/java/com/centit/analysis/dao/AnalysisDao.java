package com.centit.analysis.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.sys.po.FOptinfo;

public class AnalysisDao extends BaseDaoImpl<FOptinfo> {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getPowerApplyBJ(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "select s.datacode itemtype,nvl(s1.num1,0) bjnum  from f_datadictionary s ");
        sql.append("left join (select substr(t.item_id, 12, 2) itemtype, count(1) as num1 from m_apply t where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and t.apply_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(" group by substr(t.item_id, 12, 2)) s1 ")
                .append("  on s.datacode = s1.itemtype ")
                .append("  where s.catalogcode = 'ITEM_TYPE' and s.datacode!='CF' ")
                .append(" order by s.extracode2 ");
        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    public String getPowerPunishBJ(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "select count(1) from m_punish t where 1=1  ");

        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        return sqlQuery.list().get(0).toString();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypeApplyBJ(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "select f.datacode as INDUSTRYTYPE,nvl(a.applycount,0)+nvl(punish.punishcount,0) applynum ");

        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.org_id, 9, 2) industry_type, ")
                .append("       count(1) applycount ")
                .append(" from m_apply t ").append(" where 1 = 1 ");
        if (yearmonth != null) {
            sql.append(" and t.apply_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id, 9, 2)) a on f.datacode=a.industry_type ")
                .append("  left join (select substr(t.org_id, 9, 2) industry_type, ")
                .append("  count(1) punishcount ").append(" from m_punish t ")
                .append(" where 1 = 1 ");
        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id, 9, 2)) punish on f.datacode=punish.industry_type  ")
                .append(" where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append("  and f.datatag = 'T' ")
                .append(" order by f.extracode ");
        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypeFinishBJ(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "select f.datacode as INDUSTRYTYPE,nvl(a.applycount,0)+nvl(punish.punishcount,0) applynum ");
        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.org_id, 9, 2) industry_type, ")
                .append("       count(1) applycount ")
                .append(" from m_applyresult t ").append(" where 1 = 1 ");
        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id, 9, 2)) a on f.datacode=a.industry_type ")
                .append("  left join (select substr(t.org_id, 9, 2) industry_type, ")
                .append("  count(1) punishcount ")
                .append(" from m_punishresult t ").append(" where 1 = 1 ");
        if (yearmonth != null) {
            sql.append(" and t.finish_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id, 9, 2)) punish on f.datacode=punish.industry_type  ")
                .append(" where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append("  and f.datatag = 'T' ")
                .append(" order by f.extracode ");

        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypePowerNum(String yearmonth) {
        StringBuffer sql = new StringBuffer(
                " select f.datacode as INDUSTRYTYPE,nvl(powerinuse.powercount, 0) powercount ");
        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.org_id, 9, 2) industry_type, ")
                .append("    count(1) powercount ")
                .append(" from b_v_powerinusing t ").append(" where 1 = 1 ");
        sql.append("  group by substr(t.org_id, 9, 2)) powerinuse ")
                .append(" on f.datacode = powerinuse.industry_type ")
                .append(" where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append("  and f.datatag = 'T' ")
                .append(" order by f.extracode ");
        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypePowerUseNum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                " select f.datacode as INDUSTRYTYPE, nvl(powerinuse2.powercount, 0) powerusecount ");
        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.org_id, 9, 2) industry_type, ")
                .append("    count(1) powercount  ").append("   from  ")
                .append(" (select distinct s.item_id,s.org_id ")
                .append("    from m_apply s ").append("   where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and s.apply_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append("  group by s.item_id,s.org_id ").append("   union ")
                .append("  select distinct p.item_id,p.org_id ")
                .append("  from m_punish p ").append("  where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and p.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(" group by p.item_id,p.org_id) t ")
                .append("  group by substr(t.org_id, 9, 2)) powerinuse2 ")
                .append("  on f.datacode = powerinuse2.industry_type ")
                .append(" where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append(" and f.datatag = 'T' ")
                .append(" order by f.extracode ");
        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    public String getPowerSum(String yearmonth) {
        StringBuffer sql = new StringBuffer(
                "select count(1) from b_v_powerinusing t ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        return sqlQuery.list().get(0).toString();
    }

    public String getPowerUseSum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer("select count(1) from ( ");
        sql.append(" select distinct s.item_id,s.org_id  ")
                .append("  from m_apply s ").append("  where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and s.apply_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append("group by s.item_id,s.org_id ").append(" union ")
                .append(" select distinct p.item_id,p.org_id ")
                .append(" from m_punish p ").append("  where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and p.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(" group by p.item_id,p.org_id) ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        return sqlQuery.list().get(0).toString();
    }

    public String getApplySum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer("select count(1) from ( ");
        sql.append(" select s.no ").append("  from m_apply s ")
                .append("  where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and s.apply_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(" ").append(" union ").append(" select p.no ")
                .append(" from m_punish p ").append("  where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and p.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(" ) ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        return sqlQuery.list().get(0).toString();
    }

    public String getOutWaySum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "select count(1) from m_outway t where 1=1 and t.outwaystate='1' and t.monitor_style in ('1','2') ");
        if (yearmonth != null) {
            sql.append(" and t.intime ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        return sqlQuery.list().get(0).toString();
    }

    public String getSuperviseSum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "select count(1) from m_supervisebasic t where 1=1 ");
        if (yearmonth != null) {
            sql.append(" and t.createdate ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        return sqlQuery.list().get(0).toString();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypeOutWayNum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "  select f.datacode as INDUSTRYTYPE,nvl(f1.yjnum, 0) YJNUM,nvl(f2.bjnum, 0) BJNUM ");
        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.org_id, 9, 2) industry_type, count(1) yjnum ")
                .append("    from m_outway t ").append("   where 1 = 1 ")
                .append(" and t.outwaystate='1'  and t.monitor_style = '1' ");
        if (yearmonth != null) {
            sql.append(" and t.intime ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append("   group by substr(t.org_id, 9, 2)) f1 ")
                .append("  on f.datacode = f1.industry_type ")
                .append("  left join (select substr(t.org_id, 9, 2) industry_type, count(1) bjnum ")
                .append("    from m_outway t ").append("  where 1 = 1 ")
                .append(" and t.outwaystate='1' and t.monitor_style = '2' ");
        if (yearmonth != null) {
            sql.append(" and t.intime ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append("  group by substr(t.org_id, 9, 2)) f2 ")
                .append("  on f.datacode = f2.industry_type ")
                .append(" where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append("  and f.datatag = 'T' ")
                .append(" order by f.extracode ");

        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypeSuperviseNum(
            String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                " select f.datacode as INDUSTRYTYPE,nvl(f1.dbnum, 0) dbnum,nvl(f2.jsfknum, 0) jsfknum ");
        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.depno, 9, 2)  industry_type,count(1) dbnum from v_supervisebasic t where 1=1  ");
        if (yearmonth != null) {
            sql.append(" and t.supervise_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append("  group by  substr(t.depno, 9, 2)) f1 ")
                .append("  on f.datacode = f1.industry_type ")
                .append("  left join (select substr(t.depno, 9, 2)  industry_type,count(1) jsfknum from v_supervisebasic t where 1=1 and t.state='receipt_intime'  ");
        if (yearmonth != null) {
            sql.append(" and t.supervise_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append("  group by  substr(t.depno, 9, 2)) f2 ")
                .append("  on f.datacode = f2.industry_type ")
                .append("  where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append("  and f.datatag = 'T' ")
                .append("  order by f.extracode ");
        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getIndustryTypeBSNum(String yearmonth) {
        String nextmonth = "";
        if (yearmonth != null) {
            nextmonth = getNextYearMonth(yearmonth);
        }
        StringBuffer sql = new StringBuffer(
                "  select f.datacode as INDUSTRYTYPE, nvl(f1.ts, 0) + nvl(f2.ts, 0)+ nvl(f3.ts, 0)+ nvl(f4.ts, 0) ts ");
        sql.append(" from f_datadictionary f ")
                .append(" left join (select substr(t.org_id,9,2) industry_type,count(1) ts from m_applyprocess t where 1=1  ");
        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id,9,2)) f1 on f.datacode = f1.industry_type ")
                .append("left join (select substr(t.org_id,9,2) industry_type,count(1) ts from m_applyresult t where 1=1  ");
        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id,9,2)) f2 on f.datacode = f2.industry_type ")
                .append(" left join (select substr(t.org_id,9,2) industry_type,count(1) ts from m_punishprocess t where 1=1  ");
        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                "group by substr(t.org_id,9,2)) f3 on f.datacode = f3.industry_type ")
                .append("left join (select substr(t.org_id,9,2) industry_type,count(1) ts from m_punishresult t where 1=1  ");
        if (yearmonth != null) {
            sql.append(" and t.create_date ").append("between to_date('")
                    .append(yearmonth).append("','yyyy-mm') and to_date('")
                    .append(nextmonth).append("','yyyy-mm') ");
        }
        sql.append(
                " group by substr(t.org_id,9,2)) f4 on f.datacode = f4.industry_type ")

        .append(" where f.catalogcode = 'INDUSTRY_TYPE2' ")
                .append(" and f.datatag = 'T' ")
                .append("order by f.extracode ");

        Query query = getSession().createSQLQuery(sql.toString())
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    // 根据给定的月份，取上一个月份
    @SuppressWarnings("deprecation")
    private String getNextYearMonth(String yearmonth) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date date = sdf.parse(yearmonth + "-01");
            date.setMonth(date.getMonth() + 1);
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

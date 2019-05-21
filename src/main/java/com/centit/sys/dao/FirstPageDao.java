package com.centit.sys.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.sys.po.FOptinfo;

public class FirstPageDao extends BaseDaoImpl<FOptinfo> {
    private static final long serialVersionUID = 1L;

    public String getYjnum(String yyyymm) {
        
        StringBuffer sql = new StringBuffer(
                "select count(t.outwayno) from m_outway t,V_hi_unitinfo v where t.org_Id=v.depno and topunitcode='1' and v.isvalid='T' and t.outwaystate='1' ");

        /*if (yyyymm != null) {
            sql.append(" and to_char(t.intime,'yyyymm')='").append(yyyymm)
                    .append("'");
        }*/
        
        if (yyyymm != null) {
            sql.append(" and t.intime >= to_date('").append(yyyymm).append("','yyyy-mm') ");
            sql.append(" and t.intime < to_date('").append(String.valueOf(Integer.parseInt(yyyymm)+1)).append("','yyyy-mm') ");
        }

        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());

        return sqlQuery.list().get(0).toString();
    }

    public String getDbnum(String yyyymm) {
        
        StringBuffer sql = new StringBuffer(
                "select count(t.supervise_no) from m_supervisebasic t where 1=1 ");

        /*if (yyyymm != null) {
            sql.append(" and to_char(t.supervise_date,'yyyymm')='")
                    .append(yyyymm).append("'");
        }*/
        if (yyyymm != null) {
            sql.append(" and t.supervise_date >= to_date('").append(yyyymm).append("','yyyy-mm') ");
            sql.append(" and t.supervise_date < to_date('").append(String.valueOf(Integer.parseInt(yyyymm)+1)).append("','yyyy-mm') ");
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());

        return sqlQuery.list().get(0).toString();
    }

    public String getAreaXkNum(String areacode, String yyyymm) {
       /* StringBuffer sql = new StringBuffer(
                "select count(t.no) from m_applyresult t where " +
                " exists (select 1 from    b_power b where b.item_id=t.item_id and" +
                "(b.version <> 0 and b.begin_time <= sysdate and (b.end_time is null or b.end_time > sysdate))) ");*/
        //新的权力34位编码
        StringBuffer sql = new StringBuffer(
                "select count(t.no) from m_applyresult t where 1 = 1 ");
        if (areacode != null && areacode.length()>0) {
            sql.append("and t.org_id like '").append(areacode)
                    .append("'||'%' ");
        }
        /*if (yyyymm != null) {
            sql.append(" and to_char(t.finish_time,'yyyymm')='").append(yyyymm)
                    .append("'");
        }*/
        if (yyyymm != null) {
            sql.append(" and t.finish_time >= to_date('").append(yyyymm).append("','yyyy-mm') ");
            if(StringUtils.isNotBlank(yyyymm) && yyyymm.length()==6){
                String mm = yyyymm.substring(4,6);
                String yyyy = yyyymm.substring(0,4);
                if(!"12".equals(mm)){
                    sql.append(" and t.finish_time < to_date('").append(String.valueOf(Integer.parseInt(yyyymm)+1)).append("','yyyy-mm') ");
                }else{
                    sql.append(" and t.finish_time < to_date('").append(Integer.valueOf(yyyy)+1).append("01','yyyy-mm') ");
                }
            }else{
                sql.append(" and t.finish_time < to_date('").append(String.valueOf(Integer.parseInt(yyyymm)+1)).append("','yyyy-mm') ");
            }
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());

        return sqlQuery.list().get(0).toString();
    }

    public String getAreaCfNum(String areacode, String yyyymm) {
        /*StringBuffer sql = new StringBuffer(
                "select count(t.no) from m_punishresult t " +
                        "where exists (select 1 from    b_power b where b.item_id=t.item_id and" +
                "(b.version <> 0 and b.begin_time <= sysdate and (b.end_time is null or b.end_time > sysdate))) ");*/
        StringBuffer sql = new StringBuffer(
                "select count(t.no) from m_punishresult t where 1=1 ");
        if (areacode != null) {
            sql.append("and t.org_id like '").append(areacode)
                    .append("'||'%' ");
        }
        /*if (yyyymm != null) {
            sql.append(" and to_char(t.finish_date,'yyyymm')='").append(yyyymm)
                    .append("'");
        }*/
        if (yyyymm != null) {
            sql.append(" and t.finish_date >= to_date('").append(yyyymm).append("','yyyy-mm') ");
            if(StringUtils.isNotBlank(yyyymm) && yyyymm.length()==6){
                String mm = yyyymm.substring(4,6);
                String yyyy = yyyymm.substring(0,4);
                if(!"12".equals(mm)){
                    sql.append(" and t.finish_date < to_date('").append(String.valueOf(Integer.parseInt(yyyymm)+1)).append("','yyyy-mm') ");
                }else{
                    sql.append(" and t.finish_date < to_date('").append(Integer.valueOf(yyyy)+1).append("01','yyyy-mm') ");
                }
            }else{
                sql.append(" and t.finish_date < to_date('").append(String.valueOf(Integer.parseInt(yyyymm)+1)).append("','yyyy-mm') ");
            }
            
        }
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());

        return sqlQuery.list().get(0).toString();
    }

    public String getAreaXkBjl(String areacode, String yyyymm) {
        /* StringBuffer sql = new StringBuffer(
                 "select count(t.no) from m_applyresult t where " +
                 " exists (select 1 from    b_power b where b.item_id=t.item_id and" +
                 "(b.version <> 0 and b.begin_time <= sysdate and (b.end_time is null or b.end_time > sysdate))) ");*/
         //新的权力34位编码
         StringBuffer sql = new StringBuffer(
                 "select trunc((count(b.no)/count(a.no) )*100 ,2) as bjl "+
                         " from m_apply a left join m_applyresult b on a.internal_no= b.internal_no and a.item_id= b.item_id"+
                         " where 1=1 ");
         if (areacode != null) {
             sql.append("and a.org_id like '").append(areacode)
                     .append("'||'%' ");
         }
         if (yyyymm != null) {
             sql.append(" and to_char(a.apply_date,'yyyymm')='").append(yyyymm)
                     .append("'");
         }
         SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());

         return sqlQuery.list().get(0).toString();
     }

     public String getAreaCfBjl(String areacode, String yyyymm) {
         /*StringBuffer sql = new StringBuffer(
                 "select count(t.no) from m_punishresult t " +
                         "where exists (select 1 from    b_power b where b.item_id=t.item_id and" +
                 "(b.version <> 0 and b.begin_time <= sysdate and (b.end_time is null or b.end_time > sysdate))) ");*/
         StringBuffer sql = new StringBuffer(
                 "select trunc((count(b.no)/count(a.no) )*100 ,2) as bjl "+
                         " from m_punish a left join m_punishresult b on a.internal_no= b.internal_no and a.org_id = b.org_id"+
                         " where 1=1  ");
         if (areacode != null) {
             sql.append("and a.org_id like '").append(areacode)
                     .append("'||'%' ");
         }
         if (yyyymm != null) {
             sql.append(" and to_char(a.create_date,'yyyymm')='").append(yyyymm)
                     .append("'");
         }
         SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());

         return sqlQuery.list().get(0).toString();
     }
}

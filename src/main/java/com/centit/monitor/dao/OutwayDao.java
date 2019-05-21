package com.centit.monitor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.Unit.Constant;
import com.centit.monitor.po.Outway;

public class OutwayDao extends MonitorDaoImpl<Outway> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("NP_outWayQX", " OutWayState = '0' ");
            filterField.put("NP_outWayZC", " OutWayState = '1' ");
            filterField.put("bjType", " bj_type = ? ");
            filterField.put("orgId", " org_id = ? ");
            filterField.put("internalNo", " internal_No = ? ");
            filterField.put("monitorStyle", " monitor_Style = ? ");
            filterField.put("monitorType", " monitor_Type = ? ");
            filterField.put("monitorSource", " MONITOR_SOURCE = ?");
            filterField.put("topunitcode", " topunitcode = ? ");
            filterField.put("processNo", " process_No = ? ");
            filterField.put("calcNo", " calc_No = ? ");
            filterField.put("warningCode", " warning_Code = ? ");
            // 时间范围过滤 条件
            filterField
                    .put("begTime",
                            " to_date(to_char(intime, 'yyyy-mm-dd'), 'yyyy-mm-dd') >= to_date(?, 'yyyy-mm-dd') ");
            filterField
                    .put("endTime",
                            " to_date(to_char(intime, 'yyyy-mm-dd'), 'yyyy-mm-dd') <= to_date(?, 'yyyy-mm-dd') ");
            // 排序
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " o.intime desc");
        }
        return filterField;
    }

    public void updateMore(Outway outway, String[] warnNoList) {
        SessionFactory sessionFactory = getSession().getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String hqlUpdate = "update Outway o set o.outtime=:outtime, o.outperson=:outperson,"
                    + "o.outreason=:outreason, o.OutWayState=:OutWayState "
                    + "where o.outwayno = :outwayno";
            for (int i = 0; i < warnNoList.length; i++) {
                session.createQuery(hqlUpdate)
                        .setTimestamp("outtime", outway.getOuttime())
                        .setString("outperson", outway.getOutperson())
                        .setString("outreason", outway.getOutreason())
                        .setString("OutWayState", outway.getOutWayState())
                        .setLong("outwayno", Long.parseLong(warnNoList[i]))
                        .executeUpdate();
                if (i > 0 && i % 20 == 0) {
                    tx.commit();
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Outway> getOutWayList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " select o from Outway o ,Vhiunitinfo v where o.orgId=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public List<Outway> getOutWayListT(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " select o from Outway o ,Vhiunitinfo v where o.orgId=v.depno ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public List<Outway> getOutWayList(Map<String, Object> filterMap) {
        String shql = " select o from Outway o,Vhiunitinfo v where o.orgId=v.depno ";
        return listObjects(shql, filterMap);
    }

    public String getMaxStateFromOutWay(String processno, String internalno) {
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("internalNo", internalno);
        filtermap.put("processNo", processno);
        List<Outway> list = this.getOutWayList(filtermap);
        if (list.size() == 0) {
            return "-1";
        }
        String hql = " select max(monitorStyle) from Outway o where o.processNo='"
                + processno + "' and o.internalNo='" + internalno + "'";
        Long state = getSingleIntByHql(hql);
        if (state != null) {
            return state.toString();
        } else {
            return "-1";
        }
    }

    public String getCJJCBjType2(String outwayId2) {
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("outwayno", outwayId2);
        String shql = " select o from Outway o where 1=1 ";

        List<Outway> list = listObjects(shql, filtermap);

        Outway o = list.get(0);
        return o.getBjType();
    }

    /**
     * 根据预警批次号获取报警级别预警数目
     * 
     * @param calcNo
     * @param monitorStyle
     * @return
     */
    public Long getAlertCount(Long calcNo) {
        String hql = "select count(o.outwayno) from Outway o where o.calcNo="
                + calcNo + " and o.monitorStyle='" + Constant.OutwayLevel_BJ
                + "'";
        return getSingleIntByHql(hql);
    }

    /**
     * 根据预警批次号获取预警级别+提醒级别的预警数目
     * 
     * @param calcNo
     * @return
     */
    public Long getAlarmCount(Long calcNo) {
        String hql = "select count(o.outwayno) from Outway o where o.calcNo="
                + calcNo + " and o.monitorStyle<>'" + Constant.OutwayLevel_BJ
                + "'";
        return getSingleIntByHql(hql);
    }

    @SuppressWarnings("rawtypes")
    public List getcjjclist(String begintime, String endtime) {
        List versionList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select nvl(allcjqcybjnum,0) allcjqcybjnum,nvl(xkcqjcybjnum,0) xkcqjcybjnum,nvl(zscqjcybjnum,0) zscqjcybjnum,nvl(cfcqjcybjnum,0) cfcqjcybjnum,"
                + " nvl(qzcqjcybjnum,0) qzcqjcybjnum,nvl(qtcqjcybjnum,0) qtcqjcybjnum from ("
                + "select  sum(case when item_type is not null  then 1 else 0 end) as allcjqcybjnum,"
                + "  sum(case when item_type='XK' then 1 else 0 end ) as xkcqjcybjnum,"
                + " sum(case when item_type='ZS' then 1 else 0 end ) as zscqjcybjnum,"
                + "  sum(case when item_type='CF' then 1 else 0 end ) as cfcqjcybjnum,"
                + "  sum(case when item_type='QZ' then 1 else 0 end ) as qzcqjcybjnum,"
                + " sum(case when item_type not in('XK','ZS','CF','QZ') then 1 else 0 end ) as qtcqjcybjnum"
                + " from m_outway"
                + " left join B_V_POWERINUSING b on b.item_id=m_outway.item_id "
                + "  where m_outway.item_id is not null and b.version<>0 and m_outway.intime >= to_date('"
                + begintime
                + "','yyyy-mm-dd') and m_outway.intime <= to_date('"
                + endtime
                + " 23:59:59','yyyy-mm-dd HH24:mi:ss')) ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        versionList = sqlQuery.list();
        return versionList;

    }
}

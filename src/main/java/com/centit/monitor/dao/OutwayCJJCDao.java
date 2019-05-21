package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.monitor.po.OutwayCJJC;

public class OutwayCJJCDao extends MonitorDaoImpl<OutwayCJJC> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("outwayId", " o.outwayid = ? ");

            filterField.put("orgId", " org_id = ? ");
            filterField.put("warnpointno", " o.warnpointno = ? ");
            filterField.put("outwaytype", " o.outwaytype = ? ");
            filterField.put("oldoutwaytype", " o.oldOutwayType = ? ");

            // 时间范围过滤 条件
            filterField.put("begTime", " intime >= to_date(?, 'yyyy-mm-dd') ");
            filterField.put("endTime", " intime <= to_date(?, 'yyyy-mm-dd') ");

            // 排序
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " o.intime desc");
        }
        return filterField;
    }

    public void updateMore(OutwayCJJC outway, String[] warnNoList) {
        SessionFactory sessionFactory = getSession().getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String hqlUpdate = "update OutwayCJJC o set o.outtime=:outtime, o.outperson=:outperson,"
                    + "o.outreason=:outreason "
                    + "where o.outwayno = :outwayno";
            for (int i = 0; i < warnNoList.length; i++) {
                session.createQuery(hqlUpdate)
                        .setTimestamp("outtime", outway.getOuttime())
                        .setString("outperson", outway.getOutperson())
                        .setString("outreason", outway.getOutreason())
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

    public List<OutwayCJJC> getOutWayList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " select o from OutwayCJJC o  where 1=1 "; // select o
                                                                 // from
                                                                 // OutwayCJJC o
                                                                 // ,Vhiunitinfo
                                                                 // v where
                                                                 // o.orgId=v.depno
        return listObjects(shql, filterMap, pageDesc);
    }

    public List<OutwayCJJC> getOutWayListT(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String shql = " select o from OutwayCJJC o  where 1=1 ";
        return listObjects(shql, filterMap, pageDesc);
    }

    public List<OutwayCJJC> getOutWayList(Map<String, Object> filterMap) {
        String shql = " select o from OutwayCJJC o where 1=1 ";
        return listObjects(shql, filterMap);
    }

    public String getMaxStateFromOutWay(String processno, String internalno) {
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("internalNo", internalno);
        filtermap.put("processNo", processno);
        List<OutwayCJJC> list = this.getOutWayList(filtermap);
        if (list.size() == 0) {
            return "-1";
        }
        String hql = " select max(monitorStyle) from OutwayCJJC o where o.processNo='"
                + processno + "' and o.internalNo='" + internalno + "'";
        Long state = getSingleIntByHql(hql);
        if (state != null) {
            return state.toString();
        } else {
            return "-1";
        }
    }

    public OutwayCJJC getOutwayCJJCById(String id) {
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("outwayId", Long.getLong(id));

        List<OutwayCJJC> list = this.getOutWayList(filtermap);
        return list.size() > 0 ? list.get(0) : null;
    }
}

package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.Punishobjectbasic;

public class PunishobjectbasicDao extends BaseDaoImpl<Punishobjectbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishobjectbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectno", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjecttype", CodeBook.LIKE_HQL_ID);

            filterField.put("managedepid", CodeBook.EQUAL_HQL_ID);

            filterField.put("poorigindate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisterdate", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepdate", CodeBook.LIKE_HQL_ID);

            filterField.put("pofinishdate", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectbrief", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurstate", CodeBook.LIKE_HQL_ID);

            filterField.put("poimpeachstate", CodeBook.LIKE_HQL_ID);

            filterField.put("poundertaker", CodeBook.LIKE_HQL_ID);

            filterField.put("punishclassnum", CodeBook.LIKE_HQL_ID);

            filterField.put("pocontrovertype", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussnum", CodeBook.LIKE_HQL_ID);

            filterField.put("issurpass", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectstate", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

            filterField.put("ispass", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccuradress", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurdate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisteropinion", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorid", CodeBook.LIKE_HQL_ID);

            filterField.put("poorigincontext", CodeBook.LIKE_HQL_ID);

            filterField.put("poregistedate", CodeBook.LIKE_HQL_ID);

            filterField.put("pooriginstate", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachphone", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachunit", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachid", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachname", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachsex", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachage", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachadress", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachpostcode", CodeBook.LIKE_HQL_ID);

            filterField.put("riskdesc", CodeBook.LIKE_HQL_ID);

            filterField.put("risktype", CodeBook.LIKE_HQL_ID);

            filterField.put("riskresult", CodeBook.LIKE_HQL_ID);

            filterField.put("optId", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    /**
     * 案件流水号PUNISHOBJECTID
     * 
     * @return
     */

    public String genNextPunishObjectId() {
        return "CF" + getNextKeyBySequence("S_PUNISHOBJECTBASIC", 14);
    }

    /**
     * 根据流程实例编号获取案件信息
     * 
     * @param flowinstid
     * @return
     */
    public Punishobjectbasic getPunishBaseByFlowId(Long flowinstid) {
        List<Punishobjectbasic> optBaseList = this.listObjects(
                "from Punishobjectbasic where flowInstId = ?", flowinstid);
        if (optBaseList == null || optBaseList.size() == 0) {
            return null;
        }
        return optBaseList.get(0);
    }

    /**
     * 更新处罚项目种类数量
     * 
     * @param punishObjectID
     * @param state
     */
    public void updatepunishNum(String punishObjectID, String state) {
        Punishobjectbasic o = this.getObjectById(punishObjectID);
        int punishnum = 0;
        if (null == o.getPunishclassnum()) {
            o.setPunishclassnum((long) 0);
        }
        if ("add".equals(state)) {
            punishnum = o.getPunishclassnum().intValue() + 1;
        }
        if ("del".equals(state)) {
            punishnum = o.getPunishclassnum().intValue() - 1;
        }
        o.setPunishclassnum((long) punishnum);
        this.save(o);
    }

    /*
     * public void updateIsisSurpass(String punishObjectID,String isSurpass) {
     * Punishobjectbasic saveobject=this.getObjectById(punishObjectID);
     * saveobject.setIssurpass(Long.parseLong(isSurpass));
     * this.save(saveobject); }
     */

    @SuppressWarnings("unchecked")
    public int getNumOfsameModel(String codeModel, String year) {
        StringBuffer sb = new StringBuffer();
        sb.append(" select punishobjectid,caseno from p_punish_object_basic where to_char(poregisterdate, 'yyyy')="
                + HQLUtils.buildHqlStringForSQL(year)
                + " and caseno like "
                + HQLUtils.buildHqlStringForSQL("%" + codeModel + "%"));
        List<Object[]> l = findObjectsBySql(sb.toString());
        return l.size();
    }

    /**
     * 查询处罚查看
     * 
     * @param filterMap
     * @param pageDesc
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Punishobjectbasic> listPunishObjectBasics(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = "from p_punish_object_basic where 1=1 ";
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);
        String queryUnderUnit = "";
        if ("true".equals(filterMap.get("queryUnderUnit"))) {
            queryUnderUnit = " or managedepid in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                    + filterMap.get("managedepid") + " ) ";
        }
        queryUnderUnit += " order by  poregistedate desc ";
        String hql1 = "select *  " + hql.getHql() + queryUnderUnit;
        String hql2 = "select count(*)  " + hql.getHql() + queryUnderUnit;
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();

        List<Punishobjectbasic> l = null;
        try {

            l = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, Punishobjectbasic.class));
            pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                    .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
                    .get(0).toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return l;
    }

    public Punishobjectbasic getPunishobjectid(String punishobjectid) {
        String HQL = "from Punishobjectbasic  a  where 1=1 and  a.punishobjectid=?";
        List<Punishobjectbasic> pl = this.listObjects(HQL,
                new String[] { punishobjectid });
        if (pl == null || pl.size() <= 0) {
            return null;
        } else {
            return pl.get(0);
        }

    }

}

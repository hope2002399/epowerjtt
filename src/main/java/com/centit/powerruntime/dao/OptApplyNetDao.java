package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.OptApplyInfoNet;
import com.centit.powerruntime.po.OptApplyReturn;
import com.centit.powerruntime.po.VOptApplyInfoNet;

public class OptApplyNetDao extends BaseDaoImpl<OptApplyInfoNet> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptApplyNetDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("netId", CodeBook.EQUAL_HQL_ID);
            filterField.put("djId", CodeBook.EQUAL_HQL_ID);
            filterField.put("channelName", CodeBook.LIKE_HQL_ID);

            filterField.put("channelLevel", CodeBook.LIKE_HQL_ID);

            filterField.put("elevationSystem", CodeBook.LIKE_HQL_ID);

            filterField.put("applyDate",
                    "applyDate like to_date(?,'yyyy-mm-dd')");

            filterField.put("proposerName", CodeBook.LIKE_HQL_ID);

            filterField.put("applyItem", CodeBook.LIKE_HQL_ID);

            filterField.put("applyReason", CodeBook.LIKE_HQL_ID);

            filterField.put("applyWay", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerType", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerPaperType", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerPaperCode", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerPhone", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerMobile", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerAddr", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerZipcode", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerEmail", CodeBook.LIKE_HQL_ID);

            filterField.put("proposerUnitcode", CodeBook.LIKE_HQL_ID);

            filterField.put("agentName", CodeBook.LIKE_HQL_ID);

            filterField.put("agentPaperType", CodeBook.LIKE_HQL_ID);

            filterField.put("agentPaperCode", CodeBook.LIKE_HQL_ID);

            filterField.put("agentPhone", CodeBook.LIKE_HQL_ID);

            filterField.put("agentMobile", CodeBook.LIKE_HQL_ID);

            filterField.put("agentAddr", CodeBook.LIKE_HQL_ID);

            filterField.put("agentZipcode", CodeBook.LIKE_HQL_ID);

            filterField.put("agentEmail", CodeBook.LIKE_HQL_ID);

            filterField.put("agentUnitcode", CodeBook.LIKE_HQL_ID);

            filterField.put("applyMemo", CodeBook.LIKE_HQL_ID);

            filterField.put("acceptDate",
                    "acceptDate like to_date(?,'yyyy-mm-dd')");
            filterField
                    .put("bookDate", "bookDate like to_date(?,'yyyy-mm-dd')");
            filterField.put("auditingDate",
                    "auditingDate like to_date(?,'yyyy-mm-dd')");

            filterField.put("headUsercode", CodeBook.LIKE_HQL_ID);

            filterField.put("headAuditingIdea", CodeBook.LIKE_HQL_ID);

            filterField.put("checkIdeaDate",
                    "checkIdeaDate like to_date(?,'yyyy-mm-dd')");

            filterField.put("checkUsercode", CodeBook.LIKE_HQL_ID);

            filterField.put("checkIdea", CodeBook.LIKE_HQL_ID);

            filterField.put("checkDetail", CodeBook.LIKE_HQL_ID);

            filterField.put("checkAddr", CodeBook.LIKE_HQL_ID);

            filterField.put("checkDate",
                    "checkDate like to_date(?,'yyyy-mm-dd')");

            filterField.put("checkMemo", CodeBook.LIKE_HQL_ID);

            filterField.put("item_Type", CodeBook.EQUAL_HQL_ID);

            filterField.put("proposer_Name", CodeBook.LIKE_HQL_ID);

            filterField.put("proposer_Unitcode", CodeBook.LIKE_HQL_ID);
            filterField.put("transaffairname", CodeBook.LIKE_HQL_ID);
            filterField.put("apply_Way", CodeBook.EQUAL_HQL_ID);
            filterField.put("orgcode", CodeBook.EQUAL_HQL_ID);
            filterField.put("NP_delete", " bizstate !='W' ");
            filterField.put("bizstate", CodeBook.EQUAL_HQL_ID);

        }
        return filterField;
    }

    /*
     * public String genNextDjID(String item_type){ return item_type +
     * getNextKeyBySequence("S_PERMIT_APPLY",14); }
     */
    

    public void insertOptApplyReturn(OptApplyReturn appret){
        String inssql="insert into opt_apply_return (TRANSAFFAIRNAME, ORGCODE, ORGNAME, POWERID, POWERNAME, CASENO, ISTOTAL, ISACCEPT, SIGN, SYNC_DATE, SYNC_ERROR_DESC, NET_ID, SLYJ, UPDATE_DATE, DJID)"
                    + "values ('" + appret.getTransaffairName() + "','" + appret.getOrgCode() + "','"
                    + appret.getOrgName() + "','" + appret.getPowerId() + "','" + appret.getPowerName() + "','"
                    + appret.getCaseNo() + "','" + appret.getIsTotal() + "','" + appret.getIsaccpet() + "','"
                    + appret.getSign() + "',sysdate,'" + appret.getSyncErrorDesc() + "','"
                    + appret.getNetId() + "','" + appret.getSlyj() + "',sysdate,'" + appret.getDjId() + "')";
        super.doExecuteSql(inssql);
    }

    @SuppressWarnings("unchecked")
    public List<VOptApplyInfoNet> listOptApplyInfoNet(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        String shql = "from v_opt_apply_info_net where 1=1 ";
        String queryUnderUnit = "";
        // 得到登陆人所在部门的orgcode
        String orgcode1 = (String)filterMap.get("orgcode1");
        if(null != orgcode1){
            // 限制查找办件为登陆人所在部门或者其下属机构的办件
            queryUnderUnit += " and orgcode in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                    + orgcode1 + " )  ";
            // 传值完成，清除多余查找条件
            filterMap.remove("orgcode1");
        }
        
        if ("true".equals(filterMap.get("queryUnderUnit"))) {
            queryUnderUnit += " and orgcode in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                    + filterMap.get("orgcode") + " ) ";

            // 包含下属机构后，应去除查询所选的本级部门查询条件，如果不去builderHqlAndParams(shql,
            // filterMap)方法里会加上 and orgcode= 的条件，导致实际查找到的数据不包含下属机构
            filterMap.put("orgcode", null);
        }

        HqlAndParams hql = builderHqlAndParams(shql, filterMap);

        String hql1 = "select *  " + hql.getHql() + queryUnderUnit;
        String hql2 = "select count(*)  " + hql.getHql() + queryUnderUnit;
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        List<VOptApplyInfoNet> l = null;
        try {

            l = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, VOptApplyInfoNet.class));
            pageDesc.setTotalRows(new Integer(getHibernateTemplate()
                    .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
                    .get(0).toString()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return l;
    }
    
    /**
     * 获取未发送通知消息的人员
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> getSendMessageInfo(){
        String sql="select distinct a.usercode,a.username,a.loginname,a.contactphone,a.officephone,"
                + " c.unitcode,c.depno,c.unitname,v.net_id from v_opt_apply_info_net v "
                + " left join f_userunit b on b.unitcode=v.orgcode"
                + " left join f_userinfo a on b.usercode=a.usercode"
                + " left join f_unitinfo c on c.unitcode=b.unitcode"
                + " where a.usercode in (select usercode from f_userrole where rolecode in( 'P-YSLSC','P-hsyzw')) and v.bizstate = 'F'"
                + " and v.net_id not in(select net_id from sms_log)";
        List<Object[]> objList = (List<Object[]>)findObjectsBySql(sql);
        return objList;
    }
}

package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.HqlAndParams;
import com.centit.core.dao.SQLQueryCallBack;
import com.centit.core.utils.PageDesc;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptApplyResult;
import com.centit.powerruntime.po.VOptApplyInfo;

public class OptApplyResultDao extends BaseDaoImpl<OptApplyResult>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(OptApplyResultDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("no" , CodeBook.EQUAL_HQL_ID);

			filterField.put("applyDate",
                    "applyDate like to_date(?,'yyyy-MM-dd')");

			filterField.put("orgId" , CodeBook.LIKE_HQL_ID);

			filterField.put("internalNo" , CodeBook.LIKE_HQL_ID);

			filterField.put("itemId" , CodeBook.LIKE_HQL_ID);

			filterField.put("status" , CodeBook.LIKE_HQL_ID);

			filterField.put("note" , CodeBook.LIKE_HQL_ID);

			filterField.put("finishTime",
                    "finishTime like to_date(?,'yyyy-MM-dd')");

			filterField.put("receivable" , CodeBook.LIKE_HQL_ID);

			filterField.put("paid" , CodeBook.LIKE_HQL_ID);

			filterField.put("reliefReasons" , CodeBook.LIKE_HQL_ID);

			filterField.put("department" , CodeBook.LIKE_HQL_ID);

			filterField.put("transactAffairName" , CodeBook.LIKE_HQL_ID);

			filterField.put("content" , CodeBook.LIKE_HQL_ID);

			filterField.put("applyWay" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantCode" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantType" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantName" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantPaperType" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantPaperCode" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantPhone" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantMobile" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantAddress" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantZipcode" , CodeBook.LIKE_HQL_ID);

			filterField.put("applicantEmail" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkman" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanName" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanPaperType" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanPaperCode" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanPhone" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanMobile" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanAddress" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanZipcode" , CodeBook.LIKE_HQL_ID);

			filterField.put("linkmanEmail" , CodeBook.LIKE_HQL_ID);
			
			/*filterField.put(CodeBook.ORDER_BY_HQL_ID, " finishTime desc ");*/

		}
		return filterField;
	}

	/**
	 * 查询送达列表
	 * @param filterMap
	 * @param pageDesc
	 * @return
	 */
    @SuppressWarnings("unchecked")
    public List<OptApplyResult> listOptApplyResult(Map<String, Object> filterMap, PageDesc pageDesc) {
        boolean state=true;//初始化状态
        String shql = " from opt_apply_result where 1=1 ";
        HqlAndParams hql = builderHqlAndParams(shql, filterMap);
        String queryUnderUnit = "";
        String countQueryUnit = "";
        if (filterMap.get("orgcode") != null) {
            queryUnderUnit = " and (orgcode=" + filterMap.get("orgcode");
            countQueryUnit = " and (orgcode=" + filterMap.get("orgcode");
            if ("true".equals(filterMap.get("queryUnderUnit"))) {
                queryUnderUnit += " or orgcode in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                        + filterMap.get("orgcode") + " ) ";
                countQueryUnit += " or orgcode in ( select unitcode from f_unitinfo connect by prior unitcode = parentunit start with unitcode= "
                        + filterMap.get("orgcode") + " ) ";
                
            }
            queryUnderUnit += ")";
        }
        if (!StringUtils.isBlank((String)filterMap.get("applicantName"))) {
            state=false;
            queryUnderUnit += " and applicant_Name like '%"+filterMap.get("applicantName")+"%' ";
            countQueryUnit += " and b.applicant_Name like '%"+filterMap.get("applicantName")+"%' ";
        }
        if (!StringUtils.isBlank((String)filterMap.get("transactAffairName"))) {
            state=false;
            queryUnderUnit += " and transact_affair_name like '%"+filterMap.get("transactAffairName")+"%' ";
            countQueryUnit += " and b.transact_affair_name like '%"+filterMap.get("transactAffairName")+"%' ";
        }
        if (!StringUtils.isBlank((String)filterMap.get("internalNo"))) {
            state=false;
            queryUnderUnit += " and internal_no like '%"+filterMap.get("internalNo")+"%' ";
            countQueryUnit += " and a.internal_no like '%"+filterMap.get("internalNo")+"%' ";
        }
        if(!StringUtils.isBlank((String)filterMap.get("finishBeginTime"))){
            state=false;
            queryUnderUnit = queryUnderUnit  +"  and finish_time >= '"+filterMap.get("finishBeginTime")+"' ";
            countQueryUnit = countQueryUnit  +"  and a.finish_time >= '"+filterMap.get("finishBeginTime")+"' ";
        }
        if(!StringUtils.isBlank((String)filterMap.get("finishEndTime"))){
            state=false;
            queryUnderUnit = queryUnderUnit  +"  and finish_time <= '"+filterMap.get("finishEndTime")+" 23:59:59' "; 
            countQueryUnit = countQueryUnit  +"  and a.finish_time <= '"+filterMap.get("finishEndTime")+" 23:59:59' ";
        } 
        if(!StringUtils.isBlank((String)filterMap.get("applyBeginTime"))){
            state=false;
            queryUnderUnit = queryUnderUnit  +"  and apply_date >= '"+filterMap.get("applyBeginTime")+"' ";
            countQueryUnit = countQueryUnit  +"  and b.apply_date >= '"+filterMap.get("applyBeginTime")+"' ";
        }
        if(!StringUtils.isBlank((String)filterMap.get("applyEndTime"))){
            state=false;
            queryUnderUnit = queryUnderUnit  +"  and apply_date <= '"+filterMap.get("applyEndTime")+" 23:59:59' ";
            countQueryUnit = countQueryUnit  +"  and b.apply_date <= '"+filterMap.get("applyEndTime")+" 23:59:59' ";
        } 
        
        if (!StringUtils.isBlank((String)filterMap.get("sendWay"))) {
            state=false;
            queryUnderUnit += " and sendway = '"+filterMap.get("sendWay")+"' ";
            countQueryUnit += " and c.sendway = '"+filterMap.get("sendWay")+"' ";
        }
        
        if (!StringUtils.isBlank((String)filterMap.get("servicetype"))) {
            state=false;
            queryUnderUnit += " and org_id like '%"+filterMap.get("servicetype")+"%' ";
            countQueryUnit += " and a.org_id like '%"+filterMap.get("servicetype")+"%' ";
        }
        if (state) {//默认初始化近一个月数据
            //queryUnderUnit = "and finish_time <to_char(sysdate,'yyyy-MM-dd HH:mm:ss') and finish_time>to_char(sysdate - 30,'yyyy-MM-dd HH:mm:ss')";
            queryUnderUnit = " and to_date(finish_time,'yyyy-mm-dd hh24:mi:ss')<sysdate  and to_date(finish_time,'yyyy-mm-dd hh24:mi:ss')>sysdate -30";
            countQueryUnit = " and to_char(a.finish_time, 'yyyy-mm-dd hh24:mi:ss')<to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') "
                    + " and to_char(a.finish_time, 'yyyy-mm-dd hh24:mi:ss')>to_char(sysdate -30,'yyyy-mm-dd hh24:mi:ss') ";
        }
        
       
        //String hql1 = "select *  " + hql.getHql() + queryUnderUnit +" order by  finish_time desc";
        //String hql2 = "select count(*)  " + hql.getHql() + queryUnderUnit +" order by  finish_time desc";
        
        StringBuffer sql_select = new StringBuffer();
        sql_select.append(" select a.no,a.org_id,a.internal_no,a.item_id,a.status,a.note,to_char(a.finish_time, 'yyyy-mm-dd hh24:mi:ss') as finish_time,");
        sql_select.append(" a.receivable,a.paid,a.relief_reasons,b.department,b.transact_affair_name,b.content,b.apply_way,b.applicant_code,b.applicant_type,");
        sql_select.append(" b.applicant_name,b.applicant_paper_type,b.applicant_paper_code,b.applicant_phone,b.applicant_mobile,b.applicant_address,b.applicant_zipcode,");
        sql_select.append(" b.applicant_email,to_char(b.apply_date, 'yyyy-mm-dd hh24:mi:ss') as apply_date,b.linkman,b.linkman_name,b.linkman_paper_type,");
        sql_select.append(" b.linkman_paper_code,b.linkman_phone,b.linkman_mobile,b.linkman_address,b.linkman_zipcode,b.linkman_email,c.sendway ");
        sql_select.append(" from m_applyresult a ");
        sql_select.append(" left join m_apply b on a.internal_no=b.internal_no");
        sql_select.append(" left join opt_relevancy_result c on a.internal_no=c.internalno");
        sql_select.append(" where a.finish_time is not null and b.internal_no is not null ");
        sql_select.append(" order by a.finish_time desc ");

        StringBuffer sql_select2 = new StringBuffer();
        sql_select2.append(" from m_applyresult a ");
        sql_select2.append(" left join m_apply b on a.internal_no=b.internal_no");
        sql_select2.append(" left join opt_relevancy_result c on a.internal_no=c.internalno");
        sql_select2.append(" where a.finish_time is not null and b.internal_no is not null ");
        
        StringBuffer hql1 = new StringBuffer();
        hql1.append("select *  from ( ");
        hql1.append(sql_select);
        hql1.append(" ) where 1=1 ");
        hql1.append(queryUnderUnit);
        
        StringBuffer hql2 = new StringBuffer();
        hql2.append("select count(1)  ");
        hql2.append(sql_select2);
        hql2.append(countQueryUnit);
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();

        List<OptApplyResult> l = null;
        try {
            l = findObjectsBySql(hql1.toString(), OptApplyResult.class
                    , startPos, maxSize);
           /* l = getHibernateTemplate().executeFind(
                    new SQLQueryCallBack(hql1, hql.getParams(), startPos,
                            maxSize, OptApplyResult.class));
                    pageDesc.setTotalRows(new Integer(getHibernateTemplate()
            .executeFind(new SQLQueryCallBack(hql2, hql.getParams()))
            .get(0).toString()));*/
                    
            long totalRows = getSingleIntBySql(hql2.toString());
            if(totalRows>=0){
                pageDesc.setTotalRows((int)totalRows);
            }else{
                pageDesc.setTotalRows(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        return l;
    } 
}

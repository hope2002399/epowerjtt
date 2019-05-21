package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptRelevancyResult;

public class OptRelevancyResultDao extends BaseDaoImpl<OptRelevancyResult>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(OptRelevancyResultDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("internalNo" , CodeBook.EQUAL_HQL_ID);

			filterField.put("sendway" , CodeBook.LIKE_HQL_ID);

			filterField.put("memo" , CodeBook.LIKE_HQL_ID);

			filterField.put("username" , CodeBook.LIKE_HQL_ID);

			filterField.put("updatedate" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	}

    public void saveResult(OptRelevancyResult relevancyResult) {
        String inssql="insert into OPT_RELEVANCY_RESULT (INTERNALNO, SENDWAY, MEMO, USERNAME, UPDATEDATE)"
                + "values ('" + relevancyResult.getInternalNo() + "','" + relevancyResult.getSendway() + "','"
                + relevancyResult.getMemo() + "','" + relevancyResult.getUsername() + "',sysdate)";
        super.doExecuteSql(inssql);
        
    }

    public void updateResult(OptRelevancyResult relevancyResult) {
        String inssql="UPDATE OPT_RELEVANCY_RESULT SET SENDWAY = '"+relevancyResult.getSendway()+"',MEMO = '"+relevancyResult.getMemo()+"' WHERE INTERNALNO = '"+relevancyResult.getInternalNo()+"'";
        super.doExecuteSql(inssql);
        
    } 
	
}

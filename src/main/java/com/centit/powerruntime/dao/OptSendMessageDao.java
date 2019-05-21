package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptSendMessage;

public class OptSendMessageDao extends BaseDaoImpl<OptSendMessage>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(OptSendMessageDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("sendid" , CodeBook.EQUAL_HQL_ID);


			filterField.put("sendname" , CodeBook.LIKE_HQL_ID);

			filterField.put("sendprov" , CodeBook.LIKE_HQL_ID);

			filterField.put("sendcity" , CodeBook.LIKE_HQL_ID);

			filterField.put("sendCountry" , CodeBook.LIKE_HQL_ID);

			filterField.put("sendstrect" , CodeBook.LIKE_HQL_ID);

			filterField.put("sendphone" , CodeBook.LIKE_HQL_ID);

			filterField.put("sendcall" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	}

    public String getSendMessageId() {
        String id =super.getNextKeyByHqlStrOfMax("sendid", "OptSendMessage", 16);
        return id;
    } 
}

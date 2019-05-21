package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptPickupMessage;

public class OptPickupMessageDao extends BaseDaoImpl<OptPickupMessage>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(OptPickupMessageDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("pickupid" , CodeBook.EQUAL_HQL_ID);


			filterField.put("rcvname" , CodeBook.LIKE_HQL_ID);

			filterField.put("rcvprov" , CodeBook.LIKE_HQL_ID);

			filterField.put("rcvcity" , CodeBook.LIKE_HQL_ID);

			filterField.put("rcvcountry" , CodeBook.LIKE_HQL_ID);

			filterField.put("rcvstrect" , CodeBook.LIKE_HQL_ID);

			filterField.put("rcvphone" , CodeBook.LIKE_HQL_ID);

			filterField.put("rcvcall" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("djid" , CodeBook.EQUAL_HQL_ID);

			filterField.put("rcvpostcode" , CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	}

    public String getPickupMessageId() {
        String id =super.getNextKeyByHqlStrOfMax("pickupid", "OptPickupMessage", 16);
        return id;
    } 
}

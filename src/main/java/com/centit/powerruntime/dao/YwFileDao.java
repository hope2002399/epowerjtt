package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.YwFile;

public class YwFileDao extends BaseDaoImpl<YwFile>
	{
		private static final long serialVersionUID = 1L;
		public static final Log log = LogFactory.getLog(YwFileDao.class);
		
	public Map<String, String> getFilterField() {
		if( filterField == null){
			filterField = new HashMap<String, String>();

			filterField.put("idywFile" , CodeBook.EQUAL_HQL_ID);


			filterField.put("deptYwId" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileType" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileName" , CodeBook.LIKE_HQL_ID);

			filterField.put("sourceFileName" , CodeBook.LIKE_HQL_ID);

			filterField.put("sourceFileUrl" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileRemark" , CodeBook.LIKE_HQL_ID);

			filterField.put("pageNum" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifEcPage" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileSource" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileSourceExplain" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileExplian" , CodeBook.LIKE_HQL_ID);

			filterField.put("fileLaw" , CodeBook.LIKE_HQL_ID);

			filterField.put("ifNeed" , CodeBook.LIKE_HQL_ID);

			filterField.put("ord" , CodeBook.LIKE_HQL_ID);

			filterField.put("createDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateType" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("syncErrorDesc" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateSign" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateDate" , CodeBook.LIKE_HQL_ID);

			filterField.put("updateErrorDesc" , CodeBook.LIKE_HQL_ID);
			
			filterField.put("update_type", "update_type <> ?");

		}
		return filterField;
	} 
}

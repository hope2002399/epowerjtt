package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.VRecordFileBasic;

public class VRecordFileBasicDao extends BaseDaoImpl<VRecordFileBasic> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(RecordFileBasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("recordCode", CodeBook.EQUAL_HQL_ID);
            filterField.put("operatorID", CodeBook.EQUAL_HQL_ID);

            filterField.put("beginDate",
                    "to_char(bookDate, 'yyyy-mm-dd') >= ? ");
            filterField.put("endDate", "to_char(bookDate, 'yyyy-mm-dd') <= ? ");
            filterField.put("constituteDepName", CodeBook.LIKE_HQL_ID);
            filterField.put("fileName", CodeBook.LIKE_HQL_ID);
            filterField.put("ownerDepID", CodeBook.LIKE_HQL_ID);
            filterField.put("depFileNo", CodeBook.LIKE_HQL_ID);
            filterField.put("allFIleNo", CodeBook.LIKE_HQL_ID);
            filterField.put("remark", CodeBook.LIKE_HQL_ID);
            filterField.put("finishDate",
                    "to_char(finishDate, 'yyyy-mm-dd') <= ? ");
            filterField.put("finishStatus", CodeBook.LIKE_HQL_ID);
            filterField.put("dealStep", CodeBook.EQUAL_HQL_ID);
            filterField.put("sortNo", CodeBook.LIKE_HQL_ID);
            filterField.put("discussname", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " bookDate desc");
        }
        return filterField;
    }

}

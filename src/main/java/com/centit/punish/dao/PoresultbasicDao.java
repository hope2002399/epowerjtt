package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poresultbasic;

public class PoresultbasicDao extends BaseDaoImpl<Poresultbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoresultbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("resulttype", CodeBook.LIKE_HQL_ID);

            filterField.put("poneatencontent", CodeBook.LIKE_HQL_ID);

            filterField.put("poarbitrationcontent", CodeBook.LIKE_HQL_ID);

            filterField.put("poquashreason", CodeBook.LIKE_HQL_ID);

            filterField.put("podeportationdepname", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}

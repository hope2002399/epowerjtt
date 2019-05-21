package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Powitnessbasic;

public class PowitnessbasicDao extends BaseDaoImpl<Powitnessbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PowitnessbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("powitnessdate", CodeBook.LIKE_HQL_ID);

            filterField.put("powitnesstype", CodeBook.LIKE_HQL_ID);

            filterField.put("powitnessadress", CodeBook.LIKE_HQL_ID);

            filterField.put("powitnessemceename", CodeBook.LIKE_HQL_ID);

            filterField.put("powitnessnotername", CodeBook.LIKE_HQL_ID);

            filterField.put("investigatename", CodeBook.LIKE_HQL_ID);

            filterField.put("investigatedepname", CodeBook.LIKE_HQL_ID);

            filterField.put("deputyname", CodeBook.LIKE_HQL_ID);

            filterField.put("deputybusiness", CodeBook.LIKE_HQL_ID);

            filterField.put("deputydepname", CodeBook.LIKE_HQL_ID);

            filterField.put("delegatename", CodeBook.LIKE_HQL_ID);

            filterField.put("powitnessmind", CodeBook.LIKE_HQL_ID);

            filterField.put("powitnessreason", CodeBook.LIKE_HQL_ID);

            filterField.put("witnessdate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}

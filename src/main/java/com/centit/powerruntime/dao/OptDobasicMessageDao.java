package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.Map;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.po.OptDobasicMessage;

public class OptDobasicMessageDao extends BaseDaoImpl<OptDobasicMessage> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptDobasicMessageDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("dobasicid", CodeBook.EQUAL_HQL_ID);
            filterField.put("internalno", CodeBook.LIKE_HQL_ID);
            filterField.put("zwfwzxCode", CodeBook.LIKE_HQL_ID);
            filterField.put("expressid", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    public String getDobasicMessageId() {
        String id = super.getNextKeyByHqlStrOfMax("dobasicid",
                "OptDobasicMessage", 16);
        return id;
    }
}

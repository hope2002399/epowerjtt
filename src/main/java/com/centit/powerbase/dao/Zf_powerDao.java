package com.centit.powerbase.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.powerbase.po.Zf_power;

@SuppressWarnings("serial")
public class Zf_powerDao extends BaseDaoImpl<Zf_power> {
    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("itemId", CodeBook.LIKE_HQL_ID);
            filterField.put("itemName", CodeBook.LIKE_HQL_ID);
            filterField.put("item_name", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<Zf_power> getlistZfpower() {
        List<Zf_power> list = new ArrayList<Zf_power>();
        StringBuffer sql = new StringBuffer();
        sql.append("select t.item_id as itemId,t.item_name as itemName "
                + "from zf_power t where 1=1 ");
        sql.append("  order by t.item_id ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        sqlQuery.addScalar("itemId", StringType.INSTANCE);
        sqlQuery.addScalar("itemName", StringType.INSTANCE);
        list = (List<Zf_power>) sqlQuery.setResultTransformer(
                Transformers.aliasToBean(Zf_power.class)).list();
        return list;
    }

}

package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Pcdef;
import com.centit.punish.po.Poindagaterepbasic;

public class PoindagaterepbasicDao extends BaseDaoImpl<Poindagaterepbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory
            .getLog(PoindagaterepbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("confirmtruth", CodeBook.LIKE_HQL_ID);

            filterField.put("unconfirmtruth", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagatereppassage", CodeBook.LIKE_HQL_ID);

            filterField.put("disobeyitem", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepresult", CodeBook.LIKE_HQL_ID);

            filterField.put("isdiscuss", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepreportdoc", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepreportdocname", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepstate", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepstep", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<Pcdef> getPcdefChooseList(String punishobjectid,
            String s_punishclasscode, String s_punishclassname,
            String primaryunit) {
        StringBuffer sql = new StringBuffer();
        sql.append("select pcdef.* from p_pcdef pcdef left join power_org_info on pcdef.punishclasscode=power_org_info.item_id where 1=1 and  punishclassid not in (select distinct punishclassid from potranslawbasic where 1=1");
        if (!StringUtils.isBlank(punishobjectid)) {
            sql.append(" and punishobjectid='" + punishobjectid + "' ");
        }
        sql.append(" )");
        if (!StringUtils.isBlank(s_punishclasscode)) {
            sql.append(" and punishclasscode like  '%" + s_punishclasscode
                    + "%' ");
        }
        if (!StringUtils.isBlank(s_punishclassname)) {
            sql.append(" and punishclassname like '%" + s_punishclassname
                    + "%' ");
        }
        if (!StringUtils.isBlank(primaryunit)) {
            sql.append(" and power_org_info.unitcode=" + primaryunit);
        }

        return (List<Pcdef>) this.findObjectsBySql(sql.toString(), null,
                Pcdef.class);
    }

}

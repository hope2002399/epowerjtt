package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.punish.po.Pofinishbasic;
import com.centit.punish.po.Punishobjectbasic;

public class PofinishbasicDao extends BaseDaoImpl<Pofinishbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PofinishbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("disobeyitem", CodeBook.LIKE_HQL_ID);

            filterField.put("confirmtruth", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussresult", CodeBook.LIKE_HQL_ID);

            filterField.put("punishamout", CodeBook.LIKE_HQL_ID);

            filterField.put("otherpunish", CodeBook.LIKE_HQL_ID);

            filterField.put("punishamoutpeople", CodeBook.LIKE_HQL_ID);

            filterField.put("punishseizure", CodeBook.LIKE_HQL_ID);

            filterField.put("punishseizurevalue", CodeBook.LIKE_HQL_ID);

            filterField.put("punishshoutont", CodeBook.LIKE_HQL_ID);

            filterField.put("punishdetentionpeople", CodeBook.LIKE_HQL_ID);

            filterField.put("punishdetention", CodeBook.LIKE_HQL_ID);

            filterField.put("isfinish", CodeBook.LIKE_HQL_ID);

            filterField.put("punishaffixname", CodeBook.LIKE_HQL_ID);

            filterField.put("punishaffixdoc", CodeBook.LIKE_HQL_ID);

            filterField.put("punishaffixcode", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public double getPunishReultByExtraCode(Punishobjectbasic bean,
            String punishobjectid, String punishType) {
        long punishclassnum = bean.getPunishclassnum();

        double punishvalue = 0;
        String sSqlsen = "select POPunishBasic.punishValue,POPunishBasic.Punishobjectid from p_punish_basic POPunishBasic left join f_datadictionary on POPunishBasic.punishtypeid=f_datadictionary.datacode where 1=1 and f_datadictionary.catalogcode = 'CFZL' ";

        if (punishclassnum > 1) {
            sSqlsen += " and POPunishBasic.item_id='" + bean.getItem_id()
                    + "' ";
        }
        if (StringUtils.isNotBlank(punishobjectid)) {
            sSqlsen += "and POPunishBasic.punishObjectID="
                    + HQLUtils.buildHqlStringForSQL(punishobjectid);
        }
        if (StringUtils.isNotBlank(punishType)) {
            sSqlsen += " and f_datadictionary.datacode="
                    + HQLUtils.buildHqlStringForSQL(punishType);
        }
        List<Object[]> l = findObjectsBySql(sSqlsen);
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = l.get(i);
                String punishValue = O[0].toString();
                if (StringUtils.isNotBlank(punishValue)
                        && !"-".equals(punishValue)) {
                    punishvalue = Double.parseDouble(punishValue);
                } else {
                    punishvalue = 0.00;
                }
            }
        }
        return punishvalue;
    }
}

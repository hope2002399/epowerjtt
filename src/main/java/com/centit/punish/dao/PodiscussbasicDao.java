package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Podiscussbasic;
import com.centit.punish.po.PodiscussbasicId;

public class PodiscussbasicDao extends BaseDaoImpl<Podiscussbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PodiscussbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("podiscusstype", CodeBook.EQUAL_HQL_ID);

            filterField.put("podiscussbegintime", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussendtime", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussemcee", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussnoter", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussattendname", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussattendeename", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussaffixname", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussrecored", CodeBook.LIKE_HQL_ID);

            filterField.put("disobeyitem", CodeBook.LIKE_HQL_ID);

            filterField.put("confirmtruth", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussadress", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussresult", CodeBook.LIKE_HQL_ID);

            filterField.put("enregisterdate", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussstep", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String getPunishClassID(String punishobjectid) {
        String item_id = "";
        StringBuffer sb = new StringBuffer();
        sb.append(" select DISTINCT  item_id,'scar' from p_punish_basic where punishObjectID='"
                + punishobjectid + "' and item_id<>'00000000'");
        List<Object[]> l = findObjectsBySql(sb.toString());
        if (l != null && l.size() > 0) {
            Object[] O = (Object[]) l.get(0);
            item_id = (String) O[0];
        } else {
            item_id = "00000000";
        }
        return item_id;
    }

    public String getDegreeNoByCon(String punishObjectID, String item_id) {
        String degreeNo = "";
        StringBuffer sb = new StringBuffer();
        sb.append(" select degreeNo,'scar' from p_trans_law_basic where punishObjectID='"
                + punishObjectID + "' and item_id='" + item_id + "'");

        List<Object[]> l = findObjectsBySql(sb.toString());
        if (l != null && l.size() > 0) {
            Object[] O = (Object[]) l.get(0);
            degreeNo = O[0].toString();
        } else {
            degreeNo = "";
        }
        return degreeNo;
    }

    public Podiscussbasic getPodiscussresult(String punishObjectID) {
        PodiscussbasicId cid = new PodiscussbasicId();
        String HQL = "from Podiscussbasic where cid.punishobjectid=? ";
        List<Podiscussbasic> po = this.listObjects(HQL, punishObjectID);
        if (po == null || po.size() < 1) {
            return null;
        } else {
            return po.get(0);
        }
    }
}

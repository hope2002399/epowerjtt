package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.PotranslawbasicId;

public class PotranslawbasicDao extends BaseDaoImpl<Potranslawbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PotranslawbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishclassid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("degreeno", CodeBook.LIKE_HQL_ID);

            filterField.put("issurpass", CodeBook.LIKE_HQL_ID);

            filterField.put("translawdate", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    // public String factPunishisSurpass(String punishObjectID) {
    // String flag = "0";
    // StringBuffer sb = new StringBuffer();
    // sb
    // .append(" select count(punishObjectID) as punishObject from POTransLawBasic where isSurpass=1 and punishObjectID='"
    // + punishObjectID + "'");
    // try {
    // super.executeSql(sb.toString(), null);
    // if (rs.next() && rs.getInt("punishObject") > 0) {
    // flag = "1";
    // }
    // } catch (SQLException ex) {
    // ex.printStackTrace(System.err);
    // } finally {
    // super.closeConnection();
    // }
    // return flag;
    // }
    @SuppressWarnings("unchecked")
    public String factPunishisSurpass(String punishobjectID) {
        String flag = "0";
        StringBuffer sql = new StringBuffer();
        sql.append("select count(punishobjectID) as punishObject,'scar' from p_trans_law_basic where isSurpass=1 and punishObjectID='"
                + punishobjectID + "'");
        List<Object[]> l = findObjectsBySql(sql.toString());
        Object[] count = (Object[]) l.get(0);
        int num = Integer.parseInt(count[0].toString());
        if (num > 0) {
            flag = "1";
        }
        return flag;
    }

    public void updatePOTransLawBasic(String punishObjectID, String item_id,
            String degreeNo) {
        PotranslawbasicId cid = new PotranslawbasicId(item_id, punishObjectID);
        Potranslawbasic saveobj = this.getObjectById(cid);
        saveobj.setIssurpass(Long.parseLong("0"));
        saveobj.setDegreeno(Long.parseLong(degreeNo));
        this.saveObject(saveobj);

    }

    @SuppressWarnings("unchecked")
    public List<Potranslawbasic> getPotranslawbasicsbyId(String punishobjectid) {
        String hql = "FROM Potranslawbasic  where punishobjectid = ?";
        return getHibernateTemplate().find(hql, punishobjectid);
    }

    public Potranslawbasic getItem_idBypunishobjectid(String punishobjectid) {
        List<Potranslawbasic> optBaseList = this.listObjects(
                "from Potranslawbasic where cid.punishobjectid = ?",
                punishobjectid);
        if (optBaseList == null || optBaseList.size() == 0) {
            return null;
        }
        return optBaseList.get(0);
    }

}

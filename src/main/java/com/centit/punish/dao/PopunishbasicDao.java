package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Popunishbasic;

public class PopunishbasicDao extends BaseDaoImpl<Popunishbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PopunishbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishtypeid", CodeBook.EQUAL_HQL_ID);

            filterField.put("item_id", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishvalue", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public boolean isHavingPunishBasic(String punishObjectID, String item_id) {
        StringBuffer sql = new StringBuffer();
        boolean flag = false;
        sql.append(" select count(punishObjectID) as count,'scar' from p_punish_basic where punishObjectID='"
                + punishObjectID + "'");
        if (!StringUtils.isBlank(item_id)) {
            sql.append(" and item_id='" + item_id + "'");
        }
        List<Object[]> l = this.findObjectsBySql(sql.toString());
        Object[] count = l.get(0);
        int num = Integer.parseInt(count[0].toString());
        if (num > 0) {
            flag = true;
        }
        return flag;
    }

    public void deleteAllPunishBasic(String punishObjectID, String item_id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" delete from p_punish_basic where punishObjectID='"
                + punishObjectID + "'");
        if (!StringUtils.isBlank(item_id)) {
            sql.append(" and item_id='" + item_id + "'");
        }
        this.doExecuteSql(sql.toString());
    }

    public Popunishbasic getObjectByPunishobjectid(String punishobjectid) {
        String hql = "from Popunishbasic where  cid.item_id<>'00000000' and cid.punishobjectid=? ";

        List<Popunishbasic> optBaseList = this.listObjects(hql, punishobjectid);
        if (optBaseList == null || optBaseList.size() == 0) {
            return null;
        }
        return optBaseList.get(0);
    }

    public List<Popunishbasic> getPopunishbasicList(String punishobjectid,
            String item_id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select * from p_punish_basic where 1=1 ");
        if (!StringUtils.isBlank(punishobjectid)) {
            sql.append(" and punishobjectid='" + punishobjectid + "'");
        }
        if (!StringUtils.isBlank(item_id)) {
            sql.append(" and item_id='" + item_id + "'");
        }
        @SuppressWarnings("unchecked")
        List<Popunishbasic> retlist = (List<Popunishbasic>) this
                .findObjectsBySql(sql.toString(), Popunishbasic.class);
        return retlist;
    }

    public Popunishbasic getPunishBasic(String punishobjectid, String itemId) {
        String hql = "from Popunishbasic where  cid.punishobjectid=? and cid.item_id=? ";

        List<Popunishbasic> optBaseList = this.listObjects(hql, new String[] {
                punishobjectid, itemId });
        if (optBaseList == null || optBaseList.size() == 0) {
            return null;
        }
        return optBaseList.get(0);
    }

}

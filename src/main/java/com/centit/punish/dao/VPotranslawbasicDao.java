package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.VPotranslawbasic;

public class VPotranslawbasicDao extends BaseDaoImpl<VPotranslawbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VPotranslawbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("item_id", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("degreeno", CodeBook.LIKE_HQL_ID);

            filterField.put("issurpass", CodeBook.LIKE_HQL_ID);

            filterField.put("translawdate", CodeBook.LIKE_HQL_ID);

            filterField.put("punishClassCode", CodeBook.LIKE_HQL_ID);

            filterField.put("depID", CodeBook.LIKE_HQL_ID);

            filterField.put("punishBasis", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String getAllpunishClassID(String punishobjectid) {
        String item_id = "";
        List<VPotranslawbasic> list = this.listObjects(
                "from VPotranslawbasic where cid.punishobjectid = ?",
                punishobjectid);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                VPotranslawbasic O = (VPotranslawbasic) list.get(i);
                String itemid = O.getItem_id();
                if (i == 0) {
                    item_id = itemid;
                } else {
                    item_id = item_id + "," + itemid;
                }
            }
        }
        return item_id;
    }

}

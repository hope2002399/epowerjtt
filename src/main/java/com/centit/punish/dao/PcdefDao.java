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
import com.centit.punish.po.Pcdef;

public class PcdefDao extends BaseDaoImpl<Pcdef> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PcdefDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishclassid", CodeBook.LIKE_HQL_ID);

            filterField.put("punishclassname", CodeBook.LIKE_HQL_ID);

            filterField.put("depid", CodeBook.LIKE_HQL_ID);

            filterField.put("punishclasscode", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobject", CodeBook.LIKE_HQL_ID);

            filterField.put("isinuse", CodeBook.LIKE_HQL_ID);

            filterField.put("punishbasiscontent", CodeBook.LIKE_HQL_ID);

            filterField.put("punishbasis", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);
            filterField.put("belonganyou", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    /**
     * 处罚项目类别流水号PunishClassID
     * 
     * @return
     */

    public String genNextPunishClassID() {
        return getNextKeyBySequence("S_PCDEF", 8);

    }

    public Pcdef getObjectByItemId(String punishclasscode) {
        List<Pcdef> procs = this
                .listObjects("From Pcdef where punishclasscode =  "
                        + HQLUtils.buildHqlStringForSQL(punishclasscode));
        if (procs == null || procs.size() < 1)
            return null;
        return procs.get(0);
    }

    public List<Pcdef> listPcdefUsingOrg(String unitcode, String anyou) {
        String sql = "select pcdef.* from p_pcdef pcdef  left join power_org_info on pcdef.punishclasscode=power_org_info.item_id where 1=1 and power_org_info.unitcode="
                + unitcode;
        if (StringUtils.isNotBlank(anyou)) {
            sql += " and pcdef.belonganyou=" + anyou;
        }
        @SuppressWarnings("unchecked")
        List<Pcdef> l = (List<Pcdef>) this.findObjectsBySql(sql, Pcdef.class);
        return l;
    }
}

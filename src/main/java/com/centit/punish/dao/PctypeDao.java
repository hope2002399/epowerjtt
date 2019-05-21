package com.centit.punish.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.punish.po.Pctype;

public class PctypeDao extends BaseDaoImpl<Pctype> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PctypeDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("punishclassid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishtypeid", CodeBook.EQUAL_HQL_ID);

            filterField.put("isinuse", CodeBook.LIKE_HQL_ID);

            filterField.put("punishmax", CodeBook.LIKE_HQL_ID);

            filterField.put("punishmin", CodeBook.LIKE_HQL_ID);

            filterField.put("israte", CodeBook.LIKE_HQL_ID);

            filterField.put("chargemax", CodeBook.LIKE_HQL_ID);

            filterField.put("radixname", CodeBook.LIKE_HQL_ID);

            filterField.put("radixunit", CodeBook.LIKE_HQL_ID);

            filterField.put("punishcontent", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public Pctype getObjectByClassId(String punishclassid) {
        List<Pctype> procs = this
                .listObjects("From Pctype where punishclassid =  "
                        + HQLUtils.buildHqlStringForSQL(punishclassid));
        if (procs == null || procs.size() < 1)
            return null;
        return procs.get(0);
    }

    public Pctype getObjectByItemsId(String punishclassid, String punishtypeid) {
        List<Pctype> procs = this
                .listObjects("From Pctype where punishclassid =  "
                        + HQLUtils.buildHqlStringForSQL(punishclassid)
                        + " and punishtypeid="
                        + HQLUtils.buildHqlStringForSQL(punishtypeid));
        if (procs == null || procs.size() < 1)
            return null;
        return procs.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Pctype> listPcType(String punishclassid) {
        String baseHQL = "from Pctype where punishclassid = ? order by punishtypeid desc";
        return (List<Pctype>) findObjectsByHql(baseHQL, punishclassid);
    }

    @SuppressWarnings("unchecked")
    public List<Pctype> listPcTypeInUse(String punishclassid) {
        String baseHQL = "from Pctype where punishclassid = ? and isinuse='1' order by punishtypeid desc";
        List<Pctype> retlist = (List<Pctype>) findObjectsByHql(baseHQL,
                punishclassid);
        for (Pctype o : retlist) {
            if (StringUtils.isBlank(o.getPunishmin())) {
                o.setPunishmin("-");
            }
            if (StringUtils.isBlank(o.getPunishmax())) {
                o.setPunishmax("-");
            }
        }
        return retlist;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Map> listPunishType(String punishclassid, String degreeno) {
        List<Map> list = new ArrayList<Map>();
        String sSqlsen = "select f.datacode as id,f.datavalue as value from F_DATADICTIONARY f "
                + "where  f.datacode not in (select punishtypeid from pcfreeumpiretype where pcfreeumpiretype.punishclassid="
                + HQLUtils.buildHqlStringForSQL(punishclassid)
                + "and pcfreeumpiretype.degreeno="
                + HQLUtils.buildHqlStringForSQL(degreeno)
                + ")"
                + "and f.catalogcode='punishType' and f.datacode in (select punishtypeid from pctype where punishclassid="
                + HQLUtils.buildHqlStringForSQL(punishclassid) + ")";

        List<Object[]> l = findObjectsBySql(sSqlsen);
        ;
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                Map po = new HashMap();
                po.put("id", O[0]);
                po.put("value", O[1]);
                list.add(po);
            }
        }
        return list;
    }

}

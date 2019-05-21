package com.centit.powerbase.dao;

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
import com.centit.powerbase.po.Pcfreeumpiretype;

public class PcfreeumpiretypeDao extends BaseDaoImpl<Pcfreeumpiretype> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PcfreeumpiretypeDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("degreeno", CodeBook.EQUAL_HQL_ID);
            filterField.put("punishtypeid", CodeBook.EQUAL_HQL_ID);
            filterField.put("standardNo", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

    public List<Pcfreeumpiretype> listFreeumpiretype(Long degreeno,
            String isInUse) {
        String baseHQL = "From Pcfreeumpiretype where  1=1 ";
        if (degreeno != null && degreeno != 0) {
            baseHQL += " and  degreeno="
                    + HQLUtils.buildHqlStringForSQL(String.valueOf(degreeno));
        }
        if (StringUtils.isNotBlank(isInUse)) {
            baseHQL += " and  isInUse="
                    + HQLUtils.buildHqlStringForSQL(isInUse);
        }
        baseHQL += "  order by degreeno desc";
        return this.listObjects(baseHQL);
    }

    @SuppressWarnings("unchecked")
    public List<Pcfreeumpiretype> getPCFreeUmpireTypeListByClassID(
            String itemId, Long version, String punishtypeid) {

        List<Pcfreeumpiretype> list = new ArrayList<Pcfreeumpiretype>();
        String baseHQL = "select t.punishtypeid,t.degreeno,t.standard_no,t.isinuse,d.punishfactgrade  from B_freeumpiretype t left join B_freeumpiredegree d on  t.degreeno=d.degreeno"
                + "  where  d.item_Id ="
                + HQLUtils.buildHqlStringForSQL(itemId)
                + " and d.version="
                + HQLUtils.buildHqlStringForSQL(Long.toString(version))
                + " and t.punishtypeid="
                + HQLUtils.buildHqlStringForSQL(punishtypeid);
        List<Object[]> l = findObjectsBySql(baseHQL);
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                Pcfreeumpiretype po = new Pcfreeumpiretype();

                po.setPunishtypeid((String) O[0]);
                po.setDegreeno(Long.parseLong(String.valueOf(O[1])));
                po.setStandardNo((String) O[2]);
                po.setIsinuse(Long.parseLong(String.valueOf(O[3])));
                po.setPunishfactgrade((String) O[4]);
                list.add(po);
            }
        }
        return list;
    }

    public void updatepcfreeumpiretype(Long degreeno, String punishtypeid,
            long isinuse) {
        doExecuteHql(
                "update Pcfreeumpiredegree set isinuse=? where cid.degreeno =?  and cid.punishtypeid=? ",
                new Object[] { isinuse, degreeno, punishtypeid });
    }

    @SuppressWarnings("unchecked")
    public List<Pcfreeumpiretype> getPCFreeUmpireTypeDegreeList(
            String punishclassid, String degreeno) {

        List<Pcfreeumpiretype> list = new ArrayList<Pcfreeumpiretype>();
        String baseHQL = "select t.punishclassid,t.punishtypeid,t.degreeno,t.standard_no,t.isinuse,d.punishfactgrade  from Pcfreeumpiretype t left join pcfreeumpiredegree d on t.punishclassid=d.punishclassid and t.degreeno=d.degreeno"
                + "  where  t.punishclassid ="
                + HQLUtils.buildHqlStringForSQL(punishclassid)
                + " and t.degreeno=" + HQLUtils.buildHqlStringForSQL(degreeno);
        List<Object[]> l = findObjectsBySql(baseHQL);
        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                Pcfreeumpiretype po = new Pcfreeumpiretype();
                // po.setPunishclassid((String) O[0]);
                po.setPunishtypeid((String) O[1]);
                po.setDegreeno(Long.parseLong(String.valueOf(O[2])));
                po.setStandardNo((String) O[3]);
                po.setIsinuse(Long.parseLong(String.valueOf(O[4])));
                po.setPunishfactgrade((String) O[5]);
                list.add(po);
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Pcfreeumpiretype> getPCFreeUmpireTypeListByPunishClassId(
            String item_id) {
        List<Pcfreeumpiretype> list = new ArrayList<Pcfreeumpiretype>();
        String baseHQL = "select t.punishclassid,t.punishtypeid,t.degreeno,t.standard_no,t.isinuse,d.punishfactgrade  from Pcfreeumpiretype t left join pcfreeumpiredegree d on t.punishclassid=d.punishclassid and t.degreeno=d.degreeno"
                + "  where 1=1 and t.isinuse='1' and  t.punishclassid ="
                + HQLUtils.buildHqlStringForSQL(item_id);
        List<Object[]> l = findObjectsBySql(baseHQL);

        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                Pcfreeumpiretype po = new Pcfreeumpiretype();
                // po.setPunishclassid((String) O[0]);
                po.setPunishtypeid((String) O[1]);
                po.setDegreeno(Long.parseLong(String.valueOf(O[2])));
                po.setStandardNo((String) O[3]);
                po.setIsinuse(Long.parseLong(String.valueOf(O[4])));
                po.setPunishfactgrade((String) O[5]);
                list.add(po);
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public boolean ifHavePCFreeUmpireTypeRate(String punishtypeid,
            String degreeno) {
        boolean flag = false;
        StringBuffer sql = new StringBuffer();
        sql.append("select israte,'scar' from B_free_umpire_type where 1=1 ");
        // if (!StringUtils.isBlank(itemId)) {
        // sql.append(" and pcfreeumpiretype.punishClassID='" + itemId
        // + "'");
        // }
        if (!StringUtils.isBlank(degreeno)) {
            sql.append(" and B_freeumpiretype.degreeNo='" + degreeno + "'");
        }
        if (!StringUtils.isBlank(punishtypeid)) {
            sql.append(" and punishtypeid='" + punishtypeid + "'");
        }
        List<Object[]> l = findObjectsBySql(sql.toString());
        for (Object[] o : l) {
            if (null != o[0]) {
                String israte = String.valueOf(o[0]);
                if ("1".equals(israte)) {
                    flag = true;
                    break;
                }
            } else {
                continue;
            }
        }
        return flag;
    }

    @SuppressWarnings("unchecked")
    public List<Pcfreeumpiretype> getPCFreeUmpireTypeListBySqlCon(
            String punishClassID, String degreeNo, String isinuse) {
        StringBuffer sqlcon = new StringBuffer();
        if (!StringUtils.isBlank(punishClassID)) {
            sqlcon.append(" and PCFreeUmpireType.punishClassID="
                    + punishClassID);
        }
        if (!StringUtils.isBlank(degreeNo)) {
            sqlcon.append(" and PCFreeUmpireType.degreeNo=" + degreeNo);
        }
        if (!StringUtils.isBlank(isinuse)) {
            sqlcon.append(" and PCFreeUmpireType.isinuse=" + isinuse);
        }

        StringBuffer sql = new StringBuffer();
        List<Pcfreeumpiretype> list = new ArrayList<Pcfreeumpiretype>();
        sql.append("select Pcfreeumpiretype.punishclassid,Pcfreeumpiretype.punishtypeid,Pcfreeumpiretype.degreeno,Pcfreeumpiretype.standard_no,Pcfreeumpiretype.isinuse,pcfreeumpiredegree.punishfactgrade,Pcfreeumpiretype.punishmin,Pcfreeumpiretype.punishmax,Pcfreeumpiretype.israte  from Pcfreeumpiretype  left join pcfreeumpiredegree on Pcfreeumpiretype.punishclassid=pcfreeumpiredegree.punishclassid and Pcfreeumpiretype.degreeno=pcfreeumpiredegree.degreeno"
                + "  where 1=1 ");
        if (!StringUtils.isBlank(sqlcon.toString())) {
            sql.append(sqlcon);
        }
        List<Object[]> l = findObjectsBySql(sql.toString());

        if (l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                Pcfreeumpiretype po = new Pcfreeumpiretype();
                // po.setPunishclassid((String) O[0]);
                po.setPunishtypeid((String) O[1]);
                po.setDegreeno(Long.parseLong(String.valueOf(O[2])));
                po.setStandardNo((String) O[3]);
                po.setIsinuse(Long.parseLong(String.valueOf(O[4])));
                po.setPunishfactgrade((String) O[5]);
                // po.setPunishmin((String) O[6]);
                // po.setPunishmax((String) O[7]);
                if (O[8] != null) {
                    // po.setIsrate((Long.parseLong(String.valueOf(O[8]))));
                } else {
                    // po.setIsrate(null);
                }

                list.add(po);
            }
        }
        return list;
    }

    /**
     * 根据自由裁量标准－违法事实程度的权力编码和版本获取自由裁量处罚项目种类
     * 
     * @param item_id
     * @param version
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Pcfreeumpiretype> getPcfreeumpiretypeByItemIdandversion(
            String item_id, Long version, String degreeNo) {

        StringBuffer sql = new StringBuffer();
        List<Pcfreeumpiretype> list = new ArrayList<Pcfreeumpiretype>();
        sql.append("select degreeno,punishtypeid,isinuse,standard_no,punishtype,toplimit,"
                + "toplimit_unit,lowlimit,lowlimit_unit,base_name,base_toplimit,base_lowlimit,base_unit,remark  "
                + " from B_FREEUMPIRETYPE  where 1=1 and degreeno in (select degreeno from b_freeumpiredegree "
                + "where item_Id = "
                + HQLUtils.buildHqlStringForSQL(item_id)
                + "  and version =" + version + ")  ");
        if (StringUtils.isNotBlank(degreeNo)) {
            sql.append(" and degreeNo=" + degreeNo);
        }
        sql.append(" order by degreeno desc ");
        List<Object[]> l = findObjectsBySql(sql.toString());

        if (l != null && l.size() > 0) {
            for (int i = 0; i < l.size(); i++) {
                Object[] O = (Object[]) l.get(i);
                Pcfreeumpiretype po = new Pcfreeumpiretype();
                po.setDegreeno(Long.parseLong(String.valueOf(O[0])));
                po.setPunishtypeid((String) O[1]);
                po.setIsinuse(Long.parseLong(String.valueOf(O[2])));
                po.setStandardNo((String) O[3]);
                String Punishtype = String.valueOf(O[4]);
                po.setPunishtype(Long.parseLong(StringUtils.isBlank(Punishtype)
                        || "null".equals(Punishtype) ? "0" : Punishtype));
                po.setToplimit((String) O[5]);
                po.setToplimitUnit((String) O[6]);
                po.setLowlimit((String) O[7]);
                po.setLowlimitUnit((String) O[8]);
                po.setBaseName((String) O[9]);
                po.setBaseToplimit((String) O[10]);
                po.setBaseUnit((String) O[11]);
                po.setRemark((String) O[12]);
                list.add(po);
            }
        }
        return list;
    }

    public Pcfreeumpiretype getPunishTypeid(Long degreeno) {
        String HQL = "From Pcfreeumpiretype where  1=1  and degreeno=?";
        List<Pcfreeumpiretype> pc = this.listObjects(HQL, degreeno);
        if (pc == null || pc.size() < 1) {
            return null;
        } else {
            return pc.get(0);
        }

    }
}

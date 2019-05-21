package com.centit.punish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.Poradixbasic;
import com.centit.support.utils.StringBaseOpt;

public class PoradixbasicDao extends BaseDaoImpl<Poradixbasic> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PoradixbasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("radixid", CodeBook.EQUAL_HQL_ID);
            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishtypeid", CodeBook.LIKE_HQL_ID);

            filterField.put("item_id", CodeBook.EQUAL_HQL_ID);

            filterField.put("radix", CodeBook.LIKE_HQL_ID);

            filterField.put("multiple", CodeBook.LIKE_HQL_ID);

            filterField.put("degreeno", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public String generateNextPoRadixId() {
        return getNextKeyBySequence("S_RADIXID", 10);
    }

    @SuppressWarnings("unchecked")
    public String getRadixprama(String sqlCondition, String tableName) {
        String retString = "";
        StringBuffer sql = new StringBuffer();
        sql.append("select RadixName,RadixUnit from ");
        sql.append(tableName);
        sql.append(" where 1=1");
        if (!StringBaseOpt.isNvl(sqlCondition)) {
            sql.append(sqlCondition);
        }
        List<Object[]> l = findObjectsBySql(sql.toString());
        if (l != null && l.size() > 0) {
            Object[] O = (Object[]) l.get(0);
            String radixname = (String) O[0];
            String radixunit = (String) O[1];
            retString = radixname + "," + radixunit;
        }
        return retString;
    }

    public void initRadioBasic(String punishObjectID, String item_id) {
        String sql = " select count(degreeNo) from b_freeumpiredegree where item_id='"
                + item_id + "' and isInUse=1";
        long degreenum = getSingleIntBySql(sql);
        String inssql = "";
        if (degreenum > 0) {
            inssql = "insert into p_radix_basic(RadixID,PunishObjectID,item_id,punishTypeID,DEGREENO)( "
                    + "select  S_RADIXID.nextval, '"
                    + punishObjectID
                    + "','"
                    + item_id
                    + "',punishTypeID,DEGREENO "
                    + "from b_FreeUmpireType "
                    + "where degreeNo='"
                    + item_id
                    + "' and version = (select max(b.version) as version from b_freeumpiredegree b where b.item_id = b_freeumpiredegree.item_id)) ";
        } else {
            inssql = "insert into p_radix_basic(RADIXID,PunishObjectID,punishClassID,punishTypeID,DEGREENO)( "
                    + " select  S_RADIXID.nextval,'"
                    + punishObjectID
                    + "','"
                    + item_id
                    + "',punishTypeID,0 from b_punishstandard where item_id='"
                    + item_id
                    + "' and version = (select max(b.version) as version from b_freeumpiredegree b where b.item_id = b_punishstandard.item_id)) ";
        }
        super.doExecuteSql(inssql);
    }

    public boolean ifHavePoRadix(String punishObjectID, String item_id,
            String punishTypeID) {
        Map<String, Object> filtermap = new HashMap<String, Object>();
        filtermap.put("punishobjectid", punishObjectID);
        filtermap.put("item_id", item_id);
        filtermap.put("punishtypeid", punishTypeID);
        List<Poradixbasic> radixlist = this.listObjects(filtermap);
        int size = radixlist.size();
        if (size == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<Poradixbasic> getRadixByCon(String sqlcon) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select radixid,punishobjectid,punishtypeid,item_id,radix,multiple,degreeno,'' as radixname,'' as radixunit from p_radix_basic where 1=1 ");
        if (!StringUtils.isBlank(sqlcon)) {
            sql.append(sqlcon);
        }
        @SuppressWarnings("unchecked")
        List<Poradixbasic> retlist = (List<Poradixbasic>) this
                .findObjectsBySql(sql.toString(), Poradixbasic.class);
        return retlist;
    }

    public Poradixbasic getRadixBasic(String punishobjectid,
            String punishtypeid, String item_id) {
        Poradixbasic retobj = new Poradixbasic();
        StringBuffer sql = new StringBuffer();
        if (!StringUtils.isBlank(punishobjectid)) {
            sql.append(" and punishObjectID='" + punishobjectid + "'");
        }
        if (!StringUtils.isBlank(punishtypeid)) {
            sql.append(" and punishTypeID='" + punishtypeid + "'");
        }
        if (!StringUtils.isBlank(item_id)) {
            sql.append(" and item_id='" + item_id + "'");
        }
        sql.append(" and (degreeNo>0 or degreeNo=0)");
        List<Poradixbasic> radixlist = this.getRadixByCon(sql.toString());
        if (radixlist.size() > 0) {
            retobj = (Poradixbasic) radixlist.get(0);
            String tmp = "";
            tmp = this.getRadixprama(item_id, punishtypeid, retobj
                    .getDegreeno().toString());// /????一会换到
            if (StringUtils.isBlank(tmp)) {
                retobj.setRadixName("");
                retobj.setRadixUnit("");
            } else {
                retobj.setRadixName(tmp.split(",")[0]);
                retobj.setRadixUnit(tmp.split(",")[1]);
            }
        }
        return retobj;
    }

    public String getRadixprama(String item_id, String punishtypeid,
            String degreeno) {
        String tableName = "";
        StringBuffer sql = new StringBuffer();
        if (!StringUtils.isBlank(punishtypeid)) {
            sql.append(" and punishTypeID='" + punishtypeid + "'");
        }
        if (!StringUtils.isBlank(item_id)) {
            sql.append(" and item_id='" + item_id + "'");
        }
        if (!"0".equals(degreeno)) {
            sql.append(" and degreeNo=" + degreeno + "");
            tableName = "b_freeumpiretype";
        } else {
            tableName = "b_punishstandard";
        }
        return this.getRadixprama(sql.toString(), tableName);
    }

    /**
     * 此方法许舍弃 获取字典项
     * 
     * @param catalogcode
     * @param extracode
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getDataCodeFromFdic(String catalogcode, String extracode) {
        String sql = "select datacode,'scar' from f_datadictionary where catalogcode='"
                + catalogcode + "' and extracode='" + extracode + "'";
        List<Object[]> l = findObjectsBySql(sql);
        String datacode = "";
        if (l != null && l.size() > 0) {
            Object[] O = (Object[]) l.get(0);
            datacode = (String) O[0];
        }
        return datacode;
    }

    @SuppressWarnings("unchecked")
    public String getDatavalueFromFdic(String catalogcode, String datacode) {
        String sql = "select datavalue,'scar' from f_datadictionary where catalogcode='"
                + catalogcode + "' and datacode='" + datacode + "'";
        List<Object[]> l = findObjectsBySql(sql);
        Object[] O = (Object[]) l.get(0);
        String datavalue = (String) O[0];
        return datavalue;
    }

    public boolean deleteObjectBypunishObjectID(String punishobjectid) {
        boolean flag = true;
        try {
            this.doExecuteHql(
                    "DELETE FROM Poradixbasic where punishobjectid =? ",
                    punishobjectid);

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public void delRadixBasic(String punishobjectid, String item_id,
            String punishtypeid) {
        StringBuffer sql = new StringBuffer();
        sql.append(" delete from p_radix_basic where punishObjectID='"
                + punishobjectid + "'");
        if (!StringUtils.isBlank(item_id)) {
            sql.append(" and item_id='" + item_id + "'");
        }
        if (!StringUtils.isBlank(punishtypeid)) {
            sql.append(" and punishtypeid='" + punishtypeid + "'");
        }
        this.doExecuteSql(sql.toString());
    }

    public void updateRadixBasic(Poradixbasic o) {
        StringBuffer sql = new StringBuffer();
        sql.append(" update p_radix_basic set radix='" + o.getRadix()
                + "',multiple='" + o.getMultiple() + "',degreeno='"
                + o.getDegreeno() + "' where 1=1");
        sql.append(" and punishobjectid='" + o.getPunishobjectid()
                + "' and punishtypeid='" + o.getPunishtypeid()
                + "' and item_id='" + o.getItem_id() + "' ");
        this.doExecuteSql(sql.toString());
    }

    /**
     * 获取对应处罚基数信息
     * 
     * @param punishObjectID
     * @param punishTypeID
     * @param item_id
     * @return
     */
    public Poradixbasic getRadixBasicInfo(String punishObjectID,
            String punishTypeID, String item_id) {
        String hql = "from Poradixbasic where punishobjectid = ? and punishtypeid=? and item_id=? ";
        @SuppressWarnings("unchecked")
        List<Poradixbasic> list = (List<Poradixbasic>) this.findObjectsByHql(
                hql, new String[] { punishObjectID, punishTypeID, item_id });
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 根据处罚流水号获取对应基数信息
     * 
     * @param punishobjectid
     * @return
     */
    public Poradixbasic getRadixBasicByPunishobjectid(String punishobjectid) {
        String hql = "from Poradixbasic where punishobjectid = ? ";
        @SuppressWarnings("unchecked")
        List<Poradixbasic> list = (List<Poradixbasic>) this.findObjectsByHql(
                hql, punishobjectid);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

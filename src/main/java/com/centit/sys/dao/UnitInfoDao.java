package com.centit.sys.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;

public class UnitInfoDao extends BaseDaoImpl<FUnitinfo> {
    public static final Log log = LogFactory.getLog(UnitInfoDao.class);
    private static final long serialVersionUID = 1L;

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("UNITCODE", CodeBook.EQUAL_HQL_ID);
            filterField.put("UNITNAME", CodeBook.LIKE_HQL_ID);
            filterField.put("ISVALID", CodeBook.EQUAL_HQL_ID);
            filterField.put("PARENTUNIT", CodeBook.EQUAL_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID,
                    " parentunit, to_number(unitcode)");
        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<FUnitinfo> getSubUnits(String superUnitID) {
        // Oracle only

        String sSqlsen;
        String dn = getDialectName();
        if ("Oracle10gDialect".endsWith(dn) || "OracleDialect".endsWith(dn))
            sSqlsen = "select UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID  "
                    + "from f_Unitinfo "
                    + "where ISVALID='T' "
                    + "start with (UNITCODE = '"
                    + superUnitID
                    + "') "
                    + "connect by  prior UNITCODE = PARENTUNIT "
                    + "order by PARENTUNIT, to_number(unitcode)";
        else
            // if("DB2Dialect".endsWith(dn) || "SQLServerDialect".endsWith(dn))
            // // ibme db2 sql server
            sSqlsen = "WITH RPL (LEVEL,UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID) AS "
                    + " ("
                    + "SELECT 1 as LEVEL,UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID "
                    + "FROM f_Unitinfo "
                    + "WHERE UNITCODE='"
                    + superUnitID
                    + "' "
                    + "UNION ALL "
                    + "SELECT PARENT.LEVEL+1 as LEVEL, CHILD.UNITCODE,CHILD.PARENTUNIT,CHILD.UNITTYPE, "
                    + "CHILD.ISVALID,CHILD.UNITNAME,CHILD.UNITDESC,CHILD.ADDRBOOKID "
                    + "FROM RPL PARENT, f_Unitinfo CHILD "
                    + "WHERE PARENT.UNITCODE = CHILD.PARENTUNIT "
                    + ") "
                    + "SELECT UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID "
                    + "FROM RPL WHERE ISVALID='T' ORDER BY LEVEL,unitorder";

        // sql server

        List<FUnitinfo> l = (List<FUnitinfo>) findObjectsBySql(sSqlsen,
                FUnitinfo.class);

        return l;
    }

    @SuppressWarnings("unchecked")
    public List<FUnitinfo> getAllSubUnits(String superUnitID) {
        // Oracle only

        String sSqlsen;
        String dn = getDialectName();
        if ("Oracle10gDialect".endsWith(dn) || "OracleDialect".endsWith(dn)) /* 交通厅行权添加了DEPNO字段 */
            sSqlsen = /* "select UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID,UNITSHORTNAME,DEPNO,UNITORDER " */
            "select * " + "from f_Unitinfo " +
            // "connect by  prior UNITCODE = PARENTUNIT "+"start with (UNITCODE = '"+superUnitID+"') "+
                    "order by PARENTUNIT, to_number(unitcode)";
        else
            // if("DB2Dialect".endsWith(dn) || "SQLServerDialect".endsWith(dn))
            // // ibme db2 sql server
            sSqlsen = "WITH RPL (LEVEL,UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID) AS "
                    + " ("
                    + "SELECT 1 as LEVEL,UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID "
                    + "FROM f_Unitinfo "
                    + "WHERE UNITCODE='"
                    + superUnitID
                    + "' "
                    + "UNION ALL "
                    + "SELECT PARENT.LEVEL+1 as LEVEL, CHILD.UNITCODE,CHILD.PARENTUNIT,CHILD.UNITTYPE, "
                    + "CHILD.ISVALID,CHILD.UNITNAME,CHILD.UNITDESC,CHILD.ADDRBOOKID "
                    + "FROM RPL PARENT, f_Unitinfo CHILD "
                    + "WHERE PARENT.UNITCODE = CHILD.PARENTUNIT "
                    + ") "
                    + "SELECT UNITCODE,PARENTUNIT,UNITTYPE,ISVALID,UNITNAME,UNITDESC,ADDRBOOKID "
                    + "FROM RPL ORDER BY LEVEL,unitorder";
        // sql server
        log.debug(sSqlsen);
        List<FUnitinfo> l = (List<FUnitinfo>) findObjectsBySql(sSqlsen,
                FUnitinfo.class);
        /*
         * if(l != null ){ //删除自身 for(int i=0;i<l.size();i++){ if(
         * l.get(i).getUnitcode().equals(superUnitID) ){ l.remove(i); break; } }
         * }
         */
        // 为什么要删除自身

        return l;
    }

    public String getNextKey() {
        /*
         * return getNextKeyByHqlStrOfMax("unitcode",
         * "FUnitinfo WHERE unitcode !='99999999'",6);
         */
        return getNextKeyBySequence("S_UNITCODE", 6);
    }

    @SuppressWarnings("unchecked")
    public List<FUserunit> getSysUnitsByUserId(String userId) {
        List<FUserunit> ls = getHibernateTemplate().find(
                "FROM FUserunit where id.usercode=?", userId);
        /*
         * for (FUserunit usun : ls) {
         * usun.setUnitname(CodeRepositoryUtil.getValue
         * ("unitcode",usun.getId().getUnitcode() )); }
         */
        return ls;
    }

    public FUserunit getUserPrimaryUnit(String userId) {
        List<FUserunit> ul = getSysUnitsByUserId(userId);
        FUserunit uu = null;
        for (FUserunit u : ul) {
            if ("T".equals(u.getIsprimary())) {
                uu = u;
                break;
            } else if (uu == null)
                uu = u;
        }
        return uu;
    }

    @SuppressWarnings("unchecked")
    public List<FUserunit> getSysUsersByUnitId(String unitCode) {
        List<FUserunit> ls = getHibernateTemplate().find(
                "FROM FUserunit where id.unitcode=?", unitCode);
        return ls;
    }

    @SuppressWarnings("unchecked")
    public String getUnitCode(String depno) {
        List<FUnitinfo> ls = getHibernateTemplate().find(
                "FROM FUnitinfo where 1=1 and depno=?", depno);
        if (ls != null && !ls.isEmpty()) {
            return ls.get(0).getUnitcode();
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<FUserinfo> getUnitUsers(String unitCode) {
        String sSqlsen = "select a.* "
                + "from f_Userinfo a join f_userunit b on(a.usercode=b.usercode) "
                + "where b.unitcode ='" + unitCode + "'";

        return (List<FUserinfo>) findObjectsBySql(sSqlsen, FUserinfo.class);
    }

    @SuppressWarnings("unchecked")
    public List<FUserinfo> getRelationUsers(String unitCode) {
        String sSqlsen = "select * FROM F_Userinfo ui where ui.usercode in "
                + "(select usercode from f_userunit where unitcode='"
                + unitCode
                + "') or "
                + "ui.usercode in (select usercode from f_userrole where rolecode like '"
                + unitCode + "-%')";

        return (List<FUserinfo>) findObjectsBySql(sSqlsen, FUserinfo.class);
    }

    @SuppressWarnings("unchecked")
    public String getDepNamesByDepIds(String depIds) {
        String sSqlsen = "select *  from f_Unitinfo  where unitcode in (depIds)";
        List<FUserinfo> list = (List<FUserinfo>) findObjectsBySql(sSqlsen,
                FUnitinfo.class);
        return null;
    }
}

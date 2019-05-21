package com.centit.powerruntime.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerruntime.po.OptStuffInfoNet;

public class OptStuffInfoNetDao extends BaseDaoImpl<OptStuffInfoNet> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptStuffInfoNetDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("stuffid", CodeBook.EQUAL_HQL_ID);

            filterField.put("netId", CodeBook.EQUAL_HQL_ID);

            filterField.put("stuffname", CodeBook.LIKE_HQL_ID);

            filterField.put("stuffcontent", CodeBook.LIKE_HQL_ID);

            filterField.put("iszhi", CodeBook.LIKE_HQL_ID);

            filterField.put("filename", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("uploadtime", CodeBook.LIKE_HQL_ID);

            filterField.put("uploadusercode", CodeBook.LIKE_HQL_ID);

            filterField.put("nodename", CodeBook.LIKE_HQL_ID);

            filterField.put("filetype", CodeBook.LIKE_HQL_ID);

            filterField.put("archivetype", CodeBook.EQUAL_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID, " uploadtime desc ");

        }
        return filterField;
    }

    /*
     * public void deleteStuffByiszhi(String sortId){ String hql=
     * "From OptStuffInfoNet where sortId = ? and iszhi = '1' ";
     * 
     * @SuppressWarnings("unchecked") List<OptStuffInfoNet> o=
     * (List<OptStuffInfoNet>) getHibernateTemplate().find(hql, sortId);
     * delete(o.get(0)); }
     * 
     * public OptStuffInfoNet getStuffInfoByFileType(String netId, String
     * fileType) { String hql = "from OptStuffInfoNet where netId = " +
     * HQLUtils.buildHqlStringForSQL(netId);
     * if(StringUtils.isNotBlank(fileType)){ hql += " and filetype =" +
     * HQLUtils.buildHqlStringForSQL(fileType); }
     * 
     * @SuppressWarnings("unchecked") List<OptStuffInfoNet> sqclList =
     * (List<OptStuffInfoNet>) this .findObjectsByHql(hql); if (sqclList != null
     * && sqclList.size() > 0) { return sqclList.get(0); } return null; }
     * 
     * @SuppressWarnings("unchecked") public List<OptStuffInfoNet>
     * getStuffInfoListByFileType(String netId, String fileType) { String hql =
     * "from OptStuffInfoNet where djId = " +
     * HQLUtils.buildHqlStringForSQL(netId);
     * if(StringUtils.isNotBlank(fileType)){ hql += " and filetype =" +
     * HQLUtils.buildHqlStringForSQL(fileType); } return (List<OptStuffInfoNet>)
     * this.findObjectsByHql(hql); }
     *//**
     * 获取许可登记上传附件
     * 
     * @param djId
     * @param nodeinstid
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<OptStuffInfoNet> getStuffInfoNetListByNodeinstid(String netId,
            String nodeinstid) {
        String hql = "from OptStuffInfoNet where djId = "
                + HQLUtils.buildHqlStringForSQL(netId);
        if (StringUtils.isNotBlank(nodeinstid)) {
            hql += " and nodeinstid ="
                    + HQLUtils.buildHqlStringForSQL(nodeinstid);
        }
        return (List<OptStuffInfoNet>) this.findObjectsByHql(hql);
    }

    public OptStuffInfoNet getStuffInfoByArchiveType(String netId,
            String archiveType) {
        String hql = "from OptStuffInfo where netId = "
                + HQLUtils.buildHqlStringForSQL(netId) + " and archivetype ="
                + HQLUtils.buildHqlStringForSQL(archiveType);
        @SuppressWarnings("unchecked")
        List<OptStuffInfoNet> sqclList = (List<OptStuffInfoNet>) this
                .findObjectsByHql(hql);
        if (sqclList != null && sqclList.size() > 0) {
            return sqclList.get(0);
        }
        return null;
    }

    /**
     * 
     * @param djId
     * @param fileType
     * @param archiveType
     * @return
     */
    /*
     * public OptStuffInfo getStuffInfoByType(String djId,String fileType,
     * String archiveType) { String hql = "from OptStuffInfo where djId = " +
     * HQLUtils.buildHqlStringForSQL(djId) + " and archivetype =" +
     * HQLUtils.buildHqlStringForSQL(archiveType) + " and filetype = " +
     * HQLUtils.buildHqlStringForSQL(fileType);
     * 
     * @SuppressWarnings("unchecked") List<OptStuffInfo> sqclList =
     * (List<OptStuffInfo>) this.findObjectsByHql(hql); if (sqclList != null &&
     * sqclList.size() > 0) { return sqclList.get(0); } return null; }
     */

    /**
     * 查询某办件下办理步骤的附件
     * 
     * @param djid
     * @return
     */
    /*
     * public List<OptStuffInfo> listTransStuffs(String djid) { // String hql =
     * "from OptStuffInfo where djId = ? and archivetype in ('02','03','04')";
     * String hql =
     * "from OptStuffInfo where djId = ? and archivetype in ('sl','nsl','bz')";
     * 
     * List<OptStuffInfo> sqclList = this.listObjects(hql,djid); return
     * sqclList; }
     */

    public List<OptStuffInfoNet> listZwclStuffs(String netid) {
        String hql = "from OptStuffInfoNet where netId =?  ";

        List<OptStuffInfoNet> sqclList = this.listObjects(hql, netid);
        return sqclList;
    }

    /**
     * 根据登记编号、附件类型删除受理意见材料
     * 
     * @param djid
     *            登记编号
     * @param clid
     *            附件类型
     */
    /*
     * public void deleteTransStuffs(String djid) { // String sSql =
     * "delete from OPT_STUFF_INFO t where t.archivetype in ('02','03','04') and  t.dj_id = "
     * // + HQLUtils.buildHqlStringForSQL(djid); String sSql =
     * "delete from OPT_STUFF_INFO t where t.archivetype in ('sl','nsl','bz') and  t.dj_id = "
     * + HQLUtils.buildHqlStringForSQL(djid); super.doExecuteSql(sSql); }
     */
    /**
     * 根据文件类型和正文分类删除附件
     * 
     * @param djid
     * @param fileType
     * @param archiveType
     */
    /*
     * public void deleteStuffsByType(String djid,String fileType, String
     * archiveType) { String sSql =
     * "delete from OPT_STUFF_INFO t where t.FILETYPE = " + fileType +
     * " and t.dj_id = " + HQLUtils.buildHqlStringForSQL(djid) +
     * " and t.ARCHIVETYPE =" + HQLUtils.buildHqlStringForSQL(archiveType);
     * super.doExecuteSql(sSql); }
     */

    /**
     * 根据文件类型删除附件信息
     * 
     * @param djid
     *            登记编号
     * @param clid
     *            附件类型
     */
    /*
     * public void deleteStuffsByFileType(String djid,String fileType) { String
     * sSql = "delete from OPT_STUFF_INFO t where T.FILETYPE = " +
     * HQLUtils.buildHqlStringForSQL(fileType) + " and  t.dj_id = " +
     * HQLUtils.buildHqlStringForSQL(djid); super.doExecuteSql(sSql); }
     * 
     * 
     * public void isInuse(String djid){ String
     * hql="update OptStuffInfo  t set t.isuse = '1' where t.djId= " +
     * HQLUtils.buildHqlStringForSQL(djid) + " and t.nodeInstId= '0'";
     * super.doExecuteHql(hql); String sSql =
     * "delete  OptStuffInfo t where t.nodeInstId= '0' and t.isuse is null ";
     * super.doExecuteHql(sSql); }
     */

    public OptStuffInfoNet getObjectById_SortId(String djId, String sortId) {
        String hql = "from OptStuffInfo where djId =? and sortId =? ";
        @SuppressWarnings("unchecked")
        List<OptStuffInfoNet> sqclList = (List<OptStuffInfoNet>) this
                .findObjectsByHql(hql, new String[] { djId, sortId });
        if (sqclList != null && sqclList.size() > 0) {
            return sqclList.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<String> getStuffInfoNetList(String netId) {
        List<String> list = new ArrayList<String>();
        StringBuffer sql = new StringBuffer();
        sql.append(" select FILENAME from OPT_STUFF_INFO_NET where 1=1 ");
        if (StringUtils.isNotBlank(netId)) {
            sql.append(" and NET_ID = " + HQLUtils.buildHqlStringForSQL(netId));
        }
        sql.append(" order by UPLOADTIME DESC ");
        SQLQuery sqlQuery = getSession().createSQLQuery(sql.toString());
        list = sqlQuery.list();
        return list;
    }

    public void deleteObjectById(String netId, String sortId) {
        StringBuffer sql = new StringBuffer();
        sql.append(" delete from OPT_STUFF_INFO_NET where 1=1 ");
        if (StringUtils.isNotBlank(netId)) {
            sql.append(" and net_id = " + HQLUtils.buildHqlStringForSQL(netId));
        }
        if (StringUtils.isNotBlank(sortId)) {
            sql.append(" and sortid = " + HQLUtils.buildHqlStringForSQL(sortId));
        }
        getSession().createSQLQuery(sql.toString()).executeUpdate();

    }
}

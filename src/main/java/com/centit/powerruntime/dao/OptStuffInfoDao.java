package com.centit.powerruntime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerruntime.po.OptStuffInfo;

public class OptStuffInfoDao extends BaseDaoImpl<OptStuffInfo> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(OptStuffInfoDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("stuffid", CodeBook.EQUAL_HQL_ID);

            filterField.put("djId", CodeBook.LIKE_HQL_ID);

            filterField.put("stuffname", CodeBook.LIKE_HQL_ID);

            filterField.put("stuffcontent", CodeBook.LIKE_HQL_ID);

            filterField.put("iszhi", CodeBook.LIKE_HQL_ID);

            filterField.put("filename", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeinstid", CodeBook.LIKE_HQL_ID);

            filterField.put("uploadtime", CodeBook.LIKE_HQL_ID);

            filterField.put("uploadusercode", CodeBook.LIKE_HQL_ID);

            filterField.put("nodename", CodeBook.LIKE_HQL_ID);

            filterField.put("filetype", CodeBook.LIKE_HQL_ID);

            filterField.put("archivetype", CodeBook.LIKE_HQL_ID);

            filterField.put(CodeBook.ORDER_BY_HQL_ID,
                    " order by uploadtime desc ");

        }
        return filterField;
    }

    public void deleteStuffByiszhi(String sortId) {
        String hql = "From OptStuffInfo where sortId = ? and iszhi = '1' ";
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> o = (List<OptStuffInfo>) getHibernateTemplate()
                .find(hql, sortId);
        delete(o.get(0));
    }

    public OptStuffInfo getStuffInfoByFileType(String djId, String fileType) {
        String hql = "from OptStuffInfo where djId = "
                + HQLUtils.buildHqlStringForSQL(djId);
        if (StringUtils.isNotBlank(fileType)) {
            hql += " and filetype =" + HQLUtils.buildHqlStringForSQL(fileType);
        }
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> sqclList = (List<OptStuffInfo>) this
                .findObjectsByHql(hql);
        if (sqclList != null && sqclList.size() > 0) {
            return sqclList.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<OptStuffInfo> getStuffInfoListByFileType(String djId,
            String fileType) {
        String hql = "from OptStuffInfo where djId = "
                + HQLUtils.buildHqlStringForSQL(djId);
        if (StringUtils.isNotBlank(fileType)) {
            hql += " and filetype =" + HQLUtils.buildHqlStringForSQL(fileType);
        }
        return (List<OptStuffInfo>) this.findObjectsByHql(hql);
    }

    /**
     * 获取许可登记上传附件
     * 
     * @param djId
     * @param nodeinstid
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<OptStuffInfo> getStuffInfoListByNodeinstid(String djId,
            String nodeinstid) {
        String hql = "from OptStuffInfo where djId = "
                + HQLUtils.buildHqlStringForSQL(djId);
        if (StringUtils.isNotBlank(nodeinstid)) {
            hql += " and nodeinstid ="
                    + HQLUtils.buildHqlStringForSQL(nodeinstid);
        }
        return (List<OptStuffInfo>) this.findObjectsByHql(hql);
    }

    public OptStuffInfo getStuffInfoByArchiveType(String djId,
            String archiveType) {
        String hql = "from OptStuffInfo where djId = '" + djId
                + "' and archivetype ='" + archiveType + "'";
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> sqclList = (List<OptStuffInfo>) this
                .findObjectsByHql(hql);
        if (sqclList != null && sqclList.size() > 0) {
            return sqclList.get(0);
        }
        return null;
    }
    

    public OptStuffInfo getStuffInfoBydjIdName(String djId,
            String fileName) {
        String hql = "from OptStuffInfo where djId = '" + djId
                + "' and filename ='" + fileName + "'";
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> sqclList = (List<OptStuffInfo>) this
                .findObjectsByHql(hql);
        if (sqclList != null && sqclList.size() > 0) {
            return sqclList.get(0);
        }
        return null;
    }
    
    /**
     * 根据业务流水号和文件类型获取文书、材料附件信息
     * 
     * @param djId
     * @param archiveType
     * @return
     */
    public OptStuffInfo getStuffInfoByType(String djId, String archiveType) {
        String hql = "from OptStuffInfo where djId = "
                + HQLUtils.buildHqlStringForSQL(djId) + " and archivetype ="
                + HQLUtils.buildHqlStringForSQL(archiveType);
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> sqclList = (List<OptStuffInfo>) this
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
    public OptStuffInfo getStuffInfoByType(String djId, String fileType,
            String archiveType) {
        String hql = "from OptStuffInfo where djId = "
                + HQLUtils.buildHqlStringForSQL(djId) + " and archivetype ="
                + HQLUtils.buildHqlStringForSQL(archiveType)
                + " and filetype = " + HQLUtils.buildHqlStringForSQL(fileType);
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> sqclList = (List<OptStuffInfo>) this
                .findObjectsByHql(hql);
        if (sqclList != null && sqclList.size() > 0) {
            return sqclList.get(0);
        }
        return null;
    }

    /**
     * 查询某办件下办理步骤的附件
     * 
     * @param djid
     * @return
     */
    public List<OptStuffInfo> listTransStuffs(String djid) {
        String hql = "from OptStuffInfo where djId = '" + djid
                + "' and archivetype in ('02','03','04')";
        @SuppressWarnings("unchecked")
        List<OptStuffInfo> sqclList = (List<OptStuffInfo>) this
                .findObjectsByHql(hql);
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
    public void deleteTransStuffs(String djid) {
        String sSql = "delete from OPT_STUFF_INFO t where t.archivetype in ('sl','BYXK','bz') and  t.dj_id = '"
                + djid + "'";
        super.doExecuteSql(sSql);
    }

    /**
     * 根据文件类型和正文分类删除附件
     * 
     * @param djid
     * @param fileType
     * @param archiveType
     */
    public void deleteStuffsByType(String djid, String fileType,
            String archiveType) {
        String sSql = "delete from OPT_STUFF_INFO t where t.FILETYPE = "
                + fileType + " and t.dj_id = "
                + HQLUtils.buildHqlStringForSQL(djid) + " and t.ARCHIVETYPE ="
                + HQLUtils.buildHqlStringForSQL(archiveType);
        super.doExecuteSql(sSql);
    }

    /**
     * 根据文件类型删除附件信息
     * 
     * @param djid
     *            登记编号
     * @param clid
     *            附件类型
     */
    public void deleteStuffsByFileType(String djid, String fileType) {
        String sSql = "delete from OPT_STUFF_INFO t where T.FILETYPE = '"
                + fileType + "' and  t.dj_id = '" + djid + "'";
        super.doExecuteSql(sSql);
    }

    public void isInuse(String djid) {
        String hql = "update OptStuffInfo  t set t.isuse = '1' where t.djId= '"
                + djid + "' and t.nodeInstId= '0'";
        super.doExecuteHql(hql);
        /*
         * String sSql =
         * "delete  OptStuffInfo t where t.nodeInstId= '0' and t.isuse is null "
         * ; super.doExecuteHql(sSql);
         */
    }
}

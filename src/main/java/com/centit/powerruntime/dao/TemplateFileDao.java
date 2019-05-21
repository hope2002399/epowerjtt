package com.centit.powerruntime.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerruntime.po.TemplateFile;

public class TemplateFileDao extends BaseDaoImpl<TemplateFile> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(TemplateFileDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("templateId", CodeBook.EQUAL_HQL_ID);
            filterField.put("recordId", CodeBook.LIKE_HQL_ID);
            filterField.put("fileName", CodeBook.LIKE_HQL_ID);
            filterField.put("fileType", CodeBook.LIKE_HQL_ID);
            filterField.put("fileDate", CodeBook.LIKE_HQL_ID);
            filterField.put("fileSize", CodeBook.LIKE_HQL_ID);
            filterField.put("filePath", CodeBook.LIKE_HQL_ID);
            filterField.put("descript", CodeBook.LIKE_HQL_ID);
            filterField.put("tempType", CodeBook.LIKE_HQL_ID);
            filterField.put("isUsed", CodeBook.LIKE_HQL_ID);
            filterField.put("orderBy", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public List<TemplateFile> listTemplateByType(String tempType) {
        String baseHQL = "from TemplateFile where tempType  = "
                + HQLUtils.buildHqlStringForSQL(tempType);
        return this.listObjects(baseHQL);
    }

    public TemplateFile getTemplateByRecordId(String recordId) {
        String baseHQL = "from TemplateFile where recordId  = "
                + HQLUtils.buildHqlStringForSQL(recordId);
        List<TemplateFile> temps = this.listObjects(baseHQL);
        if (temps != null && temps.size() > 0) {
            return temps.get(0);
        }
        return new TemplateFile();
    }

    @SuppressWarnings("unchecked")
    public List<TemplateFile> listTemplateByTypeNoWith(String tempType) {
        String sql = "select recordId,descript from template_file where "
                + "recordId not in (Select recordId from opt_writdef where isinuse='T')"
                + " and tempType=" + HQLUtils.buildHqlStringForSQL(tempType);
        List<Object[]> list = findObjectsBySql(sql);
        List<TemplateFile> reList = new ArrayList<TemplateFile>();
        if (list.size() > 0) {
            for (Object[] o : list) {
                TemplateFile bean = new TemplateFile();
                bean.setRecordId((String) o[0]);
                bean.setDescript((String) o[1]);
                reList.add(bean);
            }
        }
        return reList;
    }
}

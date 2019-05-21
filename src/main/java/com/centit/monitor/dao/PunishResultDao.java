package com.centit.monitor.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.PunishResult;

/**
 * 
 * TODO Class description should be added
 * 
 * @author cjw
 * @create 2013-6-5
 * @version
 */
public class PunishResultDao extends BaseDaoImpl<PunishResult> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PunishResultDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("no", CodeBook.EQUAL_HQL_ID);

            filterField.put("changNo", CodeBook.LIKE_HQL_ID);

            filterField.put("orgId", CodeBook.LIKE_HQL_ID);

            filterField.put("internalNo", CodeBook.LIKE_HQL_ID);

            filterField.put("itemId", CodeBook.LIKE_HQL_ID);

            filterField.put("program", CodeBook.LIKE_HQL_ID);

            filterField.put("punishSort", CodeBook.LIKE_HQL_ID);

            filterField.put("accordance", CodeBook.LIKE_HQL_ID);

            filterField.put("standard", CodeBook.LIKE_HQL_ID);

            filterField.put("punishDeside", CodeBook.LIKE_HQL_ID);

            filterField.put("punishClass", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResult", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultFine", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultFinePeople", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultExpropriation", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultExpropriationV", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultBusiness", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultPeople", CodeBook.LIKE_HQL_ID);

            filterField.put("punishResultDetain", CodeBook.LIKE_HQL_ID);

            filterField.put("attachment", CodeBook.LIKE_HQL_ID);

            filterField.put("finishDate", CodeBook.LIKE_HQL_ID);

            filterField.put("resultStandard", CodeBook.LIKE_HQL_ID);

            filterField.put("createDate", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

            filterField
                    .put("limitdate", "finishDate>= to_date(?,'yyyy-mm-dd')");
            filterField.put("begfinishtime",
                    "finishDate >= to_date(?,'yyyy-mm-dd')");
            filterField.put("endfinishtime",
                    "finishDate <= to_date(?,'yyyy-mm-dd')");

        }
        return filterField;
    }

    /**
     * 
     * @param internalNo
     * @param orgId
     * @return
     */
    public PunishResult getPunishResult(String internalNo, String orgId) {
        String shql = " from PunishResult where internalNo=? and orgId=? ";
        Object[] objects = new Object[] { internalNo, orgId };
        List<PunishResult> Applys = this.listObjects(shql, objects);
        if (Applys != null && Applys.size() >= 1) {
            return Applys.get(0);
        } else {
            return null;
        }
    }
}

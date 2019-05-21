package com.centit.powerbase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.HQLUtils;
import com.centit.powerbase.po.RecordFileBasic;
import com.centit.sys.po.FUnitinfo;

public class RecordFileBasicDao extends BaseDaoImpl<RecordFileBasic> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(RecordFileBasicDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("recordCode", CodeBook.EQUAL_HQL_ID);
            filterField.put("operatorID", CodeBook.EQUAL_HQL_ID);

            filterField.put("beginDate",
                    "to_char(bookDate, 'yyyy-mm-dd') >= ? ");
            filterField.put("endDate", "to_char(bookDate, 'yyyy-mm-dd') <= ? ");
            filterField.put("constituteDepName", CodeBook.LIKE_HQL_ID);
            filterField.put("fileName", CodeBook.LIKE_HQL_ID);
            filterField.put("ownerDepID", CodeBook.LIKE_HQL_ID);
            filterField.put("depFileNo", CodeBook.LIKE_HQL_ID);
            filterField.put("allFIleNo", CodeBook.LIKE_HQL_ID);
            filterField.put("remark", CodeBook.LIKE_HQL_ID);
            filterField.put("finishDate",
                    "to_char(finishDate, 'yyyy-mm-dd') <= ? ");
            filterField.put("finishStatus", CodeBook.LIKE_HQL_ID);
            filterField.put("dealStep", CodeBook.EQUAL_HQL_ID);
            filterField.put("sortNo", CodeBook.LIKE_HQL_ID);
            filterField.put("discussname", CodeBook.LIKE_HQL_ID);
            filterField.put(CodeBook.ORDER_BY_HQL_ID, " bookDate desc");
        }
        return filterField;
    }

    public RecordFileBasic getRecordById(String recordCode) {
        if (recordCode != null) {
            List<RecordFileBasic> procs = this
                    .listObjects("From RecordFileBasic where recordCode =  "
                            + HQLUtils.buildHqlStringForSQL(recordCode)
                            + " and dealStep=1 order by bookDate desc");
            if (procs != null && procs.size() >= 1)
                return procs.get(0);
        }
        return null;

    }

    public String getDepNamesByDepIds(String depIds) {
        String sSqlsen = "select *  from F_UNITINFO  where unitcode in ("
                + depIds + ")";
        // System.out.println(depIds);
        List<FUnitinfo> list = (List<FUnitinfo>) findObjectsBySql(sSqlsen,
                FUnitinfo.class);
        String names = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                names += list.get(i).getUnitname() + "、";
            }
            names = names.substring(0, names.length() - 1);
        }
        return names;

    }

    public String getRecordCode() {
        return getNextKeyBySequence("S_RECORDFILEBASICID", 10);
    }
}

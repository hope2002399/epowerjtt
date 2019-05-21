package com.centit.monitor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.monitor.po.PaMonthCheckup;

public class PaMonthCheckupDao extends BaseDaoImpl<PaMonthCheckup> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(PaMonthCheckupDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("pieceNo", CodeBook.EQUAL_HQL_ID);
            filterField.put("checkType", CodeBook.LIKE_HQL_ID);
            filterField.put("userCode", CodeBook.LIKE_HQL_ID);
            filterField.put("orgId", CodeBook.LIKE_HQL_ID);
            filterField.put("countYear", CodeBook.LIKE_HQL_ID);
            filterField.put("countMonth", CodeBook.LIKE_HQL_ID);
            filterField.put("createDate", CodeBook.LIKE_HQL_ID);
            filterField.put("itemCode", CodeBook.LIKE_HQL_ID);
            filterField.put("itemName", CodeBook.LIKE_HQL_ID);
            filterField.put("itemValue", CodeBook.LIKE_HQL_ID);
            filterField.put("itemUnit", CodeBook.LIKE_HQL_ID);
            filterField.put("itemRuleDesc", CodeBook.LIKE_HQL_ID);
            filterField.put("itemRule", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public List<PaMonthCheckup> getCheckList(String countYear,
            String countMonth, String orgId) {
        String hql = "from PaMonthCheckup where COUNT_YEAR = ? and COUNT_MONTH=? and ORG_ID=?";
        @SuppressWarnings("unchecked")
        List<PaMonthCheckup> sqclList = (List<PaMonthCheckup>) this
                .findObjectsByHql(hql, new Object[] { countYear, countMonth,
                        orgId });
        // if(sqclList != null){
        // VOrgSupPower orgSup = sqclList.get(0);
        // flowCode = orgSup.getOrgFlowCode();
        //
        // if(StringUtils.isBlank(flowCode)){
        // flowCode = orgSup.getOptFlowCode();
        // }
        // }
        // return flowCode;
        return sqclList;
    }

    /**
     * 法制系统 动态实时计算考评
     * 
     * @param orgID
     *            部门编码
     * @param beginTime
     *            开始时间
     * @param endTime
     *            结束时间
     * @return
     */

    public List<PaMonthCheckup> appraisalDeptTemporary(String orgID,
            Date beginTime, Date endTime) {
        List<PaMonthCheckup> ckList = new ArrayList<PaMonthCheckup>();

        try {

            ResultSet rs = callProcedureOutRS(
                    "performance_appraisal.appraisal_dept_temporary", orgID,
                    beginTime, endTime);

            while (rs.next()) {
                PaMonthCheckup ck = new PaMonthCheckup();
                // PIECE_NO, ORG_ID, ITEM_CODE, ITEM_NAME, ITEM_VALUE,
                // ITEM_UNIT, ITEM_RULE_DESC,ITEM_RULE
                ck.setPieceNo(rs.getLong("PIECE_NO"));
                ck.setOrgId(rs.getString("ORG_ID"));
                ck.setItemCode(rs.getString("ITEM_CODE"));
                ck.setItemName(rs.getString("ITEM_NAME"));
                ck.setItemValue(rs.getDouble("ITEM_VALUE"));
                ck.setItemUnit(rs.getString("ITEM_UNIT"));
                ck.setItemRuleDesc(rs.getString("ITEM_RULE_DESC"));
                ck.setItemRule(rs.getString("ITEM_RULE"));
                ckList.add(ck);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ckList;
    }

}

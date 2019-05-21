package com.centit.workflow.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.workflow.sample.po.WfInstAttention;

public class WfInstAttentionDao extends BaseDaoImpl<WfInstAttention> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(WfInstAttentionDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("userCode", "cid.userCode=?");

            filterField.put("flowInstId", "cid.flowInstId=?");

            filterField.put("attSetTime", CodeBook.LIKE_HQL_ID);

            filterField.put("attSetUser", CodeBook.LIKE_HQL_ID);

            filterField.put("attSetMemo", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    /**
     * 删除一个流程的所有关注
     * 
     * @param flowInstId
     */
    public void deleteFlowAttention(long flowInstId) {
        this.doExecuteHql("delete from WfInstAttention where cid.flowInstId=?",
                flowInstId);
    }

    /**
     * 获得一个流程的所有关注
     * 
     * @param flowInstId
     */
    public List<WfInstAttention> listAttentionByFlowInstId(long flowInstId) {
        return this.listObjects("From WfInstAttention where cid.flowInstId=?",
                flowInstId);
    }
}

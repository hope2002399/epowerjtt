package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.SuperviseReply;

public class SuperviseReplyDao extends BaseDaoImpl<SuperviseReply> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuperviseReplyDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("nodeinstid", CodeBook.EQUAL_HQL_ID);

            filterField.put("superviseNo", CodeBook.LIKE_HQL_ID);

            filterField.put("processCode", CodeBook.LIKE_HQL_ID);

            filterField.put("processName", CodeBook.LIKE_HQL_ID);

            filterField.put("processDate", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorResult", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorOpinion", CodeBook.LIKE_HQL_ID);

            filterField.put("attachment", CodeBook.LIKE_HQL_ID);

            filterField.put("updateDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncDate", CodeBook.LIKE_HQL_ID);

            filterField.put("syncSign", CodeBook.LIKE_HQL_ID);

            filterField.put("syncErrorDesc", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    @SuppressWarnings("unchecked")
    public List<SuperviseReply> getObjListBySuperviseNo(String superviseNo) {
        return getHibernateTemplate()
                .find("FROM SuperviseReply  where superviseNo= ? order by processDate ",
                        superviseNo);
    }

    public SuperviseReply getObjectByNodeInstId(long nodeInstId) {
        List<SuperviseReply> optSuperviseReplyList = this.listObjects(
                "from SuperviseReply where nodeInstId = ?", nodeInstId);
        if (optSuperviseReplyList == null || optSuperviseReplyList.size() == 0) {
            return null;
        }
        return optSuperviseReplyList.get(0);
    }
}

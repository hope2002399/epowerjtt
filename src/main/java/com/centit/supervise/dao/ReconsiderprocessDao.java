package com.centit.supervise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.supervise.po.Reconsiderprocess;

public class ReconsiderprocessDao extends BaseDaoImpl<Reconsiderprocess> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ReconsiderprocessDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("processno", CodeBook.EQUAL_HQL_ID);

            filterField.put("nodeInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("reconsiderId", CodeBook.EQUAL_HQL_ID);

            filterField.put("processCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("processName", CodeBook.LIKE_HQL_ID);

            filterField.put("processDate", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorId", CodeBook.EQUAL_HQL_ID);

            filterField.put("operatorName", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorResult", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorOpinion", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }

    public Reconsiderprocess getObjectByNodeInstId(Long nodeInstId) {
        List<Reconsiderprocess> optReconsiderprocessList = this.listObjects(
                "from Reconsiderprocess where nodeInstId = ?", nodeInstId);
        if (optReconsiderprocessList == null
                || optReconsiderprocessList.size() == 0) {
            return null;
        }
        return optReconsiderprocessList.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Reconsiderprocess> getObjListByReconsiderId(String reconsiderId) {
        return getHibernateTemplate()
                .find("FROM Reconsiderprocess  where reconsiderId= ? order by processDate desc ",
                        reconsiderId);
    }
}

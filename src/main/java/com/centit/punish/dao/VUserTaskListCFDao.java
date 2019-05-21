package com.centit.punish.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.punish.po.VUserTaskListCF;

public class VUserTaskListCFDao extends BaseDaoImpl<VUserTaskListCF> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(VUserTaskListCF.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            // 自己添加
            filterField = new HashMap<String, String>();
            filterField.put("nodeInstId", CodeBook.EQUAL_HQL_ID);

            filterField.put("flowInstId", CodeBook.LIKE_HQL_ID);

            filterField.put("wfOptName", CodeBook.LIKE_HQL_ID);

            filterField.put("wfOptTag", CodeBook.LIKE_HQL_ID);

            filterField.put("userCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("roleType", CodeBook.LIKE_HQL_ID);

            filterField.put("roleCode", CodeBook.LIKE_HQL_ID);

            filterField.put("authDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeName", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeType", CodeBook.LIKE_HQL_ID);

            filterField.put("nodeOptType", CodeBook.LIKE_HQL_ID);

            filterField.put("optName", CodeBook.LIKE_HQL_ID);

            filterField.put("methodName", CodeBook.LIKE_HQL_ID);

            filterField.put("optUrl", CodeBook.LIKE_HQL_ID);

            filterField.put("optMethod", CodeBook.LIKE_HQL_ID);

            filterField.put("optDesc", CodeBook.LIKE_HQL_ID);

            filterField.put("optCode", CodeBook.EQUAL_HQL_ID);

            filterField.put("inststate", CodeBook.LIKE_HQL_ID);

            filterField.put("flowPhase", CodeBook.LIKE_HQL_ID);

            filterField.put("noGrantor",
                    "1 = to_number(?) and grantor is null ");

            filterField.put("grantor",
                    "1 = to_number(?) and grantor is not null ");

            filterField.put(CodeBook.ORDER_BY_HQL_ID, "nodeCreateTime desc");
            filterField.put("punishobjectid", CodeBook.EQUAL_HQL_ID);

            filterField.put("punishobjectno", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjecttype", CodeBook.LIKE_HQL_ID);

            filterField.put("managedepid", CodeBook.LIKE_HQL_ID);

            filterField.put("poorigindate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisterdate", CodeBook.LIKE_HQL_ID);

            filterField.put("poindagaterepdate", CodeBook.LIKE_HQL_ID);

            filterField.put("pofinishdate", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectbrief", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurstate", CodeBook.LIKE_HQL_ID);

            filterField.put("poimpeachstate", CodeBook.LIKE_HQL_ID);

            filterField.put("poundertaker", CodeBook.LIKE_HQL_ID);

            filterField.put("punishclassnum", CodeBook.LIKE_HQL_ID);

            filterField.put("pocontrovertype", CodeBook.LIKE_HQL_ID);

            filterField.put("podiscussnum", CodeBook.LIKE_HQL_ID);

            filterField.put("issurpass", CodeBook.LIKE_HQL_ID);

            filterField.put("punishobjectstate", CodeBook.LIKE_HQL_ID);

            filterField.put("remark", CodeBook.LIKE_HQL_ID);

            filterField.put("ispass", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccuradress", CodeBook.LIKE_HQL_ID);

            filterField.put("pooccurdate", CodeBook.LIKE_HQL_ID);

            filterField.put("poregisteropinion", CodeBook.LIKE_HQL_ID);

            filterField.put("operatorid", CodeBook.LIKE_HQL_ID);

            filterField.put("poorigincontext", CodeBook.LIKE_HQL_ID);

            filterField.put("poregistedate", CodeBook.LIKE_HQL_ID);

            filterField.put("pooriginstate", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachphone", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachunit", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachid", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachname", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachsex", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachage", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachadress", CodeBook.LIKE_HQL_ID);

            filterField.put("pocaseimpeachpostcode", CodeBook.LIKE_HQL_ID);

            filterField.put("riskdesc", CodeBook.LIKE_HQL_ID);

            filterField.put("risktype", CodeBook.LIKE_HQL_ID);

            filterField.put("riskresult", CodeBook.LIKE_HQL_ID);

            filterField.put("optId", CodeBook.LIKE_HQL_ID);
        }
        return filterField;
    }

}

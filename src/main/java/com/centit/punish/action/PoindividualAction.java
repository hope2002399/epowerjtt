package com.centit.punish.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.PageDesc;
import com.centit.punish.po.Poindividual;
import com.centit.punish.service.PoindividualManager;

public class PoindividualAction extends BaseEntityExtremeAction<Poindividual> {
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(PoindividualAction.class);
    private static final long serialVersionUID = 1L;
    private PoindividualManager poindividualMag;

    public void setPoindividualManager(PoindividualManager basemgr) {
        poindividualMag = basemgr;
        this.setBaseEntityManager(poindividualMag);
    }

    /**
     * 根据查询表单查询
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String listvidual() {
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            String orderField = request.getParameter("orderField");
            String orderDirection = request.getParameter("orderDirection");

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            if (!StringUtils.isBlank(orderField)
                    && !StringUtils.isBlank(orderDirection)) {

                filterMap.put(CodeBook.SELF_ORDER_BY, orderField + " "
                        + orderDirection);

                // request.setAttribute("orderDirection", orderDirection);
                // request.setAttribute("orderField", orderField);
            }
            PageDesc pageDesc = makePageDesc();
            objList = baseEntityManager.listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();

            this.pageDesc = pageDesc;
            return LIST;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
}

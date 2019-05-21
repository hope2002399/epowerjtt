package com.centit.powerruntime.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.optmodel.PowerRuntimeEntityAction;
import com.centit.powerruntime.po.OptPickupMessage;
import com.centit.powerruntime.service.OptPickupMessageManager;

public class OptPickupMessageAction extends
        PowerRuntimeEntityAction<OptPickupMessage> implements
        ServletResponseAware {
    private static final Log log = LogFactory
            .getLog(OptPickupMessageAction.class);

    private static final long serialVersionUID = 1L;
    private OptPickupMessageManager optPickupMessageMag;

    public void setOptPickupMessageManager(OptPickupMessageManager basemgr) {
        optPickupMessageMag = basemgr;
        this.setBaseEntityManager(optPickupMessageMag);
    }

    public String list() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<OptPickupMessage> pickupMessagelist = optPickupMessageMag
                .listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("pickupMessagelist", pickupMessagelist);
        return "list";

    }

    public String selectlist() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<OptPickupMessage> pickupMessagelist = optPickupMessageMag
                .listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("pickupMessagelist", pickupMessagelist);
        return "selectlist";

    }

    public String add() {
        optPickupMessageMag.clearObjectProperties(object);
        object.setPickupid(null);
        return EDIT;
    }

    public String edit() {
        try {
            if (object == null) {
                object = getEntityClass().newInstance();
            } else {
                OptPickupMessage o = optPickupMessageMag.getObject(object);
                if (o != null) {
                    optPickupMessageMag.copyObject(object, o);
                } else {
                    optPickupMessageMag.clearObjectProperties(object);
                }
            }
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String save() {
        OptPickupMessage o = optPickupMessageMag.getObject(object);
        if (o != null) {
            optPickupMessageMag.copyObjectNotNullProperty(o, object);
            object = o;
        } else {
            object.setPickupid(optPickupMessageMag.getPickupMessageId());
        }
        optPickupMessageMag.saveObject(object);
        return this.list();
    }

    public String view() {
        try {
            OptPickupMessage o = optPickupMessageMag.getObject(object);
            if (object == null) {
                return "view";
            }
            if (o != null) {
                optPickupMessageMag.copyObject(object, o);
            }
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    public String delete() {
        super.delete();

        return this.list();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        // TODO Auto-generated method stub
        
    }

}

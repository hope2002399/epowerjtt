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
import com.centit.powerruntime.po.OptSendMessage;
import com.centit.powerruntime.service.OptSendMessageManager;

public class OptSendMessageAction extends
        PowerRuntimeEntityAction<OptSendMessage> implements
        ServletResponseAware {
    private static final Log log = LogFactory
            .getLog(OptSendMessageAction.class);

    private static final long serialVersionUID = 1L;
    private OptSendMessageManager optSendMessageMag;

    public void setOptSendMessageManager(OptSendMessageManager basemgr) {
        optSendMessageMag = basemgr;
        this.setBaseEntityManager(optSendMessageMag);
    }

    public String list() {
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<OptSendMessage> sendMessagelist = optSendMessageMag.listObjects(
                filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("sendMessagelist", sendMessagelist);
        return "list";

    }

    @SuppressWarnings("unchecked")
    public String selectlist() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        List<OptSendMessage> sendMessagelist = optSendMessageMag.listObjects(
                filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        request.setAttribute("sendMessagelist", sendMessagelist);
        return "selectlist";
    }

    public String add() {
        optSendMessageMag.clearObjectProperties(object);
        object.setSendid(null);
        return EDIT;
    }

    public String edit() {
        try {
            if (object == null) {
                object = getEntityClass().newInstance();
            } else {
                OptSendMessage o = optSendMessageMag.getObject(object);
                if (o != null) {
                    optSendMessageMag.copyObject(object, o);
                } else {
                    optSendMessageMag.clearObjectProperties(object);
                }
            }
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String save() {
        OptSendMessage o = optSendMessageMag.getObject(object);
        if (o != null) {
            optSendMessageMag.copyObjectNotNullProperty(o, object);
            object = o;
        } else {
            object.setSendid(optSendMessageMag.getSendMessageId());
        }
        optSendMessageMag.saveObject(object);
        return this.list();
    }

    public String view() {
        try {
            OptSendMessage o = optSendMessageMag.getObject(object);
            if (object == null) {
                return "view";
            }
            if (o != null) {
                optSendMessageMag.copyObject(object, o);
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

package com.centit.monitor.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.ApplyDoc;
import com.centit.monitor.po.ApplyProcess;
import com.centit.monitor.service.ApplyDocManager;
import com.centit.monitor.service.ApplyProcessManager;
import com.centit.monitor.service.OutwayManager;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.SysUserManager;

public class ApplyProcessAction extends BaseEntityExtremeAction<ApplyProcess> {
    private static final Log log = LogFactory.getLog(ApplyProcessAction.class);
    private static final long serialVersionUID = 1L;
    private ApplyProcessManager applyProcessManager;
    private ApplyDocManager applyDocManager;
    private OutwayManager outwayManager;
    private SysUserManager sysUserManager;

    public void setSysUserManager(SysUserManager sysUserManager) {
        this.sysUserManager = sysUserManager;
    }

    public OutwayManager getOutwayManager() {
        return outwayManager;
    }

    public void setOutwayManager(OutwayManager outwayManager) {
        this.outwayManager = outwayManager;
    }

    public void setApplyDocManager(ApplyDocManager applyDocManager) {
        this.applyDocManager = applyDocManager;
    }

    public void setApplyProcessManager(ApplyProcessManager basemgr) {
        applyProcessManager = basemgr;
        this.setBaseEntityManager(applyProcessManager);
    }

    public String list() {
        String internalNo = request.getParameter("internalNo");
        String itemId = request.getParameter("itemId");
        objList = applyProcessManager.listObjects(internalNo, itemId);
        // request.setAttribute("processList", processList);
        return "list";
    }

    public String view() {
        try {
            ApplyProcess applyProcess = applyProcessManager.getObject(object);
            HashMap<String, Object> docMap = new HashMap<String, Object>();
            docMap.put("docType", "2");
            docMap.put("internalNo", applyProcess.getInternalNo());
            docMap.put("itemId", applyProcess.getItemId());
            docMap.put("processNo", applyProcess.getNoOrd());
            List<ApplyDoc> docList = applyDocManager.listObjects(docMap);
            applyProcess.setDocList(docList);
            Map<String, Object> filterMap = new HashMap<String, Object>();
            filterMap.put("internalNo", applyProcess.getInternalNo());
            filterMap.put("processNo", applyProcess.getNo());
            FUserDetail user = ((FUserDetail) getLoginUser());
            FUserunit dept = sysUserManager.getUserPrimaryUnit(user
                    .getUsercode());
            String sParentUnit = dept.getUnitcode();
            filterMap.put("topunitcode", sParentUnit);
            applyProcess.setOutwaylist(this.outwayManager
                    .getOutWayList(filterMap));
            if (object == null) {
                return LIST;
            }
            List<ApplyDoc> doclist = applyDocManager.getProcessApplyDoc(
                    applyProcess.getInternalNo(), applyProcess.getItemId(),
                    String.valueOf(applyProcess.getNoOrd()), false);
            request.setAttribute("listStuff", doclist);
            request.setAttribute("applyProcess", applyProcess);
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }

    public String delete() {
        super.delete();
        return "delete";
    }
}

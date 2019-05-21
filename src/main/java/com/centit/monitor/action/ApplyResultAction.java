package com.centit.monitor.action;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.ApplyDoc;
import com.centit.monitor.po.ApplyResult;
import com.centit.monitor.service.ApplyDocManager;
import com.centit.monitor.service.ApplyResultManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;

public class ApplyResultAction extends BaseEntityExtremeAction<ApplyResult> {
    private static final Log log = LogFactory.getLog(ApplyResultAction.class);
    private static final long serialVersionUID = 1L;
    private ApplyResultManager applyResultManager;
    private ApplyDocManager applyDocManager;

    public void setApplyDocManager(ApplyDocManager applyDocManager) {
        this.applyDocManager = applyDocManager;
    }

    public void setApplyResultManager(ApplyResultManager basemgr) {
        applyResultManager = basemgr;
        this.setBaseEntityManager(applyResultManager);
    }

    public String delete() {
        super.delete();
        return "delete";
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            ApplyResult result = applyResultManager.getApplyResult(internalNo,
                    itemId);
            HashMap<String, Object> docMap = new HashMap<String, Object>();
            docMap.put("docType", "3");
            docMap.put("internalNo", result.getInternalNo());
            docMap.put("itemId", result.getItemId());
            List<ApplyDoc> docList = applyDocManager.listObjects(docMap);
            result.setDocList(docList);
            if (object == null) {
                return LIST;
            }
            List<InFlowInfo> listStuff = JDomeGetItem.JDomeGetDocument(result
                    .getAttachment());
            request.setAttribute("listStuff", listStuff);
            request.setAttribute("result", result);
            return VIEW;
        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }
    }
}

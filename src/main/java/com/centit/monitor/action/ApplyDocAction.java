package com.centit.monitor.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.monitor.po.Apply;
import com.centit.monitor.po.ApplyDoc;
import com.centit.monitor.po.ApplyResult;
import com.centit.monitor.service.ApplyDocManager;
import com.centit.monitor.service.ApplyManager;
import com.centit.monitor.service.ApplyProcessManager;
import com.centit.monitor.service.ApplyResultManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;
import com.opensymphony.xwork2.ActionContext;

public class ApplyDocAction extends BaseEntityExtremeAction<ApplyDoc> {
    private static final Log log = LogFactory.getLog(ApplyDocAction.class);
    private static final long serialVersionUID = 1L;
    private ApplyDocManager applyDocManager;
    private ApplyManager applyManager;
    private ApplyResultManager applyResultManager;

    public void setApplyManager(ApplyManager applyManager) {
        this.applyManager = applyManager;
    }

    public void setApplyProcessManager(ApplyProcessManager applyProcessManager) {
    }

    public void setApplyResultManager(ApplyResultManager applyResultManager) {
        this.applyResultManager = applyResultManager;
    }

    public void setApplyDocManager(ApplyDocManager basemgr) {
        applyDocManager = basemgr;
        this.setBaseEntityManager(applyDocManager);
    }

    /**
     * 材料下载使用
     */
    private InputStream stuffStream;
    ActionContext context = ActionContext.getContext();
    HttpServletResponse response;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public String downloadAtt() throws IOException {
        String type = request.getParameter("type");
        String no = request.getParameter("no");
        String document_id = request.getParameter("document_id");
        ApplyDoc showdoc = null;
        if ("1".equals(type)) {
            Apply apply = applyManager.getObjectById(no);
            InFlowInfo flowInfo = JDomeGetItem.JDomeGetDocument_File_content(
                    apply.getStuff(), document_id);
            showdoc = new ApplyDoc(flowInfo, true);
        } else if ("2".equals(type)) {
            String itemId = request.getParameter("itemId");
            String internalNo = request.getParameter("internal_no");
            String noord = request.getParameter("noord");
            List<ApplyDoc> doclist = applyDocManager.getProcessApplyDoc(
                    internalNo, itemId, noord, true);
            String applydocno = request.getParameter("applydocno");
            for (ApplyDoc doc : doclist) {
                if (doc.getNo().equals(applydocno)) {
                    showdoc = doc;
                    break;
                }
            }
        } else if ("3".equals(type)) {
            ApplyResult apply = applyResultManager.getObjectById(no);
            InFlowInfo flowInfo = JDomeGetItem.JDomeGetDocument_File_content(
                    apply.getAttachment(), document_id);
            showdoc = new ApplyDoc(flowInfo, true);
        }
        String fileName = showdoc.getDocName();
        byte[] bt = showdoc.getDocFile();
        try {
            if (bt != null) {
                setStuffStream(new ByteArrayInputStream(bt));
            } else {
                this.postAlertMessage("操作失败，没有电子档！", response);
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        this.setFilename(new String(fileName.getBytes("GBK"), "ISO8859-1"));
        return "download";
    }

    public String downloadStuff() throws IOException {
        ApplyDoc bean = applyDocManager.getObjectById(object.getNo());
        String fileName = "文件查看";
        byte[] bt = null;

        fileName = bean.getDocName();
        bt = bean.getDocFile();

        try {
            if (bt != null) {
                setStuffStream(new ByteArrayInputStream(bt));
            } else {
                // saveError("没有电子档！");
                this.postAlertMessage("操作失败，没有电子档！", response);
                return null;
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }
        this.setFilename(new String(fileName.getBytes("GBK"), "ISO8859-1"));
        return "download";
    }

    /**
     * 弹出提示信息
     * 
     * @param msg
     * @param response
     */
    protected void postAlertMessage(String msg, HttpServletResponse response) {
        String alertCoding = "GBK";
        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";
        response.setContentType("text/html; charset=" + alertCoding);
        try {
            sos = response.getOutputStream();
            int strSize = (int) str.length();
            byte[] b = new byte[strSize];
            b = str.getBytes();
            sos.write(b);
            sos.flush();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public String delete() {
        super.delete();
        return "delete";
    }
}

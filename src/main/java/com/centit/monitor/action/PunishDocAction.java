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
import com.centit.monitor.po.Punish;
import com.centit.monitor.po.PunishDoc;
import com.centit.monitor.po.PunishResult;
import com.centit.monitor.service.PunishDocManager;
import com.centit.monitor.service.PunishManager;
import com.centit.monitor.service.PunishProcessManager;
import com.centit.monitor.service.PunishResultManager;
import com.centit.sys.util.InFlowInfo;
import com.centit.sys.util.JDomeGetItem;
import com.opensymphony.xwork2.ActionContext;

public class PunishDocAction extends BaseEntityExtremeAction<PunishDoc> {
    private static final Log log = LogFactory.getLog(PunishDocAction.class);
    private static final long serialVersionUID = 1L;
    private PunishDocManager punishDocManager;
    private PunishManager punishManager;
    private PunishResultManager punishResultManager;
    private PunishProcessManager punishProcessManager;

    public void setPunishManager(PunishManager punishManager) {
        this.punishManager = punishManager;
    }

    public void setPunishResultManager(PunishResultManager punishResultManager) {
        this.punishResultManager = punishResultManager;
    }

    public void setPunishDocManager(PunishDocManager basemgr) {
        punishDocManager = basemgr;
        this.setBaseEntityManager(punishDocManager);
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

    public String downloadStuff() throws IOException {
        PunishDoc bean = punishDocManager.getObjectById(object.getNo());
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

    public String downloadAtt() throws IOException {
        String type = request.getParameter("type");
        String no = request.getParameter("no");
        String document_id = request.getParameter("document_id");
        PunishDoc showdoc = null;
        if ("1".equals(type)) {
            Punish apply = punishManager.getObjectById(no);
            InFlowInfo flowInfo = JDomeGetItem.JDomeGetDocument_File_content(
                    apply.getForm(), document_id);
            showdoc = new PunishDoc(flowInfo, true);
        } else if ("2".equals(type)) {
            String org_id = request.getParameter("orgId");
            String internalNo = request.getParameter("internal_no");
            String noord = request.getParameter("noord");
            String style = request.getParameter("style");
            List<PunishDoc> doclist = punishDocManager.getProcessPunishDoc(
                    style, internalNo, org_id, noord, true);
            String punishdocno = request.getParameter("punishdocno");
            for (PunishDoc doc : doclist) {
                if (doc.getNo().equals(punishdocno)) {
                    showdoc = doc;
                    break;
                }
            }
        } else if ("3".equals(type)) {
            PunishResult apply = punishResultManager.getObjectById(no);
            InFlowInfo flowInfo = JDomeGetItem.JDomeGetDocument_File_content(
                    apply.getAttachment(), document_id);
            showdoc = new PunishDoc(flowInfo, true);
        }
        // ApplyDoc bean = applyDocManager.getObjectById(object.getNo());
        String fileName = showdoc.getDocName();
        byte[] bt = showdoc.getDocFile();
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

    public void setPunishProcessManager(PunishProcessManager punishProcessManager) {
        this.punishProcessManager = punishProcessManager;
    }
    
}

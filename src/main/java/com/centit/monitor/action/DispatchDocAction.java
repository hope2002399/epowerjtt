package com.centit.monitor.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.dispatchdoc.po.DispatchDoc;
import com.centit.dispatchdoc.service.DispatchDocManager;
import com.opensymphony.xwork2.ActionContext;

public class DispatchDocAction extends BaseEntityExtremeAction<DispatchDoc> {
    private static final Log log = LogFactory.getLog(DispatchDocAction.class);
    private static final long serialVersionUID = 1L;
    private DispatchDocManager dispatchDocManager;
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

    public void setDispatchDocManager(DispatchDocManager basemgr) {
        dispatchDocManager = basemgr;
        this.setBaseEntityManager(dispatchDocManager);
    }

    public String view() {
        try {
            String internalNo = object.getInternalNo();
            String itemId = object.getItemId();
            DispatchDoc dispatchDoc = dispatchDocManager.getDispatchDoc(
                    internalNo, itemId);
            if (object == null) {
                return LIST;
            }
            request.setAttribute("dispatchDoc", dispatchDoc);
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

    private String no;

    public String downloadStuff() throws IOException {
        DispatchDoc incomeDoc = dispatchDocManager.getObjectById(no);
        String fileName = "文件查看";
        byte[] bt = null;
        fileName = incomeDoc.getDispatchDocFileName();
        bt = incomeDoc.getDispatchDocFile();
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}

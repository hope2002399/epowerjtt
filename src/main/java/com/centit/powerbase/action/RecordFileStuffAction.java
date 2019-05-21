package com.centit.powerbase.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.dao.CodeBook;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.RecordFileBasic;
import com.centit.powerbase.po.RecordFileStuff;
import com.centit.powerbase.service.RecordFileStuffManager;

public class RecordFileStuffAction extends
        BaseEntityExtremeAction<RecordFileBasic> implements
        ServletResponseAware {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    HttpServletResponse response;

    private RecordFileStuffManager recordFileStuffManager;
    private List<RecordFileStuff> filestufflist;
    private InputStream stuffStream;
    private String filename;
    private String attachNo;

    @SuppressWarnings("unchecked")
    public String list() {
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        filterMap.put(CodeBook.SELF_ORDER_BY, "uploadDate desc");
        filestufflist = recordFileStuffManager
                .getFileStuff(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return LIST;
    }

    protected void postAlertMessage(String msg, HttpServletResponse response) {// 提示信息
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

    public String stuffDown() throws IOException {// 附件查看或者下载
        String attachNo = (String) request.getAttribute("attachNo");
        System.out.println(attachNo);
        RecordFileStuff bean = recordFileStuffManager.getStuffByNo(attachNo);
        String fileName = "文件查看";
        byte[] bt = null;
        fileName = bean.getFileName();
        bt = bean.getContext();

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

    public String changeFileType(String filetype) {
        if (filetype.equals("01")) {
            return "备案报告";
        }
        if (filetype.equals("02")) {
            return "规范性文件正式文本";
        }
        if (filetype.equals("03")) {
            return "制定说明";
        }
        if (filetype.equals("04")) {
            return "制定依据";
        }
        return "其他";
    }

    public List<RecordFileStuff> getFilestufflist() {
        return filestufflist;
    }

    public void setFilestufflist(List<RecordFileStuff> filestufflist) {
        this.filestufflist = filestufflist;
    }

    public void setRecordFileStuffManager(
            RecordFileStuffManager recordFileStuffManager) {
        this.recordFileStuffManager = recordFileStuffManager;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    public List<RecordFileStuff> getRecordFileStuffByRecord(String recordCode) {

        return recordFileStuffManager.getRecordFileStuffByRecord(recordCode);

    }

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAttachNo() {
        return attachNo;
    }

    public void setAttachNo(String attachNo) {
        this.attachNo = attachNo;
    }

}

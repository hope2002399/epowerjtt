package com.centit.sys.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.sys.po.ApplyUser;
import com.centit.sys.po.ApplyUserStuffInfo;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.ApplyUserManager;
import com.centit.sys.util.ISysOptLog;
import com.centit.sys.util.SysOptLogFactoryImpl;

public class ApplyUserAction extends BaseEntityExtremeAction<ApplyUser>
        implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ApplyUserAction.class);
    @SuppressWarnings("unused")
    private static final ISysOptLog SYS_OPT_LOG = SysOptLogFactoryImpl
            .getSysOptLog("USERMAG");
    private ApplyUserManager applyUserMgr;

    public ApplyUserManager getApplyUserMgr() {
        return applyUserMgr;
    }

    public void setApplyUserMgr(ApplyUserManager applyUserMgr) {
        this.applyUserMgr = applyUserMgr;
        this.setBaseEntityManager(applyUserMgr);
    }

    protected HttpServletResponse response;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    // 启用
    public String renew() {
        try {
            object = applyUserMgr.getObjectById(object.getUserID());
            object.setIsInUse("1");
            applyUserMgr.saveObject(object);
            return super.list();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }

    }

    // 禁用
    public String delete() {
        try {
            object = applyUserMgr.getObjectById(object.getUserID());
            object.setIsInUse("0");
            applyUserMgr.saveObject(object);
            return super.list();

        } catch (Exception e) {
            log.error(e.getMessage());
            return ERROR;
        }

    }

    // 查看
    public String view() {

        try {
            //
            object = applyUserMgr.getObjectById(object.getUserID());

            return VIEW;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // 审核
    public String edit() {

        try {
            //
            object = applyUserMgr.getObjectById(object.getUserID());

            return EDIT;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String savesh() {

        try {
            FUserDetail user = ((FUserDetail) getLoginUser());
            String shjg = object.getIsInUse();
            object = applyUserMgr.getObjectById(object.getUserID());
            object.setIsInUse(shjg);
            object.setCheckDate(new Date(System.currentTimeMillis()));
            object.setCheckOperatorId(user.getUsercode());
            applyUserMgr.saveObject(object);
            return super.list();

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private InputStream stuffStream;

    public InputStream getStuffStream() {
        return stuffStream;
    }

    public void setStuffStream(InputStream stuffStream) {
        this.stuffStream = stuffStream;
    }

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @SuppressWarnings("unused")
    public String downStuffInfo() throws IOException {

        ApplyUserStuffInfo asi = applyUserMgr
                .getApplyUserStuffInfoByUserID(object.getUserID());
        String fn = asi.getFilename();
        try {
            if (asi.getFilecontent() == null) {
                this.postAlertMessage("附件为空或为纸质文件", response);
                return null;
            }
            if (asi.getFilecontent() != null) {
                InputStream inputStream = new ByteArrayInputStream(
                        asi.getFilecontent());
                this.setStuffStream(inputStream);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
        }

        object.setFilename(asi.getFilename());
        return "download";

    }

    protected void postAlertMessage(String msg, HttpServletResponse response) {

        String alertCoding = "GBK";

        ServletOutputStream sos;
        String str = "<script language=\"JavaScript\""
                + " type=\"text/JavaScript\" charset=\"" + alertCoding + "\">"
                + "javascript:alert('" + msg + "');history.back(-1);"
                + " </script>";

        // response.setContentType("text/html; charset=" + alertCoding);
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
}

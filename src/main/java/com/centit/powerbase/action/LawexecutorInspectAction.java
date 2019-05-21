package com.centit.powerbase.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerbase.po.LawexecutorInspect;
import com.centit.powerbase.service.LawexecutorInspectManager;
import com.centit.support.utils.DatetimeOpt;
import com.centit.sys.security.FUserDetail;

/**
 * 
 * 执法人年检Action
 * 
 * @author jf
 * @create 2013-10-25
 * @version
 */
public class LawexecutorInspectAction extends
        BaseEntityExtremeAction<LawexecutorInspect> {

    private static final Log log = LogFactory
            .getLog(LawexecutorInspectAction.class);

    private static final long serialVersionUID = 1L;

    private LawexecutorInspectManager lawexecutorInspectMag;

    public String backurl;

    public void setLawexecutorInspectManager(LawexecutorInspectManager basemgr) {
        lawexecutorInspectMag = basemgr;
        this.setBaseEntityManager(lawexecutorInspectMag);
    }

    public String save() {
        try {
            FUserDetail user = (FUserDetail) getLoginUser();// 获取当前用户的信息
            object.setRecorder(user.getUsercode());
            object.setRecordDate(DatetimeOpt.currentUtilDate());

            baseEntityManager.saveObject(object);
            savedMessage();
            return SUCCESS;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            saveError(e.getMessage());
            return ERROR;
        }
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }

}

package com.centit.powerbase.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerbase.po.RecordFileDep;

public class RecordFileDepAction extends BaseEntityExtremeAction<RecordFileDep>
        implements ServletResponseAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    HttpServletResponse response;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

}

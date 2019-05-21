package com.centit.powerruntime.action;

import com.centit.powerruntime.po.YwFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

    



        

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.service.YwFileManager;
    

public class YwFileAction  extends BaseEntityExtremeAction<YwFile>  {
    private static final Log log = LogFactory.getLog(YwFileAction.class);
    
    //private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
    
    private static final long serialVersionUID = 1L;
    private YwFileManager ywFileMag;
    public void setYwFileManager(YwFileManager basemgr)
    {
        ywFileMag = basemgr;
        this.setBaseEntityManager(ywFileMag);
    }

    
    
        
    public String delete() {
        super.delete();      
        
        return "delete";
    }
}

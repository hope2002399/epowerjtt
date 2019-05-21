package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.YwFile;
import com.centit.powerruntime.dao.YwFileDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.YwFileManager;

public class YwFileManagerImpl extends BaseEntityManagerImpl<YwFile>
    implements YwFileManager{
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(YwFileManager.class);
    
    //private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

    private YwFileDao ywFileDao ;
    public void setYwFileDao(YwFileDao baseDao)
    {
        this.ywFileDao = baseDao;
        setBaseDao(this.ywFileDao);
    }
    
}


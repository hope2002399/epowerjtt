package com.centit.powerruntime.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.Suppowerstuffinfo;
import com.centit.powerruntime.po.YwFile;
import com.centit.powerruntime.po.YwFiles;
import com.centit.powerruntime.dao.YwFileDao;
import com.centit.powerruntime.dao.YwFilesDao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.YwFileManager;
import com.centit.powerruntime.service.YwFilesManager;

public class YwFilesManagerImpl extends BaseEntityManagerImpl<YwFiles>
	implements YwFilesManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(YwFileManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private YwFilesDao ywFilesDao ;
	public void setYwFilesDao(YwFilesDao baseDao)
	{
		this.ywFilesDao = baseDao;
		setBaseDao(this.ywFilesDao);
	}
    @Override
    public List<YwFiles> getinfosByGroupId(String groupid) {
        // TODO Auto-generated method stub
        return ywFilesDao.getinfosByGroupId(groupid);
    }
    @Override
    public String getNextKey() {
        // TODO Auto-generated method stub
        return ywFilesDao.getNextKeyBySequence("S_STUFFINFO", 10);
    }
}


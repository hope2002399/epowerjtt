package com.centit.indicator.service.impl;


import java.util.List;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmIndexTypeLog;
import com.centit.indicator.dao.PmIndexTypeLogDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmIndexTypeLogManager;

public class PmIndexTypeLogManagerImpl extends BaseEntityManagerImpl<PmIndexTypeLog>
	implements PmIndexTypeLogManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmIndexTypeLogManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmIndexTypeLogDao pmIndexTypeLogDao ;
	public void setPmIndexTypeLogDao(PmIndexTypeLogDao baseDao)
	{
		this.pmIndexTypeLogDao = baseDao;
		setBaseDao(this.pmIndexTypeLogDao);
	}
	@Override
	public PmIndexTypeLog getLogByTempId(String templatId, String indicatorId) {
		// TODO Auto-generated method stub
		String hql="From PmIndexTypeLog t where t.templetId='"+templatId+"' and t.indicatorId='"+indicatorId+"'";
		List<PmIndexTypeLog> logs=pmIndexTypeLogDao.listObjects(hql);
		if(logs!=null&&logs.size()>0){
			return logs.get(0);
		}
		return null;
	}
	
}


package com.centit.indicator.service.impl;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmIndexExpression;
import com.centit.indicator.dao.PmIndexExpressionDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmIndexExpressionManager;

public class PmIndexExpressionManagerImpl extends BaseEntityManagerImpl<PmIndexExpression>
	implements PmIndexExpressionManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmIndexExpressionManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmIndexExpressionDao pmIndexExpressionDao ;
	public void setPmIndexExpressionDao(PmIndexExpressionDao baseDao)
	{
		this.pmIndexExpressionDao = baseDao;
		setBaseDao(this.pmIndexExpressionDao);
	}
	
}


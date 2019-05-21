package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdtj;
import com.centit.powerruntime.dao.QlQdtjDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdtjManager;

public class QlQdtjManagerImpl extends BaseEntityManagerImpl<QlQdtj>
	implements QlQdtjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdtjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdtjDao qlQdtjDao ;
	public void setQlQdtjDao(QlQdtjDao baseDao)
	{
		this.qlQdtjDao = baseDao;
		setBaseDao(this.qlQdtjDao);
	}
    @Override
    public List<QlQdtj> listQlQdtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdtj> qlQdtjs = qlQdtjDao.listObjects();
        return qlQdtjs;
    }
	
}


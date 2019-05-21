package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdtj;
import com.centit.powerruntime.po.QlQdywtj;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.dao.QlQdtjDao;
import com.centit.powerruntime.dao.QlQdywtjDao;
import com.centit.powerruntime.dao.QlQdzxtjDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdtjManager;
import com.centit.powerruntime.service.QlQdywtjManager;
import com.centit.powerruntime.service.QlQdzxtjManager;

public class QlQdywtjManagerImpl extends BaseEntityManagerImpl<QlQdywtj>
	implements QlQdywtjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdywtjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdywtjDao qlQdywtjDao ;
	public void setQlQdywtjDao(QlQdywtjDao baseDao)
	{
		this.qlQdywtjDao = baseDao;
		setBaseDao(this.qlQdywtjDao);
	}
    @Override
    public List<QlQdywtj> listQlQdywtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdywtj> qlQdywtjs = qlQdywtjDao.listObjects();
        return qlQdywtjs;
    }
	
}


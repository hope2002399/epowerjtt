package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdsjsttj;
import com.centit.powerruntime.dao.QlQdsjsttjDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdsjsttjManager;

public class QlQdsjsttjManagerImpl extends BaseEntityManagerImpl<QlQdsjsttj>
	implements QlQdsjsttjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdsjsttjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdsjsttjDao qlQdsjsttjDao ;
	public void setQlQdsjsttjDao(QlQdsjsttjDao baseDao)
	{
		this.qlQdsjsttjDao = baseDao;
		setBaseDao(this.qlQdsjsttjDao);
	}
    @Override
    public List<QlQdsjsttj> listQlQdsjsttj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdsjsttj> qlQdsjsttjs = qlQdsjsttjDao.listObjects();
        return qlQdsjsttjs;
    }
	
}


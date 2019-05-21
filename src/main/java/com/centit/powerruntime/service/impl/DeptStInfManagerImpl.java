package com.centit.powerruntime.service.impl;


import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.DeptStInf;
import com.centit.powerruntime.dao.DeptQlInfDao;
import com.centit.powerruntime.dao.DeptStInfDao;
import com.centit.powerruntime.dao.DeptYwInfDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.DeptQlInfManager;
import com.centit.powerruntime.service.DeptStInfManager;

public class DeptStInfManagerImpl extends BaseEntityManagerImpl<DeptStInf>
	implements DeptStInfManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(DeptStInfManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private DeptStInfDao deptStInfDao ;
    public void setDeptStInfDao(DeptStInfDao baseDao)
    {
        this.deptStInfDao = baseDao;
        setBaseDao(this.deptStInfDao);
    }
    @Override
    public List<DeptStInf> getDepQlInflist(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        // TODO Auto-generated method stub
        if("1".equals(filterMap.get("qlKind"))){
            filterMap.put("qlKind", "01");
        }
        return deptStInfDao.listObjects(filterMap, pageDesc);
    }	
}


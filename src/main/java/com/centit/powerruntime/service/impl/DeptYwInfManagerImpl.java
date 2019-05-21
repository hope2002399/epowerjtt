package com.centit.powerruntime.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.po.DeptYwInfExpand;
import com.centit.powerruntime.po.YwFile;
import com.centit.powerruntime.dao.DeptQlInfDao;
import com.centit.powerruntime.dao.DeptYwInfDao;
import com.centit.powerruntime.dao.DeptYwInfExpandDao;
import com.centit.powerruntime.dao.YwFileDao;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.DeptYwInfManager;
import com.centit.powerruntime.service.YwFileManager;
import com.centit.sys.service.CodeRepositoryUtil;

public class DeptYwInfManagerImpl extends BaseEntityManagerImpl<DeptYwInf>
	implements DeptYwInfManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(DeptYwInfManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private DeptYwInfDao deptYwInfDao ;
	private YwFileDao ywFileDao;
	private DeptQlInfDao deptQlInfDao;
	private DeptYwInfExpandDao deptYwInfExpandDao;
	
	
    public void setDeptYwInfExpandDao(DeptYwInfExpandDao deptYwInfExpandDao) {
        this.deptYwInfExpandDao = deptYwInfExpandDao;
    }
    public void setDeptQlInfDao(DeptQlInfDao deptQlInfDao) {
        this.deptQlInfDao = deptQlInfDao;
    }
    public void setYwFileDao(YwFileDao ywFileDao) {
        this.ywFileDao = ywFileDao;
    }
    public void setDeptYwInfDao(DeptYwInfDao baseDao)
	{
		this.deptYwInfDao = baseDao;
		setBaseDao(this.deptYwInfDao);
	}
    @Override
    public DeptYwInf getDeptYwInfById(String iddeptYwInf) {
        // TODO Auto-generated method stub
      /*  iddeptYwInf = "208e6e15db734bab9315ba0ca8df2beb";*/
        DeptYwInf deptYwInf = deptYwInfDao.getObjectById(iddeptYwInf);
        if(!StringUtils.isBlank(deptYwInf.getResultFileUrl())){
            deptYwInf.setResultFileName(deptYwInf.getResultFileUrl().substring(deptYwInf.getResultFileUrl().lastIndexOf("/")+1, deptYwInf.getResultFileUrl().length()));
            deptYwInf.setResultFileUrl("http://www.jszwfw.gov.cn/GovQlfile/"+deptYwInf.getResultFileUrl().substring(deptYwInf.getResultFileUrl().indexOf("3"), deptYwInf.getResultFileUrl().length()));
        }
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("deptYwId", iddeptYwInf);
        filterMap.put("update_type", "3");
        List<YwFile> ywFiles = ywFileDao.listObjects(filterMap);
        for (YwFile ywFile : ywFiles) {
            if(!StringUtils.isBlank(ywFile.getSourceFileUrl())){
                ywFile.setSourceFileUrl("http://www.jszwfw.gov.cn/GovQlfile/"+ywFile.getSourceFileUrl().substring(ywFile.getSourceFileUrl().indexOf("3"), ywFile.getSourceFileUrl().length()));
            }
            if(!StringUtils.isBlank(ywFile.getFileSource())){
                ywFile.setFileSourceName(CodeRepositoryUtil.getValue("FILE_SOURCE", ywFile.getFileSource()));
            }else{
                ywFile.setFileSourceName("无");
            }
            
        }
        deptYwInf.setYwFiles(ywFiles);;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("iddeptYwInf", iddeptYwInf);
        List<DeptYwInfExpand> deptYwInfExpands = deptYwInfExpandDao.listObjects(map);
        if(deptYwInfExpands != null){
            if(deptYwInfExpands.size() > 0){
                deptYwInf.setDaoXcNum(deptYwInfExpands.get(0).getDaoXcNum());
            }
        }
        return deptYwInf;
    }
	
}


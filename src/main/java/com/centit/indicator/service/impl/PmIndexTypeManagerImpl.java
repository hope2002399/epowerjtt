package com.centit.indicator.service.impl;

import java.util.List;

import com.centit.app.util.UidUtil;
import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmIndexBasic;
import com.centit.indicator.po.PmIndexType;
import com.centit.indicator.po.PmIndexTypeLog;
import com.centit.indicator.dao.PmIndexBasicDao;
import com.centit.indicator.dao.PmIndexTypeDao;
import com.centit.indicator.dao.PmIndexTypeLogDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmIndexTypeManager;

public class PmIndexTypeManagerImpl extends BaseEntityManagerImpl<PmIndexType>
	implements PmIndexTypeManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmIndexTypeManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmIndexTypeDao pmIndexTypeDao ;
	private PmIndexTypeLogDao pmIndexTypeLogDao ;
	private PmIndexBasicDao pmIndexBasicDao ;
	public void setPmIndexTypeDao(PmIndexTypeDao baseDao)
	{
		this.pmIndexTypeDao = baseDao;
		setBaseDao(this.pmIndexTypeDao);
	}
	@Override
	public void saveLog(PmIndexType pmIndexType){
		// TODO Auto-generated method stub
//		pmIndexTypeDao.saveObject(pmIndexType);
		PmIndexTypeLog pmIndexTypeLog=new PmIndexTypeLog();
		pmIndexTypeLog.copyNotNullProperty(pmIndexType);
		pmIndexTypeLogDao.save(pmIndexTypeLog);
	}
	
	@Override
	public void saveBasic(List<PmIndexBasic> pmIndexBasics){
		if(pmIndexBasics!=null&&pmIndexBasics.size()>0){
			for(PmIndexBasic basic:pmIndexBasics){
				pmIndexBasicDao.saveObject(basic);
			}
		}
	}
	public void setPmIndexBasicDao(PmIndexBasicDao pmIndexBasicDao) {
		this.pmIndexBasicDao = pmIndexBasicDao;
	}
	public void setPmIndexTypeLogDao(PmIndexTypeLogDao pmIndexTypeLogDao) {
		this.pmIndexTypeLogDao = pmIndexTypeLogDao;
	}
	@Override
	public void saveIndexFromLog(String templetId) {
		// TODO Auto-generated method stub
		//1.从log中迁出当前模板templetId所有参与测评的数据
		String hql="From PmIndexTypeLog t where t.templetId='"+templetId+"'";
		List<PmIndexTypeLog> logs=pmIndexTypeLogDao.listObjects(hql);
		if(logs!=null&&logs.size()>0){
			for(PmIndexTypeLog log :logs){
				PmIndexType type=new PmIndexType();
				type.copyNotNullProperty(log);
				pmIndexTypeDao.saveObject(type);
			}
		}
		//2.删除log中的无用数据
		String delhql="delete from pm_Index_Type_Log where templet_Id='"+templetId+"'";// or templet_id not in (select templet_id )
		pmIndexTypeLogDao.doExecuteSql(delhql);
		//3.删除basic中的冗余数据
		String basicdel="delete From Pm_Index_Basic where index_Id  not in (select index_id from pm_index_type) and index_id not in ( select index_id from pm_index_type_log)";
		pmIndexBasicDao.doExecuteSql(basicdel);
	}
	@Override
	public void copyIndex(String nowtempletId, String oldtempletId) {
		// TODO Auto-generated method stub
		String hql="From PmIndexType t where t.templetId='"+oldtempletId+"'";
		List<PmIndexType> logs=pmIndexTypeDao.listObjects(hql);
		if(logs!=null&&logs.size()>0){
			for(PmIndexType log :logs){
				PmIndexTypeLog typeLog=new PmIndexTypeLog();
				typeLog.copyNotNullProperty(log);
				typeLog.setTempletId(nowtempletId);
				typeLog.setIndexId(UidUtil.getUID());
				String hql1="Form PmIndexBasic t where t.indexId ='"+log.getIndexId()+"'";
				List<PmIndexBasic> basics=pmIndexBasicDao.listObjects(hql1);
				if(basics!=null&&basics.size()>0){
					for(PmIndexBasic basic:basics){
						basic.setIndexId(typeLog.getIndexId());
						pmIndexBasicDao.saveObject(basic);
					}
				}
				pmIndexTypeLogDao.saveObject(typeLog);
			}
		}
		
	}
	
}


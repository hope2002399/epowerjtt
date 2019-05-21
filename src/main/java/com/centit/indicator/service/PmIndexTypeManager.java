package com.centit.indicator.service;

import java.util.List;

import com.centit.core.service.BaseEntityManager;
import com.centit.indicator.po.PmIndexBasic;
import com.centit.indicator.po.PmIndexType;

public interface PmIndexTypeManager extends BaseEntityManager<PmIndexType> 
{
	public void saveLog(PmIndexType pmIndexType);
	
	public void saveIndexFromLog(String templetId);
	
	public void copyIndex(String nowtempletId,String oldtempletId);
	
	public void saveBasic(List<PmIndexBasic> pmIndexBasics);
}

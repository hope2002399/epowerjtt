package com.centit.indicator.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.app.util.UidUtil;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.indicator.po.PmIndexBasic;
import com.centit.indicator.po.PmIndexType;
import com.centit.indicator.po.PmIndexTypeLog;
import com.centit.indicator.po.PmIndicator;
import com.centit.indicator.service.PmIndexTypeLogManager;
import com.centit.indicator.service.PmIndexTypeManager;
import com.centit.indicator.service.PmIndicatorManager;
import com.centit.support.utils.StringBaseOpt;

public class PmIndexTypeAction  extends BaseEntityExtremeAction<PmIndexType>  {
	private static final Log log = LogFactory.getLog(PmIndexTypeAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmIndexTypeManager pmIndexTypeMag;
	private PmIndexTypeLogManager pmIndexTypeLogManager;
	private PmIndicatorManager pmIndicatorManager;
	public void setPmIndexTypeManager(PmIndexTypeManager basemgr)
	{
		pmIndexTypeMag = basemgr;
		this.setBaseEntityManager(pmIndexTypeMag);
	}

	private List<PmIndexBasic> pmIndexBasics;
	public List<PmIndexBasic> getNewPmIndexBasics() {
		return this.pmIndexBasics;
	}
	public void setNewPmIndexBasics(List<PmIndexBasic> pmIndexBasics) {
		this.pmIndexBasics = pmIndexBasics;
	}
	public String calType(){
		Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        filterMap.put("templetId",object.getTempletId());
        filterMap.put("indicatorId",object.getIndicatorId());
        PmIndexTypeLog typelog=pmIndexTypeLogManager.getLogByTempId(object.getTempletId(), object.getIndicatorId());
    	if(typelog!=null){
    		object.copyNotNullProperty(typelog);
    		object.setPmIndexBasics(typelog.getPmIndexBasics());
    	}
    	else 
	        objList=pmIndexTypeMag.listObjects(filterMap);
	        if(objList!=null&&objList.size()>0){
	        	object=objList.get(0);
	        }
	    PmIndicator indicator=pmIndicatorManager.getObjectById(object.getIndicatorId());
	    object.setIndicatorName(indicator.getIndicatorName());
		return "calType";
	}
	
	JSONObject result;
	public String save(){
		if(object.getIndexId()==null||object.getIndexId().equals("")){
			object.setIndexId(UidUtil.getUID());
		}
		result=new JSONObject(); 
		result.put("flag", "F");
		pmIndexBasics=new ArrayList<PmIndexBasic>();
		if(object.getEvlType().equals("02")){//区间计算
			    String[] grade = request.getParameterValues("grade1");
			    String[] rangeId = request.getParameterValues("rangeId1");
			    String[] leftRange = request.getParameterValues("leftRange");
			    String[] rightRange = request.getParameterValues("rightRange");
				if(grade!=null&&grade.length>0){
					PmIndexBasic pmIndexBasic=new PmIndexBasic();
					for(int i=0;i<grade.length;i++){
						if(!StringBaseOpt.isNvl(grade[i])||!StringBaseOpt.isNvl(leftRange[i])||!StringBaseOpt.isNvl(rightRange[i])){
							pmIndexBasic.setGrade(Double.parseDouble(grade[i]));
							pmIndexBasic.setLeftRange(Double.parseDouble(leftRange[i]));
							pmIndexBasic.setRightRange(Double.parseDouble(rightRange[i]));
							if(StringUtils.isBlank(rangeId[i])){
								rangeId[i]=UidUtil.getUID();
							}
							pmIndexBasic.setRangeId(rangeId[i]);
							pmIndexBasic.setIndexId(object.getIndexId());
						    pmIndexBasics.add(pmIndexBasic);
						}
					}
			}
		}
		if(object.getEvlType().equals("03")){//数据字典
			String[] grade = request.getParameterValues("grade2");
		    String[] rangeId = request.getParameterValues("rangeId2");
		    String[] dictvalue = request.getParameterValues("dictvalue");
			if(grade!=null&&grade.length>0){
				for(int i=0;i<grade.length;i++){
					PmIndexBasic pmIndexBasic=new PmIndexBasic();
					if(!StringBaseOpt.isNvl(grade[i])||!StringBaseOpt.isNvl(dictvalue[i])){
					pmIndexBasic.setGrade(Double.parseDouble(grade[i]));
					if(rangeId[i]==null ||rangeId[i].equals("")){
						rangeId[i]=UidUtil.getUID();
					}
					pmIndexBasic.setDictvalue(dictvalue[i]);
					pmIndexBasic.setRangeId(rangeId[i]);
					pmIndexBasic.setIndexId(object.getIndexId());
					pmIndexBasics.add(pmIndexBasic);
					}
			}
			}
		}
		this.pmIndexTypeMag.saveLog(object);
		this.pmIndexTypeMag.saveBasic(pmIndexBasics);
		result.put("flag", "T");
		return "save";
	}
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
	public void setPmIndexTypeLogManager(PmIndexTypeLogManager pmIndexTypeLogManager) {
		this.pmIndexTypeLogManager = pmIndexTypeLogManager;
	}
	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}
	public void setPmIndicatorManager(PmIndicatorManager pmIndicatorManager) {
		this.pmIndicatorManager = pmIndicatorManager;
	}
	
}

package com.centit.indicator.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.indicator.po.PmIndexExpression;
import com.centit.indicator.po.PmNode;
import com.centit.indicator.po.PmTemplet;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	

import com.centit.app.util.UidUtil;
import com.centit.core.action.BaseEntityExtremeAction;

		

import com.centit.indicator.service.PmIndexExpressionManager;
import com.centit.indicator.service.PmTempletManager;
	

public class PmIndexExpressionAction  extends BaseEntityExtremeAction<PmIndexExpression>  {
	private static final Log log = LogFactory.getLog(PmIndexExpressionAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmIndexExpressionManager pmIndexExpressionMag;
	private PmTempletManager pmTempletManager;
	private List<PmNode> nowIndicators;
	private InputStream inputStream;
	public void setPmIndexExpressionManager(PmIndexExpressionManager basemgr)
	{
		pmIndexExpressionMag = basemgr;
		this.setBaseEntityManager(pmIndexExpressionMag);
	}

	
	public String evlExpression(){
		PmTemplet pmTemplet=new PmTemplet();
		Map<String, Object> filterMap=new HashMap<String, Object>();
		super.edit();
		if(object!=null&&object.getTempletId()!=null&&!"".equals(object.getTempletId())){
			pmTemplet=pmTempletManager.getObjectById(object.getTempletId());
			nowIndicators=pmTempletManager.getEvlIndicators(object.getTempletId());
		}
		JSONObject json=new JSONObject();
		json.put("expression", object);
		json.put("templet", pmTemplet);
		json.put("nowIndicators", nowIndicators);
		try {
			this.setInputStream(new ByteArrayInputStream(json.toString()
					.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "evlExpression";
	}
		
	public String save(){
		super.save();
		return "success";
	}
	
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}


	public List<PmNode> getNowIndicators() {
		return nowIndicators;
	}


	public void setNowIndicators(List<PmNode> nowIndicators) {
		this.nowIndicators = nowIndicators;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public void setPmTempletManager(PmTempletManager pmTempletManager) {
		this.pmTempletManager = pmTempletManager;
	}


}

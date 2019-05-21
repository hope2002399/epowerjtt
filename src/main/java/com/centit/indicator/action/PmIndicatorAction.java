package com.centit.indicator.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.app.util.UidUtil;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.indicator.po.PmIndicator;
import com.centit.indicator.service.PmIndicatorManager;
import com.centit.sys.security.FUserDetail;
public class PmIndicatorAction  extends BaseEntityExtremeAction<PmIndicator>  {
	
	/*********************************************************参数***************************************************/
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(PmIndicatorAction.class);
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	private static final long serialVersionUID = 1L;
	private PmIndicatorManager pmIndicatorMag;
    private InputStream inputStream;
	
	private String nodesStr;

	/*********************************************************方法***************************************************/
	
	public String indicatorList() {
//		nodesStr=pmIndicatorMag.indicatorList();
		objList=pmIndicatorMag.listObjects();
		JSONObject json=new JSONObject();
		json.put("json", objList);
		request.setAttribute("json", json);
		return "indicatorList";
	}
	
	public String indicatorListJson() {
//		nodesStr=pmIndicatorMag.indicatorList();
		objList=pmIndicatorMag.listObjects();
		JSONObject json=new JSONObject();
		json.put("json", objList);
		try {
	        this.setInputStream(new ByteArrayInputStream(json.toString()
	                .getBytes("UTF-8")));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		return "indicatorListJson";
	}	 
	public String indicatorEdit() {
		
		return "indicatorEdit";
	}	
	public String indicatorSave() {
		boolean flag=false;
		String msg="";
		PmIndicator p=null;
		if(object!=null&&object.getIndicatorId()!=null&&!"".equals(object.getIndicatorId())){
			p=pmIndicatorMag.getObjectById(object.getIndicatorId());
		}
		if(p==null){
			p=new PmIndicator();
			p.copyNotNullProperty(object);
			p.setIndicatorId(UidUtil.getUID());
		}else{
			p.copyNotNullProperty(object);
		}
		FUserDetail user=(FUserDetail)getLoginUser();
		p.setCreateBy(user.getUsercode());
		p.setCreateTime(new Date());
		try {
			pmIndicatorMag.saveObject(p);
			flag=true;
		} catch (Exception e1) {
			flag=false;
			msg="添加失败！";
			e1.printStackTrace();
		}
		JSONObject json=new JSONObject();
		json.put("flag", flag);
		json.put("mag", msg);
		json.put("indicator", p);
		try {
	        this.setInputStream(new ByteArrayInputStream(json.toString()
	                .getBytes("UTF-8")));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		return "indicatorSave";
	}
	public String indicatorView() {
	    return "indicatorView";
	}
	public String indicatorDel() {
	    super.delete();      
	    return "indicatorDel";
	}
	
	/*********************************************************封装***************************************************/
	
	public void setPmIndicatorManager(PmIndicatorManager basemgr){
		pmIndicatorMag = basemgr;
		this.setBaseEntityManager(pmIndicatorMag);
	}
	public String getNodesStr() {
		return nodesStr;
	}
	public void setNodesStr(String nodesStr) {
		this.nodesStr = nodesStr;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}

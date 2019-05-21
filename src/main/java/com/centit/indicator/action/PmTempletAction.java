package com.centit.indicator.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.extremecomponents.table.limit.Limit;

import com.centit.app.util.UidUtil;
import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.indicator.po.PmIndicator;
import com.centit.indicator.po.PmNode;
import com.centit.indicator.po.PmTemplet;
import com.centit.indicator.po.PmTempletIndicator;
import com.centit.indicator.po.PmTempletIndicatorId;
import com.centit.indicator.service.PmIndexTypeManager;
import com.centit.indicator.service.PmIndicatorManager;
import com.centit.indicator.service.PmTempletIndicatorManager;
import com.centit.indicator.service.PmTempletManager;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryManager;
import com.centit.sys.service.CodeRepositoryUtil;

public class PmTempletAction  extends BaseEntityExtremeAction<PmTemplet>  {
	@SuppressWarnings("unused")
	/*********************************************************参数***************************************************/
	private static final Log log = LogFactory.getLog(PmTempletAction.class);
	
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private PmTempletManager pmTempletMag;
	private PmTempletIndicatorManager pmTempletIndicatorManager;
	private CodeRepositoryManager codeRepo;
	private PmIndicatorManager pmIndicatorManager;  
	private List<PmNode> nowIndicators;
	private List<PmIndicator> allIndicators;
	private List<PmIndicator> newIndicators;
    private InputStream inputStream;
    private String nodesJson;
	private PmIndexTypeManager pmIndexTypeManager;
	private SuppowerManager suppowerManager;
	private List<Suppower> suppowers; 
	
	public List<Suppower> getSuppowers() {
        return suppowers;
    }
    public void setSuppowers(List<Suppower> suppowers) {
        this.suppowers = suppowers;
    }
    /*********************************************************方法***************************************************/
	
	public String indicatorList(){
		return "indicatorList";
	}
	public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }
    public String templetList(){
        @SuppressWarnings("unchecked")
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        objList = pmTempletMag.listObjects(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
		return "templetList";
	}
	public String temType(){
        String orgId = request.getParameter("orgId");
        Map<String, Object> filterMap = new HashMap<String, Object>();
        String shql = "from Suppower t where  t.itemType='XK' and t.orgId like 'JS000000%'";
        /*String shql = "from Suppower t where  t.itemType='XK' and t.orgId='"+orgId+"'";*/
        suppowers = suppowerManager.listObjects(shql, filterMap);
        JSONArray json = new JSONArray();
        for (Suppower suppower : suppowers) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("itemId", suppower.getItemId());
            jsonObject.put("itemName", suppower.getItemName());
            json.add(jsonObject);
        }
        try {
            this.setInputStream(new ByteArrayInputStream(json.toString()
                    .getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "temType";
    }
	public String templetEdit(){
		Map<String, Object> filterMap=new HashMap<String, Object>();
		//if(object!=null&&object.getTempletId()!=null&&!"".equals(object.getTempletId())){
		String templetId = request.getParameter("templetId");
		if(templetId!=null&&!"".equals(templetId)){
			object=pmTempletMag.getObjectById(object.getTempletId());
			String hql="from PmIndicator ic where 1=1 ";
			nowIndicators=pmTempletMag.getIndicators(object.getTempletId());
			allIndicators=pmIndicatorManager.listObjects(hql+" and ic.indicatorId not in (select ti.cid.indicatorId from PmTempletIndicator ti where ti.cid.templetId='"+object.getTempletId()+"')", filterMap);
			if(object!=null&&object.getReleaseFlag()!=null&&!object.getReleaseFlag().equals("X")){//对已有的进行复制
				object.setTempletId(UidUtil.getUID());//重新生成新的主键
				//讲参与评测字段以及评测方式一并复制。
//				pmIndexTypeManager.copyIndex(object.getTempletId(), oldtempletId);
			}
		}else{
			object.setTempletId(UidUtil.getUID());
			allIndicators=pmIndicatorManager.listObjects();
		}
		JSONObject json=new JSONObject();
		json.put("templet", object);
		json.put("nowIndicators", nowIndicators);
		json.put("allIndicators", allIndicators);
		try {
	        this.setInputStream(new ByteArrayInputStream(json.toString()
	                .getBytes("UTF-8")));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		return "templetEdit";
	}
	
	public String startOrStop(){
		object=pmTempletMag.getObjectById(object.getTempletId());
		if(object.getReleaseFlag()!=null&&object.getReleaseFlag().equals("T")){
			object.setReleaseFlag("F");
		}else{
			Map<String, Object> filterMap=new HashMap<String, Object>();
			filterMap.put("releaseFlag", "T");
			filterMap.put("templetType", object.getTempletType());
			objList=pmTempletMag.listObjects(filterMap);
			if(objList!=null&&objList.size()>0){
				for (int i = 0; i < objList.size(); i++) {
					objList.get(i).setReleaseFlag("F");
					pmTempletMag.saveObject(objList.get(i));
				}
			}
			object.setReleaseFlag("T");
			 FDatadictionary fd=CodeRepositoryUtil.getDataPiece("PM_TEMPLETTYPE", object.getTempletType());
//			 FDatadictionary hiddenCode=CodeRepositoryUtil.getDataPiece("PM_TEMP_HIDE", object.getTempletType());
			nowIndicators=pmTempletMag.getIndicators(object.getTempletId());
			int result=pmTempletMag.compileClass(nowIndicators, fd);
//			PmProvinceProject p=new PmProvinceProject();
		}
		pmTempletMag.saveObject(object);
		templetList();
		codeRepo.refreshAll();
		return "startOrStop";
	}
	public String templetView(){
		this.templetEdit();
		return "templetView";
	}
	public String templetDel(){
		
		return "templetDel";
	}
	
	
	public String templetSave(){
		boolean flag=false;
		if(object!=null&&object.getTempletId()!=null&&!"".equals(object.getTempletId())){
			PmTemplet p=pmTempletMag.getObjectById(object.getTempletId());
			if(p==null||(p!=null&&StringUtils.isBlank(p.getVersion()))){//对已有的进行复制
//				object.setTempletId(UidUtil.getUID());
				int version=getVersion();//版本号
				object.setVersion(version+"");
				flag=true;
			}
			else{ //修改的话，不修改version
				this.pmTempletMag.copyObjectNotNullProperty(p, object);
				object=p;
			}
		}else{
			try {
//				object.setTempletId(UidUtil.getUID());
				flag=true;
			} catch (Exception e) {
				flag=false;
			}
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("/");
		try {
			// 通过json解析并得到模版指标集合 保存
			//if (flag) {
				//pmTempletMag.generateTempletFile(nodesJson, path + "test.jsp", path + "WEB-INF/classes");
			
				pmTempletMag.generateTempletFile(nodesJson, path + "/templets",
						pmTempletMag.getJspFileName(object), object.getTempletName());
			//}
			object.setJspHtml(nodesJson);
			JSONArray arr = (JSONArray) JSONSerializer.toJSON(nodesJson);
			List<PmTempletIndicator> tiList=new ArrayList<PmTempletIndicator>();
			setTempletIndicators(arr, tiList, object.getTempletId());
			object.setReleaseFlag("X");
			FUserDetail fuser = ((FUserDetail) getLoginUser());
			object.setCreateBy(fuser.getUsercode());
			object.setCreateTime(new Date());
			/*pmTempletMag.saveObject(object);
			if(tiList!=null&&tiList.size()>0){
				for (int i = 0; i < tiList.size(); i++) {
					pmTempletIndicatorManager.saveObject(tiList.get(i));
				}
			}*/
			pmTempletMag.saveObject(object,tiList);//多包涵一个删除操作，以保证数据数据输出时，还存在
			saveIndexType();
			flag=true;
		} catch (Exception e1) {
			System.out.println("Create Jsp Error!!!!");
			flag=false;
		}
		JSONObject json=new JSONObject();
		//json.put("jspFileName", pmTempletMag.getJspFileName(object));
		//json.put("formName", object.getTempletName());
		json.put("templetId", object.getTempletId());
		json.put("flag", flag);;
		//json.put("path", path + "test.jsp");
		try {
	        this.setInputStream(new ByteArrayInputStream(json.toString()
	                .getBytes("UTF-8")));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		return "templetSave";
	}

	public String compose(){
		PmTemplet templet = pmTempletMag.getObjectById(request.getParameter("templetId"));
		if (templet!=null) {
			/*StringBuffer gotoUrl = new StringBuffer("/templets/jsp/")
								.append(request.getParameter("jspFileName"))
								.append("Compose.jsp")
								.append("?jspFileName=").append(request.getParameter("jspFileName"))
								.append("&formName=").append(request.getParameter("formName"));*/
			String basePath = request.getSession().getServletContext().getRealPath("/");
			if (!pmTempletMag.checkJspFile(templet, basePath))
				return ERROR;
			
			String jspFileName = pmTempletMag.getJspFileName(templet);
			StringBuffer gotoUrl = new StringBuffer("/templets/jsp/")
					.append(jspFileName).append("Compose.jsp")
					.append("?jspFileName=").append(jspFileName)
					.append("&formName=").append(templet.getTempletName());
			request.setAttribute("gotoUrl", gotoUrl);
		}
		else
			return ERROR;
		
		return "gotoCompose";
	}
	
	public String saveJsp() {
		//System.out.print(p);
		String[] ps = request.getParameterValues("p[]");
		String json = sortJSONArray(nodesJson, ps);

		String path = request.getSession().getServletContext().getRealPath("/");
		pmTempletMag.generateTempletFile(json, path + "/templets",
				request.getParameter("jspFileName"), request.getParameter("formName"));
		
		JSONObject returnJson=new JSONObject();
		//returnJson.put("composeJspName", getJspFileName(true));
		try {
	        this.setInputStream(new ByteArrayInputStream(returnJson.toString()
	                .getBytes("UTF-8")));
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
		
		return "";
	}
	
	public String editFile() {
		PmTemplet templet = pmTempletMag.getObjectById(request.getParameter("templetId"));
		if (templet == null)
			return ERROR;
		
		String basePath = request.getSession().getServletContext().getRealPath("/");
		if (!pmTempletMag.checkJspFile(templet, basePath))
			return ERROR;
		
		String jspFileName = pmTempletMag.getJspFileName(templet);
		String filePath = "\\templets\\jsp\\" + jspFileName + "Form.jsp";
		
		request.setAttribute("filePath", filePath);
		
		String fileContent = readFile(basePath + filePath);
		request.setAttribute("fileContent", fileContent);
		
		return "fileEditer";
	}
	
	public String saveFile() {
		String fileContent = request.getParameter("fileContent");
		
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String filePath = request.getParameter("filePath");
		
		File file = new File(basePath + filePath );// 要写入的文本文件  
		try {
	        if (!file.exists()) {// 如果文件不存在，则创建该文件  
	            file.createNewFile();  
	        }  
	        FileWriter writer;
			writer = new FileWriter(file);
	        writer.write(fileContent);// 写内容  
	        writer.flush();// 清空缓冲区，立即将输出流里的内容写到文件里  
	        writer.close();// 关闭输出流，施放资源 
	        
	        request.setAttribute("result", "OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	        request.setAttribute("result", "ERROR");
			request.setAttribute("filePath", filePath);
			request.setAttribute("fileContent", fileContent);
		}
		
		return "fileEditer";
	}
	
	private String sortJSONArray(String jsonString, String[] orders) {
		JSONArray arr = (JSONArray) JSONSerializer.toJSON(jsonString);
		for (int i = 0; i < arr.size(); i++) {
			JSONObject jObject = arr.getJSONObject(i);
			jObject.put("order", -1);
			try {
				String children = jObject.getString("children");
				if(children!=null&&!"".equals(children)){
					jObject.put("children", sortJSONArray(children, orders));
				}
			} catch (Exception e) {
			}
			
			String nickName = jObject.get("indicatorNickName").toString();
			for (int j = 0; j < orders.length; j++) {
				if (orders[j].startsWith(nickName+"_")) {
					jObject.put("order", j);
					break;
				}
			}
		}
		
		return arr.toString();
	}
	
	public String readFile(String path){
	    File file = new File(path);
	    BufferedReader reader = null;
	    String laststr = "";
	    try {
	    	//System.out.println("以行为单位读取文件内容，一次读一整行：");
	    	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			//int line = 1;
			//一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				laststr = laststr + tempString + "\r\n";
				//显示行号
				//System.out.println("line " + line + ": " + tempString);
				//line++;
			}
			reader.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	if (reader != null) {
	    		try {
	    			reader.close();
	    		} catch (IOException e1) {
	    		}
	    	}
	    }
	    return laststr;
	}
	
	//*****************************jwy*************************************//
	private void saveIndexType(){
		//indexType的数据存储在indexLog中，当当前数据正式保存数据库，讲indextypelog的数据存储到indexType
		pmIndexTypeManager.saveIndexFromLog(object.getTempletId());
	}
	//******************************jwy************************************//
	
	

	/*********************************************************私有***************************************************/
	/**
	 * 获取版本号
	 * @return
	 */
	private int getVersion(){
		return pmTempletMag.getTempletVersion(object.getTempletType());
	}
	/**
	 * 通过json获取指标模版集合
	 * @param arr
	 * @param tiList
	 * @param templetId
	 */
	private void setTempletIndicators(JSONArray arr,List<PmTempletIndicator> tiList,String templetId){
		if(arr!=null&&arr.size()>0){
			FUserDetail fuser = ((FUserDetail) getLoginUser());
			for (int i = 0; i < arr.size(); i++) {
				PmTempletIndicator pti=new PmTempletIndicator();
				pti.setCid(new PmTempletIndicatorId());
				pti.getCid().setTempletId(templetId);
				pti.getCid().setIndicatorId(arr.getJSONObject(i).getString("indicatorId"));
				try {pti.setIfHidden(arr.getJSONObject(i).getString("ifHidden"));} catch (Exception e) {}
				try {pti.setIfMust(arr.getJSONObject(i).getString("ifMust"));} catch (Exception e) {}
				try {pti.setIfInternal(arr.getJSONObject(i).getString("ifInternal"));} catch (Exception e) {}
				try {pti.setInternalTable(arr.getJSONObject(i).getString("internalTable"));} catch (Exception e) {}
				try {pti.setIfPrimary(arr.getJSONObject(i).getString("ifPrimary"));} catch (Exception e) {}
				try {pti.setIfWriteBack(arr.getJSONObject(i).getString("ifWriteBack"));} catch (Exception e) {}
				try {pti.setWriteBackTable(arr.getJSONObject(i).getString("writeBackTable"));} catch (Exception e) {}
				try {pti.setWriteBackIndicator(arr.getJSONObject(i).getString("writeBackIndicator"));} catch (Exception e) {}
				try {pti.setIfAlong(arr.getJSONObject(i).getString("ifAlong"));} catch (Exception e) {}
				try {pti.setIfCp(arr.getJSONObject(i).getString("ifCp"));} catch (Exception e) {}
				try {pti.setEvlType(arr.getJSONObject(i).getString("evlType"));} catch (Exception e) {}
				try {pti.setEvlMethod(arr.getJSONObject(i).getString("evlMethod"));} catch (Exception e) {}
				try {pti.setFatherId(arr.getJSONObject(i).getString("pId"));} catch (Exception e) {}
				pti.setIndicatorLevel(Long.parseLong(arr.getJSONObject(i).getString("level")));
				pti.setCreateTime(new Date());
				pti.setIndicatorIndex(Long.parseLong(i+""));
				pti.setCreateBy(fuser.getUsercode());
				tiList.add(pti);
//				System.out.println(tiList.size());
				try {
					JSONArray arr1=(JSONArray)JSONSerializer.toJSON(arr.getJSONObject(i).getString("children"));
					if(arr1!=null&&arr1.size()>0){
						setTempletIndicators(arr1, tiList, templetId);
					}
				} catch (Exception e) {
				}
			}
		}
	}
	
	/*********************************************************封装***************************************************/
	
	
	public void setPmTempletManager(PmTempletManager basemgr){
		pmTempletMag = basemgr;
		this.setBaseEntityManager(pmTempletMag);
	}

	public void setPmIndicatorManager(PmIndicatorManager pmIndicatorManager) {
		this.pmIndicatorManager = pmIndicatorManager;
	}

	public List<PmNode> getNowIndicators() {
		return nowIndicators;
	}

	public void setNowIndicators(List<PmNode> nowIndicators) {
		this.nowIndicators = nowIndicators;
	}

	public List<PmIndicator> getAllIndicators() {
		return allIndicators;
	}

	public void setAllIndicators(List<PmIndicator> allIndicators) {
		this.allIndicators = allIndicators;
	}

	public List<PmIndicator> getNewIndicators() {
		return newIndicators;
	}

	public void setNewIndicators(List<PmIndicator> newIndicators) {
		this.newIndicators = newIndicators;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getNodesJson() {
		return nodesJson;
	}

	public void setNodesJson(String nodesJson) {
		this.nodesJson = nodesJson;
	}

	public void setPmTempletIndicatorManager(PmTempletIndicatorManager pmTempletIndicatorManager) {
		this.pmTempletIndicatorManager = pmTempletIndicatorManager;
	}

	public void setPmIndexTypeManager(PmIndexTypeManager pmIndexTypeManager) {
		this.pmIndexTypeManager = pmIndexTypeManager;
	}

	public void setCodeRepoManager(CodeRepositoryManager crm) {
		this.codeRepo = crm;
	}
	
}

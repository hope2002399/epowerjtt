package com.centit.powerruntime.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.po.YwFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	


		













import com.centit.powerruntime.service.DeptYwInfManager;
import com.centit.powerruntime.service.YwFileManager;
import com.centit.sys.service.CodeRepositoryUtil;
	

public class DeptYwInfAction  extends BaseEntityExtremeAction<DeptYwInf>  {
	private static final Log log = LogFactory.getLog(DeptYwInfAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private DeptYwInfManager deptYwInfMag;
	/*private YwFileManager ywFileManager;
	
	public void setYwFileManager(YwFileManager ywFileManager) {
        this.ywFileManager = ywFileManager;
    }
*/
    public void setDeptYwInfManager(DeptYwInfManager basemgr)
	{
		deptYwInfMag = basemgr;
		this.setBaseEntityManager(deptYwInfMag);
	}
	
	  /**
     * 根据id查询 权利基本信息和业务子项
     * @return
	 * @throws UnsupportedEncodingException 
     */
      public String getywById() throws UnsupportedEncodingException {
          String iddeptYwInf = request.getParameter("iddeptYwInf");
          DeptYwInf deptYwInf = deptYwInfMag.getDeptYwInfById(iddeptYwInf);
          String userLevelC = request.getParameter("userLevelC"); 
          String userLevelValue = request.getParameter("userLevelValue");
          if(userLevelValue == null)
              userLevelValue = "";
          if(!StringUtils.isBlank(userLevelC)){
              //行使主体
              if(!StringUtils.isBlank(userLevelC)){
                  String[] ul = userLevelC.split(",");
                  if(ul.length > 1){
                      for (int i = 0; i < ul.length; i++) {
                          userLevelValue +=  CodeRepositoryUtil.getValue("userlevel", ul[i])+",";
                          userLevelValue=userLevelValue.substring(userLevelValue.length()-1, userLevelValue.length());
                      }
                  }else{
                          userLevelValue +=  CodeRepositoryUtil.getValue("userlevel", userLevelC);
                  }
              }
          }else{
              Boolean boolean1 = isMessyCode(userLevelValue);
              if(boolean1 == true){
                  userLevelValue = new String(userLevelValue .getBytes("iso8859-1"),"utf-8"); 
              }
          }
          // String userLevelValue = new String(request.getParameter("userLevelValue").getBytes("iso8859-1"),"UTF-8");
          //String userLevelValue = request.getParameter("userLevelValue");
         
          String actFileUrl = deptYwInf.getActFileUrl();
          if(!StringUtils.isBlank(actFileUrl)){
              actFileUrl = "http://www.jszwfw.gov.cn/GovQlfile/"+actFileUrl.substring(actFileUrl.indexOf("3"), actFileUrl.length());
          }
          //服务表格下载功能
         // deptYwInf.setServiceFileUrl("/home/Oracle/Middleware/GovQlfile/320500/320500/320500JT/0100220003/373/1服务表格下载/1_环保验收意见.jpg,/home/Oracle/Middleware/GovQlfile/320500/320500/320500JT/0100220003/373/1服务表格下载/2_能力核算报告.jpg,/home/Oracle/Middleware/GovQlfile/320500/320500/320500JT/0100220003/373/1服务表格下载/3_发改委批复文件.jpg,");
          String serviceFileUrl = deptYwInf.getServiceFileUrl();
          JSONArray jsonArray = new JSONArray();
          JSONObject jsonObject = new JSONObject();
          String [] sr = null;
          if(!StringUtils.isBlank(serviceFileUrl)){
              sr = serviceFileUrl.split(",");
              for (int i = 0; i < sr.length; i++) {
                jsonObject.put("sfrname", sr[i].substring(sr[i].lastIndexOf("/")+1, sr[i].length()));
                jsonObject.put("sfrurl", "http://www.jszwfw.gov.cn/GovQlfile/"+sr[i].substring(sr[i].indexOf("3"), sr[i].length()));
                jsonArray.add(jsonObject);
            }
          }
          request.setAttribute("sfr", jsonArray);
          request.setAttribute("userLevelValue", userLevelValue);
          request.setAttribute("actFileUrl", actFileUrl);
          if(deptYwInf != null)
          request.setAttribute("deptYwInf", deptYwInf);
          return "getywById";
      }
      /**

       * 判断字符串是否是乱码
       *
       * @param strName 字符串
       * @return 是否是乱码
       */
      public static boolean isMessyCode(String strName) {
           try {
               Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
               Matcher m = p.matcher(strName);
               String after = m.replaceAll("");
               String temp = after.replaceAll("\\p{P}", "");
               char[] ch = temp.trim().toCharArray();

               int length = (ch != null) ? ch.length : 0;
               for (int i = 0; i < length; i++) {
                   char c = ch[i];
                   if (!Character.isLetterOrDigit(c)) {
                       String str = "" + ch[i];
                       if (!str.matches("[\u4e00-\u9fa5]+")) {
                           return true;
                       }
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }

           return false;
   
      }
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}

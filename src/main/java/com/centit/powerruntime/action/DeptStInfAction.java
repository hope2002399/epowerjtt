package com.centit.powerruntime.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.AmOrg;
import com.centit.powerruntime.po.DeptQlInf;
import com.centit.powerruntime.po.DeptStInf;
import com.centit.powerruntime.po.DeptYwInf;
import com.centit.powerruntime.po.VDeptYwBmdy;
import com.centit.powerruntime.po.VDeptYwBmdy2;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.powerruntime.service.AmOrgManager;
import com.centit.powerruntime.service.DeptQlInfManager;
import com.centit.powerruntime.service.DeptStInfManager;
import com.centit.powerruntime.service.DeptYwInfManager;
import com.centit.powerruntime.service.VDeptYwBmdy2Manager;
import com.centit.powerruntime.service.VDeptYwBmdyManager;
import com.centit.powerruntime.util.Page;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
	

public class DeptStInfAction  extends BaseEntityExtremeAction<DeptStInf>  {
	private static final Log log = LogFactory.getLog(DeptStInfAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private DeptStInfManager deptStInfMag;
	private DeptQlInfManager deptQlInfManager;
	private DeptYwInfManager deptYwInfManager;
	private AmOrgManager amOrgManager;
	private VDeptYwBmdyManager vDeptYwBmdyManager;
	private VDeptYwBmdy2Manager vDeptYwBmdy2Manager;
	
	
    public void setvDeptYwBmdy2Manager(VDeptYwBmdy2Manager vDeptYwBmdy2Manager) {
        this.vDeptYwBmdy2Manager = vDeptYwBmdy2Manager;
    }
    public void setvDeptYwBmdyManager(VDeptYwBmdyManager vDeptYwBmdyManager) {
        this.vDeptYwBmdyManager = vDeptYwBmdyManager;
    }
    public void setAmOrgManager(AmOrgManager amOrgManager) {
        this.amOrgManager = amOrgManager;
    }
    public void setDeptYwInfManager(DeptYwInfManager deptYwInfManager) {
        this.deptYwInfManager = deptYwInfManager;
    }
    public void setDeptQlInfManager(DeptQlInfManager deptQlInfManager) {
        this.deptQlInfManager = deptQlInfManager;
    }

    private JSONObject result = new JSONObject();
	
    public JSONObject getResult() {
        return result;
    }
    public void setResult(JSONObject result) {
        this.result = result;
    }
    public void setDeptStInfManager(DeptStInfManager basemgr)
    {
        deptStInfMag = basemgr;
        this.setBaseEntityManager(deptStInfMag);
    }
	/**
     * 权利三级目录
     * @return
     */
     public String qlml() {
         String area = request.getParameter("area");
         String type = request.getParameter("type");
         String orgcode = request.getParameter("orgcode");
         String flag = request.getParameter("flag");
         request.setAttribute("orgcode", orgcode);
         request.setAttribute("type", type);
         request.setAttribute("area", area);
         request.setAttribute("flag", flag);
         String code = "";
         if((!StringUtils.isBlank(area) || "0".equals(area)|| "320000JT".equals(area))&&StringUtils.isBlank(flag)){
             code = carea(area);
         }else{
             code = amOrgManager.getByOrgcode(area,orgcode);
         }
            
         if(!StringUtils.isBlank(type))
             type = ctype(type);
         FUserDetail fuser = ((FUserDetail) getLoginUser());
         String userCode = fuser.getUsercode();
         @SuppressWarnings("unchecked")
         Map<Object, Object> paramMap = request.getParameterMap();
         resetPageParam(paramMap);
         Map<String, Object> filterMap = convertSearchColumn(paramMap);
         Limit limit = ExtremeTableUtils.getLimit(request);
         PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
         List<DeptStInf> deptQlInfs = new ArrayList<DeptStInf>();
         pageDesc.setPageSize(40);
         if(!"0".equals(orgcode)){
             if((!StringUtils.isBlank(code) || "0".equals(area)|| "320000JT".equals(area))&&("00".equals(orgcode.substring(4, 6)))){
                 code=code.substring(0, 4)+"%JT";
                 // area.replace(area.substring(3, 5), "%");
                 filterMap.put("deptId2", code);
             }else{
                 filterMap.put("deptId2", code);
             }
         }
         if(!StringUtils.isBlank(type))
             filterMap.put("qlKind", type);
         deptQlInfs = deptStInfMag.getDepQlInflist(filterMap,pageDesc);
         //这里业务类别转换成中文
         int len = 41;
         if(len >= deptQlInfs.size()){
             len = deptQlInfs.size();
         }
           for (int i = 0; i < len; i++) {
              if(!StringUtils.isBlank(deptQlInfs.get(i).getOrgname1())){
                  String orgname1 = "";
                  String [] o = deptQlInfs.get(i).getOrgname1().split(",");
                  for (int j = 0; j < o.length; j++) {
                      if(!StringUtils.isBlank(o[j])){
                          if(!"GG".equals(o[j])&&!"ZB".equals(o[j])){
                              orgname1 = orgname1 + CodeRepositoryUtil.getValue("INDUSTRY_TYPE2", o[j])+",";
                          }else{
                              if("GG".equals(o[j])){
                                  orgname1 = orgname1 + "高管,";
                              }
                              if("ZB".equals(o[j])){
                                  orgname1 = orgname1 + "建设办,";
                              }
                          }
                      }
                  }
                  if(",".equals(orgname1.substring(orgname1.length()-1, orgname1.length()))){
                      orgname1 = orgname1.substring(0, orgname1.length()-1);
                  }
                  deptQlInfs.get(i).setOrgname1(orgname1);
              }
              
              if(!StringUtils.isBlank(deptQlInfs.get(i).getOrgname2())){
                  String orgname2 = "";
                  String [] o = deptQlInfs.get(i).getOrgname2().split(",");
                  for (int j = 0; j < o.length; j++) {
                      if(!StringUtils.isBlank(o[j])){
                          if(!"GG".equals(o[j])&&!"ZB".equals(o[j])){
                              orgname2 = orgname2 + CodeRepositoryUtil.getValue("INDUSTRY_TYPE2", o[j])+",";
                          }else{
                              if("GG".equals(o[j])){
                                  orgname2 = orgname2 + "高管,";
                              }
                              if("ZB".equals(o[j])){
                                  orgname2 = orgname2 + "建设办,";
                              }
                          }
                      }
                  }
                  if(",".equals(orgname2.substring(orgname2.length()-1, orgname2.length()))){
                      orgname2 = orgname2.substring(0, orgname2.length()-1);
                  }
                  deptQlInfs.get(i).setOrgname2(orgname2);
              }
           }
         totalRows = pageDesc.getTotalRows();
         request.setAttribute("deptQlInfs", deptQlInfs);
         Integer rowno = totalRows/40;
         Integer rownoys = totalRows%40;
         if(rownoys > 0){
             rowno+=1;
         }
  //       if(!StringUtils.isBlank(area))
         request.getSession().setAttribute("area", area);
         if(!StringUtils.isBlank(type))
         request.getSession().setAttribute("type", type);
         request.getSession().setAttribute("orgcode", orgcode);
         request.getSession().setAttribute("flag", flag);
         request.setAttribute("rowno", rowno);
         if("02".equals(type)||"03".equals(type)||"06".equals(type)||"08".equals(type)){
             return "qlmlNoType";
         }else{
             return "qlml";
         }
    }
     /**
      * 权利三级目录
      * @return
      */
      public String qlmlyw() {
          @SuppressWarnings("unchecked")
          Map<Object, Object> paramMap = request.getParameterMap();
          resetPageParam(paramMap);
          Map<String, Object> filterMap = convertSearchColumn(paramMap);
          //查询条件里面的请求 有可能这些都没有数据
          String area = "";
          if(StringUtils.isBlank((String)filterMap.get("area"))){
              area = request.getParameter("area");    
          }else{
              area = (String) filterMap.get("area");
              filterMap.remove("area");
          }
          String type = "";
          if(StringUtils.isBlank((String)filterMap.get("type"))){
              type = request.getParameter("type");   
          }else{
              type = (String) filterMap.get("type");
              filterMap.remove("type");
          }
          String orgcode = "";
          if(StringUtils.isBlank((String)filterMap.get("orgcode"))){
              orgcode = request.getParameter("orgcode");
          }else{
              orgcode = (String) filterMap.get("orgcode");
              filterMap.remove("orgcode");
          }
          String flag = "";
          if(StringUtils.isBlank((String)filterMap.get("flag"))){
              flag = request.getParameter("flag"); 
          }else{
              flag = (String) filterMap.get("flag");
              filterMap.remove("flag");
          }
          String code = "";
          if((!StringUtils.isBlank(area) || "0".equals(area)|| "320000JT".equals(area))&&StringUtils.isBlank(flag)){
              code = carea(area);
          }else{
              code = amOrgManager.getByOrgcode(area,orgcode);
          }
          if(!StringUtils.isBlank(type))
              type = ctype(type);
          FUserDetail fuser = ((FUserDetail) getLoginUser());
          String userCode = fuser.getUsercode();
          Limit limit = ExtremeTableUtils.getLimit(request);
          PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
          List<VDeptYwBmdy2> deptQlInfs = new ArrayList<VDeptYwBmdy2>();
          if(!"0".equals(orgcode)){
              if((!StringUtils.isBlank(code) || "0".equals(area)|| "320000JT".equals(area))&&("00".equals(orgcode.substring(4, 6))&&(StringUtils.isBlank(flag)))){
                  code=code.substring(0, 4)+"%JT";
                  // area.replace(area.substring(3, 5), "%");
                  filterMap.put("deptId2", code);
              }else{
                  filterMap.put("deptId2", code);
              }
          }
        /*  filterMap.put("qlDept", code);*/
          if(!StringUtils.isBlank(type)){
              if("1".equals(type))
                  type = "01";
              filterMap.put("qlKind", type);
          }
          if(!StringUtils.isBlank((String)filterMap.get("xztype"))){
              filterMap.put("orgname",(String)filterMap.get("xztype"));
              filterMap.remove("xztype");
          }
          deptQlInfs = vDeptYwBmdy2Manager.listObjects(filterMap, pageDesc);
          if(deptQlInfs != null){
              if(deptQlInfs.size()>0){
                  for (VDeptYwBmdy2 deptYwInf : deptQlInfs) {
                      if(!StringUtils.isBlank(deptYwInf.getQlDept())){
                          AmOrg amOrg = amOrgManager.getObjectById(deptYwInf.getQlDept());
                          if(amOrg != null){
                              deptYwInf.setShrotOrgName(amOrg.getOrgname());
                          }
                      }
                      if("GG".equals(deptYwInf.getOrgcode())){
                          deptYwInf.setOrgname("高管");
                      }
                      if("ZB".equals(deptYwInf.getOrgcode())){
                          deptYwInf.setOrgname("建设办");
                      }
                  } 
              }
          }
          totalRows = pageDesc.getTotalRows();
          request.setAttribute("deptYwInfs", deptQlInfs);
   //       if(!StringUtils.isBlank(area))
          request.getSession().setAttribute("area", area);
          if(!StringUtils.isBlank(type))
          request.getSession().setAttribute("type", type);
          request.getSession().setAttribute("orgcode", orgcode);
          request.getSession().setAttribute("flag", flag);
          if("02".equals(type)||"03".equals(type)||"06".equals(type)||"08".equals(type)){
              return "qlmlYwType";
          }else{
              return "qlmlYw";
          }
     }
     /**
      * 权利三级目录
      * @return
      */
     /* public String qlmlyw() {
          String area = request.getParameter("area");
          String type = request.getParameter("type");
          String orgcode = request.getParameter("orgcode");
          String flag = request.getParameter("flag");
          String code = "";
          if((!StringUtils.isBlank(area) || "0".equals(area)|| "320000JT".equals(area))&&StringUtils.isBlank(flag)){
              code = carea(area);
          }else{
              code = amOrgManager.getByOrgcode(area,orgcode);
          }
          if(!StringUtils.isBlank(type))
              type = ctype(type);
          @SuppressWarnings("unchecked")
          Map<Object, Object> paramMap = request.getParameterMap();
          resetPageParam(paramMap);
          Map<String, Object> filterMap = convertSearchColumn(paramMap);
          Limit limit = ExtremeTableUtils.getLimit(request);
          PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
          List<VDeptYwBmdy> deptYwInfs = new ArrayList<VDeptYwBmdy>();
          filterMap.put("qlDept", code);
          if(!StringUtils.isBlank(type)){
              if("1".equals(type))
                  type = "01";
              filterMap.put("qlKind", type);
          }
          deptYwInfs = vDeptYwBmdyManager.listObjects(filterMap, pageDesc);
          if(deptYwInfs != null){
              if(deptYwInfs.size()>0){
                  for (VDeptYwBmdy deptYwInf : deptYwInfs) {
                      if(!StringUtils.isBlank(deptYwInf.getQlDept())){
                          AmOrg amOrg = amOrgManager.getObjectById(deptYwInf.getQlDept());
                          if(amOrg != null){
                              deptYwInf.setShrotOrgName(amOrg.getOrgname());
                          }
                      }
                      if("GG".equals(deptYwInf.getOrgcode())){
                          deptYwInf.setOrgname("高管");
                      }
                      if("ZB".equals(deptYwInf.getOrgcode())){
                          deptYwInf.setOrgname("建设办");
                      }
                  } 
              }
          }
          totalRows = pageDesc.getTotalRows();
          request.setAttribute("deptYwInfs", deptYwInfs);
          
          request.getSession().setAttribute("area", area);
          if(!StringUtils.isBlank(type))
          request.getSession().setAttribute("type", type);
          request.getSession().setAttribute("orgcode", orgcode);
          request.getSession().setAttribute("flag", flag);
          if("02".equals(type)||"03".equals(type)||"06".equals(type)||"08".equals(type)){
              return "qlmlNoType";
          }else{
              return "qlmlYw";
          }
     }*/
    private String carea(String area) {
        if("0".equals(area)){
            return "";
        }else if("1".equals(area)){
            return "320000JT";
        }else if("2".equals(area)){
            return "320100JT";
        }else if("3".equals(area)){
            return "320200JT";
        }else if("4".equals(area)){
            return "320300JT";
        }else if("5".equals(area)){
            return "320400JT";
        }else if("6".equals(area)){
            return "320500JT";
        }else if("7".equals(area)){
            return "320600JT";
        }else if("8".equals(area)){
            return "320700JT";
        }else if("9".equals(area)){
            return "320800JT";
        }else if("10".equals(area)){
            return "320900JT";
        }else if("11".equals(area)){
            return "321000JT";
        }else if("12".equals(area)){
            return "321100JT";
        }else if("13".equals(area)){
            return "321200JT";
        }else if("14".equals(area)){
            return "321300JT";
        }
        return null;
    }
    private String ctype(String type) {
        if("xzxk".equals(type)){
            return "1";
        }else if("xzcf".equals(type)){
            return "02";
        }else if("xzqz".equals(type)){
            return "03";
        }else if("xzzs".equals(type)){
            return "04";
        }else if("xzjf".equals(type)){
            return "05";
        }else if("xzjl".equals(type)){
            return "06";
        }else if("xzqr".equals(type)){
            return "07";
        }else if("xzcj".equals(type)){
            return "08";
        }else if("xzzy".equals(type)){
            return "09";
        }else if("qt".equals(type)){
            return "10";
        }
        return null;
    }
        /**
      * 权利三级目录(分页)
      * @return
      */
      public String qlmlfy() {
          String area = (String) request.getSession().getAttribute("area");
          String type = (String) request.getSession().getAttribute("type");
          String orgcode =(String) request.getSession().getAttribute("orgcode");
          String flag =(String) request.getSession().getAttribute("flag");
          String code = "";
          if((!StringUtils.isBlank(area) || "0".equals(area)|| "320000JT".equals(area))&&StringUtils.isBlank(flag)){
              code = carea(area);
          }else{
              code = amOrgManager.getByOrgcode(area,orgcode);
          }
          FUserDetail fuser = ((FUserDetail) getLoginUser());
          String userCode = fuser.getUsercode();
          @SuppressWarnings("unchecked")
          Map<Object, Object> paramMap = request.getParameterMap();
          resetPageParam(paramMap);
          Map<String, Object> filterMap = convertSearchColumn(paramMap);
          Limit limit = ExtremeTableUtils.getLimit(request);
          PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
          List<DeptStInf> deptQlInfs = new ArrayList<DeptStInf>();
          /*filterMap.put("topiddeptQlInf", "1470a7a7963e4cbdb75a6a538bfbd098");*/
          pageDesc.setPageSize(40);
          String current = request.getParameter("currentPage");
          if(!StringUtils.isBlank(current)){
              pageDesc.setPageNo(Integer.parseInt(current));
          }
          if(!"0".equals(orgcode)){
              if((!StringUtils.isBlank(code) || "0".equals(area)|| "320000JT".equals(area))&&("00".equals(orgcode.substring(4, 6)))){
                  code=code.substring(0, 4)+"%JT";
                  // area.replace(area.substring(3, 5), "%");
                  filterMap.put("deptId2", code);
              }else{
                  filterMap.put("deptId2", code);
              }
          }
          if(!StringUtils.isBlank(type))
              filterMap.put("qlKind", type);
          deptQlInfs = deptStInfMag.getDepQlInflist(filterMap,pageDesc);

          //这里业务类别转换成中文
          int len = 41;
          if(len >= deptQlInfs.size()){
              len = deptQlInfs.size();
          }
            for (int i = 0; i < len; i++) {
               if(!StringUtils.isBlank(deptQlInfs.get(i).getOrgname1())){
                   String orgname1 = "";
                   String [] o = deptQlInfs.get(i).getOrgname1().split(",");
                   for (int j = 0; j < o.length; j++) {
                       if(!StringUtils.isBlank(o[j])){
                           if(!"GG".equals(o[j])&&!"ZB".equals(o[j])){
                               orgname1 = orgname1 + CodeRepositoryUtil.getValue("INDUSTRY_TYPE2", o[j])+",";
                           }else{
                               if("GG".equals(o[j])){
                                   orgname1 = orgname1 + "高管,";
                               }
                               if("ZB".equals(o[j])){
                                   orgname1 = orgname1 + "建设办,";
                               }
                           }
                       }
                   }
                   if(",".equals(orgname1.substring(orgname1.length()-1, orgname1.length()))){
                       orgname1 = orgname1.substring(0, orgname1.length()-1);
                   }
                   deptQlInfs.get(i).setOrgname1(orgname1);
               }
               
               if(!StringUtils.isBlank(deptQlInfs.get(i).getOrgname2())){
                   String orgname2 = "";
                   String [] o = deptQlInfs.get(i).getOrgname2().split(",");
                   for (int j = 0; j < o.length; j++) {
                       if(!StringUtils.isBlank(o[j])){
                           if(!"GG".equals(o[j])&&!"ZB".equals(o[j])){
                               orgname2 = orgname2 + CodeRepositoryUtil.getValue("INDUSTRY_TYPE2", o[j])+",";
                           }else{
                               if("GG".equals(o[j])){
                                   orgname2 = orgname2 + "高管,";
                               }
                               if("ZB".equals(o[j])){
                                   orgname2 = orgname2 + "建设办,";
                               }
                           }
                       }
                   }
                   if(",".equals(orgname2.substring(orgname2.length()-1, orgname2.length()))){
                       orgname2 = orgname2.substring(0, orgname2.length()-1);
                   }
                   deptQlInfs.get(i).setOrgname2(orgname2);
               }
            }
          
          totalRows = pageDesc.getTotalRows();
          request.setAttribute("deptQlInfs", deptQlInfs);
          result.put("deptQlInfs", deptQlInfs);
          return "qlmlfy";
         }
      /**
       * 根据id查询 权利基本信息和业务子项
       * @return
       */
	public String getQlAndyw() {
	    String qlid = request.getParameter("qlid");
	    DeptQlInf deptQlInf = deptQlInfManager.getObjectById(qlid);
	    AmOrg am = amOrgManager.getObjectById(deptQlInf.getDeptId());
	    if(am != null){
	        deptQlInf.setOrgShortName(am.getOrgname());
        }
	    String userLevel = deptQlInf.getUseLevel();
	    String userLevelValue = "";
	    //行使主体
	    if(!StringUtils.isBlank(userLevel)){
	        String[] ul = userLevel.split(",");
	        if(ul.length > 1){
	            for (int i = 0; i < ul.length; i++) {
	                userLevelValue +=  CodeRepositoryUtil.getValue("userlevel", ul[i])+",";
	                userLevelValue=userLevelValue.substring(userLevelValue.length()-1, userLevelValue.length());
	            }
	        }else{
	                userLevelValue +=  CodeRepositoryUtil.getValue("userlevel", userLevel);
	        }
	    }
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("deptQlId", qlid);
	    //List<DeptYwInf> deptYwInfs = deptYwInfManager.listObjects(map);
	    List<VDeptYwBmdy> deptYwInfs = vDeptYwBmdyManager.listObjects(map);
	    if(deptYwInfs != null){
            if(deptYwInfs.size()>0){
                for (VDeptYwBmdy deptYwInf : deptYwInfs) {
                    if(!StringUtils.isBlank(deptYwInf.getQlDept())){
                        AmOrg amOrg = amOrgManager.getObjectById(deptYwInf.getQlDept());
                        if(amOrg != null){
                            deptYwInf.setShrotOrgName(amOrg.getOrgname());
                        }
                    }
                    if("GG".equals(deptYwInf.getOrgcode())){
                        deptYwInf.setOrgname("高管");
                    }
                    if("ZB".equals(deptYwInf.getOrgcode())){
                        deptYwInf.setOrgname("建设办");
                    }
                } 
            }
        }
	    if(deptYwInfs.size()>0&&deptYwInfs!=null)
	    request.setAttribute("deptYwInfs", deptYwInfs);
	    request.setAttribute("userLevelValue", userLevelValue);
	    request.setAttribute("deptQlInf", deptQlInf);
        return "qlyw";
    }
	 /**
     * 判断是不是父项
     * @return
     */
  public String check() {
      String qlid = request.getParameter("qlid");
      Map<String, Object> map = new HashMap<String, Object>();
      if(!StringUtils.isBlank(qlid)){
          map.put("deptQlParentId", qlid);
      }
      List<DeptQlInf> deptQlInfs = deptQlInfManager.listObjects(map);
      if(deptQlInfs.size()>0){
          result.put("flag", "F");
      }else{
          result.put("flag", "T");
      }
      return "check";
  }	
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}

package com.centit.powerruntime.action;

import java.util.List;
import java.util.Map;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.AmOrg;
import com.centit.powerruntime.po.QlQdsxtj;
import com.centit.powerruntime.po.QlQdtj;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	


		











import com.centit.powerruntime.service.AmOrgManager;
import com.centit.powerruntime.service.QlQdsxtjManager;
import com.centit.powerruntime.service.QlQdtjManager;
import com.centit.sys.security.FUserDetail;
	

public class QlQdtjAction  extends BaseEntityExtremeAction<QlQdtj>  {
	private static final Log log = LogFactory.getLog(QlQdtjAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private QlQdtjManager qlQdtjManager;
	private QlQdsxtjManager qlQdsxtjManager;
	
	public void setQlQdsxtjManager(QlQdsxtjManager qlQdsxtjManager) {
        this.qlQdsxtjManager = qlQdsxtjManager;
    }

    public void setQlQdtjManager(QlQdtjManager basemgr)
	{
	    qlQdtjManager = basemgr;
		this.setBaseEntityManager(qlQdtjManager);
	}

	 /**
     * 权力清单统计
     * @return
     */
     public String qlqd() {
         String jtcode = request.getParameter("jtcode");
         FUserDetail fuser = ((FUserDetail) getLoginUser());
         String userCode = fuser.getUsercode();
         @SuppressWarnings("unchecked")
         Map<Object, Object> paramMap = request.getParameterMap();
         resetPageParam(paramMap);
         Map<String, Object> filterMap = convertSearchColumn(paramMap);
         if(!StringUtils.isBlank(jtcode)&&jtcode.length() > 4){
             filterMap.put("jtcode", jtcode.substring(0, jtcode.length()-4));
             List<QlQdsxtj> qlQdtjs = qlQdsxtjManager.listQlQdsxtj(filterMap);
             request.setAttribute("qlQdtjs", qlQdtjs);
             request.setAttribute("flag", request.getParameter("flag"));
         }else{
             List<QlQdtj> qlQdtjs = qlQdtjManager.listQlQdtj(filterMap);
             request.getSession().setAttribute("flag", null);
             request.setAttribute("qlQdtjs", qlQdtjs);
         }
         request.setAttribute("method", "qlQdtj!qlqd");
         return "qlml";
        }
     /**
      * 权力清单统计
      * @return
      */
    @SuppressWarnings("unchecked")
    public String qlqd2() {
          String jtcode = request.getParameter("jtcode");
          FUserDetail fuser = ((FUserDetail) getLoginUser());
          String userCode = fuser.getUsercode();
          Map<Object, Object> paramMap = request.getParameterMap();
          resetPageParam(paramMap);
          Map<String, Object> filterMap = convertSearchColumn(paramMap);
          if(!StringUtils.isBlank(jtcode)&&jtcode.length() > 4){
              filterMap.put("jtcode", jtcode.substring(0, jtcode.length()-4));
              List<QlQdsxtj> qlQdtjs = qlQdsxtjManager.listQlQdsxtj(filterMap);
              request.setAttribute("qlQdtjs", qlQdtjs);
          }else{
              List<QlQdtj> qlQdtjs = qlQdtjManager.listQlQdtj(filterMap);
              request.setAttribute("qlQdtjs", qlQdtjs);
          }
          return "qlml";
         }
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}

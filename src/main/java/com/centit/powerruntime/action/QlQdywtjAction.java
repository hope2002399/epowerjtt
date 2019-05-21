package com.centit.powerruntime.action;
import java.util.List;
import java.util.Map;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.QlQdywsxtj;
import com.centit.powerruntime.po.QlQdywtj;
import com.centit.powerruntime.po.QlQdzxsxtj;
import com.centit.powerruntime.po.QlQdzxtj;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdywsxtjManager;
import com.centit.powerruntime.service.QlQdywtjManager;
import com.centit.powerruntime.service.QlQdzxtjManager;
import com.centit.sys.security.FUserDetail;


public class QlQdywtjAction  extends BaseEntityExtremeAction<QlQdywtj>  {
	private static final Log log = LogFactory.getLog(QlQdywtjAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private QlQdywtjManager qlQdywtjManager;
	private QlQdywsxtjManager qlQdywsxtjManager;
	
	public void setQlQdywsxtjManager(QlQdywsxtjManager qlQdywsxtjManager) {
        this.qlQdywsxtjManager = qlQdywsxtjManager;
    }

    public void setQlQdywtjManager(QlQdywtjManager basemgr)
	{
	    qlQdywtjManager = basemgr;
		this.setBaseEntityManager(qlQdywtjManager);
	}

	 /**
     * 权力清单统计
     * @return
     */
     public String qlqdyw() {
         String jtcode = request.getParameter("jtcode");
         FUserDetail fuser = ((FUserDetail) getLoginUser());
         String userCode = fuser.getUsercode();
         @SuppressWarnings("unchecked")
         Map<Object, Object> paramMap = request.getParameterMap();
         resetPageParam(paramMap);
         Map<String, Object> filterMap = convertSearchColumn(paramMap);
         if(!StringUtils.isBlank(jtcode)&&jtcode.length() > 4){
             filterMap.put("jtcode", jtcode.substring(0, jtcode.length()-4));
             List<QlQdywsxtj> qlQdtjs = qlQdywsxtjManager.listQlQdywsxtj(filterMap);
             request.setAttribute("qlQdtjs", qlQdtjs);
             request.setAttribute("flag", request.getParameter("flag"));
         }else{
             List<QlQdywtj> qlQdywtjs = qlQdywtjManager.listQlQdywtj(filterMap);
             request.setAttribute("flag", null);
             request.getSession().setAttribute("flag", null);
             request.setAttribute("qlQdtjs", qlQdywtjs);
         }
         request.setAttribute("method", "qlQdywtj!qlqdyw");
         return "qlmlyw";
   }
	
		
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}

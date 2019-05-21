package com.centit.powerruntime.action;
import java.util.List;
import java.util.Map;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.powerruntime.po.QlQdsjstsxtj;
import com.centit.powerruntime.po.QlQdsjsttj;
import com.centit.powerruntime.po.QlQdywsxtj;
import com.centit.powerruntime.po.QlQdywtj;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdsjstsxtjManager;
import com.centit.powerruntime.service.QlQdsjsttjManager;
import com.centit.sys.security.FUserDetail;


public class QlQdsjsttjAction  extends BaseEntityExtremeAction<QlQdsjsttj>  {
	private static final Log log = LogFactory.getLog(QlQdsjsttjAction.class);
	
	//private static final ISysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog("optid");
	
	private static final long serialVersionUID = 1L;
	private QlQdsjsttjManager qlQdsjsttjManager;
	private QlQdsjstsxtjManager qlQdsjstsxtjManager;
	
	public void setQlQdsjstsxtjManager(QlQdsjstsxtjManager qlQdsjstsxtjManager) {
        this.qlQdsjstsxtjManager = qlQdsjstsxtjManager;
    }

    public void setQlQdsjsttjManager(QlQdsjsttjManager basemgr)
	{
	    qlQdsjsttjManager = basemgr;
		this.setBaseEntityManager(qlQdsjsttjManager);
	}

	 /**
     * 权力清单统计
     * @return
     */
     public String qlqdsjst() {
         String jtcode = request.getParameter("jtcode");
         FUserDetail fuser = ((FUserDetail) getLoginUser());
         String userCode = fuser.getUsercode();
         @SuppressWarnings("unchecked")
         Map<Object, Object> paramMap = request.getParameterMap();
         resetPageParam(paramMap);
         Map<String, Object> filterMap = convertSearchColumn(paramMap);
         
         if(!StringUtils.isBlank(jtcode)&&jtcode.length() > 4){
             filterMap.put("jtcode", jtcode.substring(0, jtcode.length()-4));
             List<QlQdsjstsxtj> qlQdtjs = qlQdsjstsxtjManager.listQlQdsjstsxtj(filterMap);
             request.setAttribute("qlQdtjs", qlQdtjs);
             request.setAttribute("flag", request.getParameter("flag"));
         }else{
             List<QlQdsjsttj> qlQdsjsttjs = qlQdsjsttjManager.listQlQdsjsttj(filterMap);
             request.getSession().setAttribute("flag", null);
             request.setAttribute("flag", null);
             request.setAttribute("qlQdtjs", qlQdsjsttjs);
         }
         request.setAttribute("method", "qlQdsjsttj!qlqdsjst");
         return "qlmlsjst";
        }
	
	
	public String delete() {
	    super.delete();      
	    
	    return "delete";
	}
}

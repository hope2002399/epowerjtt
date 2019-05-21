package com.centit.powerruntime.service.impl;

import java.util.List;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.AmOrg;
import com.centit.powerruntime.dao.AmOrgDao;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.AmOrgManager;

public class AmOrgManagerImpl extends BaseEntityManagerImpl<AmOrg>
	implements AmOrgManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(AmOrgManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private AmOrgDao amOrgDao ;
	public void setAmOrgDao(AmOrgDao baseDao)
	{
		this.amOrgDao = baseDao;
		setBaseDao(this.amOrgDao);
	}
    @Override
    public String getByOrgcode(String area, String orgcode) {
        String sql = "select a.*,rownum from (select * from am_org  where idorg like '"+orgcode.substring(0, 4)+"%JT' and idorg <> '320102JT' and idorg <> '320192JT' order by idorg) a where rownum <= '"+(Integer.parseInt(area)+1)+"'";
        List cod = amOrgDao.findObjectsBySql(sql);
        Object []c =  (Object[]) cod.get(Integer.parseInt(area)-1);
        String code = c[0].toString();
        return code;
    }
	
}


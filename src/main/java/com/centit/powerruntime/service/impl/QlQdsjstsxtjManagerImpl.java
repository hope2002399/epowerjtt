package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdsjstsxtj;
import com.centit.powerruntime.po.QlQdsjsttj;
import com.centit.powerruntime.po.QlQdywsxtj;
import com.centit.powerruntime.dao.QlQdsjstsxtjDao;
import com.centit.powerruntime.dao.QlQdsjsttjDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdsjstsxtjManager;
import com.centit.powerruntime.service.QlQdsjsttjManager;

public class QlQdsjstsxtjManagerImpl extends BaseEntityManagerImpl<QlQdsjstsxtj>
	implements QlQdsjstsxtjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdsjsttjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdsjstsxtjDao qlQdsjstsxtjDao ;
	public void setQlQdsjstsxtjDao(QlQdsjstsxtjDao baseDao)
	{
		this.qlQdsjstsxtjDao = baseDao;
		setBaseDao(this.qlQdsjstsxtjDao);
	}
    @Override
    public List<QlQdsjstsxtj> listQlQdsjstsxtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdsjstsxtj> qlQdzxtjs = qlQdsjstsxtjDao.listObjects(paramMap);
        
        int xzxk = 0;
        int xzcf = 0;
        int xzqz = 0;
        int xzzs = 0;
        int xzjf = 0;
        int xzjl = 0;
        int xzqr = 0;
        int xzcj = 0;
        int xzzy = 0;
        int qt = 0;
        for (int i = 0; i < qlQdzxtjs.size(); i++) {
            xzxk = xzxk + Integer.parseInt(qlQdzxtjs.get(i).getXzxk());
            xzcf = xzcf + Integer.parseInt(qlQdzxtjs.get(i).getXzcf());
            xzqz = xzqz + Integer.parseInt(qlQdzxtjs.get(i).getXzqz());
            xzzs = xzzs + Integer.parseInt(qlQdzxtjs.get(i).getXzzs());
            xzjf = xzjf + Integer.parseInt(qlQdzxtjs.get(i).getXzjf());
            xzjl = xzjl + Integer.parseInt(qlQdzxtjs.get(i).getXzjl());
            xzqr = xzqr + Integer.parseInt(qlQdzxtjs.get(i).getXzqr());
            xzcj = xzcj + Integer.parseInt(qlQdzxtjs.get(i).getXzcj());
            xzzy = xzzy + Integer.parseInt(qlQdzxtjs.get(i).getXzzy());
            qt = qt + Integer.parseInt(qlQdzxtjs.get(i).getQt());
            qlQdzxtjs.get(i).setPjtcode("0");
        }
        QlQdsjstsxtj qlQdsjstsxtj = new QlQdsjstsxtj();
        qlQdsjstsxtj.setJtcode("0");
        String orgname2=qlQdzxtjs.get(0).getOrgname();
        if("局".equals(orgname2.substring(orgname2.length()-1, orgname2.length()))){
            orgname2 = orgname2.substring(0, orgname2.length()-1)+"部门";
        }
        qlQdsjstsxtj.setOrgname(orgname2);
        qlQdsjstsxtj.setXzxk(String.valueOf(xzxk));
        qlQdsjstsxtj.setXzcf(String.valueOf(xzcf));
        qlQdsjstsxtj.setXzqz(String.valueOf(xzqz));
        qlQdsjstsxtj.setXzzs(String.valueOf(xzzs));
        qlQdsjstsxtj.setXzjf(String.valueOf(xzjf));
        qlQdsjstsxtj.setXzjl(String.valueOf(xzjl));
        qlQdsjstsxtj.setXzqr(String.valueOf(xzqr));
        qlQdsjstsxtj.setXzcj(String.valueOf(xzcj));
        qlQdsjstsxtj.setXzzy(String.valueOf(xzzy));
        qlQdsjstsxtj.setQt(String.valueOf(qt));
        qlQdsjstsxtj.setPjtcode("");
        qlQdzxtjs.add(0, qlQdsjstsxtj);
        return qlQdzxtjs;
    }
	
}


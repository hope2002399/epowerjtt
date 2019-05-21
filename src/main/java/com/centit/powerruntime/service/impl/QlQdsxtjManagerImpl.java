package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdsxtj;
import com.centit.powerruntime.dao.QlQdsxtjDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdsxtjManager;

public class QlQdsxtjManagerImpl extends BaseEntityManagerImpl<QlQdsxtj>
	implements QlQdsxtjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdsxtjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdsxtjDao qlQdsxtjDao ;
	public void setQlQdsxtjDao(QlQdsxtjDao baseDao)
	{
		this.qlQdsxtjDao = baseDao;
		setBaseDao(this.qlQdsxtjDao);
	}
    @Override
    public List<QlQdsxtj> listQlQdsxtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdsxtj> qlQdsxtjs = qlQdsxtjDao.listObjects(paramMap);
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
        for (int i = 0; i < qlQdsxtjs.size(); i++) {
            xzxk = xzxk + Integer.parseInt(qlQdsxtjs.get(i).getXzxk());
            xzcf = xzcf + Integer.parseInt(qlQdsxtjs.get(i).getXzcf());
            xzqz = xzqz + Integer.parseInt(qlQdsxtjs.get(i).getXzqz());
            xzzs = xzzs + Integer.parseInt(qlQdsxtjs.get(i).getXzzs());
            xzjf = xzjf + Integer.parseInt(qlQdsxtjs.get(i).getXzjf());
            xzjl = xzjl + Integer.parseInt(qlQdsxtjs.get(i).getXzjl());
            xzqr = xzqr + Integer.parseInt(qlQdsxtjs.get(i).getXzqr());
            xzcj = xzcj + Integer.parseInt(qlQdsxtjs.get(i).getXzcj());
            xzzy = xzzy + Integer.parseInt(qlQdsxtjs.get(i).getXzzy());
            qt = qt + Integer.parseInt(qlQdsxtjs.get(i).getQt());
            qlQdsxtjs.get(i).setPjtcode("0");
        }
        QlQdsxtj qlQdsxtj = new QlQdsxtj();
        qlQdsxtj.setJtcode("0");
        String orgname2=qlQdsxtjs.get(0).getOrgname();
        if("局".equals(orgname2.substring(orgname2.length()-1, orgname2.length()))){
            orgname2 = orgname2.substring(0, orgname2.length()-1)+"部门";
        }
        qlQdsxtj.setOrgname(orgname2);
        qlQdsxtj.setXzxk(String.valueOf(xzxk));
        qlQdsxtj.setXzcf(String.valueOf(xzcf));
        qlQdsxtj.setXzqz(String.valueOf(xzqz));
        qlQdsxtj.setXzzs(String.valueOf(xzzs));
        qlQdsxtj.setXzjf(String.valueOf(xzjf));
        qlQdsxtj.setXzjl(String.valueOf(xzjl));
        qlQdsxtj.setXzqr(String.valueOf(xzqr));
        qlQdsxtj.setXzcj(String.valueOf(xzcj));
        qlQdsxtj.setXzzy(String.valueOf(xzzy));
        qlQdsxtj.setQt(String.valueOf(qt));
        qlQdsxtjs.add(0, qlQdsxtj);
        // qlQdsxtjs.get(0).setPjtcode("");
        return qlQdsxtjs;
    }
	
}


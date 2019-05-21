package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdtj;
import com.centit.powerruntime.po.QlQdywsxtj;
import com.centit.powerruntime.po.QlQdywtj;
import com.centit.powerruntime.po.QlQdzxsxtj;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.dao.QlQdtjDao;
import com.centit.powerruntime.dao.QlQdywsxtjDao;
import com.centit.powerruntime.dao.QlQdywtjDao;
import com.centit.powerruntime.dao.QlQdzxtjDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdtjManager;
import com.centit.powerruntime.service.QlQdywsxtjManager;
import com.centit.powerruntime.service.QlQdywtjManager;
import com.centit.powerruntime.service.QlQdzxtjManager;

public class QlQdywsxtjManagerImpl extends BaseEntityManagerImpl<QlQdywsxtj>
	implements QlQdywsxtjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdywsxtjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdywsxtjDao qlQdywsxtjDao ;
	public void setQlQdywsxtjDao(QlQdywsxtjDao baseDao)
	{
		this.qlQdywsxtjDao = baseDao;
		setBaseDao(this.qlQdywsxtjDao);
	}
    @Override
    public List<QlQdywsxtj> listQlQdywsxtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdywsxtj> qlQdsxtjs = qlQdywsxtjDao.listObjects(paramMap);
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
        QlQdywsxtj qlQdywsxtj = new QlQdywsxtj();
        qlQdywsxtj.setJtcode("0");
        String orgname2=qlQdsxtjs.get(0).getOrgname();
        if("局".equals(orgname2.substring(orgname2.length()-1, orgname2.length()))){
            orgname2 = orgname2.substring(0, orgname2.length()-1)+"部门";
        }
        qlQdywsxtj.setOrgname(orgname2);
        qlQdywsxtj.setXzxk(String.valueOf(xzxk));
        qlQdywsxtj.setXzcf(String.valueOf(xzcf));
        qlQdywsxtj.setXzqz(String.valueOf(xzqz));
        qlQdywsxtj.setXzzs(String.valueOf(xzzs));
        qlQdywsxtj.setXzjf(String.valueOf(xzjf));
        qlQdywsxtj.setXzjl(String.valueOf(xzjl));
        qlQdywsxtj.setXzqr(String.valueOf(xzqr));
        qlQdywsxtj.setXzcj(String.valueOf(xzcj));
        qlQdywsxtj.setXzzy(String.valueOf(xzzy));
        qlQdywsxtj.setQt(String.valueOf(qt));
        qlQdywsxtj.setPjtcode("");
        qlQdsxtjs.add(0, qlQdywsxtj);
        return qlQdsxtjs;
    }
	
}


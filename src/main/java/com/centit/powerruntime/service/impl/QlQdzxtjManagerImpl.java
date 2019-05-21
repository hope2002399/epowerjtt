package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.QlQdtj;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.dao.QlQdtjDao;
import com.centit.powerruntime.dao.QlQdzxtjDao;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdtjManager;
import com.centit.powerruntime.service.QlQdzxtjManager;

public class QlQdzxtjManagerImpl extends BaseEntityManagerImpl<QlQdzxtj>
	implements QlQdzxtjManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(QlQdzxtjManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private QlQdzxtjDao qlQdzxtjDao ;
	public void setQlQdzxtjDao(QlQdzxtjDao baseDao)
	{
		this.qlQdzxtjDao = baseDao;
		setBaseDao(this.qlQdzxtjDao);
	}
    @Override
    public List<QlQdzxtj> listQlQdzxtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdzxtj> qlQdzxtjs = qlQdzxtjDao.listObjects();
        if(!StringUtils.isBlank((String)paramMap.get("beginTime"))||!StringUtils.isBlank((String)paramMap.get("endTime"))){
            String sql = " select ORGNAME,JTCODE,XZXK,XZCF,XZQZ,XZZS,XZJF,XZJL,XZQR,XZCJ,XZZY,QT,PJTCODE "
                          +" from (select '江苏省交通运输部门' orgname,'0' jtcode,sum(c.xzxk) xzxk,sum(c.xzcf) xzcf,sum(c.xzqz) xzqz,sum(c.xzzs) xzzs,        "
                          +"         sum(c.xzjf) xzjf,sum(c.xzjl) xzjl,sum(c.xzqr) xzqr,sum(c.xzcj) xzcj,sum(c.xzzy) xzzy,sum(c.qt) qt, "                      
                          + " '' pjtcode from (select b.orgname,a.* from (select substr(dsi.dept_id, 1, 4) || '00JT' jtcode,                                  "
                          +"                sum(case when dsi.ql_kind = '01' then '1' else '0' end) xzxk,                                                     "
                          +"                sum(case when dsi.ql_kind = '02' then '1' else '0' end) xzcf,                                                     "
                          +"                sum(case when dsi.ql_kind = '03' then '1' else '0' end) xzqz,                                                     "
                          +"                sum(case when dsi.ql_kind = '04' then '1' else '0' end) xzzs,                                                     "
                          +"                sum(case when dsi.ql_kind = '05' then '1' else '0' end) xzjf,                                                     "
                          +"                sum(case when dsi.ql_kind = '06' then '1' else '0' end) xzjl,                                                     "
                          +"                sum(case when dsi.ql_kind = '07' then '1' else '0' end) xzqr,                                                     "
                          +"                sum(case when dsi.ql_kind = '08' then '1' else '0' end) xzcj,                                                     "
                          +"                sum(case when dsi.ql_kind = '09' then '1' else '0' end) xzzy,                                                     "
                          +"                sum(case when dsi.ql_kind = '10' then '1' else '0' end) qt,                                                       "
                          +"                '0' pjtcode                                                                                                       "
                          +"                from dept_st_inf dsi where dsi.HI_LEVEL = '1'  ";
                          if(!StringUtils.isBlank((String)paramMap.get("beginTime"))){
                              sql = sql + " and create_date>= to_date('"+(String)paramMap.get("beginTime")+"','yyyy-MM-dd')";
                          };
                          if(!StringUtils.isBlank((String)paramMap.get("endTime"))){
                              sql = sql + " and create_date<= to_date('"+(String)paramMap.get("endTime")+"','yyyy-MM-dd')";
                          };
                          sql=sql+"          group by substr(dsi.dept_id, 1, 4)) a left join am_org b on replace(b.idorg,'_','') = a.jtcode order by jtcode) c       "
                          +"           union all                                                                                                              "
                          +"         select * from (select case when '局'<>substr(b.orgname,length(b.orgname),1)                                              "
                          +"                then b.orgname                                                                                                    "
                          +"                when '局'=substr(b.orgname,length(b.orgname),1)                                                                   "
                          +"                then substr(b.orgname,0,length(b.orgname)-1)|| '部门' end                                                         "
                          +"                orgname,a.* from (select substr(dsi.dept_id, 1, 4) || '00JT' jtcode,                                              "
                          +"                sum(case when dsi.ql_kind = '01' then '1' else '0' end) xzxk,                                                     "
                          +"                sum(case when dsi.ql_kind = '02' then '1' else '0' end) xzcf,                                                     "
                          +"                sum(case when dsi.ql_kind = '03' then '1' else '0' end) xzqz,                                                     "
                          +"                sum(case when dsi.ql_kind = '04' then '1' else '0' end) xzzs,                                                     "
                          +"                sum(case when dsi.ql_kind = '05' then '1' else '0' end) xzjf,                                                     "
                          +"                sum(case when dsi.ql_kind = '06' then '1' else '0' end) xzjl,                                                     "
                          +"                sum(case when dsi.ql_kind = '07' then '1' else '0' end) xzqr,                                                     "
                          +"                sum(case when dsi.ql_kind = '08' then '1' else '0' end) xzcj,                                                     "
                          +"                sum(case when dsi.ql_kind = '09' then '1' else '0' end) xzzy,                                                     "
                          +"                sum(case when dsi.ql_kind = '10' then '1' else '0' end) qt,                                                       "
                          +"                '0' pjtcode                                                                                                       "
                          +"                from dept_st_inf dsi where dsi.HI_LEVEL = '1'            ";
                          if(!StringUtils.isBlank((String)paramMap.get("beginTime"))){
                              sql = sql + " and create_date>= to_date('"+(String)paramMap.get("beginTime")+"','yyyy-MM-dd')";
                          };
                          if(!StringUtils.isBlank((String)paramMap.get("endTime"))){
                              sql = sql + " and create_date<= to_date('"+(String)paramMap.get("endTime")+"','yyyy-MM-dd')";
                          };
                          sql=sql+"          group by substr(dsi.dept_id, 1, 4)) a left join am_org b on replace(b.idorg,'_','') = a.jtcode order by a.jtcode)) dd   " ;
        List<Object[]> aa  = qlQdzxtjDao.findObjectsBySql(sql);
        for (int i = 0; i < aa.size(); i++) {
            qlQdzxtjs.get(i).setOrgname(aa.get(i)[0].toString());
            qlQdzxtjs.get(i).setJtcode(aa.get(i)[1].toString());
            qlQdzxtjs.get(i).setXzxk(aa.get(i)[2].toString());
            qlQdzxtjs.get(i).setXzcf(aa.get(i)[3].toString());
            qlQdzxtjs.get(i).setXzqz(aa.get(i)[4].toString());
            qlQdzxtjs.get(i).setXzzs(aa.get(i)[5].toString());
            qlQdzxtjs.get(i).setXzjf(aa.get(i)[6].toString());
            qlQdzxtjs.get(i).setXzjl(aa.get(i)[7].toString());
            qlQdzxtjs.get(i).setXzqr(aa.get(i)[8].toString());
            qlQdzxtjs.get(i).setXzcj(aa.get(i)[9].toString());
            qlQdzxtjs.get(i).setXzzy(aa.get(i)[10].toString());
            qlQdzxtjs.get(i).setQt(aa.get(i)[11].toString());
            qlQdzxtjs.get(i).setPjtcode(aa.get(i)[12]==null?"":aa.get(i)[12].toString());
        }
        } 
        return qlQdzxtjs;
    }
 
}


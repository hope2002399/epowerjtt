package com.centit.powerruntime.service.impl;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerruntime.po.QlQdsxtj;
import com.centit.powerruntime.po.QlQdtj;
import com.centit.powerruntime.po.QlQdzxsxtj;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.dao.QlQdtjDao;
import com.centit.powerruntime.dao.QlQdzxsxtjDao;
import com.centit.powerruntime.dao.QlQdzxtjDao;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.powerruntime.service.QlQdtjManager;
import com.centit.powerruntime.service.QlQdzxsxtjManager;
import com.centit.powerruntime.service.QlQdzxtjManager;

public class QlQdzxsxtjManagerImpl extends BaseEntityManagerImpl<QlQdzxsxtj>
    implements QlQdzxsxtjManager{
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(QlQdzxsxtjManager.class);
    
    //private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

    private QlQdzxsxtjDao qlQdzxsxtjDao ;
    public void setQlQdzxsxtjDao(QlQdzxsxtjDao baseDao)
    {
        this.qlQdzxsxtjDao = baseDao;
        setBaseDao(this.qlQdzxsxtjDao);
    }
    @Override
    public List<QlQdzxsxtj> listQlQdzxsxtj(Map<String, Object> paramMap) {
        // TODO Auto-generated method stub
        List<QlQdzxsxtj> qlQdzxtjs = qlQdzxsxtjDao.listObjects(paramMap);
        if(!StringUtils.isBlank((String)paramMap.get("beginTime"))||!StringUtils.isBlank((String)paramMap.get("endTime"))){
            String sql = "select ORGNAME,JTCODE,XZXK,XZCF,XZQZ,XZZS,XZJF,XZJL,XZQR,XZCJ,XZZY,QT,PJTCODE                   "
                    +"  from (select '江苏省交通运输部门' orgname,'0' jtcode,sum(c.xzxk) xzxk,sum(c.xzcf) xzcf,sum(c.xzqz) xzqz,sum(c.xzzs) xzzs,"
                    +"  sum(c.xzjf) xzjf,sum(c.xzjl) xzjl,sum(c.xzqr) xzqr,sum(c.xzcj) xzcj,sum(c.xzzy) xzzy,sum(c.qt) qt,'' pjtcode from        "
                    +"  (select b.orgname,a.* from (select substr(dsi.dept_id, 1, 4) || '00JT' jtcode,                                           "
                    +"         sum(case when dsi.ql_kind = '01' then '1' else '0' end) xzxk,                                                     "
                    +"         sum(case when dsi.ql_kind = '02' then '1' else '0' end) xzcf,                                                     "
                    +"         sum(case when dsi.ql_kind = '03' then '1' else '0' end) xzqz,                                                     "
                    +"         sum(case when dsi.ql_kind = '04' then '1' else '0' end) xzzs,                                                     "
                    +"         sum(case when dsi.ql_kind = '05' then '1' else '0' end) xzjf,                                                     "
                    +"         sum(case when dsi.ql_kind = '06' then '1' else '0' end) xzjl,                                                     "
                    +"         sum(case when dsi.ql_kind = '07' then '1' else '0' end) xzqr,                                                     "
                    +"         sum(case when dsi.ql_kind = '08' then '1' else '0' end) xzcj,                                                     "
                    +"         sum(case when dsi.ql_kind = '09' then '1' else '0' end) xzzy,                                                     "
                    +"         sum(case when dsi.ql_kind = '10' then '1' else '0' end) qt,                                                       "
                    +"         '0' pjtcode                                                                                                       "
                    +"         from dept_st_inf dsi where dsi.HI_LEVEL = '1' " ;
                    if(!StringUtils.isBlank((String)paramMap.get("beginTime"))){
                        sql = sql + " and create_date>= to_date('"+(String)paramMap.get("beginTime")+"','yyyy-MM-dd')";
                    };
                    if(!StringUtils.isBlank((String)paramMap.get("endTime"))){
                        sql = sql + " and create_date<= to_date('"+(String)paramMap.get("endTime")+"','yyyy-MM-dd')";
                    };
                    sql=sql+"   group by substr(dsi.dept_id, 1, 4)) a left join am_org b on replace(b.idorg,'_','') = a.jtcode order by jtcode) c       "
                    +"    union all                                                                                                              "
                    +"  select * from (select case when '局'<>substr(b.orgname,length(b.orgname),1)                                              "
                    +"         then b.orgname                                                                                                    "
                    +"         when '局'=substr(b.orgname,length(b.orgname),1)                                                                   "
                    +"         then substr(b.orgname,0,length(b.orgname)-1)|| '部门' end                                                         "
                    +"         orgname,a.* from (select substr(dsi.dept_id, 1, 4) || '00JT' jtcode,                                              "
                    +"         sum(case when dsi.ql_kind = '01' then '1' else '0' end) xzxk,                                                     "
                    +"         sum(case when dsi.ql_kind = '02' then '1' else '0' end) xzcf,                                                     "
                    +"         sum(case when dsi.ql_kind = '03' then '1' else '0' end) xzqz,                                                     "
                    +"         sum(case when dsi.ql_kind = '04' then '1' else '0' end) xzzs,                                                     "
                    +"         sum(case when dsi.ql_kind = '05' then '1' else '0' end) xzjf,                                                     "
                    +"         sum(case when dsi.ql_kind = '06' then '1' else '0' end) xzjl,                                                     "
                    +"         sum(case when dsi.ql_kind = '07' then '1' else '0' end) xzqr,                                                     "
                    +"         sum(case when dsi.ql_kind = '08' then '1' else '0' end) xzcj,                                                     "
                    +"         sum(case when dsi.ql_kind = '09' then '1' else '0' end) xzzy,                                                     "
                    +"         sum(case when dsi.ql_kind = '10' then '1' else '0' end) qt,                                                       "
                    +"         '0' pjtcode                                                                                                       "
                    +"         from dept_st_inf dsi where dsi.HI_LEVEL = '1'  ";
                    if(!StringUtils.isBlank((String)paramMap.get("beginTime"))){
                        sql = sql + " and create_date>= to_date('"+(String)paramMap.get("beginTime")+"','yyyy-MM-dd')";
                    };
                    if(!StringUtils.isBlank((String)paramMap.get("endTime"))){
                        sql = sql + " and create_date<= to_date('"+(String)paramMap.get("endTime")+"','yyyy-MM-dd')";
                    };
                    sql=sql+"   group by substr(dsi.dept_id, 1, 4)) a left join am_org b on replace(b.idorg,'_','') = a.jtcode order by a.jtcode)) dd ";
        List<Object[]> aa  = qlQdzxsxtjDao.findObjectsBySql(sql);
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
        QlQdzxsxtj qlQdzxsxtj = new QlQdzxsxtj();
        qlQdzxsxtj.setJtcode("0");
        String orgname2=qlQdzxtjs.get(0).getOrgname();
        if("局".equals(orgname2.substring(orgname2.length()-1, orgname2.length()))){
            orgname2 = orgname2.substring(0, orgname2.length()-1)+"部门";
        }
        qlQdzxsxtj.setOrgname(orgname2);
        qlQdzxsxtj.setXzxk(String.valueOf(xzxk));
        qlQdzxsxtj.setXzcf(String.valueOf(xzcf));
        qlQdzxsxtj.setXzqz(String.valueOf(xzqz));
        qlQdzxsxtj.setXzzs(String.valueOf(xzzs));
        qlQdzxsxtj.setXzjf(String.valueOf(xzjf));
        qlQdzxsxtj.setXzjl(String.valueOf(xzjl));
        qlQdzxsxtj.setXzqr(String.valueOf(xzqr));
        qlQdzxsxtj.setXzcj(String.valueOf(xzcj));
        qlQdzxsxtj.setXzzy(String.valueOf(xzzy));
        qlQdzxsxtj.setQt(String.valueOf(qt));
        qlQdzxsxtj.setPjtcode("");
        qlQdzxtjs.add(0, qlQdzxsxtj);
        return qlQdzxtjs;
    }
    
}


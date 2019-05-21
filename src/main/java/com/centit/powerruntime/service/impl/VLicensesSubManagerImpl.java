package com.centit.powerruntime.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.powerruntime.po.LicensesSub;
import com.centit.powerruntime.po.QlQdzxtj;
import com.centit.powerruntime.po.VLicensesSub;
import com.centit.powerruntime.po.VDeptYwBmdy2;
import com.centit.powerruntime.dao.VLicensesSubDao;
import com.centit.powerruntime.dao.VDeptYwBmdy2Dao;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.centit.powerruntime.service.VLicensesSubManager;
import com.centit.powerruntime.service.VDeptYwBmdy2Manager;
import com.centit.sys.service.CodeRepositoryUtil;

public class VLicensesSubManagerImpl extends BaseEntityManagerImpl<VLicensesSub>
	implements VLicensesSubManager{
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(VLicensesSubManager.class);
	
	//private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private VLicensesSubDao vLicensesSubDao ;

    public void setVLicensesSubDao(VLicensesSubDao baseDao)
	{
		this.vLicensesSubDao = baseDao;
		setBaseDao(this.vLicensesSubDao);
	}

    @Override
    public List<LicensesSub> getsl(Map<String, Object> filterMap) {
            List<LicensesSub> licensesSubs = new ArrayList<LicensesSub>();//需要返回的list
            /*String sql = "select rownum cid, zd.zz_name zzName, zd.dept_no orgcode, f.datavalue orgname, nvl(ab.sl,0) "
                    +"  from t_zz_dy@to_jsqz zd                                                       "
                    +"  left join (select aa.ZZ_NAME, aa.SL                                           "
                    +"               from (select c.dept_no orgcode, zz_name, count(a.id) sl            "
                    +"                       from e_licence_citysta a                              "
                    +"                      inner join t_zz_mould_info b on a.mould_id = b.id "
                    +"                      right join t_zz_dy c on b.mould_number =          "
                    +"                                                      c.mould_number            "
                    +"                                                  where a.CREATE_DATE >=              "
                    +"                                                      to_date('"+filterMap.get("decisionBeginTime")+"',     "
                    +"                                                              'yyyy-MM-dd')     "
                    +"                                                  and a.CREATE_DATE <=              "
                    +"                                                      to_date('"+filterMap.get("decisionEndTime")+" 23:59:59',     "
                    +"                                                              'yyyy-MM-dd HH24:mi:ss')     "
                    +"                      group by c.dept_no, zz_name                                 "
                    +"                      order by c.dept_no) aa) ab on zd.zz_name = ab.zz_name       "
                    +"  left join f_datadictionary f on f.datacode = dept_no                          "
                    +" where f.catalogcode = 'DZZZTJ'     order by (case when zd.dept_no like '%GL%' then 1 when zd.dept_no like '%YG%' then 2 "
                    +" when zd.dept_no like '%GK%' then 3 when zd.dept_no like '%HS%' then 4 when zd.dept_no like '%HD%' then 5 "
                    +" when zd.dept_no like '%ZB%' then 6 when zd.dept_no like '%ZJ%' then 7 when zd.dept_no like '%GG%' then 8 else 0 end) ";*/ 
            String sql = "select rownum cid,zzName,orgcode,orgname,sl from(                                                  "
                          +" select distinct zd.zz_name zzName, zd.dept_no orgcode, f.datavalue orgname, nvl(ab.sl,0) sl     "
                          +"                       from t_zz_dy zd                                                           "
                          +"                       left join (select aa.ZZ_NAME, aa.SL                                       "    
                                                             +" from (select c.dept_no orgcode, zz_name, count(distinct a.id) sl      "      
                                                             +"         from e_licence_citysta a                             " 
                                                             +"        inner join t_zz_mould_info b on a.mould_id = b.id     "
                                                             +"        right join t_zz_dy c on b.mould_number =              "
                                                             +"                                        c.mould_number  where 1=1      "   ; 
                                                             if(!StringUtils.isBlank((String)filterMap.get("decisionBeginTime"))){
                                                               sql = sql  +"                                    and a.CREATE_DATE >=  to_date('"+filterMap.get("decisionBeginTime")+"', 'yyyy-MM-dd') ";
                                                             };
                                                             if(!StringUtils.isBlank((String)filterMap.get("decisionEndTime"))){
                                                               sql = sql  +"                                    and a.CREATE_DATE <=  to_date('"+filterMap.get("decisionEndTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss')   "; 
                                                             } 
                                                            
                                          sql = sql  +"                         group by c.dept_no, zz_name                                        "
                                            +"                         order by c.dept_no) aa) ab on zd.zz_name = ab.zz_name              "
                                            +"     left join f_datadictionary f on f.datacode = dept_no                                   "
                                            +"    where f.catalogcode = 'DZZZTJ'     order by (case when zd.dept_no like '%GL%' then 1 when zd.dept_no like '%YG%' then 2 "
                                            +"    when zd.dept_no like '%GK%' then 3 when zd.dept_no like '%HS%' then 4 when zd.dept_no like '%HD%' then 5                "
                                            +"    when zd.dept_no like '%ZB%' then 6 when zd.dept_no like '%ZJ%' then 7 when zd.dept_no like '%GG%' then 8 else 0 end))";
            List<Object[]> subs2 = vLicensesSubDao.findObjectsBySql(sql);
            if(subs2 != null && subs2.size() > 0){
                String [] code = {"公路局","运管局","港口局","地方海事局","航道局","质监局","建设办","高管局"};
                for (int i = 0; i < code.length; i++) {
                    LicensesSub licensesSub = new LicensesSub();//每个对象
                    licensesSub.setOrgname(code[i]);
                    List<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
                    for (Object[] vls : subs2) {
                        if(code[i].equals(vls[3])){
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("zzName", vls[1]);
                            map.put("sl", vls[4]);
                            maps.add(map);
                        } 
                    }
                    licensesSub.setListOrgname(maps);
                    licensesSubs.add(licensesSub);
                }
                int hj = 0;
                for (Object[] vls : subs2) {
                    hj = hj+ Integer.parseInt(vls[4]+"");
                }
                Map<String, Object> map = new HashMap<String, Object>();
                List<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
                map.put("zzName", "");
                map.put("sl", hj);
                maps.add(map);
                LicensesSub licensesSub = new LicensesSub();//每个对象
                licensesSub.setListOrgname(maps);
                licensesSub.setOrgname("合计");
                licensesSubs.add(licensesSub);
            }
        return licensesSubs;
    }


    @Override
    public List<VLicensesSub> getVLicensesSubExport(Map<String, Object> filterMap) {
       /* String sql = "select rownum cid, zd.zz_name zzName, zd.dept_no orgcode, f.datavalue orgname, nvl(ab.sl,0) sl "
                +"  from t_zz_dy@to_jsqz zd                                                       "
                +"  left join (select aa.ZZ_NAME, aa.SL                                           "
                +"               from (select c.dept_no orgcode, zz_name, count(a.id) sl            "
                +"                       from e_licence_citysta a                              "
                +"                      inner join t_zz_mould_info b on a.mould_id = b.id "
                +"                      right join t_zz_dy c on b.mould_number =          "
                +"                                                      c.mould_number            "
                +"                                                  where a.CREATE_DATE >=              "
                +"                                                      to_date('"+filterMap.get("beginTime")+"',     "
                +"                                                              'yyyy-MM-dd')     "
                +"                                                  and a.CREATE_DATE <=              "
                +"                                                      to_date('"+filterMap.get("endTime")+"',     "
                +"                                                              'yyyy-MM-dd')     "
                +"                      group by c.dept_no, zz_name                                 "
                +"                      order by c.dept_no) aa) ab on zd.zz_name = ab.zz_name       "
                +"  left join f_datadictionary f on f.datacode = dept_no                          "
                +" where f.catalogcode = 'DZZZTJ'                                                 ";*/
        String sql = "select rownum cid,zzName,orgcode,orgname,sl from(                                                  "
                +" select distinct zd.zz_name zzName, zd.dept_no orgcode, f.datavalue orgname, nvl(ab.sl,0) sl     "
                +"                       from t_zz_dy zd                                                           "
                +"                       left join (select aa.ZZ_NAME, aa.SL                                       "    
                                                   +" from (select c.dept_no orgcode, zz_name, count(distinct a.id) sl      "      
                                                   +"         from e_licence_citysta a                             " 
                                                   +"        inner join t_zz_mould_info b on a.mould_id = b.id     "
                                                   +"        right join t_zz_dy c on b.mould_number =              "
                                                   +"                                        c.mould_number  where 1=1      "   ; 
                                                   if(!StringUtils.isBlank((String)filterMap.get("beginTime"))){
                                                     sql = sql  +"                                    and a.CREATE_DATE >=  to_date('"+filterMap.get("beginTime")+"', 'yyyy-MM-dd') ";
                                                   };
                                                   if(!StringUtils.isBlank((String)filterMap.get("endTime"))){
                                                     sql = sql  +"                                    and a.CREATE_DATE <=  to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss')   "; 
                                                   } 
                                                  
                                sql = sql  +"                         group by c.dept_no, zz_name                                        "
                                  +"                         order by c.dept_no) aa) ab on zd.zz_name = ab.zz_name              "
                                  +"     left join f_datadictionary f on f.datacode = dept_no                                   "
                                  +"    where f.catalogcode = 'DZZZTJ'     order by (case when zd.dept_no like '%GL%' then 1 when zd.dept_no like '%YG%' then 2 "
                                  +"    when zd.dept_no like '%GK%' then 3 when zd.dept_no like '%HS%' then 4 when zd.dept_no like '%HD%' then 5                "
                                  +"    when zd.dept_no like '%ZB%' then 6 when zd.dept_no like '%ZJ%' then 7 when zd.dept_no like '%GG%' then 8 else 0 end))";
        List<Object[]> subs2 = vLicensesSubDao.findObjectsBySql(sql);
        List<VLicensesSub> vLicensesSubs = new ArrayList<VLicensesSub>();
        int hj = 0;
        for (Object[] sub : subs2) {
            VLicensesSub licensesSub = new VLicensesSub();
            licensesSub.setOrgcode(sub[2]+"");
            licensesSub.setOrgname(sub[3]+"");
            licensesSub.setSl(sub[4]+"");
            licensesSub.setZzName(sub[1]+"");
            vLicensesSubs.add(licensesSub);
            hj = hj + Integer.parseInt(sub[4]+"");
        }
        VLicensesSub licensesSub = new VLicensesSub();
        licensesSub.setOrgcode("");
        licensesSub.setOrgname("合计");
        licensesSub.setSl(hj+"");
        licensesSub.setZzName("");
        vLicensesSubs.add(licensesSub);
        return vLicensesSubs;
    }
	
}


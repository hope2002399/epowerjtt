package com.centit.jtt2xyb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.Jtt2XybCf;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.bo.SqlLimit;

public class Jtt2XybCfDao extends BaseDaoImpl<Jtt2XybCf> {
	/**
     * 
     */
    private static final long serialVersionUID = 6541811816291262838L;

    @SuppressWarnings("unchecked")
    public List<Jtt2XybCf> getList(List<SqlBean> sqlBeans,int pageNo,int pageSize){
		String sqlFrame="SELECT * FROM ( SELECT A.*, ROWNUM RN "+
				" FROM ( sqltemp ) A WHERE ROWNUM <= "+(pageNo*pageSize)+" ) WHERE RN >=  "+((pageNo-1)*pageSize+1);
		
		
		String sql = " select t.cf_xdr cfxdr,t.cf_wsh cfwsh,t.cf_cfmc cfajmc,t.cf_jdrq cfsxq,t.cf_xzjg cfxzjg from l_jiaotong_xzcf@to_jttweb t where 1=1 and  ( cf_zt='0' or cf_zt=null or cf_zt='' ) and cf_syfw='0' and ( case when cf_gsjzq is null then add_months(cf_jdrq,7*12) else cf_gsjzq end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql+="order by t.cf_jdrq desc nulls last";
		
		sqlFrame=sqlFrame.replace("sqltemp", sql);
		List<Jtt2XybCf> list = (List<Jtt2XybCf>)findObjectsBySql(sql);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
    public List<Jtt2XybCf> getListForScroll(List<SqlBean> sqlBeans){
		
		
		
		String sql = " select t.cf_xdr cfxdr,t.cf_wsh cfwsh,t.cf_cfmc cfajmc,t.cf_jdrq cfsxq,t.cf_xzjg cfxzjg from l_jiaotong_xzcf@to_jttweb t where 1=1 and  ( cf_zt='0' or cf_zt=null or cf_zt='' ) and cf_syfw='0' and rksj>=sysdate-10 and ( case when cf_jdrq is null then sysdate else cf_jdrq+8 end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql+="order by t.cf_jdrq desc nulls last";
		
		List<Jtt2XybCf> list = (List<Jtt2XybCf>)findObjectsBySql(sql);
		
		return list;
	}
	@SuppressWarnings("rawtypes")
    public int getSumnum(List<SqlBean> sqlBeans){
		
		String sql = " select t.* from l_jiaotong_xzcf@to_jttweb t where 1=1 and  ( cf_zt='0' or cf_zt=null  or cf_zt='' ) and cf_syfw='0' and ( case when cf_gsjzq is null then add_months(cf_jdrq,7*12) else cf_gsjzq end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		
		List list = findObjectsBySql(sql);
		
		return list.size();
	}
	
	@SuppressWarnings("unchecked")
    public Jtt2XybCf getInfo(String id){
		String sql = " select t.cf_xdr cfxdr,t.cf_wsh cfwsh,t.cf_cfmc cfajmc,t.cf_jdrq cfsxq,t.cf_xzjg cfxzjg,t.cf_cflb1 cfzl," +
				"t.cf_sy cfsy,t.cf_yj cfyj,t.cf_xdr_shxym cfxdrshxym,t.cf_xdr_zdm cfxdrzdm,t.cf_xdr_gsdj cfxdrgsdj,t.cf_xdr_swdj cfxdrswdj," +
				"t.cf_xdr_sfz cfxdrsfz,t.cf_fr cffr,t.cf_jg cfjg,t.cf_gsjzq cfjzq,t.cf_cflb2 cfzl2,t.bz bz,t.sjc sjc,t.dfbm dfbm "+
				" from l_jiaotong_xzcf@to_jttweb t where cf_wsh= '" + id + "'";
		Jtt2XybCf cf = new Jtt2XybCf();
		List<Object[]> list = (List<Object[]>)findObjectsBySql(sql);
		if(list!=null && list.size()>0){
			cf.setCfwsh(list.get(0)[0].toString());
		}
		return cf;
	}

	public String insertData(List<Map<String, Object>> list,HttpServletResponse response,JiaoTongLog log) {
		String retMessage = "";
		String insertSql = "";
		
		String updateSql = "";
		String wsh = "";
		String msg = "";
		String message = "";
		
		int incount = 0;
		int upcount = 0;
		if(list!=null){
			try {
			
				for(int i=0;i<list.size();i++){
					wsh =  (String) list.get(i).get("CF_WSH");
					Jtt2XybCf cf =this.getInfo(wsh);
					if(cf!=null &&!StringUtils.isBlank(cf.getCfwsh())){//更新数据
					    updateSql = " update L_JIAOTONG_XZCF_TEMP@to_jttweb set CF_CFMC='"+list.get(i).get("CF_WSH")+"', CF_SY='"+list.get(i).get("CF_SY")+"', CF_CFLB1='"+list.get(i).get("CF_CFLB1")
                                +"', CF_YJ='"+list.get(i).get("CF_YJ")+"', CF_XDR='"+list.get(i).get("CF_XDR")+"', "
                                + " CF_XDR_SHXYM='"+list.get(i).get("CF_XDR_SHXYM")+"', CF_XDR_ZDM='"+list.get(i).get("CF_XDR_ZDM")+"', CF_XDR_GSDJ='"+list.get(i).get("CF_XDR_GSDJ")
                                +"', CF_XDR_SWDJ='"+list.get(i).get("CF_XDR_SWDJ")+"', CF_XDR_SFZ='"+list.get(i).get("CF_XDR_SFZ")+"', "
                                + "CF_FR='"+list.get(i).get("CF_FR")+"', CF_JG='"+list.get(i).get("CF_JG")+"', "
                                + " CF_JDRQ=to_date('"+list.get(i).get("CF_JDRQ")+"','yyyy/mm/dd HH24:MI:SS'), CF_JZQ=to_date('"+list.get(i).get("CF_JZQ")+"','yyyy/mm/dd HH24:MI:SS')," 
                                + " CF_XZJG='"+list.get(i).get("CF_XZJG")+"', CF_ZT='"+list.get(i).get("CF_ZT")+"', DFBM='"+list.get(i).get("DFBM")+"', SJC=to_date('"+list.get(i).get("SJC")+"','yyyy/mm/dd'), " 
                                + "BZ='"+list.get(i).get("BZ")+"', CF_BM='"+list.get(i).get("CF_BM")+"', CF_SYFW='"+list.get(i).get("CF_SYFW")+"', CF_SXYZCD='"+list.get(i).get("CF_SXYZCD")+"', CF_GSJZQ=to_date('"+list.get(i).get("CF_GSJZQ")+"','yyyy/mm/dd'),DATASOURCE='"+list.get(i).get("DATASOURCE")+"' where CF_WSH='"+list.get(i).get("CF_WSH")+"' ";
                    
						try{
						    super.doExecuteSql(updateSql);
							upcount++;
						} catch (Exception e) {
							msg = e.getMessage().toString();
							int a = msg.indexOf("ORA-00001");
							if(a >= 0 ){
								message += ",系统已存在文书号为\""+wsh+"\"的数据，请不要导入相同数据!";
								insertImportData(getLog(log, 2,"系统已存在文书号为\""+wsh+"\"的数据，请不要导入相同数据!"));
							}else{
								message += ",文书号为" + wsh + "的数据error：" + msg;
								insertImportData(getLog(log, 2,"文书号为" + wsh + "的数据error：" + msg));
							}
						}
					}else{//插入数据
					    insertSql = " insert into L_JIAOTONG_XZCF_TEMP@to_jttweb (CF_WSH, CF_CFMC, CF_SY, CF_CFLB1, CF_YJ, CF_XDR, "
                                + " CF_XDR_SHXYM, CF_XDR_ZDM, CF_XDR_GSDJ, CF_XDR_SWDJ, CF_XDR_SFZ, "
                                + "CF_FR, CF_JG, "
                                + " CF_JDRQ, CF_JZQ, CF_XZJG, CF_ZT, DFBM, SJC, BZ, CF_BM, CF_SYFW, CF_SXYZCD, CF_GSJZQ,DATASOURCE) "
                                + " values ( '"+list.get(i).get("CF_CFMC")+"','"+list.get(i).get("CF_SY")+"','"+list.get(i).get("CF_CFLB1")+"','"+list.get(i).get("CF_YJ")+"','"+list.get(i).get("CF_XDR")+"',"
                                + "'"+list.get(i).get("CF_XDR_SHXYM")+"','"+list.get(i).get("CF_XDR_ZDM")+"','"+list.get(i).get("CF_XDR_GSDJ")+"','"+list.get(i).get("CF_XDR_SWDJ")+"','"+list.get(i).get("CF_XDR_SFZ")+"',"
                                + "'"+list.get(i).get("CF_FR")+"','"+list.get(i).get("CF_JG")+"','"+list.get(i).get("CF_JDRQ")+"',"
                                + " to_date('"+list.get(i).get("CF_JZQ")+"','yyyy/mm/dd HH24:MI:SS'), to_date('"+list.get(i).get("CF_XZJG")+"','yyyy/mm/dd HH24:MI:SS'),'"+list.get(i).get("CF_ZT")+"','"+list.get(i).get("DFBM")+"','"+list.get(i).get("SJC")+"',"
                                + "to_date('"+list.get(i).get("BZ")+"','yyyy/mm/dd'),'"+list.get(i).get("CF_BM")+"','"+list.get(i).get("CF_SYFW")+"','"+list.get(i).get("CF_SXYZCD")+"','"+list.get(i).get("CF_GSJZQ")+"',to_date('"+list.get(i).get("DATASOURCE")+"','yyyy/mm/dd'),'"+list.get(i).get("CF_WSH")+"') ";
                      
						try{
							super.doExecuteSql(insertSql);
							incount++;
						} catch (Exception e) {
							msg = e.getMessage().toString();
							int a = msg.indexOf("ORA-00001");
							if(a >= 0 ){
								message += ",系统已存在文书号为\""+wsh+"\"的数据，请不要导入相同数据!";
								insertImportData(getLog(log, 2,"系统已存在文书号为\""+wsh+"\"的数据，请不要导入相同数据!"));
							}else{
								message += ",文书号为" + wsh + "的数据error：" + msg;
								insertImportData(getLog(log, 2,"文书号为" + wsh + "的数据error：" + msg));
							}
						}
					}
					
				}
			   insertImportData( getLog(log,1,"数据库成功导入" + incount + "条数据！" + ",更新" + upcount + "条数据！"));
			   retMessage = "数据库成功导入" + incount + "条数据！" + ",更新" + upcount + "条数据！" + message;
			   /*response.getWriter().write(retMessage);*/
			}  catch (Exception e) {
						
			}finally{  
		           
		    }  
		}
		return retMessage;
	}

	private JiaoTongLog getLog(JiaoTongLog log, int i, String string) {
		log.setId(""+System.currentTimeMillis());
		log.setDrjg(i);
		log.setErrormsg(string);
		return log;
	}

	
	@SuppressWarnings("unchecked")
    public List<Object[]> selectDataStatistics(String startTime,String endTime) {
        /*StringBuffer sb = new StringBuffer();
		sb.append(" select trim(t.unitname) xzjg,");
		sb.append("(select count(a.xk_wsh) from l_jiaotong_xzxk_temp@to_jttweb a where (instr(trim(t.unitname),substr(trim(a.xk_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.xk_xzjg),6,4))>0)  and a.datasource = '1' and a.rksj >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.rksj <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) +");
		sb.append("(select count(a.cf_wsh) from l_jiaotong_xzcf_temp@to_jttweb a where (instr(trim(t.unitname),substr(trim(a.cf_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.cf_xzjg),6,4))>0)  and a.datasource = '1' and a.rksj >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.rksj <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) cqnum,");
		sb.append("(select count(a.xk_wsh) from l_jiaotong_xzxk_temp@to_jttweb a  where (instr(trim(t.unitname),substr(trim(a.xk_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.xk_xzjg),6,4))>0) and a.datasource = '2' and a.rksj >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.rksj <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) +");
		sb.append("(select count(a.cf_wsh) from l_jiaotong_xzcf_temp@to_jttweb a where (instr(trim(t.unitname),substr(trim(a.cf_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.cf_xzjg),6,4))>0)  and a.datasource = '2' and a.rksj >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.rksj <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) drnum,");
		sb.append("(select count(a.xk_wsh) from l_jiaotong_xzxk@to_jttweb a  where (instr(trim(t.unitname),substr(trim(a.xk_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.xk_xzjg),6,4))>0) and a.sync_sign = '1' and a.SYNC_DATE >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.SYNC_DATE <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) +");
		sb.append("(select count(a.cf_wsh) from l_jiaotong_xzcf@to_jttweb a  where (instr(trim(t.unitname),substr(trim(a.cf_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.cf_xzjg),6,4))>0) and a.sync_sign = '1' and a.SYNC_DATE >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.SYNC_DATE <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) successnum,");
		sb.append("(select count(a.xk_wsh) from l_jiaotong_xzxk_temp@to_jttweb a  where (instr(trim(t.unitname),substr(trim(a.xk_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.xk_xzjg),6,4))>0) and a.check_sign = '2' and a.rksj >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.rksj <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.xk_wsh not in (select xk_wsh from l_jiaotong_xzxk@to_jttweb)) +");
		sb.append("(select count(a.cf_wsh) from l_jiaotong_xzcf_temp@to_jttweb a  where (instr(trim(t.unitname),substr(trim(a.cf_xzjg),4,4))>0 or instr(trim(t.unitname),substr(trim(a.cf_xzjg),6,4))>0) and a.check_sign = '2' and a.rksj >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.rksj <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.cf_wsh not in (select cf_wsh from l_jiaotong_xzcf@to_jttweb)) errornum");
		sb.append(" from f_unitinfo@to_jttweb t ");
		List<Object[]> list = findObjectsBySql(sb.toString());
		return list;*/
		
		String sql =" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%公路%' and a.mc not like '%高速公路%' "
		       +" union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%公路%' and a.mc not like '%高速公路%'       "
		       +"    union all    "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%公路%' and a.mc not like '%高速公路%'  "
		       +"    union all      "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%公路%' and a.mc not like '%高速公路%'       "
		       +"    union all     "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%运管%' or a.mc like '%运输管理%')      "
		       +"    union all     "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%运管%' or a.mc like '%运输管理%')          "
		       +"    union all    "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%运管%' or a.mc like '%运输管理%')     "
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%运管%' or a.mc like '%运输管理%')          "
		       +"    union all   "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%港口%' or a.xmcf like '%港口%')        "
		       +"    union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%港口%' or a.xmcf like '%港口%')            "
		       +"    union all   "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%港口%' or a.xmcf like '%港口%')       "
		       +"    union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%港口%' or a.xmcf like '%港口%')            "
		       +"    union all "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%海事%'  "
		       +"    union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%海事%'      "
		       +"    union all  "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%海事%' "
		       +"    union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%海事%'      "
		       +"    union all   "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and ( a.mc like '%航道%' or a.mc like '%船闸%' )  "
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and ( a.mc like '%航道%' or a.mc like '%船闸%' )      "
		       +"    union all  "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and ( a.mc like '%航道%' or a.mc like '%船闸%' ) "
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and ( a.mc like '%航道%' or a.mc like '%船闸%' )      "
		       +"    union all  "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%质监%'  "
		       +"    union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%质监%'      "
		       +"    union all   "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%质监%' "
		       +"    union all   "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%质监%'      "
		       +"    union all  "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%建设%' or a.wsh like '%苏交建%')   "
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%建设%' or a.wsh like '%苏交建%')       "
		       +"    union all   "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%建设%' or a.wsh like '%苏交建%')  "
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%建设%' or a.wsh like '%苏交建%')       "
		       +"    union all  "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%高速%' "
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%高速%'     "
		       +"    union all  "
		       +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%高速%'"
		       +"    union all  "
		       +" select count(1) from V_SGS_XKCF@to_jttweb a where a.check_sign = '2' and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%高速%'     ";
		         
    List<Map<String, Object>> listJttweb = findObjectsBySql(sql);
    List<Object[]> objects = new ArrayList<Object[]>();
    int a = 0;int b = 0;int c = 0;int d = 0;
    for (int i = 0; i < listJttweb.size(); i = i + 4) {
        Object [] arr = new Object[7];
        arr[0] = getUnitName(i);
        arr[1] = listJttweb.get(i)+"";  
        arr[2] = listJttweb.get(i+1)+"";
        arr[3] = listJttweb.get(i+2)+"";
        arr[4] = listJttweb.get(i+3)+"";
        arr[5] = i;
        arr[6] = Integer.parseInt(listJttweb.get(i)+"")+Integer.parseInt(listJttweb.get(i+1)+"")+Integer.parseInt(listJttweb.get(i+2)+"")+Integer.parseInt(listJttweb.get(i+3)+"");
        objects.add(arr);
        //最下面一行合计
        a = a + Integer.parseInt(listJttweb.get(i)+"");
        b = b + Integer.parseInt(listJttweb.get(i+1)+"");
        c = c + Integer.parseInt(listJttweb.get(i+2)+"");
        d = d + Integer.parseInt(listJttweb.get(i+3)+"");
    }
    Object [] hj = new Object[7];
    hj[0] = "合计";
    hj[1] = a;
    hj[2] = b;
    hj[3] = c;
    hj[4] = d;
    hj[5] = 9;
    hj[6] = a+b+c+d;
    objects.add(8, hj);
    return objects;
	}
    private String getUnitName(int i) {
        if(i == 0){
            return "江苏省交通运输厅公路局";
        }else if(i == 4){
            return "江苏省交通运输厅运输管理局";
        }else if(i == 8){
            return "江苏省交通运输厅港口局";
        }else if(i == 12){
            return "江苏省地方海事局";
        }else if(i == 16){
            return "江苏省交通运输厅航道局";
        }else if(i == 20){
            return "江苏省交通运输厅质监局";
        }else if(i == 24){
            return "江苏省交通运输厅建设管理办公室";
        }else if(i == 28){
            return "江苏省高速公路管理局";
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> selectError(String startTime,String endTime,String xzjg, String type) {
        String sql = " select wsh,check_unpass_cause unpassReason  "
                    +"from v_sgs_xkcf@to_jttweb a  where 1=1 and a.check_unpass_cause is not null ";
                    if(xzjg.equals("0")){
                       sql = sql +"  and  mc like '%"+getLikeUnitName(xzjg)+"%' and mc not like '%高速%'   ";
                    }else if(xzjg.equals("4")){
                        sql = sql +"  and (mc like '%"+getLikeUnitName(xzjg)+"%' or mc like '%运输管理%')        ";
                    }else if(xzjg.equals("16")){
                        sql = sql +"  and (mc like '%"+getLikeUnitName(xzjg)+"%' or mc like '%船闸%')        ";
                    }else if(xzjg.equals("8")){
                        sql = sql +"  and  (mc like '%"+getLikeUnitName(xzjg)+"%' or xmcf like '%港口%') ";
                    }else if(xzjg.equals("24")){
                        sql = sql +"  and  (mc like '%"+getLikeUnitName(xzjg)+"%' or xmcf like '%建设%') ";
                    }else if(xzjg.equals("12")||xzjg.equals("20")||xzjg.equals("28")){
                        sql = sql +"  and  mc like '%"+getLikeUnitName(xzjg)+"%' ";
                    }
                    sql = sql + " and flag = '"+type+"' and check_sign = '2' ";
                    sql = sql +"  and sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')    "
                    +"  and sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') order by sjc desc ";
        List<Object[]> list = findObjectsBySql(sql);
        return list;
    }

	private String getLikeUnitName(String xzjg) {
	    if(xzjg.equals("0")){
            return "公路";
        }else if(xzjg.equals("4")){
            return "运管";
        }else if(xzjg.equals("8")){
            return "港口";
        }else if(xzjg.equals("12")){
            return "海事";
        }else if(xzjg.equals("16")){
            return "航道";
        }else if(xzjg.equals("20")){
            return "质监";
        }else if(xzjg.equals("24")){
            return "建设";
        }else if(xzjg.equals("28")){
            return "高速";
        }
        return null;
    }

    public void insertImportData(JiaoTongLog log) {
		String sql = "insert into L_JIAOTONG_LOG@to_jttweb(id,USERID,FILENAME,IP,dataNum,DRJG,TYPE,errormsg ) "
				+ "	values( '"+log.getId()+"', '"+log.getUserid()+"', '"+log.getFileName()+"', '"+log.getIp()+"', '"+log.getDataNum()+"', '"+log.getDrjg()+"', '"+log.getType()+"', '"+log.getErrormsg().replaceAll("'", "")+"' )";
		super.doExecuteSql(sql.toString());
	}

    @SuppressWarnings("unchecked")
    public List<Object[]> selectDataStatisticsSdbs(String startTime,
            String endTime) {
        String sql =" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%公路%' and a.mc not like '%高速公路%' "
                +" union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%公路%' and a.mc not like '%高速公路%'       "
                +"    union all    "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%公路%' and a.mc not like '%高速公路%'  "
                +"    union all      "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%公路%' and a.mc not like '%高速公路%'       "
                +"    union all     "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%运管%' or a.mc like '%运输管理%')      "
                +"    union all     "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%运管%' or a.mc like '%运输管理%')          "
                +"    union all    "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%运管%' or a.mc like '%运输管理%')     "
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%运管%' or a.mc like '%运输管理%')          "
                +"    union all   "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%港口%' or a.xmcf like '%港口%')        "
                +"    union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%港口%' or a.xmcf like '%港口%')            "
                +"    union all   "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%港口%' or a.xmcf like '%港口%')       "
                +"    union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%港口%' or a.xmcf like '%港口%')            "
                +"    union all "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%海事%'  "
                +"    union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%海事%'      "
                +"    union all  "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%海事%' "
                +"    union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%海事%'      "
                +"    union all   "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and ( a.mc like '%航道%' or a.mc like '%船闸%' )  "
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and ( a.mc like '%航道%' or a.mc like '%船闸%' )      "
                +"    union all  "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and ( a.mc like '%航道%' or a.mc like '%船闸%' ) "
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and ( a.mc like '%航道%' or a.mc like '%船闸%' )      "
                +"    union all  "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%质监%'  "
                +"    union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%质监%'      "
                +"    union all   "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%质监%' "
                +"    union all   "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%质监%'      "
                +"    union all  "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%建设%' or a.xmcf like '%建设%')   "
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and (a.mc like '%建设%' or a.xmcf like '%建设%')       "
                +"    union all   "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%建设%' or a.xmcf like '%建设%')  "
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and (a.mc like '%建设%' or a.xmcf like '%建设%')       "
                +"    union all  "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%高速%' "
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '1' and a.mc like '%高速%'     "
                +"    union all  "
                +" select count(1) from V_l_jiaotong_xz@to_jttweb a where  a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd')  and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%高速%'"
                +"    union all  "
                +" select count(1) from V_SGS_XKCF@to_jttweb a where (a.datasource = '2' or a.datasource is null) and a.sjc >= to_date('"+startTime+"', 'yyyy-mm-dd') and a.sjc <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') and a.flag = '2' and a.mc like '%高速%'     ";
                  
     List<Map<String, Object>> listJttweb = findObjectsBySql(sql);
     List<Object[]> objects = new ArrayList<Object[]>();
     int a = 0;int b = 0;int c = 0;int d = 0;
     for (int i = 0; i < listJttweb.size(); i = i + 4) {
         Object [] arr = new Object[7];
         arr[0] = getUnitName(i);
         arr[1] = listJttweb.get(i)+"";  
         arr[2] = listJttweb.get(i+1)+"";
         arr[3] = listJttweb.get(i+2)+"";
         arr[4] = listJttweb.get(i+3)+"";
         arr[5] = i;
         arr[6] = Integer.parseInt(listJttweb.get(i)+"")+Integer.parseInt(listJttweb.get(i+1)+"")+Integer.parseInt(listJttweb.get(i+2)+"")+Integer.parseInt(listJttweb.get(i+3)+"");
         objects.add(arr);
         //最下面一行合计
         a = a + Integer.parseInt(listJttweb.get(i)+"");
         b = b + Integer.parseInt(listJttweb.get(i+1)+"");
         c = c + Integer.parseInt(listJttweb.get(i+2)+"");
         d = d + Integer.parseInt(listJttweb.get(i+3)+"");
     }
     Object [] hj = new Object[7];
     hj[0] = "合计";
     hj[1] = a;
     hj[2] = b;
     hj[3] = c;
     hj[4] = d;
     hj[5] = 9;
     hj[6] = a+b+c+d;
     objects.add(8, hj);
     return objects;
    }
}

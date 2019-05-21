package com.centit.jtt2xyb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.utils.PageDesc;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.bo.SqlLimit;
import com.centit.jtt2xyb.bo.WssbtjBo;
import com.centit.jtt2xyb.bo.WssbxzcfBo;
import com.centit.jtt2xyb.bo.WssbxzxkBo;

public class WssbtjDao extends BaseDaoImpl<WssbtjBo> {
	public List<WssbtjBo> getList(List<SqlBean> sqlBeans, int pageNo,
			int pageSize) {
		String sqlFrame = "SELECT * FROM ( SELECT A.*, ROWNUM RN "
				+ " FROM ( sqltemp ) A WHERE ROWNUM <= " + (pageNo * pageSize)
				+ " ) WHERE RN >=  " + ((pageNo - 1) * pageSize + 1);

		String sql = " select t.cf_xdr cfxdr,t.cf_wsh cfwsh,t.cf_cfmc cfajmc,t.cf_jdrq cfsxq,t.cf_xzjg cfxzjg from l_jiaotong_xzcf t where 1=1 and  ( cf_zt='0' or cf_zt=null or cf_zt='' ) and cf_syfw='0' and ( case when cf_gsjzq is null then add_months(cf_jdrq,7*12) else cf_gsjzq end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql += "order by t.cf_jdrq desc nulls last";

		sqlFrame = sqlFrame.replace("sqltemp", sql);
		List<WssbtjBo> list = (List<WssbtjBo>)findObjectsBySql(sqlFrame);

		return list;
	}

	public List<WssbtjBo> getListForScroll(List<SqlBean> sqlBeans) {

		String sql = " select t.cf_xdr cfxdr,t.cf_wsh cfwsh,t.cf_cfmc cfajmc,t.cf_jdrq cfsxq,t.cf_xzjg cfxzjg from l_jiaotong_xzcf t where 1=1 and  ( cf_zt='0' or cf_zt=null or cf_zt='' ) and cf_syfw='0' and rksj>=sysdate-10 and ( case when cf_jdrq is null then sysdate else cf_jdrq+8 end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql += "order by t.cf_jdrq desc nulls last";

		List<WssbtjBo> list = (List<WssbtjBo>)findObjectsBySql(sql);

		return list;
	}

	public int getSumnum(List<SqlBean> sqlBeans) {

		String sql = " select count(*) from l_jiaotong_xzcf t where 1=1 and  ( cf_zt='0' or cf_zt=null  or cf_zt='' ) and cf_syfw='0' and ( case when cf_gsjzq is null then add_months(cf_jdrq,7*12) else cf_gsjzq end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}

		List list = findObjectsBySql(sql);
        
        return list.size();
	}

	public WssbtjBo getInfo(String id) {
		String sql = " select t.cf_xdr cfxdr,t.cf_wsh cfwsh,t.cf_cfmc cfajmc,t.cf_jdrq cfsxq,t.cf_xzjg cfxzjg,t.cf_cflb1 cfzl,"
				+ "t.cf_sy cfsy,t.cf_yj cfyj,t.cf_xdr_shxym cfxdrshxym,t.cf_xdr_zdm cfxdrzdm,t.cf_xdr_gsdj cfxdrgsdj,t.cf_xdr_swdj cfxdrswdj,"
				+ "t.cf_xdr_sfz cfxdrsfz,t.cf_fr cffr,t.cf_jg cfjg,t.cf_gsjzq cfjzq,t.cf_cflb2 cfzl2,t.bz bz,t.sjc sjc,t.dfbm dfbm "
				+ " from l_jiaotong_xzcf t where cf_wsh=? ";
		WssbtjBo cf = new WssbtjBo();
		List<WssbtjBo> list = (List<WssbtjBo>)findObjectsBySql(sql);
		if (list != null && list.size() > 0) {
			cf = list.get(0);
		}
		return cf;
	}

	public String insertData(List<Map<String, Object>> list,
			HttpServletResponse response, JiaoTongLog log) {
		StringBuffer insertSql = new StringBuffer();
		String retMessage = "";
		insertSql
				.append(" insert into L_JIAOTONG_XZCF_TEMP (CF_WSH, CF_CFMC, CF_SY, CF_CFLB1, CF_YJ, CF_XDR, ");
		insertSql
				.append(" CF_XDR_SHXYM, CF_XDR_ZDM, CF_XDR_GSDJ, CF_XDR_SWDJ, CF_XDR_SFZ, "
						+ "CF_FR, CF_JG, ");
		insertSql
				.append(" CF_JDRQ, CF_JZQ, CF_XZJG, CF_ZT, DFBM, SJC, BZ, CF_BM, CF_SYFW, CF_SXYZCD, CF_GSJZQ,DATASOURCE) ");
		insertSql.append(" values ( ?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,");
		insertSql
				.append(" to_date(?,'yyyy/mm/dd HH24:MI:SS'), to_date(?,'yyyy/mm/dd HH24:MI:SS'),?,?,?,"
						+ "to_date(?,'yyyy/mm/dd'),?,?,?,?,to_date(?,'yyyy/mm/dd'),?) ");
		StringBuffer updateSql = new StringBuffer();
		updateSql
				.append(" update L_JIAOTONG_XZCF_TEMP set CF_CFMC=?, CF_SY=?, CF_CFLB1=?, CF_YJ=?, CF_XDR=?, ");
		updateSql
				.append(" CF_XDR_SHXYM=?, CF_XDR_ZDM=?, CF_XDR_GSDJ=?, CF_XDR_SWDJ=?, CF_XDR_SFZ=?, "
						+ "CF_FR=?, CF_JG=?, ");
		updateSql
				.append(" CF_JDRQ=to_date(?,'yyyy/mm/dd HH24:MI:SS'), CF_JZQ=to_date(?,'yyyy/mm/dd HH24:MI:SS'),"
						+ " CF_XZJG=?, CF_ZT=?, DFBM=?, SJC=to_date(?,'yyyy/mm/dd'), "
						+ "BZ=?, CF_BM=?, CF_SYFW=?, CF_SXYZCD=?, CF_GSJZQ=to_date(?,'yyyy/mm/dd'),DATASOURCE=? where CF_WSH=? ");
		String wsh = "";
		String msg = "";
		String message = "";
		Connection con = null;
		PreparedStatement pre = null;
		int incount = 0;
		int upcount = 0;
		if (list != null) {
			try {

				for (int i = 0; i < list.size(); i++) {
					wsh = (String) list.get(i).get("CF_WSH");
					WssbtjBo cf = this.getInfo(wsh);
					if (cf != null && !StringUtils.isBlank(cf.getCfwsh())) {// 更新数据
						pre = con.prepareStatement(updateSql.toString());

						pre.setString(1, (String) list.get(i).get("CF_CFMC"));
						pre.setString(2, (String) list.get(i).get("CF_SY"));
						pre.setString(3, (String) list.get(i).get("CF_CFLB1"));
						pre.setString(4, (String) list.get(i).get("CF_YJ"));

						pre.setString(5, (String) list.get(i).get("CF_XDR"));
						pre.setString(6,
								(String) list.get(i).get("CF_XDR_SHXYM"));
						pre.setString(7, (String) list.get(i).get("CF_XDR_ZDM"));
						pre.setString(8, (String) list.get(i)
								.get("CF_XDR_GSDJ"));
						pre.setString(9, (String) list.get(i)
								.get("CF_XDR_SWDJ"));

						pre.setString(10, (String) list.get(i)
								.get("CF_XDR_SFZ"));
						pre.setString(11, (String) list.get(i).get("CF_FR"));
						pre.setString(12, (String) list.get(i).get("CF_JG"));
						pre.setString(13, (String) list.get(i).get("CF_JDRQ"));
						pre.setString(14, (String) list.get(i).get("CF_JZQ"));
						pre.setString(15, (String) list.get(i).get("CF_XZJG"));
						pre.setString(16, (String) list.get(i).get("CF_ZT"));
						pre.setString(17, (String) list.get(i).get("DFBM"));
						pre.setString(18, (String) list.get(i).get("SJC"));
						pre.setString(19, (String) list.get(i).get("BZ"));
						pre.setString(20, (String) list.get(i).get("CF_BM"));
						pre.setString(21, (String) list.get(i).get("CF_SYFW"));
						pre.setString(22, (String) list.get(i).get("CF_SXYZCD"));
						pre.setString(23, (String) list.get(i).get("CF_GSJZQ"));
						pre.setString(24, (String) list.get(i)
								.get("DATASOURCE"));
						pre.setString(25, (String) list.get(i).get("CF_WSH"));
						try {
							pre.execute();
							upcount++;
						} catch (Exception e) {
							msg = e.getMessage().toString();
							int a = msg.indexOf("ORA-00001");
							if (a >= 0) {
								message += ",系统已存在文书号为\"" + wsh
										+ "\"的数据，请不要导入相同数据!";
								insertImportData(getLog(log, 2, "系统已存在文书号为\""
										+ wsh + "\"的数据，请不要导入相同数据!"));
							} else {
								message += ",文书号为" + wsh + "的数据error：" + msg;
								insertImportData(getLog(log, 2, "文书号为" + wsh
										+ "的数据error：" + msg));
							}
						}
					} else {// 插入数据
						pre = con.prepareStatement(insertSql.toString());
						pre.setString(1, (String) list.get(i).get("CF_WSH"));
						pre.setString(2, (String) list.get(i).get("CF_CFMC"));
						pre.setString(3, (String) list.get(i).get("CF_SY"));
						pre.setString(4, (String) list.get(i).get("CF_CFLB1"));
						pre.setString(5, (String) list.get(i).get("CF_YJ"));
						pre.setString(6, (String) list.get(i).get("CF_XDR"));
						pre.setString(7,
								(String) list.get(i).get("CF_XDR_SHXYM"));
						pre.setString(8, (String) list.get(i).get("CF_XDR_ZDM"));
						pre.setString(9, (String) list.get(i)
								.get("CF_XDR_GSDJ"));
						pre.setString(10,
								(String) list.get(i).get("CF_XDR_SWDJ"));
						pre.setString(11, (String) list.get(i)
								.get("CF_XDR_SFZ"));
						pre.setString(12, (String) list.get(i).get("CF_FR"));
						pre.setString(13, (String) list.get(i).get("CF_JG"));
						pre.setString(14, (String) list.get(i).get("CF_JDRQ"));
						pre.setString(15, (String) list.get(i).get("CF_JZQ"));
						pre.setString(16, (String) list.get(i).get("CF_XZJG"));
						pre.setString(17, (String) list.get(i).get("CF_ZT"));
						pre.setString(18, (String) list.get(i).get("DFBM"));
						pre.setString(19, (String) list.get(i).get("SJC"));
						pre.setString(20, (String) list.get(i).get("BZ"));
						pre.setString(21, (String) list.get(i).get("CF_BM"));
						pre.setString(22, (String) list.get(i).get("CF_SYFW"));
						pre.setString(23, (String) list.get(i).get("CF_SXYZCD"));
						pre.setString(24, (String) list.get(i).get("CF_GSJZQ"));
						pre.setString(25, (String) list.get(i)
								.get("DATASOURCE"));
						try {
							pre.execute();
							incount++;
						} catch (Exception e) {
							msg = e.getMessage().toString();
							int a = msg.indexOf("ORA-00001");
							if (a >= 0) {
								message += ",系统已存在文书号为\"" + wsh
										+ "\"的数据，请不要导入相同数据!";
								insertImportData(getLog(log, 2, "系统已存在文书号为\""
										+ wsh + "\"的数据，请不要导入相同数据!"));
							} else {
								message += ",文书号为" + wsh + "的数据error：" + msg;
								insertImportData(getLog(log, 2, "文书号为" + wsh
										+ "的数据error：" + msg));
							}
						}
					}

				}
				insertImportData(getLog(log, 1, "数据库成功导入" + incount + "条数据！"
						+ ",更新" + upcount + "条数据！"));
				retMessage = "数据库成功导入" + incount + "条数据！" + ",更新" + upcount
						+ "条数据！" + message;
				/* response.getWriter().write(retMessage); */
				con.commit();
			} catch (Exception e) {

			} finally {
				if (con != null) {
					try {
						pre.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return retMessage;
	}

	private JiaoTongLog getLog(JiaoTongLog log, int i, String string) {
		log.setId("" + System.currentTimeMillis());
		log.setDrjg(i);
		log.setErrormsg(string);
		return log;
	}

	
	public List<Map<String, Object>> selectDataStatistics(String startTime,
            String endTime) {
	    List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        String sql = "select a.unitname,nvl((a.cfzn + a.cfzw ), 0)+nvl(b.tzn + b.tfzj + b.wcfzn,0) as sbsl,"
                + " nvl(a.cfzn, 0) cfzn,nvl(a.cfzw, 0) cfzw,nvl(b.tzn, 0) tzn,nvl(b.tfzj, 0) tfzj,nvl(b.wcfzn, 0), "
                + " nvl(c.sl, 0) sl,nvl(c.bsl, 0) bsl, nvl(c.bz, 0) bz,nvl(a.orgcode, nvl(b.orgcode,nvl(c.depno,0))) from (select unitname,orgcode, count(aa.FZN) cfzn, count(aa.FZW) cfzw, depno from                                                                    "
                + " (select sum(case when ceil(TO_NUMBER(oar.update_date - oai.apply_date)) <= 5 then '1' end) as fzn, sum(case when ceil(TO_NUMBER(oar.update_date - oai.apply_date)) > 5 then'1' end) as fzw,         "
                + " oar.orgcode from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid where oar.orgcode like 'JS000000%'  and oai.sync_sign <> '6' and oar.isaccept is not null and oai.apply_date >= to_date('"
                + startTime
                + "', 'yyyy-mm-dd') and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by oar.orgcode, oar.update_date, oai.apply_date) aa                "
                + "         right join f_unitinfo@to_jttweb on orgcode = depno  where depno like 'JS000000%'  and depno <> 'JS000000'  group by depno, unitname,orgcode) a                                                                                           "
                + "  left join (select unitname, count(aa.tzn) tzn, count(aa.tfzj) tfzj, count(aa.fzw) wcfzn,  aa.orgcode from (select sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) <= 3 then '1'end) as tzn,                                                  "
                + "   sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) between 4 and 5 then '1'  end) as tfzj, sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) > 5 then '1' end) as fzw,oar.orgcode "
                + "  from (select aa.dj_id,aa.apply_date, bb.orgcode, fu.unitname from opt_apply_info@to_jttweb aa inner join opt_base_info@to_jttweb bb on aa.dj_id = bb.dj_id inner join f_unitinfo@to_jttweb fu on fu.depno = bb.orgcode               "
                + "  where aa.dj_id not in (select dj_id from opt_apply_info@to_jttweb right join opt_apply_return@to_jttweb oar on dj_id = djid where dj_id is not null and oar.isaccept is not null)) oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.dj_id where        "
                + "   oar.orgcode like 'JS000000%'  and oai.sync_sign <> '6'  and oai.apply_date >= to_date('"
                + startTime
                + "', 'yyyy-mm-dd') and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by oar.orgcode, oai.apply_date) aa right join f_unitinfo@to_jttweb on orgcode = depno where depno like 'JS000000%'  and depno <> 'JS000000'  group by aa.orgcode, unitname) b on a.depno = b.orgcode "
                + "  left join (select unitname, sum(aa.sl) sl,sum(aa.bz) bz,sum(aa.bsl) bsl,depno from (select sum(case when ISACCEPT = 1 then '1' end) as sl, sum(case when ISACCEPT = 4 then '1' end) as bz,     "
                + "   sum(case  when ISACCEPT = 0 then '1' end) as bsl, oar.orgcode from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid                                                        "
                + "    where oar.orgcode like 'JS000000%'  and oai.sync_sign <> '6'  and oai.apply_date >= to_date('"
                + startTime
                + "', 'yyyy-mm-dd') and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by oar.orgcode) aa right join f_unitinfo@to_jttweb on orgcode = depno where depno like 'JS000000%'  and depno <> 'JS000000'  group by depno, unitname) c on c.depno = a.depno               "
                + " order by (case when a.unitname like '%公路局%' then 1 when a.unitname like '%运管局%' then 2 "
                + " when a.unitname like '%港口局%' then 3 when a.unitname like '%海事局%' then 4 when a.unitname like '%航道局%' then 5 "
                + " when a.unitname like '%质监局%' then 6 when a.unitname like '%建设%' then 7 when a.unitname like '%高速公路%' then 8 else 0 end) ";
        List<Object[]> list = null;
        while(list == null){
            list = (List<Object[]>)findObjectsBySql(sql);
        }
        if(list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                Object [] slist = list.get(i);
                jsonObject.put("unitname", slist[0]);
                jsonObject.put("SBSL", slist[1]);
                
                jsonObject.put("CFZN", slist[2]);
                jsonObject.put("CFZW", slist[3]);
                
                jsonObject.put("TZN", slist[4]);
                jsonObject.put("TFZJ", slist[5]);
                jsonObject.put("WCFZN", slist[6]);
                
                jsonObject.put("SL", slist[7]);
                jsonObject.put("BSL", slist[8]);
                jsonObject.put("BZ", slist[9]);
                jsonObject.put("orgcode", slist[10]);
                returnlist.add(jsonObject);
            }
        }
        String sqlGk = "select 'GK' unitname , nvl((a.cfzn), 0)+nvl((a.cfzw), 0)+nvl((b.tzn), 0)+nvl((b.tfzj), 0)+nvl((b.wcfzn), 0)+nvl((c.sl), 0)+nvl((c.bsl), 0)+nvl((c.bz), 0) as sbsl, nvl(a.cfzn, 0) cfzn, nvl(a.cfzw, 0) cfzw,                           "
                + "nvl(b.tzn, 0) tzn, nvl(b.tfzj, 0) tfzj, nvl(b.wcfzn, 0) wcfzn, nvl(c.sl, 0) sl, nvl(c.bsl, 0) bsl, nvl(c.bz, 0) bz    "
                + " from (select sum(case when ceil(TO_NUMBER(oar.update_date - oai.apply_date)) <= 5 then '1' end) as cfzn,            "
                + " sum(case when ceil(TO_NUMBER(oar.update_date - oai.apply_date)) > 5 then'1' end) as cfzw, oar.orgcode               "
                + "   from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid where  oar.orgcode = '5'            "
                + "   and oai.sync_sign <> '6' and oai.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd')                                 "
                + "and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by oar.orgcode) a                                    "
                + "  left join (select sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) <= 3 then '1' end) as tzn,               "
                + "   sum(case  when ceil(TO_NUMBER(sysdate - oai.apply_date)) between 4 and 5 then  '1' end) as tfzj,                  "
                + "   sum(case  when ceil(TO_NUMBER(sysdate - oai.apply_date)) > 5 then '1' end) as wcfzn, oar.orgcode                  "
                + "   from (select aa.dj_id, aa.apply_date,  bb.orgcode, fu.unitname  from opt_apply_info@to_jttweb aa                             "
                + "    left join opt_base_info@to_jttweb bb on aa.dj_id = bb.dj_id left join f_unitinfo@to_jttweb fu on fu.depno =  bb.orgcode               "
                + "    where aa.dj_id not in (select dj_id from opt_apply_info@to_jttweb  right join opt_apply_return@to_jttweb on dj_id = djid              "
                + "    where dj_id is not null)) oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.dj_id  where  oar.orgcode = '5'     "
                + " and oai.sync_sign <> '6'  and oai.apply_date >=  to_date('"+startTime+"', 'yyyy-mm-dd')  and oai.apply_date <=        "
                + "to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')  group by oar.orgcode, oai.apply_date) b on a.orgcode = b.orgcode                 "
                + "  left join (select sum(case when ISACCEPT = 1 then '1' end) as sl, sum(case when ISACCEPT = 4 then '1'  end) as bz,  "
                + "  sum(case  when ISACCEPT = 0 then '1' end) as bsl, oar.orgcode from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai"
                + "   on oai.dj_id = oar.djid where  oar.orgcode = '5' and oai.sync_sign <> '6' and                                      "
                + "oai.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd') and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')       "
                + "   group by oar.orgcode) c on c.orgcode = b.orgcode";
        List<Object[]> listGk = null;
        while(listGk == null){
            listGk = (List<Object[]>)findObjectsBySql(sqlGk);
        }
        // 把orgcode等于5的加到港口局中
        if(listGk.size()>0){
            for (int i = 0; i < list.size(); i++) {
                if ("江苏省交通运输厅港口局".equals(returnlist.get(i).get("unitname"))) {
                    int sbsl = 0;
                    int cfzn = 0;
                    int cfzw = 0;
                    sbsl = Integer.parseInt(returnlist.get(i).get("SBSL").toString())
                            + Integer
                                    .parseInt(listGk.get(0)[1].toString());
                    cfzn = Integer.parseInt(returnlist.get(i).get("CFZN").toString())
                            + Integer
                                    .parseInt(listGk.get(0)[2].toString());
                    cfzw = Integer.parseInt(returnlist.get(i).get("CFZW").toString())
                            + Integer
                                    .parseInt(listGk.get(0)[3].toString());
                    returnlist.get(i).put("SBSL", sbsl);
                    returnlist.get(i).put("CFZN", cfzn);
                    returnlist.get(i).put("CFZW", cfzw);
                }
            }
        }
        String sqlZb = "select 'ZB' unitname , nvl((a.cfzn), 0)+nvl((a.cfzw), 0)+nvl((b.tzn), 0)+nvl((b.tfzj), 0)+nvl((b.wcfzn), 0)+nvl((c.sl), 0)+nvl((c.bsl), 0)+nvl((c.bz), 0) as sbsl, nvl(a.cfzn, 0) cfzn, nvl(a.cfzw, 0) cfzw,                           "
                + "nvl(b.tzn, 0) tzn, nvl(b.tfzj, 0) tfzj, nvl(b.wcfzn, 0) wcfzn, nvl(c.sl, 0) sl, nvl(c.bsl, 0) bsl, nvl(c.bz, 0) bz    "
                + " from (select sum(case when ceil(TO_NUMBER(oar.update_date - oai.apply_date)) <= 5 then '1' end) as cfzn,            "
                + " sum(case when ceil(TO_NUMBER(oar.update_date - oai.apply_date)) > 5 then'1' end) as cfzw, oar.orgcode               "
                + "   from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid where  oar.orgcode = '9'            "
                + "   and oai.sync_sign <> '6' and oai.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd')                                 "
                + "and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by oar.orgcode) a                                    "
                + "  left join (select sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) <= 3 then '1' end) as tzn,               "
                + "   sum(case  when ceil(TO_NUMBER(sysdate - oai.apply_date)) between 4 and 5 then  '1' end) as tfzj,                  "
                + "   sum(case  when ceil(TO_NUMBER(sysdate - oai.apply_date)) > 5 then '1' end) as wcfzn, oar.orgcode                  "
                + "   from (select aa.dj_id, aa.apply_date,  bb.orgcode, fu.unitname  from opt_apply_info@to_jttweb aa                             "
                + "    left join opt_base_info@to_jttweb bb on aa.dj_id = bb.dj_id left join f_unitinfo@to_jttweb fu on fu.depno =  bb.orgcode               "
                + "    where aa.dj_id not in (select dj_id from opt_apply_info@to_jttweb  right join opt_apply_return@to_jttweb on dj_id = djid              "
                + "    where dj_id is not null)) oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.dj_id  where  oar.orgcode = '9'     "
                + " and oai.sync_sign <> '6'  and oai.apply_date >=  to_date('"+startTime+"', 'yyyy-mm-dd')  and oai.apply_date <=        "
                + "to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')  group by oar.orgcode, oai.apply_date) b on a.orgcode = b.orgcode                 "
                + "  left join (select sum(case when ISACCEPT = 1 then '1' end) as sl, sum(case when ISACCEPT = 4 then '1'  end) as bz,  "
                + "  sum(case  when ISACCEPT = 0 then '1' end) as bsl, oar.orgcode from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai"
                + "   on oai.dj_id = oar.djid where  oar.orgcode = '9' and oai.sync_sign <> '6' and                                      "
                + "oai.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd') and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')       "
                + "   group by oar.orgcode) c on c.orgcode = b.orgcode";
        List<Object[]> listZb = null;
        while(listZb == null){
            listZb = (List<Object[]>)findObjectsBySql(sqlZb);
        }
        // 把orgcode等于9的加到建设局中
            if(listZb.size() > 0){
                for (int i = 0; i < list.size(); i++) {
                    if ("江苏省交通运输厅建设管理办公室".equals(returnlist.get(i).get("unitname"))) {
                        int sbsl = 0;
                        int cfzn = 0;
                        int cfzw = 0;
                        sbsl = Integer.parseInt(returnlist.get(i).get("SBSL").toString())
                                + Integer
                                        .parseInt(listZb.get(i)[1].toString());
                        cfzn = Integer.parseInt(returnlist.get(i).get("CFZN").toString())
                                + Integer
                                        .parseInt(listZb.get(i)[2].toString());
                        cfzw = Integer.parseInt(returnlist.get(i).get("CFZW").toString())
                                + Integer
                                        .parseInt(listZb.get(i)[3].toString());
                        returnlist.get(i).put("SBSL", sbsl);
                        returnlist.get(i).put("CFZN", cfzn);
                        returnlist.get(i).put("CFZW", cfzw);
                    }
                }
            }
        for (int i = 0; i < list.size(); i++) {
            if("江苏省交通运输厅公路局(高速公路路政总队)".equals(returnlist.get(i).get("unitname"))){
                returnlist.get(i).put("unitname", "江苏省交通运输厅公路局");
            }
        }
        int sbsl = 0;
        int cfzn = 0;
        int cfzw = 0;
        int tzn = 0;
        int tfzj = 0;
        int wcfzn = 0;
        int sl = 0;
        int bsl = 0;
        int bz = 0;
        for (int i = 0; i < returnlist.size(); i++) {
            sbsl += Integer.parseInt(returnlist.get(i).get("SBSL").toString());
            cfzn += Integer.parseInt(returnlist.get(i).get("CFZN").toString());
            cfzw += Integer.parseInt(returnlist.get(i).get("CFZW").toString());
            tzn += Integer.parseInt(returnlist.get(i).get("TZN").toString());
            tfzj += Integer.parseInt(returnlist.get(i).get("TFZJ").toString());
            wcfzn += Integer.parseInt(returnlist.get(i).get("WCFZN").toString());
            sl += Integer.parseInt(returnlist.get(i).get("SL").toString());
            bsl += Integer.parseInt(returnlist.get(i).get("BSL").toString());
            bz += Integer.parseInt(returnlist.get(i).get("BZ").toString());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("unitname", "总计");
        jsonObject.put("SBSL", sbsl);
        
        jsonObject.put("CFZN", cfzn);
        jsonObject.put("CFZW", cfzw);
        
        jsonObject.put("TZN", tzn);
        jsonObject.put("TFZJ", tfzj);
        jsonObject.put("WCFZN", wcfzn);
        
        jsonObject.put("SL", sl);
        jsonObject.put("BSL", bsl);
        jsonObject.put("BZ", bz);
        jsonObject.put("orgcode", "all");
        returnlist.add(jsonObject);
        return returnlist;
    }
	public List<Map<String, Object>> selectError(String startTime,
			String endTime, String xzjg) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		sb.append("select a.xk_wsh,a.xk_nr,a.check_unpass_cause from l_jiaotong_xzxk_temp a where a.xk_wsh not in (select xk_wsh from l_jiaotong_xzxk) and a.rksj >= to_date('"
				+ startTime
				+ "', 'yyyy-mm-dd')  and a.rksj <= to_date('"
				+ endTime
				+ "', 'yyyy-mm-dd') and a.check_sign = 2 and  and (instr(trim(a.xk_xzjg),substr(trim('"
				+ xzjg
				+ "'),4,4))>0 or instr(trim(a.xk_xzjg),substr(trim('"
				+ xzjg + "'),6,4))>0)");
		sb.append(" union all ");
		sb.append(" select b.cf_wsh,b.cf_sy,b.check_unpass_cause from l_jiaotong_xzcf_temp b  where  b.cf_wsh not in (select cf_wsh from l_jiaotong_xzcf) and b.rksj >= to_date('"
				+ startTime
				+ "', 'yyyy-mm-dd')  and b.rksj <= to_date('"
				+ endTime
				+ "', 'yyyy-mm-dd') and b.check_sign = 2 and (instr(trim(b.cf_xzjg),substr(trim('"
				+ xzjg
				+ "'),4,4))>0 or instr(trim(b.cf_xzjg),substr(trim('"
				+ xzjg + "'),6,4))>0)");
		List<Map<String, Object>> list = (List<Map<String, Object>>)findObjectsBySql(sb.toString(),
				map);
		return list;
	}

	public void insertImportData(JiaoTongLog log) {
		String sql = "insert into L_JIAOTONG_LOG(id,USERID,FILENAME,IP,dataNum,DRJG,TYPE,errormsg ) "
				+ "	values( :id, :userid, :fileName, :ip, :dataNum, :drjg, :type, :errormsg )";
		super.doExecuteSql(sql.toString());
	}
	
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectDataDetail(String condition){
	    List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
	    String sql = "select bas.transaffairno,bas.outitemname,bas.outitemid,bas.sync_sign,bas.powername,app.proposer_name,"
	               + " to_char(app.accept_date,'yyyy-MM-dd hh24:mi:mm'),r.note,oar.isaccept,oar.slyj,r.finish_time from opt_base_info@to_jttweb bas "
	               + " left join opt_apply_info@to_jttweb app on app.dj_id = bas.dj_id "
	               + " left join opt_apply_return@to_jttweb oar on bas.dj_id =oar.djid "
	               + " left join m_applyresult@to_jttweb r on r.internal_no = bas.dj_id"
	               + " left join am_org@to_jttweb amo on amo.idorg ='32' ||SUBSTR(bas.orgcode,'3','4') || 'JT' where 1=1 " + condition;
	    List<Object[]> list = null;
	    while(list == null){
	        list = (List<Object[]>)findObjectsBySql(sql);
	    }
	    if(list != null && list.size() > 0){
	           for (int i = 0; i < list.size(); i++) {
	               JSONObject jsonObject = new JSONObject();
	               Object [] slist = list.get(i);
	               jsonObject.put("transaffairno", slist[0]!=null?slist[0].toString():"");
                   jsonObject.put("outitemname", slist[1]!=null?slist[1].toString():"");
                   jsonObject.put("outitemid", slist[2]!=null?slist[2].toString():"");
                   jsonObject.put("sync_sign", slist[3]!=null?slist[3].toString():"");
                   jsonObject.put("powername", slist[4]!=null?slist[4].toString():"");
                   jsonObject.put("proposer_name", slist[5]!=null?slist[5].toString():"");
                   jsonObject.put("accept_date", slist[6]!=null?slist[6].toString():"");
                   jsonObject.put("note", slist[7]!=null?slist[7].toString():"");
                   jsonObject.put("isaccept", slist[8]!=null?slist[8].toString():"");
                   jsonObject.put("slyj", slist[9]!=null?slist[9].toString():"");
                   jsonObject.put("finish_time", slist[10]!=null?slist[10].toString():"");
	               returnlist.add(jsonObject);
	           }
	    }
	    return returnlist;
	}
	
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectDataAllDetail(String[] djids){
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sql = "select NO,DEPARTMENT,OUTITEMNAME,APPLICANT_NAME,APPLY_DATE from m_apply ";
        if(djids.length > 0){
            for(int i = 0;i < djids.length;i++){
                if(i == 0){
                    sql += " where no = '" + djids[i] + "'";
                }else{
                    sql = sql + " or no = '" + djids[i] + "'";
                }
                
            }
        }
        List<Object[]> list = (List<Object[]>)findObjectsBySql(sql);
        if(list != null && list.size() > 0){
               for (int i = 0; i < list.size(); i++) {
                   JSONObject jsonObject = new JSONObject();
                   Object [] slist = list.get(i);
                   jsonObject.put("transaffairno", slist[0]!=null?slist[0].toString():"");
                   jsonObject.put("powername", slist[1]!=null?slist[1].toString():"");
                   jsonObject.put("outitemname", slist[2]!=null?slist[2].toString():"");
                   jsonObject.put("proposer_name", slist[3]!=null?slist[3].toString():"");
                   jsonObject.put("accept_date", slist[4]!=null?slist[4].toString():"");
                   returnlist.add(jsonObject);
               }
        }
        return returnlist;
    }
	
	/**
     * 统计8张表中每个业务项的办件情况
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getYwInfHadCountStat(String startTime, String endTime) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select am.deptregno,am.yw_name,am.sh,am.city,am.qu,am.sh+am.city+am.qu allcount,to_char(yw.sh),to_char(yw.city),to_char(yw.qu) from("
                    + " select am.deptRegNo,am.yw_name,sum(case when substr(m.item_id, 33, 1) = '0' or substr(m.item_id, 33, 1) = '1' or substr(m.outitemid, 33, 1) = '0' or substr(m.outitemid, 33, 1) = '1' then 1 else 0 end) sh,"
                    + " sum(case when substr(m.item_id, 33, 1) = '2' or substr(m.item_id, 33, 1) = '3' or substr(m.outitemid, 33, 1) = '2' or substr(m.outitemid, 33, 1) = '3' then 1 else 0 end) city,"
                    + " sum(case when substr(m.item_id, 33, 1) = '4' or substr(m.item_id, 33, 1) = '5' or substr(m.outitemid, 33, 1) = '4' or substr(m.outitemid, 33, 1) = '5' then 1 else 0 end) qu from("
                    + " select am.deptRegNo,yw.yw_name from"
                    + " (select substr(yw.dept_yw_reg_no,23,10) ||"
                    + " (case when yw.dept_yw_num is null then substr(yw.dept_yw_reg_no, 34, 1) else substr(yw.dept_yw_num, 2, 1) end) deptRegNo, "
                    + " wm_concat(yw.dept_yw_reg_no) regNoCont from dept_yw_inf yw where yw.update_type != 3 and length(yw.dept_yw_reg_no) = 34"
                    + " group by substr(yw.dept_yw_reg_no,23,10) || (case when yw.dept_yw_num is null then substr(yw.dept_yw_reg_no,34,1) else substr(yw.dept_yw_num,2,1) end)"
                    + " ) am left join dept_yw_inf yw on yw.dept_yw_reg_no = to_char(substr(am.regNoCont,1,34)) "
                    + " where yw.update_type != 3) am left join m_apply m on "
                    + " am.deptRegNo = substr((case when length(m.outitemid) = 34 then m.outitemid else m.item_id end),23,10)"
                    + " || substr((case when length(m.outitemid) = 34 then m.outitemid else m.item_id end),34,1)"
                    + " where m.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and m.apply_date <= to_date('"+endTime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')"
                    + " group by am.deptRegNo,am.yw_name order by am.deptRegNo) am left join (select am.deptRegNo,"
                    + " (case when instr(am.regNoCont, '00,') > 0 or instr(am.regNoCont, '01,') > 0 or instr(am.regNoCont, '02,') > 0 or"
                    + " instr(am.regNoCont, '03,') > 0 or instr(am.regNoCont, '04,') > 0 or instr(am.regNoCont, '05,') > 0 or instr(am.regNoCont, '06,') > 0 or"
                    + " instr(am.regNoCont, '07,') > 0 or instr(am.regNoCont, '08,') > 0 or instr(am.regNoCont, '09,') > 0 or instr(am.regNoCont, '10,') > 0 or"
                    + " instr(am.regNoCont, '11,') > 0 or instr(am.regNoCont, '12,') > 0 or instr(am.regNoCont, '13,') > 0 or instr(am.regNoCont, '14,') > 0 or"
                    + " instr(am.regNoCont, '15,') > 0 or instr(am.regNoCont, '16,') > 0 or instr(am.regNoCont, '17,') > 0 or instr(am.regNoCont, '18,') > 0 or"
                    + " instr(am.regNoCont, '19,') > 0 then 1 else 0 end) sh,(case when instr(am.regNoCont,'31,') > 0 or instr(am.regNoCont,'32,') > 0 or instr(am.regNoCont,'30,') > 0"
                    + " or instr(am.regNoCont,'33,') > 0 or instr(am.regNoCont,'34,') > 0 or instr(am.regNoCont,'35,') > 0 or instr(am.regNoCont,'36,') > 0"
                    + " or instr(am.regNoCont,'37,') > 0 or instr(am.regNoCont,'38,') > 0 or instr(am.regNoCont,'39,') > 0 or instr(am.regNoCont,'20,') > 0"
                    + " or instr(am.regNoCont,'21,') > 0 or instr(am.regNoCont,'22,') > 0 or instr(am.regNoCont,'23,') > 0 or instr(am.regNoCont,'24,') > 0"
                    + " or instr(am.regNoCont,'25,') > 0 or instr(am.regNoCont,'26,') > 0 or instr(am.regNoCont,'27,') > 0 or instr(am.regNoCont,'28,') > 0"
                    + " or instr(am.regNoCont,'29,') > 0 then 1 else 0 end) city,(case when instr(am.regNoCont,'41,') > 0 or instr(am.regNoCont,'42,') > 0 or instr(am.regNoCont,'40,') > 0"
                    + " or instr(am.regNoCont,'43,') > 0 or instr(am.regNoCont,'44,') > 0 or instr(am.regNoCont,'45,') > 0 or instr(am.regNoCont,'46,') > 0"
                    + " or instr(am.regNoCont,'47,') > 0 or instr(am.regNoCont,'48,') > 0 or instr(am.regNoCont,'49,') > 0 or instr(am.regNoCont,'50,') > 0"
                    + " or instr(am.regNoCont,'51,') > 0 or instr(am.regNoCont,'52,') > 0 or instr(am.regNoCont,'53,') > 0 or instr(am.regNoCont,'54,') > 0"
                    + " or instr(am.regNoCont,'55,') > 0 or instr(am.regNoCont,'56,') > 0 or instr(am.regNoCont,'57,') > 0 or instr(am.regNoCont,'58,') > 0"
                    + " or instr(am.regNoCont,'59,') > 0 then 1 else 0 end) qu from (select substr(yw.dept_yw_reg_no, 23, 10) ||"
                    + " (case when yw.dept_yw_num is null then substr(yw.dept_yw_reg_no, 34, 1) else substr(yw.dept_yw_num, 2, 1) end) deptRegNo,wm_concat(yw.dept_yw_reg_no) || ',' regNoCont"
                    + " from dept_yw_inf yw where yw.update_type != 3 and length(yw.dept_yw_reg_no) = 34 group by substr(yw.dept_yw_reg_no, 23, 10) ||"
                    + " (case when yw.dept_yw_num is null then substr(yw.dept_yw_reg_no, 34, 1) else substr(yw.dept_yw_num, 2, 1) end)) am"
                    + " left join dept_yw_inf yw on yw.dept_yw_reg_no =to_char(substr(am.regNoCont,1,34)) "
                    + " where yw.update_type != 3) yw on am.deptRegNo = yw.deptRegNo order by allcount desc";
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("ywName", slist[1]!=null?slist[1]:"");
                       if(slist[6].toString().equals("1")){
                           jsonObject.put("deptregno", slist[0]!=null?slist[0].toString().substring(0,10) + "0" + slist[0].toString().substring(10,11):"");
                       }else if(slist[7].toString().equals("1")){
                           jsonObject.put("deptregno", slist[0]!=null?slist[0].toString().substring(0,10) + "2" + slist[0].toString().substring(10,11):"");
                       }else{
                           jsonObject.put("deptregno", slist[0]!=null?slist[0].toString().substring(0,10) + "4" + slist[0].toString().substring(10,11):"");
                       }
                       int count = 0;
                       if(slist[6].toString().equals("0")){
                           jsonObject.put("sh", "-");
                       }else{
                           jsonObject.put("sh", slist[2]!=null?slist[2]:"0");
                           count += Integer.parseInt(slist[2].toString());
                       }
                       if(slist[7].toString().equals("0")){
                           jsonObject.put("city", "-");
                       }else{
                           jsonObject.put("city", slist[3]!=null?slist[3]:"0");
                           count += Integer.parseInt(slist[3].toString());
                       }
                       if(slist[8].toString().equals("0")){
                           jsonObject.put("qu", "-");
                       }else{
                           jsonObject.put("qu", slist[4]!=null?slist[4]:"0");
                           count += Integer.parseInt(slist[4].toString());
                       }
                       jsonObject.put("allcount", slist[5]!=null?slist[5]:"0");
                       jsonObject.put("heji", count);
                       returnlist.add(jsonObject);
               }
        }
        return returnlist;
    }
	
	/**
     * 不见面清单数量统计
     * @param startTime
     * @param endTime
     * @return
     */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> getNotMeetDetailList(String startTime, String endTime) {
	    List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
	    String sqls = "select areano,orgname,ywcount,exywcount,nvl(part,''),parentno from "
	                + " (select ic.idorg areano,ic.orgname,count(yw.ql_dept) ywcount,count(ex.iddept_yw_inf) exywcount,"
	                + " decode(count(yw.ql_dept),0,'0%',to_char(round(count(ex.iddept_yw_inf)/count(yw.ql_dept),4)*100||'%')) part,substr(ic.idarea_code,0,4) || '00' parentno from am_org ic"
	                + " left join dept_yw_inf yw on yw.ql_dept = ic.idorg"
	                + " left join (select ex.iddept_yw_inf from dept_yw_inf_expand ex where ex.dao_xc_num = '0') ex on ex.iddept_yw_inf = yw.iddept_yw_inf"
	                + " where  idorg like '%JT%' and orgshortname not like '%建设局%' and substr(yw.dept_yw_reg_no, 23, 2) in ('01', '07', '10','05', '06', '04','11') "
	                + " and length(yw.DEPT_YW_REG_NO) = 34 and yw.update_type != '3' group by ic.idorg,ic.idarea_code,ic.orgname union all "
	                + " select a.no,a.areaname,sum(countTmp.ywcount),sum(countTmp.exywcount),"
	                + " decode(sum(countTmp.ywcount),0,'0%',to_char(round(sum(countTmp.exywcount)/sum(countTmp.ywcount),4)*100||'%')) part,'' from area@to_jttweb a "
	                + " left join (select areano,orgname,ywcount,exywcount,nvl(part,''),parentno from "
	                + " (select ic.idorg areano,ic.orgname,count(yw.ql_dept) ywcount,count(ex.iddept_yw_inf) exywcount,"
	                + " decode(count(yw.ql_dept),0,'0%',to_char(round(count(ex.iddept_yw_inf)/count(yw.ql_dept),4)*100||'%')) part,"
	                + " substr(ic.idarea_code,0,4) || '00' parentno from am_org ic"
	                + " left join dept_yw_inf yw on yw.ql_dept = ic.idorg left join (select ex.iddept_yw_inf "
	                + " from dept_yw_inf_expand ex where ex.dao_xc_num = '0') ex on ex.iddept_yw_inf = yw.iddept_yw_inf"
	                + " where  idorg like '%JT%' and orgshortname not like '%建设局%' and substr(yw.dept_yw_reg_no, 23, 2) in ('01', '07', '10','05', '06', '04','11') "
	                + " and length(yw.DEPT_YW_REG_NO) = 34 and yw.update_type != '3' group by ic.idorg,ic.idarea_code,ic.orgname)) countTmp on "
	                + " countTmp.parentno = a.no where substr(a.no,5,2) = '00' group by a.no,a.areaname) order by areano,ywcount";
	    List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
	    if(listRes != null && listRes.size() > 0){
	           for (int i = 0; i < listRes.size(); i++) {
	                   Object [] slist = listRes.get(i);
	                   JSONObject jsonObject = new JSONObject();
	                   jsonObject.put("childNo", slist[0]);
                       jsonObject.put("orgname", slist[1]);
                       jsonObject.put("ywcount", slist[2]);
                       jsonObject.put("exywcount", slist[3]);
                       jsonObject.put("proportion", slist[4]!=null?slist[4]:"");
                       jsonObject.put("parentNo", slist[5]);
                       returnlist.add(jsonObject);
	           }
	    }
	    return returnlist;
	}
	
	/**
     * 查找当事人为个人且当事人证件号码无效的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getErrorList(String startTime, String endTime) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls =  "select * from(select a.idarea_code || '1' no,a.orgname,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0),"
                    + " decode(substr(a.idarea_code, -4, 2),'00','',substr(a.idarea_code, 0, 4) || '00') parentno from am_org a left join ("
                    + " select yw.ql_dept,sum(case when b.orgcode = 'GL' then 1 else 0 end) GL,sum(case when b.orgcode = 'YG' then 1 else 0 end) YG, "
                    + " sum(case when b.orgcode = 'GK' then 1 else 0 end) GK,sum(case when b.orgcode = 'HS' then 1 else 0 end) HS,"
                    + " sum(case when b.orgcode = 'HD' then 1 else 0 end) HD,sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ,"
                    + " sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB,sum(case when b.orgcode = 'GG' then 1 else 0 end) GG from Bn_Inf_Apply t "
                    + " left join dept_yw_inf yw on yw.dept_yw_reg_no = t.dept_yw_reg_no "
                    + " left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yw.update_type != 3 and "
                    + " t.applicant_type = '1' and (((t.applicant_paper_type = '0' or t.applicant_paper_type = '8')"
                    + "  and length(t.applicant_paper_code) != 15 and length(t.applicant_paper_code) != 18) or "
                    + " ((t.linkman_paper_type = '0' or t.linkman_paper_type = '8') "
                    + " and length(t.linkman_paper_code) != 15 and length(t.linkman_paper_code) != 18)) "
                    + " and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+" 23:59:59','yyyy-MM-dd hh24:mi:ss') group by ql_dept ) t  on t.ql_dept = a.idorg "
                    + " where a.idorg like '%JT%' and (a.orgshortname like '%交通%' or a.orgshortname like '%港口%' or a.orgshortname like '%交运%') union all select a.idarea_code,a.orgname,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0),"
                    + " '' parentno from am_org a left join ("
                    + " select substr(t.area_no,0,4) || '00' area_no,sum(case when b.orgcode = 'GL' then 1 else 0 end) GL,sum(case when b.orgcode = 'YG' then 1 else 0 end) YG, "
                    + " sum(case when b.orgcode = 'GK' then 1 else 0 end) GK,sum(case when b.orgcode = 'HS' then 1 else 0 end) HS,"
                    + " sum(case when b.orgcode = 'HD' then 1 else 0 end) HD,sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ,"
                    + " sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB,sum(case when b.orgcode = 'GG' then 1 else 0 end) GG from Bn_Inf_Apply t "
                    + " left join dept_yw_inf yw on yw.dept_yw_reg_no = t.dept_yw_reg_no "
                    + " left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yw.update_type != 3 and "
                    + " t.applicant_type = '1' and (((t.applicant_paper_type = '0' or t.applicant_paper_type = '8')"
                    + "  and length(t.applicant_paper_code) != 15 and length(t.applicant_paper_code) != 18) or "
                    + " ((t.linkman_paper_type = '0' or t.linkman_paper_type = '8') "
                    + " and length(t.linkman_paper_code) != 15 and length(t.linkman_paper_code) != 18)) "
                    + "and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+" 23:59:59','yyyy-MM-dd hh24:mi:ss') group by substr(t.area_no,0,4) ) t  on t.area_no = a.idarea_code"
                    + " where substr(a.idarea_code,-2,2) = '00' and a.idarea_code != '320000' and a.idorg like '%JT%' and (a.orgshortname like '%交通%' or a.orgshortname like '%交运%')) order by no";
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glcount = 0;
        int ygcount = 0;
        int gkcount = 0;
        int hscount = 0;
        int hdcount = 0;
        int zjcount = 0;
        int zbcount = 0;
        int ggcount = 0;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("areaNo", slist[0]);
                       jsonObject.put("areaName", slist[1]);
                       jsonObject.put("gl", slist[2]);
                       jsonObject.put("yg", slist[3]);
                       jsonObject.put("gk", slist[4]);
                       jsonObject.put("hs", slist[5]);
                       jsonObject.put("hd", slist[6]);
                       jsonObject.put("zj", slist[7]);
                       jsonObject.put("zb", slist[8]);
                       jsonObject.put("gg", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
                       if(StringUtils.isNoneBlank((String)slist[10]) || slist[1].toString().indexOf("江苏省") != -1){
                           glcount += slist[2]!=null?Integer.parseInt(slist[2].toString()):0;
                           ygcount += slist[3]!=null?Integer.parseInt(slist[3].toString()):0;
                           gkcount += slist[4]!=null?Integer.parseInt(slist[4].toString()):0;
                           hscount += slist[5]!=null?Integer.parseInt(slist[5].toString()):0;
                           hdcount += slist[6]!=null?Integer.parseInt(slist[6].toString()):0;
                           zjcount += slist[7]!=null?Integer.parseInt(slist[7].toString()):0;
                           zbcount += slist[8]!=null?Integer.parseInt(slist[8].toString()):0;
                           ggcount += slist[9]!=null?Integer.parseInt(slist[9].toString()):0;
                       }
               }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaNo", "");
        jsonObject.put("areaName", "合计");
        jsonObject.put("gl", glcount);
        jsonObject.put("yg", ygcount);
        jsonObject.put("gk", gkcount);
        jsonObject.put("hs", hscount);
        jsonObject.put("hd", hdcount);
        jsonObject.put("zj", zjcount);
        jsonObject.put("zb", zbcount);
        jsonObject.put("gg", ggcount);
        jsonObject.put("parentNo", "");
        returnlist.add(jsonObject);
        return returnlist;
    }
    
    /**
     * 查找当事人为法人，当事人证件号码或联系人证件号码无效的数据
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getLegalErrorList(String startTime, String endTime) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls =  "select * from(select a.idarea_code || '1' no,a.orgname,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0),"
                    + " decode(substr(a.idarea_code, -4, 2),'00','',substr(a.idarea_code, 0, 4) || '00') parentno from am_org a left join ("
                    + " select yw.ql_dept,sum(case when b.orgcode = 'GL' then 1 else 0 end) GL,sum(case when b.orgcode = 'YG' then 1 else 0 end) YG, "
                    + " sum(case when b.orgcode = 'GK' then 1 else 0 end) GK,sum(case when b.orgcode = 'HS' then 1 else 0 end) HS,"
                    + " sum(case when b.orgcode = 'HD' then 1 else 0 end) HD,sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ,"
                    + " sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB,sum(case when b.orgcode = 'GG' then 1 else 0 end) GG from Bn_Inf_Apply t "
                    + " left join dept_yw_inf yw on yw.dept_yw_reg_no = t.dept_yw_reg_no "
                    + " left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yw.update_type != 3 and "
                    + " t.applicant_type != '1' and (((t.applicant_paper_type = '0' or t.applicant_paper_type = '8')"
                    + "  and length(t.applicant_paper_code) != 15 and length(t.applicant_paper_code) != 18) or "
                    + " ((t.linkman_paper_type = '0' or t.linkman_paper_type = '8') "
                    + " and length(t.linkman_paper_code) != 15 and length(t.linkman_paper_code) != 18)) "
                    + " and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+" 23:59:59','yyyy-MM-dd hh24:mi:ss') group by ql_dept ) t  on t.ql_dept = a.idorg "
                    + " where a.idorg like '%JT%' and (a.orgshortname like '%交通%' or a.orgshortname like '%港口%' or a.orgshortname like '%交运%') union all select a.idarea_code,a.orgname,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0),"
                    + " '' parentno from am_org a left join ("
                    + " select substr(t.area_no,0,4) || '00' area_no,sum(case when b.orgcode = 'GL' then 1 else 0 end) GL,sum(case when b.orgcode = 'YG' then 1 else 0 end) YG, "
                    + " sum(case when b.orgcode = 'GK' then 1 else 0 end) GK,sum(case when b.orgcode = 'HS' then 1 else 0 end) HS,"
                    + " sum(case when b.orgcode = 'HD' then 1 else 0 end) HD,sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ,"
                    + " sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB,sum(case when b.orgcode = 'GG' then 1 else 0 end) GG from Bn_Inf_Apply t "
                    + " left join dept_yw_inf yw on yw.dept_yw_reg_no = t.dept_yw_reg_no "
                    + " left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yw.update_type != 3 and "
                    + " t.applicant_type != '1' and (((t.applicant_paper_type = '0' or t.applicant_paper_type = '8')"
                    + "  and length(t.applicant_paper_code) != 15 and length(t.applicant_paper_code) != 18) or "
                    + " ((t.linkman_paper_type = '0' or t.linkman_paper_type = '8') "
                    + " and length(t.linkman_paper_code) != 15 and length(t.linkman_paper_code) != 18)) "
                    + "and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+" 23:59:59','yyyy-MM-dd hh24:mi:ss') group by substr(t.area_no,0,4) ) t  on t.area_no = a.idarea_code"
                    + " where substr(a.idarea_code,-2,2) = '00' and a.idarea_code != '320000' and a.idorg like '%JT%' and (a.orgshortname like '%交通%' or a.orgshortname like '%交运%')) order by no";
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glcount = 0;
        int ygcount = 0;
        int gkcount = 0;
        int hscount = 0;
        int hdcount = 0;
        int zjcount = 0;
        int zbcount = 0;
        int ggcount = 0;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("areaNo", slist[0]);
                       jsonObject.put("areaName", slist[1]);
                       jsonObject.put("gl", slist[2]);
                       jsonObject.put("yg", slist[3]);
                       jsonObject.put("gk", slist[4]);
                       jsonObject.put("hs", slist[5]);
                       jsonObject.put("hd", slist[6]);
                       jsonObject.put("zj", slist[7]);
                       jsonObject.put("zb", slist[8]);
                       jsonObject.put("gg", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
                       if(StringUtils.isNoneBlank((String)slist[10]) || slist[1].toString().indexOf("江苏省") != -1){
                           glcount += slist[2]!=null?Integer.parseInt(slist[2].toString()):0;
                           ygcount += slist[3]!=null?Integer.parseInt(slist[3].toString()):0;
                           gkcount += slist[4]!=null?Integer.parseInt(slist[4].toString()):0;
                           hscount += slist[5]!=null?Integer.parseInt(slist[5].toString()):0;
                           hdcount += slist[6]!=null?Integer.parseInt(slist[6].toString()):0;
                           zjcount += slist[7]!=null?Integer.parseInt(slist[7].toString()):0;
                           zbcount += slist[8]!=null?Integer.parseInt(slist[8].toString()):0;
                           ggcount += slist[9]!=null?Integer.parseInt(slist[9].toString()):0;
                       }
               }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaNo", "");
        jsonObject.put("areaName", "合计");
        jsonObject.put("gl", glcount);
        jsonObject.put("yg", ygcount);
        jsonObject.put("gk", gkcount);
        jsonObject.put("hs", hscount);
        jsonObject.put("hd", hdcount);
        jsonObject.put("zj", zjcount);
        jsonObject.put("zb", zbcount);
        jsonObject.put("gg", ggcount);
        jsonObject.put("parentNo", "");
        returnlist.add(jsonObject);
        return returnlist;
    }
    
    /**
     * 上报时间不在24小时之内
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOvertimeErrorList(String startTime, String endTime) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select * from (select a.idarea_code || '1' no,a.orgname,"
                + " nvl(t.gl, 0),nvl(t.yg, 0),nvl(t.gk, 0),nvl(t.hs, 0),nvl(t.hd, 0),nvl(t.zj, 0),nvl(t.zb, 0),nvl(t.gg, 0),"
                + " decode(substr(a.idarea_code, -4, 2),'00','',substr(a.idarea_code, 0, 4) || '00') parentno"
                + " from am_org a"
                + " left join (select substr(replace(t.org_id,'JS','32'),0,6) orgid,count(gl.no) gl,count(yg.no) yg,count(gk.no) gk,count(hs.no) hs,count(hd.no) hd,"
                + " count(zj.no) zj,count(zb.no) zb,count(gg.no) gg from INF_APPLY@to_jsqz t"
                + " left join INF_APPLY@to_jsqz gl on gl.no = t.no and gl.org_id like '%GL%'"
                + " left join INF_APPLY@to_jsqz yg on yg.no = t.no and yg.org_id like '%YG%'"
                + " left join INF_APPLY@to_jsqz gk on gk.no = t.no and gk.org_id like '%GK%'"
                + " left join INF_APPLY@to_jsqz hs on hs.no = t.no and hs.org_id like '%HS%'"
                + " left join INF_APPLY@to_jsqz hd on hd.no = t.no and hd.org_id like '%HD%'"
                + " left join INF_APPLY@to_jsqz zj on zj.no = t.no and zj.org_id like '%ZJ%'"
                + " left join INF_APPLY@to_jsqz zb on zb.no = t.no and zb.org_id like '%ZB%'"
                + " left join INF_APPLY@to_jsqz gg on gg.no = t.no and gg.org_id like '%GG%'"
                + " where  t.apply_date < t.update_date - 1 and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+"','yyyy-MM-dd')"
                + " group by substr(replace(t.org_id,'JS','32'),0,6)) t on a.idarea_code = orgid where a.idorg like '%JT%' and (a.orgshortname like '%交通%' or a.orgshortname like '%交运%') and a.orgshortname not like  '%港口管理局%' "
                + " union all select a.idarea_code,a.orgname,"
                + " nvl(t.gl, 0),nvl(t.yg, 0),nvl(t.gk, 0),nvl(t.hs, 0),nvl(t.hd, 0),nvl(t.zj, 0),nvl(t.zb, 0),nvl(t.gg, 0),'' parentno"
                + " from am_org a left join (select substr(replace(t.org_id,'JS','32'),0,4) || '00' orgid,count(gl.no) gl,"
                + " count(yg.no) yg,count(gk.no) gk,count(hs.no) hs,count(hd.no) hd,"
                + " count(zj.no) zj,count(zb.no) zb,count(gg.no) gg from INF_APPLY@to_jsqz t"
                + " left join INF_APPLY@to_jsqz gl on gl.no = t.no and gl.org_id like '%GL%'"
                + " left join INF_APPLY@to_jsqz yg on yg.no = t.no and yg.org_id like '%YG%'"
                + " left join INF_APPLY@to_jsqz gk on gk.no = t.no and gk.org_id like '%GK%'"
                + " left join INF_APPLY@to_jsqz hs on hs.no = t.no and hs.org_id like '%HS%'"
                + " left join INF_APPLY@to_jsqz hd on hd.no = t.no and hd.org_id like '%HD%'"
                + " left join INF_APPLY@to_jsqz zj on zj.no = t.no and zj.org_id like '%ZJ%'"
                + " left join INF_APPLY@to_jsqz zb on zb.no = t.no and zb.org_id like '%ZB%'"
                + " left join INF_APPLY@to_jsqz gg on gg.no = t.no and gg.org_id like '%GG%'"
                + " where  t.apply_date < t.update_date - 1 and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+"','yyyy-MM-dd')"
                + " group by substr(replace(t.org_id,'JS','32'),0,4) || '00') t on t.orgid = a.idarea_code where substr(a.idarea_code, -2, 2) = '00' and a.idarea_code != '320000' and a.idorg like '%JT%' and (a.orgshortname like '%交通%' or a.orgshortname like '%交运%')  and a.orgshortname not like  '%港口管理局%'"
                + " union all select a.idarea_code || '11' no,a.orgname,"
                + " 0,0,nvl(t.gk, 0),0,0,0,0,0,substr(a.idarea_code,0,4) || '00' parentno"
                + " from am_org a left join (select substr(replace(t.org_id,'JS','32'),0,4) || '00' orgid,count(t.no) gk "
                + " from INF_APPLY@to_jsqz t where t.org_id like '%PT%' "
                + " and t.apply_date < t.update_date - 1 and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+"','yyyy-MM-dd')"
                + " group by substr(replace(t.org_id,'JS','32'),0,4) || '00') t on t.orgid = a.idarea_code where a.idarea_code != '320000' and a.idorg like '%JT%' and (a.orgshortname like '%港口%')) order by no";
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glcount = 0;
        int ygcount = 0;
        int gkcount = 0;
        int hscount = 0;
        int hdcount = 0;
        int zjcount = 0;
        int zbcount = 0;
        int ggcount = 0;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("areaNo", slist[0]);
                       jsonObject.put("areaName", slist[1]);
                       jsonObject.put("gl", slist[2]);
                       jsonObject.put("yg", slist[3]);
                       jsonObject.put("gk", slist[4]);
                       jsonObject.put("hs", slist[5]);
                       jsonObject.put("hd", slist[6]);
                       jsonObject.put("zj", slist[7]);
                       jsonObject.put("zb", slist[8]);
                       jsonObject.put("gg", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
                       if(StringUtils.isNoneBlank((String)slist[10]) || slist[1].toString().indexOf("江苏省") != -1){
                           glcount += slist[2]!=null?Integer.parseInt(slist[2].toString()):0;
                           ygcount += slist[3]!=null?Integer.parseInt(slist[3].toString()):0;
                           gkcount += slist[4]!=null?Integer.parseInt(slist[4].toString()):0;
                           hscount += slist[5]!=null?Integer.parseInt(slist[5].toString()):0;
                           hdcount += slist[6]!=null?Integer.parseInt(slist[6].toString()):0;
                           zjcount += slist[7]!=null?Integer.parseInt(slist[7].toString()):0;
                           zbcount += slist[8]!=null?Integer.parseInt(slist[8].toString()):0;
                           ggcount += slist[9]!=null?Integer.parseInt(slist[9].toString()):0;
                       }
               }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaNo", "");
        jsonObject.put("areaName", "合计");
        jsonObject.put("gl", glcount);
        jsonObject.put("yg", ygcount);
        jsonObject.put("gk", gkcount);
        jsonObject.put("hs", hscount);
        jsonObject.put("hd", hdcount);
        jsonObject.put("zj", zjcount);
        jsonObject.put("zb", zbcount);
        jsonObject.put("gg", ggcount);
        jsonObject.put("parentNo", "");
        returnlist.add(jsonObject);
        return returnlist;
    }
    
    /**
     * 34位业务编码不在8张表之内
     * @param startTime
     * @param endTime
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getNonErrorList(String startTime, String endTime) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select * from(select a.no || '1' no,a.areaname,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0),"
                    + " decode(substr(a.no, -4, 2),'00','',substr(a.no, 0, 4) || '00') parentno from area@to_jttweb a left join ("
                    + " select t.area_no,count(gl.area_no) gl,count(yg.area_no) yg,count(gk.area_no) gk,count(hs.area_no) hs,count(hd.area_no) hd "
                    + " ,count(zj.area_no) zj,count(zb.area_no) zb,count(gg.area_no) gg,decode(substr(t.area_no,-2,2),'00','',substr(t.area_no,0,4) || '00') parentno from Bn_Inf_Apply t "
                    + " left join bn_inf_apply gl on t.no=gl.no and gl.org_name like '%公路%' "
                    + " left join bn_inf_apply yg on t.no=yg.no and yg.org_name like '%运管%' "
                    + " left join bn_inf_apply gk on t.no=gk.no and gk.org_name like '%港口%' "
                    + " left join bn_inf_apply hs on t.no=hs.no and hs.org_name like '%海事%' "
                    + " left join bn_inf_apply hd on t.no=hd.no and hd.org_name like '%航道%' "
                    + " left join bn_inf_apply zj on t.no=zj.no and zj.org_name like '%质监%' "
                    + " left join bn_inf_apply zb on t.no=zb.no and zb.org_name like '%建设%' "
                    + " left join bn_inf_apply gg on t.no=gg.no and gg.org_name like '%高管%' where  "
                    + " not exists (select dept_yw_reg_no from dept_yw_inf d where t.dept_yw_reg_no =d.dept_yw_reg_no and update_type != '3') and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+"','yyyy-MM-dd') group by t.area_no ) t  on t.area_no = a.no union all "
                    + " select a.no,a.areaname,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0),"
                    + " '' parentno from area@to_jttweb a left join ("
                    + " select substr(t.area_no,0,4) || '00' area_no,count(gl.area_no) gl,count(yg.area_no) yg,count(gk.area_no) gk,count(hs.area_no) hs,count(hd.area_no) hd "
                    + " ,count(zj.area_no) zj,count(zb.area_no) zb,count(gg.area_no) gg,'' parentno from Bn_Inf_Apply t "
                    + " left join bn_inf_apply gl on t.no=gl.no and gl.org_name like '%公路%' "
                    + " left join bn_inf_apply yg on t.no=yg.no and yg.org_name like '%运管%' "
                    + " left join bn_inf_apply gk on t.no=gk.no and gk.org_name like '%港口%' "
                    + " left join bn_inf_apply hs on t.no=hs.no and hs.org_name like '%海事%' "
                    + " left join bn_inf_apply hd on t.no=hd.no and hd.org_name like '%航道%' "
                    + " left join bn_inf_apply zj on t.no=zj.no and zj.org_name like '%质监%' "
                    + " left join bn_inf_apply zb on t.no=zb.no and zb.org_name like '%建设%' "
                    + " left join bn_inf_apply gg on t.no=gg.no and gg.org_name like '%高管%' where  "
                    + " not exists (select dept_yw_reg_no from dept_yw_inf d where t.dept_yw_reg_no =d.dept_yw_reg_no and update_type != '3') and t.apply_date >= to_date('"+startTime+"','yyyy-MM-dd') and t.apply_date <= to_date('"+endTime+"','yyyy-MM-dd') group by substr(t.area_no,0,4) ) t  on t.area_no = a.no"
                    + " where substr(a.no,-2,2) = '00' and a.no != '320000') order by no";
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("areaNo", slist[0]);
                       jsonObject.put("areaName", slist[1]);
                       jsonObject.put("gl", slist[2]);
                       jsonObject.put("yg", slist[3]);
                       jsonObject.put("gk", slist[4]);
                       jsonObject.put("hs", slist[5]);
                       jsonObject.put("hd", slist[6]);
                       jsonObject.put("zj", slist[7]);
                       jsonObject.put("zb", slist[8]);
                       jsonObject.put("gg", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
               }
        }
        return returnlist;
    }
	
	/**
	 * 外网申报统计（市县）
	 * @param startTime
	 * @param endTime
	 * @return
	 */
    public List<Map<String, Object>> selectDataStatisticssx(String startTime, String endTime) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
       String sql = "select a.areaname,decode(a.parentNo,'320000','',a.parentNo),a.childNo, nvl((a.cfzn + a.cfzw), 0) + nvl(b.tzn + b.tfzj + b.wcfzn, 0) "
           +"  as sbsl,nvl(a.cfzn, 0) cfzn, nvl(a.cfzw, 0) cfzw,nvl(b.tzn, 0) tzn, nvl(b.tfzj, 0) tfzj, nvl(b.wcfzn, 0) wcfzn, "
           +"  nvl(c.sl, 0) sl, nvl(c.bsl, 0) bsl, nvl(c.bz, 0) bz "
           +"  from (select ar.areaname, count(aa.FZN) cfzn, count(aa.FZW) cfzw, ar.childNo,ar.parentNo "
           +"  from (select sum(case when ROUND(TO_NUMBER(oar.update_date - oai.apply_date)) <= 5 then '1' end) as fzn, "
           +"  sum(case when ROUND(TO_NUMBER(oar.update_date - oai.apply_date)) > 5 then '1' end) as fzw, amo.idarea_code "
           +"  from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid "
           +"  left join opt_base_info@to_jttweb obi on obi.dj_id = oar.djid left join am_org@to_jttweb amo on amo.idorg = '32' ||SUBSTR(obi.orgcode, '3', '4') || 'JT'"
           +"  where obi.orgcode not like 'JS000000%'  and oai.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd') "
           +"  and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by amo.idarea_code, oar.update_date, oai.apply_date) aa "
           +"  right join (select aj.no childNo,  substr(aj.no, 1, 4) || '00' parentNo,  aj.areaname from area@to_jttweb aj "
           +"  where substr(aj.no, 5, 2) <> '00' union all select aj.no childNo, '320000' parentNo, aj.areaname  from area@to_jttweb aj "
           +"  where substr(aj.no, 5, 2) = '00'  order by childNo) ar on aa.idarea_code = ar.childNo "
           +"  group by ar.childNo, ar.areaname,ar.parentNo order by ar.childNo) a left join (select areaname, "
           +"  count(aa.tzn) tzn,count(aa.tfzj) tfzj, count(aa.fzw) wcfzn,ae.childNo from (select sum(case "
           +"  when ceil(TO_NUMBER(sysdate - oai.apply_date)) <= 3 then '1' end) as tzn, sum(case "
           +"  when ceil(TO_NUMBER(sysdate - oai.apply_date)) between 4 and 5 then '1' end) as tfzj, "
           +"  sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) > 5 then '1'  end) as fzw,oar.orgcode "
           +"  from (select aa.dj_id, aa.apply_date, amo.idarea_code orgcode "
           +"  from opt_apply_info@to_jttweb aa  inner join opt_base_info@to_jttweb bb on aa.dj_id = bb.dj_id "
           +"  left join am_org@to_jttweb amo on amo.idorg = '32' ||SUBSTR(bb.orgcode, '3', '4') || 'JT' where not exists "
           +"  (select djid from opt_apply_return@to_jttweb where djid = aa.dj_id)) "
           +"  oar  left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.dj_id "
           +"  where oar.orgcode not like 'JS000000%' and oai.sync_sign <> '6' and oai.apply_date >= "
           +"  to_date('" + startTime + "', 'yyyy-mm-dd') and oai.apply_date <=  to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') "
           +"  group by oar.orgcode, oai.apply_date) aa right join (select aj.no childNo, substr(aj.no, 1, 4) || '00' parentNo, "
           +"  aj.areaname  from area@to_jttweb aj where substr(aj.no, 5, 2) <> '00' union all select aj.no childNo, '' parentNo, "
           +"  aj.areaname from area@to_jttweb aj where substr(aj.no, 5, 2) = '00' order by childNo) ae on '32' || "
           +"  SUBSTR(orgcode, '3', '4') = ae.childNo group by ae.childNo, areaname order by ae.childNo) b on a.childNo = b.childNo "
           +"  left join (select areaname, sum(aa.sl) sl, sum(aa.bz) bz,  sum(aa.bsl) bsl,are.childNo from (select sum(case "
           +"  when ISACCEPT = 1 then '1' end) as sl, sum(case  when ISACCEPT = 4 then '1' end) as bz,  sum(case "
           +"  when ISACCEPT = 0 then '1' end) as bsl, amo.idarea_code orgcode from opt_apply_return@to_jttweb oar "
           +"  left join opt_base_info@to_jttweb obi on obi.dj_id = oar.djid left join am_org@to_jttweb amo on amo.idorg = '32' ||SUBSTR(obi.orgcode, '3', '4') || 'JT'    "
           +"  left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid where obi.orgcode not like 'JS000000%' "
           +"  and oai.apply_date >=  to_date('" + startTime + "', 'yyyy-mm-dd')  and oai.apply_date <= "
           +"  to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by amo.idarea_code) aa right join (select aj.no childNo,"
           +"  substr(aj.no, 1, 4) || '00' parentNo, aj.areaname from area@to_jttweb aj  where substr(aj.no, 5, 2) <> '00' "
           +"  union all select aj.no childNo, '' parentNo, aj.areaname from area@to_jttweb aj  where substr(aj.no, 5, 2) = '00' "
           +"  order by childNo) are on '32' || SUBSTR(orgcode, '3', '4') = are.childNo group by are.childNo, areaname "
           +"  order by are.childNo) c on c.childNo = b.childNo where a.childNo != '320000'";
       List<Object[]> list = null;
       while(list == null){
           list = (List<Object[]>)findObjectsBySql(sql);
       }
       String sqls = "select parentNo,sbsl,cfzn,cfzw,tzn,tfzj,wcfzn,sl,bsl,bz "
               + " from (select parentNo,sum(nvl((a.cfzn + a.cfzw), 0) + nvl(b.tzn + b.tfzj + b.wcfzn, 0)) as sbsl, "
               +"  sum(nvl(a.cfzn, 0)) cfzn,sum(nvl(a.cfzw, 0)) cfzw,sum(nvl(b.tzn, 0)) tzn,sum(nvl(b.tfzj, 0)) tfzj,sum(nvl(b.wcfzn, 0)) wcfzn,"
               +"  sum(nvl(c.sl, 0)) sl,sum(nvl(c.bsl, 0)) bsl,sum(nvl(c.bz, 0)) bz "
               +"  from (select ar.areaname, count(aa.FZN) cfzn, count(aa.FZW) cfzw,aa.orgcode, ar.childNo,decode(ar.parentNo, '320000', ar.childNo, ar.parentNo) parentNo "
               +"  from (select sum(case when ROUND(TO_NUMBER(oar.update_date - oai.apply_date)) <= 5 then '1' end) as fzn, "
               +"  sum(case when ROUND(TO_NUMBER(oar.update_date - oai.apply_date)) > 5 then '1' end) as fzw, amo.idarea_code,obi.orgcode "
               +"  from opt_apply_return@to_jttweb oar left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid "
               +"  left join opt_base_info@to_jttweb obi on obi.dj_id = oar.djid left join am_org@to_jttweb amo on amo.idorg = '32' ||SUBSTR(obi.orgcode, '3', '4') || 'JT'"
               +"  where obi.orgcode not like 'JS000000%'  and oai.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd') "
               +"  and oai.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by amo.idarea_code, oar.update_date, oai.apply_date,obi.orgcode) aa "
               +"  right join (select aj.no childNo,  substr(aj.no, 1, 4) || '00' parentNo,  aj.areaname from area@to_jttweb aj "
               +"  where substr(aj.no, 5, 2) <> '00' union all select aj.no childNo, '320000' parentNo, aj.areaname  from area@to_jttweb aj "
               +"  where substr(aj.no, 5, 2) = '00'  order by childNo) ar on aa.idarea_code = ar.childNo "
               +"  group by ar.childNo, ar.areaname,ar.parentNo,aa.orgcode order by ar.childNo) a left join (select areaname, "
               +"  count(aa.tzn) tzn,count(aa.tfzj) tfzj, count(aa.fzw) wcfzn,ae.childNo from (select sum(case "
               +"  when ceil(TO_NUMBER(sysdate - oai.apply_date)) <= 3 then '1' end) as tzn, sum(case "
               +"  when ceil(TO_NUMBER(sysdate - oai.apply_date)) between 4 and 5 then '1' end) as tfzj, "
               +"  sum(case when ceil(TO_NUMBER(sysdate - oai.apply_date)) > 5 then '1'  end) as fzw,oar.orgcode "
               +"  from (select aa.dj_id, aa.apply_date, amo.idarea_code orgcode "
               +"  from opt_apply_info@to_jttweb aa  inner join opt_base_info@to_jttweb bb on aa.dj_id = bb.dj_id "
               +"  left join am_org@to_jttweb amo on amo.idorg = '32' ||SUBSTR(bb.orgcode, '3', '4') || 'JT' where aa.dj_id not in "
               +"  (select dj_id from opt_apply_info@to_jttweb right join opt_apply_return@to_jttweb on dj_id = djid "
               +"  where dj_id is not null)) oar  left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.dj_id "
               +"  where oar.orgcode not like 'JS000000%' and oai.sync_sign <> '6' and oai.apply_date >= "
               +"  to_date('" + startTime + "', 'yyyy-mm-dd') and oai.apply_date <=  to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') "
               +"  group by oar.orgcode, oai.apply_date) aa right join (select aj.no childNo, substr(aj.no, 1, 4) || '00' parentNo, "
               +"  aj.areaname  from area@to_jttweb aj where substr(aj.no, 5, 2) <> '00' union all select aj.no childNo, '' parentNo, "
               +"  aj.areaname from area@to_jttweb aj where substr(aj.no, 5, 2) = '00' order by childNo) ae on '32' || "
               +"  SUBSTR(orgcode, '3', '4') = ae.childNo group by ae.childNo, areaname order by ae.childNo) b on a.childNo = b.childNo "
               +"  left join (select areaname, sum(aa.sl) sl, sum(aa.bz) bz,  sum(aa.bsl) bsl,are.childNo from (select sum(case "
               +"  when ISACCEPT = 1 then '1' end) as sl, sum(case  when ISACCEPT = 4 then '1' end) as bz,  sum(case "
               +"  when ISACCEPT = 0 then '1' end) as bsl, amo.idarea_code orgcode from opt_apply_return@to_jttweb oar "
               +"  left join opt_base_info@to_jttweb obi on obi.dj_id = oar.djid left join am_org@to_jttweb amo on amo.idorg = '32' ||SUBSTR(obi.orgcode, '3', '4') || 'JT'    "
               +"  left join opt_apply_info@to_jttweb oai on oai.dj_id = oar.djid where obi.orgcode not like 'JS000000%' "
               +"  and oai.apply_date >=  to_date('" + startTime + "', 'yyyy-mm-dd')  and oai.apply_date <= "
               +"  to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss') group by amo.idarea_code) aa right join (select aj.no childNo,"
               +"  substr(aj.no, 1, 4) || '00' parentNo, aj.areaname from area@to_jttweb aj  where substr(aj.no, 5, 2) <> '00' "
               +"  union all select aj.no childNo, '' parentNo, aj.areaname from area@to_jttweb aj  where substr(aj.no, 5, 2) = '00' "
               +"  order by childNo) are on '32' || SUBSTR(orgcode, '3', '4') = are.childNo group by are.childNo, areaname "
               +"  order by are.childNo) c on c.childNo = b.childNo where a.childNo != '320000' group by rollup(a.parentNo)) "
               +"  where 1=1 ";
               //+"  where parentNo is not null";
       List<Object[]> listRes = null;
       while(listRes == null){
           listRes = (List<Object[]>)findObjectsBySql(sqls);
       }
       
       if(list != null && list.size() > 0){
           for (int i = 0; i < list.size(); i++) {
                   Object [] slist = list.get(i);
                   JSONObject jsonObject = new JSONObject();
                   jsonObject.put("unitname", slist[0]);
                   if(slist[1] == null || "".equals(slist[1])){
                       jsonObject.put("parentNo", slist[2]);
                       jsonObject.put("childNo", slist[2].toString() + "area");
                       for (int j = 0; j < listRes.size(); j++) {
                           Object[] slistRes = listRes.get(j);
                           if(slistRes[0]==null || "".equals(String.valueOf(slistRes[0]))){
                               continue;
                           }
                           if(slistRes[0].toString().equals(slist[2].toString())){
                               JSONObject jsonObjectRes = new JSONObject();
                               jsonObjectRes.put("unitname", slist[0]);
                               jsonObjectRes.put("parentNo", "");
                               jsonObjectRes.put("childNo", slistRes[0]);
                               jsonObjectRes.put("SBSL", slistRes[1]);
                               
                               jsonObjectRes.put("CFZN", slistRes[2]);
                               jsonObjectRes.put("CFZW", slistRes[3]);
                               
                               jsonObjectRes.put("TZN", slistRes[4]);
                               jsonObjectRes.put("TFZJ", slistRes[5]);
                               jsonObjectRes.put("WCFZN", slistRes[6]);
                               
                               jsonObjectRes.put("SL", slistRes[7]);
                               jsonObjectRes.put("BSL", slistRes[8]);
                               jsonObjectRes.put("BZ", slistRes[9]);
                               jsonObjectRes.put("orgcode", slistRes[0] + "al");
                               returnlist.add(jsonObjectRes);
                               break;
                           }
                       }
                   }else{
                       jsonObject.put("parentNo", slist[1]);
                       jsonObject.put("childNo", slist[2]);
                   }
                   jsonObject.put("SBSL", slist[3]);
                   
                   jsonObject.put("CFZN", slist[4]);
                   jsonObject.put("CFZW", slist[5]);
                   
                   jsonObject.put("TZN", slist[6]);
                   jsonObject.put("TFZJ", slist[7]);
                   jsonObject.put("WCFZN", slist[8]);
                   
                   jsonObject.put("SL", slist[9]);
                   jsonObject.put("BSL", slist[10]);
                   jsonObject.put("BZ", slist[11]);
                   jsonObject.put("orgcode", slist[2].toString());

                   returnlist.add(jsonObject);
           }
       }
       
       int sbsl = 0;
       int cfzn = 0;
       int cfzw = 0;
       int tzn = 0;
       int tfzj = 0;
       int wcfzn = 0;
       int sl = 0;
       int bsl = 0;
       int bz = 0;
       for (int i = 0; i < returnlist.size(); i++) {
           if(returnlist.get(i).get("parentNo").toString().equals("")){
               sbsl += Integer.parseInt(returnlist.get(i).get("SBSL").toString());
               cfzn += Integer.parseInt(returnlist.get(i).get("CFZN").toString());
               cfzw += Integer.parseInt(returnlist.get(i).get("CFZW").toString());
               
               tzn += Integer.parseInt(returnlist.get(i).get("TZN").toString());
               tfzj += Integer.parseInt(returnlist.get(i).get("TFZJ").toString());
               wcfzn += Integer.parseInt(returnlist.get(i).get("WCFZN").toString());
               
               sl += Integer.parseInt(returnlist.get(i).get("SL").toString());
               bsl += Integer.parseInt(returnlist.get(i).get("BSL").toString());
               bz += Integer.parseInt(returnlist.get(i).get("BZ").toString());
               
           }
       }
       JSONObject jsonObject = new JSONObject();
       jsonObject.put("unitname", "总计");
       jsonObject.put("SBSL", sbsl);
       
       jsonObject.put("CFZN", cfzn);
       jsonObject.put("CFZW", cfzw);
       
       jsonObject.put("TZN", tzn);
       jsonObject.put("TFZJ", tfzj);
       jsonObject.put("WCFZN", wcfzn);
       
       jsonObject.put("SL", sl);
       jsonObject.put("BSL", bsl);
       jsonObject.put("BZ", bz);
       
       returnlist.add(jsonObject);
       return returnlist;
    }
    
    
    /**
     * 外网申报统计
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Object[]> selectDataStatisticssxAll(String startTime, String endTime) {
       String sql = "select am.idarea_code,am.orgname,nvl(公路,0),nvl(运管,0),nvl(港口,0), "
           +"  nvl(海事,0),nvl(航道,0),nvl(质监,0),nvl(建设,0),nvl(高管,0),nvl(总计,0) from am_org am left join( "
           +"  select am.idorg,am.orgname,sum(case when substr(ba.orgcode,-2,2) = 'GL' then 1 else 0 end) 公路 "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'YG' then 1 else 0 end) 运管  "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'GK' then 1 else 0 end) 港口  "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'HS' then 1 else 0 end) 海事  "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'HD' then 1 else 0 end) 航道  "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'ZJ' then 1 else 0 end) 质监  "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'ZB' then 1 else 0 end) 建设  "
           +"  ,sum(case when substr(ba.orgcode,-2,2) = 'GG' then 1 else 0 end) 高管,"
           +" sum(case when substr(ba.orgcode,-2,2) = 'GL' then 1 else 0 end) + sum(case when substr(ba.orgcode,-2,2) = 'YG' then 1 else 0 end)+"
           +" sum(case when substr(ba.orgcode,-2,2) = 'GK' then 1 else 0 end) + sum(case when substr(ba.orgcode,-2,2) = 'HS' then 1 else 0 end)+"
           +" sum(case when substr(ba.orgcode,-2,2) = 'HD' then 1 else 0 end) + sum(case when substr(ba.orgcode,-2,2) = 'ZJ' then 1 else 0 end)+"
           +" sum(case when substr(ba.orgcode,-2,2) = 'ZB' then 1 else 0 end) + sum(case when substr(ba.orgcode,-2,2) = 'GG' then 1 else 0 end) 总计"
           +" from opt_base_info@to_jttweb ba left join opt_apply_info@to_jttweb ap on ba.dj_id = ap.dj_id "
           +" left join dept_yw_inf@to_jttweb yw on yw.dept_yw_reg_no = ba.outitemid left join am_org@to_jttweb am on am.idorg = yw.ql_dept"
           +"   where yw.update_type !='3' and am.update_type !='3' and ap.apply_date >= to_date('"+startTime+"', 'yyyy-mm-dd') "
           +"  and ap.apply_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')  group by am.idorg,am.orgname order by am.idorg)t "
           +"  on am.idorg = t.idorg where am.idorg like '%JT%' order by am.idorg";
       List<Object[]> list = null;
       while(list == null){
           list = (List<Object[]>)findObjectsBySql(sql);
       }
        return list;   
    }   
    
    /**
     * 电子证照统计
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Object[]> getDataListZzxxAll(String startTime, String endTime) {
       String sql = "select am.idarea_code,am.orgname,sum(case when t.dept_no = 'GL' then 1 else 0 end) 公路 "
           +"  ,sum(case when t.dept_no = 'YG' then 1 else 0 end) 运管 "
           +"  ,sum(case when t.dept_no = 'GK' then 1 else 0 end) 港口 "
           +"  ,sum(case when t.dept_no = 'HS' then 1 else 0 end) 海事  "
           +"  ,sum(case when t.dept_no = 'HD' then 1 else 0 end) 航道  "
           +"  ,sum(case when t.dept_no = 'ZJ' then 1 else 0 end) 质监  "
           +"  ,sum(case when t.dept_no = 'ZB' then 1 else 0 end) 建设  "
           +"  ,sum(case when t.dept_no = 'GG' then 1 else 0 end) 高管 from am_org am left join ("
           +"  select distinct tz.id,substr(tz.qx_numcode, 1, 6) || 'JT' orgcode,"
           +"  td.dept_no,tz.CREATE_DATE,tz.mould_id from t_zz_zm_info@to_jsqz tz"
           +"  left join t_zz_mould_info@to_jsqz tm on tz.mould_id = tm.id right join t_zz_dy@to_jsqz td on tm.mould_number = td.mould_number"
           +"  where tz.create_date >= to_date('"+startTime+"', 'yyyy-mm-dd') "
           +"  and tz.create_date <= to_date('"+endTime+" 23:59:59', 'yyyy-mm-dd HH24:mi:ss')) t on "
           +"  (am.idarea_code || 'JT') = t.orgcode where am.idorg like '%JT%' and am.orgname not like '%港口%' "
           +"  and am.orgname not like  '%管理%' group by am.idarea_code,am.orgname,am.idorg order by am.idorg";
       List<Object[]> list = null;
       while(list == null){
           list = (List<Object[]>)findObjectsBySql(sql);
       }
        return list;   
    }   

    public List<Map<String, Object>> getDataListDzzz(Map<String, Object> filterMap) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select am.idorg areano,am.orgname,nvl(t.gl,0) gl,nvl(t.yg,0) yg,nvl(t.gk,0) gk,nvl(t.hs,0) hs,nvl(t.hd,0) hd,"
                  +"nvl(t.zj,0) zj,nvl(t.zb,0) zb,nvl(t.gg,0) gg,substr(am.idarea_code, 0, 4) || '00' parentno from am_org am left join"
                  +"(select ic.idorg,ic.orgname,         "
                  +"       sum(case when b.orgcode = 'GL' then 1 else 0 end) GL, "
                  +"       sum(case when b.orgcode = 'YG' then 1 else 0 end) YG, "
                  +"       sum(case when b.orgcode = 'GK' then 1 else 0 end) GK, "
                  +"       sum(case when b.orgcode = 'HS' then 1 else 0 end) HS, "
                  +"       sum(case when b.orgcode = 'HD' then 1 else 0 end) HD, "
                  +"       sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ, "
                  +"       sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB, "
                  +"       sum(case when b.orgcode = 'GG' then 1 else 0 end) GG, "
                  +"       substr(ic.idarea_code, 0, 4) || '00' parentno         "
                  +"  from bn_inf_apply yw left join dept_yw_inf yi on yi.dept_yw_reg_no = yw.dept_yw_reg_no "
                  +"  left join am_org ic on ic.idorg = yi.ql_dept   "
                  +"  left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yi.update_type != 3 ";
                if(!StringUtils.isBlank((String)filterMap.get("startTime"))){
                  sqls = sqls+"  and wapply_date >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd') ";
                }if(!StringUtils.isBlank((String)filterMap.get("endTime"))){
                    sqls = sqls+" and wapply_date <= to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss') ";
                }
                sqls = sqls  +"   and substr(yw.dept_yw_reg_no, 23, 2) in                   "
                  +"       ('01', '07', '10', '05', '06', '04' , '11')           "
                  +"   and length(yw.DEPT_YW_REG_NO) = 34 and ic.idarea_code != '320000'  and substr(ic.idarea_code,5,2) != '00'   "
                  +" group by ic.idorg,ic.orgname,ic.idarea_code) t on t.idorg = am.idorg where am.idorg like '%JT%' and (am.orgshortname like '%交通%' or am.orgshortname like  '%港口%' or am.orgshortname like '%交运%') and substr(am.idarea_code, 5, 2) != '00' union all                          "
          +"  select a.no, a.areaname,  nvl(sum(countTmp.GL),0) GL,   nvl(sum(countTmp.YG),0) YG,         "
          +"  nvl(sum(countTmp.GK),0) GK, nvl(sum(countTmp.HS),0) HS, nvl(sum(countTmp.HD),0) HD, "
          +"  nvl(sum(countTmp.ZJ),0) ZJ, nvl(sum(countTmp.ZB),0) ZB, nvl(sum(countTmp.GG),0) GG,"
          +"  '' from area@to_jttweb a                                                "
          +"  left join (select areano, orgname, GL,YG, GK, HS, HD, ZJ, ZB, GG, parentno    "
          +"  from (select ic.idarea_code || 'JT' areano,  ic.orgname,                 "
                      +"  sum(case when b.orgcode = 'GL' then 1 else 0 end) GL,        "
                      +"  sum(case when b.orgcode = 'YG' then 1 else 0 end) YG,        "
                      +"  sum(case when b.orgcode = 'GK' then 1 else 0 end) GK,        "
                      +"  sum(case when b.orgcode = 'HS' then 1 else 0 end) HS,        "
                      +"  sum(case when b.orgcode = 'HD' then 1 else 0 end) HD,        "
                      +"  sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ,        "
                      +"  sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB,        "
                      +"  sum(case when b.orgcode = 'GG' then 1 else 0 end) GG,        "
                      +"  substr(ic.idarea_code, 0, 4) || '00' parentno                "
           +" from bn_inf_apply yw left join dept_yw_inf yi on yi.dept_yw_reg_no = yw.dept_yw_reg_no "
           +" left join am_org ic on ic.idorg = yi.ql_dept "
           +" left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yi.update_type != 3 ";
            if(!StringUtils.isBlank((String)filterMap.get("startTime"))){
                sqls = sqls+"  and wapply_date >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd') ";
              }if(!StringUtils.isBlank((String)filterMap.get("endTime"))){
                  sqls = sqls+" and wapply_date <= to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss') ";
              }
           sqls = sqls+"  and substr(ic.idarea_code,5,2) != '00' and "
           +" substr(yw.dept_yw_reg_no, 23, 2) in ('01', '07', '10', '05', '06', '04' , '11')  "
           +"         and length(yw.DEPT_YW_REG_NO) = 34                                       "
           +"       group by ic.idorg,ic.orgname,ic.idarea_code)) countTmp on countTmp.parentno = a.no "
           +"    where substr(a.no, 5, 2) = '00'  and a.no != '320000'  group by a.no, a.areaname  order by areano   ";

        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glCount = 0;
        int ygCount = 0;
        int gkCount = 0;
        int hsCount = 0;
        int hdCount = 0;
        int zjCount = 0;
        int jsCount = 0;
        int ggCount = 0;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("childNo", slist[0]);
                       jsonObject.put("orgname", slist[1]);
                       jsonObject.put("GL", slist[2]);
                       jsonObject.put("YG", slist[3]);
                       jsonObject.put("GK", slist[4]);
                       jsonObject.put("HS", slist[5]);
                       jsonObject.put("HD", slist[6]);
                       jsonObject.put("ZJ", slist[7]);
                       jsonObject.put("JS", slist[8]);
                       jsonObject.put("GG", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
                       if(StringUtils.isNotBlank((String)slist[10]) ||
                               "江苏省交通运输厅".equals(slist[1])){
                           glCount += Integer.parseInt(slist[2].toString());
                           ygCount += Integer.parseInt(slist[3].toString());
                           gkCount += Integer.parseInt(slist[4].toString());
                           hsCount += Integer.parseInt(slist[5].toString());
                           hdCount += Integer.parseInt(slist[6].toString());
                           zjCount += Integer.parseInt(slist[7].toString());
                           jsCount += Integer.parseInt(slist[8].toString());
                           ggCount += Integer.parseInt(slist[9].toString());
                       }
                       if(i+1 == listRes.size()){
                           jsonObject = new JSONObject();
                           jsonObject.put("childNo", "");
                           jsonObject.put("orgname", "合计");
                           jsonObject.put("GL", glCount);
                           jsonObject.put("YG", ygCount);
                           jsonObject.put("GK", gkCount);
                           jsonObject.put("HS", hsCount);
                           jsonObject.put("HD", hdCount);
                           jsonObject.put("ZJ", zjCount);
                           jsonObject.put("JS", jsCount);
                           jsonObject.put("GG", ggCount);
                           jsonObject.put("parentNo", "");
                           returnlist.add(jsonObject);
                       }
               }
        }
        return returnlist;
    }
    
    public List<Map<String, Object>> getDataListDzzzAll(Map<String, Object> filterMap) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select am.idorg areano,am.orgname,nvl(t.gl,0) gl,nvl(t.yg,0) yg,nvl(t.gk,0) gk,nvl(t.hs,0) hs,nvl(t.hd,0) hd,"
                  +"nvl(t.zj,0) zj,nvl(t.zb,0) zb,nvl(t.gg,0) gg,(case when am.idorg != '320000JT' then substr(am.idarea_code, 0, 4) || '00' else '' end) parentno from am_org am left join"
                  +"(select ic.idorg,ic.orgname,         "
                  +"       sum(case when b.orgcode = 'GL' then 1 else 0 end) GL, "
                  +"       sum(case when b.orgcode = 'YG' then 1 else 0 end) YG, "
                  +"       sum(case when b.orgcode = 'GK' then 1 else 0 end) GK, "
                  +"       sum(case when b.orgcode = 'HS' then 1 else 0 end) HS, "
                  +"       sum(case when b.orgcode = 'HD' then 1 else 0 end) HD, "
                  +"       sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ, "
                  +"       sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB, "
                  +"       sum(case when b.orgcode = 'GG' then 1 else 0 end) GG, "
                  +"       substr(ic.idarea_code, 0, 4) || '00' parentno         "
                  +"  from bn_inf_apply yw left join dept_yw_inf yi on yi.dept_yw_reg_no = yw.dept_yw_reg_no "
                  +"  left join am_org ic on ic.idorg = yi.ql_dept "
                  +"  left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yi.update_type != 3 ";
                if(!StringUtils.isBlank((String)filterMap.get("startTime"))){
                  sqls = sqls+"  and wapply_date >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd') ";
                }if(!StringUtils.isBlank((String)filterMap.get("endTime"))){
                    sqls = sqls+" and wapply_date <= to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss') ";
                }
                sqls = sqls  +"   and substr(yw.dept_yw_reg_no, 23, 2) in                   "
                  +"       ('01', '07', '10', '05', '06', '04' , '11')           "
                  +"   and length(yw.DEPT_YW_REG_NO) = 34  "
                  +" group by ic.idorg,ic.orgname,ic.idarea_code) t on t.idorg = am.idorg where am.idorg like '%JT%' and (am.orgshortname like '%交通%' or am.orgshortname like  '%港口%' or am.orgshortname like '%交运%') union all                          "
          +"  select a.no, a.areaname,  nvl(sum(countTmp.GL),0) GL,   nvl(sum(countTmp.YG),0) YG,         "
          +"                 nvl(sum(countTmp.GK),0) GK, nvl(sum(countTmp.HS),0) HS, nvl(sum(countTmp.HD),0) HD, "
          +"                 nvl(sum(countTmp.ZJ),0) ZJ, nvl(sum(countTmp.ZB),0) ZB, nvl(sum(countTmp.GG      "
          +"  ),0) GG, '' from area@to_jttweb a                                                "
          +"  left join (select areano, orgname, GL,YG, GK, HS, HD, ZJ, ZB, GG, parentno    "
          +"  from (select ic.idarea_code || 'JT' areano,  ic.orgname,                 "
                      +"  sum(case when b.orgcode = 'GL' then 1 else 0 end) GL,        "
                      +"  sum(case when b.orgcode = 'YG' then 1 else 0 end) YG,        "
                      +"  sum(case when b.orgcode = 'GK' then 1 else 0 end) GK,        "
                      +"  sum(case when b.orgcode = 'HS' then 1 else 0 end) HS,        "
                      +"  sum(case when b.orgcode = 'HD' then 1 else 0 end) HD,        "
                      +"  sum(case when b.orgcode = 'ZJ' then 1 else 0 end) ZJ,        "
                      +"  sum(case when b.orgcode = 'ZB' then 1 else 0 end) ZB,        "
                      +"  sum(case when b.orgcode = 'GG' then 1 else 0 end) GG,        "
                      +"  substr(ic.idarea_code, 0, 4) || '00' parentno                "
           +"  from bn_inf_apply yw left join dept_yw_inf yi on yi.dept_yw_reg_no = yw.dept_yw_reg_no left join am_org ic on ic.idorg = yi.ql_dept "
           +"  left join DEP_YW_BMDY@to_jttweb b on substr(yw.dept_yw_reg_no,23,12) = b.outitemid where yi.update_type != 3  ";
            if(!StringUtils.isBlank((String)filterMap.get("startTime"))){
                sqls = sqls+"  and wapply_date >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd') ";
              }if(!StringUtils.isBlank((String)filterMap.get("endTime"))){
                  sqls = sqls+" and wapply_date <= to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss') ";
              }
           sqls = sqls+"  and                                 "
           +" substr(yw.dept_yw_reg_no, 23, 2) in ('01', '07', '10', '05', '06', '04' , '11')  "
           +"         and length(yw.DEPT_YW_REG_NO) = 34                                       "
           +"       group by ic.idorg,ic.orgname,ic.idarea_code)) countTmp on countTmp.parentno = a.no "
           +"    where substr(a.no, 5, 2) = '00' and a.no != '320000' group by a.no, a.areaname  order by areano   ";

        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glCount = 0;
        int ygCount = 0;
        int gkCount = 0;
        int hsCount = 0;
        int hdCount = 0;
        int zjCount = 0;
        int jsCount = 0;
        int ggCount = 0;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("childNo", slist[0]);
                       jsonObject.put("orgname", slist[1]);
                       jsonObject.put("GL", slist[2]);
                       jsonObject.put("YG", slist[3]);
                       jsonObject.put("GK", slist[4]);
                       jsonObject.put("HS", slist[5]);
                       jsonObject.put("HD", slist[6]);
                       jsonObject.put("ZJ", slist[7]);
                       jsonObject.put("JS", slist[8]);
                       jsonObject.put("GG", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
                       if(StringUtils.isNotBlank((String)slist[10]) ||
                               "江苏省交通运输厅".equals(slist[1])){
                           glCount += Integer.parseInt(slist[2].toString());
                           ygCount += Integer.parseInt(slist[3].toString());
                           gkCount += Integer.parseInt(slist[4].toString());
                           hsCount += Integer.parseInt(slist[5].toString());
                           hdCount += Integer.parseInt(slist[6].toString());
                           zjCount += Integer.parseInt(slist[7].toString());
                           jsCount += Integer.parseInt(slist[8].toString());
                           ggCount += Integer.parseInt(slist[9].toString());
                       }
                       if(i+1 == listRes.size()){
                           jsonObject = new JSONObject();
                           jsonObject.put("childNo", "");
                           jsonObject.put("orgname", "合计");
                           jsonObject.put("GL", glCount);
                           jsonObject.put("YG", ygCount);
                           jsonObject.put("GK", gkCount);
                           jsonObject.put("HS", hsCount);
                           jsonObject.put("HD", hdCount);
                           jsonObject.put("ZJ", zjCount);
                           jsonObject.put("JS", jsCount);
                           jsonObject.put("GG", ggCount);
                           jsonObject.put("parentNo", "");
                           returnlist.add(jsonObject);
                       }
               }
        }
        return returnlist;
    }
    
    /*public List<Map<String, Object>> gettrafficData(Map<String, Object> filterMap) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select (case when d.mon = '01' then '一月' when d.mon = '02' then '二月'  when d.mon = '03' then '三月' when d.mon = '04' then '四月'"
                    + " when d.mon = '05' then '五月' when d.mon = '06' then '六月' when d.mon = '07' then '七月' when d.mon = '08' then '八月' "
                    + "  when d.mon = '09' then '九月' when d.mon = '10' then '十月' when d.mon = '11' then '十一月' when d.mon = '12' then '十二月' end) mont,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'GL' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') glall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'GL' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') glbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'YG' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') ygall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'YG' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') ygbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'GK' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') gkall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'GK' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') gkbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'HS' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') hsall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'HS' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') hsbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'HD' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') hdall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'HD' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') hdbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'ZJ' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') zjall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'ZJ' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') zjbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'ZB' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') zball,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'ZB' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') zbbs,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'GG' and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') ggall,"
                    + "(select count(c.fillingdate) from case_info c where substr(c.org_id,-2,2)= 'GG' and sync_sign = 1 and d.mon = substr(c.fillingdate,6,2)"
                    + "  and c.fillingdate like '%"+filterMap.get("time")+"-%') ggbs from(select lpad(level,2,0) mon from dual connect by level<13) d";
                
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glall = 0;
        int glbs = 0;
        int ygall = 0;
        int ygbs = 0;
        int gkall = 0;
        int gkbs = 0;
        int hsall = 0;
        int hsbs = 0;
        int hdall = 0;
        int hdbs = 0;
        int zjall = 0;
        int zjbs = 0;
        int zball = 0;
        int zbbs = 0;
        int ggall = 0;
        int ggbs = 0;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("month", slist[0].toString());
                       jsonObject.put("glall", slist[1].toString());
                       jsonObject.put("glbs", slist[2].toString());
                       jsonObject.put("ygall", slist[3].toString());
                       jsonObject.put("ygbs", slist[4].toString());
                       jsonObject.put("gkall", slist[5].toString());
                       jsonObject.put("gkbs", slist[6].toString());
                       jsonObject.put("hsall", slist[7].toString());
                       jsonObject.put("hsbs", slist[8].toString());
                       jsonObject.put("hdall", slist[9].toString());
                       jsonObject.put("hdbs", slist[10].toString());
                       jsonObject.put("zjall", slist[11].toString());
                       jsonObject.put("zjbs", slist[12].toString());
                       jsonObject.put("zball", slist[13].toString());
                       jsonObject.put("zbbs", slist[14].toString());
                       jsonObject.put("ggall", slist[15].toString());
                       jsonObject.put("ggbs", slist[16].toString());
                       returnlist.add(jsonObject);
                       glall += Integer.parseInt(slist[1].toString());
                       glbs += Integer.parseInt(slist[2].toString());
                       ygall += Integer.parseInt(slist[3].toString());
                       ygbs += Integer.parseInt(slist[4].toString());
                       gkall += Integer.parseInt(slist[5].toString());
                       gkbs += Integer.parseInt(slist[6].toString());
                       hsall += Integer.parseInt(slist[7].toString());
                       hsbs += Integer.parseInt(slist[8].toString());
                       hdall += Integer.parseInt(slist[9].toString());
                       hdbs += Integer.parseInt(slist[10].toString());
                       zjall += Integer.parseInt(slist[11].toString());
                       zjbs += Integer.parseInt(slist[12].toString());
                       zball += Integer.parseInt(slist[13].toString());
                       zbbs += Integer.parseInt(slist[14].toString());
                       ggall += Integer.parseInt(slist[15].toString());
                       ggbs += Integer.parseInt(slist[16].toString());
                       if(i+1 == listRes.size()){
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "合计");
                           jsonObject.put("glall", glall);
                           jsonObject.put("glbs", glbs);
                           jsonObject.put("ygall", ygall);
                           jsonObject.put("ygbs", ygbs);
                           jsonObject.put("gkall", gkall);
                           jsonObject.put("gkbs", gkbs);
                           jsonObject.put("hsall", hsall);
                           jsonObject.put("hsbs", hsbs);
                           jsonObject.put("hdall", hdall);
                           jsonObject.put("hdbs", hdbs);
                           jsonObject.put("zjall", zjall);
                           jsonObject.put("zjbs", zjbs);
                           jsonObject.put("zball", zball);
                           jsonObject.put("zbbs", zbbs);
                           jsonObject.put("ggall", ggall);
                           jsonObject.put("ggbs", ggbs);
                           returnlist.add(jsonObject);
                       }
               }
        }
        return returnlist;
    }*/
    
    public List<Map<String, Object>> gettrafficData(Map<String, Object> filterMap) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select d.mon,nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0) from "
                + " (select lpad(level,2,0) mon from dual connect by level<13) d left join "
                + " (select (case when length(replace(substr(c.fillingdate, 6, 2),'-','')) = 1 then 0 || replace(substr(c.fillingdate, 6, 2),'-','') else replace(substr(c.fillingdate, 6, 2),'-','') end) mon "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='GL' then 1 else 0 end) gl "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='YG' then 1 else 0 end) yg "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='GK' then 1 else 0 end) gk "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='HS' then 1 else 0 end) hs "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='HD' then 1 else 0 end) hd "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='ZJ' then 1 else 0 end) zj "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='ZB' then 1 else 0 end) zb "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='GG' then 1 else 0 end) gg  from case_info c where (substr(c.fillingdate, 6, 2) in "
                + " ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12') or substr(c.fillingdate, 6, 2) in  ('1-', '2-', '3-', '4-', '5-', '6-', '7-', '8-', '9-', '10', '11', '12'))"
                + " and c.fillingdate like '%"+filterMap.get("time")+"-%' group by  (case when length(replace(substr(c.fillingdate, 6, 2),'-','')) = 1 then 0 || replace(substr(c.fillingdate, 6, 2),'-','')"
                + " else replace(substr(c.fillingdate, 6, 2),'-','') end)) t on d.mon = t.mon union all "
                + " select d.mon || 'bs',nvl(t.gl,0),nvl(t.yg,0),nvl(t.gk,0),nvl(t.hs,0),nvl(t.hd,0),nvl(t.zj,0),nvl(t.zb,0),nvl(t.gg,0) from "
                + " (select lpad(level,2,0) mon from dual connect by level<13) d left join "
                + " (select (case when length(replace(substr(c.fillingdate, 6, 2),'-','')) = 1 then 0 || replace(substr(c.fillingdate, 6, 2),'-','') else replace(substr(c.fillingdate, 6, 2),'-','') end) mon "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='GL' then 1 else 0 end) gl "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='YG' then 1 else 0 end) yg "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='GK' then 1 else 0 end) gk "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='HS' then 1 else 0 end) hs "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='HD' then 1 else 0 end) hd "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='ZJ' then 1 else 0 end) zj "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='ZB' then 1 else 0 end) zb "
                + " ,sum(case when upper(substr(c.org_id, -2, 2)) ='GG' then 1 else 0 end) gg  from case_info c where (substr(c.fillingdate, 6, 2) in "
                + " ('01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12') or substr(c.fillingdate, 6, 2) in  ('1-', '2-', '3-', '4-', '5-', '6-', '7-', '8-', '9-', '10', '11', '12'))"
                + " and c.fillingdate like '%"+filterMap.get("time")+"-%' and sync_sign = 1 group by  (case when length(replace(substr(c.fillingdate, 6, 2),'-','')) = 1 then 0 || replace(substr(c.fillingdate, 6, 2),'-','')"
                + " else replace(substr(c.fillingdate, 6, 2),'-','') end)) t on d.mon = t.mon order by mon";
                
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        int glall = 0;
        int glbs = 0;
        int ygall = 0;
        int ygbs = 0;
        int gkall = 0;
        int gkbs = 0;
        int hsall = 0;
        int hsbs = 0;
        int hdall = 0;
        int hdbs = 0;
        int zjall = 0;
        int zjbs = 0;
        int zball = 0;
        int zbbs = 0;
        int ggall = 0;
        int ggbs = 0;
        JSONObject jsonObject = null;
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       if(slist[0].equals("01") && jsonObject == null){
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "一月");
                       }else if(slist[0].equals("02")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "二月");
                       }else if(slist[0].equals("03")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "三月");
                       }else if(slist[0].equals("04")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "四月");
                       }else if(slist[0].equals("05")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "五月");
                       }else if(slist[0].equals("06")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "六月");
                       }else if(slist[0].equals("07")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "七月");
                       }else if(slist[0].equals("08")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "八月");
                       }else if(slist[0].equals("09")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "九月");
                       }else if(slist[0].equals("10")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "十月");
                       }else if(slist[0].equals("11")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "十一月");
                       }else if(slist[0].equals("12")){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "十二月");
                       }
                       if(slist[0].toString().indexOf("bs") == -1){
                           jsonObject.put("gl", slist[1]);
                           jsonObject.put("yg", slist[2]);
                           jsonObject.put("gk", slist[3]);
                           jsonObject.put("hs", slist[4]);
                           jsonObject.put("hd", slist[5]);
                           jsonObject.put("zj", slist[6]);
                           jsonObject.put("zb", slist[7]);
                           jsonObject.put("gg", slist[8]);
                           glall += Integer.parseInt(slist[1].toString());
                           ygall += Integer.parseInt(slist[2].toString());
                           gkall += Integer.parseInt(slist[3].toString());
                           hsall += Integer.parseInt(slist[4].toString());
                           hdall += Integer.parseInt(slist[5].toString());
                           zjall += Integer.parseInt(slist[6].toString());
                           zball += Integer.parseInt(slist[7].toString());
                           ggall += Integer.parseInt(slist[8].toString());
                       }else{
                           jsonObject.put("glbs", slist[1]);
                           jsonObject.put("ygbs", slist[2]);
                           jsonObject.put("gkbs", slist[3]);
                           jsonObject.put("hsbs", slist[4]);
                           jsonObject.put("hdbs", slist[5]);
                           jsonObject.put("zjbs", slist[6]);
                           jsonObject.put("zbbs", slist[7]);
                           jsonObject.put("ggbs", slist[8]);
                           glbs += Integer.parseInt(slist[1].toString());
                           ygbs += Integer.parseInt(slist[2].toString());
                           gkbs += Integer.parseInt(slist[3].toString());
                           hsbs += Integer.parseInt(slist[4].toString());
                           hdbs += Integer.parseInt(slist[5].toString());
                           zjbs += Integer.parseInt(slist[6].toString());
                           zbbs += Integer.parseInt(slist[7].toString());
                           ggbs += Integer.parseInt(slist[8].toString());
                       }
                       if(i+1 == listRes.size()){
                           returnlist.add(jsonObject);
                           jsonObject = new JSONObject();
                           jsonObject.put("month", "合计");
                           jsonObject.put("gl", glall);
                           jsonObject.put("glbs", glbs);
                           jsonObject.put("yg", ygall);
                           jsonObject.put("ygbs", ygbs);
                           jsonObject.put("gk", gkall);
                           jsonObject.put("gkbs", gkbs);
                           jsonObject.put("hs", hsall);
                           jsonObject.put("hsbs", hsbs);
                           jsonObject.put("hd", hdall);
                           jsonObject.put("hdbs", hdbs);
                           jsonObject.put("zj", zjall);
                           jsonObject.put("zjbs", zjbs);
                           jsonObject.put("zb", zball);
                           jsonObject.put("zbbs", zbbs);
                           jsonObject.put("gg", ggall);
                           jsonObject.put("ggbs", ggbs);
                           returnlist.add(jsonObject);
                       }
               }
        }
        return returnlist;
    }

    public List<Map<String, Object>> getDataListZzxx(Map<String, Object> filterMap) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select ic.idorg areano, nvl(ic.orgname,'合计'),                                        "
                        +" sum(case when ab.dept_no = 'GL' then 1 else 0 end) GL,                 "
                        +" sum(case when ab.dept_no = 'YG' then 1 else 0 end) YG,                 "
                        +" sum(case when ab.dept_no = 'GK' then 1 else 0 end) GK,                 "
                        +" sum(case when ab.dept_no = 'HS' then 1 else 0 end) HS,                 "
                        +" sum(case when ab.dept_no = 'HD' then 1 else 0 end) HD,                 "
                        +" sum(case when ab.dept_no = 'ZJ' then 1 else 0 end) ZJ,                 "
                        +" sum(case when ab.dept_no = 'JS' then 1 else 0 end) JS,                 "
                        +" sum(case when ab.dept_no = 'GG' then 1 else 0 end) GG,                 "
                        +" substr(ic.idarea_code, 0, 4) || '00' parentno                          "
                        +" from am_org ic                                                         "
                        +" left join (select orgcode,                                             "
                        +" dept_no from e_licence_citysta                                         "
                        +" where CREATE_DATE >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd')"
                        + " and CREATE_DATE <= to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss') "
                        + ") ab on     "
             +"      ic.idorg = ab.orgcode where idorg like '%JT%' and ic.idorg <> '320000JT'     "
             +"                and orgshortname not like '%建设局%'  and substr(ic.idorg,5,2) <> '00'                              "
             +"           group by ic.idorg, ic.orgname,ic.idarea_code                           "
             +"  union all                                                                        "
             +"  select a.no, a.areaname,  sum(countTmp.GL) GL,   sum(countTmp.YG) YG,            "
             +"                 sum(countTmp.GK) GK, sum(countTmp.HS) HS, sum(countTmp.HD) HD,    "
             +"                 sum(countTmp.ZJ) ZJ, sum(countTmp.JS) JS, sum(countTmp.GG         "
             +"  ) GG, '' from area@to_jttweb a                                                   "
             +"  left join (select areano, orgname, GL,YG, GK, HS, HD, ZJ, JS, GG, parentno       "
                      +" from (select ic.idorg areano,                                            "
                      +"        ic.orgname,                                                       "
                      +"       sum(case when ab.dept_no = 'GL' then 1 else 0 end) GL,             "
                      +"       sum(case when ab.dept_no = 'YG' then 1 else 0 end) YG,             "
                      +"       sum(case when ab.dept_no = 'GK' then 1 else 0 end) GK,             "
                      +"       sum(case when ab.dept_no = 'HS' then 1 else 0 end) HS,             "
                      +"       sum(case when ab.dept_no = 'HD' then 1 else 0 end) HD,             "
                      +"       sum(case when ab.dept_no = 'ZJ' then 1 else 0 end) ZJ,             "
                      +"       sum(case when ab.dept_no = 'JS' then 1 else 0 end) JS,             "
                      +"       sum(case when ab.dept_no = 'GG' then 1 else 0 end) GG,             "
                      +"       substr(ic.idarea_code, 0, 4) || '00' parentno                      "
                      +"   from am_org ic                                                         "
                      +"   left join (select orgcode,                                             "
                      +"   dept_no from e_licence_citysta                                         "
                      +"   where CREATE_DATE >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd')"
                      + " and CREATE_DATE <= to_date('"+filterMap.get("endTime")+" 23:59：59', 'yyyy-MM-dd HH24:mi:ss') and substr(orgcode,5,2) != 00) ab        "
                      +"    on ic.idorg = ab.orgcode  where idorg like '%JT%'                     "
                      +"    and orgshortname not like '%建设局%'                                  "
                      +"  group by ic.idorg, ic.orgname,ic.idarea_code)) countTmp on              "
                      +"   countTmp.parentno = a.no                                               "
                  +"  where substr(a.no, 5, 2) = '00'  and a.no <> '320000'  group by a.no, a.areaname  order by areano ";


        int glCount = 0;
        int ygCount = 0;
        int gkCount = 0;
        int hsCount = 0;
        int hdCount = 0;
        int zjCount = 0;
        int jsCount = 0;
        int ggCount = 0;
        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("childNo", slist[0]);
                       jsonObject.put("orgname", slist[1]);
                       jsonObject.put("GL", slist[2]);
                       jsonObject.put("YG", slist[3]);
                       jsonObject.put("GK", slist[4]);
                       jsonObject.put("HS", slist[5]);
                       jsonObject.put("HD", slist[6]);
                       jsonObject.put("ZJ", slist[7]);
                       jsonObject.put("JS", slist[8]);
                       jsonObject.put("GG", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
                       if(!slist[0].toString().substring(4).equals("00")){
                           glCount += Integer.parseInt(slist[2].toString());
                           ygCount += Integer.parseInt(slist[3].toString());
                           gkCount += Integer.parseInt(slist[4].toString());
                           hsCount += Integer.parseInt(slist[5].toString());
                           hdCount += Integer.parseInt(slist[6].toString());
                           zjCount += Integer.parseInt(slist[7].toString());
                           jsCount += Integer.parseInt(slist[8].toString());
                           ggCount += Integer.parseInt(slist[9].toString());
                       }
                       if(i+1 == listRes.size()){
                           jsonObject = new JSONObject();
                           jsonObject.put("childNo", "");
                           jsonObject.put("orgname", "合计");
                           jsonObject.put("GL", glCount);
                           jsonObject.put("YG", ygCount);
                           jsonObject.put("GK", gkCount);
                           jsonObject.put("HS", hsCount);
                           jsonObject.put("HD", hdCount);
                           jsonObject.put("ZJ", zjCount);
                           jsonObject.put("JS", jsCount);
                           jsonObject.put("GG", ggCount);
                           jsonObject.put("parentNo", "");
                           returnlist.add(jsonObject);
                       }
               }
        }
        return returnlist;
    }
    
    public List<Map<String, Object>> getDataListZzxxPro(Map<String, Object> filterMap) {
        List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
        String sqls = "select nvl(ic.idorg,'999999JT') areano, nvl(ic.orgname,'合计'),                                        "
                        +" sum(case when ab.dept_no = 'GL' then 1 else 0 end) GL,                 "
                        +" sum(case when ab.dept_no = 'YG' then 1 else 0 end) YG,                 "
                        +" sum(case when ab.dept_no = 'GK' then 1 else 0 end) GK,                 "
                        +" sum(case when ab.dept_no = 'HS' then 1 else 0 end) HS,                 "
                        +" sum(case when ab.dept_no = 'HD' then 1 else 0 end) HD,                 "
                        +" sum(case when ab.dept_no = 'ZJ' then 1 else 0 end) ZJ,                 "
                        +" sum(case when ab.dept_no = 'JS' then 1 else 0 end) JS,                 "
                        +" sum(case when ab.dept_no = 'GG' then 1 else 0 end) GG,                 "
                        +" '' parentno                                                            "
                        +" from am_org ic                                                         "
                        +" left join (select orgcode,         "
                        +" dept_no from  e_licence_citysta   "
                        +" where CREATE_DATE >= to_date('"+filterMap.get("startTime")+"', 'yyyy-MM-dd')"
                        +" and CREATE_DATE <= to_date('"+filterMap.get("endTime")+" 23:59:59', 'yyyy-MM-dd HH24:mi:ss') "
                        +" ) ab on     "
                        +" ic.idorg = ab.orgcode where idorg like '%JT%'    "
                        +" and orgshortname not like '%建设局%' and substr(ic.idorg,5,2) = '00' "
                        +" group by rollup((ic.idorg, ic.orgname,ic.idarea_code))                            ";


        List<Object[]> listRes = (List<Object[]>)findObjectsBySql(sqls);
        if(listRes != null && listRes.size() > 0){
               for (int i = 0; i < listRes.size(); i++) {
                       Object [] slist = listRes.get(i);
                       JSONObject jsonObject = new JSONObject();
                       jsonObject.put("childNo", slist[0]);
                       jsonObject.put("orgname", slist[1]);
                       jsonObject.put("GL", slist[2]);
                       jsonObject.put("YG", slist[3]);
                       jsonObject.put("GK", slist[4]);
                       jsonObject.put("HS", slist[5]);
                       jsonObject.put("HD", slist[6]);
                       jsonObject.put("ZJ", slist[7]);
                       jsonObject.put("JS", slist[8]);
                       jsonObject.put("GG", slist[9]);
                       jsonObject.put("parentNo", slist[10]);
                       returnlist.add(jsonObject);
               }
        }
        return returnlist;
    }

    /**
     * 行政许可列表(在用)
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<WssbxzxkBo> getXzxkList(Map<String, Object> filterMap, PageDesc pageDesc) {
        String sql = " from L_JIAOTONG_XZXK_2018@to_jttweb a where 1=1 and a.sync_sign <> '3'";
        if(!StringUtils.isBlank((String)filterMap.get("xkjdrqBeginTime"))){
            sql = sql  +"  and a.xk_jdrq >=  to_date('"+filterMap.get("xkjdrqBeginTime")+"','yyyy-MM-dd' )";
        }
        if(!StringUtils.isBlank((String)filterMap.get("xkjdrqEndTime"))){
            sql = sql  +"  and a.xk_jdrq <= to_date('"+filterMap.get("xkjdrqEndTime")+"','yyyy-MM-dd') "; 
        }
        if (!StringUtils.isBlank((String)filterMap.get("xksclx"))) {
            sql += " and a.xk_sclx = '"+filterMap.get("xksclx")+"' ";
        }
        if (!StringUtils.isBlank((String)filterMap.get("xkxdrlx"))) {
            String xkxdrlx = (String)filterMap.get("xkxdrlx");
            if("1".equals(xkxdrlx)){
                sql += " and a.xk_xdrlx in('法人及非法人组织','个体工商户' ) ";
            }else if("2".equals(xkxdrlx)){
                sql += " and a.xk_xdrlx = '自然人' ";
            }
        }
        sql += " order by  xk_jdrq desc ";
        String hql1 = "select a.xk_xdr,a.xk_xdr_shxym,a.xk_xdr_gsdj,a.xk_xdr_zdm,a.xk_xdr_swdj,a.xk_xdr_sydw,"+
                "a.xk_xdr_shzjdjzh,a.xk_fr,a.xk_frsfz,a.xk_zjlx,a.xk_zjhm,a.xk_jdsmc,a.xk_wsh,a.xk_splb," +
        		"a.xk_zsmc,a.xk_bh,a.xk_nr,a.xk_jdrq,a.xk_yxqq,a.xk_yxqz,a.xk_xzjg,a.xk_jgtyshxy,"+
                "case(a.xk_zt) when '1' then '有效' when '2' then '无效' end xk_zt ,"+
        		"a.xk_sjlydw,a.xk_lytyshxym,a.bz,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') xk_nowtime "+ sql;
        //String hql2 = "select count(*)  " + hql.getHql();

       /* String sqlFrame = "SELECT * FROM ( SELECT A.*, ROWNUM RN "
                + " FROM ( sqltemp ) A WHERE ROWNUM <= " + (pageDesc.getPageNo() * pageDesc.getPageSize())
                + " ) WHERE RN >=  " + ((pageDesc.getPageNo() - 1) * pageDesc.getPageSize() + 1);*/
        
        String countSql = "select count(1) "+sql;
        /**
         * 拼接分页查询
         */
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        //sqlFrame = sqlFrame.replace("sqltemp", hql1);
        @SuppressWarnings("unchecked")
        List<WssbxzxkBo> list = findObjectsBySql(hql1, WssbxzxkBo.class, startPos, maxSize);
        long totalRows = getSingleIntBySql(countSql);
        if(totalRows>0){
            pageDesc.setTotalRows((int)totalRows);
        }else{
            pageDesc.setTotalRows(0);
        }
        //List<WssbxzxkBo> list = (List<WssbxzxkBo>)findObjectsBySql(sqlFrame);
        return list;
    }
    
    
    
    
    

    public List<WssbxzxkBo> getXzxkAllList(Map<String, Object> filterMap) {
        String sql = "from L_JIAOTONG_XZXK_2018@to_jttweb a where 1=1 and a.sync_sign <> '3'";
        if(!StringUtils.isBlank((String)filterMap.get("xkjdrqBeginTime"))){
            sql = sql  +"  and a.xk_jdrq >=  to_date('"+filterMap.get("xkjdrqBeginTime")+"','yyyy-MM-dd' )";
        }
        if(!StringUtils.isBlank((String)filterMap.get("xkjdrqEndTime"))){
            sql = sql  +"  and a.xk_jdrq <= to_date('"+filterMap.get("xkjdrqEndTime")+"','yyyy-MM-dd') "; 
        }
        if (!StringUtils.isBlank((String)filterMap.get("xksclx"))) {
            sql += " and a.xk_sclx = '"+filterMap.get("xksclx")+"' ";
        }
        if (!StringUtils.isBlank((String)filterMap.get("xkxdrlx"))) {
           // sql += " and a.xk_xdrlx = '"+filterMap.get("xkxdrlx")+"' ";
            String xkxdrlx = (String)filterMap.get("xkxdrlx");
            if("1".equals(xkxdrlx)){
                sql += " and a.xk_xdrlx in('法人及非法人组织','个体工商户' ) ";
            }else if("2".equals(xkxdrlx)){
                sql += " and a.xk_xdrlx = '自然人' ";
            }
        }
        sql += " order by  xk_jdrq desc ";
        String hql1 = "select a.xk_xdr,a.xk_xdr_shxym,a.xk_xdr_gsdj,a.xk_xdr_zdm,a.xk_xdr_swdj,a.xk_xdr_sydw,"+
                "a.xk_xdr_shzjdjzh,a.xk_fr,a.xk_frsfz,a.xk_zjlx,a.xk_zjhm,a.xk_jdsmc,a.xk_wsh,a.xk_splb," +
                "a.xk_zsmc,a.xk_bh,a.xk_nr,a.xk_jdrq,a.xk_yxqq,a.xk_yxqz,a.xk_xzjg,a.xk_jgtyshxy,"+
                //"case(a.xk_zt) when '1' then '有效' when '2' then '无效' end xk_zt ,"+
                "nvl(a.xk_zt,'1') xk_zt,"+
                "a.xk_sjlydw,a.xk_lytyshxym,a.bz,to_char(sysdate,'yyyymmddhhmmss') xk_nowtime "+ sql;

        String sqlFrame = "SELECT * FROM ( SELECT A.*, ROWNUM RN "
                + " FROM ( sqltemp ) A WHERE ROWNUM <= 10000000000000000000000 ) WHERE RN >=1  ";


        sqlFrame = sqlFrame.replace("sqltemp", hql1);
        List<WssbxzxkBo> list = (List<WssbxzxkBo>)findObjectsBySql(sqlFrame);
        return list;
    }

    /**
     * 行政处罚列表
     * @param filterMap
     * @param pageDesc
     * @return
     */
    public List<WssbxzcfBo> getXzcfList(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        String sql = " from L_JIAOTONG_XZCF_2018@to_jttweb a where 1=1 and a.sync_sign <> '3'";
        if(!StringUtils.isBlank((String)filterMap.get("cfjdrqBeginTime"))){
            sql = sql  +"  and a.cf_jdrq >=  to_date('"+filterMap.get("cfjdrqBeginTime")+"','yyyy-MM-dd' )";
        }
        if(!StringUtils.isBlank((String)filterMap.get("cfjdrqEndTime"))){
            sql = sql  +"  and a.cf_jdrq <= to_date('"+filterMap.get("cfjdrqEndTime")+"','yyyy-MM-dd') "; 
        }
        if (!StringUtils.isBlank((String)filterMap.get("cfsclx"))) {
            sql += " and a.cf_sclx = '"+filterMap.get("cfsclx")+"' ";
        }
        if (!StringUtils.isBlank((String)filterMap.get("cfxdrlx"))) {
            /*sql += " and a.cf_xdrlx = '"+filterMap.get("cfxdrlx")+"' ";*/
            String cfxdrlx = (String)filterMap.get("cfxdrlx");
            if("1".equals(cfxdrlx)){
                sql += " and a.cf_xdrlx in('法人及非法人组织','个体工商户' ) ";
            }else if("2".equals(cfxdrlx)){
                sql += " and a.cf_xdrlx = '自然人' ";
            }
        }
        sql += " order by  cf_jdrq desc ";
        String hql1 = "select a.cf_xdr,a.cf_xdr_shxym,a.cf_xdr_gsdj,a.cf_xdr_zdm,a.cf_xdr_swdj,a.cf_xdr_sydw,"+
                "a.cf_xdr_shzjdjzh,a.cf_fr,a.cf_frsfz,a.cf_xdr_zjlx,a.cf_xdr_zjhm,a.cf_wsh," +
                "a.cf_wfxwlx,a.cf_sy,a.cf_yj,a.cf_cflb1,a.cf_nr,a.cf_je,a.cf_msje,a.cf_zkzh,"+
                "a.cf_jdrq,a.cf_yxq,a.cf_gsjzq,a.cf_xzjg,a.cf_jgtyshxy,a.cf_sjlydw,a.cf_lytyshxym,"+
                "a.bz,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as cf_nowtime "+ sql;
        String countSql = "select count(1) "+sql;
        /**
         * 拼接分页查询
         */
        int startPos = 0;
        int maxSize;
        startPos = pageDesc.getRowStart();
        maxSize = pageDesc.getPageSize();
        //sqlFrame = sqlFrame.replace("sqltemp", hql1);
        @SuppressWarnings("unchecked")
        List<WssbxzcfBo> list = findObjectsBySql(hql1, WssbxzcfBo.class, startPos, maxSize);
        long totalRows = getSingleIntBySql(countSql);
        if(totalRows>0){
            pageDesc.setTotalRows((int)totalRows);
        }else{
            pageDesc.setTotalRows(0);
        }
        /*String sqlFrame = "SELECT * FROM ( SELECT A.*, ROWNUM RN "
                + " FROM ( sqltemp ) A WHERE ROWNUM <= " + (pageDesc.getPageNo() * pageDesc.getPageSize())
                + " ) WHERE RN >=  " + ((pageDesc.getPageNo() - 1) * pageDesc.getPageSize() + 1);


        sqlFrame = sqlFrame.replace("sqltemp", hql1);
        List<WssbxzcfBo> list = (List<WssbxzcfBo>)findObjectsBySql(sqlFrame);*/
        return list;
    }

    public List<WssbxzcfBo> getXzcfAllList(Map<String, Object> filterMap) {
        String sql = "from L_JIAOTONG_XZCF_2018@to_jttweb a where 1=1 and a.sync_sign <> '3'";
        if(!StringUtils.isBlank((String)filterMap.get("cfjdrqBeginTime"))){
            sql = sql  +"  and a.cf_jdrq >=  to_date('"+filterMap.get("cfjdrqBeginTime")+"','yyyy-MM-dd' )";
        }
        if(!StringUtils.isBlank((String)filterMap.get("cfjdrqEndTime"))){
            sql = sql  +"  and a.cf_jdrq <= to_date('"+filterMap.get("cfjdrqEndTime")+"','yyyy-MM-dd') "; 
        }
        if (!StringUtils.isBlank((String)filterMap.get("cfsclx"))) {
            sql += " and a.cf_sclx = '"+filterMap.get("cfsclx")+"' ";
        }
        if (!StringUtils.isBlank((String)filterMap.get("cfxdrlx"))) {
            //sql += " and a.cf_xdrlx = '"+filterMap.get("cfxdrlx")+"' ";
            String cfxdrlx = (String)filterMap.get("cfxdrlx");
            if("1".equals(cfxdrlx)){
                sql += " and a.cf_xdrlx in('法人及非法人组织','个体工商户' ) ";
            }else if("2".equals(cfxdrlx)){
                sql += " and a.cf_xdrlx = '自然人' ";
            }
        }
        sql += " order by  cf_jdrq desc ";
        String hql1 = "select a.cf_xdr,a.cf_xdr_shxym,a.cf_xdr_gsdj,a.cf_xdr_zdm,a.cf_xdr_swdj,a.cf_xdr_sydw,"+
                "a.cf_xdr_shzjdjzh,a.cf_fr,a.cf_frsfz,a.cf_xdr_zjlx,a.cf_xdr_zjhm,a.cf_wsh," +
                "a.cf_wfxwlx,a.cf_sy,a.cf_yj,a.cf_cflb1,a.cf_nr,a.cf_je,a.cf_msje,a.cf_zkzh,"+
                "a.cf_jdrq,a.cf_yxq,a.cf_gsjzq,a.cf_xzjg,a.cf_jgtyshxy,a.cf_sjlydw,a.cf_lytyshxym,"+
                "a.bz,to_char(sysdate,'yyyymmddhhmmss') as cf_nowtime "+ sql;

        String sqlFrame = "SELECT * FROM ( SELECT A.*, ROWNUM RN "
                + " FROM ( sqltemp ) A WHERE ROWNUM <= 10000000000000000000000 ) WHERE RN >=1  ";


        sqlFrame = sqlFrame.replace("sqltemp", hql1);
        List<WssbxzcfBo> list = (List<WssbxzcfBo>)findObjectsBySql(sqlFrame);
        return list;
    }

}

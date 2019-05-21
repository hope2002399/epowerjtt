package com.centit.jtt2xyb.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.jtt2xyb.bo.JiaoTongLog;
import com.centit.jtt2xyb.bo.Jtt2XybXk;
import com.centit.jtt2xyb.bo.SqlBean;
import com.centit.jtt2xyb.bo.SqlLimit;

public class Jtt2XybXkDao extends BaseDaoImpl<Jtt2XybXk> {
	/**
     * 
     */
    private static final long serialVersionUID = 1923583626529460314L;

    @SuppressWarnings("unchecked")
    public List<Jtt2XybXk> getList(List<SqlBean> sqlBeans,int pageNo,int pageSize){
		String sqlFrame="SELECT * FROM ( SELECT A.*, ROWNUM RN "+
				" FROM ( sqltemp ) A WHERE ROWNUM <= "+(pageNo*pageSize)+" ) WHERE RN >=  "+((pageNo-1)*pageSize+1);
		
		String sql = " select t.xk_wsh xkwsh,t.xk_xmmc xkxmmc,t.xk_jdrq xksxq,t.xk_xdr xkxdr,t.xk_xzjg xkxzjg from l_jiaotong_xzxk@to_jttweb t where 1=1 and ( xk_zt='0' or xk_zt=null or xk_zt='' ) and xk_syfw='0'  and ( case when xk_jzq is null then add_months(xk_jdrq,7*12) else xk_jzq end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql+="order by t.xk_jdrq desc nulls last";
		
		sqlFrame=sqlFrame.replace("sqltemp", sql);
		List<Jtt2XybXk> list = (List<Jtt2XybXk>)findObjectsBySql(sqlFrame);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
    public List<Jtt2XybXk> getListForScroll(List<SqlBean> sqlBeans){
		
		
		String sql = " select t.xk_wsh xkwsh,t.xk_xmmc xkxmmc,t.xk_jdrq xksxq,t.xk_xdr xkxdr,t.xk_xzjg xkxzjg from l_jiaotong_xzxk@to_jttweb t where 1=1 and ( xk_zt='0' or xk_zt=null or xk_zt='' ) and xk_syfw='0' and rksj>=sysdate-10  and ( case when xk_jdrq is null then sysdate else xk_jdrq+8 end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql+="order by t.xk_jdrq desc nulls last";
		
		List<Jtt2XybXk> list = (List<Jtt2XybXk>)findObjectsBySql(sql);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
    public List<Jtt2XybXk> getListForScroll(List<SqlBean> sqlBeans,int pageNo,int pageSize){
		String sqlFrame = "select * from ( sqlTmp ) where rn > " + ((pageNo-1)*pageSize) + " and rn <= " + (pageNo*pageSize);
		
		String sql = " select t.xk_wsh xkwsh,t.xk_xmmc xkxmmc,t.xk_jdrq xksxq,t.xk_xdr xkxdr,t.xk_xzjg xkxzjg,rownum rn from l_jiaotong_xzxk@to_jttweb t where 1=1 and ( xk_zt='0' or xk_zt=null or xk_zt='' ) and xk_syfw='0' and rksj>=sysdate-10  and ( case when xk_jzq is null then add_months(xk_jdrq,7*12) else xk_jdrq+8 end )>=sysdate ";
		
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		sql+="order by t.xk_jdrq desc nulls last";
		
		sqlFrame = sqlFrame.replace("sqlTmp", sql);
		List<Jtt2XybXk> list = (List<Jtt2XybXk>)findObjectsBySql(sqlFrame);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
    public int getSumnum(List<SqlBean> sqlBeans){
		
		String sql = " select t.* from l_jiaotong_xzxk@to_jttweb t where 1=1 and ( xk_zt='0' or xk_zt=null  or xk_zt='' ) and xk_syfw='0'  and ( case when xk_jzq is null then add_months(xk_jdrq,7*12) else xk_jzq end )>=sysdate ";
		for (SqlBean sqlbean : sqlBeans) {
			sql = sql + SqlLimit.buildLimit(sqlbean);
		}
		
		List<Jtt2XybXk> list = (List<Jtt2XybXk>)findObjectsBySql(sql);
		
		return list.size();
	}
	
	@SuppressWarnings("unchecked")
    public Jtt2XybXk getInfo(String id){
		String sql = " select t.xk_wsh xkwsh,t.xk_xmmc xkxmmc,t.xk_jdrq xksxq,t.xk_xdr xkxdr,t.xk_xzjg xkxzjg"
				+ ",t.xk_splb xksplb" 
				+ ",t.xk_nr xknr" 
				+ ",t.xk_xdr_shxym xkxdrshxym" 
				+ ",t.xk_xdr_zdm xkxdrzdm" 
				+ ",t.xk_xdr_gsdj xkxdrgsdj" 
				+ ",t.xk_xdr_swdj xkxdrswdj" 
				+ ",t.xk_xdr_sfz xkxdrsfz" 
				+ ",t.xk_fr xkfr" 
				+ ",t.xk_jzq xkjzq" 
				+ ",t.xk_zt xkzt" 
				+ ",t.dfbm dfbm" 
				+ ",t.sjc sjc" 
				+ ",t.bz bz" 
				+ ",t.xk_bm xkbm" 
				+ ",t.xk_syfw xksyfw" 
				+

				"  from l_jiaotong_xzxk@to_jttweb t where xk_wsh= '" + id + "'";
		//System.out.println(sql);
		Jtt2XybXk xk = new Jtt2XybXk();
		List<Object[]> list = (List<Object[]>)findObjectsBySql(sql);
		if(list!=null && list.size()>0){
			xk.setXkwsh(list.get(0)[0].toString());
		}
		return xk;
	}

	public String  insertData(List<Map<String,Object>> list,HttpServletResponse response,JiaoTongLog log) {
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
					wsh =  (String) list.get(i).get("XK_WSH");
					Jtt2XybXk xk = this.getInfo(wsh);
					if(xk!=null && !StringUtils.isBlank(xk.getXkwsh())){//进行update
					    updateSql = " update L_JIAOTONG_XZXK_TEMP@to_jttweb set XK_XMMC='"+list.get(i).get("XK_XMMC")+"', XK_SPLB='"+list.get(i).get("XK_SPLB")+"', XK_NR='"+list.get(i).get("XK_NR")+"',"
				                + " XK_XDR='"+list.get(i).get("XK_XDR")+"', XK_XDR_SHXYM='"+list.get(i).get("XK_XDR_SHXYM")+"', XK_XDR_ZDM='"+list.get(i).get("XK_XDR_ZDM")+"', XK_XDR_GSDJ='"
					            + list.get(i).get("XK_XDR_GSDJ")+"', XK_XDR_SWDJ='"+list.get(i).get("XK_XDR_SWDJ")+"', "
				                + "  XK_XDR_SFZ='"+list.get(i).get("XK_XDR_SFZ")+"', XK_FR='"+list.get(i).get("XK_FR")+"', XK_JDRQ=to_date('"+list.get(i).get("XK_JDRQ")+"','yyyy/mm/dd'), XK_JZQ=to_date('"+list.get(i).get("XK_JZQ")+"','yyyy/mm/dd'), XK_XZJG='"
					            + list.get(i).get("XK_XZJG")+"', XK_ZT='"+list.get(i).get("XK_ZT")+"', "
				                + "DFBM='"+list.get(i).get("DFBM")+"', SJC=to_date('"+list.get(i).get("SJC")+"','yyyy/mm/dd'), BZ='"+list.get(i).get("BZ")+"', XK_BM='"+list.get(i).get("XK_BM")+"', XK_SYFW='"+list.get(i).get("XK_SYFW")+"',  DATASOURCE='"+list.get(i).get("DATASOURCE")+"' where  XK_WSH='"+list.get(i).get("XK_WSH")+"' ";
						
						try{
						    doExecuteSql(updateSql);
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
					}else{//进行插入
					    insertSql = " insert into L_JIAOTONG_XZXK_TEMP@to_jttweb (XK_WSH, XK_XMMC, XK_SPLB, XK_NR,"
                                + " XK_XDR, XK_XDR_SHXYM, XK_XDR_ZDM, XK_XDR_GSDJ, XK_XDR_SWDJ, "
                                + "  XK_XDR_SFZ, XK_FR, XK_JDRQ, XK_JZQ, XK_XZJG, XK_ZT, DFBM, SJC, BZ, XK_BM, XK_SYFW,  DATASOURCE) "
                                + "  values ( '"+list.get(i).get("XK_WSH")+"','"+list.get(i).get("XK_XMMC")+"','"+list.get(i).get("XK_SPLB")+"','"+list.get(i).get("XK_NR")
                                + "','"+list.get(i).get("XK_XDR")+"','"+list.get(i).get("XK_XDR_SHXYM")+"','"+list.get(i).get("XK_XDR_ZDM")+"','"+list.get(i).get("XK_XDR_GSDJ")
                                + "','"+list.get(i).get("XK_XDR_SWDJ")+"','"+list.get(i).get("XK_XDR_SFZ")+"'"
                                + ",'"+list.get(i).get("XK_FR")+"', to_date('"+list.get(i).get("XK_JDRQ")+"','yyyy/mm/dd'),to_date('"+list.get(i).get("XK_JZQ")+"','yyyy/mm/dd'),"
                                + "'"+list.get(i).get("XK_XZJG")+"','"+list.get(i).get("XK_ZT")+"','"+list.get(i).get("DFBM")+"',to_date('"+list.get(i).get("SJC")+"','yyyy/mm/dd'),'"
                                + list.get(i).get("BZ")+"','"+list.get(i).get("XK_BM")+"','"+list.get(i).get("XK_SYFW")+"','"+list.get(i).get("DATASOURCE")+"' )";
						
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

	public void insertImportData(JiaoTongLog log) {
		String sql = "insert into L_JIAOTONG_LOG@to_jttweb(id,USERID,FILENAME,IP,dataNum,DRJG,TYPE,errormsg ) "
		        + " values( '"+log.getId()+"', '"+log.getUserid()+"', '"+log.getFileName()+"', '"+log.getIp()+"', '"+log.getDataNum()+"', '"+log.getDrjg()+"', '"+log.getType()+"', '"+log.getErrormsg().replaceAll("'", "")+"' )";
		super.doExecuteSql(sql.toString());
	}

}

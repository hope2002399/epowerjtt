package com.centit.indicator.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.CannotCompileException;
import javassist.NotFoundException;

import com.centit.app.form.FieldInfo;
import com.centit.app.util.SqlUtil;
import com.centit.core.dao.CodeBook;
import com.centit.core.dao.BaseDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.po.PmTemplet;

public class PmTempletDao extends BaseDaoImpl<PmTemplet> {
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmTempletDao.class);

	public Map<String, String> getFilterField() {
		if (filterField == null) {
			filterField = new HashMap<String, String>();

			filterField.put("templetId", CodeBook.EQUAL_HQL_ID);

			filterField.put("version", CodeBook.EQUAL_HQL_ID);

			filterField.put("templetCode", CodeBook.LIKE_HQL_ID);

			filterField.put("templetName", CodeBook.LIKE_HQL_ID);

			filterField.put("templetType", CodeBook.EQUAL_HQL_ID);

			filterField.put("year", CodeBook.LIKE_HQL_ID);

			filterField.put("jspName", CodeBook.LIKE_HQL_ID);

			filterField.put("jspHtml", CodeBook.LIKE_HQL_ID);

			filterField.put("releaseFlag", CodeBook.LIKE_HQL_ID);

			filterField.put("createTime", CodeBook.LIKE_HQL_ID);

			filterField.put("createBy", CodeBook.LIKE_HQL_ID);

		}
		return filterField;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getIndicators(String templetId){
		String sql="select t.indicator_id,t.templet_id,t.if_must,t.if_internal,t.internal_table,t.if_along,t.if_primary,t.if_hidden,t.indicator_level,t.indicator_index,t.if_write_back,t.write_back_table,t.write_back_indicator,i.indicator_name,i.indicator_nick_name,i.has_lower,t.father_id,i.if_dictionary,i.dictionary_id,i.dictionary_key,i.input_type,i.if_cascade,i.cascade_id,i.value_type,if_cp,evl_type,evl_method " +
				"from pm_templet_indicator t,pm_indicator i where i.indicator_id=t.indicator_id and t.templet_id='"+templetId+"' order by t.indicator_level,t.indicator_index";
		List<Object[]> objList=(List<Object[]>)findObjectsBySql(sql);
		return objList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getEvlIndicators(String templetId){//获得参与指标测评的指标
		String sql="select t.indicator_id,t.templet_id,t.if_must,t.if_internal,t.internal_table,t.if_along,t.if_primary,t.if_hidden,t.indicator_level,t.indicator_index,t.if_write_back,t.write_back_table,t.write_back_indicator,i.indicator_name,i.indicator_nick_name,i.has_lower,i.father_id,i.if_dictionary,i.dictionary_id,i.dictionary_key,i.input_type,i.if_cascade,i.cascade_id,i.value_type,if_cp,evl_type,evl_method" +
				" from pm_templet_indicator t,pm_indicator i where i.indicator_id=t.indicator_id and t.templet_id='"+templetId+"' order by t.indicator_level,t.indicator_index";
		List<Object[]> objList=(List<Object[]>)findObjectsBySql(sql);
		return objList;
	}

	@SuppressWarnings("unchecked")
	public void alterIndicators(List<String> indicatorsStr, String table) {
		if (indicatorsStr != null && indicatorsStr.size() > 0 && table != null && table.length() > 0) {
			List<String> tableFiled=(List<String>) findObjectsBySql("SELECT T.COLUMN_NAME FROM ALL_TAB_COLUMNS T WHERE UPPER(T.TABLE_NAME)='"+table.toUpperCase().trim()+"'");
			for (int i = 0; i < indicatorsStr.size(); i++) {
				String newFieldSql=indicatorsStr.get(i);
				String newField=newFieldSql.substring(0, newFieldSql.indexOf(" ")).toUpperCase();
				if(tableFiled.contains(newField))continue;
				String sql = "alter table " + table + " add " + indicatorsStr.get(i);
				try {
					super.doExecuteSql(sql);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取新增模版的当前类型下所需的版本号
	 * @param templetType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int getTempletVersion(String templetType){
		String sql="select max(t.version) from pm_templet t where t.templet_Type='"+templetType+"'";
		List<Object> obj=(List<Object>)this.findObjectsBySql(sql);
		if(obj!=null&&obj.size()>0){
			return Integer.parseInt(obj.get(0)==null?"0":obj.get(0).toString())+1;
		}
		return 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void buildFactory(Class c) {
		try {
			Map<String, Object> sqlMap = SqlUtil.getSqlMap(c);
			String tableName = sqlMap.get("tableName").toString();
			FieldInfo primayKey = (FieldInfo) sqlMap.get("primayKey");
			List<FieldInfo> fields = (List<FieldInfo>) sqlMap.get("propertys");
			String sql = "INSERT INTO PM_INDICATOR_FIELD_INFO (CLASS_NAME,TABLE_NAME,PRIMARY_KEY_CLASS,PRIMARY_TYPE,PRIMARY_KEY_TABLE,FIELD_NAME_CLASS,FIELD_NAME_TABLE,FIELD_TYPE) VALUES (";
			if (fields != null && fields.size() > 0) {
				List<String> oldFields=(List<String>)findObjectsBySql("SELECT T.FIELD_NAME_CLASS FROM PM_INDICATOR_FIELD_INFO T WHERE T.CLASS_NAME='"+c.getSimpleName()+"'");
				for (FieldInfo f : fields) {
					if(oldFields.contains(f.getPojoField())){
						continue;
					}else{
						StringBuffer sb = new StringBuffer(sql);
						sb.append("'").append(c.getSimpleName()).append("','").append(tableName).append("','")
								.append(primayKey.getPojoField()).append("','").append(primayKey.getPojoType())
								.append("','").append(primayKey.getTableField()).append("','").append(f.getPojoField())
								.append("','").append(f.getTableField()).append("','").append(f.getPojoType()).append("')");
						doExecuteSql(sb.toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Configuration config = new Configuration();
		// config.addClass(c);
		// config.buildMappings();
		// ClassLoader loader=new URLClassLoader(new URL[]{url});
		// try {
		// c=loader.loadClass(c.getName());
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }
		// config.addFile(xmlPath);
		// config.addResource(c.getName().replace(".", "/")+".hbm.xml", c.getClassLoader());
		// Thread.currentThread().setContextClassLoader(classLoader);
		// config.addResource(url, c.getClassLoader());
		// this.getSessionFactory().close();
		// this.setSessionFactory(config.buildSessionFactory());
	}

	public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
//		PmTemplet p = new PmTemplet();
//		System.out.println(p.getClass().getResource(""));
//		ClassPool pool = ClassPool.getDefault();
//		CtClass pt = pool.get("com.centit.imp.po.PmProvinceProject");
//		CtMethod oldMethod = pt.getDeclaredMethod("copyNotNullProperty");
//		CtField f = CtField.make("private String asd;", pt);
//		pt.addField(f);
//		CtMethod set = CtMethod.make("public void setAsd(String asd){this.asd=asd;}", pt);
//		CtMethod get = CtMethod.make("public String getAsd(){return this.asd;}", pt);
//		pt.addMethod(set);
//		pt.addMethod(get);
//		oldMethod.insertBefore("if(other.getAsd()!=null){this.asd=other.getAsd();}");
//		pt.writeFile();
//		System.out.println(oldMethod.getLongName());
		// String pakage=p.getClass().getPackage().toString();
		// URLClassLoader loader=new URLClassLoader(new URL[]{p.getClass().getClassLoader().getResource("")});
		// String path = pakage.substring(pakage.indexOf("com"))+"."+p.getClass().getName();
		// try {
		// Class c=loader.loadClass(p.getClass().getName());
		// System.out.println(c.getName());
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }
	}
}

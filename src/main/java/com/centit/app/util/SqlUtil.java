package com.centit.app.util;

//import java.io.ByteArrayInputStream;
//import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;

//import org.dom4j.Attribute;
//import org.dom4j.io.SAXReader;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
import com.centit.app.form.FieldInfo;

public class SqlUtil {
	/**
	 * 获取insert语句sql
	 * 
	 * @param request
	 * @param columns
	 * @param table
	 *            表名
	 * @return INSERT INTO table_name (列1, 列2,...) VALUES (?, ?,....)占位sql + Object[]
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getInsetSql(Map<Object, Object> requestMap, Map<String, Object> fieldMap) {
		StringBuffer columnSql = new StringBuffer();
		StringBuffer valueSql = new StringBuffer();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat mm = new SimpleDateFormat("yyyy-MM");
		List value = new ArrayList();
		try {
			// Map<String, Object> fieldMap = getSqlMap(c);
			// FieldInfo primaryKey = (FieldInfo)fieldMap.get("primaryKey");//主键
			String tableName = fieldMap.get("tableName").toString();// 表名
			List<FieldInfo> propertys = (List<FieldInfo>) fieldMap.get("propertys");
			List<String> clumnList=new ArrayList<String>();
			// 判断数据库中字段类型并且把有值的数据转换为数据库字段指定类型
			for (int i = 0; i < propertys.size(); i++) {
				String pojoField = propertys.get(i).getPojoField();
				if(clumnList.size()>0&&clumnList.contains(propertys.get(i).getTableField())){
					continue;
				}
				if (requestMap.containsKey(pojoField) && requestMap.get(pojoField) != null) {
					String param = requestMap.get(pojoField).toString();
					if(param==null||"".equals(param)){
						continue;
					}
					if (propertys.get(i).getPojoType().equals(Date.class.getName())) {// 时间类型
						if (param.length() == 10) {// 2014-01-01
							value.add(dd.parse(param.toString()));
						} else if (param.length() == 7) {// 2014-01
							value.add(mm.parse(param.toString()));
						} else {// 否则认定为空
							value.add(null);
						}
					} else if (propertys.get(i).getPojoType().equals(Double.class.getName())) {// Double类型
						if (param != "") {
							value.add(Double.valueOf(param));
						} else {
							value.add(null);
						}
					} else if (propertys.get(i).getPojoType().equals(Long.class.getName())) {// Long类型
						if (param != "") {
							value.add(Long.valueOf(param));
						} else {
							value.add(null);
						}
					} else {// String和其他类型
						value.add(param);
					}
					clumnList.add(propertys.get(i).getTableField());
					columnSql.append(propertys.get(i).getTableField() + ",");
					valueSql.append("?,");
				}
			}
			if (value.size() > 0) {
				Map<String, Object> sqlMap = new HashMap<String, Object>();
				Object[] obj = new Object[value.size()];
				for (int i = 0; i < value.size(); i++) {
					obj[i] = value.get(i);
				}
				String sql = "INSERT INTO " + tableName + " (" + columnSql.substring(0, columnSql.length() - 1)
						+ ") VALUES (" + valueSql.substring(0, valueSql.length() - 1) + ")";
//				System.out.println(sql);
				sqlMap.put("sql", sql);
				sqlMap.put("value", obj);
				return sqlMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 根据提供的前台传入的参数Map和对应实体类/数据库字段信息拼接更新sql
	 * 
	 * @param requestMap
	 *            前台传入的参数map
	 * @param fieldMap
	 *            字段信息
	 * @param c
	 *            对应实体类的class
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> getUpdateSql(Map<Object, Object> requestMap, Map<String, Object> fieldMap) {
		StringBuffer sql = new StringBuffer();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat mm = new SimpleDateFormat("yyyy-MM");
		List value = new ArrayList();
		try {
			// Map<String, Object> fieldMap = getSqlMap(c);
			FieldInfo primaryKey = (FieldInfo) fieldMap.get("primaryKey");// 主键
			String tableName = fieldMap.get("tableName").toString();// 表名
			sql.append("UPDATE " + tableName + " SET ");
			List<FieldInfo> propertys = (List<FieldInfo>) fieldMap.get("propertys");
			List<String> clumnList=new ArrayList<String>();
			// 判断数据库中字段类型并且把有值的数据转换为数据库字段指定类型
			for (int i = 0; i < propertys.size(); i++) {
				if(clumnList.size()>0&&clumnList.contains(propertys.get(i).getTableField())){
					continue;
				}
				String pojoField = propertys.get(i).getPojoField();
				if (requestMap.containsKey(pojoField) && requestMap.get(pojoField) != null) {
					String param = requestMap.get(pojoField).toString();
					if(param==null||"".equals(param)){
						continue;
					}
					clumnList.add(propertys.get(i).getTableField());
					sql.append(propertys.get(i).getTableField() + "=?,");
					if (propertys.get(i).getPojoType().equals(Date.class.getName())) {// 时间类型
						if (param.length() == 10) {// 2014-01-01
							value.add(dd.parse(param.toString()));
						} else if (param.length() == 7) {// 2014-01
							value.add(mm.parse(param.toString()));
						} else {// 否则认定为空
							value.add("");
						}
					} else if (propertys.get(i).getPojoType().equals(Double.class.getName())) {// Double类型
						if (param != "") {
							value.add(Double.valueOf(param));
						} else {
							value.add(0);
						}
					} else if (propertys.get(i).getPojoType().equals(Long.class.getName())) {// Long类型
						if (param != "") {
							value.add(Long.valueOf(param));
						} else {
							value.add(null);
						}
					} else {// String和其他类型
						if(param==null||param.length()<1){
							value.add(null);
						}else{
							value.add(param);
						}
					}
				}
			}
			if (value.size() > 0) {
				String keyId = requestMap.get(primaryKey.getPojoField()).toString();
				String finalSql = sql.substring(0, sql.length() - 1) + " WHERE " + primaryKey.getTableField() + "=?";
				Map<String, Object> sqlMap = new HashMap<String, Object>();
				Object[] obj = new Object[value.size() + 1];
//				String abc="";
				for (int i = 0; i < value.size(); i++) {
					obj[i] = value.get(i);
//					if(abc.length()>0){
//						abc+=",";
//					}
//					abc+=value.get(i);
				}
//				System.out.println(abc);
				obj[value.size()] = keyId;
				sqlMap.put("sql", finalSql);
				sqlMap.put("value", obj);
				return sqlMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getSelectObjectSql(Map<Object, Object> requestMap, Map<String, Object> fieldMap) {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		FieldInfo primaryKey = (FieldInfo) fieldMap.get("primaryKey");// 主键
		String tableName = fieldMap.get("tableName").toString();// 表名
		List<FieldInfo> propertys = (List<FieldInfo>) fieldMap.get("propertys");
		// 判断数据库中字段类型并且把有值的数据转换为数据库字段指定类型
		List<String> fields = new ArrayList<String>();
		if (propertys == null || propertys.size() < 1)
			return paramMap;
		for (int i = 0; i < propertys.size(); i++) {
			sql.append(propertys.get(i).getTableField() + ",");
			fields.add(propertys.get(i).getPojoField());
		}
		fields.add(primaryKey.getPojoField());
		String primaryValue = requestMap.get(primaryKey.getPojoField()).toString();
		String finalSql = "SELECT " + sql + primaryKey.getTableField() + " FROM " + tableName + " WHERE "
				+ primaryKey.getTableField() + "='" + primaryValue + "'";
		paramMap.put("sql", finalSql);
		paramMap.put("fields", fields);
		return paramMap;
	}

	/**
	 * 根据提供的class读取该class同包下.hbm.xml配置文件 获取表名、主键以及字段和对字段应类型
	 * 
	 * @param pojo
	 *            实体类的class
	 * @return Map<String, Object> "tableName":表名 "primayKey":主键字段 "propertys":其他字段
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> getSqlMap(Class pojo) throws Exception {
		Map<String, Object> fields = new HashMap<String, Object>();
//		String path = pojo.getResource("") + pojo.getSimpleName() + ".hbm.xml";
//		String path=pojo.getResource("").toString();
//		 if(path.toLowerCase().indexOf("file:")>-1){
//			 path=path.substring(path.toLowerCase().indexOf("file:")+6);
//		 }
//		 path=path.substring(0,path.indexOf("impsd/")+6);
//		if(path.indexOf("file:")>-1){
//			path=path.substring(path.indexOf("file:")+6);
//		}
		
		String path="D:/INDICATOR/"+pojo.getSimpleName() + ".hbm.xml";
		System.out.println(path);
//		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		File root = new File("D:/INDICATOR/");
		if(!root.exists()){
			FileUtils.forceMkdir(root);
		}
		FileInputStream fileIns = new FileInputStream(path);
		InputStreamReader fileReder = new InputStreamReader(fileIns, "utf-8");
		int b;
		StringBuffer fileBuffer=new StringBuffer();
		while ((b = fileReder.read()) != -1) {
			fileBuffer.append((char) b);
		}
		String fileStr=fileBuffer.toString().replaceAll(" ", "");
		fileStr=fileStr.substring(fileStr.indexOf("table=\"")+7);
		String tableName=fileStr.substring(0, fileStr.indexOf("\""));
		fields.put("tableName", tableName);
		fileStr=fileStr.substring(fileStr.indexOf("name=\"")+6);
		String pojoIdField=fileStr.substring(0, fileStr.indexOf("\""));
		fileStr=fileStr.substring(fileStr.indexOf("type=\"")+6);
		String pojoIdType=fileStr.substring(0, fileStr.indexOf("\""));
		fileStr=fileStr.substring(fileStr.indexOf("name=\"")+6);
		String tableIdField=fileStr.substring(0, fileStr.indexOf("\""));
		FieldInfo primayKey = new FieldInfo();
		primayKey.setPojoField(pojoIdField);
		primayKey.setTableField(tableIdField);
		primayKey.setPojoType(pojoIdType);
		fields.put("primayKey", primayKey);
		List<FieldInfo> propertys = new ArrayList<FieldInfo>();
		propertys.add(primayKey);
		while (fileStr.indexOf("name=\"")>-1) {
			FieldInfo propertyKey = new FieldInfo();
			fileStr=fileStr.substring(fileStr.indexOf("name=\"")+6);
			propertyKey.setPojoField(fileStr.substring(0, fileStr.indexOf("\"")));
			fileStr=fileStr.substring(fileStr.indexOf("type=\"")+6);
			propertyKey.setPojoType(fileStr.substring(0, fileStr.indexOf("\"")));
			fileStr=fileStr.substring(fileStr.indexOf("name=\"")+6);
			propertyKey.setTableField(fileStr.substring(0, fileStr.indexOf("\"")));
			propertys.add(propertyKey);
		}
		fields.put("propertys", propertys);
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println(fileStr.toString());
//		File xmlFile = new File(path);
//		SAXReader reader = new SAXReader();
//		InputStream inputStream = (new ByteArrayInputStream(fileStr.toString().getBytes("utf-8")));
//		org.dom4j.Document dom4 = reader.read(fileIns);
//		org.dom4j.Element root = dom4.getRootElement();
		//获取class根节点
//		org.dom4j.Element elementClass=root.element("class");
//		String tableName=elementClass.attributeValue("table");//获取table名
//		fields.put("tableName", tableName);
		
		/******以下获取主键信息******/
//		org.dom4j.Element elementId=elementClass.element("id");//获取主键节点
//		String pojoIdField=elementId.attributeValue("name");//获取主键pojoName
//		String pojoIdType=elementId.attributeValue("type");//获取主键类型
//		org.dom4j.Element elementIdClumn=elementId.element("column");
//		String tableIdField=elementIdClumn.attributeValue("name");
//		FieldInfo primayKey = new FieldInfo();
//		primayKey.setPojoField(pojoIdField);
//		primayKey.setTableField(tableIdField);
//		primayKey.setPojoType(pojoIdType);
//		fields.put("primayKey", primayKey);
		/**********************/
		
		/******其他字段信息获取*****/
//		List<org.dom4j.Element> elementProperties=elementClass.elements("property");
//		List<FieldInfo> propertys = new ArrayList<FieldInfo>();
//		propertys.add(primayKey);
//		for (org.dom4j.Element e : elementProperties) {
//			FieldInfo propertyKey = new FieldInfo();
//			org.dom4j.Element et=e.element("column");
//			String pojoField = e.attributeValue("name");
//			String tableField = et.attributeValue("name");
//			String fieldType = e.attributeValue("type");
//			propertyKey.setPojoField(pojoField);
//			propertyKey.setTableField(tableField);
//			propertyKey.setPojoType(fieldType);
//			propertys.add(propertyKey);
//		}
//		fields.put("propertys", propertys);
//		System.out.println(01);
//		DocumentBuilder documentB = builderFactory.newDocumentBuilder();
//		
//		System.out.println(02);
//		System.out.println("readXml");
//		Document document = documentB.parse(xmlFile);
//		System.out.println(03);
//		NodeList tables = document.getElementsByTagName("class");
//		System.out.println(04);
//		Element table = (Element) tables.item(0);
//		System.out.println(05);
//		String tableName = table.getAttribute("table");
//		System.out.println(06);
//		fields.put("tableName", tableName);
//		System.out.println(07);
//		NodeList ids = document.getElementsByTagName("id");
//		Element id = (Element) ids.item(0);
//		NodeList idColumns = id.getElementsByTagName("column");
//		Element idColumn = (Element) idColumns.item(0);
//		String pojoIdField = id.getAttribute("name");
//		String pojoIdType = id.getAttribute("type");
//		String tableIdField = idColumn.getAttribute("name");
//		FieldInfo primayKey = new FieldInfo();
//		primayKey.setPojoField(pojoIdField);
//		primayKey.setTableField(tableIdField);
//		primayKey.setPojoType(pojoIdType);
//		fields.put("primayKey", primayKey);

		// System.out.println(id.getNodeName()+"--"+pojoIdField+"--"+pojoIdType+"--"+tableIdField);
//		NodeList propertyNodes = document.getElementsByTagName("property");
//		List<FieldInfo> propertys = new ArrayList<FieldInfo>();
//		propertys.add(primayKey);
//		for (int i = 0; i < propertyNodes.getLength(); i++) {
//			FieldInfo propertyKey = new FieldInfo();
//			Element property = (Element) propertyNodes.item(i);
//			NodeList columns = property.getElementsByTagName("column");
//			Element column = (Element) columns.item(0);
//			String pojoField = property.getAttribute("name");
//			String tableField = column.getAttribute("name");
//			String fieldType = property.getAttribute("type");
//			propertyKey.setPojoField(pojoField);
//			propertyKey.setTableField(tableField);
//			propertyKey.setPojoType(fieldType);
//			propertys.add(propertyKey);
//			// System.out.println(pojoField+"--"+fieldType+"--"+tableField);
//		}
//		fields.put("propertys", propertys);
		return fields;
	}

	@SuppressWarnings("rawtypes")
	public static Class loadClass(String javaPath) {
		ManageClassLoader mc = new ManageClassLoader();
		Class c = null;
		try {
			c = mc.loadClass(javaPath);// 通过自定义加载器获取加载后的类/class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * 获取前台request中所有参数，若参数以“s_”开头则默认去掉该参数“s_”前缀
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Object, Object> getRequestMap(HttpServletRequest request) {
		Map<Object, Object> requestMap = request.getParameterMap();
		Map<Object, Object> newMap = new HashMap<Object, Object>();
		if (requestMap != null && requestMap.size() > 0) {
			Iterator<Object> keys = requestMap.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				Object value = requestMap.get(key);
				if ((key.indexOf("s_") == 0||key.indexOf("t_") == 0) && !requestMap.containsKey(key.substring(2))) {
					key = key.substring(2);
				}
				if (value == null) {
					continue;
				}
				if (value.getClass().getSimpleName().equals("String[]")) {
					value = ((String[]) value)[0];
				}
				newMap.put(key, value);
			}
		}
		return newMap;
	}

	/**
	 * 根据提供的map和key判断该map中是否有以key为键的参数并且不为空和“”，符合条件返回true否则false
	 * @param map
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean ifContansKeyNotNull(Map map, Object key) {
		if (map == null || !map.containsKey(key) || map.get(key) == null || map.get(key).toString().equals("")) {
			return false;
		}
		return true;
	}
	
	/**
	 * Map<String, Object>转化成Map<Object, Object>
	 * 得到符合serviceManager操作的参数
	 * @param oldMap
	 * @return
	 */
	public static Map<Object, Object> getObjectMap(Map<String, Object> oldMap){
		Map<Object, Object> newMap=new HashMap<Object, Object>();
		if(oldMap==null||oldMap.size()<1)return newMap;
		Iterator<String> keys = oldMap.keySet().iterator();
		while (keys.hasNext()) {
			String key=keys.next();
			newMap.put(key, oldMap.get(key));
		}
		return newMap;
	}

	/**
	 * 把strMap里键值对塞入objMap中返回
	 * @param objMap
	 * @param strMap
	 * @return Map<Object,Object>
	 */
	public static Map<Object,Object> copyNotNullObjectMap(Map<Object, Object> objMap,Map<String, Object> strMap){
		if(strMap==null||strMap.size()<1){
			return objMap;
		}
		Iterator<String> keys = strMap.keySet().iterator();
		while (keys.hasNext()) {
			String key=keys.next();
			objMap.put(key, strMap.get(key));
		}
		return objMap;
	}
	/**
	 * 把objMap里键值对塞入strMap中返回
	 * @param objMap
	 * @param strMap
	 * @return Map<String,Object>
	 */
	public static Map<String,Object> copyNotNullStrMap(Map<String, Object> strMap,Map<Object, Object> objMap){
		if(objMap==null||objMap.size()<1){
			return strMap;
		}
		Iterator<Object> keys = objMap.keySet().iterator();
		while (keys.hasNext()) {
			Object key=keys.next();
			strMap.put(key.toString(), objMap.get(key));
		}
		return strMap;
	}
	
	public static void main(String[] args) throws Exception {
		// StringBuffer a=new StringBuffer("ASD_WER_ZXC");
		// String column=a.toString().toLowerCase();
		// while (column.indexOf("_")>-1) {
		// column=column.substring(0,column.indexOf("_"))+column.substring(column.indexOf("_")+1,column.indexOf("_")+2).toUpperCase()+column.substring(column.indexOf("_")+2);
		// }
		// String asdWerZxc="asdWerZxc,";
		// System.out.println(asdWerZxc.substring(0,asdWerZxc.length()-1));

		// Map<String, Object> fields=new HashMap<String, Object>();
		//
		// String path=PmProvinceProject.class.getResource("")+PmProvinceProject.class.getSimpleName()+".hbm.xml";
		// path=path.substring(path.indexOf("file:/")+6);
		// System.out.println(path);
		// DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		// DocumentBuilder documentB = builderFactory.newDocumentBuilder();
		// Document document=documentB.parse(new File(path));
		// NodeList ids=document.getElementsByTagName("id");
		// Element id=(Element)ids.item(0);
		// NodeList idColumns=id.getElementsByTagName("column");
		// Element idColumn=(Element)idColumns.item(0);
		// String pojoIdField=id.getAttribute("name");
		// String pojoIdType=id.getAttribute("type");
		// String tableIdField=idColumn.getAttribute("name");
		// FieldInfo primayKey=FieldInfo.class.newInstance();
		// primayKey.setPojoField(pojoIdField);
		// primayKey.setTableField(tableIdField);
		// primayKey.setPojoType(pojoIdType);
		// fields.put("primayKey", primayKey);
		//
		// NodeList tables=document.getElementsByTagName("class");
		// Element table=(Element)tables.item(0);
		// String tableName=table.getAttribute("table");
		// fields.put("table", tableName);
		// System.out.println("tableName:"+tableName);
		// System.out.println(id.getNodeName()+"--"+pojoIdField+"--"+pojoIdType+"--"+tableIdField);
		// NodeList propertyNodes = document.getElementsByTagName("property");
		//
		// List<FieldInfo> propertys=new ArrayList<FieldInfo>();
		// for (int i = 0; i < propertyNodes.getLength(); i++) {
		// FieldInfo propertyKey=FieldInfo.class.newInstance();
		// Element property=(Element)propertyNodes.item(i);
		// NodeList columns =property.getElementsByTagName("column");
		// Element column=(Element)columns.item(0);
		// String pojoField=property.getAttribute("name");
		// String tableField=column.getAttribute("name");
		// String fieldType=property.getAttribute("type");
		// propertyKey.setPojoField(pojoField);
		// propertyKey.setTableField(tableField);
		// propertyKey.setPojoType(fieldType);
		// propertys.add(propertyKey);
		// System.out.println(pojoField+"--"+fieldType+"--"+tableField);
		// }
		// fields.put("property", propertys);
		//
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// String d="2014-02-01";
		// String e="2014-11-11";
		// Date dd=sdf.parse(d);
		// Date ee=sdf.parse(e);
		// System.out.println(dd);
		// System.out.println(ee);
		// Object[] obj = new Object[] { "123", 123, new Date() };
		// String a =
		// "XMBM,DWMC,DWXZ,xmxz,ZCZB,yjldshtz,ZCFZL,YHZXQK,YFTRB,ZZYFCG,CWLR,YFSS,ZDCPSCCLZYL,CPFWSCQK,FRZLJG,ZLTXRZQK,HJGLRZQK,XMMC,JSGM,ZTZ,GDZCTZ,JZDSBNDMYWCTZ,NDJHTZ,SSHY,JSDDCS,JSDDQX,JSJD,XMZYD,XMYYYD,DNXXZYD,JSYH,NH,JSBYX,CPZCFHX,GHFHQK,SFDDZDCY,CYYQQK,JSLY,ZLQK,JSXJX,JSCSJSYQK,JSLNXJX,TZQD,DWTZNH,XSSR,LR,SH,JJJYRS,JYXG,DDCYJJFZQK,DDQYFZQK,XJXMKGQZBQK,TGJZ,MONEY_GOVERNMENT,MONEY_ENTERPRISE,MONEY_BANK,MONEY_OTHER,TITANIC_PROJECT,TITANIC_EIA,TITANIC_LAND,fjid,TITANIC_PLAN,ORGAN_PROJECT,ORGAN_EIA,ORGAN_LAND,ORGAN_PLAN,SUBMIT_FLAG,ISSTARTED,SNDXSSR,SNDSSQK,ZYJSNR";
		// String b =
		// "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		// System.out.println(a.split(",").length);
		// System.out.println(b.split(",").length);
		// ManageClassLoader mc = new ManageClassLoader();
		// Class c=null;
		// try {
		// String path=PmProvinceProject.class.getResource("").getPath()+"PmProvinceProject.class";
		// c=mc.loadClass(path.substring(1));//通过自定义加载器获取加载后的类/class
		// Object obj=c.newInstance();
		// System.out.println("");
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// System.out.println(PmProvinceProject.class.getResource("").getPath()+"PmProvinceProject.java");
		//
		// Map a=null;
		// System.out.println(SqlUtil.ifContansKeyNotNull(a, "bbb"));

	}
}

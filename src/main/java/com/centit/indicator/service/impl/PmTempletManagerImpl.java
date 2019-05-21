package com.centit.indicator.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javassist.CannotCompileException;
import javassist.NotFoundException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.centit.app.form.FieldInfo;
import com.centit.app.util.ManageClassLoader;
import com.centit.app.util.SqlUtil;
import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
/*import com.centit.imp.po.PmProvinceProject;*/
import com.centit.indicator.dao.PmIndicatorDao;
import com.centit.indicator.dao.PmTempletDao;
import com.centit.indicator.dao.PmTempletIndicatorDao;
import com.centit.indicator.po.PmIndicator;
import com.centit.indicator.po.PmNode;
import com.centit.indicator.po.PmTemplet;
import com.centit.indicator.po.PmTempletIndicator;
import com.centit.indicator.service.PmTempletManager;
import com.centit.sys.po.FDatadictionary;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * @author znj
 * @create 2014-12-9
 * @version 1.0
 */
public class PmTempletManagerImpl extends BaseEntityManagerImpl<PmTemplet> implements PmTempletManager {
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmTempletManager.class);

	// private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmTempletDao pmTempletDao;
	public void setPmTempletDao(PmTempletDao baseDao) {
		this.pmTempletDao = baseDao;
		setBaseDao(this.pmTempletDao);
	}
	private PmTempletIndicatorDao pmTempletIndicatorDao;
	

    private PmIndicatorDao pmIndicatorDao;
    
    

	public void setPmIndicatorDao(PmIndicatorDao pmIndicatorDao) {
        this.pmIndicatorDao = pmIndicatorDao;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void generateTempletFile(String dataJson, String templetPath, String fileName, String formName) {
		dataJson = dataJson.replace("null", "\"\"");
		Configuration cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File( templetPath + "/ftl") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
		try {
			Template tplCompose = cfg.getTemplate("html.ftl");
			Template tplForm = cfg.getTemplate("form.ftl");
			Template tplView = cfg.getTemplate("view.ftl");
			Map data = new HashMap();
			data.put("formName", formName);
			data.put("dataJson", dataJson);

			String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tplForm, data);
			File file = new File(templetPath + "/jsp/" + fileName +"Form.jsp");
			FileUtils.writeStringToFile(file, htmlText, "utf-8");
			
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tplView, data);
			file = new File(templetPath + "/jsp/" + fileName + "View.jsp");
			FileUtils.writeStringToFile(file, htmlText, "utf-8");
			
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tplCompose, data);
			file = new File(templetPath + "/jsp/" + fileName + "Compose.jsp");
			FileUtils.writeStringToFile(file, htmlText, "utf-8");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<PmNode> getIndicators(String templetId) {
		List<Object[]> objList = pmTempletDao.getIndicators(templetId);
		List<PmNode> nodes = new ArrayList<PmNode>();
		for (int i = 0; i < objList.size(); i++) {
			PmNode node = setNode(objList.get(i));
			if (node != null) {
				nodes.add(node);
			}
		}
		return nodes;
	}
	
	@Override
	public List<PmNode> getEvlIndicators(String templetId) {//获得参与测评的所有字段
		List<Object[]> objList = pmTempletDao.getEvlIndicators(templetId);
		List<PmNode> nodes = new ArrayList<PmNode>();
		for (int i = 0; i < objList.size(); i++) {
			PmNode node = setNode(objList.get(i));
			if (node != null) {
				nodes.add(node);
			}
		}
		return nodes;
	}
	private PmNode setNode(Object[] obj) {
		PmNode node = new PmNode();
		try {
			node.setIndicatorId(obj[0].toString());
			node.setTempletId(obj[1].toString());
			node.setIfMust(obj[2] == null ? "F" : obj[2].toString());
			node.setIfInternal(obj[3] == null ? "F" : obj[3].toString());
			node.setInternalTable(obj[4] == null ? "" : obj[4].toString());
			node.setIfAlong(obj[5] == null ? "F" : obj[5].toString());
			node.setIfPrimary(obj[6] == null ? "F" : obj[6].toString());
			node.setIfHidden(obj[7] == null ? "F" : obj[7].toString());
			node.setIndicatorLevel(Long.parseLong(obj[8].toString()));
			node.setIndicatorIndex(Long.parseLong(obj[9].toString()));
			node.setIfWriteBack(obj[10] == null ? "" : obj[10].toString());
			node.setWriteBackTable(obj[11] == null ? "" : obj[11].toString());
			node.setWriteBackIndicator(obj[12] == null ? "" : obj[12].toString());
			node.setIndicatorName(obj[13] == null ? "" : obj[13].toString());
			node.setIndicatorNickName(obj[14] == null ? "" : obj[14].toString());
			node.setHasLower(obj[15] == null ? "" : obj[15].toString());
			node.setFatherId(obj[16] == null ? "" : obj[16].toString());
			node.setIfDictionary(obj[17] == null ? "" : obj[17].toString());
			node.setDictionaryId(obj[18] == null ? "" : obj[18].toString());
			node.setDictionaryKey(obj[19] == null ? "" : obj[19].toString());
			node.setInputType(obj[20] == null ? "" : obj[20].toString());
			node.setIfCascade(obj[21] == null ? "" : obj[21].toString());
			node.setCascadeId(obj[22] == null ? "" : obj[22].toString());
			node.setValueType(obj[23] == null ? "" : obj[23].toString());
			node.setIfCp(obj[24] == null ? "" : obj[24].toString());
			node.setEvlType(obj[25] == null ? "" : obj[25].toString());
			node.setEvlMethod(obj[26] == null ? "" : obj[26].toString());
		} catch (NumberFormatException e) {
			return null;
		}
		return node;
	}
	/**
	 * 动态编译pojo文件入口
	 */
	@SuppressWarnings({ "unused" })
	public int compileClass(List<PmNode> nowIndicators, FDatadictionary fd) {
		if (nowIndicators == null || nowIndicators.size() < 1) {
			return 1;
		}
		int factoryResult=compileFactory(nowIndicators, fd);//动态编译加载文件
		if(factoryResult==-1|| fd == null){
			return -1;
		}
		/*if(fd.getId().getDatacode().equals("Pm_Province_Project")){//省重点项目需要在确认库也更新字段
			String dateCode="Pm_Province_Project";
			String dateDesc=fd.getDatadesc();
			fd.getId().setDatacode(dateCode+"_Storage");
			fd.setDatadesc(dateDesc+"Storage");
			compileFactory(nowIndicators, fd);//确认库
			fd.getId().setDatacode(dateCode+"_Alter");
			fd.setDatadesc(dateDesc+"Alter");
			compileFactory(nowIndicators, fd);//备选库
			
		}else if(fd.getId().getDatacode().equals("Pm_City_Project")){//市重点项目需要在确认库也更新字段
			fd.getId().setDatacode("Pm_City_Project_Qr");
			fd.setDatadesc(fd.getDatadesc()+"Qr");
			compileFactory(nowIndicators, fd);
		}*/
		//PmProvinceProject p=new PmProvinceProject();
		return 1;
	}
	/**
	 * 自定义classLoader加载类进入JVM
	 * @param path 加载的类的物理文件class全地址--D:/.../.../a.class
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private Class loadClass(String javaPath){
		ManageClassLoader mc = new ManageClassLoader();
		Class c=null;
		try {
			c=mc.loadClass(javaPath);//通过自定义加载器获取加载后的类/class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 读取相应java文件、xml配置文件，并且将定义的指标需要新增入表的写入文件和数据库
	 * @author znj
	 * @param nowIndicators
	 * @param fd
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private int compileFactory(List<PmNode> nowIndicators, FDatadictionary fd){
		String flodPath="D:/INDICATOR/";//PO包地址
		String javaPath;//PO下JAVA地址
		String xmlPath;//PO下对应JAVA的XML地址
		try {
			Class c = Class.forName(fd.getDatadesc());//获取需要变更的class对象
			List<String> fieldName = new ArrayList<String>();
			Map<String, Object> fieldMap=SqlUtil.getSqlMap(c);
			List<FieldInfo> propertys=(List<FieldInfo>)fieldMap.get("propertys");
			for (FieldInfo fe : propertys) {
				if(!fieldName.contains(fe.getPojoField())){
					fieldName.add(fe.getPojoField());
				}
			}
			List<String> addFields = new ArrayList<String>();//存储需要变更的字段
			List<PmNode> addIndicators=new ArrayList<PmNode>();//存储需要变更的字段全部属性
			for (int i = 0; i < nowIndicators.size(); i++) {//是否有需要新增的字段
//				System.out.println(nowIndicators.get(i).getIndicatorNickName());
				if (!fieldName.contains(nowIndicators.get(i).getIndicatorNickName())) {
					addFields.add(nowIndicators.get(i).getIndicatorNickName());
					addIndicators.add(nowIndicators.get(i));
				}
			}
			if(addFields.size()<1){//无新增需求时不需要读取原文件进行变更
				return 666;
			}
//			flodPath = c.getClassLoader().getResource("") + "";
//			 flodPath=this.getClass().getResource("").toString();
//			 if(flodPath.toLowerCase().indexOf("file:")>-1){
//				 flodPath=flodPath.substring(flodPath.toLowerCase().indexOf("file:")+6);
//			 }
//			 flodPath=flodPath.substring(0,flodPath.indexOf("impsd/")+6);
//			flodPath="D:/INDICATOR/";
//			if(flodPath.indexOf("file:")>-1){
//				flodPath=flodPath.substring(flodPath.indexOf("file:")+6);
//			}String path="D:/INDICATOR/"+pojo.getSimpleName() + ".hbm.xml";
//			javaPath = flodPath + fd.getDatadesc().replace(".", "/") + ".java";
//			xmlPath = flodPath + fd.getDatadesc().replace(".", "/") + ".hbm.xml";
			javaPath=flodPath+c.getSimpleName()+".java";
			xmlPath=flodPath+c.getSimpleName()+".hbm.xml";
			String javaStr=readFile( javaPath);//获取远java文件字符串
			String xmlStr=readFile(xmlPath);//获取远java文件对应xml文件字符串
			if(javaStr=="")return -1;//读取失败直接返回
			String newJavaStr="";
			try {
				newJavaStr = newJavaStr(addFields, javaStr,c);//新增字段后组成的java文件字符串
			} catch (Exception e) {
				e.printStackTrace();
			}//添加字段后的java文件字符串
			int writeResult=writeFile(javaPath, newJavaStr);//将新java文件字符串写入文件
			if(writeResult==0){//写入失败返回写入原java字符串
				writeFile(javaPath, javaStr);
				return -1;
			}else{
				compileToClass(flodPath, javaPath);//动态编译java文件生成.class文件
			}
			if(xmlStr==""){//xml获取字符串失败
				writeFile(javaPath, javaStr);
				compileToClass(flodPath, javaPath);
				return -1;
			}else{
				String newXmlStr=newXmlStr(addIndicators, xmlStr,fd);//添加字段后的java文件对应xml文件字符串
				writeFile(xmlPath, newXmlStr);//写入对应hbm.xml文件中
				
//				Class newClassc=loadClass(flodPath + fd.getDatadesc().replace(".", "/") +".class");
				pmTempletDao.buildFactory(c);//编译到JVM
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
	/**
	 * 获取修改后的java字符串
	 * @param addFields
	 * @param javaStr
	 * @return
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 */
	@SuppressWarnings("rawtypes")
	private String newJavaStr(List<String> addFields,String javaStr,Class c) throws Exception{
		if(javaStr==null||"".equals(javaStr))return "";
		StringBuffer privateStr=new StringBuffer();//private String XXXX；private String XXXX；private……
//		StringBuffer copyNotNullStr=new StringBuffer();//if(other.getXxx()!=null)this.xxx=other.getXxx();if(other.getXxx()!=null)this.xxx=other.getXxx();……
		StringBuffer getAndSetStr=new StringBuffer();//get和set方法
//		ClassPool pool=ClassPool.getDefault();//获取Pool工具
//		pool.insertClassPath(new ClassClassPath(this.getClass()));//获取容器当前类根路径
//		CtClass pt = pool.get(c.getName());//通过Pool工具获取内存中类.class
//		CtMethod oldMethod=pt.getDeclaredMethod("copyNotNullProperty");//获取copyNotNullProperty方法
		for (int i = 0; i < addFields.size(); i++) {
			String methodName=addFields.get(i).substring(0,1).toUpperCase()+addFields.get(i).substring(1);
			String field="private String "+addFields.get(i)+";";//定义字段--private String A;
			String methodGet="public String get"+methodName+"(){return this."+addFields.get(i)+";}";//字段A封装get方法
			String methodSet="public void set"+methodName+"(String "+addFields.get(i)+"){this."+addFields.get(i)+"="+addFields.get(i)+";}";//字段A封装set方法
//			String methodCopy="if(other.get"+methodName+"()!=null)this."+addFields.get(i)+"=other.get"+methodName+"();";//copyNouNullProperty添加
			privateStr.append(field);//java文件需要添加字段字符串
//			copyNotNullStr.append(methodCopy);//java文件copyNotNullProperty方法添加代码块
			getAndSetStr.append(methodGet);//java文件添加封装get方法字符串
			getAndSetStr.append(methodSet);//java文件添加封装set方法字符串
//			pt.addField(CtField.make(field, pt));//添加字段
//			pt.addMethod(CtMethod.make(methodSet, pt));//字段set方法添加进去
//			pt.addMethod(CtMethod.make(methodGet, pt));//不解释
//			oldMethod.insertBefore(methodCopy);//在方法return之前添加代码块
		}
		javaStr=javaStr.substring(0,javaStr.lastIndexOf("}"))+privateStr+getAndSetStr+"}";
//		pt.writeFile();//写入内存中
		//以下为拼接java文件需要更新后的字符串
//		int copyNotNullIndex=javaStr.indexOf("copyNotNullProperty(");
//		String javaStrHead=javaStr.substring(0,copyNotNullIndex);
//		String javaStrEnd=javaStr.substring(copyNotNullIndex);
//		javaStrEnd=javaStrEnd.substring(0, javaStrEnd.indexOf("{")+1)+copyNotNullStr+javaStrEnd.substring(javaStrEnd.indexOf("{")+1);
//		javaStrEnd=javaStrEnd.substring(0,javaStrEnd.lastIndexOf("}"))+privateStr+getAndSetStr+"}";
//		javaStr=javaStrHead+javaStrEnd;
//		System.out.println(javaStr);
		return javaStr;
	}
	/**
	 * 新增对应表中字段
	 * 获取修改后的java文件对应xml文件字符串
	 * @param addIndicators
	 * @param xmlStr
	 * @return
	 */
	private String newXmlStr(List<PmNode> addIndicators,String xmlStr,FDatadictionary fd){
		if(xmlStr==null||"".equals(xmlStr))return "";
		StringBuffer newXmlStr=new StringBuffer();
		List<String> alterSql=new ArrayList<String>();
		for (int i = 0; i < addIndicators.size(); i++) {
			//为每个新增字段拼接xml格式的字符串  
			String sql=addIndicators.get(i).getIndicatorNickName();//alter table XXX add XXX varchar2(32)
			newXmlStr.append("<property name=\"");
			newXmlStr.append(addIndicators.get(i).getIndicatorNickName());
			newXmlStr.append("\" type=\"java.lang.String\">");
			newXmlStr.append("<column name=\"");
			newXmlStr.append(addIndicators.get(i).getIndicatorNickName());
			newXmlStr.append("\" length=\"");
			if(addIndicators.get(i).getInputType().equals("02")){
				newXmlStr.append("1500");
				sql+=" varchar2(1500)";
			}else{
				newXmlStr.append("150");
				sql+=" varchar2(150)";
			}
			newXmlStr.append("\" /></property>");
			alterSql.add(sql);
		}
		newXmlStr.append("</class>");
		xmlStr=xmlStr.replace("</class>", newXmlStr);
		//需要添加的字符串alter到对应表中
		this.pmTempletDao.alterIndicators(alterSql, fd.getExtracode());
		return xmlStr;
	}
	
	/**
	 * 通过给定地址和文件字符写入指定文件
	 * @param filePath
	 * @param fileStr
	 * @return 0失败  1成功
	 */
	private int writeFile(String filePath,String fileStr){
		int result=0;
		File javaFile = new File(filePath);
		OutputStream fileOut=null;
		OutputStreamWriter fileWriter=null;
		try {
			fileOut=new FileOutputStream(javaFile);
			fileWriter=new OutputStreamWriter(fileOut,"utf-8");
			fileWriter.write(fileStr);
			result=1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fileWriter!=null)fileWriter.close();
				if(fileOut!=null)fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 根据提供地址读取文件返回字符串
	 * @param filePath
	 * @return 文件字符串
	 */
	private String readFile(String filePath){
		File javaFile = new File(filePath);
		StringBuffer fileStr = new StringBuffer();//存储杜浒的文件字符串,.
		int b;
		InputStream fileIns = null;
		InputStreamReader fileReder = null;
		try {
			fileIns = new FileInputStream(javaFile);
			fileReder = new InputStreamReader(fileIns, "utf-8");
			while ((b = fileReder.read()) != -1) {
				fileStr.append((char) b);
			}
			// System.out.println(javaStr.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReder != null) {
					fileReder.close();
				}
				if (fileIns != null) {
					fileIns.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(fileStr.length()>0){
			return fileStr.toString();
		}else{
			return "";
		}
//		System.out.println(result);
	}
	/**
	 * 通过地址编译JAVA生成.class文件
	 * @param flodPath
	 * @param filePath
	 * @return 0-成功
	 */
	private int compileToClass(String flodPath,String javaPath){
		int result=0;
//		com.sun.tools.javac.Main javac = new com.sun.tools.javac.Main();
//		String[] args = new String[] { "-s", flodPath, "-encoding", "utf-8", javaPath };
//		result = javac.compile(args);
		return result;
	}
	public static void main(String[] args) {
		PmTempletManagerImpl pm=new PmTempletManagerImpl();
		String a=pm.readFile("D:\\css.txt");
		StringBuffer b=new StringBuffer();
		while (a.indexOf("position:")>-1) {
			b.append(a.substring(0,a.indexOf("position:")+9));
			a=a.substring(a.indexOf("position:")+9);
			String c=a.substring(0,a.indexOf("px"));
			String[] d=c.split(" ");
			b.append(d[1]+"px "+d[0]+"px;}");
			a=a.substring(a.indexOf("}")+1);
		}
		System.out.println(b);
//		String a="a.b.c.d";
//		a=a.replace(".", "/");
//		System.out.println(a);
//		String flodPath="";
//		String javaPath="";
//		try {
//			Class c = Class.forName("com.centit.task.po.PmProvinceProjectOhtfTask");
//			flodPath = c.getClassLoader().getResource("") + "";
//			flodPath=flodPath.substring(flodPath.indexOf("file:")+6);
//			javaPath ="D:/PmProvinceProjectOhtfTask" + ".java";
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		File javaFile = new File(javaPath);
//		StringBuffer fileStr = new StringBuffer();//存储杜浒的文件字符串,.
//		int b;
//		InputStream fileIns = null;
//		InputStreamReader fileReder = null;
//		try {
//			fileIns = new FileInputStream(javaFile);
//			fileReder = new InputStreamReader(fileIns, "utf-8");
//			while ((b = fileReder.read()) != -1) {
//				fileStr.append((char) b);
//			}
//			// System.out.println(javaStr.toString());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fileReder != null) {
//					fileReder.close();
//				}
//				if (fileIns != null) {
//					fileIns.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		List<String> addFields=new ArrayList<String>();
//		addFields.add("name111");
//		StringBuffer privateStr=new StringBuffer();
//		StringBuffer copyNotNullStr=new StringBuffer();
//		StringBuffer getAndSetStr=new StringBuffer();
//		for (int i = 0; i < addFields.size(); i++) {
//			privateStr.append("private String "+addFields.get(i)+";");
//			String methodName=addFields.get(i).substring(0,1).toUpperCase()+addFields.get(i).substring(1);
//			copyNotNullStr.append("if(other.get"+methodName+"()!=null)this."+addFields.get(i)+"=other.get"+methodName+"();");
//			getAndSetStr.append("public String get"+methodName+"(){return this."+addFields.get(i)+";}");
//			getAndSetStr.append("public void set"+methodName+"(String "+addFields.get(i)+"){this."+addFields.get(i)+"="+addFields.get(i)+";}");
//		}
//		String javaStr=fileStr.toString();
//		int copyNotNullIndex=javaStr.indexOf("copyNotNullProperty(");
//		String javaStrHead=javaStr.substring(0,copyNotNullIndex);
//		String javaStrEnd=javaStr.substring(copyNotNullIndex);
//		javaStrEnd=javaStrEnd.substring(0, javaStrEnd.indexOf("{")+1)+copyNotNullStr+javaStrEnd.substring(javaStrEnd.indexOf("{")+1);
//		javaStrEnd=javaStrEnd.substring(0,javaStrEnd.lastIndexOf("}"))+privateStr+getAndSetStr+"}";
//		javaStr=javaStrHead+javaStrEnd;
//		File aaa = new File(javaPath);
//		OutputStream fileOut=null;
//		OutputStreamWriter fileWriter=null;
//		try {
//			fileOut=new FileOutputStream(aaa);
//			fileWriter=new OutputStreamWriter(fileOut,"utf-8");
//			fileWriter.write(javaStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				if(fileWriter!=null)fileWriter.close();
//				if(fileOut!=null)fileOut.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		com.sun.tools.javac.Main javac = new com.sun.tools.javac.Main();
//		String[] a = new String[] { "-s", "D:\\", "-encoding", "utf-8", javaPath };
//		int result = javac.compile(a);
	}

	@Override
	public void saveObject(PmTemplet templet, List<PmTempletIndicator> indicatorList) {
		// TODO Auto-generated method stub
		
		//1.删除PmTempletIndicator中当前模板已存在的数据
		String delsql="delete from pm_templet_indicator where templet_id='"+templet.getTempletId()+"'";
		this.pmTempletDao.doExecuteSql(delsql);
		//2.保存模板
		PmTemplet newTemplet = this.getObjectById(templet.getTempletId());
		if (newTemplet == null) {
			newTemplet = new PmTemplet();
		}
		this.copyObjectNotNullProperty(newTemplet, templet);
		this.saveObject(newTemplet);
		//3.将新的模板指标存入表PmTempletIndicator中
		// TODO: 新增模板时报错，因为新的templet的保存还没提交--好像已经不报了  谁改了  我吗？哈哈
		if(indicatorList!=null&&indicatorList.size()>0){
			for(PmTempletIndicator indicator:indicatorList){
				indicator.setVersion(templet.getVersion());
				this.pmTempletIndicatorDao.saveObject(indicator);
			}
		}
	}
	public int getTempletVersion(String templetType){
		return pmTempletDao.getTempletVersion(templetType);
	}
	public void setPmTempletIndicatorDao(PmTempletIndicatorDao pmTempletIndicatorDao) {
		this.pmTempletIndicatorDao = pmTempletIndicatorDao;
	}
	

	
	/**
	 * 获取JSP文件名称（不带.jsp）
	 * @return
	 */
	public String getJspFileName(PmTemplet templet) {
		if(templet==null)return "";
		return templet.getTempletType() + "_" + templet.getVersion();
	}

	@Override
	public boolean checkJspFile(PmTemplet templet, String basePath) {
		String fullPath = basePath + "\\templets\\jsp\\" + this.getJspFileName(templet) + "Form.jsp";
		File f = new File(fullPath);
		if (!f.exists())
			this.generateTempletFile(templet.getJspHtml(), basePath + "\\templets",
					this.getJspFileName(templet), templet.getTempletName());
		
		return true;
	}
	
	public PmTemplet getVersionTemplet(String templetType){
		Map<String, Object> map=new HashMap<String, Object>();
		List<PmTemplet> temList=pmTempletDao.listObjects("from PmTemplet t where 1=1 and t.releaseFlag='T' and t.templetType='"+templetType+"'", map);
		if(temList!=null&&temList.size()>0){
			return temList.get(0);
		}
		return null;
	}

    @Override
    public List<PmTemplet> listObjectsPmtem(Map<String, Object> filterMap,
            PageDesc pageDesc) {
        List<PmTemplet> temList = this.listObjects(filterMap, pageDesc);
        if(temList!=null&&temList.size()>0){
            return temList;
        }
        return null;
    }

    @Override
    public String getTemplateXml(Map<Object, Object> paramMap, String templetId) {
        // TODO Auto-generated method stub
        
        // TODO Auto-generated method stub
        StringBuffer tempXml=new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?><FORMDATA>");
        
  
            tempXml.append(getTemplateXmlType2(paramMap,templetId));
        
        tempXml.append("</FORMDATA>");
        
        return tempXml.toString();
        
    }
    
    @SuppressWarnings("unchecked")
    private String getTemplateXmlType2(Map<Object, Object> paramMap,
            String templetId) {
        // TODO Auto-generated method stub
        StringBuffer tempxml = new StringBuffer("");

      /*  List<PmTempletIndicator> thirdList = pmTempletIndicatorDao
                .listObjects(
                        "From PmTempletIndicator t where t.templetId1=? and t.indicatorLevel=2 order by  t.indicatorIndex ",
                        templetId);*/
        List<PmTempletIndicator> thirdList = pmTempletIndicatorDao.findObjectsBySql("select * From Pm_Templet_Indicator t where t.templet_Id=? order by  t.indicator_Index ", templetId, PmTempletIndicator.class);

        PmIndicator thirdPi = null;

        if (thirdList != null && thirdList.size() > 0) {
            for (PmTempletIndicator ptiii : thirdList) {
                thirdPi = pmIndicatorDao.getObjectById(ptiii.getIndicatorId());

                tempxml.append("<DATA><KEY>")
                        .append(thirdPi.getIndicatorNickName())
                        .append("</KEY><NAME>")
                        .append(thirdPi.getIndicatorName())
                        .append("</NAME><VALUE>")
                        .append(paramMap.get(thirdPi.getIndicatorNickName()) == null ? ""
                                : paramMap.get(thirdPi.getIndicatorNickName()))
                        .append("</VALUE></DATA>");
            }
        }

        return tempxml.toString();
    }

    @Override
    public void paseTemplateXml(Map<String, Object> obj, String xmlString) {
        // TODO Auto-generated method stub
      //处理返回的数据,封装实体类
        try{
        Document document = DocumentHelper.parseText(xmlString);
        Element root = document.getRootElement();
       // root = root.element("FORMDATA");
       /* Iterator iter = root.elementIterator("FIRST");
        while (iter.hasNext()) {
            Element ele = (Element) iter.next();
            Iterator iter2 = ele.elementIterator("SECOND");
            while (iter2.hasNext()) {
                Element ele2 = (Element) iter2.next();
                ele2=ele2.element("DATA");
                String key = ele2.attributeValue("KEY");
                String name = ele2.attributeValue("NAME");
                String value = ele2.attributeValue("VALUE");
                obj.put(key, value);
                
            }
        }*/
        Iterator iter = root.elementIterator("DATA");
        while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                String key = ele.attributeValue("KEY");
                String name = ele.attributeValue("NAME");
                String value = ele.attributeValue("VALUE");
                obj.put(key, value);
                
        }
        

        }catch(Exception ex){
            ex.printStackTrace();
        }
    
	
    }
}

<%@page import="com.centit.support.utils.xml.XmlUtils"%><%
/*--------------------------------------------------|
| savexml.js | http://www.tops.com.cn/              |
|---------------------------------------------------|
| Copyright (c) 2000-2004 Hi,Hi(support@tops.com.cn)|
|                                                   |
| 将上传的XML对象以文件形式保存在服务器的data目录下 |
|                                                   |
| 您可以随便在非商业软件中使用本代码，使用前请      |
| 保留本注释                                        |
|                                                   |
| Updated: 20060725                                 |
|--------------------------------------------------*/
%>
<%@ page contentType="text/xml; charset=gbk" %>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import ="org.dom4j.*"%>
<%
  try{
  
    Document doc = null;
    
    String xmlDoc = "<?xml version=\"1.0\" encoding=\"GBK\"?>"+(String)request.getParameter("xmlDoc");
        
    //System.out.println(">>>>>>>>>>xmlDoc:  "+xmlDoc);       
    
    doc = XmlUtils.string2xml(xmlDoc);
    // doc = builder.parse(new File(request.getRealPath("data"),"default.xml"));
    // doc = builder.parse(file);
    //保存
    Element element = (Element)doc.selectSingleNode("//Flow");    
 	String S = element.attribute("filename").getValue();
    // System.out.println(">>>>>>>>>> "+request.getRealPath("page\\workflow\\data"));
    //System.out.println(">>>>>>>>>> S: "+S);
    
    File file = new File(request.getSession().getServletContext().getRealPath("page\\workflow\\data"), S+".xml");
    FileWriter fw = new FileWriter(file);
	fw.write(xmlDoc);

	fw.flush();
	fw.close();
   
  }
  catch(Exception e){
    //e.printStackTrace();  
    out.println(e.getMessage());
  }
%>

<html>
<form name="xmlForm" action="sampleFlowDefine!defFlow.do">
	<input type="hidden" name="" value=""></input>
</form>	

</html>
<script>
	document.all.xmlForm.submit();
</script>


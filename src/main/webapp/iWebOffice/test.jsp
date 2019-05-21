<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*,java.sql.*,java.text.SimpleDateFormat,java.text.DateFormat" %>
<%@page import="com.centit.weboffice.*"%>
<%!
iDBManager2000 DbaObj=new iDBManager2000();
%>
<html>
<head>
<title></title>
<link rel='stylesheet' type='text/css' href='test.css'>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript">
function newDoc(val){
	alert(val);
	if(window.confirm("重新选择模板会生成新的文件，已保存的内容将被覆盖，是否确定？")){
		var tempid = document.getElementById("fwType").value;
		var userid = 'u10708'; //'${SPRING_SECURITY_CONTEXT.authentication.principal.usercode}';
		window.open("<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp?FileType=.wps&flowInstId=1234&nodeInstId=5678&RecordID="+userid+"&UserName="+userid+"&Template=" + val);
	}
}

function viewDoc(){
	var tempid = document.getElementById("fwType").value;
	var userid =  'u10708'; //'${SPRING_SECURITY_CONTEXT.authentication.principal.usercode}';
	window.open("<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp?flowStep=FWCL&RecordID="+userid+"&EditType=2,1&ShowType=1&UserName="+userid);	
}


</script>
</head>
<body bgcolor="#ffffff">
<hr size=1>
  <table width="100%"><tr><td height="25"><script src="iWebOffice2009.js"></script></td></tr></table>
<hr size=1>
<br>
<table border=0  cellspacing='0' cellpadding='0' width=100% align=center class=TBStyle>
<tr>
  <td colspan=4 class="TDTitleStyle" >
    请选择模版:<%=DocumentService.getTemplateByName("fwType",".wps")%>
    <input type="button" onclick="viewDoc();" value="修改正文" class="btn processBtn" />
    <br>
  </td>
  <td colspan=2 class="TDTitleStyle">由于不同用户保留痕迹将使用不同的颜色，所以在修改文档时请更改身份<input type=text name=username size=8 value="演示人">
  </td>
</tr>

<tr>
  <td nowrap align=center class="TDTitleStyle" height="25">编号</td>
  <td nowrap align=center class="TDTitleStyle">主题</td>
  <td nowrap align=center class="TDTitleStyle">作者</td>
  <td nowrap align=center class="TDTitleStyle">类型</td>
  <td nowrap align=center class="TDTitleStyle">日期</td>
  <td nowrap align=center class="TDTitleStyle">操作</td>
</tr>
<%
    try {
      if (DbaObj.OpenConnection()) {
        try {
          ResultSet result = DbaObj.ExecuteQuery("select Status,RecordID,HtmlPath,DocumentID,Subject,Author,FileType,FileDate from Document order by DocumentID desc");
          while (result.next()) {
            String RecordID = result.getString("RecordID");
            String HTMLPath = result.getString("HtmlPath");
            if (HTMLPath == null)
               HTMLPath = "";
%>
<tr>
  <td class="TDStyle"><%=result.getString("DocumentID")%>&nbsp;</td>
  <td class="TDStyle"><%=result.getString("Subject")%>&nbsp;</td>
  <td class="TDStyle"><%=result.getString("Author")%>&nbsp;</td>
  <td class="TDStyle"><%=result.getString("FileType")%>&nbsp;</td>
  <td class="TDStyle"><%=result.getString("FileDate")%>&nbsp;</td>
  <td class="TDStyle" nowrap>
    <input type=button onClick="javascript:location.href='<%=request.getContextPath()%>/page/iWebOffice/DocumentEdit.jsp?RecordID=<%=RecordID%>&EditType=0,0&ShowType=1&UserName='+username.value;" value="阅读">
    <input type=button onClick="javascript:location.href='<%=request.getContextPath()%>/page/iWebOffice/DocumentEdit.jsp?RecordID=<%=RecordID%>&EditType=1,1&ShowType=1&UserName='+username.value;" value="修改[无痕迹]">
    <input type=button onClick="javascript:location.href='<%=request.getContextPath()%>/page/iWebOffice/DocumentEdit.jsp?RecordID=<%=RecordID%>&EditType=2,1&ShowType=1&UserName='+username.value;" value="修改[有痕迹]">
    <input type=button onClick="javascript:location.href='<%=request.getContextPath()%>/page/iWebOffice/DocumentEdit.jsp?RecordID=<%=RecordID%>&EditType=3,1&ShowType=2&UserName='+username.value;" value="领导手写">
    <input type=button onClick="javascript:location.href='<%=request.getContextPath()%>/page/iWebOffice/DocumentEdit.jsp?RecordID=<%=RecordID%>&EditType=3,0&ShowType=0&UserName='+username.value;" value="审核">
    <input type=button <% if (HTMLPath.equalsIgnoreCase("")) out.write("disabled"); %> onClick="javascript:window.open('<%=HTMLPath%>');" value="HTML">
  </td>
</tr>
<%
          }
          result.close();
        }
        catch (SQLException sqlex) {
          System.out.println(sqlex.toString());
        }
      }
      else {
        out.println("OpenDatabase Error");
      }
    }
    finally {
      DbaObj.CloseConnection();
    }
%>
</table>
</body>
</html>
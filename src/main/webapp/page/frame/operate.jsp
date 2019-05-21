<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <body>
  <table bgcolor="CAEFFF" height = "80px" width="100%" border="2" bordercolor="99BDCC">
   <tr height = "20px">
    <td  width="160px" style="border-style:none"><font color="red" size="2"><b>操作手册（点击下载）</b></font></td>
   </tr>
   <tr height = "60px"></tr>
  </table>
  <table border="1" align="center" cellpadding="0" cellspacing="0" height = "300px" width="300px">
   <tr height = "100px">
    <td align="center">
      <a href="#" onclick="javascript:window.location.href = '${pageContext.request.contextPath}/op_document/电子监察操作手册.doc';">电子监察</a>
    </td>
   </tr>
   <tr height = "100px">
    <td align="center">
      <a href="#" onclick="javascript:window.location.href = '${pageContext.request.contextPath}/op_document/法制监督操作手册.doc';">法制监督</a>
    </td>
   </tr>
   <tr height = "100px">
    <td align="center">
      <a href="#" onclick="javascript:window.location.href = '${pageContext.request.contextPath}/op_document/权力运行操作手册.docx';">权力运行</a>   
    </td>
   </tr>
  </table>
 </body>
 
 <script type="text/javascript">
  function open(){
	  var html='${pageContext.request.contextPath}/op_document/cg.txt';
	 window.location.href = html;
	 }
 </script>
</html>
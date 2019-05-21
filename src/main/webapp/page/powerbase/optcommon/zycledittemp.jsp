<%@ page contentType="text/html;charset=UTF-8"%>
<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.centit.powerbase.po.*" %>
<html>

<head>
	<title>自由裁量编缉</title>
	
  
</head>
<body>
	<s:form action="supPower!editzycl.do" method="post" namespace="/powerbase"
			id="suppowerForm1">
		<input type="text" id="itemId" name="itemId">
		<input type="text" id="version" name="version">
		<input type="text" id="dis_detail" name="dis_detail">
		<input type="submit">
<script type="text/javascript" language="javascript">

var item_id = window.parent.document.getElementById("itemId");
var version = window.parent.document.getElementById("version");
var dis_detail = window.parent.document.getElementById("dis_detail");
if (item_id.value)
	document.getElementById("itemId").value = item_id.value;
else 
	document.getElementById("itemId").value = window.opener.document.getElementById("itemId").value;
if (version.value)
	document.getElementById("version").value = version.value;
else
	document.getElementById("version").value = window.opener.document.getElementById("version").value;
if (dis_detail.value)
	document.getElementById("dis_detail").value = dis_detail.value;
else
	document.getElementById("dis_detail").value=window.opener.document.getElementById("dis_detail").value;
 window.onload=function()
	{
		openflow();
	};
	function openflow(){
		var form=document.getElementById("suppowerForm1");
	     form.action="${pageContext.request.contextPath}/powerbase/supPower!editzycl.do";   
	     form.submit();
	}

</script>
</s:form>
</body>

</html>

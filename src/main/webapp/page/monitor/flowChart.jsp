<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<%@page import="com.centit.powerbase.po.Suppower"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>内部流程与办件流程对比图</title>
<style>
.FixedTitleRow {
	position: relative;
	top: expression(this . offsetParent . scrollTop);
	z-index: 10;
	background-color: #2D80D2;
	color: #fff;
	font-size: 12pt;
	text-align: center;
	font-weight: bold;
}
</style>
<script type="text/javascript" language="javascript">
function switchsysbar(){
if(switchpoint.innerHTML=="undefined") switchpoint.innerHTML='4';
	if(switchpoint.innerHTML=='4'){
		switchpoint.innerHTML='3';
		document.all("frmtitle").style.display="none";
		document.all("switleft").style.display="none";
}
else{
	switchpoint.innerHTML='4';
	document.all("frmtitle").style.display="";
	document.all("switleft").style.display="";
	document.all("switright").style.display="";
 }
}
function switchsysbarLeft(){
if(switchpointLeft.innerHTML=="undefined") switchpointLeft.innerHTML='3';
	if(switchpointLeft.innerHTML=='3'){
		switchpointLeft.innerHTML='4';
		document.all("frmLeft").style.display="none";
		document.all("switright").style.display="none";
}
else{
	switchpointLeft.innerHTML='3';
	document.all("frmLeft").style.display="";
	document.all("switleft").style.display="";
	document.all("switright").style.display="";
 }
}
</script>

<%
	String item_id = request.getParameter("item_id");
	String internal_no = request.getParameter("internal_no");
	String org_id = request.getParameter("org_id");
%>
		<link rel="stylesheet" type="text/css"
			href="<%=session.getAttribute("css")%>/css/index.css">
		<style type=text/css>
.navpoint {
	color: 5e95c3;
	cursor: hand;
	font-family: webdings;
	font-size: 9pt
}
</style>
	</head>
	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">

			<tr>
				<!-- 左边 -->
				<td valign="top" bgcolor="#ffffff">
					<table border=0 cellpadding=0 cellspacing=0 height="100%"
						width="100%">
						<tr>
							<td height="100%" valign="top" id="frmLeft" name="frmLeft">
								<table border=0 cellpadding=0 cellspacing=0 height="100%"
									width="100%">
									<tr class="FixedTitleRow">
										<TD >案件流程图</TD>
									 </tr>
									<tr>
										<td height="100%" valign="top" name="frmtitle" width="100%">
											<iframe frameborder=0 id="frmAppLeft" name="frmAppLeft"
												scrolling='no'
												src="<%=request.getContextPath()%>/monitor/${systemType}!flowChart_L.do?systemType=${systemType}&item_id=${item_id}&internal_no=<%=internal_no%>&org_id=<%=org_id%>"
												style="width: 100%; height: 100%; visibility: inherit; z-index: 1">
											</iframe>
										</td>
									</tr>
								</table>
							</td>
							<!--  中间 -->
							<td id="switleft" name="switleft" width="10" bgcolor="#eeeeee"  onclick="switchsysbarLeft();">
								<font face=webdings size="1"> <span class="navpoint"
									id=switchpointLeft title="关闭/打开左栏">3</span> </font>
							</td>
							<td id="switright" name="switright" width="10" bgcolor="#eeeeee" onclick="switchsysbar();">
								<font face=webdings size="1"> <span class="navpoint"
									id=switchpoint title="关闭/打开右栏">4</span> </font>
							</td>
							<!--  右边-->
							<td id="frmtitle"  height="100%" valign="top" 
								name="frmtitle">
								<table border=0 cellpadding=0 cellspacing=0 height="100%"
									width="100%">
									<tr class="FixedTitleRow">
										<TD >内部流程图</TD>
									 </tr>
									<tr>
										<td style="width: 100%; height: 100%">
											<iframe scrolling="auto" frameborder=0 id=boardtitle name=right
												style="height: 100%; visibility: inherit; width: 100%; z-index: 2;">
											</iframe>
											
	                    					<input type="hidden" id="xmlDate" value="${sup.inFlowXml}" />
										</td>
									</tr>
								</table>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript" language="javascript">
	window.onload=function()
	{
		openflow();
	};
	function openflow(){
		var url="${pageContext.request.contextPath}/page/powerbase/innerflow/svg/readXml.html";
		window.open(url, "right");
	}
	</script>
</html>
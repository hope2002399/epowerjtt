<%@page import="com.centit.powerruntime.po.LicensesSub"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		
		<title>
		电子证照（批文）报送情况统计
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css">
		<!-- 统计相关js -->
		<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>
	</head>
<style>
</style>
	<body style="width: 99%;" marginwidth="0" marginheight="0">
	<div class="container" style="padding-top: 5px;">

	<div class="search stat">
		<style>
form {
	float: left
}

form span.addTd {
	margin: 5px 0px 5px 5px;
	float: left;
}
form div.addbutton {
	margin: 10px 0px 5px 5px;
	float: right;
}
form div.addTd {
	margin: 5px 0px 5px 5px;
	float: left;
}

form span.addTd lable {
	width: 80px;
	float: left
}

.addTd {
	width: 300px;
	padding: 10px
}

</style>
		<div class="crumbs">电子证照（批文）报送情况统计</div>
		<form action="./powerruntime/vLicensesSub!getVLicensesSub.do" method="get"  id="dataForm" >
						<%
							String startTime = (String)request.getAttribute("startTime");
							String endTime   = (String)request.getAttribute("endTime");
						%>
						<span class="addTd">
							 <label>开始时间：</label>
							 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionBeginTime" 
							 value="<%=startTime%>" name="s_decisionBeginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</span>
						<span class="addTd">
							 <label>结束时间：</label>
							 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionEndTime" 
							 value="<%=endTime%>" name="s_decisionEndTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</span>
						<div class="addbutton">
							<input type="submit"  class="btn" value="查询">
							<input type="button" class="btn" value="导出" onclick="return exportExcel();">
						</div>
			
		</form>
	</div>
<div>
	<div>
		<table style="width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;" id="statTable" cellpadding="0" border="0" cellspacing="0" class="treetable">
		<!-- <table style="border:1px;width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;" cellpadding="0" border="1" cellspacing="1" > -->
				<caption style="font-size: 16px;padding: 5px;color: #2D80D2;font-weight: bold;">电子证照（批文）报送情况统计</caption>
				<thead>
					<tr>  
				        <th scope="col">业务局</th>  
				        <th scope="col">模板名称</th>  
				        <th scope="col">数量</th>
		 		   </tr> 
				</thead>
				<tbody id="dataStatisTbody" align="center">
		  <%
	     List<LicensesSub> list = (List<LicensesSub>) request.getAttribute("licensesSubs");
		  
		  for (int i = 0; i < list.size(); i++) {
			  LicensesSub info = list.get(i);
			  int jh = info.getListOrgname().size();
        %>   
				<tr>
					<%
						if(i%2 != 1){
					%>
					<td style="background: #EAEAEA" rowspan="<%=jh %>"><%=info.getOrgname() %></td>
					<%}else{ %>
					<td style="background: white" rowspan="<%=jh %>"><%=info.getOrgname() %></td>
					<%}
					for (int j = 0; j < info.getListOrgname().size(); j++) {
						
					%>
					<td ><%=info.getListOrgname().get(j).get("zzName") %></td>
					<td ><%=info.getListOrgname().get(j).get("sl") %></td>
				</tr>
				<%}}%>
				</tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>
<script type="text/javascript">
function showError(xzjg){
	var iWidth=600; //弹出窗口的宽度;
	var iHeight=400; //弹出窗口的高度;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open("","newWin","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no");
	$("#decisionBeginTimeerror").val("2010-01-01");
	$("#decisionEndTimeerror").val("2017-07-31");
	$("#xzjg").val("");
	$("#dataError").submit();
}
function exportExcel(){
	var decisionBeginTime = document.getElementById("decisionBeginTime").value;
	var decisionEndTime = document.getElementById("decisionEndTime").value;
	window.location.href = '${pageContext.request.contextPath}/powerruntime/vLicensesSub!export.do?decisionBeginTime='+decisionBeginTime+'&decisionEndTime='+decisionEndTime;
}
function openXK(){
	var iWidth=600; //弹出窗口的宽度;
	var iHeight=400; //弹出窗口的高度;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	 window.open('${ctx}/jtt2xyb/permit_TakeIn.jsp',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no"); 
}
function openCF(){
	var iWidth=600; //弹出窗口的宽度;
	var iHeight=400; //弹出窗口的高度;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	 window.open('${ctx}/jtt2xyb/punish_TakeIn.jsp',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no"); 
}
</script>
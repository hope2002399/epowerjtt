<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		
		<title>
		双公示报表统计
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
		<div class="crumbs">双公示统计</div>
		<form action="。/sys/dataStat.do" method="get"  id="dataForm" style="margin-top: 0px; margin-bottom: 5px;">
						<%
							String startTime = (String)request.getAttribute("startTime");
							String endTime   = (String)request.getAttribute("endTime");
						%>
						<span class="addTd">
							 <label>开始时间：</label>
							 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionBeginTime" 
							 value="<%=startTime%>" name="decisionBeginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</span>
						<span class="addTd">
							 <label>结束时间：</label>
							 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionEndTime" 
							 value="<%=endTime%>" name="decisionEndTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</span>
						<div class="addbutton">
							<input type="submit"  class="btn" value="查询">
							<input type="button" class="btn" value="导出" onclick="return exportExcel();">
							<!-- <input type="button" class="btn" value="导入许可文件" onclick="return openXK();">
							<input type="button" class="btn" value="导入处罚文件" onclick="return openCF();"> -->
						</div>
			
		</form>
		<form id="dataError" action="./sys/dataStat!showError.do" method="post" target="newWin">
			<input type="hidden" name="decisionBeginTime" id="decisionBeginTimeerror" />
			<input type="hidden" name="decisionEndTime" id="decisionEndTimeerror" />
			<input type="hidden" name="xzjg" id="xzjg" />
			<input type="hidden" name="type" id="type" />
		</form>
	</div>
<div>
	<div>
		<table style="width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;" id="statTable" cellpadding="0" border="0" cellspacing="0" class="treetable">
			<caption>双公示统计</caption>
				<thead>
					<tr>
						<th>行政机关</th>
						<th>成功数据量（许可）</th>
						<th>错误数据量（许可）</th>
						<th>成功数据量（处罚）</th>
						<th>错误数据量（处罚）</th>
						<th>合计</th>
					</tr>
				</thead>
				<tbody id="dataStatisTbody" align="center">
		  <%
		  List<Object[]> list = (List<Object[]>) request.getAttribute("list");
		  if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					Object[] info = list.get(i);
					if(i%2!=0){
						
		   %>   
				<tr style="display: table-row;background: rgb(223, 228, 232);">
					<td style="text-align: center;"><%=info[0] %></td>
					<td style="text-align: center;"><%=info[1] %></td>
					<td style="text-align: center;">
					<% if(info[2] == null || Integer.parseInt(info[2].toString()) == 0 ){ %>
						0
					<%}else{ %>
						<a href="#" onclick="showError('1','<%=info[5] %>')"><%=info[2] %></a>
					<%} %>
					</td> 
					<td style="text-align: center;"><%=info[3] %></td> 
					<td style="text-align: center;">
					<% if(info[4] == null || Integer.parseInt(info[4].toString()) == 0 ){ %>
						0
					<%}else{ %>
						<a href="#" onclick="showError('2','<%=info[5] %>')"><%=info[4] %></a>
					<%} %>
					</td> 
					<td style="text-align: center;"><%=info[6] %></td> 
				</tr>
				<%}else{%>
					<tr style="display: table-row; background: rgb(255, 255, 255);" >
					<td style="text-align: center;"><%=info[0] %></td>
					<td style="text-align: center;"><%=info[1] %></td>
					<td style="text-align: center;">
					<% if(info[2] == null || Integer.parseInt(info[2].toString()) == 0 ){ %>
						0
					<%}else{ %>
						<a href="#" onclick="showError('1','<%=info[5] %>')"><%=info[2] %></a>
					<%} %>
					</td> 
					<td style="text-align: center;"><%=info[3] %></td> 
					<td style="text-align: center;">
					<% if(info[4] == null || Integer.parseInt(info[4].toString()) == 0 ){ %>
						0
					<%}else{ %>
						<a href="#" onclick="showError('2','<%=info[5] %>')"><%=info[4] %></a>
					<%} %>
					</td> 
					<td style="text-align: center;"><%=info[6] %></td> 
				</tr>
				<%}%>
				<%}}%>
				</tbody>
			
		</table>
	</div>
</div>
</div>
</body>
</html>
<script type="text/javascript">
	function showError(type,xzjg){
		var iWidth=600; //弹出窗口的宽度;
		var iHeight=400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open("","newWin","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no");
		$("#decisionBeginTimeerror").val($("#decisionBeginTime").val());
		$("#decisionEndTimeerror").val($("#decisionEndTime").val());
		$("#xzjg").val(xzjg);
		$("#type").val(type);
		$("#dataError").submit();
	}
	function exportExcel(){
		var decisionBeginTime = $("#decisionBeginTime").val();
		var decisionEndTime = $("#decisionEndTime").val();
		window.location.href = '${pageContext.request.contextPath}/sys/export.do?decisionBeginTime='+decisionBeginTime+'&decisionEndTime='+decisionEndTime;
	}
	function openXK(){
		var iWidth=600; //弹出窗口的宽度;
		var iHeight=400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		 window.open('${pageContext.request.contextPath}/page/jtt2xyb/permit_TakeIn.jsp',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no"); 
	}
	function openCF(){
		var iWidth=600; //弹出窗口的宽度;
		var iHeight=400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		 window.open('${pageContext.request.contextPath}/page/jtt2xyb/punish_TakeIn.jsp',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no"); 
	}
</script>
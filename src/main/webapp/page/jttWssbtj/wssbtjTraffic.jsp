<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		
		<title>
		交通部数据报送情况统计
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
		<div class="crumbs">交通部数据报送情况统计</div>
		<form action="。/sys/jttWssbtjsx!traffic.do" method="get"  id="dataForm" >
						<%
							String yeartime = (String)request.getAttribute("time");
						%>
						<span class="addTd">
							 <label>统计年度：</label>
							 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionBeginTime" 
							 value="<%=yeartime%>" name="decisionBeginTime" onclick="WdatePicker({dateFmt:'yyyy'})" placeholder="选择日期">
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
				<caption style="font-size: 16px;padding: 5px;color: #2D80D2;font-weight: bold;"><%=yeartime%>交通部数据报送情况统计</caption>
				<thead>
					<tr>  
				        <th scope="col" rowspan="2">月份</th>  
				        <th scope="col" colspan="2">公路</th>
				        <th scope="col" colspan="2">运管</th>  
				        <th scope="col" colspan="2">港口</th>  
				        <th scope="col" colspan="2">海事</th>
				        <th scope="col" colspan="2">航道</th>
				        <th scope="col" colspan="2">质监</th>
				        <th scope="col" colspan="2">建设</th>
				        <th scope="col" colspan="2">高管</th>
				        <!-- <th scope="col" colspan="2">合计</th> -->
		 		   </tr> 
					<tr>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>   
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				        <th scope="col">接收</th>  
				        <th scope="col">报送</th>  
				       <!--  <th scope="col">接收</th>  
				        <th scope="col">报送</th>    -->
		 		   </tr> 
				</thead>
				<tbody id="dataStatisTbody" align="center">
		  <%
	     List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("map");
		  for (int i = 0; i < list.size(); i++) {
				Map<String,Object> info = list.get(i);
				if(i%2!=0){
        %>   
				<tr>
					<td><%=info.get("month") %></td>
					<td><%=info.get("gl")!=null?info.get("gl"):0 %></td>
					<td><%=info.get("glbs")!=null?info.get("glbs"):0 %></td>
					<td><%=info.get("yg")!=null?info.get("yg"):0 %></td>
					<td><%=info.get("ygbs")!=null?info.get("ygbs"):0 %></td>
					<td><%=info.get("gk")!=null?info.get("gk"):0 %></td>
					<td><%=info.get("gkbs")!=null?info.get("gkbs"):0 %></td>
					<td><%=info.get("hs")!=null?info.get("hs"):0 %></td>
					<td><%=info.get("hsbs")!=null?info.get("hsbs"):0 %></td>
					<td><%=info.get("hd")!=null?info.get("hd"):0 %></td>
					<td><%=info.get("hdbs")!=null?info.get("hdbs"):0 %></td>
					<td><%=info.get("zj")!=null?info.get("zj"):0 %></td>
					<td><%=info.get("zjbs")!=null?info.get("zjbs"):0 %></td>
					<td><%=info.get("zb")!=null?info.get("zb"):0 %></td>
					<td><%=info.get("zbbs")!=null?info.get("zbbs"):0 %></td>
					<td><%=info.get("gg")!=null?info.get("gg"):0 %></td>
					<td><%=info.get("ggbs")!=null?info.get("ggbs"):0 %></td>
					<%-- <td><%=Integer.parseInt(info.get("gl").toString())+Integer.parseInt(info.get("yg").toString())
						+Integer.parseInt(info.get("gk").toString())+Integer.parseInt(info.get("hs").toString())
						+Integer.parseInt(info.get("hd").toString())+Integer.parseInt(info.get("zj").toString())
						+Integer.parseInt(info.get("zb").toString())+Integer.parseInt(info.get("gg").toString())%></td>
					<td><%=Integer.parseInt(info.get("glbs").toString())+Integer.parseInt(info.get("ygbs").toString())
						+Integer.parseInt(info.get("gkbs").toString())+Integer.parseInt(info.get("hsbs").toString())
						+Integer.parseInt(info.get("hdbs").toString())+Integer.parseInt(info.get("zjbs").toString())
						+Integer.parseInt(info.get("zbbs").toString())+Integer.parseInt(info.get("ggbs").toString())%></td> --%>
				</tr>
				<%}else{%>
				<tr class="altrow">
					<td><%=info.get("month") %></td>
					<td><%=info.get("gl")!=null?info.get("gl"):0 %></td>
					<td><%=info.get("glbs")!=null?info.get("glbs"):0 %></td>
					<td><%=info.get("yg")!=null?info.get("yg"):0 %></td>
					<td><%=info.get("ygbs")!=null?info.get("ygbs"):0 %></td>
					<td><%=info.get("gk")!=null?info.get("gk"):0 %></td>
					<td><%=info.get("gkbs")!=null?info.get("gkbs"):0 %></td>
					<td><%=info.get("hs")!=null?info.get("hs"):0 %></td>
					<td><%=info.get("hsbs")!=null?info.get("hsbs"):0 %></td>
					<td><%=info.get("hd")!=null?info.get("hd"):0 %></td>
					<td><%=info.get("hdbs")!=null?info.get("hdbs"):0 %></td>
					<td><%=info.get("zj")!=null?info.get("zj"):0 %></td>
					<td><%=info.get("zjbs")!=null?info.get("zjbs"):0 %></td>
					<td><%=info.get("zb")!=null?info.get("zb"):0 %></td>
					<td><%=info.get("zbbs")!=null?info.get("zbbs"):0 %></td>
					<td><%=info.get("gg")!=null?info.get("gg"):0 %></td>
					<td><%=info.get("ggbs")!=null?info.get("ggbs"):0 %></td>
					<%-- <td><%=Integer.parseInt(info.get("gl").toString())+Integer.parseInt(info.get("yg").toString())
						+Integer.parseInt(info.get("gk").toString())+Integer.parseInt(info.get("hs").toString())
						+Integer.parseInt(info.get("hd").toString())+Integer.parseInt(info.get("zj").toString())
						+Integer.parseInt(info.get("zb").toString())+Integer.parseInt(info.get("gg").toString())%></td>
					<td><%=Integer.parseInt(info.get("glbs").toString())+Integer.parseInt(info.get("ygbs").toString())
						+Integer.parseInt(info.get("gkbs").toString())+Integer.parseInt(info.get("hsbs").toString())
						+Integer.parseInt(info.get("hdbs").toString())+Integer.parseInt(info.get("zjbs").toString())
						+Integer.parseInt(info.get("zbbs").toString())+Integer.parseInt(info.get("ggbs").toString())%></td> --%>
				</tr>
				<%}%>
				<%}%>
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
	window.location.href = '${pageContext.request.contextPath}/sys/exportwssbtjsxtraffic.do?decisionBeginTime='+decisionBeginTime;
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
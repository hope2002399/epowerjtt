<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		
		<title>
		外网申报统计（省）
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
		<div class="crumbs">外网申报统计（省）</div>
		<form action="。/sys/jttWssbtj.do" method="get"  id="dataForm" >
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
						</div>
			
		</form>
	</div>
<div>
	<div>
		<table style="width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;" id="statTable" cellpadding="0" border="0" cellspacing="0" class="treetable">
				<caption style="font-size: 16px;padding: 5px;color: #2D80D2;font-weight: bold;">外网申报统计（省）</caption>
				<thead>
					<tr>  
				        <th scope="col" rowspan="2">部门</th>  
				        <th scope="col" rowspan="2">申报数量</th>
				        <th scope="col" colspan="2">已反馈</th>  
				        <th scope="col" colspan="3">未反馈</th>  
				        <th scope="col" colspan="3">反馈状态</th>
		 		   </tr> 
					<tr>  
				        <th scope="col">5天内反馈</th>  
				        <th scope="col">5天后反馈</th>  
				        <th scope="col">未超过3天</th>
				        <th scope="col">超过3天</th>  
				        <th scope="col">超过5天</th>  
				        <th scope="col">受理</th>  
				        <th scope="col">补正</th>  
				        <th scope="col">不予受理</th>   
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
					<td ><%=info.get("unitname") %></td>
					<td >
					<%if(!info.get("SBSL").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=sbsl&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("SBSL") %></a>
					<%}else{out.write(info.get("SBSL").toString());}%>
					</td>
					<td >
					<%if(!info.get("CFZN").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=cfzn&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("CFZN") %></a>
					<%}else{out.write(info.get("CFZN").toString());}%>
					</td>
					<td >
					<%if(!info.get("CFZW").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=cfzw&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("CFZW") %></a>
					<%}else{out.write(info.get("CFZW").toString());}%>
					</td> 
					<td >
					<%if(!info.get("TZN").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=tzn&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("TZN") %></a>
					<%}else{out.write(info.get("TZN").toString());}%>
					</td>
					<td >
					<%if(!info.get("TFZJ").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=tfzj&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("TFZJ") %></a>
					<%}else{out.write(info.get("TFZJ").toString());}%>
					</td>
					<td >
					<%if(!info.get("WCFZN").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=wcfzn&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("WCFZN") %></a>
					<%}else{out.write(info.get("WCFZN").toString());}%>
					</td>
					<td >
					<%if(!info.get("SL").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=sl&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("SL") %></a>
					<%}else{out.write(info.get("SL").toString());}%>
					</td> 
					<td >
					<%if(!info.get("BSL").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=bsl&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("BSL") %></a>
					<%}else{out.write(info.get("BSL").toString());}%>
					</td>
					<td >
					<%if(!info.get("BZ").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=bz&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("BZ") %></a>
					<%}else{out.write(info.get("BZ").toString());}%>
					</td>
					<%-- <td >
						<% if(info.get("ERRORNUM") == null || Integer.parseInt(info.get("ERRORNUM").toString()) == 0 ){ %>
							0
						<%}else{ %>
							<a href="#" onclick="showError('<%=info.get("XZJG") %>')"><%=info.get("ERRORNUM") %></a>
						<%} %>
						
					</td>  --%>
				</tr>
				<%}else{%>
					<tr class="altrow">
					<td ><%=info.get("unitname") %></td>
					<td >
					<%if(!info.get("SBSL").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=sbsl&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("SBSL") %></a>
					<%}else{out.write(info.get("SBSL").toString());}%>
					</td>
					<td >
					<%if(!info.get("CFZN").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=cfzn&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("CFZN") %></a>
					<%}else{out.write(info.get("CFZN").toString());}%>
					</td>
					<td >
					<%if(!info.get("CFZW").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=cfzw&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("CFZW") %></a>
					<%}else{out.write(info.get("CFZW").toString());}%>
					</td> 
					<td >
					<%if(!info.get("TZN").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=tzn&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("TZN") %></a>
					<%}else{out.write(info.get("TZN").toString());}%>
					</td>
					<td >
					<%if(!info.get("TFZJ").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=tfzj&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("TFZJ") %></a>
					<%}else{out.write(info.get("TFZJ").toString());}%>
					</td>
					<td >
					<%if(!info.get("WCFZN").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=wcfzn&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("WCFZN") %></a>
					<%}else{out.write(info.get("WCFZN").toString());}%>
					</td>
					<td >
					<%if(!info.get("SL").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=sl&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("SL") %></a>
					<%}else{out.write(info.get("SL").toString());}%>
					</td> 
					<td >
					<%if(!info.get("BSL").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=bsl&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("BSL") %></a>
					<%}else{out.write(info.get("BSL").toString());}%>
					</td>
					<td >
					<%if(!info.get("BZ").toString().equals("0")){ %>
					<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?type=bz&startTime=<%=startTime%>&endTime=<%=endTime%>&orgCode=<%=info.get("orgcode") %>"><%=info.get("BZ") %></a>
					<%}else{out.write(info.get("BZ").toString());}%>
					</td>
					<%-- <td >
						<% if(info.get("ERRORNUM") == null || Integer.parseInt(info.get("ERRORNUM").toString()) == 0 ){ %>
							0
						<%}else{ %>
							<a href="#" onclick="showError('<%=info.get("XZJG") %>')"><%=info.get("ERRORNUM") %></a>
						<%} %>
						
					</td>  --%>
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
	var decisionEndTime = document.getElementById("decisionEndTime").value;
	window.location.href = '${pageContext.request.contextPath}/sys/exportwssb.do?decisionBeginTime='+decisionBeginTime+'&decisionEndTime='+decisionEndTime;
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
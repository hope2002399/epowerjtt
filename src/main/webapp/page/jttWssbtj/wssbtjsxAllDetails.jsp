<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		
		<title>
		外网申报办件详情统计
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
<div>
	<div>
		<table style="width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;" id="statTable" cellpadding="0" border="0" cellspacing="0" class="treetable">
						<caption>外网申报办件详情统计</caption>
						<thead align="center">
							<tr>  
						        <th scope="col" rowspan="2">办件编号</th>  
						        <th scope="col" rowspan="2">办件名称</th>
						        <th scope="col" rowspan="2">权力事项</th>  
						        <th scope="col" rowspan="2">申报单位</th>  
						        <th scope="col" rowspan="2">申报时间</th>
				 		   </tr> 
						</thead>
						<tbody align="center" class="tableBody" id="tabledy">
							 <%
							 List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("map");
									for (int i = 0; i < list.size(); i++) {
										Map<String,Object> info = list.get(i);
										if(i%2!=0){
											
							   %>   
									<tr>
										<td width="213px;"><%=info.get("transaffairno") %></td>
										<td width="213px;"><%=info.get("powername") %></td>
										<td width="213px;"><%=info.get("outitemname") %></td>
										<td width="67px;"><%=info.get("proposer_name") %></td> 
										<td width="145px;"><%=info.get("accept_date") %></td>
										
									</tr>
									<%}else{%>
										<tr class="altrow">
											<td width="213px;"><%=info.get("transaffairno") %></td>
											<td width="213px;"><%=info.get("powername") %></td>
											<td width="213px;"><%=info.get("outitemname") %></td>
											<td width="67px;"><%=info.get("proposer_name") %></td> 
											<td width="145px;"><%=info.get("accept_date") %></td>
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

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.centit.jtt2xyb.bo.WssbxzcfBo" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
		行政处罚查询
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">行政处罚查询</div>
			<s:form action="jttWssbxzcf" namespace="/sys">
						<%
							String startDate = (String)request.getAttribute("startDate");
							String endDate   = (String)request.getAttribute("endDate");
						%>
				<table cellpadding="0" cellspacing="0" align="center">	
					<tr>
						<td class="addTd">处罚决定开始时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="cfjdrqBeginTime" 
							 value="<%=startDate%>" name="s_cfjdrqBeginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						 </td>
						 <td class="addTd">处罚决定结束时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="cfjdrqEndTime" 
							 value="<%=endDate%>" name="s_cfjdrqEndTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</td>
					</tr>
					<tr>
						<td class="addTd">市场类型：</td>
						<td>
							<select name="s_cfsclx" id="cfsclx" style="width:160px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('SCLX')}">
									<option value="${row.key}" <c:if test="${param.s_cfsclx eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td> 
						<td class="addTd">处罚相对人类型：</td>
						<td>
							<select name="s_cfxdrlx" id="cfxdrlx" style="width:160px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('XKXDRLX')}">
									<option value="${row.key}" <c:if test="${param.s_cfxdrlx eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td> 
					</tr>
					<tr>
						
						<td align="center" colspan="4">
							<s:submit method=""  key="opt.btn.query" cssClass="btn"/>&nbsp;&nbsp;&nbsp;
							<input type="button" class="btn" value="导出" onclick="return exportExcel();">
						</td>
						</tr>
				</table>
			</s:form>
		</div>
		<div>
		<ec:table action="sys/jttWssbxzcf.do" items="map" var="xzcf"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="cfxdr" title="行政相对人名称" style="text-align:center" sortable="false"/>
				<ec:column property="cfxdrzjlx" title="证件类型" style="text-align:center" sortable="false"/>
				<ec:column property="cfxdrzjhm" title="证件号码" style="text-align:center" sortable="false"/>
				<ec:column property="cfcflb1" title="处罚类别" style="text-align:center" sortable="false"/>
				<ec:column property="cfje" title="处罚金额（万元）" style="text-align:center" sortable="false"/>
				<ec:column property="cfjdrq" title="处罚决定日期" style="text-align:center" sortable="false" >
					<fmt:formatDate value="${xzcf.cfjdrq}" type="both" pattern="yyyy-MM-dd "/>
				</ec:column>
			</ec:row>
		</ec:table>
		<%-- <table border="1" cellspacing="0" cellpadding="0"> 
				<thead>
					<tr>  
				        <th scope="col">行政相对人名称</th>
				        <th scope="col">证件类型</th>  
				        <th scope="col">证件号码</th> 
				        <th scope="col">处罚类别</th>
				        <th scope="col">处罚金额（万元） </th>
				        <th scope="col">处罚决定日期</th> 
		 		   </tr> 
				</thead>
				<tbody id="dataStatisTbody" align="center">
					  <% List<WssbxzcfBo> list = (List<WssbxzcfBo>) request.getAttribute("map");
					  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
						  for(Object obj : list) {
							  Object[] objs = (Object[]) obj;
							 
			        %>   
			        <tr>
					<td ><%=(String) objs[0] %></td>
					<td ><%=((String) objs[9]==null? "":(String) objs[9]) %></td>
					<td ><%=((String) objs[10]==null? "":(String) objs[10]) %></td>
					<td ><%=(String) objs[15] %></td>
					<td ><%=(String) String.valueOf(objs[17]) %></td>
					<td ><%=(String) sdf.format(objs[20]) %></td>
			        </tr>
			        <%}%>
			    </tbody>
		</table> --%>
		</div>
	</body>
	<script type="text/javascript">
	function exportExcel(){
		if($("#cfxdrlx").val()!=""&&$("#cfsclx").val()!=""){
			window.location.href = '${pageContext.request.contextPath}/sys/exportBxzcf.do?cfjdrqBeginTime='+$("#cfjdrqBeginTime").val()+"&cfjdrqEndTime="+$("#cfjdrqEndTime").val()+"&cfsclx="+$("#cfsclx").val()+"&cfxdrlx="+$("#cfxdrlx").val();
		}else{
			alert("导出必须选择市场类型和处罚相对人类型事项");
		}	
	}
	</script>
</html>

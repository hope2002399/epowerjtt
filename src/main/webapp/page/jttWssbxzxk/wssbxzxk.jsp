<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.centit.jtt2xyb.bo.WssbxzxkBo" %>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
		行政许可查询
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">行政许可查询</div>
			<s:form action="jttWssbxzxk" namespace="/sys">
						<%
							String startDate = (String)request.getAttribute("startDate");
							String endDate   = (String)request.getAttribute("endDate");
						%>
				<table cellpadding="0" cellspacing="0" align="center">	
					<tr>
						<td class="addTd">许可决定开始时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="xkjdrqBeginTime" 
							 value="<%=startDate%>" name="s_xkjdrqBeginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						 </td>
						 <td class="addTd">许可决定结束时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="xkjdrqEndTime" 
							 value="<%=endDate%>" name="s_xkjdrqEndTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</td>
					</tr>
					<tr>
						<td class="addTd">市场类型：</td>
						<td>
							<select name="s_xksclx" id="xksclx" style="width:160px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('SCLX')}">
									<option value="${row.key}" <c:if test="${param.s_xksclx eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td> 
						<td class="addTd">许可相对人类型：</td>
						<td>
							<select name="s_xkxdrlx" id="xkxdrlx" style="width:160px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('XKXDRLX')}">
									<option value="${row.key}" <c:if test="${param.s_xkxdrlx eq row.key}"> selected = "selected" </c:if>>
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
		<ec:table action="sys/jttWssbxzxk.do" items="map" var="xzxk"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="xkxdr" title="行政相对人名称" style="text-align:center" sortable="false"/>
				<ec:column property="xkxdrshxym" title="统一社会信用代码" style="text-align:center" sortable="false"/>
				<ec:column property="xkfr" title="法定代表人" style="text-align:center" sortable="false"/>
				<ec:column property="xksplb" title="许可类别" style="text-align:center" sortable="false"/>
				<ec:column property="xkxzjg" title="许可机关" style="text-align:center" sortable="false"/>
				<ec:column property="xkjdrq" title="许可决定日期" style="text-align:center" sortable="false" >
					<fmt:formatDate value="${xzxk.xkjdrq}" type="both" pattern="yyyy-MM-dd "/>
				</ec:column>
			</ec:row>
		</ec:table>
		
		
		
		
		
		<%-- <table border="1" cellspacing="0" cellpadding="0"> 
				<thead>
					<tr>  
				        <th scope="col">行政相对人名称</th>
				        <th scope="col">统一社会信用代码</th>  
				        <th scope="col">法定代表人</th> 
				        <th scope="col">许可类别 </th>
				        <th scope="col">许可机关 </th>
				        <th scope="col">许可决定日期</th> 
		 		   </tr> 
				</thead>
				<tbody id="dataStatisTbody" align="center">
					  <% List<WssbxzxkBo> list = (List<WssbxzxkBo>) request.getAttribute("map");
					  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
						  for(Object obj : list) {
							  Object[] objs = (Object[]) obj;
							 
			        %>   
			        <tr>
					<td ><%=(String) objs[0] %></td>
					<td ><%=((String) objs[1]==null? "":(String) objs[1]) %></td>
					<td ><%=((String) objs[7]==null? "":(String) objs[7]) %></td>
					<td ><%=(String) objs[13] %></td>
					<td ><%=(String) objs[20] %></td>
					<td ><%=(String) sdf.format(objs[17]) %></td>
			        </tr>
			        <%}%>
			    </tbody>
		</table> --%>
		</div>
	</body>
	<script type="text/javascript">
	function exportExcel(){
		if($("#xkxdrlx").val()!=""&&$("#xksclx").val()!=""){
			window.location.href = '${pageContext.request.contextPath}/sys/exportBxzxk.do?xkjdrqBeginTime='+$("#xkjdrqBeginTime").val()+"&xkjdrqEndTime="+$("#xkjdrqEndTime").val()+"&xksclx="+$("#xksclx").val()+"&xkxdrlx="+$("#xkxdrlx").val();
		}else{
			alert("导出必须选择市场类型和许可相对人类型事项");
		}
		
	}
	</script>
</html>

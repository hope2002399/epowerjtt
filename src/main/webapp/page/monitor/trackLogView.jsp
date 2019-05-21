<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<sj:head locale="zh_CN" />
<title><s:text name="suppower.edit.title" /></title>
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
<fieldset style="padding: 10px;">
<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<b>跟踪日志信息</b>
		</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">业务类型</td>
				<td ><c:if test="${object.powertype==1}">办件跟踪日志</c:if><c:if test="${object.powertype==2}">案件跟踪日志</c:if></td>
				
				<td class="addTd" width="130">跟踪类型</td>
				<td >${cp:MAPVALUE("track_type",(object.tracktype))}</td>
				</tr>
				 <tr>
				 <td class="addTd" width="130">跟踪人</td>
				<td > ${cp:MAPVALUE("usercode",object.trackoperator)}</td> 
				<td class="addTd" width="130">跟踪时间</td>
				<td ><fmt:formatDate value='${object.tracktime}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
			
				</tr>
				<tr>
				<td class="addTd" width="130">跟踪原因</td>
				<td colspan="3">${object.trackreason}</td>
				</tr>
				<tr>  
				<td class="addTd" width="130">取消人</td>
				<td >${cp:MAPVALUE("usercode",object.untrackoperator)}</td>  
				<td class="addTd" width="130">取消时间</td>
				<td ><fmt:formatDate value='${object.untracktime}' pattern='yyyy-MM-dd hh:mm:ss' /></td> 
				</tr>
				<tr>
				<td class="addTd" width="130">取消原因</td>
				<td colspan="3">${object.untrackreason}</td>
				</tr>
			</table>
		</fieldset>
</body>
</html>

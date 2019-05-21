<html>
<head>
<title></title>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
</head>

<body>
	<fieldset style="padding:10px;position:relative;">
	<legend class="new_legend" style="width:auto;margin-bottom:10px;">指标测评查看</legend>
	<table width="200" border="0" cellpadding="1" cellspacing="1" class="viewTable">
		
		<%-- <tr>
			<td class="TDTITLE"><c:out value="pmIndexEvluation.evlId" /></td>
			<td align="left"><c:out value="${object.evlId}" /></td>
		</tr>
		  --%>
		<tr>
			<td class="TDTITLE">模板名称</td>
			<td align="left"><c:out value="${vEvluation.templetName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE">测评对象</td>
			<td align="left"><c:out value="${vEvluation.objectName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE">测评对象类型</td>
			<td align="left">${cp:MAPVALUE("PM_TEMPLETTYPE",vEvluation.objectType) }</td>
		</tr>
		
		<tr>
			<td class="TDTITLE">测评分</td>
			<td align="left"><c:out value="${vEvluation.evlScore}" /></td>
		</tr>
		
		<%-- <tr>
			<td class="TDTITLE">任务id</td>
			<td align="left"><c:out value="${pmIndexEvluation.taskId}" /></td>
		</tr> --%>
		
		<tr>
			<td class="TDTITLE">测评时间</td>
			<td align="left"><fmt:formatDate value="${vEvluation.evlTime}" pattern="yyyy-MM-dd"/> </td>
		</tr>
		
	</table>
	<input type="button" class="btn" style="float:none" value="返回" onclick="window.history.back();" />
</fieldset>
	

</body>
</html>

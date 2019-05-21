<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="outwaycjjc.view.title" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>	
<c:if test="${empty param.noback }">
<input type="button" value="返回" Class="btn" onclick="window.history.back()" /></c:if>

<input type="button" value="摘牌" Class="btn" onclick="" />
<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;"><s:text name="outwaycjjc.view.title"/></legend>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">办件编号</td>
					
					<td>
					<c:choose>
					<c:when test="${oldOutwayType eq 1}">
					<a href="/../jttsunzw/Apply.do?action=warn&doSearch=showInfo&item_id=${itemId}&internal_no=${internalNo}&usercode=0" target="_BLANK">
					<c:out value="${internalNo}"></c:out>
					</a>
					</c:when>
					<c:when test="${oldOutwayType eq 2}">
					<a href="/../jttsunzw/Punish.do?action=warn&doSearch=showInfo&org_id=${orgId}&internal_no=${internalNo}&usercode=0" target="_BLANK">
					<c:out value="${internalNo}"></c:out>
					</a>
					</c:when>
					</c:choose>
					</td>
				</tr>
				
				<tr>
					<td class="addTd"><s:text name="outway.monitorType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('outwayType', outwaytype) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd">异常编号</td>
					<td align="left"><c:out value="${outwayid}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd">主办部门</td>
					<td align="left"><c:out value="${cp:MAPVALUE('depno',orgId)}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outwaycjjc.warnpoint" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('warnpointno_cj',warnpointno)}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.intime" /></td>
					<td align="left"><fmt:formatDate value="${intime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
                <c:if test="${not empty outtime}">
				<tr>
					<td class="addTd"><s:text name="outway.outtime" /></td>
					<td align="left"><fmt:formatDate value="${outtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.outperson" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('usercode', outperson) }"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.outreason" /></td>
					<td align="left"><s:property value="%{outreason}" /></td>
				</tr>	
				</c:if>
</table>
</fieldset>
<s:form action="supervisecjjc!save" namespace="/supervise" style="margin-top:0;margin-bottom:5" id="supCJJCForm" method="post">
<fieldset style="padding:10px;">
	<input name="outwayid" type="hidden" value="${outwayid}"></input>
	<input name="orgid" type="hidden" value="${orgId}"></input>
	<input name="step" type="hidden" value="2"></input>
	<legend style="margin-bottom:10px;">督办发起信息</legend>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd">督办意见：</td>
			<td><s:textarea name="superviseOption" id="superviseOption"/></td>
		</tr>
	</table>
	
	<input type="button" value="发起督办" Class="btn" onclick="addSup();" />
</fieldset>
</s:form>
</body>

<script type="text/javascript">
function addSup(){
	var v=document.getElementById('superviseOption').value;
	if(""==v){
		alert("督办意见不能为空");
		document.getElementById('superviseOption').focus();
		return;
	}
	document.getElementById('supCJJCForm').submit();
}
</script>
</html>

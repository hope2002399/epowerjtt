<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="outwaycjjc.view.title" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>	
<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;"><s:text name="outwaycjjc.view.title"/></legend>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">办件编号</td>
					<td>
					<c:choose>
					<c:when test="${outwaycjjc.oldOutwayType eq 1}">
					<a href="/../jttsunzw/Apply.do?action=warn&doSearch=showInfo&item_id=${outwaycjjc.itemId}&internal_no=${outwaycjjc.internalNo}&usercode=0" target="_BLANK">
					<c:out value="${outwaycjjc.internalNo}"></c:out>
					</a>
					</c:when>
					<c:when test="${outwaycjjc.oldOutwayType eq 2}">
					<a href="/../jttsunzw/Punish.do?action=warn&doSearch=showInfo&org_id=${outwaycjjc.orgId}&internal_no=${outwaycjjc.internalNo}&usercode=0" target="_BLANK">
					<c:out value="${outwaycjjc.internalNo}"></c:out>
					</a>
					</c:when>
					</c:choose>
					</td>
				</tr>
			
				<tr>
					<td class="addTd"><s:text name="outway.monitorType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('outwayType', outwaycjjc.outwaytype) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd">异常编号</td>
					<td align="left"><c:out value="${outwaycjjc.outwayid}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd">主办部门</td>
					<td align="left"><c:out value="${cp:MAPVALUE('depno',outwaycjjc.orgId)}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outwaycjjc.warnpoint" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('warnpointno_cj',outwaycjjc.warnpointno)}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.monitorType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('outwayType', outwaycjjc.outwaytype) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.monitorLogo" /></td>
					<td align="left"><c:out value="${outwaycjjc.outwayinfo}" /></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.intime" /></td>
					<td align="left"><fmt:formatDate value="${outwaycjjc.intime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</table>
</fieldset>

<s:form action="supervisecjjc!save" namespace="/supervise" style="margin-top:0;margin-bottom:5" id="supCJJCForm" method="post">
<input type="hidden" name="step" id="step"></input>
<input type="hidden" name="supervisecode" id="supervisecode" value="${sup.supervisecode}"></input>
<fieldset style="padding:10px;">
	<legend style="margin-bottom:10px;">督办发起信息</legend>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd">督办意见：</td>
			<td colspan=3><c:out value="${sup.superviseoption}"></c:out>
				<div class="r" align="right">
					发起人：${sup.operatorname}&nbsp;&nbsp;&nbsp;
					发起日期：<fmt:formatDate value="${sup.superdate }" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;
				</div>
			</td>
		</tr>
	</table>
	
</fieldset>
<c:if test="${sup.dealstep gt '1'}">
	<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">督办反馈信息</legend>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd">反馈内容：</td>
				<c:choose>
					<c:when test="${param.step gt '2'}">
						<td colspan=3><c:out value="${sup.superviseback}"></c:out>
							<div class="r" align="right">
								回复人：${sup.backoperatorname}&nbsp;&nbsp;&nbsp;
								回复日期：<fmt:formatDate value="${sup.receiptdate }" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</td>
					</c:when>
					<c:otherwise>
						<td colspan=3><s:textarea name="superviseback" id="superviseback"/></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
		
		<c:if test="${param.step eq '2'}">
		<input type="button" value="提交反馈" Class="btn" onclick="saveSup(3);" />
		</c:if>
	</fieldset>
</c:if>
<c:if test="${sup.dealstep gt '2'}">
	<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">督办结论信息</legend>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
			<tr height="22">
					<td class="addTd">是否有客观原因:</td>
					<td align="left">
					 <select name="isexternal">
							<option value="">---请选择----</option>
								<c:forEach var="row" items="${cp:DICTIONARY('Charge_Flag')}">
									<option value="${row.key}"
										<c:if test="${sup.isexternal eq row.key}"> selected="selected" </c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							
					</select>
					</td>
				</tr>
				<td class="addTd">督办结论：</td>
				<c:choose>
					<c:when test="${param.step gt '3'}">
						<td colspan=3><c:out value="${sup.superviseresult}"></c:out>
							<div class="r" align="right">
								办结人：${sup.endoperatorname}&nbsp;&nbsp;&nbsp;
								办结日期：<fmt:formatDate value="${sup.enddate }" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;&nbsp;&nbsp;&nbsp;
							</div>
						</td>
					</c:when>
					<c:otherwise>
						<td colspan=3><s:textarea name="superviseresult" id="superviseresult"/></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
		<c:if test="${param.step eq '3'}">
		<input type="button" value="办结" Class="btn" onclick="saveSup(4);" />
		</c:if>
	</fieldset>
</c:if>
</s:form>
</body>

<script type="text/javascript">
function checkForm(id, desc){
	var v=document.getElementById(id).value;
	if(""==v){
		alert(desc+"不能为空");
		document.getElementById(id).focus();
		return false;
	}
}
function saveSup(step){
if (step == 3){
		if (checkForm('superviseback', '反馈内容')==false) return;
	}
	else if (step == 4){
		if (checkForm('superviseresult', '办结说明')==false) return;
	}
	var o = document.getElementById('step');
  	o.value=step;
  	document.getElementById('supCJJCForm').submit();
}
</script>
</html>

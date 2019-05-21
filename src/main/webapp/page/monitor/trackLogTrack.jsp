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
		<s:form action="trackLog" method="trackLogSave" namespace="/monitor" id="trackLogForm" enctype="multipart/form-data">
		<c:if test="${flag==1}">
		<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<b>办件基本信息</b>
		</legend>
		 	<input id="no" type="hidden" name="no" value="${applyInfo.no}" />
		 	<input id="flag" type="hidden" name="flag" value="${flag}" />
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">办件编号</td>
				<td ><a href="monitor/apply!view.do?internalNo=${applyInfo.internalNo}&itemId=${applyInfo.itemId}"><s:property value="%{applyInfo.internalNo}" /></a></td>
				
				<td class="addTd" width="130">主办部门</td>
				<td >${cp:MAPVALUE("depno",applyInfo.orgId)}</td>
				</tr>
				<tr>
				<td class="addTd" width="130">申请者名称</td>
				<td >${applyInfo.applicantName}</td>
				 <td class="addTd" width="130">申请者类型</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(applyInfo.applicantType))}</td> 
				</tr>
				<tr>
				<td class="addTd" width="130">登记时间</td>
				<td colspan="3"><fmt:formatDate value='${applyInfo.applyDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
				</tr>
				<tr>
				<td class="addTd" width="130">权力名称</td>
				<td colspan="3"><a href='${pageContext.request.contextPath}/powerbase/suppowerchglog!listVersion.do?itemId=${applyInfo.itemId}&version=${applyInfo.version}'>${cp:MAPVALUE("suppowerId",applyInfo.itemId)}</a></td>
				</tr>
			</table>
		</fieldset>
		</c:if>
		<c:if test="${flag==2}">
		<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<b>案件基本信息</b>
		</legend>
		 	<input id="no" type="hidden" name="no" value="${punishInfo.no}" />
		 	<input id="flag" type="hidden" name="flag" value="${flag}" />
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">案件编号</td>
				<td ><a href="monitor/punish!view.do?internalNo=${punishInfo.internalNo}&orgId=${punishInfo.orgId}"><s:property value="%{punishInfo.internalNo}" /></a></td>
				
				<td class="addTd" width="130">执法部门</td>
				<td >${cp:MAPVALUE("depno",punishInfo.orgId)}</td>
				</tr>
				 <tr>
				 <td class="addTd" width="130">当事人</td>
				<td >${punishInfo.punishTarget}</td> 
				<td class="addTd" width="130">当事人类型</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(punishInfo.targetType))}</td>  
				</tr>
				<tr>
				<td class="addTd" width="130">登记时间</td>
				<td ><fmt:formatDate value='${punishInfo.createDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
				<td class="addTd" width="130">案件来源</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(punishInfo.source))}</td>  
				</tr> 
				<tr>
				 <td class="addTd" width="130">确认事实</td>
				<td colspan="3">${punishInfo.fact}</td> 
				
				</tr>
				<tr>
				<td class="addTd" width="130">权力名称</td>
				<td colspan="3"><a href='${pageContext.request.contextPath}/powerbase/suppowerchglog!listVersion.do?itemId=${punishInfo.itemId}&version=${punishInfo.version}'>${cp:MAPVALUE("suppowerId",punishInfo.itemId)}</a></td>
				</tr>
			</table>
		</fieldset>
		</c:if>
			<fieldset>
			<legend class="ctitle" style="width: auto; margin-bottom: 5px;"><b>跟踪信息</b></legend>
			<input type="hidden" name="fromsup" value="${fromsup}">
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd"><span style="color: red">*</span>跟踪类型</td>
						<td colspan="3"><select name="tracktype" id="tracktype">
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('track_type')}">
								<option value="${row.key}"
									<c:if test="${tracktype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span>跟踪原因</td>
					<td align="left" colspan="3">
					<s:textarea name="trackreason" id="trackreason" cols="40" rows="2" style="width:98%;height:40px;" /></td>
				</tr>
				<tr align="center">
				<td align="center" colspan="4">
			<input type="button" class="btn" value="保存" onclick="trackLogSave()"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			</td>
			</tr>
			</table>
			</fieldset>
		</s:form>
</body>
<script type="text/javascript">
function trackLogSave(){
	var form=document.getElementById("trackLogForm");
	var tracktype=document.getElementById("tracktype").value;
	if(""==tracktype){
		alert("请选择跟踪类型");
		document.forms[0].tracktype.focus();
		return false;
	}
	var trackreason=document.getElementById("trackreason").value;
	if(""==trackreason){
		alert("请填写跟踪原因");
		document.forms[0].trackreason.focus();
		return false;
	}
	form.action="trackLog!trackLogSave.do?trackreason="+trackreason+"&tracktype="+tracktype;
	form.submit();
	
}
</script>
</html>

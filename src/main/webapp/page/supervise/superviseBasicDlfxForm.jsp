<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>部门督办发起</title>
		<sj:head locale="zh_CN" />
   		<script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="padding:10px;">
		<legend class="ctitle" style="width:auto;font:·16px">预报警信息</legend>
		<table cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td align="center">&nbsp;</td>
				<td align="center">报警类别</td>
				<td align="center">说明</td>
				<td align="center">预报警时间</td>
				<td align="center">摘牌时间</td>
				<td align="center">操作</td>
			</tr>
			<tr>
				<td align="center"><c:if test="${object.outway.monitorStyle eq 1}">
						<img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" />
					</c:if> 
					<c:if test='${object.outway.monitorStyle  eq 2}'>
						<img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" />
					</c:if> <c:if test='${object.outway.monitorStyle eq 3}'>
						<img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" />
					</c:if></td>
				<td align="center">${cp:MAPVALUE("Warnpointname",object.outway.monitorType)}</td>
				<td align="center">${object.outway.monitorDesc}</td>
				<td align="center"><fmt:formatDate value='${object.outway.intime}' pattern='yyyy-MM-dd' /></td>
				<td align="center"><fmt:formatDate value='${object.outway.outtime}' pattern='yyyy-MM-dd' /></td>
				<td align="center">
				<c:if test="${object.outway.outtime ne null}">&nbsp;</c:if>
					<c:if test="${object.outway.outtime eq null}"><a href="#">摘牌</a></c:if></td>
			</tr>
		</table>
			</fieldset>
		<fieldset style="padding:10px;">
		<legend class="ctitle" style="width:auto;font:·16px">督办基本信息</legend>
			<s:form  action="superviseBasic" namespace="/supervise" style="margin-top:0;margin-bottom:5" id="superviseBasicForm" method="post">
			 <s:textfield name="optId" value="%{object.optId}" type="hidden"/>
		<input type="hidden" name="bjtypestring" value="${bjtypestring}"/>
		<input type="hidden" name="intno" value="${intno}"/>
		<input type="hidden" name="itemid" value="${itemid}"/>
		<input type="hidden" name="forwardurl" value="${forwardurl}"/>
		<input type="hidden" name="outwayid" value="${object.outway.outwayno}"/>
		<input type="hidden" name="bjType" value="${object.outway.bjType}"/>
		<input type="hidden" name="monitorOrgId" value="${object.outway.orgId}">
		<input type="hidden" name="s_monitorSource" value="C">
		<input type="hidden" name="monitorOrgName" value="${cp:MAPVALUE('unitcode',object.outway.orgId)}">	  
			<table cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd">督办反馈时限<span style="color: red">*</span></td>
				<td align="left" colspan="1"><sj:datepicker id="promisedate"
						name="promisedate" style="width:140px" yearRange="2000:2020"
						timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
						changeYear="true" timepicker="true" validator="input" min="1"
						errorshow="请选择督办反馈时限" value="%{object.promisedate}" /></td>
			</tr>
				<tr height="22">
					<td class="addTd">被督办部门:</td>
			
					<td align="left"><s:textfield name="orgId" value="%{object.outway.orgId}" type="hidden"/>${cp:MAPVALUE("unitcode",object.outway.orgId)} </td>
				</tr>
				<tr height="22">
					<td class="addTd">督办意见:</td>
					<td><s:textarea name="superviseOption" id="superviseOption"/></td>
				</tr>
				<tr><td colspan="4" align="center"><input type="button" class="btn" value="发起督办" onclick="save();"/>
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /></td></tr>
			</table>
			</s:form>
			</fieldset>
	</body>
	<script type="text/javascript">
	function save(){
		var superviseOption=document.getElementById("superviseOption").value;
		if(""==superviseOption){
			alert("督办意见不能为空");
			document.forms[0].superviseOption.focus();
			return;
		}
		var promisedate=document.getElementById("promisedate").value;
		if(""==promisedate){
			alert("督办反馈时限不能为空");
			document.getElementById("promisedate").focus();
			return;
		}
		  var form=document.getElementById("superviseBasicForm");
		     form.action="superviseBasic!DlfxSubmit.do";     
		     form.submit();
	}
</script>
</html>

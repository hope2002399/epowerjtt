<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="wfActionTask.edit.title" /></title>
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
<sj:head locale="zh_CN" />
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>
<fieldset style="padding:10px;">
	<legend class="ctitle" style="width:auto; margin-bottom:10px;">任务分配</legend>
<s:form action="flowUserTask" namespace="/sampleflow"  method="post" id="wfActionTaskForm" >
	<s:submit name="assign"  method="assign" cssClass="btn" key="opt.btn.save" />
	<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
	<input type="hidden" name="nodeInstId" value="${nodeInstId}">
<table class="viewTable" border="0" cellpadding="0" cellspacing="0">		

				<tr>
					<td class="addTd">
						任务代办人
					</td>
					<td align="left">
					<div id="userDiv">
						<s:textfield name="userName" size="40"/>
						<input type="hidden" name="userCode" />
						<ul id="list"></ul>
					</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("input[name=userCode]"));
						})
						</script>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						任务过期时间
					</td>
					<td align="left">
						<sj:datepicker id="expiretime"
							name="expireTime" value="%{expiretime}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true"
							 />
					</td>
				</tr>

				<tr>
					<td class="addTd">
						描述
					</td>
					<td align="left">
						<s:textarea name="authDesc" cols="40" rows="2"/>
					</td>
				</tr>

</table>


</s:form>
</fieldset>
</body>
</html>
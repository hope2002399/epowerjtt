<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="wfTaskMove.edit.title" /></title>
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
</head>

<body>
<p class="ctitle"><s:text name="wfTaskMove.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="flowUserTask"  method="post" namespace="/sampleflow" id="wfTaskMoveForm" >
	<s:submit name="save"  method="saveTaskMove" cssClass="btn" key="opt.btn.save" />
	<input type="button" name="back" class="btn" value="返回" onclick="window.history.go(-1);"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
				<tr>
					<td class="TDTITLE">
						<s:text name="wfTaskMove.olduser" />
					</td>
					<td align="left">
					<div class="userDiv" style="z-index:1000000000;">
						<input type="text" name="userName" size="40" value=""/>
						<input type="hidden" id="olduser" name="taskMoveObj.olduser" />
						<ul id="list" class="ulList"></ul>
					</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#olduser"));
						})
						</script>
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="wfTaskMove.newuser" />
					</td>
					<td align="left">
						<div class="userDiv">
						<input type="text" name="userName1" size="40" value=""/>
						<input type="hidden" id="newuser" name="taskMoveObj.newuser" />
						<ul id="list1" class="ulList"></ul>
					</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName1]"),$("#list1"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#newuser"));
						})
						</script>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						<s:text name="wfTaskMove.desc" />
					</td>
					<td align="left">
						<s:textarea name="taskMoveObj.moveDesc" cols="40" rows="2"/>
					</td>
				</tr>

</table>


</s:form>
</body>
</html>

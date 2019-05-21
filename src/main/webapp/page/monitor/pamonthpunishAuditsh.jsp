<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>增减分录入</title>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			增减分录入审核
		</legend>
		<s:form action="pamonthpunish" method="post" namespace="/monitor" id="pamonthpunishForm" enctype="multipart/form-data">
			  	<input id="punishNo" type="hidden" name="punishNo" value="${object.punishNo}" />
			<s:submit name="save" method="update" cssClass="btn" key="opt.btn.save" />
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">

				
				<tr >
				<td class="addTd" width="130">增减分审批人：</td>
				<td>	<input type="hidden" id="auditor" name="auditor"
								value="${object.auditor}" />
							<s:property value="%{object.auditor}" /></td>
							
				</tr>
					<tr>
					<td class="addTd" width="130">增减分审批时间</td>
					<td ><s:date name="auditDate"
							format="yyyy-MM-dd HH:mm:ss" /></td> 	
				</tr>
			
				<tr>
					<td class="addTd" width="130"><s:text
							name="pamonthpunish.auditResult" /></td>
					<td align="left"><s:radio name="auditResult"
							list="#{'1':'同意','0':'不同意'}" value="%{object.auditResult}"
							listKey="key" listValue="value" /></td>
				</tr>
			
				<tr>			
					<td class="addTd" width="130"><s:text
							name="pamonthpunish.auditDesc" /></td>
					<td ><s:textarea name="auditDesc" cols="40" rows="2" style="width:50%;height:40px;" 
					value="%{object.auditDesc}"/></td>
				</tr>
				
			</table>

		</s:form>
	</fieldset>
	<script type="text/javascript">
	
	</script>
</body>
</html>

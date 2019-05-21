<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>考核汇总</title>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			考核汇总审核
		</legend>
		<s:form action="paPerformanceResult" method="post" namespace="/monitor" id="paPerformanceResultForm" enctype="multipart/form-data">
			  	<input id="checkNo" type="hidden" name="checkNo" value="${object.checkNo}" />
			<s:submit name="save" method="prupdate" cssClass="btn" key="opt.btn.save" />
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">

				
				<tr >
				<td class="addTd" width="130"><s:text
							name="paperformanceresult.auditor" /></td>
						<td><input type="hidden" id="auditor" name="auditor"
								value="${object.auditor}" />
							<s:property value="%{object.auditor}" /></td>
				</tr>
					<tr>
					<td class="addTd" width="130"><s:text
							name="paperformanceresult.auditDate" /></td>
					<td ><s:date name="auditDate"
							format="yyyy-MM-dd HH:mm:ss" /></td> 	
				</tr>
			
				<tr>
					<td class="addTd" width="130"><s:text
							name="paperformanceresult.auditResult" /></td>
					<td align="left"><s:radio name="auditResult"
							list="#{'1':'同意','0':'不同意'}" value="%{object.auditResult}"
							listKey="key" listValue="value" /></td>
				</tr>
			
				<tr>			
					<td class="addTd" width="130"><s:text
							name="paperformanceresult.auditDesc" /></td>
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

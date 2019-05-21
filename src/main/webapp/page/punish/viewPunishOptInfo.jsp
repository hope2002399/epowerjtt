<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<sj:head locale="zh_CN" />
<body>
<c:if test="${not empty processNote}">
<fieldset style="width: 99%; display: block; padding: 10px; margin-top: 10px;">
			<legend>
				<b>处理意见信息</b>
			</legend>
			<s:form>
			<table border="0" cellpadding="0" cellspacing="0" id="tb"
				class="viewTable" style="margin-top: 20px;">
				<tr>
					<td class="addTd">处理意见</td>
					<td><textarea readonly="true"
							style="width: 100%; height: 80px;background: white" >${processNote}</textarea></td>
				</tr>				
			</table>
			</s:form>
		</fieldset>
</c:if>
</body>
</html>
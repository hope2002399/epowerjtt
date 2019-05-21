<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<%@page import="com.centit.monitor.po.Pamonthpunish"%>
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
			明细查看
		</legend>
		<s:form action="pamonthpunish" method="post" namespace="/monitor"  enctype="multipart/form-data">
				<input type="hidden" id="auditResult" name="auditResult" value="${auditResult}"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	
			<tr>
				<td class="addTd"><s:text name="pamonthpunish.orgId" /></td>
				<td align="left" ><s:property value="%{orgId}" /></td>
				<td class="addTd"><s:text name="评测年月" /></td>
				<td align="left"colspan="3"><s:property value="%{countYear}" />年
				<s:property value="%{countMonth}" />月
				</td>
			</tr>
		<tr>
				<td class="addTd"><s:text name="增减分类别" /></td>
				<td align="left" colspan="3">${cp:MAPEXPRESSION
			        ("statType",phobject.punishType)} </td>
			
			</tr>
			<tr>
				<td class="addTd"><s:text name="增减美分单项值" /></td>
				<td align="left"><s:property value="%{punishUnit}" /></td>

				<td class="addTd"><s:text name="增减分数量" /></td>
				<td align="left"><s:property value="%{punishCount}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="增减分总值" /></td>
				<td align="left" colspan="3"><s:property value="%{punishSum}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="增减分说明" /></td>
				<td align="left" colspan="3"><s:property value="%{punishResion}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="增减分录入人" /></td>
				<td align="left" colspan="3"><s:property value="%{recorder}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="pamonthpunish.recordDate" /></td>
				<td align="left" colspan="3"><fmt:formatDate value='${phobject.recordDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
			</tr>
			</table>
        <c:if test="${auditResult!=null}">
			<fieldset> 
 			<legend>审核信息</legend> 
 			<table border="0" cellpadding="0" cellspacing="0" class="viewTable"> 
				<tr> 
					<td class="addTd"><s:text name="增减分审批人" /></td>
				<td align="left"><s:property value="%{auditor}" /></td>

						<td class="addTd"><s:text name="增减分审批时间" /></td>
				<td align="left"><fmt:formatDate value='${phobject.auditDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
 		
			<tr>
				<td class="addTd"><s:text name="pamonthpunish.auditResult" /></td>
				<td align="left" colspan="3">
					 <s:if
						test='%{ auditResult==\"0\"}'>不同意</s:if> <s:if
						test='%{ auditResult==\"1\"}'>同意</s:if>
				</td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="pamonthpunish.auditDesc" /></td>
				<td align="left" colspan="3"><s:property value="%{auditDesc}" /></td>
			</tr>
	</table> 
 			</fieldset> 
 			</c:if>
		</s:form>
	</fieldset>
	<script type="text/javascript">
	function checkItemType() {
		var statType = document.getElementById("statType");
		
		var chargeBasis_tr = document.getElementById("chargeBasis_tr");
		var charge_tr = document.getElementById("charge_tr");

		if (statType.value == '1') {
			chargeBasis_tr.style.display = "none";
			charge_tr.style.display = "block";
			
		} else {
			chargeBasis_tr.style.display = "block";
			charge_tr.style.display = "none";
		}


	}
	</script>
</body>
</html>

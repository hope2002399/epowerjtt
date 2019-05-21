<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="权利信息查看" /></title>
<style type="text/css">
.adColpan {
	background: #edf7ff url(js_wzy_16.png) left center;
}
#statTable{
border:1.5px solid #eee;
}
#statTable tbody tr td{

 border:1px solid #eee;

 border-bottom-width: thin;

 border-right-style:none;

 border-left-style:none;

 border-top-style: none;

}

a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: none;
}
a:active {
 text-decoration: none;
}
</style>
</head>
<body>
	<input type="button" name="reset" value="返回" class="btn"
		onclick="goback();" />
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend>
			权力基本信息
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td align="center" colspan="4" style="font-size: 14pt; font-family:宋体"><strong><c:out value="${deptQlInf.qlName}"></c:out></strong></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>类别</h4></td>
				<td align="left">${cp:MAPVALUE("ITEM_TYPE_NEW",deptQlInf.qlKind)}</td>
				<td class="addTd" style="width: 15%"><h4>权力基本编码</h4></td>
				<td align="left"><c:out value="${deptQlInf.qlRegNo}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>实施主体</h4></td>
				<td align="left"><c:out value="${deptQlInf.orgShortName}" /></td>
				<td class="addTd" style="width: 15%"><h4>行使层级</h4></td>
				<td align="left"><c:out value="${userLevelValue}" /></td>
			</tr>
			<tr id="ssyj">
				<td class="addTd" style="width: 15%"><h4>实施依据</h4></td>
				<%-- <td align="left" colspan="3"><c:out value="${deptQlInf.qlByLaw}" /></td> --%>
				<c:choose>
					<c:when test="${fn:length(deptQlInf.qlByLaw ) > 700}">
							<td align="left" colspan="3"><c:out value="${fn:substring(deptQlInf.qlByLaw, 0, 700)}..." />
							<span onclick="shedingyiju()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击展开]</span>
							</td>
					</c:when>
					<c:otherwise>
							<td align="left" colspan="3"><c:out value="${deptQlInf.qlByLaw}" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr id="ssyj2" style="display: none;">
				<td class="addTd" style="width: 15%"><h4>实施依据</h4></td>
					<td align="left" colspan="3"><c:out value="${deptQlInf.qlByLaw }" />
		      		<span onclick="shedingyiju2()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击收起]</span>
		      		</td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>备注</h4></td>
				<td align="left" colspan="3"><c:out value="${deptQlInf.remaer}" /></td>
			</tr>
		</table>
	</fieldset>
 	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
 		<div class="crumbs" style="font-size: 10pt;"><strong>审批服务业务</strong></div>
		<table id="statTable" style="width: 100%; border:1.5px solid #eee;">
			<thead align="center">
				<tr>
					<th width="10%" class="adColpan" style="text-align: center;font-size: small;">业务序号</th>
					<th width="45%" class="adColpan" style="text-align: center;font-size: small;">业务名称</th>
					<th width="30%" class="adColpan" style="text-align: center;font-size: small;">办理机构</th>
					<c:if test="${deptQlInf.qlKind eq '01' || deptQlInf.qlKind eq '04'||deptQlInf.qlKind eq '05' || deptQlInf.qlKind eq '07' || deptQlInf.qlKind eq '09' || deptQlInf.qlKind eq '10'}">
						<th width="15%" class="adColpan" style="text-align: center;font-size: small;">业务类别</th>
					</c:if>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="dyi" items="${deptYwInfs }" varStatus="status">
					<tr>
						<td><c:out value="${status.index + 1}" /></td>
						<td><a href='powerruntime/deptYwInf!getywById.do?iddeptYwInf=${dyi.iddeptYwInf }&userLevelValue=${userLevelValue}'><c:out value="${dyi.ywName}" /></a></td>
						<td><c:out value="${dyi.shrotOrgName}" /></td>
						<c:if test="${deptQlInf.qlKind eq '01' || deptQlInf.qlKind eq '04'||deptQlInf.qlKind eq '05' || deptQlInf.qlKind eq '07' || deptQlInf.qlKind eq '09' || deptQlInf.qlKind eq '10'}">
							<td><c:out value="${dyi.orgname }" /></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</body>
<script type="text/javascript">
	function goback() {
		return history.go(-1);
	}
	function shedingyiju(){
		$("#ssyj").hide();
		$("#ssyj2").show()
	}
	function shedingyiju2(){
		$("#ssyj").show();
		$("#ssyj2").hide();
	}
</script>
</html>
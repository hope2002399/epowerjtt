<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="办件列表" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/stat/stat.css">
</head>
<body>
	<div class="search">
		<div class="crumbs">办件列表</div>
		<s:form action="applyTask" namespace="/powerruntime">
			<input type="hidden" name="bjnumber" value="${bjnumber}"
				id="bjnumber" />
			<input type="hidden" name="showmore" value="${showmore}"
				id="showmore" />
			<input type="hidden" name="openid" value="${openid}" id="openid" />
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd"><h4>办件编号</h4></td>
					<td><s:textfield id="s_djId" name="s_djId"
							value="%{#parameters['s_djId']}" /></td>
					<td class="addTd"><h4>办件名称</h4></td>
					<td><s:textfield id="s_wfOptName" name="s_wfOptName"
							value="%{#parameters['s_wfOptName']}" /></td>
					<td class="addTd"><h4>申请者</h4></td>
					<td><s:textfield name="s_proposername" id="s_proposername"
							value="%{#parameters['s_proposername']}"></s:textfield>&nbsp;&nbsp;&nbsp;&nbsp;
						<s:submit method="selectlist" key="opt.btn.query" cssClass="btn" />
						&nbsp;&nbsp; <input type="button" name="reset" value="确认选择"
						class="btn" onclick="setParentVal()" /></td>
				</tr>
			</table>
		</s:form>
	</div>
	<div class="container">
		<table class="" id="statTable" style="width: 100%;">
			<thead align="center">
				<tr>
					<th class="addTh" width="5%" style="text-align: center">操作</th>
					<th class="addTh" width="20%" style="text-align: center">办件编号</th>
					<th class="addTh" width="30%" style="text-align: center">办件名称</th>
					<th class="addTh" width="30%" style="text-align: center">申请者</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="userTask" items="${objList}" varStatus="status">
					<tr
						<c:if test="${status.index%2==1}">style='background: rgb(223, 228, 232);'</c:if>>
						<td><input style="margin: 0;" type="checkbox" id="ischeck"
							name="ischeck" value="${userTask.djId}"
							onclick="ischange('${userTask.djId}','${userTask.transAffairNo}','${userTask.transaffairname}');"
							<c:if test="${userTask.isChecked eq 1}">checked="checked"</c:if> />
						</td>
						<td><c:out value="${userTask.transAffairNo}" /></td>
						<td><c:out value="${userTask.transaffairname}" /></td>
						<td><c:out value="${userTask.proposerName}" /></td>
					</tr>
				</c:forEach>
			</tbody>
			</div>
</body>
<script type="text/javascript">
	var arr = new Array();
	var arrname = new Array();
	var parentDocument = window.opener.document;//获取父页面对象
	$(document).ready(function() {
		var djid = $("#djid").val();
		if (djid != "" && djid != null) {
			var djids = djid.split(",");
			if (djids != null && djids.length > 0) {
				for (var i = 0; i < djids.length; i++) {
					arr.push(djids[i]);
				}
			}
		}
		var showmore = $("#showmore").val();
		if (showmore != "" && showmore != null) {
			var showmorees = showmore.split(",");
			if (showmorees != null && showmorees.length > 0) {
				for (var i = 0; i < showmorees.length; i++) {
					arrname.push(showmorees[i]);
				}
			}
		}
	});
	var ischange = function(djid, transAffairNo, name) {
		var a = 0;
		for (var i = 0; i < arr.length; i++) {
			if (arr[i] == djid) {
				a = 1; //这个是删除操作
				arr.splice(i, 1);
				arrname.splice(i, 1);
			}
		}
		if (a == 0) {
			arr.push(djid);
			arrname.push(transAffairNo + "(" + name + ")");
		}
		$("#openid").val(arr.toString());
		$("#bjnumber").val(arr.toString());
		$("#showmore").val(arrname.toString());
	}
	var setParentVal = function() {
		var openid = $("#openid").val();
		var showmore = $("#showmore").val();
		if (openid == "" || openid == null) {
			alert("至少选择一条办件！");
		} else {
			if (window.confirm("确认选择这些办件吗？选择后窗口将自动关闭。")) {
				parentDocument.getElementById('showmore').value = showmore;
				parentDocument.getElementById('bjnumber').value = openid;
				window.close();
			}
		}
	}
</script>
</html>
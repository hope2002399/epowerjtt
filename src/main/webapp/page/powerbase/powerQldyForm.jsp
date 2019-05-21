<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑权力对应关系</title>
<script src="<s:url value='/scripts/centit_validator.js'/>" type="text/javascript" />		
<script type="text/javascript"
	src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>"
	charset="utf-8"></script>
<link
	href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="编辑权力对应关系" />
		</legend>
	<s:form action="powerQldy" method="post"  theme="simple" validator="true" > 
		<table cellpadding="0" cellspacing="0" align="center" class="viewTable">
			<tr>
				<td class="addTd">部门名称</td>
				<td>
				${cp:MAPVALUE('depno',obj.orgId)}
				
			</tr>
		
			<tr><td class="addTd">事项类型</td>
			<td>
			${cp:MAPVALUE('ITEM_TYPE',obj.itemType)}
			</td></tr>
			<tr><td class="addTd">事项编码</td>
			<td>
			${obj.itemId}
			<input type="hidden"  id="itemId" name="itemId" value="${obj.itemId}" />
			</td></tr>
			<tr><td class="addTd">事项名称</td>
			<td>
			${cp:MAPVALUE('ITEM_TYPE',obj.itemType)}
			</td></tr>
			<tr><td class="addTd">对应权力编码</td><td><input type="text"  id="otherItemId" name="otherItemId" value="${obj.otherItemId}"/></td></tr>
					</table>
		<s:submit  method="savePowerQldy"  cssClass="btn" key="opt.btn.save"  onclick="return check();"/>
		<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
	</s:form>
	</fieldset>
	
	<script>
	function check(){
		if($("#otherItemId").val()==null||$("#otherItemId").val().trim()==""){
			alert("请输入对应的权力编码");
			return false;
		}
		return true;
	}
	</script>
</body>

</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head><meta name="decorator" content='${LAYOUT}'/>
<title><c:out value="${cp:MAPVALUE('unitcode',unitcode)}" /> :部门角色列表</title>

<script type="text/javascript">
	function resetForm(){
		alert($('#s_ROLENAME').val());
		$('#s_ROLENAME').val();
	}
</script>
</head>

<body>

<div class="search">
		<div class="crumbs">部门角色定义</div>
<s:form action="deptManager" namespace="/sys" styleId="deptroleForm" style="margin-top:0;margin-bottom:5">
	<table cellpadding="0" cellspacing="0" align="left">
		<tr>
			<td class="addTd">部门角色名：</td>	
			<td width="30%">
			<s:textfield name="s_ROLENAME" id="s_ROLENAME" value="%{#parameters['s_ROLENAME']}"  />
			<s:checkbox label="包含禁用" name="s_isAll" value="#parameters['s_isAll']" fieldValue="true" />包含禁用	
			</td>
			<td align="center">
			  <s:submit method="listrole" cssClass="btn" value="查询" />
			  <s:submit method="builtDeptRole" cssClass="btn" value="新增" />
			  <input type="button" name="reset"  class="btn" value="重置" onclick="resetForm();" />  
		 	</td>
		</tr>
	</table>
</s:form>
</div>

<ec:table action="sys/deptManager!listrole.do" items="fRoleinfos" var="role"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
	<ec:row>
		<ec:column property="rolecode" title="角色代码" style="text-align:center" />
		<ec:column property="rolename" title="角色名" style="text-align:center" />
		<ec:column property="Isvalid" title="状态" sortable="false" style="text-align:center">
					${USE_STATE[role.isvalid]}
		</ec:column>
		<ec:column property="roledesc" title="角色描述" style="text-align:center" />

		<ec:column property="roleopt" title="操作" sortable="false" style="text-align:center">
			<div class="option-btn">
			<a href='deptManager!editDeptRole.do?roleinfo.rolecode=${role.rolecode}' styleopt="">编辑</a>
			<c:if test="${role.rolecode != 'SYSADMIN'}">
				<c:if test="${role.isvalid eq 'T'}">
					
					<s:a action="deptManager!disableDeptRole.do" styleopt="">
						<s:param name="roleinfo.rolecode">${role.rolecode }</s:param>
						禁用
					</s:a>
				</c:if>
				<c:if test="${role.isvalid eq 'F'}">
					<s:a action="deptManager!renewDeptRole.do" style="">
						<s:param name="roleinfo.rolecode">${role.rolecode }</s:param>
					启用</s:a>
						<s:a action="deptManager!deleteDeptRole.do" style="">
						<s:param name="roleinfo.rolecode">${role.rolecode }</s:param>
					删除</s:a>				
				</c:if>
			</c:if>
			</div>
		</ec:column>
	</ec:row>
</ec:table>

</body>
</html>

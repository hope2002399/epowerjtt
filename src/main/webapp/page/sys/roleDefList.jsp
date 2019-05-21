<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
<head><meta name="decorator" content='${LAYOUT}'/>
<title><s:text name="roleinfo.list.title"/></title>


</head>

<body>


<div class="search">
		<div class="crumbs">角色定义</div>
<s:form action="roleDef" namespace="/sys" styleId="roleForm" theme="simple" >
	<table cellpadding="0" cellspacing="0"  align="left">
		<tr>
			<td class="addTd">角色名：
			</td>
			<td width="30%"><s:textfield name="s_ROLENAME" value="%{#parameters['s_ROLENAME']}" theme="simple"></s:textfield>
			<s:checkbox name="s_isAll" value="#parameters['s_isAll']" fieldValue="true" />包含禁用</td>
			<td align="center">
			<s:submit  key="opt.btn.query" cssClass="btn" method="list"></s:submit>
			<s:submit  key="opt.btn.new" cssClass="btn" method="built" ></s:submit></td>
		</tr>
	</table>
</s:form>
</div>


<ec:table action="roleDef!list.do" items="objList" var="fRoleinfo"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"   
		rowsDisplayed="15"
		filterRowsCallback="limit" 
		retrieveRowsCallback="limit"
		sortRowsCallback="limit">
	<ec:row>
		<ec:column property="rolecode" title="角色代码" style="text-align:center" />
		<ec:column property="rolename" title="角色名称" style="text-align:center" />
		<ec:column property="roledesc" title="角色说明" style="text-align:center" />
		<ec:column property="isvalid" title="状态" sortable="false" style="text-align:center">
					${USE_STATE[fRoleinfo.isvalid]}
				</ec:column>
		<ec:column property="roleopt" title="操作" sortable="false" style="text-align:center">		
			<a href='roleDef!newEdit.do?rolecode=${fRoleinfo.rolecode}&ec_p=${ec_p}&ec_crd=${ec_crd}'>编辑
			</a>
			<c:if test="${fRoleinfo.rolecode != 'SYSADMIN'}">
				<c:if test="${fRoleinfo.isvalid eq 'T'}">
					<a href='roleDef!delete.do?rolecode=${fRoleinfo.rolecode}'
					  onclick='return confirm("<s:text name='roleinfo.Isuse'/>");'> 禁用
					</a>
				</c:if>

				<c:if test="${fRoleinfo.isvalid eq 'F'}">
					<a href='roleDef!renew.do?rolecode=${fRoleinfo.rolecode}'>
						启用
					</a>
				</c:if>
			</c:if>
			
		</ec:column>
	</ec:row>
</ec:table>



</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			流程权限委托表列表
		</title>
	</head>
<sj:head locale="zh_CN" />
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 查询条件
			</legend>
			
			<s:form action="sampleFlowRelegate" namespace="/sampleflow" style="margin-top:0;margin-bottom:5">
			<s:hidden name="s_grant" value="%{#parameters['s_grant']}"/>
				<table cellpadding="0" cellspacing="0" >


					<tr >
						<td class="addTd">委托开始时间:</td>
						<td width="200"><sj:datepicker id="s_relegatetime" style="width:180px"
							name="s_relegatetime" value="%{#parameters['s_relegatetime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /></td>
						<td class="addTd">截止时间:</td>
						<td width="200"><sj:datepicker id="s_expiretime" style="width:180px"
							name="s_expiretime" value="%{#parameters['s_expiretime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /></td>
						<!--<td class="addTd">委托:</td>
						<td width="200"><s:radio name="s_grant" list="#{'T':'委托人','F':'受委托'}" listKey="key" listValue="value" value=""></s:radio></td>
						--><td width="200">
							<s:submit method="list"  value="查询" cssClass="btn"/>&nbsp;&nbsp;
							<input type="button" class="btn" onclick="window.location.href='${pageContext.request.contextPath}/sampleflow/sampleFlowRelegate!built.do?grant='+document.getElementById('s_grant').value" value="新增">
						</td>
					</tr>	
				</table>
			</s:form>
		</fieldset>
		<ec:table action="sampleflow/sampleFlowRelegate!list.do" items="objList" var="wfRoleRelegate"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>
				<%--
				<ec:column property="relegateno" title="委托编号" style="text-align:center" />
				 --%>
				<ec:column property="grantor" title="委托人" style="text-align:center" >
				${cp:MAPVALUE("usercode",wfRoleRelegate.grantor)}
				</ec:column>
				<ec:column property="grantee" title="受委托人" style="text-align:center" >
				${cp:MAPVALUE("usercode",wfRoleRelegate.grantee)}
				</ec:column>
				<ec:column property="unitcode" title="委托机构" style="text-align:center" >
				${cp:MAPVALUE("unitcode",wfRoleRelegate.unitcode)}
				</ec:column>
				<ec:column property="roletype" title="委托角色类别" style="text-align:center" >
				${cp:MAPVALUE("WFRoleType",wfRoleRelegate.roletype)}
				</ec:column>
				<ec:column property="rolecode" title="委托角色" style="text-align:center" >
					<c:if test="${wfRoleRelegate.roletype eq 'gw' }">
						${cp:MAPVALUE("StationType",wfRoleRelegate.rolecode)}
					</c:if>
					<c:if test="${wfRoleRelegate.roletype eq 'bj' }">
						${cp:MAPVALUE("WFTeamRole",wfRoleRelegate.rolecode)}
					</c:if>
					<c:if test="${wfRoleRelegate.roletype eq 'xz' }">
						${cp:MAPVALUE("RankType",wfRoleRelegate.rolecode)}
					</c:if>
				</ec:column>
				<ec:column property="relegatetime" title="委托开始时间" style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date"/>
				<ec:column property="expiretime" title="截止时间" style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date"/>
				<ec:column property="grantdesc" title="授予说明" style="text-align:center" />
				<%--
				<ec:column property="recorder" title="录入人" style="text-align:center" >
					${cp:MAPVALUE("usercode",wfRoleRelegate.recorder)}
				</ec:column>
				<ec:column property="recorddate" title="录入时间" style="text-align:center" format="yyyy-MM-dd hh:mm:ss" cell="date" />
				 --%>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href="javascript:void(0)" onclick="window.location.href='${pageContext.request.contextPath}/sampleflow/sampleFlowRelegate!edit.do?relegateno=${wfRoleRelegate.relegateno}&grant='+document.getElementById('s_grant').value">编辑</a>
					<a href="javascript:void(0)" onclick="window.location.href='${pageContext.request.contextPath}/sampleflow/sampleFlowRelegate!delete.do?relegateno=${wfRoleRelegate.relegateno}&grant='+document.getElementById('s_grant').value" 
							onclick='return confirm("确认删除该条记录?");'>删除</a>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>
</html>

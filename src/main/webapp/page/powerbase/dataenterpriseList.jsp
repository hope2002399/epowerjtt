<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			<s:text name="dataenterprise.list.title" />
		</title>
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 组织结构管理
			</div>
			
			<s:form action="dataenterprise" namespace="/powerbase" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td class="addTd">机构名称：</td>
						<td>
							<s:textfield name="s_applicant" />
						</td>
						<td class="addTd">是否使用：</td>
						<td>
							<select name="s_isInuse">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('ISINUSE')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_isInuse[0] eq row.key}"> selected = "selected" </c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
						<td width="160"></td>
					</tr>	

					<tr >
						<td class="addTd">更新时间：</td>
						<td>
							<sj:datepicker name="s_begTime" readonly="true"
								value="%{#parameters['s_begTime']}" yearRange="2010:2030"
								changeYear="true" displayFormat="yy-mm-dd" />
						</td>
						<td class="addTd">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						
						<td><sj:datepicker
							name="s_endTime" readonly="true"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
						</td>
						<td align="center"><s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<s:submit method="edit"  key="opt.btn.new" cssClass="btn"/></td>
					</tr>
				</table>
			</s:form>
		</div>
		<c:set var="cxparam"
		value="s_applicant=&s_isInuse=${s_isInuse }&s_begTime=${s_begTime }&s_endTime=${s_endTime }"></c:set>
		<ec:table action="powerbase/dataenterprise!list.do" items="objList" var="dataenterprise"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="rowCount" title="序号" style="text-align:center" cell="rowCount"/>

				<ec:column property="applicant" title="机构名称" style="text-align:center" />

				<ec:column property="linkman" title="法人" style="text-align:center" />

				<ec:column property="linkmanName" title="联系人" style="text-align:center" />

				<ec:column property="isInuse" title="是否使用" style="text-align:center">
				${cp:MAPVALUE("ISINUSE",dataenterprise.isInuse) }
				</ec:column>

				<ec:column property="lastModdate" title="更新时间" style="text-align:center">
				<fmt:formatDate value="${dataenterprise.lastModdate}"
					pattern="yyyy-MM-dd HH:mm" />
				</ec:column>
	
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='powerbase/dataenterprise!view.do?enterpriseid=${dataenterprise.enterpriseid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='powerbase/dataenterprise!edit.do?enterpriseid=${dataenterprise.enterpriseid}'><s:text name="opt.btn.edit" /></a>
					<c:if test="${dataenterprise.isInuse eq 'T' }">
					<a href='powerbase/dataenterprise!delete.do?enterpriseid=${dataenterprise.enterpriseid}&${cxparam}' 
							onclick='return confirm("确定要禁用吗?");'>禁用</a>
					</c:if>
					<c:if test="${dataenterprise.isInuse eq 'F' }">
					<a href='powerbase/dataenterprise!delete.do?enterpriseid=${dataenterprise.enterpriseid}&${cxparam}' 
							onclick='return confirm("确定要启用吗?");'>启用</a>
					</c:if>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>
</html>

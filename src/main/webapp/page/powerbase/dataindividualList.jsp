<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			<s:text name="dataindividual.list.title" />
		</title>
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 <s:text name="label.list.filter" />
			</div>
			
			<s:form action="dataindividual" namespace="/powerbase" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td width="30%" align="right">人员姓名：</td><td><s:textfield name="s_applicant" /></td><td>是否使用：</td><td>
						<select name="s_isInuse" style="width: 160px">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('ISINUSE')}">
							<option value="${row.key}"
								<c:if test="${parameters.s_isInuse[0] eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
						</select></td>
					</tr>	

					<tr >
						<td align="right">更新时间：</td><td><sj:datepicker name="s_begTime" readonly="true"
							value="%{#parameters['s_begTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
						</td><td>至</td><td><sj:datepicker
							name="s_endTime" readonly="true"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
						</td>
						<td>&nbsp;&nbsp;&nbsp;<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<s:submit method="edit"  key="opt.btn.new" cssClass="btn"/></td>
					</tr>
				</table>
			</s:form>
		</div>
<c:set var="cxparam"
		value="s_applicant=&s_isInuse=${s_isInuse }&s_begTime=${s_begTime }&s_endTime=${s_endTime }"></c:set>
		<ec:table action="powerbase/dataindividual!list.do" items="objList" var="dataindividual"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="rowCount" title="序号" style="text-align:center" cell="rowCount"/>

				<ec:column property="applicant" title="人员姓名" style="text-align:center" />

				<c:set var="tapplicantPaperType"><s:text name='dataindividual.applicantPaperType' /></c:set>	
				<ec:column property="applicantPaperType" title="${tapplicantPaperType}" style="text-align:center">
				${cp:MAPVALUE("PaperType_ZRR", dataindividual.applicantPaperType) }
				</ec:column>

				<ec:column property="sex" title="性别" style="text-align:center">
				${cp:MAPVALUE("sex", dataindividual.sex) }
				</ec:column>
				<ec:column property="isInuse" title="是否使用" style="text-align:center">
				${cp:MAPVALUE("ISINUSE", dataindividual.isInuse) }
				</ec:column>
				
				<ec:column property="lastModdate" title="更新时间" style="text-align:center">
				<fmt:formatDate value="${dataindividual.lastModdate }" pattern="yyyy-MM-dd HH:mm"/>
				</ec:column>
		
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='powerbase/dataindividual!view.do?individualid=${dataindividual.individualid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='powerbase/dataindividual!edit.do?individualid=${dataindividual.individualid}'><s:text name="opt.btn.edit" /></a>
					<c:if test="${dataindividual.isInuse eq 'T' }">
					<a href='powerbase/dataindividual!delete.do?individualid=${dataindividual.individualid}&${cxparam}' 
							onclick='return confirm("确定要禁用吗?");'>禁用</a>
					</c:if>
					<c:if test="${dataindividual.isInuse eq 'F' }">
					<a href='powerbase/dataindividual!delete.do?individualid=${dataindividual.individualid}&${cxparam}' 
							onclick='return confirm("确定要启用吗?");'>启用</a>
					</c:if>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>

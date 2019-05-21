<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			<s:text name="trPermitApply.list.title" />
		</title>
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="trPermitApply" namespace="/dofc" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td>申请人:</td>
						<td><s:textfield name="s_proposerName" value="%{#parameters['s_proposerName']}" /></td>
					</tr>	

					<tr>
						<td>申请日期:</td>
						<td><sj:datepicker id="s_applyDate" value="%{#parameters['s_applyDate']}"
							name="s_applyDate"  style="width:180px"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						</td>
					</tr>
					
					<tr>
						<td>申请者所在单位:</td>
						<td>
							<select name="s_proposerUnitcode" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:LVB('unitcode')}">
									<option value="${row.value}"  <c:if test="${param.s_proposerUnitcode==row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>	

					<tr>
						<td>申请方式:</td>
						<td>
							<select name="s_applyWay" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('bjsqfs')}">
									<option value="${row.key}" <c:if test="${param.s_applyWay eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<s:submit method="list" value="查询" cssClass="btn"/>
							<s:submit method="permitReg" value="新建" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="dofc/trPermitApply!list.do" items="objList" var="trPermitApply"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="proposerName" title="申请人" style="text-align:center" />
				
				<ec:column property="applyDate" title="申请日期" style="text-align:center">
					<fmt:formatDate value="${trPermitApply.applyDate}" pattern="yyyy-MM-dd"/>
				</ec:column>
				
				<ec:column property="applyItem" title="申请事项" style="text-align:center" />

				<ec:column property="proposerUnitcode" title="申请者所在单位" style="text-align:center" >
					${cp:MAPVALUE("unitcode",trPermitApply.proposerUnitcode)}
				</ec:column>

				<ec:column property="proposerType" title="申请者类别" style="text-align:center" >
					${cp:MAPVALUE("PROPOSER_TYPE",trPermitApply.proposerType)}
				</ec:column>

				<ec:column property="applyWay" title="申请方式" style="text-align:center" >
					${cp:MAPVALUE("bjsqfs",trPermitApply.applyWay)}
				</ec:column>
		
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<!--<a href='dofc/trPermitApply!view.do?djId=${trPermitApply.djId}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
					-->
					<a href='dofc/trPermitApply!edit.do?djId=${trPermitApply.djId}'>修改</a>
					<a href='dofc/trPermitApply!delete.do?djId=${trPermitApply.djId}' 
							onclick='return confirm("${deletecofirm}trPermitApply?");'>删除</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<html>
	<head>
		<title><c:out value="pmIndexEvluation.list.title" /></title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		function resetForm(){
			$("#s_objectType").val('');
			$("#s_annual").val('');
			$("#s_evlTimebeg").val('');
			$("#s_evlTimeend").val('');
		}
		</script>
		<style type="text/css">
		 select{width:160px; }
		 input{width:160px; }
		</style>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #CACACA; ">
			<legend>
				 指标测评结果
			</legend>
			<s:form action="/indicator/pmIndexEvluation.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">


					<tr height="22">
						<td>对象类型:</td>
						<td><select  name="s_objectType" id="s_objectType">
								<option value="">请选择</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PM_TEMPLETTYPE')}">
									<option type="radio" <c:if test="${param.s_objectType eq row.key}">selected="selected"</c:if> value="${row.key }" >
										${row.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td>测评年度:</td>
						<td><input type="hidden" name="maxnd" id="maxnd" value="${cp:MAPVALUE('provinceAnnual','sbAnnual') }"/>
						<input type="text" name="s_annual"  id="s_annual" value="${param.s_annual}" class="Wdate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'maxnd\')}',dateFmt:'yyyy'})" readonly="readonly"/></td>
					</tr>	


					<tr height="22">
						<td>测评时间:</td>
						<td><input type="text" name="s_evlTimebeg"  id="s_evlTimebeg" value="${param.s_evlTimebeg}" class="Wdate" onClick="WdatePicker()" readonly="readonly"/> </td>
						<td>至:</td>
						<td><input type="text" name="s_evlTimeend"  id="s_evlTimeend" value="${param.s_evlTimeend}" class="Wdate" onClick="WdatePicker()" readonly="readonly"/> </td>
						
					</tr>	

				</table>
				<center>
							<s:submit method="list" cssClass="btn" key="查询" ></s:submit>
							<input type="button" class="btn" value="重置" onclick="resetForm()">
				</center>
			</s:form>
		</fieldset>

			<ec:table action="pmIndexEvluation!list.do" items="vEvluationList" var="pmIndexEvluation"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="pmIndexEvluations.xls" ></ec:exportXls>
			<ec:row>
				
					
					<ec:column property="templetName" title="模板名称" style="text-align:center" />
				
					<ec:column property="objectType" title="项目类型" style="text-align:center" >
						${cp:MAPVALUE("PM_TEMPLETTYPE",pmIndexEvluation.objectType) }
					</ec:column>
					
					<ec:column property="objectName" title="项目名称" style="text-align:center" />
					
					<ec:column property="annual" title="年度" style="text-align:center" />

					<%-- <ec:column property="expression" title="测评表达式" style="text-align:center" /> --%>
				
					<ec:column property="evlScore" title="测评得分" style="text-align:center" />
				
					<ec:column property="evlTime" title="测评时间" style="text-align:center" />
						
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href='pmIndexEvluation!view.do?evlId=${pmIndexEvluation.evlId}&expression=${pmIndexEvluation.expression}'>查看</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>

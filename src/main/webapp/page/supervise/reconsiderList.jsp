<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			行政复议
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				查询条件
			</div>
			
			<s:form action="reconsider" namespace="/supervise" style="margin-top:0;margin-bottom:5;">
				<s:hidden name="optId" value="reconsider"/>
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="addTd">复议编号：</td>
						<td><s:textfield name="s_reconsiderid" value="%{#parameters['s_reconsiderid']}"/> </td>
					
						<td class="addTd">办件类型：</td>
						<td>	
                <s:radio value="%{#parameters['s_bjType']}" listKey="key" listValue="value" id="s_bjType" name="s_bjType" list="#{'':'全部','1':'许可','2':'处罚'}"  />
						 </td>
					</tr>	
<tr>
						<td class="addTd">办件编号：</td>
						<td><s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}"/> </td>
					    
					    <td class="addTd">状态：</td>
						<td class="addTd">
						<select name="s_biztype" style="width:140px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bizType')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_biztype==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						</td>
						<td >&nbsp;&nbsp;
							<s:submit method="edit"  cssClass="btn" value="复议登记"/>
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="supervise/reconsider!list.do" items="objList" var="reconsider"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row highlightRow="true">
				<ec:column property="reconsiderid" title="复议编号" style="text-align:center" />
				<ec:column property="bjType" title="办件类型" style="text-align:center" >
				${cp:MAPVALUE("bjType",reconsider.bjType)}
				</ec:column>
		        <ec:column property="internalNo" title="办件编号" style="text-align:center" />
		        <ec:column property="bjType" title="申请复议单位" style="text-align:center" >
		        ${cp:MAPVALUE("depno",reconsider.reconsiderapply)}
		        </ec:column>
		        <ec:column property="bookdate" title="复议登记时间" style="text-align:center" format="yyyy-MM-dd HH:mm" cell="date" />
		        
		       	<ec:column property="biztype" title="状态" style="text-align:center" >
				${cp:MAPVALUE("bizType",reconsider.biztype)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='supervise/reconsider!view.do?reconsiderid=${reconsider.reconsiderid}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
					<c:if test="${reconsider.biztype=='F'}">
					<a href='supervise/reconsider!edit.do?reconsiderid=${reconsider.reconsiderid}'>编辑</a>
					<a href='supervise/reconsider!delete.do?reconsiderid=${reconsider.reconsiderid}' 
							onclick='return confirm("${deletecofirm}当前行政复议?");'>删除</a>
				</c:if>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>

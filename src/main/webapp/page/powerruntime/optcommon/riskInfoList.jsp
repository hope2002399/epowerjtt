<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			<s:text name="riskInfo.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">风险点管理</div>
			
			<s:form action="riskInfo" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td class="addTd">风险点类别：</td>
						<td width="30%">
						<select name="s_risktype">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('RISKTYPE')}">
									<option value="${row.key}"
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
						</td>
						<td class="addTd">风险点描述：</td>
						<td width="180"><s:textfield name="s_riskdes" /></td>
						<td colspan="4" align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<s:submit method="edit"  key="opt.btn.new" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="powerruntime/riskInfo!list.do" items="objList" var="riskInfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>			

				<c:set var="trisktype">风险点类别</c:set>	
				<ec:column property="risktype" title="${trisktype}" style="text-align:center" >
				 ${cp:MAPVALUE("RISKTYPE",riskInfo.risktype)}
				</ec:column>

				<c:set var="triskdes">风险点描述</c:set>	
				<ec:column property="riskdes" title="${triskdes}" style="text-align:center" />
				
				<c:set var="tsettime">设置时间</c:set>	
				<ec:column property="settime" title="${tsettime}" style="text-align:center">
				<fmt:formatDate value="${riskInfo.settime}" pattern="yyyy-MM-dd"/>
				</ec:column>
			
				<c:set var="optlabel">操作</c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='powerruntime/riskInfo!edit.do?riskid=${riskInfo.riskid}'>编辑</a>
					<a href='powerruntime/riskInfo!delete.do?riskid=${riskInfo.riskid}' 
							onclick='return confirm("${deletecofirm}:${cp:MAPVALUE("RISKTYPE",riskInfo.risktype)}?");'>删除</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>

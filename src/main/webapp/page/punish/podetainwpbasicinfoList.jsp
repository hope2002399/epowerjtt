<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
</head>
<body>

<fieldset style="border: hidden 1px #000000;">
		<s:form name="podetainwpbasicinfoForm" action="podetainwpbasicinfo" method="post" namespace="/punish" id="podetainwpbasicinfoForm" target="_self">
		<input type="hidden" name="punishobjectid" value="${object.punishobjectid}"/>
		<legend>
			查询条件
		</legend>
			<table cellpadding="0" cellspacing="0" align="center">
				<tr><td class="addTd">办件编号:</td>
					<td> <s:textfield name="s_punishobjectid" style="width:180px"  /></td>
				</tr>
				<tr><td class="addTd">暂扣品名称:</td><td>
					<s:textfield name="s_wpname" style="width:180px" /></td>
				</tr>

				<tr>
					<td align="center" colspan="2">
					<s:submit method="list" key="查询" cssClass="btn" /> 
					<s:submit method="addnew" key="新增" cssClass="btn" /> 
					</td>
				</tr>
			</table>
</s:form>
	</fieldset>

	<ec:table  action="../punish/podetainwpbasicinfo!list.do" items="podetainwpbasicinfos" var="object" imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
	<ec:row>		
	<ec:column property="wpid" title="暂扣品编号"	style="text-align:center" sortable="false"><a href="podetainwpbasicinfo!view.do?wpid=${object.wpid}">${object.wpid}</ec:column>
	<ec:column property="punishobjectid" title="办件编号"	style="text-align:center" sortable="true"/>
	<ec:column property="wpname" title="物品名称"	style="text-align:center" sortable="true"/>
	<ec:column property="wptype" title="物品类别"	style="text-align:center" sortable="true">
	${cp:MAPVALUE("wptype",object.wptype)} 
	</ec:column>
	<ec:column property="wpstate" title="物品状态"	style="text-align:center" sortable="true">
	${cp:MAPVALUE("wpstate",object.wpstate)} 
	</ec:column>
	<ec:column property="wpcurrentlocation" title="当前位置"	style="text-align:center" sortable="true"/>
	<ec:column  property="opt" title="操作"	style="text-align:center" sortable="true">
	<c:if test="${object.wpstate==1}">
	<a href="podetainwpbasicinfo!edit.do?wpid=${object.wpid}">编辑</a>
	<a href="podetainwptransinfo!turnover.do?wpid=${object.wpid}">转移</a>
	<a href="podetainwptransinfo!sendback.do?wpid=${object.wpid}">归还</a>
	<a href="podetainwptransinfo!reglost.do?wpid=${object.wpid}" >登记遗失</a>
	<a href="podetainwptransinfo!destroy.do?wpid=${object.wpid}" >销毁</a>
	</c:if>
	<c:if test="${object.wpstate ne 1}">
	--
	</c:if>
	</ec:column>
	
	</ec:row>
	</ec:table>	

</body>
</html>
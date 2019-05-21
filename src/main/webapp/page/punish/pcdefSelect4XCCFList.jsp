<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<base target='_self'>
<title>选择处罚项目</title>
<script type="text/javascript">	


	//设置返回值
	function selectCF(id,name,punishbasis) {
		if (window.confirm("确认选择此处罚项目吗？选择后窗口将自动关闭。")) {
				
				window.opener.document.getElementById('itemId').value=id;
				window.opener.document.getElementById('itemName').value=name;
				window.opener.document.getElementById('itemanyou').value=name;
				window.opener.document.getElementById('poRegisterBasis').value=punishbasis;
				window.
			window.close();
		}
		/*****************业务数据页面跳转end*********/
	}
	function selectCF4XCCF(id,name,punishbasis) {
		if (window.confirm("确认选择此处罚项目吗？选择后窗口将自动关闭。")) {
			var url = "punish/punishobjectbasic!createfacilitydes.do?punishclassid=" + id +"&object.punishobjectid=${punishobjectid}";
			window.opener.location.href=url;
			window.close();
		}
		/*****************业务数据页面跳转end*********/
	}
</script>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="border: hidden 1px #000000;">
		<legend>
			查询条件
		</legend>

		<s:form action="pcdef" namespace="/punish"	style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
			<input type="hidden" name="depid" value="${object.depid }">
				<tr>
					<td class="addTd">项目代码:</td>
					<td>
					<s:textfield name="s_punishclasscode" style="width:180px" value="%{#parameters['s_punishclasscode']}" /></td>
				</tr>
				<tr>
					<td class="addTd">权力名称:</td>
					<td>
					<s:textfield name="s_punishclassname" style="width:180px" value="%{#parameters['s_punishclassname']}" /></td>
				</tr>

				<tr>
					<td align="center" colspan="2">
					<s:submit method="listPcdef" key="opt.btn.query" cssClass="btn" /> 
					<input type="button" class="btn" value="关闭" onclick="window.close();">
					</td>
				</tr>
			</table>
		</s:form>
	</fieldset>

	<ec:table action="pcdef!listPcdef.do" items="pcdefList" var="pcdef"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">	
		<ec:row>			
			<ec:column property="punishclasscode" title="权力编码"	style="text-align:center" sortable="false"/>
			<ec:column property="punishclassname" title="权力名称"	style="text-align:center" sortable="false">	
				<c:choose>
					<c:when test="${fn:length(pcdef.punishclassname) > 20}">
						<c:out value="${fn:substring(pcdef.punishclassname, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${pcdef.punishclassname}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="punishbasis" title="法律依据" style="text-align:center" sortable="false">
			<c:choose>
					<c:when test="${fn:length(pcdef.punishbasis) > 20}">
						<c:out value="${fn:substring(pcdef.punishbasis, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${pcdef.punishbasis}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="punishobject" title="处罚对象"	style="text-align:center" sortable="false">
			 <c:if test="${pcdef.punishobject==0}">个人</c:if>
		     <c:if test="${pcdef.punishobject==1}">机构</c:if>
		     <c:if test="${pcdef.punishobject==2}">个人、机构</c:if>
			</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<input type="radio" onclick="selectCF4XCCF('${pcdef.punishclassid}','${pcdef.punishclassname}','${pcdef.punishbasis}')">

			</ec:column>
		</ec:row>
	</ec:table>

</body>

</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<base target='_self'>
<title>选择处罚项目</title>
<script type="text/javascript">
	//设置返回值
	function selectCF(id, name) {

		if (window.confirm("确认选择此处罚项目吗？选择后窗口将自动关闭。")) {

			dialogArguments.document.getElementById('itemId').value = id;
			dialogArguments.document.getElementById('itemName').value = name;			
			window.returnValue = id;
			window.close();
		}
		/*****************业务数据页面跳转end*********/
	}
</script>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="border: hidden 1px #000000;">
		<legend> 查询条件 </legend>

		<s:form action="pcdef" namespace="/punish"
			style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
				<input type="hidden" name="depid" value="${object.depid }">
				<tr>
					<td class="addTd">项目代码:</td>
					<td><s:textfield name="s_punishclasscode" style="width:180px"
							value="%{#parameters['s_punishclasscode']}" /></td>
				</tr>
				<tr>
					<td class="addTd">权力名称:</td>
					<td><s:textfield name="s_punishclassname" style="width:180px"
							value="%{#parameters['s_punishclassname']}" /></td>
				</tr>
				<tr>
					<td class="addTd">案由</td>
					<td align="left"><select name="s_belonganyou" id="belonganyou">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('anyou')}">
								<option value="${row.key}" label="${row.value}"
									<c:if test="${s_belonganyou eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><s:submit method="listPcdef"
							key="opt.btn.query" cssClass="btn" /> <input type="button"
						class="btn" value="关闭" onclick="window.close();"></td>
				</tr>
			</table>
		</s:form>
	</fieldset>

	<ec:table action="pcdef!listPcdef.do" items="pcdefList" var="pcdef"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit" styleClass="fixedOverflow">
		<ec:row>
			<ec:column property="punishclasscode" title="权力编码"
				style="text-align:center" sortable="false" />
			<ec:column property="punishclassname" title="权力名称"
				style="text-align:center" sortable="false" />

			<ec:column property="punishbasis" title="法律依据"
				style="text-align:center" sortable="false" />
			<ec:column property="punishbasiscontent" title="法律条文"
				style="text-align:center" sortable="false" />

			<ec:column property="punishobject" title="处罚对象"
				style="text-align:center" sortable="false">
				<c:if test="${pcdef.punishobject==0}">个人</c:if>
				<c:if test="${pcdef.punishobject==1}">机构</c:if>
				<c:if test="${pcdef.punishobject==2}">个人、机构</c:if>
			</ec:column>
			<ec:column property="punishobject" title="案由"
				style="text-align:center" sortable="false">
              ${cp:MAPVALUE("anyou",pcdef.belonganyou)}
			</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<input type="radio"
					onclick="selectCF('${pcdef.punishclassid}','${pcdef.punishclassname}')">

			</ec:column>
		</ec:row>
	</ec:table>

</body>
<script type="text/javascript"
	src="<c:url value="/scripts/jquery1.3.2.js"/>"></script>
<style type="text/css">
.eXtremeTable.fixedOverflow { /* *width:30em; **/
	table-layout: fixed; /* 只有定义了表格的布局算法为fixed，下面td的定义才能起作用。 */
}

.eXtremeTable.fixedOverflow td { /* *width:100%; **/
	font-family: verdana, arial, helvetica, sans-serif;
	word-break: keep-all; /* 不换行 */
	white-space: nowrap; /* 不换行 */
	overflow: hidden; /* 内容超出宽度时隐藏超出部分的内容 */
	text-overflow: ellipsis;
	/* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
}
</style>

<script type="text/javascript">
	$(function() {
		$("tbody td").mouseover(

				function() {
					var inControl = $(this).children("a");
					if (inControl.length == 1
							&& inControl.html().replace(/&nbsp;/g, "") != "") {
						$(this).attr("title", inControl.html());
					} else if ($(this).children().length == 0
							&& $(this).html().replace(/&nbsp;/g, "") != "") {
						$(this).attr("title", $(this).html());
					}
				});
	});
</script>

</html>

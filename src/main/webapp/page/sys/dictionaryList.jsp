<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="decorator" content='${LAYOUT}' />

<title>数据字典</title>
<%@ include file="/page/common/css.jsp"%>
</head>

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

<body>
		<div class="search" style="float:none">
		<div class="crumbs">数据字典管理</div>	
		<s:form action="dictionary.do" namespace="/sys">
			
			<table>
				<tr>
					<td class="addTd">代码：</td>
					<td width="180"><s:textfield name="s_CATALOGCODE" value="%{#parameters['s_CATALOGCODE']}"></s:textfield> </td>
					<td class="addTd">字典名:</td>
					<td><s:textfield name="s_CATALOGNAME" value="%{#parameters['s_CATALOGNAME']}"></s:textfield> </td>
					</tr>
					<tr>
					<td class="addTd">业务分类:</td>
					<td><select name="s_dictionarytype">
						<option value="">全部</option>
                        <c:forEach var="dt" items="${cp:DICTIONARY('DICTIONARYTYPE')}">
                            <option value="${dt.id.datacode}"
                                    <c:if test="${param['s_dictionarytype'] eq dt.id.datacode}">selected="selected" </c:if>
                                    >${dt.datavalue }</option>
                        </c:forEach>
                    </select> </td>
				</tr>	
				<tr>
					<td class="addTd">字典类型：</td>
					<td colspan="3"><s:radio name="s_CATALOGSTYLE" list="#{'U':'用户数据字典','S':'系统数据字典','G':'国际数据字典','L':'同步数据字典','':'全部类型'}" listKey="key" listValue="value" value="%{#parameters['s_CATALOGSTYLE']}"></s:radio></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3"><s:submit method="list" cssClass="btn" value="查询"></s:submit><input type="button" value="新建字典" class="btn" onclick="location.href='dictionary!built.do'">
					<input type="button" value="刷新系统中的代码库" class="btn" onclick="location.href='dictionary!refresh.do'" />
					<!-- <a href="dictionary!refresh.do" class="btnA"><span class="btn">刷新系统中的代码库</span></a> --></td>
				</tr>
			</table>
			
		</s:form>
	</div>

	<br />

<!-- 	<a href='dictionary!list.do?s_style=U'> 用户数据字典 </a>
	<a href='dictionary!list.do?s_style=S'> 系统数据字典 </a>
	<a href='dictionary!list.do?s_style=G'> 国标数据字典 </a>
	<a href='dictionary!list.do?s_style=L'> 同步的数据字典 </a> 
	<a href='dictionary!built.do'> 新建字典 </a>
	<a href='dictionary!refresh.do'>
		刷新系统中的代码库 </a> -->

	<ec:table items="objList" var="fDatadictionary"
		action="sys/dictionary!list.do" styleClass="tableRegion fixedOverflow"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit" >
		<ec:row>
			<ec:column property="catalogcode" title="代码"
				style="text-align:center" width="15%" />
			<ec:column property="catalogname" title="字典名"
				style="text-align:center" width="10%" />
			<ec:column property="catalogtype" title="字典形式" sortable="false"
				style="text-align:center" width="10%">
				<c:out value="${fDatadictionary.catalogtype=='L'?'列表':'树形'}" />
			</ec:column>
			<ec:column property="catalogdesc" title="字典描述" sortable="false"
				style="text-align:center" width="15%" />
			<ec:column property="dictionarytype" title="业务分类" sortable="false"
				style="text-align:center" width="15%">
					<c:set var="dt" value="${empty fDatadictionary.dictionarytype ? 'NONE' : fDatadictionary.dictionarytype}" />
                    ${cp:MAPVALUE('DICTIONARYTYPE', dt) }
				</ec:column>
			<ec:column property="catalogopt" title="操作" sortable="false"
				width="20%">
				<a
					href='dictionary!view.do?catalogcode=${fDatadictionary.catalogcode}'>
					字典明细 </a>
				<a
					href='dictionary!edit.do?catalogcode=${fDatadictionary.catalogcode}'>
					编辑 </a>
				<a
					href='dictionary!delete.do?catalogcode=${fDatadictionary.catalogcode}'
					onclick='return confirm("是否删除数据字典：${fDatadictionary.catalogname}?");'>
					删除 </a>
			</ec:column>
		</ec:row>
	</ec:table>

</body>
</html>

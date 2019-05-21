<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			通用运行模块配置
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">通用运行模块配置</div>
			
			<s:form action="generalModuleParam" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="left">

					<tr >
						<td class="addTd">模块代码：</td>
						<td width="30%"><s:textfield name="s_moduleCode" id="s_moduleCode" value="%{#parameters['s_moduleCode']}"/> &nbsp;
						<input type="checkbox"  name="s_isInUse" value="" <c:if test="${param.s_isInUse eq ''}">checked="checked"</c:if>/>包含已禁用</td>
					
						<td align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<s:submit method="built"  key="opt.btn.new" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="powerruntime/generalModuleParam!list.do" items="objList" var="generalModuleParam"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="moduleCode" title="模块代码" style="text-align:center" />

				<ec:column property="nodeName" title="环节名称" style="text-align:center" />

				<ec:column property="ideaLabel" title="结果标签" style="text-align:center" />

				<ec:column property="ideaCatalog" title="结果代码" style="text-align:center" />

				<ec:column property="ideaContent" title="内容标签" style="text-align:center" />

				
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">				
					
					<a href='powerruntime/generalModuleParam!edit.do?moduleCode=${generalModuleParam.moduleCode}'>编辑</a>
					<a href='powerruntime/generalModuleParam!copy.do?moduleCode=${generalModuleParam.moduleCode}'>复制</a>
					<a href='powerruntime/generalModuleParam!delete.do?moduleCode=${generalModuleParam.moduleCode}' 
							onclick='return confirm("确定该操作?");'>删除</a>
				<a href='#' onclick="doIsInUse('${generalModuleParam.moduleCode}','${generalModuleParam.isInUse}');">
					<c:if test="${generalModuleParam.isInUse eq 'T' or empty generalModuleParam.isInUse}">禁用</c:if>
					<c:if test="${generalModuleParam.isInUse eq 'F'}">启用</c:if>
					</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
	
<script type="text/javascript">
	function doIsInUse(moduleCode,isInUse){
		if(window.confirm("是否确定此操作?")){
		var url = "powerruntime/generalModuleParam!editIsInUse.do?moduleCode="+moduleCode+"&isInUse="+isInUse+"&s_moduleCode="+document.getElementById('s_moduleCode').value;
		document.location.href = url;
		}
	}

</script>
</html>

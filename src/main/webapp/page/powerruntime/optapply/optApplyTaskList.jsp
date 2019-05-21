<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="wfActionTask.list.title" />
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_wfOptTag').val('');
			  $('#s_wfOptName').val('');
		  }
		</script>
	</head>

	<body>
		<div class="search">
		<div class="crumbs">办件处理</div>
		<s:form action="applyTask" namespace="/powerruntime">
			<s:hidden name="s_applyItemType" value="%{#parameters['s_applyItemType']}" />
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
				<td class="addTd">办件编号:</td>
				<td><s:textfield id="s_wfOptTag" name="s_wfOptTag"
							value="%{#parameters['s_wfOptTag']}" /></td>
				<td class="addTd">办件名称:</td>
				<td><s:textfield id="s_wfOptName" name="s_wfOptName" value="%{#parameters['s_wfOptName']}" /> </td>
				<td width="160" align="center"><s:submit method="list" key="opt.btn.query"
							cssClass="btn" /><input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/></td>
				</tr>
			</table>
		</s:form>
	</div>
	
	
		<ec:table action="../powerruntime/applyTask!list.do" items="objList" var="userTask"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="nodeInstId"  title="编号" style="text-align:center" />
				<ec:column property="flowOptTag" title="办件编号" style="text-align:center" />
				<ec:column property="flowOptName" title="办件名称" style="text-align:center" />
				
				<ec:column property="nodeCreateTime" title="更新时间"
						style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" />
				<ec:column property="inststate" title="流程状态"
				style="text-align:center">
					${cp:MAPVALUE("WFInstType",userTask.inststate)}
				</ec:column>
				<ec:column property="nodeName" title="当前步骤" style="text-align:left" >
				${userTask.nodeName}
				<c:if test="${userTask.grantor ne null }">
					 (委托)
				</c:if>
			</ec:column>
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<a href="<c:url value='${userTask.nodeOptUrl}' />" >办理</a>
					<a href="#" onclick="openNewWindow('<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${userTask.flowInstId}','powerWindow',null);">查看流程图</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
    <script type="text/javascript">
		function openNewWindow(winUrl,winName,winProps){
    		if(winProps =='' || winProps == null){
    			winProps = 'height=800px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
    		}
    		window.open(winUrl, winName, winProps);
    	}
    </script>
</html>

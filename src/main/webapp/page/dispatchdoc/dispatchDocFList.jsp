<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
		</title>
	</head>

	<body>
	<%@ include file="/page/common/messages.jsp"%>
<div class="search">
		<div class="crumbs">个人发文</div>
			
			<s:form action="dispatchDoc" namespace="/dispatchdoc" method="post">				
				<table cellpadding="0" cellspacing="0" align="left">
					<tr >
					    <td class="addTd">办件编号：</td>
						<td width="180"><s:textfield id="s_djId" name="s_djId" value="%{#parameters['s_djId']}" /> </td>
						<td class="addTd">办件名称：</td>
						<td width="180"><s:textfield id="s_transaffairname" name="s_transaffairname" value="%{#parameters['s_transaffairname']}" /></td>
						<td align="center"><s:submit method="list" key="opt.btn.query" cssClass="btn"/>&nbsp;</td>
					</tr>	
                 </table>
             </s:form>
          </div>
		<ec:table action="dispatchdoc/dispatchDoc!list.do" items="vDispatchDocList" var="vDispatchDoc"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="djId"  title="办件编号" style="text-align:center" />	
				<ec:column property="transaffairname" title="办件名称" style="text-align:center" />	
				
				<ec:column property="createdate" title="更新时间"
						style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" />

				<ec:column property="biztype" title="状态"
				style="text-align:center">
				<c:if test="${vDispatchDoc.biztype eq 'F' }">
					未提交
				</c:if>
				<c:if test="${vDispatchDoc.biztype ne 'F' }">
					办理中
				</c:if>
				</ec:column>
				
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:if test="${vDispatchDoc.biztype eq 'F' }">
						<a href="<%=request.getContextPath()%>/dispatchdoc/dispatchDoc!editDispatchDoc.do?djId=${vDispatchDoc.djId}&s_djId=${vDispatchDoc.djId}">编辑</a>
						<a href="<%=request.getContextPath()%>/dispatchdoc/dispatchDoc!delete.do?djId=${vDispatchDoc.djId}">删除</a>
					</c:if>
					<c:if test="${vDispatchDoc.biztype ne 'F' }">
						<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${vDispatchDoc.flowInstId}'>查看流程图</a>
					</c:if>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
	
	<script type="text/javascript">
	
			function replaceUrl(a) {
									
				var doOptUrl = a.href; 									
									
				doOptUrl = doOptUrl.replaceAll("amp%3B","");
			
				a.href=doOptUrl;
				
				return false;
			}
</script>

</html>

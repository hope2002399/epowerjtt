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
		<div class="crumbs">个人收文</div>
			<s:form action="incomeDoc" namespace="/dispatchdoc" method="post">				
				<table cellpadding="0" cellspacing="0" align="left">
					<tr>
					    <td class="addTd">办件编号：</td>
						<td width="180"><s:textfield id="s_djId" name="s_djId" value="%{#parameters['s_djId']}" /> </td>
						<td class="addTd">办件名称：</td>
						<td width="180"><s:textfield id="s_transaffairname" name="s_transaffairname" value="%{#parameters['s_transaffairname']}" /></td>
						<td align="center"><s:submit method="list" key="opt.btn.query" cssClass="btn"/>&nbsp;</td>
					</tr>	
                 </table>
             </s:form>
          </div>
		<ec:table action="dispatchdoc/incomeDoc!list.do" items="incomeDocList" var="incomeDoc"
				imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>

				<ec:column property="djId"  title="办件编号" style="text-align:center" />	
				<ec:column property="transaffairname" title="办件名称" style="text-align:center" />	
				
				<ec:column property="updateDate" title="更新时间"
						style="text-align:center" format="yyyy-MM-dd HH:mm" cell="date" />

				<ec:column property="biztype" title="状态"
				style="text-align:center">
				<c:if test="${incomeDoc.biztype eq 'F'}">
					未提交
				</c:if>
				<c:if test="${incomeDoc.biztype ne 'F' and incomeDoc.instState ne 'C'}">
					办理中
				</c:if>
				<c:if test="${incomeDoc.biztype ne 'F' and incomeDoc.instState eq 'C'}">
					已完成
				</c:if>
				</ec:column>
				
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:if test="${incomeDoc.biztype eq 'F' }">
						<a href="<%=request.getContextPath()%>/dispatchdoc/incomeDoc!edit.do?djId=${incomeDoc.djId}">编辑</a>
						<a href="<%=request.getContextPath()%>/dispatchdoc/incomeDoc!delete.do?djId=${incomeDoc.djId}">删除</a>
					</c:if>
					<c:if test="${incomeDoc.biztype ne 'F' }">
						<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${incomeDoc.flowInstId}'>查看流程图</a>
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

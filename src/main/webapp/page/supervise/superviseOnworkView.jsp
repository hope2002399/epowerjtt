<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title><s:text name="superviseOnwork.view.title" /></title>
<%-- <SCRIPT type="text/javascript" src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
 --%>
</head>

<body>
<!-- <p class="ctitle">督办基本信息</p> -->

<%@ include file="/page/common/messages.jsp"%>
<%-- <input type="button" value="返回" Class="btn" onclick="window.history.back()" />	
	<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>督办基本信息</b>
			</legend>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
	
  
				<tr>
					<td class="addTd">
						督察督办编号
					</td>
					<td align="left">
						<s:property value="%{object.superviseNo}" />
					</td>

					<td class="addTd">
						督办类型
					</td>
					<td align="left">
						${cp:MAPVALUE("DBTYPE",object.bjType)}
					</td>
				</tr>

				<tr>
					<td class="addTd">
						办件名称 
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.bjname}" />
					</td>
				</tr>	
			<tr>
					<td class="addTd">
						办件编号
					</td>
					<td align="left">
						<s:property value="%{object.internalNo}" />
					</td>
				
					<td class="addTd">
						办件流水号
					</td>
					<td align="left">
						<s:property value="%{object.bjNo}" />
					</td>
				</tr>	
<c:if test="${object.bjType=='3'}">
				<tr>
					<td class="addTd">
						投诉编号
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.complaintid}" />
					</td>
				</tr>	
</c:if>
<c:if test="${object.bjType=='4'}">
				<tr>
					<td class="addTd">
						报警流水号
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.outwayid}" />
					</td>
				</tr>	
</c:if>
				<tr>
					<td class="addTd">
					督办发起部门 
					</td>
					<td align="left">
						${cp:MAPVALUE("unitCode",object.orgId)}
					</td>				
					<td class="addTd">
						督办发起人
					</td>
					<td align="left">
					${cp:MAPVALUE("userCode",object.operatorId)}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
					发起督办时间
					</td>
					<td align="left">
					<s:date name="object.superviseDate" format="yyyy-MM-dd HH:mm"/>
					</td>
				
					<td class="addTd">
						督办反馈时限
					</td>
					<td align="left">
					<s:date name="object.promiseDate" format="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						被督办部门
					</td>
					<td align="left">
					${cp:MAPVALUE("unitCode",object.monitorOrgId)}
					</td>
					<td class="addTd">
					被督办人员
					</td>
					<td align="left">
					${cp:MAPVALUE("userCode",object.monitorOperatorId)}
					</td>
				</tr>	
<tr>
					<td class="addTd">
						督办建议
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.superviseOption}" />
					</td>
				</tr>
	</table>
	</fieldset> --%>
	
	<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>督办过程信息</b>
			</legend>				
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
				<tr>
					<td class="addTd">
						督办过程编号
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.processno}" />
					</td>				
					<!--<td class="addTd">
						督办过程名称
					</td>
					<td align="left">
						<s:property value="%{object.processName}" />
					</td>
					!-->
				</tr>	

				<tr>
					<td class="addTd">
						督办过程处理时间
					</td>
					<td align="left">
					<s:date name="object.processDate" format="yyyy-MM-dd HH:mm"/>
					</td>			
					<td class="addTd">
					督办过程处理人员
					</td>
					<td align="left">
					${cp:MAPVALUE("userCode",object.processOperatorId)}
					</td>
				</tr>	
<!-- 
				<tr>
					<td class="addTd">
						督办过程处理结果
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.operatorResult}" />
					</td>
				</tr>	
 -->
				<tr>
					<td class="addTd">
						督办过程反馈意见
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.operatorOpinion}" />
					</td>
				</tr>	


</table>

</fieldset>
<%-- <div id="myDiv" class="tt" style="display: none">
		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div> --%>
</body>
</html>

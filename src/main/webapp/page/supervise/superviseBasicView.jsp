<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<SCRIPT type="text/javascript" src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
<title>督办详细查看</title>
</head>
<body>
<div id="myDiv" class="tt" style="display: none">
		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
<p class="ctitle">督办详细查看</p>

<%@ include file="/page/common/messages.jsp"%>

<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
<c:if test="${not empty object.apply.no or not empty object.punish.no}">			
			<p align="center" style="font-size: 20; color: #01A6E0;">关于对<c:if test="${object.bjType=='1' or ((object.bjType=='3' or object.bjType=='7') and not empty object.apply.no)}">${object.apply.transactAffairName}办件</c:if><c:if test="${object.bjType=='2' or ((object.bjType=='3' or object.bjType=='7') and not empty object.punish.no)}">${object.punish.content}处罚</c:if>的督办		
			</p>
			</c:if>
		<!--  <fieldset style="display: block; padding: 10px;">
			<legend>
				<b>督办详细查看</b>
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
					${cp:MAPVALUE("DBTYPE",object.bjType)}</td>					
				</tr>	

				<tr>
					<td class="addTd">
						办件流水号
					</td>
					<td align="left">
						<s:property value="%{object.bjNo}" />
					</td>
			
					<td class="addTd">
						投诉编号
					</td>
					<td align="left">
						<s:property value="%{object.complaintid}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						报警流水号
					</td>
					<td align="left">
						<s:property value="%{object.outwayid}" />
					</td>
				
					<td class="addTd">
						督办发起部门
					</td>
					<td align="left">
						${cp:MAPVALUE("unitCode",object.orgId)}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						督办发起人姓名
					</td>
					<td align="left">
						<s:property value="%{object.operatorName}" />
					</td>
				
					<td class="addTd">
						督办发起人id
					</td>
					<td align="left">
						<s:property value="%{object.operatorId}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						发起督办时间
					</td>
					<td align="left">
						<s:date name="superviseDate" format="yyyy-MM-dd HH:mm"/>
					</td>
				
					<td class="addTd">
						被督办部门编码
					</td>
					<td align="left">
						<s:property value="%{object.monitorOrgId}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						被督办部门名称
					</td>
					<td align="left">
						<s:property value="%{object.monitorOrgName}" />
					</td>
				
					<td class="addTd">
						被督办人员编码
					</td>
					<td align="left">
						<s:property value="%{object.monitorOperatorId}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						被督办人员名称
					</td>
					<td align="left">
						<s:property value="%{object.monitorOperatorName}" />
					</td>
			
					<td class="addTd">
						督办建议
					</td>
					<td align="left">
						<s:property value="%{object.superviseOption}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd">
					督办反馈时限
					</td>
					<td align="left">
						<s:date name="promiseDate" format="yyyy-MM-dd HH:mm"/>
					</td>
				
					<td class="addTd">
						信息更新时间
					</td>
					<td align="left">
					<s:date name="updateDate" format="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>	
</table>
</fieldset>-->
<iframe id="viewFrame" name="viewFrame" src="<%=request.getContextPath()%>/supervise/superviseBasic!viewFrame.do?superviseNo=${object.superviseNo}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>
<!-- 督办工作 流中过程信息-->
<c:if test="${isworkflowFlag !='F'}">
<iframe id="processFrame" name="processFrame" src="<%=request.getContextPath()%>/supervise/superviseReply!viewList.do?superviseNo=${object.superviseNo}&flowInstId=${object.flowInstId}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['processFrame'].document.body.scrollHeight"></iframe>

<iframe id="staffFrame" name="staffFrame" src="<%=request.getContextPath()%>/powerruntime/generalOperator!listStuffs.do?djId=${object.superviseNo}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['staffFrame'].document.body.scrollHeight"></iframe>
</c:if>


<!-- 督办过程信息 --无工作流-->
<c:if test="${isworkflowFlag=='F'}">
<iframe id="processFrame1" name="processFrame1" src="<%=request.getContextPath()%>/supervise/superviseOnwork!view.do?superviseNo=${object.superviseNo}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['processFrame1'].document.body.scrollHeight"></iframe>
</c:if>


</body>

	<%-- <%@ include file="/page/common/scripts.jsp"%> --%>
</html>

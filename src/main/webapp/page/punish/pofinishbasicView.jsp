<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><c:out value="pofinishbasic.view.title" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	<fieldset style=" display: block; padding: 10px;">
			<legend>
			<b>
				执行情况与结案
				</b>
			</legend>
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
  
				<tr>
					<td class="addTd" width="130">
						最终认定的违法事实
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.confirmtruth}" />
					</td>
				</tr>	


				<tr>
					<td class="addTd" width="130">
						违法条款
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.disobeyitem}" />
					</td>
				</tr>	

			

				<tr>
					<td class="addTd" width="130">
						处罚结果
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.podiscussresult}" />
					</td>
				</tr>	
				<%-- 	<tr>
					<td class="addTd">结案类型</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("finishType",object.finishType)}
					</td>				
				</tr> --%>
	<tr>
					<td class="addTd" width="130">
						案件履行情况
					</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("OtherPunish",object.otherpunish)}
					</td>
				</tr>
				<c:if test="${ not empty object.punishaffixname }">
				<tr>
					<td class="addTd" width="130">
						缴费通知单编号
					</td>
					<td align="left">
						<c:out value="${object.punishaffixcode}" />
					</td>			
					<td class="addTd" width="130">
						缴费单据文件名
					</td>
					<td align="left">
						<a  style="text-decoration:underline" href="<%=request.getContextPath()%>/punish/pofinishbasic!downloadstuff.do?object.punishobjectid=${object.punishobjectid}"><c:out value="${object.punishaffixname}" /></a>
					</td>
				</tr>	
				</c:if>
				<c:if test="${object.punishamout >0}">
				<tr>
					<td class="addTd" width="130">
						实际罚款金额
					</td>
					<td align="left">
						<c:out value="${object.punishamout}" />元
					</td>
					<td class="addTd" width="130">
						实际处罚人数
					</td>
					<td align="left">
						<c:out value="${object.punishamoutpeople}" />人
					</td>
				</tr>
				</c:if>
			<c:if test="${object.punishseizure != -1}">
				<tr>
					<td class="addTd" width="130">
						实际没收件数
					</td>
					<td align="left">
						<c:out value="${object.punishseizure}" />件
					</td>			
					<td class="addTd" width="130">
						实际没收价值
					</td>
					<td align="left">
						<c:out value="${object.punishseizurevalue}" />
					</td>
				</tr>	
</c:if>
			
<c:if test="${object.punishdetention != -1}">
				<tr>
					<td class="addTd" width="130">
						实际拘留人数
					</td>
					<td align="left">
						<c:out value="${object.punishdetentionpeople}" />人
					</td>			
					<td class="addTd" width="130">
						实际拘留天数
					</td>
					<td align="left">
						<c:out value="${object.punishdetention}" />天
					</td>
				</tr>
				</c:if>	
				<c:if test="${object.punishshoutont != -1}">
	<tr>
					<td class="addTd" width="130">
					实际停业天数
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.punishshoutont}" />天
					</td>
				</tr>	
				</c:if>
				<tr>
					<td class="addTd" width="130">
						是否结案
					</td>
					<td align="left" colspan="3">
					<c:if test="${object.isfinish==1}">已结案</c:if>
					<c:if test="${object.isfinish !=1}">未结案</c:if>
					</td>
				</tr>	

                <c:if test="${not empty object.jbroptionja}">
				<tr>				
				<td class="addTd" width="130">
						经办人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.jbroptionja}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.jbrja}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.jbroptionjatime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
			<c:if test="${ not empty object.ksoptionja}">
				<tr>
				<td class="addTd" width="130">
						科室意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.ksoptionja}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.ksja}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.ksoptionjatime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
				<c:if test="${ not empty object.fzroptionja}">
				<tr>
				<td class="addTd" width="130">
						部门负责人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.fzroptionja}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.fzrja}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.fzroptionjatime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
				<tr rowspan="${fn:length(optStuffs)}">
	<td class="addTd" width="130">
			环节格式文书
	</td>
	<td align="left" colspan="3">
<c:forEach var="stfobj" items="${optStuffs}">
<a  style="text-decoration:underline;color: blue;" href="<%=request.getContextPath()%>/powerruntime/generalOperator!downStuffInfo.do?stuffid=${stfobj.stuffid}&netid=${stfobj.netId}">${stfobj.filename}</a>&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
	</td>
</tr>
</table>

</fieldset>

</body>
</html>

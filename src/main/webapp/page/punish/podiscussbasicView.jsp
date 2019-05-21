<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>		
<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>
				<c:if test="${object.podiscusstype==1}">案件讨论</c:if>
				<c:if test="${object.podiscusstype==2}">二次讨论</c:if>
				</b>
			</legend>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">	
<tr>
					<td class="addTd" width="130">
						案件讨论地点
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.podiscussadress}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						案件讨论开始时间
					</td>
					<td align="left">
					<s:date name="podiscussbegintime" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td class="addTd" width="130">
						案件讨论结束时间
					</td>
					<td align="left">
						<s:date name="podiscussendtime" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						主持人 
					</td>
					<td align="left">
						<c:out value="${object.podiscussemcee}" />
					</td>
				
					<td class="addTd" width="130">
						记录人 
					</td>
					<td align="left">
						<c:out value="${object.podiscussnoter}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						参加人员
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.podiscussattendname}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						列席人员
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.podiscussattendeename}" />
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
						认定违法事实
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.confirmtruth}" />
					</td>
				</tr>			

				<tr>
					<td class="addTd" width="130">
						处罚结论
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.podiscussresult}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						讨论记录
					</td>
					<td align="left" colspan="3">
					<a  href="<%=request.getContextPath()%>/punish/podiscussbasic!downloaddiscussstuff.do?object.punishobjectid=${object.punishobjectid}&object.podiscusstype=${object.podiscusstype}"><span style="text-decoration:underline;color: blue"><c:out value="${object.podiscussaffixname}" /></span></a>
						<a href=>
					</td>
				</tr>
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

<fieldset style="padding:10px;display:block;margin-bottom:10px;">
   <legend style="padding:4px 8px 3px;"><b><c:if test="${object.podiscusstype==1}">行政处罚预先告知书回执信息</c:if><c:if test="${object.podiscusstype==2}">行政处罚告知书回执信息</c:if></b></legend>
         <iframe id="itemFrame" src="../punish/poreceiptinfo!view.do?punishobjectid=${object.punishobjectid}&poreceiptstate=${object.podiscusstype}" frameborder="0" width="100%" scrolling="no"
        onload="this.height=window.frames['itemFrame'].document.body.scrollHeight">

         </iframe>
 </fieldset>

</body>
</html>

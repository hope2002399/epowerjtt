<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="srPermitApply.view.title" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>

<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
<fieldset style="display: block; padding: 10px; margin-bottom: 10px;">
		<legend>
			<b>基本信息</b>
		</legend>
	
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	 				
				<tr>
					<td class="addTd">
						办件名称
					</td>
					<td align="left" colspan="3">
						${object.transactAffairName}
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请事项
					</td>
					<td align="left" colspan="3">
						${object.content}
					</td>
				</tr>	
				<tr>
					<td class="addTd">
						业务处室
					</td>
					<td align="left" colspan="3">
						${object.department}
					</td>
				</tr>	
				<tr>
					<td class="addTd" style="width:15%">
						申请者
					</td>
					<td align="left" style="width:35%">
						${object.applicantName}
					</td>
					<td class="addTd" style="width:15%">
						申请日期
					</td>
					<td align="left" style="width:35%">
						<fmt:formatDate value="${object.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>				
				</tr>	
				<tr>
					<td class="addTd">
						申请方式
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("bjsqfs", object.applyWay)}
					</td>
				
					<td class="addTd">
						申请者类别 
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("PROPOSER_TYPE", object.applicantType)}
					</td>
				</tr>	
				<tr>
					<td class="addTd">
						申请者证件类型
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("PaperType", object.applicantPaperType)}
					</td>
					<td class="addTd">
						申请者证件号码
					</td>
					<td align="left">
						${object.applicantPaperCode}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者电话
					</td>
					<td align="left">
						${object.applicantPhone}
					</td>
					<td class="addTd">
						申请者手机
					</td>
					<td align="left">
						${object.applicantMobile}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者地址
					</td>
					<td align="left" colspan="3">
						${object.applicantAddress}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者邮编
					</td>
					<td align="left">
						${object.applicantZipcode}
					</td>
					<td class="addTd">
						申请者电子邮箱
					</td>
					<td align="left">
						${object.applicantEmail}
					</td>
				</tr>

				<tr>
					<td class="addTd">
						申请者机构代码
					</td>
					<td align="left">
						${object.applicantCode}
					</td>
					<td class="addTd">
						代理人姓名
					</td>
					<td align="left">
						${object.linkmanName}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人证件类型
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("PaperType", object.linkmanPaperType)}
					</td>
					<td class="addTd">
						代理人证件号码
					</td>
					<td align="left">
						${object.linkmanPaperCode}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人电话
					</td>
					<td align="left">
						${object.linkmanPhone}
					</td>
					<td class="addTd">
						代理人手机
					</td>
					<td align="left">
						${object.linkmanMobile}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人地址 
					</td>
					<td align="left" colspan="3">
						${object.linkmanAddress}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人邮编
					</td>
					<td align="left">
						${object.linkmanZipcode}
					</td>
					<td class="addTd">
						代理人电子邮箱
					</td>
					<td align="left">
						${object.linkmanEmail}
					</td>
				</tr>	
				<tr>
					<td class="addTd" style="width:15%">
						办结状态
					</td>
					<td align="left" style="width:35%">
						<c:if test="${object.status==1}">不予受理</c:if>
						<c:if test="${object.status==2}">许可</c:if>
						<c:if test="${object.status==3}">不许可</c:if>
					</td>
					<td class="addTd" style="width:15%">
						办结日期
					</td>
					<td align="left" style="width:35%">
						<fmt:formatDate value="${object.finishTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>				
				</tr>	
				<tr>
					<td class="addTd">
						办结意见
					</td>
					<td align="left" colspan="3">
						${object.note}
					</td>
				</tr>
</table>
</fieldset>

<fieldset style="display: block; padding: 10px; margin-bottom: 10px;">
		<legend>
			<b>过程信息</b>
		</legend>
		<ec:table action="powerruntime/optApplyResult!view.do" items="processList" var="optIdeaInfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false" >
			<ec:row>
				<ec:column property="tacheName" title="环节名称" style="text-align:center" sortable="false"/>
				<ec:column property="department" title="部门名称" style="text-align:center" sortable="false"/>
				<ec:column property="userName" title="办理人员姓名" style="text-align:center" sortable="false" />
				<ec:column property="processDate" title="办理时间" style="text-align:center" sortable="false">
				<fmt:formatDate value="${optIdeaInfo.processDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="note" title="办理意见" style="text-align:center" sortable="false"/>

			</ec:row>
		</ec:table>
</fieldset>
</body>
</html>

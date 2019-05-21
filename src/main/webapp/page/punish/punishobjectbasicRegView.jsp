<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
</head>

<body>
<input type="button"  value="返回" Class="btn" onclick="window.history.back()" />
<fieldset style=" display: block; padding: 10px;">
			<legend>
				案件业务信息
			</legend>
			
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">		
  
				<tr>
					<td class="addTd" width="130">
						案件流水号
					</td>
					<td align="left">
						<s:property value="%{object.punishobjectid}" />
					</td>
					<!--  
					<td class="addTd" width="130">
						案件编号
					</td>
					<td align="left">
						<s:property value="%{object.punishobjectno}" />
					</td>
					-->				
			
					<td class="addTd" width="130">
						案件性质
					</td>
					<td align="left">
					 <c:if test="${'0' eq  object.punishobjecttype}">一般流程</c:if>
					 <c:if test="${'1' eq  object.punishobjecttype}">现场流程</c:if>
					</td>
				
				</tr>	
				<tr>
                    <td class="addTd" width="130">
						案件来源种类
					</td>
					<td align="left">
				    ${cp:MAPVALUE("CASEORIGN",object.pooriginstate)}
					</td>
					<td class="addTd" width="130">
						当事人机构性质
					</td>
					<td align="left">
					    <c:if test="${object.pooccurstate=='0'}">个人</c:if>
					    <c:if test="${object.pooccurstate=='1'}">组织机构</c:if>
					</td>
				</tr>	

				


					<tr>
					<td class="addTd" width="130">
						案发地点
					</td>
					<td align="left">
						<s:property value="%{object.pooccuradress}" />
					</td>
					<td class="addTd" width="130">
						案发时间
					</td>
					<td align="left">
						<s:date name="object.pooccurdate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>	
<tr>
					<td class="addTd" width="130">
						案件登记部门
					</td>
					<td align="left">
						 ${cp:MAPVALUE("unitcode",object.managedepid)}
					</td>
				<td class="addTd" width="130">
						登记日期
					</td>
					<td align="left">				
						<s:date name="object.poregistedate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				
				</tr>	
				<tr>
					<td class="addTd" width="130">
						登记人员
					</td>
					<td align="left">
						 ${cp:MAPVALUE("usercode",object.operatorid)}
					</td>
					<td class="addTd" width="130">
						登记人员意见
					</td>
					<td align="left">
						<s:property value="%{object.poregisteropinion}" />
					</td>
				
				</tr>	

				<tr>
					<td class="addTd" width="130">
						案件来源描述
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.poorigincontext}" />
					</td>
					
				</tr>	

				<tr>				
					<td class="addTd" width="130">
						来源备注
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.remark}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						办件状态
					</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("xk_Status",object.biztype)}
					</td>
				</tr>
					
            <c:if test="${object.pooriginstate=='0001000070' }">
            <tr>
					<td class="addTd" width="130">
						举报人姓名
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachname}" />
					</td>
						<td class="addTd" width="130">
						举报人身份证号码
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachid}" />
					</td>
					</tr>
			<tr>
					<td class="addTd" width="130">
						举报人性质
					</td>
					<td align="left">
						<c:if test="${object.poimpeachstate=='0'}">个人</c:if>
					    <c:if test="${object.poimpeachstate=='1'}">组织机构</c:if>
						<c:if test="${object.poimpeachstate=='2'}">无举报人</c:if>
					</td>
	
	
					<td class="addTd" width="130">
						举报人性别
					</td>
					<td align="left">
					${cp:MAPVALUE("sex",object.pocaseimpeachsex)}
					</td>
					<tr>
					<td class="addTd" width="130">
						举报人邮编
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachpostcode}" />
					</td>
			
					<td class="addTd" width="130">
						举报人联系电话
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachphone}" />
					</td>
				<tr>
					<td class="addTd" width="130">
						举报人工作单位
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachunit}" />
					</td>
					<td class="addTd" width="130">
						举报人年龄
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachage}" />
					</td>
<tr>
				
					<td class="addTd" width="130">
						举报人地址
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.pocaseimpeachadress}" />
					</td>
				</tr>	
			
</c:if>
<!-- 
	<tr>
									<td class="addTd" width="130">
						案由
					</td>
					<td colspan="3">
						<s:property value="%{object.punishobjectbrief}"  />
					</td>
					</tr>
					 -->
			<c:if test="${ not empty object.riskresult }">
				<tr>
					<td class="addTd" width="130">
						风险点描述
					</td>
					<td align="left">
						<s:property value="%{object.riskdesc}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						风险点类别
					</td>
					<td align="left">
						<s:property value="%{object.risktype}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						风险内控的手段与结果
					</td>
					<td align="left">
						<s:property value="%{object.riskresult}" />
					</td>
				</tr>	
</c:if>

</table>
</fieldset>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>
<html>
<head>
<title><s:text name="srPermitApply.view.title" /></title>
</head>

<body>
<p class="ctitle">办件信息查看</p>

<%@ include file="/page/common/messages.jsp"%>

<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
<fieldset style="display: block; padding: 10px; margin-bottom: 10px;">
		<legend>
			<b>办件信息</b>
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">办件名称</td>
				<td align="left"><!-- <input type="hidden" id="transaffairname"
					name="optBaseInfo.transaffairname"> -->${obin.transaffairname}</td>
			</tr>
			<tr>
				<td class="addTd">权力事项</td>
				<td align="left"><!-- <input type="hidden" id="powername"
					name="optBaseInfo.powername"> -->
					${obin.powername}</td>
			</tr>
			<tr>
				<td class="addTd">
						权力类型
					</td>
					<td align="left">
					${cp:MAPVALUE("ITEM_TYPE",object.applyItemType)}
						<%-- <s:textfield name="applyItem"  value="%{object.applyItem}" readonly="true" /> --%>
					</td>
			</tr>
			<tr>
				<td class="addTd">办理单位</td>
				<td align="left"><!-- <input type="hidden"
					name="optBaseInfo.orgcode"> --> ${obin.orgname}</td>
			</tr>
			<tr>
				<td class="addTd">办件摘要</td>
				<td align="left">${obin.content}</td>
			</tr>
		</table>
	</fieldset>
	<c:if test="${jsonxml != null }">
<fieldset>
	<legend>自定义表单</legend>
					<%
						JSONArray jsonArray = (JSONArray) request.getAttribute("jsonxml");
 							if(jsonArray != null && jsonArray.size()>0){
							for (int j = 0; j < jsonArray.size(); j++) {
								JSONObject jsonObject = (JSONObject)jsonArray.get(j);
								if(j == 0){
						%>
					<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
					<%
						}else{
					%>
					<tr>
						<td class="addTd"><%=jsonObject.getString("name")%></td>
						<td align="left"><%=jsonObject.getString("valueName")!=null && !"".equals(jsonObject.getString("valueName"))
						?jsonObject.getString("valueName"):jsonObject.getString("value")%></td>
					</tr>
				<%}}}%>
				</table>
</fieldset>
</c:if>
	<fieldset style=" display: block; padding: 10px;">
	<legend><b>申请信息</b></legend>
	<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
				<tr>
					<td class="addTd" width="130">
						申请方式
					</td>
					<td width="37%">
					<s:label></s:label>
					${cp:MAPVALUE("bjsqfs",object.applyWay) }
					<%-- 	<s:textfield name="applyWay" value="%{object.applyWay}"  readonly="true" /> --%>
					</td>
					<td class="addTd" width="130">
						申请日期
					</td>
					<td align="left">
					<%-- ${object.applyDate } --%>
					<fmt:formatDate value="${object.applyDate }" type="both"/>  

					
						<%-- <s:textarea name="applyReason" value="%{object.applyReason}" readonly="true" cssStyle="width:100%;height:40px;" /> --%>
					</td>
				</tr>
				<tr>
				<td class="addTd" width="130">
						申请原因
					</td>
					<td align="left" colspan="3">
					${object.applyReason }
						<%-- <s:textarea name="applyReason" value="%{object.applyReason}" readonly="true" cssStyle="width:100%;height:40px;" /> --%>
					</td>
				</tr>
				<tr>
					
					<td class="addTd">
						申请者名称
					</td>
					<td align="left">
					${object.proposerName}
						<%-- <s:textfield name="proposerName"  value="%{object.proposerName}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						申请者类别
					</td>
					<td align="left">
					
					${cp:MAPVALUE("PROPOSER_TYPE",object.proposerType) }
						<%-- <s:textfield name="applyItem"  value="%{object.applyItem}" readonly="true" /> --%>
					</td>
				</tr>

				
				<tr>
					
					<td class="addTd">
						申请者证件类型
					</td>
					<td align="left">
					<c:if test="${(object.proposerType eq '1')}">
					${cp:MAPVALUE("PaperType_unit",object.proposerPaperType) }
					</c:if>
					<c:if test="${(object.proposerType eq '0')}">
					${cp:MAPVALUE("PaperType",object.proposerPaperType) }
					</c:if>
					<c:if test="${(object.proposerType eq '2')}">
					${cp:MAPVALUE("PaperType",object.proposerPaperType) }
					</c:if>
						<%-- <s:textfield name="proposerPaperType" value="%{object.proposerPaperType}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						申请者证件号码
					</td>
					<td align="left">
					${object.proposerPaperCode }
						<%-- <s:textfield name="proposerPaperCode" value="%{object.proposerPaperCode}" readonly="true" /> --%>
					</td>
				</tr>
				<tr>
					
					<td class="addTd">
						申请者固定电话
					</td>
					<td align="left">
					${object.proposerPhone }
						<%-- <s:textfield name="proposerPhone" value="%{object.proposerPhone}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						申请者移动电话
					</td>
					<td align="left">
					${object.proposerMobile }
						<%-- <s:textfield name="proposerMobile" value="%{object.proposerMobile}" readonly="true" /> --%>
					</td>
				</tr>
				<tr>
					
					<td class="addTd">
						申请者电子邮箱
					</td>
					<td align="left">
					${object.proposerEmail }
						<%-- <s:textfield name="proposerEmail" value="%{object.proposerEmail}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						申请者邮编
					</td>
					<td align="left">
					${object.proposerZipcode }
						<%-- <s:textfield name="proposerZipcode" value="%{object.proposerZipcode}" readonly="true" /> --%>
					
					</td>
				</tr>
				<c:if test="${!(object.proposerType eq '0')}">
				<tr>
				<td class="addTd">
						申请者组织机构代码
					</td>
					<td align="left">
					${object.proposerUnitcode }
						<%-- <s:textfield name="proposerUnitcode"  value="%{object.proposerUnitcode}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						法定代表人/负责人
					</td>
					<td align="left">
					${object.legal_person }
						<%-- <s:textfield name="proposerUnitcode"  value="%{object.proposerUnitcode}" readonly="true" /> --%>
					</td>
					</tr>
				</c:if>	
				<tr>
					<td class="addTd">
						申请者地址
					</td>
					<td align="left" colspan="3">
					${object.proposerAddr }
						<%-- <s:textfield name="proposerAddr" value="%{object.proposerAddr}" readonly="true" /> --%>
					</td>
					
				</tr>
				<tr>
					
					<td class="addTd">
						<s:text name="trPermitApply.agentName"  />
					</td>
					<td align="left" colspan="3">
					${object.agentName}
						<%-- <s:textfield name="agentName" value="%{object.agentName}" readonly="true" /> --%>
					</td>
				<%-- 	<td class="addTd">
					代理人机构代码
						<s:text name="trPermitApply.agentName"  />
					</td>
					<td align="left">
					${object.agentUnitcode}
						<s:textfield name="agentName" value="%{object.agentName}" readonly="true" />
					</td> --%>
				</tr>
				<tr>
					<td class="addTd">
						<s:text name="trPermitApply.agentPaperType"  />
					</td>
					<td align="left">
					
					${cp:MAPVALUE("PaperType",object.agentPaperType) }
						<%-- <s:textfield name="agentPaperType" value="%{object.agentPaperType}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentPaperCode"  />
					</td>
					<td align="left">
					${object.agentPaperCode}
						<%-- <s:textfield name="agentPaperCode" value="%{object.agentPaperCode}" readonly="true" /> --%>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<s:text name="trPermitApply.agentPhone"   />
					</td>
					<td align="left">
					${object.agentPhone}
						<%-- <s:textfield name="agentPhone" value="%{object.agentPhone}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentMobile"  />
					</td>
					<td align="left">
					${object.agentMobile}
						<%-- <s:textfield name="agentMobile" value="%{object.agentMobile}" readonly="true" /> --%>
					</td>
				</tr>

				<tr>
					
					<td class="addTd">
						<s:text name="trPermitApply.agentEmail"  />
					</td>
					<td align="left">
					${object.agentEmail}
						<%-- <s:textfield name="agentEmail" value="%{object.agentEmail}" readonly="true" /> --%>
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentZipcode" />
					</td>
					<td align="left">
					${object.agentZipcode}
						<%-- <s:textfield name="agentZipcode" value="%{object.agentZipcode}" readonly="true" /> --%>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<s:text name="trPermitApply.agentAddr" />
					</td>
					<td align="left" colspan="3">
					${object.agentAddr}
						<%-- <s:textfield name="agentAddr" value="%{object.agentAddr}" readonly="true" /> --%>
					</td>
					
				</tr>
				<tr>
					<td class="addTd">
						申请备注
					</td>
					<td align="left" colspan="3">
					${object.applyMemo}
						<%-- <s:textarea name="applyMemo" value="%{object.applyMemo}" readonly="true"  cssStyle="width:100%;height:40px;" /> --%>
					</td>
				</tr>
		
</table>
</fieldset>
<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>审查结果</b>
			</legend>
	<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<c:if test="${obin.bizstate == null ||obin.bizstate=='F' }">
	<tr>
					<td  align="center">
					预受理尚未审核
					</td>
				</tr>
	</c:if>	
	<c:if test="${obin.bizstate != null && obin.bizstate=='W' }">
				
  				<tr>
					<td  align="center" colspan="2">
					预受理不予受理(已删除)
					</td>
				</tr>	
				<tr>
					<td class="addTd" >
					办理意见：
					</td>
					<td  align="center" >
					${obin.yslblyj }
					</td>
				</tr>
  </c:if>
  	<c:if test="${obin.bizstate != null && obin.bizstate=='T' }">
  	<tr>
					<td  colspan="2" align="center">
					预受理已受理
					</td>
				</tr>	
  				<tr>
					<td class="addTd" >
						内网受理编号
					</td>
					<td align="center" >
					<a style="text-decoration: none; color: blue;" href="powerruntime/optApply!generalOptView.do?djId=${obin.djId }" target="_blank">${obin.djId }</a>	
					</td>				
				
				</tr>	
				<tr>
					<td  class="addTd" >
					办理意见：
					</td>
					<td  align="center">
					${obin.yslblyj }
					</td>
				</tr>
  </c:if>

</table>		
			
			
			
</fieldset>
</body>
</html>

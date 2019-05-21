<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="trPermitApply.edit.title" /></title>
<sj:head locale="zh_CN" />
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<s:form action="trPermitApply" method="post" namespace="/dofc" id="trPermitApplyForm" >
	<s:submit name="save"  method="savePermitReg" cssClass="btn" key="opt.btn.save" />
		<s:submit name="saveAndSubmit"  method="saveAndSubmitPermit" cssClass="btn" value="保存并提交"/>
		<input name="optId" type="hidden" value="XZXKTEST"/>
	<!--<input type="button" value="返回" class="btn"  onclick="window.history.go(-1)"/>
	--><%@ include file="/page/powerruntime/optcommon/optBaseInfoForm.jsp"%>	
	<fieldset style="padding:10px;display:block;margin-bottom:10px;">
	<legend style="padding:4px 8px 3px;"><b>申请信息</b></legend>
	<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
				<tr>
					<td class="addTd" width="130">
						申请方式
					</td>
					<td align="left" width="38%">
						<select name="applyWay" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('bjsqfs')}">
									<option value="${row.key}" <c:if test="${object.applyWay eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
					<td class="addTd" width="130">
						申请原因
					</td>
					<td align="left">
						<s:textarea name="applyReason" style="width:100%;height:40px;" value="%{object.applyReason}"/>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						申请事项
					</td>
					<td align="left">
						<s:textfield name="applyItem"   value="%{object.applyItem}"/>
					</td>
					<td class="addTd">
						申请者姓名
					</td>
					<td align="left">
						<s:textfield name="proposerName"   value="%{object.proposerName}"/>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						申请日期
					</td>
					<td align="left">
						<sj:datepicker id="applyDate" value="%{object.applyDate}"
							name="applyDate"  style="width:130px"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
					<td class="addTd">
						申请者类别
					</td>
					<td align="left">
					<select name="proposerType" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PROPOSER_TYPE')}">
									<option value="${row.key}" <c:if test="${object.proposerType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请者所在单位
					</td>
					<td align="left">
							<select name="proposerUnitcode" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:LVB('unitcode')}">
									<option value="${row.value}"  <c:if test="${object.proposerUnitcode==row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
									</option>
								</c:forEach>
							</select>
					</td>
					<td class="addTd">
						申请者证件类型
					</td>
					<td align="left">
						<select name="proposerPaperType" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PaperType')}">
									<option value="${row.key}" <c:if test="${object.proposerPaperType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请者证件号码
					</td>
					<td align="left">
						<s:textfield name="proposerPaperCode"   value="%{object.proposerPaperCode}"/>
					</td>
					<td class="addTd">
						申请者电话
					</td>
					<td align="left">
						<s:textfield name="proposerPhone" value="%{object.proposerPhone}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请者手机
					</td>
					<td align="left">
						<s:textfield name="proposerMobile" value="%{object.proposerMobile}" />
					</td>
					<td class="addTd">
						申请者电子邮箱
					</td>
					<td align="left">
						<s:textfield name="proposerEmail" value="%{object.proposerEmail}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请者地址
					</td>
					<td align="left">
						<s:textfield name="proposerAddr" value="%{object.proposerAddr}" />
					</td>
					<td class="addTd">
						申请者邮编
					</td>
					<td align="left">
						<s:textfield name="proposerZipcode" value="%{object.proposerZipcode}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请备注
					</td>
					<td align="left">
						<s:textarea name="applyMemo" value="%{object.applyMemo}" style="width:100%;height:40px;"/>
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentName" />
					</td>
					<td align="left">
						<s:textfield name="agentName" value="%{object.agentName}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<s:text name="trPermitApply.agentPaperType" />
					</td>
					<td align="left">
						<select name="agentPaperType" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PaperType')}">
									<option value="${row.key}" <c:if test="${object.agentPaperType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentPaperCode" />
					</td>
					<td align="left">
						<s:textfield name="agentPaperCode" value="%{object.agentPaperCode}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						代理人所在单位
					</td>
					<td align="left">
						<s:textfield name="agentUnitcode" value="%{object.agentUnitcode}" />
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentMobile" />
					</td>
					<td align="left">
						<s:textfield name="agentMobile" value="%{object.agentMobile}" />
					</td>
				</tr>

				<tr>
					<td class="addTd">
						<s:text name="trPermitApply.agentPhone" />
					</td>
					<td align="left">
						<s:textfield name="agentPhone" value="%{object.agentPhone}" />
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentEmail" />
					</td>
					<td align="left">
						<s:textfield name="agentEmail" value="%{object.agentEmail}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<s:text name="trPermitApply.agentAddr" />
					</td>
					<td align="left">
						<s:textfield name="agentAddr" value="%{object.agentAddr}" />
					</td>
					<td class="addTd">
						<s:text name="trPermitApply.agentZipcode" />
					</td>
					<td align="left">
						<s:textfield name="agentZipcode" value="%{object.agentZipcode}" />
					</td>
				</tr>
		</fieldset>
</table>


</s:form>

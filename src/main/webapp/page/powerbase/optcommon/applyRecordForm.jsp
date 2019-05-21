<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
<head>
		<title>办件备案</title>
		<script src="<s:url value='/scripts/centit_validator.js'/>" type="text/javascript" ></script>	
</head>
<body>
	<div class="two">
			<fieldset>
				<legend>
					办件基本信息
				</legend>
				<table cellpadding="0" cellspacing="0" align="center" class="viewTable">
					<tr height="20">
						<td class="addTd" width="15%">
							办件编号
						</td>
						<td colspan="3">
							<%-- <s:property value="internalNo"/> --%>
							${info.internalNo}
						</td>
					</tr>
					<tr height="20">
						<td class="addTd" width="15%">
							权力编码
						</td>
						<td colspan="3">
							<%-- <s:property value="itemId"/> --%>
							${info.itemId}
						</td>
					</tr>
					<tr height="20">
						<td class="addTd" width="15%">
							权力名称
						</td>
						<td colspan="3">
							<%-- <s:property value="itemName"/> --%>
							${info.itemName}
						</td>
					</tr>
					<tr height="20">
						<td class="addTd" width="15%">
							权力类型
						</td>
						<td width="35%">
							<%-- <s:property value="itemType"/> --%>
							${cp:MAPVALUE("ITEM_TYPE",info.itemType)}
						</td>
						<td class="addTd" width="15%">
							业务科室
						</td>
						<td>
							<%-- <s:property value="orgId"/> --%>
							${info.orgId}
						</td>
					</tr>
					<tr height="20">
						<td class="addTd">
							申请者名称
						</td>
						<td>
							<%-- <s:property value="applicant"/> --%>
							${info.applicant}
						</td>
						<td class="addTd">
							申请者类型
						</td>
						<td>
							<%-- <s:property value="applicantType" /> --%>
							${info.applicantType}
						</td>
					</tr>

					<tr >
						<td class="addTd">
							申请办件摘要
						</td>
						<td colspan="3">
							<%-- <s:property value="content"/> --%>
							${info.itemId}
						</td>
					</tr>

					<tr height="20">
						<td class="addTd">
							办件申请提交材料
						</td>
						<td colspan="3">
						</td>
					</tr>

				</table>
			</fieldset>
		</div>
			<s:form action="applyRecord" namespace="/powerbase" style="margin-top:0;margin-bottom:5" method="post" validator="true">
		<div class="two">
	
			<fieldset>
				<legend>
					办件备案
				</legend>
				
				<table cellpadding="0" cellspacing="0" align="center" class="viewTable">
					<tr><td width="15%" align="center" class="addTd">备案意见</td>
						<td>
						<s:textarea  name="remark" id="remark"  cols="85" rows="5" style="width:70%;height:50px;" 
									validator="input" min="1"   errorshow="请输入报备意见"></s:textarea>
						</td>
					</tr>
				</table>
			
			</fieldset>
		</div>
		<div align="center">
			<s:submit  method="insertRecordApplyBasic" cssClass="btn" key="opt.btn.save" />&nbsp;
			<input type="button" class="btn" value="返回" onClick="javascript:history.go(-1);"/>
		</div>
		</s:form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>立案审批</title>
<script type="text/javascript">
function _getSelectedItemLabel(objSelect) {            
    //判断是否存在        
    //var isExit = false;     
  //  alert(objSelect.label);
    document.getElementById("opiIdeacode").value=objSelect.value;
    for (var i = 0; i < objSelect.options.length; i++) {        
        if ( objSelect.options[i].selected) {  
        	
        	document.getElementById("transidea").value=objSelect.options[i].label;  
            break;        
        }        
    } 
}
</script>

</head>

<body>


<%@ include file="/page/common/messages.jsp"%>


<s:form action="poregisterbasic"  namespace="/punish" >
<s:hidden name="nodeInstId" value="%{nodeInstId}"/>
<s:hidden name="djId" value="%{object.punishobjectid}"></s:hidden>
<s:hidden name="object.punishobjectid" value="%{object.punishobjectid}"></s:hidden>
<s:hidden name="flowPhase" value="%{flowPhase}"></s:hidden>



<fieldset style=" display: block; padding: 10px;">
<legend>立案审批</legend>
	
<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">				
 
				<tr>
					<td class="addTd">
						是否立案
					</td>
					<td align="left">
						<select name="optProcInfo.ideacode"  onchange="_getSelectedItemLabel(this)">
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
								<option value="${row.key}" label="${row.value}"  <c:if test="${optProcInfo.ideacode eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" /></option>
							</c:forEach>
							</select>
					</td>
					<s:hidden name="ideacode" id="opiIdeacode" value="%{optProcInfo.ideacode}"/>
				</tr>

				<tr>
					<td class="addTd">
					分管局长审批
					</td>
					<td align="left">
						<s:hidden name="optProcInfo.transidea" value="%{optProcInfo.transidea}" id="transidea"></s:hidden>
						<s:textarea name="optProcInfo.transcontent" value="%{optProcInfo.transcontent}"></s:textarea>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						是否风险点
					</td>
					<td align="left">
						<s:radio list="#{'T':'是','F':'否'}" name="optProcInfo.isrisk" value="%{optProcInfo.isrisk}"></s:radio>
					</td>
					</tr>
				<tr>
					<td class="addTd">
						风险点类别
					</td>
					<td align="left">
						<s:textfield name="optProcInfo.risktype" value="%{optProcInfo.risktype}"></s:textfield>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						风险点描述
					</td>
					<td align="left">
						<s:textarea name="optProcInfo.riskdesc" value="%{optProcInfo.riskdesc}"></s:textarea>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						风险内控的<br />手段与结果<span style="color: red">*</span>
					</td>
					<td align="left">
						<s:textarea name="optProcInfo.riskresult" value="%{optProcInfo.riskresult}"></s:textarea>
					</td>
				</tr>
				

	
</table>
		<center style="margin-top: 10px;">
		<span style="display:none;" >
			<s:submit name="saveAndSubmit" method="submitIs" cssClass="btn" value="提 交" id="submitBtn"/>
		</span>
		<span style="display:none;" >			
			<s:submit name="save" method="saveIs" cssClass="btn" value="保 存" id="saveBtn"/>
			</span>
			<span style="display:none;" >
			<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>	
		</span>
		</center>

</fieldset>
</s:form>


</body>

</html>

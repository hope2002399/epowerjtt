<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>立案前调查</title>

	<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/alertDiv.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/arrow.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/kjyj.js"
	type="text/javascript"></script>
<script type="text/javascript" src="jquery-1.6.min.js"></script>
<link href="${pageContext.request.contextPath}/themes/css/arrow.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function choseQL(){
	window.open('<%=request.getContextPath()%>/punish/pcdef!listPcdef.do',
			'',
			'height=600,width=750,top=200,left=200,toolbar=yes,menubar=yes,scrollbars=yes, resizable=yes,location=yes, status=yes');
}
function checkform(){
	

	
	var s =document.getElementById("ispass");
	var e =document.getElementById("itemName");
	var f=document.getElementById("poregisterindagate");
	var g=docunment.getElementById("transcontent");

	if(s.value==""){
		alert("请选择是否立案");
		return false;}
	else
		return true;
	 if(e.value==""){
		alert("请选择处罚项目名称");
		return false;}
	else
		return true;
	
	if(f.value==""){		
		alert("请填写调查情况");
		return false;}
	else
		return true;
	if(g.value==""){
		alert("请填写经办人意见");
		return false;}
	else
		return true;	
	
}



</script>

</head>

<body>


<%@ include file="/page/common/messages.jsp"%>


<s:form action="poregisterbasic"  namespace="/punish" target="_parent" onsubmit="return checkform()">
<s:hidden name="nodeInstId" value="%{nodeInstId}"/>
<s:hidden name="djId" value="%{object.punishobjectid}"/>
<s:hidden name="object.punishobjectid" value="%{object.punishobjectid}"/>
<s:hidden name="flowPhase" value="%{flowPhase}"/>



<fieldset style=" display: block; padding: 10px;">
<legend>立案前调查</legend>
	
<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">				
 
				<tr>
					<td class="addTd">
						是否立案<font color="red">*</font>
					</td>
					<td align="left">
						
						<select name="object.ispass"  id="ispass" >
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
								<option value="${row.key}" label="${row.value}"  <c:if test="${object.ispass eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" /></option>
							</c:forEach>
							</select>
						
					</td>
				</tr>


				<tr>
					<td class="addTd">
						处罚项目名称<font color="red">*</font>
					</td>
					<td align="left">
						<s:textfield id="itemName" value="%{anyou}" cssStyle="width:380px" readonly="true"></s:textfield><button onclick="choseQL();">选择</button>
						<s:hidden id="itemId" name="potranslawbasic.punishclassid" value="%{potranslawbasic.punishclassid}"></s:hidden>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						案由
					</td>
					<td align="left">
						<s:textfield id="itemanyou" value="%{anyou}" cssStyle="width:380px" readonly="true"></s:textfield>
					</td>
				</tr> 

				<tr>
					<td class="addTd">
						相关的法律依据
					</td>
					<td align="left">
						<s:textfield id="poRegisterBasis"  value="%{object.poregisterbasis}" cssStyle="width:380px" name="poregisterbasis" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						调查情况<font color="red">*</font>
					</td>
					<td align="left">
						<s:textarea id="poregisterindagate" name="poregisterindagate" value="%{object.poregisterindagate}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						经办人意见<font color="red">*</font>
					</td>
					<td align="left">
						<s:textarea id="transcontent" name="optProcInfo.transcontent" value="%{optProcInfo.transcontent}"></s:textarea>
					</td>
				</tr>
				<tr id="JBR">
					<td class="addTd">审批人员<font color="red">*</font></td>
					<td align="left" colspan="3" >
							<input type="text" id="bjUserNames" name="bjUserNames" style="width:60%;height:30px;" value="${bjUserNames}"  readonly="readonly" />
							<input type="hidden" id="bjCodes" name="teamRoles" value="${teamRoleCode}" />
							<input type="hidden" id="roleCode" name="roleCode" value="${roleCode}" />
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
			<s:submit id="submitBtn" name="saveAndSubmit" method="submit" cssClass="btn" value="提 交"  />
			<s:submit id="saveBtn" name="save" method="save" cssClass="btn" value="保 存" />
			<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
		</center>

</fieldset>
</s:form>

<div id="attAlert" class="alert"
			style="width: 600px; height: 330px; overflow: hidden;">
			<%-- <input type="hidden" id="attention" name="attentionJson" value="${attentionJson}" /> --%>
			<%-- <input type="hidden" id="userjson" name="userjson" value="${userjson}" /> --%>
			<h4>
				<span>选择人员</span><span id="close"
					style="float: right; margin-right: 8px;" class="close"
					onclick="closeAlert('attAlert');">关闭</span>
			</h4>
			<div class="fix">
				<div id="leftSide"></div>
				<div id="l-r-arrow">
					<div class="lb"></div>
					<div class="rb"></div>
				</div>
				<div id="rightSide">
					<ul></ul>
				</div>
				<div id="t-b-arrow">
					<!-- <div class="tb"></div>
		            <div class="bb"></div> -->
					<b class="btns"><input id="save" class="btn" type="button"
						value="保存" /><input id="clear" class="btn" type="button"
						value="取消" style="margin-top: 5px;" /></b>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">

$("#bjUserNames").click(function(){
	var s = '${userjson}';
	if(s.trim().length){
		selectPopWin(${userjson},$("#bjUserNames"),$("#bjCodes"));
	};
});

function selectPopWin(json,o1,o2 ){
	new person(json,o1,o2).init();
	setAlertStyle("attAlert");
};
</script>
</html>

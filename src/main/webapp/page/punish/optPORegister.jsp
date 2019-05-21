<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>立案前调查</title>

<script type="text/javascript">

	function checkForm() {
		
		if ($("#ispass").val() == '') {
			alert("请选择是否立案");
			return false;
		}
		if ($("#itemName").val() == '') {
			alert("请选择处罚项目名称");
			return false;
		}

		if ($("#poregisterindagate").val() == '') {
			alert("请填写调查情况");
			return false;
		}

		if ($("#transcontent").val() == '') {
			alert("请填写经办人意见");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body onload="changPaperType();">
	<s:form action="poregisterbasic" method="post" namespace="/punish" target="_parent" onsubmit="return checkForm();">
		<s:hidden name="nodeInstId" value="%{nodeInstId}" />
		<s:hidden name="djId" value="%{object.punishobjectid}" />
		<s:hidden name="object.punishobjectid" value="%{object.punishobjectid}" />
		<s:hidden name="flowPhase" value="%{flowPhase}" />
		<input type="hidden" name="optProcInfo.transidea" value="${optProcInfo.transidea}" id="transidea">
		<input type="hidden" name="object.punishObjectBrief" value="${object.punishObjectBrief}" id="popunishObjectBrief">


		<fieldset style="display: block; padding: 10px;">
			<legend>立案前调查</legend>

			<table border="0" cellpadding="0" cellspacing="0" id="tb"
				class="viewTable" style="margin-top: 20px;">

				<tr>
					<td class="addTd">是否立案<font color="red">*</font>
					</td>
					<td align="left"><select name="object.ispass" id="ispass" onchange="changPaperType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
								<option value="${row.key}" label="${row.value}"
									<c:if test="${object.ispass eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr id="punishClassName">
					<td class="addTd">违法行为<font color="red">*</font>
					</td>
					<td align="left"><s:textfield id="itemName" value="%{punishclassname}"
							style="width:60%;height:30px;" readonly="true"></s:textfield>
				<input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/powerbase/supPower!listSupPower_CF.do?itemType=CF&s_itemType=CF&s_orgId=${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}','powerWindow',null);" value="选择">
						<s:hidden id="itemId" name="potranslawbasic.item_id"
							value="%{potranslawbasic.item_id}"/></td>
				</tr>	

				<tr id="poRegisterBas">
					<td class="addTd">相关的法律依据</td>
					<td align="left"><s:textarea id="poRegisterBasis"
							value="%{object.poregisterbasis}" style="width:60%;"
							name="poregisterbasis" readonly="true" /></td>
				</tr>
				<tr>
					<td class="addTd">调查情况<font color="red">*</font>
					</td>
					<td align="left"><s:textarea id="poregisterindagate"
							name="poregisterindagate" value="%{object.poregisterindagate}"
							style="width:60%;" /></td>
				</tr>
				<tr>
					<td class="addTd">经办人意见<font color="red">*</font>
					</td>
					<td align="left"><s:textarea id="transcontent"
							name="optProcInfo.transcontent"
							value="%{object.jbrOption_la}" style="width:60%;" /></td>
				</tr>
				<tr>
					<td class="addTd">是否风险点</td>
					<td align="left"><s:radio list="#{'T':'是','F':'否'}"
							name="optProcInfo.isrisk" value="%{optProcInfo.isrisk}"></s:radio>
					</td>
				</tr>
				<tr>
					<td class="addTd">风险点类别</td>
					<td align="left"><s:textfield name="optProcInfo.risktype"
							value="%{optProcInfo.risktype}"></s:textfield></td>
				</tr>
				<tr>
					<td class="addTd">风险点描述</td>
					<td align="left"><s:textarea name="optProcInfo.riskdesc"
							value="%{optProcInfo.riskdesc}" style="width:60%;" /></td>
				</tr>
				<tr>
					<td class="addTd">风险内控的<br />手段与结果<span style="color: red">*</span>
					</td>
					<td align="left"><s:textarea name="optProcInfo.riskresult"
							value="%{optProcInfo.riskresult}" style="width:60%;" /></td>
				</tr>
			</table>
			<center style="margin-top: 10px;">
			<span style="display:none;" >
				<s:submit name="saveAndSubmit" method="submit" cssClass="btn" value="提 交" id="submitBtn"/>
				</span>
			<span style="display:none;" >	
				<s:submit name="save" method="save" cssClass="btn" value="保 存" id="saveBtn"/>
			</span>	
			<span style="display:none;" >	
				<input type="button" value="返回" class="btn" onclick="window.history.go(-1);" id="backBtn"/>
			</span>
			</center>
		</fieldset>
	</s:form>
</body>
<script type="text/javascript">
window.parent.hiddSaveBtn();	
	function choseQL(){		
		var href="<%=request.getContextPath()%>/punish/pcdef!listPcdef.do";
        id=window.showModalDialog(href,window,"dialogHeight:850px;dialogWidth:1250px;center:yes;help:no;scroll:yes;status:no;edge:raised");

 /*   	 $.ajax({ 
         type: "post", 
         url: "poregisterbasic!getpunishpbasis.do?", 
         data: "punishclassid="+id, 
         dataType: "text",
         success: function(punishbasis){
        	 $("#poRegisterBasis").attr("value",punishbasis);
         } 
     });  */
		}
	
	function changPaperType() {		
		if ($("#ispass").val() =="F") { //不立案
			document.getElementById("punishClassName").style.display = "none";			
			document.getElementById("poRegisterBas").style.display = "none";
			document.getElementById("transidea").value='建议不立案';
		} else {//
			document.getElementById("punishClassName").style.display = "block";			
			document.getElementById("poRegisterBas").style.display = "block";
			document.getElementById("transidea").value='建议立案';
		}
	}
</script>
</html>

<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>

<title>办理信息</title>
 <sj:head locale="zh_CN"/>
<script type="text/javascript">
var fs='${fs}';
 $(document).ready(function(){
	if(fs=="C"||fs==""){
		$("#tz").hide();
		$("#notz").hide();
		$("#powitnessbasic").attr("disabled","true");
		$("#pounwitnessbasic").attr("disabled","true");
	}
	else if(fs=="T"){
		$("#cs").hide();
		$("#notz").hide();
		$("#poexcucebasic").attr("disabled","true");
		$("#pounwitnessbasic").attr("disabled","true");
	}
	else if(fs=="F"){
		$("#cs").hide();
		$("#tz").hide();
		$("#poexcucebasic").attr("disabled","true");
		$("#powitnessbasic").attr("disabled","true");
	}	
}); 
function h(o){
	var h1 = o.outerHeight(),
		h2 = $("#t").outerHeight();
	return parseInt(h1)+parseInt(h2)+"px";
}
function changeDiv(radio){
	var fs=radio.value;
	//alert(fs);
	if(fs=="C"||fs==""){
		$("#tz").hide();
		$("#notz").hide();
		$("#cs").show();
		$("#powitnessbasic").attr("disabled","true");
		$("#pounwitnessbasic").attr("disabled","true");
		$("#poexcucebasic").removeAttr("disabled");
		window.parent.getHeight( h($("#cs")) );
	}
	else if(fs=="T"){
		$("#cs").hide();
		$("#notz").hide();
		$("#tz").show();
		$("#poexcucebasic").attr("disabled","true");
		$("#pounwitnessbasic").attr("disabled","true");
		$("#powitnessbasic").removeAttr("disabled");
		window.parent.getHeight( h($("#tz")) );
	}
	else if(fs=="F"){
		$("#cs").hide();
		$("#tz").hide();
		$("#notz").show();
		$("#poexcucebasic").attr("disabled","true");
		$("#powitnessbasic").attr("disabled","true");
		$("#pounwitnessbasic").removeAttr("disabled");
		window.parent.getHeight( h($("#notz")) );
	}			
}
function checkcs(){
	if($("#poexcucedate").attr("value")==""){
		document.getElementById("poexcucedate").style.borderColor="red";
		alert("陈述申辩时间没有选择");
		return false;
	}else
		document.getElementById("poexcucedate").style.borderColor="#CCC";
	
	if($("#undertakername").attr("value")==""){
		alert("请填写承办人");
		document.getElementById("undertakername").style.borderColor="red";
		return false;
	}else
		document.getElementById("undertakername").style.borderColor="#CCC";
	
	if($("#undertakername2").attr("value")==""){
		alert("请填写承办人");
		document.getElementById("undertakername2").style.borderColor="red";
		return false;
	}else
		document.getElementById("undertakername2").style.borderColor="#CCC";
	
	if($("#registerid").attr("value")==""){
		alert("请填写记录人");
		document.getElementById("registerid").style.borderColor="red";
		return false;
	}else
		document.getElementById("registerid").style.borderColor="#CCC";	
}

function checktz(){
	if($("#powitnessdate").attr("value")==""){
		document.getElementById("powitnessdate").style.borderColor="red";
		alert("听证时间没有选择");
		return false;
	}else
		document.getElementById("powitnessdate").style.borderColor="#CCC";
 	
	 
	if($("#powitnessemceename").attr("value")==""){
		document.getElementById("powitnessemceename").style.borderColor="red";
		alert("主持人没有填写");
		return false;
	}else
		document.getElementById("powitnessemceename").style.borderColor="#CCC";
	
	if($("#powitnessnotername").attr("value")==""){
		document.getElementById("powitnessnotername").style.borderColor="red";
		alert("记录人没有填写");
		return false;
	}else
		document.getElementById("powitnessnotername").style.borderColor="#CCC";
	
	if($("#investigatename").attr("value")==""){
		document.getElementById("investigatename").style.borderColor="red";
		alert("调查人没有填写");
		return false;
	}else
		document.getElementById("investigatename").style.borderColor="#CCC";
	
}

function checkno(){
	 var obj = document.getElementsByName("pounwitnessreason");
	 var count=obj.length;
	    var j=0;
	    for(var i=0;i<count;i++)
	    {
	        if (obj[i].checked){
	            j++;
	        }
	    }
	    if(j==0){
	    	alert("请选择不予听证的理由");
	    	document.getElementById("reason").style.color="red";
	    	return false;
	    }
	    else
	    	document.getElementById("reason").style.color="#CCC";
}

</script>
</head>
<body id="l">
	<fieldset style="display: block; padding: 10px;" id="t">
				<legend>
				<b>方式选择</b>
				</legend>
	<table>
		<tr>
			<td><s:radio id="fs"  name="fs"
					list="#{'C':'陈述、申辩','T':'听证','F':'不予以听证（陈述、申辩）'}"
					onclick="changeDiv(this);" value="%{fs}"></s:radio></td>
		</tr>
		</table>
	</fieldset>
		<div id="cs" style="">
			<fieldset style="display: block; padding: 10px;">
				<legend>
					<b>陈述、申辩信息</b>
				</legend>
				<s:form action="poexcucebasic" namespace="/punish" target="_parent"  id="poexcucebasic" onsubmit="return checkcs();">
					<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
					<s:hidden name="object.punishobjectid" value="%{object.punishobjectid}"></s:hidden>
					<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
					<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
					<table border="0" cellpadding="0" cellspacing="0" id="tb"
						class="viewTable" style="margin-top: 20px;">
						<tr>
							<td class="addTd" width="130">陈述申辩时间<span style="color: red">*</span></td>
							<td colspan="3"> <sj:datepicker id="poexcucedate"
									name="object.poexcucedate" value="%{object.poexcucedate}"
									style="width:120px;" yearRange="2000:2020"
									timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true" timepicker="true"/> </td>
						</tr>
						<tr>
							<td class="addTd" width="130">地点</td>
							<td colspan="3"><s:textfield name="object.poexcuceadress" size="60px" style="width:100%; height:40px;"></s:textfield></td>
						</tr>
						<tr>
							<td class="addTd" width="130" rowspan="2">承办人<span style="color: red">*</span></td>
							<td><s:textfield  id="undertakername" name="object.undertakername" ></s:textfield></td>
							<td class="addTd" width="130" rowspan="2"> 执法证号</td>
							<td><s:textfield id="undertakecertno" name="object.undertakecertno"></s:textfield></td>
						</tr>
						<tr>
						<td><s:textfield  id="undertakername2" name="object.undertakername2" ></s:textfield></td>
						<td><s:textfield id="undertakecertno2" name="object.undertakecertno2"></s:textfield></td>
						</tr>
						<tr>
							<td class="addTd" width="130">记录人<span style="color: red">*</span></td>
							<td><s:textfield id="registerid" name="object.registerid"></s:textfield></td>
							<td class="addTd" width="130">执法证号</td>
							<td><s:textfield name="object.registercertno"></s:textfield></td>
						</tr>
						<tr>
							<td class="addTd" width="130">委托代理人</td>
							<td><s:textfield name="object.deputyname"></s:textfield></td>
						</tr>
						<tr>
							<td class="addTd" width="130">是否风险点</td>
							<td align="left"><s:radio name="optProcInfo.isrisk"
									list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}"
									listKey="key" listValue="value" /></td>
							<td class="addTd" width="130">风险类别</td>
							<td align="left"><s:textfield name="optProcInfo.risktype"
									size="60" value="%{optProcInfo.risktype}" /></td>
						</tr>
						<tr>
							<td class="addTd" width="130">风险描述</td>
							<td align="left" colspan="3"><s:textarea
									name="optProcInfo.riskdesc" style="width:100%;height:40px;"
									value="%{optProcInfo.riskdesc}" /></td>
						</tr>
						<tr>
							<td class="addTd">风险内控手段与结果</td>
							<td align="left" colspan="3"><s:textarea
									name="optProcInfo.riskresult" value="%{optProcInfo.riskresult}"
									style="width:100%;height:40px;" /></td>
						</tr>

					</table>
						<center style="margin-top: 10px;">
							<span style="display:none;" >
			<s:submit  id="submitBtn"  name="saveAndSubmit" method="submitCs"  cssClass="btn" value="提 交" />
			<s:submit id="saveBtn"  name="save" method="saveCs" cssClass="btn" value="保 存" />
			<input id="backBtn"  type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
			</span>
		</center>
				</s:form>
	</table>
	</div>
	<div id="tz" style="">
		<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>听证信息</b>
			</legend>
			<s:form action="powitnessbasic" namespace="/punish" target="_parent" id="powitnessbasic" onsubmit="return checktz();">
				<input type="hidden" name="optProcInfo.transidea" value="${optProcInfo.transidea}" id="transidea">
				<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
				<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
				<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
				<s:hidden name="object.punishobjectid" value="%{object.punishobjectid}"></s:hidden>
				<table border="0" cellpadding="0" cellspacing="0" id="tb"
					class="viewTable" style="margin-top: 20px;">
					<tr>
						<td class="addTd" width="130">听证时间<span style="color: red">*</span></td>
						<td colspan="3"> <sj:datepicker id="powitnessdate" 
								name="object.powitnessdate" value="%{powitnessbasic.powitnessdate}"
								style="width:120px;" yearRange="2000:2020"
								timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"/> </td>
					</tr>
					<tr>
						<td class="addTd" width="130">听证会地点</td>
						<td colspan="3"><s:textfield name="object.powitnessadress" value="%{powitnessbasic.powitnessadress}" style="width:100%; height:40px;"></s:textfield></td>
					</tr>
					<tr>
						<td class="addTd" width="130">听证方式<span style="color: red">*</span></td>
						<td><s:radio id="powitnesstype" name="object.powitnesstype" value="%{powitnessbasic.powitnesstype}" required="1" list="#{'0':'公开','1':'不公开'}"></s:radio></td>
						<td class="addTd" width="130">主持人<span style="color: red">*</span></td>
						<td><s:textfield id="powitnessemceename" name="object.powitnessemceename" value="%{powitnessbasic.powitnessemceename}"></s:textfield></td>
					</tr>
					<tr>
						<td class="addTd" width="130">记录人<span style="color: red">*</span></td>
						<td><s:textfield  id="powitnessnotername" name="object.powitnessnotername" value="%{powitnessbasic.powitnessnotername}"></s:textfield></td>
						<td class="addTd" width="130">调查人姓名<span style="color: red">*</span></td>
						<td><s:textfield id="investigatename" name="object.investigatename" value="%{powitnessbasic.investigatename}"></s:textfield></td>
					</tr>
					<tr>
						<td class="addTd" width="130">调查人单位</td>
						<td><s:textfield name="object.investigatedepname" value="%{powitnessbasic.investigatedepname}"></s:textfield></td>
						<td class="addTd" width="130">代理人姓名</td>
						<td><s:textfield name="object.deputyname" value="%{powitnessbasic.deputyname}"></s:textfield></td>
					</tr>
					<tr>
						<td class="addTd" width="130">代理人职务</td>
						<td><s:textfield name="object.deputybusiness" value="%{powitnessbasic.deputybusiness}"></s:textfield></td>
						<td class="addTd" width="130">代理人单位</td>
						<td><s:textfield name="object.deputydepname" value="%{powitnessbasic.deputydepname}"></s:textfield></td>
					</tr>
					<tr>
						<td class="addTd" width="130">列席人员姓名</td>
						<td colspan="3"><s:textfield size="100" name="object.delegatename" value="%{powitnessbasic.delegatename}"></s:textfield></td>
					</tr>
					<tr>
						<td class="addTd" width="130">当事人主要理由</td>
						<td colspan="3"><s:textarea name="object.powitnessreason" value="%{powitnessbasic.powitnessreason}" style="width:100%; height:40px;"></s:textarea></td>
					</tr>
					<tr>
						<td class="addTd" width="130">听证意见</td>
						<td colspan="3"><s:textarea name="object.powitnessmind" value="%{powitnessbasic.powitnessmind}" style="width:100%; height:40px;"></s:textarea></td>
					</tr>
					<tr>
						<td class="addTd" width="130">是否风险点</td>
						<td align="left"><s:radio name="optProcInfo.isrisk"
								list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}"
								listKey="key" listValue="value" /></td>
						<td class="addTd" width="130">风险类别</td>
						<td align="left"><s:textfield name="optProcInfo.risktype"
								size="60" value="%{optProcInfo.risktype}" /></td>
					</tr>
					<tr>
						<td class="addTd" width="130">风险描述</td>
						<td align="left" colspan="3"><s:textarea
								name="optProcInfo.riskdesc" style="width:100%;height:40px;"
								value="%{optProcInfo.riskdesc}" /></td>
					</tr>
					<tr>
						<td class="addTd">风险内控手段与结果</td>
						<td align="left" colspan="3"><s:textarea
								name="optProcInfo.riskresult" value="%{optProcInfo.riskresult}"
								style="width:100%;height:40px;" /></td>
					</tr>

				</table>
					<center style="margin-top: 10px;">
						<span style="display:none;" >
			<s:submit   id="submitBtn"  name="saveAndSubmit" method="submitTz" cssClass="btn" value="提 交" />
			<s:submit  id="saveBtn" name="save" method="saveTz" cssClass="btn" value="保 存" />
			<input id="backBtn" type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
			</span>
		</center>
			</s:form>
		</fieldset>
	</div>

	<div id="notz" >
		<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>不予听证</b>
			</legend>
			<s:form action="pounwitnessbasic" namespace="/punish" target="_parent" id="pounwitnessbasic" onsubmit="return checkno();">
				<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
				<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
				<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
				<s:hidden name="object.punishobjectid" value="%{object.punishobjectid}"></s:hidden>
				<table border="0" cellpadding="0" cellspacing="0" id="tb"
					class="viewTable" style="margin-top: 20px;">
					<tr>
						<td  class="addTd" rowspan="3"><span id="reason">理由</span><span style="color: red">*</span></td>
						<td  colspan="3" ><s:checkbox  name="pounwitnessreason" fieldValue="超出申请日期"></s:checkbox>1、超出申请日期</td>
					</tr>
					<tr>
						<td colspan="3"><s:checkbox   name="pounwitnessreason" fieldValue="条件不符合"></s:checkbox>2、条件不符合</td>
					</tr>

					<tr>
						<td  colspan="3"><s:checkbox name="pounwitnessreason" fieldValue="其他"></s:checkbox>3、其他</td>
					</tr>
					<tr>
						<td class="addTd" width="130">是否风险点</td>
						<td align="left"><s:radio name="optProcInfo.isrisk"
								list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}"
								listKey="key" listValue="value" /></td>
						<td class="addTd" width="130">风险类别</td>
						<td align="left"><s:textfield name="optProcInfo.risktype"
								size="60" value="%{optProcInfo.risktype}" /></td>
					</tr>
					<tr>
						<td class="addTd" width="130">风险描述</td>
						<td align="left" colspan="3"><s:textarea
								name="optProcInfo.riskdesc" style="width:100%;height:40px;"
								value="%{optProcInfo.riskdesc}" /></td>
					</tr>
					<tr>
						<td class="addTd">风险内控手段与结果</td>
						<td align="left" colspan="3"><s:textarea
								name="optProcInfo.riskresult" value="%{optProcInfo.riskresult}"
								style="width:100%;height:40px;" /></td>
					</tr>
					
				</table>
					<center style="margin-top: 10px;">
						<span style="display:none;" >
			<s:submit  id="submitBtn" name="saveAndSubmit" method="submitNoTz" cssClass="btn" value="提 交"  />
			<s:submit id="saveBtn" name="save" method="saveNoTz" cssClass="btn" value="保 存" />
			<input id="backBtn" type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
			</span>
		</center>
			</s:form>
		</fieldset>

	</div>
</body>
</html>


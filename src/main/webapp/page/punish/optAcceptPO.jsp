<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<sj:head locale="zh_CN" />
<script type="text/javascript">
function checkForm(){
	if(trim(_get('ideacode').value).length==0){
		alert("请选择处理结果");
		_get('ideacode').focus();
		return false;
	}
	if(trim(_get('transcontent').value).length==0){
		alert("意见不能为空");
		_get('transcontent').focus();
		return false;
	}	
	return true;
}

var _get = function (id) {
	return document.getElementById(id);
};

//字符空格处理
var trim = function (str) {
	return str.replace(/^\s+|\s+$/g, "");
};
</script>
</head>
<script type="text/javascript">

function _SelectItemByValue(objSelect, objItemText) {            
    //判断是否存在        
    //var isExit = false;        
    for (var i = 0; i < objSelect.options.length; i++) {        
        if (objSelect.options[i].value == objItemText) {        
            objSelect.options[i].selected = true;        
            //isExit = true;        
            break;        
        }        
    } 
}

function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height='+(window.screen.availHeight-50) +',width='+window.screen.availWidth
		+',directories=false,location=false,top=0,left=0,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}




//根据值设置select中的选项       
function _getSelectedItemLabel(objSelect) {            
    //判断是否存在        
    //var isExit = false;        
    for (var i = 0; i < objSelect.options.length; i++) {        
        if ( objSelect.options[i].selected) { 
        	if(objSelect.options[i].value=='T'){
        		document.forms[0].transcontent.value='同意受理案件';
        	}else if(objSelect.options[i].value=='F'){
        		document.forms[0].transcontent.value='不同意受理案件';
        	}else{
        		document.forms[0].transcontent.value='';
        		alert("请选择受理意见!");
        		_get('ideacode').focus();
        	}
        	document.getElementById("transidea").value=objSelect.options[i].label;
            break;        
        }        
    } 
    
    
}
</script>
<body>
<s:form action="punishobjectbasic" method="post" namespace="/punish" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="flowPhase" name="flowPhase" value="${flowPhase}" />

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>案件受理</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">
				<tr>
					<td class="addTd" width="140">是否受理<font color="red">*</font></td>
					<td align="left" colspan="3">
						<input type="hidden" name="optProcInfo.transidea" value="${optProcInfo.transidea}" id="transidea">
						<select id="ideacode"  name="optProcInfo.ideacode" onchange="_getSelectedItemLabel(this)">
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('HDJXZCF_CFSL')}">
								<option value="${row.key}" label="${row.value}"  <c:if test="${opi.ideacode eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" /></option>
							</c:forEach>
							</select>
					</td>
				</tr>				
				<tr>
					<td class="addTd">经办人意见</td>
					<td align="left" colspan="3">
						<s:textarea id="transcontent"
								name="optProcInfo.transcontent" style="width:100%; height:40px;" value="%{optProcInfo.transcontent}"/>
					</td>
				</tr>
						<tr>
						<td class="addTd" width="130">是否风险点</td>
				<td align="left"><s:radio listKey="key" listValue="value" name="optProcInfo.isrisk" id="isRisk"
						list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}"  /></td>
						</tr>
				<tr id="RISK1">
					<td class="addTd" width="130">
						风险类别
					</td>
					<td align="left">
					<s:textfield name="optProcInfo.risktype"
						size="60" value="%{optProcInfo.risktype}"/>
					</td>
				</tr>	
				<tr id="RISK2">
					<td class="addTd" width="130">
						风险描述
					</td>
					<td align="left" colspan="3">
					<s:textarea name="optProcInfo.riskdesc"
						style="width:100%;height:40px;" value="%{optProcInfo.riskdesc}"/>
					</td>
				</tr>
				<tr id="RISK3">
					<td class="addTd">
						风险内控手段与结果	
					</td>
					<td align="left" colspan="3">
						<s:textarea name="optProcInfo.riskresult"  value="%{optProcInfo.riskresult}" style="width:100%;height:40px;" />
					</td>
				</tr>	  
			</div>	
			</table>
		</fieldset>
		
		<center style="margin-top: 10px;">
		<span style="display:none;" >
			<s:submit name="saveAndSubmit" method="submitOpt" cssClass="btn" value="提 交" id="submitBtn"/>
		</span>
		<span style="display:none;" >	
			<s:submit name="save" method="saveOptAcceptPO" cssClass="btn" value="保 存" id="saveBtn"/>
		</span>
		<span style="display:none;" >			
			<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>	
		</span>
		</center>
		</s:form>

</body>
<script type="text/javascript">
function inital(isrisk){
	if(isrisk=='F'){
		_get("RISK1").style.display = "none";
		_get("RISK2").style.display = "none";
		_get("RISK3").style.display = "none";
	}else{
		_get("RISK1").style.display = "block";
		_get("RISK2").style.display = "block";
		_get("RISK3").style.display = "block";
	}
	
	
}


</script>
</html>
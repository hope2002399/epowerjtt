<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<script type="text/javascript">
function checkForm(){
	if($("#transcontent").val()==''){
		alert("经办人意见不可为空！");
		$('#transcontent').focus();
		return false;
	}
	
	if($("#bjUserNames").val()==''){
		alert("审批人员不可为空！");
		$('#bjUserNames').focus();
		return false;
	}	
	return true;
}
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
        		document.forms[0].transcontent.value='同意结案';        	
        	}else if(objSelect.options[i].value=='B'){        		
        		document.forms[0].transcontent.value='退回经办人';
        	}else{
        		document.forms[0].transcontent.value='';
        		alert("请选择受理意见!");        		
        		$('#ideacode').focus();
        	}
        	document.getElementById("transidea").value=objSelect.options[i].label;
        	//alert(objSelect.options[i].value);
        	document.getElementById("opiIdeacode").value=objSelect.options[i].value;
        	//alert(document.getElementById("opiIdeacode").value);
            break;        
        }        
    } 
}
</script>
<body>
<s:form action="pofinishbasic" method="post" namespace="/punish" id="generalOperatorForm" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="flowPhase" name="flowPhase" value="${flowPhase}">

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>执行情况登记</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
				<tr>
					<td class="addTd">认定违法事实</td>
					<td align="left" colspan="3">${object.confirmtruth }
					</td>
				</tr>	
				<tr>
					<td class="addTd">违反条款</td>
					<td align="left" colspan="3">${object.disobeyitem }
					</td>
				</tr>	
				<tr>
					<td class="addTd">处罚结论</td>
					<td align="left" colspan="3">${object.podiscussresult }
					</td>
				</tr>
				
				<c:if test="${object.punishamout !=null }">
				<c:if test="${object.punishamout >=0.00}">
					<tr>
					<td class="addTd">缴款金额</td>
					<td align="left">${object.punishamout }
					</td>
					<td class="addTd">处罚人数</td>
					<td align="left">${object.punishamoutpeople }
					</td>
				</tr>	
				<tr>
					<td class="addTd">处罚票据扫描件</td>
					<td align="left" colspan="3">
		<a  href="<%=request.getContextPath()%>/punish/pofinishbasic!downloadstuff.do?object.punishobjectid=${object.punishobjectid}">${object.punishaffixname}</a>
					</td>
				</tr>			
				</c:if>	
				
				<c:if test="${object.punishseizure >=0}">
					<tr>
					<td class="addTd">没收件数</td>
					<td align="left">${object.punishseizure }
					</td>
					<td class="addTd">没收价值</td>
					<td align="left">${object.punishseizurevalue }
					</td>
				</tr>				
				</c:if>	
					
				<c:if test="${object.punishshoutont >=0}">
					<tr>
					<td class="addTd">停业天数</td>
					<td align="left" colspan="3">${object.punishshoutont }天
					</td>				
				</tr>				
				</c:if>
				
				<c:if test="${object.punishdetention >=0}">
					<tr>
					<td class="addTd">拘留人数</td>
					<td align="left">${object.punishdetentionpeople } 人
					</td>
					<td class="addTd">拘留天数</td>
					<td align="left">${object.punishdetention }
					</td>
				</tr>				
				</c:if>						
				</c:if>	
					<tr>
					<td class="addTd">执行情况</td>
					<td align="left" colspan="3">${object.otherpunish }
					</td>				
				</tr>
				
				</table>
		</fieldset>
		<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>经办人意见</b>
			</legend>
					<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
			<tr>
					<td class="addTd" width="140">是否结案<font color="red">*</font></td>
					<td align="left" colspan="3">
						<input type="hidden" name="optProcInfo.transidea" id="transidea" value="${optProcInfo.transidea}">
						<input type="hidden" name="optProcInfo.ideacode" id="opiIdeacode" value="${optProcInfo.ideacode}">
						<select id="ideacode"  name="ideacode" onchange="_getSelectedItemLabel(this)">
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('HDJXZCF_CFJA')}">
								<option value="${row.key}" label="${row.value}"  <c:if test="${opi.ideacode eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" /></option>
							</c:forEach>
							</select>
					</td>
				</tr>
			
				<tr>
					<td class="addTd">审批意见<font color="red">*</font></td>
					<td align="left" colspan="3">
						<s:textarea id="transcontent"
								name="optProcInfo.transcontent" style="width:100%; height:40px;" value="%{optProcInfo.transcontent}"/>
					</td>
				</tr>	
							
						<tr>
						<td class="addTd" width="130">是否风险点</td>
				<td align="left"><s:radio name="optProcInfo.isrisk"
						list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}" listKey="key" listValue="value"/></td>
					<td class="addTd" width="130">
						风险类别
					</td>
					<td align="left">
					<s:textfield name="optProcInfo.risktype"
						size="60" value="%{optProcInfo.risktype}"/>
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						风险描述
					</td>
					<td align="left" colspan="3">
					<s:textarea name="optProcInfo.riskdesc"
						style="width:100%;height:40px;" value="%{optProcInfo.riskdesc}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						风险内控手段与结果	
					</td>
					<td align="left" colspan="3">
						<s:textarea name="optProcInfo.riskresult"  value="%{optProcInfo.riskresult}" style="width:100%;height:40px;" />
					</td>
				</tr>	
		       		
			</table>
		</fieldset>
		
		<center style="margin-top:10px;">
		<span style="display:none;" >
		<s:submit name="save" method="saveOpt" cssClass="btn" value="保 存" id="saveBtn"/>
		</span>
		<span style="display:none;" >		
		<s:submit name="saveAndSubmit" method="saveIsFinishsubmitOpt" cssClass="btn" value="提 交" id="submitBtn"/>
		</span>
		<span style="display:none;" >
		<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>
		</span>
</center>
		</s:form>	
</body>

</html>
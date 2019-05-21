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
	var isNeed=$('#isNeed').val();	
	var podiscusstype=$('#podiscusstype').val();
	
	if(isNeed=='' && podiscusstype=='2'){
		alert("请选择是否需要二次讨论！");
		$('#isNeed').focus();
		return false;
	}
	if(isNeed=='1' || podiscusstype=='1'){
	if($("#podiscussbegintime").val()==''){
		alert("开始时间不可为空！");
		$('#podiscussbegintime').focus();
		return false;
	}	
	if($("#podiscussendtime").val()==''){
		alert("结束时间不能为空!");
		$('#podiscussendtime').focus();
		return false;
	}	
	
	if($("#podiscussbegintime").val() > $("#podiscussendtime").val()){
		alert("开始时间不可大于结束时间!");
		return false;
	}
	
	if($("#podiscussemcee").val()==''){
		alert("主持人不能为空!");
		$('#podiscussemcee').focus();
		return false;
	}
	
	if($("#podiscussnoter").val()==''){
		alert("记录人不能为空!");
		$('#podiscussnoter').focus();
		return false;
	}
	
	if($("#podiscussadress").val()==''){
		alert("讨论地点不能为空!");
		$('#podiscussadress').focus();
		return false;
	}
	
	if($("#podiscussrecored_").val()==''){
		alert("请上传讨论记录!");
		$('#podiscussrecored_').focus();
		return false;
	}
	
	if($("#isrisk").val()=='T'){		
		if($('#riskresult').val()==''){
			alert("风险内控手段与结果不能为空!");
		};
		return false;
	}
	}else{
		document.getElementById("transidea").value="不进行二次讨论";
		if(window.confirm("选择不进行二次讨论，是否确定？")){
			return true;
	}else{
		$('#isNeed').focus();
		return false;
	}
	}
	return true;
}
function showFreeUmpireList(){
	var item_id="${item_id}";
	var punishobjectid="${object.punishobjectid}";
	var degreeno="${degreeNo}";
	var contextpath="${pageContext.request.contextPath}";
	var discusstype="${object.cid.podiscusstype}";
    var url=contextpath+"/punish/poindagaterepbasic!showPunishOpinion2.do?discusstype="+discusstype+"&punishobjectid="+punishobjectid+"&item_id="+item_id+"&degreeno="+degreeno;	

	 //openNewWindow(url,'powerWindow',null);
   id=window.showModalDialog(url,window,"dialogHeight:450px;dialogWidth:850px;center:yes;help:no;scroll:yes;status:no;edge:raised");

   if(id!=""&&id!="undefined"&&id!=null){
	   document.forms[0].podiscussresult.value=id;
	   }
}
String.prototype.replaceAll = function(s1,s2) {

    return this.replace(new RegExp(s1,"gm"),s2);
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
        		document.forms[0].transcontent.value='同意以上做出的最终处罚决定';
        	}else if(objSelect.options[i].value=='F'){
        		document.forms[0].transcontent.value='不同意以上做出的最终处罚决定';
        	}else if(objSelect.options[i].value=='B'){
        		document.forms[0].transcontent.value='退回承办人重新审批';
        	}else{
        		document.forms[0].transcontent.value='';
        		alert("请选择审批意见!");
        		_get('ideacode').focus();
        	}
        	document.getElementById("transidea").value=objSelect.options[i].label;
            break;        
        }        
    } 
}
</script>
<c:if test="${object.podiscusstype==2}">
<body onload="showDiv('${object.podiscusstype}');">
</c:if>
<c:if test="${object.podiscusstype !=2}">
<body>
</c:if>
<s:form action="podiscussbasic" method="post" namespace="/punish" id="generalOperatorForm" target="_parent" onsubmit="return checkForm();" enctype="multipart/form-data">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="degreeNo" name="degreeNo"  value="${degreeNo}" />
<input type="hidden" id="item_id" name="item_id"  value="${item_id}" />

<input type="hidden" id="podiscusstype" name="podiscusstype"  value="${object.podiscusstype}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />

<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" name="optProcInfo.cfType" value="${optProcInfo.cfType}">
<input type="hidden" name="cfType" value="${optProcInfo.cfType}">
<input type="hidden" name="optProcInfo.transidea" value="同意" id="transidea">
<s:hidden name="flowPhase" value="%{flowPhase}"/>
<c:if test="${object.podiscusstype==2}">
<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">
	<tr>
	<td class="addTd">是否需要二次讨论<font color="red">*</font></td>
					<td align="left">
						<select id="isNeed"  name="isNeed" onchange="showDiv(this);">
						<option VALUE="" >---请选择---</option>
								<option value="0">
									<c:out value="不进行二次讨论" />
								</option>
								<option value="1">
									<c:out value="进行二次讨论" />
								</option>
						</select>
					</td>
	</tr>							
</table>
</c:if>
<div id="IDD">
<fieldset style=" display: block; padding: 10px;" >
			<legend>
				<b>案件讨论信息</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">
								
				<tr>
					<td class="addTd">开始时间<font color="red">*</font></td>
					<td align="left">
					<sj:datepicker id="podiscussbegintime" name="podiscussbegintime"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.podiscussbegintime}"/>
			</td>
					<td class="addTd">结束时间<font color="red">*</font></td>
					<td align="left">
				<sj:datepicker id="podiscussendtime" name="podiscussendtime"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.podiscussendtime}"/>
			</td>
				</tr>
					<tr>
					<td class="addTd">主持人<font color="red">*</font></td>
					<td align="left">
					<s:textfield id="podiscussemcee" name="podiscussemcee" value="%{object.podiscussemcee}"/>
					</td>
					<td class="addTd">记录人<font color="red">*</font></td>
					<td align="left">
						<s:textfield id="podiscussnoter"
								name="podiscussnoter"  value="%{object.podiscussnoter}"/>
					</td>
				</tr>
				
					<tr>
					<td class="addTd">讨论地点<font color="red">*</font></td>
					<td align="left" colspan="3">
						<s:textarea id="podiscussadress"
								name="podiscussadress" style="width:100%; height:40px;" value="%{object.podiscussadress}"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="addTd">参加人员</td>
					<td align="left" colspan="3">
						<s:textarea id="podiscussattendname"
								name="podiscussattendname" style="width:100%; height:40px;" value="%{object.podiscussattendname}"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="addTd">列席人员</td>
					<td align="left" colspan="3">
						<s:textarea id="podiscussattendeename"
								name="podiscussattendeename" style="width:100%; height:40px;" value="%{object.podiscussattendeename}"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="addTd">认定违法事实</td>
					<td align="left" colspan="3">
						<s:textarea id="confirmtruth"
								name="confirmtruth" style="width:100%; height:40px;" value="%{object.confirmtruth}"/>
					</td>
					
				</tr>
				<tr>
					<td class="addTd">违法条款</td>
					<td align="left" colspan="3">
						<s:textarea id="disobeyitem"
								name="disobeyitem" style="width:100%; height:40px;" value="%{object.disobeyitem}"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="addTd">处罚结论</td>
					<input type="hidden" name="selFreeUmpire">
					<td align="left" colspan="3">
						<s:textarea id="podiscussresult"
								name="podiscussresult" style="width:80%; height:40px;" value="%{object.podiscussresult}"/>
									<input type="button" value="..." onclick="javascript:showFreeUmpireList();" class='btn'/> </tr>
					</td>
                  </tr>
				</tr>
			<tr>
					<td class="addTd">讨论记录<font color="red">*</font></td>
					<td align="left" colspan="3">
					<s:file id="podiscussrecored_" name="podiscussrecored_"  style="width:60%;height:30px;" /></td>
					
				</tr>
						<tr>
						<td class="addTd" width="130">是否风险点</td>
				<td align="left"><s:radio name="optProcInfo.isrisk" id="isrisk"
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
						<s:textarea id="riskresult" name="optProcInfo.riskresult"  value="%{optProcInfo.riskresult}" style="width:100%;height:40px;" />
					</td>
				</tr>	
		       		
			</table>
		</fieldset>
		</div>
		<center style="margin-top: 10px;">
		<span style="display:none;" >
			<s:submit id="submitBtn" name="saveAndSubmit" method="saveDiscussSubmitOpt" cssClass="btn" value="提 交" />
			</span>
			<span style="display:none;" >
			<input id="backBtn" type="button" Class="btn"  onclick="window.history.back()" value="返回" />  
		</span>
		</center>
		</s:form>
</body>
<c:if test="${object.podiscusstype==2}">
<script type="text/javascript">

	function showDiv(){
	
		var podiscusstype=document.getElementById("podiscusstype").value;
		var isNeed=document.getElementById("isNeed").value;
		//alert(isNeed);
		var t = window.parent.document.getElementById("transFrame");
		if(podiscusstype=='1'){
			document.getElementById("IDD").style.display = "block";
			if(t) t.height = document.body.scrollHeight;
		}else if(podiscusstype=='2'&& isNeed=='0'){
			document.getElementById("IDD").style.display = "none";
			if(t) t.height = document.body.scrollHeight;
		}else if(podiscusstype=='2'&& isNeed=='1'){
			document.getElementById("IDD").style.display = "block";
			if(t) t.height = document.body.scrollHeight;
		}else{
			document.getElementById("IDD").style.display = "block";
			if(t) t.height = document.body.scrollHeight;
		}	
	}
</script>
</c:if>
<script type="text/javascript">
	window.parent.hiddSaveBtn();
</script>
</html>
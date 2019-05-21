<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<meta name="decorator" content='${LAYOUT}'/>
<title>现场处罚登记 </title>
<style type="text/css">
	.viewTable td { width:37%; }
	.viewTable td.addTd { width:13%; }
</style>
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
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(
		function (){ 
	
             if(getId("occurstate").value!=""&&getId("occurstate").value!=null){
    
			if(getId("occurstate").value==0){
				document.getElementById('individual').style.display = 'block';
				document.getElementById('enterprise').style.display = 'none';
			}
			if(getId("occurstate").value==1){
				document.getElementById('individual').style.display = 'none';
				document.getElementById('enterprise').style.display = 'block';
			}
			if(getId("originstate").value=='0001000070'){
				if(getId("impeachstate").value==0){
					getId("jbtype").innerHTML="个人";
					getId("tr1").style.display='block';
					getId("tr2").style.display='block';
					getId("jbrxm").innerHTML="举报人姓名";
					getId("lxdh").innerHTML="举报人联系电话";
					getId("dz").innerHTML="举报人姓名";
					getId("yb").innerHTML="举报人姓名";
				}
				if(getId("impeachstate").value==1){
					getId("jbtype").innerHTML="组织机构";
					getId("tr1").style.display='none';
					getId("tr2").style.display='none';
					getId("jbrxm").innerHTML="单位名称";
					getId("lxdh").innerHTML="单位联系电话";
					getId("dz").innerHTML="单位地址";
					getId("yb").innerHTML="单位邮编";
				}
			}else{
				
			}
		

            }
             else{
			document.getElementById('enterprise').style.display = 'none';
			/* document.getElementById('sea1').style.display = 'none';
			document.getElementById('sea2').style.display = 'none';
			document.getElementById('sea3').style.display = 'none'; */
			}
             /* if(getId("isrisk").value==0){
     			document.getElementById('sea1').style.display = 'none';
    			document.getElementById('sea2').style.display = 'none';
    			document.getElementById('sea3').style.display = 'none';
             }
             else if(getId("isrisk").value==1){
     			document.getElementById('sea1').style.display = 'block';
    			document.getElementById('sea2').style.display = 'block';
    			document.getElementById('sea3').style.display = 'block';
             } */
		}
);	

	function changeoccur(radiovalue){
		if(radiovalue=="0"){
			document.getElementById('individual').style.display = 'block';
			document.getElementById('enterprise').style.display = 'none';
		}
		if(radiovalue=="1"){
			document.getElementById('individual').style.display = 'none';
			document.getElementById('enterprise').style.display = 'block';
		}

	}
	function changeoccur2(radiovalue){
		if(radiovalue=="0"){
			getId("jbtype").innerHTML="个人";
			getId("tr1").style.display='block';
			getId("tr2").style.display='block';
			getId("jbrxm").innerHTML="举报人姓名";
			getId("lxdh").innerHTML="举报人联系电话";
			getId("dz").innerHTML="举报人姓名";
			getId("yb").innerHTML="举报人姓名";

		     getId("pocaseimpeachphone").value ="";
		     getId("pocaseimpeachadress").value ="";
		     getId("pocaseimpeachpostcode").value ="";
		}
		if(radiovalue=="1"){
			getId("jbtype").innerHTML="组织机构";
			getId("tr1").style.display='none';
			getId("tr2").style.display='none';
			getId("jbrxm").innerHTML="单位名称";
			getId("lxdh").innerHTML="单位联系电话";
			getId("dz").innerHTML="单位地址";
			getId("yb").innerHTML="单位邮编";	
		     getId("pocaseimpeachphone").value ="";
		     getId("pocaseimpeachadress").value ="";
		     getId("pocaseimpeachpostcode").value ="";
		}
	}
	function check(subtype){
		/* if(document.forms[0].caseUnitCode.value==""){
			alert("请选择文书单位");
		  	document.forms[0].caseUnitCode.focus();
		  	return false;
		} */
		if(document.forms[0].transaffairname.value==""){
			alert("办件名称不能为空");
		  	document.forms[0].transaffairname.focus();
		  	return false;
		}
		
    	if(document.forms[0].bjUserNames.value==""){
			alert("请选择现场执法人员");
		  	document.forms[0].bjUserNames.focus();
		  	return false;
		}
    	
	    if(document.forms[0].pooccurdate.value==""){
		  	alert("请填写案发时间");
		  	document.forms[0].pooccurdate.focus();
		  	return false;
		}
		  
	    if(document.forms[0].pooccuradress.value==""){
		  	alert("请填写案发地点");
		  	document.forms[0].pooccuradress.focus();
		  	return false;
		}
	    
		if(getId("pooccurstate").checked){
			if(getIdValue("indname")==""){
		   		alert("请填写当事人姓名");
		   		getId("indname").focus();
		   		return false;
			}
		   	if(getIdValue("indphone")!=null&&getIdValue("indphone")!=""){
		   		if(!IsPhoneNumber(getIdValue("indphone"))){
		   			alert("联系电话格式不正确");
		   			getId("indphone").value="";
		   			getId("indphone").focus();
	       			return false;
		   		}
		   	}
		   	if(getIdValue("indpost")!=null&&getIdValue("indpost")!=""){
		   		if(!IsPostCode(getIdValue("indpost"))){
		   			alert("邮编格式不正确");
		   			getId("indpost").value="";
		   			getId("indpost").focus();
		   			return false;
		   		}
		   	}
		} else if (!getId("pooccurstate").checked) {
	    	
			if(getIdValue("entname")==""){
		   		alert("请填写组织机构名称");
		   		getId("entname").focus();
		   		return false;
		   	}
	    	
		   	if(getIdValue("entpost")!=null&&getIdValue("entpost")!=""){
		   		if(!IsPostCode(getIdValue("entpost"))){
		   			alert("邮政编码格式不正确");
		   			getId("entpost").value="";
		   			getId("entpost").focus();
	       			return false;
		   		}
		  	}
		   
		   	if(getIdValue("entfax")!=null&&getIdValue("entfax")!=""){
		   		if(!IsPhoneNumber(getIdValue("entfax"))){
		   			alert("传真格式不正确");
		   			getId("entfax").value="";
		   			getId("entfax").focus();
		   			return false;
		   		}
		   	}
		   
		   	if(getIdValue("entphone")!=null&&getIdValue("entphone")!=""){
		   		if(!IsPhoneNumber(getIdValue("entphone"))){
	       			alert("联系电话格式不正确");
	       			getId("entphone").value="";
		   			getId("entphone").focus();
		   			return false;
		   		}
		   	}
		}
		/* if (document.frames['itemFrame'].document.lkmform.popunishObjectBrief.value == "") {
	 		alert("请选择案由");
			document.frames['itemFrame'].document.lkmform.popunishObjectBrief.focus();
   			return false;
		} */
		if (document.frames['itemFrame'].document.lkmform.itemName.value == "") {
			alert("请选择处罚项目");
			document.frames['itemFrame'].document.lkmform.itemName.focus();
		    return false;
		}
		if (document.frames['itemFrame'].document.lkmform.discussresult.value == "") {
	 		alert("请填写处罚决定");
	 		document.frames['itemFrame'].document.lkmform.discussresult.focus();
    		return false;
		}
		if (document.frames['itemFrame'].document.lkmform.punishamout.value != "") {
			if (isNaN(document.frames['itemFrame'].document.lkmform.punishamout.value)) {
				alert("请正确填写处罚金额数字!");
				return false;
	 		}
   		}
   	/* 	if(!isLimitLength(document.frames['itemFrame'].document.lkmform.otherpunish.value,100)){
          	alert("其他处罚项目长度过长,标准长度不超过100");
          	document.frames['itemFrame'].document.lkmform.otherpunish.focus();
          	return;
   		} */
   		var punishamout=document.frames['itemFrame'].document.lkmform.punishamout.value;
   		var indlimit="${cp:MAPVALUE('Limited','Limited_pri')}";
   		var entlimit="${cp:MAPVALUE('Limited','Limited_enp')}";
   		var isoutofrange;
   
   		if(getId("pooccurstate").checked&&Number(punishamout)>Number(indlimit)){
      		if(window.confirm("个人罚款金额已超过"+indlimit+"元,确定将进入一般流程?")){
    	  		isoutofrange=1;
      		}else{
        		alert("请重新作出处罚意见");
        		return false;
      		}
   		} else if (!getId("pooccurstate").checked&&Number(punishamout)>Number(entlimit)){
	   		if(window.confirm("企业罚款金额已超过"+entlimit+"元,确定将进入一般流程?")){
	    	  	isoutofrange=1;
	      	}else{
	        	alert("请重新作出处罚意见");
	        	return false;
	      	}
   		} else {
	   		isoutofrange=0;
   		}

   		var warm="";
   		if('subm'==subtype){
   		//判断文书是否已经保存
   		var frmObj = window.frames['itemFrame'];	
   		if(frmObj.document.lkmform.curTemplateId.value=='' || frmObj.document.lkmform.curTemplateId.value===undefined){
   				alert("文书不可为空，请上传！");
	        	return false;   		
   		} 
		if(isoutofrange==1){
			warm="确实保存登记信息，并进入一般流程";
		}else{
		    warm="确实要保存此现场处罚信息吗";
		}
		}else{
		warm="保存现场处罚信息后，将可以出具处罚决定书！";		
		}
		
		if('save'==subtype){//保存时
		if(window.confirm(warm)){
	    	var form=document.getElementById("basicform");
	    	document.basicform.action="punishobjectbasic!savefacilityflowinfo_save.do?isoutofrange="+isoutofrange; 
	    	getIframeValue();
	    	form.submit();
   		}else{
     		return false;
   		}
   		
   		
   		}else{//保存提交时
   		if(window.confirm(warm)){
	    	var form=document.getElementById("basicform");
	    	document.basicform.action="punishobjectbasic!savefacilityflowinfo_subm.do?isoutofrange="+isoutofrange; 
	    	getIframeValue();
	    	form.submit();
   		}else{
     		return false;
   		}
   		}
	}	
	
	
	function setvalue(checkbox){
		  if(checkbox.checked){
		
		     getId("pocaseimpeachname").value="匿名";
		     getId("pocaseimpeachname").readonly=true;
		     getId("pocaseimpeachphone").disabled=true;
		     getId("pocaseimpeachadress").disabled=true;
		     getId("pocaseimpeachpostcode").disabled=true;
		     getId("pocaseimpeachphone").value ="";
		     getId("pocaseimpeachadress").value ="";
		     getId("pocaseimpeachpostcode").value ="";
		   
		}else{
			 getId("pocaseimpeachname").value="";
			 getId("pocaseimpeachname").readonly=false;
		     getId("pocaseimpeachphone").disabled=false;
		     getId("pocaseimpeachadress").disabled=false;
		     getId("pocaseimpeachpostcode").disabled=false;
		}
	}
	function setvalue2(checkbox){
		  if(checkbox.checked){
		
		     getId("pocaseimpeachname2").value="匿名";
		     getId("pocaseimpeachname2").readonly=true;
		     getId("pocaseimpeachphone2").disabled=true;
		     getId("pocaseimpeachadress2").disabled=true;
		     getId("pocaseimpeachpostcode2").disabled=true;
		     getId("pocaseimpeachphone2").value ="";
		     getId("pocaseimpeachadress2").value ="";
		     getId("pocaseimpeachpostcode2").value ="";
		   
		}else{
			 getId("pocaseimpeachname2").value="";
			 getId("pocaseimpeachname2").readonly=false;
		     getId("pocaseimpeachphone2").disabled=false;
		     getId("pocaseimpeachadress2").disabled=false;
		     getId("pocaseimpeachpostcode2").disabled=false;
		}
	}
	
	function getIframeValue(){
		//document.all("punishobjectbrief").value=document.frames['itemFrame'].document.lkmform.popunishObjectBrief.value;
		//document.all("punishClassID").value=document.frames['itemFrame'].document.lkmform['punishClassID'].value;
		document.all("punishamout").value=document.frames['itemFrame'].document.lkmform['punishamout'].value;
		//document.all("otherpunish").value=document.frames['itemFrame'].document.lkmform['otherpunish'].value;
		document.all("discussresult").value=document.frames['itemFrame'].document.lkmform['discussresult'].value;
		document.all("issurpass").value=document.frames['itemFrame'].document.lkmform['issurpass'].value;
		document.all("disobeyitem").value=document.frames['itemFrame'].document.lkmform['object.vorgsuppower.punishbasis'].value;
		document.all("confirmtruth").value=document.frames['itemFrame'].document.getElementById('itemName').value;
	}
</script>
</head>
<body onsubmit="submit();">
<s:form   id="basicform" action="punishobjectbasic"  method="post" namespace="/punish"  styleId="punishobjectbasicForm" >

<input type="hidden" id="flowCode" name="flowCode"  value="${flowCode}" />
<input type="hidden" id="occurstate" value="${object.pooccurstate}"/>
<input type="hidden" id="impeachstate" value="${object.poimpeachstate}"/>
<input type="hidden" id="originstate" value="${object.pooriginstate}"/>
<input type="hidden" name="managedepid" value="${object.managedepid}"/>
<input type="hidden" name="operatorid" value="${object.operatorid}"/>
<input type="hidden" id="optId" name="optId"  value="${object.optId}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="item_id" name="item_id">
<input type="hidden" id="punishobjectbrief" name="punishobjectbrief">
<input type="hidden" id="punishamout" name="punishamout">
<input type="hidden" id="otherpunish" name="otherpunish">
<input type="hidden" id="discussresult" name="discussresult">
<input type="hidden" id="issurpass" name="issurpass">
<input type="hidden" name="disobeyitem" value="">
<input type="hidden" name="confirmtruth" value="">
<input type="hidden" name="documentTemplateIds" value="${documentTemplateIds}">
<input type="hidden" name="isJD" value="${isJD}">
<input type="hidden" name="caseno" value="${object.caseno}">
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>简易流程案件信息</b></legend>

<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<tr>
		<%-- <td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>文书单位</td>
		<td align="left" >
			<select name="caseUnitCode" id="caseUnitCode" onchange="document.getElementById('caseUnitName').value = this.options[this.selectedIndex].text">
				<option value="">--请选择--</option>
				<c:forEach var="row" items="${unitList}">
					<option value="${row.unitcode}" <c:if test="${object.caseUnitCode eq row.unitcode}"> selected = "selected" </c:if>>
						<c:out value="${row.unitname}" />
					</option>
				</c:forEach>
			</select>
			<input type="hidden" id="caseUnitName" name="caseUnitName" value="${object.caseUnitName}">
		</td> --%>
		<td class="addTd" >
			<font color="red"><strong>*&nbsp;</strong></font> 办件名称
		</td>
		<td align="left" >
			 <s:textarea value="%{object.transaffairname}" name="transaffairname" id="transaffairname" style="width:100%;height:23px;"/>
		</td>
	</tr>
	<tr>
		<td class="addTd" >受理单位</td><td align="left">${cp:MAPVALUE("unitcode",object.managedepid)}</td>
		<td class="addTd" >登记人员</td><td align="left">${cp:MAPVALUE("usercode",object.operatorid)}</td>
	</tr>
	<tr>
	<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>现场执法人员</td>	

		<td align="left">
		<input type="text" id="bjUserNames" name="bjUserNames" style="width:60%;height:24px;" value="${object.poundertaker}"  readonly="readonly" />
		<input type="hidden" id="bjCodes" name="teamRoles" value="${teamRoleCode}" />
		<input type="hidden" id="roleCode" name="roleCode" value="${roleCode}" />
		</td>
		<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>案发时间</td>	

		<td align="left">
			<sj:datepicker id="pooccurdate" 
			name="pooccurdate"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="HH:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.pooccurdate}"/>
		</td>
	</tr>
	<tr>
		<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>案发地点</td>	
		<td align="left" >
	<s:textarea value="%{object.pooccuradress}" name="pooccuradress" style="width:100%;height:20px;" /></td>
	
	
	<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>当事人性质</td>	
	<td align="left">
		<c:if test="${empty object.pooccurstate}"> 
        <s:radio   value="0" listKey="key" listValue="value" id="pooccurstate" name="pooccurstate" onclick="changeoccur(this.value)" list="#{'0':'个人','1':'组织机构'}" />
        </c:if>
        <c:if test="${!empty object.pooccurstate}"> 
       	<s:radio value="%{object.pooccurstate}" listKey="key" listValue="value" id="pooccurstate" name="pooccurstate"	onclick="changeoccur(this.value)" list="#{'0':'个人','1':'组织机构'}"  />
        </c:if>

	</td>
	</tr>

</table>

</fieldset>
<div id="individual">
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>当事人信息-个人</b></legend>


<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
<tr>
<td class="addTd"><font color="red"><strong>*&nbsp;</strong></font>当事人</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.individualname}" id="indname" name="poindividual.individualname" style="width:200px;height:20px;" />
		  <input type="button" class='btn' style='z-index:200 !important;' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/punish/poindividual!list.do?','powerWindow',null);" value="选择">
		</td>
		<td class="addTd">性别</td>
	
		<td align="left">
		<select id="indsex" name="poindividual.sex">
				<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('sex')}">
						<option value="${row.key}"
						<c:if test="${object.poindividual.sex eq row.key}"> selected = "selected" </c:if> 
						<c:if test="${empty object.poindividual.sex and row.key eq '0'}"> selected = "selected" </c:if>
						>
						<c:out value="${row.value}" /></option>
					</c:forEach>
			</select>
		</td>
			<tr>
		<td class="addTd">证件号码</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.individualcode}" id="indcode" name="poindividual.individualcode" style="width:200px;height:20px;" />
		</td>
		<td class="addTd">电话</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.phone}"  id="indphone" name="poindividual.phone" style="width:200px;height:20px;" />
		</td>
		<tr>
		<td class="addTd">邮政编码</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.postcode}" id="indpost" name="poindividual.postcode" style="width:200px;height:20px;" />
		</td>
		<td class="addTd">地址</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.individualadress}" id="indaddress" name="poindividual.individualadress" style="width:100%;height:20px;" />
		</td>
			<tr>
		<td class="addTd">工作单位</td>
		<td align="left" colspan="3">
		  <s:textarea value="%{object.poindividual.workunit}" id="indworkunit" name="poindividual.workunit" style="width:300px;height:20px;" />
		</td>
	
</table>
	</fieldset>
</div>

<div id="enterprise">
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>当事人信息-组织机构</b></legend>
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
<tr>
<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>单位名称</td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.enterprisename}" id="entname" name="poenterprise.enterprisename" style="width:60%;height:20px;" />
		    <input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/punish/poenterprise!list.do?','powerWindow',null);" value="选择">
		</td>
		<td class="addTd" >机构代码 </td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.enterprisecode}" id="entcode" name="poenterprise.enterprisecode" style="width:60%;height:20px;" />
		</td>
		<tr>
		<td class="addTd" >负责人</td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.mastername}" id="entmaster" name="poenterprise.mastername" style="width:60%;height:20px;" />
		</td>
		<td class="addTd" >机构性质</td>
		<td align="left"  >
		  <select id="entunittype" name="poenterprise.unittype">
				<option value="">--请选择--</option>
				<c:forEach var="row" items="${cp:DICTIONARY('UnitType4CF')}">
					<option value="${row.key}"
					<c:if test="${object.poenterprise.unittype eq row.key}"> selected = "selected" </c:if> 
					>
					<c:out value="${row.value}" /></option>
				</c:forEach>
			</select>
		</td>
		<tr>

						<td class="addTd" >企业地址  </td>
		<td align="left"  colspan="3">
		  <s:textarea value="%{object.poenterprise.enterpriseaddress}" id="entaddress"  name="poenterprise.enterpriseaddress" style="width:60%;height:20px;" />
		</td>
		<tr>
				<td class="addTd" >传真 </td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.fax}" id="entfax"name="poenterprise.fax" style="width:60%;height:20px;" />
		</td>
						<td class="addTd" >联系人 </td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.linker}" id="entlinker" name="poenterprise.linker" style="width:60%;height:20px;" />
		</td>
<tr>
				<td class="addTd" >联系电话 </td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.phone}" id="entphone" name="poenterprise.phone" style="width:60%;height:20px;" />
		</td>

		
				<td class="addTd" >邮政编码</td>
		<td align="left"  >
		  <s:textarea value="%{object.poenterprise.postcode}" id="entpost" name="poenterprise.postcode" style="width:60%;height:20px;" />
		</td>

</table>
</fieldset>
</div>

<div id="punishInfoDiv">
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
	<legend style="padding:4px 8px 3px;"><b>处罚信息</b></legend>
		<iframe id="itemFrame" src="../punish/punishobjectbasic!refreshfacilitydes_first.do?punishobjectid=${object.punishobjectid}&documentTemplateIds=${documentTemplateIds}&isJD=${isJD}" frameborder="0" width="100%" scrolling="no" 
		 onload="this.height=window.frames['itemFrame'].document.body.scrollHeight"></iframe>
	</fieldset>
</div>
	<div align="center">
				<!-- 附件上传-->
			<iframe  name="stuffsFrame" src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotoCFsqcl.do?stuffInfo.djId=${object.punishobjectid}&stuffInfo.nodeInstId=99999&suppowerstuffinfo.groupId=103" width="100%"
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0" onload="this.height=window.frames['stuffsFrame'].document.body.scrollHeight"></iframe>	
			<!-- 附件上传-->	
			</div>
<div align="center">

<c:if test="${isJD ne 'T' }">
					<input type="button" class="btn"  onClick="check('save');" value="保存" />
					</c:if>
					<c:if test="${isJD eq 'T' }">
					<input type="button" class="btn"  id="saveAndSubmit" onClick="check('subm');"  value="保存并提交"/>
					</c:if>
 </div>
 
 </s:form>
<div id="attAlert" class="alert" style="width: 600px; height: 330px; overflow: hidden;">
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
</body>

<script>

   function getIdValue(id){
	return document.getElementById(id).value;
   }
   function getId(id){
		return document.getElementById(id);
	   }
	
   function IsPostCode(inputVal)     
	{     
	 
	    var str = inputVal; 
	     if(str.length!=0){    
	      reg=/^\d{6}$/;    
	     if(!reg.test(str)){    
	         return false;
	     }    
	    }
	    return true;    
	}
	function IsPhoneNumber(inputVal)
	{ 
	 var str=inputVal;
	 if(str.length!=0){
	   var reg=/(^[0-9]{3,4}\-[0-9]{7,8}\-[0-9]{3,4}$)|(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}\-[0-9]{3,4}$)|(^[0-9]{7,15}$)/;
	   if(!reg.test(inputVal))
	   {
	    return false;
	   }
	   return true;
	 }else{
	   return true;
	 }
	}
	function isLimitLength(value,maxlen) {
	    var flag = true;
	    var len = value.replace(/[^\x00-\xff]/g, "**").length;
	      if(len > maxlen) {
	          flag = false;
	      }
	    return flag;
	}
	function addFile(data)
	{
		var newFile = "<input type='hidden' name='fileCodes' value='"+data.id+"' >" + data.name;
		var oper = "&nbsp;&nbsp;<a href='###' onclick=\"deleteRow(this)\">[删除]</a>"; 
		var tblObj = _get("filetab");
		var len =  tblObj.rows.length; 
	    var newRow = tblObj.insertRow(len);//插入行对象 
	    var fileCell = newRow.insertCell(0); 
	    fileCell.innerHTML = newFile + oper;
	};
	function openNewWindow(winUrl,winName,winProps){
		if(winProps =='' || winProps == null){
			winProps = 'height=600px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		
		window.open(winUrl, winName, winProps);
	}
</script>


</html>


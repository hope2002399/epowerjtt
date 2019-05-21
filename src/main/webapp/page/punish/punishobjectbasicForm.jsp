<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<meta name="decorator" content='${LAYOUT}'/>
<title>案件来源登记 </title>
<style type="text/css">
	.viewTable td { width:37%; }
	.viewTable td.addTd { width:13%; }
</style>
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
				document.getElementById('impeachtype').style.display = 'block';
				document.getElementById('CaseImpeach').style.display = 'block';
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
				
				document.getElementById('impeachtype').style.display = 'none';
				document.getElementById('CaseImpeach').style.display = 'none';
			}
		

            }
             else{
			document.getElementById('CaseImpeach').style.display = 'none';
			document.getElementById('enterprise').style.display = 'none';
			document.getElementById('sea1').style.display = 'none';
			document.getElementById('sea2').style.display = 'none';
			document.getElementById('sea3').style.display = 'none';
			}
             if(getId("isrisk").value==0){
     			document.getElementById('sea1').style.display = 'none';
    			document.getElementById('sea2').style.display = 'none';
    			document.getElementById('sea3').style.display = 'none';
             }
             else if(getId("isrisk").value==1){
     			document.getElementById('sea1').style.display = 'block';
    			document.getElementById('sea2').style.display = 'block';
    			document.getElementById('sea3').style.display = 'block';
             }
		}
);
	


	function orgincheck(){
		if(document.getElementById('pooriginstate').value=='0001000070'){
		   document.getElementById('CaseImpeach').style.display = 'block';
		   getId("impeachtype").style.display='block';
		}else{
		   document.getElementById('CaseImpeach').style.display = 'none';
		   getId("impeachtype").style.display='none';
		}
	}
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
	function check(){	
	
	      if(document.forms[0].pooriginstate.value==""){
	      alert("请选择案件的来源");
		  document.forms[0].pooriginstate.focus();
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
		   
}else if(!getId("pooccurstate").checked){
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
if(getIdValue("poorigincontext")==""){
    alert("请填写来源内容");
    getId("poorigincontext").focus();
    return false;
 }
 if(getIdValue("poorigincontext")!="") {
     var flag = isLimitLength(getIdValue("poorigincontext"),140);
     if(!flag) {
         alert("输入字符过长");
         getId("poorigincontext").focus();
         return false;
     }
 }
 if(document.forms[0].poregisteropinion.value==""){
	    alert("请填写经办人意见");
	    document.forms[0].poregisteropinion.focus();
	    return false;
	 }

 if(!getId("isriskbtn").checked){
	 if (document.forms[0].riskresult.value==""){
  		alert("风险内控的手段与结果不能为空");
  		document.forms[0].riskresult.focus();
  		return false;
 }
 
 }
 }	

	function changerisk(radiovalue){
		
		if(radiovalue=="1"){
			document.getElementById('sea1').style.display = 'block';
			document.getElementById('sea2').style.display = 'block';		
			document.getElementById('sea3').style.display = 'block';		
		}
		if(radiovalue=="0"){
			document.getElementById('sea1').style.display = 'none';
			document.getElementById('sea2').style.display = 'none';
			document.getElementById('sea3').style.display = 'none';
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
</script>
</head>
<body onsubmit="submit();">
<s:form   action="punishobjectbasic"  method="post" namespace="/punish"  styleId="punishobjectbasicForm" >
<s:submit  name="savePermit"  method="savePunish" onclick="return check();"  cssClass="btn" value="保存" />
<s:submit id="saveAndSubmit" method="saveAndSubmit"  onclick="return check();" cssClass="btn" value="保存并提交"/>
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="flowCode" name="flowCode"  value="${flowCode}" />
<input type="hidden" id="occurstate" value="${object.pooccurstate}"/>
<input type="hidden" id="impeachstate" value="${object.poimpeachstate}"/>
<input type="hidden" id="originstate" value="${object.pooriginstate}"/>
<input type="hidden" name="managedepid" value="${object.managedepid}"/>
<input type="hidden" name="operatorid" value="${object.operatorid}"/>
<input type="hidden" id="optId" name="optId"  value="${object.optId}" />
<input type="hidden" id="entid" name="entid" />
<input type="hidden" id="indid" name="indid" />
<input type="hidden" id="isrisk" <c:if test="${empty object.riskresult}"> value="0"</c:if> <c:if test="${!empty object.riskresult}"> value="1"</c:if>/>
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>案件来源信息</b></legend>

<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<tr>
		<td class="addTd" >受理单位</td><td align="left">${cp:MAPVALUE("unitcode",object.managedepid)}</td>
		<td class="addTd" >受理人员</td><td align="left">${cp:MAPVALUE("usercode",object.operatorid)}</td>
	</tr>
	<tr>
		<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>案件来源</td><td align="left"  >
											<select onchange="orgincheck()" name="pooriginstate" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('CASEORIGN')}">
									<option value="${row.key}"
									 <c:if test="${object.pooriginstate eq row.key}"> selected = "selected" </c:if> 
									<c:if test="${empty pooriginstate and row.key eq '0'}"> selected = "selected" </c:if>
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select></td>
		<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>案发时间</td>	

		<td align="left">
			<sj:datepicker id="pooccurdate" 
			name="pooccurdate"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="HH:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.pooccurdate}"/>
			
			<!-- <select name="reghour">  
  <s:iterator begin="1" end="24" status="status">     
     <option <c:if test="${reghour eq status.index+1}"> selected = "selected" </c:if> value="${status.index+1}">${status.index+1}</option>    
  </s:iterator>
</select>时
<select name="regmin">  
  <s:iterator begin="1" end="60" status="status">     
     <option  <c:if test="${regmin eq status.index+1}"> selected = "selected" </c:if> value="${status.index+1}">${status.index+1}</option>    
  </s:iterator>     
</select>分
 -->
		</td>
	</tr>
	<tr>
		<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>案发地点</td>	
		<td align="left" >
	<s:textarea value="%{object.pooccuradress}" name="pooccuradress" style="width:100%;height:20px;" /></td>
	<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>当事人性质</td>	
	<td align="left" >
		<c:if test="${empty object.pooccurstate}"> 
        <s:radio   value="0" listKey="key" listValue="value" id="pooccurstate" name="pooccurstate" onclick="changeoccur(this.value)" list="#{'0':'个人','1':'组织机构'}" />
        </c:if>
        <c:if test="${!empty object.pooccurstate}"> 
       	<s:radio value="%{object.pooccurstate}" listKey="key" listValue="value" id="pooccurstate" name="pooccurstate"	onclick="changeoccur(this.value)" list="#{'0':'个人','1':'组织机构'}"  />
        </c:if>

	</td>
	</tr>
	<tr id="impeachtype" style="display:none">
	
	<td class="addTd"><font color="red"><strong>*&nbsp;</strong></font>举报人性质</td>	
	<td align="left" colspan="3">
		<c:if test="${empty object.poimpeachstate}"> 
	<s:radio value="0"  listKey="key" listValue="value" onclick="changeoccur2(this.value)" id="poistate" name="poimpeachstate"	 list="#{'0':'个人','1':'组织机构'}" />
	</c:if>
	<c:if test="${!empty object.poimpeachstate}"> 
	<s:radio value="%{object.poimpeachstate}"  listKey="key" listValue="value" onclick="changeoccur2(this.value)" id="poistate" name="poimpeachstate"	 list="#{'0':'个人','1':'组织机构'}" />
	</c:if></td>
	</tr>
	<tr>
		<td class="addTd" width="13%" ><font color="red"><strong>*&nbsp;</strong></font>来源内容</td>
		 <td align="left" colspan="3" width="87%">
		  <s:textarea value="%{object.poorigincontext}" name="poorigincontext" style="width:100%;height:40px;" />
		</td>
		</tr>
			<tr>
			<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>登记人员意见</td>
		 <td align="left" colspan="3">			
		 <s:textarea value="%{object.poregisteropinion}" name="poregisteropinion" style="width:100%;height:40px;" />
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
		  <input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/punish/appindividual!list.do?','powerWindow',null);" value="选择">
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
		  <s:textarea value="%{object.poindividual.individualcode}" id="indcode" name="poindividual.individualcode" style="width:200px;height:20px;"  onblur="getage()"/>
		</td>
		<td class="addTd">年龄</td>	
		<td align="left">
		   <s:textarea value="%{object.poindividual.age}" id="age" name="poindividual.age" style="width:200px;height:20px;" />
		</td>
		
		<tr>
		<td class="addTd">邮件编码</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.postcode}" id="indpost" name="poindividual.postcode" style="width:200px;height:20px;" />
		</td>
		<td class="addTd">电话</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.phone}"  id="indphone" name="poindividual.phone" style="width:200px;height:20px;" />
		</td>
		
			<tr>
		<td class="addTd">工作单位</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.workunit}" id="indworkunit" name="poindividual.workunit" style="width:300px;height:20px;" />
		</td>
		<td class="addTd">住址</td>
		<td align="left">
		  <s:textarea value="%{object.poindividual.individualadress}" id="indaddress" name="poindividual.individualadress" style="width:100%;height:20px;" />
		</td>
		</tr>
	
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
		    <input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/punish/appenterprise!list.do?','powerWindow',null);" value="选择">
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
				  		  			<select id="entunittype" name="poenterprise.unittype" style="width:30%" value="%{object.poenterprise.unittype}">
				<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('UnitType4CF')}">
						<option value="${row.key}"
						<c:if test="${object.poenterprise.unittype eq row.key}"> selected = "selected" </c:if> 
						<c:if test="${empty object.poenterprise.unittype and row.key eq '0'}"> selected = "selected" </c:if>
						>
						<c:out value="${row.value}" /></option>
					</c:forEach>
			</select>
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
</tr>
<tr>

						<td class="addTd" >地址  </td>
		<td align="left"  colspan="3">
		  <s:textarea value="%{object.poenterprise.enterpriseaddress}" id="entaddress"  name="poenterprise.enterpriseaddress" style="width:60%;height:20px;" />
		</td>
		</tr>
</table>
</fieldset>
</div>


<div id="CaseImpeach">
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>举报人信息-</b><b id="jbtype">个人</b></legend>

<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<tr>
		<td class="addTd"  id="jbrxm">举报人姓名	</td>
		<td align="left" >
		  <s:textarea value="%{object.pocaseimpeachname}" id="pocaseimpeachname" name="pocaseimpeachname" style="width:30%;height:20px;" />
		  <input type="checkbox" name="niming" onclick="setvalue(this);">
								匿名
		</td>
		<td class="addTd" id="lxdh">举报人联系电话</td>
		<td align="left" >			
		 <s:textarea value="%{object.pocaseimpeachphone}" id="pocaseimpeachphone" name="pocaseimpeachphone"  style="width:80%;height:20px;"/>
		</td>
	</tr>
	<tr>
			 <td class="addTd"  id="dz">举报人地址</td>	
		 <td>	
		 <s:textarea value="%{object.pocaseimpeachadress}" id="pocaseimpeachadress"  name="pocaseimpeachadress" style="width:80%;height:20px;" />
		 </td>
		 		  <td class="addTd" id="yb">举报人邮编</td>	<td>		
		  <s:textarea value="%{object.pocaseimpeachpostcode}"  name="pocaseimpeachpostcode" style="width:30%;height:20px;" />
	</tr>

	<tr id="tr1">
		<td class="addTd" >举报人性别</td><td >
			<select name="pocaseimpeachsex" style="width:30%">
				<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('sex')}">
						<option value="${row.key}"
						<c:if test="${object.pocaseimpeachsex eq row.key}"> selected = "selected" </c:if> 
						<c:if test="${empty object.pocaseimpeachsex and row.key eq '0'}"> selected = "selected" </c:if>
						>
						<c:out value="${row.value}" /></option>
					</c:forEach>
			</select>
		</td>
		<td class="addTd" >举报人年龄</td>
		<td align="left"  >
	     <s:textarea  value="%{object.pocaseimpeachage}" name="pocaseimpeachage" style="width:30%;height:20px;" /></td>

		</tr>

		<tr id="tr2">
				<td class="addTd" >举报人工作单位</td><td>			
		 <s:textarea value="%{object.pocaseimpeachunit}" name="pocaseimpeachunit" style="width:80%;height:20px;" />
		</td>
						<td class="addTd" >举报人身份证号码</td><td align="left">			
		 <s:textarea  value="%{object.pocaseimpeachid}" name="pocaseimpeachid" style="width:80%;height:20px;" />
		</td>
	</tr>

</table>

</fieldset>


</div>



<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>风险点信息</b></legend>

<table border="0" cellpadding="0" cellspacing="0" id="viewTable">
	<tr>
		<td class="addTd" >是否风险点</td>
		<td align="left" colspan="3">
		<c:if test="${empty object.riskresult}"> 
        <s:radio   name="isriskbtn" id="isriskbtn" value="0" listKey="key" listValue="value"  onclick="changerisk(this.value);"list="#{'0':'否','1':'是'}" />
        </c:if>
        <c:if test="${!empty object.riskresult}"> 
        <s:radio   name="isriskbtn" id="isriskbtn" value="%{isrisk}" listKey="key" listValue="value"  onclick="changerisk(this.value);"list="#{'0':'否','1':'是'}" />
        </c:if>
		</td>
		<tr id="sea1">
		<td class="addTd" >风险点类别</td>
		<td align="left" colspan="3">	
	     <s:textarea value="%{object.risktype}" name="risktype" style="width:100%;height:40px;" /></td>
	     </tr>
	     <tr id="sea2">
		 <td class="addTd" >风险点描述</td>	
		  <td align="left" colspan="3">	
		 <s:textarea value="%{object.riskdesc}" name="riskdesc" style="width:100%;height:40px;" />
		 </td>
	</tr>
	<tr id="sea3">
		 <td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>风险内控的手段与结果</td>	
		 <td align="left" colspan="3"><s:textarea value="%{object.riskresult}" name="riskresult" style="width:60%;height:40px;" /></td>	
		 </tr>	
        <tr> <td class="addTd">备 注</td>
          <td align="left" colspan="3">		
		 <s:textarea value="%{object.remark}" name="remark" style="width:100%;height:40px;" />
		</td>
		</tr>
	
</table>

</fieldset>
			<!-- 附件上传-->
			<iframe  id="basicsj" name="sjfj" src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotoCFsqcl.do?stuffInfo.djId=${object.punishobjectid}&stuffInfo.nodeInstId=0&suppowerstuffinfo.groupId=103" width="100%"
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0" onload="this.height=window.frames['sjfj'].document.body.scrollHeight"></iframe>	
			<!-- 附件上传-->	
				
			

</s:form>

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
	function getage(){
     if(!isIdCardNo()){
    	$("#indcode").attr("value","");
    	$("#age").attr("value","");
    	return;
     }
 	var personcode=$("#indcode").val();
     if(personcode!=null&&personcode!=""){
		var date=new Date();
		$("#age").attr("value",date.getFullYear()-personcode.substring(6,10));
		}
	}
	function isIdCardNo(){ 
		var num = document.forms[0].indcode.value;
		if(num!=null&&num!=""){
		var len = num.length;
		var re; 
		if (len == 15) 
			re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/); 
		else if (len == 18) 
			re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d)$/); 
		else {
			alert("身份证号码输入的数字位数不对！"); 
			return false;
		} 
		var a = num.match(re); 
		if (a != null){ 
			if (len == 15){ 
				var D = new Date("19" + a[3] + "/" + a[4] + "/" + a[5]); 
				var B = D.getYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5]; 
			} 
			else{ 
				var D = new Date(a[3] + "/" + a[4] + "/" + a[5]); 
				var B = D.getFullYear() == a[3] && (D.getMonth() + 1) == a[4] && D.getDate() == a[5]; 
			} 
			if (!B){
				alert("输入的身份证号 "+ a[0] + " 里出生日期不对！"); 
				return false;} 
		} 
	
		}
		return true; 
	} 

</script>
</html>


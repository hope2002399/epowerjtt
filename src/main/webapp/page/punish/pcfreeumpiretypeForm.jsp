<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<script type="text/javascript">
$(document).ready(
function(){
	if("${object.israte}"==1){
		_get("israte").checked=true;
	}}
);
</script>
<title></title>
<sj:head locale="zh_CN" />
</head>
<c:if test="${isPctype eq 1}">	
    <body onload="doChange();">
</c:if>
	<c:if test="${isPctype eq 0}">	 
	<body>
</c:if> 

<%@ include file="/page/common/messages.jsp"%>
<input id="isPctype" type="hidden" name="isPctype" value="${isPctype}" >

<c:if test="${isPctype eq 1}">
<s:form action="pcfreeumpiretype!save.do"  method="post" namespace="/punish" name="pcfreeumpiretypeForm" id="pcfreeumpiretypeForm">
        <input type="hidden"  name="punishclassid"  id="punishclassid"  value="${object.punishclassid}" />
    	<input type="hidden"  name="degreeno"  id="degreeno"  value="${object.degreeno}" />
    	<input type="hidden"  name="standardNo"  id="standardNo"  value="${pcfreeumpiredegree.standardNo}" />
    			<%--  <input type="hidden"  name="israte"  id="israte"  value="${pctype.israte}" />  --%>
		<input id="isEdit" type="hidden" name="isEdit" value="${isEdit}" />
    <table border="0" cellpadding="0" cellspacing="0" class="viewTable">
   
					  <c:forEach var="row" items="${cp:DICTIONARY('punishType')}">
						<c:if test="${object.punishtypeid eq row.key}">
						<c:set var="punishtypename" value="${row.value}" />
						</c:if>
					</c:forEach>
				<tr>
				<td class="addTd">处罚种类选择</td>
				<td align="left">
				<c:if test="${empty object.punishtypeid }">
				<select name="punishtypeid" id="punishtypeid"  onchange="changPaperType();" >
                             <option value="">--请选择--</option>
						<c:forEach var="row" items="${flowDescribesList}">
							<option value="${row.value}"
								<c:if test="${object.punishtypeid eq row.value}"> selected = "selected" </c:if>>
								<c:out value="${row.label}" />
							</option>
						</c:forEach>
				</select> <span style="color: red">*</span>
				</c:if>
				
				<c:if test="${not empty object.punishtypeid }">
				<input type="hidden"  name="punishtypeid"  id="punishtypeid"  value="${object.punishtypeid}" />
				${punishtypename}
				</c:if>
				
				  <div id="israteDiv"  style="display:none;">
				   <s:checkbox name="rate"    onclick="doChange();" id="israte"  disabled="true">按比例计算</s:checkbox> 
			      </div>	

                         </td>
                       </tr>      
				<tr id="punishmin_tr">
				        <td class="addTd">
						处罚下限
				       </td>
					<td align="left" >
						<s:textfield name="punishmin" value="%{object.punishmin}"/>
					</td>
				</tr>
				<tr id="punishmax_tr">
					 <td class="addTd">
						处罚上限
					</td>
					<td align="left" >
						<s:textfield name="punishmax"  value="%{object.punishmax}" />
					</td>
				</tr>
				
				<tr id="radixname_tr">
					<td class="addTd">
						基数名称
					</td>
					<td align="left" >
						<s:textfield name="radixname"  value="%{object.radixname}"/>
					</td>
				</tr>
				<tr id="radixunit_tr">
					<td class="addTd">
						基数单位
					</td>
					<td class="addTd">
						<s:textfield name="radixunit" value="%{object.radixunit}" />
					</td>
				</tr>  
             <tr>
				<td class="addTd">
					处罚内容
				</td>
				<td align="left" colspan="3">
					<s:textarea name="punishcontent"  value="%{object.punishcontent}" />
				</td>
			</tr>
		</table>
			
					<%--  <s:submit  value="保存"  method="save" onclick="submitview();" cssClass="btn"  />   --%>
				 <input type="button" onclick="saveForm()" Class="btn"  value="保存"/> 
	             <input type="button" Class="btn" onclick="back()" value="返回"/> 	
	</s:form>
</c:if>



<c:if test="${isPctype eq 0}">	
	<s:form action="pcfreeumpiretype!save.do" method="post" namespace="/punish" name="pcfreeumpiretypeForm" id="pcfreeumpiretypeForm">
    <input id="punishclassid" type="hidden" name="punishclassid" value="${object.punishclassid}" />
      <input id="punishtypeid" type="hidden" name="punishtypeid" value="${object.punishtypeid}" />
      <input id="punishmin" type="hidden" name="punishmin" value="${pctype.punishmin}" />
      <input id="punishmax" type="hidden" name="punishmax" value="${pctype.punishmax}" />
      <input id="radixname" type="hidden" name="radixname" value="${pctype.radixname}" />
      	<input type="hidden"  name="israte"  id="israte"  value="${pctype.israte}" />
      		<input type="hidden"  name="rate"  id="rate"  value="${rate}" />
      <input id="punishcontent" type="hidden" name="punishcontent" value="${pctype.punishcontent}" />
      	<input id="isEdit" type="hidden" name="isEdit" value="${isEdit}"/>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
                   
			 	<tr>
					<td class="addTd">
					违法程度名称
					</td>
					<td align="left">
				<c:if test="${ empty object.degreeno }">
				<select name="degreeno" id="degreeno" >
                             <option value="">--请选择--</option>
						<c:forEach var="row" items="${flowDescribesList}">
							<option value="${row.value}"
								<c:if test="${object.degreeno eq row.value}"> selected = "selected" </c:if>>
								<c:out value="${row.label}" />
							</option>
						</c:forEach>
				</select> <span style="color: red">*</span>
				</c:if>
				<c:if test="${not empty object.degreeno }">
				${pcfreeumpiredegree.punishfactgrade}
				</c:if>
				</td>
				</tr>

				<tr>
					<td class="addTd">
						自由裁量编码
					</td>
					<td align="left">
							 <s:textfield   name="standardNo"  value="%{object.standardNo}" /> 
					</td>
				</tr>
</table>

		       <input type="button" onclick="saveForm()" Class="btn"  value="保存"/>
	           <input type="button" Class="btn" onclick="back()" value="返回"/> 	
</s:form>
	
	</c:if>
</body>


<script>

		var _get = function (id) {
		 	return document.getElementById(id);
		 };

  //保存业务数据，在提交办理的时候，同时刷新两个iframe
   function submitview(){
		/*  window.parent.frames['view'].document.forms[0].submit(); */
	 
	window.parent.frames['view'].location.reload(); 
	 /*   parent.view.location.reload(); */
	
    }
  function saveForm(){
	  var punishtypeid="${pctype.cid.punishtypeid}";
	  if(punishtypeid=="0000000037" || punishtypeid=="0000000038" 
			|| punishtypeid=="0000000040" ){
	  var punishmin="${pctype.punishmin}";
	  var punishmax="${pctype.punishmax}";
	  var punishminform=_get("punishmin").value;
	  var punishmaxform=_get("punishmax").value;
	  if(!isNumber(punishminform)||!isNumber(punishmaxform)){
		  alert("请输入合法数据");	  
	  }
	  if(parseInt(punishminform)>parseInt(punishmaxform)){
		  alert("处罚下限不能大于处罚上限");
		  return;
	  }
	  if(parseInt(punishminform)<parseInt(punishmin)){
		  alert("处罚下限小于处罚项目最低数值");
		  return;
	  }
	  if(parseInt(punishmaxform)>parseInt(punishmax)){
		  alert("处罚上限大于处罚项目最高数值");
		  return;
	  }
	  }
	  $('#pcfreeumpiretypeForm').submit();
	  //document.pcfreeumpiretypeForm.submit();
	  var punishclassid=_get("punishclassid").value;
	  var punishtypeid=_get("punishtypeid").value;
	  var degreeno=_get("degreeno").value;
	  var isPctype=_get("isPctype").value;
	  var url;
	  if(isPctype==1){
	   url="punish/pcfreeumpiretype!list.do?punishclassid="+ punishclassid+"&degreeno="+degreeno;
     }
     if(isPctype==0){
    	  url="punish/pcfreeumpiretype!list.do?punishclassid="+ punishclassid+"&punishtypeid="+punishtypeid;
     }
	  parent.document.location.href = url;	
  } 
   function changeFreeInfo(punishclassid){
		var punishtypeid = document.getElementById("punishtypeid");
		var url="punish/pcfreeumpiretype!changeFreeInfo.do?punishclassid="+ punishclassid+"&punishtypeid="+punishtypeid;
 	   document.location.href = url;
	}   
	function savepcfreeunpiretype(punishclassid){
		var url="punish/pcfreeumpiretype!save.do?punishclassid="+ punishclassid;
 	   document.location.href = url;
	}   

	function docheck() {
		if($("#punishtypeid").val()==''){
			alert("请选择处罚种类");
			$('#punishtypeid').focus();
			return false;
		}
		return true;
	}
	
	 
   
 	//对不同的处罚种类对应不同的文本框
  	function changPaperType() {
  		var punishtypeid = _get("punishtypeid").value;
		var degreeno=_get("degreeno").value;	
		var punishclassid=_get("punishclassid").value;
 		var href="punish/pcfreeumpiretype!edit.do?punishtypeid="+punishtypeid+"&isPctype=1&degreeno="+degreeno+"&punishclassid="+punishclassid;
 		window.location.href=href;
 		return;
 		
 		    	

 	}	
  	function doChange(){
  		var punishtypeid = _get("punishtypeid");
  		if (punishtypeid.value=="0000000037" || punishtypeid.value=="0000000038" 
				|| punishtypeid.value=="0000000040"  ) { //处罚。。
			/* document.getElementById("punishDiv").style.display = 'block'; */
			_get("punishmin_tr").style.display = "block";
			_get("punishmax_tr").style.display = "block";
			/* _get("israte").style.display = 'none'; */
			_get("radixname_tr").style.display = "none";
			 _get("radixunit_tr").style.display = "none"; 
			if(punishtypeid.value =="0000000037" ){
				_get("israteDiv").style.display = "block";
			}
			if(punishtypeid.value !="0000000037" ){
				_get("israteDiv").style.display = "none";
			}
		} else {
			_get("punishmax_tr").style.display = "none";	
			_get("punishmin_tr").style.display = "none";
			_get("radixname_tr").style.display = "none";
			 _get("radixunit_tr").style.display = "none"; 
			 _get("israteDiv").style.display = "none";
		}
 
  parent.document.all("edit").style.height=document.body.scrollHeight; 
  		var israte="${pctype.israte}";
  		if(israte=='1'){
  			_get("israte").checked=true;
  		}else{
  			_get("israte").checked=false;
  		}
  		var punishtypeid = _get("punishtypeid").value;
  
			if(punishtypeid =="0000000037" ){
 				_get("israteDiv").style.display = "block";
 			}
 			if(punishtypeid!="0000000037" ){
 				_get("israteDiv").style.display = "none";
 			}
		if(_get('israte').checked){ 			
 			_get("radixname_tr").style.display = "block";
 			 _get("radixunit_tr").style.display = 'block'; 
  		}
  		else { 					
 			_get("radixname_tr").style.display = "none";
 			 _get("radixunit_tr").style.display = 'none'; 
  		}
  	
  	 parent.document.all("edit").style.height=document.body.scrollHeight;  

  	}
  	
  	function back(){
  		var punishclassid="${punishclassid}";
  		var href="punish/pcdef!edit.do?punishclassid="+punishclassid;
  		parent.location.href=href;
  	}
  	function isNumber(inputVal) {
		oneDecimal = false;
		if(inputVal=="")
		  return false;
		inputStr = inputVal.toString();
		for (var i = 0; i < inputStr.length; i++) {
			var oneChar = inputStr.charAt(i);
			if (i == 0 && oneChar == "-") {
				continue;
			}
			if (oneChar == "." && !oneDecimal) {
				oneDecimal = true;
				continue;
			}
			if (oneChar < "0" || oneChar > "9") {
				return false;
			}
		}
		return true;
	}
</script>
</html>

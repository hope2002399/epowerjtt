<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
<title>执法车辆管理</title>
</head>
<script type="text/javascript">
/**
 * common window dialogs
 */

</script>
<body>
<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">

<legend style="padding:4px 8px 3px;"><b>车辆信息</b></legend>
<s:form action="lawVehicle" method="post" namespace="/powerbase" id="lawVehicleForm" enctype="multipart/form-data">
			<s:submit name="save" method="lawsave" cssClass="btn" key="opt.btn.save" onclick="return checkInput();" />
			<input type="hidden" id="vehicleId" name="vehicleId" value="${vehicleId}"/>
 			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /> 
              <table border="0" cellpadding="0" cellspacing="0" class="viewTable">
              <tr>
					<td class="addTd" width="130">
						<s:text name="lawVehicle.plateNumber" />
					</td>
					<td >
						苏<select id="diqu" name="diqu">
						<option value="A" <c:if test='${fn:substring(object.plateNumber,1,2) eq "A"}'>selected</c:if>>A</option>
						<option value="B" <c:if test='${fn:substring(object.plateNumber,1,2) eq "B"}'>selected</c:if>>B</option>
						<option value="C" <c:if test='${fn:substring(object.plateNumber,1,2) eq "C"}'>selected</c:if>>C</option>
						<option value="D" <c:if test='${fn:substring(object.plateNumber,1,2) eq "D"}'>selected</c:if>>D</option>
						<option value="E" <c:if test='${fn:substring(object.plateNumber,1,2) eq "E"}'>selected</c:if>>E</option>
						<option value="F" <c:if test='${fn:substring(object.plateNumber,1,2) eq "F"}'>selected</c:if>>F</option>
						<option value="G" <c:if test='${fn:substring(object.plateNumber,1,2) eq "G"}'>selected</c:if>>G</option>
						<option value="H" <c:if test='${fn:substring(object.plateNumber,1,2) eq "H"}'>selected</c:if>>H</option>
						<option value="J" <c:if test='${fn:substring(object.plateNumber,1,2) eq "J"}'>selected</c:if>>J</option>
						<option value="K" <c:if test='${fn:substring(object.plateNumber,1,2) eq "K"}'>selected</c:if>>K</option>
						<option value="L" <c:if test='${fn:substring(object.plateNumber,1,2) eq "L"}'>selected</c:if>>L</option>
						<option value="M" <c:if test='${fn:substring(object.plateNumber,1,2) eq "M"}'>selected</c:if>>M</option>
						<option value="N" <c:if test='${fn:substring(object.plateNumber,1,2) eq "N"}'>selected</c:if>>N</option>
						
						</select><input type="text" id="plateNumber1" name="plateNumber1" value="${fn:substring(object.plateNumber,2,7)}" style="width:105px;">
						<input type="hidden" id="plateNumber" name="plateNumber" value="${object.plateNumber}" style="width:300px;">
						<c:if test="${empty vehicleId}">
						<s:submit method="checkplateNumber" value="验证车牌号" cssClass="btn" name="check" onclick="return checkcheh();"/>
						</c:if>
					</td>
		
					<td class="addTd" width="130">
					<s:text name="lawVehicle.vehicleType" />
					</td>
					<td >
						<input type="text" id="vehicleType" name="vehicleType" value="${object.vehicleType}" style="width:300px;">
  						
					</td>
				</tr>

					<tr>
					<td class="addTd" width="130">
					<s:text name="lawVehicle.ownerUnit" />
					</td>
					<td >
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',object.ownerUnit)}"/>
					<input type="hidden" id="ownerUnit" name="ownerUnit" value="${object.ownerUnit}"/>
					</td>
					<td class="addTd" width="130">
					<s:text name="lawVehicle.vehicleAdmin" />
					</td>
					<td >
						<input type="text" id="vehicleAdmin" name="vehicleAdmin" value="${object.vehicleAdmin}" style="width:300px;" >
					</td>
				</tr>	
			
				<tr>
					<td class="addTd" width="130"><s:text name="lawVehicle.purchaseDate" />
					</td>
					<td >
						<sj:datepicker id="purchaseDate" name="purchaseDate"  style="width:140px"
			yearRange="2000:2020"  displayFormat="yy-mm-dd" changeYear="true"  timepicker="false" maxDate="%y-%M-%d"
			value="%{object.purchaseDate}"/>
			</td>
				<td class="addTd" width="130"><s:text name="lawVehicle.purchasePrice" />
					</td>
			        <td >
						<input type="text" id="purchasePrice" name="purchasePrice" value="${object.purchasePrice}" style="width:300px;">
  						
					</td>
				</tr>
				<tr>
			<td class="addTd" width="130"><s:text	name="lawVehicle.engineNo" />
					</td>
			        <td >
						<input type="text" id="engineNo" name="engineNo" value="${object.engineNo}" style="width:300px;">
  						
					</td>
					<td class="addTd" width="130"><s:text	name="lawVehicle.carframeNo" />
					</td>
			        <td >
						<input type="text" id="carframeNo" name="carframeNo" value="${object.carframeNo}" style="width:300px;">
  						
					</td>
				</tr>
						<tr>
					<td class="addTd" width="130"><s:text 	name="lawVehicle.recorder" /></td>
					<td align="left" ><input type="hidden" id="recorder" name="recorder"
								value="${object.recorder}" />
					<s:property value="%{object.recorder}" /></td>
					<td class="addTd" width="130"><s:text	name="lawVehicle.recordDate" /></td>
					<td align="left" ><s:date name="recordDate"
							format="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				
</table>
</s:form>
</fieldset>

</body>
<script type="text/javascript">
	 var menuList = ${unitsJson};
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			var key = $this.attr("rel");
			for (var i=0; i<menuList.length; i++) {
				if (key == menuList[i].MID) {
					o2.val(menuList[i].depno);
				}
			}
			if(getID("shadow")){
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}
$("#orgName").bind('click',function(){
	var menuList = ${unitsJson};
	var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
	if(getID("shadow")){
		$("#shadow").show();
		$("#boxContent").show();
	}else{
		$("body").append(shadow);
		$("#shadow").height(document.body.scrollHeight);
		setTimeout(function(){
			menuDisplay(menuList,"${parentunit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#ownerUnit"),$this);
		$("#lists span").die("click");
	});
});

function checkcheh(){
	if(!/^[A-Z0-9]+$/.test($("#plateNumber1").val())) {
		alert("车牌号后五位请填写大写字母和数字。");
		$("#plateNumber1").focus();
		return false;
	}else if($("#plateNumber1").val().length != 5){
		alert("车牌号位数不对。");
		$("#plateNumber1").focus();
		return false;
	}else{
		var diqu=$("#diqu").val();
		var chehao=$("#plateNumber1").val();
		$("#plateNumber").val("苏"+diqu+chehao);
		//alert($("#plateNumber").val());
	}
}
function checkInput() {
	if(!/^[A-Z0-9]+$/.test($("#plateNumber1").val())) {
		alert("车牌号后五位请填写大写字母和数字。");
		$("#plateNumber1").focus();
		return false;
	}else if($("#plateNumber1").val().length != 5){
		alert("车牌号位数不对。");
		$("#plateNumber1").focus();
		return false;
	}else{
		var diqu=$("#diqu").val();
		var chehao=$("#plateNumber1").val();
		$("#plateNumber").val("苏"+diqu+chehao);
		//alert($("#plateNumber").val());
	}
		
	var reg = /^[\u4E00-\u9FA5]+$/;
	if(!reg.test($("#vehicleAdmin").val())){ 
		alert("所属管理人员必须为中文。");
		$("#vehicleAdmin").focus();
		return false;
	}
	
	var purchaseDate = new Date($("#purchaseDate").val());
	if (purchaseDate> new Date()) {
		alert("购买日期不可在当前时间之后。");
		$("#purchaseDate").focus();
		return false;
	}
	
	if(isNaN($("#purchasePrice").val())){
		alert("购买价格必须为正确的数字。");
		$("#purchasePrice").focus();
		return false;
	}else if ($("#purchasePrice").val()<0){
		alert("购买价格必须大于0。");
		$("#purchasePrice").focus();
		return false;
	}
		
	if(/.*[\u4e00-\u9fa5]+.*$/.test($("#engineNo").val())) {
		alert("车辆发动机号不能含有中文。");
		$("#engineNo").focus();
		return false;
	}
		
	if(/.*[\u4e00-\u9fa5]+.*$/.test($("#carframeNo").val())) {
		alert("车辆车架号不能含有中文。");
		$("#carframeNo").focus();
		return false;
	}
}

</script>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/css.jsp"%>
<%@ taglib uri="http://www.centit.com/el/coderepo" prefix="cp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title><c:out value="ecProject.list.title" /></title>
		<sj:head locale="zh_CN" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/json2.js"></script>
		<script src="${pageContext.request.contextPath}/scripts/centitui/jquery-1.7.2.min.js" type="text/javascript"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/tree/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/tree/demo.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.core-3.5.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.excheck-3.5.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.exedit-3.5.min.js"></script>
		<SCRIPT type="text/javascript">
		<!--
		var nodeNow;
		var setting = {
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeDrop: beforeDrop,
				onClick:clickTree
			}
		};

		//节点点击事件
		function clickTree(event, treeId, treeNode, clickFlag){
			nodeNow=treeNode;
			if(treeNode.ifPrimary=="T"){
				$("#ifPrimary").attr("checked",true);
			}else{
				$("#ifPrimary").attr("checked",false);
			}
			if(treeNode.ifMust=="T"){
				$("#ifMust").attr("checked",true);
			}else{
				$("#ifMust").attr("checked",false);
			}
			if(treeNode.ifHidden=="T"){
				$("#ifHidden").attr("checked",true);
			}else{
				$("#ifHidden").attr("checked",false);
			}
			if(treeNode.ifAlong=="T"){
				$("#ifAlong").attr("checked",true);
			}else{
				$("#ifAlong").attr("checked",false);
			}
			////jwy添加
			$("#evlType").val(treeNode.evlType);
			$("#evlMethod").val(treeNode.evlMethod);
			if (!treeNode.isParent&&treeNode.inputType!='02'&&treeNode.inputType!='03') {
					$("#ifCp").attr("disabled",false);
					alert(1);
					if(treeNode.ifCp=="T"){
						$("#ifCp").attr("checked",true);
						$(".cp_tr").each(function(){
							this.style.display="block";
						});
						if($("#evlType").val()=='03'){
							$("#evlType").hide();
							$("#szbtn").show();
						}
						else
							$("#evlType").show();
					}
				else{
					$("#ifCp").attr("checked",false);
					$(".cp_tr").each(function(){
						this.style.display="none";
				});
				}
			}
			////
			if(nodeNow.writeBacktable!=undefined){
				$("#writeBacktable").val(nodeNow.writeBacktable);
			}else{
				$("#writeBacktable").val("");
			}
			if(nodeNow.writeBackIndicator!=undefined){
				$("#writeBackIndicator").val(nodeNow.writeBackIndicator);
			}else{
				$("#writeBackIndicator").val("");
			}
			$("#indicatorName").text(treeNode.indicatorName);
			$("#indicatorId").val(treeNode.indicatorId);
			$("#dictionaryId").text(treeNode.dictionaryId);
			$("#indicatorNickName").text(treeNode.indicatorNickName);
			$("#inputtype").val(treeNode.inputType);
			//获取父级指标信息
			var parentNode = treeNode.getParentNode();
			if(parentNode!=null){
				$("#fatherName").text(parentNode.indicatorName);
			}else{
				$("#fatherName").text("");
			}
			//级联指标
			/* var cascadeNode=treeNodes.getNodeByParam("id", treeNode.cascadeId);
			if(cascadeNode!=null){
				$("#cascadeName").text(cascadeNode.name);
			}else{
				$("#cascadeName").text("");
			} */
			$(".hasLower").each(function(){
				if(this.id==treeNode.hasLower){
					this.style.display="block";
				}else{
					this.style.display="none";
				}
			});
			$(".ifCascade").each(function(){
				if(this.id==treeNode.ifCascade){
					this.style.display="block";
				}else{
					this.style.display="none";
				}
			});
			$(".ifDictionary").each(function(){
				if(this.id==treeNode.ifDictionary){
					this.style.display="block";
				}else{
					this.style.display="none";
				}
			});
			$(".inputType").each(function(){
				if(this.id==treeNode.inputType){
					this.style.display="block";
				}else{
					this.style.display="none";
				}
			});
		}
		function beforeDrag(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;
		}
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			return targetNode ? targetNode.drop !== false : true;
		}
		
		$(document).ready(function(){
			$.ajax({
				   type : 'post',
				   url: "${pageContext.request.contextPath}/indicator/pmTemplet!templetEdit.do",
				   dataType:"json",
				   async:false,
				   data:{
					   "object.templetId":$("#templetId").val()
				   },
				   success: function(data){
					   var nowIndicators=data.nowIndicators;
					   var allIndicators=data.allIndicators;
					   var templet=data.templet;
					   if(templet!=null){
						   $("#templetCode").val(templet.templetCode);
						   $("#templetName").val(templet.templetName);
						   $("#templetType").val(templet.templetType);
						   $("#jspName").val(templet.jspName);
						   $("#jspHtml").val(templet.jspHtml);
						   $("#templetId").val(templet.templetId);
					   }
					   if(allIndicators!=null&&allIndicators.length>0){
						   for(var i=0;i<allIndicators.length;i++){
							   allIndicators[i].id=allIndicators[i].indicatorId;
							   allIndicators[i].pId=allIndicators[i].fatherId;
							   allIndicators[i].name=allIndicators[i].indicatorName;
							   if(allIndicators[i].hasLower=="01"){
								   allIndicators[i].isParent=true;
							   }
							   //else{
								//   allIndicators[i].dropInner=false;
							   //}
							  $.fn.zTree.init($("#treeDemo"), setting, allIndicators);
						   }
					   }else{
						   $.fn.zTree.init($("#treeDemo"), setting);
					   }
					   if(nowIndicators!=null&&nowIndicators.length>0){
						   for(var i=0;i<nowIndicators.length;i++){
							   nowIndicators[i].id=nowIndicators[i].indicatorId;
							   nowIndicators[i].pId=nowIndicators[i].fatherId;
							   nowIndicators[i].name=nowIndicators[i].indicatorName;
							   if(nowIndicators[i].hasLower=="01"){
								   nowIndicators[i].isParent=true;
							   }
							   //else{
								//   nowIndicators[i].dropInner=false;
							   //}
							  $.fn.zTree.init($("#treeDemo2"), setting, nowIndicators);
						   }
					   }else{
						   $.fn.zTree.init($("#treeDemo2"), setting);
					   }
					}
				});
		});
		function checkMe(temp){
			if(nodeNow==undefined){
				temp.checked=false;
				return;
			}
			if(temp.id=="ifAlong"){
				if(temp.checked){
					nodeNow.ifAlong="T";
				}else{
					nodeNow.ifAlong="F";
				}
			}
		////jwy添加
			if(temp.id=="ifCp"){
				if(temp.checked){
					nodeNow.ifCp="T";
					if($("#inputtype").val()=='04'||$("#inputtype").val()=='05'||$("#inputtype").val()=='06'){
						$("#evlType").css("display","none");
						$("#evlType").val('03');
						$("#szbtn").show();
					}
					if($("#inputtype").val()=='01'){
						$("#evlType").show();
						$("#evlType").val('');
						$("#szbtn").hide();
					}
					$(".cp_tr").each(function(){
						this.style.display="block";
				});
				}else{
					nodeNow.ifCp="F";
					$(".cp_tr").each(function(){
						this.style.display="none";
				});
				}
			}
		////jwy添加
			if(temp.id=="ifPrimary"){
				if(temp.checked){// 如果主键被选中 那么该指标必须隐藏 必填被取消
					nodeNow.ifPrimary="T";
					nodeNow.ifHidden="T";
					nodeNow.ifMust="F";
					$("#ifMust").attr("checked",false);
					$("#ifHidden").attr("checked",true);
				}else{
					nodeNow.ifPrimary="F";
				}
			}else if(temp.id=="ifMust"){//如果该指标已经选中隐藏 那么该指标必填选项不可选
				if(temp.checked&&!$("#ifHidden").attr("checked")&&!$("#ifPrimary").attr("checked")){
					nodeNow.ifMust="T";
				}else{
					$("#ifMust").attr("checked",false);
					nodeNow.ifMust="F";
				}
			}else if(temp.id=="ifHidden"){
				if(temp.checked||$("#ifPrimary").attr("checked")){//如果该指标已被选为主键，那么隐藏不可取消，并且必填不可选中
					nodeNow.ifMust="T";
					nodeNow.ifMust="F";
					temp.checked=true;
					$("#ifMust").attr("checked",false);
				}else{
					nodeNow.ifMust="F";
				}
			}
		}
		function witeMe(temp){
			if(nodeNow==undefined){
				temp.value="";
				return;
			}
			if(temp.id=="writeBacktable"){
				nodeNow.writeBacktable=$.trim($("#writeBacktable").val());
			}else if(temp.id=="writeBackIndicator"){
				nodeNow.writeBackIndicator=$.trim($("#writeBackIndicator").val());
			}
			else if(temp.id=="evlType"){
				nodeNow.evlType=$.trim($("#evlType").val());
				alert($("#evlMethod").val());
				nodeNow.evlMethod=$.trim($("#evlMethod").val());
			}
			else if(temp.id=="evlMethod"){
				nodeNow.evlType=$.trim($("#evlType").val());
				nodeNow.evlMethod=$.trim($("#evlMethod").val());
			}
			if(nodeNow.writeBacktable!=undefined&&nodeNow.writeBackIndicator!=undefined&&nodeNow.writeBacktable!=""&&nodeNow.writeBackIndicator!=""){
				nodeNow.ifWriteBack="T";
			}else{
				
				nodeNow.ifWriteBack="F";
			}
		}
		function templetSave(){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo2");
			var nodes=zTree.getNodes();
			alert(nodes)
			var templetType=$("#templetType").val();
			var jspName=$("#jspName").val();
			var templetName=$("#templetName").val();
			var templetCode=$("#templetCode").val();
			var year=$("#year").val();
			var jspHtml=$("#jspHtml").val();
			var nodesJson=JSON.stringify(nodes);
			if(templetName==""){
				alert("请输入模版名称！");return;
			}
			if(templetCode==""){
				alert("请输入模版编码！");return;
			}
			if(templetType==""){
				alert("请选择模版类型！");return;
			}
			if(jspName==""){
				alert("请输入JSP名称！");return;
			}
			if(nodes.length<1){
				alert("请从指标库中选择需要的指标！");return;
			}
			$.ajax({
				   type : 'post',
				   url: "${pageContext.request.contextPath}/indicator/pmTemplet!templetSave.do",
				   dataType:"json",
				   async:false,
				   data:{
					   "object.templetId":$("#templetId").val(),
					   "object.templetName":templetName,
					   "object.templetCode":templetCode,
					   "object.templetType":templetType,
					   "object.year":year,
					   "object.jspHtml":jspHtml,
					   "object.jspName":jspName,
					   "nodesJson":nodesJson
				   },
				   success: function(data){
					   alert(data.flag)
				   }
			});
		}
		//-->
	</SCRIPT>
	<style type="text/css">
		.input1{width: 95%;}
		.tdRight{width: 12%;text-align: right;}
		.tdRight1{width: 20%;text-align: left;}
		.tdLeft{width:22%;text-align: right;}
	</style>
	</head>
	<body>
		<input type="hidden" id="templetId" value="${param.templetId }" />
		<fieldset style=" display: block; padding: 10px;height: 20%; " >
			<legend class="new_legend">
				 模版信息
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="tdRight">模版名称：</td>
					<td class="tdRight1">
						<input type="text" class="input1" id="templetName" value="${object.templetName }">
					</td>
					<td class="tdRight">模版编码：</td>
					<td class="tdRight1">
						<input type="text" class="input1" id="templetCode" value="${object.templetCode }">
					</td>
					<td class="tdRight">模版类型：</td>
					<td class="tdRight1">
						<select id="templetType" style="width: 158px;">
							<option value="">请选择</option>
							<c:forEach var="row" items="${cp:DICTIONARY('PM_TEMPLETTYPE')}">
								<option type="radio" <c:if test="${object.templetType eq row.key}">selected="selected"</c:if> value="${row.key }" >
									${row.value}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tdRight">年度：</td>
					<td class="tdRight1">
						<input type="text" class="input1" readonly="readonly" id="year" value="${cp:MAPVALUE("provinceAnnual","sbAnnual") }">
					</td>
					<td class="tdRight">JSP名称：</td>
					<td class="tdRight1">
						<input type="text" class="input1" id="jspName" value="${object.jspName }"/>
					</td>
					<td class="tdRight">JSP页面：</td>
					<td class="tdRight1">
						<input type="text" class="input1" id="jspHtml" value="${object.jspHtml }">
					</td>
				</tr>
			</table>
		</fieldset>
		<div style="width: 23%;float:left;height: 70%;">
			<ul id="treeDemo" class="ztree" style="width: 98%;height: 98%;"></ul>
		</div>
		<div style="width: 23%;float:left;height: 70%;">
			<ul id="treeDemo2" class="ztree" style="width: 98%;height: 98%;"></ul>
		</div>
		<div style="float: left;">
			<fieldset style=" display: block; padding: 10px;" >
				<legend class="new_legend">
					 指标信息
				</legend>
						<table style="float: left;" width="200px;" border="0" cellpadding="1" cellspacing="1" class="viewTable">
								<tr>
									<td class="tdLeft">指标名称</td>
									<td>
										<span id="indicatorName"></span><input type="hidden" id="indicatorId"></span>
									</td>
									<td class="tdLeft">字段名称</td>
									<td>
										<span id="indicatorNickName"></span>
									</td>
								</tr>
								<tr>
									<td class="tdLeft">是否有下级</td>
									<td>
										<c:forEach var="row" items="${cp:DICTIONARY('PM_YESORNOT')}">
											<span class="hasLower" id="${row.key }" style="display: none;">${row.value}</span>
										</c:forEach>
									</td>
									<td class="tdLeft">上级指标</td>
									<td>
										<span id="fatherName"></span>
									</td>
								</tr>
								<tr>
									<td class="tdLeft">是否级联</td>
									<td>
										<c:forEach var="row" items="${cp:DICTIONARY('PM_YESORNOT')}">
											<span class="ifCascade" id="${row.key }" style="display: none;">${row.value}</span>
										</c:forEach>
									</td>
									<td class="tdLeft">级联目标</td>
									<td>
										<span id="cascadeName" ></span>
									</td>
								</tr>
								<tr>
									<td class="tdLeft">是否字典项</td>
									<td>
										<c:forEach var="row" items="${cp:DICTIONARY('PM_YESORNOT')}">
											<span class="ifDictionary" id="${row.key }" style="display: none;">${row.value}</span>
										</c:forEach>
									</td>
									<td class="tdLeft">字典项</td>
									<td>
										<span id="dictionaryId"></span>
									</td>
								</tr>
								<tr>
									<td class="tdLeft">指标值类型</td>
									<td>
									</td>
									<td class="tdLeft">输入方式</td>
									<td>
										<c:forEach var="row" items="${cp:DICTIONARY('PM_INPUTTYPE')}">
											<span class="inputType" id="${row.key }" style="display: none;">${row.value}</span>
										</c:forEach>
										<input type="hidden" id="inputtype" >
									</td>
								</tr>
								<tr>
									<td class="tdLeft">指标属性</td>
									<td colspan="3">
										<input type="checkbox" name="temp" value="T" id="ifPrimary" onclick="checkMe(this)">主键
										<input type="checkbox" name="temp" value="T" id="ifMust" onclick="checkMe(this)">必填
										<input type="checkbox" name="temp" value="T" id="ifHidden" onclick="checkMe(this)">隐藏
										<input type="checkbox" name="temp" value="T" id="ifAlong" onclick="checkMe(this)">独行
										<input type="checkbox" name="temp" value="T" id="ifCp" onclick="checkMe(this)" disabled="disabled">是否参与测评
									</td>
								</tr>
								<tr class="cp_tr" style="display:none">
									<td class="tdLeft">测评方式</td>
									<td colspan="3">
										<select id="evlType" name="evlType" onchange="_doshow(this);">
											<option value="">请选择</option>
											<c:forEach var="row" items="${cp:DICTIONARY('PM_EVLTYPE')}">
												<option value="${row.key}" label="${row.value}" <c:if test="${evlType eq row.key }">selected=selected</c:if>>
													${row.value}
												</option>	
											</c:forEach>
										</select>
										<input type="button" class="btn" id="szbtn" value="设置" onclick="cal();" style="display:none;">
									</td>
									</tr>
									<tr class="cp_tr" style="display:none">
									<td class="tdLeft" >测评计算方式</td>
									<td colspan="3">
									<textarea style="width:400px;" onchange="witeMe(this)" id="evlMethod" name="evlMethod"></textarea>
									</td>
								</tr>
								
								<tr>
									<td class="tdLeft">回写表名：</td>
									<td colspan="3">
										<input type="text" style="width: 80%;" id="writeBacktable" onchange="witeMe(this)">
									</td>
								</tr>
								<tr>
									<td class="tdLeft">回写字段：</td>
									<td colspan="3">
										<input type="text" style="width: 80%;" id="writeBackIndicator" onchange="witeMe(this)">
									</td>
								</tr>
							</table>
				</fieldset>
			</div>
				<center style="margin-top: 3px;width: 100%;background-color: #f0f0f0;height: 40px;line-height: 40px;">
					<input type="button" onclick="templetSave()" value="保存" class="btn">
					<input type="button" value="返回" class="btn">
				</center>
				<div id="nodesshow"></div>
	</body>
	<script type="text/javascript">
	
	function _doshow(temp){
		var val=temp.value;
		if(val==''){
			$("#evlMethod").val('');
			$("#szbtn").hide();
		}
		if(val!=''){
			if(val=='01'){
				$("#evlMethod").val('值直接计算');
				$("#szbtn").hide();
			}
			else{
				$("#evlMethod").val('');
				$("#szbtn").show();
			}
		}
		witeMe(temp);
	}
	function cal(){
		var url="${pageContext.request.contextPath}/indicator/pmIndexType!calType.do?"+
				"templetId="+$("#templetId").val()+"&indicatorId="+$("#indicatorId").val()+
				"&evlType="+$("#evlType").val()+"&indexname="+$("#indicatorNickName").text()+"&dictionaryId="+$("#dictionaryId").text();
// 		openwindow(url,"指标计算方式","800","600");
		var str=window.showModalDialog(url,null,'dialogWidth:800px;dialogHeight:600px;','top=0,left=0,toolbar=no, resizable=no,location=no, status=no');
// 		window.location.href=url;
		alert(str);
		if(str!=""){
			$("#evlMethod").val(str);
			nodeNow.evlType=$.trim($("#evlType").val());
			nodeNow.evlMethod=$.trim($("#evlMethod").val());
		}
	}
	</script>
</html>

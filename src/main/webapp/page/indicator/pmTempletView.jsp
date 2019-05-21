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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/inputZtree/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/tree/demo.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.core-3.5.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.excheck-3.5.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.exedit-3.5.min.js"></script>
		<SCRIPT type="text/javascript">
// 		<!--
		var nodeNow;
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
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
			if (treeNode.ifCp=="T") {
				$("#evlType").val(treeNode.evlType);
				$("#evlMethod").text(treeNode.evlMethod);
				$("#ifCp").attr("checked",true);
				$("#evlType").attr("disabled",true);
				$(".cp_tr").each(function(){
					this.style.display="block";
				});
			}
				else{
					$("#ifCp").attr("checked",false);
					$(".cp_tr").each(function(){
						this.style.display="none";
				});
				}
			$("#inputtype").val(treeNode.inputType);
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
			$("#dictionaryId").text(treeNode.dictionaryId);
			$("#indicatorNickName").text(treeNode.indicatorNickName);
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
					   "templetId":'${param.templetId }'
				   },
				   success: function(data){
					   var nowIndicators=data.nowIndicators;
					   var allIndicators=data.allIndicators;
					   var templet=data.templet;
					   if(templet!=null){
						   $("#templetCode").text(templet.templetCode);
						   $("#templetName").text(templet.templetName);
						   $("#templetType").val(templet.templetType);
// 						   $("#.templetType").each(function(){
// 							   if(this.id==templet.templetType){
// 									this.style.display="block";
// 							   }else{
// 								   this.style.display="none";
// 							   }
// 						   });
						   $("#year").text(templet.year);
						   $("#jspName").text(templet.jspName);
						   $("#jspHtml").text(templet.jspHtml);
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
		/* function checkMe(temp){
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
		} */
		/* function witeMe(temp){
			if(nodeNow==undefined){
				temp.value="";
				return;
			}
			if(temp.id=="writeBacktable"){
				nodeNow.writeBacktable=$.trim($("#writeBacktable").val());
			}else if(temp.id=="writeBackIndicator"){
				nodeNow.writeBackIndicator=$.trim($("#writeBackIndicator").val());
			}
			if(nodeNow.writeBacktable!=undefined&&nodeNow.writeBackIndicator!=undefined&&nodeNow.writeBacktable!=""&&nodeNow.writeBackIndicator!=""){
				nodeNow.ifWriteBack="T";
			}else{
				
				nodeNow.ifWriteBack="F";
			}
			alert(nodeNow.writeBacktable)
			alert(nodeNow.writeBackIndicator)
		} */
		/* function templetSave(){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo2");
			var nodes=zTree.getNodes();
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
		} */
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
						<span id="templetName">${object.templetName }</span>
					</td>
					<td class="tdRight">模版编码：</td>
					<td class="tdRight1">
						<span id="templetCode">${object.templetCode }</span>
					</td>
					<td class="tdRight">模版类型：</td>
					<td class="tdRight1">
						<select id="templetType" style="width: 158px;" disabled="true">
							<option value="1">请选择</option>
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
						<span id="year">${object.year }</span>
					</td>
					<%-- <td class="tdRight">JSP名称：</td>
					<td class="tdRight1">
						<span id="jspName">${object.jspName }</span>
					</td>
					<td class="tdRight">JSP页面：</td>
					<td class="tdRight1">
						<span id="jspHtml">${object.jspHtml }</span>
					</td> --%>
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
										<span id="indicatorName"></span>
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
									</td>
								</tr>
								<tr>
									<td class="tdLeft">指标属性</td>
									<td colspan="3">
										<input disabled="disabled" type="checkbox" name="temp" value="T" id="ifPrimary" onclick="checkMe(this)">主键
										<input disabled="disabled" type="checkbox" name="temp" value="T" id="ifMust" onclick="checkMe(this)">必填
										<input disabled="disabled" type="checkbox" name="temp" value="T" id="ifHidden" onclick="checkMe(this)">隐藏
										<input disabled="disabled" type="checkbox" name="temp" value="T" id="ifAlong" onclick="checkMe(this)">独行
										<input type="checkbox" name="temp" value="T" id="ifCp" onclick="checkMe(this)" disabled="disabled">是否参与测评
									</td>
								</tr>
								<tr class="cp_tr" style="display:none">
									<td class="tdLeft">测评方式</td>
									<td colspan="3">
										<select id="evlType" name="evlType" onselect="false">
											<option value="">请选择</option>
											<c:forEach var="row" items="${cp:DICTIONARY('PM_EVLTYPE')}">
												<option value="${row.key}" label="${row.value}" <c:if test="${evlType eq row.key }">selected=selected</c:if>>
													${row.value}
												</option>	
											</c:forEach>
										</select>
									</td>
									</tr>
									<tr class="cp_tr" style="display:none">
									<td class="tdLeft" >测评计算方式</td>
									<td colspan="3">
									<span id="evlMethod"></span>
								</tr>
								<tr>
									<td class="tdLeft">回写表名：</td>
									<td colspan="3">
										<input disabled="disabled" type="text" style="width: 80%;" id="writeBacktable" onchange="witeMe(this)">
									</td>
								</tr>
								<tr>
									<td class="tdLeft">回写字段：</td>
									<td colspan="3">
										<input disabled="disabled" type="text" style="width: 80%;" id="writeBackIndicator" onchange="witeMe(this)">
									</td>
								</tr>
							</table>
				</fieldset>
			</div>
				<center style="margin-top: 3px;width: 100%;background-color: #f0f0f0;height: 40px;line-height: 40px;">
					<input type="button" value="编辑页面" class="btn" onclick="editFile();">
					<input type="button" onclick="goBackPage()" value="返回" class="btn">
				</center>
				<div id="nodesshow"></div>
	</body>
	
	<script type="text/javascript">
		function editFile(){
			var url = "${pageContext.request.contextPath}/indicator/pmTemplet!editFile.do?templetId=${param.templetId }";
			
			window.open(url);
		}
		function goBackPage(){
			window.history.go(-1);
		}
	</script>
</html>

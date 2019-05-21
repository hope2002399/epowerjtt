<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/inputZtree/zTreeStyle.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/tree/demo.css" type="text/css"  />
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.core-3.5.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tree/jquery.ztree.excheck-3.5.min.js"></script>
		<style type="text/css">
			.radio{border: none;}
		</style>
		<script type="text/javascript">
			var settingInit = {
				data: {
					simpleData: {
						enable:true
					}
				},
				callback: {
					onClick:clickTree
				}
			};
			var settingRadio={
					check: {
						enable: true,
						chkStyle: "radio",
						radioType: "all"
					},
					view: {
						dblClickExpand: false
					},
					data: {
						simpleData: {
							enable: true
						}
					},
					callback: {
						onCheck: checkRadio
					}
			};
			function checkIfDictionary(){
				if($("input[name='ifDictionary']:checked").val()=="02"){
					$("#dictionaryId").val("");
				}
			}
			function checkCascade(temp){
				if($("input[name='ifCascade']:checked").val()=="02"){
					$("#cascadeId").val("");
					$("#cascadeName").val("");
				}
			}
			//radio单选选中事件
			function checkRadio(e, treeId, treeNode){
				$("#cascadeId").val(treeNode.id);
				$("#cascadeName").val(treeNode.name);
			}
			function showMenu(temp){
				if($("input[name='ifCascade']:checked").val()=="02"){
					return;
				}
				var treeNodes = $.fn.zTree.getZTreeObj("indicatorTree");
				var menuNodes = treeNodes.getNodes();//ByParam("isParent", false);
				//自动选中已选择的节点
				var cascadeId=$("#cascadeId").val();
				if(cascadeId!=""){
					treeNodes.getNodeByParam("id", cascadeId).checked=true;
				}
				$.fn.zTree.init($("#radioTree"), settingRadio, menuNodes);
				var cityObj = $("#"+temp.id);
				var cityOffset = $("#"+temp.id).offset();
				$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
				$("body").bind("mousedown", onBodyDown);
			}
			//鼠标点击树之外后隐藏 
			function onBodyDown(event) {
				if (!( event.target.id == "citySel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
					hideMenu();
				}
			}
			function hideMenu() {
				$("#menuContent").fadeOut("fast");
				$("body").unbind("mousedown", onBodyDown);
			}
			//节点点击事件
			function clickTree(event, treeId, treeNode, clickFlag){
				$("#indicatorName").val(treeNode.indicatorName);
				$("#indicatorId").val(treeNode.indicatorId);
				$("#dictionaryId").val(treeNode.dictionaryId);
				$("#indicatorNickName").val(treeNode.indicatorNickName);
				//获取父级指标信息
				var treeNodes = $.fn.zTree.getZTreeObj("indicatorTree");
				var parentNodes = treeNodes.getNodeByParam("id", treeNode.pId);
				if(parentNodes!=null){
					$("#fatherName").val(parentNodes.indicatorName);
					$("#fatherId").val(parentNodes.indicatorId);
				}else{
					$("#fatherName").val("");
					$("#fatherId").val(treeNode.fatherId);
				}
				//级联指标
				var cascadeNode=treeNodes.getNodeByParam("id", treeNode.cascadeId);
				if(cascadeNode!=null){
					$("#cascadeId").val(cascadeNode.id);
					$("#cascadeName").val(cascadeNode.name);
				}else{
					$("#cascadeId").val("");
					$("#cascadeName").val("");
				}
				$("input[name='hasLower']").each(function(){
					if(this.value==treeNode.hasLower){
						this.checked=true;
					}
				});
				$("input[name='ifCascade']").each(function(){
					if(this.value==treeNode.ifCascade){
						this.checked=true;
					}
				});
				$("input[name='ifDictionary']").each(function(){
					if(this.value==treeNode.ifDictionary){
						this.checked=true;
					}
				});
				 $("#inputType").find("option").each(function(){
					 if(this.value==treeNode.inputType){
						 this.selected=true;
					 }
				 });
			}
			//异步加载所有节点数据
			function referTree(){
				$.ajax({
					   type : 'post',
					   url: "${pageContext.request.contextPath}/indicator/pmIndicator!indicatorListJson.do",
					   dataType:"json",
					   async:false,
					   success: function(data){
						   var nodes=data.json;
						   for(var i=0;i<nodes.length;i++){
							   nodes[i].id=nodes[i].indicatorId;
							   nodes[i].pId=nodes[i].fatherId;
							   nodes[i].name=nodes[i].indicatorName;
							   if(nodes[i].hasLower=="01"){
								   nodes[i].isParent=true;
							   }
						   }
						   $.fn.zTree.init($("#indicatorTree"), settingInit, nodes);
						}
					});
			}
			function getAllChildNodes(){
				var zTree = $.fn.zTree.getZTreeObj("indicatorTree");
				var childNodes = zTree.getNodesByParam("isParent", false);
				var cascadeSelectStr="<option value=''>请选择</option>";
				for(var i=0;i<childNodes.length;i++){
					var optionStr="<option value='"+childNodes[i].id+"'>";
					optionStr+=childNodes[i].name;
					optionStr+="</option>";
					cascadeSelectStr+=optionStr;
				}
				$("#cascadeId").empty().append(cascadeSelectStr);
			}
			//初始化加载所有节点
			$(document).ready(function(){
				referTree();
				$("input[name*='Name']").css("width","180px");
			});
			function newIndicator(){
				var zTree = $.fn.zTree.getZTreeObj("indicatorTree");
				var selectNodes=zTree.getSelectedNodes();
				if(selectNodes.length!=1){
					alert("请点击左侧结构单个节点作为新节点的父节点！");
					return;
				}
				var fatherNode;
				if(selectNodes[0].isParent){
					fatherNode=selectNodes[0];
				}else{
					fatherNode=zTree.getNodeByParam("id", selectNodes.pId);
				}
				if(fatherNode==null){
					return;
				}
				var fatherId=fatherNode.id;
				var fatherName=fatherNode.name;
				$("#indicatorName").val("");
				$("#indicatorId").val("");
				$("#indicatorNickName").val("");
				$("#fatherId").val(fatherId);
				$("#fatherName").val(fatherName);
				$("#cascadeName").val("");
				$("#cascadeId").val("");
				$("#inputType").val("");
				$("#dictionaryId").val("");
				$("input[name='hasLower']").each(function(){
					if(this.value=="02"){
						this.checked=true;
					}
				});
				$("input[name='ifCascade']").each(function(){
					if(this.value=="02"){
						this.checked=true;
					}
				});
				$("input[name='ifDictionary']").each(function(){
					if(this.value=="02"){
						this.checked=true;
					}
				});
			}
			function addNode(){
				var zTree = $.fn.zTree.getZTreeObj("indicatorTree");
				var fatherId=$("#fatherId").val();
				if(fatherId==""){
					alert("请点击左侧结构单个节点作为新节点的父节点！");
					return false;
				}
				var indicatorName=$("#indicatorName").val();
				if(indicatorName==""){
					alert("请输入业务名称！");
					return false;
				}
				if(indicatorName.length>150){
					alert("指标名称过长！");
					return false;
				}
				var indicatorNickName=$("#indicatorNickName").val();
				if(indicatorNickName==""){
					alert("请输入字段名称！");
					return false;
				}else if($("#indicatorId").val()==""){
					var NickNameNodes = zTree.getNodesByParam("indicatorNickName", indicatorNickName);
					if(NickNameNodes.length>0){
						alert("字段名已存在！");
						return false;
					}
				}
				if(indicatorNickName.length>32){
					alert("字段名称过长！");
					return false;
				}
				var param=$("#indicatorForm").serialize();
				$.ajax({
					   type : 'post',
					   url: "${pageContext.request.contextPath}/indicator/pmIndicator!indicatorSave.do",
					   dataType:"json",
					   async:false,
					   data:param,
					   success: function(data){
						   if(data.flag){
							   var newNode=data.indicator;
							   var oldNode=zTree.getNodeByParam("id", newNode.indicatorId);
							   if(oldNode!=null){
								   oldNode.id=newNode.indicatorId;
								   oldNode.pId=newNode.fatherId;
								   oldNode.name=newNode.indicatorName;
								   oldNode.indicatorId=newNode.indicatorId;
								   oldNode.fatherId=newNode.fatherId;
								   oldNode.indicatorName=newNode.indicatorName;
								   oldNode.indicatorNickName=newNode.indicatorNickName;
								   oldNode.ifDictionary=newNode.ifDictionary;
								   oldNode.dictionaryId=newNode.dictionaryId;
								   oldNode.dictionaryKey=newNode.dictionaryKey;
								   oldNode.inputType=newNode.inputType;
								   oldNode.ifCascade=newNode.ifCascade;
								   oldNode.cascadeId=newNode.cascadeId;
								   oldNode.valueType=newNode.valueType;
								   oldNode.hasLower=newNode.hasLower;
								   if(newNode.hasLower=="01"){
									   oldNode.isParent=true;
								   }else{
									   oldNode.isParent=false;
								   }
								   var trees = $.fn.zTree.getZTreeObj("indicatorTree");
								   trees.updateNode(oldNode);
							   }else{
								   newNode.id=newNode.indicatorId;
								   newNode.pId=newNode.fatherId;
								   newNode.name=newNode.indicatorName;
								   if(newNode.hasLower=="01"){
									   newNode.isParent=true;
								   }
								   var fatherNode=zTree.getNodesByParam("id", newNode.fatherId);
									zTree.addNodes(fatherNode[0],newNode);
									$("#indicatorId").val(newNode.indicatorId);
							   }
						   }
					   },
					   error:function(){
						   alert("操作失败！");
					   }
				});
			}
		</script>
		<style type="text/css">
		.viewTable td{white-space:nowrap;}
		.TDTITLE{width:90px}
		table{table-layout: fixed;min-width: 200px}
		</style>
	</head>
	<body>
		<div style="height: 300px;">
			<div class="zTreeDemoBackground left" style="width: 30%;float:left;">
				<ul id="indicatorTree" class="ztree" style="width: 98%;margin: 3px 3px;"></ul>
			</div>
			<div class="right" style="width: 60%;height: 50%;float:left;margin-left: 8px;">
				<fieldset style="padding:5px;margin-left:10px; ">
					<legend>
						 <s:text name="业务属性" />
					</legend>
					<span style="float: right;margin: 3px;cursor: pointer;"><a onclick="newIndicator()">+添加业务项</a></span>
					<form id="indicatorForm">
						<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
							<tr>
								<td class="TDTITLE">业务名称</td>
								<td>
									<input type="text" id="indicatorName" maxlength="150" name="indicatorName" />
									<input type="hidden" id="indicatorId" name="indicatorId">
								</td>
								<td class="TDTITLE">字段名称</td>
								<td>
									<input type="text" id="indicatorNickName" maxlength="32" name="indicatorNickName" onblur="if(/[^0-9a-zA-Z]/g.test(this.value))alert('请输入合法字段名称！')"/>
								</td>
							</tr>
							<tr>
								<td class="TDTITLE">是否有下级</td>
								<td>
									<c:forEach var="row" items="${cp:DICTIONARY('PM_YESORNOT')}">
										<input type="radio"  name="hasLower"  checked="true" class="radio" value="${row.key }" />
										<c:out value="${row.value}" />
									</c:forEach>
								</td>
								<td class="TDTITLE">上级指标</td>
								<td>
									<input type="text" id="fatherName" readonly="readonly" name="fatherName">
									<input type="hidden" id="fatherId" name="fatherId">
								</td>
							</tr>
							<tr>
								<td class="TDTITLE">是否级联</td>
								<td>
									<c:forEach var="row" items="${cp:DICTIONARY('PM_YESORNOT')}">
										<input type="radio"  name="ifCascade" checked="true" onclick="checkCascade(this)" class="radio" value="${row.key }" />
										<c:out value="${row.value}" />
									</c:forEach>
								</td>
								<td class="TDTITLE">级联目标</td>
								<td>
									<input type="text" id="cascadeName" readonly="readonly" name="cascadeName" onclick="showMenu(this)">
									<input type="hidden" id="cascadeId" name="cascadeId" >
								</td>
							</tr>
							<tr>
								<td class="TDTITLE">是否字典项</td>
								<td>
									<c:forEach var="row" items="${cp:DICTIONARY('PM_YESORNOT')}">
										<input type="radio" onclick="checkIfDictionary()" name="ifDictionary" checked="true" class="radio" value="${row.key }" />
										<c:out value="${row.value}" />
									</c:forEach>
								</td>
								<td class="TDTITLE">字典项</td>
								<td>
									<input style="width: 180px;" onchange="checkIfDictionary()" type="text" id="dictionaryId" name="dictionaryId">
								</td>
							</tr>
							<tr>
								<td class="TDTITLE">业务值类型</td>
								<td>
								</td>
								<td class="TDTITLE">输入方式</td>
								<td>
									<select name="inputType" id="inputType">
										<option value="">请选择</option>
										<c:forEach	var="row" items="${cp:DICTIONARY('PM_INPUTTYPE')}">
											<option value="${row.key }">${row.value}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
					</form>
					<center style="margin-top: 30px;width: 100%;background-color: #f0f0f0;height: 40px;line-height: 50px;padding-top: 6px;">
						<input type="button" onclick="addNode()" value="保存" class="btn">
						<input type="button" value="删除" class="btn">
					</center>
				</fieldset>
			</div>
			
			<div id="menuContent" class="menuContent" style="display:none;position: absolute;">
				<ul id="radioTree" class="ztree" style="margin-top:0; width:180px; height: 250px;"></ul>
			</div>
		</div>
	</body>
</html>
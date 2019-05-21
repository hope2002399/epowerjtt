<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/css.jsp"%>
<%@ taglib uri="http://www.centit.com/el/coderepo" prefix="cp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
 		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/drag.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/treeMove.js"></script>
<%-- 		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/test/jquery.js"></script> --%>
				 		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/test/jquery-ui.js"></script>
<%--  		 		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/test/idrag.js"></script> --%>
		 <script type="text/javascript">
		 var zNodes =[
			             { id:0, pId:0, name:"符号", open:true},
			             { id:"SYMBOL1", pId:0, name:"+"},
			             { id:"SYMBOL2", pId:0, name:"-"},
			             { id:"SYMBOL3", pId:0, name:"*"},
			             { id:"SYMBOL4", pId:0, name:"/"},
			             { id:"SYMBOL5", pId:0, name:"("},
			             { id:"SYMBOL6", pId:0, name:")"}
			         ];
		 $(document).ready(function(){
			 var exs='',exp='';
				$.ajax({
					   type : 'post',
					   url: "${pageContext.request.contextPath}/indicator/pmIndexExpression!evlExpression.do",
					   dataType:"json",
					   async:false,
					   data:{
						   "object.templetId":$("#templetId").val()
					   },
					   success: function(data){
						   var nowIndicators=data.nowIndicators;
						   var allIndicators=zNodes;
// 						   var templet=data.templet;
						   var expression=data.expression;
						   exs=expression.expression;
						   exp=expression.expression;
						   exs=exs.replace(/\+/g,",+,").replace(/\-/g,",-,").replace(/\*/g,",*,").replace(/\//g,",/,");
					   	   exs=exs.replace(/\(/g,",(,").replace(/\)/g,",),");
						   if(expression!=null){
							   $("#expression").text(expression.expression);
						   }
						   if(allIndicators!=null&&allIndicators.length>0){
							   for(var i=0;i<allIndicators.length;i++){
								   allIndicators[i].id=zNodes[i].id;
								   allIndicators[i].pId=zNodes[i].pId;
								   allIndicators[i].name=zNodes[i].name;
								   exp=exp.replace(/\+/g,",SYMBOL1,").replace(/\-/g,",SYMBOL2,").replace(/\*/g,",SYMBOL3,").replace(/\//g,",SYMBOL4,");
								   exp=exp.replace(/\(/g,",SYMBOL5,").replace(/\)/g,",SYMBOL6,");
// 								  $.fn.zTree.init($("#treeDemo"), setting1, allIndicators);
							   }
						   }else{
// 							   $.fn.zTree.init($("#treeDemo"), setting1);
						   } 
// 						   MoveTest.updateType("treeDemo");
						   if(nowIndicators!=null&&nowIndicators.length>0){
							   for(var i=0;i<nowIndicators.length;i++){
								   nowIndicators[i].id=nowIndicators[i].indicatorId;
								   nowIndicators[i].pId=nowIndicators[i].fatherId;
								   nowIndicators[i].name=nowIndicators[i].indicatorName;
								   if(exs.indexOf(nowIndicators[i].indicatorNickName)!=-1){
									   var reg=new RegExp(nowIndicators[i].indicatorNickName,"g");
									   exs=exs.replace(reg,nowIndicators[i].indicatorName);
								   }
								   if(nowIndicators[i].hasLower=="01"){
									   nowIndicators[i].isParent=true;
								   }
								  $.fn.zTree.init($("#treeDemo2"), setting2, nowIndicators);
							   }
						   }else{
							   $.fn.zTree.init($("#treeDemo2"), setting2);
						   }
						   MoveTest.updateType("treeDemo2");
						}
					});
				evlexpression1(exp,exs);
				MoveTest.bindDom();
			});
		
		 function evlexpression1(exp,exs){ 
			 var str=exp.replace(/\[/g, ",").replace(/\]/g,",").split(",");
			 var exp=exs.replace(/\[/g, ",").replace(/\]/g,",").split(",");
			 for(var i=0;i<str.length;i++){
				if(str[i]!=''){
					if(!isNaN(str[i])){
						str[i]="Number"+str[i];
					}
					$("#dom_0").append("<span class='domBtn' domId='" +str[i] + "' ><h3 style='cursor: move;' class='m_title'>" + exp[i] + "</h3></span>");
				}
			 }
			 var $list = $("#dom_0");
				
				$list.sortable({
					opacity: 0.6,
					revert: true,
					cursor: 'move',
					handle: '.m_title',
					update: function(){
						 var new_order = [];
			             $list.children(".domBtn").each(function() {
			                new_order.push(this.title);
			             });
					}
				});
		 }
		 function evlexpression(){ 
			 var expression="";
			 for(var i=0;i<$("#dom_0").children("span").length;i++){
			 $("#dom_0").each(function(){
				var text= $(this).find("span").eq(i).text();
			 	var id= $(this).find("span").eq(i).attr("domId");
			 	 if(id.indexOf("SYMBOL")!=-1||id.indexOf("Number")!=-1){
			 		expression+=text;
			 	 }
			 	 else
			 		expression+="["+id+"]";
			 });
			 }
			 $("#expression").val(expression);
			 if(expression!=''){
				 return true;
			 }
			 else{
				 alert("表达式不能为空");
				 return false;
			 }
				 
		 }
		 </script>
		<style type="text/css">
			.input1{width: 95%;}
			.tdRight{width: 12%;text-align: right;}
			.tdRight1{width: 20%;text-align: left;}
			.tdLeft{width:22%;text-align: right;}
			.dom_line {margin:2px;border-bottom:1px gray dotted;height:1px}
			.domBtnDiv {display:block;padding:2px;border:1px gray dotted;background-color:powderblue; word-break:break-all;}
			.categoryDiv {display:inline-block;width: 100%;float:left;height: 100%;}
/* 			.domBtn {display:inline-block;padding:1px;margin:1px 1px;border:1px gray solid;background-color:#FFE6B0;font-size:16px;font-family:Arial, Helvetica, sans-serif;}  */
			.domBtn{float:left;  margin:5px; overflow:hidden; border:1px solid #acc6e9; background:#e8f5fe;display:block;word-break:nowarp;}
			.m_title{ background:#afc6e9;margin:0px}	
			.domBtn_Disabled {display:inline-block;cursor:default;padding:2px;margin:2px 10px;border:1px gray solid;background-color:#DFDFDF;color:#999999}
			.dom_tmp {position:absolute;font-size:12px;}
			.active {background-color: #93C3CF}
			.dragSPAN{cursor:move;/*color:#FFFFFF;background-color:#0073ff;*/color:#ffff00;background-color:#3cb500;height:20px; font-weight:bold; font-size:14px;font-family:Arial, Helvetica, sans-serif; word-break:nowarp;}
			.symbolBtn{background-color: #93C3CF;width: 25px;font-size:12px;margin-left:10px}
		</style>
	
	</head>
	<body>
		
		<div style="width: 100%;float:left;height: 5%;" align="center">
			<input type="button" value="+" class="symbolBtn" id="SYMBOL1" onclick="addSpan(this);">
			<input type="button" value="-" class="symbolBtn" id="SYMBOL2" onclick="addSpan(this);">
			<input type="button" value="*" class="symbolBtn" id="SYMBOL3" onclick="addSpan(this);">
			<input type="button" value="/" class="symbolBtn" id="SYMBOL4" onclick="addSpan(this);">
			<input type="button" value="(" class="symbolBtn" id="SYMBOL5" onclick="addSpan(this);">
			<input type="button" value=")" class="symbolBtn" id="SYMBOL6" onclick="addSpan(this);">
			
			数字输入：<input type="text" id="Number" onkeypress="add();">
			<input type="button" value="数字添加" class="btn" id="numbtn" onclick="addNumSpan(this);">
		</div>
		<div style="width: 23%;float:left;height: 70%;">
			<ul id="treeDemo2" class="ztree" style="width: 98%;height: 98%;"></ul>
		</div>
<!-- 		<div style="width: 23%;float:left;height: 70%;"> -->
<!-- 			<ul id="treeDemo" class="ztree" style="width: 98%;height: 98%;"></ul> -->
<!-- 		</div> -->
		<div style="width:73%;height:98%;float:right">
			<div class="domBtnDiv"style="height:25%;margin-top:10px" >
					<div id="dom_0" class="categoryDiv">
					</div>
			</div>
			<div>
			<s:form action="pmIndexExpression.do" namespace="/indicator" style="margin-top:0;margin-bottom:5" id="expForm">
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
											<input disabled="disabled" type="checkbox" name="temp" value="T" id="ifCp" onclick="checkMe(this)">参与测评
										</td>
									</tr>
									<tr class="cp_tr" style="display:none">
									<td  class="tdLeft">测评方式</td>
									<td><span id="evlType"></span></td>
									<td  class="tdLeft">测评方式</td>
									<td><span id="evlMethod"></span> </td>
									</tr>
								</table>
								<table style="float: left;display:block;" width="200px;" border="0" cellpadding="1" cellspacing="1" class="viewTable">
									<tr>
										<input type="hidden" id="templetId" name="templetId" value="${param.templetId }" />
										<td class="tdLeft">指标测评表达式</td>
										<td colspan="3">
											<textarea rows="3" cols="10" hidden="hidden" id="expression" name="expression" value="${object.expression }"></textarea>
										</td>
									</tr>
								
								</table>
					</fieldset>
				</div>
				<center style="margin-top: 3px;width: 100%;background-color: #f0f0f0;height: 40px;line-height: 40px;">
						<s:submit method="save" cssClass="btn" value="保存" onclick="return evlexpression();"></s:submit>
						<input type="button" value="返回" class="btn" onclick="window.history.back(-1)">
				</center>
			</div>
			</s:form>
			<div id="nodesshow"></div>
	</body>
	<script type="text/javascript" language="javascript">
	
		function addSpan(temp){
			var id=temp.id;
			var name=$("#"+id).val();
			$("#dom_0").append("<span class='domBtn' domId='" +id+ "' ><h3 style='cursor: move;' class='m_title'>" + name+ "</h3></span>");
			///
			$(".m_title").bind('mouseover',function(){
				$(this).css("cursor","move");
			});
			var $list = $("#dom_0");
			
			$list.sortable({
				opacity: 0.6,
				revert: true,
				cursor: 'move',
				handle: '.m_title',
				update: function(){
					 var new_order = [];
		             $list.children(".domBtn").each(function() {
		                new_order.push(this.title);
		             });
				}
			});
		}
		function addNumSpan(){
			var id="Number";
			var name=$("#Number").val();
			if(name!=''&&!isNaN(name)){
				id=id+name;
				$("#dom_0").append("<span class='domBtn' domId='" +id+ "' ><h3 style='cursor: move;' class='m_title'>" + name+ "</h3></span>");
				///
				$(".m_title").bind('mouseover',function(){
					$(this).css("cursor","move");
				});
				var $list = $("#dom_0");
				
				$list.sortable({
					opacity: 0.6,
					revert: true,
					cursor: 'move',
					handle: '.m_title',
					update: function(){
						 var new_order = [];
			             $list.children(".domBtn").each(function() {
			                new_order.push(this.title);
			             });
					}
				});
			}
			else
				alert('请输入数字');
		}
	function add(){
		var e = event || window.event;
        var keyCode = e.keyCode || e.which;
        if(keyCode=='13'){
        	$("#numbtn").click();
        }
	}
	
        document.onkeyup = function (event) {
            var e = event || window.event;
            var keyCode = e.keyCode || e.which;
//             alert(keyCode);
//             alert(e.shiftKey);
// 			if()
//             if(e.keyCode==16){
//             	alert(11);
//             }
            if(e.shiftKey == true && e.keyCode == 57){
               		 $("#SYMBOL5").click();
                     $("#SYMBOL6").click();
            }
            else
            	switch (keyCode) {
	                case 107:
	                    $("#SYMBOL1").click();
	                    break;
	                case 109:
	                    $("#SYMBOL2").click();
	                    break;
	                case 106:
	                    $("#SYMBOL3").click();
	                    break;
	                case 111:
	                    $("#SYMBOL4").click();
	                    break;
	//                 case 57:
	//                		 $("#SYMBOL5").click();
	//                      $("#SYMBOL6").click();
	//                     break;
	                default:
	                    break;
	            } 
        }
</script>
</html>

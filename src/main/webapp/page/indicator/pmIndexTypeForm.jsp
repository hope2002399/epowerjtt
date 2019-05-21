<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
	<title></title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	</head>
	<body>
	<s:form action="pmIndexType.do" namespace="/indicator" id="typeForm">
			<fieldset style="border: hidden 1px #f0f0f0;padding: 5px;height: 99%; ">
				<legend>
					 ${object.indicatorName }指标测评计算方式
				</legend>
					<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
						<tr>
							<td class="TDTITLE">指标名称</td>
							<td>
								${object.indicatorName }
								<input type="hidden" id="indexId" name="indexId" value="${object.indexId }">
							</td>
							<td class="TDTITLE">字段名称</td>
							<td>
								${indexname}
								<input type="hidden" id="indexname" name="indexname" value="${object.indexname }">
							</td>
							<td class="TDTITLE">计算方式</td>
							<td>
								${cp:MAPVALUE("PM_EVLTYPE",evlType) }
								<input type="hidden" id="evlType" name="evlType" value="${object.evlType }">
								<input type="hidden" id="templetId" name="templetId" value="${object.templetId }">
								<input type="hidden" id="indicatorId" name="indicatorId" value="${object.indicatorId }">
							</td>
						</tr>
					</table>
					<c:if test="${evlType eq '02' }"><!-- 数值区间计算 -->
					<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
					<thead>
					<tr><td colspan="6">
						<div style="float:right; width:5%; height:18px; border-right:0px solid #0000FF; border-top:0px solid #0000FF; border-bottom:0px solid #0000FF; margin:0 auto; line-height:23px" >
 						<input type="button" onclick="addOrderRow('detailItemBody',0,0,this,'add');" value="增加" class="btn" id="btnAdd1" name="btnAdd">  </div> 
 						</td></tr>
						<tr>
							<td align="center">得分</td>
							<td align="center">下限值</td>
							<td align="center">单位</td>
							<td align="center">上限值</td>
							<td align="center">单位</td>
							<td align="center">操作</td>
						</tr></thead>
						<tbody id="detailItemBody">
						<c:if  test="${!empty object.pmIndexBasics }">
							<c:forEach items="${object.pmIndexBasics}" var="basic">
								<tr>
								<td align="center"><input type="input" name="grade1" id="grade1" value=${basic.grade }>
								<input type="hidden" name="rangeId1"  id="rangeId1" value=${basic.rangeId }></td>
								<td align="center"><input type="input" name="leftRange" value=${basic.leftRange }> </td>
								<td align="center">万元 </td>
								<td align="center"><input type="input" name="rightRange" value=${basic.rightRange }> </td>
								<td align="center">万元 </td>
								<td align="center"><input type="button" onclick="addOrderRow('detailItemBody',2,11,this,'delete')" value="删除" class="btn" id="btnDelete" name="btnDelete"></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty object.pmIndexBasics }">
							<tr >
								<td align="center"><input type="input" name="grade1" id="grade1" value=${basic.grade }>
								<input type="hidden" name="rangeId1" id="rangeId1" value=${basic.rangeId }></td>
								<td align="center"><input type="input" name="leftRange" value=${basic.leftRange }> </td>
								<td align="center">万元 </td>
								<td align="center"><input type="input" name="rightRange" value=${basic.rightRange }> </td>
								<td align="center">万元 </td>
								<td align="center"><input type="button" onclick="addOrderRow('detailItemBody',0,0,this,'delete')" value="删除" class="btn" id="btnDelete" name="btnDelete"/></td>
							</tr>
						</c:if>
						</tbody>
						</table>
					
					</c:if>
					<c:if test="${evlType eq '03' }"><!-- 数据字典计算 -->
					<table border="0" cellpadding="1" cellspacing="1" class="viewTable" id="detailItemBody">
						<tr>
							<td align="center">得分</td>
							<td align="center">字典项值</td>
						</tr>
						<c:if test="${!empty object.pmIndexBasics }">
						<c:forEach var="basic" items="${object.pmIndexBasics}">
							<tr>
							<td align="center"><input type="input" name="grade2" id="grade2" value=${basic.grade }> 
							<input type="hidden" name="rangeId2" id="rangeId2" value=${basic.rangeId }></td>
							<td align="center">${cp:MAPVALUE(param.dictionaryId,basic.dictvalue) }
							<input type="hidden" name="dictvalue" value="${basic.dictvalue}">
							<input type="hidden" name="dictlabel" value="${cp:MAPVALUE(param.dictionaryId,basic.dictvalue) }">
							</td>
							</tr>
						</c:forEach>
						</c:if>
						<c:if test="${empty object.pmIndexBasics }">
						<c:forEach var="row" items="${cp:DICTIONARY(param.dictionaryId)}">
							<tr>
							<td align="center"><input type="input" name="grade2" id="grade2" value="" }>
								<input type="hidden" name="rangeId2" id="rangeId2" value=${basic.rangeId }></td>
							<td align="center">${row.value }<input type="hidden" name="dictvalue" value="${row.key}">
							<input type="hidden" name="dictlabel" value="${row.value}">
							</td>
							</tr>
						</c:forEach>
						</c:if>
						</table>
					
					</c:if>
					
					<div align="center">
						<input type="button" name="" onclick="btn_doSave();" value="保存" class="btn">
						<input type="button" name="" onclick="closeWindow();" value="取消" class="btn">
					</div>
			</fieldset>
		</div>
		</s:form>
<!-- 		<div id="menuContent" class="menuContent" style="display:none;position: absolute;"> -->
<!-- 			<ul id="radioTree" class="ztree" style="margin-top:0; width:180px; height: 250px;"></ul> -->
<!-- 		</div> -->
	</body>
	<script type="text/javascript">
	function addOrderRow(tab,rowNum,colNum,obj,addType){
		var detailbody=document.getElementById(tab); 
		var row = document.createElement("tr"); 
		var newrow=obj.parentNode.parentNode.innerHTML; 
		if(addType=='add'){
		var row = detailbody.insertRow(); 
		for(var i=0;i<detailbody.getElementsByTagName("TR")[0].childNodes.length;i++){ 
		var cell=row.insertCell();
// 		if(i==0)
// 			cell.innerHTML=parseInt(detailbody.getElementsByTagName("TR").length-2)+1;
// 		else
			cell.innerHTML=detailbody.getElementsByTagName("TR")[0].childNodes[i].innerHTML;

		cell.align="center";//设置样式。
			//.
// 		cell.innerHTML=detailbody.getElementsByTagName("TR")[0].childNodes[i].innerHTML;
		
		//如果表单中有值就清空 
// 		cell.childNodes.item(0).id = "cell" + row + i;
		 for(var k=0;k<cell.childNodes.length;k++){ 
			if (cell.childNodes[k].type == 'text') { cell.childNodes[k].value = ''; } 
			if (cell.childNodes[k].type == 'textarea') { cell.childNodes[k].value = ''; } 
			if (cell.childNodes[k].type == 'checkbox') { cell.childNodes[k].checked = false; } 
			if (cell.childNodes[k].type == 'radio') { cell.childNodes[k].checked = true; } 
			if (cell.childNodes[k].type == 'select-multiple') { cell.childNodes[k].selectedIndex = -1; } 
			if (cell.childNodes[k].type == 'select-one') { cell.childNodes[k].selectedIndex = ''; } 
		}  
		//cell.innerHTML=arr[i]; 
		} 
		}else if(addType=='copy'){ 
		//copy 
		//detailbody.insertRow().insertCell().innerHTML = newrow;   ok 
		var row = detailbody.insertRow(); 
		for(var i=0;i<obj.parentNode.parentNode.childNodes.length;i++){ 
		var cell=row.insertCell(); 
		if(i==0)
		cell.innerHTML=parseInt(obj.parentNode.parentNode.childNodes[i].innerHTML)+1;
		else
		cell.innerHTML=obj.parentNode.parentNode.childNodes[i].innerHTML;
		} 
		}else{ 
		//delete 
		if((obj.parentNode.parentNode.parentNode.childNodes.length)!=1){
		if(confirm("是否确定删除此项?")){
		    obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);    
		}else{ 
		return false; 
		} 
		}else{
		alert("此项不可删除,直接填写信息!");
		return false; 
		}
		} 


		} 
	
	function btn_doSave(){
		var grade1=document.getElementsByName("grade1");
		var grade2=document.getElementsByName("grade2");
		var leftRange=document.getElementsByName("leftRange");
		var rightRange=document.getElementsByName("rightRange");
		var dictvalue=document.getElementsByName("dictvalue");
		var dictlabel=document.getElementsByName("dictlabel");
		if($("#evlType").val()=='02'){
			for(var i=0;i<grade1.length;i++){
				if(grade1[i].value!=''){
					if(isNaN(grade1[i].value)){
						alert("得分只能填入数字！");
						return;
					}
					if(leftRange[i].value!=''){
						if(isNaN(leftRange[i].value)){
							alert("下限只能输入数字！");
							return;
						}
					}
					if(rightRange[i].value!=''){
						if(isNaN(rightRange[i].value)){
							alert("上限只能输入数字！");
							return;
						}
					}
					if(leftRange[i].value!='' && rightRange[i].value!=''){
						if(parseInt(rightRange[i].value) < parseInt(leftRange[i].value)){
							alert("上限数值不能小于下限数值！");
							return ;
						}
					}
// 					if(leftRange[i].value=='' || rightRange[i].value==''){
// 							alert("请输入区间值");
// 							return ;
// 					}
					 for(var j=i+1;j <grade1.length;j++) {
						  if(grade1[i].value==grade1[j].value){
							  alert("分数不可以相同");
								return;
						  }
					  }	
				 }
				else{
					   alert("得分不可以为空");
					   return;
					}

			}
		}
		else{
			for(var i=0;i<grade2.length;i++){
				if(grade2[i].value!=''){
					if(isNaN(grade2[i].value)){
						alert("得分只能填入数字！");
						return;
					}
				}else{
				   alert("得分不可以为空");
				   return;
				}
			}
		}
		
// 	 alert(1);
// 	 if(comfirm("确定保存?")){
			var param=$("#typeForm").serialize();
			 $.ajax({
				   type : 'post',
				   url: "${pageContext.request.contextPath}/indicator/pmIndexType!save.do",
				   dataType:"json",
				   async:false,
				   data:param,
				   success: function(data){
					   if(data.flag=='T'){
						   alert("保存成功！");
						   var str='';
							if(grade1.length>0){
								for(var i=0;i<grade1.length;i++){
									str+="数值处于"+leftRange[i].value+"与"+rightRange[i].value+"之间，测评得分为:"+grade1[i].value+"\n";
								}
							} 
							if(grade2.length>0){
								for(var i=0;i<grade2.length;i++){
									str+="字段值为:"+dictlabel[i].value+",测评得分为"+grade2[i].value+"\n";
								}
							}
							window.returnValue=str;
							window.close();
							}
						},
				   error:function(){
					   alert("保存失败！");
				   }
			});
	 }
	 function closeWindow(){
		 window.returnValue="";
			window.close();
	 }
	 
</script>

</html>
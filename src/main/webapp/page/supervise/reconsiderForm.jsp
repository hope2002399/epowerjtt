<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>投诉登记</title>
        <sj:head locale="zh_CN"/>
        <script src="<s:url value='/scripts/centit_validator.js'/>" type="text/javascript" ></script>	
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<s:form action="reconsider" method="post" namespace="/supervise"  theme="simple"  validator="true">
	<s:submit method="save" id="save" cssClass="btn" value="保存" />
	<s:submit method="saveAndSubmit" id="saveAndSubmit" cssClass="btn" value="提交" />
	<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
<div id="frame">
			<iframe id="viewFrame" name="viewFrame" src="<%=request.getContextPath()%>/supervise/reconsider!viewBizInfo.do?bjNo=${object.bjNo}&bjType=${object.bjType}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>
</div>
	
	<fieldset style="display: block; padding: 10px;">
		<legend><b>复议信息</b></legend>
		<s:hidden name="optId" value="%{object.optId}"/>
		<s:hidden name="reconsiderid" value="%{object.reconsiderid}"> </s:hidden>
		<s:hidden name="bjNo" value="%{object.bjNo}" id="bjNo"></s:hidden>
		
		<c:if test="${object.apply.no != null}">
		<s:hidden name="itemId" value="%{object.apply.itemId}"></s:hidden>
		
		</c:if>
		<c:if test="${object.punish.no != null}">
		<s:hidden name="itemId" value="%{object.punish.itemId}"></s:hidden>		
		</c:if>
		
	<table cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd">办件编号<span style="color: red">*</span> </td>
			<td colspan="3">
			<c:if test="${object.apply.no != null}">
			<s:textfield id="internalNo" name="internalNo" readonly="true" value="%{object.apply.internalNo}" style="width:300px;" />
			</c:if>
			<c:if test="${object.punish.no != null}">		
			<s:textfield id="internalNo" name="internalNo" readonly="true" value="%{object.punish.internalNo}" style="width:300px;" />
			</c:if>
			<c:if test="${object.punish.no == null && object.apply.no == null}">		
			<s:textfield  id="internalNo" name="internalNo"  readonly="true" value="%{object.punish.internalNo}" style="width:300px;"/>
	 	<input type="button" valign="center" class='btn' name="listFy" onclick="choosebj();" value="选择办件">
		<%--	<input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/supervise/reconsider!listsup.do?','powerWindow',null);" value="选择">--%>
			
			</c:if> 
			</td>
					<s:hidden id="bjType" name="bjType" value="%{object.bjType}"></s:hidden>
			
		</tr>
		<tr>
				<td class="addTd" >申请复议时间<span style="color: red">*</span></td>
			<td align="left"><sj:datepicker id="applydate"
				name="applydate" value="%{object.applydate}" style="width:120px;"
				yearRange="2000:2020" timepickerFormat="hh:mm" displayFormat="yy-mm-dd" changeYear="true"  timepicker="false" validator="input" min="1"   errorshow="请输入申请复议时间" /></td>
	
		<td class="addTd">申请复议单位<span style="color: red">*</span></td>
			<td align="left">			
			<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.reconsiderapply)}"/>
					<input type="hidden" id="reconsiderapply" name="reconsiderapply" value="${param.reconsiderapply}"/>
			</td>
	</tr>
		
		<tr>
			
			<td class="addTd">申请单位联系电话<span style="color: red">*</span></td>
			<td align="left" colspan="3"><s:textfield name="applyphone" value="%{object.applyphone}"  style="width:200px;"  validator="input" min="1" max="16"  errorshow="请输入申请复议单位联系电话"/></td>
		</tr>
		
		<tr>
		<td class="addTd" >申请复议事由 <span style="color: red">*</span></td>
			<td align="left" colspan="3"><s:textarea  cssStyle="overflow:visible"  name="applyreason"  validator="input" min="1"   errorshow="请输入申请复议事由 "    value="%{object.applyreason}" style="width:100%"></s:textarea></td>
		</tr>
		<tr>
		<td class="addTd" >申请复议内容</td>
			<td align="left" colspan="3"><s:textarea cssStyle="overflow:visible"  name="applyremark" value="%{object.applyremark}" style="width:100%"></s:textarea></td>
		</tr>		
	</table>
	
	
</s:form>
</fieldset>
<fieldset style="display: block; padding: 10px;">
	<legend> <b>材料上传</b></legend>
<iframe id="basicsj"  name="sjfj"
								src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${object.reconsiderid}&stuffInfo.nodeInstId=0&stuffInfo.groupid=133" width="100%" height=""
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0"></iframe>
</fieldset>
</body>
<script type="text/javascript">
function choosebj(){
	var url="${pageContext.request.contextPath}/supervise/reconsider!listsup.do";
	openNewWindow(url, "", "");
	
}
function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height=700px,width=1024px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}

 $(document).ready(function(){ 
   if("${object.bjNo}"==null||"${object.bjNo}"==""){
	   $("#frame").hide();	  
   }else{   
		//var bjtype="处罚";
		var type="${object.bjType}";
		//if(type==1){
			//bjtype="许可";
		//}		
		$("#bjType").val=type;
		//$("#bjtypetd").text(bjtype);
   }
 });
	function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=500px,width=790px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
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
		bindEvent($("#orgName"),$("#reconsiderapply"),$this);
		$("#lists span").die("click");
	});
});
</script>
</html>

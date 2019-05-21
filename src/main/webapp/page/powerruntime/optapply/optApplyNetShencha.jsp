<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="srPermitApply.view.title" /></title>
</head>

<body>


<%@ include file="/page/common/messages.jsp"%>

<!-- <input type="button" value="返回" Class="btn" onclick="window.history.back()" /> -->

	<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>预受理办件审查</b>
			</legend>
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
				<tr>
					<td  class="addTd" style="width:20%;" >
					办理意见：
				
					</td>
					<td  align="left"  style="width:80%;" >
					<textarea rows="5" cols="100" name="blyj" id="blyj" style="width:100%;"></textarea>
				
					</td>
				</tr>

  				<tr>
					<td  align="center" colspan="2">
					<input type="button" id="shouli" value="受理" Class="btn" onclick="shouli('${object.netId}');" />
					<input type="button" id="buzheng" value="补正" Class="btn" onclick="buzheng('${object.netId}');" />
					<input type="button" id="bushouli" value="不受理" Class="btn" onclick="byshouli('${object.netId}');" />
				
					</td>
				</tr>	

				
</table>
</fieldset>
<div id="slfieldset" >
				<fieldset  style="padding:10px;display:block;margin-bottom:10px;">
					<legend style="padding:4px 8px 3px;"><b>材料上传</b></legend>
					<input type="hidden" id="groupId" name="groupId" value="${groupid}" /> 					
					<iframe id="basicsj"  name="sjfj" height="500px;"
								 width="100%"  style="overflow:hidden;"
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0" src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotoyslsqcl.do?optStuffInfoNet.netId=${object.netId}&optStuffInfoNet.nodeInstId=0&optStuffInfoNet.groupid=${groupid}"></iframe>
				</fieldset>
				</div>
<script type="text/javascript">
function shouli(arg){
	var blyj=$("#blyj").val();
	if(blyj==""||blyj==null){
		alert("受理请填写受理意见");
		return ;
	}
	blyj=encodeURI(encodeURI(blyj)); 
	window.parent.location.href="powerruntime/optApplyNet!shouli.do?netId="+arg+"&blyj="+blyj;
	$("#shouli").attr("disabled", true); 
}
function byshouli(arg){
	if(confirm("确定不予受理该办件吗？")){
		var blyj=$("#blyj").val();
		
		if(blyj==""||blyj==null){
			alert("不予受理请填写受理意见");
			return ;
		}
		blyj=encodeURI(encodeURI(blyj)); 
		window.parent.location.href="powerruntime/optApplyNet!byshouli.do?netId="+arg+"&blyj="+blyj;
		$("#bushouli").attr("disabled", true); 
	}
}
function buzheng(arg){
	if(confirm("确定需补证该办件吗？")){
		var blyj=$("#blyj").val();
		
		if(blyj==""||blyj==null){
			alert("补证请填写受理意见");
			return ;
		}
		blyj=encodeURI(encodeURI(blyj)); 
		window.parent.location.href="powerruntime/optApplyNet!buzheng.do?netId="+arg+"&blyj="+blyj;
		$("#buzheng").attr("disabled", true); 
	}
}

</script>

</body>
</html>

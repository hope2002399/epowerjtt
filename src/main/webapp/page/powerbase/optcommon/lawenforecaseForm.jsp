<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
<title>执法案例管理</title>
</head>
<script type="text/javascript">
/**
 * common window dialogs
 */
function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height=600px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}
function downFile(caseno, fileType) {
	var url = "lawenforecase!downloadStuff.do?caseno=" + caseno + "&fileType="
			+ fileType;
	document.location.href = url;
}

function deleteFile(caseno, fileType) {
	var url = "lawenforecase!deleteStuff.do?caseno=" + caseno + "&fileType="
			+ fileType;
	document.location.href = url;
}
</script>
<body>
<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">

<legend style="padding:4px 8px 3px;"><b>案例信息</b></legend>
<s:form action="lawenforecase" method="post" namespace="/powerbase" id="lawenforecaseForm" enctype="multipart/form-data">
			<s:submit name="save" method="lawenforecaseSave" cssClass="btn" key="opt.btn.save" />
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /> 
              <table border="0" cellpadding="0" cellspacing="0" class="viewTable">
              <tr>
					<td class="addTd" width="130">
						案例编号
					</td>
					<td align="left" colspan="3">
						<input type="text" id="caseno" name="caseno" value="${object.caseno}" style="width:300px;" >
  						<s:submit name="check" method="checkCaseNoExist" cssClass="btn"  value="验证案例编号"/>
					</td>
				</tr>
				<tr>
					<td class="addTd" width="130">
						案例标题
					</td>
					<td align="left" colspan="3">
						<input type="text" id="casetitle" name="casetitle" value="${object.casetitle}" style="width:300px;">
  						
					</td>
				</tr>

					<tr>
					<td class="addTd" width="130">
						案例所属部门
					</td>
					<td align="left" colspan="3">
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',object.orgId)}"/>
					<input type="hidden" id="orgId" name="orgId" value="${object.orgId}"/>
					</td>
					
				</tr>	
				<tr>
				<tr>
					<td class="addTd" width="130">案例正文</td>
					<td align="left" colspan="3"><s:file name="casedoc_" size="30%"/> <c:if
							test="${not empty object.docName}">&nbsp;
				<input type="button" name="built" value="查看" class="btn"
								onclick="downFile('${object.caseno}','casedoc')">&nbsp;
				<input type="button" name="built" value="删除" class="btn"
								onclick="deleteFile('${object.caseno}','casedoc')">
						</c:if></td>
				</tr>
			
				
				<tr>
					<td class="addTd" width="130">备注</td>
					<td align="left" colspan="3"><s:textarea name="remark"
							value="%{object.remark}"/>
				</tr>
						<tr>
					<td class="addTd" width="130"><s:text
							name="lawenforecase.bookoperator" /></td>
					<td align="left" ><input type="hidden" id="bookoperator" name="bookoperator"
								value="${object.bookoperator}" />
								<s:property value="%{object.bookoperator}" /></td>
					<td class="addTd" width="130"><s:text
							name="lawenforecase.bookdate" /></td>
					<td align="left" ><s:date name="bookdate"
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
		bindEvent($("#orgName"),$("#orgId"),$this);
		$("#lists span").die("click");
	});
});
</script>
</html>

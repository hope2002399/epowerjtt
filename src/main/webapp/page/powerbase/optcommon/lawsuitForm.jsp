<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title>行政诉讼</title>
		<sj:head locale="zh_CN" />
   		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
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

</script>
<body>
<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">

<legend style="padding:4px 8px 3px;"><b>诉讼信息</b></legend>
<s:form action="lawsuit" method="post" namespace="/powerbase" id="lawsuitForm" enctype="multipart/form-data">
			<s:submit name="save" method="lawsuitSave" cssClass="btn" key="opt.btn.save" onclick="return checkInput();"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /> 
              <table border="0" cellpadding="0" cellspacing="0" class="viewTable">
              <tr>
					<td class="addTd" width="130">
						诉讼编码
					</td>
					<td align="left" colspan="3">
						<input type="text" id="lawsuitno" name="lawsuitno" value="${object.lawsuitno}" style="width:300px;" readonly="readonly">
  						<input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/powerbase/lawsuit!selectList.do?','powerWindow',null);" value="选择">
					</td>
				</tr>
				<tr>
					<td class="addTd">诉讼时间</td>
						
						<td align="left" colspan="3">
						<sj:datepicker id="lawsuitdate" 
			name="lawsuitdate"  style="width:140px"
			yearRange="2000:2020"  displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.lawsuitdate}"/>
				
					</td>
				</tr>
					<tr>
					<td class="addTd" width="130">
						诉讼单位
					</td>
					<td align="left" >
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',object.lawsuitapplyunit)}"/>
					<input type="hidden" id="lawsuitapplyunit" name="lawsuitapplyunit" value="${object.lawsuitapplyunit}"/>
					
					<%-- <select name="lawsuitapplyunit" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList }">
								<option value="${row.depno}"
									<c:if test="${object.lawsuitapplyunit eq row.depno}"> selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select> --%></td>
					<td class="addTd" width="130">
						诉讼办理单位
					</td>
					<td align="left" >
					<input type="text" id="orgName1" name="orgName1"  value="${cp:MAPVALUE('depno',object.lawsuitdep)}"/>
					<input type="hidden" id="lawsuitdep" name="lawsuitdep" value="${object.lawsuitdep}"/>
					
					<%-- <select name="lawsuitdep" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList }">
								<option value="${row.depno}"
									<c:if test="${object.lawsuitdep eq row.depno}"> selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select> --%>
					
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						诉讼完成时间
					</td>
					<td align="left">
			<sj:datepicker id="lawsuitenddate" 
			name="lawsuitenddate"  style="width:140px"
			yearRange="2000:2020"  displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.lawsuitenddate}"/>
					
					</td>
				</tr>
				
				<tr>
					<td class="addTd">
						诉讼结果
					</td>
					<td align="left" colspan="3">
					<select name="lawsuitresult" style="width:180px" >
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('LawsuitResult')}">
									<option value="${row.key}" 
									<c:if test="${object.lawsuitresult eq row.key}"> selected = "selected" </c:if>
									<c:if test="${empty object.lawsuitresult and row.key eq '01'}"> selected = "selected" </c:if>
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="addTd" width="130">备注</td>
					<td align="left" colspan="3"><s:textarea name="lawsuitremark"
							value="%{object.lawsuitremark}"/>
				</tr>
						<tr>
					<td class="addTd" width="130"><s:text
							name="lawsuit.bookoperator" /></td>
					<td align="left" ><input type="hidden" id="bookoperator" name="bookoperator"
								value="${object.bookoperator}" />
								<s:property value="%{object.bookoperator}" /></td>
					<td class="addTd" width="130"><s:text
							name="lawsuit.bookdate" /></td>
					<td align="left" colspan="3"><s:date name="bookdate"
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
		bindEvent($("#orgName"),$("#lawsuitapplyunit"),$this);
		$("#lists span").die("click");
	});
});
$("#orgName1").bind('click',function(){
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
		bindEvent($("#orgName1"),$("#lawsuitdep"),$this);
		$("#lists span").die("click");
	});
});

function checkInput() {
	if ( $("#lawsuitenddate").val()!="" && $("#lawsuitenddate").val()<=$("#lawsuitdate").val() ) {
		alert("诉讼完成时间必须在诉讼时间之后。");
		return false;
	}
}
</script>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>备案登记</title>
<sj:head locale="zh_CN" />
<style type="text/css">
	        td
	        {
	            white-space: nowrap;
	        }
	    </style>
<script type="text/javascript">
function resetForm(){
	  $('#orgName').val('');
	  $('#ownerDepID').val('');
	  $('#constituteId').val('');
	  $('#conDepName').val('');
	  $('#fileName').val('');
	  $('#depFileNo').val('');
	  $('#allFIleNo').val('');
	  $('#punishDate').val('');
	  $('#applyDate').val('');
	  $('#remark').val('');
}
		function chooseDep() {
			var ids;
			ids = window.showModalDialog("<%=request.getContextPath()%>/powerbase/recordFileBasic!chooseDep.do"
					,window,"dialogHeight:500px;dialogWidth:600px ;center:yes;help:no;scroll:yes;status:no;edge:raised");
			if(typeof(ids) == "undefined") {
			} else {
				var depIDs = '';
				var depNames = '';
				var array1 = ids.split(';');
				for(var i=0; i<array1.length; i++) {
					var array2 = array1[i].split(',');
					depIDs = depIDs + array2[0] + ',';
					depNames = depNames + array2[1] + '、';
				}
				depIDs = depIDs.substring(0, depIDs.length-1);
				depNames = depNames.substring(0, depNames.length-1);
				document.forms[0].constituteId.value = depNames;
				document.forms[0].conDepName.value = depIDs;
			}
		}
		  
		</script>
		<sj:head locale="zh_CN" />
   		<script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<script src="<s:url value='/scripts/centit_validator.js'/>" type="text/javascript" ></script>	
</head>

<body>
<s:form action="recordFileBasic" namespace="/powerbase" method="post"
			style="margin-top:0;margin-bottom:5" theme="simple" validator="true">
	<fieldset style="border: hidden 1px #000000; ">
		<legend class="ctitle" style="width:auto;">
		备案基本信息 
		</legend>
		<s:hidden property="recordCode"></s:hidden>
		<table cellpadding="0" cellspacing="0" align="center" class="table_b">
						<TBODY>
						<s:hidden name="backurl"/>
						 <c:if test="${not empty object.recordCode}">
						 <tr>
						 <td width="15%" class="table_b_th">备案编号</td>
							<td colspan="3">
							<s:property value="%{object.recordCode}" />
							</td>
						</tr>
						</c:if>
						
							<tr>
								<td width="15%" class="table_b_th">
									制定部门名称<font color="red">*</font>
								</td>
								<td colspan="2">
									<s:textarea name="constituteId" value="%{object.constituteId}" id="constituteId" readOnly="true" style="width:100%;height:40px;" 
									validator="input" min="1"   errorshow="请选择制定部门" ></s:textarea>
									<s:hidden name="constituteDepName" value="%{object.constituteDepName}" id="conDepName" />
									</td>
									<td>
									<input type="button" name="" value="选择制定部门" onclick="javascript:chooseDep();" class="btn">
								</td>
							</tr>
							<tr>
								<td width="15%" class="table_b_th">
									规范性文件名称<font color="red">*</font>
								</td>
								<td width="35%">
									<s:textfield name="fileName" id="fileName" value="%{object.fileName}" validator="input" min="1"   errorshow="请输入规范性文件名称"/>
								</td>
								<td width="15%" class="table_b_th">
									主办机关<font color="red">*</font>
								</td>
								<td width="35%">
									<%-- <select name="ownerDepID">
										<option value="">--请选择--</option>
										<c:forEach var="row" items="${unitList }">
										<option value="<c:out value='${row.unitcode}'/>"
										<c:if test="${row.unitcode==object.ownerDepID}">selected="selected"</c:if>>   
										<c:out value="${row.unitname}"/>  
										</option>
							</c:forEach>
					</select> --%>
									<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('unitcode',object.ownerDepID)}" validator="input" min="1"   errorshow="请输入选择主办机关"/>
									<input type="hidden" id="ownerDepID" name="ownerDepID" value="${object.ownerDepID}"/>
					
								</td>
							</tr>
							<tr>
								<td width="15%" class="table_b_th">
									主办机关文号<font color="red">*</font>
								</td>
								<td width="35%">
									<s:textfield name="depFileNo" id="depFileNo" value="%{object.depFileNo}" validator="input" min="1"   errorshow="请输入主办机关文号"/>
								</td>
								<td width="15%" class="table_b_th">
									统一编排文号
								</td>
								<td width="35%">
									<s:textfield name="allFIleNo"  id="allFIleNo" value="%{object.allFIleNo}" validator="input" min="1"   errorshow="请输入统一编排文号"/>
								</td>
							</tr>
							<tr>
								<td width="15%" class="table_b_th">
									发布时间
								</td>
								<td width="35%">
									<sj:datepicker name="punishDate" id="punishDate" readonly="true" value="%{object.punishDate}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true"  maxDate="%y-%M-%d"
									/><%-- validator="input" min="1"   errorshow="请输入发布时间" --%>
								</td>
								<td width="15%" class="table_b_th">
									施行时间
								</td>
								<td width="35%">
									<sj:datepicker name="applyDate" id="applyDate" readonly="true" value="%{object.applyDate}" yearRange="2000:2020" displayFormat="yy-mm-dd" maxDate="%y-%M-%d" changeYear="true"
									/><%-- validator="input" min="1"   errorshow="请输入施行时间" --%>
								</td>
							</tr>
							<tr>
								<td width="15%" class="table_b_th">
									报备意见<font color="red">*</font>
								</td>
								<td colspan="3">
									<s:textarea  name="remark" id="remark" value="%{object.remark}" cols="85" rows="5" style="width:100%;height:40px;" 
									validator="input" min="1"   errorshow="请输入报备意见"></s:textarea>
								</td>
							</tr>
						</TBODY>
					</table>
					
					<div align="center">
						<s:submit method="save" key="opt.btn.save" cssClass="btn" /> &nbsp;&nbsp;&nbsp; 
						 <c:if test="${empty object.recordCode}">
						<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>&nbsp;&nbsp;&nbsp;
						</c:if>
						<input type="button" class="btn" value="返回" onclick="window.location.replace('${backurl}');" />
						
					</div>
					
	</fieldset>

</s:form>

</body>
<script type="text/javascript">
	 var menuList = ${unitsJson};
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			var key = $this.attr("rel");
			for (var i=0; i<menuList.length; i++) {
				if (key == menuList[i].MID) {
					o2.val(menuList[i].MID);
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
			menuDisplay(menuList,"${parentUnit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#ownerDepID"),$this);
		$("#lists span").die("click");
	});
});


</script>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<sj:head locale="zh_CN" />
<title>监察人员管理</title>
<style type="text/css">
	.viewTable td { width:37%; }
	.viewTable td.addTd { width:13%; }
</style>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<s:form action="supervisorypersonnel" method="post" namespace="/monitor" id="supervisorypersonnelForm" enctype="multipart/form-data">
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			监察人员基本信息
		</legend>
			<input type="button" value="保存" class="btn" onclick="shSave()"/>
			<input id="userId" type="hidden" name="userId" value="${object.userId}" />
		  	<input id="no" type="hidden" name="no" value="${object.no}" />
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
			<tr>
					<td class="addTd" width="20%"><s:text name="supervisorypersonnel.userName" /></td>
					<td align="left">${object.userName}</td>
					<td class="addTd" width="130">部门名称</td>
					<td align="left">${cp:MAPVALUE("depno",deptcode)}</td>
					</tr>
				<tr>
				<td class="addTd" >出生年月</td>	
				<td align="left">${object.birth}</td>
					<td class="addTd"><s:text name="supervisorypersonnel.sex" /></td>
				<td align="left">
				${cp:MAPVALUE("sex",sex)}
				</td>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.politicalLandscape" /></td>
					<td align="left">${cp:MAPVALUE("POLLANDSCAPE",politicalLandscape)}</td>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.education" /></td>
					<td align="left">${cp:MAPVALUE("EDUCATION",education)}</td>
				</tr>
				<tr>
				<td class="addTd" ><s:text name="supervisorypersonnel.tel" /></td>	
				<td class="left" >${object.tel}</td>
				<td class="addTd" width="130"><s:text name="supervisorypersonnel.position" /></td>
					<td align="left">${cp:MAPVALUE("POSITION",position)}</td>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.organization" /></td>
					<td align="left">${cp:MAPVALUE("ORGANIZATION",organization)}</td>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.updateType" /></td>
					<td align="left">${cp:MAPVALUE("jcry_type",updateType)}</td>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.datesource" /></td>
					<td align="left"><s:if
						test='%{datesource==\"1\"}'>本级数据</s:if> <s:if
						test='%{datesource==\"2\"}'>自建系统上报数据</s:if>
				</td>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.updateDate" /></td>
					<td align="left">${updateDate}</td>
				</tr>
		</table>
	</fieldset>
	<fieldset>
			<legend class="ctitle" style="width: auto; margin-bottom: 5px;"><b>监察人员审核</b></legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span>是否通过</td>
						<td  colspan="3"><select name="isPass" id="isPass">
							<c:forEach var="row" items="${cp:DICTIONARY('isPass')}">
								<option value="${row.key}"
									<c:if test="${isPass eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span>审核意见</td>
					<td align="left" colspan="4">
					<s:textarea name="auditReason" id="auditReason" cols="40" rows="2" style="width:98%;height:40px;" /></td>
				</tr>
			</table>
			</fieldset>
		</s:form>
	<script type="text/javascript">
	</script>
</body>
<script type="text/javascript">
function shSave(){
	 var isPass=document.getElementById("isPass").value;
	 var auditReason=document.getElementById("auditReason").value;
    if(''==isPass){
   	 alert("请选择是否通过");
   	 document.forms[0].isPass.focus();
   	 return;
    }
    if(''==auditReason){
      	 alert("请填写审核意见");
      	 document.forms[0].auditReason.focus();
      	 return;
       }
    var form=document.getElementById("supervisorypersonnelForm");
    form.action="supervisorypersonnel!shSave.do?isPass="+isPass+"&auditReason="+auditReason;     
    form.submit();
    
}
</script>
</html>

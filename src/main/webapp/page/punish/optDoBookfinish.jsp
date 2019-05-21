<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<script type="text/javascript">
function checkForm(){	
	if($("#TR_doc") != undefined){
		//alert(document.getElementById("docName").value);
		if(document.getElementById("poreceiptdoc_").value=='' && document.getElementById("docName").value==''){
			alert("处罚票据扫描件不能为空。");
			document.getElementById("poreceiptdoc_").focus();
			return false;
		}	
	}
	//alert($("#transcontent").val());
	if($("#transcontent").val()==''){
		alert("经办人意不可为空！");
		$('#transcontent').focus();
		return false;
	}
	//alert($("#bjUserNames").val());
	/* if($("#bjUserNames").val()==''){
		alert("审批人员不可为空！");
		$('#bjUserNames').focus();
		return false;
	} */	
	
	/* if($("#bjUserNames").val()!=''){
		var opertator=$("#bjUserNames").val().split(",");
		if(opertator.length<2){
			alert("人员至少选择两位！");
			$('#bjUserNames').focus();
			return false;	
		}		
	} */
	//alert($("#finishType").val());
	/* if($("#finishType").val()==''){
		alert("结案类型不可为空！");
		$('#finishType').focus();
		return false;
	} */
	return true;
}
</script>
</head>
<body>
<s:form action="pofinishbasic" method="post" namespace="/punish" id="generalOperatorForm" target="_parent" onsubmit="return checkForm();" enctype="multipart/form-data">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<s:hidden name="flowPhase" value="%{flowPhase}"/>

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>执行情况登记</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
				<tr>
					<td class="addTd">认定违法事实</td>
					<td align="left" colspan="3">${object.confirmtruth }
					</td>
				</tr>	
				<tr>
					<td class="addTd">违反条款</td>
					<td align="left" colspan="3">${object.disobeyitem }
					</td>
				</tr>	
				<tr>
					<td class="addTd">处罚结论</td>
					<td align="left" colspan="3">${object.podiscussresult }
					</td>
				</tr>
				
				<c:if test="${object.punishamout !=null }">
				<c:if test="${object.punishamout >=0.00}">
					<tr>
					<td class="addTd">缴款金额</td>
					<td align="left">${object.punishamout }元
					</td>
					<td class="addTd">处罚人数</td>
					<td align="left">${object.punishamoutpeople }人
					</td>
				</tr>	
				<c:if test="${ not empty object.punishaffixname}">
				<tr>
					<td class="addTd">处罚票据扫描件</td>
					<td align="left" colspan="3">
		<a  style="text-decoration:underline" href="<%=request.getContextPath()%>/punish/pofinishbasic!downloadstuff.do?object.punishobjectid=${object.punishobjectid}"><c:out value="${object.punishaffixname}" /></a>			
					</td>
				</tr>	
				</c:if>		
				</c:if>	
				
				<c:if test="${object.punishseizure >=0}">
					<tr>
					<td class="addTd">没收件数</td>
					<td align="left">${object.punishseizure }
					</td>
					<td class="addTd">没收价值</td>
					<td align="left">${object.punishseizurevalue }
					</td>
				</tr>				
				</c:if>	
					
				<c:if test="${object.punishshoutont >=0}">
					<tr>
					<td class="addTd">停业天数</td>
					<td align="left" colspan="3">${object.punishshoutont }天
					</td>				
				</tr>				
				</c:if>
				
				<c:if test="${object.punishdetention >=0}">
					<tr>
					<td class="addTd">拘留人数</td>
					<td align="left">${object.punishdetentionpeople } 人
					</td>
					<td class="addTd">拘留天数</td>
					<td align="left">${object.punishdetention }天
					</td>
				</tr>				
				</c:if>						
				</c:if>	
				<c:if test="${ not empty object.otherpunish}">
					<tr>
					<td class="addTd">案件履行情况</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("OtherPunish",object.otherpunish)}
					</td>				
				</tr>
			</c:if>	
			<%-- 	<c:if test="${ not empty object.finishType}">
					<tr>
					<td class="addTd">结案类型</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("finishType",object.finishType)}
					</td>				
				</tr>
			</c:if>	 --%>
				</table>
		</fieldset>
		<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>经办人意见</b>
			</legend>
					<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
						<input type="hidden" name="optProcInfo.transidea" value="同意" id="transidea">
				<c:choose>
					<c:when test="${object.punishamout >=0.00}">
					<tr>
					<td class="addTd">缴款金额</td>
					<td align="left"><s:textfield name="punishamout"
						size="20" value="%{object.punishamout}"/>元
					</td>
					<td class="addTd">处罚人数</td>
					<td align="left">
					<s:textfield name="punishamoutpeople"
						size="20" value="%{object.punishamoutpeople}"/>人
					</td>
				</tr>
				<tr>
					<td class="addTd">处罚票据编号</td>
					<td align="left" colspan="3"><s:textfield name="punishaffixcode"
						size="60" value="%{object.punishaffixcode}"/>
					</td>				
				</tr>
				<tr id="TR_doc">
					<td class="addTd">处罚票据扫描件<font color="red">*</font></td>
				<td align="left" colspan="3">
				<input type="hidden" id="docName" name="docName"  value="${object.punishaffixname}" />
				<s:file id="poreceiptdoc_" name="punishaffixdoc_" style="width:60%;"/> 
				<c:if test="${ not empty object.punishaffixname}">
				<a  style="text-decoration:underline" href="<%=request.getContextPath()%>/punish/pofinishbasic!downloadstuff.do?object.punishobjectid=${object.punishobjectid}">查看</a>
				</c:if>
			</td>
				</tr>	
				
					</c:when>
				<%-- 	<c:otherwise>
						<input type="hidden" name="punishamout" value="${-1.00}">
						<input type="hidden" name="punishamoutpeople" value="${-1}">
					</c:otherwise>--%>
					</c:choose> 
					
						
			
				<c:choose>
					<c:when test="${object.punishseizure >=0}">
					<tr>
					<td class="addTd">没收件数</td>
					<td align="left"><s:textfield name="punishseizure"
						value="%{object.punishseizure}"/>件
					</td>
					<td class="addTd">没收价值</td>
					<td align="left"><s:textfield name="punishseizurevalue"
						value="%{object.punishseizurevalue}"/>
					</td>
				</tr>				
					</c:when>		
					</c:choose> 
					
					<c:choose>
					<c:when test="${object.punishshoutont >=0}">
					<tr>
					<td class="addTd">停业天数</td>
					<td align="left" colspan="3"><s:textfield name="punishshoutont"
						value="%{object.punishshoutont}"/>天
					</td>				
				</tr>				
				</c:when>
				<%-- 	<c:otherwise>
						<input type="hidden" name="punishshoutont" value="${-1}">
					</c:otherwise> --%>
					</c:choose>
				
				<c:choose>
					<c:when test="${object.punishdetention >=0}">
					<tr>
					<td class="addTd">拘留人数</td>
					<td align="left"><s:textfield name="punishdetentionpeople"
						value="%{object.punishdetentionpeople}"/>人
					</td>
					<td class="addTd">拘留天数</td>
					<td align="left"><s:textfield name="punishdetention"
						value="%{object.punishdetention}"/>天
					</td>
				</tr>				
				</c:when>
					<%-- <c:otherwise>
						<input type="hidden" name="punishdetention" value="${-1}">
						<input type="hidden" name="punishdetentionpeople" value="${-1}">
					</c:otherwise> --%>
					</c:choose>
				<tr>
					<td class="addTd">
				案件履行情况</td>
					<td align="left" colspan="3">						
					<select id="otherpunish"  name="otherpunish">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('OtherPunish')}">
								<option value="${row.key}"
								 <c:if test="${object.otherpunish eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>				
					</td>
			<%-- 		<td class="addTd">
				结案类型<font color="red">*</font></td>
					<td align="left">						
					<select id="finishType"  name="finishType">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('finishType')}">
								<option value="${row.key}"
								 <c:if test="${object.finishType eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>				
					</td> --%>
				</tr>
				<tr>
					<td class="addTd">经办人意见<font color="red">*</font></td>
					<td align="left" colspan="3">
						<s:textarea id="transcontent"
								name="optProcInfo.transcontent" style="width:100%; height:40px;" value="%{opi.transcontent}"/>
					</td>
				</tr><tr id="JBR">
					<td class="addTd">审批人员</td>
					<td align="left" colspan="3" >
					${nextOperaters}
							<%-- <input type="text" id="bjUserNames" name="operatorname" style="width:60%;height:30px;" value="${bjUserNames}"  readonly="readonly" /> --%>
							<input type="hidden" id="bjCodes" name="teamRoles" value="${teamRoleCode}" />							
					</td>
					</tr>	
							
						<tr>
						<td class="addTd" width="130">是否风险点</td>
				<td align="left"><s:radio name="optProcInfo.isrisk"
						list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}" listKey="key" listValue="value"/></td>
					<td class="addTd" width="130">
						风险类别
					</td>
					<td align="left">
					<s:textfield name="optProcInfo.risktype"
						size="60" value="%{optProcInfo.risktype}"/>
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						风险描述
					</td>
					<td align="left" colspan="3">
					<s:textarea name="optProcInfo.riskdesc"
						style="width:100%;height:40px;" value="%{optProcInfo.riskdesc}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						风险内控手段与结果	
					</td>
					<td align="left" colspan="3">
						<s:textarea name="optProcInfo.riskresult"  value="%{optProcInfo.riskresult}" style="width:100%;height:40px;" />
					</td>
				</tr>	
		       		
			</table>
		</fieldset>
		
		<center style="margin-top:10px;">
		<span style="display:none;" >
		<s:submit name="saveAndSubmit" method="saveFinishSubmitOpt" cssClass="btn" value="提 交" id="submitBtn"/>
		</span>
		<span style="display:none;" >	
			<s:submit name="save" method="saveOpt" cssClass="btn" value="保 存" id="saveBtn"/>
		</span>
		<span style="display:none;" >
		<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>
			<span style="display:none;" >
		</center>
		</s:form>
</body>

<script type="text/javascript">

$("#bjUserNames").click(function(){
	var s = '${userjson}';
	if(s.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(s),$("#bjUserNames"),$("#bjCodes"));
	};
});

window.parent.hiddSaveBtn();
</script>
</html>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>投诉登记</title>
        <sj:head locale="zh_CN"/>	
	    <script type="text/javascript">
	    	function checkForm() {
	    		if($("#internalNo").val()==''){
	    			alert("请选择办件！");
	    			$('#internalNo').focus();
	    			return false;
	    		}	
	    		if($("#graentOrgId").val()==''){
	    			alert("请选择主办部门！");
	    			$('#graentOrgId').focus();
	    			return false;
	    		}	
	    		if($("#complaintdate").val()==''){
	    			alert("请填写投诉时间！");
	    			$('#complaintdate').focus();
	    			return false;
	    		}	
	    		if($("#complaintman").val()==''){
	    			alert("请填写投诉人姓名！");
	    			$('#complaintman').focus();
	    			return false;
	    		}	
	    		if($("#complaintphone").val()==''){
	    			alert("请填写投诉人联系电话！");
	    			$('#complaintphone').focus();
	    			return false;
	    		}
	    		if($("#complaintsType").val()==null||$("#complaintsType").val()==''){
	    			alert("请选择投诉类型！");
	    			$('#complaintsType').focus();
	    			return false;
	    		}
	    		if($("#complaintsSource").val()==null||$("#complaintsSource").val()==''){
	    			alert("请选择投诉来源！");
	    			$('#complaintsSource').focus();
	    			return false;
	    		}
	    	
	    		
	    		if($("#complaintreason").val()==''){
	    			alert("请填写投诉事由！");
	    			$('#complaintreason').focus();
	    			return false;
	    		}	
	    		
	    		
	    		if(getStringLen($("#complaintreason").val())>100){
	    			alert("投诉事由过长，请不要超过100个字符！");
	    			$('#complaintreason').focus();
	    			return false;
	    		}
	    		if(getStringLen($("#complaintremark").val())>200){
	    			alert("投诉内容过长，请不要超过200个字符！");
	    			$('#complaintremark').focus();
	    			return false;
	    		}
	    	}
	    	
	    	function getStringLen(Str) {
	    		var i, len, code;
	    		if (Str == null || Str == "")
	    			return 0;
	    		len = Str.length;
	    		for (i = 0; i < Str.length; i++) {
	    			code = Str.charCodeAt(i);
	    			if (code > 255) {
	    				len++;
	    			}
	    		}
	    		return len;
	    	}
	    	
	         function openNewWindow(winUrl,winName,winProps){
	    		if(winProps =='' || winProps == null){
	    			winProps = 'height=700px,width=860px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	    		}
	    		window.open(winUrl, winName, winProps);
	    	}
	    </script>
	</head>
	<body>
 
	<s:form action="complaint"  namespace="/complaint"  theme="simple"  validator="true">
	

	<s:submit onclick="return checkForm();" method="save" id="save" cssClass="btn" value="保存" />
	<s:submit onclick="return checkForm();" method="saveAndSubmit" id="saveAndSubmit" cssClass="btn" value="提交" />
	<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
	<s:reset type="button" name="reset" cssClass="btn" value="重置"></s:reset>
		<c:if test="${object.apply.no != null}"> 
	<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">基本信息</legend>
		<table cellpadding="0" cellspacing="0" class="viewTable">
		<tr> 
		<td class="addTd">办件事项</td>
		<td align="left">${object.apply.internalNo}</td><td class="addTd">主办部门</td><td >${object.apply.department}</td>
		</tr>
		<tr> 
		<td class="addTd">申请者名称</td><td>${object.apply.applicantName}</td><td class="addTd">申请者类型</td><td>${cp:MAPVALUE("PROPOSER_TYPE",object.apply.applicantType)}</td>
		</tr>
		<tr> 
		<td class="addTd">登记时间</td><td>${object.apply.applyDate}</td>
		</tr>
		<tr> 
		<td class="addTd">权力名称</td><td>${cp:MAPVALUE("suppowerId",object.apply.itemId)}</td>
		</tr>
		</table>
	</fieldset>	
	 </c:if>
	 <c:if test="${object.punish.no != null}"> 
	<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">基本信息</legend>
		<table cellpadding="0" cellspacing="0" class="viewTable">
		<tr> 
		<td class="addTd">办件编号</td><td align="left">${object.punish.internalNo}</td><td class="addTd">主办部门</td><td >${object.punish.department}</td>
		</tr>
		<tr> 
		<td class="addTd">受理单位</td><td>${cp:MAPVALUE("unitcode",object.punish.department)}</td><td class="addTd">案件来源</td><td >${cp:MAPVALUE("CASEORIGN",(object.punish.source))}</td> 
		</tr>
		<tr> 
		<td class="addTd">案件时间</td><td>${object.punish.ajOccurDate}</td>	<td class="addTd">当事人性质</td><td >${cp:MAPVALUE("PROPOSER_TYPE",(object.punish.targetType))}</td>
		</tr>
		<tr> 
		<td class="addTd">案件地点</td><td>${cp:MAPVALUE("suppowerId",object.punish.ajAddr)}</td>
		</tr>
		</table>
	</fieldset>	
	 </c:if>
	
	<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">投诉信息</legend>
		<s:hidden name="optId" value="%{object.optId}"/>
		<s:hidden name="complaintid" value="%{object.complaintid}"> </s:hidden>
		<s:hidden name="bjNo" value="%{object.bjNo}"></s:hidden>
		
		<c:if test="${object.apply.no != null}">
		<s:hidden name="itemId" value="%{object.apply.itemId}"></s:hidden>
		
		</c:if>
		<c:if test="${object.punish.no != null}">
		<s:hidden name="itemId" value="%{object.punish.itemId}"></s:hidden>		
		</c:if>
		
		<c:if test="${object.punish.no == null&&object.punish.no== null}">
		<s:hidden id="itemId" name="itemId" value=""></s:hidden>		
		</c:if>
		
	<table cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd">办件编号<span style="color: red">*</span> </td>
			<td>
			<c:if test="${object.apply.no != null}">
			<s:textfield name="internalNo" id="internalNo" readonly="true" value="%{object.apply.internalNo}" style="width:300px;" />
			</c:if>
			<c:if test="${object.punish.no != null}">		
			<s:textfield name="internalNo"  id="internalNo" readonly="true" value="%{object.punish.internalNo}" style="width:300px;" />
			</c:if>
			<c:if test="${object.punish.no == null && object.apply.no == null}">		
			<s:textfield name="internalNo" id="internalNo" value="%{object.punish.internalNo}" style="width:300px;" readonly ="true" />
			<%
			Date date = new Date();//当前日期  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化对象
			Calendar calendar = Calendar.getInstance();//日历对象
			calendar.setTime(date);//设置当前日期  
			calendar.add(Calendar.MONTH, -1);//月份减一  
			String begtime=sdf.format(calendar.getTime());
			%>
			<input type="button" class='btn' name="powerBtn" onClick="openNewWindow('<%=request.getContextPath()%>/complaint/complaint!selectList.do?s_begTime=<%=begtime %>','powerWindow',null);" value="选择">
			</c:if>
			</td>
			
			<td class="addTd" >投诉时间<span style="color: red">*</span></td>
			<td align="left" colspan="3"><sj:datepicker id="complaintdate"
				name="complaintdate"  value="%{object.complaintdate}" style="width:120px;"
				displayFormat="yy-mm-dd" validator="input" min="1" maxDate="%y-%M-%d"  errorshow="请输入投诉时间"  timepicker="true"  timepickerFormat="HH:mm"  readonly ="true" />
			</td><!-- timepicker="true"  timepickerFormat="HH:mm"  -->
		
		</tr>
	
		<tr>
		<td class="addTd">主办部门<span style="color: red">*</span></td>
			<td align="left">			
					<select name="graentOrgId" id="graentOrgId">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList}">
								<option value="${row.depno}"
									<c:if test="${object.graentOrgId eq row.depno}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select>
			</td>
			<%-- <td class="addTd">主办部门<span style="color: red">*</span></td>
			<td align="left">	
			<label for ="orgName" >${cp:MAPVALUE('depno',graentOrgId)}</label> 
			<input type="hidden" id="graentOrgId" name="graentOrgId" value="${graentOrgId}"/>		
			</td>--%>
			<td class="addTd">办件类型<span style="color: red">*</span></td>
			<td><select name ="bjType" id ="bjType"  errorshow="请选择办件类型" validator="true">  
								<option value="1" <c:if test="${object.apply.no != null}">selected="true"</c:if>>许可</option>
								<option value="2" <c:if test="${object.punish.no != null}">selected="true"</c:if>>处罚</option></select></td>
	</tr>
		
		<tr>
			<td class="addTd">投诉人<span style="color: red">*</span></td>
			<td align="left"><s:textfield name="complaintman" id="complaintman" value="%{object.complaintman}" validator="input" min="1" max="16"  errorshow="请输入投诉人姓名" style="width:200px;" /></td>
			<td class="addTd">联系电话<span style="color: red">*</span></td>
			<td align="left"><s:textfield name="complaintphone" id="complaintphone" value="%{object.complaintphone}"  style="width:200px;"  validator="input" min="1" max="16"  errorshow="请输入投诉人联系电话"/></td>
		</tr>
		<tr>
			<td class="addTd">投诉类型<span style="color: red">*</span></td>
				<td><select name ="complaintsType" id ="complaintsType">
					<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('COMPLAINTS_TYPE')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${object.complaintsType==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
			</td>
			<td class="addTd">投诉来源<span style="color: red">*</span></td>
				<td><select name ="complaintsSource" id ="complaintsSource">
					<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TS_SOURCE')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${object.complaintsSource==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
			</td>
		</tr>
		<tr>
		<td class="addTd" >投诉事由 <span style="color: red">*</span></td>
			<td align="left" colspan="3"><s:textarea  cssStyle="overflow:visible"  name="complaintreason" id="complaintreason" validator="input" min="1"   errorshow="请输入投诉事由"    value="%{object.complaintreason}" ></s:textarea></td>
		</tr>
		<tr>
		<td class="addTd" >投诉内容</td>
			<td align="left" colspan="3"><s:textarea cssStyle="overflow:visible"  name="complaintremark" id="complaintremark" value="%{object.complaintremark}"></s:textarea></td>
		</tr>		
	</table>
	
	
</s:form>
</fieldset>
<fieldset>
	<legend>材料上传</legend>
<iframe id="basicsj"  name="sjfj"
								src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${object.complaintid}&stuffInfo.nodeInstId=0&stuffInfo.groupid=127" width="100%" height="100%"
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0"></iframe>
</fieldset>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="wfFlowInstance.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="wfFlowInstance.edit.title" /></p>
<%@ include file="/page/common/messages.jsp"%>

<s:form action="wfFlowInstance"  method="post" namespace="/sampleflow" id="wfFlowInstanceForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<input type="button" name="back" class="btn" value="返回" onclick="window.history.go(-1);"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">	
				<tr>	
					<td class="TDTITLE">
						<s:text name="wfFlowInstance.wfcode"  />
					</td>
					<td align="left">
						<s:textfield name="wfcode"  readonly="true" size="40"/>
					</td>
				</tr>
								<tr>
					<td class="TDTITLE">
						<s:text name="wfFlowInstance.version" />
					</td>
					<td align="left">
						<s:textfield name="version" readonly="true"   size="40"/>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						<s:text name="wfFlowInstance.issubinst" />
					</td>
					<td align="left">
				    <s:radio name="issubinst" list="#{'Y':'是','N':'否' }" listKey="key" listValue="value" ></s:radio>
					</td>
				</tr>
<!-- 
				<tr>
					<td class="TDTITLE">
						<s:text name="wfFlowInstance.preinstid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="preinstid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="wfFlowInstance.prenodeinstid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="prenodeinstid"  size="40"/>
	
					</td>
				</tr>
 -->
				<tr>
					<td class="TDTITLE">
						<s:text name="wfFlowInstance.unitcode" />
					</td>
					<td align="left">
						<select name="unitcode">   
							<option value="0">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="row" items="${cp:LVB('unitcode')}">       
								<option value="${row.value}">   
									<c:out value="${row.label}"/>   
								</option>       
							</c:forEach> 
						</select>
					</td>
				</tr>

</table>
</s:form>
</body>
</html>

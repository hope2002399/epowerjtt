<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
</head>
<body>
<s:form action="poregisterbasic" namespace="/punish" target="_parent" >

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>初核与立案审批</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
				<tr>
					<td class="addTd">处罚项目</td>
					<td align="left" colspan="3">${vsuppowerinusing.itemName}
					</td>
				</tr>					
				<tr>
					<td class="addTd">相关法律法规</td>
					<td align="left" colspan="3">${object.poregisterbasis}
					</td>
				</tr>
		       <tr>
					<td class="addTd">调查情况</td>
					<td align="left" colspan="3">${object.poregisterindagate}
					</td>
				</tr>	
				<c:if test="${ not empty object.jbrOption_la}">
				<tr>				
				<td class="addTd" width="130">
						经办人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.jbrOption_la}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.jbr_la}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.jbrOption_latime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
								<c:if test="${ not empty object.ksOption_la}">
				<tr>
				<td class="addTd" width="130">
						科室意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.ksOption_la}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.ks_la}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.ksOption_latime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
				<c:if test="${ not empty object.fzrOption_la}">
				<tr>
				<td class="addTd" width="130">
						部门负责人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.fzrOption_la}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.fzr_la}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.fzrOption_latime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
				

				<tr rowspan="${fn:length(optStuffs)}">
	<td class="addTd" width="130">
			环节格式文书
	</td>
	<td align="left" colspan="3">
<c:forEach var="stfobj" items="${optStuffs}">
<a  style="text-decoration:underline;color: blue;" href="<%=request.getContextPath()%>/powerruntime/generalOperator!downStuffInfo.do?stuffid=${stfobj.stuffid}&netid=${stfobj.netId}">${stfobj.filename}</a>&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>
	</td>
</tr>					
			</table>
		</fieldset>	
		</s:form>
</body>

</html>
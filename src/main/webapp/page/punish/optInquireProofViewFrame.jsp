<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
</head>
<body>
	
	<fieldset style="display: block; padding: 10px;">
		<legend>
			<b>调查取证信息</b> 
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" id="tb"
			class="viewTable" style="margin-top: 20px;">
			<tr>
				<td class="addTd">认定违法事实</td><td>${object.confirmtruth} </td>
			</tr>
			<tr>
				<td class="addTd">不认定违法事实</td><td>${object.unconfirmtruth}</td>
			</tr>
			<tr>
				<td class="addTd">调查经过</td><td>${object.poindagatereppassage}</td>
			</tr>
			<c:if test="${not empty object.poindagaterepresult}">
			<tr>
				<td class="addTd">违法条款</td><td>${object.disobeyitem}</td>
			</tr>
			<tr>
				<td class="addTd">处罚意见</td><td>${object.poindagaterepresult}</td>
			</tr>
			</c:if>
			<c:if test="${ not empty object.jbrOption_dczj}">
				<tr>				
				<td class="addTd" width="130">
						经办人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.jbrOption_dczj}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.jbr_dczj}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.jbrOptiontime_dczj" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
				

				
				<c:if test="${ not empty object.ksOption_dczj}">
				<tr>
				<td class="addTd" width="130">
						科室意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.ksOption_dczj}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.ks_dczj}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.ksOptiontime_dczj" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
				</c:if>
				
								<c:if test="${ not empty object.fzrOption_dczj}">
				<tr>
				<td class="addTd" width="130">
						部门负责人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.fzrOption_dczj}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.fzr_dczj}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.fzrOptiontime_dczj" format="yyyy-MM-dd HH:mm:ss"/>
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
</body>
</html>
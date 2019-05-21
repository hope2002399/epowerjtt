<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
<head><meta name="decorator" content='${LAYOUT}'/>
	<title>用户信息--<c:out
				value="${userinfo.username}" />
	</title>
<style type="text/css">
table tr td {
	border:1px solid gray;
}

</style>

</head>
<body>
	<br/>
		  
	<table cellpadding="0" cellspacing="0" >
		<tr >
			<td class="addTd">用户ID：</td>
			<td align="left" width="150">${object.userID }&nbsp;</td>
			<td class="addTd">用户名：</td>
			<td align="left" width="150">${object.userName}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">公司：</td>
			<td align="left">${object.depName}&nbsp;</td>
			<td class="addTd">公司地址：</td>
			<td align="left">${object.depAaddress}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">法人代表：</td>
			<td align="left">${object.artificialPerson}&nbsp;</td>
			<td class="addTd">联系人：</td>
			<td align="left">${object.linkman}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd"> 身份证号码：</td>
			<td align="left">${object.papercode}&nbsp;</td>
			<td class="addTd">邮箱：</td>
			<td align="left">${object.email}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">邮编：</td>
			<td align="left">${object.post}&nbsp;</td>
			<td class="addTd">电话：</td>
			<td align="left">${object.telephone}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">组织机构代码：</td>
			<td align="left">${object.unitcode}&nbsp;</td>
			<td class="addTd">企业营业执照：</td>
			<td align="left">
			<a href="${pageContext.request.contextPath}/sys/applyUser!downStuffInfo.do?userID=${object.userID}" >${object.filename}</a>&nbsp;
			</td>
		</tr>
		<tr>
			<td class="addTd">状态：</td>
			<td align="left" colspan="3">
				<c:if test="${object.isInUse eq '1'}">
					在用
				</c:if>
				<c:if test="${object.isInUse eq '2'}">
					审核未通过
				</c:if>
				<c:if test="${object.isInUse eq '3'}">
					未审核
				</c:if>
				<c:if test="${object.isInUse eq '0'}">
					已停用
				</c:if>
			</td>
			
		</tr>
		<c:if test="${!(object.isInUse eq '')}">
			<tr>
			<td class="addTd">审核人：</td>
			<td align="left">${object.checkOperatorName}</td>
			<td class="addTd">审核日期：</td>
			<td align="left">${object.checkDate}</td>
		</tr>
		</c:if>
		
		<tr>
			
			<td colspan="4" align="center">
	
			<input type="button" value="返回" class="btn" onclick="window.history.back();">					
			</td>			
		</tr>
	</table>


	
		

</body>
</html>

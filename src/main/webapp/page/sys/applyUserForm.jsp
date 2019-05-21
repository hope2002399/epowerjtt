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
	<s:form action="applyUser" theme="simple">		  
	<table cellpadding="0" cellspacing="0" >
		<tr>
			<td class="addTd">用户ID：</td>
			<td align="left" width="150">${object.userID }&nbsp;</td>
			<td class="addTd">用户名：</td>
			<td align="left" width="150">${object.userName}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">公司：</td>
			<td align="left" width="150">${object.depName}&nbsp;</td>
			<td class="addTd">公司地址：</td>
			<td align="left" width="150">${object.depAaddress}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">法人代表：</td>
			<td align="left" width="150" >${object.artificialPerson}&nbsp;</td>
			<td class="addTd">联系人：</td>
			<td align="left" width="150">${object.linkman}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd"> 身份证号码：</td>
			<td align="left" width="150">${object.papercode}&nbsp;</td>
			<td class="addTd">邮箱：</td>
			<td align="left" width="150">${object.email}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">邮编：</td>
			<td align="left" width="150" >${object.post}&nbsp;</td>
			<td class="addTd">电话：</td>
			<td align="left" width="150" >${object.telephone}&nbsp;</td>
		</tr>
		<tr>
			<td class="addTd">组织机构代码：</td>
			<td align="left" width="150" >${object.unitcode}&nbsp;</td>
			<td class="addTd">企业营业执照：</td>
			<td align="left" width="150" >
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
		<c:if test="${!(object.isInUse eq '3')}">
			<tr>
			<td class="addTd">审核人：</td>
			<td align="left">${object.checkOperatorName}</td>
			<td class="addTd">审核日期：</td>
			<td align="left">${object.checkDate}</td>
		</tr>
		</c:if>
		<tr>
		<td colspan="2" align="center">审核结果 <input type="hidden" name="userID" value="${object.userID }"/></td>
		<td colspan="2" align="center"><input name="isInUse" type="radio" checked value="1"/> 通过 &nbsp;&nbsp;&nbsp; <input name="isInUse" type="radio" value="2"/> 不通过</td>
		</tr>
		<tr>
			
			<td colspan="4" align="center">
			<s:submit method="savesh" cssClass="btn" value="提交" ></s:submit>
			<input type="button" value="返回" class="btn" onclick="window.history.back();">					
			</td>			
		</tr>
	</table>
</s:form>

	
		

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
  
				<tr>
					<td class="addTd" width="130">
						<c:if test="${object.poreceiptstate==1}">预先告知书回执</c:if><c:if test="${object.poreceiptstate==2}">告知书回执</c:if>
					</td>
					<td align="left">
						<a  href="<%=request.getContextPath()%>/punish/poreceiptinfo!downloaddiscussstuff.do?punishobjectid=${object.punishobjectid}&poreceiptstate=${object.poreceiptstate}"><span style="text-decoration:underline;color: blue">${object.poreceiptname}
					</td>
				</tr>
				
				<tr>
					<td class="addTd" width="130">
						回执签收时间
					</td>
					<td align="left">
						<s:date name="signineddate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
  
				
</table>



</body>
</html>

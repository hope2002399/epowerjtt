<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<%@ page import="java.util.List"%>
<%@ page import="com.centit.monitor.po.ApplyProcess"%>
<%@ page import="com.centit.monitor.po.ApplyDoc"%>
<%@ page import="com.centit.sys.service.CodeRepositoryUtil"%>
<html>
<head>
<title>办件对比</title>
</head>
<body>
	<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="viewTable" style="table-layout:fixed;">
		<%
			List applyList = (List) request.getAttribute("applyList");
			for (int i = 0; i < applyList.size(); i++) {
				Object[] temp = (Object[]) applyList.get(i);
		%>

		<tr style="min-height:22px">
			<%
				for (int j = 0; j < temp.length; j++) {
			%>
			<%
				if (j == 0) {
			%>
			<td class="addTd"><%=temp[j] == null ? "" : temp[j]%></td>
			<%
				} else {
					if (temp[j] instanceof List<?>) {
						Object o = ((List) temp[j]).size()>0?((List) temp[j]).get(0):null;
						if (o == null) {
						%>
							<td></td>
						<%
						}
						else if (o instanceof ApplyProcess){
					%>	
							<td valign="top" align="left">	
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
									<tr class="b_darkblue">
										<td style="text-align:center">环节名称</td>
										<td style="text-align:center">办理科室</td>
										<td style="text-align:center">岗位状态</td>
									</tr>
									<%List<ApplyProcess> processList = (List<ApplyProcess>)temp[j];
									for (int k=0;k<processList.size();k++) {%>
										<tr class="b_gray">
											<td style="text-align:center"><%=processList.get(k).getTacheName() %></td>
											<td style="text-align:center"><%=processList.get(k).getDepartment() %></td>
											<td style="text-align:center"><%=CodeRepositoryUtil.getValue("APPLYSTATUS", processList.get(k).getStatus()) %></td>
										</tr>
									<%} %>
								</table>
							</td>
				<%	
						}
						else if (o instanceof ApplyDoc){
				%>
							<td valign="top" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
							   		<tr class="b_darkblue">
										<td style="text-align:center">材料名称</td>
										<td style="text-align:center">附件名称</td>
										<td style="text-align:center">材料类型</td>	
									</tr>
									<%List<ApplyDoc> docList = (List<ApplyDoc>)temp[j];
									for (int k=0;k<docList.size();k++) {%>
										<tr class="b_gray">
											<td style="text-align:center"><%=docList.get(k).getDocName() %></td>
											<td style="text-align:center"><%=docList.get(k).getDocumentName() %></td>
											<td style="text-align:center"><%=CodeRepositoryUtil.getValue("DOC_TYPE", docList.get(k).getDocType()) %></td>
										</tr>
									<%} %>
								</table>
				<%
						}
					} else {
						if (j > 1 && temp[j] != null && !temp[j].equals(temp[j - 1])) {
					%>
					<td align="left" style="color: red"><%=temp[j] == null ? "" : temp[j]%></td>
					<%
						} else {
					%>
					<td align="left"><%=temp[j] == null ? "" : temp[j]%></td>
					<%
						}
					}
				}
			}
			%>
		</tr>

		<%
		}
		%>

	</table>
</body>
</html>
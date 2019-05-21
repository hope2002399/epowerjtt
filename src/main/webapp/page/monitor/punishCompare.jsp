<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<%@ page import="java.util.List"%>
<%@ page import="com.centit.monitor.po.PunishProcess"%>
<%@ page import="com.centit.monitor.po.PunishDoc"%>
<%@ page import="com.centit.monitor.po.PunishResult"%>
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
			List punishList = (List) request.getAttribute("punishList");
			for (int i = 0; i < punishList.size()-1; i++) {
				Object[] temp = (Object[]) punishList.get(i);
		%>

		<tr style="min-height:22px">
			<%
				for (int j = 0; j < temp.length; j++) {
				if (j == 0) {
					%>
					<td colspan=2 class="addTd"><%=temp[j] == null ? "" : temp[j]%></td>
					<%
				} else {
					if (temp[j] instanceof List<?>) {
						Object o = ((List) temp[j]).size()>0?((List) temp[j]).get(0):null;
						if (o == null) {
						%>
							<td></td>
						<%
						}
						else if (o instanceof PunishProcess){
					%>	
							<td valign="top" align="left">	
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
									<tr class="b_darkblue">
										<td style="text-align:center">环节名称</td>
										<td style="text-align:center">办理科室</td>
										<td style="text-align:center">岗位状态</td>
									</tr>
									<%List<PunishProcess> processList = (List<PunishProcess>)temp[j];
									for (int k=0;k<processList.size();k++) {%>
										<tr class="b_gray">
											<td style="text-align:center"><%=processList.get(k).getTacheName() %></td>
											<td style="text-align:center"><%=processList.get(k).getDepartment() %></td>
											<td style="text-align:center"><%=CodeRepositoryUtil.getValue("PUNISHSTATUS", processList.get(k).getStatus()) %></td>
										</tr>
									<%} %>
								</table>
							</td>
				<%	
						}
						else if (o instanceof PunishDoc){
				%>
							<td valign="top" align="left">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
							   		<tr class="b_darkblue">
										<td style="text-align:center">材料名称</td>
										<td style="text-align:center">附件名称</td>
										<td style="text-align:center">材料类型</td>	
									</tr>
									<%List<PunishDoc> docList = (List<PunishDoc>)temp[j];
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
		Object[] temp = (Object[]) punishList.get(punishList.size()-1);
		%>
		
		<tr style="min-height:22px">
			<td rowspan=18 class="addTd">案件结果信息</td>
			<td class="addTd">行政处罚编码</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getItemId()==null?"":((PunishResult)temp[j]).getItemId() %></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">权力名称</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getItemId()==null?"":CodeRepositoryUtil.getValue("suppowerId", ((PunishResult)temp[j]).getItemId()) %></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">处罚程序</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getProgram()==null?"":CodeRepositoryUtil.getValue("PROGRAM", ((PunishResult)temp[j]).getProgram()) %></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">办结时间</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getFinishDate()==null?"":((PunishResult)temp[j]).getFinishDate().toLocaleString() %></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">处罚分类</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishSort()==null?"":((PunishResult)temp[j]).getPunishSort() %></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">自由裁量标准</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getStandard()==null?"":((PunishResult)temp[j]).getStandard()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">处罚决定</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishDeside()==null?"":CodeRepositoryUtil.getValue("PUNISH_DESIDE", ((PunishResult)temp[j]).getPunishDeside())%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">处罚种类</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishClass()==null?"":CodeRepositoryUtil.getValue("punishType", ((PunishResult)temp[j]).getPunishClass())%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">处罚结果</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResult()==null?"":((PunishResult)temp[j]).getPunishResult()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">罚款金额</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultFine()==null?"":((PunishResult)temp[j]).getPunishResultFine()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">罚款人数</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultFinePeople()==null?"":((PunishResult)temp[j]).getPunishResultFinePeople()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">没收件数</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultExpropriation()==null?"":((PunishResult)temp[j]).getPunishResultExpropriation()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">没收价值</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultExpropriationV()==null?"":((PunishResult)temp[j]).getPunishResultExpropriationV()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">停业天数</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultBusiness()==null?"":((PunishResult)temp[j]).getPunishResultBusiness()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">拘留人数</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultPeople()==null?"":((PunishResult)temp[j]).getPunishResultPeople()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">拘留天数</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getPunishResultDetain()==null?"":((PunishResult)temp[j]).getPunishResultDetain()%></td>
			<%} %>
		</tr>
		<tr style="min-height:22px">
			<td class="addTd">处罚法律依据</td>
			<%for (int j = 1; j < temp.length; j++) { %>
				<td align="left"><%=temp[j]==null||((PunishResult)temp[j]).getAccordance()==null?"":((PunishResult)temp[j]).getAccordance()%></td>
			<%} %>
		</tr>

	</table>
</body>
</html>
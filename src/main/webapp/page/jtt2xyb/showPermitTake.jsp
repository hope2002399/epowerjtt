<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css">
<html>
	<head>
	</head>
	<body style="background-color:#f6f7fb;" >
		 <%
	     List<Object[]> list = (List<Object[]>) request.getAttribute("list");
        %>
			<table style="width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;" 
			id="statTable" cellpadding="0" border="0" cellspacing="0" class="treetable">
				<thead>
					<tr>  
				        <th scope="col" style="width: 30%;">行政许可决定书文号</th>  
				        <th scope="col" style="width: 70%;">错误原因</th>  
		 		   </tr>  
	 		   </thead>
	 		   <tbody align="center">
		  <%
				for (int i = 0; i < list.size(); i++) {
					Object[] info = list.get(i);
					if(i%2!=0){
						
		   %>   
				<tr style="display: table-row;background: rgb(223, 228, 232);">
					<td ><%=info[0] %></td>
					<td style="text-align: center;"><%=info[1] %></td>
				</tr>
				<%}else{%>
					<tr style="display: table-row; background: rgb(255, 255, 255);">
					<td ><%=info[0] %></td>
					<td style="text-align: center;"><%=info[1] %></td>
				</tr>
				<%}%>
				<%}%>
				</tbody>
			</table>
</body>
</html>

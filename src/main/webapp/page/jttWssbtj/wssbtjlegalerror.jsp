<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
		<title>
		申请人为法人证件号码无效的数据
		</title>
		<sj:head locale="zh_CN" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css" id="css1">
		<script
		src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/css/jquery.pagination.css" id="css2"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/list.css" type="text/css" id="css3"/>
		<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/js/jquery.pagination.min.js"></script>
		<script src="${pageContext.request.contextPath}/scripts/print.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){ 
			setTimeout('closeTable()', 100); //延迟1秒
			
		}); 
		function closeTable(){
			$("#treeTable tr").each(function(){
					var attr = $(this).attr("data-tt-parent-id");
					if((typeof attr !== typeof undefined && attr !== false) && attr !='' && attr != 'null'){
						$(this).attr("style","background: rgb(255, 255, 255); display: none;");
					}else{
						$(this).attr("class","altrow branch collapsed");
					}
			})
			$("#treeTable tr td").each(function(){
				if($(this).children().eq(0).children("a").length > 0){
					$(this).children().eq(0).children().click();
					$(this).children().eq(0).children().click();
					return false;
				}
				
			})
		}
		</script>
</head>
<body style="width: 99%;" marginwidth="0" marginheight="0" >
	<div class="container" style="padding-top: 5px;padding-left: 5px;">
<style>
form {
	float: left
}

form span.addTd {
	margin: 5px 0px 5px 5px;
	float: left;
}
form div.addbutton {
	margin: 10px 0px 5px 5px;
	float: right;
}
form div.addTd {
	margin: 5px 0px 5px 5px;
	float: left;
}

form span.addTd lable {
	width: 80px;
	float: left
}

.addTd {
	width: 300px;
	padding: 10px
}

</style>
	<div class="search stat">
		<div class="crumbs">申请人为法人证件号码无效的数据</div>
			<form action="。/sys/jttWssbtjsx!showlegalerrorList.do" method="get" >
			<%
				String startTime = (String)request.getAttribute("startTime");
				String endTime   = (String)request.getAttribute("endTime");
			%>
			<span class="addTd">
				 <label>开始时间：</label>
				 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionBeginTime" 
				 value="<%=startTime%>" name="startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
			</span>
			<span class="addTd">
				 <label>结束时间：</label>
				 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="decisionEndTime" 
				 value="<%=endTime%>" name="endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
			</span>
			<div class="addbutton">
				<input type="submit"  class="btn" value="查询">
				<input type="button" class="btn" value="导出" onclick="return exportExcel();">
			</div>
		</form> 
	</div>
<div>
	<div>
					<table width="100%" border="0" cellpadding="0" id="treeTable" class="tableRegion" cellspacing="0" class="zn2">
						<caption style="font-size: 16px;padding: 5px;color: #2D80D2;font-weight: bold;">申请人为法人证件号码无效的数据</caption>
						<thead>
							<tr>  
						        <th scope="col" >地区</th>  
						        <th scope="col" >公路</th>
						        <th scope="col" >运管</th>  
						        <th scope="col" >港口</th>  
						        <th scope="col" >海事</th>
						        <th scope="col" >航道</th>
						        <th scope="col" >质监</th>
						        <th scope="col" >建设</th>
						        <th scope="col" >高管</th>
						        <th scope="col" >合计</th>
				 		   </tr> 
						</thead>
						<tbody id="dataStatisTbody" align="center">
				  <%
			     List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("map");
				  for (int i = 0; i < list.size(); i++) {
						Map<String,Object> info = list.get(i);
						if(i%2!=0){
		        %>   
						<tr data-tt-id="<%=info.get("areaNo") %>" <%if(info.get("parentNo") != "")
											{%>data-tt-parent-id="<%=info.get("parentNo") %>"<%}%>>
							<td ><%=info.get("areaName") %></td>
							<td >
							<%-- <%if(!info.get("gl").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("SBSLDJID") %>"><%=info.get("gl") %></a>
							<%}else{out.write(info.get("gl").toString());}%> --%>
							<%=info.get("gl") %>
							</td>
							<td >
							<%-- <%if(!info.get("yg").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("CFZNDJID") %>"><%=info.get("yg") %></a>
							<%}else{out.write(info.get("yg").toString());}%> --%>
							<%=info.get("yg") %>
							</td>
							<td >
							<%-- <%if(!info.get("gk").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("CFZWDJID") %>"><%=info.get("gk") %></a>
							<%}else{out.write(info.get("gk").toString());}%> --%>
							<%=info.get("gk") %>
							</td> 
							<td >
							<%-- <%if(!info.get("hs").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("hs") %></a>
							<%}else{out.write(info.get("hs").toString());}%> --%>
							<%=info.get("hs") %>
							</td>
							<td >
							<%-- <%if(!info.get("hd").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("hd") %></a>
							<%}else{out.write(info.get("hd").toString());}%> --%>
							<%=info.get("hd") %>
							</td>
							<td >
							<%-- <%if(!info.get("zj").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("zj") %></a>
							<%}else{out.write(info.get("zj").toString());}%> --%>
							<%=info.get("zj") %>
							</td>
							<td >
							<%-- <%if(!info.get("zb").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("zb") %></a>
							<%}else{out.write(info.get("zb").toString());}%> --%>
							<%=info.get("zb") %>
							</td>
							<td >
							<%-- <%if(!info.get("gg").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("gg") %></a>
							<%}else{out.write(info.get("gg").toString());}%> --%>
							<%=info.get("gg") %>
							</td>
							<td >
							<%-- <%if(!info.get("gg").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("gg") %></a>
							<%}else{out.write(info.get("gg").toString());}%> --%>
							<%=Integer.parseInt(info.get("gl").toString()) + Integer.parseInt(info.get("yg").toString())+Integer.parseInt(info.get("gk").toString())
							+Integer.parseInt(info.get("hs").toString())+Integer.parseInt(info.get("hd").toString())+Integer.parseInt(info.get("zj").toString())
							+Integer.parseInt(info.get("zb").toString())+Integer.parseInt(info.get("gg").toString())%>
							</td>
							
						</tr>
						<%}else{%>
							<tr class="altrow"  data-tt-id="<%=info.get("areaNo") %>" <%if(info.get("parentNo") != "")
											{%>data-tt-parent-id="<%=info.get("parentNo") %>"<%}%>>
							<td ><%=info.get("areaName") %></td>
							<td >
							<%-- <%if(!info.get("gl").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("SBSLDJID") %>"><%=info.get("gl") %></a>
							<%}else{out.write(info.get("gl").toString());}%> --%>
							<%=info.get("gl") %>
							</td>
							<td >
							<%-- <%if(!info.get("yg").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("CFZNDJID") %>"><%=info.get("yg") %></a>
							<%}else{out.write(info.get("yg").toString());}%> --%>
							<%=info.get("yg") %>
							</td>
							<td >
							<%-- <%if(!info.get("gk").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("CFZWDJID") %>"><%=info.get("gk") %></a>
							<%}else{out.write(info.get("gk").toString());}%> --%>
							<%=info.get("gk") %>
							</td> 
							<td >
							<%-- <%if(!info.get("hs").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("hs") %></a>
							<%}else{out.write(info.get("hs").toString());}%> --%>
							<%=info.get("hs") %>
							</td>
							<td >
							<%-- <%if(!info.get("hd").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("hd") %></a>
							<%}else{out.write(info.get("hd").toString());}%> --%>
							<%=info.get("hd") %>
							</td>
							<td >
							<%-- <%if(!info.get("zj").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("zj") %></a>
							<%}else{out.write(info.get("zj").toString());}%> --%>
							<%=info.get("zj") %>
							</td>
							<td >
							<%-- <%if(!info.get("zb").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("zb") %></a>
							<%}else{out.write(info.get("zb").toString());}%> --%>
							<%=info.get("zb") %>
							</td>
							<td >
							<%-- <%if(!info.get("gg").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("gg") %></a>
							<%}else{out.write(info.get("gg").toString());}%> --%>
							<%=info.get("gg") %>
							</td>
							<td >
							<%-- <%if(!info.get("gg").toString().equals("0")){ %>
							<a href="${pageContext.request.contextPath}/sys/jttWssbtjsx!showDetail.do?djid=<%=info.get("TZNDJID") %>"><%=info.get("gg") %></a>
							<%}else{out.write(info.get("gg").toString());}%> --%>
							<%=Integer.parseInt(info.get("gl").toString()) + Integer.parseInt(info.get("yg").toString())+Integer.parseInt(info.get("gk").toString())
							+Integer.parseInt(info.get("hs").toString())+Integer.parseInt(info.get("hd").toString())+Integer.parseInt(info.get("zj").toString())
							+Integer.parseInt(info.get("zb").toString())+Integer.parseInt(info.get("gg").toString())%>
							</td>
						</tr>
						<%}%>
						<%}%>
						</tbody>
				 </table>
		</div>
</div>
</div>
</body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/jquery.treetable.css" id="css4"/>
<script language="JavaScript"
	src="<%=request.getContextPath() %>/scripts/jquery/jquery.treetable/treetable2/jquery.treetable.js" type="text/JavaScript"></script>
	<script language="JavaScript"
	src="<%=request.getContextPath() %>/scripts/jquery/jquery.treetable/treetable2/jquery.chosen.min.js" type="text/JavaScript"></script>
<script language="JavaScript"
	src="<%=request.getContextPath() %>/scripts/jquery/jquery.treetable/tree.js" type="text/JavaScript"></script>
	<script type="text/javascript">
	function showError(xzjg){
		var iWidth=600; //弹出窗口的宽度;
		var iHeight=400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		window.open("","newWin","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no");
		$("#decisionBeginTimeerror").val("2010-01-01");
		$("#decisionEndTimeerror").val("2017-07-31");
		$("#xzjg").val("");
		$("#dataError").submit();
	}
	function exportExcel(){
		window.location.href = '${pageContext.request.contextPath}/sys/exportLegarerror.do?startTime='+$("#decisionBeginTime").val()+"&endTime="+$("#decisionEndTime").val();
	}
	function openXK(){
		var iWidth=600; //弹出窗口的宽度;
		var iHeight=400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		 window.open('${ctx}/jtt2xyb/permit_TakeIn.jsp',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no"); 
	}
	function openCF(){
		var iWidth=600; //弹出窗口的宽度;
		var iHeight=400; //弹出窗口的高度;
		var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
		 window.open('${ctx}/jtt2xyb/punish_TakeIn.jsp',"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+", location=no"); 
	}
</script>
</html>
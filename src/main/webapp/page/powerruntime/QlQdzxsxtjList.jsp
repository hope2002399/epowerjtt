﻿<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<sj:head locale="zh_CN" />
<title><s:text name="权利列表" /></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css" id="css1">
<style type="text/css">
a{ text-decoration: none;}
</style>
<script
	src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"
	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/css/jquery.pagination.css" id="css2"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/list.css" type="text/css" id="css3"/>
<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/js/jquery.pagination.min.js"></script>
</head>
<body>
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
		<div class="crumbs">权力清单</div>
			<form action="。/powerruntime/qlQdzxtj!qlqdzx.do" method="get" >
			<%-- <span class="addTd">
				 <label>开始时间：</label>
				 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="beginTime" 
				 value="${beginTime }" name="s_beginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
			</span>
			<span class="addTd">
				 <label>结束时间：</label>
				 <input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="endTime" 
				 value="${endTime }" name="s_endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
			</span> --%>
			<div class="addbutton">
				<!-- <input type="submit"  class="btn" value="查询"> -->
				<input type="button" style=" margin-right: -150%;" class="btn" value="导出" onclick="return exportExcel()">
			</div>
		</form> 
	</div>
<div>
<div>

	<tr>
		<td valign="top">
			<table width="100%" border="0" cellpadding="0"
				cellspacing="0">
					<tr>
				<td valign="top">
					<div align="center" style=" top: -14px; position: relative;">
					<table width="100%" border="0" cellpadding="0" id="treeTable" class="tableRegion" cellspacing="0" class="zn2">
						<thead align="center">
							<tr>
								<td width="30%" class="tableHeader" >部门</td>
								<td  class="tableHeader" >行政许可</td>
								<td  class="tableHeader" >行政处罚</td>
								<td  class="tableHeader" >行政强制</td>
								<td  class="tableHeader" >行政征收</td>
								<td  class="tableHeader" >行政给付</td>
								<td  class="tableHeader" >行政奖励</td>
								<td  class="tableHeader" >行政确认</td>
								<td  class="tableHeader" >行政裁决</td>
								<td  class="tableHeader" >行政征用</td>
								<td  class="tableHeader" >其它</td>
							</tr>
						</thead>
						<tbody align="center" class="tableBody" id="tabledy">
							<c:forEach var="dqi" items="${qlQdtjs }" varStatus="status">
							<c:if test="${empty dqi.pjtcode}">
								<tr data-tt-id="${dqi.jtcode }"  class="odd" height="36px;">
							</c:if>
							<c:if test="${!(empty dqi.pjtcode)}">
								<tr data-tt-id="${dqi.jtcode }" data-tt-parent-id="${dqi.pjtcode }" class="odd" height="25px;">
							</c:if>
							<c:if test="${flag == null && (empty dqi.pjtcode)}">
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.orgname }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzxk }</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzcf }</td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzqz }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzzs }</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzjf }</td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzjl }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzqr }</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzcj }</td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzzy }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.qt }</td>
							</c:if>
							<c:if test="${flag == null && !(empty dqi.pjtcode)}">
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/qlQdzxtj!qlqdzx.do?jtcode=${dqi.jtcode }&flag=1" onmouseover="this.style.cursor='hand'">${dqi.orgname }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzxk&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzxk }</a></td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzcf&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzcf }</a></td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzqz&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzqz }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzzs&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzzs }</a></td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzjf&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzjf }</a></td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzjl&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzjl }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzqr&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzqr }</a></td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzcj&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzcj }</a></td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzzy&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzzy }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=qt&orgcode=${dqi.jtcode }&flag=${flag} " onmouseover="this.style.cursor='hand'">${dqi.qt }</a></td>
							</c:if>
							<c:if test="${flag != null && !(empty dqi.pjtcode)}">
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.orgname }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzxk&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzxk }</a></td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzcf&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzcf }</a></td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzqz&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzqz }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzzs&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzzs }</a></td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzjf&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzjf }</a></td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzjl&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzjl }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzqr&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzqr }</a></td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzcj&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzcj }</a></td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=xzzy&orgcode=${dqi.jtcode }&flag=${flag}" onmouseover="this.style.cursor='hand'">${dqi.xzzy }</a></td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted"><a href="../powerruntime/deptStInf!qlml.do?area=${status.index }&type=qt&orgcode=${dqi.jtcode }&flag=${flag} " onmouseover="this.style.cursor='hand'">${dqi.qt }</a></td>
							</c:if>
							<c:if test="${flag != null  && (empty dqi.pjtcode)}">
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.orgname }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzxk }</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzcf }</td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzqz }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzzs }</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzjf }</td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzjl }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzqr }</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzcj }</td>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.xzzy }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.qt }</td>
							</c:if>
							</tr>
							</c:forEach>
						</tbody>
				 </table>
				</div>
				</td>
			</tr>
			</table>
		</td>
	</tr>
</body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/jquery.treetable.css" id="css4"/>
<script language="JavaScript"
	src="<%=request.getContextPath() %>/scripts/jquery/jquery.treetable/treetable2/jquery.treetable.js" type="text/JavaScript"></script>
	<script language="JavaScript"
	src="<%=request.getContextPath() %>/scripts/jquery/jquery.treetable/treetable2/jquery.chosen.min.js" type="text/JavaScript"></script>
<script language="JavaScript"
	src="<%=request.getContextPath() %>/scripts/jquery/jquery.treetable/tree.js" type="text/JavaScript"></script>
	<script type="text/javascript">
	function exportExcel(){
		var beginTime = document.getElementById("beginTime").value;
		var endTime = document.getElementById("endTime").value;
		window.location.href = '${pageContext.request.contextPath}/powerruntime/qlQdzxtj!export.do?beginTime='+beginTime+'&endTime='+endTime+"&area=${status.index }&type=xzcf&orgcode=${dqi.jtcode }&flag=${flag}";
	}
	</script>
</html>
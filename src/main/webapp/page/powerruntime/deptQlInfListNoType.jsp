<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="权利列表" /></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css" id="css1">
<script
	src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/css/jquery.pagination.css" id="css2"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/list.css" type="text/css" id="css3"/>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/js/jquery.pagination.min.js"></script>
<script type="text/javascript">
		  function resetForm(){
			  $('#s_qlRegNo').val('');
			  $('#s_qlNmame').val('');
		  }
		</script>
</head>
<%-- <body>
	<div class="search">
		<div class="crumbs">权力列表</div>
		<fieldset>
			<s:form action="deptStInf" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="addTd">权力编码:</td>
						<td width="250"><s:textfield name="s_qlRegNo" value="%{#parameters['s_qlRegNo']}"/> </td>
						<td class="addTd">权力名称:</td>
						<td><s:textfield name="s_qlNmame" value="%{#parameters['s_qlNmame']}"/> </td>
						<td colspan="1">
							<s:submit method="qlml"  key="opt.btn.query" cssClass="btn"/>
						</td>
					</tr>	
				</table>
			</s:form> --%>
			
<body>
		<div class="search">
		<div class="crumbs">权力列表</div>
		<s:form action="deptStInf" namespace="/powerruntime">
			<table cellpadding="0" cellspacing="0" align="left">
				<input type="hidden" value="${orgcode }" name="orgcode"/>
				<input type="hidden" value="${type }" name="type"/>
				<input type="hidden" value="${area }" name="area"/>
				<input type="hidden" value="${flag }" name="flag"/>
				<tr>
				<td class="addTd">权力编码:</td>
				<td><s:textfield id="s_qlRegNo" name="s_qlRegNo"
							value="%{#parameters['s_qlRegNo']}" /></td>
				<td class="addTd">权力名称:</td>
				<td><s:textfield id="s_qlNmame" name="s_qlNmame" value="%{#parameters['s_qlNmame']}" /> </td>
				<td width="160" align="center"><s:submit method="qlml" key="opt.btn.query"
							cssClass="btn" /><input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/></td>
				</tr>
			</table>
		</s:form>			


		</fieldset>
	</div>
	<tr>
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
								<td width="15%" class="tableHeader" >权力编码</td>
								<td width="40%" class="tableHeader" >权力名称</td>
								<td width="20%" class="tableHeader" >实施主体</td>
							</tr>
						</thead>
						<tbody align="center" class="tableBody" id="tabledy">
							<c:forEach var="dqi" items="${deptQlInfs }" varStatus="status">
							<c:if test="${empty dqi.deptQlParentId}">
								<tr data-tt-id="${dqi.iddeptQlInf }"  class="odd" height="36px;">
							</c:if>
							<c:if test="${!(empty dqi.deptQlParentId)}">
								<tr data-tt-id="${dqi.iddeptQlInf }" data-tt-parent-id="${dqi.deptQlParentId }" class="odd" height="25px;">
							</c:if>
								<td id="tr1${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.qlRegNo }</td>
								<td id="tr2${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">
								<c:choose>
								<c:when test="${fn:length(dqi.qlName) > 20}">
										<c:if test="${not empty dqi.zxs && dqi.hiLevel == '1'}">
											${fn:substring(dqi.qlName, 0, 20)}...
										</c:if>
										<c:if test="${!(not empty dqi.zxs && dqi.hiLevel == '1')}">
											<a style="text-decoration:none;" onclick="return checkFzx('${dqi.iddeptQlInf }','${dqi.deptQlParentId }')" href='powerruntime/deptStInf!getQlAndyw.do?qlid=${dqi.iddeptQlInf }'><c:out value="${fn:substring(dqi.qlName, 0, 20)}..." /></a>
										</c:if>
								</c:when>
								<c:otherwise>
										<c:if test="${not empty dqi.zxs && dqi.hiLevel == '1'}">
											${dqi.qlName}
										</c:if>
										<c:if test="${!(not empty dqi.zxs && dqi.hiLevel == '1')}">
											<a style="text-decoration:none;" onclick="return checkFzx('${dqi.iddeptQlInf }','${dqi.deptQlParentId }')" href='powerruntime/deptStInf!getQlAndyw.do?qlid=${dqi.iddeptQlInf }'><c:out value="${dqi.qlName}" /></a>
										</c:if>
								</c:otherwise>
								</c:choose>
								</td>
								<td id="tr3${status.index }" nowrap="nowrap" style="border-bottom: #9d9d9d 1px dotted">${dqi.orgshortname }</td>
								</tr>
							</c:forEach>
						</tbody>
				 </table>
				</div>
				<div id="pagination3" style="position: relative;top: -5px;right: -34%;">
				<input hidden="hidden" id="rowno" value="${rowno }"/></div>
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
	var n=0;
	function checkFzx(val,parVal){
		var flag = '';
		if(parVal == ''){
			$.ajax({
				typ : "POST",
				url : "${pageContext.request.contextPath}/powerruntime/deptStInf!check.do?qlid="
					+ val,
				contentType : "text/html",
				dataType : "json",
				processData : false,
				async : false,
				success : function(data){
					if(data.flag == 'T'){
						flag = 'T';
					}else{
						flag = 'F';
					}
				}
			})
		}else{
			return true;
		}
		if(flag == 'T'){
			return true;
		}else{
			return false;
		}
	}
	function checkCss(id,i,n){
		for(var a = 0;a<n;a++){
			/* alert("i"+i);//当前第i个
			alert("n"+n); */
			var c = parseInt(i)+parseInt(n);
			for(var d = 1; d<c ; d++){
				var b = document.getElementById(d+id);
				var e = document.getElementById(id);
				/* alert("2") */
				if(b.style.display == 'none'){
					/* alert("3") */
					e.className="odd branch collapsed";
					b.style.display="table-row";
					$("#"+("a"+id)).attr("title","Collapse");
				}else{
					$("#"+("a"+id)).attr("title","Expand");
					e.className="odd branch expanded";
					b.style.display="none";
				}
				
			}
		}
	}
	
	var rowno = $("#rowno").val();
		$("#pagination3").pagination({
		   currentPage: 1,// 当前页数
		   totalPage: rowno,// 总页数
		   isShow: false,// 是否显示首尾页
		   endPageText: "尾页",// 尾页文本
		   count: 6,// 显示个数
		   homePageText: "首页",// 首页文本
		   prevPageText: "上一页",// 上一页文本
		   nextPageText: "下一页",// 下一页文本
		   callback: function(current) {
			   $
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/powerruntime/deptStInf!qlmlfy.do?currentPage="
							+ current,
					contentType : "text/html",
					dataType : "json",
					processData : false,
					async : false,
					success : function(data) {
						var tb = document.getElementById('tabledy');
						/* $("#tabledy").removeClass("tableBody");  */
					   var rowNum=tb.rows.length;
					     for (i=0;i<rowNum;i++)
					     {
					         tb.deleteRow(i);
					         rowNum=rowNum-1;
					         i=i-1;
					     }
						var s = "";
						for(var i=0;i<=data.deptQlInfs.length;i++){
							if(data.deptQlInfs[i] != undefined){
								if(i%2 ==0){
									if(data.deptQlInfs[i].deptQlParentId == ''||data.deptQlInfs[i].deptQlParentId==null){
										if(data.deptQlInfs[i].zxs == ''||data.deptQlInfs[i].deptQlParentId==null){
											s+="	<tr data-tt-id='"+data.deptQlInfs[i].iddeptQlInf+"'   class='odd leaf expanded' height='36px;' bg='#dfe4e8' style='background: rgb(223, 228, 232);'>";
											s+="	<td id='tr1"+i+"' nowrap='nowrap' style='border-bottom: 1px dotted rgb(157, 157, 157); text-align: left;'><span class='indenter' style='margin-left: 0px;'></span>"+data.deptQlInfs[i].qlRegNo+"</td>";
											if(data.deptQlInfs[i].qlName.length>20){
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName.substring(0,20)+"...</a></td>";
											}else{
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName+"</a></td>";
											}
										}else{
											s+="	<tr data-tt-id='"+data.deptQlInfs[i].iddeptQlInf+"'  class='odd branch expanded' height='36px;' bg='#dfe4e8' style='background: rgb(223, 228, 232);'>";
											s+="	<td id='tr1"+i+"' nowrap='nowrap' style='border-bottom: 1px dotted rgb(157, 157, 157); text-align: left;'><span class='indenter' style='margin-left: 0px;'><a id=a"+data.deptQlInfs[i].iddeptQlInf+"' href=\"javascript:void(0)\"  onclick=\"checkCss('"+data.deptQlInfs[i].iddeptQlInf+"','"+i+"','"+data.deptQlInfs[i].zxs+"')\" title='collapse'>&nbsp;</a></span>"+data.deptQlInfs[i].qlRegNo+"</td>";
											if(data.deptQlInfs[i].qlName.length>20){
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'>"+data.deptQlInfs[i].qlName.substring(0,20)+"...</td>";
											}else{
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'>"+data.deptQlInfs[i].qlName+"</td>";
											}
										}
									}else{
										n=parseInt(n)+1;
										s+="	<tr id='"+i+data.deptQlInfs[i].deptQlParentId+"' data-tt-id='"+data.deptQlInfs[i].iddeptQlInf+"' data-tt-parent-id='"+data.deptQlInfs[i].deptQlParentId+"' class='odd leaf expanded' height='25px;' bg='#dfe4e8' style='display: table-row; background: rgb(223, 228, 232);'>";
										s+="	<td id='tr1"+i+"' nowrap='nowrap' style='border-bottom: 1px dotted rgb(157, 157, 157); text-align: left;'><span class='indenter' style='margin-left: 19px;'></span>"+data.deptQlInfs[i].qlRegNo+"</td>";
										if(data.deptQlInfs[i].qlName.length>20){
												s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName.substring(0,20)+"...</a></td>";
										}else{
												s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName+"</a></td>";
										}
									}
									s+="	<td id='tr3"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'>"+data.deptQlInfs[i].orgshortname+"</td></tr>";
								}else{
									if(data.deptQlInfs[i].deptQlParentId == ''||data.deptQlInfs[i].deptQlParentId==null){
										if(data.deptQlInfs[i].zxs == ''||data.deptQlInfs[i].deptQlParentId==null){
											s+="	<tr data-tt-id='"+data.deptQlInfs[i].iddeptQlInf+"'   class='odd leaf expanded' height='36px;' bg='#dfe4e8' style='background: rgb(255, 255, 255);'>";
											s+="	<td id='tr1"+i+"' nowrap='nowrap' style='border-bottom: 1px dotted rgb(157, 157, 157); text-align: left;'><span class='indenter' style='margin-left: 0px;'></span>"+data.deptQlInfs[i].qlRegNo+"</td>";
											if(data.deptQlInfs[i].qlName.length>20){
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName.substring(0,20)+"...</a></td>";
											}else{
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName+"</a></td>";
											}
										}else{
											s+="	<tr data-tt-id='"+data.deptQlInfs[i].iddeptQlInf+"'  class='odd branch expanded' height='36px;' bg='#dfe4e8' style='background: rgb(255, 255, 255);'>";
											s+="	<td id='tr1"+i+"' nowrap='nowrap' style='border-bottom: 1px dotted rgb(157, 157, 157); text-align: left;'><span class='indenter' style='margin-left: 0px;'><a id=a"+data.deptQlInfs[i].iddeptQlInf+"' href=\"javascript:void(0)\"  onclick=\"checkCss('"+data.deptQlInfs[i].iddeptQlInf+"','"+i+"','"+data.deptQlInfs[i].zxs+"')\" title='collapse'>&nbsp;</a></span>"+data.deptQlInfs[i].qlRegNo+"</td>";
											if(data.deptQlInfs[i].qlName.length>20){
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'>"+data.deptQlInfs[i].qlName.substring(0,20)+"<span>...</span></td>";
											}else{
													s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'>"+data.deptQlInfs[i].qlName+"</td>";
											}
										}
									}else{
										n=parseInt(n)+1;
										s+="	<tr  id='"+i+data.deptQlInfs[i].deptQlParentId+"' data-tt-id='"+data.deptQlInfs[i].iddeptQlInf+"' data-tt-parent-id='"+data.deptQlInfs[i].deptQlParentId+"' class='odd leaf expanded' height='25px;' bg='#dfe4e8' style='display: table-row; background: rgb(255, 255, 255);'>";
										s+="	<td id='tr1"+i+"' nowrap='nowrap' style='border-bottom: 1px dotted rgb(157, 157, 157); text-align: left;'><span class='indenter' style='margin-left: 19px;'></span>"+data.deptQlInfs[i].qlRegNo+"</td>";
										if(data.deptQlInfs[i].qlName.length>20){
												s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName.substring(0,20)+"...</a></td>";
										}else{
												s+="	<td id='tr2"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'><a  style='text-decoration:none;'  href='powerruntime/deptStInf!getQlAndyw.do?qlid="+data.deptQlInfs[i].iddeptQlInf+"'>"+data.deptQlInfs[i].qlName+"</a></td>";
										}
									}
									s+="	<td id='tr3"+i+"' nowrap='nowrap' style='border-bottom: #9d9d9d 1px dotted'>"+data.deptQlInfs[i].orgshortname+"</td></tr>";
								}
							}
					   };
					   $("#tabledy").append(s); 
					}
				});
		   }
		});
	</script>
</html>
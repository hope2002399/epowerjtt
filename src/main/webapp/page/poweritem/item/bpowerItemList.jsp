<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<%@taglib uri="/WEB-INF/pageTag.tld" prefix="pageTag"%>

<html>
	<head>
		<title>
			行政权力实施事项列表
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_orgId').val('');
			  $('#s_itemType').val('');
			  $('#s_itemId').val('');
			  $('#s_itemName').val('');
			  $('#s_itemStatus').val('');
		  }
		</script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css" rel="stylesheet" type="text/css" />
	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/stylesheets/jquery.treetable.css" />
	
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 查询条件
			</div>
			
			<s:form action="bpowerItem" namespace="/poweritem" style="margin-top:0;margin-bottom:5">
			<input type="hidden" name="offset" id="offset">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="addTd">事项编号：</td>
						<td><s:textfield name="s_itemId" id="s_itemId" style="width:180px" value="%{#parameters['s_itemId']}"></s:textfield></td>
						<td class="addTd">事项名称：</td>
						<td><s:textfield name="s_itemName" id="s_itemName" style="width:180px" value="%{#parameters['s_itemName']}"/> </td>
					</tr>	
				<tr>
					<td class="addTd">所属部门：</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}" style="width: 180px"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					</td>
				
					<td class="addTd">权力类型：</td>
					<td>
							<select name="s_itemType" id="itemType" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE_NEW')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_itemType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					</tr>
					<tr>
					<td class="addTd">状态：</td>
						<td><select name="s_itemStatus" id="itemStatus" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_STATUS_NEW')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_itemStatus[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td colspan="2">&nbsp;&nbsp;
							<s:submit method="listBpowerItem"  key="opt.btn.query" cssClass="btn"/>
							<s:submit method="addBpowerItem"  key="opt.btn.new" cssClass="btn"/>
							<input type="button" value="重置" class="btn" onclick="resetForm()"/>	
						</td>
					</tr>
				</table>
			</s:form>
		</div>



	<div class="eXtremeTable">
	
		<table class="tableRegion"
			style="width: 100%; border-left: 1px solid #CACACA; border-bottom: 1px solid #CACACA; margin-top: 10px;"
			id="treeTable" cellpadding="0" border="0" cellspacing="0">


			<thead align="center">
				<tr>
					<td class="tableHeader">事项编码</td>
					<td class="tableHeader">事项名称</td>
					<td class="tableHeader">所属部门</td>
					<td class="tableHeader">事项类型</td>
					<td class="tableHeader">事项状态</td>
					<td class="tableHeader">操作</td>
				</tr>
			</thead>

			<tbody align="center" class="tableBody">
				<c:forEach var="line" items="${bpowerItemlist }"
					varStatus="trStatus">

					<%-- 父节点为空 --%>
					<c:if test="${empty line.parentId }">
						<tr data-tt-id="${line.itemId  }" class="odd">
					</c:if>

					<%-- 父节点不为空 --%>
					<c:if test="${not empty line.parentId }">
						<tr data-tt-id="${line.itemId }" data-tt-parent-id="${line.parentId }"
							class="odd">
					</c:if>
					<td>${line.itemId }</td>
					<td><a
						href="<%=request.getContextPath()%>/poweritem/bpowerItem!viewBpowerItem.do?itemId=${line.itemId}">

							<c:choose>
								<c:when test="${fn:length(line.itemName) > 20}">
									<c:out value="${fn:substring(line.itemName, 0, 20)}..." />
								</c:when>
								<c:otherwise>
									<c:out value="${line.itemName}" />
								</c:otherwise>
							</c:choose>
					</a></td>
					<td>${cp:MAPVALUE("depno",line.orgId)}</td>
					<td>${cp:MAPVALUE("ITEM_TYPE_NEW",line.itemType)}</td>
					<td>${cp:MAPVALUE("ITEM_STATUS_NEW",line.itemStatus)}</td>
					<td><c:if test="${line.itemStatus ne '4' }">
							<c:if test="${empty line.itemQldyItemId  }">
							<c:if
								test="${(!empty line.isContainSub and line.isContainSub eq '1')}">
								<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!addBpowerItem.do?type=cfzx&itemId=${line.itemId}'>添加子项</a>
							</c:if>
							<c:if test="${(!empty line.isContainSub and line.isContainSub eq '2') or (empty line.isContainSub)}">
								<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!addBpowerItemQldy.do?type=listitem&itemSubId=${line.itemId}'>添加业务项</a>
								<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!listBpowerItemQldy.do?itemSubId=${line.itemId}'>业务项列表</a>
							</c:if>
							</c:if>
							<a
								href='<%=request.getContextPath()%>/poweritem/bpowerItem!editBpowerItem.do?itemId=${line.itemId}'>修改</a>
							<a
								href='<%=request.getContextPath()%>/poweritem/bpowerItem!deleteBpowerItem.do?itemId=${line.itemId}'>删除</a>
						</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<%@include file="/page/poweritem/tree-scripts.jsp"%>
	</div>
	<div style="text-align: center; margin-top: 20px;">
					<table border=0 align="center" cellPadding=0 cellSpacing=0
						style="margin-top: 4px">
						<tr>
						<%-- <td>${pageargs }</td> --%>
							<td align="center" style="FONT-SIZE: 14px;"><pageTag:page
									page="${page}"
									action="${ctx }/poweritem/bpowerItem!listBpowerItem.do" onclickmethod="flip"/>
							</td>
						</tr>
					</table>
				</div>
			

	</body>
	<script type="text/javascript">
	/**
	 * common window dialogs这是弹出窗口的实现代码
	 */
	function openNewWindow(winUrl,winName,winProps){
		if(winProps =='' || winProps == null){
			winProps = 'height=400px,width=400px,directories=false,z-look=true,alwaysRaised=true,location=false,top=100,left=500,menubar=false,Resizable=no,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
	 var menuList = ${unitsJson};
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			var key = $this.attr("rel");
			for (var i=0; i<menuList.length; i++) {
				if (key == menuList[i].MID) {
					o2.val(menuList[i].depno);
				}
			}
			if(getID("shadow")){
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}
$("#orgName").bind('click',function(){
	var menuList = ${unitsJson};
	var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
	if(getID("shadow")){
		$("#shadow").show();
		$("#boxContent").show();
	}else{
		$("body").append(shadow);
		$("#shadow").height(document.body.scrollHeight);
		setTimeout(function(){
			menuDisplay(menuList,"${parentunit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#s_orgId"),$this);
		$("#lists span").die("click");
	});
});
//翻页函数
function flip(offset){
	$("#offset").val(offset);
	$("#bpowerItem_opt_btn_query").click();
}
	</script>
</html>

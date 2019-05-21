<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>备案列表</title>
<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_ownerDepID').val('');
			  $('#s_fileName').val('');
			  $('#s_depFileNo').val('');
			  $('#s_beginDate').val('');
			  $('#s_allFIleNo').val('');
			  $('#s_endDate').val('');
		  }
		</script>
		<sj:head locale="zh_CN" />
   		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	
</head>

<body>
<div class="search">
			<div class="crumbs">
				 <s:text name="label.list.filter" />
			</div>

		<s:form action="recordFileBasic" namespace="/powerbase"
			style="margin-top:0;margin-bottom:5" method="post">
			<table cellpadding="0" cellspacing="0"  align="center">
			<tr>
					<td width="20%" align="right">文件名称：</td>
					<td width="250"><s:textfield name="s_fileName" id="s_fileName"  value="%{#parameters['s_fileName']}"/>
					<s:hidden  name="s_finishStatus" id="s_finishStatus" value="%{#parameters['s_finishStatus']}"></s:hidden></td>
					<td align="right" width="100px">主办机关文号：</td>
					<td><s:textfield name="s_depFileNo" id="s_depFileNo" value="%{#parameters['s_depFileNo']}"/></td>
			</tr>
			<tr>
					<td align="right">统一编排文号：</td>
					<td width="250"><s:textfield name="s_allFIleNo" id="s_allFIleNo" 
							value="%{#parameters['s_allFIleNo']}" /></td>
					 <td align="right" width="100px">主办机关：</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_ownerDepID)}"/>
					<input type="hidden" id="s_ownerDepID" name="s_ownerDepID" value="${param.s_ownerDepID}"/>
					</td>
			</tr>
			<tr>
						 <td align="right">登记时间范围：</td>
						<td colspan="3">
							<sj:datepicker name="s_beginDate" id="s_beginDate" readonly="true" value="%{#parameters['s_beginDate']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
							至
							<sj:datepicker name="s_endDate" id="s_endDate" readonly="true" value="%{#parameters['s_endDate']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						&nbsp;&nbsp;
						<s:submit method="list" key="opt.btn.query" cssClass="btn" />
						<input type="button" value="重置" Class="btn" onclick="resetForm()"/>
						<s:submit method="editInitial" key="opt.btn.new" cssClass="btn" />
					</td>
			</tr>
			</table>
		</s:form>
	</div>
	
	<ec:table action="powerbase/recordFileBasic!list.do" items="vrecordList"
		var="record"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit" >
		<ec:row>
			<ec:column property="recordCode" title="备案编号" style="text-align:center" >
			<a href='powerbase/recordFileBasic!view.do?recordCode=${record.recordCode}&backurl=${backurl}'>${record.recordCode }</a>
			</ec:column>

			<ec:column property="fileName" title="规范性文件名称" style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(record.fileName) > 30}">
						<c:out value="${fn:substring(record.fileName, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${record.fileName}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			
			<ec:column property="depFileNo" title="主办机关文号" style="text-align:center" />
			<ec:column property="allFIleNo" title="统一编排文号" style="text-align:center" />
			<ec:column property="ownerDepID" title="主办机关" style="text-align:center">
					${cp:MAPVALUE("depno",record.ownerDepID)}
				</ec:column>
			<ec:column property="bookDate" title="登记时间" style="text-align:center" sortable="false" >
				<fmt:formatDate value="${record.bookDate}" pattern="yyyy-MM-dd"/>
				</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<a
					href='powerbase/recordFileBasic!view.do?recordCode=${record.recordCode}&backurl=${backurl}'><s:text
						name="opt.btn.view" /></a>
				<a
					href='powerbase/recordFileBasic!edit.do?recordCode=${record.recordCode}&backurl=${backurl}'>编辑</a> 
					<a
						href='powerbase/recordFileBasic!upstuff.do?recordCode=${record.recordCode}&upshow=1&backurl=${backurl}'>上传资料</a>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
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
			menuDisplay(menuList,"${parentUnit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#s_ownerDepID"),$this);
		$("#lists span").die("click");
	});
});

</script>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
<head><meta name="decorator" content='${LAYOUT}'/>
<sj:head locale="zh_CN" />
<title>全文检索 by lucene</title>
<script type="text/javascript"
	src="<c:url value='/scripts/datepicker/WdatePicker.js'/>"></script>

<script type="text/javascript">
	function onFormSubmit(theForm) {
		if (document.all.query.value == "") {
			alert("请输入检索内容，关键词用空格隔开。");
			document.all.file.focus();
			return;
		}
		document.all.btn_search.value = "搜索中，请稍等...";
		document.all.btn_search.disabled = "true";
		document.getElementById('method').value = 'search';
		theForm.submit();
	}
	function uploadfile() {
		var filecode = window
				.showModalDialog(
						"<c:url value='/app/fileinfo!uploadindialog.do?index=1' />",
						"上传文件");
		//alert(filecode);
		window.location.reload();//.location.reload();
	}
	function ajaxchange() {
		if ($("#bn").attr("value") == "高级") {
			$("#ajaxtable").show();
			$("#bn").attr("value", "简洁");
		} else {
			$("#ajaxtable").hide();
			$("#bn").attr("value", "高级");
		}
	}
</script>
</head>
<base target="_self" />
<body>

<%@ include file="/page/common/messages.jsp"%>
<fieldset>
		<legend>全文检索</legend>
<s:form action="searcher" namespace="/app"
	enctype="multipart/form-data">

	<table border="0" cellpadding="1" cellspacing="1">
		<tr>
			<td width="200">请输入检索内容，关键词用空格隔开</td>
			<td align="left"><s:textfield name="keyWord" maxlength="80"
				size="60" /></td>
		</tr>
	</table>
	<div id="ajaxtable" style="display: none">
	<table border="0" cellpadding="1" cellspacing="1">

		<tr>
			<td align="left">时间范围：&nbsp;&nbsp;<sj:datepicker id="beginTime"
				name="beginTime" yearRange="2000:2020" displayFormat="yy-mm-dd"
				changeYear="true" />至<sj:datepicker id="endTime" name="endTime"
				yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /></td>
		</tr>
		<tr>
			<td align="left">文件类别：&nbsp;&nbsp;<s:checkboxlist name="typeList"
				list="{'txt','doc','docx','xls','xlsx','ppt','pplx','vsd','rtf','html'}"></s:checkboxlist>
			</td>
		</tr>
		<tr>
			<td align="left">业务类别：&nbsp;&nbsp;<s:checkboxlist name="optList"
				list="{'mail','file'}"></s:checkboxlist></td>
		</tr>
	</table>
	</div>
	<table border="0" cellpadding="1" cellspacing="1">
		<tr>
			<td width="200"><input type="checkbox"
				name="owner" value="yes" /> 仅检索属于自己的文档</td>
			<td><s:submit method="search" value="检索"
				cssClass="btn" /> <input type="button" id="bn" value="高级"
				class="btn" onclick="ajaxchange()" /> <input type="button" style="width:100;"
				onclick="uploadfile()"  value="上传并索引文件" class="btn"/></td>
		</tr>
	</table>

</s:form>
</fieldset>
<div class="eXtremeTable"><c:if test="${docsum gt 0}">
	<table id="t_doclist" border="0" cellspacing="0" cellpadding="0"
		class="tableRegion" width="100%">
		<thead>
			<tr>
				<td class="tableHeader">共检索到 <c:out value="${docsum}" /> 条结果</td>
			</tr>
		</thead>
		<tbody class="tableBody">
			<c:set value="odd" var="rownum" />
			<c:forEach var="doc" items="${doclist}">
				<tr class="${rownum}" onmouseover="this.className='highlight'"
					onmouseout="this.className='${rownum}'">
					<td><c:out value='${doc.summary}' /> <a
						href='<c:url value="${doc.url}" />'>查看详情</a></td>
				</tr>
				<c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
			</c:forEach>
		</tbody>
	</table>
</c:if> <c:if test="${docsum == 0}">
	<p class="CTITLE" align="center">根据条件没有检索到文件</p>
</c:if> 
</div>


</body>
</html>

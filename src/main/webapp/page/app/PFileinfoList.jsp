<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
	<sj:head locale="zh_CN" />
		<title>
			格式文书案号管理
		</title>
	</head>
<base target="_self" />
	<body>

<fieldset><legend>查询条件 </legend> <s:form action="fileinfo.do" namespace="/app" theme="simple">
	<table cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td width="120"><s:label key="fileinfo.filecode"/>:</td>
			<td><s:textfield name="s_filecode" value="%{#parameters['s_filecode']}"/></td>
		<!-- </tr>
		<tr> -->
			<td><s:label key="fileinfo.recorder"/>:</td>
			<td><s:textfield name="s_recorder" value="%{#parameters['s_recorder']}"/></td>
		</tr>
		<tr>
			<td><s:label key="fileinfo.fileextname"/>:</td>
			<td><s:textfield name="s_fileextname" value="%{#parameters['s_fileextname']}"/></td>
		<!-- </tr>
		<tr> -->
			<td><s:label key="fileinfo.optcode"/>:</td>
			<td><s:textfield name="s_optcode" value="%{#parameters['s_optcode']}"/></td>
		</tr>
		<tr>
			<td><s:label key="fileinfo.filedesc"/>:</td>
			<td><s:textfield name="s_filedesc" value="%{#parameters['s_filedesc']}"/></td>
		<!-- </tr>
		<tr> -->
			<td><s:label key="fileinfo.recorddate"/>:</td>
			<td><sj:datepicker name="s_recorddate" id="s_recorddate" readonly="true" value="%{#parameters['s_recorddate']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
		</tr>
		<tr>
			<td><s:label key="fileinfo.filetype"/>:</td>
			<td><s:textfield name="s_filetype" value="%{#parameters['s_filetype']}"/></td>
		<!-- </tr>
		<tr> -->
			<td><s:label key="fileinfo.filename"/>:</td>
			<td><s:textfield name="s_filename" value="%{#parameters['s_filename']}"/></td>
		</tr>
		<tr height="36">
			<td></td>
			<td><s:submit method="list" cssClass="btn" value="查询">
			</s:submit><s:submit method="built" target="navTab" cssClass="btn" value="新增"></s:submit>
			<a href="<s:url value='/page/app/uploadfiledialog.jsp'/>" target="dialog" width="550" height="350">在对话框中上传文件（不会被索引）</a>
		</tr>
	</table>
</s:form></fieldset>

<ec:table action="fileinfo!list.do" items="objList" var="fileinfo"
	imagePath="${STYLE_PATH}/images/table/*.gif"
	retrieveRowsCallback="limit">
	<ec:row>
		<%-- <ec:column property="fileCode" title="fileinfo.filecode"
			style="text-align:center" />
		<ec:column property="recorder" title="fileinfo.recorder"
			style="text-align:center" />
		<ec:column property="fileExtName" title="fileinfo.fileextname"
			style="text-align:center" />
		<ec:column property="optCode" title="fileinfo.optcode"
			style="text-align:center" />
		<ec:column property="fileDesc" title="fileinfo.filedesc"
			style="text-align:center" />
		<ec:column property="recordDate" title="fileinfo.recorddate"
			style="text-align:center" />
		<ec:column property="fileType" title="fileinfo.filetype"
			style="text-align:center" />
		<ec:column property="fileName" title="fileinfo.filename"
			style="text-align:center" /> --%>
			<ec:column property="fileCode" title="文件编号"
			style="text-align:center" />
		<ec:column property="recorder" title="更改人员"
			style="text-align:center" />
		<ec:column property="fileExtName" title="文件类别"
			style="text-align:center" />
		<ec:column property="optCode" title="操作编码"
			style="text-align:center" />
		<ec:column property="fileDesc" title="文件内容描述"
			style="text-align:center" />
		<ec:column property="recordDate" title="更改时间"
			style="text-align:center"  cell="date" format="yyyy-MM-dd hh:mm:ss"/>
		<ec:column property="fileType" title="文件业务类别"
			style="text-align:center" />
		<ec:column property="fileName" title="文件名"
			style="text-align:center" />

		<ec:column property="opt" title="操作" sortable="false"
			style="text-align:center">
			<a href='fileinfo!download.do?fileCode=${fileinfo.fileCode}'>下载文件</a>
			<a href='fileinfo!edit.do?fileCode=${fileinfo.fileCode}'>编辑</a>
			<a href='fileinfo!delete.do?fileCode=${fileinfo.fileCode}'
				onclick='return confirm("是否删除 ${fileinfo.fileCode}?");'>删除</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>
</html>


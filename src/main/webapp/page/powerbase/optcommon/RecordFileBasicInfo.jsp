<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@page import="com.centit.powerbase.po.RecordFileBasic"%>
<%@page import="com.centit.powerbase.po.RecordFileStuff"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>备案详尽信息</title>
<sj:head locale="zh_CN" />
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<input type="button" class="btn" value="返回"
		onclick="window.location.replace('${backurl}');" />
	<s:form action="recordFileBasic" namespace="/powerbase" method="post"  enctype="multipart/form-data" >
		<fieldset style="border: hidden 1px #000000; ">
		<legend class="ctitle" style="width:auto;">
				备案基本信息
			</legend>
			<s:hidden property="recordCode"></s:hidden>
			<table border="0" cellpadding="0" cellspacing="0" align="center" class="table_b">
				<tr>
					<td width="15%" class="table_b_th">制定部门名称</td>
					<td align="left" colspan="3"><s:property
							value='%{object.constituteId }' /> <s:hidden
							property="object.constituteDepName"></s:hidden></td>
				</tr>
				<tr>
					<td width="15%" class="table_b_th">规范性文件名称</td>
					<td align="left" colspan="3"><s:property value='%{object.fileName }' /></td>
				</tr>
				<tr>
					<td width="15%" class="table_b_th">主办机关</td>
					<td align="left" colspan="3">${cp:MAPVALUE("unitcode",object.ownerDepID)}</td>
				 </tr>
				<tr> 
					<td width="15%" class="table_b_th">主办机关文号</td>
					<td align="left" ><s:property value='%{object.depFileNo }' /></td>
				<!-- </tr>
				<tr> -->
					<td width="15%" class="table_b_th">统一编排文号</td>
					<td width="35%" align="left"><s:property value='%{object.allFIleNo }' /></td>
				</tr>
				<tr>
					<td width="15%" class="table_b_th">发布时间</td>
					<td align="left" ><fmt:formatDate
							value='${object.punishDate}' pattern='yyyy-MM-dd ' /></td>
				<!-- </tr>
				<tr> -->
					<td width="15%" class="table_b_th">施行时间</td>
					<td width="35%"  align="left"><fmt:formatDate
							value='${object.applyDate }' pattern='yyyy-MM-dd ' /></td>
					
				</tr>
				<tr>
					<td class="table_b_th">备案意见</td>
					<td align="left" colspan="3"><s:property value='%{object.remark }' /></td>
				</tr>
			</table>

		</fieldset>
		<c:if test="${not empty listfileStuff}">
		<fieldset style="border: hidden 1px #000000; ">
		<legend class="ctitle" style="width:auto;">已上传材料</legend>
			<table cellpadding="0" cellspacing="0" align="center" class="table_b">
				<tr class="b_darkblue">
					<td align="center">序号</td>
					<td align="center">材料名称</td>
					<td align="center">材料类型</td>
				</tr>
				<c:forEach items="${listfileStuff }" varStatus="stat" var="stuff">
					<tr class="b_gray">
						<td align="center">${stat.index+1 }</td>
						<td align="center"><a
							href='recordFileBasic!stuffDown.do?attachNo=${stuff.attachNo }'>
								${stuff.attachmnetName } </a></td>
						<td align="center">
							${cp:MAPVALUE("stuffType",stuff.fileType)}
						</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		</c:if>
		<c:if test="${not empty upshow}">
			<fieldset style="border: hidden 1px #000000; ">
		<legend class="ctitle" style="width:auto;">上传材料</legend>
			<table cellpadding="0" cellspacing="0" align="center" class="table_b">
				<TBODY>
					<tr>
						<td width="15%" class="table_b_th"><font color="red">*</font>选择材料
						</td>
						<td colspan="3"><s:file name="sfile_" size="70" /></td>
					</tr>
					<tr>
						<td width="15%" class="table_b_th"><font color="red">*</font>材料名称
						</td>
						<td width="35%"><s:textfield name="filestuff.attachmnetName" id="attachmnetName"
								size="30" /></td>
						<td width="15%" class="table_b_th"><font color="red">*</font>材料类型
						</td>
						<td width="35%"><select name="filestuff.fileType" >
								<option value="">&nbsp;</option>
								<c:forEach var="row" items="${cp:DICTIONARY('stuffType')}">
								<option value="${row.key}"
									<c:if test="${parameters.fileType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
								</c:forEach>
								</select></td>
					</tr>
					<tr>
						<td width="15%" class="table_b_th">材料说明</td>
						<td colspan="3"><s:textarea name="filestuff.memo" cols="75"
								rows="3" /></td>
					</tr>
				</TBODY>
			</table>
			<div align="center">
				<s:submit method="savestuff" key="上传资料" cssClass="btn"/>
				<!-- &nbsp;&nbsp;&nbsp; <input type="button" class="btn" value="返回"
					onclick="javascript:history.go(-1);" /> -->
			</div>

			</fieldset>
			<div align="center">
				<s:submit method="complete" key="完成" cssClass="btn" />
				&nbsp;&nbsp;&nbsp; <input type="button" class="btn" value="返回"
					onclick="window.location.replace('${backurl}');" />
					</div>
		</c:if>
	</s:form>
</body>

</html>
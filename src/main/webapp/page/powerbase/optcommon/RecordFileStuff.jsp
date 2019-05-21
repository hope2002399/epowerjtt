<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@page import="com.centit.powerbase.po.RecordFileBasic"%>
<%@page import="com.centit.powerbase.po.RecordFileStuff"%>
<%@page import="com.centit.powerbase.action.RecordFileStuffAction"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>备案文件详尽信息</title>
<sj:head locale="zh_CN" />
</head>
<body>
<div class="search">
			<div class="crumbs">
				 <s:text name="label.list.filter" />
			</div>
	<s:form action="recordFileStuff" namespace="/powerbase" method="post"  enctype="multipart/form-data" style="margin-top:0;margin-bottom:5">
	<table cellpadding="0" cellspacing="0" align="center">
					<tr>
					<td width="15%" align="right">文件名称：</td>
					<td><s:textfield name="s_attachmnetName" 
							value="%{#parameters['s_attachmnetName']}"/></td>
					 <td  align="left" width="80px">文件类型：</td>
					 <td><select name="s_fileType" style="width: 100px">
					 			<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('stuffType')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_fileType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
								</select></td>
					</tr>
					<tr>
						 <td align="right">时间范围：</td>
						<td width="400px">
							<sj:datepicker name="s_beginDate" readonly="true" value="%{#parameters['s_beginDate']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
							至
							<sj:datepicker name="s_endDate" readonly="true" value="%{#parameters['s_endDate']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						</td>
						<td ><s:submit method="list" key="opt.btn.query" cssClass="btn" />
					</td>
					</tr>
			</table>

	</s:form>
</div>
	<ec:table action="powerbase/recordFileStuff!list.do" items="filestufflist"
			var="stuff" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit" >
		<ec:row>
			<ec:column property ="rowcount"  cell ="rowCount"  sortable ="false"  title ="序号"/>

			<ec:column property="attachmnetName" title="材料名称" style="text-align:center">
				<a href='recordFileStuff!stuffDown.do?attachNo=${stuff.attachNo }'>
				<c:choose>
					<c:when test="${fn:length(stuff.attachmnetName) > 30}">
						
						<c:out value="${fn:substring(stuff.attachmnetName, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${stuff.attachmnetName}" />
					</c:otherwise>
				</c:choose>
				</a>
			</ec:column>
			
			<ec:column property="fileType" title="材料类型" style="text-align:center" >
				${cp:MAPVALUE("stuffType",stuff.fileType)}
			<%-- <c:if test="${stuff.fileType=='01' }"><c:out value ="备案报告"></c:out></c:if>
			<c:if test="${stuff.fileType=='02' }"><c:out value ="规范性文件正式文本"></c:out></c:if>
			<c:if test="${stuff.fileType=='03' }"><c:out value ="制定说明"></c:out></c:if>
			<c:if test="${stuff.fileType=='04' }"><c:out value ="制定依据"></c:out></c:if>
			<c:if test="${stuff.fileType=='05' }"><c:out value ="其他"></c:out></c:if> --%>
			</ec:column>
			<ec:column property="operatorID" title="上传者" style="text-align:center" >
				${cp:MAPVALUE("usercode",stuff.operatorID)}
			</ec:column>
			<ec:column property="uploadDate" title="等记时间" style="text-align:center" sortable="false" >
				<fmt:formatDate value="${stuff.uploadDate}" pattern="yyyy-MM-dd"/>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
</html>
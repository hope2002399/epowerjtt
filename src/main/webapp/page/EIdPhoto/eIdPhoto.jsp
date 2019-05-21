<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html style="padding-top: 50px;">
	<head>
		<title>
		电子证照
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){ 
				if($("#mouldId").val() == ''){
					$("#eIdPhotoIframe" , parent.document).hide();
				}
			}); 
		</script>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="padding: 10px;">
		<legend >
			电子证照
		</legend>

		<s:form action="eIdPhoto!addTZzZmInfo.do" method="post" namespace="/powerruntime"
			id="suppowerForm" enctype="multipart/form-data">
			<input type="button" style="display: none;" id="eIdPhotoSubmit" class="btn" onclick="submitItemFrame();" value="提交"/>
			<!-- <input type="button" class="btn" value="返回"
				onclick="javascript:history.go(-1);" /> -->
			<input type="hidden" id="mouldId" name="mouldId"
				value="${mouldId}" />
			<input type="hidden" value="${deptName }" size="50" name="deptName" id="deptName" /><!-- 颁证单位  -->
			<input type="hidden" value="${userName }" size="50" name="userName" id="userName" /><!-- 持证者  -->
			<input type="hidden" value="${userType }" size="50" name="userType" id="userType" /><!-- 持证者类型  -->
			<input type="hidden" value="${userZzType }" size="50" name="userZzType" id="userZzType" /><!-- 持证者证件类型  -->
			<input type="hidden" value="${userNo }" size="32" name="userNo" id="userNo" /><!-- 持证者号码  -->
			<input type="hidden" value="${djId }" size="32" name="djId" id="djId" /><!-- djId  -->
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" width="130"><span style="color: red;">*</span>证照编号</td>
					<td align="left" colspan="3"><input type="text" size="32" id="zzBh" name="zzBh" /></td>
					<!-- <td class="addTd" width="130" >颁证时间</td>
					<td align="left">
						<input type="text" class="Wdate" id="bzDate"  size="40"
							 value="" name="bzDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="选择日期">
					</td> -->
				</tr>
				<tr>
					<td class="addTd" width="150"><span style="color: red;">*</span>有效期</td>
					<td align="left" colspan="3">
						<input type="text" class="Wdate" id="starTime"  size="40"
							 value="" name="starTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="选择日期">
						&#12288;～ &#12288;
						<input type="text" class="Wdate" id="endTime"  size="40"
							 value="" name="endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="选择日期">
					</td>
				</tr>
				<!-- <tr>
					<td class="addTd" width="130"><span style="color: red;" >*</span>颁证单位</td>
					<td align="left"></td>
					<td class="addTd" width="130"><span style="color: red;">*</span>持证者</td>
					<td align="left"></td>
				</tr> -->
				<!-- <tr>
					<td class="addTd" width="130"><span style="color: red;">*</span>持证者类型</td>
					<td align="left"><select name="userType" id="userType">
						<option value="01">自然人</option>
						<option value="02">企业法人</option>
						<option value="03">事业法人</option>
						<option value="04">社团法人</option>
					</select></td>
					<td class="addTd" width="150"><span style="color: red;">*</span>持证者证件类型</td>
					<td align="left"><select name="userZzType" id="userZzType">
						<option value="01">统一社会信用代码</option>
						<option value="02">组织机构代码</option>
						<option value="03">工商登记号（营业执照）</option>
						<option value="04">其他单位证照</option>
						<option value="05">身份证</option>
						<option value="06">军官证</option>
						<option value="07">士兵证</option>
						<option value="08">护照</option>
						<option value="09">香港身份证</option>
						<option value="10">台湾身份证</option>
						<option value="11">澳门身份证</option>
						<option value="12">港澳居民来往内地通行证</option>
						<option value="13">台湾居民来往内地通行证</option>
						<option value="14">其他个人证照</option>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red;">*</span>持证者号码</td>
					<td align="left"><input type="text" value="userNo" size="32" name="userNo" id="userNo" /></td>
					<td class="addTd" width="130"><span style="color: red;">*</span>证照文件</td>
					<td align="left"><input type="file" name="zzFile" id="zzFile" accept=".pdf" /></td>
				</tr> -->
				<tbody id="metadataBody">
				<c:forEach items="${metadataInfoList }" var="metaInfo" varStatus="status">
					<c:if test="${status.count%2 == '0' }">
						<tr>
					</c:if>
						<td class="addTd" width="150"><span style="color: red;">*</span>${metaInfo.columnName }</td>
						<td align="left">
							<c:if test="${metaInfo.columnType == '字符型' }">
								<input type="text" name="${metaInfo.id }" />
							</c:if>
							<c:if test="${metaInfo.columnType == '日期型' }">
								<input type="text" class="Wdate" id="endTime"  size="40"
							 		value="" name="${metaInfo.id }" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="选择日期">
							</c:if>
							<c:if test="${metaInfo.columnType == '数值型' }">
								<input type="number" name="${metaInfo.id }" />
							</c:if>
						</td>
					<c:if test="${status.count%2 != '0' }">
						</tr>
					</c:if>
				</c:forEach>
				</tbody>
			</table>
		</s:form>
	</fieldset>

	</body>
	<script type="text/javascript">
		
	</script>
</html>

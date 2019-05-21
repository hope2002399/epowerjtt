<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
	<head><meta name="decorator" content='${LAYOUT}'/>
		<title>字典类别编辑</title>

		

	</head>

	<body>
		<p class="ctitle">
			字典类别编辑
		</p>
		
		<s:form action="optDef.do" namespace="/sys" >
			
			<s:submit method="save" cssClass="btn" value="保存" />
			<input type="button" value="返回" Class="btn" onclick="window.history.back()" />

			<table cellpadding="1" cellspacing="1" align="center">

				<tr>
					<td class="TDTITLE">
						业务代码
					</td>
					<td align="left">
						<s:textarea name="optid" rows="1" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						操作代码
					</td>
					
					<td align="left">
					<c:if test="${not empty object.optcode}">
						<s:textarea name="optcode" rows="1" cols="40"  readonly="true" /></c:if>
					<c:if test="${empty optcode}">
						<s:textarea name="optcode" rows="1" cols="40" /></c:if>
					</td>
					
				</tr>
				<tr>
					<td class="TDTITLE">
						操作方法
					</td>
					<td align="left">
						<s:textarea name="optmethod" rows="1" cols="40" />
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						方法名称
					</td>
					<td align="left">
						<s:textarea name="optname" rows="1" cols="40" />
					</td>
				</tr>
				<tr>
				<tr>
					<td class="TDTITLE">
						方法说明
					</td>
					<td align="left">
						<s:textarea name="optdesc" rows="2" cols="40" />
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						是否为流程操作
					</td>
					<td align="left">
						<s:radio name="isinworkflow" list="#{'F':'否','T':'是' }" listKey="key" listValue="value" ></s:radio>
					</td>
				</tr>							
			</table>
		</s:form>
	</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<head>
		<title>
			监察人员查询
		</title>
		<sj:head locale="zh_CN" />
	</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
	<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
<fieldset>
<legend><b>监察人员基本信息</b></legend>
	<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
			<tr>
					<td class="addTd" width="20%"><s:text name="supervisorypersonnel.userName" /></td>
					<td align="left">${object.userName}</td>
					<td class="addTd" width="130">部门名称</td>
					<td align="left">${cp:MAPVALUE("depno",deptcode)}</td>
					</tr>
				<tr>
				<td class="addTd" >出生年月</td>	
				<td align="left"><fmt:formatDate value='${object.birth}' pattern='yyyy-MM-dd' /></td>
					<td class="addTd"><s:text name="supervisorypersonnel.sex" /></td>
				<td align="left">
				${cp:MAPVALUE("sex",sex)}
				</td>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.politicalLandscape" /></td>
					<td align="left">${cp:MAPVALUE("POLLANDSCAPE",politicalLandscape)}</td>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.education" /></td>
					<td align="left">${cp:MAPVALUE("EDUCATION",education)}</td>
				</tr>
				<tr>
				<td class="addTd" ><s:text name="supervisorypersonnel.tel" /></td>	
				<td class="left" >${object.tel}</td>
				<td class="addTd" width="130"><s:text name="supervisorypersonnel.position" /></td>
					<td align="left">${cp:MAPVALUE("POSITION",position)}</td>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.organization" /></td>
					<td align="left">${cp:MAPVALUE("ORGANIZATION",organization)}</td>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.updateType" /></td>
					<td align="left">${cp:MAPVALUE("jcry_type",updateType)}</td>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.datesource" /></td>
					<td align="left"><s:if
						test='%{datesource==\"1\"}'>本级数据</s:if> <s:if
						test='%{ datesource==\"2\"}'>自建系统上报数据</s:if>
				</td></td>
					<td class="addTd" width="130"><s:text name="supervisorypersonnel.updateDate" /></td>
					<td align="left"><fmt:formatDate value='${updateDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
				</tr>
		</table>
		</fieldset>
</body>
</html> 

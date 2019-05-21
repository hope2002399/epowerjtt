<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="监察操作日志详细信息" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>

	<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
	<fieldset>
<legend><b>监察操作日志详细信息</b></legend>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">	
				<tr>
					<td class="TDTITLE">操作人员</td>
					<td align="left">
						${usercode}[<c:out value="${cp:MAPVALUE('usercode',usercode)}" />]
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">操作时间	</td>
					<td align="left">
						<fmt:formatDate value="${opttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">项目模块</td>
					<td align="left">
						<c:out value="${cp:MAPVALUE('optid',optid)}"></c:out>
					</td>
				</tr>	
				<tr>
					<td class="TDTITLE">操作内容</td>
					<td align="left">
						<s:property value="%{optcontent}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">更改前原值</td>
					<td align="left"><s:property value="%{oldvalue}" />	</td>
				</tr>	
				<tr>
					<td class="TDTITLE">监察日志类型</td>
					<td align="left">
						${cp:MAPVALUE("JCRZLX", bjType)}
					</td>
				</tr>	
</table>
</fieldset>
</body>
</html>

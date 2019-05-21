
<%@page import="org.apache.poi.util.StringUtil"%>

<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List, java.util.ArrayList"%>
<html>
	<head>
		<title>

		</title>
		<sj:head locale="zh_CN" />
		    <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
    <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>

	</head>

	<body>

		
		<fieldset>
			<legend>查询条件</legend>
			
			<s:form action="paMonthCheckup" namespace="/monitor" style="margin-top:0;margin-bottom:5">

				<table cellpadding="0" cellspacing="0" align="center">
					<input type="hidden" id="flag" name="flag" value="${flag}"/>
				    <TR>
				       <td width="80">开始时间:</td>
				       <td><sj:datepicker name="s_begTime" readonly="true" value="%{#parameters['s_begTime']}" 
				       	yearRange="2000:2020"changeYear="true"  displayFormat="yy-mm-dd"/></td>
				       <td width="80">结束时间:</td>
				       <td><sj:datepicker name="s_endTime" readonly="true" value="%{#parameters['s_endTime']}"
				        yearRange="2000:2020"changeYear="true" displayFormat="yy-mm-dd"/></td>
					<td colspan="2">
							<s:submit method="listAll"  key="opt.btn.query" cssClass="btn"/>
						</td>
				    </TR>
					
				</table>
			</s:form>
		</fieldset>
			
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr height="20">

				<td
					style="padding-left: 5px; padding-top: 5px; line-height: 20px; text-align: left; font-size: 12px;">
					<p align="center" style="font-size: 20;">地区统计分析报告</p><br>
					<p style="font-size: 17;">${QLString}&nbsp;</p><br>
					<p style="font-size: 17;">${QLSString}&nbsp;</p><br>
					<p style="font-size: 17;">${XKString}&nbsp;</p><br>
					<p style="font-size: 17;">${ZSString}&nbsp;</p><br>
					<p style="font-size: 17;">${QZString}&nbsp;</p><br>
					<p style="font-size: 17;">${QTString}&nbsp;</p><br>
					<p style="font-size: 17;">${CFString}&nbsp;</p><br>
				
					
					<br>
			</tr>
		</table>
</table>

	</body>
 <script type="text/javascript" >

        
    </script>
</html>

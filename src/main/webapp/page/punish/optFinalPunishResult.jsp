<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
</head>
<body>
<s:form action="" method="post" namespace="/punish" id="generalOperatorForm" target="_parent">

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>案件结果信息</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
					<tr>
					<td class="addTd" width="140">最终认定违法事实</td>
					<td align="left">
					${poi.confirmtruth}
					</td>					
					</tr>
					<tr>
					<td class="addTd" width="140">违法条款</td>
					<td align="left">
					${poi.disobeyitem}
					</td>					
					</tr>
										<tr>
					<td class="addTd" width="140">处罚结果</td>
					<td align="left">
						${poi.poindagaterepresult}
					</td>					
					</tr>				

		       		
			</table>
		</fieldset>
		<br><br>
		<p><p><p><p><p><p><p><p>
		</s:form>		
</body>
</html>
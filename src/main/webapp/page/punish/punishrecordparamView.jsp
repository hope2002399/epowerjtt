<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title>处罚备案参数信息</title>
<sj:head locale="zh_CN" />
</head>

<body>

<%@ include file="/page/common/messages.jsp"%>
<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
<fieldset>
<legend><b>处罚备案参数信息</b></legend>
	
<table border="0" cellpadding="1" cellspacing="1" class="viewTable">		
  
				<tr>
					<td class="addTd">
						<s:text name="punishrecordparam.bookoperatorid" />
					</td>
					<td align="left">
<%-- 						<s:property value="%{bookoperatorid}" /> --%>
						${cp:MAPVALUE("usercode",bookoperatorid)}
					</td>
					
				</tr>
				
				<tr>
					<td class="addTd" width="130">
						部门名称
					</td>
					<td align="left">
						${cp:MAPVALUE("depno",orgId)}
					</td>
					<td class="addTd">
						<s:text name="punishrecordparam.depkind" />
					</td>
					<td align="left">
						${cp:MAPVALUE("depkind",depkind)}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						<s:text name="punishrecordparam.personnum" />
					</td>
					<td align="left">
						${personnum} 元
					</td>
					<td class="addTd">
						<s:text name="punishrecordparam.corpnum" />
					</td>
					<td align="left">
						${corpnum} 元
					</td>
				</tr>	
				<tr>
					<td class="addTd">
						<s:text name="punishrecordparam.punishClass" />
					</td>
					<td align="left">
						<s:property value="%{punishClass}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						<s:text name="punishrecordparam.personnumBusiness" />
					</td>
					<td align="left">
						<s:property value="%{personnumBusiness}" />
					</td>
					<td class="addTd">
						<s:text name="punishrecordparam.corpnumBusiness" />
					</td>
					<td align="left">
						<s:property value="%{corpnumBusiness}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd">
						<s:text name="punishrecordparam.lawbasic" />
					</td>
					<td align="left">
						<s:property value="%{lawbasic}" />
					</td>
					<td class="addTd">
						<s:text name="punishrecordparam.remark" />
					</td>
					<td align="left">
						<s:property value="%{remark}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd">
						<s:text name="punishrecordparam.bookdate" />
					</td>
					<td align="left">
						<fmt:formatDate value='${object.bookdate}' pattern='yyyy-MM-dd HH:mm:ss' />
					</td>
					<td class="addTd">
						最后更新时间
					</td>
					<td align="left">
						<fmt:formatDate value='${object.modifydate}' pattern='yyyy-MM-dd HH:mm:ss' />
					</td>
				</tr>	

</table>



</body>
</html>

<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
</head>
<body>
<s:form action="pofinishbasic" method="post" namespace="/punish" id="generalOperatorForm" target="_parent">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" name="optProcInfo.transidea" value="结案" id="transidea">
<input type="hidden" name="optProcInfo.transcontent" value="案件办理结束" id="transcontent">
<s:hidden name="flowPhase" value="%{flowPhase}"/>
<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>执行情况登记</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
				<tr>
					<td class="addTd">认定违法事实</td>
					<td align="left" colspan="3">${object.confirmtruth }
					</td>
				</tr>	
				<tr>
					<td class="addTd">违反条款</td>
					<td align="left" colspan="3">${object.disobeyitem }
					</td>
				</tr>	
				<tr>
					<td class="addTd">处罚结论</td>
					<td align="left" colspan="3">${object.podiscussresult }
					</td>
				</tr>
				
				<c:if test="${object.punishamout !=null }">
				<c:if test="${object.punishamout >=0.00}">
					<tr>
					<td class="addTd">缴款金额</td>
					<td align="left">${object.punishamout } 元
					</td>
					<td class="addTd">处罚人数</td>
					<td align="left" width="30%">${object.punishamoutpeople }  人
					</td>
				</tr>	
				<tr>
					<td class="addTd">处罚票据扫描件</td>
					<td align="left" colspan="3">
	<a  href="<%=request.getContextPath()%>/punish/pofinishbasic!downloadstuff.do?object.punishobjectid=${object.punishobjectid}">${object.punishaffixname}</a>
					</td>
				</tr>			
				</c:if>	
				
				<c:if test="${object.punishseizure >=0}">
					<tr>
					<td class="addTd">没收件数</td>
					<td align="left">${object.punishseizure }
					</td>
					<td class="addTd">没收价值</td>
					<td align="left">${object.punishseizurevalue }
					</td>
				</tr>				
				</c:if>	
					
				<c:if test="${object.punishshoutont >=0}">
					<tr>
					<td class="addTd">停业天数</td>
					<td align="left" colspan="3">${object.punishshoutont }天
					</td>				
				</tr>				
				</c:if>
				
				<c:if test="${object.punishdetention >=0}">
					<tr>
					<td class="addTd">拘留人数</td>
					<td align="left">${object.punishdetentionpeople } 人
					</td>
					<td class="addTd">拘留天数</td>
					<td align="left">${object.punishdetention }
					</td>
				</tr>				
				</c:if>						
				</c:if>	
					<tr>
					<td class="addTd">案件履行情况</td>
					<td align="left" colspan="3">${cp:MAPVALUE("OtherPunish",object.otherpunish)}
					</td>				
				</tr>		
				<c:if test="${ not empty object.jbrja}">
					<tr>
				<td class="addTd" width="130">
						登记人员意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.jbroptionja}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.jbrja}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.jbroptionjatime" format="yyyy-MM-dd HH:mm:ss" /></div>
					</td>
				</tr>	
				</c:if>
					<c:if test="${ not empty object.ksja}">
					<tr>
				<td class="addTd" width="130">
						科室意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.ksoptionja}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.ksja}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.ksoptionjatime" format="yyyy-MM-dd HH:mm:ss" /></div>
					</td>
				</tr>	
				</c:if>
						<c:if test="${ not empty object.fzrja}">
					<tr>
				<td class="addTd" width="130">
						分管局长审批
					</td>
					<td colspan="3"  >
					<s:property value="%{object.fzroptionja}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${object.fzrja}			
						&nbsp;&nbsp;日期:						
						<s:date name="object.fzroptionjatime" format="yyyy-MM-dd HH:mm:ss" /></div>
					</td>
				</tr>	
				</c:if>
				</table>
		</fieldset>		


	<center style="margin-top:10px;">
		<span style="display:none;" >
		<s:submit name="saveAndSubmit" method="saveEndsubmitOpt" cssClass="btn" value="提 交" id="submitBtn"/>
		</span>
		<span style="display:none;" >	
			<s:submit name="save" method="saveOpt" cssClass="btn" value="保 存" id="saveBtn"/>
		</span>
		<span style="display:none;" >
		<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>
		</span>
		</center>
		</s:form>	
</body>
<script type="text/javascript">
window.parent.hiddSaveBtn();
</script>
</html>
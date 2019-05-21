<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
</head>

<body>
<fieldset style=" display: block; padding: 10px;">
			<legend>
			<b>
				案件来源信息
				</b>
			</legend>
			
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">		
  
			<%-- 	<tr>
					<td class="addTd" width="130">
						案件流水号
					</td>
					<td align="left">
						<s:property value="%{object.punishobjectid}" />
					</td>
					<td class="addTd" width="130">
						案件编号
					</td>
					<td align="left">
						<s:property value="%{object.punishobjectno}" />
					</td>
				</tr>	 --%>
				<tr>
					<td class="addTd" width="130">
						案件来源种类
					</td>
					<td align="left">					
						${cp:MAPVALUE("CASEORIGN",object.pooriginstate)}
					</td>
					<td class="addTd" width="130">
						来源时间
					</td>
					<td align="left">
						<s:date name="poregistedate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
				<tr>
					<td class="addTd" width="130">
						案发时间
					</td>
					<td align="left">
						<s:date name="pooccurdate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
						<td class="addTd" width="130">
						当事人
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachname}" />
					</td>
				</tr>
				<tr>
					<td class="addTd" width="130">
						案发地点
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.pooccuradress}" />
					</td>
				</tr>
					<tr>
					<td class="addTd" width="130">
						案件来源描述
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.poorigincontext}" />
					</td>
				</tr>	
		<%-- 		
					<tr>
					<td class="addTd" width="130">
						案由
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.punishobjectbrief}" />
					</td>
				</tr>	 --%>
			
				
					
				<tr>
					<td class="addTd" width="130">
						来源备注
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.remark}" />
					</td>
				</tr>
				<tr>
				<td class="addTd" width="130">
						登记人员意见
					</td>
					<td colspan="3"  >
					<s:property value="%{object.poregisteropinion}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${cp:MAPVALUE("usercode",object.operatorid)}			
						&nbsp;&nbsp;日期:						
						<s:date name="poregistedate" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>
				<c:if test="${ not empty poacceptinfo.jbroptionSl}">
				<tr>
				<td class="addTd" width="130">
						经办人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{poacceptinfo.jbroptionSl}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${poacceptinfo.jbrSl}			
						&nbsp;&nbsp;日期:						
						<s:date name="poacceptinfo.jbroptionSltime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>
				</c:if>
				<c:if test="${ not empty poacceptinfo.fzroptionSl}">
				<tr>
				
				<td class="addTd" width="130">
						部门负责人意见
					</td>
					<td colspan="3"  >
					<s:property value="%{poacceptinfo.fzroptionSl}" />
					<div align="right" style=" padding-right: 100px ">
						签名:				
						${poacceptinfo.fzrSl}			
						&nbsp;&nbsp;日期:						
						<s:date name="poacceptinfo.fzroptionSltime" format="yyyy-MM-dd HH:mm:ss"/>
						</div>
					</td>
				</tr>		
</c:if>
				

				

				
<%-- 
				<tr>
					<td class="addTd" width="130">
						举报人姓名
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachname}" />
					</td>
					
			
					<td class="addTd" width="130">
						举报人性质
					</td>
					<td align="left">
						<s:property value="%{object.poimpeachstate}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						举报人性别
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachsex}" />
					</td>
					<td class="addTd" width="130">
						举报人邮编
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachpostcode}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						举报人联系电话
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachphone}" />
					</td>
				
					<td class="addTd" width="130">
						举报人工作单位
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachunit}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						举报人年龄
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachage}" />
					</td>

					<td class="addTd" width="130">
						举报人身份证号码
					</td>
					<td align="left">
						<s:property value="%{object.pocaseimpeachid}" />
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						举报人地址
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.pocaseimpeachadress}" />
					</td>
				</tr>	 --%>

			<c:if test="${ not empty object.risktype }">
				<tr>
					<td class="addTd" width="130">
						风险点描述
					</td>
					<td align="left">
						<s:property value="%{object.riskdesc}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						风险点类别
					</td>
					<td align="left">
						<s:property value="%{object.risktype}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						风险内控的手段与结果
					</td>
					<td align="left">
						<s:property value="%{object.riskresult}" />
					</td>
				</tr>
	
</c:if>
		
</table>
</fieldset>
</body>
</html>

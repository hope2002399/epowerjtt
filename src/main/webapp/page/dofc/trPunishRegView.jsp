<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="trPunishReg.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="trPunishReg.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='powerruntime/trPunishReg!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.djId" />
					</td>
					<td align="left">
						<s:property value="%{djId}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseDate" />
					</td>
					<td align="left">
						<s:property value="%{caseDate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseAddress" />
					</td>
					<td align="left">
						<s:property value="%{caseAddress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseSource" />
					</td>
					<td align="left">
						<s:property value="%{caseSource}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseFact" />
					</td>
					<td align="left">
						<s:property value="%{caseFact}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetType" />
					</td>
					<td align="left">
						<s:property value="%{targetType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetName" />
					</td>
					<td align="left">
						<s:property value="%{targetName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetPaperType" />
					</td>
					<td align="left">
						<s:property value="%{targetPaperType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetPaperCode" />
					</td>
					<td align="left">
						<s:property value="%{targetPaperCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetUnitcode" />
					</td>
					<td align="left">
						<s:property value="%{targetUnitcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetPhone" />
					</td>
					<td align="left">
						<s:property value="%{targetPhone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetMobile" />
					</td>
					<td align="left">
						<s:property value="%{targetMobile}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetAddress" />
					</td>
					<td align="left">
						<s:property value="%{targetAddress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterName" />
					</td>
					<td align="left">
						<s:property value="%{reporterName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterDate" />
					</td>
					<td align="left">
						<s:property value="%{reporterDate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterPaperType" />
					</td>
					<td align="left">
						<s:property value="%{reporterPaperType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterPaperCode" />
					</td>
					<td align="left">
						<s:property value="%{reporterPaperCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterPhone" />
					</td>
					<td align="left">
						<s:property value="%{reporterPhone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterMobile" />
					</td>
					<td align="left">
						<s:property value="%{reporterMobile}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterAddress" />
					</td>
					<td align="left">
						<s:property value="%{reporterAddress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseRegDate" />
					</td>
					<td align="left">
						<s:property value="%{caseRegDate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseRegUsercode" />
					</td>
					<td align="left">
						<s:property value="%{caseRegUsercode}" />
					</td>
				</tr>	

</table>


<p/>
<div class="eXtremeTable" >
	<table id="ec_table"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >

		<thead>
			<tr>
    
				<td class="tableHeader">
					<s:text name="trPunishDetail.djId" />
				</td>
    
				<td class="tableHeader">
					<s:text name="trPunishDetail.punishItem" />
				</td>

  
				<td class="tableHeader">
					<s:text name="trPunishDetail.punishName" />
				</td>
  
				<td class="tableHeader">
					<s:text name="trPunishDetail.isreal" />
				</td>
		
				<td class="tableHeader"><s:text name="opt.btn.collection" /></td>
			</tr>  
		</thead>
		
		<tbody class="tableBody" >
		<c:set value="odd" var="rownum" />
		
		<c:forEach var="trPunishDetail" items="${object.trPunishDetails}">    
			<tr class="${rownum}"  onmouseover="this.className='highlight'"  onmouseout="this.className='${rownum}'" >
    
				<td><c:out value="${trPunishDetail.djId}"/></td>  
    
				<td><c:out value="${trPunishDetail.punishItem}"/></td>  

  
				<td><c:out value="${trPunishDetail.punishName}"/></td>  
  
				<td><c:out value="${trPunishDetail.isreal}"/></td>  
		
				<td>
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='powerruntime/trPunishDetail!edit.do?djId=${trPunishReg.djId}&djId=${trPunishDetail.djId}&punishItem=${trPunishDetail.punishItem}'><s:text name="opt.btn.edit" /></a>
					<a href='powerruntime/trPunishDetail!delete.do?djId=${trPunishReg.djId}&djId=${trPunishDetail.djId}&punishItem=${trPunishDetail.punishItem}' 
							onclick='return confirm("${deletecofirm}trPunishDetail?");'><s:text name="opt.btn.delete" /></a>
				</td>
			</tr>  
            <c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
		</c:forEach> 
		</tbody>        
	</table>
</div>


</body>
</html>

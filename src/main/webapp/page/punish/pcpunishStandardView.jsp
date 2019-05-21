<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title><c:out value="pcpunishStandard.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/extremecomponents.css"
	type="text/css" rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="pcpunishStandard.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.punishclassid" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.punishclassid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.punishtypeid" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.punishtypeid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.isinuse" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.isinuse}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.punishmax" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.punishmax}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.punishmin" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.punishmin}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.israte" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.israte}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.chargemax" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.chargemax}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.radixname" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.radixname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.radixunit" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.radixunit}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pcpunishStandard.punishcontent" />
					</td>
					<td align="left">
						<c:out value="${pcpunishStandard.punishcontent}" />
					</td>
				</tr>	

</table>


<p/>
<div class="eXtremeTable" >
	<table id="ec_table"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >

		<thead>
			<tr>

    
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.degreeno" />
				</td>


  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.isinuse" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.punishmax" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.punishmin" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.israte" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.radixname" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.radixunit" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.punishcontent" />
				</td>
  
				<td class="tableHeader">
					<c:out value="pcfreeumpiretype.standardNo" />
				</td>
		
				<td class="tableHeader"><bean:message key="opt.btn.collection" /></td>
			</tr>  
		</thead>
		
		<tbody class="tableBody" >
		<c:set value="odd" var="rownum" />
		
		<c:forEach var="pcfreeumpiretype" items="${pcpunishStandard.pcfreeumpiretypes}">    
			<tr class="${rownum}"  onmouseover="this.className='highlight'"  onmouseout="this.className='${rownum}'" >
    
				<td><c:out value="${pcfreeumpiretype.degreeno}"/></td>  

  
				<td><c:out value="${pcfreeumpiretype.isinuse}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.punishmax}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.punishmin}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.israte}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.radixname}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.radixunit}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.punishcontent}"/></td>  
  
				<td><c:out value="${pcfreeumpiretype.standardNo}"/></td>  
		
				<td>
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='pcfreeumpiretype.do?punishclassid=${pcpunishStandard.punishclassid}&punishtypeid=${pcpunishStandard.punishtypeid}&punishclassid=${pcfreeumpiretype.punishclassid}&degreeno=${pcfreeumpiretype.degreeno}&punishtypeid=${pcfreeumpiretype.punishtypeid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='pcfreeumpiretype.do?punishclassid=${pcpunishStandard.punishclassid}&punishtypeid=${pcpunishStandard.punishtypeid}&punishclassid=${pcfreeumpiretype.punishclassid}&degreeno=${pcfreeumpiretype.degreeno}&punishtypeid=${pcfreeumpiretype.punishtypeid}&method=delete' 
							onclick='return confirm("${deletecofirm}pcfreeumpiretype?");'><bean:message key="opt.btn.delete" /></a>
				</td>
			</tr>  
            <c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
		</c:forEach> 
		</tbody>        
	</table>
</div>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="riskInfo.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="riskInfo.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>
<s:form action="riskInfo"  method="post" namespace="/powerruntime" id="riskInfoForm" >
<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back" />
<p>	
	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
  
			
				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.risktype" />
					</td>
					<td align="left">
						<s:property value="%{risktype}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.riskdes" />
					</td>
					<td align="left">
						<s:property value="%{riskdes}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.riskdeal" />
					</td>
					<td align="left">
						<s:property value="%{riskdeal}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.settime" />
					</td>
					<td align="left">
						<s:property value="%{settime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.setuser" />
					</td>
					<td align="left">
						<s:property value="%{setuser}" />
					</td>
				</tr>	

</table>
</s:form>

<p/>
<div class="eXtremeTable" >
	<table id="ec_table"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >

		<thead>
			<tr>
    
				<td class="tableHeader">
					<s:text name="powerOptInfo.itemId" />
				</td>
    
				<td class="tableHeader">
					<s:text name="powerOptInfo.wfcode" />
				</td>


  
				<td class="tableHeader">
					<s:text name="powerOptInfo.setoperator" />
				</td>
  
				<td class="tableHeader">
					<s:text name="powerOptInfo.setime" />
				</td>
		
				<td class="tableHeader"><s:text name="opt.btn.collection" /></td>
			</tr>  
		</thead>
		
		<tbody class="tableBody" >
		<c:set value="odd" var="rownum" />
		
		<c:forEach var="powerOptInfo" items="${object.powerOptInfos}">    
			<tr class="${rownum}"  onmouseover="this.className='highlight'"  onmouseout="this.className='${rownum}'" >
    
				<td><c:out value="${powerOptInfo.itemId}"/></td>  
    
				<td><c:out value="${powerOptInfo.wfcode}"/></td>  

  
				<td><c:out value="${powerOptInfo.setoperator}"/></td>  
  
				<td><c:out value="${powerOptInfo.setime}"/></td>  
		
				<td>
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='powerruntime/powerOptInfo!edit.do?riskid=${riskInfo.riskid}&itemId=${powerOptInfo.itemId}&wfcode=${powerOptInfo.wfcode}'><s:text name="opt.btn.edit" /></a>
					<a href='powerruntime/powerOptInfo!delete.do?riskid=${riskInfo.riskid}&itemId=${powerOptInfo.itemId}&wfcode=${powerOptInfo.wfcode}' 
							onclick='return confirm("${deletecofirm}powerOptInfo?");'><s:text name="opt.btn.delete" /></a>
				</td>
			</tr>  
            <c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
		</c:forEach> 
		</tbody>        
	</table>
</div>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head><meta name="decorator" content='${LAYOUT}'/>
<title>机构权限信息</title>

</head>

<body>
<p class="ctitle">机构权限信息</p>


<s:form action="deptManager.do" namespace="/sys" styleId="deptpowerForm"  >

	<s:submit method="saveDeptPower" cssClass="btn" value="保存" />

	<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
	
	<table cellpadding="1" cellspacing="1" align="center">
		
		<tr>
			<td class="TDTITLE">机构代码*</td>
			<td align="left"><s:textfield name="unitcode" readonly="true"/></td>
			<td class="TDTITLE">机构名称</td>
			<td align="left"><s:textfield name="unitname"  size="24"/></td>
		</tr>
		<tr>
			<td class="TDTITLE">机构描述</td>
			<td align="left" colspan="3"><s:textarea name="unitdesc" 
				rows="1" cols="60" /></td>
		</tr>
	</table>

<div class="eXtremeTable" >
	<table id="ec_table"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >

		<thead>
			<tr>
			<td class="tableHeader">业务名称</td>   
			<td class="tableHeader">业务操作</td>  
			</tr>  
		</thead>
		<tbody class="tableBody" >
		<c:set value="odd" var="rownum" />
		
		<c:forEach var="optpower" items="${fOptPowers}">    

			<tr class="${rownum}"  onmouseover="this.className='highlight'"  onmouseout="this.className='${rownum}'" >
				<td><c:out value="${optpower.optname}"/></td>   
				<td>
					<c:forEach var="row" items="${cp:OPTDEF(optpower.optid)}">    
						<input type="checkbox" name="optcodelist" value="${row.optcode}"
							<c:if test="${powerlist[row.optcode] eq '1' }">  checked="checked" </c:if> />
						<c:out value="${row.optname}"/>    
					</c:forEach>          
				</td>  
			</tr>  

          <c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
          
		</c:forEach> 
		</tbody>        
	</table>
</div>

</s:form>
</body>

</html>

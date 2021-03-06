<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>




<!-- IFRAME模式下需要导入的内容BEGIN -->
<%@ include file="./childs/stat-taglibs.jsp"%>
<!-- IFRAME模式下需要导入的内容END -->

<%@ include file="childs/search.jsp"%>
<form method="post" id="dataForm" action="twodimenform!doExport.do?headrows=1">
<div class="pageContent">
	<input name="formName" id="formName" value="${formName }" type="hidden" ></input>
	<input name="exportData" id="exportData" type="hidden" ></input>
	<table id="dataTab" class="list stat" layoutH=".pageHeader 1" width="100%">
		
		<c:if test="${not empty tablePanel.thead }">
			<thead align="center">
				<c:forEach var="line" items="${tablePanel.thead.lines }">
					<tr>
						<c:forEach var="cell" items="${line.cells }">
							${cell.html }
						</c:forEach>
					</tr>
				</c:forEach>
			</thead>
		</c:if>
		
		<c:if test="${not empty tablePanel.tbody }">
			<tbody align="center">
				<c:forEach var="line" items="${tablePanel.tbody.lines }">
					<tr>
						<c:forEach var="cell" items="${line.cells }">
							${cell.html }					
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>
</div>
</form>
<%@ include file="./childs/stat-scripts.jsp"%>	
<script>
  	$(function() {
		$('a').each(function() {
			$this = $(this);
			
			var href = $this.attr('href');
			href=encodeURI(encodeURI(href));
			$this.attr('href', href);
		});
	}); 
</script>
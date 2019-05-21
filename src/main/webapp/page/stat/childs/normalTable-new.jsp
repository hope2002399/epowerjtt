<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<div class="">
	<div class="">
	<table class="" id="statTable" style="width:100%;" >
		<caption>${formNameFormat }</caption>
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
				<c:forEach var="line" items="${tablePanel.tbody.lines }" varStatus="a">
					<tr <c:if test="${a.index%2==0 }">style="background-color: #dfe4e8;" </c:if> 
					<c:if test="${a.index%2==1 }">style="background-color:#ffffff;" 
					</c:if> >
						<c:forEach var="cell" items="${line.cells }">
							${cell.html }					
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>




	
	</div>
</div>
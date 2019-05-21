<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<script>
	top.document.getElementById("progressBar").style.display = "block";
	top.document.getElementById("background").style.display = "block";
</script>
<div >
	<div >
	<table class="table table-bordered ${thLargeDisplay }" id="statTable" >
	<caption>${formNameFormat}</caption>
		<c:if test="${not empty tablePanel.thead }">
			<%-- <thead align="center">
				<c:forEach var="line" items="${tablePanel.thead.lines }">
					<tr>
						<c:forEach var="cell" items="${line.cells }">
							${cell.html }
						</c:forEach>
					</tr>
				</c:forEach>
			</thead> --%>
			
			<!--执法情况报表专用表头 zkp  -->
					<thead align="center" style="width: 100%; border: 1px solid #CACACA; margin-top: 10px;">
				<tr >
					<th rowspan="3" align="center" width="20%"><strong>执法单位 </strong></th>
					<th rowspan="3" align="center" width="10%" style="display:none;"><strong>上级单位 </strong></th>
					<th rowspan="3" align="center" width="10%" style="display:none;"><strong>执法单位 </strong></th>
					<th colspan="4" align="center" width="35%"><strong>行政许可</strong></th>
					<th colspan="2" align="center" width="25%"><strong>行政处罚</strong></th>
					<th rowspan="3" align="center" width="5%"><strong>行政征收</strong></th>
					<th rowspan="3" align="center" width="5%"><strong>行政强制</strong></th>
					<th rowspan="3" align="center" width="5%"><strong>其他事项</strong></th>
				</tr>
				<tr >
			
					<th colspan="2" align="center"><strong>申请</strong></th>
					<th colspan="2" align="center"><strong>许可决定</strong></th>
					<th rowspan="2" align="center"><strong>简易程序</strong></th>
					<th rowspan="2" align="center"><strong>一般程序</strong></th>
					<!-- <td rowspan="2" align="center">重大处罚</td> -->
				</tr>
				<tr >
					<th align="center"><strong>不予受理</strong></td>
					<th align="center"><strong>受理</strong></td>
					<th align="center"><strong>不予许可</strong></td>
					<th align="center"><strong>准予许可</strong></td>
				</tr>
				</thead>
		</c:if>
		
		<c:if test="${not empty tablePanel.tbody }">
			<tbody align="center">
				<c:forEach var="line" items="${tablePanel.tbody.lines }" varStatus="trStatus">
					<c:set var="depno" value="${line.cells[0].value }"></c:set>
					<c:set var="supdepno" value="${line.cells[1].value }"></c:set>
					
					<%-- 父节点为空 顶级节点 --%>
					<c:if test="${empty supdepno or trStatus.index == 0}">
						<tr data-tt-id="${depno }">
					</c:if>
					
					<%-- 父节点不为空 --%>
					<c:if test="${not empty supdepno and trStatus.index != 0}">
						<tr data-tt-id="${depno }" data-tt-parent-id="${supdepno }">
					</c:if>
					
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
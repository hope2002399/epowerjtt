<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<head>
<style type="text/css">
thead td{background-color:#2D80D2;color:white;border: 1px solid #CACACA;text-align:center;
          cursor:pointer;font-size:12px;padding:5px;border-right: 1px solid #CACACA;line-height:16px;vertical-align: middle;}
table td {font-size:12px; padding:5px;border: 1px solid #CACACA;}
table#statTable td{border-right: 1px solid #CACACA;font-size:12px;line-height:16px;padding:5px;vertical-align: middle;}
table.viewTable{border: 1px solid #CACACA;}

</style>
</head>
<body>


	<div class="box">
		<h2>&nbsp;&nbsp;一、权力事项运行分析</h2>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;&nbsp;
			按权力类型统计，行政权力运行数量为${sumnum }件，其中
			<c:forEach items="${list }" var="map" varStatus="mapstatu">
		${cp:MAPVALUE('ITEM_TYPE',map.ITEMTYPE)}${map.BJNUM }件
		<c:if test="${map.BJNUM ne '0' }">
		,占
		<fmt:formatNumber value="${map.BJNUM/sumnum }" maxFractionDigits="2"
						minFractionDigits="2" type="percent" />
		;</c:if>
				<c:if test="${map.BJNUM eq '0' }">
		;</c:if>
			</c:forEach>
			<!-- 许可4081件，占16.15%；
		处罚5153件，占20.39%；
		强制10件，占0.04%；
		行政确认7902件，占31.28%；
		行政审批0件；
		其他8120件，占32.14%。 -->
		</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table style="width: 100%;" class="viewTable" id="statTable">
			<thead>
				<tr align="center">
					<td>序号</td>
					<td>权力类型</td>
					<td>办件量（件）</td>
					<td>占比</td>
				</tr>
			</thead>
			<c:forEach items="${list }" var="map" varStatus="mapstatu">
				<tr align="center"
					<c:if test="${mapstatu.index%2==0 }">style="background-color: #dfe4e8;" </c:if>
					<c:if test="${mapstatu.index%2==1 }">style="background-color:#ffffff;" 
					</c:if>>
					<td>${mapstatu.count }</td>
					<td>${cp:MAPVALUE('ITEM_TYPE',map.ITEMTYPE)}</td>
					<td>${map.BJNUM }</td>
					<td><c:if test="${map.BJNUM ne '0' }">
							<fmt:formatNumber value="${map.BJNUM /sumnum }" type="percent"
								maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${map.BJNUM eq '0' }">
			0%
		</c:if></td>
				</tr>
			</c:forEach>
		<!-- 	<thead> -->
				<tr align="center">
					<td colspan="2">合计</td>
					<td>${sumnum }</td>
					<td>
					<c:if test="${sumnum eq '0' }">0%</c:if>
					<c:if test="${sumnum ne '0' }">100%</c:if>
					</td>
				</tr>
			<!-- </thead> -->
		</table>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;&nbsp;按行使权力的行业统计，在用权力数、实际运行权力数、运行率和运行办件数量如下表所示。</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table style="width: 100%;" class="viewTable" id="statTable">
			<thead>
				<tr align="center">
					<td>序号</td>
					<td>部门</td>
					<td>权力总数（项）</td>
					<td>实际运行（项）</td>
					<td>实际运行率</td>
					<td>办件量（件）</td>
					<td>办结量（件）</td>
				</tr>
			</thead>
			<c:forEach items="${list1 }" var="map" varStatus="mapstatu">
				<tr align="center"
					<c:if test="${mapstatu.index%2==0 }">style="background-color: #dfe4e8;" </c:if>
					<c:if test="${mapstatu.index%2==1 }">style="background-color:#ffffff;" 
					</c:if>>
					<td>${mapstatu.count }</td>
					<td>${cp:MAPVALUE('INDUSTRY_TYPE2',map.INDUSTRYTYPE)}</td>
					<td>${map.POWERCOUNT}</td>
					<td>${map.POWERUSECOUNT}</td>
					<td><c:if test="${map.POWERUSECOUNT ne '0' }">
							<fmt:formatNumber value="${map.POWERUSECOUNT /map.POWERCOUNT }"
								type="percent" maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${map.POWERUSECOUNT eq '0' }">
			0%
		</c:if></td>
					<td>${map.APPLYNUM}</td>
					<td>${map.FINISHNUM}</td>
				</tr>
			</c:forEach>
			<!-- <thead> -->
				<tr align="center">
					<td colspan="2">合计</td>
					<td>${powersum }</td>
					<td>${powerusesum }</td>
					<td><c:if test="${powerusesum ne '0' }">
							<fmt:formatNumber value="${powerusesum /powersum }"
								type="percent" maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${powerusesum eq '0' }">
			0%
		</c:if></td>
					<td>${applysum}</td>
					<td>${finishsum}</td>

				</tr>
		<!-- 	</thead> -->
		</table>
		<p>注：实际运行率=实际运行数/权力总数</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>



</body>




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
		<h3>&nbsp;&nbsp;（二）督查督办情况分析</h3>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;&nbsp;
			${year}年 ${month}月，发起督查督办${dbsum }次，及时反馈${jsfksum }次

			<c:if test="${dbsum ne '0' && jsfksum ne '0'}">
					，及时反馈率为	<fmt:formatNumber value="${jsfksum /dbsum }" type="percent"
					maxFractionDigits="2" minFractionDigits="2" />
			</c:if>
			<c:if test="${dbsum eq '0' || jsfksum eq '0'}">
			，及时反馈率为0%
		</c:if>
			。 行业督查督办情况如下表所示。
		</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table style="width: 100%;" class="viewTable" id="statTable">
			<thead>
				<tr align="center">
					<td>序号</td>
					<td>部门</td>
					<td>督办（次）</td>
					<td>及时反馈（次）</td>
					<td>及时反馈率</td>
				</tr>
			</thead>
			<c:forEach items="${list }" var="map" varStatus="mapstatu">
				<tr align="center"
					<c:if test="${mapstatu.index%2==0 }">style="background-color: #dfe4e8;" </c:if>
					<c:if test="${mapstatu.index%2==1 }">style="background-color:#ffffff;" 
					</c:if>>
					<td>${mapstatu.count }</td>
					<td>${cp:MAPVALUE('INDUSTRY_TYPE2',map.INDUSTRYTYPE)}</td>
					<td>${map.DBNUM }</td>
					<td>${map.JSFKNUM }</td>
					<td><c:if test="${map.DBNUM  ne '0' && map.JSFKNUM ne '0'}">
							<fmt:formatNumber value="${map.JSFKNUM /map.DBNUM }"
								type="percent" maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${map.DBNUM  eq '0' || map.JSFKNUM eq '0'}">
			0%
		</c:if></td>
				</tr>
			</c:forEach>
			<!-- <thead> -->
				<tr align="center">
					<td colspan="2">合计</td>
					<td>${dbsum }</td>
					<td>${jsfksum }</td>
					<td><c:if test="${dbsum  ne '0' && jsfksum ne '0'}">
							<fmt:formatNumber value="${jsfksum /dbsum }" type="percent"
								maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${jsfksum eq '0' || dbsum eq '0' }">
			0%
		</c:if></td>

				</tr>
			<!-- </thead> -->
		</table>

		<p>注：及时反馈率=及时反馈/督办数</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>



</body>




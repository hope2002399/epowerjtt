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
		<h3>&nbsp;&nbsp;（一）预报警情况分析</h3>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;&nbsp;
			${year}年 ${month}月，系统共发生预报警${yjsum +bjsum }次，其中预警${yjsum }次，报警${bjsum
			}次

			<c:if test="${(yjsum +bjsum)  ne '0'  }">
		，预报警率为
		<fmt:formatNumber value="${(yjsum +bjsum) /applysum }"
					maxFractionDigits="2" minFractionDigits="2" type="percent" />
			</c:if>
			<c:if test="${(yjsum +bjsum)  eq '0'  }">
		，预报警率为0%
				</c:if>
			。各行业预报警情况如下表所示：
		</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table style="width: 100%;" class="viewTable" id="statTable">
			<thead>
				<tr align="center">
					<td>序号</td>
					<td>部门</td>
					<td>预警（次）</td>
					<td>报警（次）</td>
					<td>合计（次）</td>
					<td>预报警率</td>
				</tr>
			</thead>
			<c:forEach items="${list }" var="map" varStatus="mapstatu">
				<tr align="center"
					<c:if test="${mapstatu.index%2==0 }">style="background-color: #dfe4e8;" </c:if>
					<c:if test="${mapstatu.index%2==1 }">style="background-color:#ffffff;" 
					</c:if>>
					<td>${mapstatu.count }</td>
					<td>${cp:MAPVALUE('INDUSTRY_TYPE2',map.INDUSTRYTYPE)}</td>
					<td>${map.YJNUM }</td>
					<td>${map.BJNUM }</td>
					<td>${map.YJNUM+map.BJNUM }</td>
					<td><c:if test="${(map.YJNUM+map.BJNUM)  ne '0'  }">
							<fmt:formatNumber
								value="${(map.YJNUM+map.BJNUM) /map.APPLYCOUNT }" type="percent"
								maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${(map.YJNUM+map.BJNUM) eq '0' }">
			0%
		</c:if></td>
				</tr>
			</c:forEach>
			<!-- <thead> -->
				<tr align="center">
					<td colspan="2">合计</td>
					<td>${yjsum }</td>
					<td>${bjsum }</td>
					<td>${yjsum +bjsum }</td>
					<td><c:if test="${(yjsum +bjsum)  ne '0' }">
							<fmt:formatNumber value="${(yjsum +bjsum) /applysum }"
								type="percent" maxFractionDigits="2" minFractionDigits="2" />
						</c:if> <c:if test="${(yjsum+bjsum) eq '0' }">
			0%
		</c:if></td>

				</tr>
			<!-- </thead> -->
		</table>

		<p>注：预报警率=预报警数量/办件数量</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>



</body>




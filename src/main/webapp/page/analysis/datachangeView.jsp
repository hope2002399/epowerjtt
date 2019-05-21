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
		<h2>&nbsp;&nbsp;三、数据交换运行情况</h2>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;&nbsp;${year}年 ${month}月，系统向省政府权力运行平台报送办件${applysum_J }件（${applysum_T
			}条）， 其中包括厅系统运行办件${applytsum_J }件（${applytsum_T
			}条），以及接收的厅属单位业务系统办件${applybssum_J }件（${applybssum_T }条）， 具体报送情况如下表所示。</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table style="width: 100%;" id="statTable" class="viewTable">
			<thead>
				<tr align="center">
					<td>序号</td>
					<td>部门</td>
					<td>报送办件（件）</td>
					<td>报送数据（条）</td>
				</tr>
			</thead>
			<c:forEach items="${list }" var="map" varStatus="mapstatu">
				<tr align="center"
					<c:if test="${mapstatu.index%2==0 }">style="background-color: #dfe4e8;" </c:if>
					<c:if test="${mapstatu.index%2==1 }">style="background-color:#ffffff;" 
					</c:if>>
					<td>${mapstatu.count }</td>
					<td>${cp:MAPVALUE('INDUSTRY_TYPE2',map.INDUSTRYTYPE)}</td>
					<td>${map.APPLYCOUNT_J }</td>
					<td>${map.APPLYCOUNT_T }</td>

				</tr>
			</c:forEach>
		<!-- 	<thead> -->
				<tr align="center">
					<td colspan="2">合计</td>
					<td>${applysum_J }</td>
					<td>${applysum_T }</td>


				</tr>
			<!-- </thead> -->
		</table>

		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>



</body>




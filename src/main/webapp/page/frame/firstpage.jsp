<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<style>
.container1 {
	padding: 5px;
	box-sizing: border-box;
	overflow: hidden;
}

.container1 .box {
	border: 1px solid #ddd;
	margin-bottom: 10px;
	box-sizing: border-box;
}

.container1 .box h1 {
	height: 25px;
	line-height: 25px;
	padding-left: 10px;
	color: #fff;
	font-size: 14px;
	background:
		url(${pageContext.request.contextPath}/themes/default/images/zhong.gif)
		repeat-x;
}


</style>
	<%-- <link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> --%>
	<link href="${pageContext.request.contextPath}/media/css/style.css" rel="stylesheet" type="text/css"/>

<div class="container1">
<%-- 
	<div class="box" style="margin-bottom:0px;" >

			<div class="span3 responsive" data-tablet="span3"
				data-desktop="span3" style="float:left;width:24.5%;margin-left:0.1%;margin-right:0.1%;margin-bottom:0px;padding-bottom:0px;">

				<div class="dashboard-stat blue" style="margin-bottom:0px;padding-bottom:0px;">


					<div class="details" >

						<div class="number" style="padding-top:5px;float:right;margin-bottom:0px;">

							${firstTotal.currenBuidemonth}
							${xknum }

						</div>

						<div class="desc" style="font-weight: bold;float:left;padding-top:15px;padding-left:10px;" >

							${firstTotal.month}月份船舶建造检验量
							当月许可办件量

						</div>

					</div>
					<span> </span> <a class="more" href="${pageContext.request.contextPath}/monitor/apply!fgList.do?type=result&s_NP_result=1&s_begFinishTime=${firstdayofmonth}" target="navTab" rel="external_BJJGJK" external="true"> 详细信息 <i
						class="m-icon-swapright m-icon-white"></i>

					</a>

				</div>

			</div>

			<div class="span3 responsive" data-tablet="span3"
				data-desktop="span3" style="float:left;width:24.5%;margin-left:0.1%;margin-right:0.1%;margin-bottom:0px;padding-bottom:0px;">

				<div class="dashboard-stat green" style="margin-bottom:0px;padding-bottom:0px;">

					<div class="details">

						<div class="number" style="padding-top:5px;float:right;margin-bottom:0px;">
							${firstTotal.visaByCurrentMonth}
							${cfnum }
						</div>

						<div class="desc" style="font-weight: bold;float:left;padding-top:15px;padding-left:10px;">
							${firstTotal.month}月份船舶进出港签证数量
							当月处罚办件量
						</div>

					</div>

					<a class="more"  href="${pageContext.request.contextPath}/monitor/punish!list.do?type=result&s_NP_result=1&s_begFinishTime=${firstdayofmonth}" target="navTab" rel="external_AJJGJK" external="true"> 详细信息 <i
						class="m-icon-swapright m-icon-white"></i>

					</a>

				</div>

			</div>

			<div class="span3 responsive" data-tablet="span3"
				data-desktop="span3" style="float:left;width:24.5%;margin-left:0.1%;margin-right:0.1%;margin-bottom:0px;padding-bottom:0px;">

				<div class="dashboard-stat purple" style="margin-bottom:0px;padding-bottom:0px;">


					<div class="details">

						<div class="number" style="padding-top:5px;float:right;margin-bottom:0px;">
								${firstTotal.punishByPreMonth}
							${yjnum }
						</div>

						<div class="desc" style="font-weight: bold;float:left;padding-top:15px;padding-left:10px;">
							
							${firstTotal.month}月份行政处罚笔数 
							当月预警报警数
						</div>

					</div>

					<a class="more" href="${pageContext.request.contextPath}/monitor/outway!list.do?s_NP_outWayZC=1&s_begTime=${firstdayofmonth}" target="navTab" rel="external_YJBJ" external="true"> 详细信息 <i
						class="m-icon-swapright m-icon-white"></i>

					</a>

				</div>

			</div>

			<div class="span3 responsive" data-tablet="span3"
				data-desktop="span3" style="float:left;width:24.5%;margin-left:0.1%;margin-right:0.1%;margin-bottom:0px;padding-bottom:0px;">

				<div class="dashboard-stat yellow" style="margin-bottom:0px;padding-bottom:0px;">


					<div class="details">

						<div class="number" style="padding-top:5px;float:right;margin-bottom:0px;">
							${firstTotal.portFeeByCurrentMonth}
							${dbnum }
						</div>

						<div class="desc" style="font-weight: bold;float:left;padding-top:15px;padding-left:10px;">
							${firstTotal.month}月份船舶港务费(万元)
							当月督办总数
						</div>

					</div>

					<a class="more" href="#"> 详细信息 <i
						class="m-icon-swapright m-icon-white"></i>

					</a>


				</div>

			</div>
		</div>
 --%>

	<div class="box" style="width: 49%; float: left">
			<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showFirstPageMap.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="99%" onload="autoHeight(this);"></iframe>
	</div>

	<div class="box" style="width: 49%; float: right">


			<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showFirstPageLine.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="99%" height="400px"></iframe>


		</div>

	<div class="box" style="width: 49%; float: right">
			<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showFirstPageBar.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="99%" height="420px"></iframe>


		</div>


</div>





</body>


<script>
	function autoHeight(iframe) {

		if (!iframe) {
			return false;
		}

		// chrome处理iframe上的onmousescroll和ff ie不同，可以支持nicescroll
		if ($.browser.chrome) {
			// iframe的高度
			var ih = iframe.contentDocument.body.offsetHeight;

		}
		// 其他浏览器只好固定iframe高度了
		else {

		}

		if (iframe.Document) {//ie自有属性
			iframe.height = iframe.Document.body.scrollHeight;
		} else if (iframe.contentDocument) {//ie,firefox,chrome,opera,safari
			iframe.height = iframe.contentDocument.body.offsetHeight;
		}
	}
</script>

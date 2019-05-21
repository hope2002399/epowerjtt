<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<style type="text/css">
.search td {
	padding: 0px 10px 0px 10px;
}

#ui-datepicker-div {
	z-index: 25000 !important;
}
/*  .ui-datepicker-calendar {
	display: none;
}  */
</style>
<style>      
@media   print{    
    div.noprint{display:none;}  
}  
</style>


<script
	src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>





<body>

	<div class="search noprint">

		<s:form action="analysis" namespace="/analysis"
			style="margin-top:0;margin-bottom:5">

			<table cellpadding="0" cellspacing="0" align="center">

				<tr height="22">
					<td>选择时间：</td>
					<td>
						<%-- <sj:datepicker name="s_yearmonth" id="s_yearmonth"
							readonly="true" changeYear="true" changeMonth="true"
							value="%{#parameters['s_yearmonth']}" displayFormat="yy-mm-dd" /> --%>
						<input type="text" class="Wdate"
						style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;"
						value="${s_yearmonth}" name="s_yearmonth" id="s_yearmonth"
						onclick="WdatePicker({dateFmt:'yyyy-MM',maxDate:'%y-%M'})" placeholder="选择年、月"
						readonly>
					</td>

					<td align="center"><s:submit method="mainView"
							key="opt.btn.query" cssClass="btn" /><input type="button"
						class="btn btn-success btn-sm excel" value="打印"
						onclick="doprint();" /> <input type="button"
						class="btn btn-success btn-sm excel" value="生成word"
						onclick="doword(1);" /></td>

				</tr>




			</table>
		</s:form>
	</div>
	<!--startprint1-->
	<div class="container1" id="printcontainer">
		<h1 align="center">${year }年${month }月交通行政权力系统运行分析</h1>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<P>
			&nbsp;&nbsp;${year}年 ${month}月，全省交通行政权力事项${powerSum
			}项，实际运行${powerUseSum }项，实际运行率
			<c:if test="${powerUseSum ne '0' }">

				<fmt:formatNumber value="${powerUseSum /powerSum }"
					maxFractionDigits="2" minFractionDigits="2" type="percent" />
			</c:if>
			<c:if test="${powerUseSum eq '0' }">
				0% 
		</c:if>
			； 运行办件量为${applySum_N }件
			<c:if test="${applySum_N ne '0' && applySum_P ne '0' }">
				<c:if test="${applySum_N >= applySum_P }">
		，环比增加
		<fmt:formatNumber value="${(applySum_N-applySum_P) /applySum_P }"
						maxFractionDigits="2" minFractionDigits="2" type="percent" />
				</c:if>
				<c:if test="${applySum_N < applySum_P }">
				，环比下降
				<fmt:formatNumber value="${(applySum_P-applySum_N) /applySum_P }"
						maxFractionDigits="2" minFractionDigits="2" type="percent" />
				</c:if>
			</c:if>
			； 发生预报警${outWaySum_N }次
			<c:if test="${outWaySum_N ne '0' && outWaySum_P ne '0' }">
				<c:if test="${outWaySum_N >= outWaySum_P }">
		，环比增加
		<fmt:formatNumber value="${(outWaySum_N-outWaySum_P) /outWaySum_P }"
						maxFractionDigits="2" minFractionDigits="2" type="percent" />
				</c:if>
				<c:if test="${outWaySum_N < outWaySum_P }">
				，环比下降
				<fmt:formatNumber value="${(outWaySum_P-outWaySum_N) /outWaySum_P }"
						maxFractionDigits="2" minFractionDigits="2" type="percent" />
				</c:if>
			</c:if>
			； 发起督办${superviseSum_N }次
			<c:if test="${superviseSum_N ne '0' && superviseSum_P ne '0' }">
				<c:if test="${superviseSum_N >= superviseSum_P }">
		，环比增加
		<fmt:formatNumber
						value="${(superviseSum_N-superviseSum_P) /superviseSum_P }"
						maxFractionDigits="2" minFractionDigits="2" type="percent" />
				</c:if>
				<c:if test="${superviseSum_N < superviseSum_P }">
				，环比下降
				<fmt:formatNumber
						value="${(superviseSum_P-superviseSum_N) /superviseSum_P }"
						maxFractionDigits="2" minFractionDigits="2" type="percent" />
				</c:if>
			</c:if>
			； 系统接收办件${applySum_N }件。
		</P>
		<p>&nbsp;</p>
		<p>&nbsp;</p>

		<div class="box">
			<!-- 权力事项运行分析 -->
			<iframe
				src="${pageContext.request.contextPath}/analysis/analysis!powerView.do?year=${year}&month=${month}"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="96%" onload="autoHeight(this);" id="iframe1"></iframe>
		</div>

		<div class="box">
			<h2>&nbsp;&nbsp;二、电子监察运行分析</h2>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<!-- 预报警情况分析 -->
			<iframe
				src="${pageContext.request.contextPath}/analysis/analysis!outwayView.do?year=${year}&month=${month}"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="96%" onload="autoHeight(this);" id="iframe2"></iframe>

			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<!-- 督查督办情况分析 -->
			<iframe
				src="${pageContext.request.contextPath}/analysis/analysis!superviseView.do?year=${year}&month=${month}"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="96%" onload="autoHeight(this);" id="iframe3"></iframe>


		</div>

		<div class="box">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<!-- 数据交换运行情况 -->
			<iframe
				src="${pageContext.request.contextPath}/analysis/analysis!datachangeView.do?year=${year}&month=${month}"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="96%" onload="autoHeight(this);" id="iframe4"></iframe>


		</div>



		<div class="box">
			<p style="float: right;" align="right">统计时间：${nowDate }</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>

		<div class="box">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<!-- 附件 -->
			<p>附件：</p>
			<%-- <iframe
				src="${pageContext.request.contextPath}/analysis/analysis!attachView.do?year=${year}&month=${month}"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="60%" onload="autoHeight(this);" id="iframe5"></iframe>
 --%>
			
				<h3 align="center">交通行政权力运行办件量统计表（按权力）</h3>

				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<iframe
					src='${pageContext.request.contextPath}/stat/twodimenform!doStat.do?modelName=qlblqkfb_analysis&begDate=${yearmonthfirst}&endDate=${yearmonthlast}'
					border="0" frameBorder="no" marginWidth="0" scrolling="no"
					width="96%" onload="parent.autoHeight(this);" id="iframe5"></iframe>


			


		</div>

	</div>
	<!--endprint1-->


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

	function getIframeValue(ObjectID) {
		var IsIE = (navigator.appName == 'Microsoft Internet Explorer')
		if (IsIE) {//如果是IE          
			return document.frames(ObjectID).document.body.innerHTML;
		} else {//如果是FF
			return document.getElementById(ObjectID).contentDocument.body.innerHTML;
			//FF下不支持innerText; 下面是解决方法                      
			//if(document.all){
			//　　alert(document.getElementById('div1').innerText);
			//} else{
			//　 alert(document.getElementById('div1').textContent);
			//}
		}
	}

	function doword(oper) {

		bdhtml = window.document.body.innerHTML;//获取当前页的html代码 
		sprnstr = "<!--startprint" + oper + "-->";//设置打印开始区域 
		eprnstr = "<!--endprint" + oper + "-->";//设置打印结束区域 
		prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 18); //从开始代码向后取html 

		prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));//从结束代码向前取html 
		//alert(prnhtml);
		while (prnhtml.indexOf("<IFRAME") > 0) {
			prnhtml1 = prnhtml.substring(0, prnhtml.indexOf("<IFRAME"));
			prnhtml2 = prnhtml.substring(prnhtml.indexOf("<IFRAME"), prnhtml
					.indexOf("</IFRAME>"));
			prnhtml3 = prnhtml.substring(prnhtml.indexOf("</IFRAME>") + 9);
			idstr = prnhtml2.substring(prnhtml2.indexOf("id") + 3, prnhtml2
					.indexOf("id") + 10);
			//alert(idstr);
			prnhtml = prnhtml1 + getIframeValue(idstr) + prnhtml3;
		}
		startString = '<head>'
				+ ' <style type="text/css">'
				+ ' thead td,th{background-color:#2D80D2;color:white;border: 1px solid #CACACA;text-align:center;'
				+ ' cursor:pointer;font-size:12px;padding:5px;border-right: 1px solid #CACACA;line-height:16px;vertical-align: middle;}'
				+ 'table td {font-size:12px; padding:5px;border: 1px solid #CACACA;}'
				+ 'table#statTable td{border-right: 1px solid #CACACA;font-size:12px;line-height:16px;padding:5px;vertical-align: middle;}'
				+ 'table{border: 1px solid #CACACA;border-collapse: collapse;}'

				+ '</style>' + '<title>生成word预览</title></head><body>';
		endString = ''
				//+'<!--endprint-->'
				//+ ' 	<center><input type="button"  value="打印" onclick="previewprint();" /></center> '
				+ '<br><br> <center><input type="button"  value="确认生成" onclick="MakeWord2();" style="background-color:#2d80d2;color:white;filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=\'#54B1EB\',endColorstr=\'#3683D5\'); BORDER-LEFT: #015e91 1px solid; PADDING-BOTTOM: 0.45em; LINE-HEIGHT: 1em !important; PADDING-LEFT: 0.82em; PADDING-RIGHT: 0.82em; DISPLAY: inline-block; BACKGROUND: none transparent scroll repeat 0% 0%; COLOR: #fcf9f9; BORDER-TOP: #015e91 1px solid; CURSOR: pointer; BORDER-RIGHT: #015e91 1px solid; PADDING-TOP: 0.45em; border-radius: .3em; -moz-border-radius: .3em; -webkit-border-radius: .3em; box-shadow: 0 1px rgba(255,255,255,0.8), inset 0 1px rgba(255,255,255,0.35); -moz-box-shadow: 0 1px rgba(255,255,255,0.8), inset 0 1px rgba(255,255,255,0.35); -webkit-box-shadow: 0 1px rgba(255,255,255,0.8), inset 0 1px rgba(255,255,255,0.35); -moz-transition-property: color,-moz-box-shadow,text-shadow; -moz-transition-duration: .05s; -moz-transition-timing-function: ease-in-out; -webkit-transition-property: color,-webkit-box-shadow,text-shadow; -webkit-transition-duration: .05s; -webkit-transition-timing-function: ease-in-out;" /></center>'
				//+ '<script src="${pageContext.request.contextPath}/scripts/toword.js" ><\/script></body>';
				+ '<script>'
				+ 'function MakeWord2() {'
				+ 'var oWD = new ActiveXObject("Word.Application");'
				+ 'var oDC = oWD.Documents.Add("", 0, 1);'
				+ 'var oRange = oDC.Range(0, 1);'
				+ 'var sel = document.body.createTextRange();'
				+ 'sel.moveToElementText(printcontainer);'
				+ 'sel.select();'
				+ 'sel.execCommand("Copy");'
				+ 'oRange.Paste();'
				+ 'oWD.Application.Visible = true;'
				+ 'window.close(); '
				+ '}'
				//+ 'MakeWord2();'
				+'<\/script></body>';
		printwind = window.open("", "preview");
		printwind.document.write(startString + prnhtml+ endString);

		//printwind.MakeWord2();

		
	}
	function doprint() {
		
			PageSetup_Null();
			window.print();
		

	}
</script>
<script>
	var HKEY_Root, HKEY_Path, HKEY_Key;
	HKEY_Root = "HKEY_CURRENT_USER";
	HKEY_Path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	//设置网页打印的页眉页脚为空
	function PageSetup_Null() {
		try {
			var Wsh = new ActiveXObject("WScript.Shell");
			HKEY_Key = "header";
			Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");
			HKEY_Key = "footer";
			Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "&b页码,&p/&P&b");
		} catch (e) {

		}
	}
	//设置网页打印的页眉页脚为默认值
	/* 	function PageSetup_Default() {
	 try {
	 var Wsh = new ActiveXObject("WScript.Shell");
	 HKEY_Key = "header";
	 Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "&w&b页码,&p/&P");
	 HKEY_Key = "footer";
	 Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "&u&b&d");
	 } catch (e) {
	 }
	 } */
</script>

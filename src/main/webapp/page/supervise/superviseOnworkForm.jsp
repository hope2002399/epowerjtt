<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="superviseOnwork.edit.title" /></title>

<style>
#content,#intro {
	font: 13px/25px;
	width: 100%;
	height: 220px;
	background: #FFFFFF;
	padding: 10px;
	border: 0px #ccc double;
	border-bottom: 0;
	overflow: hidden;
}

#intro {
	color: #036;
	font: 12px;
	border: 0px #ccc double;
	border-top: 0;
	height: 70px;
}

#key {
	color: #900;
	float: right
}

hr {
	height: 1px;
	border: 1px #ccc dotted
}
</style>



</head>

<body>
	<p class="ctitle">督办结论</p>

	<%@ include file="/page/common/messages.jsp"%>

	<s:form action="superviseOnwork" method="post" namespace="/supervise"
		id="superviseOnworkForm" onsubmit="return doCheck();">
		<s:submit name="save" method="saveResult" cssClass="btn" key="opt.btn.submit"/>
		<input type="button" name="back" value="返回" Class="btn" onclick="window.history.back()" />
		<input type="hidden" id="superviseNo" name="superviseNo" value="${object.superviseNo}"/>
		<div id="content">
			<iframe id="viewFrame" name="viewFrame"
				src="<%=request.getContextPath()%>/supervise/superviseBasic!viewFrame.do?superviseNo=${object.superviseNo}"
				width="100%" style="margin-bottom: 10px;" frameborder="no"
				scrolling="false" border="0" marginwidth="0"
				onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>


			<iframe id="processFrame1" name="processFrame1"
				src="<%=request.getContextPath()%>/supervise/superviseOnwork!view.do?superviseNo=${object.superviseNo}"
				width="100%" style="margin-bottom: 10px;" frameborder="no"
				scrolling="false" border="0" marginwidth="0"
				onload="this.height=window.frames['processFrame1'].document.body.scrollHeight"></iframe>
		</div>
		<span id="key" onclick="shoppingcat();">展开▼</span>

		<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>督办结论</b>
			</legend>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable"> 
				<tr>
												
				<td class="addTd">是否客观&nbsp;&nbsp;&nbsp;<td><select name="isExternal">
				
				<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('isExternal')}">
								<option  value="${row.key}" label="${row.value}">
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd">
						督办结论<span style="color: red">*</span>
					</td>
					<td align="left">
  
						<s:textarea name="superviseResult" id="superviseResult" cols="40" rows="2"/>	
					</td>
				</tr>
				<tr>
					<td class="addTd">
						办理意见
					</td>
					<td align="left">
  
						<s:textarea name="endOpinion" id="endOpinion" cols="40" rows="2"/>
	
	
					</td>
				</tr>				
</table></fieldset>
		
		</s:form>
		
		</body>
		<script type="text/javascript">
		function doCheck(){
			if($('#superviseResult').val()==''){
				alert("督办结论不可为空");
				$('#superviseResult').focus();
				return false;		
			}
			if($('#endOpinion').val()==''){
				alert("办理意见不可为空");
				$('#endOpinion').focus();
				return false;		
			}
			return true;
		}
		</script>
		
		<script type="text/javascript">
			var s = 5;
			var minheight = 220;		
			var maxheight; 			
			function shoppingcat() {
				maxheight=parseInt($('#viewFrame')[0].height)+parseInt($('#processFrame1')[0].height)+25; 
				var key = document.getElementById("key").innerText;
				if (key == "展开▼") {
					content.style.pixelHeight += s;
					if (content.style.pixelHeight < maxheight) {
						setTimeout("shoppingcat();", 1);
					} else {
						document.getElementById("key").innerText = "收起 ▲";
					}
				} else {
					content.style.pixelHeight -= s;
					if (content.style.pixelHeight > minheight) {
						setTimeout("shoppingcat();", 1);
					} else {
						document.getElementById("key").innerText = "展开▼";
					}
				}
			}
		</script>
		
		</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<style type="text/css">
.viewTable {
	color: #000;
}

.viewTable th {
	text-align: left;
	text-indent: 10px;
	border: 1px solid #cdcdcd;
	height: 30px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/ajaxfileupload.js"></script>
</head>
<body style="padding-left: 5px; width: 98%;">
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend style="padding: 4px 8px 3px;">
			<b>材料上传</b>
		</legend>
		<s:form action="generalOperator!saveCFStuff.do" method="POST"
			enctype="multipart/form-data" name="form1" target="">
			<s:hidden id="isAllsc" value="%{isAllsc}"></s:hidden>
			<s:hidden name="stuffInfo.djId" value="%{stuffInfo.djId}"></s:hidden>
			<s:hidden name="stuffInfo.nodeInstId" value="%{stuffInfo.nodeInstId}"></s:hidden>
			<s:hidden id="stuffname" name="stuffInfo.stuffname"></s:hidden>
			<s:hidden id="sortId" name="stuffInfo.sortId"></s:hidden>
			<s:hidden id="groupid" name="stuffInfo.groupid"
				value="%{suppowerstuffinfo.groupId}" />
			<table border="0" class="viewTable">
				<tr>
					<th>材料名称</th>
					<th width="70" align="center">是否纸质</th>
					<th width="70" align="center">是否必须</th>
					<th width="250">已上传文件</th>
					<th>文件上传</th>
				</tr>
				<c:if test="${ empty suppowerstuffinfos }">
					<tr>
						<td align="center" colspan=5>没有上传材料</td>
					</tr>
				</c:if>
				<c:if test="${ not(empty suppowerstuffinfos) }">
					<c:forEach var="obj" items="${suppowerstuffinfos}">
						<tr>
							<td>${obj.stuffName}</td>
							<td align="center"><input type="checkbox"
								id="check_${obj.sortId}" target="${obj.stuffName}"
								iszhiname="stuffInfo.iszhi" class="${obj.sortId}" value="1"></input></td>
							<td align="center"><c:if test="${obj.isNeed == '1'}">
									<p style="color: red">是</p>
								</c:if> <c:if test="${obj.isNeed == '0'}">
									<p style="color: red">否</p>
								</c:if></td>
							<td class="stuffName_${obj.sortId}" width="250"><c:if
									test="${VOpt != null}">
									<c:forEach var="info" items="${VOpt}">
										<c:if test="${info.sortId == obj.sortId}">
											<c:if test="${info.iszhi == '1'}">
												<a style="text-decoration: none; color: blue;"
													href="javascript:void(0);"
													onclick="downloadfile('${info.stuffid}','1');">${info.filename}</a>
												<script type="text/javascript">
													var sid = '${obj.sortId}';
													$(".${obj.sortId}").attr("checked","checked");
												</script>
											</c:if>
											<c:if test="${info.iszhi!= '1'}">
												<a style="text-decoration: none; color: blue;"
													href="javascript:void(0);"
													onclick="downloadfile('${info.stuffid}','0');">${info.filename}</a>
												<a href="javascript:void(0);"
													onclick="deleteStuff('${info.stuffid}','${obj.sortId}')">删除</a>
												<br> <script type="text/javascript">
													var sid = '${obj.sortId}';
													$(".${obj.sortId}").attr(
															"disabled",
															"disabled");
												</script>
											</c:if>
										</c:if>
									</c:forEach>
								</c:if></td>
							<td width="50px"><div id="div_${obj.sortId}">
									<input type="file" id="file_${obj.sortId}" name="stuffFile"></input>
								</div></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</s:form>
	</fieldset>
</body>
<script type="text/javascript">
$(document).ready(function(){
	<c:if test="${not (empty suppowerstuffinfos) }">
	  <c:forEach var="obj" items="${suppowerstuffinfos}">
	  $("#check_${obj.sortId}").click(function(){
		  if($("#check_${obj.sortId}").attr('checked')==undefined){
			  $("#check_${obj.sortId}").attr("checked", "checked");
			  $.getJSON("${pageContext.request.contextPath}/powerruntime/generalOperator!deleteStuffInfoByAjax.do?callback=?",
					  {djId:'${stuffInfo.djId}',sortId:'${obj.sortId}',stuffid :''},
				  function(json) {
						  if(json.result=='OK'){
							  $("#file_${obj.sortId}").attr("disabled", "");
							  $(".stuffName_${obj.sortId}").empty();
							  $("#check_${obj.sortId}").attr("checked", "");
							  checkiaAllsc();
						  }
				  });
		  }else{
			  $("#check_${obj.sortId}").attr("checked", "");
			  $.getJSON("${pageContext.request.contextPath}/powerruntime/generalOperator!AddStuffinfoByAjax.do?stuffname="+encodeURI(encodeURI("${obj.stuffName}"))+"&callback=?",
					  {nodeInstId:'${stuffInfo.nodeInstId}',iszhi:'1',djId:'${stuffInfo.djId}',sortId:'${obj.sortId}',groupid:$("#groupid").val()},
				  function(json) {
						  if(json.result=='OK'){
							  var suffid = json.suffid;
							  $("#file_${obj.sortId}").attr("disabled", "disabled");
							  $(".stuffName_${obj.sortId}").html('<a style=\"text-decoration: none; color: blue;\" href=\"javascript:void(0);\" onclick=\"downloadfile(\''+suffid+'\',\'1\');\">纸质材料<\/a>');
							  $("#check_${obj.sortId}").attr("checked", "checked");
							  checkiaAllsc();
						  }
				  });
		  }
		  
	   });
	   $("#file_${obj.sortId}").live('change', function(){
		   var filename = getFileName($("#file_${obj.sortId}").val());
		   var urls = "${pageContext.request.contextPath}/powerruntime/generalOperator!AddStuffinfoByAjax.do?nodeInstId=${stuffInfo.nodeInstId}&iszhi=&djId=${stuffInfo.djId}&sortId=${obj.sortId}&groupid="+$("#groupid").val()+"&filename="+encodeURI(encodeURI(filename))+"&stuffname="+encodeURI(encodeURI("${obj.stuffName}"));
		   $.ajaxFileUpload({
			   url: urls,            //需要链接到服务器地址
			   secureuri:false,
			   fileElementId:'file_${obj.sortId}',                        //文件选择框的id属性
			   dataType: 'json',                                     //服务器返回的格式，可以是json
			   success: function (data, status){           //相当于java中try语句块的用法
				   if(data.result=="OK"){
					   var suffid = data.suffid;
					   var html = "<a style=\"text-decoration: none; color: blue;\" href=\"javascript:void(0);\" onclick=\"downloadfile(\'"+data.suffid+"\',\'0\');\">"+filename+"<\/a>   <a href=\"javascript:void(0);\" onclick=\"deleteStuff(\'"+suffid+"\',\'${obj.sortId}\')\">删除<\/a>";
					   $("#check_${obj.sortId}").attr("disabled", "disabled");
					   var tdText = $(".stuffName_${obj.sortId}").text();
					   if(tdText==""){
						   $(".stuffName_${obj.sortId}").html(html);
					   }else{
						   $(".stuffName_${obj.sortId}").append("<p>"+html);
					   }
					   initHight();
					   checkiaAllsc();
				   }
			   },
			   error: function (data, status, e){            //相当于java中catch语句块的用法
				   alert("加载失败!原因"+e);
			   }
		   });
	   });	  
	  </c:forEach>
	</c:if>
	var isAllsc = $("#isAllsc").val();
	var bt1 = window.parent.parent.document.getElementById('saveAndSubmit');
	var bt2 = window.parent.document.getElementById('saveAndSubmit');
	if (isAllsc == "0") {
		if (bt1 != null){
			bt1.disabled = "true";
		}
		else {
			bt2.disabled = "true";
		}
	}
	if (isAllsc == "1") {
		if (bt1 != null)
			bt1.disabled = undefined;
		else {
			bt2.disabled = undefined;
		}
	}
});
function getFileName(o){
	var pos=o.lastIndexOf("\\");
		    return o.substring(pos+1);  

}
function downloadfile(stuffid,iszhi){
	if("1"==iszhi){
		alert("纸质文件");
		return false;
	}else{
		window.location.href ="${pageContext.request.contextPath}/powerruntime/generalOperator!downStuffInfo.do?stuffid="+stuffid;
	}
}
function deleteStuff(stuffid,sortId){
	$.getJSON("${pageContext.request.contextPath}/powerruntime/generalOperator!deleteStuffInfoByAjax.do?callback=?",
			{djId:'${stuffInfo.djId}',sortId:'',stuffid :stuffid},
		function(json) {
				if(json.result=='OK'){
					if(json.suffid ==""){
						$(".stuffName_"+sortId).empty();
						$("#check_"+sortId).attr("disabled", "");
					}else{
						var suffids = json.suffid;
						var suffnames = json.suffname;
						if(suffids.indexOf(",")<=0){
							var html = "<a style=\"text-decoration: none; color: blue;\" href=\"javascript:void(0);\" onclick=\"downloadfile(\'"+suffids+"\',\'0\');\">"+suffnames+"<\/a>   <a href=\"javascript:void(0);\" onclick=\"deleteStuff(\'"+suffids+"\',\'"+sortId+"\')\">删除<\/a>";
							$(".stuffName_"+sortId).html(html);
						}else{
							for(var i = 0;i<suffids.split(",").length;i++){
								var id = suffids.split(",")[i];
								var name = suffnames.split(",")[i];
								var html = "<a style=\"text-decoration: none; color: blue;\" href=\"javascript:void(0);\" onclick=\"downloadfile(\'"+id+"\',\'0\');\">"+name+"<\/a>   <a href=\"javascript:void(0);\" onclick=\"deleteStuff(\'"+id+"\',\'"+sortId+"\')\">删除<\/a>";
								if(i==0){
	    							$(".stuffName_"+sortId).html(html);
								}else{
									$(".stuffName_"+sortId).append("<p>"+html);
								}
							}
						}
					}
					initHight();
					checkiaAllsc();
				}
		});
}
function initHight(){
	window.resizeTo($(document).width(), $(document).height());
	parent.window.resizeTo($(parent.document).width(), $(parent.document).height());
}
function checkiaAllsc(){
	 var isAllsc = "1";
	 <c:forEach var="obj" items="${suppowerstuffinfos}">
	    <c:if test="${obj.isNeed == '1'}">
	       var text=$(".stuffName_${obj.sortId}").text();
	       if(text == ""){
	    	   isAllsc = "0";
	       }
	    </c:if>
	 </c:forEach>
	 var bt1 = window.parent.parent.document.getElementById('saveAndSubmit');
	 var bt2 = window.parent.document.getElementById('saveAndSubmit');
     if (isAllsc == "0") {
	    if (bt1 != null){
			bt1.disabled = "true";
	    }else {
			bt2.disabled = "true";
		}
	 }
	 if (isAllsc == "1") {
        if (bt1 != null)
			bt1.disabled = undefined;
		else {
			bt2.disabled = undefined;
		}
	}
}
</script>
</html>

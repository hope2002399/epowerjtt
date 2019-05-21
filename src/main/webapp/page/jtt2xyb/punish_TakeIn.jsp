<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
		<title>
		导入处罚文件
		</title>
		<sj:head locale="zh_CN" />
		<script
		src="${pageContext.request.contextPath}/scripts/jquery-1.8.3.min.js"
		type="text/javascript"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-1.6.min.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/scripts/Calendar/calendar.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/scripts/easyui/jquery.easyui.min.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery.form.js"/>"></script>
		<link type="text/css" href="<s:url value='/scripts/Calendar/css/calendar.css'/>" rel="stylesheet"/>
		<link type="text/css" href="<s:url value='/scripts/easyui/themes/default/easyui.css'/>" rel="stylesheet"/>
</head>
<body style="width: 99%;" marginwidth="0" marginheight="0" >
	<div class="container" style="padding-top: 5px;padding-left: 5px;">
	<div class="search stat">
		<div class="crumbs">导入处罚文件</div>
	</div>
<div>
	<s:form action="/sys/importdata.do" namespace="/" id="form1" method="post"  enctype="multipart/form-data" >
		<div align="center">
			<hr>
			<br>
			<div style="margin-top: 30px;">
				<label style="  margin-left: -296px;font-size: 21px;">导入文件：</label>
				<input  style="    width: 200px; margin-left: 14px;" id="myfiles"  type="file" name="myfiles" onchange="upattachValue()"/>
			 	<input id="upload" type="button" style="height: 25px;width:45px;background-color: #e8e8e8;" value="导入" onclick="return ajaxFileUpload()"/> 
			</div>
			<div style="margin-top: 50px;position: relative;">
				<label style="    margin-left: -8.9%;  text-align: center; position: absolute;font-size: 21px;">导入日志：</label>
				<textarea rows="8" id="message" style="width: 450px;height: 150px;margin-left: 2%;" cols="80"></textarea>
			</div>
			
			<div style="padding-top: 40px;color: red;margin-left: -8%;  font-size: 21px;">
			 	示例模板：<a style="    font-size: 21px;"  href="${pageContext.request.contextPath}/UploadFile/CF_Template.xls"  >处罚模板下载</a>
			</div>
		</div>
	</s:form>
</div>
</div>
</body>
<script type="text/javascript" >
function upattachValue(){
	var fileName = 	$("#myfiles").val();
	var index = fileName.lastIndexOf('\\');
	fileName = fileName.substring(index+1,fileName.length);
	$("#attach").val(fileName);
}
function ajaxFileUpload(){
	debugger;
	var filename = $("#myfiles").val();
	var _id = $("#upload");
	_id.attr("disabled","disabled");
	var type = "";
	if(filename ==""){  
		_id.removeAttr("disabled");
        alert("附件不能为空");  
        return false;  
    } else{
    	type = filename.lastIndexOf('.');
    	var str = filename.substring(type+1,filename.length);
    	if(str != 'xls' && str != 'xlsx' ){
    		_id.removeAttr("disabled");
    	alert("错误:不支持"+str+"文件");
    		return false;
    	}    
    }
	
	var ajax_option = {
			data : {
				fileType_takeIn : "CF"
			},
			success:function(res){
				debugger;
				_id.removeAttr("disabled");
				if(null != res && "" !=res){
					var errorMsg = "导入错误!-----";
					var length = res.length;
					var index = res.indexOf("#")+1;
					var error_index = index-1;
					if("error_msg_1" == res){//不是指定的模板文件     
						alert(errorMsg+"上传的文件不是指定的模板文件!");
					}else if("success_msg" == res){//成功返回
						alert("导入成功!");
					}else{
						var error_msg_index = res.substring(0,error_index);
						var error_msg = errorMsg+res.substring(index,length);
						if("error_msg_2" == error_msg_index){//excel文件导入了系统已有的记录
							alert(error_msg);
						}else if("error_msg_3" == error_msg_index){//excel中必填字段空缺
								alert(error_msg);
						}else if("error_msg_4" == error_msg_index){//excel文件大小为0
								alert(error_msg);
						}else if("error_msg_5" == error_msg_index){//excel中没有数据
								alert(error_msg);
						}else if("error_msg_6" == error_msg_index){//导入文件中有重复字段
							    alert(error_msg);
						}else if("error_msg_7" == error_msg_index){//session过期
							    alert(error_msg);
						}else if("error_msg_8" == error_msg_index){//其他异常
							    alert(error_msg);
						}else{
							$("#message").val(res);
						}
					}
				}
			}
	};
	$("#form1").ajaxSubmit(ajax_option);
}

</script>
</html>
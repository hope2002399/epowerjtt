<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<% String path = request.getContextPath();
	System.out.print(path); %>
<html>
<head>
<title>选择条件</title>

<script language="javascript" src="../../scripts/jquery-1.6.min.js" ></script>
<link href="../../styles/gray/css/dtree.css" type="text/css" rel="stylesheet">
<script language="javascript" src="../../scripts/dtree.js" ></script>
<link href="css/cond.css" type="text/css" rel="stylesheet">
<sj:head/>
<script type="text/javascript">
//名称:createProcTypeOption
//说明:ajax与后台交互取数据
//参数:无
//作者:xc
//时间:2011-11-9
var Data;

//alert(flowCode);
var argsDoc = window.dialogArguments; 

	//var m=jQuery.parseJSON('{"a":"金额","b":"申请人"}');
	var n=jQuery.parseJSON('{"ave(...)":"求均值  ave (1,2,3)=2","byte( , ,)":"求位值  byte (4321.789,2)=2 "}');
	$(document).ready(function(){
		//var params={'datacode':"$("")"};
		$.ajax({
			type:"POST",
			url:"<%=path%>/sampleflow/sampleFlowDefine!getVar.do?optId=<%=request.getParameter("optid")%>",
			//data:params,
			dataType:"json",
			async: false,
			success:function(data){	
				//alert(data);
				Data=jQuery.parseJSON(data);
			
			},
			error:function(){
				alert("失败");
			}			
		});	
	for(var k in Data)
		{
		$("#bl").append("<tr><td width='100px' ><a href=\"javascript:addbl(\'"+k+"\');\" >"+k+"</a></td><td width='150px'>"+Data[k]+"</td></tr>");
		}
	for(var k in n)
	{
	//alert(k);
	$("#method").append("<tr><td width='100px' ><a href=\"javascript:addbl(\'"+k+"\');\" >"+k+"</a></td><td width='200px'>"+n[k]+"</td></tr>");
	}
	//父页面对象
	$("#cond").attr("value",argsDoc);
	});
	function addbl(bl)
	{
		document.getElementById("cond").value +=bl;
		//$("#cond").append("<div>"+bl+"</div>");
	}
	function addcond(){
		var mycond=$("#cond").attr("value");
		parent.window.returnValue={cond:mycond};
		window.close();
	}
	
</script>
<style type="text/css"> 
th { 
font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
color: #4f6b72; 
border-right: 1px solid #C1DAD7; 
border-bottom: 1px solid #C1DAD7; 
border-top: 1px solid #C1DAD7; 
letter-spacing: 2px; 
text-transform: uppercase; 
text-align: left; 
padding: 6px 6px 6px 12px; 
background: #CAE8EA  no-repeat; 
} 

</style>
</head>
<body style="background-color: #FFFFF3">
 <div id="midbody" >
       <div id="leftside" >
       
       		<fieldset >
       		<legend>业务变量</legend>
       		<div style="overflow: auto;">
       			<table id="bl" border="0" style="border-collapse:collapse;">
       			<tr>
       			<th width='120px'>变量代码</th>
       			<th width='150px'>变量描述</th>
       			</tr>	       			
       			</table>
       			</div>
       		</fieldset>
       </div>
       <div id="rightside">
       		<fieldset>
       		<legend>业务方法</legend>
       		<sj:tabbedpanel id="localtabs"  >
       		 	<sj:tab id="tab1" target="tone" label="数值方法"/>
       		 	<sj:tab id="tab2" target="ttwo" label="字符串方法"/>
       		 	<sj:tab id="tab3" target="tthree" label="其他"/>
       			<div  id ="tone" style="overflow: auto;">
       			<table id="method" border="0">
       				<tr>
       				<th width='100px'>方法名称</th>
       				<th width='200px'>变量描述</th>
       				</tr>	
       			</table>
       			</div>
       			<div id="ttwo"></div>
       			<div id="tthree"></div>
       		</sj:tabbedpanel>
      	</fieldset>
       </div>
       </div>
       <div id="foot">
       		<fieldset>
       		<legend>条件</legend>
       		<table><tr><td>
       		<textarea  rows="4" cols="70" id="cond" ></textarea></td></tr>
       		<tr><td align="right"><button  onclick="addcond()">保存</button></td></tr>
       		</table>
  			</fieldset>     
       </div>
   
</body>
</html>
<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/" ;

%>

    <c:if test="${empty STYLE_PATH}">
        <c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>
        <c:set var="STYLE_PATH" value="${ctx}/styles/default" scope="session"/>
    </c:if>
<style type="text/css">
<!--
body {
	background-image: url(images/hdj/loginbg.jpg);
	background-color: #0549aa;
	background-repeat:repeat-x;
}
td{
	font-size:12px;
	color:#333;
	font-family:Verdana, Arial, Helvetica, sans-serif;
}
input {
	height:20px;
	border:1px solid #ccc; 
	background-image:url(images/hdj/inputbg.jpg);
}
.bg {
	background-repeat:no-repeat;
	background-position:center middle;
	padding-bottom:5px;
}
-->
</style>
<script type="text/javascript" language="javascript" src="<%=basePath%>scripts/jquery-1.6.min.js"></script>
    <script src="<%=basePath%>scripts/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>

    <script src="<%=basePath%>scripts/global.js" type="text/javascript" language="javascript"></script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="/j_spring_security_check" method="post" focus="loginName">
<html:hidden property="action" />
<table width="1000"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="<%=basePath%>images/hdj/login7_01.jpg" width="1000" height="158" alt=""></td>
  </tr>
  <tr>
    <td><img src="<%=basePath%>images/hdj/login7_02.jpg" width="1000" height="263" alt=""></td>
  </tr>
  <tr>
  <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="280"><img src="<%=basePath%>images/hdj/login7_03.jpg" width="280" height="29" alt=""></td>
        <td background="<%=basePath%>images/hdj/login6_04.jpg"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <thead>
          	<tr>
          		<td width="40%"></td>
          		<td width="40%"></td>
          		<td width="20%"></td>
          	</tr>
          </thead>
          <tr>
            <td align="right" background="<%=basePath%>images/hdj/login6_04.jpg">用户名&nbsp;&nbsp;<input type="text" id="username" name="j_username" value="${SPRING_SECURITY_LAST_USERNAME}" style="width:100px">&nbsp;&nbsp;</td>
            <td height="24" align="center" >密码&nbsp;&nbsp;<input type="password" name="j_password" id="password"  style="width:100px"  /></td>
            <td align="center" ><input type="submit" class="btn" name="login" value="登录" ></td>
          </tr>
        </table></td>
        <td width="247"><img src="<%=basePath%>images/hdj/login7_06.jpg" width="247" height="29" alt=""></td>
      </tr>
    </table></td>
  </tr>

	<tr>
    <td><img src="<%=basePath%>images/hdj/login7_17.jpg" width="1000" height="135" alt="" border="0" usemap="#Map"></td>
  </tr>
</table>
</s:form>
</body>

<script language="JavaScript" >
$(document).ready(function() {
    $("#loginForm").validate({
       // errorLabelContainer: "#messageBox",      wrapper: "li",
        rules: {
            j_username: "required",
            j_password: "required"},
        messages: {
            j_username: "请输入用户名",
            j_password: "请输入密码"} ,
        showErrors: function(errorMap, errorList) {
            var errorTips = $('div');
            var info='';
            $.each(errorList,function(i,e){
                   info += e?'<li>'+e.message+'</li>':'';
            });
            errorTips.html(info);
            var screenWidth = $(document).width();
            errorTips.css({'position':'absolute','left':screenWidth/2-200,'top':'0px','width':'400px','background':'#ffffcc','font-size':'10pt'});
           errorTips.appendTo('body');
            (errorList.length==0)?errorTips.hide():errorTips.show();
        },
        success: function(label) {
            //alert("提交成功");
        }
    });
});

function submit(event) {
	
};

</script>
</html>
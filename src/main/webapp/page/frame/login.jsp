<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${cp:MAPVALUE('SYSPARAM','SysName')}" /></title>
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
	background-image: url(images/loginbg.jpg);
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
	background-image:url(images/inputbg.jpg);
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
<s:form action="/j_spring_security_check" method="post" focusElement="loginName"  cssClass="pageForm required-validate">
<html:hidden property="action" />
<%@ include file="/page/common/messages.jsp"%>
<!--<input type="hidden" name="sysType" value="${superFunctionId}" />
--><table width="1000"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
   <%--  <td><img src="<%=basePath%>images/login7_01.jpg" width="1000" height="158" alt=""></td> --%>
 	<td><img src="<%=basePath%>images/login7_01new.png" width="1000" height="158" alt=""></td>
  </tr>
  <tr>
    <td><img src="<%=basePath%>images/login7_02.jpg" width="1000" height="263" alt=""></td>
  </tr>
  <tr>
  <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="280"><img src="<%=basePath%>images/login7_03.jpg" width="280" height="29" alt=""></td>
        <td background="<%=basePath%>images/login6_04.jpg"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <thead>
          	<tr>
          		<td width="25%"></td>
          		<td width="23%"></td>
          		<td width="23%"></td>
          		<td width="20%"></td>
          		<td width="10%"></td>
          	</tr>
          </thead>
          <tr>
            <td align="right" background="<%=basePath%>images/login6_04.jpg">用户名&nbsp;&nbsp;<input type="text" id="username" name="j_username" nValidate="{required:true}" value="${sessionScope.name}" style="width:60px">&nbsp;&nbsp;</td>
            <td height="24" align="center" >密码&nbsp;&nbsp;<input type="password" name="j_password" id="password" value="${sessionScope.pwd}" nValidate="{required:true}" style="width:60px"  /></td>
            <td height="24" align="center" >验证码&nbsp;&nbsp;<input type="text" name="captcha" id="captcha" nValidate="{required:true}" style="width:60px"  /><input type="hidden" id="isCaptcha" value="1" name="isCaptcha"></td>
            <td height="24" align="center" > <img border="0" src="<%=basePath%>page/frame/captcha.jsp" onclick="this.src='<%=basePath%>page/frame/captcha.jsp?'+new Date().getTime()"/> 
            </td>
            <td align="center" ><input type="submit" class="btn" name="login" value="登录" ></td>
          </tr>
        </table></td>
        <td width="247"><img src="<%=basePath%>images/login7_06.jpg" width="247" height="29" alt=""></td>
      </tr>
    </table></td>
  </tr>

	<tr>
    <td><img src="<%=basePath%>images/login7_17.jpg" width="1000" height="135" alt="" border="0" usemap="#Map"></td>
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
            j_password: "required",
            captcha: "required"},
        messages: {
            j_username: "请输入用户名",
            j_password: "请输入密码",
            captcha: "请输入验证码"} ,
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
$(function(){
	$("#login").validate();
	
}

function submit(event) {
	
};

</script>
</html>
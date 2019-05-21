<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<div class="pageContent">

	<s:form id="form1" action="userDef!modifypwd.do" namespace="/sys"
		cssClass="pageForm required-validate">
		<div class="pageFormContent" layoutH="58">

			
			<div class="unit">
				<label>用户名</label>
				<authz:authentication property="name" />
			</div>

			<div class="unit">
				<label>旧密码<font color="red">*</font></label> <input type="password"
					name="userPwd.oldPassword" minlength="6" maxlength="20"
					alt="字母、数字、下划线、特殊字符 6-20位" class="required">
			</div>

			<div class="unit">
				<label>新密码<font color="red">*</font></label> <input type="password" id="cp_newPassword"
					name="userPwd.newPassword" minlength="6" maxlength="20" class="required "
					alt="字母、数字、下划线 、特殊字符 6-20位" ><font color="red">必须包含数字和字母，可以有特殊字符</font>
			</div>

			<div class="unit">
				<label>确认新密码<font color="red">*</font></label> <input type="password"
					equalTo="#cp_newPassword" name="userPwd.confirmPassword"
					minlength="6" maxlength="20" class="required"><font color="red">必须包含数字和字母，可以有特殊字符</font>
			</div>

		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" onclick="return yzmm();">提交</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</s:form>
	<script type="text/javascript">
	function yzmm(){
		npwd=$("#cp_newPassword").val();
	 	//var pa=/^(?=.{6,16}$)(?![0-9]+$)(?!.*(.).*\1)[0-9a-zA-Z#@]+$/; 
	 	var pa=/(?=^.{6,20}$)(?![0-9]+$)(?![a-zA-Z]+$)[0-9a-zA-Z#@~%&!$%^*|?()]+$/; 

	if(npwd.match(pa)){
			return true;
		}else{
			alert("新密码必须包含数字和字母,也可以有特殊字符");
			return false;
		}  
/* 		var npwd=$("#cp_newPassword").val();
		var regu = /\w*[0-9]+\w*$/;;  
        var regu2 = /\w*[a-zA-Z]+\w*$/; 
        if (!regu.test(npwd)||!regu2.test(npwd)) {  
        	alert("新密码必须包含数字和字母");
        	        return false;  
        }else{
        	return true;
        }  */
		return false;
	}
	</script>
</div>

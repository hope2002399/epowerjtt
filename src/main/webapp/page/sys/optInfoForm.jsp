<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
	<head><meta name="decorator" content='${LAYOUT}'/>
		<title>业务模块编辑</title>
		<s:include value="/page/common/formValidator.jsp"></s:include>
		
		
		<script type="text/javascript">
			$(document).ready(function(){
			
				$.formValidator.initConfig({formid:"form1",
				onerror:function(msg,obj,errorlist){
					alert(msg);
				}
				});
				$("#optid").formValidator().inputValidator({min:1,max:20,onerror:"业务代码请输入1到20个字符"})
				.regexValidator({regexp:"username",datatype:"enum",onerror:"输入字母或者数字"});
				$("#optname").formValidator().inputValidator({min:1,max:50,onerror:"输入1到50个字符"})
				;
			
			});
			function changetype(){
				var opttype=$("#opttypeW").attr("checked");
				if(opttype=="checked")
					{
					$("#wfcode").show();
					}
				else
					{
					$("#wfcode").hide();
					}
			} 
		</script>	

	</head>

	<body>
		<p class="ctitle">
			业务模块编辑
		</p>
	
		<s:form action="optInfo!save.do" namespace="/sys" id="form1" >
			<s:submit name="save" cssClass="btn" value="保存" />
			<s:hidden property="roid" />
			<input type="button" value="返回" class="btn" onclick="window.history.back()" />

			<table cellpadding="1" cellspacing="1" align="center">

				<tr>
					<td class="TDTITLE">
						业务代码
					</td>
					<td align="left">
					<c:if test="${not empty optid }">
						<s:textfield name="optid" readonly="true"  /></c:if>
					<c:if test="${ empty optid }">
						<s:textfield name="optid" id="optid" /></c:if>
						<span id="optidTip"></span>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						父类业务代码
					</td>
					<td align="left">
						<s:textfield name="preoptid"  />
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						业务名称
					</td>
					<td align="left">
						<s:textfield name="optname" id="optname" rows="1" cols="40" />
						<span id="optnameTip"></span>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						业务类别
					</td>
					<td align="left">
						<s:radio  id="opttype"   name="opttype" onclick="changetype();" list="#{'M':'系统管理','S':'系统业务','N':'普通业务','W':'流程业务','E':'外部业务','H':'首页面模块','T':'统计模块'}"></s:radio>						
					</td>
				</tr>	
				<tr>
					<td class="TDTITLE">
						业务URL
					</td>
					<td align="left">
						<s:textfield name="opturl" id="opturl" size="50" />
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						是否放在菜单栏
					</td>
					<td align="left">
						<s:radio name="isintoolbar" list="#{'Y':'是','N':'否'}" ></s:radio>
						
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						打开方式
					</td>
					<td align="left">
						<s:radio name="pageType" list="#{'D':'Div','F':'iframe'}"></s:radio>						
					</td>
				</tr>		
				
				<tr>
					<td class="TDTITLE">
						业务排序号
					</td>
					<td align="left">
						<s:textfield name="orderind" rows="1" cols="40" />
					</td>
				</tr>
				<c:if test="${opttype=='W'}">
				<tr id="wfcode" >
					<td class="TDTITLE">
						流程代码
					</td>
					<td align="left">
						<s:textfield name="wfcode" rows="1" cols="40" />
					</td>
				</tr>
				</c:if>	
				<c:if test="${opttype!='W'}">
				<tr id="wfcode" style="display: none">
					<td class="TDTITLE">
						流程代码
					</td>
					<td align="left">
						<s:textfield name="wfcode" rows="1" cols="40" />
					</td>
				</tr>
				</c:if>
													
			</table>
		</s:form>
	
	</body>
</html>

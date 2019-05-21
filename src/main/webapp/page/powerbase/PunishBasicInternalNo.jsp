<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>权力编码详细信息</title>
</head>
<body>
<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="基本信息" />
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">

			<tr>
				<td class="addTd">案件编号</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd">权力编码</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >权力名称</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >主办部门</td>
				<td></td>
				<td class="addTd" >业务处室</td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd" >处罚名称 </td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >案件来源</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >确认事实</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd">案发时间 </td>
				<td></td>
				<td class="addTd">案发地点</td>
				<td><td>
			</tr>
			<tr>
				<td class="addTd">登记时间</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd">处罚当事人</td>
				<td></td>
				<td class="addTd">当事人类型 </td>
				<td></td>	
			</tr>
			<tr>
				<td class="addTd">当事人证件名称 <td>
				<td></td>
				<td class="addTd">当事人证件号码 </td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd">当事人联系电话 </td>
				<td></td>
				<td class="addTd">当事人联系手机    </td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd">当事人电子邮箱</td>
				<td ></td>
				<td class="addTd">当事人地址</td>
				<td ></td>
			</tr>
			<tr>
				<td class="addTd">当事人邮编</td>
				<td ></td>
				<td class="addTd">承诺期限</td>
				<td ></td>
			</tr>
			<tr>
				<td class="addTd">来源系统 </td>
				<td ></td>
			</tr>
		</table>
<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="过程信息" />
		</legend>
<s:form action="" namespace="/powerbase" method="post" validator="true">
			<div>
			<input type="button" value="流程对比" class="#btn">
				<ec:table>
				</ec:table></fieldset>
		<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="结果信息" />
		</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd">权力编码</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >权力名称</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd">处罚程序</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >自由裁量标准</td>
				<td></td>
				</tr>
				<tr>
				<td class="addTd" >是否重大处罚</td>
				<td></td>
				</tr>
				<tr>
				<td class="addTd" >自由裁量信息</td>
				<td></td>
				</tr>
				<tr>
				<td class="addTd" >处罚决定分类</td>
				<td></td>
				</tr>
			<tr>
				<td class="addTd" >处罚种类</td>
				<td></td>
				<td class="addTd" >处罚执行结果</td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd" >实际罚款金额</td>
				<td></td>
				<td class="addTd" >实际罚款人数</td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd" >实际没收件数</td>
				<td></td>
				<td class="addTd" >实际没收价值</td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd" >实际停业天数</td>
				<td></td>
				<td class="addTd" >实际拘留人数</td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd" >实际拘留天数</td>
				<td></td>
				<td class="addTd" >办结时间</td>
				<td></td>
			</tr>
			<tr>
				<td class="addTd" >处罚法律依据</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="addTd" >办理附件</td>
				<td colspan="3"></td>
			</tr>
		</table>
		</fieldset>		
			<input type="button" class="btn" value="返回"
				onclick="javascript:history.go(-1);" />
	
	
</body>
</html>
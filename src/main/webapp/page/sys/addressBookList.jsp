<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/option.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 

<style>a{TEXT-DECORATION:none}</style>

<title>通用的通讯录</title>

<script language="javascript" type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
<script language="javascript" type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>

<script type="text/javascript">
    function showAddressBook(id){
        var options ={};
      //  options.displayNull = true;
     //   options.nullReplace = '---';
        addressBook.showDetail(id,options);
    }
    
</script>
</head>
<body>
		<div class="search">
		<div class="crumbs">通讯录</div>
		<s:form action="addressBook">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd">智能搜索：</td>
					<td width="30%"><s:textfield name="s_searchstring" /></td>
					<td class="addTd">备注：</td>
					<td width="180"><s:textfield name="s_memo" /></td>
					<td><s:submit type="submit" method="list" cssClass="btn" value="查询" />
						<a href="<s:url value='/page/sys/addressBookDialogForm.jsp'/>" target="dialog"><span class="btn">在对话框中新增</span></a>
					</td>
				</tr>
			</table>
		</s:form>
	</div>

	<ec:table action="addressBook!list.do" items="objList"
		var="addressBook" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:exportXls fileName="out.xls"></ec:exportXls>
		<ec:exportPdf fileName="out.pdf" headerColor="blue"
			headerBackgroundColor="white"></ec:exportPdf>
		<ec:row>
			<c:set var="taddrbookid"><s:text name='addressBook.addrbookid' /></c:set>	
			<ec:column property="addrbookid" title="${taddrbookid }"
				style="text-align:center" viewsDenied="html" />
			<c:set var="trepresentation"><s:text name='addressBook.representation' /></c:set>
			<ec:column property="representation" title="${trepresentation }"
				style="text-align:center" />
			<c:set var="tunitname"><s:text name='addressBook.unitname' /></c:set>
			<ec:column property="unitname" title="${tunitname }"
				style="text-align:center" viewsDenied="html" />
			<c:set var="tdeptname"><s:text name='addressBook.deptname' /></c:set>
			<ec:column property="deptname" title="${tdeptname }"
				style="text-align:center" viewsDenied="html" />
				<c:set var="trankname"><s:text name='addressBook.rankname' /></c:set>
			<ec:column property="rankname" title="${trankname }"
				style="text-align:center" viewsDenied="html" />
			<c:set var="tqq"><s:text name='addressBook.qq' /></c:set>
			<ec:column property="qq" title="${tqq }" style="text-align:center" />
			<c:set var="tbuzphone"><s:text name='addressBook.buzphone' /></c:set>
			<ec:column property="buzphone" title="${tbuzphone }"
				style="text-align:center" viewsDenied="html" />
			<c:set var="tmobilephone"><s:text name='addressBook.mobilephone' /></c:set>
			<ec:column property="mobilephone" title="${tmobilephone }"
				style="text-align:center" />
			<c:set var="temail"><s:text name='addressBook.email' /></c:set>
			<ec:column property="email" title="${temail }" style="text-align:center" />
			<c:set var="thomepage"><s:text name='addressBook.homepage' /></c:set>
			<ec:column property="homepage" title="${thomepage }"
				style="text-align:center" viewsDenied="html" />
			<c:set var="tmemo"><s:text name='addressBook.memo' /></c:set>
			<ec:column property="memo" title="${tmemo}" style="text-align:center" />
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center;">
				<div class="option-btn">
					<a class="showDetail" rel="check" styleopt="viewDetail"
						href='addressBook!view.do?addrbookid=${addressBook.addrbookid}'>查看</a>
					<a href='#' class="showDetail" styleopt="viewInDialog"
						onclick="showAddressBook('${addressBook.addrbookid}')"></a> <a
						href='addressBook!edit.do?addrbookid=${addressBook.addrbookid}'
						styleopt="edit">编辑</a> <a
						href='addressBook!delete.do?addrbookid=${addressBook.addrbookid}'
						onclick='return confirm("是否删除 ${addressBook.representation} 通讯录?");'
						styleopt="delete">删除</a>
				</div>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
</html>

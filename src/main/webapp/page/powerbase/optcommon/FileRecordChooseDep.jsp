<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@page import="com.centit.powerbase.po.RecordFileBasic"%>
<%@page import="com.centit.powerbase.po.RecordFileStuff"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>备案详尽信息</title>
<sj:head locale="zh_CN" />
<script type="text/javascript">
		function doSubmit() {
			if(!isChecked()) {
				alert('请选择部门！');
				return ;
			}
			var id = "";
			for(nIndex=0;nIndex<document.forms(0).groupIDs.length;nIndex++) {
				if (document.forms(0).groupIDs[nIndex].checked) {
					id = id + document.forms(0).groupIDs[nIndex].value + ';';
				}
			}
			id = id.substring(0, id.length-1);
			window.returnValue = id;
			window.close();
		}
	   
  		function isChecked() {
			var nIndex = 0 ;
			var HChecked = false;
			if(!document.forms(0).groupIDs.length) {
					if (document.forms(0).groupIDs.checked) {
						  HChecked = true;
					}
				}
			 else{
				  for(nIndex=0;nIndex<document.forms(0).groupIDs.length;nIndex++){
				       if (document.forms(0).groupIDs[nIndex].checked) {
							  HChecked = true;
						}
				   	}
			   }
			   return HChecked;
		}
		

  		function btn_selAll(){
			if(document.forms(0).selectAll.value=="全选"){
			    if(!document.forms(0).groupIDs.length){
			        document.forms(0).groupIDs.checked=true;
			    }else{
			        for(var i=0;i<document.forms(0).groupIDs.length;i++){
			            document.forms(0).groupIDs[i].checked=true;
			        }    
			    }
			    document.forms(0).selectAll.value="取消"
			}else{
			    if(!document.forms(0).groupIDs.length){
			        document.forms(0).groupIDs.checked=false;
			    }else{
			        for(var i=0;i<document.forms(0).groupIDs.length;i++){
			            document.forms(0).groupIDs[i].checked=false;
			        }    
			    }
			    document.forms(0).selectAll.value="全选"
			}
		}
	</script>
</head>
<body>
	<s:form action="/recordFileBasic" namespace="/powerbase" method="POST">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tablegray">
				<tr>
					<td valign="middle" width="20%">
						当前位置：
						<span class="fontred">部门选择</span>
					</td>
				</tr>
			</table>
			<br>
			<div align="center">
						<input type="button"  class="btn" value="完成" onclick="doSubmit();" >&nbsp;&nbsp;&nbsp; 
						<input type="button"  class="btn" value="关闭" onclick="window.close();" >  
			</div>
			<br>
			<table cellpadding="0" cellspacing="0" align="center" class="table_b">
				<tr class="b_darkblue">
					<td width="5%">
						<input type="button" name="selectAll" value="全选" onclick="btn_selAll();" class="btn">
					</td>
					<td width="10%">
						序号
					</td>
					<td>
						部门名称
					</td>
				</tr>
				<c:forEach items="${allunitList }" varStatus="stat" var="bo" >
					<s:set name="code">${bo.unitcode}</s:set>
					<s:set name="name">${bo.unitname}</s:set>
				<%String unit=(String)request.getAttribute("code")+","+(String)request.getAttribute("name"); %>
					<tr class="b_gray">
						<td align="center">
							<input type="checkbox" name="groupIDs" value="<%=unit %>" />
						</td>
						<td align="center">
							${stat.index+1 }
						</td>
						<td align="center">
							${bo.unitname }
						</td>
					</tr>
				</c:forEach>
			</table>
		</s:form>
	</body>

</html>
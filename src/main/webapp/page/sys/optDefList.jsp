<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><meta name="decorator" content='${LAYOUT}'/>
       
    <title>操作方法定义，要和业务中的Action中的方法对应</title>

	
  </head>
  
  <body> 
  
  
	  
    <table cellpadding="1" cellspacing="1" align="center">

				<tr>
					<td class="TDTITLE">
						业务代码
					</td>
					<td align="left">
						${optinfo.optid} 
					</td>

					<td class="TDTITLE">
						业务名称
					</td>
					<td align="left">
						${optinfo.optname}
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						业务URL
					</td>
					<td align="left">
						${optinfo.opturl}
					</td>
					<td class="TDTITLE">
						<a href='optDef!built.do?optid=${optinfo.optid}'>新建一个操作方法</a>
					</td>
					<td class="TDTITLE">
						<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
					</td>					
				</tr>
			</table>  
  <br/>
 

  <br/>
    <ec:table items="optdefs" action="sys/optDef!list.do" retrieveRowsCallback="limit"
		sortable="false"  var="optdef" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif">
			<ec:row>
				<ec:column property="optcode" title="操作代码" style="text-align:left"  />
				<ec:column property="optmethod" title="操作方法" sortable="false" style="text-align:left" />
				<ec:column property="optname" title="方法名称" sortable="false" style="text-align:left" />
				<ec:column property="optdesc" title="方法说明" sortable="false"	style="text-align:left" />
				<ec:column property="optdefineopt" title="操作" sortable="false" >
					<a href='optDef!edit.do?optcode=${optdef.optcode}'>
						编辑
					</a>
					<a href='optDef!delete.do?optcode=${optdef.optcode}'
						onclick='return confirm("是否删除操作：${optdef.optname}?");' >
						删除
					</a>
				</ec:column>
			</ec:row>
		</ec:table>	
		
		
  </body>
</html>

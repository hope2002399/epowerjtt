<#include "common.ftl" />
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibsindicator.jsp"%>
<#assign columnCount = 2 />
<!DOCTYPE html>
	<head>  
		<meta http-equiv="content-type" content="text/html;charset=utf8">  
		<link href="${r"${"}pageContext.request.contextPath${r"}"}/scripts/drag/style.css" rel="stylesheet" type="text/css" />
		<script src="${r"${"}pageContext.request.contextPath${r"}"}/scripts/drag/drag.js" type="text/javascript"></script>
		<script src="${r"${"}pageContext.request.contextPath${r"}"}/scripts/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="${r"${"}pageContext.request.contextPath${r"}"}/scripts/datepicker/WdatePicker.js" type="text/javascript"></script>
		<script type="text/javascript">
			// after page is loaded, initialize DIV elements inside tables
			window.onload = function () {
				REDIPS.drag.border = "none";
				
				// initialization
				REDIPS.drag.init();
				// set hover color
				REDIPS.drag.hover_color = '#E7C7B2';
				// set drop option to 'switching'
				REDIPS.drag.drop_option = 'switching';
			}
			
			function save(){
				// scan first table
				var content = REDIPS.drag.save_content();
				// if content doesn't exist
				if (content === '') {
					alert('Table is empty!');
				}
				// display query string
				else {
					//window.open('/my/multiple-parameters.php?' + content, 'Mypop', 'width=350,height=160,scrollbars=yes');
					//window.open('multiple-parameters.php?' + content, 'Mypop', 'width=350,height=260,scrollbars=yes');

					//window.document.getElementById('nodesJson').value = window.opener.document.getElementById('nodesJson').value;
					
					$.ajax({
					   type : 'post',
					   url: '${r"${"}pageContext.request.contextPath${r"}"}/indicator/pmTemplet!saveJsp.do?' + content,
					   dataType:"json",
					   async: false,
					   data:{
							"nodesJson": window.opener.document.getElementById('nodesJson').value,
							"jspFileName": '${r"${"}param.jspFileName${r"}"}',
							"formName": '${r"${"}param.formName${r"}"}'
					   },
					   success: function(data){
							alert('排版保存成功');
					   }
					});
					alert('排版保存成功');
					window.opener.location.href="${r"${"}pageContext.request.contextPath${r"}"}/indicator/pmTemplet!templetList.do";
					window.close();
					//window.location.href = '${r"${"}pageContext.request.contextPath${r"}"}/indicator/pmTemplet!saveJsp.do?' + content;
				}
			}
		</script>
		<style>
			body { width:98%; padding-left:5px; }
			
			/*fieldset*/
			fieldset { clear:both; display:block; width:99.5%; padding-bottom:10px;  border:1px solid #cdcdcd/* #b8d0d6 */;  }
			legend { margin-left:10px; border:1px dotted #cdcdcd/* #b8d0d6 */; padding:2px 4px; }
			legend b{font-weight:bold}
			fieldset table { width:100%; margin-top:10px; }
			fieldset td {  padding:0 10px 0 10px;  font-size:12px;}
			fieldset input { height:21px; line-height:21px; padding:0 4px;z-index:10000; }
			
			#viewTable,.viewTable { border-collapse:collapse; margin-top:10px; color:#333; }
			#viewTable,#viewTable td,.viewTable,.viewTable td { border:1px solid #cdcdcd/* #b8d0d6 */; }
			#viewTable td,.viewTable td { padding:4px 10px 4px 10px; line-height:16px;}
			#viewTable .addTd,.viewTable .addTd { color:#000; }
			
			.btn {
				display: inline-block;
				zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
				*display: inline;
				vertical-align: baseline;
				margin: 10px 5px;
				outline: none;
				cursor: pointer;
				text-align: center;
				text-decoration: none;
				font-size: 14px;
				line-height: 100%;
				border: none; /* gray */
				color: #fff;
				background: #497CF3;
				
				
			    width:75px;
				height:25px;
				border-radius: 2px;
				behavior: url(../themes/gray/PIE.htc);
			}
		</style>
	</head>  
	<body>
		<h1>${formName} 排版页面</h1>
		<div id="drag">
		<#assign data = dataJson?eval />
		<#list data as item>
			<#if (!item.ifHidden??) || (item.ifHidden != "T")>
			<fieldset style="display: block; padding: 10px; ">
				<legend class="new_legend">${item.name}</legend>
				<#if item.children??>
					<table id="table${item_index}" class="viewTable" >
					<#list item.children?sort_by("order") as children>
						<#if (!children.ifHidden??) || (children.ifHidden != "T")>
						<tr>
						<#if children.children??>
							<td class="mark" rowspan=${(children.children?size / columnCount) ? ceiling}><b>${children.name}</b></td>
							<#list children.children?sort_by("order") as sub>
								<#if (!sub.ifHidden??) || (sub.ifHidden != "T")>
								<#if (sub_index > 0) && (sub_index % columnCount == 0)>
								<tr>
								</#if>
								<td>
								<div id="${sub.indicatorNickName}" class="drag">
									<table border="0"><tr><td style="width:35%">${sub.name}：</td><td><@inputC item=sub /></td></tr></table>
								</div>
								</td>
								<#if (sub_index > 0) && (sub_index % columnCount == columnCount-1)>
								</tr>
								</#if>
								</#if>	
							</#list>
						<#else>
							<td>${children.name}：</td>
							<td><@input item=children /></td>
						</#if>
						</tr>
						</#if>
					</#list>
					</table>
				<#else>
				</#if>
			</fieldset>
			</#if>
		</#list>
		</div>
		<div align="center">
			<input type="button" class="btn" value="保存" onClick="save();"/>
		</div>
	</body>
</html>
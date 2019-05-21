<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibsindicator.jsp"%> 
<#include "common.ftl" />
<#assign columnCount = 2 />

		<#assign data = dataJson?eval />
		<#list data as item>
		<#if (!item.ifHidden??) || (item.ifHidden != "T")>	
			<fieldset style="display: block; padding: 10px; ">
				<legend class="new_legend">${item.name}</legend>
				<#if item.children??>
					<table class="viewTable" >
					<#list item.children as children>
					<#if (!children.ifHidden??) || (children.ifHidden != "T")>	
						<tr>
						<#if children.children??>
							<td rowspan=${(children.children?size / columnCount) ? ceiling}><b>${children.name}</b></td>
							<#list children.children?sort_by("order") as sub>
							<#if (!sub.ifHidden??) || (sub.ifHidden != "T")>	
								<#if (sub_index > 0) && (sub_index % columnCount == 0)>
								<tr>
								</#if>
								<td>${sub.name}：</td>
								<td><@text item=sub /></td>
								<#if (sub_index > 0) && (sub_index % columnCount == columnCount-1)>
								</tr>
								</#if>
							</#if>
							</#list>
						<#else>
							<td>${children.name}：</td>
							<td><@text item=children /></td>
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
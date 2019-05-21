<#assign INPUT_TYPE_TEXT = "01">
<#assign INPUT_TYPE_TEXTAREA = "02">
<#assign INPUT_TYPE_DATE = "03">
<#assign INPUT_TYPE_CHECKBOX = "04">
<#assign INPUT_TYPE_RADIO = "05">
<#assign INPUT_TYPE_SELECT = "06">
<#assign INPUT_TYPE_FILE = "99">

<#macro input item>
	<#if item.inputType == INPUT_TYPE_TEXT>
		<input type="text" name="${item.indicatorNickName}" value="${r"${"}obj.${item.indicatorNickName}${r"}"}" />
	<#elseif item.inputType == INPUT_TYPE_TEXTAREA>
		<textarea name="${item.indicatorNickName}">${r"${"}obj.${item.indicatorNickName}${r"}"}</textarea>
	<#elseif item.inputType == INPUT_TYPE_DATE>
		<input type="text" name="${item.indicatorNickName}" id="${item.indicatorNickName}" value='${r"${"}obj.${item.indicatorNickName}${r"}"}' onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
	<#elseif item.inputType == INPUT_TYPE_SELECT>
		<@select item=item />
	<#elseif item.inputType == INPUT_TYPE_RADIO>
		<@radio item=item />
	<#elseif item.inputType == INPUT_TYPE_CHECKBOX>
		<@checkbox item=item />
	<#elseif item.inputType == INPUT_TYPE_FILE>
		<@file item=item />
	<#else>
		<input type="text" name="${item.indicatorNickName}" value="${r"${"}obj.${item.indicatorNickName}${r"}"}" />
	</#if>
</#macro>

<#macro inputC item>
	<#if item.inputType == INPUT_TYPE_TEXT>
		<input type="text" />
	<#elseif item.inputType == INPUT_TYPE_TEXTAREA>
		<textarea></textarea>
	<#elseif item.inputType == INPUT_TYPE_DATE>
		<input type="text" name="${item.indicatorNickName}" id="${item.indicatorNickName}" value='' onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
	<#elseif item.inputType == INPUT_TYPE_SELECT>
		<select><option value="">--请选择--</option></select>
	<#elseif item.inputType == INPUT_TYPE_RADIO>
		<input type="radio" name="${item.indicatorNickName}" checked="checked" />选项1
		<input type="radio" name="${item.indicatorNickName}" />选项2
	<#elseif item.inputType == INPUT_TYPE_CHECKBOX>
		<input type="checkbox" name="${item.indicatorNickName}" checked="checked" />选项1
		<input type="checkbox" name="${item.indicatorNickName}" />选项2
	<#elseif item.inputType == INPUT_TYPE_FILE>
		<div></div>
	<#else>
		<input type="text" />
	</#if>
</#macro>

<#macro text item>
	<#if (!item.ifDictionary??) || (item.ifDictionary != "01")>
		${r"${"}obj.${item.indicatorNickName}${r"}"}
	<#else>
		${r"${"}cp:MAPVALUE('${item.dictionaryId}', obj.${item.indicatorNickName})${r"}"}
	</#if>
</#macro>

<#macro select item>
	<select name="${item.indicatorNickName}">
		<option value="">--请选择--</option>
		<#if item.dictionaryId??>
			<c:forEach var="row" items="${r"${"}cp:DICTIONARY('${item.dictionaryId}')${r"}"}">
				<option value="${r"${"}row.key${r"}"}" label="${r"${"}row.value${r"}"}"
					<c:if test="${r"${"}obj.${item.indicatorNickName}==row.key${r"}"}"> selected="selected"</c:if>>
					<c:out value="${r"${"}row.value${r"}"}" />
				</option>
			</c:forEach>
		</#if>
	</select>
</#macro>

<#macro radio item>
	<#if item.dictionaryId??>
		<c:forEach var="row" items="${r"${"}cp:DICTIONARY('${item.dictionaryId}')${r"}"}" varStatus="s">
			<input name="${item.indicatorNickName}" type="radio" <c:if test="${r"${"} obj.${ item.indicatorNickName}==row.key || (empty obj.${item.indicatorNickName} && s.index==0) ${r"}"}">checked="checked"</c:if> value="${r"${"}row.key${r"}"}"/><c:out value="${r"${"}row.value${r"}"}" />
		</c:forEach>
	</#if>
</#macro>

<#macro checkbox item>
	<c:forEach var="row" items="${r"${"}cp:DICTIONARY('${item.dictionaryId}')${r"}"}">
		<input onclick="checkboxChoise(this)" type="checkbox" class="radio" name="box_${item.indicatorNickName}" value="${r"${"}row.key ${r"}"}" <c:if test="${r"${"}not empty obj.${item.indicatorNickName}&&fn:contains(obj.${item.indicatorNickName}, row.key)${r"}"}">checked="checked"</c:if>/>
		<c:out value="${r"${"}row.value${r"}"}" />
	</c:forEach>
	<input type="hidden" id="${item.indicatorNickName}" name="${item.indicatorNickName}" value="${r"${"}obj.${item.indicatorNickName}${r"}"}"/>
</#macro>

<#macro file item>
	<div class="attachment" id="${item.indicatorNickName}Div" rel="${item.indicatorNickName}" ></div>
	<input name="${item.indicatorNickName}" id="${item.indicatorNickName}" type="hidden"  value="${r"${"}obj.${item.indicatorNickName}${r"}"}"/>
</#macro>
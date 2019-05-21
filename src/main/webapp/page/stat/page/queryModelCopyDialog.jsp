<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<div class="pageContent" layoutH="1">
	<form action="${pageContext.request.contextPath }/stat/queryModel!copy.do"  onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="submit" value="复制" class="btn" />
		<div class="pageFormContent">
			<div class="unit">	
				<label>*新模板编号：</label>
				<input type="text" name="newModelName" value="${modelName }_New" />
				<input type="hidden" name="modelName" value="${modelName }" />
			</div>
	
			<div class="unit">	
				<label>模板名称：</label>
				<input type="text" name="formNameFormat" value="${object.formNameFormat }" />
			</div>
			
			<div class="unit">	
				<label>返回页面：</label>
				<input type="text" name="resultName" value="${object.resultName }" />
			</div>
			
			<div class="unit">	
				<label>模板描述：</label>
				<textarea rows="120" cols="5" style="width:300px; height:100px;">${object.queryDesc }</textarea>
			</div>
		</div>
	</form>
</div>

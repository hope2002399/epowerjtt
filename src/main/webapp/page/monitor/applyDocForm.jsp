<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/applyDoc!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="applyDoc.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="applyDoc.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyDocForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.readDate" />：</label>
				 
				 
				<input name="readDate" type="text" <c:if test="${!empty applyDocForm.map.readDate }">readonly="readonly"</c:if> size="40" value="${object.readDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyDocForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.errorDesc" />：</label>
				 
				 
				<input name="errorDesc" type="text" <c:if test="${!empty applyDocForm.map.errorDesc }">readonly="readonly"</c:if> size="40" value="${object.errorDesc }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyDocForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyDocForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.processNo" />：</label>
				 
				 
				<input name="processNo" type="text" <c:if test="${!empty applyDocForm.map.processNo }">readonly="readonly"</c:if> size="40" value="${object.processNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.docNo" />：</label>
				 
				 
				<input name="docNo" type="text" <c:if test="${!empty applyDocForm.map.docNo }">readonly="readonly"</c:if> size="40" value="${object.docNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.docType" />：</label>
				 
				 
				<input name="docType" type="text" <c:if test="${!empty applyDocForm.map.docType }">readonly="readonly"</c:if> size="40" value="${object.docType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.docSort" />：</label>
				 
				 
				<input name="docSort" type="text" <c:if test="${!empty applyDocForm.map.docSort }">readonly="readonly"</c:if> size="40" value="${object.docSort }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.docName" />：</label>
				 
				 
				<input name="docName" type="text" <c:if test="${!empty applyDocForm.map.docName }">readonly="readonly"</c:if> size="40" value="${object.docName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.documentName" />：</label>
				 
				 
				<input name="documentName" type="text" <c:if test="${!empty applyDocForm.map.documentName }">readonly="readonly"</c:if> size="40" value="${object.documentName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyDoc.docFile" />：</label>
				 
				 
				<input name="docFile" type="text" <c:if test="${!empty applyDocForm.map.docFile }">readonly="readonly"</c:if> size="40" value="${object.docFile }"/>
				
			</p>
			
			
			
			
		</div>


		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</s:form>
</div>

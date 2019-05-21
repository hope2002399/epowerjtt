<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/punishDoc!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="punishDoc.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="punishDoc.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishDocForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.readDate" />：</label>
				 
				 
				<input name="readDate" type="text" <c:if test="${!empty punishDocForm.map.readDate }">readonly="readonly"</c:if> size="40" value="${object.readDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishDocForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.errorDesc" />：</label>
				 
				 
				<input name="errorDesc" type="text" <c:if test="${!empty punishDocForm.map.errorDesc }">readonly="readonly"</c:if> size="40" value="${object.errorDesc }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishDocForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishDocForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.processNo" />：</label>
				 
				 
				<input name="processNo" type="text" <c:if test="${!empty punishDocForm.map.processNo }">readonly="readonly"</c:if> size="40" value="${object.processNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.docNo" />：</label>
				 
				 
				<input name="docNo" type="text" <c:if test="${!empty punishDocForm.map.docNo }">readonly="readonly"</c:if> size="40" value="${object.docNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.docType" />：</label>
				 
				 
				<input name="docType" type="text" <c:if test="${!empty punishDocForm.map.docType }">readonly="readonly"</c:if> size="40" value="${object.docType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.docSort" />：</label>
				 
				 
				<input name="docSort" type="text" <c:if test="${!empty punishDocForm.map.docSort }">readonly="readonly"</c:if> size="40" value="${object.docSort }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.docName" />：</label>
				 
				 
				<input name="docName" type="text" <c:if test="${!empty punishDocForm.map.docName }">readonly="readonly"</c:if> size="40" value="${object.docName }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.documentName" />：</label>
				 
				 
				<input name="documentName" type="text" <c:if test="${!empty punishDocForm.map.documentName }">readonly="readonly"</c:if> size="40" value="${object.documentName }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishDoc.docFile" />：</label>
				 
				 
				<input name="docFile" type="text" <c:if test="${!empty punishDocForm.map.docFile }">readonly="readonly"</c:if> size="40" value="${object.docFile }"/>
				
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

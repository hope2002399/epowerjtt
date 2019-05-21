<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/punishResult!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="punishResult.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="punishResult.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" <c:if test="${!empty punishResultForm.map.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishResultForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishResultForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishResultForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.program" />：</label>
				 
				 
				<input name="program" type="text" <c:if test="${!empty punishResultForm.map.program }">readonly="readonly"</c:if> size="40" value="${object.program }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishSort" />：</label>
				 
				 
				<input name="punishSort" type="text" <c:if test="${!empty punishResultForm.map.punishSort }">readonly="readonly"</c:if> size="40" value="${object.punishSort }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.accordance" />：</label>
				 
				 
				<input name="accordance" type="text" <c:if test="${!empty punishResultForm.map.accordance }">readonly="readonly"</c:if> size="40" value="${object.accordance }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.standard" />：</label>
				 
				 
				<input name="standard" type="text" <c:if test="${!empty punishResultForm.map.standard }">readonly="readonly"</c:if> size="40" value="${object.standard }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishDeside" />：</label>
				 
				 
				<input name="punishDeside" type="text" <c:if test="${!empty punishResultForm.map.punishDeside }">readonly="readonly"</c:if> size="40" value="${object.punishDeside }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishClass" />：</label>
				 
				 
				<input name="punishClass" type="text" <c:if test="${!empty punishResultForm.map.punishClass }">readonly="readonly"</c:if> size="40" value="${object.punishClass }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResult" />：</label>
				 
				 
				<input name="punishResult" type="text" <c:if test="${!empty punishResultForm.map.punishResult }">readonly="readonly"</c:if> size="40" value="${object.punishResult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultFine" />：</label>
				 
				 
				<input name="punishResultFine" type="text" <c:if test="${!empty punishResultForm.map.punishResultFine }">readonly="readonly"</c:if> size="40" value="${object.punishResultFine }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultFinePeople" />：</label>
				 
				 
				<input name="punishResultFinePeople" type="text" <c:if test="${!empty punishResultForm.map.punishResultFinePeople }">readonly="readonly"</c:if> size="40" value="${object.punishResultFinePeople }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultExpropriation" />：</label>
				 
				 
				<input name="punishResultExpropriation" type="text" <c:if test="${!empty punishResultForm.map.punishResultExpropriation }">readonly="readonly"</c:if> size="40" value="${object.punishResultExpropriation }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultExpropriationV" />：</label>
				 
				 
				<input name="punishResultExpropriationV" type="text" <c:if test="${!empty punishResultForm.map.punishResultExpropriationV }">readonly="readonly"</c:if> size="40" value="${object.punishResultExpropriationV }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultBusiness" />：</label>
				 
				 
				<input name="punishResultBusiness" type="text" <c:if test="${!empty punishResultForm.map.punishResultBusiness }">readonly="readonly"</c:if> size="40" value="${object.punishResultBusiness }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultPeople" />：</label>
				 
				 
				<input name="punishResultPeople" type="text" <c:if test="${!empty punishResultForm.map.punishResultPeople }">readonly="readonly"</c:if> size="40" value="${object.punishResultPeople }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.punishResultDetain" />：</label>
				 
				 
				<input name="punishResultDetain" type="text" <c:if test="${!empty punishResultForm.map.punishResultDetain }">readonly="readonly"</c:if> size="40" value="${object.punishResultDetain }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty punishResultForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.finishDate" />：</label>
				 
				 
				<input name="finishDate" type="text" <c:if test="${!empty punishResultForm.map.finishDate }">readonly="readonly"</c:if> size="40" value="${object.finishDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.resultStandard" />：</label>
				 
				 
				<input name="resultStandard" type="text" <c:if test="${!empty punishResultForm.map.resultStandard }">readonly="readonly"</c:if> size="40" value="${object.resultStandard }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishResultForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishResultForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishResultForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishResultForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResult.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishResultForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/punishResultLog!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="punishResultLog.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="punishResultLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishResultLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishResultLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishResultLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.program" />：</label>
				 
				 
				<input name="program" type="text" <c:if test="${!empty punishResultLogForm.map.program }">readonly="readonly"</c:if> size="40" value="${object.program }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishSort" />：</label>
				 
				 
				<input name="punishSort" type="text" <c:if test="${!empty punishResultLogForm.map.punishSort }">readonly="readonly"</c:if> size="40" value="${object.punishSort }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.accordance" />：</label>
				 
				 
				<input name="accordance" type="text" <c:if test="${!empty punishResultLogForm.map.accordance }">readonly="readonly"</c:if> size="40" value="${object.accordance }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.standard" />：</label>
				 
				 
				<input name="standard" type="text" <c:if test="${!empty punishResultLogForm.map.standard }">readonly="readonly"</c:if> size="40" value="${object.standard }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishDeside" />：</label>
				 
				 
				<input name="punishDeside" type="text" <c:if test="${!empty punishResultLogForm.map.punishDeside }">readonly="readonly"</c:if> size="40" value="${object.punishDeside }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishClass" />：</label>
				 
				 
				<input name="punishClass" type="text" <c:if test="${!empty punishResultLogForm.map.punishClass }">readonly="readonly"</c:if> size="40" value="${object.punishClass }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResult" />：</label>
				 
				 
				<input name="punishResult" type="text" <c:if test="${!empty punishResultLogForm.map.punishResult }">readonly="readonly"</c:if> size="40" value="${object.punishResult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultFine" />：</label>
				 
				 
				<input name="punishResultFine" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultFine }">readonly="readonly"</c:if> size="40" value="${object.punishResultFine }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultFinePeople" />：</label>
				 
				 
				<input name="punishResultFinePeople" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultFinePeople }">readonly="readonly"</c:if> size="40" value="${object.punishResultFinePeople }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultExpropriation" />：</label>
				 
				 
				<input name="punishResultExpropriation" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultExpropriation }">readonly="readonly"</c:if> size="40" value="${object.punishResultExpropriation }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultExpropriationV" />：</label>
				 
				 
				<input name="punishResultExpropriationV" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultExpropriationV }">readonly="readonly"</c:if> size="40" value="${object.punishResultExpropriationV }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultBusiness" />：</label>
				 
				 
				<input name="punishResultBusiness" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultBusiness }">readonly="readonly"</c:if> size="40" value="${object.punishResultBusiness }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultPeople" />：</label>
				 
				 
				<input name="punishResultPeople" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultPeople }">readonly="readonly"</c:if> size="40" value="${object.punishResultPeople }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultDetain" />：</label>
				 
				 
				<input name="punishResultDetain" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultDetain }">readonly="readonly"</c:if> size="40" value="${object.punishResultDetain }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty punishResultLogForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.finishDate" />：</label>
				 
				 
				<input name="finishDate" type="text" <c:if test="${!empty punishResultLogForm.map.finishDate }">readonly="readonly"</c:if> size="40" value="${object.finishDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.resultStandard" />：</label>
				 
				 
				<input name="resultStandard" type="text" <c:if test="${!empty punishResultLogForm.map.resultStandard }">readonly="readonly"</c:if> size="40" value="${object.resultStandard }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishResultLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishResultLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishResultLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishResultLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishResultLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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

			<p>
				<label><c:out value="punishResultLog.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" class="required" <c:if test="${!empty object.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }" />
				
			</p>

			
			<p>
				<label><c:out value="punishResultLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishResultLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishResultLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishResultLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.program" />：</label>
				 
				 
				<input name="program" type="text" <c:if test="${!empty punishResultLogForm.map.program }">readonly="readonly"</c:if> size="40" value="${object.program }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishSort" />：</label>
				 
				 
				<input name="punishSort" type="text" <c:if test="${!empty punishResultLogForm.map.punishSort }">readonly="readonly"</c:if> size="40" value="${object.punishSort }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.accordance" />：</label>
				 
				 
				<input name="accordance" type="text" <c:if test="${!empty punishResultLogForm.map.accordance }">readonly="readonly"</c:if> size="40" value="${object.accordance }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.standard" />：</label>
				 
				 
				<input name="standard" type="text" <c:if test="${!empty punishResultLogForm.map.standard }">readonly="readonly"</c:if> size="40" value="${object.standard }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishDeside" />：</label>
				 
				 
				<input name="punishDeside" type="text" <c:if test="${!empty punishResultLogForm.map.punishDeside }">readonly="readonly"</c:if> size="40" value="${object.punishDeside }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishClass" />：</label>
				 
				 
				<input name="punishClass" type="text" <c:if test="${!empty punishResultLogForm.map.punishClass }">readonly="readonly"</c:if> size="40" value="${object.punishClass }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResult" />：</label>
				 
				 
				<input name="punishResult" type="text" <c:if test="${!empty punishResultLogForm.map.punishResult }">readonly="readonly"</c:if> size="40" value="${object.punishResult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultFine" />：</label>
				 
				 
				<input name="punishResultFine" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultFine }">readonly="readonly"</c:if> size="40" value="${object.punishResultFine }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultFinePeople" />：</label>
				 
				 
				<input name="punishResultFinePeople" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultFinePeople }">readonly="readonly"</c:if> size="40" value="${object.punishResultFinePeople }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultExpropriation" />：</label>
				 
				 
				<input name="punishResultExpropriation" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultExpropriation }">readonly="readonly"</c:if> size="40" value="${object.punishResultExpropriation }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultExpropriationV" />：</label>
				 
				 
				<input name="punishResultExpropriationV" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultExpropriationV }">readonly="readonly"</c:if> size="40" value="${object.punishResultExpropriationV }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultBusiness" />：</label>
				 
				 
				<input name="punishResultBusiness" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultBusiness }">readonly="readonly"</c:if> size="40" value="${object.punishResultBusiness }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultPeople" />：</label>
				 
				 
				<input name="punishResultPeople" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultPeople }">readonly="readonly"</c:if> size="40" value="${object.punishResultPeople }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.punishResultDetain" />：</label>
				 
				 
				<input name="punishResultDetain" type="text" <c:if test="${!empty punishResultLogForm.map.punishResultDetain }">readonly="readonly"</c:if> size="40" value="${object.punishResultDetain }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty punishResultLogForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.finishDate" />：</label>
				 
				 
				<input name="finishDate" type="text" <c:if test="${!empty punishResultLogForm.map.finishDate }">readonly="readonly"</c:if> size="40" value="${object.finishDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.resultStandard" />：</label>
				 
				 
				<input name="resultStandard" type="text" <c:if test="${!empty punishResultLogForm.map.resultStandard }">readonly="readonly"</c:if> size="40" value="${object.resultStandard }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishResultLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishResultLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishResultLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishResultLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishResultLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishResultLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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

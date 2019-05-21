<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/outwaycalc!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="outwaycalc.calcNo" />�?/label>
				 
				 
				<input name="calcNo" type="text" class="required" <c:if test="${!empty object.calcNo }">readonly="readonly"</c:if> size="40" value="${object.calcNo }" />
				
			</p>

			
			<p>
				<label><c:out value="outwaycalc.calcTime" />�?/label>
				 
				 
				<input name="calcTime" type="text" <c:if test="${!empty outwaycalcForm.map.calcTime }">readonly="readonly"</c:if> size="40" value="${object.calcTime }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.callType" />�?/label>
				 
				 
				<input name="callType" type="text" <c:if test="${!empty outwaycalcForm.map.callType }">readonly="readonly"</c:if> size="40" value="${object.callType }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.caller" />�?/label>
				 
				 
				<input name="caller" type="text" <c:if test="${!empty outwaycalcForm.map.caller }">readonly="readonly"</c:if> size="40" value="${object.caller }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.scopeBegin" />�?/label>
				 
				 
				<input name="scopeBegin" type="text" <c:if test="${!empty outwaycalcForm.map.scopeBegin }">readonly="readonly"</c:if> size="40" value="${object.scopeBegin }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.scopeEnd" />�?/label>
				 
				 
				<input name="scopeEnd" type="text" <c:if test="${!empty outwaycalcForm.map.scopeEnd }">readonly="readonly"</c:if> size="40" value="${object.scopeEnd }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.alertPieces" />�?/label>
				 
				 
				<input name="alertPieces" type="text" <c:if test="${!empty outwaycalcForm.map.alertPieces }">readonly="readonly"</c:if> size="40" value="${object.alertPieces }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.alarmPieces" />�?/label>
				 
				 
				<input name="alarmPieces" type="text" <c:if test="${!empty outwaycalcForm.map.alarmPieces }">readonly="readonly"</c:if> size="40" value="${object.alarmPieces }"/>
				
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

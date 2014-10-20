<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editIspolnitel" var="editIspolnitelUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editIspolnitelForm" id="editIspolnitelForm">
	<aui:input id="id" name="id" type="hidden" value="${isplModel.id}" />
	
	<spring:message code="zayavka.surname" var='surnameLabel' />
	<aui:input id="surname" name="surname" label='${surnameLabel}' bean="isplModel" showRequiredLabel="" value="${isplModel.surname}" disabled="true">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.name" var='nameLabel' />
	<aui:input id="name" name="name" label='${nameLabel}' bean="isplModel" showRequiredLabel="" value="${isplModel.name}" disabled="true">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.patronymic" var='patronymicLabel' />
	<aui:input id="patronymic" name="patronymic" label='${patronymicLabel}' bean="isplModel" showRequiredLabel="" value="${isplModel.patronymic}" disabled="true">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
	<aui:input id="birthday" name="birthday" label='${birthdayLabel}' bean="isplModel" showRequiredLabel="" placeholder="дд-мм-гггг" value="${isplModel.birthday}" disabled="true">
		<aui:validator name="required" />
		<aui:validator name="custom" errorMessage="Формат даты дд-мм-гггг">
						function (val, fieldNode, ruleValue) {
							var result = false;
							
							if (val == '' || val.search(/^\d{2}-\d{2}-\d{4}$/)!=-1){
								result = true;
							}
							return result;
						}
					</aui:validator>
	</aui:input>

	<spring:message code="zayavka.degree" var='degreeLabel' />
	<aui:select id="popupUchStepeniId" name="uchStepeniIdArr" bean="isplModel" label='${degreeLabel}' multiple="true">
		<option value="" />
		<c:forEach var="i" items="${uchStepeniList}">
			<c:choose>
				<c:when test="${empty isplModel.uchStepeniIdArr}">
					<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==45}" />
				</c:when>
				<c:otherwise>
					<c:set var="contains" value="false" />
					<c:forEach var="item" items="${isplModel.uchStepeniIdArr}">
						<c:if test="${item eq i.id}">
							<c:set var="contains" value="true" />
						</c:if>
					</c:forEach>
					<aui:option value="${i.id}" label="${i.fullName}" selected="${contains}" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</aui:select>

	<spring:message code="zayavka.academicTitle" var='academicTitleLabel' />
	<aui:select id="popupUchZvaniyId" name="uchZvaniyIdArr" bean="isplModel" label='${academicTitleLabel}' multiple="true">
		<option value="" />
		<c:forEach var="i" items="${uchZvaniyList}">
			<c:choose>
				<c:when test="${empty isplModel.uchZvaniyIdArr}">
					<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==17}" />
				</c:when>
				<c:otherwise>
					<c:set var="contains" value="false" />
					<c:forEach var="item" items="${isplModel.uchZvaniyIdArr}">
						<c:if test="${item eq i.id}">
							<c:set var="contains" value="true" />
						</c:if>
					</c:forEach>
					<aui:option value="${i.id}" label="${i.fullName}" selected="${contains}" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</aui:select>

	<spring:message code="zayavka.mestoRaboti" var='mestoRabotiLabel' />
	<aui:select id="popupOrgId" name="orgId" bean="isplModel" label='${mestoRabotiLabel}'>
		<option value="" />
		<c:forEach var="i" items="${listOrg}">
			<aui:option value="${i.id}" label="${i.name}" selected="${i.id==isplModel.orgId}"/>
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code='zayavka.postManager' var='postLabel' />
	<aui:input id="post" name="post" label='${postLabel}' bean="isplModel" value="${isplModel.post}"></aui:input>

</aui:form>
<aui:script>
$(document).ready(function() {
	
	$('#${ns}popupUchStepeniId,#${ns}popupUchZvaniyId,#${ns}popupOrgId').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		placeholder_text_multiple : "Выберите нужные пункты...",
		width : '91%',
		search_contains:true
	});
	
	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
					"surname":$('#${ns}surname').val(),
		   		  	"name":$('#${ns}name').val(),
		   		  	"patronymic":$('#${ns}patronymic').val(),
		   		  	"birthday":$('#${ns}birthday').val(),
		   		  	"post":$('#${ns}post').val(),
		   		  	"uchStepeniIdArr":$('#${ns}popupUchStepeniId').val(),
		   		  	"uchZvaniyIdArr":$('#${ns}popupUchZvaniyId').val(),
		   		  	"orgId":$('#${ns}popupOrgId').val()};
		   		  	
		$.ajax({
		   url: '${editIspolnitelUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById('ispl'+data['id']);
						 $(parentTR).children('td').eq(0).html(data['surname']);
						 $(parentTR).children('td').eq(1).html(data['name']);
						 $(parentTR).children('td').eq(2).html(data['patronymic']);
						 $(parentTR).children('td').eq(3).html(data['birthday']);
						 $(parentTR).children('td').eq(4).html($('#${ns}popupUchStepeniId option:selected').text());
						 $(parentTR).children('td').eq(5).html($('#${ns}popupUchZvaniyId option:selected').text());
						 $(parentTR).children('td').eq(6).html($('#${ns}popupOrgId option:selected').text());
						 $(parentTR).children('td').eq(7).html(data['post']);
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});
});
</aui:script>
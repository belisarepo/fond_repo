<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.ispolniteliDTO}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.surname" /></th>
				<th><spring:message code="zayavka.name" /></th>
				<th><spring:message code="zayavka.patronymic" /></th>
				<th><spring:message code="zayavka.birthdayManager" /></th>
				<th><spring:message code="zayavka.degree" /></th>
				<th><spring:message code="zayavka.academicTitle" /></th>
				<th><spring:message code="zayavka.mestoRaboti" /></th>
				<th><spring:message code="zayavka.postManager" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.ispolniteliDTO}" var="i" varStatus="n">
				<tr id="ispl${i.id}">
					<td>${i.surname}</td>
					<td>${i.name}</td>
					<td>${i.patronymic}</td>
					<td>${i.birthday}</td>
					<td>${i.uchStepeniName}</td>
					<td>${i.uchZvaniyName}</td>
					<td>${i.orgName}</td>
					<td>${i.post}</td>
					<portlet:renderURL var="editIsplUrl" windowState='<%=LiferayWindowState.POP_UP.toString()%>'><portlet:param name="action" value="editIspolnitel" /><portlet:param name="isplId" value="${i.id}" /></portlet:renderURL>
					<c:set var="strEditIsplUrl"><%=editIsplUrl.toString()%></c:set>
					<aui:script>
						$('#editIspl${n.index+1}').on('click', function(event){
  					 		showPopup('Редактировать исполнителя',null,'${strEditIsplUrl}');
						});
					</aui:script>
					<td><a id="editIspl${n.index+1}" class='deleteLink' href="#">Редактировать</a></td>
					<td><a
						class='deleteLink' href="<portlet:actionURL><portlet:param name="action" value="deleteIspolnitel"/><portlet:param name="ispolnitelId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>


<aui:form action="${addIspolnitelAction}" method="POST" name="form6">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />
	<spring:message code="zayavka.surname" var='surnameLabel' />
	<aui:input name="surname" label='${surnameLabel}' bean="ispolnitelModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.name" var='nameLabel' />
	<aui:input name="name" label='${nameLabel}' bean="ispolnitelModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.patronymic" var='patronymicLabel' />
	<aui:input name="patronymic" label='${patronymicLabel}' bean="ispolnitelModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
	<aui:input name="birthday" label='${birthdayLabel}' bean="ispolnitelModel" showRequiredLabel="" placeholder="дд-мм-гггг">
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
	<aui:select name="uchStepeniId" bean="ispolnitelModel" label='${degreeLabel}'>
		<option value="" />
		<c:forEach var="i" items="${uchStepeniList}">
			<aui:option value="${i.id}" label="${i.fullName}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code="zayavka.academicTitle" var='academicTitleLabel' />
	<aui:select name="uchZvaniyId" bean="ispolnitelModel" label='${academicTitleLabel}'>
		<option value="" />
		<c:forEach var="i" items="${uchZvaniyList}">
			<aui:option value="${i.id}" label="${i.fullName}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code="zayavka.mestoRaboti" var='mestoRabotiLabel' />
	<aui:select name="orgId" bean="ispolnitelModel" label='${mestoRabotiLabel}'>
		<option value="" />
		<c:forEach var="i" items="${listOrg}">
			<aui:option value="${i.id}" label="${i.name}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code='zayavka.postManager' var='postLabel' />
	<aui:input name="post" label='${postLabel}' bean="ispolnitelModel"></aui:input>
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Добавить" />
		</div>
	</aui:button-row>

</aui:form>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
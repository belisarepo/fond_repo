<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form action="${saveForm2}" method="POST" name="form2">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

	<spring:message code="zayavka.fioRuk" var='fioRukLabel' />
	<aui:input name="fioRk" value="${zayavkaModel.fioRk}" disabled="true" label="${fioRukLabel}" bean="zayavkaModel" />

	<spring:message code="zayavka.fioFullRuk" var='fioFullRukLabel' />
	<aui:input name="fullFioRk" value="${zayavkaModel.fullFioRk}" disabled="true" label="${fioFullRukLabel}" bean="zayavkaModel" />

	<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
	<aui:input name="birthdayRk" value="${zayavkaModel.birthdayRk}" label='${birthdayLabel}' bean="zayavkaModel" cssClass="datapick" disabled="true" showRequiredLabel="">
	</aui:input>

	<spring:message code="zayavka.degree" var='degreeLabel' />
	<aui:select name="uchStepenIdRk" bean="zayavkaModel" label='${degreeLabel}'>
		<option value="" />
		<c:forEach var="i" items="${uchStepeniList}">
			<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==zayavkaModel.uchStepenIdRk}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code="zayavka.academicTitle" var='academicTitleLabel' />
	<aui:select name="uchZvaniyIdRk" bean="zayavkaModel" label='${academicTitleLabel}'>
		<option value="" />
		<c:forEach var="i" items="${uchZvaniyList}">
			<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==zayavkaModel.uchZvaniyIdRk}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code='zayavka.postManager' var='postLabel' />
	<aui:input name="postRk" value="${zayavkaModel.postRk}" label='${postLabel}' bean="zayavkaModel" cssClass="input-large"></aui:input>

	<spring:message code='zayavka.lab' var='labLabel' />
	<aui:input name="labRk" value="${zayavkaModel.labRk}" label='${labLabel}' bean="zayavkaModel" cssClass="input-large"></aui:input>

	<spring:message code='zayavka.jobPhone' var='jobPhoneLabel' />
	<aui:input name="jobPhoneRk" value="${zayavkaModel.jobPhoneRk}" label='${jobPhoneLabel}' bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.homePhone' var='homePhoneLabel' />
	<aui:input name="homePhoneRk" value="${zayavkaModel.homePhoneRk}" label='${homePhoneLabel}' bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.mobilePhone' var='mobilePhoneLabel' />
	<aui:input name="mobilePhoneRk" value="${zayavkaModel.mobilePhoneRk}" label='${mobilePhoneLabel}' bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.email' var='emailLabel' />
	<aui:input name="emailRk" value="${zayavkaModel.emailRk}" label='${emailLabel}' bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.address' var='addressLabel' />
	<aui:input name="addressRk" value="${zayavkaModel.addressRk}" label='${addressLabel}' bean="zayavkaModel" cssClass="input-large"></aui:input>

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>
	</aui:button-row>
</aui:form>


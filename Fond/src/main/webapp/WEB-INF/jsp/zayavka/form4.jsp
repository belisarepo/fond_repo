<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form action="${saveForm4}" method="POST" name="form4">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr/>
	

	<spring:message code="zayavka.fioRuk" var='fioRukLabel' />
	<aui:input name="fioRkNr" value="${zayavkaModel.fioRkNr}" label="${fioRukLabel}" bean="zayavkaModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.fioFullRuk" var='fioFullRukLabel' />
	<aui:input name="fullFioRkNr" value="${zayavkaModel.fullFioRkNr}" label="${fioFullRukLabel}" bean="zayavkaModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
	<aui:input name="birthdayRkNr" value="${zayavkaModel.birthdayRkNr}" label='${birthdayLabel}' bean="zayavkaModel" cssClass="datemask" showRequiredLabel="">
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
	<aui:select name="uchStepenIdRkNr" bean="zayavkaModel" label='${degreeLabel}'>
		<option value="" />
		<c:forEach var="i" items="${uchStepeniList}">
			<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==zayavkaModel.uchStepenIdRkNr}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code="zayavka.academicTitle" var='academicTitleLabel' />
	<aui:select name="uchZvaniyIdRkNr" bean="zayavkaModel" label='${academicTitleLabel}'>
		<option value="" />
		<c:forEach var="i" items="${uchZvaniyList}">
			<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==zayavkaModel.uchZvaniyIdRkNr}" />
		</c:forEach>
		<aui:option></aui:option>
	</aui:select>

	<spring:message code='zayavka.postManager' var='postLabel' />
	<aui:input name="postRkNr" value="${zayavkaModel.postRkNr}" label='${postLabel}' bean="zayavkaModel"></aui:input>

	
</aui:form>
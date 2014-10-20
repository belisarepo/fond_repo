<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:renderURL var="popupTemaNameURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="temaName" />
</portlet:renderURL>
<c:set var="strPopupTemaNameUrl"><%=popupTemaNameURL.toString()%></c:set>


<aui:form action="${saveForm1}" method="POST" name="form1">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />
	
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr/>

	<spring:message code="zayavka.konkursNameR" var='konkursNameLabel' />
	<aui:input name="konkursNameR" disabled="true" label="${konkursNameLabel}" bean="zayavkaModel" value="${zayavkaModel.konkursNameR}" />

	<spring:message code="zayavka.tipKonkursaName" var='tipKonkursaNameLabel' />
	<aui:input name="tipKonkursaName" value="${zayavkaModel.tipKonkursaName}" disabled="true" label="${tipKonkursaNameLabel}"
		bean="zayavkaModel" />

	<spring:message code="zayavka.sectionFond" var='sectionFondLabel' />
	<aui:select name="sectionFondId" label="${sectionFondLabel}" bean="zayavkaModel">
		<option value="" />
		<c:forEach var="i" items="${sectionFondList}">
			<aui:option value="${i.id}" label="${i.nameR}" selected="${i.id==zayavkaModel.sectionFondId}" />
		</c:forEach>
	</aui:select>
	<c:if test="${zayavkaModel.prioritetN}">
		<spring:message code="zayavka.prioritetNauka" var='prioritetNaukaLabel' />
		<aui:select name="prioritetNaukaId" label="${prioritetNaukaLabel}" bean="zayavkaModel">
			<option value="" />
			<c:forEach var="i" items="${prioritetNaukaList}">
				<aui:option value="${i.id}" label="${i.name}" selected="${i.id==zayavkaModel.prioritetNaukaId}" />
			</c:forEach>
		</aui:select>
	</c:if>
	<c:if test="${zayavkaModel.otraslN}">
		<spring:message code="zayavka.otraslNauka" var='otraslNaukaLabel' />
		<aui:select name="otraslNaukaId" label="${otraslNaukaLabel}" bean="zayavkaModel">
			<option value="" />
			<c:forEach var="i" items="${otraslNaukaList}">
				<aui:option value="${i.id}" label="${i.name}" selected="${i.id==zayavkaModel.otraslNaukaId}" />
			</c:forEach>
		</aui:select>
	</c:if>
	
	<c:if test="${zayavkaModel.napravl}">
		<spring:message code="zayavka.napravl" var='napravlLabel' />
		<aui:input name="napravlName" value="${zayavkaModel.napravlName}" label="${napravlLabel}" bean="zayavkaModel" cssClass="input-large"/>
	</c:if>
	
	<c:if test="${zayavkaModel.vidProject}">
		<spring:message code="zayavka.vidProject" var='vidProjectLabel' />
		<aui:input name="vidProjectName" value="${zayavkaModel.vidProjectName}" label="${vidProjectLabel}" bean="zayavkaModel" cssClass="input-large"/>
	</c:if>


	<spring:message code="zayavka.temaName" var='temaNameLabel' />
	<aui:input name="temaName" value="${zayavkaModel.temaName}" id="temaName" label="${temaNameLabel}" bean="zayavkaModel" type="hidden"/>
	<label><c:out value="${temaNameLabel}"/></label>
	<div id="temaNameDiv" class='div-as-textarea'></div>

	<spring:message code="zayavka.udk" var='udkLabel' />
	<aui:input name="udk" value="${zayavkaModel.udk}" label="${udkLabel}" bean="zayavkaModel" />

	
</aui:form>
<aui:script>
$('#temaNameDiv').on('click', function(event){
   showPopup('Тема заявки','temaName','${strPopupTemaNameUrl}');
});
$('#temaNameDiv').html($('#${ns}temaName').val());
</aui:script>

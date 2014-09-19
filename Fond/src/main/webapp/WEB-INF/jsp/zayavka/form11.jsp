<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:renderURL var="popupGoalURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="goal" />
</portlet:renderURL>
<c:set var="strPopupGoalURL"><%=popupGoalURL.toString()%></c:set>

<portlet:renderURL var="popupAnalizResultsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="analizResults" />
</portlet:renderURL>
<c:set var="strPopupAnalizResultsURL"><%=popupAnalizResultsURL.toString()%></c:set>

<portlet:renderURL var="popupReserveAuthorsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="reserveAuthors" />
</portlet:renderURL>
<c:set var="strPopupReserveAuthorsURL"><%=popupReserveAuthorsURL.toString()%></c:set>

<portlet:renderURL var="popupExpediencyURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="expediency" />
</portlet:renderURL>
<c:set var="strPopupExpediencyURL"><%=popupExpediencyURL.toString()%></c:set>

<portlet:renderURL var="popupIdeaFormulationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="ideaFormulation" />
</portlet:renderURL>
<c:set var="strPopupIdeaFormulationURL"><%=popupIdeaFormulationURL.toString()%></c:set>

<portlet:renderURL var="popupIdeaInnovationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="ideaInnovation" />
</portlet:renderURL>
<c:set var="strPopupIdeaInnovationURL"><%=popupIdeaInnovationURL.toString()%></c:set>

<portlet:renderURL var="popupStructureOfStudyURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="structureOfStud" />
</portlet:renderURL>
<c:set var="strPopupStructureOfStudyURL"><%=popupStructureOfStudyURL.toString()%></c:set>
            
<portlet:renderURL var="popupResultsNirURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="resultsNir" />
</portlet:renderURL>
<c:set var="strPopupResultsNirURL"><%=popupResultsNirURL.toString()%></c:set>

<portlet:renderURL var="popupUsingResultsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="usingResults" />
</portlet:renderURL>
<c:set var="strPopupUsingResultsURL"><%=popupUsingResultsURL.toString()%></c:set>

<portlet:renderURL var="popupTeamCharacteristicURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="teamCharacteristic" />
</portlet:renderURL>
<c:set var="strPopupTeamCharacteristicURL"><%=popupTeamCharacteristicURL.toString()%></c:set>

<portlet:renderURL var="popupProvisionEquipmentURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="provisionEquipment" />
</portlet:renderURL>
<c:set var="strPopupProvisionEquipmentURL"><%=popupProvisionEquipmentURL.toString()%></c:set>

<portlet:renderURL var="popupPreviousKonkursURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="previousKonkurs" />
</portlet:renderURL>
<c:set var="strPopupPreviousKonkursURL"><%=popupPreviousKonkursURL.toString()%></c:set>

<aui:form action="${saveForm11}" method="POST" name="form11">

	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />
	
	<c:set var="nn" value="1"/>
	<spring:message code="zayavka.goal" var='goalLabel' arguments="${nn}"/>
	<aui:input name="goal" value="${zayavkaModel.goal}" id="goal" label="${goalLabel}" bean="zayavkaModel" type="textarea"/>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.analizResults" var='analizResultsLabel' arguments="${nn},${nn}"/>
	<aui:input name="analizResults" value="${zayavkaModel.analizResults}" id="analizResults" label="${analizResultsLabel}" bean="zayavkaModel" type="textarea"/>
	
	<spring:message code="zayavka.reserveAuthors" var='reserveAuthorsLabel' arguments="${nn}" />
	<aui:input name="reserveAuthors" value="${zayavkaModel.reserveAuthors}" id="reserveAuthors" label="${reserveAuthorsLabel}" bean="zayavkaModel" type="textarea"/>
	<c:if test="${zayavkaModel.intl}">
		<c:set var="nn" value="${nn+1}"/>
		<spring:message code="zayavka.expediency" var='expediencyLabel' arguments="${nn}" />
		<aui:input name="expediency" value="${zayavkaModel.expediency}" id="expediency" label="${expediencyLabel}" bean="zayavkaModel" type="textarea"/>
	</c:if>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.ideaFormulation" var='ideaFormulationLabel' arguments="${nn},${nn}"/>
	<aui:input name="ideaFormulation" value="${zayavkaModel.ideaFormulation}" id="ideaFormulation" label="${ideaFormulationLabel}" bean="zayavkaModel" type="textarea"/>

	<spring:message code="zayavka.ideaInnovation" var='ideaInnovationLabel' arguments="${nn}" />
	<aui:input name="ideaInnovation" value="${zayavkaModel.ideaInnovation}" id="ideaInnovation" label="${ideaInnovationLabel}" bean="zayavkaModel" type="textarea"/>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.structureOfStudy" var='structureOfStudyLabel' arguments="${nn}" />
	<aui:input name="structureOfStudy" value="${zayavkaModel.structureOfStudy}" id="structureOfStudy" label="${structureOfStudyLabel}" bean="zayavkaModel" type="textarea"/>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.resultsNir" var='resultsNirLabel' arguments="${nn}" />
	<aui:input name="resultsNir" value="${zayavkaModel.resultsNir}" id="resultsNir" label="${resultsNirLabel}" bean="zayavkaModel" type="textarea"/>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.usingResults" var='usingResultsLabel' arguments="${nn}" />
	<aui:input name="usingResults" value="${zayavkaModel.usingResults}" id="usingResults" label="${usingResultsLabel}" bean="zayavkaModel" type="textarea"/>

	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.teamCharacteristic" var='teamCharacteristicLabel' arguments="${nn}" />
	<aui:input name="teamCharacteristic" value="${zayavkaModel.teamCharacteristic}" id="teamCharacteristic" label="${teamCharacteristicLabel}" bean="zayavkaModel" type="textarea"/>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.provisionEquipment" var='provisionEquipmentLabel' arguments="${nn}" />
	<aui:input name="provisionEquipment" value="${zayavkaModel.provisionEquipment}" id="provisionEquipment" label="${provisionEquipmentLabel}" bean="zayavkaModel" type="textarea"/>
	
	<c:set var="nn" value="${nn+1}"/>
	<spring:message code="zayavka.previousKonkurs" var='previousKonkursLabel' arguments="${nn}"/>
	<aui:input name="previousKonkurs" value="${zayavkaModel.previousKonkurs}" id="previousKonkurs" label="${previousKonkursLabel}" bean="zayavkaModel" type="textarea"/>
	
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>
	</aui:button-row>
</aui:form>
<aui:script>
$('#${ns}goal').on('click', function(event){
   showPopup('Цель и задачи работы, ее актуальность','goal','${strPopupGoalURL}');
});
$('#${ns}analizResults').on('click', function(event){
   showPopup('Краткий анализ результатов, полученных специалистами в мире в данной области','analizResults','${strPopupAnalizResultsURL}');
});
$('#${ns}reserveAuthors').on('click', function(event){
   showPopup('Научно-практический задел авторов проекта','reserveAuthors','${strPopupReserveAuthorsURL}');
});
$('#${ns}expediency').on('click', function(event){
   showPopup('Обоснование целесообразности проведения совместных исследований','expediency','${strPopupExpediencyURL}');
});
$('#${ns}ideaFormulation').on('click', function(event){
   showPopup('Формулировка и обоснование идеи','ideaFormulation','${strPopupIdeaFormulationURL}');
});
$('#${ns}ideaInnovation').on('click', function(event){
   showPopup('Уровень новизны научной идеи (гипотезы)','ideaInnovation','${strPopupIdeaInnovationURL}');
});
$('#${ns}structureOfStudy').on('click', function(event){
   showPopup('Структура исследования','structureOfStudy','${strPopupStructureOfStudyURL}');
});
$('#${ns}resultsNir').on('click', function(event){
   showPopup('Ожидаемые результаты НИР, их научная и практическая значимость','resultsNir','${strPopupResultsNirURL}');
});
$('#${ns}usingResults').on('click', function(event){
   showPopup('Возможные области использования результатов исследования','usingResults','${strPopupUsingResultsURL}');
});
$('#${ns}teamCharacteristic').on('click', function(event){
   showPopup('Характеристика научного коллектива','teamCharacteristic','${strPopupTeamCharacteristicURL}');
});
$('#${ns}provisionEquipment').on('click', function(event){
   showPopup('Обеспеченность работы основным оборудованием, необходимым для ее выполнения','provisionEquipment','${strPopupProvisionEquipmentURL}');
});
$('#${ns}previousKonkurs').on('click', function(event){
   showPopup('Сведения об участии руководителя и основных исполнителей проекта с белорусской стороны в предыдущих конкурсах Фонда','previousKonkurs','${strPopupPreviousKonkursURL}');
});
</aui:script>
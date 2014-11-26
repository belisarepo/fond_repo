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
<div style="border-radius: 20px; background: #E0EEE0; padding: 20px; width: 90%">
	<p>
		Вы можете загрузить все одним файлом либо заполнить форму ниже<br />
		<c:choose>
			<c:when test="${not empty zayavkaModel.obosnFileName}">
				<a href="<portlet:resourceURL id="getObosnFile"><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /><portlet:param name="fileName" value="${zayavkaModel.obosnFileName}"/></portlet:resourceURL>" >${zayavkaModel.obosnFileName}</a>
				<a title='удалить' href="<portlet:actionURL><portlet:param name="action" value="deleteObosnFile"/><portlet:param name="zayavkaId" value="${zayavkaModel.id}"/></portlet:actionURL>"><span style="color:red; padding:10px;font-size:large;font-weight:700;">X</span></a>
			</c:when>
			<c:otherwise>
				<portlet:actionURL var="uploadObosnUrl">
					<portlet:param name="action" value="uploadObosn" />
					<portlet:param name="zayavkaId" value="${zayavkaModel.id}" />
					<portlet:param name="konkursId" value="${zayavkaModel.konkursId}" />
				</portlet:actionURL>
				<aui:form action="${uploadObosnUrl}" enctype="multipart/form-data" method="POST" inlineLabels="true">

					<aui:input id="fileObosn" name="fileObosn" type="file" label="" style="outline: none;"></aui:input>
					<button id="fileObosnSubmit" type="submit" style="display:none">Загрузить</button>
				</aui:form>
			</c:otherwise>
		</c:choose>
	</p>
</div>
<div id="obosnFileDiv">
	<c:if test="${not empty obosnFileText}">
		<div class="div-as-textarea" style="height:500px;">
			<div style="margin: 5px">${obosnFileText}</div>
		</div>
	</c:if>
</div>
<div id="obosnFormDiv">
<aui:form action="${saveForm11}" method="POST" name="form11">

	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr />


	<c:set var="nn" value="1" />
	<spring:message code="zayavka.goal" var='goalLabel' arguments="${nn}" />
	<aui:input name="goal" value="${zayavkaModel.goal}" id="goal" label="${goalLabel}" bean="zayavkaModel" type="hidden" />
	<label>${goalLabel}</label>
	<div id="goalDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.analizResults" var='analizResultsLabel' arguments="${nn},${nn}" />
	<aui:input name="analizResults" value="${zayavkaModel.analizResults}" id="analizResults" label="${analizResultsLabel}" bean="zayavkaModel"
		type="hidden" />
	<label>${analizResultsLabel}"</label>
	<div id="analizResultsDiv" class='div-as-textarea'></div>

	<spring:message code="zayavka.reserveAuthors" var='reserveAuthorsLabel' arguments="${nn}" />
	<aui:input name="reserveAuthors" value="${zayavkaModel.reserveAuthors}" id="reserveAuthors" label="${reserveAuthorsLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${reserveAuthorsLabel}</label>
	<div id="reserveAuthorsDiv" class='div-as-textarea'></div>
	<c:if test="${zayavkaModel.intl}">
		<c:set var="nn" value="${nn+1}" />
		<spring:message code="zayavka.expediency" var='expediencyLabel' arguments="${nn}" />
		<aui:input name="expediency" value="${zayavkaModel.expediency}" id="expediency" label="${expediencyLabel}" bean="zayavkaModel"
			type="hidden" />
		<label>${expediencyLabel}</label>
		<div id="expediencyDiv" class='div-as-textarea'></div>
	</c:if>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.ideaFormulation" var='ideaFormulationLabel' arguments="${nn},${nn}" />
	<aui:input name="ideaFormulation" value="${zayavkaModel.ideaFormulation}" id="ideaFormulation" label="${ideaFormulationLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${ideaFormulationLabel}</label>
	<div id="ideaFormulationDiv" class='div-as-textarea'></div>

	<spring:message code="zayavka.ideaInnovation" var='ideaInnovationLabel' arguments="${nn}" />
	<aui:input name="ideaInnovation" value="${zayavkaModel.ideaInnovation}" id="ideaInnovation" label="${ideaInnovationLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${ideaInnovationLabel}</label>
	<div id="ideaInnovationDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.structureOfStudy" var='structureOfStudyLabel' arguments="${nn}" />
	<aui:input name="structureOfStudy" value="${zayavkaModel.structureOfStudy}" id="structureOfStudy" label="${structureOfStudyLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${structureOfStudyLabel}</label>
	<div id="structureOfStudyDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.resultsNir" var='resultsNirLabel' arguments="${nn}" />
	<aui:input name="resultsNir" value="${zayavkaModel.resultsNir}" id="resultsNir" label="${resultsNirLabel}" bean="zayavkaModel"
		type="hidden" />
	<label>${resultsNirLabel}</label>
	<div id="resultsNirDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.usingResults" var='usingResultsLabel' arguments="${nn}" />
	<aui:input name="usingResults" value="${zayavkaModel.usingResults}" id="usingResults" label="${usingResultsLabel}" bean="zayavkaModel"
		type="hidden" />
	<label>${usingResultsLabel}</label>
	<div id="usingResultsDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.teamCharacteristic" var='teamCharacteristicLabel' arguments="${nn}" />
	<aui:input name="teamCharacteristic" value="${zayavkaModel.teamCharacteristic}" id="teamCharacteristic" label="${teamCharacteristicLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${teamCharacteristicLabel}</label>
	<div id="teamCharacteristicDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.provisionEquipment" var='provisionEquipmentLabel' arguments="${nn}" />
	<aui:input name="provisionEquipment" value="${zayavkaModel.provisionEquipment}" id="provisionEquipment" label="${provisionEquipmentLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${provisionEquipmentLabel}</label>
	<div id="provisionEquipmentDiv" class='div-as-textarea'></div>

	<c:set var="nn" value="${nn+1}" />
	<spring:message code="zayavka.previousKonkurs" var='previousKonkursLabel' arguments="${nn}" />
	<aui:input name="previousKonkurs" value="${zayavkaModel.previousKonkurs}" id="previousKonkurs" label="${previousKonkursLabel}"
		bean="zayavkaModel" type="hidden" />
	<label>${previousKonkursLabel}</label>
	<div id="previousKonkursDiv" class='div-as-textarea'></div>


</aui:form>
</div>
<aui:script>
$('#${ns}fileObosn').change(function(){
	if ($(this).val()){
		$('#fileObosnSubmit').css('display','block');
	}else{
		$('#fileObosnSubmit').css('display','none');
	}
	
});

var isObosnFile = '${zayavkaModel.obosnFileName}';
if(isObosnFile){
	$('#obosnFormDiv').css('display','none');
	$('#obosnFileDiv').css('display','block');
}else{
	$('#obosnFormDiv').css('display','block');
	$('#obosnFileDiv').css('display','none');
}



$('#goalDiv').on('click', function(event){
   showPopup('Цель и задачи работы, ее актуальность','goal','${strPopupGoalURL}');
});
$('#goalDiv').html($('#${ns}goal').val());
$('#analizResultsDiv').on('click', function(event){
   showPopup('Краткий анализ результатов, полученных специалистами в мире в данной области','analizResults','${strPopupAnalizResultsURL}');
});
$('#analizResultsDiv').html($('#${ns}analizResults').val());
$('#reserveAuthorsDiv').on('click', function(event){
   showPopup('Научно-практический задел авторов проекта','reserveAuthors','${strPopupReserveAuthorsURL}');
});
$('#reserveAuthorsDiv').html($('#${ns}reserveAuthors').val());
$('#expediencyDiv').on('click', function(event){
   showPopup('Обоснование целесообразности проведения совместных исследований','expediency','${strPopupExpediencyURL}');
});
$('#expediencyDiv').html($('#${ns}expediency').val());
$('#ideaFormulationDiv').on('click', function(event){
   showPopup('Формулировка и обоснование идеи','ideaFormulation','${strPopupIdeaFormulationURL}');
});
$('#ideaFormulationDiv').html($('#${ns}ideaFormulation').val());
$('#ideaInnovationDiv').on('click', function(event){
   showPopup('Уровень новизны научной идеи (гипотезы)','ideaInnovation','${strPopupIdeaInnovationURL}');
});
$('#ideaInnovationDiv').html($('#${ns}ideaInnovation').val());
$('#structureOfStudyDiv').on('click', function(event){
   showPopup('Структура исследования','structureOfStudy','${strPopupStructureOfStudyURL}');
});
$('#structureOfStudyDiv').html($('#${ns}structureOfStudy').val());
$('#resultsNirDiv').on('click', function(event){
   showPopup('Ожидаемые результаты НИР, их научная и практическая значимость','resultsNir','${strPopupResultsNirURL}');
});
$('#resultsNirDiv').html($('#${ns}resultsNir').val());
$('#usingResultsDiv').on('click', function(event){
   showPopup('Возможные области использования результатов исследования','usingResults','${strPopupUsingResultsURL}');
});
$('#usingResultsDiv').html($('#${ns}usingResults').val());
$('#teamCharacteristicDiv').on('click', function(event){
   showPopup('Характеристика научного коллектива','teamCharacteristic','${strPopupTeamCharacteristicURL}');
});
$('#teamCharacteristicDiv').html($('#${ns}teamCharacteristic').val());
$('#provisionEquipmentDiv').on('click', function(event){
   showPopup('Обеспеченность работы основным оборудованием, необходимым для ее выполнения','provisionEquipment','${strPopupProvisionEquipmentURL}');
});
$('#provisionEquipmentDiv').html($('#${ns}provisionEquipment').val());
$('#previousKonkursDiv').on('click', function(event){
   showPopup('Сведения об участии руководителя и основных исполнителей проекта с белорусской стороны в предыдущих конкурсах Фонда','previousKonkurs','${strPopupPreviousKonkursURL}');
});
$('#previousKonkursDiv').html($('#${ns}previousKonkurs').val());
</aui:script>
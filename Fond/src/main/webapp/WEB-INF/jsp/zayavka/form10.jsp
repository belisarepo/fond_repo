<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:renderURL var="popupKeyWordsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="keyWords" />
</portlet:renderURL>
<c:set var="strPopupKeyWordsUrl"><%=popupKeyWordsURL.toString()%></c:set>

<portlet:renderURL var="popupJobGoalURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="jobGoal" />
</portlet:renderURL>
<c:set var="strPopupJobGoalUrl"><%=popupJobGoalURL.toString()%></c:set>

<portlet:renderURL var="popupIdeaURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="idea" />
</portlet:renderURL>
<c:set var="strPopupIdeaUrl"><%=popupIdeaURL.toString()%></c:set>

<portlet:renderURL var="popupResultsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="results" />
</portlet:renderURL>
<c:set var="strPopupResultsUrl"><%=popupResultsURL.toString()%></c:set>
<div style="border-radius: 20px; background: #E0EEE0; padding: 20px; width: 90%">
	<p>
		Вы можете загрузить все одним файлом либо заполнить форму ниже<br />
		<c:choose>
			<c:when test="${not empty zayavkaModel.annotationFileName}">
				<a href="<portlet:resourceURL id="getAnnotationFile"><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /><portlet:param name="fileName" value="${zayavkaModel.annotationFileName}"/></portlet:resourceURL>" >${zayavkaModel.annotationFileName}</a>
				<a title='удалить' href="<portlet:actionURL><portlet:param name="action" value="deleteAnnotationFile"/><portlet:param name="zayavkaId" value="${zayavkaModel.id}"/></portlet:actionURL>"><span style="color:red; padding:10px;font-size:large;font-weight:700;">X</span></a>
			</c:when>
			<c:otherwise>
				<portlet:actionURL var="uploadAnnotationUrl">
					<portlet:param name="action" value="uploadAnnotation" />
					<portlet:param name="zayavkaId" value="${zayavkaModel.id}" />
					<portlet:param name="konkursId" value="${zayavkaModel.konkursId}" />
				</portlet:actionURL>
				<aui:form action="${uploadAnnotationUrl}" enctype="multipart/form-data" method="POST" inlineLabels="true">

					<aui:input id="fileAnnotation" name="fileAnnotation" type="file" label="" style="outline: none;"></aui:input>
					<button id="fileAnnotationSubmit" type="submit" style="display:none;">Загрузить</button>
				</aui:form>
			</c:otherwise>
		</c:choose>
	</p>
</div>
<div id="annotationFileDiv">
	<c:if test="${not empty annotationFileText}">
		<div class="div-as-textarea" style="height:500px;">
			<div style="margin: 5px">${annotationFileText}</div>
		</div>
	</c:if>
</div>
<div id="annotationFormDiv">
<aui:form action="${saveForm10}" method="POST" name="form10">

	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr />

	<spring:message code="zayavka.keyWords" var='keyWordsLabel' />
	<aui:input name="keyWords" value="${zayavkaModel.keyWords}" id="keyWords" label="${keyWordsLabel}" bean="zayavkaModel" type="hidden" />
	<label>${keyWordsLabel}</label>
	<div id="keyWordsDiv" class='div-as-textarea'></div>

	<spring:message code="zayavka.jobGoal" var='jobGoalLabel' />
	<aui:input name="jobGoal" value="${zayavkaModel.jobGoal}" id="jobGoal" label="${jobGoalLabel}" bean="zayavkaModel" type="hidden" />
	<label>${jobGoalLabel}</label>
	<div id="jobGoalDiv" class='div-as-textarea'></div>

	<spring:message code="zayavka.idea" var='ideaLabel' />
	<aui:input name="idea" value="${zayavkaModel.idea}" id="idea" label="${ideaLabel}" bean="zayavkaModel" type="hidden" />
	<label>${ideaLabel}</label>
	<div id="ideaDiv" class='div-as-textarea'></div>

	<spring:message code="zayavka.results" var='resultsLabel' />
	<aui:input name="results" value="${zayavkaModel.results}" id="results" label="${resultsLabel}" bean="zayavkaModel" type="hidden" />
	<label>${resultsLabel}</label>
	<div id="resultsDiv" class='div-as-textarea'></div>


</aui:form>
</div>

<aui:script>

$('#${ns}fileAnnotation').change(function(){
	if ($(this).val()){
		$('#fileAnnotationSubmit').css('display','block');
	}else{
		$('#fileAnnotationSubmit').css('display','none');
	}
	
});

var isAnnotationFile = '${zayavkaModel.annotationFileName}';
if(isAnnotationFile){
	$('#annotationFormDiv').css('display','none');
	$('#annotationFileDiv').css('display','block');
}else{
	$('#annotationFormDiv').css('display','block');
	$('#annotationFileDiv').css('display','none');
}


// add Show Popup
//===============================================================
$('#keyWordsDiv').on('click', function(event){
   showPopup('Ключевые слова','keyWords','${strPopupKeyWordsUrl}');
});
$('#keyWordsDiv').html($('#${ns}keyWords').val());

$('#jobGoalDiv').on('click', function(event){
   showPopup('Цель работы','jobGoal','${strPopupJobGoalUrl}');
});
$('#jobGoalDiv').html($('#${ns}jobGoal').val());

$('#ideaDiv').on('click', function(event){
   showPopup('Научная идея (гипотеза) авторов','idea','${strPopupIdeaUrl}');
});
$('#ideaDiv').html($('#${ns}idea').val());

$('#resultsDiv').on('click', function(event){
   showPopup('Основные планируемые результаты, их научная и практическая значимость','results','${strPopupResultsUrl}');
});
$('#resultsDiv').html($('#${ns}results').val());
//==============================================================

</aui:script>
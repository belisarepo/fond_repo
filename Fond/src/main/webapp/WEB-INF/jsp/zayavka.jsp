<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>

<portlet:actionURL var="saveZayavka">
</portlet:actionURL>
<portlet:actionURL var="saveForm1">
	<portlet:param name="form" value="form1" />
</portlet:actionURL>
<portlet:actionURL var="saveForm2">
	<portlet:param name="form" value="form2" />
</portlet:actionURL>
<portlet:actionURL var="saveForm3">
	<portlet:param name="form" value="form3" />
</portlet:actionURL>
<portlet:actionURL var="saveForm4">
	<portlet:param name="form" value="form4" />
</portlet:actionURL>
<portlet:actionURL var="saveForm5">
	<portlet:param name="form" value="form5" />
</portlet:actionURL>
<portlet:actionURL var="addIspolnitelAction">
	<portlet:param name="action" value="addIspolnitel" />
	<portlet:param name="konkursId" value="${zayavka.konkursId}" />
</portlet:actionURL>

<portlet:renderURL var="popupTemaNameURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="temaName" />
</portlet:renderURL>
<c:set var="strPopupTemaNameUrl"><%=popupTemaNameURL.toString()%></c:set>
<center>
	<div id="successMessageContainer"></div>
</center>
<div id="myTab" class="tabs-left">

	<ul class="nav nav-tabs ">
		<li><a href="#tab-1"><spring:message code="zayavka.tab1" /></a></li>
		<li><a href="#tab-2"><spring:message code="zayavka.tab2" /></a></li>
		<li><a href="#tab-3"><spring:message code="zayavka.tab3" /></a></li>
		<li><a href="#tab-4"><spring:message code="zayavka.tab4" /></a></li>
		<li><a href="#tab-5"><spring:message code="zayavka.tab5" /></a></li>
		<li><a href="#tab-6"><spring:message code="zayavka.ispolniteli" /></a></li>
	</ul>

	<div class="tab-content">

		<div id="tab-1" class="tab-pane">
			<aui:form action="${saveForm1}" method="POST" name="form1">
				<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
				<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

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

				<spring:message code="zayavka.prioritetNauka" var='prioritetNaukaLabel' />
				<aui:select name="prioritetNaukaId" label="${prioritetNaukaLabel}" bean="zayavkaModel">
					<option value="" />
					<c:forEach var="i" items="${prioritetNaukaList}">
						<aui:option value="${i.id}" label="${i.name}" selected="${i.id==zayavkaModel.prioritetNaukaId}" />
					</c:forEach>
				</aui:select>

				<spring:message code="zayavka.otraslNauka" var='otraslNaukaLabel' />
				<aui:select name="otraslNaukaId" label="${otraslNaukaLabel}" bean="zayavkaModel">
					<option value="" />
					<c:forEach var="i" items="${otraslNaukaList}">
						<aui:option value="${i.id}" label="${i.name}" selected="${i.id==zayavkaModel.otraslNaukaId}" />
					</c:forEach>
				</aui:select>

				<spring:message code="zayavka.temaName" var='temaNameLabel' />
				<aui:input name="temaName" value="${zayavkaModel.temaName}" id="temaName" label="${temaNameLabel}" bean="zayavkaModel" />

				<spring:message code="zayavka.udk" var='udkLabel' />
				<aui:input name="udk" value="${zayavkaModel.udk}" label="${udkLabel}" bean="zayavkaModel" />

				<aui:button-row>
					<div align="left">
						<aui:button type="submit" value="Сохранить" />
					</div>
				</aui:button-row>
			</aui:form>

		</div>
		<div id="tab-2" class="tab-pane">


			<aui:form action="${saveForm2}" method="POST" name="form2">
				<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
				<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

				<spring:message code="zayavka.fioRuk" var='fioRukLabel' />
				<aui:input name="fioRk" value="${zayavkaModel.fioRk}" disabled="true" label="${fioRukLabel}" bean="zayavkaModel" />

				<spring:message code="zayavka.fioFullRuk" var='fioFullRukLabel' />
				<aui:input name="fullFioRk" value="${zayavkaModel.fullFioRk}" disabled="true" label="${fioFullRukLabel}" bean="zayavkaModel" />

				<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
				<aui:input name="birthdayRk" value="${zayavkaModel.birthdayRk}" label='${birthdayLabel}' bean="zayavkaModel" cssClass="datapick">
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
				<aui:input name="postRk" value="${zayavkaModel.postRk}" label='${postLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.lab' var='labLabel' />
				<aui:input name="labRk" value="${zayavkaModel.labRk}" label='${labLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.jobPhone' var='jobPhoneLabel' />
				<aui:input name="jobPhoneRk" value="${zayavkaModel.jobPhoneRk}" label='${jobPhoneLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.homePhone' var='homePhoneLabel' />
				<aui:input name="homePhoneRk" value="${zayavkaModel.homePhoneRk}" label='${homePhoneLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.mobilePhone' var='mobilePhoneLabel' />
				<aui:input name="mobilePhoneRk" value="${zayavkaModel.mobilePhoneRk}" label='${mobilePhoneLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.email' var='emailLabel' />
				<aui:input name="emailRk" value="${zayavkaModel.emailRk}" label='${emailLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.address' var='addressLabel' />
				<aui:input name="addressRk" value="${zayavkaModel.addressRk}" label='${addressLabel}' bean="zayavkaModel"></aui:input>

				<aui:button-row>
					<div align="left">
						<aui:button type="submit" value="Сохранить" />
					</div>
				</aui:button-row>
			</aui:form>
			<%-- <form:form modelAttribute='${ns}zayavkaModel' method="POST" action="${saveZayavka}" name="zayavka">
				<form:hidden path="id" />
				<form:hidden path="konkursId" />
				<form:hidden path="userId" />
				<form:label path="konkursNameR">Название конкурса</form:label>
				<form:input path="konkursNameR" disabled="true" />
				<form:label path="temaName">Тема заявки</form:label>
				<form:input path="temaName" id="temaName" onclick="showPopup('Тема заявки','temaName','${strUrl}')" />
				<form:label path="sectionFondId">Секция фонда</form:label>
				<form:select path="sectionFondId" items="${sectionFondList}" itemValue="id" itemLabel="nameR" class="chosen"></form:select>
				<form:label path="otraslNaukaId">Отрасль науки</form:label>
				<form:select path="otraslNaukaId" items="${otraslNaukaList}" itemLabel="name" itemValue="id" class="chosen"></form:select>
				<form:label path="prioritetNaukaId">Приоритет науки</form:label>
				<form:select path="prioritetNaukaId" items="${prioritetNaukaList}" itemLabel="name" itemValue="id" class="chosen"></form:select>
				<form:label path="orgId">Организация заявитель</form:label>
				<form:select path="orgId" items="${listOrg}" itemValue="id" itemLabel="name" class="chosen">
					<option></option>
				</form:select>
				<form:label path="ispolniteli">Исполнители</form:label>
				<form:select path="ispolniteli" items="${fizInfoList}" itemValue="id" itemLabel="surname" class="chosen" multiple="true"></form:select>
				<aui:button-row>
					<div align="left">
						<aui:button type="submit" />
					</div>
				</aui:button-row>
			</form:form> --%>
		</div>
		<div id="tab-3" class="tab-pane">
			<aui:form action="${saveForm3}" method="POST" name="form3">
				<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
				<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />


				<spring:message code="zayavka.orgZRB" var='orgZRBLabel' />
				<aui:select name="orgId" bean="zayavkaModel" label='${orgZRBLabel}' id="orgSelect">
					<option value="" />
					<c:forEach var="i" items="${listOrg}">
						<aui:option value="${i.id}" label="${i.name}" selected="${i.id==zayavkaModel.orgId}" />
					</c:forEach>
				</aui:select>
				<spring:message code='zayavka.email' var='emailLabel' />
				<aui:input id="orgEmailRb" disabled="true" name="orgEmail" value="${zayavkaModel.orgEmail}" label='${emailLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.okogu' var='okoguLabel' />
				<aui:input id="okoguRb" disabled="true" name="okoguName" value="${zayavkaModel.okoguName}" label='${okoguLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.addressOrg' var='addressOrgLabel' />
				<aui:input id="orgAddressRb" disabled="true" name="orgAddress" value="${zayavkaModel.orgAddress}" label='${addressOrgLabel}'
					bean="zayavkaModel"></aui:input>

				<aui:button-row>
					<div align="left">
						<aui:button type="submit" value="Сохранить" />
					</div>
				</aui:button-row>
			</aui:form>
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		</div>
		<div id="tab-4" class="tab-pane">
			<aui:form action="${saveForm4}" method="POST" name="form4">
				<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
				<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

				<spring:message code="zayavka.fioRuk" var='fioRukLabel' />
				<aui:input name="fioRkNr" value="${zayavkaModel.fioRkNr}" label="${fioRukLabel}" bean="zayavkaModel" >
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.fioFullRuk" var='fioFullRukLabel' />
				<aui:input name="fullFioRkNr" value="${zayavkaModel.fullFioRkNr}" label="${fioFullRukLabel}" bean="zayavkaModel" >
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
				<aui:input name="birthdayRkNr" value="${zayavkaModel.birthdayRkNr}" label='${birthdayLabel}' bean="zayavkaModel" cssClass="datapick">
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

				<aui:button-row>
					<div align="left">
						<aui:button type="submit" value="Сохранить" />
					</div>
				</aui:button-row>
			</aui:form>
		</div>
		
		<div id="tab-5" class="tab-pane">
			<aui:form action="${saveForm5}" method="POST" name="form5">
				<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
				<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />


				<spring:message code="zayavka.orgZNr" var='orgZNrLabel' />
				<aui:select name="orgNrId" bean="zayavkaModel" label='${orgZNrLabel}' id="orgNrSelect">
					<option value="" />
					<c:forEach var="i" items="${orgNrList}">
						<aui:option value="${i.id}" label="${i.nameR}" selected="${i.id==zayavkaModel.orgNrId}" />
					</c:forEach>
				</aui:select>
				<spring:message code='zayavka.email' var='emailOrgNrLabel' />
				<aui:input id="orgNrEmail" disabled="true" name="orgNrEmail" value="${zayavkaModel.orgNrEmail}" label='${emailOrgNrLabel}' bean="zayavkaModel"></aui:input>

				<spring:message code='zayavka.addressOrg' var='addressOrgLabel' />
				<aui:input id="orgNrAddress" disabled="true" name="orgNrAddress" value="${zayavkaModel.orgNrAddress}" label='${addressOrgLabel}'
					bean="zayavkaModel"></aui:input>

				<aui:button-row>
					<div align="left">
						<aui:button type="submit" value="Сохранить" />
					</div>
				</aui:button-row>
			</aui:form>
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		</div>
		
		<div id="tab-6" class="tab-pane">

			<c:if test="${not empty ispolniteliList}">
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
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ispolniteliList}" var="i">
							<tr>
								<td>${i.surname}</td>
								<td>${i.name}</td>
								<td>${i.patronymic}</td>
								<td>${i.birthday}</td>
								<td>${i.uchStepeniName}</td>
								<td>${i.uchZvaniyName}</td>
								<td>${i.orgName}</td>
								<td>${i.post}</td>
								<td><a
									href="<portlet:actionURL><portlet:param name="action" value="deleteIspolnitel"/><portlet:param name="ispolnitelId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /></portlet:actionURL>">Удалить</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>


			<aui:form action="${addIspolnitelAction}" method="POST" name="form6">

				<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
				<spring:message code="zayavka.surname" var='surnameLabel' />
				<aui:input name="surname" label='${surnameLabel}' bean="ispolnitelModel">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.name" var='nameLabel' />
				<aui:input name="name" label='${nameLabel}' bean="ispolnitelModel">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.patronymic" var='patronymicLabel' />
				<aui:input name="patronymic" label='${patronymicLabel}' bean="ispolnitelModel">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.birthdayManager" var='birthdayLabel' />
				<aui:input name="birthday" label='${birthdayLabel}' bean="ispolnitelModel" cssClass="datapick">
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
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		</div>
	</div>
</div>




<aui:script>
$(document).ready(function() {
	$('select').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		width : '206px'
	});

	$('.datapick').datepick({
		dateFormat : 'dd-mm-yyyy',
		onClose : function(dates) {
			$(this).focus();
			$(this).datepick('performAction', 'close');
			$(this).blur();$(this).focus();
		}
	});

	$('#${ns}orgSelect').on('change', function(evt, params) {
		var orgId = $(evt.target).val();

		$.ajax({
			dataType : 'json',
			url : '<portlet:resourceURL id="getOrgById" />',
			data : {
				<portlet:namespace />orgId : orgId
			},
			success : function(jsondata) {
				$('#${ns}orgEmailRb').val(jsondata.email);
				$('#${ns}orgAddressRb').val(jsondata.address);
				$('#${ns}okoguRb').val(jsondata.okoguName);

			}
		});
	});
	
	$('#${ns}orgNrSelect').on('change', function(evt, params) {
		var orgId = $(evt.target).val();

		$.ajax({
			dataType : 'json',
			url : '<portlet:resourceURL id="getOrgNrById" />',
			data : {
				<portlet:namespace />orgId : orgId
			},
			success : function(jsondata) {
				$('#${ns}orgNrEmail').val(jsondata.email);
				$('#${ns}orgNrAddress').val(jsondata.address);
			}
		});
	});
});

AUI().use(
  'aui-base',
  'aui-tabview',
  'liferay-notice',
  'history',
  'liferay-util-window',
  'aui-io-plugin-deprecated',
  function(Y) {

// Show Popup
//===============================================================  	
Y.one('#${ns}temaName').on('click', function(event){
   showPopup('Тема заявки','temaName','${strPopupTemaNameUrl}');
});
function showPopup(title, input_id, popup_page_url) {

	var saveButton = [ {
		label : 'Save',
		on : {
			click : function() {
				getDataFromPopup(input_id);
			}
		}
	} ];
	var closeButton = [ {
		cssClass : 'close',
		label : '\u00D7',
		render : true,
		on : {
			click : function() {
				<portlet:namespace />textDialog.hide();
			}
		}
	} ];

	<portlet:namespace />textDialog = Liferay.Util.Window.getWindow({
		height : '50%',
		dialog : {
			align : Liferay.Util.Window.ALIGN_CENTER,
			centered : true,
			constrain2view : false,
			modal : true,
			resizable : false,
			width : '70%',

			toolbars : {
				footer : saveButton,
				header : closeButton
			},
		},
		title : title
	}).plug(Y.Plugin.IO, {
		uri : popup_page_url
	}).render();
}

//=================================================================================  
// Render Tabs
//=============================================================
var tabview = new Y.TabView({
	srcNode : '#myTab'
}).render();
if (sessionStorage.getItem('tab')) {
	tabview.selectChild(sessionStorage.getItem('tab') || 0);
}

tabview.after('selectionChange', function(e) {
	sessionStorage.setItem('tab', e.newVal.get('index') || 0);
});
//============================================================
// Show success message
//==============================================================	
var save_result = '${save_result}';
if (save_result) {
	showSuccess();
}

function showSuccess() {

	var successMessageContainer = Y.one('#successMessageContainer');
	var banner = new Liferay.Notice({
		animationConfig : {
			duration : 0.1,
			top : '50%',
			left : '50%'

		},
		content : '<div class="alert alert-success">Сохранено</div>',
		closeText : false,
		node : '#successMessageContainer',
		type : 'notice',
		toggleText : false,
		timeout : 1000,
		useAnimation : false

	});

	banner.show();
}
//==============================================================

});
</aui:script>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="addOrg" var="addOrgUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="addOrgForm" id="addOrgForm">
	<spring:message code="zayavka.full_name_rus" var="full_name_rusLabel"/>
	<aui:input name="full_name_rus" bean="orgModel" label="${full_name_rusLabel}"></aui:input>
	
	<spring:message code="zayavka.full_name_eng" var="full_name_engLabel"/>
	<aui:input name="full_name_eng" bean="orgModel" label="${full_name_engLabel}"></aui:input>
	
	<spring:message code="zayavka.shortName" var="orgNameLabel"/>
	<aui:input name="name" bean="orgModel" label="${orgNameLabel}"></aui:input>
	
	<spring:message code="zayavka.unp" var="unpLabel"/>
	<aui:input name="unp" bean="orgModel" label="${unpLabel}"></aui:input>
	
	<%-- <spring:message code="zayavka.vidOrg" var="vidOrgLabel"/>
	<aui:select id="popupVidOrg" name="vidOrgId" label="${vidOrgLabel}" bean="orgModel">
		<option value="" />
		<c:forEach var="i" items="${vidOrgList}">
			<aui:option value="${i.id}" label="${i.name}"/>
		</c:forEach>
	</aui:select> --%>
	
	<spring:message code="zayavka.adr" var="addressLabel"/>
	<aui:input name="address" bean="orgModel" label="${addressLabel}"></aui:input>
	
	<spring:message code="zayavka.email" var="emailLabel"/>
	<aui:input name="email" bean="orgModel" label="${emailLabel}"></aui:input>
	
	<%-- <spring:message code="zayavka.kod_booker" var="kod_bookerLabel"/>
	<aui:input name="kod_booker" bean="orgModel" label="${kod_bookerLabel}"></aui:input> --%>
	
	<spring:message code="zayavka.okogu" var="okoguLabel"/>
	<aui:select id="popupOkogu" name="okoguId" label="${okoguLabel}" bean="orgModel">
		<option value="" />
		<c:forEach var="i" items="${okoguList}">
			<aui:option value="${i.id}" label="${i.fullName}"/>
		</c:forEach>
	</aui:select>
</aui:form>
<aui:script>

	$('#${ns}popupOkogu,#${ns}popupVidOrg').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		width : '91%',
		search_contains:true
	});
	
	$('#popupSaveBtn').click(function(){
		var data = {"name":$('#${ns}name').val(),
					"full_name_rus":$('#${ns}full_name_rus').val(),
					"full_name_eng":$('#${ns}full_name_eng').val(),
					"unp":$('#${ns}unp').val(),
					<!-- "vidOrgId":$('#${ns}popupVidOrg').val(), -->
					"address":$('#${ns}address').val(),
					"email":$('#${ns}email').val(),
					<!-- "kod_booker":$('#${ns}kod_booker').val(), -->
					"okoguId":$('#${ns}popupOkogu').val()};
		$.ajax({
		   url: '${addOrgUrl}',
		   dataType: 'json',
		   data: data,
		   success: function(data){
		   				var parentSelect = Liferay.Util.getOpener().document.getElementById('${ns}'+'orgSelect');
		   				
		   				$(parentSelect).append($("<option></option>").attr("selected",true).attr("value",data['id']).text(data['name']));
		   				isChanged = true;
						changedForm = $(parentSelect).closest("form");
						<portlet:namespace />textDialog.hide();
						submitFondForm();
		   			}
		 });
	});

</aui:script>
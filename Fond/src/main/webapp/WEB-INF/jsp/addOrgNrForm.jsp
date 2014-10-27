<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="addOrgNr" var="addOrgNrUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="addOrgNrForm" id="addOrgNrForm">
	<spring:message code="zayavka.full_name_rus" var="name_rusLabel"/>
	<aui:input name="fullName" bean="orgNrModel" label="${name_rusLabel}"></aui:input>
	
	<spring:message code="zayavka.name_eng" var="name_engLabel"/>
	<aui:input name="nameE" bean="orgNrModel" label="${name_engLabel}"></aui:input>
	
	<%-- <spring:message code="zayavka.fullName" var="fullNameLabel"/>
	<aui:input name="fullName" bean="orgNrModel" label="${fullNameLabel}"></aui:input> --%>
	<spring:message code="zayavka.oksm" var="oksmLabel"/>
	<c:choose>
		<c:when test="${empty orgNrModel.oksmId}">
			<aui:select name="oksmId" label="${oksmLabel}" bean="orgNrModel">
				<option value="" />
				<c:forEach var="i" items="${oksmList}">
					<aui:option value="${i.id}" label="${i.nameR}" />
				</c:forEach>
			</aui:select>
		</c:when>
		<c:otherwise>
			<aui:input name="oksmId" bean="orgNrModel" value="${orgNrModel.oksmId}" type="hidden"></aui:input>
			<aui:input name="oksmName" bean="orgNrModel" value="${orgNrModel.oksmName}" disabled="true" label="${oksmLabel}"></aui:input>
		</c:otherwise>
	</c:choose>
	
	
	<spring:message code="zayavka.adr" var="addressLabel"/>
	<aui:input name="address" bean="orgNrModel" label="${addressLabel}"></aui:input>
	
	<spring:message code="zayavka.email" var="emailLabel"/>
	<aui:input name="email" bean="orgNrModel" label="${emailLabel}"></aui:input>
	
	<%-- <spring:message code="zayavka.vidOrg" var="vidOrgLabel"/>
	<aui:select id="popupVidOrg" name="vidOrgId" label="${vidOrgLabel}" bean="orgNrModel">
		<option value="" />
		<c:forEach var="i" items="${vidOrgList}">
			<aui:option value="${i.id}" label="${i.name}"/>
		</c:forEach>
	</aui:select> --%>
	
	
</aui:form>
<aui:script>

	$('#${ns}popupOksm,#${ns}popupVidOrg').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		width : '91%',
		search_contains:true
	});
	
	$('#popupSaveBtn').click(function(){
		var data = {<!-- "nameR":$('#${ns}nameR').val(), -->
					"nameE":$('#${ns}nameE').val(),
					"fullName":$('#${ns}fullName').val(),
					"oksmId":$('#${ns}oksmId').val(),
					<!-- "vidOrgId":$('#${ns}popupVidOrg').val(), -->
					"address":$('#${ns}address').val(),
					"email":$('#${ns}email').val()};
		$.ajax({
		   url: '${addOrgNrUrl}',
		   dataType: 'json',
		   data: data,
		   success: function(data){
		   				var parentSelect = Liferay.Util.getOpener().document.getElementById('${ns}'+'orgNrSelect');
		   				
		   				$(parentSelect).append($("<option></option>").attr("selected",true).attr("value",data['id']).text(data['name']));
		   				isChanged = true;
						changedForm = $(parentSelect).closest("form");
						<portlet:namespace />textDialog.hide();
						submitFondForm();
		   			}
		 });
	});

</aui:script>
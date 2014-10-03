<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editPublicationM" var="editPublicationMUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editPublicationMForm" id="editPublicationMForm">
	<aui:input id="id" name="id" type="hidden" value="${publMModel.id}" />
	
	<spring:message code="zayavka.publName" var='publNameLabel' />
				<aui:input id="name" name="name" label='${publNameLabel}' bean="publMModel" showRequiredLabel="" value="${publMModel.name}">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.publIzdanie" var='publIzdanieLabel' />
				<aui:input id="edition" name="edition" label='${publIzdanieLabel}' bean="publMModel" showRequiredLabel="" value="${publMModel.edition}">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.pages" var='pagesLabel' />
				<aui:input id="pages" name="pages" label='${pagesLabel}' bean="publMModel" showRequiredLabel="" value="${publMModel.pages}">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.soauthors" var='soauthorsLabel' />
				<aui:input id="authors" name="authors" label='${soauthorsLabel}' bean="publMModel" showRequiredLabel="" value="${publMModel.authors}">
					<aui:validator name="required" />
				</aui:input>

</aui:form>
<aui:script>
$(document).ready(function() {
	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
		   		  	"name":$('#${ns}name').val(),
		   		  	"edition":$('#${ns}edition').val(),
		   		  	"pages":$('#${ns}pages').val(),
		   		  	"authors":$('#${ns}authors').val()};
		$.ajax({
		   url: '${editPublicationMUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById('publM'+data['id']);
						 $(parentTR).children('td').eq(2).html(data['name']);
						 $(parentTR).children('td').eq(3).html(data['edition']);
						 $(parentTR).children('td').eq(4).html(data['pages']);
						 $(parentTR).children('td').eq(5).html(data['authors']);
						 
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});
});
</aui:script>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editPublication" var="editPublicationUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editPublicationForm" id="editPublicationForm">
	<aui:input id="id" name="id" type="hidden" value="${publModel.id}" />
	
	<spring:message code="zayavka.publName" var='publNameLabel' />
	<aui:input id="name" name="name" label='${publNameLabel}' bean="publModel" showRequiredLabel="" type="textarea" value='${publModel.name}'>
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.publIzdanie" var='publIzdanieLabel' />
	<aui:input id="edition" name="edition" label='${publIzdanieLabel}' bean="publModel" showRequiredLabel="" type="textarea" value='${publModel.edition}'>
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.fullListAutors" var='fullListAutorsLabel' />
	<aui:input id="authors" name="authors" label='${fullListAutorsLabel}' bean="publModel" showRequiredLabel="" type="textarea" value='${publModel.authors}'>
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.publIndex" var='publIndexLabel' />
	<aui:input id="citationIndex" name="citationIndex" label='${publIndexLabel}' bean="publModel" value='${publModel.citationIndex}'>
	</aui:input>

	<spring:message code="zayavka.publDB" var='publDBLabel' />
	<aui:input id="database" name="database" label='${publDBLabel}' bean="publModel" value='${publModel.database}'>
	</aui:input>

</aui:form>
<aui:script>
$(document).ready(function() {
	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
		   		  	"name":$('#${ns}name').val(),
		   		  	"edition":$('#${ns}edition').val(),
		   		  	"authors":$('#${ns}authors').val(),
		   		  	"citationIndex":$('#${ns}citationIndex').val(),
		   		  	"database":$('#${ns}database').val()};
		$.ajax({
		   url: '${editPublicationUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById(data['id']);
						 $(parentTR).children('td').eq(0).html(data['name']);
						 $(parentTR).children('td').eq(1).html(data['edition']);
						 $(parentTR).children('td').eq(2).html(data['authors']);
						 $(parentTR).children('td').eq(3).html(data['citationIndex']);
						 $(parentTR).children('td').eq(4).html(data['database']);
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});
});
</aui:script>
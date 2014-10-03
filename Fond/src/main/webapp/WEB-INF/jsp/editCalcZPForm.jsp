<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editCalcZP" var="editCalcZPUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editCalcZPForm" id="editCalcZPForm">
	<aui:input id="id" name="id" type="hidden" value="${calcZpModel.id}" />
	
	
	<spring:message code="zayavka.calcZp.name" var='nameLabel' />
	<aui:input id="name" name="name" label='${nameLabel}' bean="calcZpModel" showRequiredLabel="" value="${calcZpModel.name}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcZp.salary" var='salaryLabel' />
	<aui:input id="salary" name="salary" label='${salaryLabel}' bean="calcZpModel" showRequiredLabel="" value="${calcZpModel.salary}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcZp.rate" var='rateLabel' />
	<aui:input id="rate" name="rate" label='${rateLabel}' bean="calcZpModel" showRequiredLabel="" value="${calcZpModel.rate}">
		<aui:validator name="required" />
	</aui:input>
	
	<spring:message code="zayavka.calcZp.duration" var='durationLabel' />
	<aui:input id="duration" name="duration" label='${durationLabel}' bean="calcZpModel" showRequiredLabel="" value="${calcZpModel.duration}">
		<aui:validator name="required" />
	</aui:input>
	<spring:message code="zayavka.calcZp.fondZp" var='fondZpLabel' />
	<aui:input id="fondZp" name="fondZp" label='${fondZpLabel}' bean="calcZpModel" showRequiredLabel="" value="${calcZpModel.fondZp}">
		<aui:validator name="required" />
	</aui:input>
	
	<spring:message code='zayavka.calcZp.note' var='noteLabel' />
	<aui:input id="note" name="note" label='${noteLabel}' bean="calcZpModel" value="${calcZpModel.note}"></aui:input>

</aui:form>
<aui:script>
$(document).ready(function() {
	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
					"name":$('#${ns}name').val(),
		   		  	"salary":$('#${ns}salary').val(),
		   		  	"rate":$('#${ns}rate').val(),
		   		  	"duration":$('#${ns}duration').val(),
		   		  	"fondZp":$('#${ns}fondZp').val(),
		   		  	"note":$('#${ns}note').val(),
		   		  	"zayavkaId":'${zayavkaId}'};
		$.ajax({
		   url: '${editCalcZPUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById(data['id']);
						 $(parentTR).children('td').eq(0).html(data['name']);
						 $(parentTR).children('td').eq(1).html(data['salary']);
						 $(parentTR).children('td').eq(2).html(data['rate']);
						 $(parentTR).children('td').eq(3).html(data['duration']);
						 $(parentTR).children('td').eq(4).html(data['fondZp']);
						 $(parentTR).children('td').eq(5).html(data['note']);
						 resum();
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});
});
</aui:script>
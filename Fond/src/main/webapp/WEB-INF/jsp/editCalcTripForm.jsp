<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editCalcTrip" var="editCalcTripUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editCalcTripForm" id="editCalcTripForm">
	<aui:input id="id" name="id" type="hidden" value="${calcTripModel.id}" />


	<spring:message code="zayavka.calcTrip.tripGoal" var='calcTripTripGoalLabel' />
	<aui:input id="tripGoal" name="tripGoal" label='${calcTripTripGoalLabel}' bean="calcTripModel" showRequiredLabel="" value="${calcTripModel.tripGoal}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.tripPoint" var='calcTripTripPointLabel' />
	<aui:input id="tripPoint" name="tripPoint" label='${calcTripTripPointLabel}' bean="calcTripModel" showRequiredLabel="" value="${calcTripModel.tripPoint}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.count" var='calcTripCountLabel' />
	<aui:input id="count" name="count" label='${calcTripCountLabel}' bean="calcTripModel" showRequiredLabel="" value="${calcTripModel.count}">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.duration" var='calcTripDurationLabel' />
	<aui:input id="duration" name="duration" label='${calcTripDurationLabel}' bean="calcTripModel" showRequiredLabel="" value="${calcTripModel.duration}">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.costs" var='calcTripCostsZpLabel' />
	<aui:input id="costs" name="costs" label='${calcTripCostsZpLabel}' bean="calcTripModel" showRequiredLabel="" value="${calcTripModel.costs}">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>
</aui:form>
<aui:script>
$(document).ready(function() {
	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
					"tripGoal":$('#${ns}tripGoal').val(),
		   		  	"tripPoint":$('#${ns}tripPoint').val(),
		   		  	"count":$('#${ns}count').val(),
		   		  	"duration":$('#${ns}duration').val(),
		   		  	"costs":$('#${ns}costs').val(),
		   		  	"zayavkaId":'${zayavkaId}'};
		$.ajax({
		   url: '${editCalcOtherCostsUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById('calcTrip'+data['id']);
						 $(parentTR).children('td').eq(0).html(data['tripGoal']);
						 $(parentTR).children('td').eq(1).html(data['tripPoint']);
						 $(parentTR).children('td').eq(2).html(data['count']);
						 $(parentTR).children('td').eq(3).html(data['duration']);
						 $(parentTR).children('td').eq(4).html(data['costs']);
						 resumCalcTrip();
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});
});
</aui:script>
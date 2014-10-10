<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editCalcOtherCosts" var="editCalcOtherCostsUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editCalcOtherCostsForm" id="editCalcOtherCostsForm">
	<aui:input id="id" name="id" type="hidden" value="${calcOtherCostsModel.id}" />
	
	
	<spring:message code="zayavka.calcOtherCosts.name" var='calcOtherCostsNameLabel' />
	<aui:input id="name" name="name" label='${calcOtherCostsNameLabel}' bean="calcOtherCostsModel" showRequiredLabel="" value="${calcOtherCostsModel.name}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcOtherCosts.sum" var='calcOtherCostsSumLabel' />
	<aui:input id="sum" name="sum" label='${calcOtherCostsSumLabel}' bean="calcOtherCostsModel" showRequiredLabel="" value="${calcOtherCostsModel.sum}">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcOtherCosts.note" var='calcOtherCostsNoteLabel' />
	<aui:input id="note" name="note" label='${calcOtherCostsNoteLabel}' bean="calcOtherCostsModel" type="textarea" value="${calcOtherCostsModel.note}"/>
</aui:form>
<aui:script>

	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
					"name":$('#${ns}name').val(),
		   		  	"sum":$('#${ns}sum').val(),
		   		  	"note":$('#${ns}note').val(),
		   		  	"zayavkaId":'${zayavkaId}'};
		$.ajax({
		   url: '${editCalcOtherCostsUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById('calcOtherCosts'+data['id']);
						 $(parentTR).children('td').eq(1).html(data['name']);
						 $(parentTR).children('td').eq(2).html(data['sum']);
						 $(parentTR).children('td').eq(3).html(data['note']);
						 resumCalcOtherCosts();
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});

</aui:script>
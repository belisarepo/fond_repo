<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:resourceURL id="editCalcMaterials" var="editCalcMaterialsUrl">
</portlet:resourceURL>
<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<aui:form action="#" name="editCalcMaterialsForm" id="editCalcMaterialsForm">
	<aui:input id="id" name="id" type="hidden" value="${calcMaterialsModel.id}" />
	
	
	<spring:message code="zayavka.calcMaterials.name" var='nameLabel' />
	<aui:input id="name" name="name" label='${nameLabel}' bean="calcMaterialsModel" showRequiredLabel="" value="${calcMaterialsModel.name}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcMaterials.unit" var='unitLabel' />
	<aui:input id="unit" name="unit" label='${unitLabel}' bean="calcMaterialsModel" showRequiredLabel="" value="${calcMaterialsModel.unit}">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcMaterials.count" var='countLabel' />
	<aui:input id="count" name="count" label='${countLabel}' bean="calcMaterialsModel" showRequiredLabel="" value="${calcMaterialsModel.count}">
		<aui:validator name="required" />
	</aui:input>
		<spring:message code="zayavka.calcMaterials.sum" var='sumLabel' />
	<aui:input id="sum" name="sum" label='${sumLabel}' bean="calcMaterialsModel" showRequiredLabel="" value="${calcMaterialsModel.sum}">
		<aui:validator name="required" />
	</aui:input>
		
</aui:form>
<aui:script>
$(document).ready(function() {
	$('#popupSaveBtn').click(function(){
		var data = {"id":$('#${ns}id').val(),
					"name":$('#${ns}name').val(),
		   		  	"unit":$('#${ns}unit').val(),
		   		  	"count":$('#${ns}count').val(),
		   		  	"sum":$('#${ns}sum').val(),
		   		  	"zayavkaId":'${zayavkaId}'};
		$.ajax({
		   url: '${editCalcMaterialsUrl}',
		   <!-- dataType: 'json', -->
		   data: data,
		   success: function(){
		   				 var parentTR = Liferay.Util.getOpener().document.getElementById(data['id']);
						 $(parentTR).children('td').eq(1).html(data['name']);
						 $(parentTR).children('td').eq(2).html(data['unit']);
						 $(parentTR).children('td').eq(3).html(data['count']);
						 $(parentTR).children('td').eq(4).html(data['sum']);
						 resum();
						<portlet:namespace />textDialog.hide();
		   			}
		 });
		 
		
		
	});
});
</aui:script>
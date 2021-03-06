<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:actionURL var="sendForm">
</portlet:actionURL>
<c:set var="ns">
	<portlet:namespace />
</c:set>
<center>
	<div id="successMessageContainer" />
</center>

<form:form modelAttribute='${ns}organization' method="POST" action="${sendForm}" name="organization">
	<form:label path="full_name_rus">Полное наименование организации на русском</form:label>
	<form:input path="full_name_rus" />
	<br />
	<form:label path="full_name_eng">Полное наименование организации на английском</form:label>
	<form:input path="full_name_eng" />
	<br />
	<form:label path="name">Краткое наименование</form:label>
	<form:input path="name" />
	<br />
	<form:label path="unp">УНП</form:label>
	<form:input path="unp" />
	<br />
	<form:label path="vidOrgId">Вид организации</form:label>
	<form:select path="vidOrgId">
		<form:option value=""></form:option>
		<form:options items="${vidOrgList}" itemLabel="name" itemValue="id" />
	</form:select>
	<br />
	<form:label path="address">Адрес</form:label>
	<form:input path="address" />
	<br />
	<form:label path="email">Электронная почта</form:label>
	<form:input path="email" />
	<br />

	<form:label path="kod_old">Код в справочнике</form:label>
	<form:input path="kod_old" />
	<br />

	<form:label path="kod_booker">Код бухгалтерии</form:label>
	<form:input path="kod_booker" />
	<br />
	<form:label path="okoguId">Классификатор ОКОГУ</form:label>
	<form:select path="okoguId">
		<form:option value=""></form:option>
		<form:options items="${okoguList}" itemLabel="fullName" itemValue="id" />
	</form:select>
	<br />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>
	</aui:button-row>
</form:form>
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
});
YUI().use(
  function(Y) {
  	var save_result = '${save_result}';
  	if (save_result){
  		showSuccess();
  	}
  }
);

function showSuccess(){
	AUI().use('liferay-notice', function(A){
		var successMessageContainer = A.one('#successMessageContainer');
		var banner = new Liferay.Notice(
			{
				animationConfig:
					{
						duration: 0.1,
						top: '50%',
						left: '50%'
						
					},
				content: '<div class="alert alert-success">Сохранено</div>',
				closeText: false,
				node: '#successMessageContainer',
				type: 'notice',
				toggleText: false,
				timeout: 1000,
				useAnimation: false
				
			}
		);

		banner.show();
	});	
}
</aui:script>


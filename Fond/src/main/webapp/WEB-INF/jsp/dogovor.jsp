<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<style>
div .tab-pane{
	min-height: 500px;
	
}
</style>

<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>

<div id="dogovorTab" class="tabs-left">

	<ul class="nav nav-tabs ">
		<li><a href="#tab-1"><spring:message code="dogovor.tab1" /></a></li>
		<li><a href="#tab-2"><spring:message code="dogovor.tab2" /></a></li>
		<li><a href="#tab-3"><spring:message code="dogovor.tab3" /></a></li>
	</ul>

	<div class="tab-content">

		<div id="tab-1" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/dogovor/form1.jsp"%>
		</div>
		<div id="tab-2" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/dogovor/form2.jsp"%>
		</div>
		<div id="tab-3" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/dogovor/form3.jsp"%>
		</div>
		
	</div>
</div>

<aui:script>
viewTab('#dogovorTab');
$(document).ready(function(){
	$('select').chosen({
		no_results_text : "Извините, нет совпадений!",
		placeholder_text_single : "Выберите из списка...",
		placeholder_text_multiple : "Выберите нужные пункты...",
		width : '91%',
		search_contains:true
	});
});
</aui:script>
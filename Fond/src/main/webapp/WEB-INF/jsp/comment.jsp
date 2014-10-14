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
<form:form modelAttribute='${ns}comment' method="POST" action="${sendForm}" name="comment">
	<form:label path="text">Отзыв</form:label>
	<form:textarea path="text" style="width:99%" rows="20"/>
	<br />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>
	</aui:button-row>
</form:form>
<aui:script>
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


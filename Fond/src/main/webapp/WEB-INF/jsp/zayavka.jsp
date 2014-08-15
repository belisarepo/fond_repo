<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>

<portlet:actionURL var="sendForm">
</portlet:actionURL>
<portlet:actionURL var="addIspolnitelAction">
	<portlet:param name="action" value="addIspolnitel" />
	<portlet:param name="konkursId" value="${zayavka.konkursId}"/>
</portlet:actionURL>

<portlet:renderURL var="popupPageURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="temaName" />
</portlet:renderURL>
<c:set var="strUrl"><%=popupPageURL.toString()%></c:set>

<div id="myTab" class="tabs-left">

	<ul class="nav nav-tabs ">
		<li><a href="#tab-1"><spring:message code="zayavka.competitionLegend" /></a></li>
		<li><a href="#tab-2"><spring:message code="zayavka.orgLegend" /></a></li>
		<li><a href="#tab-3"><spring:message code="zayavka.managerLegend" /></a></li>
		<li><a href="#tab-4"><spring:message code="zayavka.ispolniteli" /></a></li>
	</ul>

	<div class="tab-content">

		<div id="tab-1" class="tab-pane"></div>
		<div id="tab-2" class="tab-pane">
			<form:form modelAttribute='${ns}zayavka' method="POST" action="${sendForm}" name="zayavka">
				<form:hidden path="id" />
				<form:hidden path="konkursId" />
				<form:hidden path="userId" />
				<form:label path="konkursNameR">Название конкурса</form:label>
				<form:input path="konkursNameR" disabled="true" />
				<form:label path="temaName">Тема заявки</form:label>
				<form:input path="temaName" id="temaName" onclick="showPopup('Тема заявки','temaName','${strUrl}')" />
				<form:label path="sectionFondId">Секция фонда</form:label>
				<form:select path="sectionFondId" items="${sectionFondList}" itemValue="id" itemLabel="nameR" class="chosen"></form:select>
				<form:label path="otraslNaukaId">Отрасль науки</form:label>
				<form:select path="otraslNaukaId" items="${otraslNaukaList}" itemLabel="name" itemValue="id" class="chosen"></form:select>
				<form:label path="prioritetNaukaId">Приоритет науки</form:label>
				<form:select path="prioritetNaukaId" items="${prioritetNaukaList}" itemLabel="name" itemValue="id" class="chosen"></form:select>
				<form:label path="orgId">Организация заявитель</form:label>
				<form:select path="orgId" items="${listOrg}" itemValue="id" itemLabel="name" class="chosen"></form:select>
				<%-- <form:label path="ispolniteli">Исполнители</form:label>
				<form:select path="ispolniteli" items="${fizInfoList}" itemValue="id" itemLabel="surname" class="chosen" multiple="true"></form:select> --%>
				<aui:button-row>
					<div align="left">
						<aui:button type="submit" />
					</div>
				</aui:button-row>
			</form:form>
		</div>
		<div id="tab-3" class="tab-pane"></div>
		<div id="tab-4" class="tab-pane">
			<table class="table table-condensed table-bordered" style="width:auto">
				<thead>
					<tr>

						<th><spring:message code="zayavka.surname" /></th>
						<th><spring:message code="zayavka.name" /></th>
						<th><spring:message code="zayavka.patronymic" /></th>
						<th><spring:message code="zayavka.birthdayManager" /></th>
						<th><spring:message code="zayavka.degree" /></th>
						<th><spring:message code="zayavka.academicTitle" /></th>
						<th><spring:message code="zayavka.mestoRaboti" /></th>
						<th><spring:message code="zayavka.postManager" /></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ispolniteliList}" var="i">
						<tr>
							<td>${i.surname}</td>
							<td>${i.name}</td>
							<td>${i.patronymic}</td>
							<td>${i.birthday}</td>
							<td>${i.uchStepeniName}</td>
							<td>${i.uchZvaniyName}</td>
							<td>${i.orgName}</td>
							<td>${i.post}</td>
						</tr>
					</c:forEach>
					<form:form action="${addIspolnitelAction}" modelAttribute="${ns}ispolnitelModel" method="POST">
						<tr>
							<td><form:input path="surname" cssClass="big-table"/></td>
							<td><form:input path="name" cssClass="big-table"/></td>
							<td><form:input path="patronymic" cssClass="big-table"/></td>
							<td><form:input path="birthday" cssClass="big-table"/></td>
							<td><form:select path="uchStepeniId" items="${uchStepeniList}" itemLabel="fullName" itemValue="id" /></td>
							<td><form:select path="uchZvaniyId" items="${uchZvaniyList}" itemLabel="fullName" itemValue="id" /></td>
							<td><form:select path="orgId" items="${listOrg}" itemValue="id" itemLabel="name" class="chosen" /></td>
							<td><form:input path="post" cssClass="big-table"/></td>
							<td><button type="submit" class="btn btn-lg btn-link">
									<span class="glyphicon glyphicon-plus green">Add</span>
								</button></td>
						</tr>
					</form:form>
				</tbody>
			</table>
		</div>
	</div>
</div>




<aui:script>
AUI().use(
  'aui-tabview',
  'history',
  function(Y) {
    var tabview = new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
    
    tabview.selectChild(sessionStorage.getItem('tab') || 0);
    tabview.after('selectionChange', function (e) {
   		sessionStorage.setItem('tab', e.newVal.get('index') || null);
    });
   
  }
);
function showPopup(title,input_id, popup_page_url) {
	AUI().use(
		    'aui-base',
		    'liferay-util-window',
		    'aui-io-plugin-deprecated',
		     function(A) {
		            var saveButton = [
					{
						label: 'Save',
						on: {
							click: function() {
								getDataFromPopup(input_id);
							}
						}
					}
				];
				var closeButton = [
					{
						cssClass: 'close',
						label: '\u00D7',
						render: true,
						on: {
							click: function() {
								<portlet:namespace />textDialog.hide();
							}
						}
					}
				];

		            <portlet:namespace />textDialog = Liferay.Util.Window.getWindow(
		                {
		                	height: '50%',
		                    dialog: {
		                    	align: Liferay.Util.Window.ALIGN_CENTER,
		                        centered: true,
		                        constrain2view: false,
		                        modal: true,
		                        resizable: false,
		                        width:'70%',
		                        
		                        toolbars: {
											footer: saveButton,
											header: closeButton
								}, 
		                    },
		                    title: title
		                }
		                ).plug(A.Plugin.IO, {uri:popup_page_url}).render();
		                
		                
		        }
		    
		); 
}
</aui:script>
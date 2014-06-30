<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<portlet:actionURL var="sendForm">
</portlet:actionURL>
<portlet:resourceURL var="ajaxUrl" id="ajax" />
<portlet:renderURL var="somePageURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
</portlet:renderURL>
<c:set var="strUrl"><%=somePageURL.toString()%></c:set>
<c:set var="ns">
	<portlet:namespace />
</c:set>

<div id="myTab" class="tabs-left">

	<ul class="nav nav-tabs ">
		<li><a href="#tab-1"><spring:message
					code="request.competitionLegend" /></a></li>
		<li><a href="#tab-2"><spring:message code="request.orgLegend" /></a></li>
		<li><a href="#tab-3"><spring:message
					code="request.managerLegend" /></a></li>
	</ul>

	<div class="tab-content">

		<div id="tab-1" class="tab-pane">
			<form:form modelAttribute='${ns}requestBean' method="POST"
				action="${sendForm}">
				<legend>
					<spring:message code="request.competitionLegend" />
				</legend>
				<aui:fieldset>
					<aui:col width="33">
						<form:label path="codeCompetition">
							<spring:message code="request.codeCompetition" />
						</form:label>
						<form:input path="codeCompetition" class="uneditable-input"
							value="test" />
						<form:label path="nameCompetition">
							<spring:message code="request.nameCompetition" />
						</form:label>
						<form:input path="nameCompetition" class="uneditable-input"
							value="test" />
						<form:label path="typeCompetition">
							<spring:message code="request.typeCompetition" />
						</form:label>
						<form:input path="typeCompetition" class="uneditable-input"
							value="1" />
					</aui:col>
					<aui:col width="33">
						<form:label path="brffi">
							<spring:message code="request.brffi" />
						</form:label>
						<form:select path="brffi" items="${testMap }" />
						<form:label path="branchScience">
							<spring:message code="request.branchScience" />
						</form:label>
						<form:select path="branchScience" items="${testMap }" />
						<form:label path="priority">
							<spring:message code="request.priority" />
						</form:label>
						<form:select path="priority" items="${testMap }" />
					</aui:col>
					<aui:col width="33">
						<form:label path="topic">
							<spring:message code="request.topic" />
						</form:label>
						<form:input path="topic" class="uneditable-input" value="test" />
						<form:label path="codeUdk">
							<spring:message code="request.codeUdk" />
						</form:label>
						<form:input path="codeUdk" class="uneditable-input" value="test" />
					</aui:col>
				</aui:fieldset>
				<aui:button-row>
					<div align="right" style="padding-right: 10%;">
						<aui:button type="submit" />
					</div>
				</aui:button-row>
			</form:form>
		</div>
		<div id="tab-2" class="tab-pane">
			<form:form modelAttribute='${ns}requestBean' method="POST"
				action="${sendForm}">
				<legend>
					<spring:message code="request.orgLegend" />
				</legend>
				<aui:fieldset>
					<aui:col width="33">
						<form:label path="org">
							<spring:message code="request.org" />
						</form:label>
						<form:select path="org" items="${testMap }" />
						<form:label path="supremeOrg">
							<spring:message code="request.supremeOrg" />
						</form:label>
						<form:select path="supremeOrg" items="${testMap }" />
					</aui:col>
					<aui:col width="33">
						<form:label path="addressOrg">
							<spring:message code="request.addressOrg" />
						</form:label>
						<form:input path="addressOrg" />
						<form:label path="emailOrg">
							<spring:message code="request.emailOrg" />
						</form:label>
						<div class="input-prepend">
							<span class="add-on"><i class="icon-envelope"></i></span>
							<form:input path="emailOrg" />
						</div>
					</aui:col>
				</aui:fieldset>
				<aui:button-row>
					<div align="right" style="padding-right: 10%;">
						<aui:button type="submit" />
					</div>
				</aui:button-row>
			</form:form>
		</div>
		<div id="tab-3" class="tab-pane">
			<form:form modelAttribute='${ns}requestBean' method="POST"
				action="${sendForm}">
				<legend>
					<spring:message code="request.managerLegend" />
				</legend>
				<aui:fieldset>
					<aui:col width="33">
						<form:label path="fioManager">
							<spring:message code="request.fioManager" />
						</form:label>
						<form:input path="fioManager" id="fioManager"/>
						<form:label path="birthdayManager">
							<spring:message code="request.birthdayManager" />
						</form:label>
						<form:input path="birthdayManager" />
						<form:label path="degree">
							<spring:message code="request.degree" />
						</form:label>
						<form:select path="degree" items="${testMap }" />
						<form:label path="academicTitle">
							<spring:message code="request.academicTitle" />
						</form:label>
						<form:select path="academicTitle" items="${testMap }" />
					</aui:col>
					<aui:col width="33">
						<form:label path="postManager">
							<spring:message code="request.postManager" />
						</form:label>
						<form:input path="postManager" />
						<form:label path="chairManager">
							<spring:message code="request.chairManager" />
						</form:label>
						<form:input path="chairManager" />
						<form:label path="emailManager">
							<spring:message code="request.emailManager" />
						</form:label>
						<div class="input-prepend">
							<span class="add-on"><i class="icon-envelope"></i></span>
							<form:input path="emailManager" />
						</div>
						<form:label path="addressManager">
							<spring:message code="request.addressManager" />
						</form:label>
						<form:input path="addressManager" />
					</aui:col>
					<aui:col width="33">
						<form:label path="businessPhone">
							<spring:message code="request.businessPhone" />
						</form:label>
						<form:input path="businessPhone" />
						<form:label path="homePhone">
							<spring:message code="request.homePhone" />
						</form:label>
						<form:input path="homePhone" />
						<form:label path="mobilePhone">
							<spring:message code="request.mobilePhone" />
						</form:label>
						<form:input path="mobilePhone" />
						<form:label path="text">Text</form:label>
						<form:textarea rows="3" path="text"
							onclick="showPopup('TextPopup','popup_text','${strUrl}')"
							id="popup_text" />
					</aui:col>
				</aui:fieldset>
				<aui:button-row>
					<div align="right" style="padding-right: 10%;">
						<aui:button type="submit" />
					</div>
				</aui:button-row>
			</form:form>
		</div>


	</div>
</div>
<!-- 
<form:form modelAttribute='${ns}requestBean' method="POST"
	action="${sendForm}">

	<legend>
		<spring:message code="request.competitionLegend" />
	</legend>
	<aui:fieldset>
		<aui:col width="33">
			<form:label path="codeCompetition">
				<spring:message code="request.codeCompetition" />
			</form:label>
			<form:input path="codeCompetition" class="uneditable-input"
				value="test" />
			<form:label path="nameCompetition">
				<spring:message code="request.nameCompetition" />
			</form:label>
			<form:input path="nameCompetition" class="uneditable-input"
				value="test" />
			<form:label path="typeCompetition">
				<spring:message code="request.typeCompetition" />
			</form:label>
			<form:input path="typeCompetition" class="uneditable-input"
				value="test" />
		</aui:col>
		<aui:col width="33">
			<form:label path="brffi">
				<spring:message code="request.brffi" />
			</form:label>
			<form:select path="brffi" items="${testMap }" />
			<form:label path="branchScience">
				<spring:message code="request.branchScience" />
			</form:label>
			<form:select path="branchScience" items="${testMap }" />
			<form:label path="priority">
				<spring:message code="request.priority" />
			</form:label>
			<form:select path="priority" items="${testMap }" />
		</aui:col>
		<aui:col width="33">
			<form:label path="topic">
				<spring:message code="request.topic" />
			</form:label>
			<form:input path="topic" class="uneditable-input" value="test" />
			<form:label path="codeUdk">
				<spring:message code="request.codeUdk" />
			</form:label>
			<form:input path="codeUdk" class="uneditable-input" value="test" />
		</aui:col>
	</aui:fieldset>

	<legend>
		<spring:message code="request.orgLegend" />
	</legend>
	<aui:fieldset>
		<aui:col width="33">
			<form:label path="org">
				<spring:message code="request.org" />
			</form:label>
			<form:select path="org" items="${testMap }" />
			<form:label path="supremeOrg">
				<spring:message code="request.supremeOrg" />
			</form:label>
			<form:select path="supremeOrg" items="${testMap }" />
		</aui:col>
		<aui:col width="33">
			<form:label path="addressOrg">
				<spring:message code="request.addressOrg" />
			</form:label>
			<form:input path="addressOrg" />
			<form:label path="emailOrg">
				<spring:message code="request.emailOrg" />
			</form:label>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-envelope"></i></span>
				<form:input path="emailOrg" />
			</div>
		</aui:col>
	</aui:fieldset>

	<legend>
		<spring:message code="request.managerLegend" />
	</legend>
	<aui:fieldset>
		<aui:col width="33">
			<form:label path="fioManager">
				<spring:message code="request.fioManager" />
			</form:label>
			<form:input path="fioManager" />
			<form:label path="birthdayManager">
				<spring:message code="request.birthdayManager" />
			</form:label>
			<form:input path="birthdayManager" />
			<form:label path="degree">
				<spring:message code="request.degree" />
			</form:label>
			<form:select path="degree" items="${testMap }" />
			<form:label path="academicTitle">
				<spring:message code="request.academicTitle" />
			</form:label>
			<form:select path="academicTitle" items="${testMap }" />
		</aui:col>
		<aui:col width="33">
			<form:label path="postManager">
				<spring:message code="request.postManager" />
			</form:label>
			<form:input path="postManager" />
			<form:label path="chairManager">
				<spring:message code="request.chairManager" />
			</form:label>
			<form:input path="chairManager" />
			<form:label path="emailManager">
				<spring:message code="request.emailManager" />
			</form:label>
			<div class="input-prepend">
				<span class="add-on"><i class="icon-envelope"></i></span>
				<form:input path="emailManager" />
			</div>
			<form:label path="addressManager">
				<spring:message code="request.addressManager" />
			</form:label>
			<form:input path="addressManager" />
		</aui:col>
		<aui:col width="33">
			<form:label path="businessPhone">
				<spring:message code="request.businessPhone" />
			</form:label>
			<form:input path="businessPhone" />
			<form:label path="homePhone">
				<spring:message code="request.homePhone" />
			</form:label>
			<form:input path="homePhone" />
			<form:label path="mobilePhone">
				<spring:message code="request.mobilePhone" />
			</form:label>
			<form:input path="mobilePhone" />
			<form:label path="text">Text</form:label>
			<form:textarea rows="3" path="text"
				onclick="showPopup('TextPopup','popup_text','${strUrl}')"
				id="popup_text" />
		</aui:col>
	</aui:fieldset>
	<aui:button-row>
		<div align="right" style="padding-right: 10%;">
			<aui:button type="submit" />
		</div>
	</aui:button-row>
</form:form>
-->
<aui:script>
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
		                    title: title,
		                }
		                ).plug(A.Plugin.IO, {uri:popup_page_url}).render();
		                
		                
		        }
		    
		); 
}

AUI().use(
  'aui-tabview',
  'history',
  function(Y) {
  	var history = new Y.HistoryHash();
    var tabview = new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
    
    tabview.selectChild(history.get('tab') || 0);
    tabview.after('selectionChange', function (e) {
   		history.addValue('tab', e.newVal.get('index') || null);
    	
    });
   
  }
);

function autoUpdate(){
	var ajaxUrl = "${ajaxUrl}";
	AUI().use('aui-io-request',
			  function(A){
				A.io.request(ajaxUrl,
							 {
								method : 'POST',
								dataType: 'json',
								data : {
										<portlet:namespace/>fioManager : A.one('#fioManager').val()
								}
							});	
			  });
}

setInterval(autoUpdate,3000);
</aui:script>



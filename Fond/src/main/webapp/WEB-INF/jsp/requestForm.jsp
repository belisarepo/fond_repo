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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<portlet:actionURL var="sendForm">
</portlet:actionURL>
<portlet:renderURL var="somePageURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="action" value="popup"/>	
</portlet:renderURL>
<c:set var="strUrl"><%=somePageURL.toString() %></c:set>
<c:set var="ns"><portlet:namespace/></c:set>


<form:form modelAttribute='${ns}requestBean' method="POST" action="${sendForm}" >
	
	<form:label path="name">Имя1</form:label>
	<form:input path="name"/><br/>
	<form:label path="text">Text</form:label>
	<form:input path="text" onclick="showPopup('TextPopup','popup_text','${strUrl}')" id="popup_text"/>
	
	
	<input type="submit" value="Save" />
</form:form>
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



</aui:script>



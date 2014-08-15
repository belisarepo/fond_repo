<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<liferay-ui:input-editor />
<center><div id="successMessageContainer" /></center>


<!-- <input id="<portlet:namespace />text" type="hidden" value="" /> -->
<aui:script>
function <portlet:namespace />initEditor() {
                        return Liferay.Util.getOpener().document.getElementById('${input_id}').value;
            }
function getDataFromPopup(input_id) {
    //AUI().one('#<portlet:namespace />text').value = window.<portlet:namespace />editor.getHTML(); 
    Liferay.Util.getOpener().document.getElementById(input_id).value = window.<portlet:namespace />editor.getHTML(); 
    showSuccess();
    <portlet:namespace />textDialog.hide();              
            }
            
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

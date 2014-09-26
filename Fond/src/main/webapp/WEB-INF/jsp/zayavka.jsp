<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>

<portlet:actionURL var="saveZayavka">
</portlet:actionURL>
<portlet:actionURL var="saveForm1">
	<portlet:param name="form" value="form1" />
</portlet:actionURL>
<portlet:actionURL var="saveForm2">
	<portlet:param name="form" value="form2" />
</portlet:actionURL>
<portlet:actionURL var="saveForm3">
	<portlet:param name="form" value="form3" />
</portlet:actionURL>
<portlet:actionURL var="saveForm4">
	<portlet:param name="form" value="form4" />
</portlet:actionURL>
<portlet:actionURL var="saveForm5">
	<portlet:param name="form" value="form5" />
</portlet:actionURL>
<portlet:actionURL var="saveForm8">
	<portlet:param name="form" value="form8" />
</portlet:actionURL>
<portlet:actionURL var="saveForm9">
	<portlet:param name="form" value="form9" />
</portlet:actionURL>
<portlet:actionURL var="saveForm10">
	<portlet:param name="form" value="form10" />
</portlet:actionURL>
<portlet:actionURL var="saveForm11">
	<portlet:param name="form" value="form11" />
</portlet:actionURL>
<portlet:actionURL var="saveForm12">
	<portlet:param name="form" value="form12" />
</portlet:actionURL>
<portlet:actionURL var="saveForm13">
	<portlet:param name="form" value="form13" />
</portlet:actionURL>
<portlet:actionURL var="saveForm14">
	<portlet:param name="form" value="form14" />
</portlet:actionURL>
<portlet:actionURL var="saveForm15">
	<portlet:param name="form" value="form15" />
</portlet:actionURL>
<portlet:actionURL var="sendZayavka">
	<portlet:param name="action" value="send" />
	<portlet:param name="konkursId" value="${zayavkaModel.konkursId}" />
	<portlet:param name="zayavkaId" value="${zayavkaModel.id}" />
</portlet:actionURL>


<portlet:actionURL var="addIspolnitelAction">
	<portlet:param name="action" value="addIspolnitel" />
</portlet:actionURL>
<portlet:actionURL var="addPublicationAction">
	<portlet:param name="action" value="addPublication" />
</portlet:actionURL>
<portlet:actionURL var="addSoOrgAction">
	<portlet:param name="action" value="addSoOrg" />
</portlet:actionURL>
<portlet:actionURL var="addPetitionAction">
	<portlet:param name="action" value="addPetition" />
</portlet:actionURL>
<portlet:actionURL var="addCalcZpAction">
	<portlet:param name="action" value="addCalcZp" />
</portlet:actionURL>
<portlet:actionURL var="addCalcMaterialsAction">
	<portlet:param name="action" value="addCalcMaterials" />
</portlet:actionURL>
<portlet:actionURL var="addCalcTripAction">
	<portlet:param name="action" value="addCalcTrip" />
</portlet:actionURL>
<portlet:actionURL var="addCalcOtherCostsAction">
	<portlet:param name="action" value="addCalcOtherCosts" />
</portlet:actionURL>



	<aui:button-row>
		<div align="right">
			<a class="btn" id="send_btn" href="${sendZayavka}">Подать</a>
			<c:if test="${zayavkaModel.statusZayavkaId==3}">
				<a class="btn"
					onclick="window.open('<portlet:resourceURL id="report"><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:resourceURL>')">Печать</a>
			</c:if>
		</div>
	</aui:button-row>
<hr />
<center>
	<div id="successMessageContainer"></div>
</center>

<c:if test="${!empty errorMsg}">
	<div class="alert alert-error">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<p>${errorMsg}</p>
	</div>
</c:if>


<div id="myTab" class="tabs-left">

	<ul class="nav nav-tabs ">
		<li><a href="#tab-1"><spring:message code="zayavka.tab1" /></a></li>
		<li><a href="#tab-2"><spring:message code="zayavka.tab2" /></a></li>
		<li><a href="#tab-3"><spring:message code="zayavka.tab3" /></a></li>
		<c:if test="${zayavkaModel.intl}">
			<li><a href="#tab-4"><spring:message code="zayavka.tab4" /></a></li>
			<li><a href="#tab-5"><spring:message code="zayavka.tab5" /></a></li>
		</c:if>

		<li><a href="#tab-6"><spring:message code="zayavka.tab6" /></a></li>
		<li><a href="#tab-7"><spring:message code="zayavka.tab7" /></a></li>
		<li><a href="#tab-8"><spring:message code="zayavka.tab8" /></a></li>
		<li><a href="#tab-9"><spring:message code="zayavka.tab9" /></a></li>
		<c:if test="${zayavkaModel.young}">
			<li><a href="#tab-21"><spring:message code="zayavka.tab21" /></a></li>
		</c:if>
		<c:if test="${not zayavkaModel.young}">
			<li><a href="#tab-10"><spring:message code="zayavka.tab10" /></a></li>
		</c:if>
		<li><a href="#tab-11"><spring:message code="zayavka.tab11" /></a></li>
		<li><a href="#tab-12"><spring:message code="zayavka.tab12" /></a></li>
		<c:if test="${not zayavkaModel.young}">
			<li><a href="#tab-13"><spring:message code="zayavka.tab13" /></a></li>
			<li><a href="#tab-14"><spring:message code="zayavka.tab14" /></a></li>
		</c:if>
		<li><a href="#tab-15"><spring:message code="zayavka.tab15" /></a></li>
		<li><a href="#tab-16"><spring:message code="zayavka.tab16" /></a></li>
		<li><a href="#tab-17"><spring:message code="zayavka.tab17" /></a></li>
		<li><a href="#tab-18"><spring:message code="zayavka.tab18" /></a></li>
		<li><a href="#tab-19"><spring:message code="zayavka.tab19" /></a></li>
		<li><a href="#tab-20"><spring:message code="zayavka.tab20" /></a></li>
	</ul>

	<div class="tab-content">

		<div id="tab-1" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form1.jsp"%>
		</div>
		<div id="tab-2" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form2.jsp"%>
		</div>
		<div id="tab-3" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form3.jsp"%>
		</div>
		<c:if test="${zayavkaModel.intl}">
			<div id="tab-4" class="tab-pane">
				<%@ include file="/WEB-INF/jsp/zayavka/form4.jsp"%>
			</div>
			<div id="tab-5" class="tab-pane">
				<%@ include file="/WEB-INF/jsp/zayavka/form5.jsp"%>
			</div>
		</c:if>
		<div id="tab-6" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form6.jsp"%>
		</div>
		<div id="tab-7" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form7.jsp"%>
		</div>
		<div id="tab-8" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form8.jsp"%>
		</div>
		<div id="tab-9" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form9.jsp"%>
		</div>
		<c:if test="${zayavkaModel.young}">
			<div id="tab-21" class="tab-pane">
				<%@ include file="/WEB-INF/jsp/zayavka/form21.jsp"%>
			</div>
		</c:if>
		<c:if test="${not zayavkaModel.young}">
			<div id="tab-10" class="tab-pane">
				<%@ include file="/WEB-INF/jsp/zayavka/form10.jsp"%>
			</div>
		</c:if>

		<div id="tab-11" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form11.jsp"%>
		</div>
		<div id="tab-12" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form12.jsp"%>
		</div>
		<c:if test="${not zayavkaModel.young}">
			<div id="tab-13" class="tab-pane">
				<%@ include file="/WEB-INF/jsp/zayavka/form13.jsp"%>
			</div>
			<div id="tab-14" class="tab-pane">
				<%@ include file="/WEB-INF/jsp/zayavka/form14.jsp"%>
			</div>
		</c:if>

		<div id="tab-15" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form15.jsp"%>
		</div>
		<div id="tab-16" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form16.jsp"%>
		</div>
		<div id="tab-17" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form17.jsp"%>
		</div>
		<div id="tab-18" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form18.jsp"%>
		</div>
		<div id="tab-19" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form19.jsp"%>
		</div>
		<div id="tab-20" class="tab-pane">
			<%@ include file="/WEB-INF/jsp/zayavka/form20.jsp"%>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal" id="confirmModal" role="dialog" aria-hidden="true" data-backdrop="true" style="width:260px;top:40%;left:55%;display:none">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
      	
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"  id="myModalLabel">Сохранить изменения?</h4>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Нет</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="submitFondForm()">Сохранить</button>
      </div>
    </div>
  </div>
</div>




<div class="loading"><!-- Place at bottom of page --></div>
<aui:script>
var isChanged = false;
var changedForm;
function submitFondForm(){
		changedForm.submit();
		$('.loading').css('display','block');
	}
$(document).ready(function() {
	
	$('input, select').change(function(){
		isChanged = true;
		changedForm = $(this).closest("form");
	});
	
	function disabledZayavka(){
		$('input').prop('disabled', true);
		$('button').prop('disabled', true);
		$('select').prop('disabled', true);
		$('#send_btn').css('display','none');
		$('.deleteLink').css('display','none');
		
	}
	if ('${zayavkaModel.statusZayavkaId}'==3){
		disabledZayavka();
	}
	
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
//=============================================================================
//Show Popup Function
//=============================================================================
function showPopup(title, input_id, popup_page_url) {
	AUI().use('aui-base', 'aui-tabview', 'liferay-notice', 'history',
			'liferay-util-window', 'aui-io-plugin-deprecated', function(Y) {
				var saveButton = [ {
					label : 'Save',
					on : {
						click : function() {
							getDataFromPopup(input_id);
							Y.one('#<portlet:namespace />'+input_id).simulate('change');
						}
					}
				} ];
				var closeButton = [ {
					cssClass : 'close',
					label : '\u00D7',
					render : true,
					on : {
						click : function() {
							<portlet:namespace />textDialog.hide();
						}
					}
				} ];

				<portlet:namespace />textDialog = Liferay.Util.Window.getWindow({
					height : '50%',
					dialog : {
						align : Liferay.Util.Window.ALIGN_CENTER,
						centered : true,
						constrain2view : false,
						modal : true,
						resizable : false,
						width : '70%',

						toolbars : {
							footer : saveButton,
							header : closeButton
						},
					},
					title : title
				}).plug(Y.Plugin.IO, {
					uri : popup_page_url
				}).render();
			});
}
//=========================================================================

AUI().use(
  'aui-base',
  'aui-tabview',
  'liferay-notice',
  'history',
  'liferay-util-window',
  'aui-io-plugin-deprecated',
  function(Y) {

// add Show Popup
//===============================================================  	
Y.one('#${ns}temaName').on('click', function(event){
   showPopup('Тема заявки','temaName','${strPopupTemaNameUrl}');
});




Y.one('#${ns}biography').on('click', function(event){
   showPopup('Научная биография руководителя','biography','${strPopupBiographyURL}');
});

//=================================================================================  
// Render Tabs
//=============================================================
var tabview = new Y.TabView({
	srcNode : '#myTab'
}).render();
if (sessionStorage.getItem('tab')) {
	tabview.selectChild(sessionStorage.getItem('tab') || 0);
}
tabview.before('selectionChange', function(e) {
	if (isChanged){
		$('#confirmModal').modal('show');
	}
	
});
tabview.after('selectionChange', function(e) {
	isChanged = false;
	sessionStorage.setItem('tab', e.newVal.get('index') || 0);
});
//============================================================
// Show success message
//==============================================================	
var save_result = '${save_result}';
if (save_result) {
	showSuccess(save_result);
}

function showSuccess(save_result) {

	var successMessageContainer = Y.one('#successMessageContainer');
	var banner = new Liferay.Notice({
		animationConfig : {
			duration : 0.1,
			top : '50%',
			left : '50%'

		},
		content : '<div class="alert alert-success">'+save_result+'</div>',
		closeText : false,
		node : '#successMessageContainer',
		type : 'notice',
		toggleText : false,
		timeout : 1000,
		useAnimation : false

	});

	banner.show();
}
//==============================================================
// Show error message
//==============================================================	
//var errorMsg = '${errorMsg}';
//if (errorMsg) {
//	showError(errorMsg);
//}

function showError(errorMsg) {

	var errorMessageContainer = Y.one('#errorMessageContainer');
	var banner = new Liferay.Notice({
		animationConfig : {
			duration : 0.1,
			top : '50%',
			left : '50%'

		},
		content : '<div class="alert alert-error">'+errorMsg+'</div>',
		closeText : 'Закрыть',
		node : '#errorMessageContainer',
		type : 'notice',
		toggleText : false,
		useAnimation : false

	});

	banner.show();
}
//==============================================================
});
</aui:script>
function viewTab(srcNode){
	AUI().use('aui-base', 'aui-tabview', 'liferay-notice', 'history',
			'liferay-util-window', 'aui-io-plugin-deprecated', function(Y) {
				// =================================================================================
				// Render Tabs
				// =============================================================
				var tabview = new Y.TabView({
					srcNode : srcNode
				}).render();
				if (sessionStorage.getItem('tab')) {
					tabview.selectChild(sessionStorage.getItem('tab') || 0);
				}

				tabview.after('selectionChange', function(e) {
					sessionStorage.setItem('tab', e.newVal.get('index') || 0);
				});
			});
}

	


$('select').chosen({
    no_results_text: "Извините, нет совпадений!",
    placeholder_text_single: "Выберите из списка...",
    width: '206px'
  });
$('.datapick').datepick({dateFormat: 'dd-mm-yyyy',
						 onClose: function(dates) {
							 $(this).focus();
							 $(this).datepick('performAction', 'close');
							 $(this).blur();
						 }	
						 });
						 

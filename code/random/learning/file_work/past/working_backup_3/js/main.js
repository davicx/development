$(document).ready(function(){
		$(".download-button").click(function(){

		var $button = $(this);		
		var user_id = $(this).attr('id');
		//alert(user_id);

		
		$.post('functions/function.php', { user_id: user_id }, 
		function(data) {		
			//alert(data);
		})	
	});
});

$(function() {
	//$( "#sortable1, #sortable2" ).sortable({connectWith: ".connectedSortable"}).disableSelection().on( "sort", function( event, ui ) {
	$( "#sortable1, #sortable2" ).sortable({connectWith: ".connectedSortable"}).disableSelection().on( "sortreceive", function( event, ui ) {	
		//	alert(ui.item.closest('ul').attr('id'));		
	});
});
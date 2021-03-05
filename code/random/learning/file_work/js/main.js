/* Function 1: Download File */
$(document).ready(function(){
	$(".download-button").click(function(){
		var $button = $(this);		
		var user_id = $(this).attr('id');
		$.post('functions/function.php', { user_id: user_id }, 
		function(data) {		
			//alert(data);
		})	
	});
});

/*Function 2: Process File Move*/
$(document).ready(function(){
	$("#sortable1, #sortable2").sortable({
		connectWith: ".connectedSortable",
	/*	placeholder: "highlight" */
		placeholder: {
			element: function(currentItem) {
				return $("<li><em>test</em></li>")[0];
			},
			update: function(container, p) {
				return;
			}
		}
	
	}).disableSelection().on( "sortreceive", function( event, ui ) {	
		
		
		//When clicking "li" which is each file, get the id of this file to update the database
		$("li").click(function(event) {
			
			currentID = event.target.id;
			$("#" + currentID).fadeOut(80);
			//alert(currentID);
		
			//Get ID of dropped location
			newFolder = (ui.item.closest('ul').attr('data'));
		
			$.post('functions/file_process.php', {file_id: currentID, new_folder: newFolder}, function(php_result) {
				//alert(php_result);
			
			});
		});	
	});

});



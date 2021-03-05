
$(document).ready(function(){
	$("button").click(function(){
		var button = $(this).attr('id'); 
		var splitParts;
		splitParts = button.split("_");
		var current_test_id = splitParts[1];
		//alert(current_post_id);
		
		$.post("index.php", {current_test_id: current_test_id}, function(php_result) {

			//$("div.current-file-name").html(php_result);
			//alert(php_result);
		});
		
	}); 
});


	
		
	/*
		var college = $( "#college_id" ).val();
		var contact = $( "#contact_id" ).val();
		var title = $( "#title_id" ).val();
		var date = $( "#datepicker_id" ).val();
		var purpose = $( "#purpose_id" ).val();
		
		$.post("function.php", {}, function(data)) {
			alert();
		}
		*/


/*
$(document).ready(function(){
	$(".connection-edit-form-area").hide();
	$("button.edit-button").click(function(){
		var button = $(this).attr('id');
		var splitParts;
		splitParts = button.split("_");
		var current_post_id = splitParts[1];
		var formID = "update_form_" + current_post_id;
		$("button#delete_" + current_post_id).hide();		
		$("button#edit_" + current_post_id).hide();
		$("#" + formID ).show();
	});
}); 


*/

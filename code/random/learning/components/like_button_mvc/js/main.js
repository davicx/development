//LIKE POST 
$(document).ready(function(){
	$("p.like").click(function(){
		var like_id = ($(this).attr("id"));
		var like_array = like_id.split('e_');
		var post_id = like_array[1];
		
		$.post('includes/function.php', {like_id: post_id}, function(like_output) {
	
			var currentLike = $('#' + like_id).text();
			var like = "Like";	
			var outcome = currentLike.localeCompare(like);
		
			if(outcome == 0) {
				$('#' + like_id).html("<strong>Unlike</strong>");
			} else {
				$('#' + like_id).html("<strong>Like</strong>");
			}

		});	
		
  });
});


//EDIT POSTS 
$(document).ready(function(){
	//Function 1: Edit a posts text 
	$("button").click(function(){
		//The variable post_id is just the primary key for each post	
		var $button 	= $(this);	
		var post_id 	= $(this).attr('id');
		var post_text 	= $("p#text_" + post_id).text();
			
		//Change Buttons: Hide edit button and show the save and cancel button
		$("button#" + post_id).hide();
		$("button#save_" + post_id).show();
		$("button#cancel_" + post_id).show();
		
		//Hide Text Field and display editable field
		$("p#text_" + post_id).hide();
		$("textarea#edit_text_" + post_id).show();
				
	});
	
	//Function 2: Save Button
	$("button.save-button").click(function(){
		//Get the post id to use for manipulating other elements 
		var $button 		= $(this);
		var save_button_id 	= $(this).attr('id');
	
		//Get the actual post id 
		var splitParts;
		splitParts = save_button_id.split("_");
		var current_post_id = splitParts[1];
		
		//Hide the Save and Cancel Button
		$("button#save_" + current_post_id).hide();	
		$("button#cancel_" + current_post_id).hide();	
	
		//Show the edit button and text field and hide the editable text area
		$("button#" + current_post_id).show();
		$("textarea#edit_text_" + current_post_id).hide();
		
		//Get edited text value and place back in the post 
		var new_post_text 	= $("textarea#edit_text_" + current_post_id).val();
		$("p#text_" + current_post_id).text(new_post_text);
		$("p#text_" + current_post_id).show();

		$.post('includes/function.php', {post_to_process: new_post_text, post_id_process: current_post_id }, function(php_result) {
			
		});
	});
	
	//Function 3: Cancel Button
	$("button.cancel-button").click(function(){
		var $button 			= $(this);
		var cancel_button_id 	= $(this).attr('id');
		var splitParts;
		splitParts = cancel_button_id.split("_");
		var current_post_id = splitParts[1];
		
		//Hide the Save Button
		$("button#save_" + current_post_id).hide();	
		
		//Show the edit button and text field and hide the editable text area
		$("button#" + current_post_id).show();
		$("textarea#edit_text_" + current_post_id).hide();
		$("p#text_" + current_post_id).show();
	});
	
});

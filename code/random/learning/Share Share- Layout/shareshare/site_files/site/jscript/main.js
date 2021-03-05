//Function 1: Like or unlike a post or comment
$(document).ready(function(){
	$("p.like").click(function(){
		var save_id = ($(this).attr("id"));
		var arr = save_id.split('e');
		var post_id = arr[1];
		
		$.post('insert_post.php', {like_id: post_id}, function(like_output) {
			//$('#' + post_id).text(like_output);
			var currentLike = $('#' + save_id).text();	
			//alert(currentLike);
			if(currentLike=="Like") {
				$('#' + save_id).text("Unlike");
			} else {
				$('#' + save_id).text("Like");
			}
		});	
  });
});

//Function 2: Edit a Post 
//Edit Button: This will open text box, cancel and save buttons
$(document).ready(function(){
  $("button.edit").click(function(){
	var $button = $(this);	
	//$(this).hide();

	//Creating dynamic id's to change document based on clicked id
	var user_id_int = ($(this).attr("id"));
	var userString = user_id_int.toString();
	var user_id = ("post" + userString);
	//IDS of elements
	var div_id = ("div" + userString); //edit button
	var save_id = ("save" + userString); //save button
	var cancel_id = ("cancel" + userString); //cancel button
	var text_id = ("text" + userString); //edit text box 
	var caption_id = ("caption-text" + userString); //posts

	$('#' + caption_id).toggleClass('view-post view-textbox'); 
	$('#' + div_id).toggleClass('view-post view-textbox');
	$('#' + user_id).hide(); 


	
	//This div reveals the save and cancel buttons and the text box 
	//This is an example so this toggles the p element to hidden or view $("p").toggleClass('view hide');

	$('#' + save_id).toggleClass('hide view');
	$('#' + cancel_id).toggleClass('hide view');
	$('#' + text_id).toggleClass('hide view');
	
	
  });
});


//Cancel Button: This will remove the text box and bring the quote back
$(document).ready(function(){
  $("button.cancel").click(function(){
	var $button = $(this);	
	var cancel_id = ($(this).attr("id"));
	var arr = cancel_id.split('l');
	var click_id = arr[1];
	div_id = ("div" + click_id);
	var save_id = ("save" + click_id); //save button
	var cancel_id = ("cancel" + click_id); //cancel button
	var text_id = ("text" + click_id); //edit text box 

	var caption_id = ("caption-text" + click_id); //posts

	$('#' + caption_id).toggleClass('view-textbox view-post'); 

	
	//Toggle save, cancel and text into view
	$('#' + save_id).toggleClass('view hide');
	$('#' + cancel_id).toggleClass('view hide');
	$('#' + text_id).toggleClass('view hide');


	$('#' + click_id).show();
	
  });
});

//Save Button: Save and execute Jquery
$(document).ready(function(){
	$("button.save").click(function(){	
		//variables to execute JQuery
		var $button = $(this);	
		var save_id = ($(this).attr("id"));
		var arr = save_id.split('e');
		var click_id = arr[1];
		var cancel_id = ("cancel" + click_id); 
		div_id = ("div" + click_id);

		var caption_id = ("caption-text" + click_id); //posts

		$('#' + caption_id).toggleClass('view-textbox view-post'); 

			
		
		text_id = ("text" + click_id);
		//Toggling visible components
		$('#' + save_id).toggleClass('view hide');
		$('#' + cancel_id).toggleClass('view hide');
		$('#' + text_id).toggleClass('view hide');	
		$('#' + div_id).toggleClass('view-textbox view-post');
		$('#' + click_id).show();
		
		//AJAX to udpate database
		var updatedMessage = $('#' + text_id).val(); 
		$.post('insert_post.php', {new_post: updatedMessage, post_id: click_id}, function(processedMessage) {
		$('#' + caption_id).text(processedMessage);	
		});	
  });
});

//Function 3: Submit new post to Database
$(document).ready(function(){
	$("button#new-post").click(function(){
		var new_post = $('#new-post-text').val();	

		$.post('new_post.inc.php', {new_wall_post: new_post}, function(inserted_post) {
			//need to construct a new jquery post
			//$('#wall-post-output').html(inserted-post);
		});
		$('#new-post-text').val('');	
  });
});

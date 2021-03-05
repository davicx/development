$(document).ready(function(){
	//Function 1: Edit a posts text 
	$("button").click(function(){
		var $button 	= $(this);
		//The variable post_id is just the primary key for each post		
		var post_id 	= $(this).attr('id');
		//This creates the name of the object that contains the post that was clicked, this will be passed to the php to edit the object
		//var post_object_name = "post_" + post_id;
		
		//Each individual field that must be accessed will be done through a unique id added to a word that describes that field. 
		var post_text 	= $("p#text_" + post_id).text()
		
		
		$.post('includes/function.php', {post_to_process: post_text, post_id_process: post_id }, function(php_result) {
			//This is what to do with the outcome of the text
			alert(php_result);

			//$('#name_feedback').html(php_result);
		});
	});
});

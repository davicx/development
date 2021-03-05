$(document).ready(function(){
	$("button").click(function(){
	//Need to make the class match what ever person is getting clicked on
		//Works
		//var user_id = $('#user_id').val();
		//$.post(php script, value to send (value passed, value from js), call back function or fuction(data) data is coming back from php  )
		//$("#parent").on("click", ".item-to-be-clicked", function () {
		var $button = $(this);
		
		var user_id = $(this).attr('id');
		$.post('function.inc.php', { name: user_id }, 
		
		function(data) {
			$('#name_feedback').html(data);
			var button_words = $button.html();

			if (button_words=="Unfriend"){
				//alert(user_id);
				$button.text("Be Friends!");	
			//	alert(button_words);
			} else {
			//	alert(button_words);
				$button.text("Unfriend");	
			}

		})		
	});
});

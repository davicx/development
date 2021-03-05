$(document).ready(function(){
		$("button").click(function(){
		var $button = $(this);
		
		var user_id = $(this).attr('id');
		$.post('function.php', { name: user_id }, 
		
		function(data) {
			$('#name_feedback').html(data);
			var button_words = $button.html();

			if (button_words=="Unfriend"){
				$button.text("Be Friends!");	
			} else {
				$button.text("Unfriend");	
			}

		})		

	});
});

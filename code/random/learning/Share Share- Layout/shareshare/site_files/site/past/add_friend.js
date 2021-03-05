$(document).ready(function(){
	$("friends").click(function(){
		var $button = $(this);
		alert("Hi");
		var user_id = $(this).attr('id');
		//alert(user_id);
		$.post('function.php', { name: user_id }, 
		
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


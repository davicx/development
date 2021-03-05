//Function 5: Add a new Square and send Invite
$(document).ready(function(){
		$("button").click(function(){
		var $button = $(this);
		
		var user_id = $(this).attr('id');
		//alert(user_id);
	
		$.post('../functions/add_square.php', { invited: user_id }, 
		
		function(data) {
			alert(data);
		})		

	});
});
